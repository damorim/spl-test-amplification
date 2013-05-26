//#if CPBYTES
//#if CHECKPOINTERDAEMON
package com.sleepycat.je.log;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
/** 
 * The checkpoint monitor saves information about log writes to decide when a
 * checkpoint is needed.
 */
class CheckpointMonitor {
  private int bytesWritten;
//#if CPBYTES
//#if CHECKPOINTERDAEMON
  private long periodInBytes;
//#endif
//#endif
  private EnvironmentImpl envImpl;
  CheckpointMonitor(  EnvironmentImpl envImpl) throws DatabaseException {
    bytesWritten=0;
//#if CPBYTES
    periodInBytes=envImpl.getConfigManager().getLong(EnvironmentParams.CHECKPOINTER_BYTES_INTERVAL);
//#endif
//#if CPBYTES
    periodInBytes/=10;
//#endif
    this.envImpl=envImpl;
  }
  /** 
 * Update checkpoint driving information. Call from within the log write
 * latch.
 * @return true if a checkpoint is needed.
 */
  boolean recordLogWrite(  int entrySize,  LoggableObject item){
    bytesWritten+=entrySize;
    return (bytesWritten >= 
//#if CPBYTES
periodInBytes
//#endif
);
  }
  /** 
 * Wake up the checkpointer. Note that the check on bytesWritten is
 * actually within a latched period.
 */
  void activate(){
    envImpl.getCheckpointer().wakeup();
    bytesWritten=0;
  }
}
//#endif
//#endif
