package com.sleepycat.je.dbi;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.LockStats;
//#endif
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.RunRecoveryException;
//#if LATCHES
import com.sleepycat.je.latch.LatchNotHeldException;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.BINBoundary;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.ThreadLocker;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;
/** 
 * A CursorImpl is the internal implementation of the cursor.
 */
public class CursorImpl implements Cloneable {
//#if VERIFIER
  private static final boolean DEBUG=false;
//#endif
  private static final byte CURSOR_NOT_INITIALIZED=1;
  private static final byte CURSOR_INITIALIZED=2;
  private static final byte CURSOR_CLOSED=3;
  private static final String TRACE_DELETE="Delete";
  private static final String TRACE_MOD="Mod:";
  volatile private BIN bin;
  volatile private int index;
  volatile private DBIN dupBin;
  volatile private int dupIndex;
  volatile private BIN binToBeRemoved;
  volatile private DBIN dupBinToBeRemoved;
  private BIN targetBin;
  private int targetIndex;
  private byte[] dupKey;
  private DatabaseImpl database;
  private Locker locker;
  private CursorImpl lockerPrev;
  private CursorImpl lockerNext;
  private boolean retainNonTxnLocks;
  private byte status;
//#if EVICTOR
  private boolean allowEviction=true;
//#endif
  private TestHook testHook;
  private boolean nonCloning=false;
  private int thisId;
  private static long lastAllocatedId=0;
  private ThreadLocal treeStatsAccumulatorTL=new ThreadLocal();
  private static long getNextCursorId(){
    return ++lastAllocatedId;
  }
  public int hashCode(){
    return thisId;
  }
  private TreeWalkerStatsAccumulator getTreeStatsAccumulator(){
    if (EnvironmentImpl.getThreadLocalReferenceCount() > 0) {
      return (TreeWalkerStatsAccumulator)treeStatsAccumulatorTL.get();
    }
 else {
      return null;
    }
  }
  public void incrementLNCount(){
    TreeWalkerStatsAccumulator treeStatsAccumulator=getTreeStatsAccumulator();
    if (treeStatsAccumulator != null) {
      treeStatsAccumulator.incrementLNCount();
    }
  }
  public void setNonCloning(  boolean nonCloning){
    this.nonCloning=nonCloning;
  }
  /** 
 * public for Cursor et al
 */
public static class SearchMode {
    public static final SearchMode SET=new SearchMode(true,false,"SET");
    public static final SearchMode BOTH=new SearchMode(true,true,"BOTH");
    public static final SearchMode SET_RANGE=new SearchMode(false,false,"SET_RANGE");
    public static final SearchMode BOTH_RANGE=new SearchMode(false,true,"BOTH_RANGE");
    private boolean exactSearch;
    private boolean dataSearch;
    private String name;
    private SearchMode(    boolean exactSearch,    boolean dataSearch,    String name){
      this.exactSearch=exactSearch;
      this.dataSearch=dataSearch;
      this.name="SearchMode." + name;
    }
    /** 
 * Returns true when the key or key/data search is exact, i.e., for SET
 * and BOTH.
 */
    public final boolean isExactSearch(){
      return exactSearch;
    }
    /** 
 * Returns true when the data value is included in the search, i.e.,
 * for BOTH and BOTH_RANGE.
 */
    public final boolean isDataSearch(){
      return dataSearch;
    }
    public String toString(){
      return name;
    }
  }
  /** 
 * Holder for an OperationStatus and a keyChange flag.  Is used for search
 * and getNextWithKeyChangeStatus operations.
 */
public static class KeyChangeStatus {
    /** 
 * Operation status;
 */
    public OperationStatus status;
    /** 
 * Whether the operation moved to a new key.
 */
    public boolean keyChange;
    public KeyChangeStatus(    OperationStatus status,    boolean keyChange){
      this.status=status;
      this.keyChange=keyChange;
    }
  }
  /** 
 * Creates a cursor with retainNonTxnLocks=true.
 */
  public CursorImpl(  DatabaseImpl database,  Locker locker) throws DatabaseException {
    this(database,locker,true);
  }
  /** 
 * Creates a cursor.
 * @param retainNonTxnLocks is true if non-transactional locks should be
 * retained (not released automatically) when the cursor is closed.
 */
  public CursorImpl(  DatabaseImpl database,  Locker locker,  boolean retainNonTxnLocks) throws DatabaseException {
    thisId=(int)getNextCursorId();
    bin=null;
    index=-1;
    dupBin=null;
    dupIndex=-1;
    assert !(retainNonTxnLocks && (locker instanceof ThreadLocker));
    assert !(!retainNonTxnLocks && locker.getClass() == BasicLocker.class);
    this.retainNonTxnLocks=retainNonTxnLocks;
    this.database=database;
    this.locker=locker;
    this.locker.registerCursor(this);
    status=CURSOR_NOT_INITIALIZED;
  }
//#if EVICTOR
  /** 
 * Disables or enables eviction during cursor operations for an internal
 * cursor.  For example, a cursor used to implement eviction should not
 * itself perform eviction.  Eviction is enabled by default.
 */
  public void setAllowEviction(  boolean allowed){
    allowEviction=allowed;
  }
//#endif
  /** 
 * Shallow copy.  addCursor() is optionally called.
 */
  public CursorImpl cloneCursor(  boolean addCursor) throws DatabaseException {
    return cloneCursor(addCursor,null);
  }
  /** 
 * Shallow copy.  addCursor() is optionally called.  Allows inheriting the
 * BIN position from some other cursor.
 */
  public CursorImpl cloneCursor(  boolean addCursor,  CursorImpl usePosition) throws DatabaseException {
    CursorImpl ret=null;
    if (nonCloning) {
      ret=this;
    }
 else {
      try {
//#if LATCHES
        latchBINs();
//#endif
        ret=(CursorImpl)super.clone();
        if (!retainNonTxnLocks) {
          ret.locker=locker.newNonTxnLocker();
        }
        ret.locker.registerCursor(ret);
        if (usePosition != null && usePosition.status == CURSOR_INITIALIZED) {
          ret.bin=usePosition.bin;
          ret.index=usePosition.index;
          ret.dupBin=usePosition.dupBin;
          ret.dupIndex=usePosition.dupIndex;
        }
        if (addCursor) {
          ret.addCursor();
        }
      }
 catch (      CloneNotSupportedException cannotOccur) {
        return null;
      }
 finally {
//#if LATCHES
        releaseBINs();
//#endif
      }
    }
//#if EVICTOR
    if (allowEviction) 
//#if EVICTOR
{
//#if CRITICALEVICTION
//#if EVICTOR
      database.getDbEnvironment().getEvictor().doCriticalEviction();
//#endif
//#endif
    }
//#endif
//#endif
    return ret;
  }
  public int getIndex(){
    return index;
  }
  public void setIndex(  int idx){
    index=idx;
  }
  public BIN getBIN(){
    return bin;
  }
  public void setBIN(  BIN newBin){
    bin=newBin;
  }
  public BIN getBINToBeRemoved(){
    return binToBeRemoved;
  }
  public int getDupIndex(){
    return dupIndex;
  }
  public void setDupIndex(  int dupIdx){
    dupIndex=dupIdx;
  }
  public DBIN getDupBIN(){
    return dupBin;
  }
  public void setDupBIN(  DBIN newDupBin){
    dupBin=newDupBin;
  }
  public DBIN getDupBINToBeRemoved(){
    return dupBinToBeRemoved;
  }
  public void setTreeStatsAccumulator(  TreeWalkerStatsAccumulator tSA){
    treeStatsAccumulatorTL.set(tSA);
  }
  /** 
 * Figure out which BIN/index set to use.
 */
  private boolean setTargetBin(){
    targetBin=null;
    targetIndex=0;
    boolean isDup=(dupBin != null);
    dupKey=null;
    if (isDup) {
      targetBin=dupBin;
      targetIndex=dupIndex;
      dupKey=dupBin.getDupKey();
    }
 else {
      targetBin=bin;
      targetIndex=index;
    }
    return isDup;
  }
  /** 
 * Advance a cursor.  Used so that verify can advance a cursor even in the
 * face of an exception [12932].
 * @param key on return contains the key if available, or null.
 * @param data on return contains the data if available, or null.
 */
  public boolean advanceCursor(  DatabaseEntry key,  DatabaseEntry data){
    BIN oldBin=bin;
    BIN oldDupBin=dupBin;
    int oldIndex=index;
    int oldDupIndex=dupIndex;
    key.setData(null);
    data.setData(null);
    try {
      getNext(key,data,LockType.NONE,true,false);
    }
 catch (    DatabaseException ignored) {
    }
    if (bin != oldBin || dupBin != oldDupBin || index != oldIndex || dupIndex != oldDupIndex) {
      if (key.getData() == null && bin != null && index > 0) {
        setDbt(key,bin.getKey(index));
      }
      if (data.getData() == null && dupBin != null && dupIndex > 0) {
        setDbt(data,dupBin.getKey(dupIndex));
      }
      return true;
    }
 else {
      return false;
    }
  }

  public BIN latchBIN() throws DatabaseException {
    //#if LATCHES
    while (bin != null) {
      BIN waitingOn=bin;
      waitingOn.latch();
      if (bin == waitingOn) {
        return bin;
      }
      waitingOn.releaseLatch();
    }
    return null;
    //#else
    throw new RuntimeException("TYPE ERROR?");
    //#endif
  }

//#if LATCHES
  public void releaseBIN() throws LatchNotHeldException {
    if (bin != null) {
      bin.releaseLatchIfOwner();
    }
  }
//#endif
  
//#if LATCHES
  public void latchBINs() throws DatabaseException {
    latchBIN();
    latchDBIN();
  }
//#endif
  
//#if LATCHES
  public void releaseBINs() throws LatchNotHeldException {
    releaseBIN();
    releaseDBIN();
  }
//#endif

  public DBIN latchDBIN() throws DatabaseException {
    //#if LATCHES
    while (dupBin != null) {
      BIN waitingOn=dupBin;
      waitingOn.latch();
      if (dupBin == waitingOn) {
        return dupBin;
      }
      waitingOn.releaseLatch();
    }
    return null;
    //#else
    throw new RuntimeException("TYPE ERROR?");
    //#endif
  }

  
//#if LATCHES
  public void releaseDBIN() throws LatchNotHeldException {
    if (dupBin != null) {
      dupBin.releaseLatchIfOwner();
    }
  }
//#endif
  
  public Locker getLocker(){
    return locker;
  }
  
  public void addCursor(  BIN bin){
    if (bin != null) {
      //#if LATCHES
      assert bin.isLatchOwner();
      //#endif
      bin.addCursor(this);
    }
  }
  
/** 
 * Add to the current cursor. (For dups)
 */
  public void addCursor(){
    if (dupBin != null) {
      addCursor(dupBin);
    }
    if (bin != null) {
      addCursor(bin);
    }
  }
  public void updateBin(  BIN bin,  int index) throws DatabaseException {
    removeCursorDBIN();
    setDupIndex(-1);
    setDupBIN(null);
    setIndex(index);
    setBIN(bin);
    addCursor(bin);
  }
  public void updateDBin(  DBIN dupBin,  int dupIndex){
    setDupIndex(dupIndex);
    setDupBIN(dupBin);
    addCursor(dupBin);
  }
  private void removeCursor() throws DatabaseException {
    removeCursorBIN();
    removeCursorDBIN();
  }
  
  private void removeCursorBIN() throws DatabaseException {
    BIN abin=latchBIN();
    if (abin != null) {
      abin.removeCursor(this);
      //#if LATCHES
      abin.releaseLatch();
      //#endif
    }
  }
  
  private void removeCursorDBIN() throws DatabaseException {
    DBIN abin=latchDBIN();
    if (abin != null) {
      abin.removeCursor(this);
      //#if LATCHES
      abin.releaseLatch();
      //#endif
    }
  }
  
  /** 
 * Clear the reference to the dup tree, if any.
 */
  public void clearDupBIN(  boolean alreadyLatched) throws DatabaseException {
    if (dupBin != null) {
      if (alreadyLatched) {
        dupBin.removeCursor(this);
        //#if LATCHES
        dupBin.releaseLatch();
        //#endif
      }
 else {
        removeCursorDBIN();
      }
      dupBin=null;
      dupIndex=-1;
    }
  }
  public void dumpTree() throws DatabaseException {
    database.getTree().dump();
  }
  /** 
 * @return true if this cursor is closed
 */
  public boolean isClosed(){
    return (status == CURSOR_CLOSED);
  }
  /** 
 * @return true if this cursor is not initialized
 */
  public boolean isNotInitialized(){
    return (status == CURSOR_NOT_INITIALIZED);
  }
  /** 
 * Reset a cursor to an uninitialized state, but unlike close(), allow it
 * to be used further.
 */
  public void reset() throws DatabaseException {
    removeCursor();
    if (!retainNonTxnLocks) {
      locker.releaseNonTxnLocks();
    }
    bin=null;
    index=-1;
    dupBin=null;
    dupIndex=-1;
    status=CURSOR_NOT_INITIALIZED;
//#if CRITICALEVICTION
//#if EVICTOR
    if (allowEviction) 
//#if CRITICALEVICTION
//#if EVICTOR
{
//#if CRITICALEVICTION
      database.getDbEnvironment().getEvictor().doCriticalEviction();
//#endif
    }
//#endif
//#endif
//#endif
//#endif
  }
  /** 
 * Close a cursor.
 * @throws DatabaseException if the cursor was previously closed.
 */
  public void close() throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    removeCursor();
    locker.unRegisterCursor(this);
    if (!retainNonTxnLocks) {
      locker.releaseNonTxnLocks();
    }
    status=CURSOR_CLOSED;
//#if CRITICALEVICTION
//#if EVICTOR
    if (allowEviction) 
//#if CRITICALEVICTION
//#if EVICTOR
{
      database.getDbEnvironment().getEvictor().doCriticalEviction();
    }
//#endif
//#endif
//#endif
//#endif
  }
  
  public int count(  LockType lockType) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    if (!database.getSortedDuplicates()) {
      return 1;
    }
    if (bin == null) {
      return 0;
    }
    //#if LATCHES
    latchBIN();
    try {
      if (bin.getNEntries() <= index) {
        return 0;
      }
      Node n=bin.fetchTarget(index);
      if (n != null && n.containsDuplicates()) {
        DIN dupRoot=(DIN)n;
        dupRoot.latch();
        releaseBIN();
        DupCountLN dupCountLN=(DupCountLN)dupRoot.getDupCountLNRef().fetchTarget(database,dupRoot);
        dupRoot.releaseLatch();
        if (lockType != LockType.NONE) {
          locker.lock(dupCountLN.getNodeId(),lockType,false,database);
        }
        return dupCountLN.getDupCount();
      }
      else {
        return 1;
      }
    }
    finally {
      releaseBIN();
    }
    //#else
    throw new RuntimeException("TYPE ERROR?");
    //#endif
  }
  
  /** 
 * Delete the item pointed to by the cursor. If cursor is not initialized
 * or item is already deleted, return appropriate codes. Returns with
 * nothing latched.  bin and dupBin are latched as appropriate.
 * @return 0 on success, appropriate error code otherwise.
 */
  public OperationStatus delete() throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    boolean isDup=setTargetBin();
    if (targetBin == null) {
      return OperationStatus.KEYEMPTY;
    }
    if (targetBin.isEntryKnownDeleted(targetIndex)) {
//#if LATCHES
      releaseBINs();
//#endif
      return OperationStatus.KEYEMPTY;
    }
    LN ln=(LN)targetBin.fetchTarget(targetIndex);
    if (ln == null) {
//#if LATCHES
      releaseBINs();
//#endif
      return OperationStatus.KEYEMPTY;
    }
    LockResult lockResult=lockLN(ln,LockType.WRITE);
    ln=lockResult.getLN();
    if (ln == null) {
//#if LATCHES
      releaseBINs();
//#endif
      return OperationStatus.KEYEMPTY;
    }
    LockResult dclLockResult=null;
    DIN dupRoot=null;
//#if LATCHES
    try {
      isDup=(dupBin != null);
      if (isDup) {
        dupRoot=getLatchedDupRoot(true);
        dclLockResult=lockDupCountLN(dupRoot,LockType.WRITE);
        dupRoot=(DIN)bin.getTarget(index);
//#if LATCHES
        releaseBIN();
//#endif
      }
      setTargetBin();
      long oldLsn=targetBin.getLsn(targetIndex);
      byte[] lnKey=targetBin.getKey(targetIndex);
      lockResult.setAbortLsn(oldLsn,targetBin.isEntryKnownDeleted(targetIndex));
//#if MEMORYBUDGET
      long oldLNSize=ln.getMemorySizeIncludedByParent();
//#endif
      long newLsn=ln.delete(database,lnKey,dupKey,oldLsn,locker);
//#if MEMORYBUDGET
      long newLNSize=ln.getMemorySizeIncludedByParent();
//#endif
      targetBin.updateEntry(targetIndex,newLsn
//#if MEMORYBUDGET
, oldLNSize, newLNSize
//#endif
);
      targetBin.setPendingDeleted(targetIndex);
//#if LATCHES
      releaseBINs();
//#endif
      if (isDup) {
        dupRoot.incrementDuplicateCount(dclLockResult,dupKey,locker,false);
//#if LATCHES
        dupRoot.releaseLatch();
//#endif
        dupRoot=null;
//#if INCOMPRESSOR
        locker.addDeleteInfo(dupBin,new Key(lnKey));
//#endif
      }
 else {
//#if INCOMPRESSOR
        locker.addDeleteInfo(bin,new Key(lnKey));
//#endif
      }
//#if LOGGINGFINER
      trace(Level.FINER,TRACE_DELETE,targetBin,ln,targetIndex,oldLsn,newLsn);
//#endif
    }
  finally {
      if (dupRoot != null) {
        dupRoot.releaseLatchIfOwner();
      }
    }
//#endif
    return OperationStatus.SUCCESS;
  }
  /** 
 * Return a new copy of the cursor. If position is true, position the
 * returned cursor at the same position.
 */
  public CursorImpl dup(  boolean samePosition) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    CursorImpl ret=cloneCursor(samePosition);
    if (!samePosition) {
      ret.bin=null;
      ret.index=-1;
      ret.dupBin=null;
      ret.dupIndex=-1;
      ret.status=CURSOR_NOT_INITIALIZED;
    }
    return ret;
  }
//#if EVICTOR
  /** 
 * Evict the LN node at the cursor position.  This is used for internal
 * databases only.
 */
  public void evict() throws DatabaseException {
//#if LATCHES
    try {
//#if LATCHES
      latchBINs();
//#endif
      setTargetBin();
      targetBin.evictLN(targetIndex);
    }
  finally {
      releaseBINs();
    }
//#endif
  }
//#endif
  /** 
 * Search for the next key (or duplicate) following the given key (and
 * datum), and acquire a range insert lock on it.  If there are no more
 * records following the given key and datum, lock the special EOF node
 * for the database.
 */
  public void lockNextKeyForInsert(  DatabaseEntry key,  DatabaseEntry data) throws DatabaseException {
    DatabaseEntry tempKey=new DatabaseEntry(key.getData(),key.getOffset(),key.getSize());
    DatabaseEntry tempData=new DatabaseEntry(data.getData(),data.getOffset(),data.getSize());
    tempKey.setPartial(0,0,true);
    tempData.setPartial(0,0,true);
    boolean lockedNextKey=false;
    SearchMode searchMode=database.getSortedDuplicates() ? SearchMode.BOTH_RANGE : SearchMode.SET_RANGE;
//#if LATCHES
    boolean latched=true;
//#endif
//#if LATCHES
    try {
      int searchResult=searchAndPosition(tempKey,tempData,searchMode,LockType.RANGE_INSERT);
      if ((searchResult & FOUND) != 0 && (searchResult & FOUND_LAST) == 0) {
        OperationStatus status;
        if ((searchResult & EXACT_KEY) != 0) {
          status=getNext(tempKey,tempData,LockType.RANGE_INSERT,true,true);
        }
 else {
          status=getNextNoDup(tempKey,tempData,LockType.RANGE_INSERT,true,true);
        }
        if (status == OperationStatus.SUCCESS) {
          lockedNextKey=true;
        }
//#if LATCHES
        latched=false;
//#endif
      }
    }
  finally {
      if (latched) {
        releaseBINs();
      }
    }
//#endif
    if (!lockedNextKey) {
      lockEofNode(LockType.RANGE_INSERT);
    }
  }
  /** 
 * Insert the given LN in the tree or return KEYEXIST if the key is already
 * present.
 * <p>This method is called directly internally for putting tree map LNs
 * and file summary LNs.  It should not be used otherwise, and in the
 * future we should find a way to remove this special case.</p>
 */
  public OperationStatus putLN(  byte[] key,  LN ln,  boolean allowDuplicates) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
//#if LATCHES
    assert LatchSupport.countLatchesHeld() == 0;
//#endif
    LockResult lockResult=locker.lock(ln.getNodeId(),LockType.WRITE,false,database);
    if (database.getTree().insert(ln,key,allowDuplicates,this,lockResult)) {
      status=CURSOR_INITIALIZED;
      return OperationStatus.SUCCESS;
    }
 else {
      locker.releaseLock(ln.getNodeId());
      return OperationStatus.KEYEXIST;
    }
  }
  /** 
 * Insert or overwrite the key/data pair.
 * @param key
 * @param data
 * @return 0 if successful, failure status value otherwise
 */
  public OperationStatus put(  DatabaseEntry key,  DatabaseEntry data,  DatabaseEntry foundData) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    OperationStatus result=putLN(Key.makeKey(key),new LN(data),database.getSortedDuplicates());
    if (result == OperationStatus.KEYEXIST) {
      status=CURSOR_INITIALIZED;
      result=putCurrent(data,null,foundData);
    }
    return result;
  }
  /** 
 * Insert the key/data pair in No Overwrite mode.
 * @param key
 * @param data
 * @return 0 if successful, failure status value otherwise
 */
  public OperationStatus putNoOverwrite(  DatabaseEntry key,  DatabaseEntry data) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    return putLN(Key.makeKey(key),new LN(data),false);
  }
  /** 
 * Insert the key/data pair as long as no entry for key/data exists yet.
 */
  public OperationStatus putNoDupData(  DatabaseEntry key,  DatabaseEntry data) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    if (!database.getSortedDuplicates()) {
      throw new DatabaseException("putNoDupData() called, but database is not configured " + "for duplicate data.");
    }
    return putLN(Key.makeKey(key),new LN(data),true);
  }
  /** 
 * Modify the current record with this data.
 * @param data
 */
  public OperationStatus putCurrent(  DatabaseEntry data,  DatabaseEntry foundKey,  DatabaseEntry foundData) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    if (foundKey != null) {
      foundKey.setData(null);
    }
    if (foundData != null) {
      foundData.setData(null);
    }
    if (bin == null) {
      return OperationStatus.KEYEMPTY;
    }
    //#if LATCHES
    latchBINs();
    //#endif
    boolean isDup=setTargetBin();
    //#if LATCHES
    try {
      LN ln=(LN)targetBin.fetchTarget(targetIndex);
      byte[] lnKey=targetBin.getKey(targetIndex);
      Comparator userComparisonFcn=targetBin.getKeyComparator();
      if (targetBin.isEntryKnownDeleted(targetIndex) || ln == null) {
        releaseBINs();
        return OperationStatus.NOTFOUND;
      }
      LockResult lockResult=lockLN(ln,LockType.WRITE);
      ln=lockResult.getLN();
      if (ln == null) {
        releaseBINs();
        return OperationStatus.NOTFOUND;
      }
      byte[] foundDataBytes;
      byte[] foundKeyBytes;
      isDup=setTargetBin();
      if (isDup) {
        foundDataBytes=lnKey;
        foundKeyBytes=targetBin.getDupKey();
      }
      else {
        foundDataBytes=ln.getData();
        foundKeyBytes=lnKey;
      }
      byte[] newData;
      if (data.getPartial()) {
        int dlen=data.getPartialLength();
        int doff=data.getPartialOffset();
        int origlen=(foundDataBytes != null) ? foundDataBytes.length : 0;
        int oldlen=(doff + dlen > origlen) ? doff + dlen : origlen;
        int len=oldlen - dlen + data.getSize();
        if (len == 0) {
          newData=LogUtils.ZERO_LENGTH_BYTE_ARRAY;
        }
        else {
          newData=new byte[len];
        }
        int pos=0;
        int slicelen=(doff < origlen) ? doff : origlen;
        if (slicelen > 0)         System.arraycopy(foundDataBytes,0,newData,pos,slicelen);
        pos+=doff;
        slicelen=data.getSize();
        System.arraycopy(data.getData(),data.getOffset(),newData,pos,slicelen);
        pos+=slicelen;
        slicelen=origlen - (doff + dlen);
        if (slicelen > 0)         System.arraycopy(foundDataBytes,doff + dlen,newData,pos,slicelen);
      }
      else {
        int len=data.getSize();
        if (len == 0) {
          newData=LogUtils.ZERO_LENGTH_BYTE_ARRAY;
        }
        else {
          newData=new byte[len];
        }
        System.arraycopy(data.getData(),data.getOffset(),newData,0,len);
      }
      if (database.getSortedDuplicates()) {
        boolean keysEqual=false;
        if (foundDataBytes != null) {
          keysEqual=Key.compareKeys(foundDataBytes,newData,userComparisonFcn) == 0;
        }
        if (!keysEqual) {
          revertLock(ln,lockResult);
          throw new DatabaseException("Can't replace a duplicate with different data.");
        }
      }
      if (foundData != null) {
        setDbt(foundData,foundDataBytes);
      }
      if (foundKey != null) {
        setDbt(foundKey,foundKeyBytes);
      }
      long oldLsn=targetBin.getLsn(targetIndex);
      lockResult.setAbortLsn(oldLsn,targetBin.isEntryKnownDeleted(targetIndex));
      //#if MEMORYBUDGET
      long oldLNSize=ln.getMemorySizeIncludedByParent();
      //#endif
      byte[] newKey=(isDup ? targetBin.getDupKey() : lnKey);
      long newLsn=ln.modify(newData,database,newKey,oldLsn,locker);
      //#if MEMORYBUDGET
      long newLNSize=ln.getMemorySizeIncludedByParent();
      //#endif
      targetBin.updateEntry(targetIndex,newLsn 
          //#if MEMORYBUDGET
          , oldLNSize, newLNSize
          //#endif
          );
      releaseBINs();
      //#if LOGGINGFINER
      trace(Level.FINER,TRACE_MOD,targetBin,ln,targetIndex,oldLsn,newLsn);
      //#endif
      status=CURSOR_INITIALIZED;
      return OperationStatus.SUCCESS;
    }
    finally {
      releaseBINs();
    }
    //#else
    throw new RuntimeException("TYPE ERROR?");
    //#endif
  }
  /** 
 * Retrieve the current record.
 */
  public OperationStatus getCurrent(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    if (bin == null) {
      return OperationStatus.KEYEMPTY;
    }
//#if LATCHES
    if (dupBin == null) 
//#if LATCHES
{
      latchBIN();
    }
//#endif
 else 
//#if LATCHES
{
      latchDBIN();
    }
//#endif
//#endif
    return getCurrentAlreadyLatched(foundKey,foundData,lockType,true);
  }
  /** 
 * Retrieve the current record. Assume the bin is already latched.  Return
 * with the target bin unlatched.
 */
  public OperationStatus getCurrentAlreadyLatched(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType,  boolean first) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    //#if LATCHES
    assert checkAlreadyLatched(true) : dumpToString(true);
    try {
      return fetchCurrent(foundKey,foundData,lockType,first);
    }
    finally {
      releaseBINs();
    }
    //#else
    throw new RuntimeException("TYPE ERROR?");
    //#endif
  }
  /** 
 * Retrieve the current LN, return with the target bin unlatched.
 */
  public LN getCurrentLN(  LockType lockType) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    if (bin == null) {
      return null;
    }
 else {
//#if LATCHES
      latchBIN();
//#endif
      return getCurrentLNAlreadyLatched(lockType);
    }
  }
  /** 
 * Retrieve the current LN, assuming the BIN is already latched.  Return
 * with the target BIN unlatched.
 */
  public LN getCurrentLNAlreadyLatched(  LockType lockType) throws DatabaseException {
    //#if LATCHES
    try {
      assert assertCursorState(true) : dumpToString(true);
      assert checkAlreadyLatched(true) : dumpToString(true);
      if (bin == null) {
        return null;
      }
      LN ln=null;
      if (!bin.isEntryKnownDeleted(index)) {
        ln=(LN)bin.fetchTarget(index);
      }
      if (ln == null) {
        releaseBIN();
        return null;
      }
      addCursor(bin);
      LockResult lockResult=lockLN(ln,lockType);
      ln=lockResult.getLN();
      return ln;
    }
    finally {
      releaseBINs();
    }
    //#else
      throw new RuntimeException("TYPE ERROR?");
    //#endif
  }

  public OperationStatus getNext(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType,  boolean forward,  boolean alreadyLatched) throws DatabaseException {
    return getNextWithKeyChangeStatus(foundKey,foundData,lockType,forward,alreadyLatched).status;
  }
  /** 
 * Move the cursor forward and return the next record. This will cross BIN
 * boundaries and dip into duplicate sets.
 * @param foundKey DatabaseEntry to use for returning key
 * @param foundData DatabaseEntry to use for returning data
 * @param forward if true, move forward, else move backwards
 * @param alreadyLatched if true, the bin that we're on is already
 * latched.
 * @return the status and an indication of whether we advanced to a new
 * key during the operation.
 */
  public KeyChangeStatus getNextWithKeyChangeStatus(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType,  boolean forward,
  boolean alreadyLatched
) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
//#if LATCHES
    assert checkAlreadyLatched(alreadyLatched) : dumpToString(true);
//#endif
    KeyChangeStatus result=new KeyChangeStatus(OperationStatus.NOTFOUND,true);
    try {
      while (bin != null) {
        if (dupBin != null) {
//#if VERIFIER
          if (DEBUG) 
//#if VERIFIER
{
            verifyCursor(dupBin);
          }
//#endif
//#endif
          if (getNextDuplicate(foundKey,foundData,lockType,forward,alreadyLatched) == OperationStatus.SUCCESS) {
            result.status=OperationStatus.SUCCESS;
            result.keyChange=false;
            break;
          }
 else {
            removeCursorDBIN();
//#if LATCHES
            alreadyLatched=false;
//#endif
            dupBin=null;
            dupIndex=-1;
            continue;
          }
        }
//#if LATCHES
        assert checkAlreadyLatched(alreadyLatched) : dumpToString(true);
//#endif
//#if LATCHES
        if (!alreadyLatched) 
//#if LATCHES
{
          latchBIN();
        }
//#endif
 else 
//#if LATCHES
{
          alreadyLatched=false;
        }
//#endif
//#endif
//#if VERIFIER
        if (DEBUG) 
//#if VERIFIER
{
          verifyCursor(bin);
        }
//#endif
//#endif
        if ((forward && ++index < bin.getNEntries()) || (!forward && --index > -1)) {
          OperationStatus ret=getCurrentAlreadyLatched(foundKey,foundData,lockType,forward);
          if (ret == OperationStatus.SUCCESS) {
            incrementLNCount();
            result.status=OperationStatus.SUCCESS;
            break;
          }
 else {
//#if LATCHES
            assert LatchSupport.countLatchesHeld() == 0;
//#endif
            if (binToBeRemoved != null) {
              flushBINToBeRemoved();
            }
            continue;
          }
        }
 else {
          if (binToBeRemoved != null) {
//#if LATCHES
            releaseBIN();
//#endif
            flushBINToBeRemoved();
//#if LATCHES
            latchBIN();
//#endif
          }
          binToBeRemoved=bin;
          bin=null;
          BIN newBin;
          assert TestHookExecute.doHookIfSet(testHook);
          if (forward) {
            newBin=database.getTree().getNextBin(binToBeRemoved,false);
          }
 else {
            newBin=database.getTree().getPrevBin(binToBeRemoved,false);
          }
          if (newBin == null) {
            result.status=OperationStatus.NOTFOUND;
            break;
          }
 else {
            if (forward) {
              index=-1;
            }
 else {
              index=newBin.getNEntries();
            }
            addCursor(newBin);
            bin=newBin;
//#if LATCHES
            alreadyLatched=true;
//#endif
          }
        }
      }
    }
  finally {
//#if LATCHES
      assert LatchSupport.countLatchesHeld() == 0 : LatchSupport.latchesHeldToString();
//#endif
      if (binToBeRemoved != null) {
        flushBINToBeRemoved();
      }
    }
    return result;
  }
  private void flushBINToBeRemoved() throws DatabaseException {
//#if LATCHES
    binToBeRemoved.latch();
//#endif
    binToBeRemoved.removeCursor(this);
//#if LATCHES
    binToBeRemoved.releaseLatch();
//#endif
    binToBeRemoved=null;
  }
  public OperationStatus getNextNoDup(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType,  boolean forward,  boolean alreadyLatched) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    if (dupBin != null) {
      clearDupBIN(alreadyLatched);
      alreadyLatched=false;
    }
    return getNext(foundKey,foundData,lockType,forward,alreadyLatched);
  }
  /** 
 * Retrieve the first duplicate at the current cursor position.
 */
  public OperationStatus getFirstDuplicate(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
    if (dupBin != null) {
      removeCursorDBIN();
      dupBin=null;
      dupIndex=-1;
    }
    return getCurrent(foundKey,foundData,lockType);
  }
  /** 
 * Enter with dupBin unlatched.  Pass foundKey == null to just advance
 * cursor to next duplicate without fetching data.
 */
  public OperationStatus getNextDuplicate(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType,  boolean forward,
  boolean alreadyLatched) throws DatabaseException {
    assert assertCursorState(true) : dumpToString(true);
//#if LATCHES
    assert checkAlreadyLatched(alreadyLatched) : dumpToString(true);
//#endif
    try {
      while (dupBin != null) {
//#if LATCHES
        if (!alreadyLatched) 
//#if LATCHES
{
          latchDBIN();
        }
//#endif
 else 
//#if LATCHES
{
          alreadyLatched=false;
        }
//#endif
//#endif
//#if VERIFIER
        if (DEBUG) 
//#if VERIFIER
{
          verifyCursor(dupBin);
        }
//#endif
//#endif
        if ((forward && ++dupIndex < dupBin.getNEntries()) || (!forward && --dupIndex > -1)) {
          OperationStatus ret=OperationStatus.SUCCESS;
          if (foundKey != null) {
            ret=getCurrentAlreadyLatched(foundKey,foundData,lockType,forward);
          }
 else 
//#if LATCHES
{
//#if LATCHES
            releaseDBIN();
//#endif
          }
//#endif
          if (ret == OperationStatus.SUCCESS) {
            incrementLNCount();
            return ret;
          }
 else {
//#if LATCHES
            assert LatchSupport.countLatchesHeld() == 0;
//#endif
            if (dupBinToBeRemoved != null) {
              flushDBINToBeRemoved();
            }
            continue;
          }
        }
 else {
          if (dupBinToBeRemoved != null) {
            flushDBINToBeRemoved();
          }
          dupBinToBeRemoved=dupBin;
          dupBin=null;
//#if LATCHES
          dupBinToBeRemoved.releaseLatch();
//#endif
//#if STATISTICS
          TreeWalkerStatsAccumulator treeStatsAccumulator=getTreeStatsAccumulator();
//#endif
//#if STATISTICS
          if (treeStatsAccumulator != null) 
//#if STATISTICS
{
//#if LATCHES
            latchBIN();
//#endif
//#if LATCHES
            try {
              if (index < 0) {
                return OperationStatus.NOTFOUND;
              }
              DIN duplicateRoot=(DIN)bin.fetchTarget(index);
//#if LATCHES
              duplicateRoot.latch();
//#endif
//#if LATCHES
              try {
                DupCountLN dcl=duplicateRoot.getDupCountLN();
                if (dcl != null) {
                  dcl.accumulateStats(treeStatsAccumulator);
                }
              }
  finally {
                duplicateRoot.releaseLatch();
              }
//#endif
            }
  finally {
              releaseBIN();
            }
//#endif
          }
//#endif
//#endif
//#if LATCHES
          assert (LatchSupport.countLatchesHeld() == 0);
//#endif
//#if LATCHES
          dupBinToBeRemoved.latch();
//#endif
          DBIN newDupBin;
          if (forward) {
            newDupBin=(DBIN)database.getTree().getNextBin(dupBinToBeRemoved,true);
          }
 else {
            newDupBin=(DBIN)database.getTree().getPrevBin(dupBinToBeRemoved,true);
          }
          if (newDupBin == null) {
            return OperationStatus.NOTFOUND;
          }
 else {
            if (forward) {
              dupIndex=-1;
            }
 else {
              dupIndex=newDupBin.getNEntries();
            }
            addCursor(newDupBin);
            dupBin=newDupBin;
//#if LATCHES
            alreadyLatched=true;
//#endif
          }
        }
      }
    }
  finally {
//#if LATCHES
      assert LatchSupport.countLatchesHeld() == 0;
//#endif
      if (dupBinToBeRemoved != null) {
        flushDBINToBeRemoved();
      }
    }
    return OperationStatus.NOTFOUND;
  }
  private void flushDBINToBeRemoved() throws DatabaseException {
//#if LATCHES
    dupBinToBeRemoved.latch();
//#endif
    dupBinToBeRemoved.removeCursor(this);
//#if LATCHES
    dupBinToBeRemoved.releaseLatch();
//#endif
    dupBinToBeRemoved=null;
  }
  /** 
 * Position the cursor at the first or last record of the database.  It's
 * okay if this record is deleted. Returns with the target BIN latched.
 * @return true if a first or last position is found, false if the 
 * tree being searched is empty.
 */
  public boolean positionFirstOrLast(  boolean first,  DIN duplicateRoot) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    IN in=null;
    boolean found=false;
    //#if LATCHES
    try {
      if (duplicateRoot == null) {
        removeCursorBIN();
        if (first) {
          in=database.getTree().getFirstNode();
        }
        else {
          in=database.getTree().getLastNode();
        }
        if (in != null) {
          assert (in instanceof BIN);
          dupBin=null;
          dupIndex=-1;
          bin=(BIN)in;
          index=(first ? 0 : (bin.getNEntries() - 1));
          addCursor(bin);
          TreeWalkerStatsAccumulator treeStatsAccumulator=getTreeStatsAccumulator();
          if (bin.getNEntries() == 0) {
            found=true;
          }
          else {
            Node n=null;
            if (!in.isEntryKnownDeleted(index)) {
              n=in.fetchTarget(index);
            }
            if (n != null && n.containsDuplicates()) {
              DIN dupRoot=(DIN)n;
              dupRoot.latch();
              in.releaseLatch();
              in=null;
              found=positionFirstOrLast(first,dupRoot);
            }
            else {
              if (treeStatsAccumulator != null) {
                if (n == null || ((LN)n).isDeleted()) {
                  treeStatsAccumulator.incrementDeletedLNCount();
                }
                else {
                  treeStatsAccumulator.incrementLNCount();
                }
              }
              found=true;
            }
          }
        }
      }
      else {
        removeCursorDBIN();
        if (first) {
          in=database.getTree().getFirstNode(duplicateRoot);
        }
        else {
          in=database.getTree().getLastNode(duplicateRoot);
        }
        if (in != null) {
          assert (in instanceof DBIN);
          dupBin=(DBIN)in;
          dupIndex=(first ? 0 : (dupBin.getNEntries() - 1));
          addCursor(dupBin);
          found=true;
        }
      }
      status=CURSOR_INITIALIZED;
      return found;
    }
    catch (    DatabaseException e) {
      if (in != null) {
        in.releaseLatch();
      }
      throw e;
    }
    //#else
    throw new RuntimeException("TYPE ERROR?");
    //#endif
  }
  
  public static final int FOUND=0x1;
  public static final int EXACT_KEY=0x2;
  public static final int EXACT_DATA=0x4;
  public static final int FOUND_LAST=0x8;
  /** 
 * Position the cursor at the key. This returns a three part value that's
 * bitwise or'ed into the int. We find out if there was any kind of match
 * and if the match was exact. Note that this match focuses on whether the
 * searching criteria (key, or key and data, depending on the search type)
 * is met.
 * <p>Note this returns with the BIN latched!</p>
 * <p>If this method returns without the FOUND bit set, the caller can
 * assume that no match is possible.  Otherwise, if the FOUND bit is set,
 * the caller should check the EXACT_KEY and EXACT_DATA bits.  If EXACT_KEY
 * is not set (or for BOTH and BOTH_RANGE, if EXACT_DATA is not set), an
 * approximate match was found.  In an approximate match, the cursor is
 * always positioned before the target key/data.  This allows the caller to
 * perform a 'next' operation to advance to the value that is equal or
 * higher than the target key/data.</p>
 * <p>Even if the search returns an exact result, the record may be
 * deleted.  The caller must therefore check for both an approximate match
 * and for whether the cursor is positioned on a deleted record.</p>
 * <p>If SET or BOTH is specified, the FOUND bit will only be returned if
 * an exact match is found.  However, the record found may be deleted.</p>
 * <p>There is one special case where this method may be called without
 * checking the EXACT_KEY (and EXACT_DATA) bits and without checking for a
 * deleted record:  If SearchMode.SET is specified then only the FOUND bit
 * need be checked.  When SET is specified and FOUND is returned, it is
 * guaranteed to be an exact match on a non-deleted record.  It is for this
 * case only that this method is public.</p>
 * <p>If FOUND is set, FOUND_LAST may also be set if the cursor is
 * positioned on the last record in the database.  Note that this state can
 * only be counted on as long as the BIN is latched, so it is not set if
 * this method must release the latch to lock the record.  Therefore, it
 * should only be used for optimizations.  If FOUND_LAST is set, the cursor
 * is positioned on the last record and the BIN is latched.  If FOUND_LAST
 * is not set, the cursor may or may not be positioned on the last record.
 * Note that exact searches always perform an unlatch and a lock, so
 * FOUND_LAST will only be set for inexact (range) searches.</p>
 * <p>Be aware that when an approximate match is returned, the index or
 * dupIndex may be set to -1.  This is done intentionally so that a 'next'
 * operation will increment it.</p>
 */
  public int searchAndPosition(  DatabaseEntry matchKey,  DatabaseEntry matchData,  SearchMode searchMode,  LockType lockType) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    removeCursor();
    bin=null;
    boolean foundSomething=false;
    boolean foundExactKey=false;
    boolean foundExactData=false;
    boolean foundLast=false;
    boolean exactSearch=searchMode.isExactSearch();
    BINBoundary binBoundary=new BINBoundary();
    //#if LATCHES
    try {
      byte[] key=Key.makeKey(matchKey);
      bin=(BIN)database.getTree().search(key,Tree.SearchType.NORMAL,-1,binBoundary,true);
      if (bin != null) {
        addCursor(bin);
        index=bin.findEntry(key,true,exactSearch);
        foundSomething=!exactSearch;
        dupBin=null;
        dupIndex=-1;
        boolean containsDuplicates=false;
        if (index >= 0) {
          if ((index & IN.EXACT_MATCH) != 0) {
            foundExactKey=true;
            index&=~IN.EXACT_MATCH;
          }
          Node n=null;
          if (!bin.isEntryKnownDeleted(index)) {
            n=bin.fetchTarget(index);
          }
          if (n != null) {
            containsDuplicates=n.containsDuplicates();
            if (searchMode.isDataSearch()) {
              if (foundExactKey) {
                int searchResult=searchAndPositionBoth(containsDuplicates,n,matchData,exactSearch,lockType,bin.getLsn(index));
                foundSomething=(searchResult & FOUND) != 0;
                foundExactData=(searchResult & EXACT_DATA) != 0;
              }
            }
            else {
              foundSomething=true;
              if (!containsDuplicates && exactSearch) {
                LN ln=(LN)n;
                LockResult lockResult=lockLN(ln,lockType);
                ln=lockResult.getLN();
                if (ln == null) {
                  foundSomething=false;
                }
              }
            }
          }
          foundLast=(searchMode == SearchMode.SET_RANGE && foundSomething && !containsDuplicates && binBoundary.isLastBin && index == bin.getNEntries() - 1);
        }
      }
      status=CURSOR_INITIALIZED;
      return (foundSomething ? FOUND : 0) | (foundExactKey ? EXACT_KEY : 0) | (foundExactData ? EXACT_DATA : 0)| (foundLast ? FOUND_LAST : 0);
    }
    catch (    DatabaseException e) {
      releaseBIN();
      throw e;
    }
    //#else
    throw new RuntimeException("TYPE ERROR?");
    //#endif
  }
  /** 
 * For this type of search, we need to match both key and data.  This
 * method is called after the key is matched to perform the data portion of
 * the match. We may be matching just against an LN, or doing further
 * searching into the dup tree.  See searchAndPosition for more details.
 */
  private int searchAndPositionBoth(  boolean containsDuplicates,  Node n,  DatabaseEntry matchData,  boolean exactSearch,  LockType lockType,  long oldLsn) throws DatabaseException {
    assert assertCursorState(false) : dumpToString(true);
    boolean found=false;
    boolean exact=false;
    assert (matchData != null);
    byte[] data=Key.makeKey(matchData);
    if (containsDuplicates) {
      DIN duplicateRoot=(DIN)n;
//#if LATCHES
      duplicateRoot.latch();
//#endif
//#if LATCHES
      releaseBIN();
//#endif
      dupBin=(DBIN)database.getTree().searchSubTree(duplicateRoot,data,Tree.SearchType.NORMAL,-1,null,true);
      if (dupBin != null) {
        addCursor(dupBin);
        dupIndex=dupBin.findEntry(data,true,exactSearch);
        if (dupIndex >= 0) {
          if ((dupIndex & IN.EXACT_MATCH) != 0) {
            exact=true;
          }
          dupIndex&=~IN.EXACT_MATCH;
          found=true;
        }
 else {
          dupIndex=-1;
          found=!exactSearch;
        }
      }
    }
 else {
      LN ln=(LN)n;
      LockResult lockResult=lockLN(ln,lockType);
      ln=lockResult.getLN();
      if (ln == null) {
        found=!exactSearch;
      }
 else {
        dupBin=null;
        dupIndex=-1;
        int cmp=Key.compareKeys(ln.getData(),data,database.getDuplicateComparator());
        if (cmp == 0 || (cmp <= 0 && !exactSearch)) {
          if (cmp == 0) {
            exact=true;
          }
          found=true;
        }
 else {
          index--;
          found=!exactSearch;
        }
      }
    }
    return (found ? FOUND : 0) | (exact ? EXACT_DATA : 0);
  }
  
  private OperationStatus fetchCurrent(  DatabaseEntry foundKey,  DatabaseEntry foundData,  LockType lockType,  boolean first) throws DatabaseException {
    TreeWalkerStatsAccumulator treeStatsAccumulator=getTreeStatsAccumulator();
    boolean duplicateFetch=setTargetBin();
    if (targetBin == null) {
      return OperationStatus.NOTFOUND;
    }
//#if LATCHES
    assert targetBin.isLatchOwner();
//#endif
    Node n=null;
    if (targetIndex < 0 || targetIndex >= targetBin.getNEntries() || targetBin.isEntryKnownDeleted(targetIndex)) {
    }
 else {
      if (targetBin.isEntryPendingDeleted(targetIndex)) {
//#if INCOMPRESSOR
        EnvironmentImpl envImpl=database.getDbEnvironment();
        envImpl.addToCompressorQueue(targetBin,new Key(targetBin.getKey(targetIndex)),false);
//#endif
      }
//#if LATCHES
      try {
        n=targetBin.fetchTarget(targetIndex);
      } catch (      DatabaseException DE) {
        targetBin.releaseLatchIfOwner();
        throw DE;
      }
//#endif
    }
    if (n == null) {
      if (treeStatsAccumulator != null) {
        treeStatsAccumulator.incrementDeletedLNCount();
      }
//#if LATCHES
      targetBin.releaseLatchIfOwner();
//#endif
      return OperationStatus.KEYEMPTY;
    }
    addCursor(targetBin);
    if (n.containsDuplicates()) {
      assert !duplicateFetch;
      DIN duplicateRoot=(DIN)n;
//#if LATCHES
      duplicateRoot.latch();
      targetBin.releaseLatch();
//#endif
      if (positionFirstOrLast(first,duplicateRoot)) {
//#if LATCHES
        try {
          return fetchCurrent(foundKey,foundData,lockType,first);
        } catch (DatabaseException DE) {
          releaseBINs();
          throw DE;
        }
//#endif
      }
 else {
        return OperationStatus.NOTFOUND;
      }
    }
    LN ln=(LN)n;
    assert TestHookExecute.doHookIfSet(testHook);
    LockResult lockResult=lockLN(ln,lockType);
//#if LATCHES
    try {
      ln=lockResult.getLN();
      byte[] lnData=(ln != null) ? ln.getData() : null;
      if (ln == null || lnData == null) {
        if (treeStatsAccumulator != null) {
          treeStatsAccumulator.incrementDeletedLNCount();
        }
        return OperationStatus.KEYEMPTY;
      }
      duplicateFetch=setTargetBin();
      if (duplicateFetch) {
        if (foundData != null) {
          setDbt(foundData,targetBin.getKey(targetIndex));
        }
        if (foundKey != null) {
          setDbt(foundKey,targetBin.getDupKey());
        }
      }
 else {
        if (foundData != null) {
          setDbt(foundData,lnData);
        }
        if (foundKey != null) {
          setDbt(foundKey,targetBin.getKey(targetIndex));
        }
      }
      return OperationStatus.SUCCESS;
    }
  finally {
      releaseBINs();
    }
//#else
    throw new RuntimeException("TYPE ERROR?");
//#endif
  }
  /** 
 * Locks the given LN's node ID; a deleted LN will not be locked or
 * returned.  Attempts to use a non-blocking lock to avoid
 * unlatching/relatching.  Retries if necessary, to handle the case where
 * the LN is changed while the BIN is unlatched.
 * Preconditions: The target BIN must be latched.  When positioned in a dup
 * tree, the BIN may be latched on entry also and if so it will be latched
 * on exit.
 * Postconditions: The target BIN is latched.  When positioned in a dup
 * tree, the BIN will be latched if it was latched on entry or a blocking
 * lock was needed.  Therefore, when positioned in a dup tree, releaseDBIN
 * should be called.
 * @param ln the LN to be locked.
 * @param lockType the type of lock requested.
 * @return the LockResult containing the LN that was locked, or containing
 * a null LN if the LN was deleted or cleaned.  If the LN is deleted, a
 * lock will not be held.
 */
  private LockResult lockLN(  LN ln,  LockType lockType) throws DatabaseException {
    LockResult lockResult=lockLNDeletedAllowed(ln,lockType);
    ln=lockResult.getLN();
    if (ln != null) {
      setTargetBin();
      if (targetBin.isEntryKnownDeleted(targetIndex) || ln.isDeleted()) {
        revertLock(ln.getNodeId(),lockResult.getLockGrant());
        lockResult.setLN(null);
      }
    }
    return lockResult;
  }
  /** 
 * Locks the given LN's node ID; a deleted LN will be locked and returned.
 * Attempts to use a non-blocking lock to avoid unlatching/relatching.
 * Retries if necessary, to handle the case where the LN is changed while
 * the BIN is unlatched.
 * Preconditions: The target BIN must be latched.  When positioned in a dup
 * tree, the BIN may be latched on entry also and if so it will be latched
 * on exit.
 * Postconditions: The target BIN is latched.  When positioned in a dup
 * tree, the BIN will be latched if it was latched on entry or a blocking
 * lock was needed.  Therefore, when positioned in a dup tree, releaseDBIN
 * should be called.
 * @param ln the LN to be locked.
 * @param lockType the type of lock requested.
 * @return the LockResult containing the LN that was locked, or containing
 * a null LN if the LN was cleaned.
 */
  public LockResult lockLNDeletedAllowed(  LN ln,  LockType lockType) throws DatabaseException {
    LockResult lockResult;
    if (lockType == LockType.NONE) {
      lockResult=new LockResult(LockGrantType.NONE_NEEDED,null);
      lockResult.setLN(ln);
      return lockResult;
    }
    if (locker.getDefaultNoWait()) {
      lockResult=locker.lock(ln.getNodeId(),lockType,true,database);
    }
 else {
      lockResult=locker.nonBlockingLock(ln.getNodeId(),lockType,database);
    }
    if (lockResult.getLockGrant() != LockGrantType.DENIED) {
      lockResult.setLN(ln);
      return lockResult;
    }
    while (true) {
      long nodeId=ln.getNodeId();
//#if LATCHES
      releaseBINs();
//#endif
      lockResult=locker.lock(nodeId,lockType,false,database);
//#if LATCHES
      latchBINs();
//#endif
      setTargetBin();
      ln=(LN)targetBin.fetchTarget(targetIndex);
      if (ln != null && nodeId != ln.getNodeId()) {
        revertLock(nodeId,lockResult.getLockGrant());
        continue;
      }
 else {
        lockResult.setLN(ln);
        return lockResult;
      }
    }
  }
  /** 
 * Locks the DupCountLN for the given duplicate root.  Attempts to use a
 * non-blocking lock to avoid unlatching/relatching.
 * Preconditions: The dupRoot, BIN and DBIN are latched.
 * Postconditions: The dupRoot, BIN and DBIN are latched.
 * Note that the dupRoot may change during locking and should be refetched
 * if needed.
 * @param dupRoot the duplicate root containing the DupCountLN to be
 * locked.
 * @param lockType the type of lock requested.
 * @return the LockResult containing the LN that was locked.
 */
  public LockResult lockDupCountLN(  DIN dupRoot,  LockType lockType) throws DatabaseException {
    DupCountLN ln=dupRoot.getDupCountLN();
    LockResult lockResult;
    if (locker.getDefaultNoWait()) {
      lockResult=locker.lock(ln.getNodeId(),lockType,true,database);
    }
 else {
      lockResult=locker.nonBlockingLock(ln.getNodeId(),lockType,database);
    }
    if (lockResult.getLockGrant() == LockGrantType.DENIED) {
//#if LATCHES
      dupRoot.releaseLatch();
//#endif
//#if LATCHES
      releaseBINs();
//#endif
      lockResult=locker.lock(ln.getNodeId(),lockType,false,database);
//#if LATCHES
      latchBIN();
//#endif
      dupRoot=(DIN)bin.fetchTarget(index);
//#if LATCHES
      dupRoot.latch();
//#endif
//#if LATCHES
      latchDBIN();
//#endif
      ln=dupRoot.getDupCountLN();
    }
    lockResult.setLN(ln);
    return lockResult;
  }
  /** 
 * Fetch, latch and return the DIN root of the duplicate tree at the cursor
 * position.
 * Preconditions: The BIN must be latched and the current BIN entry must
 * contain a DIN.
 * Postconditions: The BIN and DIN will be latched.  The DBIN will remain
 * latched if isDBINLatched is true.
 * @param isDBINLatched is true if the DBIN is currently latched.
 */
  public DIN getLatchedDupRoot(
//#if LATCHES
  boolean isDBINLatched
//#endif
) throws DatabaseException {
    assert bin != null;
//#if LATCHES
    assert bin.isLatchOwner();
//#endif
    assert index >= 0;
    DIN dupRoot=(DIN)bin.fetchTarget(index);
//#if LATCHES
    if (isDBINLatched) 
//#if LATCHES
{
//#if LATCHES
      if (!dupRoot.latchNoWait()) 
//#if LATCHES
{
        releaseDBIN();
        dupRoot.latch();
        latchDBIN();
      }
//#endif
//#endif
    }
//#endif
 else 
//#if LATCHES
{
      dupRoot.latch();
    }
//#endif
//#endif
    return dupRoot;
  }
  /** 
 * Helper to return a Data DBT from a BIN.
 */
  private void setDbt(  DatabaseEntry data,  byte[] bytes){
    if (bytes != null) {
      boolean partial=data.getPartial();
      int off=partial ? data.getPartialOffset() : 0;
      int len=partial ? data.getPartialLength() : bytes.length;
      if (off + len > bytes.length) {
        len=(off > bytes.length) ? 0 : bytes.length - off;
      }
      byte[] newdata=null;
      if (len == 0) {
        newdata=LogUtils.ZERO_LENGTH_BYTE_ARRAY;
      }
 else {
        newdata=new byte[len];
        System.arraycopy(bytes,off,newdata,0,len);
      }
      data.setData(newdata);
      data.setOffset(0);
      data.setSize(len);
    }
 else {
      data.setData(null);
      data.setOffset(0);
      data.setSize(0);
    }
  }
//#if VERIFIER
  private void verifyCursor(  BIN bin) throws DatabaseException {
    if (!bin.getCursorSet().contains(this)) {
      throw new DatabaseException("BIN cursorSet is inconsistent.");
    }
  }
//#endif
  /** 
 * Calls checkCursorState and returns false is an exception is thrown.
 */
  private boolean assertCursorState(  boolean mustBeInitialized){
    try {
      checkCursorState(mustBeInitialized);
      return true;
    }
 catch (    DatabaseException e) {
      return false;
    }
  }
  /** 
 * Check that the cursor is open and optionally if it is initialized.
 */
  public void checkCursorState(  boolean mustBeInitialized) throws DatabaseException {
    if (status == CURSOR_INITIALIZED) {
//#if VERIFIER
      if (DEBUG) 
//#if VERIFIER
{
        if (bin != null) {
          verifyCursor(bin);
        }
        if (dupBin != null) {
          verifyCursor(dupBin);
        }
      }
//#endif
//#endif
      return;
    }
 else     if (status == CURSOR_NOT_INITIALIZED) {
      if (mustBeInitialized) {
        throw new DatabaseException("Cursor Not Initialized.");
      }
    }
 else     if (status == CURSOR_CLOSED) {
      throw new DatabaseException("Cursor has been closed.");
    }
 else {
      throw new DatabaseException("Unknown cursor status: " + status);
    }
  }
  /** 
 * Return this lock to its prior status. If the lock was just obtained,
 * release it. If it was promoted, demote it.
 */
  private void revertLock(  LN ln,  LockResult lockResult) throws DatabaseException {
    revertLock(ln.getNodeId(),lockResult.getLockGrant());
  }
  /** 
 * Return this lock to its prior status. If the lock was just obtained,
 * release it. If it was promoted, demote it.
 */
  private void revertLock(  long nodeId,  LockGrantType lockStatus) throws DatabaseException {
    if ((lockStatus == LockGrantType.NEW) || (lockStatus == LockGrantType.WAIT_NEW)) {
      locker.releaseLock(nodeId);
    }
 else     if ((lockStatus == LockGrantType.PROMOTION) || (lockStatus == LockGrantType.WAIT_PROMOTION)) {
      locker.demoteLock(nodeId);
    }
  }
  /** 
 * Locks the logical EOF node for the database.
 */
  public void lockEofNode(  LockType lockType) throws DatabaseException {
    locker.lock(database.getEofNodeId(),lockType,false,database);
  }
  /** 
 * @throws RunRecoveryException if the underlying environment is invalid.
 */
  public void checkEnv() throws RunRecoveryException {
    database.getDbEnvironment().checkIfInvalid();
  }
  public CursorImpl getLockerPrev(){
    return lockerPrev;
  }
  public CursorImpl getLockerNext(){
    return lockerNext;
  }
  public void setLockerPrev(  CursorImpl p){
    lockerPrev=p;
  }
  public void setLockerNext(  CursorImpl n){
    lockerNext=n;
  }
  /** 
 * Dump the cursor for debugging purposes.  Dump the bin and dbin that the
 * cursor refers to if verbose is true.
 */
  public void dump(  boolean verbose){
    System.out.println(dumpToString(verbose));
  }
  /** 
 * dump the cursor for debugging purposes.  
 */
  public void dump(){
    System.out.println(dumpToString(true));
  }
  private String statusToString(  byte status){
switch (status) {
case CURSOR_NOT_INITIALIZED:
      return "CURSOR_NOT_INITIALIZED";
case CURSOR_INITIALIZED:
    return "CURSOR_INITIALIZED";
case CURSOR_CLOSED:
  return "CURSOR_CLOSED";
default :
return "UNKNOWN (" + Byte.toString(status) + ")";
}
}
public String dumpToString(boolean verbose){
StringBuffer sb=new StringBuffer();
sb.append("<Cursor idx=\"").append(index).append("\"");
if (dupBin != null) {
sb.append(" dupIdx=\"").append(dupIndex).append("\"");
}
sb.append(" status=\"").append(statusToString(status)).append("\"");
sb.append(">\n");
if (verbose) {
sb.append((bin == null) ? "" : bin.dumpString(2,true));
sb.append((dupBin == null) ? "" : dupBin.dumpString(2,true));
}
sb.append("\n</Cursor>");
return sb.toString();
}
//#if STATISTICS
public LockStats getLockStats() throws DatabaseException {
return locker.collectStats(new LockStats());
}
//#endif
//#if LOGGINGFINER
/** 
 * Send trace messages to the java.util.logger. Don't rely on the logger
 * alone to conditionalize whether we send this message, we don't even want
 * to construct the message if the level is not enabled.
 */
private void trace(Level level,String changeType,BIN theBin,LN ln,int lnIndex,long oldLsn,long newLsn){
//#if LOGGINGBASE
Logger logger=database.getDbEnvironment().getLogger();
//#endif
//#if LOGGINGBASE
if (logger.isLoggable(level)) 
//#if LOGGINGBASE
{
StringBuffer sb=new StringBuffer();
sb.append(changeType);
sb.append(" bin=");
sb.append(theBin.getNodeId());
sb.append(" ln=");
sb.append(ln.getNodeId());
sb.append(" lnIdx=");
sb.append(lnIndex);
sb.append(" oldLnLsn=");
sb.append(DbLsn.getNoFormatString(oldLsn));
sb.append(" newLnLsn=");
sb.append(DbLsn.getNoFormatString(newLsn));
logger.log(level,sb.toString());
}
//#endif
//#endif
}
//#endif
public void setTestHook(TestHook hook){
testHook=hook;
}
//#if LATCHES
private boolean checkAlreadyLatched(boolean alreadyLatched){
if (alreadyLatched) {
if (dupBin != null) {
return dupBin.isLatchOwner();
}
 else if (bin != null) {
return bin.isLatchOwner();
}
}
return true;
}
//#endif
}
