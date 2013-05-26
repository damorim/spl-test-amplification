//#if FSYNC
package com.sleepycat.je.log;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
import com.sleepycat.je.RunRecoveryException;
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.utilint.PropUtil;
class FSyncManager {
  private EnvironmentImpl envImpl;
  private long timeout;
//#if LATCHES
  private Latch fsyncLatch;
//#endif
  private volatile boolean fsyncInProgress;
  private FSyncGroup nextFSyncWaiters;
//#if STATISTICS
  private long nFSyncRequests=0;
//#endif
//#if STATISTICS
  private long nFSyncs=0;
//#endif
//#if STATISTICS
  private long nTimeouts=0;
//#endif
  FSyncManager(  EnvironmentImpl envImpl) throws DatabaseException {
    timeout=PropUtil.microsToMillis(envImpl.getConfigManager().getLong(EnvironmentParams.LOG_FSYNC_TIMEOUT));
    this.envImpl=envImpl;
//#if LATCHES
    fsyncLatch=LatchSupport.makeLatch("fsyncLatch",envImpl);
//#endif
    fsyncInProgress=false;
    nextFSyncWaiters=new FSyncGroup(timeout,envImpl);
  }
  /** 
 * Request that this file be fsynced to disk. This thread may or may not
 * actually execute the fsync, but will not return until a fsync has been
 * issued and executed on behalf of its write. There is a timeout period
 * specified by EnvironmentParam.LOG_FSYNC_TIMEOUT that ensures that no
 * thread gets stuck here indefinitely.
 * When a thread comes in, it will find one of two things. 
 * 1. There is no fsync going on right now. This thread should go
 * ahead and fsync.
 * 2. There is an active fsync, wait until it's over before
 * starting a new fsync.
 * When a fsync is going on, all those threads that come along are grouped
 * together as the nextFsyncWaiters. When the current fsync is finished,
 * one of those nextFsyncWaiters will be selected as a leader to issue the
 * next fsync. The other members of the group will merely wait until the
 * fsync done on their behalf is finished.
 * When a thread finishes a fsync, it has to:
 * 1. wake up all the threads that were waiting for its fsync call.
 * 2. wake up one member of the next group of waiting threads (the 
 * nextFsyncWaiters) so that thread can become the new leader
 * and issue the next fysnc call.
 * If a non-leader member of the nextFsyncWaiters times out, it will issue
 * its own fsync anyway, in case something happened to the leader.
 */
  void fsync() throws DatabaseException {
    boolean doFsync=false;
    boolean isLeader=false;
    boolean needToWait=false;
    FSyncGroup inProgressGroup=null;
    FSyncGroup myGroup=null;
synchronized (
//#if LATCHES
fsyncLatch
//#endif
) {
//#if STATISTICS
      nFSyncRequests++;
//#endif
      if (fsyncInProgress) {
        needToWait=true;
        myGroup=nextFSyncWaiters;
      }
 else {
        isLeader=true;
        doFsync=true;
        fsyncInProgress=true;
        inProgressGroup=nextFSyncWaiters;
        nextFSyncWaiters=new FSyncGroup(timeout,envImpl);
      }
    }
    if (needToWait) {
      int waitStatus=myGroup.waitForFsync();
      if (waitStatus == FSyncGroup.DO_LEADER_FSYNC) {
synchronized (
//#if LATCHES
fsyncLatch
//#endif
) {
          if (!fsyncInProgress) {
            isLeader=true;
            doFsync=true;
            fsyncInProgress=true;
            inProgressGroup=myGroup;
            nextFSyncWaiters=new FSyncGroup(timeout,envImpl);
          }
        }
      }
 else       if (waitStatus == FSyncGroup.DO_TIMEOUT_FSYNC) {
        doFsync=true;
//#if STATISTICS
synchronized (
//#if LATCHES
fsyncLatch
//#endif
) {
//#if STATISTICS
          nTimeouts++;
//#endif
        }
//#endif
      }
    }
    if (doFsync) {
      executeFSync();
synchronized (
//#if LATCHES
fsyncLatch
//#endif
) {
//#if STATISTICS
        nFSyncs++;
//#endif
        if (isLeader) {
          inProgressGroup.wakeupAll();
          nextFSyncWaiters.wakeupOne();
          fsyncInProgress=false;
        }
      }
    }
  }
//#if STATISTICS
  long getNFSyncRequests(){
    return nFSyncRequests;
  }
//#endif
//#if STATISTICS
  long getNFSyncs(){
    return nFSyncs;
  }
//#endif
//#if STATISTICS
  long getNTimeouts(){
    return nTimeouts;
  }
//#endif
//#if STATISTICS
  void loadStats(  StatsConfig config,  EnvironmentStats stats) throws DatabaseException {
    stats.setNFSyncs(nFSyncs);
    stats.setNFSyncRequests(nFSyncRequests);
    stats.setNFSyncTimeouts(nTimeouts);
    if (config.getClear()) {
      nFSyncs=0;
      nFSyncRequests=0;
      nTimeouts=0;
    }
  }
//#endif
  /** 
 * Put the fsync execution into this method so it can be overridden for
 * testing purposes.
 */
  protected void executeFSync() throws DatabaseException {
    envImpl.getFileManager().syncLogEnd();
  }
static class FSyncGroup {
    static int DO_TIMEOUT_FSYNC=0;
    static int DO_LEADER_FSYNC=1;
    static int NO_FSYNC_NEEDED=2;
    private volatile boolean fsyncDone;
    private long fsyncTimeout;
    private boolean leaderExists;
    private EnvironmentImpl envImpl;
    FSyncGroup(    long fsyncTimeout,    EnvironmentImpl envImpl){
      this.fsyncTimeout=fsyncTimeout;
      fsyncDone=false;
      leaderExists=false;
      this.envImpl=envImpl;
    }
    synchronized boolean getLeader(){
      if (fsyncDone) {
        return false;
      }
 else {
        if (leaderExists) {
          return false;
        }
 else {
          leaderExists=true;
          return true;
        }
      }
    }
    /** 
 * Wait for either a turn to execute a fsync, or to find out that a
 * fsync was done on your behalf.
 * @return true if the fsync wasn't done, and this thread needs to
 * execute a fsync when it wakes up. This may be true because it's the
 * leader of its group, or because the wait timed out.
 */
    synchronized int waitForFsync() throws RunRecoveryException {
      int status=0;
      if (!fsyncDone) {
        long startTime=System.currentTimeMillis();
        while (true) {
          try {
            wait(fsyncTimeout);
          }
 catch (          InterruptedException e) {
            throw new RunRecoveryException(envImpl,"Unexpected interrupt while waiting for fsync",e);
          }
          if (fsyncDone) {
            status=NO_FSYNC_NEEDED;
            break;
          }
 else {
            if (!leaderExists) {
              leaderExists=true;
              status=DO_LEADER_FSYNC;
              break;
            }
 else {
              long now=System.currentTimeMillis();
              if ((now - startTime) > fsyncTimeout) {
                status=DO_TIMEOUT_FSYNC;
                break;
              }
            }
          }
        }
      }
      return status;
    }
    synchronized void wakeupAll(){
      fsyncDone=true;
      notifyAll();
    }
    synchronized void wakeupOne(){
      notify();
    }
  }
}
//#endif
