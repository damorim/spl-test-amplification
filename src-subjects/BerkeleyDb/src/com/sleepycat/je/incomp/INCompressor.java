//#if INCOMPRESSOR
package com.sleepycat.je.incomp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.TrackedFileSummary;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.UtilizationTracker;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.BINReference;
import com.sleepycat.je.tree.CursorsExistException;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.NodeNotEmptyException;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.Tree.SearchType;
import com.sleepycat.je.utilint.DaemonThread;
import com.sleepycat.je.utilint.PropUtil;
import com.sleepycat.je.utilint.Tracer;
/** 
 * The IN Compressor.  JE compression consist of removing delete entries from
 * BINs, and pruning empty IN/BINs from the tree. Compression is carried out by
 * either a daemon thread or lazily by operations (namely checkpointing and
 * eviction) that are writing INS.
 */
public class INCompressor extends DaemonThread {
  private static final String TRACE_COMPRESS="INCompress:";
  private static final boolean DEBUG=false;
  private EnvironmentImpl env;
  private long lockTimeout;
//#if STATISTICS
  private int splitBins=0;
//#endif
//#if STATISTICS
  private int dbClosedBins=0;
//#endif
//#if STATISTICS
  private int cursorsBins=0;
//#endif
//#if STATISTICS
  private int nonEmptyBins=0;
//#endif
//#if STATISTICS
  private int processedBins=0;
//#endif
//#if STATISTICS
  private int splitBinsThisRun=0;
//#endif
//#if STATISTICS
  private int dbClosedBinsThisRun=0;
//#endif
//#if STATISTICS
  private int cursorsBinsThisRun=0;
//#endif
//#if STATISTICS
  private int nonEmptyBinsThisRun=0;
//#endif
//#if STATISTICS
  private int processedBinsThisRun=0;
//#endif
//#if STATISTICS
  private int lazyProcessed=0;
//#endif
//#if STATISTICS
  private int lazyEmpty=0;
//#endif
//#if STATISTICS
  private int lazySplit=0;
//#endif
//#if STATISTICS
  private int wokenUp=0;
//#endif
  private Map binRefQueue;
  private Object binRefQueueSync;
  public INCompressor(  EnvironmentImpl env,  long waitTime,  String name) throws DatabaseException {
    super(waitTime,name,env);
    this.env=env;
    lockTimeout=PropUtil.microsToMillis(env.getConfigManager().getLong(EnvironmentParams.COMPRESSOR_LOCK_TIMEOUT));
    binRefQueue=new HashMap();
    binRefQueueSync=new Object();
  }
  public String toString(){
    StringBuffer sb=new StringBuffer();
    sb.append("<INCompressor name=\"").append(name).append("\"/>");
    return sb.toString();
  }
  synchronized public void clearEnv(){
    env=null;
  }
//#if VERIFIER
  public synchronized void verifyCursors() throws DatabaseException {
    if (env.isClosed()) {
      return;
    }
    List queueSnapshot=null;
synchronized (binRefQueueSync) {
      queueSnapshot=new ArrayList(binRefQueue.values());
    }
    Map dbCache=new HashMap();
    Iterator it=queueSnapshot.iterator();
    while (it.hasNext()) {
      BINReference binRef=(BINReference)it.next();
      DatabaseImpl db=env.getDbMapTree().getDb(binRef.getDatabaseId(),lockTimeout,dbCache);
      BIN bin=searchForBIN(db,binRef);
      if (bin != null) {
        bin.verifyCursors();
//#if LATCHES
        bin.releaseLatch();
//#endif
      }
    }
  }
//#endif
  /** 
 * The default daemon work queue is not used because we need a map, not a
 * set.
 */
  public void addToQueue(  Object o) throws DatabaseException {
    throw new DatabaseException("INCompressor.addToQueue should never be called.");
  }
  public int getBinRefQueueSize() throws DatabaseException {
    int size=0;
synchronized (binRefQueueSync) {
      size=binRefQueue.size();
    }
    return size;
  }
  /** 
 * Adds the BIN and deleted Key to the queue if the BIN is not already in
 * the queue, or adds the deleted key to an existing entry if one exists.
 */
  public void addBinKeyToQueue(  BIN bin,  Key deletedKey,  boolean doWakeup) throws DatabaseException {
synchronized (binRefQueueSync) {
      addBinKeyToQueueAlreadyLatched(bin,deletedKey);
    }
    if (doWakeup) {
      wakeup();
    }
  }
  /** 
 * Adds the BINReference to the queue if the BIN is not already in the
 * queue, or adds the deleted keys to an existing entry if one exists.
 */
  public void addBinRefToQueue(  BINReference binRef,  boolean doWakeup) throws DatabaseException {
synchronized (binRefQueueSync) {
      addBinRefToQueueAlreadyLatched(binRef);
    }
    if (doWakeup) {
      wakeup();
    }
  }
  /** 
 * Adds an entire collection of BINReferences to the queue at once.  Use
 * this to avoid latching for each add.
 */
  public void addMultipleBinRefsToQueue(  Collection binRefs,  boolean doWakeup) throws DatabaseException {
synchronized (binRefQueueSync) {
      Iterator it=binRefs.iterator();
      while (it.hasNext()) {
        BINReference binRef=(BINReference)it.next();
        addBinRefToQueueAlreadyLatched(binRef);
      }
    }
    if (doWakeup) {
      wakeup();
    }
  }
  /** 
 * Adds the BINReference with the latch held.
 */
  private void addBinRefToQueueAlreadyLatched(  BINReference binRef){
    Long node=new Long(binRef.getNodeId());
    BINReference existingRef=(BINReference)binRefQueue.get(node);
    if (existingRef != null) {
      existingRef.addDeletedKeys(binRef);
    }
 else {
      binRefQueue.put(node,binRef);
    }
  }
  /** 
 * Adds the BIN and deleted Key with the latch held.
 */
  private void addBinKeyToQueueAlreadyLatched(  BIN bin,  Key deletedKey){
    Long node=new Long(bin.getNodeId());
    BINReference existingRef=(BINReference)binRefQueue.get(node);
    if (existingRef != null) {
      if (deletedKey != null) {
        existingRef.addDeletedKey(deletedKey);
      }
    }
 else {
      BINReference binRef=bin.createReference();
      if (deletedKey != null) {
        binRef.addDeletedKey(deletedKey);
      }
      binRefQueue.put(node,binRef);
    }
  }
  public boolean exists(  long nodeId){
    Long node=new Long(nodeId);
synchronized (binRefQueueSync) {
      return (binRefQueue.get(node) != null);
    }
  }
  private BINReference removeCompressibleBinReference(  long nodeId){
    Long node=new Long(nodeId);
    BINReference foundRef=null;
synchronized (binRefQueueSync) {
      BINReference target=(BINReference)binRefQueue.remove(node);
      if (target != null) {
        if (target.deletedKeysExist()) {
          foundRef=target;
        }
 else {
          binRefQueue.put(node,target);
        }
      }
    }
    return foundRef;
  }
//#if STATISTICS
  /** 
 * Return stats
 */
  public void loadStats(  StatsConfig config,  EnvironmentStats stat) throws DatabaseException {
    stat.setSplitBins(splitBins);
    stat.setDbClosedBins(dbClosedBins);
    stat.setCursorsBins(cursorsBins);
    stat.setNonEmptyBins(nonEmptyBins);
    stat.setProcessedBins(processedBins);
    stat.setInCompQueueSize(getBinRefQueueSize());
    if (DEBUG) {
      System.out.println("lazyProcessed = " + lazyProcessed);
      System.out.println("lazyEmpty = " + lazyEmpty);
      System.out.println("lazySplit = " + lazySplit);
      System.out.println("wokenUp=" + wokenUp);
    }
    if (config.getClear()) {
      splitBins=0;
      dbClosedBins=0;
      cursorsBins=0;
      nonEmptyBins=0;
      processedBins=0;
      lazyProcessed=0;
      lazyEmpty=0;
      lazySplit=0;
      wokenUp=0;
    }
  }
//#endif
  /** 
 * Return the number of retries when a deadlock exception occurs.
 */
  protected int nDeadlockRetries() throws DatabaseException {
    return env.getConfigManager().getInt(EnvironmentParams.COMPRESSOR_RETRY);
  }
  public synchronized void onWakeup() throws DatabaseException {
    if (env.isClosed()) {
      return;
    }
//#if STATISTICS
    wokenUp++;
//#endif
    doCompress();
  }
  /** 
 * The real work to doing a compress. This may be called by the compressor
 * thread or programatically.
 */
  public synchronized void doCompress() throws DatabaseException {
    if (!isRunnable()) {
      return;
    }
    Map queueSnapshot=null;
    int binQueueSize=0;
synchronized (binRefQueueSync) {
      binQueueSize=binRefQueue.size();
      if (binQueueSize > 0) {
        queueSnapshot=binRefQueue;
        binRefQueue=new HashMap();
      }
    }
    if (binQueueSize > 0) {
//#if STATISTICS
      resetPerRunCounters();
//#endif
//#if LOGGINGFINE
      Tracer.trace(Level.FINE,env,"InCompress.doCompress called, queue size: " + binQueueSize);
//#endif
//#if LATCHES
      assert LatchSupport.countLatchesHeld() == 0;
//#endif
//#if CLEANER
      UtilizationTracker tracker=new UtilizationTracker(env);
//#endif
      Map dbCache=new HashMap();
      DbTree dbTree=env.getDbMapTree();
      BINSearch binSearch=new BINSearch();
      try {
        Iterator it=queueSnapshot.values().iterator();
        while (it.hasNext()) {
          if (env.isClosed()) {
            return;
          }
          BINReference binRef=(BINReference)it.next();
          if (!findDBAndBIN(binSearch,binRef,dbTree,dbCache)) {
            continue;
          }
          if (binRef.deletedKeysExist()) {
            boolean requeued=compressBin(binSearch.db,binSearch.bin,binRef
//#if CLEANER
, tracker
//#endif
);
            if (!requeued) {
              checkForRelocatedSlots(binSearch.db,binRef
//#if CLEANER
, tracker
//#endif
);
            }
          }
 else {
            BIN foundBin=binSearch.bin;
            byte[] idKey=foundBin.getIdentifierKey();
            boolean isDBIN=foundBin.containsDuplicates();
            byte[] dupKey=null;
            if (isDBIN) {
              dupKey=((DBIN)foundBin).getDupKey();
            }
//#if LATCHES
            foundBin.releaseLatch();
//#endif
            pruneBIN(binSearch.db,binRef,idKey,isDBIN,dupKey
//#if CLEANER
, tracker
//#endif
);
          }
        }
//#if CLEANER
        TrackedFileSummary[] summaries=tracker.getTrackedFiles();
//#endif
//#if CLEANER
        if (summaries.length > 0) 
//#if CLEANER
{
          env.getUtilizationProfile().countAndLogSummaries(summaries);
        }
//#endif
//#endif
      }
  finally {
//#if LATCHES
        assert LatchSupport.countLatchesHeld() == 0;
//#endif
//#if STATISTICS
        accumulatePerRunCounters();
//#endif
      }
    }
  }
  /** 
 * Compresses a single BIN and then deletes the BIN if it is empty.
 * @param bin is latched when this method is called, and unlatched when it
 * returns.
 * @return true if the BINReference was requeued by this method.
 */
  private boolean compressBin(  DatabaseImpl db,  BIN bin,  BINReference binRef
//#if CLEANER
  , UtilizationTracker tracker
//#endif
) throws DatabaseException {
    boolean empty=false;
    boolean requeued=false;
    byte[] idKey=bin.getIdentifierKey();
    byte[] dupKey=null;
    boolean isDBIN=bin.containsDuplicates();
//#if LATCHES
    try {
      int nCursors=bin.nCursors();
      if (nCursors > 0) {
        addBinRefToQueue(binRef,false);
        requeued=true;
//#if STATISTICS
        cursorsBinsThisRun++;
//#endif
      }
 else {
        requeued=bin.compress(binRef,true);
        if (!requeued) {
          empty=(bin.getNEntries() == 0);
          if (empty) {
            if (isDBIN) {
              dupKey=((DBIN)bin).getDupKey();
            }
          }
        }
      }
    }
  finally {
//#if LATCHES
      bin.releaseLatch();
//#endif
    }
//#endif
    if (empty) {
      requeued=pruneBIN(db,binRef,idKey,isDBIN,dupKey
//#if CLEANER
, tracker
//#endif
);
    }
    return requeued;
  }
  /** 
 * If the target BIN is empty, attempt to remove the empty branch of the 
 * tree.
 * @return true if the pruning was unable to proceed and the BINReference
 * was requeued.
 */
  private boolean pruneBIN(  DatabaseImpl dbImpl,  BINReference binRef,  byte[] idKey,  boolean containsDups,  byte[] dupKey
//#if CLEANER
  , UtilizationTracker tracker
//#endif
) throws DatabaseException {
    boolean requeued=false;
    try {
      Tree tree=dbImpl.getTree();
      if (containsDups) {
        tree.deleteDup(idKey,dupKey
//#if CLEANER
, tracker
//#endif
);
      }
 else {
        tree.delete(idKey
//#if CLEANER
, tracker
//#endif
);
      }
//#if STATISTICS
      processedBinsThisRun++;
//#endif
    }
 catch (    NodeNotEmptyException NNEE) {
//#if STATISTICS
      nonEmptyBinsThisRun++;
//#endif
    }
catch (    CursorsExistException e) {
      addBinRefToQueue(binRef,false);
//#if STATISTICS
      cursorsBinsThisRun++;
//#endif
      requeued=true;
    }
    return requeued;
  }
  private void checkForRelocatedSlots(  DatabaseImpl db,  BINReference binRef,
//#if CLEANER
  UtilizationTracker tracker
//#endif
) throws DatabaseException {
    Iterator iter=binRef.getDeletedKeyIterator();
    if (iter != null) {
      byte[] mainKey=binRef.getKey();
      boolean isDup=(binRef.getData() != null);
      while (iter.hasNext()) {
        Key key=(Key)iter.next();
        BIN splitBin=isDup ? searchForBIN(db,mainKey,key.getKey()) : searchForBIN(db,key.getKey(),null);
        if (splitBin != null) {
          BINReference splitBinRef=splitBin.createReference();
          splitBinRef.addDeletedKey(key);
          compressBin(db,splitBin,splitBinRef
//#if CLEANER
, tracker
//#endif
);
        }
      }
    }
  }
  private boolean isRunnable() throws DatabaseException {
    return true;
  }
  /** 
 * Search the tree for the BIN or DBIN that corresponds to this
 * BINReference.
 * @param binRef the BINReference that indicates the bin we want.
 * @return the BIN or DBIN that corresponds to this BINReference. The
 * node is latched upon return. Returns null if the BIN can't be found.
 */
  public BIN searchForBIN(  DatabaseImpl db,  BINReference binRef) throws DatabaseException {
    return searchForBIN(db,binRef.getKey(),binRef.getData());
  }
  private BIN searchForBIN(  DatabaseImpl db,  byte[] mainKey,  byte[] dupKey) throws DatabaseException {
    Tree tree=db.getTree();
    IN in=tree.search(mainKey,SearchType.NORMAL,-1,null,false);
    if (in == null) {
      return null;
    }
    if (dupKey == null) {
      return (BIN)in;
    }
    DIN duplicateRoot=null;
    DBIN duplicateBin=null;
    BIN bin=(BIN)in;
//#if LATCHES
    try {
      int index=bin.findEntry(mainKey,false,true);
      if (index >= 0) {
        Node node=null;
        if (!bin.isEntryKnownDeleted(index)) {
          node=bin.fetchTarget(index);
        }
        if (node == null) {
//#if LATCHES
          bin.releaseLatch();
//#endif
          return null;
        }
        if (node.containsDuplicates()) {
          duplicateRoot=(DIN)node;
//#if LATCHES
          duplicateRoot.latch();
//#endif
//#if LATCHES
          bin.releaseLatch();
//#endif
          duplicateBin=(DBIN)tree.searchSubTree(duplicateRoot,dupKey,SearchType.NORMAL,-1,null,false);
          return duplicateBin;
        }
 else {
          return bin;
        }
      }
 else {
//#if LATCHES
        bin.releaseLatch();
//#endif
        return null;
      }
    }
 catch (    DatabaseException DBE) {
      if (bin != null) {
        bin.releaseLatchIfOwner();
      }
      if (duplicateRoot != null) {
        duplicateRoot.releaseLatchIfOwner();
      }
      if (duplicateBin != null) {
        duplicateBin.releaseLatchIfOwner();
      }
      throw DBE;
    }
//#endif
  }
//#if STATISTICS
  /** 
 * Reset per-run counters.
 */
  private void resetPerRunCounters(){
    splitBinsThisRun=0;
    dbClosedBinsThisRun=0;
    cursorsBinsThisRun=0;
    nonEmptyBinsThisRun=0;
    processedBinsThisRun=0;
  }
//#endif
//#if STATISTICS
  private void accumulatePerRunCounters(){
    splitBins+=splitBinsThisRun;
    dbClosedBins+=dbClosedBinsThisRun;
    cursorsBins+=cursorsBinsThisRun;
    nonEmptyBins+=nonEmptyBinsThisRun;
    processedBins+=processedBinsThisRun;
  }
//#endif
  /** 
 * Lazily compress a single BIN. Do not do any pruning. The target IN
 * should be latched when we enter, and it will be remain latched.
 */
  public void lazyCompress(  IN in) throws DatabaseException {
    if (!in.isCompressible()) {
      return;
    }
//#if LATCHES
    assert in.isLatchOwner();
//#endif
    BIN bin=(BIN)in;
    int nCursors=bin.nCursors();
    if (nCursors > 0) {
      return;
    }
 else {
      BINReference binRef=removeCompressibleBinReference(bin.getNodeId());
      if ((binRef == null) || (!binRef.deletedKeysExist())) {
        return;
      }
 else {
        boolean requeued=bin.compress(binRef,false);
//#if STATISTICS
        lazyProcessed++;
//#endif
        if (!requeued && binRef.deletedKeysExist()) {
          addBinRefToQueue(binRef,false);
//#if STATISTICS
          lazySplit++;
//#endif
        }
 else {
          if (bin.getNEntries() == 0) {
            addBinRefToQueue(binRef,false);
//#if STATISTICS
            lazyEmpty++;
//#endif
          }
        }
      }
    }
  }
  private boolean findDBAndBIN(  BINSearch binSearch,  BINReference binRef,  DbTree dbTree,  Map dbCache) throws DatabaseException {
    binSearch.db=dbTree.getDb(binRef.getDatabaseId(),lockTimeout,dbCache);
    if ((binSearch.db == null) 
//#if DELETEOP
    		|| (binSearch.db.isDeleted())
//#endif
) {
//#if STATISTICS
      dbClosedBinsThisRun++;
//#endif
      return false;
    }
//#if CRITICALEVICTION
//#if EVICTOR
    env.getEvictor().doCriticalEviction();
//#endif
//#endif
    binSearch.bin=searchForBIN(binSearch.db,binRef);
    if ((binSearch.bin == null) || binSearch.bin.getNodeId() != binRef.getNodeId()) {
//#if LATCHES
      if (binSearch.bin != null) 
//#if LATCHES
{
        binSearch.bin.releaseLatch();
      }
//#endif
//#endif
//#if STATISTICS
      splitBinsThisRun++;
//#endif
      return false;
    }
    return true;
  }
private static class BINSearch {
    public DatabaseImpl db;
    public BIN bin;
  }
}
//#endif
