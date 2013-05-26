package com.sleepycat.je.log.entry;
import java.nio.ByteBuffer;
import com.sleepycat.je.DatabaseException;
/** 
 * A Log entry allows you to read, write and dump a database log entry.  Each
 * entry may be made up of one or more loggable items.
 */
public interface LogEntry extends Cloneable {
  /** 
 * Read in an log entry.
 */
  void readEntry(  ByteBuffer entryBuffer,  int entrySize,  byte entryTypeVersion,  boolean readFullItem) throws DatabaseException ;
  /** 
 * Print out the contents of an entry.
 */
  StringBuffer dumpEntry(  StringBuffer sb,  boolean verbose);
  /** 
 * @return the first item of the log entry
 */
  Object getMainItem();
  /** 
 * @return a shallow clone.
 */
  public Object clone() throws CloneNotSupportedException ;
  /** 
 * @return true if the LogEntry is a transactional log entry type.
 */
  
//#if TRANSACTIONS
public
//#endif
 
//#if TRANSACTIONS
boolean
//#endif
 
//#if TRANSACTIONS
isTransactional
//#endif
();
//#if TRANSACTIONS
  /** 
 * @return return the transaction id if this log entry is transactional,
 * 0 otherwise.
 */
  public long getTransactionId();
//#endif
}
