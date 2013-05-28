package com.sleepycat.je.log;
import java.nio.ByteBuffer;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.utilint.DbLsn;
/** 
 * DbLogBuffers hold outgoing, newly written log entries.
 */
class LogBuffer implements LogSource {
  private static final String DEBUG_NAME=LogBuffer.class.getName();
  private ByteBuffer buffer;
  private long firstLsn;
  private long lastLsn;
//#if LATCHES
  private Latch readLatch;
//#endif
//#if DISKFULLERRO
  private boolean rewriteAllowed;
//#endif
  LogBuffer(  int capacity,  EnvironmentImpl env) throws DatabaseException {
//#if NIO
    buffer=ByteBuffer.allocateDirect(capacity);
//#endif
//#if IO
    buffer=ByteBuffer.allocate(capacity);
//#endif
//#if LATCHES
    readLatch=LatchSupport.makeLatch(DEBUG_NAME,env);
//#endif
    reinit();
  }
  LogBuffer(  ByteBuffer buffer,  long firstLsn) throws DatabaseException {
    this.buffer=buffer;
    this.firstLsn=firstLsn;
    this.lastLsn=firstLsn;
//#if DISKFULLERRO
    rewriteAllowed=false;
//#endif
  }
  void reinit() throws DatabaseException {
//#if LATCHES
    readLatch.acquire();
//#endif
    buffer.clear();
    firstLsn=DbLsn.NULL_LSN;
    lastLsn=DbLsn.NULL_LSN;
//#if DISKFULLERRO
    rewriteAllowed=false;
//#endif
//#if LATCHES
    readLatch.release();
//#endif
  }
  /** 
 * Return first LSN held in this buffer. Assumes the log write latch is
 * held.
 */
  long getFirstLsn(){
    return firstLsn;
  }
  /** 
 * This LSN has been written to the log.
 */
  void registerLsn(  long lsn) throws DatabaseException {
//#if LATCHES
    readLatch.acquire();
//#endif
//#if LATCHES
    try {
      if (lastLsn != DbLsn.NULL_LSN) {
        assert (DbLsn.compareTo(lsn,lastLsn) > 0);
      }
      lastLsn=lsn;
      if (firstLsn == DbLsn.NULL_LSN) {
        firstLsn=lsn;
      }
    }
  finally {
      readLatch.release();
    }
//#endif
  }
  /** 
 * Check capacity of buffer. Assumes that the log write latch is held.
 * @return true if this buffer can hold this many more bytes.
 */
  boolean hasRoom(  int numBytes){
    return (numBytes <= (buffer.capacity() - buffer.position()));
  }
  /** 
 * @return the actual data buffer.
 */
  ByteBuffer getDataBuffer(){
    return buffer;
  }
  /** 
 * @return capacity in bytes
 */
  int getCapacity(){
    return buffer.capacity();
  }
  /** 
 * Support for reading a log entry out of a still-in-memory log
 * @return true if this buffer holds the entry at this LSN. The buffer will
 * be latched for read. Returns false if LSN is not here, and
 * releases the read latch.
 */
  boolean containsLsn(  long lsn) throws DatabaseException {
//#if LATCHES
    readLatch.acquire();
//#endif
    boolean found=false;
    if ((firstLsn != DbLsn.NULL_LSN) && ((DbLsn.compareTo(firstLsn,lsn) <= 0) && (DbLsn.compareTo(lastLsn,lsn) >= 0))) {
      found=true;
    }
    if (found) {
      return true;
    }
 else {
//#if LATCHES
      readLatch.release();
//#endif
      return false;
    }
  }
  
//#if LATCHES
  /** 
 * When modifying the buffer, acquire the readLatch. Call release() to
 * release the latch. Note that containsLsn() acquires the latch for
 * reading.
 */
  public void latchForWrite() throws DatabaseException {
    readLatch.acquire();
  }
//#endif
  
  /** 
 * @see LogSource#release
 */
  public void release() throws DatabaseException {
//#if LATCHES
	  readLatch.releaseIfOwner();
//#endif
  }
  
//#if DISKFULLERRO
  boolean getRewriteAllowed(){
    return rewriteAllowed;
  }
//#endif
  
//#if DISKFULLERRO
  void setRewriteAllowed(){
    rewriteAllowed=true;
  }
//#endif
  
  /** 
 * @see LogSource#getBytes
 */
  public ByteBuffer getBytes(  long fileOffset){
    ByteBuffer copy=null;
    while (true) {
      try {
        copy=buffer.duplicate();
        copy.position((int)(fileOffset - DbLsn.getFileOffset(firstLsn)));
        break;
      }
 catch (      IllegalArgumentException IAE) {
        continue;
      }
    }
    return copy;
  }
  /** 
 * @see LogSource#getBytes
 */
  public ByteBuffer getBytes(  long fileOffset,  int numBytes){
    ByteBuffer copy=getBytes(fileOffset);
    assert (copy.remaining() >= numBytes) : "copy.remaining=" + copy.remaining() + " numBytes="+ numBytes;
    return copy;
  }
}
