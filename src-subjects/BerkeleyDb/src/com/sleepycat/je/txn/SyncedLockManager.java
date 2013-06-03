package com.sleepycat.je.txn;

import java.util.Set;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockStats;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;

/**
 * SyncedLockManager uses the synchronized keyword to implement its critical
 * sections.
 */
public class SyncedLockManager extends LockManager {
	public SyncedLockManager(EnvironmentImpl envImpl) throws DatabaseException {
		super(envImpl);
	}

	/**
	 * @see LockManager#attemptLock
	 */
	protected LockAttemptResult attemptLock(Long nodeId, Locker locker,
			LockType type, boolean nonBlockingRequest) throws DatabaseException {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return attemptLockInternal(nodeId, locker, type,
					nonBlockingRequest, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#makeTimeoutMsg
	 */
	protected String makeTimeoutMsg(String lockOrTxn, Locker locker,
			long nodeId, LockType type, LockGrantType grantType, Lock useLock,
			long timeout, long start, long now, DatabaseImpl database) {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return makeTimeoutMsgInternal(lockOrTxn, locker, nodeId, type,
					grantType, useLock, timeout, start, now, database);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#releaseAndNotifyTargets
	 */
	protected Set releaseAndFindNotifyTargets(long nodeId, Lock lock,
			Locker locker, boolean removeFromLocker) throws DatabaseException {
		long nid = nodeId;
		if (nid == -1) {
			nid = lock.getNodeId().longValue();
		}
		int lockTableIndex = getLockTableIndex(nid);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return releaseAndFindNotifyTargetsInternal(nodeId, lock, locker,
					removeFromLocker, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#transfer
	 */
	void transfer(long nodeId, Locker owningLocker, Locker destLocker,
			boolean demoteToRead) throws DatabaseException {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			transferInternal(nodeId, owningLocker, destLocker, demoteToRead,
					lockTableIndex);
		}
		// #endif
	}

	/**
	 * @see LockManager#transferMultiple
	 */
	void transferMultiple(long nodeId, Locker owningLocker, Locker[] destLockers)
			throws DatabaseException {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			transferMultipleInternal(nodeId, owningLocker, destLockers,
					lockTableIndex);
		}
		// #endif
	}

	/**
	 * @see LockManager#demote
	 */
	void demote(long nodeId, Locker locker) throws DatabaseException {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			demoteInternal(nodeId, locker, lockTableIndex);
		}
		// #endif
	}

	/**
	 * @see LockManager#isLocked
	 */
	boolean isLocked(Long nodeId) {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return isLockedInternal(nodeId, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#isOwner
	 */
	boolean isOwner(Long nodeId, Locker locker, LockType type) {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return isOwnerInternal(nodeId, locker, type, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#isWaiter
	 */
	boolean isWaiter(Long nodeId, Locker locker) {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return isWaiterInternal(nodeId, locker, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#nWaiters
	 */
	int nWaiters(Long nodeId) {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return nWaitersInternal(nodeId, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#nOwners
	 */
	int nOwners(Long nodeId) {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return nOwnersInternal(nodeId, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#getWriterOwnerLocker
	 */
	Locker getWriteOwnerLocker(Long nodeId) throws DatabaseException {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return getWriteOwnerLockerInternal(nodeId, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#validateOwnership
	 */
	protected boolean validateOwnership(Long nodeId, Locker locker,
			LockType type, boolean flushFromWaiters, MemoryBudget mb)
			throws DatabaseException {
		int lockTableIndex = getLockTableIndex(nodeId);
		// #if LATCHES
		synchronized (lockTableLatches[lockTableIndex]) {
			return validateOwnershipInternal(nodeId, locker, type,
					flushFromWaiters, mb, lockTableIndex);
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * @see LockManager#dumpLockTable
	 */
	protected void dumpLockTable(LockStats stats) throws DatabaseException {
		for (int i = 0; i < nLockTables; i++) {
			// #if LATCHES
			synchronized (lockTableLatches[i]) {
				dumpLockTableInternal(stats,i);
			}
			// #endif
		}
	}
}
