package com.sleepycat.je.txn;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.transaction.xa.Xid;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.LockStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
//#if TRANSACTIONS
import com.sleepycat.je.Transaction;
//#endif
//#if TRANSACTIONS
import com.sleepycat.je.TransactionConfig;
//#endif
//#if TRANSACTIONS
//#if STATISTICS
import com.sleepycat.je.TransactionStats;
//#endif
//#endif
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.MemoryBudget;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.utilint.DbLsn;

/**
 * Class to manage transactions. Basically a Set of all transactions with add
 * and remove methods and a latch around the set.
 */
public class TxnManager {
	static final long NULL_TXN_ID = -1;
	private static final String DEBUG_NAME = TxnManager.class.getName();
	private LockManager lockManager;
	private EnvironmentImpl env;
	// #if TRANSACTIONS
	// #if LATCHES
	private Latch allTxnLatch;
	// #endif
	// #endif
	// #if TRANSACTIONS
	private Set allTxns;
	// #endif
	// #if TRANSACTIONS
	private Map allXATxns;
	// #endif
	// #if TRANSACTIONS
	private Map thread2Txn;
	// #endif
	// #if TRANSACTIONS
	private long lastUsedTxnId;
	// #endif
	// #if TRANSACTIONS
	private int nActiveSerializable;
	// #endif
	// #if TRANSACTIONS
	// #if STATISTICS
	private int numCommits;
	// #endif
	// #endif
	// #if TRANSACTIONS
	// #if STATISTICS
	private int numAborts;
	// #endif
	// #endif
	// #if TRANSACTIONS
	// #if STATISTICS
	private int numXAPrepares;
	// #endif
	// #endif
	// #if TRANSACTIONS
	// #if STATISTICS
	private int numXACommits;
	// #endif
	// #endif
	// #if TRANSACTIONS
	// #if STATISTICS
	private int numXAAborts;

	// #endif
	// #endif
	public TxnManager(EnvironmentImpl env) throws DatabaseException {
		// #if LATCHES
		if (EnvironmentImpl.getFairLatches())
		// #if LATCHES
		{
			lockManager = new LatchedLockManager(env);
		}
		// #endif
		else {
			if (env.isNoLocking()) {
				lockManager = new DummyLockManager(env);
			} else {
				lockManager = new SyncedLockManager(env);
			}
		}
		// #endif
		this.env = env;
		// #if TRANSACTIONS
		allTxns = new HashSet();
		// #endif
		// #if TRANSACTIONS
		// #if LATCHES
		allTxnLatch = LatchSupport.makeLatch(DEBUG_NAME, env);
		// #endif
		// #endif
		// #if TRANSACTIONS
		allXATxns = Collections.synchronizedMap(new HashMap());
		// #endif
		// #if TRANSACTIONS
		thread2Txn = Collections.synchronizedMap(new HashMap());
		// #endif
		// #if TRANSACTIONS
		// #if STATISTICS
		numCommits = 0;
		// #endif
		// #endif
		// #if TRANSACTIONS
		// #if STATISTICS
		numAborts = 0;
		// #endif
		// #endif
		// #if TRANSACTIONS
		// #if STATISTICS
		numXAPrepares = 0;
		// #endif
		// #endif
		// #if TRANSACTIONS
		// #if STATISTICS
		numXACommits = 0;
		// #endif
		// #endif
		// #if TRANSACTIONS
		// #if STATISTICS
		numXAAborts = 0;
		// #endif
		// #endif
		// #if TRANSACTIONS
		lastUsedTxnId = 0;
		// #endif
	}

	// #if TRANSACTIONS
	/**
	 * Set the txn id sequence.
	 */
	synchronized public void setLastTxnId(long lastId) {
		this.lastUsedTxnId = lastId;
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Get the last used id, for checkpoint info.
	 */
	public synchronized long getLastTxnId() {
		return lastUsedTxnId;
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Get the next transaction id to use.
	 */
	synchronized long incTxnId() {
		return ++lastUsedTxnId;
	}

	// #endif
	/**
	 * Create a new transaction.
	 * 
	 * @param parent
	 *            for nested transactions, not yet supported
	 * @param txnConfig
	 *            specifies txn attributes
	 * @return the new txn
	 */

	// #if TRANSACTIONS
	public Txn txnBegin(Transaction parent, TransactionConfig txnConfig)
			throws DatabaseException {
		if (parent != null) {
			throw new DatabaseException(
					"Nested transactions are not supported yet.");
		}
		return new Txn(env, txnConfig);
	}

	// #endif
	/**
	 * Give transactions and environment access to lock manager.
	 */
	public LockManager getLockManager() {
		return lockManager;
	}

	// #if TRANSACTIONS
	/**
	 * Called when txn is created.
	 */
	void registerTxn(Txn txn) throws DatabaseException {
		// #if LATCHES
		allTxnLatch.acquire();
		// #endif
		allTxns.add(txn);
		if (txn.isSerializableIsolation()) {
			nActiveSerializable++;
		}
		// #if LATCHES
		allTxnLatch.release();
		// #endif
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Called when txn ends.
	 */
	void unRegisterTxn(Txn txn, boolean isCommit) throws DatabaseException {
		// #if LATCHES
		allTxnLatch.acquire();
		// #endif
		// #if LATCHES
		try {
			allTxns.remove(txn);
			// #if MEMORYBUDGET
			env.getMemoryBudget().updateMiscMemoryUsage(
					txn.getAccumulatedDelta() - txn.getInMemorySize());
			// #endif
			// #if STATISTICS
			if (isCommit)
			// #if STATISTICS
			{
				numCommits++;
			}
			// #endif
			else
			// #if STATISTICS
			{
				numAborts++;
			}
			// #endif
			// #endif
			if (txn.isSerializableIsolation()) {
				nActiveSerializable--;
			}
		} finally {
			allTxnLatch.release();
		}
		// #endif
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Called when txn is created.
	 */
	public void registerXATxn(Xid xid, Txn txn, boolean isPrepare)
			throws DatabaseException {
		if (!allXATxns.containsKey(xid)) {
			allXATxns.put(xid, txn);
			// #if MEMORYBUDGET
			env.getMemoryBudget().updateMiscMemoryUsage(
					MemoryBudget.HASHMAP_ENTRY_OVERHEAD);
			// #endif
		}
		// #if STATISTICS
		if (isPrepare)
		// #if STATISTICS
		{
			numXAPrepares++;
		}
		// #endif
		// #endif
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Called when txn ends.
	 */
	void unRegisterXATxn(Xid xid, boolean isCommit) throws DatabaseException {
		if (allXATxns.remove(xid) == null) {
			throw new DatabaseException("XA Transaction " + xid
					+ " can not be unregistered.");
		}
		// #if MEMORYBUDGET
		env.getMemoryBudget().updateMiscMemoryUsage(
				0 - MemoryBudget.HASHMAP_ENTRY_OVERHEAD);
		// #endif
		// #if STATISTICS
		if (isCommit)
		// #if STATISTICS
		{
			numXACommits++;
		}
		// #endif
		else
		// #if STATISTICS
		{
			numXAAborts++;
		}
		// #endif
		// #endif
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Retrieve a Txn object from an Xid.
	 */
	public Txn getTxnFromXid(Xid xid) throws DatabaseException {
		return (Txn) allXATxns.get(xid);
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Called when txn is assoc'd with this thread.
	 */
	public void setTxnForThread(Transaction txn) {
		Thread curThread = Thread.currentThread();
		thread2Txn.put(curThread, txn);
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Called when txn is assoc'd with this thread.
	 */
	public Transaction unsetTxnForThread() throws DatabaseException {
		Thread curThread = Thread.currentThread();
		return (Transaction) thread2Txn.remove(curThread);
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Retrieve a Txn object for this Thread.
	 */
	public Transaction getTxnForThread() throws DatabaseException {
		return (Transaction) thread2Txn.get(Thread.currentThread());
	}

	// #endif
	// #if TRANSACTIONS
	public Xid[] XARecover() throws DatabaseException {
		Set xidSet = allXATxns.keySet();
		Xid[] ret = new Xid[xidSet.size()];
		ret = (Xid[]) xidSet.toArray(ret);
		return ret;
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Returns whether there are any active serializable transactions, excluding
	 * the transaction given (if non-null). This is intentionally returned
	 * without latching, since latching would not make the act of reading an
	 * integer more atomic than it already is.
	 */
	public boolean areOtherSerializableTransactionsActive(Locker excludeLocker) {
		int exclude = (excludeLocker != null && excludeLocker
				.isSerializableIsolation()) ? 1 : 0;
		return (nActiveSerializable - exclude > 0);
	}

	// #endif
	// #if TRANSACTIONS
	/**
	 * Get the earliest LSN of all the active transactions, for checkpoint.
	 */
	public long getFirstActiveLsn() throws DatabaseException {
		long firstActive = DbLsn.NULL_LSN;
		// #if LATCHES
		allTxnLatch.acquire();
		// #endif
		// #if LATCHES
		try {
			Iterator iter = allTxns.iterator();
			while (iter.hasNext()) {
				long txnFirstActive = ((Txn) iter.next()).getFirstActiveLsn();
				if (firstActive == DbLsn.NULL_LSN) {
					firstActive = txnFirstActive;
				} else if (txnFirstActive != DbLsn.NULL_LSN) {
					if (DbLsn.compareTo(txnFirstActive, firstActive) < 0) {
						firstActive = txnFirstActive;
					}
				}
			}
		} finally {
			allTxnLatch.release();
		}
		// #endif
		return firstActive;
	}

	// #endif
	// #if TRANSACTIONS
	// #if STATISTICS
	/**
	 * Collect transaction related stats.
	 */
	public TransactionStats txnStat(StatsConfig config)
			throws DatabaseException {
		TransactionStats stats = new TransactionStats();
		// #if LATCHES
		allTxnLatch.acquire();
		// #endif
		// #if LATCHES
		try {
			stats.setNCommits(numCommits);
			stats.setNAborts(numAborts);
			stats.setNXAPrepares(numXAPrepares);
			stats.setNXACommits(numXACommits);
			stats.setNXAAborts(numXAAborts);
			stats.setNActive(allTxns.size());
			TransactionStats.Active[] activeSet = new TransactionStats.Active[stats
					.getNActive()];
			stats.setActiveTxns(activeSet);
			Iterator iter = allTxns.iterator();
			int i = 0;
			while (iter.hasNext()) {
				Locker txn = (Locker) iter.next();
				activeSet[i] = new TransactionStats.Active(txn.toString(),
						txn.getId(), 0);
				i++;
			}
			if (config.getClear()) {
				numCommits = 0;
				numAborts = 0;
				numXACommits = 0;
				numXAAborts = 0;
			}
		} finally {
			allTxnLatch.release();
		}
		// #endif
		return stats;
	}

	// #endif
	// #endif
	// #if STATISTICS
	/**
	 * Collect lock related stats.
	 */
	public LockStats lockStat(StatsConfig config) throws DatabaseException {
		return lockManager.lockStat(config);
	}
	// #endif
}
