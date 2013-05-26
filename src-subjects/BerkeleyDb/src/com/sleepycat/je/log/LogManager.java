package com.sleepycat.je.log;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.List;
import java.util.zip.Checksum;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
import com.sleepycat.je.RunRecoveryException;
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
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.EnvironmentImpl;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.log.entry.LogEntry;
import com.sleepycat.je.utilint.Adler32;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.Tracer;
/** 
 * The LogManager supports reading and writing to the JE log.
 */
abstract public class LogManager {
  private static final String DEBUG_NAME=LogManager.class.getName();
  static final int HEADER_BYTES=14;
  static final int CHECKSUM_BYTES=4;
  static final int PREV_BYTES=4;
  static final int HEADER_CONTENT_BYTES=HEADER_BYTES 
//#if CHECKSUM
-CHECKSUM_BYTES
//#endif
;
//#if CHECKSUM
  static final int HEADER_CHECKSUM_OFFSET=0;
//#endif
  static final int HEADER_ENTRY_TYPE_OFFSET=4;
  static final int HEADER_VERSION_OFFSET=5;
  static final int HEADER_PREV_OFFSET=6;
  static final int HEADER_SIZE_OFFSET=6 + 4;
  protected LogBufferPool logBufferPool;
//#if LATCHES
  protected Latch logWriteLatch;
//#endif
//#if CHECKSUM
  private boolean doChecksumOnRead;
//#endif
  private FileManager fileManager;
//#if CPBYTES
//#if CHECKPOINTERDAEMON
  private CheckpointMonitor checkpointMonitor;
//#endif
//#endif
  protected EnvironmentImpl envImpl;
  private boolean readOnly;
  private int readBufferSize;
  private long lastLsnAtRecovery=DbLsn.NULL_LSN;
//#if STATISTICS
  private int nRepeatFaultReads;
//#endif
//#if STATISTICS
  private long nTempBufferWrites;
//#endif
  private TestHook readHook;
  /** 
 * There is a single log manager per database environment.
 */
  public LogManager(  EnvironmentImpl envImpl,  boolean readOnly) throws DatabaseException {
    this.envImpl=envImpl;
    this.fileManager=envImpl.getFileManager();
    DbConfigManager configManager=envImpl.getConfigManager();
    this.readOnly=readOnly;
    logBufferPool=new LogBufferPool(fileManager,envImpl);
//#if CHECKSUM
    doChecksumOnRead=configManager.getBoolean(EnvironmentParams.LOG_CHECKSUM_READ);
//#endif
//#if LATCHES
    logWriteLatch=LatchSupport.makeLatch(DEBUG_NAME,envImpl);
//#endif
    readBufferSize=configManager.getInt(EnvironmentParams.LOG_FAULT_READ_SIZE);
//#if CPBYTES
//#if CHECKPOINTERDAEMON
    checkpointMonitor=new CheckpointMonitor(envImpl);
//#endif
//#endif
  }
//#if CHECKSUM
  public boolean getChecksumOnRead(){
    return doChecksumOnRead;
  }
//#endif
  public long getLastLsnAtRecovery(){
    return lastLsnAtRecovery;
  }
  public void setLastLsnAtRecovery(  long lastLsnAtRecovery){
    this.lastLsnAtRecovery=lastLsnAtRecovery;
  }
  /** 
 * Reset the pool when the cache is resized.  This method is called after
 * the memory budget has been calculated.
 */
  public void resetPool(  DbConfigManager configManager) throws DatabaseException {
    logBufferPool.reset(configManager);
  }
  /** 
 * Log this single object and force a write of the log files.
 * @param item object to be logged
 * @param fsyncRequired if true, log files should also be fsynced.
 * @return LSN of the new log entry
 */
  public long logForceFlush(  LoggableObject item
//#if FSYNC
  , boolean fsyncRequired
//#endif
) throws DatabaseException {
    return log(item,false,true
//#if FSYNC
, fsyncRequired
//#endif
,false,DbLsn.NULL_LSN);
  }
  /** 
 * Log this single object and force a flip of the log files.
 * @param item object to be logged
 * @param fsyncRequired if true, log files should also be fsynced.
 * @return LSN of the new log entry
 */
  public long logForceFlip(  LoggableObject item) throws DatabaseException {
    return log(item,false,true
    		//#if FSYNC
    		,false
    		//#endif
    		,true,DbLsn.NULL_LSN);
  }
  /** 
 * Write a log entry.
 * @return LSN of the new log entry
 */
  public long log(  LoggableObject item) throws DatabaseException {
    return log(item,false,false
    		//#if FSYNC
    		,false
    		//#endif
    		,false,DbLsn.NULL_LSN);
  }
  /** 
 * Write a log entry.
 * @return LSN of the new log entry
 */
  public long log(  LoggableObject item,  boolean isProvisional,  long oldNodeLsn) throws DatabaseException {
    return log(item,isProvisional,false
    		//#if FSYNC
    		,false
    		//#endif
    		,false,oldNodeLsn);
  }
  /** 
 * Write a log entry.
 * @param item is the item to be logged.
 * @param isProvisional true if this entry should not be read during
 * recovery.
 * @param flushRequired if true, write the log to the file after
 * adding the item. i.e. call java.nio.channel.FileChannel.write().
 * @param fsyncRequired if true, fsync the last file after adding the item.
 * @param oldNodeLsn is the previous version of the node to be counted as
 * obsolete, or null if the item is not a node or has no old LSN.
 * @return LSN of the new log entry
 */
  private long log(  LoggableObject item,  boolean isProvisional,  boolean flushRequired
//#if FSYNC
  , boolean fsyncRequired
//#endif
,  boolean forceNewLogFile,  long oldNodeLsn) throws DatabaseException {
    if (readOnly) {
      return DbLsn.NULL_LSN;
    }
    boolean marshallOutsideLatch=item.marshallOutsideWriteLatch();
    ByteBuffer marshalledBuffer=null;
//#if CLEANER
    UtilizationTracker tracker=envImpl.getUtilizationTracker();
//#endif
    LogResult logResult=null;
    try {
      if (marshallOutsideLatch) {
        int itemSize=item.getLogSize();
        int entrySize=itemSize + HEADER_BYTES;
        marshalledBuffer=marshallIntoBuffer(item,itemSize,isProvisional,entrySize);
      }
      logResult=logItem(item,isProvisional,flushRequired,forceNewLogFile,oldNodeLsn,marshallOutsideLatch,marshalledBuffer,
//#if CLEANER
tracker
//#endif
);
    }
 catch (    BufferOverflowException e) {
      throw new RunRecoveryException(envImpl,e);
    }
catch (    IOException e) {
      throw new DatabaseException(Tracer.getStackTrace(e),e);
    }
//#if FSYNC
    if (fsyncRequired) 
//#if FSYNC
{
      fileManager.groupSync();
    }
//#endif
//#endif
//#if CPBYTES
//#if CHECKPOINTERDAEMON
    if (logResult.wakeupCheckpointer) 
//#if CPBYTES
//#if CHECKPOINTERDAEMON
{
      checkpointMonitor.activate();
    }
//#endif
//#endif
//#endif
//#endif
//#if CLEANER
    if (logResult.wakeupCleaner) 
//#if CLEANER
{
      tracker.activateCleaner();
    }
//#endif
//#endif
    return logResult.currentLsn;
  }
  abstract protected LogResult logItem(  LoggableObject item,  boolean isProvisional,  boolean flushRequired,  boolean forceNewLogFile,  long oldNodeLsn,  boolean marshallOutsideLatch,  ByteBuffer marshalledBuffer,
//#if CLEANER
  UtilizationTracker tracker
//#endif
) throws IOException, DatabaseException ;
  /** 
 * Called within the log write critical section. 
 */
  protected LogResult logInternal(  LoggableObject item,  boolean isProvisional,  boolean flushRequired,  boolean forceNewLogFile,  long oldNodeLsn,  boolean marshallOutsideLatch,  ByteBuffer marshalledBuffer,
//#if CLEANER
  UtilizationTracker tracker
//#endif
) throws IOException, DatabaseException {
    LogEntryType entryType=item.getLogType();
//#if CLEANER
    if (oldNodeLsn != DbLsn.NULL_LSN) 
//#if CLEANER
{
      tracker.countObsoleteNode(oldNodeLsn,entryType);
    }
//#endif
//#endif
    int entrySize;
    if (marshallOutsideLatch) {
      entrySize=marshalledBuffer.limit();
    }
 else {
      entrySize=item.getLogSize() + HEADER_BYTES;
    }
    if (forceNewLogFile) {
      fileManager.forceNewLogFile();
    }
    boolean flippedFile=fileManager.bumpLsn(entrySize);
    long currentLsn=DbLsn.NULL_LSN;
//#if CLEANER
    boolean wakeupCleaner=false;
//#endif
    boolean usedTemporaryBuffer=false;
    try {
      currentLsn=fileManager.getLastUsedLsn();
//#if CLEANER
      wakeupCleaner=tracker.countNewLogEntry(currentLsn,entryType,entrySize);
//#endif
//#if CLEANER
      if (item.countAsObsoleteWhenLogged()) 
//#if CLEANER
{
        tracker.countObsoleteNodeInexact(currentLsn,entryType);
      }
//#endif
//#endif
      if (!marshallOutsideLatch) {
        marshalledBuffer=marshallIntoBuffer(item,entrySize - HEADER_BYTES,isProvisional,entrySize);
      }
      if (entrySize != marshalledBuffer.limit()) {
        throw new DatabaseException("Logged item entrySize= " + entrySize + " but marshalledSize="+ marshalledBuffer.limit()+ " type="+ entryType+ " currentLsn="+ DbLsn.getNoFormatString(currentLsn));
      }
      LogBuffer useLogBuffer=logBufferPool.getWriteBuffer(entrySize,flippedFile);
      marshalledBuffer=addPrevOffsetAndChecksum(marshalledBuffer,fileManager.getPrevEntryOffset(),entrySize);
//#if LATCHES
      useLogBuffer.latchForWrite();
//#endif
//#if LATCHES
      try {
        ByteBuffer useBuffer=useLogBuffer.getDataBuffer();
        if (useBuffer.capacity() - useBuffer.position() < entrySize) {
          fileManager.writeLogBuffer(new LogBuffer(marshalledBuffer,currentLsn));
          usedTemporaryBuffer=true;
          assert useBuffer.position() == 0;
//#if STATISTICS
          nTempBufferWrites++;
//#endif
        }
 else {
          useBuffer.put(marshalledBuffer);
        }
      }
  finally {
        useLogBuffer.release();
      }
//#endif
    }
 catch (    Exception e) {
      fileManager.restoreLastPosition();
      if (e instanceof DatabaseException) {
        throw (DatabaseException)e;
      }
 else       if (e instanceof IOException) {
        throw (IOException)e;
      }
 else {
        throw new DatabaseException(e);
      }
    }
    if (!usedTemporaryBuffer) {
      logBufferPool.writeCompleted(currentLsn,flushRequired);
    }
    item.postLogWork(currentLsn);
//#if CPBYTES
//#if CHECKPOINTERDAEMON
    boolean wakeupCheckpointer=checkpointMonitor.recordLogWrite(entrySize,item);
//#endif
//#endif
    return new LogResult(currentLsn
//#if CPBYTES
//#if CHECKPOINTERDAEMON
, wakeupCheckpointer
//#endif
//#endif
//#if CLEANER
, wakeupCleaner
//#endif
);
  }
  /** 
 * Serialize a loggable object into this buffer.
 */
  private ByteBuffer marshallIntoBuffer(  LoggableObject item,  int itemSize,  boolean isProvisional,  int entrySize) throws DatabaseException {
    ByteBuffer destBuffer=ByteBuffer.allocate(entrySize);
    destBuffer.position(CHECKSUM_BYTES);
    writeHeader(destBuffer,item.getLogType(),itemSize,isProvisional);
    item.writeToLog(destBuffer);
    destBuffer.flip();
    return destBuffer;
  }
  private ByteBuffer addPrevOffsetAndChecksum(  ByteBuffer destBuffer,  long lastOffset,  int entrySize){
    Checksum checksum=Adler32.makeChecksum();
    destBuffer.position(HEADER_PREV_OFFSET);
    LogUtils.writeUnsignedInt(destBuffer,lastOffset);
    checksum.update(destBuffer.array(),CHECKSUM_BYTES,(entrySize - CHECKSUM_BYTES));
    destBuffer.position(0);
    LogUtils.writeUnsignedInt(destBuffer,checksum.getValue());
    destBuffer.position(0);
    return destBuffer;
  }
  /** 
 * Serialize a loggable object into this buffer. Return it ready for a
 * copy.
 */
  ByteBuffer putIntoBuffer(  LoggableObject item,  int itemSize,  long prevLogEntryOffset,  boolean isProvisional,  int entrySize) throws DatabaseException {
    ByteBuffer destBuffer=marshallIntoBuffer(item,itemSize,isProvisional,entrySize);
    return addPrevOffsetAndChecksum(destBuffer,0,entrySize);
  }
  /** 
 * Helper to write the common entry header.
 * @param destBuffer destination
 * @param item object being logged
 * @param itemSize We could ask the item for this, but are passing it
 * as a parameter for efficiency, because it's already available
 */
  private void writeHeader(  ByteBuffer destBuffer,  LogEntryType itemType,  int itemSize,  boolean isProvisional){
    byte typeNum=itemType.getTypeNum();
    destBuffer.put(typeNum);
    byte version=itemType.getVersion();
    if (isProvisional)     version=LogEntryType.setProvisional(version);
    destBuffer.put(version);
    destBuffer.position(HEADER_SIZE_OFFSET);
    LogUtils.writeInt(destBuffer,itemSize);
  }
  /** 
 * Instantiate all the objects in the log entry at this LSN.
 * @param lsn location of entry in log.
 * @return log entry that embodies all the objects in the log entry.
 */
  public LogEntry getLogEntry(  long lsn) throws DatabaseException {
    envImpl.checkIfInvalid();
    LogSource logSource=getLogSource(lsn);
    return getLogEntryFromLogSource(lsn,logSource);
  }
  LogEntry getLogEntry(  long lsn,  RandomAccessFile file) throws DatabaseException {
    return getLogEntryFromLogSource(lsn,new FileSource(file,readBufferSize,fileManager));
  }
  /** 
 * Instantiate all the objects in the log entry at this LSN. This will
 * release the log source at the first opportunity.
 * @param lsn location of entry in log
 * @return log entry that embodies all the objects in the log entry
 */
  private LogEntry getLogEntryFromLogSource(  long lsn,  LogSource logSource) throws DatabaseException {
    try {
      long fileOffset=DbLsn.getFileOffset(lsn);
      ByteBuffer entryBuffer=logSource.getBytes(fileOffset);
//#if CHECKSUM
      ChecksumValidator validator=null;
//#endif
//#if CHECKSUM
      long storedChecksum=LogUtils.getUnsignedInt(entryBuffer);
//#endif
//#if CHECKSUM
      if (doChecksumOnRead) 
//#if CHECKSUM
{
        validator=new ChecksumValidator();
        validator.update(envImpl,entryBuffer,HEADER_CONTENT_BYTES,false);
      }
//#endif
//#endif
      byte loggableType=entryBuffer.get();
      byte version=entryBuffer.get();
      entryBuffer.position(entryBuffer.position() + PREV_BYTES);
      int itemSize=LogUtils.readInt(entryBuffer);
      if (entryBuffer.remaining() < itemSize) {
        entryBuffer=logSource.getBytes(fileOffset + HEADER_BYTES,itemSize);
//#if STATISTICS
        nRepeatFaultReads++;
//#endif
      }
//#if CHECKSUM
      if (doChecksumOnRead) 
//#if CHECKSUM
{
        validator.update(envImpl,entryBuffer,itemSize,false);
        validator.validate(envImpl,storedChecksum,lsn);
      }
//#endif
//#endif
      assert LogEntryType.isValidType(loggableType) : "Read non-valid log entry type: " + loggableType;
      LogEntry logEntry=LogEntryType.findType(loggableType,version).getNewLogEntry();
      logEntry.readEntry(entryBuffer,itemSize,version,true);
      if (readHook != null) {
        readHook.doIOHook();
      }
      return logEntry;
    }
 catch (    DatabaseException e) {
      throw e;
    }
catch (    ClosedChannelException e) {
      throw new RunRecoveryException(envImpl,"Channel closed, may be " + "due to thread interrupt",e);
    }
catch (    Exception e) {
      throw new DatabaseException(e);
    }
 finally {
      if (logSource != null) {
        logSource.release();
      }
    }
  }
  /** 
 * Fault in the first object in the log entry log entry at this LSN.
 * @param lsn location of object in log
 * @return the object in the log
 */
  public Object get(  long lsn) throws DatabaseException {
    LogEntry entry=getLogEntry(lsn);
    return entry.getMainItem();
  }
  /** 
 * Find the LSN, whether in a file or still in the log buffers.
 */
  private LogSource getLogSource(  long lsn) throws DatabaseException {
    LogBuffer logBuffer=logBufferPool.getReadBuffer(lsn);
    if (logBuffer == null) {
      try {
        return new FileHandleSource(fileManager.getFileHandle(DbLsn.getFileNumber(lsn)),readBufferSize,fileManager);
      }
 catch (      LogFileNotFoundException e) {
        throw new LogFileNotFoundException(DbLsn.getNoFormatString(lsn) + ' ' + e.getMessage());
      }
    }
 else {
      return logBuffer;
    }
  }
  /** 
 * Flush all log entries, fsync the log file.
 */
  public void flush() throws DatabaseException {
    if (readOnly) {
      return;
    }
    flushInternal();
    fileManager.syncLogEnd();
  }
  abstract protected void flushInternal() throws LogException, DatabaseException ;
//#if STATISTICS
  public void loadStats(  StatsConfig config,  EnvironmentStats stats) throws DatabaseException {
    stats.setNRepeatFaultReads(nRepeatFaultReads);
    stats.setNTempBufferWrites(nTempBufferWrites);
    if (config.getClear()) {
      nRepeatFaultReads=0;
      nTempBufferWrites=0;
    }
    logBufferPool.loadStats(config,stats);
//#if FSYNC
    fileManager.loadStats(config,stats);
//#endif
  }
//#endif
//#if CLEANER
  /** 
 * Returns a tracked summary for the given file which will not be flushed.
 * Used for watching changes that occur while a file is being cleaned.
 */
  abstract public TrackedFileSummary getUnflushableTrackedSummary(  long file) throws DatabaseException ;
//#endif
//#if CLEANER
  protected TrackedFileSummary getUnflushableTrackedSummaryInternal(  long file) throws DatabaseException {
    return envImpl.getUtilizationTracker().getUnflushableTrackedSummary(file);
  }
//#endif
//#if CLEANER
  /** 
 * Count node as obsolete under the log write latch.  This is done here
 * because the log write latch is managed here, and all utilization
 * counting must be performed under the log write latch.
 */
  abstract public void countObsoleteNode(  long lsn,  LogEntryType type) throws DatabaseException ;
//#endif
//#if CLEANER
  protected void countObsoleteNodeInternal(
//#if CLEANER
  UtilizationTracker tracker
//#endif
,  long lsn,  LogEntryType type) throws DatabaseException {
    tracker.countObsoleteNode(lsn,type);
  }
//#endif
//#if CLEANER
  /** 
 * Counts file summary info under the log write latch.
 */
  abstract public void countObsoleteNodes(  TrackedFileSummary[] summaries) throws DatabaseException ;
//#endif
//#if CLEANER
  protected void countObsoleteNodesInternal(  UtilizationTracker tracker,  TrackedFileSummary[] summaries) throws DatabaseException {
    for (int i=0; i < summaries.length; i+=1) {
      TrackedFileSummary summary=summaries[i];
      tracker.addSummary(summary.getFileNumber(),summary);
    }
  }
//#endif
//#if CLEANER
  /** 
 * Counts the given obsolete IN LSNs under the log write latch.
 */
  abstract public void countObsoleteINs(  List lsnList) throws DatabaseException ;
//#endif
//#if CLEANER
  protected void countObsoleteINsInternal(  List lsnList) throws DatabaseException {
    UtilizationTracker tracker=envImpl.getUtilizationTracker();
    for (int i=0; i < lsnList.size(); i+=1) {
      Long offset=(Long)lsnList.get(i);
      tracker.countObsoleteNode(offset.longValue(),LogEntryType.LOG_IN);
    }
  }
//#endif
  public void setReadHook(  TestHook hook){
    readHook=hook;
  }
  /** 
 * LogResult holds the multivalue return from logInternal.
 */
static class LogResult {
    long currentLsn;
//#if CPBYTES
//#if CHECKPOINTERDAEMON
    boolean wakeupCheckpointer;
//#endif
//#endif
//#if CLEANER
    boolean wakeupCleaner;
//#endif
    LogResult(    long currentLsn 
//#if CPBYTES
//#if CHECKPOINTERDAEMON
    , boolean wakeupCheckpointer
//#endif
//#endif
//#if CLEANER
    , boolean wakeupCleaner
//#endif
){
      this.currentLsn=currentLsn;
//#if CPBYTES
//#if CHECKPOINTERDAEMON
      this.wakeupCheckpointer=wakeupCheckpointer;
//#endif
//#endif
//#if CLEANER
      this.wakeupCleaner=wakeupCleaner;
//#endif
    }
  }
}
