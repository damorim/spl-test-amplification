package com.sleepycat.je.tree;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sleepycat.je.DatabaseException;
//#if CLEANER
import com.sleepycat.je.cleaner.UtilizationTracker;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.dbi.MemoryBudget;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchNotHeldException;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.log.LogFileNotFoundException;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.LogReadable;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.LoggableObject;
import com.sleepycat.je.log.entry.INLogEntry;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.Tracer;
/** 
 * An IN represents an Internal Node in the JE tree.
 */
public class IN extends Node implements Comparable, LoggableObject, LogReadable {
  private static final String BEGIN_TAG="<in>";
  private static final String END_TAG="</in>";
  private static final String TRACE_SPLIT="Split:";
  private static final String TRACE_DELETE="Delete:";
  private static final byte KNOWN_DELETED_BIT=0x1;
  private static final byte CLEAR_KNOWN_DELETED_BIT=~0x1;
  private static final byte DIRTY_BIT=0x2;
  private static final byte CLEAR_DIRTY_BIT=~0x2;
  private static final byte MIGRATE_BIT=0x4;
  private static final byte CLEAR_MIGRATE_BIT=~0x4;
  private static final byte PENDING_DELETED_BIT=0x8;
  private static final byte CLEAR_PENDING_DELETED_BIT=~0x8;
  private static final int BYTES_PER_LSN_ENTRY=4;
  private static final int MAX_FILE_OFFSET=0xfffffe;
  private static final int THREE_BYTE_NEGATIVE_ONE=0xffffff;
  private static final int GROWTH_INCREMENT=5;
  public static final int DBMAP_LEVEL=0x20000;
  public static final int MAIN_LEVEL=0x10000;
  public static final int LEVEL_MASK=0x0ffff;
  public static final int MIN_LEVEL=-1;
  public static final int MAX_LEVEL=Integer.MAX_VALUE;
  public static final int BIN_LEVEL=MAIN_LEVEL | 1;
//#if EVICTOR
  public static final int MAY_NOT_EVICT=0;
//#endif
//#if EVICTOR
  public static final int MAY_EVICT_LNS=1;
//#endif
//#if EVICTOR
  public static final int MAY_EVICT_NODE=2;
//#endif
//#if LATCHES
  private Latch latch;
//#endif
  private long generation;
  private boolean dirty;
  private int nEntries;
  private byte[] identifierKey;
  private Node[] entryTargets;
  private byte[][] entryKeyVals;
  private long baseFileNumber;
  private byte[] entryLsnByteArray;
  private long[] entryLsnLongArray;
  private byte[] entryStates;
  private DatabaseImpl databaseImpl;
  private boolean isRoot;
  private int level;
  private long inMemorySize;
//#if MEMORYBUDGET
  private boolean inListResident;
//#endif
  private long lastFullVersion=DbLsn.NULL_LSN;
  private List provisionalObsolete;
  public static final int EXACT_MATCH=(1 << 16);
  public static final int INSERT_SUCCESS=(1 << 17);
//#if MEMORYBUDGET
  private int accumulatedDelta=0;
//#endif
  public static int ACCUMULATED_LIMIT=1000;
  /** 
 * Create an empty IN, with no node id, to be filled in from the log.
 */
  public IN(){
    super(false);
    init(null,Key.EMPTY_KEY,0,0);
  }
  /** 
 * Create a new IN.
 */
  public IN(  DatabaseImpl db,  byte[] identifierKey,  int capacity,  int level){
    super(true);
    init(db,identifierKey,capacity,generateLevel(db.getId(),level));
//#if MEMORYBUDGET
    initMemorySize();
//#endif
  }
  /** 
 * Initialize IN object.
 */
  protected void init(  DatabaseImpl db,  byte[] identifierKey,  int initialCapacity,  int level){
    setDatabase(db);
    EnvironmentImpl env=(databaseImpl == null) ? null : databaseImpl.getDbEnvironment();
//#if LATCHES
    latch=LatchSupport.makeLatch(shortClassName() + getNodeId(),env);
//#endif
    generation=0;
    dirty=false;
    nEntries=0;
    this.identifierKey=identifierKey;
    entryTargets=new Node[initialCapacity];
    entryKeyVals=new byte[initialCapacity][];
    baseFileNumber=-1;
    entryLsnByteArray=new byte[initialCapacity << 2];
    entryLsnLongArray=null;
    entryStates=new byte[initialCapacity];
    isRoot=false;
    this.level=level;
//#if MEMORYBUDGET
    inListResident=false;
//#endif
  }
//#if MEMORYBUDGET
  /** 
 * Initialize the per-node memory count by computing its memory usage.
 */
  protected void initMemorySize(){
    inMemorySize=computeMemorySize();
  }
//#endif
  private long getEqualityKey(){
    int hash=System.identityHashCode(this);
    long hash2=(((long)hash) << 32) | hash;
    return hash2 ^ getNodeId();
  }
  public boolean equals(  Object obj){
    if (!(obj instanceof IN)) {
      return false;
    }
    IN in=(IN)obj;
    return (this.getEqualityKey() == in.getEqualityKey());
  }
  public int hashCode(){
    return (int)getEqualityKey();
  }
  /** 
 * Sort based on node id.
 */
  public int compareTo(  Object o){
    if (o == null) {
      throw new NullPointerException();
    }
    IN argIN=(IN)o;
    long argEqualityKey=argIN.getEqualityKey();
    long myEqualityKey=getEqualityKey();
    if (myEqualityKey < argEqualityKey) {
      return -1;
    }
 else     if (myEqualityKey > argEqualityKey) {
      return 1;
    }
 else {
      return 0;
    }
  }
  /** 
 * Create a new IN.  Need this because we can't call newInstance() without
 * getting a 0 for nodeid.
 */
  protected IN createNewInstance(  byte[] identifierKey,  int maxEntries,  int level){
    return new IN(databaseImpl,identifierKey,maxEntries,level);
  }
  /** 
 * Initialize a node that has been read in from the log.
 */
  public void postFetchInit(  DatabaseImpl db,  long sourceLsn) throws DatabaseException {
    setDatabase(db);
    setLastFullLsn(sourceLsn);
    EnvironmentImpl env=db.getDbEnvironment();
//#if MEMORYBUDGET
    initMemorySize();
//#endif
    env.getInMemoryINs().add(this);
  }
  /** 
 * Initialize a node read in during recovery.
 */
  public void postRecoveryInit(  DatabaseImpl db,  long sourceLsn){
    setDatabase(db);
    setLastFullLsn(sourceLsn);
//#if MEMORYBUDGET
    initMemorySize();
//#endif
  }
  /** 
 * Sets the last logged LSN.
 */
  void setLastFullLsn(  long lsn){
    lastFullVersion=lsn;
  }
  /** 
 * Returns the last logged LSN, or null if never logged.  Is public for
 * unit testing.
 */
  public long getLastFullVersion(){
    return lastFullVersion;
  }
  /** 
 * Latch this node, optionally setting the generation.
 */
  public void latch(  boolean updateGeneration) throws DatabaseException {
    if (updateGeneration) {
      setGeneration();
    }
//#if LATCHES
    latch.acquire();
//#endif
  }
  /** 
 * Latch this node if it is not latched by another thread, optionally
 * setting the generation if the latch succeeds.
 */
//#if LATCHES
  public boolean latchNoWait(  boolean updateGeneration) throws DatabaseException {
	  if (latch.acquireNoWait()) {
		  if (updateGeneration) {
			  setGeneration();
		  }
		  return true;
	  } else {
		  return false;
	  }
  }
//#endif

//#if LATCHES
  /** 
 * Latch this node and set the generation.
 */
  public void latch() throws DatabaseException {
    latch(true);
  }
//#endif
//#if LATCHES
  /** 
 * Latch this node if it is not latched by another thread, and set the
 * generation if the latch succeeds.
 */
  public boolean latchNoWait() throws DatabaseException {
    return latchNoWait(true);
  }
//#endif
//#if LATCHES
  /** 
 * Release the latch on this node.
 */
  public void releaseLatch() throws LatchNotHeldException {
    latch.release();
  }
//#endif
//#if LATCHES
  /** 
 * Release the latch on this node.
 */
  public void releaseLatchIfOwner() throws LatchNotHeldException {
    latch.releaseIfOwner();
  }
//#endif
//#if LATCHES
  /** 
 * @return true if this thread holds the IN's latch
 */
  public boolean isLatchOwner(){
    return latch.isOwner();
  }
//#endif
  public long getGeneration(){
    return generation;
  }
  public void setGeneration(){
    generation=Generation.getNextGeneration();
  }
  public void setGeneration(  long newGeneration){
    generation=newGeneration;
  }
  public int getLevel(){
    return level;
  }
  protected int generateLevel(  DatabaseId dbId,  int newLevel){
    if (dbId.equals(DbTree.ID_DB_ID)) {
      return newLevel | DBMAP_LEVEL;
    }
 else {
      return newLevel | MAIN_LEVEL;
    }
  }
  public boolean getDirty(){
    return dirty;
  }
  public void setDirty(  boolean dirty){
    this.dirty=dirty;
  }
  public boolean isRoot(){
    return isRoot;
  }
  public boolean isDbRoot(){
    return isRoot;
  }
  void setIsRoot(  boolean isRoot){
    this.isRoot=isRoot;
    setDirty(true);
  }
  /** 
 * @return the identifier key for this node.
 */
  public byte[] getIdentifierKey(){
    return identifierKey;
  }
  /** 
 * Set the identifier key for this node.
 * @param key - the new identifier key for this node.
 */
  void setIdentifierKey(  byte[] key){
    identifierKey=key;
    setDirty(true);
  }
  /** 
 * Get the key (dupe or identifier) in child that is used to locate it in
 * 'this' node.
 */
  public byte[] getChildKey(  IN child) throws DatabaseException {
    return child.getIdentifierKey();
  }
  public byte[] selectKey(  byte[] mainTreeKey,  byte[] dupTreeKey){
    return mainTreeKey;
  }
  /** 
 * Return the key for this duplicate set.
 */
  public byte[] getDupKey() throws DatabaseException {
    throw new DatabaseException(shortClassName() + ".getDupKey() called");
  }
  /** 
 * Return the key for navigating through the duplicate tree.
 */
  public byte[] getDupTreeKey(){
    return null;
  }
  /** 
 * Return the key for navigating through the main tree.
 */
  public byte[] getMainTreeKey(){
    return getIdentifierKey();
  }
  /** 
 * Get the database for this IN.
 */
  public DatabaseImpl getDatabase(){
    return databaseImpl;
  }
  /** 
 * Set the database reference for this node.
 */
  public void setDatabase(  DatabaseImpl db){
    databaseImpl=db;
  }
  public DatabaseId getDatabaseId(){
    return databaseImpl.getId();
  }
  private void setEntryInternal(  int from,  int to){
    entryTargets[to]=entryTargets[from];
    entryKeyVals[to]=entryKeyVals[from];
    entryStates[to]=entryStates[from];
    if (entryLsnLongArray == null) {
      int fromOff=from << 2;
      int toOff=to << 2;
      entryLsnByteArray[toOff++]=entryLsnByteArray[fromOff++];
      entryLsnByteArray[toOff++]=entryLsnByteArray[fromOff++];
      entryLsnByteArray[toOff++]=entryLsnByteArray[fromOff++];
      entryLsnByteArray[toOff]=entryLsnByteArray[fromOff];
    }
 else {
      entryLsnLongArray[to]=entryLsnLongArray[from];
    }
  }
  private void clearEntry(  int idx){
    entryTargets[idx]=null;
    entryKeyVals[idx]=null;
    setLsnElement(idx,DbLsn.NULL_LSN);
    entryStates[idx]=0;
  }
  /** 
 * Return the idx'th key.
 */
  public byte[] getKey(  int idx){
    return entryKeyVals[idx];
  }
  /** 
 * Set the idx'th key.
 */
  private void setKey(  int idx,  byte[] keyVal){
    entryKeyVals[idx]=keyVal;
    entryStates[idx]|=DIRTY_BIT;
  }
  /** 
 * Get the idx'th migrate status.
 */
  public boolean getMigrate(  int idx){
    return (entryStates[idx] & MIGRATE_BIT) != 0;
  }
  /** 
 * Set the idx'th migrate status.
 */
  public void setMigrate(  int idx,  boolean migrate){
    if (migrate) {
      entryStates[idx]|=MIGRATE_BIT;
    }
 else {
      entryStates[idx]&=CLEAR_MIGRATE_BIT;
    }
  }
  public byte getState(  int idx){
    return entryStates[idx];
  }
  /** 
 * Return the idx'th target.
 */
  public Node getTarget(  int idx){
    return entryTargets[idx];
  }
  /** 
 * Sets the idx'th target. No need to make dirty, that state only applies
 * to key and LSN.
 * <p>WARNING: This method does not update the memory budget.  The caller
 * must update the budget.</p>
 */
  void setTarget(  int idx,  Node target){
    entryTargets[idx]=target;
  }
  /** 
 * Return the idx'th LSN for this entry.
 * @return the idx'th LSN for this entry.
 */
  public long getLsn(  int idx){
    if (entryLsnLongArray == null) {
      int offset=idx << 2;
      int fileOffset=getFileOffset(offset);
      if (fileOffset == -1) {
        return DbLsn.NULL_LSN;
      }
 else {
        return DbLsn.makeLsn((long)(baseFileNumber + getFileNumberOffset(offset)),fileOffset);
      }
    }
 else {
      return entryLsnLongArray[idx];
    }
  }
  /** 
 * Sets the idx'th target LSN.
 */
  public void setLsn(  int idx,  long lsn){
//#if MEMORYBUDGET
    int oldSize=computeLsnOverhead();
//#endif
    setLsnElement(idx,lsn);
//#if MEMORYBUDGET
    changeMemorySize(computeLsnOverhead() - oldSize);
//#endif
    entryStates[idx]|=DIRTY_BIT;
  }
  long[] getEntryLsnLongArray(){
    return entryLsnLongArray;
  }
  byte[] getEntryLsnByteArray(){
    return entryLsnByteArray;
  }
  void initEntryLsn(  int capacity){
    entryLsnLongArray=null;
    entryLsnByteArray=new byte[capacity << 2];
    baseFileNumber=-1;
  }
  void setLsnElement(  int idx,  long value){
    int offset=idx << 2;
    if (entryLsnLongArray != null) {
      entryLsnLongArray[idx]=value;
      return;
    }
    if (value == DbLsn.NULL_LSN) {
      setFileNumberOffset(offset,(byte)0);
      setFileOffset(offset,-1);
      return;
    }
    long thisFileNumber=DbLsn.getFileNumber(value);
    if (baseFileNumber == -1) {
      baseFileNumber=thisFileNumber;
      setFileNumberOffset(offset,(byte)0);
    }
 else {
      if (thisFileNumber < baseFileNumber) {
        if (!adjustFileNumbers(thisFileNumber)) {
          mutateToLongArray(idx,value);
          return;
        }
        baseFileNumber=thisFileNumber;
      }
      long fileNumberDifference=thisFileNumber - baseFileNumber;
      if (fileNumberDifference > Byte.MAX_VALUE) {
        mutateToLongArray(idx,value);
        return;
      }
      setFileNumberOffset(offset,(byte)(thisFileNumber - baseFileNumber));
    }
    int fileOffset=(int)DbLsn.getFileOffset(value);
    if (fileOffset > MAX_FILE_OFFSET) {
      mutateToLongArray(idx,value);
      return;
    }
    setFileOffset(offset,fileOffset);
  }
  private void mutateToLongArray(  int idx,  long value){
    int nElts=entryLsnByteArray.length >> 2;
    long[] newArr=new long[nElts];
    for (int i=0; i < nElts; i++) {
      newArr[i]=getLsn(i);
    }
    newArr[idx]=value;
    entryLsnLongArray=newArr;
    entryLsnByteArray=null;
  }
  /** 
 * private void maybeAdjustCapacity(int offset) {
 * if (entryLsnLongArray == null) {
 * int bytesNeeded = offset + BYTES_PER_LSN_ENTRY;
 * int currentBytes = entryLsnByteArray.length;
 * if (currentBytes < bytesNeeded) {
 * int newBytes = bytesNeeded +
 * (GROWTH_INCREMENT * BYTES_PER_LSN_ENTRY);
 * byte[] newArr = new byte[newBytes];
 * System.arraycopy(entryLsnByteArray, 0, newArr, 0,
 * currentBytes);
 * entryLsnByteArray = newArr;
 * for (int i = currentBytes;
 * i < newBytes;
 * i += BYTES_PER_LSN_ENTRY) {
 * setFileNumberOffset(i, (byte) 0);
 * setFileOffset(i, -1);
 * }
 * }
 * } else {
 * int currentEntries = entryLsnLongArray.length;
 * int idx = offset >> 2;
 * if (currentEntries < idx + 1) {
 * int newEntries = idx + GROWTH_INCREMENT;
 * long[] newArr = new long[newEntries];
 * System.arraycopy(entryLsnLongArray, 0, newArr, 0,
 * currentEntries);
 * entryLsnLongArray = newArr;
 * for (int i = currentEntries; i < newEntries; i++) {
 * entryLsnLongArray[i] = DbLsn.NULL_LSN;
 * }
 * }
 * }
 * }
 */
  private boolean adjustFileNumbers(  long newBaseFileNumber){
    long oldBaseFileNumber=baseFileNumber;
    for (int i=0; i < entryLsnByteArray.length; i+=BYTES_PER_LSN_ENTRY) {
      if (getFileOffset(i) == -1) {
        continue;
      }
      long curEntryFileNumber=oldBaseFileNumber + getFileNumberOffset(i);
      long newCurEntryFileNumberOffset=(curEntryFileNumber - newBaseFileNumber);
      if (newCurEntryFileNumberOffset > Byte.MAX_VALUE) {
        long undoOffset=oldBaseFileNumber - newBaseFileNumber;
        for (int j=i - BYTES_PER_LSN_ENTRY; j >= 0; j-=BYTES_PER_LSN_ENTRY) {
          if (getFileOffset(j) == -1) {
            continue;
          }
          setFileNumberOffset(j,(byte)(getFileNumberOffset(j) - undoOffset));
        }
        return false;
      }
      setFileNumberOffset(i,(byte)newCurEntryFileNumberOffset);
    }
    return true;
  }
  private void setFileNumberOffset(  int offset,  byte fileNumberOffset){
    entryLsnByteArray[offset]=fileNumberOffset;
  }
  private byte getFileNumberOffset(  int offset){
    return entryLsnByteArray[offset];
  }
  private void setFileOffset(  int offset,  int fileOffset){
    put3ByteInt(offset + 1,fileOffset);
  }
  private int getFileOffset(  int offset){
    return get3ByteInt(offset + 1);
  }
  private void put3ByteInt(  int offset,  int value){
    entryLsnByteArray[offset++]=(byte)(value >>> 0);
    entryLsnByteArray[offset++]=(byte)(value >>> 8);
    entryLsnByteArray[offset]=(byte)(value >>> 16);
  }
  private int get3ByteInt(  int offset){
    int ret=(entryLsnByteArray[offset++] & 0xFF) << 0;
    ret+=(entryLsnByteArray[offset++] & 0xFF) << 8;
    ret+=(entryLsnByteArray[offset] & 0xFF) << 16;
    if (ret == THREE_BYTE_NEGATIVE_ONE) {
      ret=-1;
    }
    return ret;
  }
  /** 
 * @return true if the idx'th entry has been deleted, although the
 * transaction that performed the deletion may not be committed.
 */
  public boolean isEntryPendingDeleted(  int idx){
    return ((entryStates[idx] & PENDING_DELETED_BIT) != 0);
  }
  /** 
 * Set pendingDeleted to true.
 */
  public void setPendingDeleted(  int idx){
    entryStates[idx]|=PENDING_DELETED_BIT;
    entryStates[idx]|=DIRTY_BIT;
  }
  /** 
 * Set pendingDeleted to false.
 */
  public void clearPendingDeleted(  int idx){
    entryStates[idx]&=CLEAR_PENDING_DELETED_BIT;
    entryStates[idx]|=DIRTY_BIT;
  }
  /** 
 * @return true if the idx'th entry is deleted for sure.  If a transaction
 * performed the deletion, it has been committed.
 */
  public boolean isEntryKnownDeleted(  int idx){
    return ((entryStates[idx] & KNOWN_DELETED_BIT) != 0);
  }
  /** 
 * Set knownDeleted to true.
 */
  void setKnownDeleted(  int idx){
    entryStates[idx]|=KNOWN_DELETED_BIT;
    entryStates[idx]|=DIRTY_BIT;
  }
  /** 
 * Set knownDeleted to false.
 */
  void clearKnownDeleted(  int idx){
    entryStates[idx]&=CLEAR_KNOWN_DELETED_BIT;
    entryStates[idx]|=DIRTY_BIT;
  }
  /** 
 * @return true if the object is dirty.
 */
  boolean isDirty(  int idx){
    return ((entryStates[idx] & DIRTY_BIT) != 0);
  }
  /** 
 * @return the number of entries in this node.
 */
  public int getNEntries(){
    return nEntries;
  }
  /** 
 * Returns true if the given state is known deleted.
 */
  static boolean isStateKnownDeleted(  byte state){
    return ((state & KNOWN_DELETED_BIT) != 0);
  }
  /** 
 * Returns true if the given state is known deleted.
 */
  static boolean isStatePendingDeleted(  byte state){
    return ((state & KNOWN_DELETED_BIT) != 0);
  }
  /** 
 * @return the maximum number of entries in this node.
 */
  int getMaxEntries(){
    return entryTargets.length;
  }
  /** 
 * Returns the target of the idx'th entry or null if a pendingDeleted or
 * knownDeleted entry has been cleaned.  Note that null can only be
 * returned for a slot that could contain a deleted LN, not other node
 * types and not a DupCountLN since DupCountLNs are never deleted.  Null is
 * also returned for a KnownDeleted slot with a NULL_LSN.
 * @return the target node or null.
 */
  public Node fetchTarget(  int idx) throws DatabaseException {
    if (entryTargets[idx] == null) {
      long lsn=getLsn(idx);
      if (lsn == DbLsn.NULL_LSN) {
        if (!isEntryKnownDeleted(idx)) {
          throw new DatabaseException(makeFetchErrorMsg("NULL_LSN without KnownDeleted",this,lsn,entryStates[idx]));
        }
      }
 else {
        try {
          EnvironmentImpl env=databaseImpl.getDbEnvironment();
          Node node=(Node)env.getLogManager().get(lsn);
          node.postFetchInit(databaseImpl,lsn);
          entryTargets[idx]=node;
//#if MEMORYBUDGET
          updateMemorySize(null,node);
//#endif
        }
 catch (        LogFileNotFoundException LNFE) {
          if (!isEntryKnownDeleted(idx) && !isEntryPendingDeleted(idx)) {
            throw new DatabaseException(makeFetchErrorMsg(LNFE.toString(),this,lsn,entryStates[idx]));
          }
        }
catch (        Exception e) {
          throw new DatabaseException(makeFetchErrorMsg(e.toString(),this,lsn,entryStates[idx]),e);
        }
      }
    }
    return entryTargets[idx];
  }
  static String makeFetchErrorMsg(  String msg,  IN in,  long lsn,  byte state){
    StringBuffer sb=new StringBuffer();
    sb.append("fetchTarget of ");
    if (lsn == DbLsn.NULL_LSN) {
      sb.append("null lsn");
    }
 else {
      sb.append(DbLsn.getNoFormatString(lsn));
    }
    if (in != null) {
      sb.append(" IN=").append(in.getNodeId());
    }
    sb.append(" state=").append(state);
    sb.append(" ").append(msg);
    return sb.toString();
  }
  /** 
 * Set the idx'th entry of this node.
 */
  public void setEntry(  int idx,  Node target,  byte[] keyVal,  long lsn,  byte state){
//#if MEMORYBUDGET
    long oldSize=getEntryInMemorySize(idx);
//#endif
    int newNEntries=idx + 1;
    if (newNEntries > nEntries) {
      nEntries=newNEntries;
//#if MEMORYBUDGET
      oldSize=0;
//#endif
    }
    entryTargets[idx]=target;
    entryKeyVals[idx]=keyVal;
    setLsnElement(idx,lsn);
    entryStates[idx]=state;
//#if MEMORYBUDGET
    long newSize=getEntryInMemorySize(idx);
//#endif
//#if MEMORYBUDGET
    updateMemorySize(oldSize,newSize);
//#endif
    setDirty(true);
  }
  /** 
 * Update the idx'th entry of this node.
 * Note: does not dirty the node.
 */
  public void updateEntry(  int idx,  Node node){
//#if MEMORYBUDGET
    long oldSize=getEntryInMemorySize(idx);
//#endif
    setTarget(idx,node);
//#if MEMORYBUDGET
    long newSize=getEntryInMemorySize(idx);
//#endif
//#if MEMORYBUDGET
    updateMemorySize(oldSize,newSize);
//#endif
  }
  /** 
 * Update the idx'th entry of this node.
 */
  public void updateEntry(  int idx,  Node node,  long lsn){
//#if MEMORYBUDGET
    long oldSize=getEntryInMemorySize(idx);
//#endif
    setLsn(idx,lsn);
    setTarget(idx,node);
//#if MEMORYBUDGET
    long newSize=getEntryInMemorySize(idx);
//#endif
//#if MEMORYBUDGET
    updateMemorySize(oldSize,newSize);
//#endif
    setDirty(true);
  }
  /** 
 * Update the idx'th entry of this node.
 */
  public void updateEntry(  int idx,  Node node,  long lsn,  byte[] key){
//#if MEMORYBUDGET
    long oldSize=getEntryInMemorySize(idx);
//#endif
    setLsn(idx,lsn);
    setTarget(idx,node);
    setKey(idx,key);
//#if MEMORYBUDGET
    long newSize=getEntryInMemorySize(idx);
//#endif
//#if MEMORYBUDGET
    updateMemorySize(oldSize,newSize);
//#endif
    setDirty(true);
  }
  /** 
 * Update the idx'th entry of this node.
 */
  public void updateEntry(  int idx,  long lsn){
    setLsn(idx,lsn);
    setDirty(true);
  }
  /** 
 * Update the idx'th entry of this node.
 */
  public void updateEntry(  int idx,  long lsn,  byte state){
    setLsn(idx,lsn);
    entryStates[idx]=state;
    setDirty(true);
  }
  
//#if MEMORYBUDGET
  /** 
 * Update the idx'th entry of this node. This flavor is used when the
 * target LN is being modified, by an operation like a delete or update. We
 * don't have to check whether the LSN has been nulled or not, because we
 * know an LSN existed before. Also, the modification of the target is done
 * in the caller, so instead of passing in the old and new nodes, we pass
 * in the old and new node sizes.
 */
  public void updateEntry(  int idx,  long lsn, long oldLNSize, long newLNSize){
    updateMemorySize(oldLNSize,newLNSize);
    setLsn(idx,lsn);
    setDirty(true);
  }
//#endif
  
  /** 
 * Update the idx'th entry of this node.  Only update the key if the new
 * key is less than the existing key.
 */
  private void updateEntryCompareKey(  int idx,  Node node,  long lsn,  byte[] key){
//#if MEMORYBUDGET
    long oldSize=getEntryInMemorySize(idx);
//#endif
    setLsn(idx,lsn);
    setTarget(idx,node);
    byte[] existingKey=getKey(idx);
    int s=Key.compareKeys(key,existingKey,getKeyComparator());
    if (s < 0) {
      setKey(idx,key);
    }
//#if MEMORYBUDGET
    long newSize=getEntryInMemorySize(idx);
//#endif
//#if MEMORYBUDGET
    updateMemorySize(oldSize,newSize);
//#endif
    setDirty(true);
  }
//#if MEMORYBUDGET
  public boolean verifyMemorySize(){
//#if MEMORYBUDGET
    long calcMemorySize=computeMemorySize();
//#endif
    if (calcMemorySize != inMemorySize) {
      String msg="-Warning: Out of sync. " + "Should be " + calcMemorySize + " / actual: "+ inMemorySize+ " node: "+ getNodeId();
//#if LOGGINGINFO
      Tracer.trace(Level.INFO,databaseImpl.getDbEnvironment(),msg);
//#endif
      System.out.println(msg);
      return false;
    }
 else {
      return true;
    }
  }
//#endif
//#if MEMORYBUDGET
  /** 
 * Return the number of bytes used by this IN.  Latching is up to the
 * caller.
 */
  public long getInMemorySize(){
    return inMemorySize;
  }
//#endif
//#if MEMORYBUDGET
  private long getEntryInMemorySize(  int idx){
    return getEntryInMemorySize(entryKeyVals[idx],entryTargets[idx]);
  }
//#endif
//#if MEMORYBUDGET
  protected long getEntryInMemorySize(  byte[] key,  Node target){
    long ret=0;
    if (key != null) {
      ret+=MemoryBudget.byteArraySize(key.length);
    }
    if (target != null) {
      ret+=target.getMemorySizeIncludedByParent();
    }
    return ret;
  }
//#endif
//#if MEMORYBUDGET
  /** 
 * Count up the memory usage attributable to this node alone. LNs children
 * are counted by their BIN/DIN parents, but INs are not counted by their
 * parents because they are resident on the IN list.
 */
  protected long computeMemorySize(){
    MemoryBudget mb=databaseImpl.getDbEnvironment().getMemoryBudget();
    long calcMemorySize=getMemoryOverhead(mb);
    calcMemorySize+=computeLsnOverhead();
    for (int i=0; i < nEntries; i++) {
      calcMemorySize+=getEntryInMemorySize(i);
    }
    if (provisionalObsolete != null) {
      calcMemorySize+=provisionalObsolete.size() * MemoryBudget.LONG_LIST_PER_ITEM_OVERHEAD;
    }
    return calcMemorySize;
  }
//#endif
//#if MEMORYBUDGET
  public static long computeOverhead(  DbConfigManager configManager) throws DatabaseException {
    return MemoryBudget.IN_FIXED_OVERHEAD + IN.computeArraysOverhead(configManager);
  }
//#endif
//#if MEMORYBUDGET
  private int computeLsnOverhead(){
    if (entryLsnLongArray == null) {
      return MemoryBudget.byteArraySize(entryLsnByteArray.length);
    }
 else {
      return MemoryBudget.BYTE_ARRAY_OVERHEAD + entryLsnLongArray.length * MemoryBudget.LONG_OVERHEAD;
    }
  }
//#endif
//#if MEMORYBUDGET
  protected static long computeArraysOverhead(  DbConfigManager configManager) throws DatabaseException {
    int capacity=configManager.getInt(EnvironmentParams.NODE_MAX);
    return MemoryBudget.byteArraySize(capacity) + (capacity * (2 * MemoryBudget.ARRAY_ITEM_OVERHEAD));
  }
//#endif
//#if MEMORYBUDGET
  protected long getMemoryOverhead(  MemoryBudget mb){
    return mb.getINOverhead();
  }
//#endif
//#if MEMORYBUDGET
  protected void updateMemorySize(  ChildReference oldRef,  ChildReference newRef){
    long delta=0;
    if (newRef != null) {
      delta=getEntryInMemorySize(newRef.getKey(),newRef.getTarget());
    }
    if (oldRef != null) {
      delta-=getEntryInMemorySize(oldRef.getKey(),oldRef.getTarget());
    }
    changeMemorySize(delta);
  }
//#endif
//#if MEMORYBUDGET
  protected void updateMemorySize(  long oldSize,  long newSize){
    long delta=newSize - oldSize;
    changeMemorySize(delta);
  }
//#endif
//#if MEMORYBUDGET
  void updateMemorySize(  Node oldNode,  Node newNode){
    long delta=0;
    if (newNode != null) {
      delta=newNode.getMemorySizeIncludedByParent();
    }
    if (oldNode != null) {
      delta-=oldNode.getMemorySizeIncludedByParent();
    }
    changeMemorySize(delta);
  }
//#endif
//#if MEMORYBUDGET
  private void changeMemorySize(  long delta){
    inMemorySize+=delta;
    if (inListResident) {
      MemoryBudget mb=databaseImpl.getDbEnvironment().getMemoryBudget();
      accumulatedDelta+=delta;
      if (accumulatedDelta > ACCUMULATED_LIMIT || accumulatedDelta < -ACCUMULATED_LIMIT) {
        mb.updateTreeMemoryUsage(accumulatedDelta);
        accumulatedDelta=0;
      }
    }
  }
//#endif
//#if MEMORYBUDGET
  public int getAccumulatedDelta(){
    return accumulatedDelta;
  }
//#endif
//#if MEMORYBUDGET
  public void setInListResident(  boolean resident){
    inListResident=resident;
  }
//#endif
  /** 
 * Returns whether the given key is greater than or equal to the first key
 * in the IN and less than or equal to the last key in the IN.  This method
 * is used to determine whether a key to be inserted belongs in this IN,
 * without doing a tree search.  If false is returned it is still possible
 * that the key belongs in this IN, but a tree search must be performed to
 * find out.
 */
  public boolean isKeyInBounds(  byte[] keyVal){
    if (nEntries < 2) {
      return false;
    }
    Comparator userCompareToFcn=getKeyComparator();
    int cmp;
    byte[] myKey;
    myKey=entryKeyVals[0];
    cmp=Key.compareKeys(keyVal,myKey,userCompareToFcn);
    if (cmp < 0) {
      return false;
    }
    myKey=entryKeyVals[nEntries - 1];
    cmp=Key.compareKeys(keyVal,myKey,userCompareToFcn);
    if (cmp > 0) {
      return false;
    }
    return true;
  }
  /** 
 * Find the entry in this IN for which key arg is >= the key.
 * Currently uses a binary search, but eventually, this may use binary or
 * linear search depending on key size, number of entries, etc.
 * Note that the 0'th entry's key is treated specially in an IN.  It always
 * compares lower than any other key.
 * This is public so that DbCursorTest can access it.
 * @param key - the key to search for.
 * @param indicateIfDuplicate - true if EXACT_MATCH should
 * be or'd onto the return value if key is already present in this node.
 * @param exact - true if an exact match must be found.
 * @return offset for the entry that has a key >= the arg.  0 if key
 * is less than the 1st entry.  -1 if exact is true and no exact match
 * is found.  If indicateIfDuplicate is true and an exact match was found
 * then EXACT_MATCH is or'd onto the return value.
 */
  public int findEntry(  byte[] key,  boolean indicateIfDuplicate,  boolean exact){
    int high=nEntries - 1;
    int low=0;
    int middle=0;
    Comparator userCompareToFcn=getKeyComparator();
    boolean entryZeroSpecialCompare=entryZeroKeyComparesLow() && !exact && !indicateIfDuplicate;
    assert nEntries >= 0;
    while (low <= high) {
      middle=(high + low) / 2;
      int s;
      byte[] middleKey=null;
      if (middle == 0 && entryZeroSpecialCompare) {
        s=1;
      }
 else {
        middleKey=entryKeyVals[middle];
        s=Key.compareKeys(key,middleKey,userCompareToFcn);
      }
      if (s < 0) {
        high=middle - 1;
      }
 else       if (s > 0) {
        low=middle + 1;
      }
 else {
        int ret;
        if (indicateIfDuplicate) {
          ret=middle | EXACT_MATCH;
        }
 else {
          ret=middle;
        }
        if ((ret >= 0) && exact && isEntryKnownDeleted(ret & 0xffff)) {
          return -1;
        }
 else {
          return ret;
        }
      }
    }
    if (exact) {
      return -1;
    }
 else {
      return high;
    }
  }
  /** 
 * Inserts the argument ChildReference into this IN.  Assumes this node is
 * already latched by the caller.
 * @param entry The ChildReference to insert into the IN.
 * @return true if the entry was successfully inserted, false
 * if it was a duplicate.
 * @throws InconsistentNodeException if the node is full
 * (it should have been split earlier).
 */
  public boolean insertEntry(  ChildReference entry) throws DatabaseException {
    return (insertEntry1(entry) & INSERT_SUCCESS) != 0;
  }
  /** 
 * Same as insertEntry except that it returns the index where the dup was
 * found instead of false.  The return value is |'d with either
 * INSERT_SUCCESS or EXACT_MATCH depending on whether the entry was
 * inserted or it was a duplicate, resp.
 * This returns a failure if there's a duplicate match. The caller must do
 * the processing to check if the entry is actually deleted and can be
 * overwritten. This is foisted upon the caller rather than handled in this
 * object because there may be some latch releasing/retaking in order to
 * check a child LN.
 * Inserts the argument ChildReference into this IN.  Assumes this node is
 * already latched by the caller.
 * @param entry The ChildReference to insert into the IN.
 * @return either (1) the index of location in the IN where the entry was
 * inserted |'d with INSERT_SUCCESS, or (2) the index of the duplicate in
 * the IN |'d with EXACT_MATCH if the entry was found to be a duplicate.
 * @throws InconsistentNodeException if the node is full (it should have
 * been split earlier).
 */
  public int insertEntry1(  ChildReference entry) throws DatabaseException {
    if (nEntries >= entryTargets.length) {
      compress(null,true);
    }
    if (nEntries < entryTargets.length) {
      byte[] key=entry.getKey();
      int index=findEntry(key,true,false);
      if (index >= 0 && (index & EXACT_MATCH) != 0) {
        return index;
      }
 else {
        index++;
      }
      if (index < nEntries) {
//#if MEMORYBUDGET
        int oldSize=computeLsnOverhead();
//#endif
        shiftEntriesRight(index);
//#if MEMORYBUDGET
        changeMemorySize(computeLsnOverhead() - oldSize);
//#endif
      }
      entryTargets[index]=entry.getTarget();
      entryKeyVals[index]=entry.getKey();
      setLsnElement(index,entry.getLsn());
      entryStates[index]=entry.getState();
      nEntries++;
      adjustCursorsForInsert(index);
//#if MEMORYBUDGET
      updateMemorySize(0,getEntryInMemorySize(index));
//#endif
      setDirty(true);
      return (index | INSERT_SUCCESS);
    }
 else {
      throw new InconsistentNodeException("Node " + getNodeId() + " should have been split before calling insertEntry");
    }
  }
  /** 
 * Deletes the ChildReference with the key arg from this IN.  Assumes this
 * node is already latched by the caller.
 * This seems to only be used by INTest.
 * @param key The key of the reference to delete from the IN.
 * @param maybeValidate true if assert validation should occur prior to
 * delete.  Set this to false during recovery.
 * @return true if the entry was successfully deleted, false if it was not
 * found.
 */
  boolean deleteEntry(  byte[] key,  boolean maybeValidate) throws DatabaseException {
    if (nEntries == 0) {
      return false;
    }
    int index=findEntry(key,false,true);
    if (index < 0) {
      return false;
    }
    return deleteEntry(index,maybeValidate);
  }
  /** 
 * Deletes the ChildReference at index from this IN.  Assumes this node is
 * already latched by the caller.
 * @param index The index of the entry to delete from the IN.
 * @param maybeValidate true if asserts are enabled.
 * @return true if the entry was successfully deleted, false if it was not
 * found.
 */
  public boolean deleteEntry(  int index,  boolean maybeValidate) throws DatabaseException {
    if (nEntries == 0) {
      return false;
    }
    assert maybeValidate ? validateSubtreeBeforeDelete(index) : true;
    if (index < nEntries) {
//#if MEMORYBUDGET
      updateMemorySize(getEntryInMemorySize(index),0);
//#endif
//#if MEMORYBUDGET
      int oldLSNArraySize=computeLsnOverhead();
//#endif
      for (int i=index; i < nEntries - 1; i++) {
        setEntryInternal(i + 1,i);
      }
      clearEntry(nEntries - 1);
//#if MEMORYBUDGET
      updateMemorySize(oldLSNArraySize,computeLsnOverhead());
//#endif
      nEntries--;
      setDirty(true);
      setProhibitNextDelta();
//#if LOGGINGFINEST
      traceDelete(Level.FINEST,index);
//#endif
      return true;
    }
 else {
      return false;
    }
  }
  /** 
 * Do nothing since INs don't support deltas.
 */
  public void setProhibitNextDelta(){
  }
  public boolean compress(  BINReference binRef,  boolean canFetch) throws DatabaseException {
    return false;
  }
  public boolean isCompressible(){
    return false;
  }
  
  boolean validateSubtreeBeforeDelete(  int index) throws DatabaseException {
	  //#if LATCHES
	  boolean needToLatch=!isLatchOwner();
	  try {
		  if (needToLatch) {
			  latch();
		  }
		  if (index >= nEntries) {
			  return true;
		  }
		  else {
			  Node child=fetchTarget(index);
			  return child != null && child.isValidForDelete();
		  }
	  }
	  finally {
		  if (needToLatch) {
			  releaseLatchIfOwner();
		  }
	  }
	  //#else
	  return false; // -Marcelo (comperr owise)
	  //#endif
  }

  /** 
 * Return true if this node needs splitting.  For the moment, needing to be
 * split is defined by there being no free entries available.
 */
  public boolean needsSplitting(){
    if ((entryTargets.length - nEntries) < 1) {
      return true;
    }
 else {
      return false;
    }
  }
  /** 
 * Indicates whether whether entry 0's key is "special" in that it always
 * compares less than any other key.  BIN's don't have the special key, but
 * IN's do.
 */
  boolean entryZeroKeyComparesLow(){
    return true;
  }
  /** 
 * Split this into two nodes.  Parent IN is passed in parent and should be
 * latched by the caller.
 * childIndex is the index in parent of where "this" can be found.
 * @return lsn of the newly logged parent
 */
  void split(  IN parent,  int childIndex,  int maxEntries) throws DatabaseException {
    splitInternal(parent,childIndex,maxEntries,-1);
  }
  protected void splitInternal(  IN parent,  int childIndex,  int maxEntries,  int splitIndex) throws DatabaseException {
    if (identifierKey == null) {
      throw new InconsistentNodeException("idkey is null");
    }
    int idKeyIndex=findEntry(identifierKey,false,false);
    if (splitIndex < 0) {
      splitIndex=nEntries / 2;
    }
    int low, high;
    IN newSibling=null;
    if (idKeyIndex < splitIndex) {
      low=splitIndex;
      high=nEntries;
    }
 else {
      low=0;
      high=splitIndex;
    }
    byte[] newIdKey=entryKeyVals[low];
    long parentLsn=DbLsn.NULL_LSN;
    newSibling=createNewInstance(newIdKey,maxEntries,level);
//#if LATCHES
    newSibling.latch();
//#endif
    long oldMemorySize=inMemorySize;
//#if LATCHES
    try {
      int toIdx=0;
      boolean deletedEntrySeen=false;
      BINReference binRef=null;
      for (int i=low; i < high; i++) {
        byte[] thisKey=entryKeyVals[i];
        if (isEntryPendingDeleted(i)) {
          if (!deletedEntrySeen) {
            deletedEntrySeen=true;
            binRef=new BINReference(newSibling.getNodeId(),databaseImpl.getId(),newIdKey);
          }
          binRef.addDeletedKey(new Key(thisKey));
        }
        newSibling.setEntry(toIdx++,entryTargets[i],thisKey,getLsn(i),entryStates[i]);
        clearEntry(i);
      }
//#if INCOMPRESSOR
      if (deletedEntrySeen) 
//#if INCOMPRESSOR
{
        databaseImpl.getDbEnvironment().addToCompressorQueue(binRef,false);
      }
//#endif
//#endif
      int newSiblingNEntries=(high - low);
      if (low == 0) {
        shiftEntriesLeft(newSiblingNEntries);
      }
      newSibling.nEntries=toIdx;
      nEntries-=newSiblingNEntries;
      setDirty(true);
      adjustCursors(newSibling,low,high);
      EnvironmentImpl env=databaseImpl.getDbEnvironment();
      LogManager logManager=env.getLogManager();
      INList inMemoryINs=env.getInMemoryINs();
      long newSiblingLsn=newSibling.logProvisional(logManager,parent);
      long myNewLsn=logProvisional(logManager,parent);
      if (low == 0) {
        if (childIndex == 0) {
          parent.updateEntryCompareKey(childIndex,newSibling,newSiblingLsn,newIdKey);
        }
 else {
          parent.updateEntry(childIndex,newSibling,newSiblingLsn);
        }
        boolean insertOk=parent.insertEntry(new ChildReference(this,entryKeyVals[0],myNewLsn));
        assert insertOk;
      }
 else {
        if (childIndex == 0) {
          parent.updateEntryCompareKey(childIndex,this,myNewLsn,entryKeyVals[0]);
        }
 else {
          parent.updateEntry(childIndex,this,myNewLsn);
        }
        boolean insertOk=parent.insertEntry(new ChildReference(newSibling,newIdKey,newSiblingLsn));
        assert insertOk;
      }
      parentLsn=parent.log(logManager);
      if (parent.isRoot()) {
        parent.setDirty(true);
      }
//#if MEMORYBUDGET
      long newSize=computeMemorySize();
//#endif
//#if MEMORYBUDGET
      updateMemorySize(oldMemorySize,newSize);
//#endif
      inMemoryINs.add(newSibling);
//#if LOGGINGFINE
      traceSplit(Level.FINE,parent,newSibling,parentLsn,myNewLsn,newSiblingLsn,splitIndex,idKeyIndex,childIndex);
//#endif
    }
  finally {
      newSibling.releaseLatch();
    }
//#endif
  }
  /** 
 * Called when we know we are about to split on behalf of a key that is the
 * minimum (leftSide) or maximum (!leftSide) of this node.  This is
 * achieved by just forcing the split to occur either one element in from
 * the left or the right (i.e. splitIndex is 1 or nEntries - 1).
 */
  void splitSpecial(  IN parent,  int parentIndex,  int maxEntriesPerNode,  byte[] key,  boolean leftSide) throws DatabaseException {
    int index=findEntry(key,false,false);
    if (leftSide && index == 0) {
      splitInternal(parent,parentIndex,maxEntriesPerNode,1);
    }
 else     if (!leftSide && index == (nEntries - 1)) {
      splitInternal(parent,parentIndex,maxEntriesPerNode,nEntries - 1);
    }
 else {
      split(parent,parentIndex,maxEntriesPerNode);
    }
  }
  void adjustCursors(  IN newSibling,  int newSiblingLow,  int newSiblingHigh){
  }
  void adjustCursorsForInsert(  int insertIndex){
  }
  /** 
 * Return the relevant user defined comparison function for this type of
 * node.  For IN's and BIN's, this is the BTree Comparison function.
 */
  public Comparator getKeyComparator(){
    return databaseImpl.getBtreeComparator();
  }
  /** 
 * Shift entries to the right starting with (and including) the entry at
 * index. Caller is responsible for incrementing nEntries.
 * @param index - The position to start shifting from.
 */
  private void shiftEntriesRight(  int index){
    for (int i=nEntries; i > index; i--) {
      setEntryInternal(i - 1,i);
    }
    clearEntry(index);
    setDirty(true);
  }
  /** 
 * Shift entries starting at the byHowMuch'th element to the left, thus
 * removing the first byHowMuch'th elements of the entries array.  This
 * always starts at the 0th entry.  Caller is responsible for decrementing
 * nEntries.
 * @param byHowMuch - The number of entries to remove from the left side
 * of the entries array.
 */
  private void shiftEntriesLeft(  int byHowMuch){
    for (int i=0; i < nEntries - byHowMuch; i++) {
      setEntryInternal(i + byHowMuch,i);
    }
    for (int i=nEntries - byHowMuch; i < nEntries; i++) {
      clearEntry(i);
    }
    setDirty(true);
  }
  /** 
 * Check that the IN is in a valid state.  For now, validity means that the
 * keys are in sorted order and that there are more than 0 entries.
 * maxKey, if non-null specifies that all keys in this node must be less
 * than maxKey.
 */
  public void verify(  byte[] maxKey) throws DatabaseException {
//#if LATCHES
    boolean unlatchThis=false;
//#endif
    try {
//#if LATCHES
      if (!isLatchOwner()) 
//#if LATCHES
{
        latch();
        unlatchThis=true;
      }
//#endif
//#endif
      Comparator userCompareToFcn=(databaseImpl == null ? null : getKeyComparator());
      byte[] key1=null;
      for (int i=1; i < nEntries; i++) {
        key1=entryKeyVals[i];
        byte[] key2=entryKeyVals[i - 1];
        int s=Key.compareKeys(key1,key2,userCompareToFcn);
        if (s <= 0) {
          throw new InconsistentNodeException("IN " + getNodeId() + " key "+ (i - 1)+ " ("+ Key.dumpString(key2,0)+ ") and "+ i+ " ("+ Key.dumpString(key1,0)+ ") are out of order");
        }
      }
      boolean inconsistent=false;
      if (maxKey != null && key1 != null) {
        if (Key.compareKeys(key1,maxKey,userCompareToFcn) >= 0) {
          inconsistent=true;
        }
      }
      if (inconsistent) {
        throw new InconsistentNodeException("IN " + getNodeId() + " has entry larger than next entry in parent.");
      }
    }
 catch (    DatabaseException DE) {
      DE.printStackTrace(System.out);
    }
 finally {
//#if LATCHES
      if (unlatchThis) 
//#if LATCHES
{
        releaseLatch();
      }
//#endif
//#endif
    }
  }
  /** 
 * Add self and children to this in-memory IN list. Called by recovery, can
 * run with no latching.
 */
  void rebuildINList(  INList inList) throws DatabaseException {
//#if MEMORYBUDGET
    initMemorySize();
//#endif
    inList.add(this);
    for (int i=0; i < nEntries; i++) {
      Node n=getTarget(i);
      if (n != null) {
        n.rebuildINList(inList);
      }
    }
  }
  /** 
 * Remove self and children from the in-memory IN list. The INList latch is
 * already held before this is called.  Also count removed nodes as
 * obsolete.
 */
  void accountForSubtreeRemoval(  INList inList
//#if CLEANER
  , UtilizationTracker tracker
//#endif
) throws DatabaseException {
    if (nEntries > 1) {
      throw new DatabaseException("Found non-deletable IN " + getNodeId() + " while flushing INList. nEntries = "+ nEntries);
    }
    inList.removeLatchAlreadyHeld(this);
//#if CLEANER
    if (lastFullVersion != DbLsn.NULL_LSN) 
//#if CLEANER
{
      tracker.countObsoleteNode(lastFullVersion,getLogType());
    }
//#endif
//#endif
    for (int i=0; i < nEntries; i++) {
      Node n=fetchTarget(i);
      if (n != null) {
        n.accountForSubtreeRemoval(inList
//#if CLEANER
, tracker
//#endif
);
      }
    }
  }
  /** 
 * Check if this node fits the qualifications for being part of a deletable
 * subtree. It can only have one IN child and no LN children.
 */
  boolean isValidForDelete() throws DatabaseException {
	//#if LATCHES
	  boolean needToLatch=!isLatchOwner();
	  try {
		  if (needToLatch) 
		  {
			  latch();
		  }
		  if (nEntries > 1) {
			  return false;
		  }
		  else       if (nEntries == 1) {
			  Node child=fetchTarget(0);
			  return child != null && child.isValidForDelete();
		  }
		  else {
			  return true;
		  }
	  }
	  finally {
		  if (needToLatch) {
			  releaseLatchIfOwner();
		  }
	  }
	//#else
	  return false; // -Marcelo and Sabrina (comperr owise)
	//#endif
  }
  /** 
 * See if you are the parent of this child. If not, find a child of your's
 * that may be the parent, and return it. If there are no possiblities,
 * return null. Note that the keys of the target are passed in so we don't
 * have to latch the target to look at them. Also, this node is latched
 * upon entry.
 * @param doFetch If true, fetch the child in the pursuit of this search.
 * If false, give up if the child is not resident. In that case, we have
 * a potential ancestor, but are not sure if this is the parent.
 */
  void findParent(  Tree.SearchType searchType,  long targetNodeId,  boolean targetContainsDuplicates,  boolean targetIsRoot,  byte[] targetMainTreeKey,  byte[] targetDupTreeKey,  SearchResult result,  boolean requireExactMatch,  boolean updateGeneration,  int targetLevel,  List trackingList,  boolean doFetch) throws DatabaseException {
//#if LATCHES
    assert isLatchOwner();
//#endif
    if (getNodeId() == targetNodeId) {
//#if LATCHES
      releaseLatch();
//#endif
      result.exactParentFound=false;
      result.keepSearching=false;
      result.parent=null;
      return;
    }
    if (getNEntries() == 0) {
      result.keepSearching=false;
      result.exactParentFound=false;
      if (requireExactMatch) {
//#if LATCHES
        releaseLatch();
//#endif
        result.parent=null;
      }
 else {
        result.parent=this;
        result.index=-1;
      }
      return;
    }
 else {
      if (searchType == Tree.SearchType.NORMAL) {
        result.index=findEntry(selectKey(targetMainTreeKey,targetDupTreeKey),false,false);
      }
 else       if (searchType == Tree.SearchType.LEFT) {
        result.index=0;
      }
 else       if (searchType == Tree.SearchType.RIGHT) {
        result.index=nEntries - 1;
      }
 else {
        throw new IllegalArgumentException("Invalid value of searchType: " + searchType);
      }
      if (result.index < 0) {
        result.keepSearching=false;
        result.exactParentFound=false;
        if (requireExactMatch) {
//#if LATCHES
          releaseLatch();
//#endif
          result.parent=null;
        }
 else {
          result.parent=this;
        }
        return;
      }
      Node child=null;
      boolean isDeleted=false;
      if (isEntryKnownDeleted(result.index)) {
        isDeleted=true;
      }
 else       if (doFetch) {
        child=fetchTarget(result.index);
        if (child == null) {
          isDeleted=true;
        }
      }
 else {
        child=getTarget(result.index);
      }
      if (isDeleted) {
        result.exactParentFound=false;
        result.keepSearching=false;
        if (requireExactMatch) {
          result.parent=null;
//#if LATCHES
          releaseLatch();
//#endif
        }
 else {
          result.parent=this;
        }
        return;
      }
      if (targetLevel >= 0 && level == targetLevel + 1) {
        result.exactParentFound=true;
        result.parent=this;
        result.keepSearching=false;
        return;
      }
      if (child == null) {
        assert !doFetch;
        result.keepSearching=false;
        result.exactParentFound=false;
        result.parent=this;
        result.childNotResident=true;
        return;
      }
      long childLsn=getLsn(result.index);
      if (child.isSoughtNode(targetNodeId,updateGeneration)) {
        result.exactParentFound=true;
        result.parent=this;
        result.keepSearching=false;
        return;
      }
 else {
        descendOnParentSearch(result,targetContainsDuplicates,targetIsRoot,targetNodeId,child,requireExactMatch);
        if (trackingList != null) {
          if ((result.parent != this) && (result.parent != null)) {
            trackingList.add(new TrackingInfo(childLsn,child.getNodeId()));
          }
        }
        return;
      }
    }
  }
  protected void descendOnParentSearch(  SearchResult result,  boolean targetContainsDuplicates,  boolean targetIsRoot,  long targetNodeId,  Node child,  boolean requireExactMatch) throws DatabaseException {
    if (child.canBeAncestor(targetContainsDuplicates)) {
//#if LATCHES
      releaseLatch();
//#endif
      result.parent=(IN)child;
    }
 else {
//#if LATCHES
      ((IN)child).releaseLatch();
//#endif
      result.exactParentFound=false;
      result.keepSearching=false;
      if (requireExactMatch) {
//#if LATCHES
        releaseLatch();
//#endif
        result.parent=null;
      }
 else {
        result.parent=this;
      }
    }
  }
  protected boolean isSoughtNode(  long nid,  boolean updateGeneration) throws DatabaseException {
    latch(updateGeneration);
    if (getNodeId() == nid) {
//#if LATCHES
      releaseLatch();
//#endif
      return true;
    }
 else {
      return false;
    }
  }
  protected boolean canBeAncestor(  boolean targetContainsDuplicates){
    return true;
  }
//#if EVICTOR
  /** 
 * Returns whether this node can itself be evicted.  This is faster than
 * (getEvictionType() == MAY_EVICT_NODE) and is used by the evictor after
 * a node has been selected, to check that it is still evictable.
 */
  public boolean isEvictable(){
    if (isEvictionProhibited()) {
      return false;
    }
    if (hasNonLNChildren()) {
      return false;
    }
    return true;
  }
//#endif
//#if EVICTOR
  /** 
 * Returns the eviction type for this IN, for use by the evictor.  Uses the
 * internal isEvictionProhibited and getChildEvictionType methods that may
 * be overridden by subclasses.
 * @return MAY_EVICT_LNS if evictable LNs may be stripped; otherwise,
 * MAY_EVICT_NODE if the node itself may be evicted; otherwise,
 * MAY_NOT_EVICT.
 */
  public int getEvictionType(){
    if (isEvictionProhibited()) {
      return MAY_NOT_EVICT;
    }
 else {
      return getChildEvictionType();
    }
  }
//#endif
//#if EVICTOR
  /** 
 * Returns whether the node is not evictable, irrespective of the status
 * of the children nodes.
 */
  boolean isEvictionProhibited(){
    return isDbRoot();
  }
//#endif
  /** 
 * Returns whether any resident children are not LNs (are INs).
 */
  boolean hasNonLNChildren(){
    return hasResidentChildren();
  }
//#if EVICTOR
  /** 
 * Returns the eviction type based on the status of child nodes,
 * irrespective of isEvictionProhibited.
 */
  int getChildEvictionType(){
    return hasResidentChildren() ? MAY_NOT_EVICT : MAY_EVICT_NODE;
  }
//#endif
  /** 
 * Returns whether any child is non-null.
 */
  private boolean hasResidentChildren(){
    for (int i=0; i < getNEntries(); i++) {
      if (getTarget(i) != null) {
        return true;
      }
    }
    return false;
  }
  void accumulateStats(  TreeWalkerStatsAccumulator acc){
    acc.processIN(this,new Long(getNodeId()),getLevel());
  }
  /** 
 * Log this IN and clear the dirty flag.
 */
  public long log(  LogManager logManager) throws DatabaseException {
    return logInternal(logManager,false,false,false,null);
  }
  /** 
 * Log this IN and clear the dirty flag.
 */
  public long log(  LogManager logManager,  boolean allowDeltas,  boolean proactiveMigration) throws DatabaseException {
    return logInternal(logManager,allowDeltas,false,proactiveMigration,null);
  }
  /** 
 * Log this node provisionally and clear the dirty flag.
 * @param item object to be logged
 * @return LSN of the new log entry
 */
  public long logProvisional(  LogManager logManager,  IN parent) throws DatabaseException {
    return logInternal(logManager,false,true,false,parent);
  }
  /** 
 * Log this node with all available options.
 */
  public long log(  LogManager logManager,  boolean allowDeltas,  boolean isProvisional,  boolean proactiveMigration,  IN parent) throws DatabaseException {
    return logInternal(logManager,allowDeltas,isProvisional,proactiveMigration,parent);
  }
  /** 
 * Decide how to log this node. INs are always logged in full.  Migration
 * never performed since it only applies to BINs.
 */
  protected long logInternal(  LogManager logManager,  boolean allowDeltas,  boolean isProvisional,  boolean proactiveMigration,  IN parent) throws DatabaseException {
    long lsn=logManager.log(new INLogEntry(this),isProvisional,isProvisional ? DbLsn.NULL_LSN : lastFullVersion);
    if (isProvisional) {
      if (parent != null) {
        parent.trackProvisionalObsolete(this,lastFullVersion,DbLsn.NULL_LSN);
      }
    }
 else {
      flushProvisionalObsolete(logManager);
    }
    setLastFullLsn(lsn);
    setDirty(false);
    return lsn;
  }
  /** 
 * Adds the given obsolete LSNs and any tracked obsolete LSNs for the given
 * child IN to this IN's tracking list.  This method is called to track
 * obsolete LSNs when a child IN is logged provisionally.  Such LSNs cannot
 * be considered obsolete until an ancestor IN is logged non-provisionally.
 */
  void trackProvisionalObsolete(  IN child,  long obsoleteLsn1,  long obsoleteLsn2){
    int memDelta=0;
    if (child.provisionalObsolete != null) {
//#if MEMORYBUDGET
      int childMemDelta=child.provisionalObsolete.size() * MemoryBudget.LONG_LIST_PER_ITEM_OVERHEAD;
//#endif
      if (provisionalObsolete != null) {
        provisionalObsolete.addAll(child.provisionalObsolete);
      }
 else {
        provisionalObsolete=child.provisionalObsolete;
      }
      child.provisionalObsolete=null;
//#if MEMORYBUDGET
      child.changeMemorySize(0 - childMemDelta);
//#endif
//#if MEMORYBUDGET
      memDelta+=childMemDelta;
//#endif
    }
    if (obsoleteLsn1 != DbLsn.NULL_LSN || obsoleteLsn2 != DbLsn.NULL_LSN) {
      if (provisionalObsolete == null) {
        provisionalObsolete=new ArrayList();
      }
      if (obsoleteLsn1 != DbLsn.NULL_LSN) {
        provisionalObsolete.add(new Long(obsoleteLsn1));
//#if MEMORYBUDGET
        memDelta+=MemoryBudget.LONG_LIST_PER_ITEM_OVERHEAD;
//#endif
      }
      if (obsoleteLsn2 != DbLsn.NULL_LSN) {
        provisionalObsolete.add(new Long(obsoleteLsn2));
//#if MEMORYBUDGET
        memDelta+=MemoryBudget.LONG_LIST_PER_ITEM_OVERHEAD;
//#endif
      }
    }
//#if MEMORYBUDGET
    if (memDelta != 0) 
//#if MEMORYBUDGET
{
      changeMemorySize(memDelta);
    }
//#endif
//#endif
  }
  /** 
 * Adds the provisional obsolete tracking information in this node to the
 * live tracker.  This method is called when this node is logged
 * non-provisionally.
 */
  void flushProvisionalObsolete(  LogManager logManager) throws DatabaseException {
    if (provisionalObsolete != null) {
//#if MEMORYBUDGET
      int memDelta=provisionalObsolete.size() * MemoryBudget.LONG_LIST_PER_ITEM_OVERHEAD;
//#endif
//#if CLEANER
      logManager.countObsoleteINs(provisionalObsolete);
//#endif
      provisionalObsolete=null;
//#if MEMORYBUDGET
      changeMemorySize(0 - memDelta);
//#endif
    }
  }
  /** 
 * @see LoggableObject#getLogType
 */
  public LogEntryType getLogType(){
    return LogEntryType.LOG_IN;
  }
  /** 
 * @see LoggableObject#getLogSize
 */
  public int getLogSize(){
    int size=super.getLogSize();
    size+=LogUtils.getByteArrayLogSize(identifierKey);
    size+=LogUtils.getBooleanLogSize();
    size+=LogUtils.INT_BYTES;
    size+=LogUtils.INT_BYTES;
    size+=LogUtils.INT_BYTES;
    size+=LogUtils.getBooleanLogSize();
    boolean compactLsnsRep=(entryLsnLongArray == null);
    if (compactLsnsRep) {
      size+=LogUtils.INT_BYTES;
    }
    for (int i=0; i < nEntries; i++) {
      size+=LogUtils.getByteArrayLogSize(entryKeyVals[i]) + (compactLsnsRep ? LogUtils.INT_BYTES : LogUtils.getLongLogSize()) + 1;
    }
    return size;
  }
  /** 
 * @see LoggableObject#writeToLog
 */
  public void writeToLog(  ByteBuffer logBuffer){
    super.writeToLog(logBuffer);
    LogUtils.writeByteArray(logBuffer,identifierKey);
    LogUtils.writeBoolean(logBuffer,isRoot);
    LogUtils.writeInt(logBuffer,nEntries);
    LogUtils.writeInt(logBuffer,level);
    LogUtils.writeInt(logBuffer,entryTargets.length);
    boolean compactLsnsRep=(entryLsnLongArray == null);
    LogUtils.writeBoolean(logBuffer,compactLsnsRep);
    if (compactLsnsRep) {
      LogUtils.writeInt(logBuffer,(int)baseFileNumber);
    }
    for (int i=0; i < nEntries; i++) {
      LogUtils.writeByteArray(logBuffer,entryKeyVals[i]);
      assert !(getLsn(i) == DbLsn.NULL_LSN && (entryStates[i] & KNOWN_DELETED_BIT) == 0);
      if (compactLsnsRep) {
        int offset=i << 2;
        int fileOffset=getFileOffset(offset);
        logBuffer.put(getFileNumberOffset(offset));
        logBuffer.put((byte)((fileOffset >>> 0) & 0xff));
        logBuffer.put((byte)((fileOffset >>> 8) & 0xff));
        logBuffer.put((byte)((fileOffset >>> 16) & 0xff));
      }
 else {
        LogUtils.writeLong(logBuffer,entryLsnLongArray[i]);
      }
      logBuffer.put(entryStates[i]);
      entryStates[i]&=CLEAR_DIRTY_BIT;
    }
  }
  /** 
 * @see LogReadable#readFromLog
 */
  public void readFromLog(  ByteBuffer itemBuffer,  byte entryTypeVersion) throws LogException {
    super.readFromLog(itemBuffer,entryTypeVersion);
    identifierKey=LogUtils.readByteArray(itemBuffer);
    isRoot=LogUtils.readBoolean(itemBuffer);
    nEntries=LogUtils.readInt(itemBuffer);
    level=LogUtils.readInt(itemBuffer);
    int length=LogUtils.readInt(itemBuffer);
    entryTargets=new Node[length];
    entryKeyVals=new byte[length][];
    baseFileNumber=-1;
    long storedBaseFileNumber=-1;
    entryLsnByteArray=new byte[length << 2];
    entryLsnLongArray=null;
    entryStates=new byte[length];
    boolean compactLsnsRep=false;
    if (entryTypeVersion > 1) {
      compactLsnsRep=LogUtils.readBoolean(itemBuffer);
      if (compactLsnsRep) {
        baseFileNumber=LogUtils.readInt(itemBuffer) & 0xffffffff;
        storedBaseFileNumber=baseFileNumber;
      }
    }
    for (int i=0; i < nEntries; i++) {
      entryKeyVals[i]=LogUtils.readByteArray(itemBuffer);
      long lsn;
      if (compactLsnsRep) {
        byte fileNumberOffset=itemBuffer.get();
        int fileOffset=(itemBuffer.get() & 0xff);
        fileOffset|=((itemBuffer.get() & 0xff) << 8);
        fileOffset|=((itemBuffer.get() & 0xff) << 16);
        if (fileOffset == THREE_BYTE_NEGATIVE_ONE) {
          lsn=DbLsn.NULL_LSN;
        }
 else {
          lsn=DbLsn.makeLsn(storedBaseFileNumber + fileNumberOffset,fileOffset);
        }
      }
 else {
        lsn=LogUtils.readLong(itemBuffer);
      }
      setLsnElement(i,lsn);
      byte entryState=itemBuffer.get();
      entryState&=CLEAR_DIRTY_BIT;
      entryState&=CLEAR_MIGRATE_BIT;
      if (lsn == DbLsn.NULL_LSN) {
        entryState|=KNOWN_DELETED_BIT;
      }
      entryStates[i]=entryState;
    }
//#if LATCHES
    latch.setName(shortClassName() + getNodeId());
//#endif
  }
  /** 
 * @see LogReadable#dumpLog
 */
  public void dumpLog(  StringBuffer sb,  boolean verbose){
    sb.append(beginTag());
    super.dumpLog(sb,verbose);
    sb.append(Key.dumpString(identifierKey,0));
    sb.append("<isRoot val=\"");
    sb.append(isRoot);
    sb.append("\"/>");
    sb.append("<level val=\"");
    sb.append(Integer.toHexString(level));
    sb.append("\"/>");
    sb.append("<entries numEntries=\"");
    sb.append(nEntries);
    sb.append("\" length=\"");
    sb.append(entryTargets.length);
    boolean compactLsnsRep=(entryLsnLongArray == null);
    if (compactLsnsRep) {
      sb.append("\" baseFileNumber=\"");
      sb.append(baseFileNumber);
    }
    sb.append("\">");
    if (verbose) {
      for (int i=0; i < nEntries; i++) {
        sb.append("<ref knownDeleted=\"").append(isEntryKnownDeleted(i));
        sb.append("\" pendingDeleted=\"").append(isEntryPendingDeleted(i));
        sb.append("\">");
        sb.append(Key.dumpString(entryKeyVals[i],0));
        sb.append(DbLsn.toString(getLsn(i)));
        sb.append("</ref>");
      }
    }
    sb.append("</entries>");
    dumpLogAdditional(sb);
    sb.append(endTag());
  }
  /** 
 * @see LogReadable#logEntryIsTransactional.
 */
  public boolean logEntryIsTransactional(){
    return false;
  }
  /** 
 * @see LogReadable#getTransactionId
 */
  public long getTransactionId(){
    return 0;
  }
  /** 
 * Allows subclasses to add additional fields before the end tag. If they
 * just overload dumpLog, the xml isn't nested.
 */
  protected void dumpLogAdditional(  StringBuffer sb){
  }
  public String beginTag(){
    return BEGIN_TAG;
  }
  public String endTag(){
    return END_TAG;
  }
  void dumpKeys() throws DatabaseException {
    for (int i=0; i < nEntries; i++) {
      System.out.println(Key.dumpString(entryKeyVals[i],0));
    }
  }
  /** 
 * For unit test support:
 * @return a string that dumps information about this IN, without
 */
  public String dumpString(  int nSpaces,  boolean dumpTags){
    StringBuffer sb=new StringBuffer();
    if (dumpTags) {
      sb.append(TreeUtils.indent(nSpaces));
      sb.append(beginTag());
      sb.append('\n');
    }
    sb.append(super.dumpString(nSpaces + 2,true));
    sb.append('\n');
    sb.append(TreeUtils.indent(nSpaces + 2));
    sb.append("<idkey>");
    sb.append(identifierKey == null ? "" : Key.dumpString(identifierKey,0));
    sb.append("</idkey>");
    sb.append('\n');
    sb.append(TreeUtils.indent(nSpaces + 2));
    sb.append("<dirty val=\"").append(dirty).append("\"/>");
    sb.append('\n');
    sb.append(TreeUtils.indent(nSpaces + 2));
    sb.append("<generation val=\"").append(generation).append("\"/>");
    sb.append('\n');
    sb.append(TreeUtils.indent(nSpaces + 2));
    sb.append("<level val=\"");
    sb.append(Integer.toHexString(level)).append("\"/>");
    sb.append('\n');
    sb.append(TreeUtils.indent(nSpaces + 2));
    sb.append("<isRoot val=\"").append(isRoot).append("\"/>");
    sb.append('\n');
    sb.append(TreeUtils.indent(nSpaces + 2));
    sb.append("<entries nEntries=\"");
    sb.append(nEntries);
    sb.append("\">");
    sb.append('\n');
    for (int i=0; i < nEntries; i++) {
      sb.append(TreeUtils.indent(nSpaces + 4));
      sb.append("<entry id=\"" + i + "\">");
      sb.append('\n');
      if (getLsn(i) == DbLsn.NULL_LSN) {
        sb.append(TreeUtils.indent(nSpaces + 6));
        sb.append("<lsn/>");
      }
 else {
        sb.append(DbLsn.dumpString(getLsn(i),nSpaces + 6));
      }
      sb.append('\n');
      if (entryKeyVals[i] == null) {
        sb.append(TreeUtils.indent(nSpaces + 6));
        sb.append("<key/>");
      }
 else {
        sb.append(Key.dumpString(entryKeyVals[i],(nSpaces + 6)));
      }
      sb.append('\n');
      if (entryTargets[i] == null) {
        sb.append(TreeUtils.indent(nSpaces + 6));
        sb.append("<target/>");
      }
 else {
        sb.append(entryTargets[i].dumpString(nSpaces + 6,true));
      }
      sb.append('\n');
      sb.append(TreeUtils.indent(nSpaces + 6));
      dumpDeletedState(sb,getState(i));
      sb.append("<dirty val=\"").append(isDirty(i)).append("\"/>");
      sb.append('\n');
      sb.append(TreeUtils.indent(nSpaces + 4));
      sb.append("</entry>");
      sb.append('\n');
    }
    sb.append(TreeUtils.indent(nSpaces + 2));
    sb.append("</entries>");
    sb.append('\n');
    if (dumpTags) {
      sb.append(TreeUtils.indent(nSpaces));
      sb.append(endTag());
    }
    return sb.toString();
  }
  /** 
 * Utility method for output of knownDeleted and pendingDelete.
 */
  static void dumpDeletedState(  StringBuffer sb,  byte state){
    sb.append("<knownDeleted val=\"");
    sb.append(isStateKnownDeleted(state)).append("\"/>");
    sb.append("<pendingDeleted val=\"");
    sb.append(isStatePendingDeleted(state)).append("\"/>");
  }
  public String toString(){
    return dumpString(0,true);
  }
  public String shortClassName(){
    return "IN";
  }
//#if LOGGINGFINE
  /** 
 * Send trace messages to the java.util.logger. Don't rely on the logger
 * alone to conditionalize whether we send this message, we don't even want
 * to construct the message if the level is not enabled.
 */
  private void traceSplit(  Level level,  IN parent,  IN newSibling,  long parentLsn,  long myNewLsn,  long newSiblingLsn,  int splitIndex,  int idKeyIndex,  int childIndex){
//#if LOGGINGBASE
    Logger logger=databaseImpl.getDbEnvironment().getLogger();
//#endif
//#if LOGGINGBASE
    if (logger.isLoggable(level)) 
//#if LOGGINGBASE
{
      StringBuffer sb=new StringBuffer();
      sb.append(TRACE_SPLIT);
      sb.append(" parent=");
      sb.append(parent.getNodeId());
      sb.append(" child=");
      sb.append(getNodeId());
      sb.append(" newSibling=");
      sb.append(newSibling.getNodeId());
      sb.append(" parentLsn = ");
      sb.append(DbLsn.getNoFormatString(parentLsn));
      sb.append(" childLsn = ");
      sb.append(DbLsn.getNoFormatString(myNewLsn));
      sb.append(" newSiblingLsn = ");
      sb.append(DbLsn.getNoFormatString(newSiblingLsn));
      sb.append(" splitIdx=");
      sb.append(splitIndex);
      sb.append(" idKeyIdx=");
      sb.append(idKeyIndex);
      sb.append(" childIdx=");
      sb.append(childIndex);
      logger.log(level,sb.toString());
    }
//#endif
//#endif
  }
//#endif
//#if LOGGINGFINEST
  /** 
 * Send trace messages to the java.util.logger. Don't rely on the logger
 * alone to conditionalize whether we send this message, we don't even want
 * to construct the message if the level is not enabled.
 */
  
//#if LOGGINGFINEST
private
//#endif
 
//#if LOGGINGFINEST
void
//#endif
 
//#if LOGGINGFINEST
traceDelete
//#endif
(
//#if LOGGINGFINEST
  Level level
//#endif
,
//#if LOGGINGFINEST
  int index
//#endif
)
//#if LOGGINGFINEST
{
//#if LOGGINGBASE
    Logger logger=databaseImpl.getDbEnvironment().getLogger();
//#endif
//#if LOGGINGBASE
    if (logger.isLoggable(level)) 
//#if LOGGINGBASE
{
      StringBuffer sb=new StringBuffer();
      sb.append(TRACE_DELETE);
      sb.append(" in=").append(getNodeId());
      sb.append(" index=");
      sb.append(index);
      logger.log(level,sb.toString());
    }
//#endif
//#endif
  }
//#endif
//#endif
}
