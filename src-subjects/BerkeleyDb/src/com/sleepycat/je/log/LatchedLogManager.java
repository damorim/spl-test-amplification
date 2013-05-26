//#if LATCHES
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
 * The LatchedLogManager uses the latches to implement critical sections.
 */
public class LatchedLogManager extends LogManager {
  /** 
 * There is a single log manager per database environment.
 */
  public LatchedLogManager(  EnvironmentImpl envImpl,  boolean readOnly) throws DatabaseException {
    super(envImpl,readOnly);
  }
  protected LogResult logItem(  LoggableObject item,  boolean isProvisional,  boolean flushRequired,  boolean forceNewLogFile,  long oldNodeLsn,  boolean marshallOutsideLatch,  ByteBuffer marshalledBuffer,
//#if CLEANER
  UtilizationTracker tracker
//#endif
) throws IOException, DatabaseException {
    logWriteLatch.acquire();
    try {
      return logInternal(item,isProvisional,flushRequired,forceNewLogFile,oldNodeLsn,marshallOutsideLatch,marshalledBuffer,
//#if CLEANER
tracker
//#endif
);
    }
  finally {
      logWriteLatch.release();
    }
  }
  protected void flushInternal() throws LogException, DatabaseException {
    logWriteLatch.acquire();
    try {
      logBufferPool.writeBufferToFile(0);
    }
 catch (    IOException e) {
      throw new LogException(e.getMessage());
    }
 finally {
      logWriteLatch.release();
    }
  }
//#if CLEANER
  /** 
 * @see LogManager#getUnflusableTrackedSummary
 */
  public TrackedFileSummary getUnflushableTrackedSummary(  long file) throws DatabaseException {
    logWriteLatch.acquire();
    try {
      return getUnflushableTrackedSummaryInternal(file);
    }
  finally {
      logWriteLatch.release();
    }
  }
//#endif
//#if CLEANER
  /** 
 * @see LogManager#countObsoleteLNs
 */
  public void countObsoleteNode(  long lsn,  LogEntryType type) throws DatabaseException {
//#if CLEANER
    UtilizationTracker tracker=envImpl.getUtilizationTracker();
//#endif
    logWriteLatch.acquire();
    try {
      countObsoleteNodeInternal(tracker,lsn,type);
    }
  finally {
      logWriteLatch.release();
    }
  }
//#endif
//#if CLEANER
  /** 
 * @see LogManager#countObsoleteNodes
 */
  public void countObsoleteNodes(  TrackedFileSummary[] summaries) throws DatabaseException {
    UtilizationTracker tracker=envImpl.getUtilizationTracker();
    logWriteLatch.acquire();
    try {
      countObsoleteNodesInternal(tracker,summaries);
    }
  finally {
      logWriteLatch.release();
    }
  }
//#endif
//#if CLEANER
  /** 
 * @see LogManager#countObsoleteINs
 */
  public void countObsoleteINs(  List lsnList) throws DatabaseException {
    logWriteLatch.acquire();
    try {
      countObsoleteINsInternal(lsnList);
    }
  finally {
      logWriteLatch.release();
    }
  }
//#endif
}
//#endif
