//#if EVICTOR
package com.sleepycat.je.evictor;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.dbi.MemoryBudget;
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.utilint.DaemonThread;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.Tracer;

/**
 * The Evictor looks through the INList for IN's and BIN's that are worthy of
 * eviction. Once the nodes are selected, it removes all references to them so
 * that they can be GC'd by the JVM.
 */
public class Evictor
// #if EVICTORDAEMON
		extends DaemonThread
// #endif
{
	public static final String SOURCE_DAEMON = "daemon";
	public static final String SOURCE_MANUAL = "manual";
	public static final String SOURCE_CRITICAL = "critical";
	private static final boolean DEBUG = false;
	private EnvironmentImpl envImpl;
	private LogManager logManager;
	// #if LOGGINGEVICTOR
	private Level detailedTraceLevel;
	// #endif
	private volatile boolean active;
	private IN nextNode;
	private long currentRequiredEvictBytes;
	private int nodesPerScan;
	private long evictBytesSetting;
	private boolean evictByLruOnly;
	private NumberFormat formatter;
	// #if STATISTICS
	private int nEvictPasses = 0;
	// #endif
	// #if STATISTICS
	private long nNodesSelected = 0;
	// #endif
	// #if STATISTICS
	private long nNodesSelectedThisRun;
	// #endif
	// #if STATISTICS
	private int nNodesScanned = 0;
	// #endif
	private int nNodesScannedThisRun;
	// #if STATISTICS
	private long nNodesEvicted = 0;
	// #endif
	// #if STATISTICS
	private long nNodesEvictedThisRun;
	// #endif
	// #if STATISTICS
	private long nBINsStripped = 0;
	// #endif
	// #if STATISTICS
	private long nBINsStrippedThisRun;
	// #endif
	EvictProfile evictProfile;
	private TestHook runnableHook;

	public Evictor(EnvironmentImpl envImpl, String name)
			throws DatabaseException {
		// #if EVICTORDAEMON
		super(0, name, envImpl);
		// #endif
		this.envImpl = envImpl;
		logManager = envImpl.getLogManager();
		nextNode = null;
		DbConfigManager configManager = envImpl.getConfigManager();
		nodesPerScan = configManager
				.getInt(EnvironmentParams.EVICTOR_NODES_PER_SCAN);
		evictBytesSetting = configManager
				.getLong(EnvironmentParams.EVICTOR_EVICT_BYTES);
		evictByLruOnly = configManager
				.getBoolean(EnvironmentParams.EVICTOR_LRU_ONLY);
		// #if LOGGINGEVICTOR
		detailedTraceLevel = Tracer.parseLevel(envImpl,
				EnvironmentParams.JE_LOGGING_LEVEL_EVICTOR);
		// #endif
		evictProfile = new EvictProfile();
		formatter = NumberFormat.getNumberInstance();
		active = false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		// #if EVICTORDAEMON
		sb.append("<Evictor name=\"").append(name).append("\"/>");
		// #endif
		return sb.toString();
	}

	// #if EVICTORDAEMON
	/**
	 * Evictor doesn't have a work queue so just throw an exception if it's ever
	 * called.
	 */
	public void addToQueue(Object o) throws DatabaseException {
		throw new DatabaseException(
				"Evictor.addToQueue should never be called.");
	}

	// #endif
	// #if STATISTICS
	/**
	 * Load stats.
	 */
	public void loadStats(StatsConfig config, EnvironmentStats stat)
			throws DatabaseException {
		stat.setNEvictPasses(nEvictPasses);
		stat.setNNodesSelected(nNodesSelected);
		stat.setNNodesScanned(nNodesScanned);
		stat.setNNodesExplicitlyEvicted(nNodesEvicted);
		stat.setNBINsStripped(nBINsStripped);
		stat.setRequiredEvictBytes(currentRequiredEvictBytes);
		if (config.getClear()) {
			nEvictPasses = 0;
			nNodesSelected = 0;
			nNodesScanned = 0;
			nNodesEvicted = 0;
			nBINsStripped = 0;
		}
	}

	// #endif
	synchronized public void clearEnv() {
		envImpl = null;
	}

	// #if EVICTORDAEMON
	/**
	 * Return the number of retries when a deadlock exception occurs.
	 */
	protected int nDeadlockRetries() throws DatabaseException {
		return envImpl.getConfigManager().getInt(
				EnvironmentParams.EVICTOR_RETRY);
	}

	// #endif
	/**
	 * Wakeup the evictor only if it's not already active.
	 */
	public void alert() {
		if (!active) {
			// #if EVICTORDAEMON
			wakeup();
			// #endif
		}
	}

	// #if EVICTORDAEMON
	/**
	 * Called whenever the daemon thread wakes up from a sleep.
	 */
	public void onWakeup() throws DatabaseException {
		if (envImpl.isClosed()) {
			return;
		}
		doEvict(SOURCE_DAEMON, false);
	}

	// #endif
	/**
	 * May be called by the evictor thread on wakeup or programatically.
	 */
	public void doEvict(String source) throws DatabaseException {
		doEvict(source, false);
	}

	/**
	 * Allows performing eviction during shutdown, which is needed when during
	 * checkpointing and cleaner log file deletion.
	 */
	private synchronized void doEvict(String source, boolean evictDuringShutdown)
			throws DatabaseException {
		if (active) {
			return;
		}
		active = true;
		try {
			boolean progress = true;
			while (progress && (evictDuringShutdown
			// #if EVICTORDAEMON
					|| !isShutdownRequested()
					// #endif
					) && isRunnable(source)) {
				if (evictBatch(source, currentRequiredEvictBytes) == 0) {
					progress = false;
				}
			}
		} finally {
			active = false;
		}
	}

	// #if CRITICALEVICTION
	/**
	 * Do a check on whether synchronous eviction is needed.
	 */
	public void doCriticalEviction() throws DatabaseException {
		// #if MEMORYBUDGET
		MemoryBudget mb = envImpl.getMemoryBudget();
		// #endif
		// #if MEMORYBUDGET
		long currentUsage = mb.getCacheMemoryUsage();
		// #endif
		// #if MEMORYBUDGET
		long maxMem = mb.getCacheBudget();
		// #endif
		// #if MEMORYBUDGET
		long over = currentUsage - maxMem;
		// #endif
		// #if MEMORYBUDGET
		if (over > mb.getCriticalThreshold())
		// #if MEMORYBUDGET
		{
			if (DEBUG) {
				System.out.println("***critical detected:" + over);
			}
			doEvict(SOURCE_CRITICAL, true);
		}
		// #endif
		// #endif
	}

	// #endif
	/**
	 * Each iteration will latch and unlatch the major INList, and will attempt
	 * to evict requiredEvictBytes, but will give up after a complete pass over
	 * the major INList. Releasing the latch is important because it provides an
	 * opportunity for to add the minor INList to the major INList.
	 * 
	 * @return the number of bytes evicted, or zero if no progress was made.
	 */
	long evictBatch(String source, long requiredEvictBytes)
			throws DatabaseException {
		// #if STATISTICS
		nNodesSelectedThisRun = 0;
		// #endif
		// #if STATISTICS
		nNodesEvictedThisRun = 0;
		// #endif
		nNodesScannedThisRun = 0;
		// #if STATISTICS
		nBINsStrippedThisRun = 0;
		// #endif
		// #if STATISTICS
		nEvictPasses++;
		// #endif
		assert evictProfile.clear();
		int nBatchSets = 0;
		boolean finished = false;
		long evictBytes = 0;
		// #if CLEANER
		evictBytes += envImpl.getUtilizationTracker().evictMemory();
		// #endif
		INList inList = envImpl.getInMemoryINs();
		// #if LATCHES
		inList.latchMajor();
		// #endif
		int inListStartSize = inList.getSize();
		try {
			if (inListStartSize == 0) {
				nextNode = null;
				return 0;
			} else {
				if (nextNode == null) {
					nextNode = inList.first();
				}
			}
			ScanIterator scanIter = new ScanIterator(nextNode, inList);
			while ((evictBytes < requiredEvictBytes)
					&& (nNodesScannedThisRun <= inListStartSize)) {
				IN target = selectIN(inList, scanIter);
				if (target == null) {
					break;
				} else {
					assert evictProfile.count(target);
					evictBytes += evict(inList, target, scanIter);
				}
				nBatchSets++;
			}
			nextNode = scanIter.mark();
			finished = true;
		} finally {
			// #if STATISTICS
			nNodesScanned += nNodesScannedThisRun;
			// #endif
			// #if LATCHES
			inList.releaseMajorLatch();
			// #endif
			// #if LOGGINGEVICTOR
			// #if LOGGINGBASE
			Logger logger = envImpl.getLogger();
			// #endif
			// #endif
			// #if LOGGINGEVICTOR
			// #if LOGGINGBASE
			if (logger.isLoggable(detailedTraceLevel))
			// #if LOGGINGEVICTOR
			// #if LOGGINGBASE
			{
				Tracer.trace(
						detailedTraceLevel,
						envImpl,
						"Evictor: "
								+
								// #if STATISTICS
								"pass="
								// #endif
								+
								// #if STATISTICS
								nEvictPasses
								// #endif
								+ " finished=" + finished + " source=" + source
								+ " requiredEvictBytes="
								+ formatter.format(requiredEvictBytes)
								+ " evictBytes=" + formatter.format(evictBytes)
								+ " inListSize=" + inListStartSize
								+ " nNodesScanned=" + nNodesScannedThisRun +
								// #if STATISTICS
								" nNodesSelected="
								// #endif
								+
								// #if STATISTICS
								nNodesSelectedThisRun
								// #endif
								+
								// #if STATISTICS
								" nEvicted="
								// #endif
								+
								// #if STATISTICS
								nNodesEvictedThisRun
								// #endif
								+
								// #if STATISTICS
								" nBINsStripped="
								// #endif
								+
								// #if STATISTICS
								nBINsStrippedThisRun
								// #endif
								+ " nBatchSets=" + nBatchSets);
			}
			// #endif
			// #endif
			// #endif
			// #endif
		}
		// #if LATCHES
		assert LatchSupport.countLatchesHeld() == 0 : "latches held = "
				+ LatchSupport.countLatchesHeld();
		// #endif
		return evictBytes;
	}

	/**
	 * Return true if eviction should happen.
	 */
	boolean isRunnable(String source) throws DatabaseException {
		MemoryBudget mb = envImpl.getMemoryBudget();
		// #if MEMORYBUDGET
		long currentUsage = mb.getCacheMemoryUsage();
		// #endif
		// #if MEMORYBUDGET
		long maxMem = mb.getCacheBudget();
		// #endif
		boolean doRun = false;
		// #if MEMORYBUDGET
		doRun = ((currentUsage - maxMem) > 0);
		// #endif
		if (doRun) {
			currentRequiredEvictBytes =
			// #if MEMORYBUDGET
			(currentUsage - maxMem) +
			// #endif
					evictBytesSetting;
			if (DEBUG) {
				if (source == SOURCE_CRITICAL) {
					System.out.println("executed: critical runnable");
				}
			}
		}
		// #if MEMORYBUDGET
		if (runnableHook != null)
		// #if MEMORYBUDGET
		{
			doRun = ((Boolean) runnableHook.getHookValue()).booleanValue();
			currentRequiredEvictBytes = maxMem;
		}
		// #endif
		// #endif
		// #if LOGGINGEVICTOR
		// #if LOGGINGBASE
		Logger logger = envImpl.getLogger();
		// #endif
		// #endif
		// #if LOGGINGEVICTOR
		// #if LOGGINGBASE
		if (logger.isLoggable(detailedTraceLevel))
		// #if LOGGINGEVICTOR
		// #if LOGGINGBASE
		{
			Runtime r = Runtime.getRuntime();
			long totalBytes = r.totalMemory();
			long freeBytes = r.freeMemory();
			long usedBytes = r.totalMemory() - r.freeMemory();
			StringBuffer sb = new StringBuffer();
			sb.append(" source=").append(source);
			sb.append(" doRun=").append(doRun);
			// #if MEMORYBUDGET
			sb.append(" JEusedBytes=").append(formatter.format(currentUsage));
			// #endif
			sb.append(" requiredEvict=").append(
					formatter.format(currentRequiredEvictBytes));
			sb.append(" JVMtotalBytes= ").append(formatter.format(totalBytes));
			sb.append(" JVMfreeBytes= ").append(formatter.format(freeBytes));
			sb.append(" JVMusedBytes= ").append(formatter.format(usedBytes));
			logger.log(detailedTraceLevel, sb.toString());
		}
		// #endif
		// #endif
		// #endif
		// #endif
		return doRun;
	}

	/**
	 * Select a single node to evict.
	 */
	private IN selectIN(INList inList, ScanIterator scanIter)
			throws DatabaseException {
		IN target = null;
		long targetGeneration = Long.MAX_VALUE;
		int targetLevel = Integer.MAX_VALUE;
		boolean targetDirty = true;
		boolean envIsReadOnly = envImpl.isReadOnly();
		int scanned = 0;
		boolean wrapped = false;
		while (scanned < nodesPerScan) {
			if (scanIter.hasNext()) {
				IN in = scanIter.next();
				nNodesScannedThisRun++;
				DatabaseImpl db = in.getDatabase();
				if (db == null
				// #if DELETEOP
						|| db.isDeleteFinished()
				// #endif
				) {
					String inInfo = " IN type=" + in.getLogType() + " id="
							+ in.getNodeId() + " not expected on INList";
					String errMsg = (db == null) ? inInfo : "Database "
							+ db.getDebugName() + " id=" + db.getId() + inInfo;
					throw new DatabaseException(errMsg);
				}
				// #if DELETEOP
				if (db.isDeleted())
				// #if DELETEOP
				{
					continue;
				}
				// #endif
				// #endif
				if (db.getId().equals(DbTree.ID_DB_ID)) {
					continue;
				}
				if (envIsReadOnly && (target != null) && in.getDirty()) {
					continue;
				}
				int evictType = in.getEvictionType();
				if (evictType == IN.MAY_NOT_EVICT) {
					continue;
				}
				if (evictByLruOnly) {
					if (targetGeneration > in.getGeneration()) {
						targetGeneration = in.getGeneration();
						target = in;
					}
				} else {
					int level = normalizeLevel(in, evictType);
					if (targetLevel != level) {
						if (targetLevel > level) {
							targetLevel = level;
							targetDirty = in.getDirty();
							targetGeneration = in.getGeneration();
							target = in;
						}
					} else if (targetDirty != in.getDirty()) {
						if (targetDirty) {
							targetDirty = false;
							targetGeneration = in.getGeneration();
							target = in;
						}
					} else {
						if (targetGeneration > in.getGeneration()) {
							targetGeneration = in.getGeneration();
							target = in;
						}
					}
				}
				scanned++;
			} else {
				if (wrapped) {
					break;
				} else {
					nextNode = inList.first();
					scanIter.reset(nextNode);
					wrapped = true;
				}
			}
		}
		// #if STATISTICS
		if (target != null)
		// #if STATISTICS
		{
			nNodesSelectedThisRun++;
			nNodesSelected++;
		}
		// #endif
		// #endif
		return target;
	}

	/**
	 * Normalize the tree level of the given IN. Is public for unit testing. A
	 * BIN containing evictable LNs is given level 0, so it will be stripped
	 * first. For non-duplicate and DBMAP trees, the high order bits are cleared
	 * to make their levels correspond; that way, all bottom level nodes (BINs
	 * and DBINs) are given the same eviction priority. Note that BINs in a
	 * duplicate tree are assigned the same level as BINs in a non-duplicate
	 * tree. This isn't always optimimal, but is the best we can do considering
	 * that BINs in duplicate trees may contain a mix of LNs and DINs.
	 */
	public int normalizeLevel(IN in, int evictType) {
		int level = in.getLevel() & IN.LEVEL_MASK;
		if (level == 1 && evictType == IN.MAY_EVICT_LNS) {
			level = 0;
		}
		return level;
	}

	/**
	 * Strip or evict this node.
	 * 
	 * @return number of bytes evicted.
	 */
	private long evict(INList inList, IN target, ScanIterator scanIter)
			throws DatabaseException {
		boolean envIsReadOnly = envImpl.isReadOnly();
		long evictedBytes = 0;
		// #if LATCHES
		if (target.latchNoWait(false)) {
			try {
				if (target instanceof BIN) {
					// #if INCOMPRESSOR
					envImpl.lazyCompress(target);
					// #endif
					evictedBytes = ((BIN) target).evictLNs();
					// #if STATISTICS
					if (evictedBytes > 0)
					// #if STATISTICS
					{
						nBINsStrippedThisRun++;
						nBINsStripped++;
					}
					// #endif
					// #endif
				}
				if (evictedBytes == 0 && target.isEvictable()) {
					Tree tree = target.getDatabase().getTree();
					SearchResult result = tree.getParentINForChildIN(target,
							true, false);
					if (result.exactParentFound) {
						evictedBytes = evictIN(target, result.parent,
								result.index, inList, scanIter, envIsReadOnly);
					}
				}
			} finally {
				target.releaseLatchIfOwner();
			}
		}
		// #endif
		return evictedBytes;
	}

	/**
	 * Evict an IN. Dirty nodes are logged before they're evicted. inlist is
	 * latched with the major latch by the caller.
	 */
	private long evictIN(IN child, IN parent, int index, INList inlist,
			ScanIterator scanIter, boolean envIsReadOnly)
			throws DatabaseException {
		long evictBytes = 0;
		// #if LATCHES
		try {
			// #if LATCHES
			assert parent.isLatchOwner();
			// #endif
			long oldGenerationCount = child.getGeneration();
			IN renewedChild = (IN) parent.getTarget(index);
			if ((renewedChild != null)
					&& (renewedChild.getGeneration() <= oldGenerationCount)
					&& renewedChild.latchNoWait(false)) {
				// #if LATCHES
				try {
					if (renewedChild.isEvictable()) {
						long renewedChildLsn = DbLsn.NULL_LSN;
						boolean newChildLsn = false;
						if (renewedChild.getDirty()) {
							if (!envIsReadOnly) {
								boolean logProvisional = (envImpl
										.getCheckpointer() != null && (renewedChild
										.getLevel() < envImpl.getCheckpointer()
										.getHighestFlushLevel()));
								renewedChildLsn = renewedChild.log(logManager,
										false, logProvisional, true, parent);
								newChildLsn = true;
							}
						} else {
							renewedChildLsn = parent.getLsn(index);
						}
						if (renewedChildLsn != DbLsn.NULL_LSN) {
							scanIter.mark();
							inlist.removeLatchAlreadyHeld(renewedChild);
							scanIter.resetToMark();
							// #if MEMORYBUDGET
							evictBytes = renewedChild.getInMemorySize();
							// #endif
							if (newChildLsn) {
								parent.updateEntry(index, null, renewedChildLsn);
							} else {
								parent.updateEntry(index, (Node) null);
							}
							// #if STATISTICS
							nNodesEvictedThisRun++;
							// #endif
							// #if STATISTICS
							nNodesEvicted++;
							// #endif
						}
					}
				} finally {
					renewedChild.releaseLatch();
				}
				// #endif
			}
		} finally {
			parent.releaseLatch();
		}
		// #endif
		return evictBytes;
	}

	/**
	 * Used by unit tests.
	 */
	IN getNextNode() {
		return nextNode;
	}

	public void setRunnableHook(TestHook hook) {
		runnableHook = hook;
	}

	static public class EvictProfile {
		private List candidates = new ArrayList();

		public boolean count(IN target) {
			candidates.add(new Long(target.getNodeId()));
			return true;
		}

		public List getCandidates() {
			return candidates;
		}

		public boolean clear() {
			candidates.clear();
			return true;
		}
	}

	private static class ScanIterator {
		private INList inList;
		private Iterator iter;
		private IN nextMark;

		ScanIterator(IN startingIN, INList inList) throws DatabaseException {
			this.inList = inList;
			reset(startingIN);
		}

		void reset(IN startingIN) throws DatabaseException {
			iter = inList.tailSet(startingIN).iterator();
		}

		IN mark() throws DatabaseException {
			if (iter.hasNext()) {
				nextMark = (IN) iter.next();
			} else {
				nextMark = (IN) inList.first();
			}
			return (IN) nextMark;
		}

		void resetToMark() throws DatabaseException {
			reset(nextMark);
		}

		boolean hasNext() {
			return iter.hasNext();
		}

		IN next() {
			return (IN) iter.next();
		}

		void remove() {
			iter.remove();
		}
	}
}
// #endif
