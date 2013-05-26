//#if CLEANER
package com.sleepycat.je.cleaner;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.CleanerFileReader;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.SearchResult;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeLocation;
import com.sleepycat.je.tree.WithRootLatched;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.utilint.DaemonThread;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.Tracer;
/** 
 * Reads all entries in a log file and either determines them to be obsolete or
 * marks them for migration. LNs are marked for migration by setting the BIN
 * entry MIGRATE flag. INs are marked for migration by setting the dirty flag.
 * May be invoked explicitly by calling doClean, or woken up if used as a daemon
 * thread.
 */
class FileProcessor extends DaemonThread {
  /** 
 * The number of LN log entries after we process pending LNs. If we do this
 * too seldom, the pending LN queue may grow large, and it isn't budgeted
 * memory. If we process it too often, we will repeatedly request a
 * non-blocking lock for the same locked node.
 */
  private static final int PROCESS_PENDING_EVERY_N_LNS=100;
  /** 
 * Whether to prohibit BINDeltas for a BIN that is fetched by the cleaner.
 * The theory is that when fetching a BIN during cleaning we normally expect
 * that the BIN will be evicted soon, and a delta during checkpoint would be
 * wasted. However, this does not take into account use of the BIN by the
 * application after fetching; the BIN could become hot and then deltas may
 * be profitable. To be safe we currently allow deltas when fetching.
 */
  private static final boolean PROHIBIT_DELTAS_WHEN_FETCHING=false;
  private static final boolean DEBUG_TRACING=false;
  private EnvironmentImpl env;
  private Cleaner cleaner;
  private FileSelector fileSelector;
  private UtilizationProfile profile;
//#if STATISTICS
  private int nINsObsoleteThisRun=0;
//#endif
//#if STATISTICS
  private int nINsCleanedThisRun=0;
//#endif
//#if STATISTICS
  private int nINsDeadThisRun=0;
//#endif
//#if STATISTICS
  private int nINsMigratedThisRun=0;
//#endif
//#if STATISTICS
  private int nLNsObsoleteThisRun=0;
//#endif
//#if STATISTICS
  private int nLNsCleanedThisRun=0;
//#endif
//#if STATISTICS
  private int nLNsDeadThisRun=0;
//#endif
//#if STATISTICS
  private int nLNsLockedThisRun=0;
//#endif
//#if STATISTICS
  private int nLNsMigratedThisRun=0;
//#endif
//#if STATISTICS
  private int nLNsMarkedThisRun=0;
//#endif
//#if STATISTICS
  private int nLNQueueHitsThisRun=0;
//#endif
//#if STATISTICS
  private int nEntriesReadThisRun;
//#endif
//#if STATISTICS
  private long nRepeatIteratorReadsThisRun;
//#endif
  FileProcessor(  String name,  EnvironmentImpl env,  Cleaner cleaner,  UtilizationProfile profile,  FileSelector fileSelector){
    super(0,name,env);
    this.env=env;
    this.cleaner=cleaner;
    this.fileSelector=fileSelector;
    this.profile=profile;
  }
  public void clearEnv(){
    env=null;
    cleaner=null;
    fileSelector=null;
    profile=null;
  }
  /** 
 * Return the number of retries when a deadlock exception occurs.
 */
  protected int nDeadlockRetries() throws DatabaseException {
    return cleaner.nDeadlockRetries;
  }
  /** 
 * Cleaner doesn't have a work queue so just throw an exception if it's ever
 * called.
 */
  public void addToQueue(  Object o) throws DatabaseException {
    throw new DatabaseException("Cleaner.addToQueue should never be called.");
  }
  /** 
 * Activates the cleaner. Is normally called when je.cleaner.byteInterval
 * bytes are written to the log.
 */
  public void onWakeup() throws DatabaseException {
    doClean(true,true,false);
  }
  /** 
 * Cleans selected files and returns the number of files cleaned. May be
 * called by the daemon thread or programatically.
 * @param invokedFromDaemoncurrently has no effect.
 * @param cleanMultipleFilesis true to clean until we're under budget, or false to clean
 * at most one file.
 * @param forceCleaningis true to clean even if we're not under the utilization
 * threshold.
 * @return the number of files cleaned, not including files cleaned
 * unsuccessfully.
 */
  public synchronized int doClean(  boolean invokedFromDaemon,  boolean cleanMultipleFiles,  boolean forceCleaning) throws DatabaseException {
    if (env.isClosed()) {
      return 0;
    }
    int nOriginalLogFiles=profile.getNumberOfFiles();
    int nFilesCleaned=0;
    while (true) {
      if (nFilesCleaned >= nOriginalLogFiles) {
        break;
      }
      if (env.isClosing()) {
        break;
      }
      cleaner.processPending();
      cleaner.deleteSafeToDeleteFiles();
      boolean needLowUtilizationSet=cleaner.clusterResident || cleaner.clusterAll;
      Long fileNum=fileSelector.selectFileForCleaning(profile,forceCleaning,needLowUtilizationSet,cleaner.maxBatchFiles);
      cleaner.updateReadOnlyFileCollections();
      if (fileNum == null) {
        break;
      }
//#if STATISTICS
      resetPerRunCounters();
//#endif
      boolean finished=false;
      long fileNumValue=fileNum.longValue();
      int runId=++cleaner.nCleanerRuns;
      try {
        String traceMsg="CleanerRun " + runId + " on file 0x"+ Long.toHexString(fileNumValue)+ 
//#if STATISTICS
" begins backlog="
//#endif
+ 
//#if STATISTICS
cleaner.nBacklogFiles
//#endif
;
//#if LOGGINGINFO
        Tracer.trace(Level.INFO,env,traceMsg);
//#endif
        if (DEBUG_TRACING) {
          System.out.println("\n" + traceMsg);
        }
        if (processFile(fileNum)) {
          fileSelector.addCleanedFile(fileNum);
          nFilesCleaned+=1;
//#if STATISTICS
          accumulatePerRunCounters();
//#endif
          finished=true;
        }
      }
 catch (      IOException IOE) {
//#if LOGGINGSEVERE
        Tracer.trace(env,"Cleaner","doClean","",IOE);
//#endif
        throw new DatabaseException(IOE);
      }
 finally {
        if (!finished) {
          fileSelector.putBackFileForCleaning(fileNum);
        }
        String traceMsg="CleanerRun " + runId + " on file 0x"+ Long.toHexString(fileNumValue)+ " invokedFromDaemon="+ invokedFromDaemon+ " finished="+ finished+ 
//#if STATISTICS
" nEntriesRead="
//#endif
+ 
//#if STATISTICS
nEntriesReadThisRun
//#endif
+ 
//#if STATISTICS
" nINsObsolete="
//#endif
+ 
//#if STATISTICS
nINsObsoleteThisRun
//#endif
+ 
//#if STATISTICS
" nINsCleaned="
//#endif
+ 
//#if STATISTICS
nINsCleanedThisRun
//#endif
+ 
//#if STATISTICS
" nINsDead="
//#endif
+ 
//#if STATISTICS
nINsDeadThisRun
//#endif
+ 
//#if STATISTICS
" nINsMigrated="
//#endif
+ 
//#if STATISTICS
nINsMigratedThisRun
//#endif
+ 
//#if STATISTICS
" nLNsObsolete="
//#endif
+ 
//#if STATISTICS
nLNsObsoleteThisRun
//#endif
+ 
//#if STATISTICS
" nLNsCleaned="
//#endif
+ 
//#if STATISTICS
nLNsCleanedThisRun
//#endif
+ 
//#if STATISTICS
" nLNsDead="
//#endif
+ 
//#if STATISTICS
nLNsDeadThisRun
//#endif
+ 
//#if STATISTICS
" nLNsMigrated="
//#endif
+ 
//#if STATISTICS
nLNsMigratedThisRun
//#endif
+ 
//#if STATISTICS
" nLNsMarked="
//#endif
+ 
//#if STATISTICS
nLNsMarkedThisRun
//#endif
+ 
//#if STATISTICS
" nLNQueueHits="
//#endif
+ 
//#if STATISTICS
nLNQueueHitsThisRun
//#endif
+ 
//#if STATISTICS
" nLNsLocked="
//#endif
+ 
//#if STATISTICS
nLNsLockedThisRun
//#endif
;
//#if LOGGINGSEVERE
        Tracer.trace(Level.SEVERE,env,traceMsg);
//#endif
        if (DEBUG_TRACING) {
          System.out.println("\n" + traceMsg);
        }
      }
      if (!cleanMultipleFiles) {
        break;
      }
    }
    return nFilesCleaned;
  }
  /** 
 * Process all log entries in the given file.
 * Note that we check for obsolete entries using the active TFS
 * (TrackedFileSummary) for a file while it is being processed, and we
 * prohibit flushing (eviction) of that offset information until file
 * processing is complete. An entry could become obsolete because: 1- normal
 * application activity deletes or updates the entry, 2- proactive migration
 * migrates the entry before we process it, or 3- if trackDetail is false.
 * However, checking the TFS is expensive if it has many entries, because we
 * perform a linear search. There is a tradeoff between the cost of the TFS
 * lookup and its benefit, which is to avoid a tree search if the entry is
 * obsolete. Note that many more lookups for non-obsolete entries than
 * obsolete entries will typically be done. In spite of that we check the
 * tracked summary to avoid the situation where eviction does proactive
 * migration, and evicts a BIN that is very soon afterward fetched during
 * cleaning.
 * @return false if we aborted file processing because the environment is
 * being closed.
 */
  private boolean processFile(  Long fileNum) throws DatabaseException, IOException {
    PackedOffsets obsoleteOffsets=new PackedOffsets();
    TrackedFileSummary tfs=profile.getObsoleteDetail(fileNum,obsoleteOffsets,true);
    PackedOffsets.Iterator obsoleteIter=obsoleteOffsets.iterator();
    long nextObsolete=-1;
    final int readBufferSize=cleaner.readBufferSize;
//#if LOOKAHEADCACHE
    int lookAheadCacheSize=cleaner.lookAheadCacheSize;
//#endif
//#if MEMORYBUDGET
    int adjustMem=(2 * readBufferSize) + obsoleteOffsets.getLogSize() + 
//#if LOOKAHEADCACHE
lookAheadCacheSize
//#endif
;
//#endif
//#if MEMORYBUDGET
    MemoryBudget budget=env.getMemoryBudget();
//#endif
//#if MEMORYBUDGET
    budget.updateMiscMemoryUsage(adjustMem);
//#endif
//#if CRITICALEVICTION
//#if EVICTOR
    if (Cleaner.DO_CRITICAL_EVICTION) 
//#if CRITICALEVICTION
//#if EVICTOR
{
      env.getEvictor().doCriticalEviction();
    }
//#endif
//#endif
//#endif
//#endif
//#if LOOKAHEADCACHE
    LookAheadCache lookAheadCache=new LookAheadCache(lookAheadCacheSize);
//#endif
//#if DELETEOP
    Set checkPendingDbSet=new HashSet();
//#endif
    Map dbCache=new HashMap();
    try {
      CleanerFileReader reader=new CleanerFileReader(env,readBufferSize,DbLsn.NULL_LSN,fileNum);
//#if CHECKSUM
      reader.setAlwaysValidateChecksum(true);
//#endif
      DbTree dbMapTree=env.getDbMapTree();
      TreeLocation location=new TreeLocation();
      int nProcessedLNs=0;
      while (reader.readNextEntry()) {
//#if STATISTICS
        cleaner.nEntriesRead+=1;
//#endif
        long lsn=reader.getLastLsn();
        long fileOffset=DbLsn.getFileOffset(lsn);
        boolean isLN=reader.isLN();
        boolean isIN=reader.isIN();
        boolean isRoot=reader.isRoot();
        boolean isObsolete=false;
        if (env.isClosing()) {
          return false;
        }
        while (nextObsolete < fileOffset && obsoleteIter.hasNext()) {
          nextObsolete=obsoleteIter.next();
        }
        if (nextObsolete == fileOffset) {
          isObsolete=true;
        }
        if (!isObsolete && !isLN && !isIN&& !isRoot) {
          isObsolete=true;
        }
        if (!isObsolete && isLN && reader.getLN().isDeleted()) {
          isObsolete=true;
        }
        if (!isObsolete && tfs != null && tfs.containsObsoleteOffset(fileOffset)) {
          isObsolete=true;
        }
        if (isObsolete) {
//#if STATISTICS
          if (isLN) 
//#if STATISTICS
{
            nLNsObsoleteThisRun++;
          }
//#endif
 else 
//#if STATISTICS
          if (isIN) 
//#if STATISTICS
{
            nINsObsoleteThisRun++;
          }
//#endif
//#endif
//#endif
//#if DELETEOP
          DatabaseId dbId=reader.getDatabaseId();
//#endif
//#if DELETEOP
          if (dbId != null) 
//#if DELETEOP
{
            checkPendingDbSet.add(dbId);
          }
//#endif
//#endif
          continue;
        }
//#if CRITICALEVICTION
//#if EVICTOR
        if (Cleaner.DO_CRITICAL_EVICTION) 
//#if CRITICALEVICTION
//#if EVICTOR
{
          env.getEvictor().doCriticalEviction();
        }
//#endif
//#endif
//#endif
//#endif
        if (isLN) {
          LN targetLN=reader.getLN();
          DatabaseId dbId=reader.getDatabaseId();
          byte[] key=reader.getKey();
          byte[] dupKey=reader.getDupTreeKey();
          Long aLsn=new Long(DbLsn.getFileOffset(lsn));
          LNInfo aLninfo=new LNInfo(targetLN,dbId,key,dupKey);
//#if LOOKAHEADCACHE
          lookAheadCache.add(aLsn,aLninfo);
//#endif
//#if LOOKAHEADCACHE
          if (lookAheadCache.isFull()) {
            processLN(fileNum,location,aLsn,aLninfo,
//#if LOOKAHEADCACHE
lookAheadCache
//#endif
,dbCache);
          }
//#endif
          nProcessedLNs+=1;
          if (nProcessedLNs % PROCESS_PENDING_EVERY_N_LNS == 0) {
            cleaner.processPending();
          }
        }
 else         if (isIN) {
          IN targetIN=reader.getIN();
          DatabaseId dbId=reader.getDatabaseId();
          DatabaseImpl db=dbMapTree.getDb(dbId,cleaner.lockTimeout,dbCache);
          targetIN.setDatabase(db);
          processIN(targetIN,db,lsn);
        }
 else         if (isRoot) {
          env.rewriteMapTreeRoot(lsn);
        }
 else {
          assert false;
        }
      }
//#if LOOKAHEADCACHE
      while (!lookAheadCache.isEmpty()) 
//#if LOOKAHEADCACHE
{
//#if CRITICALEVICTION
//#if EVICTOR
        if (Cleaner.DO_CRITICAL_EVICTION) 
//#if CRITICALEVICTION
//#if EVICTOR
{
          env.getEvictor().doCriticalEviction();
        }
//#endif
//#endif
//#endif
//#endif
        processLN(fileNum,location,null,null,lookAheadCache,dbCache);
      }
//#endif
//#endif
//#if DELETEOP
      for (Iterator i=checkPendingDbSet.iterator(); i.hasNext(); ) 
//#if DELETEOP
{
        DatabaseId dbId=(DatabaseId)i.next();
        DatabaseImpl db=dbMapTree.getDb(dbId,cleaner.lockTimeout,dbCache);
        cleaner.addPendingDB(db);
      }
//#endif
//#endif
//#if STATISTICS
      nEntriesReadThisRun=reader.getNumRead();
//#endif
//#if STATISTICS
      nRepeatIteratorReadsThisRun=reader.getNRepeatIteratorReads();
//#endif
    }
  finally {
//#if MEMORYBUDGET
      budget.updateMiscMemoryUsage(0 - adjustMem);
//#endif
      if (tfs != null) {
        tfs.setAllowFlush(true);
      }
    }
    return true;
  }
  /** 
 * Processes the first LN in the look ahead cache and removes it from the
 * cache. While the BIN is latched, look through the BIN for other LNs in
 * the cache; if any match, process them to avoid a tree search later.
 * @param info
 * @param offset
 */
  private void processLN(  Long fileNum,  TreeLocation location,  Long offset,  LNInfo info,
//#if LOOKAHEADCACHE
  LookAheadCache lookAheadCache
//#endif
,  Map dbCache) throws DatabaseException {
//#if STATISTICS
    nLNsCleanedThisRun++;
//#endif
//#if LOOKAHEADCACHE
    offset=lookAheadCache.nextOffset();
//#endif
//#if LOOKAHEADCACHE
    info=lookAheadCache.remove(offset);
//#endif
    LN ln=info.getLN();
    byte[] key=info.getKey();
    byte[] dupKey=info.getDupKey();
    long logLsn=DbLsn.makeLsn(fileNum.longValue(),offset.longValue());
    DatabaseImpl db=env.getDbMapTree().getDb(info.getDbId(),cleaner.lockTimeout,dbCache);
    boolean processedHere=true;
    boolean obsolete=false;
    boolean completed=false;
    BIN bin=null;
    DIN parentDIN=null;
    try {
      if (db == null || 
//#if DELETEOP
db.isDeleted()
//#endif
) {
//#if DELETEOP
        cleaner.addPendingDB(db);
//#endif
//#if STATISTICS
        nLNsDeadThisRun++;
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      Tree tree=db.getTree();
      assert tree != null;
      boolean parentFound=tree.getParentBINForChildLN(location,key,dupKey,ln,false,true,false,Cleaner.UPDATE_GENERATION);
      bin=location.bin;
      int index=location.index;
      if (!parentFound) {
//#if STATISTICS
        nLNsDeadThisRun++;
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      if (bin.isEntryKnownDeleted(index)) {
//#if STATISTICS
        nLNsDeadThisRun++;
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      boolean isDupCountLN=ln.containsDuplicates();
      long treeLsn;
      if (isDupCountLN) {
        parentDIN=(DIN)bin.fetchTarget(index);
        parentDIN.latch(Cleaner.UPDATE_GENERATION);
        ChildReference dclRef=parentDIN.getDupCountLNRef();
        treeLsn=dclRef.getLsn();
      }
 else {
        treeLsn=bin.getLsn(index);
      }
      processedHere=false;
      processFoundLN(info,logLsn,treeLsn,bin,index,parentDIN);
      completed=true;
//#if LOOKAHEADCACHE
      if (!isDupCountLN) 
//#if LOOKAHEADCACHE
{
        for (int i=0; i < bin.getNEntries(); i+=1) {
          long lsn=bin.getLsn(i);
          if (i != index && !bin.isEntryKnownDeleted(i) && !bin.isEntryPendingDeleted(i) && DbLsn.getFileNumber(lsn) == fileNum.longValue()) {
            Long myOffset=new Long(DbLsn.getFileOffset(lsn));
            LNInfo myInfo=lookAheadCache.remove(myOffset);
            if (myInfo != null) {
//#if STATISTICS
              nLNQueueHitsThisRun++;
//#endif
//#if STATISTICS
              nLNsCleanedThisRun++;
//#endif
              processFoundLN(myInfo,lsn,lsn,bin,i,null);
            }
          }
        }
      }
//#endif
//#endif
      return;
    }
  finally {
//#if LATCHES
      if (parentDIN != null) 
//#if LATCHES
{
        parentDIN.releaseLatchIfOwner();
      }
//#endif
//#endif
//#if LATCHES
      if (bin != null) 
//#if LATCHES
{
        bin.releaseLatchIfOwner();
      }
//#endif
//#endif
//#if LOGGINGCLEANER
      if (processedHere) 
//#if LOGGINGCLEANER
{
        cleaner.trace(cleaner.detailedTraceLevel,Cleaner.CLEAN_LN,ln,logLsn,completed,obsolete,false);
      }
//#endif
//#endif
    }
  }
  /** 
 * Processes an LN that was found in the tree. Lock the LN's node ID and
 * then set the entry's MIGRATE flag if the LSN of the LN log entry is the
 * active LSN in the tree.
 * @param infoidentifies the LN log entry.
 * @param logLsnis the LSN of the log entry.
 * @param treeLsnis the LSN found in the tree.
 * @param binis the BIN found in the tree; is latched on method entry and
 * exit.
 * @param indexis the BIN index found in the tree.
 * @param parentDINis non-null for a DupCountLN only; if non-null, is latched on
 * method entry and exit.
 */
  private void processFoundLN(  LNInfo info,  long logLsn,  long treeLsn,  BIN bin,  int index,  DIN parentDIN) throws DatabaseException {
    LN ln=info.getLN();
    byte[] key=info.getKey();
    byte[] dupKey=info.getDupKey();
    DatabaseImpl db=bin.getDatabase();
    boolean isDupCountLN=parentDIN != null;
    boolean obsolete=false;
    boolean migrated=false;
    boolean lockDenied=false;
    boolean completed=false;
    long nodeId=ln.getNodeId();
    BasicLocker locker=null;
    try {
      Tree tree=db.getTree();
      assert tree != null;
      if (treeLsn != logLsn) {
        locker=new BasicLocker(env);
        LockResult lockRet=locker.nonBlockingLock(nodeId,LockType.READ,db);
        if (lockRet.getLockGrant() == LockGrantType.DENIED) {
//#if STATISTICS
          nLNsLockedThisRun++;
//#endif
          lockDenied=true;
        }
 else {
//#if STATISTICS
          nLNsDeadThisRun++;
//#endif
          obsolete=true;
        }
      }
      if (!obsolete && !lockDenied) {
        if (isDupCountLN) {
          ChildReference dclRef=parentDIN.getDupCountLNRef();
          dclRef.setMigrate(true);
          parentDIN.setDirty(true);
          if (treeLsn == logLsn && dclRef.getTarget() == null) {
            ln.postFetchInit(db,logLsn);
            parentDIN.updateDupCountLN(ln);
          }
        }
 else {
          bin.setMigrate(index,true);
          bin.setDirty(true);
          if (treeLsn == logLsn && bin.getTarget(index) == null) {
            ln.postFetchInit(db,logLsn);
            bin.updateEntry(index,ln);
          }
          if (PROHIBIT_DELTAS_WHEN_FETCHING && bin.getGeneration() == 0) {
            bin.setProhibitNextDelta();
          }
          bin.setGeneration();
        }
//#if STATISTICS
        nLNsMarkedThisRun++;
//#endif
        migrated=true;
      }
      completed=true;
    }
  finally {
      if (locker != null) {
        locker.operationEnd();
      }
      if (completed && lockDenied) {
        fileSelector.addPendingLN(ln,db.getId(),key,dupKey);
      }
//#if LOGGINGCLEANER
      cleaner.trace(cleaner.detailedTraceLevel,Cleaner.CLEAN_LN,ln,logLsn,completed,obsolete,migrated);
//#endif
    }
  }
  /** 
 * If an IN is still in use in the in-memory tree, dirty it. The checkpoint
 * invoked at the end of the cleaning run will end up rewriting it.
 */
  private void processIN(  IN inClone,  DatabaseImpl db,  long lsn) throws DatabaseException {
    boolean obsolete=false;
    boolean dirtied=false;
    boolean completed=false;
//#if LOGGINGCLEANER
    try {
//#if STATISTICS
      nINsCleanedThisRun++;
//#endif
      if (db == null || 
//#if DELETEOP
db.isDeleted()
//#endif
) {
//#if DELETEOP
        cleaner.addPendingDB(db);
//#endif
//#if STATISTICS
        nINsDeadThisRun++;
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      Tree tree=db.getTree();
      assert tree != null;
      IN inInTree=findINInTree(tree,db,inClone,lsn);
      if (inInTree == null) {
//#if STATISTICS
        nINsDeadThisRun++;
//#endif
        obsolete=true;
      }
 else {
//#if STATISTICS
        nINsMigratedThisRun++;
//#endif
        inInTree.setDirty(true);
        inInTree.setProhibitNextDelta();
//#if LATCHES
        inInTree.releaseLatch();
//#endif
        dirtied=true;
      }
      completed=true;
    }
  finally {
      cleaner.trace(cleaner.detailedTraceLevel,Cleaner.CLEAN_IN,inClone,lsn,completed,obsolete,dirtied);
    }
//#endif
  }
  /** 
 * Given a clone of an IN that has been taken out of the log, try to find it
 * in the tree and verify that it is the current one in the log. Returns the
 * node in the tree if it is found and it is current re: LSN's. Otherwise
 * returns null if the clone is not found in the tree or it's not the latest
 * version. Caller is responsible for unlatching the returned IN.
 */
  private IN findINInTree(  Tree tree,  DatabaseImpl db,  IN inClone,  long lsn) throws DatabaseException {
    if (inClone.isDbRoot()) {
      IN rootIN=isRoot(tree,db,inClone,lsn);
      if (rootIN == null) {
        return null;
      }
 else {
        return rootIN;
      }
    }
    inClone.latch(Cleaner.UPDATE_GENERATION);
    SearchResult result=null;
//#if LATCHES
    try {
      result=tree.getParentINForChildIN(inClone,true,Cleaner.UPDATE_GENERATION,inClone.getLevel(),null);
      if (!result.exactParentFound) {
        return null;
      }
      int compareVal=DbLsn.compareTo(result.parent.getLsn(result.index),lsn);
      if (compareVal > 0) {
        return null;
      }
 else {
        IN in;
        if (compareVal == 0) {
          in=(IN)result.parent.getTarget(result.index);
          if (in == null) {
            in=inClone;
            in.postFetchInit(db,lsn);
            result.parent.updateEntry(result.index,in);
          }
        }
 else {
          in=(IN)result.parent.fetchTarget(result.index);
        }
        in.latch(Cleaner.UPDATE_GENERATION);
        return in;
      }
    }
  finally {
      if ((result != null) && (result.exactParentFound)) {
        result.parent.releaseLatch();
      }
    }
//#endif
  }
private static class RootDoWork implements WithRootLatched {
    private DatabaseImpl db;
    private IN inClone;
    private long lsn;
    RootDoWork(    DatabaseImpl db,    IN inClone,    long lsn){
      this.db=db;
      this.inClone=inClone;
      this.lsn=lsn;
    }
    public IN doWork(    ChildReference root) throws DatabaseException {
      if (root == null || root.fetchTarget(db,null).getNodeId() != inClone.getNodeId()) {
        return null;
      }
      if (DbLsn.compareTo(root.getLsn(),lsn) <= 0) {
        IN rootIN=(IN)root.fetchTarget(db,null);
        rootIN.latch(Cleaner.UPDATE_GENERATION);
        return rootIN;
      }
 else {
        return null;
      }
    }
  }
  /** 
 * Check if the cloned IN is the same node as the root in tree. Return the
 * real root if it is, null otherwise. If non-null is returned, the returned
 * IN (the root) is latched -- caller is responsible for unlatching it.
 */
  private IN isRoot(  Tree tree,  DatabaseImpl db,  IN inClone,  long lsn) throws DatabaseException {
    RootDoWork rdw=new RootDoWork(db,inClone,lsn);
    return tree.withRootLatchedShared(rdw);
  }
//#if STATISTICS
  /** 
 * Reset per-run counters.
 */
  private void resetPerRunCounters(){
    nINsObsoleteThisRun=0;
    nINsCleanedThisRun=0;
    nINsDeadThisRun=0;
    nINsMigratedThisRun=0;
    nLNsObsoleteThisRun=0;
    nLNsCleanedThisRun=0;
    nLNsDeadThisRun=0;
    nLNsMigratedThisRun=0;
    nLNsMarkedThisRun=0;
    nLNQueueHitsThisRun=0;
    nLNsLockedThisRun=0;
    nEntriesReadThisRun=0;
    nRepeatIteratorReadsThisRun=0;
  }
//#endif
//#if STATISTICS
  /** 
 * Add per-run counters to total counters.
 */
  private void accumulatePerRunCounters(){
    cleaner.nINsObsolete+=nINsObsoleteThisRun;
    cleaner.nINsCleaned+=nINsCleanedThisRun;
    cleaner.nINsDead+=nINsDeadThisRun;
    cleaner.nINsMigrated+=nINsMigratedThisRun;
    cleaner.nLNsObsolete+=nLNsObsoleteThisRun;
    cleaner.nLNsCleaned+=nLNsCleanedThisRun;
    cleaner.nLNsDead+=nLNsDeadThisRun;
    cleaner.nLNsMigrated+=nLNsMigratedThisRun;
    cleaner.nLNsMarked+=nLNsMarkedThisRun;
    cleaner.nLNQueueHits+=nLNQueueHitsThisRun;
    cleaner.nLNsLocked+=nLNsLockedThisRun;
    cleaner.nRepeatIteratorReads+=nRepeatIteratorReadsThisRun;
  }
//#endif
  /** 
 * XXX: Was this intended to override Thread.toString()? If so it no longer
 * does, because we separated Thread from DaemonThread.
 */
  public String toString(){
    StringBuffer sb=new StringBuffer();
    sb.append("<Cleaner name=\"").append(name).append("\"/>");
    return sb.toString();
  }
//#if LOOKAHEADCACHE
  /** 
 * A cache of LNInfo by LSN offset. Used to hold a set of LNs that are to be
 * processed. Keeps track of memory used, and when full (over budget) the
 * next offset should be queried and removed.
 */
private static class LookAheadCache {
    private SortedMap map;
    private int maxMem;
    private int usedMem;
    LookAheadCache(    int lookAheadCacheSize){
      map=new TreeMap();
      maxMem=lookAheadCacheSize;
//#if MEMORYBUDGET
      usedMem=MemoryBudget.TREEMAP_OVERHEAD;
//#endif
    }
    boolean isEmpty(){
      return map.isEmpty();
    }
    boolean isFull(){
      return usedMem >= maxMem;
    }
    Long nextOffset(){
      return (Long)map.firstKey();
    }
    void add(    Long lsnOffset,    LNInfo info){
      map.put(lsnOffset,info);
      usedMem++;
//#if MEMORYBUDGET
      usedMem+=info.getMemorySize();
//#endif
//#if MEMORYBUDGET
      usedMem+=MemoryBudget.TREEMAP_ENTRY_OVERHEAD - 1;
//#endif
    }
    LNInfo remove(    Long offset){
      LNInfo info=(LNInfo)map.remove(offset);
      if (info != null) {
//#if MEMORYBUDGET
        usedMem--;
//#endif
//#if MEMORYBUDGET
        usedMem-=info.getMemorySize();
//#endif
//#if MEMORYBUDGET
        usedMem-=MemoryBudget.TREEMAP_ENTRY_OVERHEAD + 1;
//#endif
      }
      return info;
    }
  }
//#endif
}
//#endif
