package com.sleepycat.je.log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
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
/** 
 * LogBufferPool keeps a set of log buffers.
 */
class LogBufferPool {
  private static final String DEBUG_NAME=LogBufferPool.class.getName();
  private EnvironmentImpl envImpl=null;
  private int logBufferSize;
  private LinkedList bufferPool;
  private LogBuffer currentWriteBuffer;
  private FileManager fileManager;
//#if STATISTICS
  private long nNotResident=0;
//#endif
//#if STATISTICS
  private long nCacheMiss=0;
//#endif
  private boolean runInMemory;
//#if LATCHES
  private Latch bufferPoolLatch;
//#endif
  LogBufferPool(  FileManager fileManager,  EnvironmentImpl envImpl) throws DatabaseException {
    this.fileManager=fileManager;
    this.envImpl=envImpl;
//#if LATCHES
    bufferPoolLatch=LatchSupport.makeLatch(DEBUG_NAME + "_FullLatch",envImpl);
//#endif
    DbConfigManager configManager=envImpl.getConfigManager();
    runInMemory=configManager.getBoolean(EnvironmentParams.LOG_MEMORY_ONLY);
    reset(configManager);
    currentWriteBuffer=(LogBuffer)bufferPool.getFirst();
  }
  /** 
 * Initialize the pool at construction time and when the cache is resized.
 * This method is called after the memory budget has been calculated.
 */
  void reset(  DbConfigManager configManager) throws DatabaseException {
    if (runInMemory && bufferPool != null) {
      return;
    }
    int numBuffers=configManager.getInt(EnvironmentParams.NUM_LOG_BUFFERS);
    long logBufferBudget=envImpl.getMemoryBudget().getLogBufferBudget();
    int newBufferSize=(int)logBufferBudget / numBuffers;
    LinkedList newPool=new LinkedList();
    if (runInMemory) {
      numBuffers=1;
    }
    for (int i=0; i < numBuffers; i++) {
      newPool.add(new LogBuffer(newBufferSize,envImpl));
    }
//#if LATCHES
    bufferPoolLatch.acquire();
//#endif
    bufferPool=newPool;
    logBufferSize=newBufferSize;
//#if LATCHES
    bufferPoolLatch.release();
//#endif
  }
  /** 
 * Get a log buffer for writing sizeNeeded bytes. If currentWriteBuffer is
 * too small or too full, flush currentWriteBuffer and get a new one.
 * Called within the log write latch.
 * @return a buffer that can hold sizeNeeded bytes.
 */
  LogBuffer getWriteBuffer(  int sizeNeeded,  boolean flippedFile) throws IOException, DatabaseException {
    if ((!currentWriteBuffer.hasRoom(sizeNeeded)) || flippedFile) {
      writeBufferToFile(sizeNeeded);
    }
    if (flippedFile) {
      if (!runInMemory) {
        fileManager.syncLogEndAndFinishFile();
      }
    }
    return currentWriteBuffer;
  }
  /** 
 * Write the contents of the currentWriteBuffer to disk.  Leave this buffer
 * in memory to be available to would be readers.  Set up a new
 * currentWriteBuffer. Assumes the log write latch is held.
 * @param sizeNeeded is the size of the next object we need to write to
 * the log. May be 0 if this is called on behalf of LogManager.flush().
 */
  void writeBufferToFile(  int sizeNeeded) throws IOException, DatabaseException {
    int bufferSize=((logBufferSize > sizeNeeded) ? logBufferSize : sizeNeeded);
//#if LATCHES
    currentWriteBuffer.latchForWrite();
//#endif
    LogBuffer latchedBuffer=currentWriteBuffer;
//#if LATCHES
    try {
      ByteBuffer currentByteBuffer=currentWriteBuffer.getDataBuffer();
      int savePosition=currentByteBuffer.position();
      int saveLimit=currentByteBuffer.limit();
      currentByteBuffer.flip();
      if (runInMemory) {
//#if LATCHES
        latchedBuffer.release();
//#endif
        latchedBuffer=null;
//#if LATCHES
        bufferPoolLatch.acquire();
//#endif
        currentWriteBuffer=new LogBuffer(bufferSize,envImpl);
        bufferPool.add(currentWriteBuffer);
//#if LATCHES
        bufferPoolLatch.release();
//#endif
      }
 else {
        try {
          fileManager.writeLogBuffer(currentWriteBuffer);
          currentWriteBuffer.getDataBuffer().rewind();
//#if LATCHES
          latchedBuffer.release();
//#endif
          latchedBuffer=null;
          LogBuffer nextToUse=null;
//#if LATCHES
          try {
//#if LATCHES
            bufferPoolLatch.acquire();
//#endif
            Iterator iter=bufferPool.iterator();
            nextToUse=(LogBuffer)iter.next();
            boolean done=bufferPool.remove(nextToUse);
            assert done;
            nextToUse.reinit();
            bufferPool.add(nextToUse);
            currentWriteBuffer=nextToUse;
          }
  finally {
            bufferPoolLatch.releaseIfOwner();
          }
//#endif
        }
 catch (        DatabaseException DE) {
          currentByteBuffer.position(savePosition);
          currentByteBuffer.limit(saveLimit);
          throw DE;
        }
      }
    }
  finally {
      if (latchedBuffer != null) {
        latchedBuffer.release();
      }
    }
//#endif
  }
  /** 
 * A loggable object has been freshly marshalled into the write log buffer.
 * 1. Update buffer so it knows what LSNs it contains.
 * 2. If this object requires a flush, write this buffer out to the 
 * backing file.
 * Assumes log write latch is held.
 */
  void writeCompleted(  long lsn,  boolean flushRequired) throws DatabaseException, IOException {
    currentWriteBuffer.registerLsn(lsn);
    if (flushRequired) {
      writeBufferToFile(0);
    }
  }
  /** 
 * Find a buffer that holds this LSN.
 * @return the buffer that contains this LSN, latched and ready to
 * read, or return null.
 */
  LogBuffer getReadBuffer(  long lsn) throws DatabaseException {
    LogBuffer foundBuffer=null;
//#if LATCHES
    bufferPoolLatch.acquire();
//#endif
//#if LATCHES
    try {
//#if STATISTICS
      nNotResident++;
//#endif
      Iterator iter=bufferPool.iterator();
      while (iter.hasNext()) {
        LogBuffer l=(LogBuffer)iter.next();
        if (l.containsLsn(lsn)) {
          foundBuffer=l;
          break;
        }
      }
      if (foundBuffer == null && currentWriteBuffer.containsLsn(lsn)) {
        foundBuffer=currentWriteBuffer;
      }
      if (foundBuffer == null) {
//#if STATISTICS
        nCacheMiss++;
//#endif
      }
    }
  finally {
      bufferPoolLatch.releaseIfOwner();
    }
//#endif
    if (foundBuffer == null) {
      return null;
    }
 else {
      return foundBuffer;
    }
  }
//#if STATISTICS
  void loadStats(  StatsConfig config,  EnvironmentStats stats) throws DatabaseException {
    stats.setNCacheMiss(nCacheMiss);
    stats.setNNotResident(nNotResident);
    if (config.getClear()) {
      nCacheMiss=0;
      nNotResident=0;
    }
//#if LATCHES
    bufferPoolLatch.acquire();
//#endif
    long bufferBytes=0;
    int nLogBuffers=0;
//#if LATCHES
    try {
      Iterator iter=bufferPool.iterator();
      while (iter.hasNext()) {
        LogBuffer l=(LogBuffer)iter.next();
        nLogBuffers++;
        bufferBytes+=l.getCapacity();
      }
    }
  finally {
      bufferPoolLatch.release();
    }
//#endif
    stats.setNLogBuffers(nLogBuffers);
    stats.setBufferBytes(bufferBytes);
  }
//#endif
}
