package com.sleepycat.je;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.dbi.PutMode;
import com.sleepycat.je.dbi.RangeRestartException;
import com.sleepycat.je.dbi.CursorImpl.KeyChangeStatus;
import com.sleepycat.je.dbi.CursorImpl.SearchMode;
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.txn.BuddyLocker;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.utilint.InternalException;
/** 
 * Javadoc for this public class is generated
 * via the doc templates in the doc_src directory.
 */
public class Cursor {
  /** 
 * The underlying cursor.
 */
  CursorImpl cursorImpl;
  /** 
 * The CursorConfig used to configure this cursor.
 */
  CursorConfig config;
  /** 
 * True if update operations are prohibited through this cursor.  Update
 * operations are prohibited if the database is read-only or:
 * (1) The database is transactional,
 * and
 * (2) The user did not supply a txn to the cursor ctor (meaning, the
 * locker is non-transactional).
 */
  private boolean updateOperationsProhibited;
  /** 
 * Handle under which this cursor was created; may be null.
 */
  private Database dbHandle;
  /** 
 * Database implementation.
 */
  private DatabaseImpl dbImpl;
  private boolean readUncommittedDefault;
  private boolean serializableIsolationDefault;
//#if LOGGINGBASE
  private Logger logger;
//#endif
  /** 
 * Creates a cursor for a given user transaction.
 * <p>If txn is null, a non-transactional cursor will be created that
 * releases locks for the prior operation when the next operation
 * suceeds.</p>
 */
  Cursor(  Database dbHandle,
//#if TRANSACTIONS
  Transaction txn
//#endif
,  CursorConfig cursorConfig) throws DatabaseException {
    if (cursorConfig == null) {
      cursorConfig=CursorConfig.DEFAULT;
    }
    Locker locker=LockerFactory.getReadableLocker(dbHandle.getEnvironment(),
//#if TRANSACTIONS
txn
//#endif
,
//#if TRANSACTIONS
dbHandle.isTransactional()
//#endif
,false,cursorConfig.getReadCommitted());
    init(dbHandle,dbHandle.getDatabaseImpl(),locker,dbHandle.isWritable(),cursorConfig);
  }
  /** 
 * Creates a cursor for a given locker.
 * <p>If locker is null or is non-transactional, a non-transactional cursor
 * will be created that releases locks for the prior operation when the
 * next operation suceeds.</p>
 */
  Cursor(  Database dbHandle,  Locker locker,  CursorConfig cursorConfig) throws DatabaseException {
    if (cursorConfig == null) {
      cursorConfig=CursorConfig.DEFAULT;
    }
    locker=LockerFactory.getReadableLocker(dbHandle.getEnvironment(),dbHandle,locker,false,cursorConfig.getReadCommitted());
    init(dbHandle,dbHandle.getDatabaseImpl(),locker,dbHandle.isWritable(),cursorConfig);
  }
  /** 
 * Creates a cursor for a given locker and no db handle.
 * <p>The locker parameter must be non-null.  With this constructor, we use
 * the given locker without applying any special rules for different
 * isolation levels -- the caller must supply the correct locker.</p>
 */
  Cursor(  DatabaseImpl dbImpl,  Locker locker,  CursorConfig cursorConfig) throws DatabaseException {
    if (cursorConfig == null) {
      cursorConfig=CursorConfig.DEFAULT;
    }
    init(null,dbImpl,locker,true,cursorConfig);
  }
  private void init(  Database dbHandle,  DatabaseImpl dbImpl,  Locker locker,  boolean isWritable,  CursorConfig cursorConfig) throws DatabaseException {
    assert locker != null;
    assert dbImpl != null;
    cursorImpl=new CursorImpl(dbImpl,locker,false);
    readUncommittedDefault=cursorConfig.getReadUncommitted() || locker.isReadUncommittedDefault();
    serializableIsolationDefault=cursorImpl.getLocker().isSerializableIsolation();
    updateOperationsProhibited=
//#if TRANSACTIONS
(dbImpl.isTransactional() && !locker.isTransactional())
//#endif
 || !isWritable;
    this.dbImpl=dbImpl;
    this.dbHandle=dbHandle;
    if (dbHandle != null) {
      dbHandle.addCursor(this);
    }
    this.config=cursorConfig;
//#if LOGGINGBASE
    this.logger=dbImpl.getDbEnvironment().getLogger();
//#endif
  }
  /** 
 * Copy constructor.
 */
  Cursor(  Cursor cursor,  boolean samePosition) throws DatabaseException {
    readUncommittedDefault=cursor.readUncommittedDefault;
    serializableIsolationDefault=cursor.serializableIsolationDefault;
    updateOperationsProhibited=cursor.updateOperationsProhibited;
    cursorImpl=cursor.cursorImpl.dup(samePosition);
    dbImpl=cursor.dbImpl;
    dbHandle=cursor.dbHandle;
    if (dbHandle != null) {
      dbHandle.addCursor(this);
    }
    config=cursor.config;
//#if LOGGINGBASE
    logger=dbImpl.getDbEnvironment().getLogger();
//#endif
  }
  /** 
 * Internal entrypoint.
 */
  CursorImpl getCursorImpl(){
    return cursorImpl;
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public Database getDatabase(){
    return dbHandle;
  }
  /** 
 * Always returns non-null, while getDatabase() returns null if no handle
 * is associated with this cursor.
 */
  DatabaseImpl getDatabaseImpl(){
    return dbImpl;
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public CursorConfig getConfig(){
    return config.cloneConfig();
  }
  void setNonCloning(  boolean nonCloning){
    cursorImpl.setNonCloning(nonCloning);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public synchronized void close() throws DatabaseException {
    checkState(false);
    cursorImpl.close();
    if (dbHandle != null) {
      dbHandle.removeCursor(this);
    }
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int count() throws DatabaseException {
    checkState(true);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.count: ",null);
//#endif
    return countInternal(null);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public Cursor dup(  boolean samePosition) throws DatabaseException {
    checkState(false);
    return new Cursor(this,samePosition);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus delete() throws DatabaseException {
    checkState(true);
    checkUpdatesAllowed("delete");
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.delete: ",null);
//#endif
    return deleteInternal();
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus put(  DatabaseEntry key,  DatabaseEntry data) throws DatabaseException {
    checkState(false);
    DatabaseUtil.checkForNullDbt(key,"key",true);
    DatabaseUtil.checkForNullDbt(data,"data",true);
    DatabaseUtil.checkForPartialKey(key);
    checkUpdatesAllowed("put");
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.put: ",key,data,null);
//#endif
    return putInternal(key,data,PutMode.OVERWRITE);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus putNoOverwrite(  DatabaseEntry key,  DatabaseEntry data) throws DatabaseException {
    checkState(false);
    DatabaseUtil.checkForNullDbt(key,"key",true);
    DatabaseUtil.checkForNullDbt(data,"data",true);
    DatabaseUtil.checkForPartialKey(key);
    checkUpdatesAllowed("putNoOverwrite");
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.putNoOverwrite: ",key,data,null);
//#endif
    return putInternal(key,data,PutMode.NOOVERWRITE);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus putNoDupData(  DatabaseEntry key,  DatabaseEntry data) throws DatabaseException {
    checkState(false);
    DatabaseUtil.checkForNullDbt(key,"key",true);
    DatabaseUtil.checkForNullDbt(data,"data",true);
    DatabaseUtil.checkForPartialKey(key);
    checkUpdatesAllowed("putNoDupData");
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.putNoDupData: ",key,data,null);
//#endif
    return putInternal(key,data,PutMode.NODUP);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus putCurrent(  DatabaseEntry data) throws DatabaseException {
    checkState(true);
    DatabaseUtil.checkForNullDbt(data,"data",true);
    checkUpdatesAllowed("putCurrent");
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.putCurrent: ",null,data,null);
//#endif
    return putInternal(null,data,PutMode.CURRENT);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getCurrent(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(true);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getCurrent: ",lockMode);
//#endif
    return getCurrentInternal(key,data,lockMode);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getFirst(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getFirst: ",lockMode);
//#endif
    return position(key,data,lockMode,true);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getLast(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getLast: ",lockMode);
//#endif
    return position(key,data,lockMode,false);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getNext(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getNext: ",lockMode);
//#endif
    if (cursorImpl.isNotInitialized()) {
      return position(key,data,lockMode,true);
    }
 else {
      return retrieveNext(key,data,lockMode,GetMode.NEXT);
    }
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getNextDup(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(true);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getNextDup: ",lockMode);
//#endif
    return retrieveNext(key,data,lockMode,GetMode.NEXT_DUP);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getNextNoDup(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getNextNoDup: ",lockMode);
//#endif
    if (cursorImpl.isNotInitialized()) {
      return position(key,data,lockMode,true);
    }
 else {
      return retrieveNext(key,data,lockMode,GetMode.NEXT_NODUP);
    }
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getPrev(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getPrev: ",lockMode);
//#endif
    if (cursorImpl.isNotInitialized()) {
      return position(key,data,lockMode,false);
    }
 else {
      return retrieveNext(key,data,lockMode,GetMode.PREV);
    }
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getPrevDup(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(true);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getPrevDup: ",lockMode);
//#endif
    return retrieveNext(key,data,lockMode,GetMode.PREV_DUP);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getPrevNoDup(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsNoValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getPrevNoDup: ",lockMode);
//#endif
    if (cursorImpl.isNotInitialized()) {
      return position(key,data,lockMode,false);
    }
 else {
      return retrieveNext(key,data,lockMode,GetMode.PREV_NODUP);
    }
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getSearchKey(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    DatabaseUtil.checkForNullDbt(key,"key",true);
    DatabaseUtil.checkForNullDbt(data,"data",false);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getSearchKey: ",key,null,lockMode);
//#endif
    return search(key,data,lockMode,SearchMode.SET);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getSearchKeyRange(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    DatabaseUtil.checkForNullDbt(key,"key",true);
    DatabaseUtil.checkForNullDbt(data,"data",false);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getSearchKeyRange: ",key,null,lockMode);
//#endif
    return search(key,data,lockMode,SearchMode.SET_RANGE);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getSearchBoth(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getSearchBoth: ",key,data,lockMode);
//#endif
    return search(key,data,lockMode,SearchMode.BOTH);
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public OperationStatus getSearchBothRange(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    checkState(false);
    checkArgsValRequired(key,data);
//#if LOGGINGFINEST
    trace(Level.FINEST,"Cursor.getSearchBothRange: ",key,data,lockMode);
//#endif
    return search(key,data,lockMode,SearchMode.BOTH_RANGE);
  }
  /** 
 * Counts duplicates without parameter checking.
 */
  int countInternal(  LockMode lockMode) throws DatabaseException {
    CursorImpl original=null;
    CursorImpl dup=null;
    try {
      original=cursorImpl;
      dup=original.cloneCursor(true);
      return dup.count(getLockType(lockMode,false));
    }
  finally {
      if (dup != original) {
        dup.close();
      }
    }
  }
  /** 
 * Internal version of delete() that does no parameter checking.  Calls
 * deleteNoNotify() and notifies triggers (performs secondary updates).
 */
  OperationStatus deleteInternal() throws DatabaseException {
    DatabaseEntry oldKey=null;
    DatabaseEntry oldData=null;
    boolean doNotifyTriggers=dbHandle != null && dbHandle.hasTriggers();
    if (doNotifyTriggers) {
      oldKey=new DatabaseEntry();
      oldData=new DatabaseEntry();
      OperationStatus status=getCurrentInternal(oldKey,oldData,LockMode.RMW);
      if (status != OperationStatus.SUCCESS) {
        return OperationStatus.KEYEMPTY;
      }
    }
    if (doNotifyTriggers) {
      dbHandle.notifyTriggers(cursorImpl.getLocker(),oldKey,oldData,null);
    }
    OperationStatus status=deleteNoNotify();
    return status;
  }
  /** 
 * Clone the cursor, delete at current position, and if successful, swap
 * cursors.  Does not notify triggers (does not perform secondary updates).
 */
  OperationStatus deleteNoNotify() throws DatabaseException {
    CursorImpl original=null;
    CursorImpl dup=null;
    OperationStatus status=OperationStatus.KEYEMPTY;
    try {
      original=cursorImpl;
      dup=original.cloneCursor(true);
//#if LATCHES
      dup.latchBINs();
//#endif
      status=dup.delete();
      return status;
    }
  finally {
//#if LATCHES
      if (original != null) 
//#if LATCHES
{
        original.releaseBINs();
      }
//#endif
//#endif
//#if LATCHES
      if (dup != null) 
//#if LATCHES
{
        dup.releaseBINs();
      }
//#endif
//#endif
      boolean success=(status == OperationStatus.SUCCESS);
      if (cursorImpl == dup) {
        if (!success) {
          cursorImpl.reset();
        }
      }
 else {
        if (success) {
          original.close();
          cursorImpl=dup;
        }
 else {
          dup.close();
        }
      }
    }
  }
  /** 
 * Internal version of put() that does no parameter checking.  Calls
 * putNoNotify() and notifies triggers (performs secondary updates).
 * Prevents phantoms.
 */
  OperationStatus putInternal(  DatabaseEntry key,  DatabaseEntry data,  PutMode putMode) throws DatabaseException {
    DatabaseEntry oldData=null;
    boolean doNotifyTriggers=dbHandle != null && dbHandle.hasTriggers();
    if (doNotifyTriggers && (putMode == PutMode.CURRENT || putMode == PutMode.OVERWRITE)) {
      oldData=new DatabaseEntry();
      if (key == null && putMode == PutMode.CURRENT) {
        key=new DatabaseEntry();
      }
    }
    OperationStatus commitStatus=putNoNotify(key,data,putMode,oldData);
    if (doNotifyTriggers && commitStatus == OperationStatus.SUCCESS) {
      if (oldData != null && oldData.getData() == null) {
        oldData=null;
      }
      dbHandle.notifyTriggers(cursorImpl.getLocker(),key,oldData,data);
    }
    return commitStatus;
  }
  /** 
 * Performs the put operation but does not notify triggers (does not
 * perform secondary updates).  Prevents phantoms.
 */
  OperationStatus putNoNotify(  DatabaseEntry key,  DatabaseEntry data,  PutMode putMode,  DatabaseEntry returnOldData) throws DatabaseException {
    Locker nextKeyLocker=null;
    CursorImpl nextKeyCursor=null;
    try {
      Locker cursorLocker=cursorImpl.getLocker();
//#if TRANSACTIONS
      if (putMode != PutMode.CURRENT && dbImpl.getDbEnvironment().getTxnManager().areOtherSerializableTransactionsActive(cursorLocker)) 
//#if TRANSACTIONS
{
        nextKeyLocker=new BuddyLocker(dbImpl.getDbEnvironment(),cursorLocker);
        nextKeyCursor=new CursorImpl(dbImpl,nextKeyLocker);
        nextKeyCursor.lockNextKeyForInsert(key,data);
      }
//#endif
//#endif
      return putAllowPhantoms(key,data,putMode,returnOldData,nextKeyCursor);
    }
  finally {
      if (nextKeyCursor != null) {
        nextKeyCursor.close();
      }
      if (nextKeyLocker != null) {
        nextKeyLocker.operationEnd();
      }
    }
  }
  /** 
 * Clone the cursor, put key/data according to PutMode, and if successful,
 * swap cursors.  Does not notify triggers (does not perform secondary
 * updates).  Does not prevent phantoms.
 * @param nextKeyCursor is the cursor used to lock the next key during
 * phantom prevention.  If this cursor is non-null and initialized, it's
 * BIN will be used to initialize the dup cursor used to perform insertion.
 * This enables an optimization that skips the search for the BIN.
 */
  private OperationStatus putAllowPhantoms(  DatabaseEntry key,  DatabaseEntry data,  PutMode putMode,  DatabaseEntry returnOldData,  CursorImpl nextKeyCursor) throws DatabaseException {
    if (data == null) {
      throw new NullPointerException("put passed a null DatabaseEntry arg");
    }
    if (putMode != PutMode.CURRENT && key == null) {
      throw new IllegalArgumentException("put passed a null DatabaseEntry arg");
    }
    CursorImpl original=null;
    OperationStatus status=OperationStatus.NOTFOUND;
    CursorImpl dup=null;
    try {
      original=cursorImpl;
      if (putMode == PutMode.CURRENT) {
        dup=original.cloneCursor(true);
      }
 else {
        dup=original.cloneCursor(false,nextKeyCursor);
      }
      if (putMode == PutMode.CURRENT) {
        status=dup.putCurrent(data,key,returnOldData);
      }
 else       if (putMode == PutMode.OVERWRITE) {
        status=dup.put(key,data,returnOldData);
      }
 else       if (putMode == PutMode.NOOVERWRITE) {
        status=dup.putNoOverwrite(key,data);
      }
 else       if (putMode == PutMode.NODUP) {
        status=dup.putNoDupData(key,data);
      }
 else {
        throw new InternalException("unknown PutMode");
      }
      return status;
    }
  finally {
//#if LATCHES
      if (original != null) 
//#if LATCHES
{
        original.releaseBINs();
      }
//#endif
//#endif
      boolean success=(status == OperationStatus.SUCCESS);
      if (cursorImpl == dup) {
        if (!success) {
          cursorImpl.reset();
        }
      }
 else {
        if (success) {
          original.close();
          cursorImpl=dup;
        }
 else {
          if (dup != null) {
            dup.close();
          }
        }
      }
    }
  }
  /** 
 * Position the cursor at the first or last record of the database.
 * Prevents phantoms.
 */
  OperationStatus position(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode,  boolean first) throws DatabaseException {
    if (!isSerializableIsolation(lockMode)) {
      return positionAllowPhantoms(key,data,getLockType(lockMode,false),first);
    }
    while (true) {
      try {
        if (!first) {
          cursorImpl.lockEofNode(LockType.RANGE_READ);
        }
        LockType lockType=getLockType(lockMode,first);
        OperationStatus status=positionAllowPhantoms(key,data,lockType,first);
        if (first && status != OperationStatus.SUCCESS) {
          cursorImpl.lockEofNode(LockType.RANGE_READ);
        }
        return status;
      }
 catch (      RangeRestartException e) {
        continue;
      }
    }
  }
  /** 
 * Position without preventing phantoms.
 */
  private OperationStatus positionAllowPhantoms(  DatabaseEntry key,  DatabaseEntry data,  LockType lockType,  boolean first) throws DatabaseException {
    assert (key != null && data != null);
    OperationStatus status=OperationStatus.NOTFOUND;
    CursorImpl dup=null;
    try {
      dup=beginRead(false);
      if (!dup.positionFirstOrLast(first,null)) {
        status=OperationStatus.NOTFOUND;
//#if LATCHES
        assert LatchSupport.countLatchesHeld() == 0 : LatchSupport.latchesHeldToString();
//#endif
      }
 else {
//#if LATCHES
        assert LatchSupport.countLatchesHeld() == 1 : LatchSupport.latchesHeldToString();
//#endif
        status=dup.getCurrentAlreadyLatched(key,data,lockType,first);
        if (status == OperationStatus.SUCCESS) {
          if (dup.getDupBIN() != null) {
            dup.incrementLNCount();
          }
        }
 else {
          status=dup.getNext(key,data,lockType,first,false);
        }
      }
    }
  finally {
//#if LATCHES
      cursorImpl.releaseBINs();
//#endif
      endRead(dup,status == OperationStatus.SUCCESS);
    }
    return status;
  }
  /** 
 * Perform search by key, data, or both.  Prevents phantoms.
 */
  OperationStatus search(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode,  SearchMode searchMode) throws DatabaseException {
    if (!isSerializableIsolation(lockMode)) {
      LockType lockType=getLockType(lockMode,false);
      KeyChangeStatus result=searchAllowPhantoms(key,data,lockType,lockType,searchMode);
      return result.status;
    }
    while (true) {
      try {
        LockType searchLockType=getLockType(lockMode,false);
        LockType advanceLockType=getLockType(lockMode,true);
        DatabaseEntry tryKey=new DatabaseEntry(key.getData(),key.getOffset(),key.getSize());
        DatabaseEntry tryData=new DatabaseEntry(data.getData(),data.getOffset(),data.getSize());
        KeyChangeStatus result;
        if (searchMode.isExactSearch()) {
          result=searchExactAndRangeLock(tryKey,tryData,searchLockType,advanceLockType,searchMode);
        }
 else {
          result=searchAllowPhantoms(tryKey,tryData,searchLockType,advanceLockType,searchMode);
          if (result.status != OperationStatus.SUCCESS) {
            cursorImpl.lockEofNode(LockType.RANGE_READ);
          }
        }
        if (result.status == OperationStatus.SUCCESS) {
          key.setData(tryKey.getData(),0,tryKey.getSize());
          data.setData(tryData.getData(),0,tryData.getSize());
        }
        return result.status;
      }
 catch (      RangeRestartException e) {
        continue;
      }
    }
  }
  /** 
 * For an exact search, perform a range search and return NOTFOUND if the
 * key changes (or if the data changes for BOTH) during the search.
 * If no exact match is found the range search will range lock the
 * following key for phantom prevention.  Importantly, the cursor position
 * is not changed if an exact match is not found, even though we advance to
 * the following key in order to range lock it.
 */
  private KeyChangeStatus searchExactAndRangeLock(  DatabaseEntry key,  DatabaseEntry data,  LockType searchLockType,  LockType advanceLockType,  SearchMode searchMode) throws DatabaseException {
    searchMode=(searchMode == SearchMode.SET) ? SearchMode.SET_RANGE : SearchMode.BOTH_RANGE;
    KeyChangeStatus result=null;
    boolean noNextKeyFound;
    CursorImpl dup=beginRead(false);
    try {
      result=searchInternal(dup,key,data,searchLockType,advanceLockType,searchMode,true);
      noNextKeyFound=!result.keyChange;
      if (result.keyChange && result.status == OperationStatus.SUCCESS) {
        result.status=OperationStatus.NOTFOUND;
      }
    }
  finally {
      endRead(dup,result != null && result.status == OperationStatus.SUCCESS);
    }
    if (noNextKeyFound) {
      cursorImpl.lockEofNode(LockType.RANGE_READ);
    }
    return result;
  }
  /** 
 * Perform search without preventing phantoms.
 */
  private KeyChangeStatus searchAllowPhantoms(  DatabaseEntry key,  DatabaseEntry data,  LockType searchLockType,  LockType advanceLockType,  SearchMode searchMode) throws DatabaseException {
    OperationStatus status=OperationStatus.NOTFOUND;
    CursorImpl dup=beginRead(false);
    try {
      KeyChangeStatus result=searchInternal(dup,key,data,searchLockType,advanceLockType,searchMode,false);
      status=result.status;
      return result;
    }
  finally {
      endRead(dup,status == OperationStatus.SUCCESS);
    }
  }
  /** 
 * Perform search for a given CursorImpl.
 */
  private KeyChangeStatus searchInternal(  CursorImpl dup,  DatabaseEntry key,  DatabaseEntry data,  LockType searchLockType,  LockType advanceLockType,  SearchMode searchMode,  boolean advanceAfterRangeSearch) throws DatabaseException {
    assert key != null && data != null;
    OperationStatus status=OperationStatus.NOTFOUND;
    boolean keyChange=false;
//#if LATCHES
    try {
      int searchResult=dup.searchAndPosition(key,data,searchMode,searchLockType);
      if ((searchResult & CursorImpl.FOUND) != 0) {
        boolean exactKeyMatch=((searchResult & CursorImpl.EXACT_KEY) != 0);
        boolean exactDataMatch=((searchResult & CursorImpl.EXACT_DATA) != 0);
        boolean foundLast=((searchResult & CursorImpl.FOUND_LAST) != 0);
        boolean rangeMatch=false;
        if (searchMode == SearchMode.SET_RANGE && !exactKeyMatch) {
          rangeMatch=true;
        }
        if (searchMode == SearchMode.BOTH_RANGE && (!exactKeyMatch || !exactDataMatch)) {
          rangeMatch=true;
        }
        DatabaseEntry useKey=(searchMode == SearchMode.SET) ? null : key;
        if (rangeMatch || (status=dup.getCurrentAlreadyLatched(useKey,data,searchLockType,true)) == OperationStatus.KEYEMPTY) {
          if (foundLast) {
            status=OperationStatus.NOTFOUND;
          }
 else           if (searchMode == SearchMode.SET) {
            status=dup.getNextDuplicate(key,data,advanceLockType,true,rangeMatch);
          }
 else           if (searchMode == SearchMode.BOTH) {
            if (status == OperationStatus.KEYEMPTY) {
              status=OperationStatus.NOTFOUND;
            }
          }
 else {
            assert !searchMode.isExactSearch();
            byte[] searchKey=null;
            if (searchMode.isDataSearch()) {
              searchKey=Key.makeKey(key);
            }
            if (exactKeyMatch) {
              KeyChangeStatus result=dup.getNextWithKeyChangeStatus(key,data,advanceLockType,true,rangeMatch);
              status=result.status;
              keyChange=searchMode.isDataSearch() ? (status == OperationStatus.SUCCESS) : result.keyChange;
            }
 else             if (searchMode.isDataSearch() && !advanceAfterRangeSearch) {
              status=OperationStatus.NOTFOUND;
            }
 else {
              status=dup.getNextNoDup(key,data,advanceLockType,true,rangeMatch);
              keyChange=(status == OperationStatus.SUCCESS);
            }
            if (status == OperationStatus.SUCCESS && searchMode.isDataSearch()) {
              if (Key.compareKeys(key.getData(),searchKey,dbImpl.getDuplicateComparator()) != 0) {
                status=OperationStatus.NOTFOUND;
              }
            }
          }
        }
      }
    }
  finally {
      cursorImpl.releaseBINs();
      if (status != OperationStatus.SUCCESS && dup != cursorImpl) {
        dup.releaseBINs();
      }
    }
//#endif
    return new KeyChangeStatus(status,keyChange);
  }
  /** 
 * Retrieve the next or previous record.  Prevents phantoms.
 */
  OperationStatus retrieveNext(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode,  GetMode getMode) throws DatabaseException {
    if (!isSerializableIsolation(lockMode)) {
      return retrieveNextAllowPhantoms(key,data,getLockType(lockMode,false),getMode);
    }
    while (true) {
      try {
        OperationStatus status;
        if (getMode == GetMode.NEXT_DUP) {
          status=getNextDupAndRangeLock(key,data,lockMode);
        }
 else {
          if (!getMode.isForward()) {
            rangeLockCurrentPosition(getMode);
          }
          LockType lockType=getLockType(lockMode,getMode.isForward());
          status=retrieveNextAllowPhantoms(key,data,lockType,getMode);
          if (getMode.isForward() && status != OperationStatus.SUCCESS) {
            cursorImpl.lockEofNode(LockType.RANGE_READ);
          }
        }
        return status;
      }
 catch (      RangeRestartException e) {
        continue;
      }
    }
  }
  /** 
 * Retrieve the next dup; if no next dup is found then range lock the
 * following key for phantom prevention.  Importantly, the cursor position
 * is not changed if there are no more dups, even though we advance to the
 * following key in order to range lock it.
 */
  private OperationStatus getNextDupAndRangeLock(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    DatabaseEntry tryKey=new DatabaseEntry();
    DatabaseEntry tryData=new DatabaseEntry();
    LockType lockType=getLockType(lockMode,true);
    OperationStatus status;
    boolean noNextKeyFound;
    while (true) {
//#if LATCHES
      assert LatchSupport.countLatchesHeld() == 0;
//#endif
      CursorImpl dup=beginRead(true);
      try {
        KeyChangeStatus result=dup.getNextWithKeyChangeStatus(tryKey,tryData,lockType,true,false);
        status=result.status;
        noNextKeyFound=(status != OperationStatus.SUCCESS);
        if (result.keyChange && status == OperationStatus.SUCCESS) {
          status=OperationStatus.NOTFOUND;
        }
      }
 catch (      DatabaseException DBE) {
        endRead(dup,false);
        throw DBE;
      }
      if (checkForInsertion(GetMode.NEXT,cursorImpl,dup)) {
        endRead(dup,false);
        continue;
      }
 else {
        endRead(dup,status == OperationStatus.SUCCESS);
//#if LATCHES
        assert LatchSupport.countLatchesHeld() == 0;
//#endif
        break;
      }
    }
    if (noNextKeyFound) {
      cursorImpl.lockEofNode(LockType.RANGE_READ);
    }
    if (status == OperationStatus.SUCCESS) {
      key.setData(tryKey.getData(),0,tryKey.getSize());
      data.setData(tryData.getData(),0,tryData.getSize());
    }
    return status;
  }
  /** 
 * For 'prev' operations, upgrade to a range lock at the current position.
 * For PREV_NODUP, range lock the first duplicate instead.  If there are no
 * records at the current position, get a range lock on the next record or,
 * if not found, on the logical EOF node.  Do not modify the current
 * cursor position, use a separate cursor.
 */
  private void rangeLockCurrentPosition(  GetMode getMode) throws DatabaseException {
    DatabaseEntry tempKey=new DatabaseEntry();
    DatabaseEntry tempData=new DatabaseEntry();
    tempKey.setPartial(0,0,true);
    tempData.setPartial(0,0,true);
    OperationStatus status;
    CursorImpl dup=cursorImpl.cloneCursor(true);
    try {
      if (getMode == GetMode.PREV_NODUP) {
        status=dup.getFirstDuplicate(tempKey,tempData,LockType.RANGE_READ);
      }
 else {
        status=dup.getCurrent(tempKey,tempData,LockType.RANGE_READ);
      }
      if (status != OperationStatus.SUCCESS) {
        while (true) {
//#if LATCHES
          assert LatchSupport.countLatchesHeld() == 0;
//#endif
          status=dup.getNext(tempKey,tempData,LockType.RANGE_READ,true,false);
          if (checkForInsertion(GetMode.NEXT,cursorImpl,dup)) {
            dup.close();
            dup=cursorImpl.cloneCursor(true);
            continue;
          }
 else {
//#if LATCHES
            assert LatchSupport.countLatchesHeld() == 0;
//#endif
            break;
          }
        }
      }
    }
  finally {
      if (cursorImpl == dup) {
        dup.reset();
      }
 else {
        dup.close();
      }
    }
    if (status != OperationStatus.SUCCESS) {
      cursorImpl.lockEofNode(LockType.RANGE_READ);
    }
  }
  /** 
 * Retrieve without preventing phantoms.
 */
  private OperationStatus retrieveNextAllowPhantoms(  DatabaseEntry key,  DatabaseEntry data,  LockType lockType,  GetMode getMode) throws DatabaseException {
    assert (key != null && data != null);
    OperationStatus status;
    while (true) {
//#if LATCHES
      assert LatchSupport.countLatchesHeld() == 0;
//#endif
      CursorImpl dup=beginRead(true);
      try {
        if (getMode == GetMode.NEXT) {
          status=dup.getNext(key,data,lockType,true,false);
        }
 else         if (getMode == GetMode.PREV) {
          status=dup.getNext(key,data,lockType,false,false);
        }
 else         if (getMode == GetMode.NEXT_DUP) {
          status=dup.getNextDuplicate(key,data,lockType,true,false);
        }
 else         if (getMode == GetMode.PREV_DUP) {
          status=dup.getNextDuplicate(key,data,lockType,false,false);
        }
 else         if (getMode == GetMode.NEXT_NODUP) {
          status=dup.getNextNoDup(key,data,lockType,true,false);
        }
 else         if (getMode == GetMode.PREV_NODUP) {
          status=dup.getNextNoDup(key,data,lockType,false,false);
        }
 else {
          throw new InternalException("unknown GetMode");
        }
      }
 catch (      DatabaseException DBE) {
        endRead(dup,false);
        throw DBE;
      }
      if (checkForInsertion(getMode,cursorImpl,dup)) {
        endRead(dup,false);
        continue;
      }
 else {
        endRead(dup,status == OperationStatus.SUCCESS);
//#if LATCHES
        assert LatchSupport.countLatchesHeld() == 0;
//#endif
        break;
      }
    }
    return status;
  }
  /** 
 * Returns the current key and data.  There is no need to prevent phantoms.
 */
  OperationStatus getCurrentInternal(  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode) throws DatabaseException {
    LockType lockType=getLockType(lockMode,false);
    return cursorImpl.getCurrent(key,data,lockType);
  }
  private boolean checkForInsertion(  GetMode getMode,  CursorImpl origCursor,  CursorImpl dupCursor) throws DatabaseException {
    BIN origBIN=origCursor.getBIN();
    BIN dupBIN=dupCursor.getBIN();
    DBIN origDBIN=origCursor.getDupBIN();
    boolean forward=true;
    if (getMode == GetMode.PREV || getMode == GetMode.PREV_DUP || getMode == GetMode.PREV_NODUP) {
      forward=false;
    }
    boolean ret=false;
    if (origBIN != dupBIN) {
//#if LATCHES
      origCursor.latchBINs();
//#endif
      if (origDBIN == null) {
        if (forward) {
          if (origBIN.getNEntries() - 1 > origCursor.getIndex()) {
            for (int i=origCursor.getIndex() + 1; i < origBIN.getNEntries(); i++) {
              if (!origBIN.isEntryKnownDeleted(i)) {
                Node n=origBIN.fetchTarget(i);
                if (n != null && !n.containsDuplicates()) {
                  LN ln=(LN)n;
                  if (!ln.isDeleted()) {
                    ret=true;
                    break;
                  }
                }
              }
 else {
              }
            }
          }
        }
 else {
          if (origCursor.getIndex() > 0) {
            for (int i=0; i < origCursor.getIndex(); i++) {
              if (!origBIN.isEntryKnownDeleted(i)) {
                Node n=origBIN.fetchTarget(i);
                if (n != null && !n.containsDuplicates()) {
                  LN ln=(LN)n;
                  if (!ln.isDeleted()) {
                    ret=true;
                    break;
                  }
                }
 else {
                }
              }
            }
          }
        }
      }
//#if LATCHES
      origCursor.releaseBINs();
//#endif
      return ret;
    }
    if (origDBIN != dupCursor.getDupBIN() && origCursor.getIndex() == dupCursor.getIndex() && getMode != GetMode.NEXT_NODUP && getMode != GetMode.PREV_NODUP) {
//#if LATCHES
      origCursor.latchBINs();
//#endif
      if (forward) {
        if (origDBIN.getNEntries() - 1 > origCursor.getDupIndex()) {
          for (int i=origCursor.getDupIndex() + 1; i < origDBIN.getNEntries(); i++) {
            if (!origDBIN.isEntryKnownDeleted(i)) {
              Node n=origDBIN.fetchTarget(i);
              LN ln=(LN)n;
              if (n != null && !ln.isDeleted()) {
                ret=true;
                break;
              }
            }
          }
        }
      }
 else {
        if (origCursor.getDupIndex() > 0) {
          for (int i=0; i < origCursor.getDupIndex(); i++) {
            if (!origDBIN.isEntryKnownDeleted(i)) {
              Node n=origDBIN.fetchTarget(i);
              LN ln=(LN)n;
              if (n != null && !ln.isDeleted()) {
                ret=true;
                break;
              }
            }
          }
        }
      }
//#if LATCHES
      origCursor.releaseBINs();
//#endif
      return ret;
    }
    return false;
  }
  /** 
 * If the cursor is initialized, dup it and return the dup; otherwise,
 * return the original.  This avoids the overhead of duping when the
 * original is uninitialized.  The cursor returned must be passed to
 * endRead() to close the correct cursor.
 */
  private CursorImpl beginRead(  boolean addCursor) throws DatabaseException {
    CursorImpl dup;
    if (cursorImpl.isNotInitialized()) {
      dup=cursorImpl;
    }
 else {
      dup=cursorImpl.cloneCursor(addCursor);
    }
    return dup;
  }
  /** 
 * If the operation is successful, swaps cursors and closes the original
 * cursor; otherwise, closes the duped cursor.  In the case where the
 * original cursor was not duped by beginRead because it was uninitialized,
 * just resets the original cursor if the operation did not succeed.
 */
  private void endRead(  CursorImpl dup,  boolean success) throws DatabaseException {
    if (dup == cursorImpl) {
      if (!success) {
        cursorImpl.reset();
      }
    }
 else {
      if (success) {
        cursorImpl.close();
        cursorImpl=dup;
      }
 else {
        dup.close();
      }
    }
  }
  boolean advanceCursor(  DatabaseEntry key,  DatabaseEntry data){
    return cursorImpl.advanceCursor(key,data);
  }
  private LockType getLockType(  LockMode lockMode,  boolean rangeLock){
    if (isReadUncommittedMode(lockMode)) {
      return LockType.NONE;
    }
 else     if (lockMode == null || lockMode == LockMode.DEFAULT) {
      return rangeLock ? LockType.RANGE_READ : LockType.READ;
    }
 else     if (lockMode == LockMode.RMW) {
      return rangeLock ? LockType.RANGE_WRITE : LockType.WRITE;
    }
 else     if (lockMode == LockMode.READ_COMMITTED) {
      throw new IllegalArgumentException(lockMode.toString() + " not allowed with Cursor methods");
    }
 else {
      assert false : lockMode;
      return LockType.NONE;
    }
  }
  /** 
 * Returns whether the given lock mode will cause a read-uncommitted when
 * used with this cursor, taking into account the default cursor
 * configuration.
 */
  boolean isReadUncommittedMode(  LockMode lockMode){
    return (lockMode == LockMode.READ_UNCOMMITTED || (readUncommittedDefault && (lockMode == null || lockMode == LockMode.DEFAULT)));
  }
  private boolean isSerializableIsolation(  LockMode lockMode){
    return serializableIsolationDefault && !isReadUncommittedMode(lockMode);
  }
  protected void checkUpdatesAllowed(  String operation) throws DatabaseException {
    if (updateOperationsProhibited) {
      throw new DatabaseException("A transaction was not supplied when opening this cursor: " + operation);
    }
  }
  /** 
 * Note that this flavor of checkArgs doesn't require that the dbt data is
 * set.
 */
  private void checkArgsNoValRequired(  DatabaseEntry key,  DatabaseEntry data){
    DatabaseUtil.checkForNullDbt(key,"key",false);
    DatabaseUtil.checkForNullDbt(data,"data",false);
  }
  /** 
 * Note that this flavor of checkArgs requires that the dbt data is set.
 */
  private void checkArgsValRequired(  DatabaseEntry key,  DatabaseEntry data){
    DatabaseUtil.checkForNullDbt(key,"key",true);
    DatabaseUtil.checkForNullDbt(data,"data",true);
  }
  /** 
 * Check the environment and cursor state.
 */
  void checkState(  boolean mustBeInitialized) throws DatabaseException {
    checkEnv();
    cursorImpl.checkCursorState(mustBeInitialized);
  }
  /** 
 * @throws RunRecoveryException if the underlying environment is invalid.
 */
  void checkEnv() throws RunRecoveryException {
    cursorImpl.checkEnv();
  }
//#if LOGGINGFINEST
  /** 
 * Send trace messages to the java.util.logger. Don't rely on the logger
 * alone to conditionalize whether we send this message, we don't even want
 * to construct the message if the level is not enabled.
 */
  void trace(  Level level,  String methodName,  DatabaseEntry key,  DatabaseEntry data,  LockMode lockMode){
//#if LOGGINGBASE
    if (logger.isLoggable(level)) 
//#if LOGGINGBASE
{
      StringBuffer sb=new StringBuffer();
      sb.append(methodName);
      traceCursorImpl(sb);
      if (key != null) {
        sb.append(" key=").append(key.dumpData());
      }
      if (data != null) {
        sb.append(" data=").append(data.dumpData());
      }
      if (lockMode != null) {
        sb.append(" lockMode=").append(lockMode);
      }
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
void
//#endif
 
//#if LOGGINGFINEST
trace
//#endif
(
//#if LOGGINGFINEST
  Level level
//#endif
,
//#if LOGGINGFINEST
  String methodName
//#endif
,
//#if LOGGINGFINEST
  LockMode lockMode
//#endif
)
//#if LOGGINGFINEST
{
//#if LOGGINGBASE
    if (logger.isLoggable(level)) 
//#if LOGGINGBASE
{
      StringBuffer sb=new StringBuffer();
      sb.append(methodName);
      traceCursorImpl(sb);
      if (lockMode != null) {
        sb.append(" lockMode=").append(lockMode);
      }
      logger.log(level,sb.toString());
    }
//#endif
//#endif
  }
//#endif
//#endif
  private void traceCursorImpl(  StringBuffer sb){
    sb.append(" locker=").append(cursorImpl.getLocker().getId());
    if (cursorImpl.getBIN() != null) {
      sb.append(" bin=").append(cursorImpl.getBIN().getNodeId());
    }
    sb.append(" idx=").append(cursorImpl.getIndex());
    if (cursorImpl.getDupBIN() != null) {
      sb.append(" Dbin=").append(cursorImpl.getDupBIN().getNodeId());
    }
    sb.append(" dupIdx=").append(cursorImpl.getDupIndex());
  }
}
