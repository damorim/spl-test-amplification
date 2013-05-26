//#if STATISTICS
package com.sleepycat.je;
import java.io.Serializable;
//#if STATISTICS
//#if LATCHES
import com.sleepycat.je.latch.LatchStats;
//#endif
//#endif
/** 
 * Javadoc for this public class is generated
 * via the doc templates in the doc_src directory.
 */
public class LockStats implements Serializable {
  /** 
 * Total locks currently in lock table.
 */
  private int nTotalLocks;
  /** 
 * Total read locks currently held.
 */
  private int nReadLocks;
  /** 
 * Total write locks currently held.
 */
  private int nWriteLocks;
  /** 
 * Total transactions waiting for locks.
 */
  private int nWaiters;
  /** 
 * Total lock owners in lock table.
 */
  private int nOwners;
  /** 
 * Number of times a lock request was made.
 */
  private long nRequests;
  /** 
 * Number of times a lock request blocked.
 */
  private long nWaits;
//#if STATISTICS
//#if LATCHES
  /** 
 * LockTable latch stats.
 */
  private LatchStats lockTableLatchStats;
//#endif
//#endif
//#if STATISTICS
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int getNOwners(){
    return nOwners;
  }
//#endif
//#if STATISTICS
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int getNReadLocks(){
    return nReadLocks;
  }
//#endif
//#if STATISTICS
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int getNTotalLocks(){
    return nTotalLocks;
  }
//#endif
//#if STATISTICS
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int getNWaiters(){
    return nWaiters;
  }
//#endif
//#if STATISTICS
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int getNWriteLocks(){
    return nWriteLocks;
  }
//#endif
//#if STATISTICS
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public long getNRequests(){
    return nRequests;
  }
//#endif
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public long getNWaits(){
    return nWaits;
  }
  /** 
 * Internal use only.
 */
  public void setNOwners(  int val){
    nOwners=val;
  }
  /** 
 * Internal use only.
 */
  public void setNReadLocks(  int val){
    nReadLocks=val;
  }
  /** 
 * Internal use only.
 */
  public void accumulateNTotalLocks(  int val){
    nTotalLocks+=val;
  }
  /** 
 * Internal use only.
 */
  public void setNWaiters(  int val){
    nWaiters=val;
  }
  /** 
 * Internal use only.
 */
  public void setNWriteLocks(  int val){
    nWriteLocks=val;
  }
  /** 
 * Internal use only.
 */
  public void setNRequests(  long requests){
    this.nRequests=requests;
  }
  /** 
 * Internal use only.
 */
  public void setNWaits(  long waits){
    this.nWaits=waits;
  }
//#if LATCHES
  /** 
 * Internal use only.
 */
  public void accumulateLockTableLatchStats(  LatchStats latchStats){
    if (lockTableLatchStats == null) {
      lockTableLatchStats=latchStats;
      return;
    }
    lockTableLatchStats.nAcquiresNoWaiters+=latchStats.nAcquiresNoWaiters;
    lockTableLatchStats.nAcquiresSelfOwned+=latchStats.nAcquiresSelfOwned;
    lockTableLatchStats.nAcquiresUpgrade+=latchStats.nAcquiresUpgrade;
    lockTableLatchStats.nAcquiresWithContention+=latchStats.nAcquiresWithContention;
    lockTableLatchStats.nAcquireNoWaitSuccessful+=latchStats.nAcquireNoWaitSuccessful;
    lockTableLatchStats.nAcquireNoWaitUnsuccessful+=latchStats.nAcquireNoWaitUnsuccessful;
    lockTableLatchStats.nAcquireSharedSuccessful+=latchStats.nAcquireSharedSuccessful;
  }
//#endif
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public String toString(){
    StringBuffer sb=new StringBuffer();
    sb.append("nTotalLocks=").append(nTotalLocks).append('\n');
    sb.append("nReadLocks=").append(nReadLocks).append('\n');
    sb.append("nWriteLocks=").append(nWriteLocks).append('\n');
    sb.append("nWaiters=").append(nWaiters).append('\n');
    sb.append("nOwners=").append(nOwners).append('\n');
    sb.append("nRequests=").append(nRequests).append('\n');
    sb.append("nWaits=").append(nWaits).append('\n');
//#if LATCHES
    sb.append("lockTableLatch:\n").append(lockTableLatchStats);
//#endif
    return sb.toString();
  }
}
//#endif
