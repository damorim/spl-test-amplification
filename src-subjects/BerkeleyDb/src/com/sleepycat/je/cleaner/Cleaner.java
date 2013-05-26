//#if CLEANER
package com.sleepycat.je.cleaner;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvConfigObserver;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeLocation;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.utilint.DaemonRunner;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.PropUtil;
import com.sleepycat.je.utilint.Tracer;
/** 
 * The Cleaner is responsible for effectively garbage collecting the JE log.
 * It looks through log files and locates log records (IN's and LN's of all
 * flavors) that are superceded by later versions.  Those that are "current"
 * are propagated to a newer log file so that older log files can be deleted.
 */
public class Cleaner implements 
//#if CLEANERDAEMON
DaemonRunner
//#endif
, EnvConfigObserver {
  static final String CLEAN_IN="CleanIN:";
  static final String CLEAN_LN="CleanLN:";
  static final String CLEAN_MIGRATE_LN="CleanMigrateLN:";
  static final String CLEAN_PENDING_LN="CleanPendingLN:";
  /** 
 * Whether to fetch LNs for files in the to-be-cleaned set during lazy
 * migration.  This is currently enabled because we do not support the
 * dynamic addition of cleaner threads; that way, if the configured cleaner
 * threads cannot keep up, we use proactive migration to keep up.
 */
  static final boolean PROACTIVE_MIGRATION=true;
  /** 
 * Whether to update the IN generation count during searches.  This is
 * currently disabled because 1) we update the generation of the BIN when
 * we set a MIGRATE flag and 2) if the BIN is not evicted its parents will
 * not be, so not updating the generation during the search has no benefit.
 * By not updating the generation during searches for which we do NOT set
 * the MIGRATE flag, we avoid holding INs in the cache that are not needed
 * for lazy migration.  However, we do very few searches for obsolete LNs
 * because the obsolete tracking info prevents this, so the benefit of not
 * updating the generation during searches is questionable.  In other
 * words, changing this setting will have little effect.
 */
  static final boolean UPDATE_GENERATION=false;
//#if CRITICALEVICTION
  /** 
 * Whether the cleaner should participate in critical eviction.  Ideally
 * the cleaner would not participate in eviction, since that would reduce
 * the cost of cleaning.  However, the cleaner can add large numbers of
 * nodes to the cache.  By not participating in eviction, other threads
 * could be kept in a constant state of eviction and would effectively
 * starve.  Therefore, this setting is currently enabled.
 */
  static final boolean DO_CRITICAL_EVICTION=true;
//#endif
//#if STATISTICS
  int nBacklogFiles=0;
//#endif
  int nCleanerRuns=0;
//#if STATISTICS
  int nCleanerDeletions=0;
//#endif
//#if STATISTICS
  int nINsObsolete=0;
//#endif
//#if STATISTICS
  int nINsCleaned=0;
//#endif
//#if STATISTICS
  int nINsDead=0;
//#endif
//#if STATISTICS
  int nINsMigrated=0;
//#endif
//#if STATISTICS
  int nLNsObsolete=0;
//#endif
//#if STATISTICS
  int nLNsCleaned=0;
//#endif
//#if STATISTICS
  int nLNsDead=0;
//#endif
//#if STATISTICS
  int nLNsLocked=0;
//#endif
//#if STATISTICS
  int nLNsMigrated=0;
//#endif
//#if STATISTICS
  int nLNsMarked=0;
//#endif
//#if STATISTICS
  int nLNQueueHits=0;
//#endif
//#if STATISTICS
  int nPendingLNsProcessed=0;
//#endif
//#if STATISTICS
  int nMarkedLNsProcessed=0;
//#endif
//#if STATISTICS
  int nToBeCleanedLNsProcessed=0;
//#endif
//#if STATISTICS
  int nClusterLNsProcessed=0;
//#endif
//#if STATISTICS
  int nPendingLNsLocked=0;
//#endif
//#if STATISTICS
  int nEntriesRead=0;
//#endif
//#if STATISTICS
  long nRepeatIteratorReads=0;
//#endif
  long lockTimeout;
  int readBufferSize;
//#if LOOKAHEADCACHE
  int lookAheadCacheSize;
//#endif
  int nDeadlockRetries;
  boolean expunge;
  boolean clusterResident;
  boolean clusterAll;
  int maxBatchFiles;
//#if LOGGINGCLEANER
  Level detailedTraceLevel;
//#endif
  long cleanerBytesInterval;
  boolean trackDetail;
  /** 
 * All files that are to-be-cleaning or being-cleaned.  Used to perform
 * proactive migration.  Is read-only after assignment, so no
 * synchronization is needed.
 */
  Set mustBeCleanedFiles=Collections.EMPTY_SET;
  /** 
 * All files that are below the minUtilization threshold.  Used to perform
 * clustering migration.  Is read-only after assignment, so no
 * synchronization is needed.
 */
  Set lowUtilizationFiles=Collections.EMPTY_SET;
  private String name;
  private EnvironmentImpl env;
  private UtilizationProfile profile;
  private UtilizationTracker tracker;
  private FileSelector fileSelector;
  private FileProcessor[] threads;
  private Object deleteFileLock;
  public Cleaner(  EnvironmentImpl env,  String name) throws DatabaseException {
    this.env=env;
    this.name=name;
    tracker=new UtilizationTracker(env,this);
    profile=new UtilizationProfile(env,tracker);
    fileSelector=new FileSelector();
    threads=new FileProcessor[0];
    deleteFileLock=new Object();
    trackDetail=env.getConfigManager().getBoolean(EnvironmentParams.CLEANER_TRACK_DETAIL);
    envConfigUpdate(env.getConfigManager());
    env.addConfigObserver(this);
  }
  /** 
 * Process notifications of mutable property changes.
 */
  public void envConfigUpdate(  DbConfigManager cm) throws DatabaseException {
    lockTimeout=PropUtil.microsToMillis(cm.getLong(EnvironmentParams.CLEANER_LOCK_TIMEOUT));
    readBufferSize=cm.getInt(EnvironmentParams.CLEANER_READ_SIZE);
    if (readBufferSize <= 0) {
      readBufferSize=cm.getInt(EnvironmentParams.LOG_ITERATOR_READ_SIZE);
    }
//#if LOOKAHEADCACHE
    lookAheadCacheSize=cm.getInt(EnvironmentParams.CLEANER_LOOK_AHEAD_CACHE_SIZE);
//#endif
    nDeadlockRetries=cm.getInt(EnvironmentParams.CLEANER_DEADLOCK_RETRY);
    expunge=cm.getBoolean(EnvironmentParams.CLEANER_REMOVE);
    clusterResident=cm.getBoolean(EnvironmentParams.CLEANER_CLUSTER);
    clusterAll=cm.getBoolean(EnvironmentParams.CLEANER_CLUSTER_ALL);
    maxBatchFiles=cm.getInt(EnvironmentParams.CLEANER_MAX_BATCH_FILES);
//#if LOGGINGCLEANER
    detailedTraceLevel=Tracer.parseLevel(env,EnvironmentParams.JE_LOGGING_LEVEL_CLEANER);
//#endif
    if (clusterResident && clusterAll) {
      throw new IllegalArgumentException("Both " + EnvironmentParams.CLEANER_CLUSTER + " and "+ EnvironmentParams.CLEANER_CLUSTER_ALL+ " may not be set to true.");
    }
    int nThreads=cm.getInt(EnvironmentParams.CLEANER_THREADS);
    assert nThreads > 0;
    if (nThreads != threads.length) {
      for (int i=nThreads; i < threads.length; i+=1) {
        if (threads[i] != null) {
          threads[i].shutdown();
          threads[i]=null;
        }
      }
      FileProcessor[] newThreads=new FileProcessor[nThreads];
      for (int i=0; i < nThreads && i < threads.length; i+=1) {
        newThreads[i]=threads[i];
      }
      threads=newThreads;
      for (int i=0; i < nThreads; i+=1) {
        if (threads[i] == null) {
          threads[i]=new FileProcessor(name + '-' + (i + 1),env,this,profile,fileSelector);
        }
      }
    }
    cleanerBytesInterval=cm.getLong(EnvironmentParams.CLEANER_BYTES_INTERVAL);
    if (cleanerBytesInterval == 0) {
      cleanerBytesInterval=cm.getLong(EnvironmentParams.LOG_FILE_MAX) / 4;
    }
  }
  public UtilizationTracker getUtilizationTracker(){
    return tracker;
  }
  public UtilizationProfile getUtilizationProfile(){
    return profile;
  }
//#if CLEANERDAEMON
  public void runOrPause(  boolean run){
    if (!env.isNoLocking()) {
      for (int i=0; i < threads.length; i+=1) {
        if (threads[i] != null) {
          threads[i].runOrPause(run);
        }
      }
    }
  }
//#endif
  public void wakeup(){
    for (int i=0; i < threads.length; i+=1) {
      if (threads[i] != null) {
        threads[i].wakeup();
      }
    }
  }
//#if CLEANERDAEMON
  public void requestShutdown(){
    for (int i=0; i < threads.length; i+=1) {
      if (threads[i] != null) {
        threads[i].requestShutdown();
      }
    }
  }
//#endif
//#if CLEANERDAEMON
  public void shutdown(){
    for (int i=0; i < threads.length; i+=1) {
      if (threads[i] != null) {
        threads[i].shutdown();
        threads[i].clearEnv();
        threads[i]=null;
      }
    }
  }
//#endif
//#if CLEANERDAEMON
  public int getNWakeupRequests(){
    int count=0;
    for (int i=0; i < threads.length; i+=1) {
      if (threads[i] != null) {
        count+=threads[i].getNWakeupRequests();
      }
    }
    return count;
  }
//#endif
  private boolean areThreadsRunning(){
    for (int i=0; i < threads.length; i+=1) {
      if (threads[i] != null) {
        return threads[i].isRunning();
      }
    }
    return false;
  }
  /** 
 * Cleans selected files and returns the number of files cleaned.  This
 * method is not invoked by a deamon thread, it is programatically.
 * @param cleanMultipleFiles is true to clean until we're under budget,
 * or false to clean at most one file.
 * @param forceCleaning is true to clean even if we're not under the
 * utilization threshold.
 * @return the number of files cleaned, not including files cleaned
 * unsuccessfully.
 */
  public int doClean(  boolean cleanMultipleFiles,  boolean forceCleaning) throws DatabaseException {
    FileProcessor processor=new FileProcessor("",env,this,profile,fileSelector);
    return processor.doClean(false,cleanMultipleFiles,forceCleaning);
  }
//#if STATISTICS
  /** 
 * Load stats.
 */
  public void loadStats(  StatsConfig config,  EnvironmentStats stat) throws DatabaseException {
    stat.setCleanerBacklog(nBacklogFiles);
    stat.setNCleanerRuns(nCleanerRuns);
    stat.setNCleanerDeletions(nCleanerDeletions);
    stat.setNINsObsolete(nINsObsolete);
    stat.setNINsCleaned(nINsCleaned);
    stat.setNINsDead(nINsDead);
    stat.setNINsMigrated(nINsMigrated);
    stat.setNLNsObsolete(nLNsObsolete);
    stat.setNLNsCleaned(nLNsCleaned);
    stat.setNLNsDead(nLNsDead);
    stat.setNLNsLocked(nLNsLocked);
    stat.setNLNsMigrated(nLNsMigrated);
    stat.setNLNsMarked(nLNsMarked);
    stat.setNLNQueueHits(nLNQueueHits);
    stat.setNPendingLNsProcessed(nPendingLNsProcessed);
    stat.setNMarkedLNsProcessed(nMarkedLNsProcessed);
    stat.setNToBeCleanedLNsProcessed(nToBeCleanedLNsProcessed);
    stat.setNClusterLNsProcessed(nClusterLNsProcessed);
    stat.setNPendingLNsLocked(nPendingLNsLocked);
    stat.setNCleanerEntriesRead(nEntriesRead);
    stat.setNRepeatIteratorReads(nRepeatIteratorReads);
    if (config.getClear()) {
      nCleanerRuns=0;
      nCleanerDeletions=0;
      nINsObsolete=0;
      nINsCleaned=0;
      nINsDead=0;
      nINsMigrated=0;
      nLNsObsolete=0;
      nLNsCleaned=0;
      nLNsDead=0;
      nLNsLocked=0;
      nLNsMigrated=0;
      nLNsMarked=0;
      nLNQueueHits=0;
      nPendingLNsProcessed=0;
      nMarkedLNsProcessed=0;
      nToBeCleanedLNsProcessed=0;
      nClusterLNsProcessed=0;
      nPendingLNsLocked=0;
      nEntriesRead=0;
      nRepeatIteratorReads=0;
    }
  }
//#endif
  /** 
 * Deletes all files that are safe-to-delete, if an exclusive lock on the
 * environment can be obtained.
 */
  void deleteSafeToDeleteFiles() throws DatabaseException {
synchronized (deleteFileLock) {
      Set safeFiles=fileSelector.copySafeToDeleteFiles();
      if (safeFiles == null) {
        return;
      }
      env.checkIfInvalid();
      if (env.mayNotWrite()) {
        return;
      }
//#if ENVIRONMENTLOCKING
      if (!env.getFileManager().lockEnvironment(false,true)) 
//#if ENVIRONMENTLOCKING
{
//#if LOGGINGSEVERE
        Tracer.trace(Level.SEVERE,env,"Cleaner has " + safeFiles.size() + " files not deleted because of read-only processes.");
//#endif
        return;
      }
//#endif
//#endif
//#if ENVIRONMENTLOCKING
      try {
        for (Iterator i=safeFiles.iterator(); i.hasNext(); ) {
          Long fileNum=(Long)i.next();
          long fileNumValue=fileNum.longValue();
          boolean deleted=false;
          try {
            if (expunge) {
              env.getFileManager().deleteFile(fileNumValue);
            }
 else {
              env.getFileManager().renameFile(fileNumValue,FileManager.DEL_SUFFIX);
            }
            deleted=true;
          }
 catch (          DatabaseException e) {
            traceFileNotDeleted(e,fileNumValue);
          }
catch (          IOException e) {
            traceFileNotDeleted(e,fileNumValue);
          }
          if (deleted) {
//#if LOGGINGSEVERE
            Tracer.trace(Level.SEVERE,env,"Cleaner deleted file 0x" + Long.toHexString(fileNumValue));
//#endif
            try {
              profile.removeFile(fileNum);
            }
  finally {
              fileSelector.removeDeletedFile(fileNum);
            }
          }
//#if STATISTICS
          nCleanerDeletions++;
//#endif
        }
      }
  finally {
        env.getFileManager().releaseExclusiveLock();
      }
//#endif
    }
  }
  private void traceFileNotDeleted(  Exception e,  long fileNum){
//#if LOGGINGSEVERE
    Tracer.trace(env,"Cleaner","deleteSafeToDeleteFiles","Log file 0x" + Long.toHexString(fileNum) + " could not be "+ (expunge ? "deleted" : "renamed")+ ".  This operation will be retried at the next checkpoint.",e);
//#endif
  }
  /** 
 * Returns a copy of the cleaned and processed files at the time a
 * checkpoint starts.
 * <p>If non-null is returned, the checkpoint should flush an extra level,
 * and addCheckpointedFiles() should be called when the checkpoint is
 * complete.</p>
 */
  public Set[] getFilesAtCheckpointStart() throws DatabaseException {
    processPending();
    return fileSelector.getFilesAtCheckpointStart();
  }
  /** 
 * When a checkpoint is complete, update the files that were returned at
 * the beginning of the checkpoint.
 */
  public void updateFilesAtCheckpointEnd(  Set[] files) throws DatabaseException {
    fileSelector.updateFilesAtCheckpointEnd(files);
    deleteSafeToDeleteFiles();
  }
  /** 
 * Update the lowUtilizationFiles and mustBeCleanedFiles fields with new
 * read-only collections, and update the backlog file count.
 */
  public void updateReadOnlyFileCollections(){
    mustBeCleanedFiles=fileSelector.getMustBeCleanedFiles();
    lowUtilizationFiles=fileSelector.getLowUtilizationFiles();
//#if STATISTICS
    nBacklogFiles=fileSelector.getBacklog();
//#endif
  }
  /** 
 * If any LNs are pending, process them.  This method should be called
 * often enough to prevent the pending LN set from growing too large.
 */
  void processPending() throws DatabaseException {
    DbTree dbMapTree=env.getDbMapTree();
    LNInfo[] pendingLNs=fileSelector.getPendingLNs();
    if (pendingLNs != null) {
      TreeLocation location=new TreeLocation();
      for (int i=0; i < pendingLNs.length; i+=1) {
        LNInfo info=pendingLNs[i];
        DatabaseId dbId=info.getDbId();
        DatabaseImpl db=dbMapTree.getDb(dbId,lockTimeout);
        byte[] key=info.getKey();
        byte[] dupKey=info.getDupKey();
        LN ln=info.getLN();
//#if CRITICALEVICTION
        if (DO_CRITICAL_EVICTION) 
//#if CRITICALEVICTION
{
//#if CRITICALEVICTION
//#if EVICTOR
          env.getEvictor().doCriticalEviction();
//#endif
//#endif
        }
//#endif
//#endif
        processPendingLN(ln,db,key,dupKey,location);
      }
    }
//#if DELETEOP
    DatabaseId[] pendingDBs=fileSelector.getPendingDBs();
//#endif
//#if DELETEOP
    if (pendingDBs != null) 
//#if DELETEOP
{
      for (int i=0; i < pendingDBs.length; i+=1) {
        DatabaseId dbId=pendingDBs[i];
        DatabaseImpl db=dbMapTree.getDb(dbId,lockTimeout);
        if (db == null 
//#if DELETEOP
|| db.isDeleteFinished()
//#endif
) {
          fileSelector.removePendingDB(dbId);
        }
      }
    }
//#endif
//#endif
  }
  /** 
 * Processes a pending LN, getting the lock first to ensure that the
 * overhead of retries is mimimal.
 */
  private void processPendingLN(  LN ln,  DatabaseImpl db,  byte[] key,  byte[] dupKey,  TreeLocation location) throws DatabaseException {
    boolean parentFound=false;
    boolean processedHere=true;
    boolean lockDenied=false;
    boolean obsolete=false;
    boolean completed=false;
    BasicLocker locker=null;
    BIN bin=null;
    DIN parentDIN=null;
    try {
//#if STATISTICS
      nPendingLNsProcessed++;
//#endif
      if (db == null 
//#if DELETEOP
    || db.isDeleted()
//#endif
) {
//#if DELETEOP
        addPendingDB(db);
//#endif
//#if STATISTICS
        nLNsDead++;
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      Tree tree=db.getTree();
      assert tree != null;
      locker=new BasicLocker(env);
      LockResult lockRet=locker.nonBlockingLock(ln.getNodeId(),LockType.READ,db);
      if (lockRet.getLockGrant() == LockGrantType.DENIED) {
//#if STATISTICS
        nPendingLNsLocked++;
//#endif
        lockDenied=true;
        completed=true;
        return;
      }
      parentFound=tree.getParentBINForChildLN(location,key,dupKey,ln,false,true,true,UPDATE_GENERATION);
      bin=location.bin;
      int index=location.index;
      if (!parentFound) {
//#if STATISTICS
        nLNsDead++;
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      if (ln.containsDuplicates()) {
        parentDIN=(DIN)bin.fetchTarget(index);
        parentDIN.latch(UPDATE_GENERATION);
        ChildReference dclRef=parentDIN.getDupCountLNRef();
        processedHere=false;
        migrateDupCountLN(db,dclRef.getLsn(),parentDIN,dclRef,true,true,ln.getNodeId(),CLEAN_PENDING_LN);
      }
 else {
        processedHere=false;
        migrateLN(db,bin.getLsn(index),bin,index,true,true,ln.getNodeId(),CLEAN_PENDING_LN);
      }
      completed=true;
    }
 catch (    DatabaseException DBE) {
      DBE.printStackTrace();
//#if LOGGINGSEVERE
      Tracer.trace(env,"com.sleepycat.je.cleaner.Cleaner","processLN","Exception thrown: ",DBE);
//#endif
      throw DBE;
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
      if (locker != null) {
        locker.operationEnd();
      }
      if (processedHere) {
        if (completed && !lockDenied) {
          fileSelector.removePendingLN(ln.getNodeId());
        }
//#if LOGGINGCLEANER
        trace(detailedTraceLevel,CLEAN_PENDING_LN,ln,DbLsn.NULL_LSN,completed,obsolete,false);
//#endif
      }
    }
  }
//#if EVICTOR
  /** 
 * Returns whether the given BIN entry may be stripped by the evictor.
 * True is always returned if the BIN is not dirty.  False is returned if
 * the BIN is dirty and the entry will be migrated soon.
 */
  public boolean isEvictable(  BIN bin,  int index){
    if (bin.getDirty()) {
      if (bin.getMigrate(index)) {
        return false;
      }
      boolean isResident=(bin.getTarget(index) != null);
      Long fileNum=new Long(DbLsn.getFileNumber(bin.getLsn(index)));
      if ((PROACTIVE_MIGRATION || isResident) && mustBeCleanedFiles.contains(fileNum)) {
        return false;
      }
      if ((clusterAll || (clusterResident && isResident)) && lowUtilizationFiles.contains(fileNum)) {
        return false;
      }
    }
    return true;
  }
//#endif
  /** 
 * This method should be called just before logging a BIN.  LNs will be
 * migrated if the MIGRATE flag is set, or if they are in a file to be
 * cleaned, or if the LNs qualify according to the rules for cluster and
 * clusterAll.
 * <p>On return this method guarantees that no MIGRATE flag will be set on
 * any child entry.  If this method is *not* called before logging a BIN,
 * then the addPendingLNs method must be called.</p>
 * @param bin is the latched BIN.  The latch will not be released by this
 * method.
 * @param proactiveMigration perform proactive migration if needed; this is
 * false during a split, to reduce the delay in the user operation.
 */
  public void lazyMigrateLNs(  final BIN bin,  boolean proactiveMigration) throws DatabaseException {
    DatabaseImpl db=bin.getDatabase();
    boolean isBinInDupDb=db.getSortedDuplicates() && !bin.containsDuplicates();
    Integer[] sortedIndices=null;
    int nSortedIndices=0;
    int nEntries=bin.getNEntries();
    for (int index=0; index < nEntries; index+=1) {
      boolean migrateFlag=bin.getMigrate(index);
      boolean isResident=(bin.getTarget(index) != null);
      long childLsn=bin.getLsn(index);
      if (shouldMigrateLN(migrateFlag,isResident,proactiveMigration,isBinInDupDb,childLsn)) {
        if (isResident) {
          migrateLN(db,childLsn,bin,index,migrateFlag,false,0,CLEAN_MIGRATE_LN);
        }
 else {
          if (sortedIndices == null) {
            sortedIndices=new Integer[nEntries];
          }
          sortedIndices[nSortedIndices++]=new Integer(index);
        }
      }
    }
    if (sortedIndices != null) {
      Arrays.sort(sortedIndices,0,nSortedIndices,new Comparator(){
        public int compare(        Object o1,        Object o2){
          int i1=((Integer)o1).intValue();
          int i2=((Integer)o2).intValue();
          return DbLsn.compareTo(bin.getLsn(i1),bin.getLsn(i2));
        }
      }
);
      for (int i=0; i < nSortedIndices; i+=1) {
        int index=sortedIndices[i].intValue();
        long childLsn=bin.getLsn(index);
        boolean migrateFlag=bin.getMigrate(index);
        migrateLN(db,childLsn,bin,index,migrateFlag,false,0,CLEAN_MIGRATE_LN);
      }
    }
  }
  /** 
 * This method should be called just before logging a root DIN.  The
 * DupCountLN will be migrated if the MIGRATE flag is set, or if it is in a
 * file to be cleaned, or if the LN qualifies according to the rules for
 * cluster and clusterAll.
 * <p>On return this method guarantees that the MIGRATE flag will not be
 * set on the child entry.  If this method is *not* called before logging a
 * root DIN, then the addPendingDupCountLN method must be called.</p>
 * @param din is the latched DIN.  The latch will not be released by this
 * method.
 * @param dclRef is the reference to the DupCountLN.
 * @param proactiveMigration perform proactive migration if needed; this is
 * false during a split, to reduce the delay in the user operation.
 */
  public void lazyMigrateDupCountLN(  DIN din,  ChildReference dclRef,  boolean proactiveMigration) throws DatabaseException {
    DatabaseImpl db=din.getDatabase();
    boolean migrateFlag=dclRef.getMigrate();
    boolean isResident=(dclRef.getTarget() != null);
    boolean isBinInDupDb=false;
    long childLsn=dclRef.getLsn();
    if (shouldMigrateLN(migrateFlag,isResident,proactiveMigration,isBinInDupDb,childLsn)) {
      migrateDupCountLN(db,childLsn,din,dclRef,migrateFlag,false,0,CLEAN_MIGRATE_LN);
    }
  }
  /** 
 * Returns whether an LN entry should be migrated.  Updates stats.
 * @param migrateFlag is whether the MIGRATE flag is set on the entry.
 * @param isResident is whether the LN is currently resident.
 * @param proactiveMigration perform proactive migration if needed; this is
 * false during a split, to reduce the delay in the user operation.
 * @param isBinInDupDb is whether this is a BIN entry in a database with
 * duplicates enabled.
 * @param childLsn is the LSN of the LN.
 * @return whether to migrate the LN.
 */
  private boolean shouldMigrateLN(  boolean migrateFlag,  boolean isResident,  boolean proactiveMigration,  boolean isBinInDupDb,  long childLsn){
    boolean doMigration=false;
    if (migrateFlag) {
      doMigration=true;
//#if STATISTICS
      nMarkedLNsProcessed++;
//#endif
    }
 else     if (!proactiveMigration || isBinInDupDb || env.isClosing()) {
    }
 else {
      Long fileNum=new Long(DbLsn.getFileNumber(childLsn));
      if ((PROACTIVE_MIGRATION || isResident) && mustBeCleanedFiles.contains(fileNum)) {
        doMigration=true;
//#if STATISTICS
        nToBeCleanedLNsProcessed++;
//#endif
      }
 else       if ((clusterAll || (clusterResident && isResident)) && lowUtilizationFiles.contains(fileNum)) {
        doMigration=true;
//#if STATISTICS
        nClusterLNsProcessed++;
//#endif
      }
    }
    return doMigration;
  }
  /** 
 * Migrate an LN in the given BIN entry, if it is not obsolete.  The BIN is
 * latched on entry to this method and is left latched when it returns.
 */
  private void migrateLN(  DatabaseImpl db,  long lsn,  BIN bin,  int index,
//#if STATISTICS
  boolean wasCleaned
//#endif
,  boolean isPending,  long lockedPendingNodeId,  String cleanAction) throws DatabaseException {
    boolean obsolete=false;
    boolean migrated=false;
    boolean lockDenied=false;
    boolean completed=false;
    boolean clearTarget=false;
    BasicLocker locker=null;
    LN ln=null;
    try {
      if (!bin.isEntryKnownDeleted(index)) {
        ln=(LN)bin.getTarget(index);
        if (ln == null) {
          ln=(LN)bin.fetchTarget(index);
          clearTarget=!db.getId().equals(DbTree.ID_DB_ID);
        }
      }
      if (ln == null) {
//#if STATISTICS
        if (wasCleaned) 
//#if STATISTICS
{
//#if STATISTICS
          nLNsDead++;
//#endif
        }
//#endif
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      if (lockedPendingNodeId != ln.getNodeId()) {
        locker=new BasicLocker(env);
        LockResult lockRet=locker.nonBlockingLock(ln.getNodeId(),LockType.READ,db);
        if (lockRet.getLockGrant() == LockGrantType.DENIED) {
//#if STATISTICS
          if (wasCleaned) 
//#if STATISTICS
{
//#if STATISTICS
            nLNsLocked++;
//#endif
          }
//#endif
//#endif
          lockDenied=true;
          completed=true;
          return;
        }
      }
      if (ln.isDeleted()) {
        bin.setKnownDeletedLeaveTarget(index);
//#if STATISTICS
        if (wasCleaned) 
//#if STATISTICS
{
          nLNsDead++;
        }
//#endif
//#endif
        obsolete=true;
        completed=true;
        return;
      }
      if (bin.getMigrate(index)) {
        Long fileNum=new Long(DbLsn.getFileNumber(lsn));
        if (!fileSelector.isFileCleaningInProgress(fileNum)) {
          obsolete=true;
          completed=true;
//#if STATISTICS
          if (wasCleaned) 
//#if STATISTICS
{
            nLNsDead++;
          }
//#endif
//#endif
          return;
        }
      }
      byte[] key=getLNMainKey(bin,index);
      long newLNLsn=ln.log(env,db.getId(),key,lsn,locker);
      bin.updateEntry(index,newLNLsn);
//#if STATISTICS
      nLNsMigrated++;
//#endif
      migrated=true;
      completed=true;
      return;
    }
  finally {
      if (isPending) {
        if (completed && !lockDenied) {
          fileSelector.removePendingLN(lockedPendingNodeId);
        }
      }
 else {
        if (bin.getMigrate(index) && (!completed || lockDenied)) {
          byte[] key=getLNMainKey(bin,index);
          byte[] dupKey=getLNDupKey(bin,index,ln);
          fileSelector.addPendingLN(ln,db.getId(),key,dupKey);
          if (!areThreadsRunning()) {
            env.getUtilizationTracker().activateCleaner();
          }
          clearTarget=false;
        }
      }
      bin.setMigrate(index,false);
      if (clearTarget) {
        bin.updateEntry(index,null);
      }
      if (locker != null) {
        locker.operationEnd();
      }
//#if LOGGINGCLEANER
      trace(detailedTraceLevel,cleanAction,ln,lsn,completed,obsolete,migrated);
//#endif
    }
  }
  /** 
 * Migrate the DupCountLN for the given DIN.  The DIN is latched on entry
 * to this method and is left latched when it returns.
 */
  private void migrateDupCountLN(  DatabaseImpl db,  long lsn,  DIN parentDIN,  ChildReference dclRef,
//#if STATISTICS
  boolean wasCleaned
//#endif
,  boolean isPending,  long lockedPendingNodeId,  String cleanAction) throws DatabaseException {
    boolean obsolete=false;
    boolean migrated=false;
    boolean lockDenied=false;
    boolean completed=false;
    boolean clearTarget=false;
    BasicLocker locker=null;
    LN ln=null;
    try {
      ln=(LN)dclRef.getTarget();
      if (ln == null) {
        ln=(LN)dclRef.fetchTarget(db,parentDIN);
        assert ln != null;
        clearTarget=!db.getId().equals(DbTree.ID_DB_ID);
      }
      if (lockedPendingNodeId != ln.getNodeId()) {
        locker=new BasicLocker(env);
        LockResult lockRet=locker.nonBlockingLock(ln.getNodeId(),LockType.READ,db);
        if (lockRet.getLockGrant() == LockGrantType.DENIED) {
//#if STATISTICS
          if (wasCleaned) 
//#if STATISTICS
{
            nLNsLocked++;
          }
//#endif
//#endif
          lockDenied=true;
          completed=true;
          return;
        }
      }
      Long fileNum=new Long(DbLsn.getFileNumber(lsn));
      if (!fileSelector.isFileCleaningInProgress(fileNum)) {
        obsolete=true;
        completed=true;
//#if STATISTICS
        if (wasCleaned) 
//#if STATISTICS
{
          nLNsDead++;
        }
//#endif
//#endif
        return;
      }
      byte[] key=parentDIN.getDupKey();
      long newLNLsn=ln.log(env,db.getId(),key,lsn,locker);
      parentDIN.updateDupCountLNRef(newLNLsn);
//#if STATISTICS
      nLNsMigrated++;
//#endif
      migrated=true;
      completed=true;
      return;
    }
  finally {
      if (isPending) {
        if (completed && !lockDenied) {
          fileSelector.removePendingLN(lockedPendingNodeId);
        }
      }
 else {
        if (dclRef.getMigrate() && (!completed || lockDenied)) {
          byte[] key=parentDIN.getDupKey();
          byte[] dupKey=null;
          fileSelector.addPendingLN(ln,db.getId(),key,dupKey);
          if (!areThreadsRunning()) {
            env.getUtilizationTracker().activateCleaner();
          }
          clearTarget=false;
        }
      }
      dclRef.setMigrate(false);
      if (clearTarget) {
        parentDIN.updateDupCountLN(null);
      }
      if (locker != null) {
        locker.operationEnd();
      }
//#if LOGGINGCLEANER
      trace(detailedTraceLevel,cleanAction,ln,lsn,completed,obsolete,migrated);
//#endif
    }
  }
  /** 
 * Returns the main key for a given BIN entry.
 */
  private byte[] getLNMainKey(  BIN bin,  int index) throws DatabaseException {
    if (bin.containsDuplicates()) {
      return bin.getDupKey();
    }
 else {
      return bin.getKey(index);
    }
  }
  /** 
 * Returns the duplicate key for a given BIN entry.
 */
  private byte[] getLNDupKey(  BIN bin,  int index,  LN ln) throws DatabaseException {
    DatabaseImpl db=bin.getDatabase();
    if (!db.getSortedDuplicates() || ln.containsDuplicates()) {
      return null;
    }
 else     if (bin.containsDuplicates()) {
      return bin.getKey(index);
    }
 else {
      return ln.getData();
    }
  }
//#if DELETEOP
  /** 
 * Adds the DB ID to the pending DB set if it is being deleted but deletion
 * is not yet complete.
 */
  void addPendingDB(  DatabaseImpl db){
    if (db != null && db.isDeleted() && !db.isDeleteFinished()) {
      DatabaseId id=db.getId();
      if (fileSelector.addPendingDB(id)) {
//#if LOGGINGCLEANER
        Tracer.trace(detailedTraceLevel,env,"CleanAddPendingDB " + id);
//#endif
      }
    }
  }
//#endif
//#if LOGGINGCLEANER
  /** 
 * Send trace messages to the java.util.logger. Don't rely on the logger
 * alone to conditionalize whether we send this message, we don't even want
 * to construct the message if the level is not enabled.
 */
  void trace(  Level level,  String action,  Node node,  long logLsn,  boolean completed,  boolean obsolete,  boolean dirtiedMigrated){
//#if LOGGINGBASE
    Logger logger=env.getLogger();
//#endif
//#if LOGGINGBASE
    if (logger.isLoggable(level)) 
//#if LOGGINGBASE
{
      StringBuffer sb=new StringBuffer();
      sb.append(action);
      if (node != null) {
        sb.append(" node=");
        sb.append(node.getNodeId());
      }
      sb.append(" logLsn=");
      sb.append(DbLsn.getNoFormatString(logLsn));
      sb.append(" complete=").append(completed);
      sb.append(" obsolete=").append(obsolete);
      sb.append(" dirtiedOrMigrated=").append(dirtiedMigrated);
      logger.log(level,sb.toString());
    }
//#endif
//#endif
  }
//#endif
}
//#endif
