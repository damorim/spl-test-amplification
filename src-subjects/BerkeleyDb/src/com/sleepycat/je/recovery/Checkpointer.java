package com.sleepycat.je.recovery;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.Cleaner;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.TrackedFileSummary;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.UtilizationProfile;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.WithRootLatched;
import com.sleepycat.je.utilint.DaemonThread;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.PropUtil;
import com.sleepycat.je.utilint.Tracer;

/**
 * The Checkpointer looks through the tree for internal nodes that must be
 * flushed to the log. Checkpoint flushes must be done in ascending order from
 * the bottom of the tree up.
 */
public class Checkpointer
// #if CHECKPOINTERDAEMON
		extends DaemonThread
// #endif
{
	private EnvironmentImpl envImpl;
	private LogManager logManager;
	private long checkpointId;
	// #if CPBYTES
	private long logSizeBytesInterval;
	// #endif
	private long logFileMax;
	// #if CPTIME
	private long timeInterval;
	// #endif
	private long lastCheckpointMillis;
	// #if STATISTICS
	private int nCheckpoints;
	// #endif
	private long lastFirstActiveLsn;
	// #if STATISTICS
	private long lastCheckpointStart;
	// #endif
	private long lastCheckpointEnd;
	// #if STATISTICS
	private int nFullINFlush;
	// #endif
	// #if STATISTICS
	private int nFullBINFlush;
	// #endif
	// #if STATISTICS
	private int nDeltaINFlush;
	// #endif
	// #if STATISTICS
	private int nFullINFlushThisRun;
	// #endif
	// #if STATISTICS
	private int nDeltaINFlushThisRun;
	// #endif
	private volatile int highestFlushLevel;

	public Checkpointer(EnvironmentImpl envImpl, long waitTime, String name) throws DatabaseException {
		// #if CHECKPOINTERDAEMON
		super(0 + waitTime, name, envImpl);
		// #endif
		this.envImpl = envImpl;
		// #if CPBYTES
		logSizeBytesInterval = envImpl.getConfigManager().getLong(
				EnvironmentParams.CHECKPOINTER_BYTES_INTERVAL);
		// #endif
		logFileMax = envImpl.getConfigManager().getLong(
				EnvironmentParams.LOG_FILE_MAX);
		// #if STATISTICS
		nCheckpoints = 0;
		// #endif
		// #if CPTIME
		timeInterval = waitTime;
		// #endif
		lastCheckpointMillis = 0;
		highestFlushLevel = IN.MIN_LEVEL;
		logManager = envImpl.getLogManager();
	}

	public int getHighestFlushLevel() {
		return highestFlushLevel;
	}

	// #if CPTIME
	// #if CPBYTES
	/**
	 * Figure out the wakeup period. Supplied through this static method because
	 * we need to pass wakeup period to the superclass and need to do the
	 * calcuation outside this constructor.
	 */
	public static long getWakeupPeriod(DbConfigManager configManager)
			throws IllegalArgumentException, DatabaseException {
		long wakeupPeriod = PropUtil.microsToMillis(configManager
				.getLong(EnvironmentParams.CHECKPOINTER_WAKEUP_INTERVAL));
		long bytePeriod = configManager
				.getLong(EnvironmentParams.CHECKPOINTER_BYTES_INTERVAL);
		if ((wakeupPeriod == 0) && (bytePeriod == 0)) {
			throw new IllegalArgumentException(
					EnvironmentParams.CHECKPOINTER_BYTES_INTERVAL.getName()
							+ " and "
							+ EnvironmentParams.CHECKPOINTER_WAKEUP_INTERVAL
									.getName() + " cannot both be 0. ");
		}
		if (bytePeriod == 0) {
			return 0 + wakeupPeriod;
		} else {
			return 0;
		}
	}

	// #endif
	// #endif

	/**
	 * Set checkpoint id -- can only be done after recovery.
	 */
	synchronized public void setCheckpointId(long lastCheckpointId) {
		checkpointId = lastCheckpointId;
	}

	// #if CHECKPOINTERDAEMON
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<Checkpointer name=\"").append(name).append("\"/>");
		return sb.toString();
	}

	// #endif
	// #if STATISTICS
	/**
	 * Load stats.
	 */
	public void loadStats(StatsConfig config, EnvironmentStats stat)
			throws DatabaseException {
		stat.setNCheckpoints(nCheckpoints);
		stat.setLastCheckpointStart(lastCheckpointStart);
		stat.setLastCheckpointEnd(lastCheckpointEnd);
		stat.setLastCheckpointId(checkpointId);
		stat.setNFullINFlush(nFullINFlush);
		stat.setNFullBINFlush(nFullBINFlush);
		stat.setNDeltaINFlush(nDeltaINFlush);
		if (config.getClear()) {
			nCheckpoints = 0;
			nFullINFlush = 0;
			nFullBINFlush = 0;
			nDeltaINFlush = 0;
		}
	}

	// #endif
	/**
	 * @return the first active LSN point of the last completed checkpoint. If
	 *         no checkpoint has run, return null.
	 */
	public long getFirstActiveLsn() {
		return lastFirstActiveLsn;
	}

	/**
	 * Initialize the FirstActiveLsn during recovery. The cleaner needs this.
	 */
	public void setFirstActiveLsn(long lastFirstActiveLsn) {
		this.lastFirstActiveLsn = lastFirstActiveLsn;
	}

	// #if CHECKPOINTERDAEMON
	synchronized public void clearEnv() {
		envImpl = null;
	}

	// #endif
	// #if CHECKPOINTERDAEMON
	/**
	 * Return the number of retries when a deadlock exception occurs.
	 */
	protected int nDeadlockRetries() throws DatabaseException {
		return envImpl.getConfigManager().getInt(
				EnvironmentParams.CHECKPOINTER_RETRY);
	}

	// #endif
	// #if CHECKPOINTERDAEMON
	/**
	 * Called whenever the DaemonThread wakes up from a sleep.
	 */
	protected void onWakeup() throws DatabaseException {
		if (envImpl.isClosed()) {
			return;
		}
		doCheckpoint(CheckpointConfig.DEFAULT, false, "daemon");
	}

	// #endif
	/**
	 * Determine whether a checkpoint should be run. 1. If the force parameter
	 * is specified, always checkpoint. 2. If the config object specifies time
	 * or log size, use that. 3. If the environment is configured to use log
	 * size based checkpointing, check the log. 4. Lastly, use time based
	 * checking.
	 */
	private boolean isRunnable(CheckpointConfig config)
			throws DatabaseException {
		boolean result = false;
		// #if CPBYTES
		long useBytesInterval = 0;
		// #endif
		// #if CPTIME
		long useTimeInterval = 0;
		// #endif
		long nextLsn = DbLsn.NULL_LSN;
		try {
			if (config.getForce()) {
				result = true;
			}
			// #if CPBYTES
			else if (config.getKBytes() != 0)
			// #if CPBYTES
			{
				useBytesInterval = config.getKBytes() << 10;
			}
			// #endif
			else
			// #if CPTIME
			if (config.getMinutes() != 0)
			// #if CPTIME
			{
				useTimeInterval = config.getMinutes() * 60 * 1000;
			}
			// #endif
			else
			// #if CPBYTES
			if (logSizeBytesInterval != 0)
			// #if CPBYTES
			{
				useBytesInterval = logSizeBytesInterval;
			}
			// #endif
			else
			// #if CPTIME
			{
				useTimeInterval = timeInterval;
			}
			// #endif
			// #endif
			// #endif
			// #endif
			// #if CPBYTES
			if (useBytesInterval != 0)
			// #if CPBYTES
			{
				nextLsn = envImpl.getFileManager().getNextLsn();
				if (DbLsn.getNoCleaningDistance(nextLsn, lastCheckpointEnd,
						logFileMax) >= useBytesInterval) {
					result = true;
				} else {
					result = false;
				}
			}
			// #endif
			else
			// #if CPTIME
			if (useTimeInterval != 0)
			// #if CPTIME
			{
				long lastUsedLsn = envImpl.getFileManager().getLastUsedLsn();
				if (((System.currentTimeMillis() - lastCheckpointMillis) >= useTimeInterval)
						&& (DbLsn.compareTo(lastUsedLsn, lastCheckpointEnd) != 0)) {
					result = true;
				} else {
					result = false;
				}
			}
			// #endif
			else {
				result = false;
			}
			// #endif
			// #endif
		} finally {
			// #if LOGGINGFINEST
			StringBuffer sb = new StringBuffer();
			// #endif
			// #if LOGGINGFINEST
			// #if CPBYTES
			sb.append("size interval=").append(useBytesInterval);
			// #endif
			// #endif
			// #if LOGGINGFINEST
			if (nextLsn != DbLsn.NULL_LSN)
			// #if LOGGINGFINEST
			{
				sb.append(" " + "nextLsn=").append(
						DbLsn.getNoFormatString(nextLsn));
			}
			// #endif
			// #endif
			// #if LOGGINGFINEST
			if (lastCheckpointEnd != DbLsn.NULL_LSN)
			// #if LOGGINGFINEST
			{
				sb.append(" lastCkpt=");
				sb.append(DbLsn.getNoFormatString(lastCheckpointEnd));
			}
			// #endif
			// #endif
			// #if LOGGINGFINEST
			// #if CPTIME
			sb.append(" time interval=").append(useTimeInterval);
			// #endif
			// #endif
			// #if LOGGINGFINEST
			sb.append(" force=").append(config.getForce());
			// #endif
			// #if LOGGINGFINEST
			Tracer.trace(Level.FINEST, envImpl, sb.toString());
			// #endif
		}
		return result;
	}

	/**
	 * The real work to do a checkpoint. This may be called by the checkpoint
	 * thread when waking up, or it may be invoked programatically through the
	 * api.
	 * 
	 * @param allowDeltas
	 *            if true, this checkpoint may opt to log BIN deltas instead of
	 *            the full node.
	 * @param flushAll
	 *            if true, this checkpoint must flush all the way to the top of
	 *            the dbtree, instead of stopping at the highest level last
	 *            modified.
	 * @param invokingSource
	 *            a debug aid, to indicate who invoked this checkpoint. (i.e.
	 *            recovery, the checkpointer daemon, the cleaner,
	 *            programatically)
	 */
	public synchronized void doCheckpoint(CheckpointConfig config,
			boolean flushAll, String invokingSource) throws DatabaseException {
		if (envImpl.isReadOnly()) {
			return;
		}
		if (!isRunnable(config)) {
			return;
		}
		// #if CLEANER
		boolean flushExtraLevel = false;
		// #endif
		// #if CLEANER
		Cleaner cleaner = envImpl.getCleaner();
		// #endif
		// #if CLEANER
		Set[] cleanerFiles = cleaner.getFilesAtCheckpointStart();
		// #endif
		// #if CLEANER
		if (cleanerFiles != null)
		// #if CLEANER
		{
			flushExtraLevel = true;
		}
		// #endif
		// #endif
		lastCheckpointMillis = System.currentTimeMillis();
		// #if STATISTICS
		resetPerRunCounters();
		// #endif
		checkpointId++;
		// #if STATISTICS
		nCheckpoints++;
		// #endif
		boolean success = false;
		// #if LOGGINGCONFIG
		boolean traced = false;
		// #endif
		// #if MEMORYBUDGET
		int dirtyMapMemSize = 0;
		// #endif
		MemoryBudget mb = envImpl.getMemoryBudget();
		try {
			long checkpointStart = DbLsn.NULL_LSN;
			long firstActiveLsn = DbLsn.NULL_LSN;
			SortedMap dirtyMap = null;
			// #if EVICTOR
			synchronized (envImpl.getEvictor()) {
				CheckpointStart startEntry = new CheckpointStart(checkpointId,
						invokingSource);
				checkpointStart = logManager.log(startEntry);
				// #if TRANSACTIONS
				firstActiveLsn = envImpl.getTxnManager().getFirstActiveLsn();
				// #endif
				if (firstActiveLsn == DbLsn.NULL_LSN) {
					firstActiveLsn = checkpointStart;
				} else {
					if (DbLsn.compareTo(checkpointStart, firstActiveLsn) < 0) {
						firstActiveLsn = checkpointStart;
					}
				}
				dirtyMap = selectDirtyINs(flushAll, flushExtraLevel);
			}
			// #endif
			// #if MEMORYBUDGET
			int totalSize = 0;
			// #endif
			for (Iterator i = dirtyMap.values().iterator(); i.hasNext();) {
				Set nodeSet = (Set) i.next();

				// #if MEMORYBUDGET
				int size = nodeSet.size()
						* MemoryBudget.CHECKPOINT_REFERENCE_SIZE;
				totalSize += size;
				dirtyMapMemSize += size;
				// #endif
			}
			// #if MEMORYBUDGET
			mb.updateMiscMemoryUsage(totalSize);
			// #endif
			boolean allowDeltas = !config.getMinimizeRecoveryTime();
			flushDirtyNodes(dirtyMap, flushAll, allowDeltas, flushExtraLevel, checkpointStart);
			// #if CLEANER
			flushUtilizationInfo();
			// #endif
			CheckpointEnd endEntry = new CheckpointEnd(invokingSource,
					checkpointStart, envImpl.getRootLsn(), firstActiveLsn,
					Node.getLastId(), envImpl.getDbMapTree().getLastDbId(),
					// #if TRANSACTIONS
					envImpl.getTxnManager().getLastTxnId(),
					// #endif
					checkpointId);
			// #if LOGGINGCONFIG
			trace(envImpl, invokingSource, true);
			// #endif
			// #if LOGGINGCONFIG
			traced = true;
			// #endif
			lastCheckpointEnd = logManager.logForceFlush(endEntry, true);
			lastFirstActiveLsn = firstActiveLsn;
			// #if STATISTICS
			lastCheckpointStart = checkpointStart;
			// #endif
			highestFlushLevel = IN.MIN_LEVEL;
			success = true;
			// #if CLEANER
			if (cleanerFiles != null)
			// #if CLEANER
			{
				cleaner.updateFilesAtCheckpointEnd(cleanerFiles);
			}
			// #endif
			// #endif
		}

		// #if LOGGINGSEVERE
		catch (
		// #if LOGGINGSEVERE
		DatabaseException e
		// #endif
		)
		// #if LOGGINGSEVERE
		{
			// #if LOGGINGSEVERE
			Tracer.trace(envImpl, "Checkpointer", "doCheckpoint",
					"checkpointId=" + checkpointId, e);
			// #endif
			throw e;
		}
		// #endif
		// #endif
		finally {
			// #if MEMORYBUDGET
			mb.updateMiscMemoryUsage(0 - dirtyMapMemSize);
			// #endif
			// #if LOGGINGCONFIG
			if (!traced)
			// #if LOGGINGCONFIG
			{
				trace(envImpl, invokingSource, success);
			}
			// #endif
			// #endif
		}
	}

	// #if LOGGINGCONFIG
	private void trace(EnvironmentImpl envImpl, String invokingSource,
			boolean success) {
		StringBuffer sb = new StringBuffer();
		sb.append("Checkpoint ").append(checkpointId);
		sb.append(": source=").append(invokingSource);
		sb.append(" success=").append(success);
		// #if STATISTICS
		sb.append(" nFullINFlushThisRun=").append(nFullINFlushThisRun);
		// #endif
		// #if STATISTICS
		sb.append(" nDeltaINFlushThisRun=").append(nDeltaINFlushThisRun);
		// #endif
		// #if LOGGINGCONFIG
		Tracer.trace(Level.CONFIG, envImpl, sb.toString());
		// #endif
	}

	// #endif
	// #if CLEANER
	/**
	 * Flush a FileSummaryLN node for each TrackedFileSummary that is currently
	 * active. Tell the UtilizationProfile about the updated file summary.
	 */
	private void flushUtilizationInfo() throws DatabaseException {
		if (!DbInternal.getCheckpointUP(envImpl.getConfigManager()
				.getEnvironmentConfig())) {
			return;
		}
		UtilizationProfile profile = envImpl.getUtilizationProfile();
		TrackedFileSummary[] activeFiles = envImpl.getUtilizationTracker()
				.getTrackedFiles();
		for (int i = 0; i < activeFiles.length; i += 1) {
			profile.flushFileSummary(activeFiles[i]);
		}
	}

	// #endif
	/**
	 * Flush the nodes in order, from the lowest level to highest level. As a
	 * flush dirties its parent, add it to the dirty map, thereby cascading the
	 * writes up the tree. If flushAll wasn't specified, we need only cascade up
	 * to the highest level set at the start of checkpointing. Note that all but
	 * the top level INs and the BINDeltas are logged provisionally. That's
	 * because we don't need to process lower INs because the higher INs will
	 * end up pointing at them.
	 */
	private void flushDirtyNodes(SortedMap dirtyMap, boolean flushAll,
			boolean allowDeltas, boolean flushExtraLevel, long checkpointStart) throws DatabaseException {
		while (dirtyMap.size() > 0) {
			Integer currentLevel = (Integer) dirtyMap.firstKey();
			boolean logProvisionally = (currentLevel.intValue() != highestFlushLevel);
			Set nodeSet = (Set) dirtyMap.get(currentLevel);
			Iterator iter = nodeSet.iterator();
			while (iter.hasNext()) {
				CheckpointReference targetRef = (CheckpointReference) iter
						.next();
				// #if CRITICALEVICTION
				// #if EVICTOR
				envImpl.getEvictor().doCriticalEviction();
				// #endif
				// #endif
				// #if DELETEOP
				if (!(targetRef.db.isDeleted()))
				// #if DELETEOP
				{
					flushIN(targetRef, dirtyMap, currentLevel.intValue(),
							logProvisionally, allowDeltas, checkpointStart);
				}
				// #endif
				// #endif
				iter.remove();
			}
			dirtyMap.remove(currentLevel);
			if (currentLevel.intValue() == highestFlushLevel) {
				break;
			}
		}
	}

	/**
	 * Scan the INList for all dirty INs. Arrange them in level sorted map for
	 * level ordered flushing.
	 */
	private SortedMap selectDirtyINs(boolean flushAll, boolean flushExtraLevel) throws DatabaseException {
		SortedMap newDirtyMap = new TreeMap();
		INList inMemINs = envImpl.getInMemoryINs();
		// #if LATCHES
		inMemINs.latchMajor();
		// #endif
		// #if MEMORYBUDGET
		long totalSize = 0;
		// #endif
		// #if MEMORYBUDGET
		MemoryBudget mb = envImpl.getMemoryBudget();
		// #endif
		// #if LATCHES
		try {
			Iterator iter = inMemINs.iterator();
			while (iter.hasNext()) {
				IN in = (IN) iter.next();
				in.latch(false);
				// #if LATCHES
				try {
					// #if MEMORYBUDGET
					totalSize = mb.accumulateNewUsage(in, totalSize);
					// #endif
					if (in.getDirty()) {
						Integer level = new Integer(in.getLevel());
						Set dirtySet;
						if (newDirtyMap.containsKey(level)) {
							dirtySet = (Set) newDirtyMap.get(level);
						} else {
							dirtySet = new HashSet();
							newDirtyMap.put(level, dirtySet);
						}
						dirtySet.add(new CheckpointReference(in.getDatabase(),
								in.getNodeId(), in.containsDuplicates(), in
										.isDbRoot(), in.getMainTreeKey(), in
										.getDupTreeKey()));
					}
				} finally {
					in.releaseLatch();
				}
				// #endif
			}
			// #if MEMORYBUDGET
			mb.refreshTreeMemoryUsage(totalSize);
			// #endif
			if (newDirtyMap.size() > 0) {
				if (flushAll) {
					highestFlushLevel = envImpl.getDbMapTree()
							.getHighestLevel();
				} else {
					highestFlushLevel = ((Integer) newDirtyMap.lastKey())
							.intValue();
					// #if CLEANER
					if (flushExtraLevel)
					// #if CLEANER
					{
						highestFlushLevel += 1;
					}
					// #endif
					// #endif
				}
			} else {
				highestFlushLevel = IN.MAX_LEVEL;
			}
		} finally {
			inMemINs.releaseMajorLatchIfHeld();
		}
		// #endif
		return newDirtyMap;
	}

	/**
	 * Flush the target IN.
	 */
	private void flushIN(CheckpointReference targetRef, Map dirtyMap,
			int currentLevel, boolean logProvisionally, boolean allowDeltas,
			long checkpointStart) throws DatabaseException {
		Tree tree = targetRef.db.getTree();
		boolean targetWasRoot = false;
		if (targetRef.isDbRoot) {
			RootFlusher flusher = new RootFlusher(targetRef.db, logManager,
					targetRef.nodeId);
			tree.withRootLatchedExclusive(flusher);
			boolean flushed = flusher.getFlushed();
			targetWasRoot = flusher.stillRoot();
			if (flushed) {
				DbTree dbTree = targetRef.db.getDbEnvironment().getDbMapTree();
				dbTree.modifyDbRoot(targetRef.db);
				// #if STATISTICS
				nFullINFlushThisRun++;
				// #endif
				// #if STATISTICS
				nFullINFlush++;
				// #endif
			}
		}
		if (!targetWasRoot) {
			SearchResult result = tree.getParentINForChildIN(targetRef.nodeId,
					targetRef.containsDuplicates, false, targetRef.mainTreeKey,
					targetRef.dupTreeKey, false, false, -1, null, false);
			if (result.parent != null) {
				boolean mustLogParent = false;
				// #if LATCHES
				try {
					if (result.exactParentFound) {
						IN renewedTarget = (IN) result.parent
								.getTarget(result.index);
						if (renewedTarget == null) {
							mustLogParent = true;
						} else {
							mustLogParent = logTargetAndUpdateParent(
									renewedTarget, result.parent, result.index,
									allowDeltas, checkpointStart,
									logProvisionally);
						}
					} else {
						if (result.childNotResident) {
							if (result.parent.getLevel() > currentLevel) {
								mustLogParent = true;
							}
						}
					}
					if (mustLogParent) {
						assert checkParentChildRelationship(result,
								currentLevel) : dumpParentChildInfo(result,
								result.parent, targetRef.nodeId, currentLevel,
								tree);
						addToDirtyMap(dirtyMap, result.parent);
					}
				} finally {
					result.parent.releaseLatch();
				}
				// #endif
			}
		}
	}

	/**
	 * @return true if this parent is appropriately 1 level above the child.
	 */
	private boolean checkParentChildRelationship(SearchResult result,
			int childLevel) {
		if (result.childNotResident && !result.exactParentFound) {
			return true;
		}
		int parentLevel = result.parent.getLevel();
		boolean isMapTree = (childLevel & IN.DBMAP_LEVEL) != 0;
		boolean isMainTree = (childLevel & IN.MAIN_LEVEL) != 0;
		boolean checkOk = false;
		if (isMapTree || isMainTree) {
			if (parentLevel == (childLevel + 1)) {
				checkOk = true;
			}
		} else {
			if (childLevel == 1) {
				if (parentLevel == 2) {
					checkOk = true;
				}
			} else {
				if ((parentLevel == IN.BIN_LEVEL)
						|| (parentLevel == childLevel + 1)) {
					checkOk = true;
				}
			}
		}
		return checkOk;
	}

	private String dumpParentChildInfo(SearchResult result, IN parent,
			long childNodeId, int currentLevel, Tree tree)
			throws DatabaseException {
		StringBuffer sb = new StringBuffer();
		sb.append("ckptId=").append(checkpointId);
		sb.append(" result=").append(result);
		sb.append(" parent node=").append(parent.getNodeId());
		sb.append(" level=").append(parent.getLevel());
		sb.append(" child node=").append(childNodeId);
		sb.append(" level=").append(currentLevel);
		return sb.toString();
	}

	private boolean logTargetAndUpdateParent(IN target, IN parent, int index,
			boolean allowDeltas, long checkpointStart, boolean logProvisionally)
			throws DatabaseException {
		target.latch(false);
		long newLsn = DbLsn.NULL_LSN;
		boolean mustLogParent = true;
		// #if LATCHES
		try {
			// #if INCOMPRESSOR
			envImpl.lazyCompress(target);
			// #endif
			if (target.getDirty()) {
				newLsn = target.log(logManager, allowDeltas, logProvisionally,
						true, parent);
				if (allowDeltas && newLsn == DbLsn.NULL_LSN) {
					// #if STATISTICS
					nDeltaINFlushThisRun++;
					// #endif
					// #if STATISTICS
					nDeltaINFlush++;
					// #endif
					long lastFullLsn = target.getLastFullVersion();
					if (DbLsn.compareTo(lastFullLsn, checkpointStart) < 0) {
						mustLogParent = false;
					}
				}
			}
		} finally {
			target.releaseLatch();
		}
		// #endif
		if (newLsn != DbLsn.NULL_LSN) {
			// #if STATISTICS
			nFullINFlushThisRun++;
			// #endif
			// #if STATISTICS
			nFullINFlush++;
			// #endif
			// #if STATISTICS
			if (target instanceof BIN)
			// #if STATISTICS
			{
				nFullBINFlush++;
			}
			// #endif
			// #endif
			parent.updateEntry(index, newLsn);
		}
		return mustLogParent;
	}

	private static class RootFlusher implements WithRootLatched {
		private DatabaseImpl db;
		private boolean flushed;
		private boolean stillRoot;
		private LogManager logManager;
		private long targetNodeId;

		RootFlusher(DatabaseImpl db, LogManager logManager, long targetNodeId) {
			this.db = db;
			flushed = false;
			this.logManager = logManager;
			this.targetNodeId = targetNodeId;
			stillRoot = false;
		}

		/**
		 * Flush the rootIN if dirty.
		 */
		public IN doWork(ChildReference root) throws DatabaseException {
			if (root == null) {
				return null;
			}
			IN rootIN = (IN) root.fetchTarget(db, null);
			rootIN.latch(false);
			// #if LATCHES
			try {
				if (rootIN.getNodeId() == targetNodeId) {
					stillRoot = true;
					if (rootIN.getDirty()) {
						long newLsn = rootIN.log(logManager);
						root.setLsn(newLsn);
						flushed = true;
					}
				}
			} finally {
				rootIN.releaseLatch();
			}
			// #endif
			return null;
		}

		boolean getFlushed() {
			return flushed;
		}

		boolean stillRoot() {
			return stillRoot;
		}
	}

	/**
	 * Add a node to the dirty map. The dirty map is keyed by level (Integers)
	 * and holds sets of IN references.
	 */
	private void addToDirtyMap(Map dirtyMap, IN in) {
		Integer inLevel = new Integer(in.getLevel());
		Set inSet = (Set) dirtyMap.get(inLevel);
		if (inSet == null) {
			inSet = new HashSet();
			dirtyMap.put(inLevel, inSet);
		}
		inSet.add(new CheckpointReference(in.getDatabase(), in.getNodeId(), in
				.containsDuplicates(), in.isDbRoot(), in.getMainTreeKey(), in
				.getDupTreeKey()));
	}

	// #if STATISTICS
	/**
	 * Reset per-run counters.
	 */
	private void resetPerRunCounters() {
		nFullINFlushThisRun = 0;
		nDeltaINFlushThisRun = 0;
	}

	// #endif
	public static class CheckpointReference {
		DatabaseImpl db;
		long nodeId;
		boolean containsDuplicates;
		boolean isDbRoot;
		byte[] mainTreeKey;
		byte[] dupTreeKey;

		public CheckpointReference(DatabaseImpl db, long nodeId,
				boolean containsDuplicates, boolean isDbRoot,
				byte[] mainTreeKey, byte[] dupTreeKey) {
			this.db = db;
			this.nodeId = nodeId;
			this.containsDuplicates = containsDuplicates;
			this.isDbRoot = isDbRoot;
			this.mainTreeKey = mainTreeKey;
			this.dupTreeKey = dupTreeKey;
		}

		public boolean equals(Object o) {
			if (!(o instanceof CheckpointReference)) {
				return false;
			}
			CheckpointReference other = (CheckpointReference) o;
			return nodeId == other.nodeId;
		}

		public int hashCode() {
			return (int) nodeId;
		}
	}
}
