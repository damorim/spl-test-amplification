package com.sleepycat.je.log;
import java.io.IOException;
import java.io.RandomAccessFile;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
/** 
 * A FileHandle embodies a File and its accompanying latch.
 */
class FileHandle {
  private RandomAccessFile file;
//#if LATCHES
  private Latch fileLatch;
//#endif
  private boolean oldHeaderVersion;
  FileHandle(  RandomAccessFile file,  String fileName,  EnvironmentImpl env,  boolean oldHeaderVersion){
    this.file=file;
    this.oldHeaderVersion=oldHeaderVersion;
//#if LATCHES
    fileLatch=LatchSupport.makeLatch(fileName + "_fileHandle",env);
//#endif
  }
  RandomAccessFile getFile(){
    return file;
  }
  boolean isOldHeaderVersion(){
    return oldHeaderVersion;
  }
//#if LATCHES
  void latch() throws DatabaseException {
    fileLatch.acquire();
  }
//#endif
//#if LATCHES
  boolean latchNoWait() throws DatabaseException {
    return fileLatch.acquireNoWait();
  }
//#endif
//#if LATCHES
  void release() throws DatabaseException {
    fileLatch.release();
  }
//#endif
  void close() throws IOException {
    if (file != null) {
      file.close();
      file=null;
    }
  }
}
