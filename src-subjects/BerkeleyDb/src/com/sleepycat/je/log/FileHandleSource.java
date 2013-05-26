package com.sleepycat.je.log;
import com.sleepycat.je.DatabaseException;
/** 
 * FileHandleSource is a file source built on top of a cached file handle.
 */
class FileHandleSource extends FileSource {
  private FileHandle fileHandle;
  FileHandleSource(  FileHandle fileHandle,  int readBufferSize,  FileManager fileManager){
    super(fileHandle.getFile(),readBufferSize,fileManager);
    this.fileHandle=fileHandle;
  }
//#if LATCHES
  /** 
 * @see LogSource#release
 */
  public void release() throws DatabaseException {
    fileHandle.release();
  }
//#endif
}
