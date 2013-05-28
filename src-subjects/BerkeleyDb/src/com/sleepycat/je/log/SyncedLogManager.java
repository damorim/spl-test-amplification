package com.sleepycat.je.log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import com.sleepycat.je.DatabaseException;
//#if CLEANER
import com.sleepycat.je.cleaner.TrackedFileSummary;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.UtilizationTracker;
//#endif
import com.sleepycat.je.dbi.EnvironmentImpl;
/** 
 * The SyncedLogManager uses the synchronized keyword to implement protected
 * regions.
 */
public class SyncedLogManager extends LogManager {
  /** 
 * There is a single log manager per database environment.
 */
  public SyncedLogManager(  EnvironmentImpl envImpl,  boolean readOnly) throws DatabaseException {
    super(envImpl,readOnly);
  }
  
  protected LogResult logItem(  LoggableObject item,  boolean isProvisional,  boolean flushRequired,  boolean forceNewLogFile,  long oldNodeLsn,  boolean marshallOutsideLatch,  ByteBuffer marshalledBuffer
//#if CLEANER
  , UtilizationTracker tracker
//#endif
) throws IOException, DatabaseException {
//#if LATCHES
synchronized (logWriteLatch) {
      return logInternal(item,isProvisional,flushRequired,forceNewLogFile,oldNodeLsn,marshallOutsideLatch,marshalledBuffer
//#if CLEANER
, tracker
//#endif
);
    }
//#else
return null; // -Marcelo (comperr owise)
//#endif
  }
  
  protected void flushInternal() throws LogException, DatabaseException {
//#if LATCHES
    try {
synchronized (logWriteLatch) {
        logBufferPool.writeBufferToFile(0);
      }
    }
 catch (    IOException e) {
      throw new LogException(e.getMessage());
    }
//#endif
  }
  
//#if CLEANER
  /** 
 * @see LogManager#getUnflushableTrackedSummary
 */
  public TrackedFileSummary getUnflushableTrackedSummary(  long file) throws DatabaseException {
//#if LATCHES
synchronized (logWriteLatch) {
      return getUnflushableTrackedSummaryInternal(file);
    }
//#endif
  }
//#endif
//#if CLEANER
  /** 
 * @see LogManager#countObsoleteLNs
 */
  public void countObsoleteNode(  long lsn,  LogEntryType type) throws DatabaseException {
    UtilizationTracker tracker=envImpl.getUtilizationTracker();
//#if LATCHES
synchronized (logWriteLatch) {
      countObsoleteNodeInternal(tracker,lsn,type);
    }
//#endif
  }
//#endif
//#if CLEANER
  /** 
 * @see LogManager#countObsoleteNodes
 */
  public void countObsoleteNodes(  TrackedFileSummary[] summaries) throws DatabaseException {
    UtilizationTracker tracker=envImpl.getUtilizationTracker();
//#if LATCHES
synchronized (logWriteLatch) {
      countObsoleteNodesInternal(tracker,summaries);
    }
//#endif
  }
//#endif
//#if CLEANER
  /** 
 * @see LogManager#countObsoleteINs
 */
  public void countObsoleteINs(  List lsnList) throws DatabaseException {
//#if LATCHES
synchronized (logWriteLatch) {
      countObsoleteINsInternal(lsnList);
    }
//#endif
  }
//#endif
}
