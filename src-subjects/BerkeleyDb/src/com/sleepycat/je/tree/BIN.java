package com.sleepycat.je.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import com.sleepycat.je.DatabaseException;
//#if CLEANER
import com.sleepycat.je.cleaner.Cleaner;
//#endif
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.LoggableObject;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.TinyHashSet;

/**
 * A BIN represents a Bottom Internal Node in the JE tree.
 */
public class BIN extends IN implements LoggableObject {
	private static final String BEGIN_TAG = "<bin>";
	private static final String END_TAG = "</bin>";
	private TinyHashSet cursorSet;
	private long lastDeltaVersion = DbLsn.NULL_LSN;
	private int numDeltasSinceLastFull;
	private boolean prohibitNextDelta;

	public BIN() {
		cursorSet = new TinyHashSet();
		numDeltasSinceLastFull = 0;
		prohibitNextDelta = false;
	}

	public BIN(DatabaseImpl db, byte[] identifierKey, int maxEntriesPerNode,
			int level) {
		super(db, identifierKey, maxEntriesPerNode, level);
		cursorSet = new TinyHashSet();
		numDeltasSinceLastFull = 0;
		prohibitNextDelta = false;
	}

	/**
	 * Create a holder object that encapsulates information about this BIN for
	 * the INCompressor.
	 */
	public BINReference createReference() {
		return new BINReference(getNodeId(), getDatabase().getId(),
				getIdentifierKey());
	}

	/**
	 * Create a new BIN. Need this because we can't call newInstance() without
	 * getting a 0 for nodeid.
	 */
	protected IN createNewInstance(byte[] identifierKey, int maxEntries,
			int level) {
		return new BIN(getDatabase(), identifierKey, maxEntries, level);
	}

	/**
	 * Get the key (dupe or identifier) in child that is used to locate it in
	 * 'this' node. For BIN's, the child node has to be a DIN so we use the Dup
	 * Key to cross the main-tree/dupe-tree boundary.
	 */
	public byte[] getChildKey(IN child) throws DatabaseException {
		return child.getDupKey();
	}

	/**
	 * @return the log entry type to use for bin delta log entries.
	 */
	LogEntryType getBINDeltaType() {
		return LogEntryType.LOG_BIN_DELTA;
	}

	/**
	 * @return location of last logged delta version. If never set, return null.
	 */
	public long getLastDeltaVersion() {
		return lastDeltaVersion;
	}

	/**
	 * If cleaned or compressed, must log full version.
	 * 
	 * @Override
	 */
	public void setProhibitNextDelta() {
		prohibitNextDelta = true;
	}

	protected void descendOnParentSearch(SearchResult result,
			boolean targetContainsDuplicates, boolean targetIsRoot,
			long targetNodeId, Node child, boolean requireExactMatch)
			throws DatabaseException {
		if (child.canBeAncestor(targetContainsDuplicates)) {
			if (targetContainsDuplicates && targetIsRoot) {
				long childNid = child.getNodeId();
				// #if LATCHES
				((IN) child).releaseLatch();
				// #endif
				result.keepSearching = false;
				if (childNid == targetNodeId) {
					result.exactParentFound = true;
				} else {
					result.exactParentFound = false;
				}
				if (requireExactMatch && !result.exactParentFound) {
					result.parent = null;
					// #if LATCHES
					releaseLatch();
					// #endif
				} else {
					result.parent = this;
				}
			} else {
				// #if LATCHES
				releaseLatch();
				// #endif
				result.parent = (IN) child;
			}
		} else {
			result.exactParentFound = false;
			result.keepSearching = false;
			if (!requireExactMatch && targetContainsDuplicates) {
				result.parent = this;
			} else {
				// #if LATCHES
				releaseLatch();
				// #endif
				result.parent = null;
			}
		}
	}

	protected boolean canBeAncestor(boolean targetContainsDuplicates) {
		return targetContainsDuplicates;
	}

	/**
	 * @Override
	 */
	boolean isEvictionProhibited() {
		return (nCursors() > 0);
	}

	/**
	 * @Override
	 */
	boolean hasNonLNChildren() {
		for (int i = 0; i < getNEntries(); i++) {
			Node node = getTarget(i);
			if (node != null) {
				if (!(node instanceof LN)) {
					return true;
				}
			}
		}
		return false;
	}

	// #if EVICTOR
	/**
	 * @Override
	 */
	int getChildEvictionType() {
		// #if CLEANER
		Cleaner cleaner = getDatabase().getDbEnvironment().getCleaner();
		// #endif
		for (int i = 0; i < getNEntries(); i++) {
			Node node = getTarget(i);
			if (node != null) {
				if (node instanceof LN) {
					// #if CLEANER
					if (cleaner.isEvictable(this, i)) {
						return MAY_EVICT_LNS;
					}
					// #endif
				} else {
					return MAY_NOT_EVICT;
				}
			}
		}
		return MAY_EVICT_NODE;
	}

	// #endif
	/**
	 * Indicates whether entry 0's key is "special" in that it always compares
	 * less than any other key. BIN's don't have the special key, but IN's do.
	 */
	boolean entryZeroKeyComparesLow() {
		return false;
	}

	/**
	 * Mark this entry as deleted, using the delete flag. Only BINS may do this.
	 * 
	 * @param index
	 *            indicates target entry
	 */
	public void setKnownDeleted(int index) {
		super.setKnownDeleted(index);
		// #if MEMORYBUDGET
		updateMemorySize(getTarget(index), null);
		// #endif
		setMigrate(index, false);
		super.setTarget(index, null);
		setDirty(true);
	}

	/**
	 * Mark this entry as deleted, using the delete flag. Only BINS may do this.
	 * Don't null the target field. This is used so that an LN can still be
	 * locked by the compressor even if the entry is knownDeleted. See
	 * BIN.compress.
	 * 
	 * @param index
	 *            indicates target entry
	 */
	public void setKnownDeletedLeaveTarget(int index) {
		setMigrate(index, false);
		super.setKnownDeleted(index);
		setDirty(true);
	}

	/**
	 * Clear the known deleted flag. Only BINS may do this.
	 * 
	 * @param index
	 *            indicates target entry
	 */
	public void clearKnownDeleted(int index) {
		super.clearKnownDeleted(index);
		setDirty(true);
	}

	// #if MEMORYBUDGET
	public static long computeOverhead(DbConfigManager configManager)
			throws DatabaseException {
		return MemoryBudget.BIN_FIXED_OVERHEAD
				+ IN.computeArraysOverhead(configManager);
	}

	// #endif
	// #if MEMORYBUDGET
	protected long getMemoryOverhead(MemoryBudget mb) {
		return mb.getBINOverhead();
	}

	// #endif
	public Set getCursorSet() {
		return cursorSet.copy();
	}

	/**
	 * Register a cursor with this bin. Caller has this bin already latched.
	 * 
	 * @param cursor
	 *            Cursor to register.
	 */
	public void addCursor(CursorImpl cursor) {
		// #if LATCHES
		assert isLatchOwner();
		// #endif
		cursorSet.add(cursor);
	}

	/**
	 * Unregister a cursor with this bin. Caller has this bin already latched.
	 * 
	 * @param cursor
	 *            Cursor to unregister.
	 */
	public void removeCursor(CursorImpl cursor) {
		// #if LATCHES
		assert isLatchOwner();
		// #endif
		cursorSet.remove(cursor);
	}

	/**
	 * @return the number of cursors currently referring to this BIN.
	 */
	public int nCursors() {
		return cursorSet.size();
	}

	/**
	 * The following four methods access the correct fields in a cursor
	 * depending on whether "this" is a BIN or DBIN. For BIN's, the
	 * CursorImpl.index and CursorImpl.bin fields should be used. For DBIN's,
	 * the CursorImpl.dupIndex and CursorImpl.dupBin fields should be used.
	 */
	BIN getCursorBIN(CursorImpl cursor) {
		return cursor.getBIN();
	}

	BIN getCursorBINToBeRemoved(CursorImpl cursor) {
		return cursor.getBINToBeRemoved();
	}

	int getCursorIndex(CursorImpl cursor) {
		return cursor.getIndex();
	}

	void setCursorBIN(CursorImpl cursor, BIN bin) {
		cursor.setBIN(bin);
	}

	void setCursorIndex(CursorImpl cursor, int index) {
		cursor.setIndex(index);
	}

	/**
	 * Called when we know we are about to split on behalf of a key that is the
	 * minimum (leftSide) or maximum (!leftSide) of this node. This is achieved
	 * by just forcing the split to occur either one element in from the left or
	 * the right (i.e. splitIndex is 1 or nEntries - 1).
	 */
	void splitSpecial(IN parent, int parentIndex, int maxEntriesPerNode,
			byte[] key, boolean leftSide) throws DatabaseException {
		int index = findEntry(key, true, false);
		int nEntries = getNEntries();
		boolean exact = (index & IN.EXACT_MATCH) != 0;
		index &= ~IN.EXACT_MATCH;
		if (leftSide && index < 0) {
			splitInternal(parent, parentIndex, maxEntriesPerNode, 1);
		} else if (!leftSide && !exact && index == (nEntries - 1)) {
			splitInternal(parent, parentIndex, maxEntriesPerNode, nEntries - 1);
		} else {
			split(parent, parentIndex, maxEntriesPerNode);
		}
	}

	/**
	 * Adjust any cursors that are referring to this BIN. This method is called
	 * during a split operation. "this" is the BIN being split. newSibling is
	 * the new BIN into which the entries from "this" between newSiblingLow and
	 * newSiblingHigh have been copied.
	 * 
	 * @param newSibling
	 *            - the newSibling into which "this" has been split.
	 * @param newSiblingLow
	 *            , newSiblingHigh - the low and high entry of "this" that were
	 *            moved into newSibling.
	 */
	void adjustCursors(IN newSibling, int newSiblingLow, int newSiblingHigh) {
		// #if LATCHES
		assert newSibling.isLatchOwner();
		// #endif
		// #if LATCHES
		assert this.isLatchOwner();
		// #endif
		int adjustmentDelta = (newSiblingHigh - newSiblingLow);
		Iterator iter = cursorSet.iterator();
		while (iter.hasNext()) {
			CursorImpl cursor = (CursorImpl) iter.next();
			if (getCursorBINToBeRemoved(cursor) == this) {
				continue;
			}
			int cIdx = getCursorIndex(cursor);
			BIN cBin = getCursorBIN(cursor);
			assert cBin == this : "nodeId=" + getNodeId() + " cursor="
					+ cursor.dumpToString(true);
			assert newSibling instanceof BIN;
			BIN ns = (BIN) newSibling;
			if (newSiblingLow == 0) {
				if (cIdx < newSiblingHigh) {
					setCursorBIN(cursor, ns);
					iter.remove();
					ns.addCursor(cursor);
				} else {
					setCursorIndex(cursor, cIdx - adjustmentDelta);
				}
			} else {
				if (cIdx >= newSiblingLow) {
					setCursorIndex(cursor, cIdx - newSiblingLow);
					setCursorBIN(cursor, ns);
					iter.remove();
					ns.addCursor(cursor);
				}
			}
		}
	}

	// #if VERIFIER
	/**
	 * For each cursor in this BIN's cursor set, ensure that the cursor is
	 * actually referring to this BIN.
	 */
	public void verifyCursors() {
		if (cursorSet != null) {
			Iterator iter = cursorSet.iterator();
			while (iter.hasNext()) {
				CursorImpl cursor = (CursorImpl) iter.next();
				if (getCursorBINToBeRemoved(cursor) != this) {
					BIN cBin = getCursorBIN(cursor);
					assert cBin == this;
				}
			}
		}
	}

	// #endif
	/**
	 * Adjust cursors referring to this BIN following an insert.
	 * 
	 * @param insertIndex
	 *            - The index of the new entry.
	 */
	void adjustCursorsForInsert(int insertIndex) {
		// #if LATCHES
		assert this.isLatchOwner();
		// #endif
		if (cursorSet != null) {
			Iterator iter = cursorSet.iterator();
			while (iter.hasNext()) {
				CursorImpl cursor = (CursorImpl) iter.next();
				if (getCursorBINToBeRemoved(cursor) != this) {
					int cIdx = getCursorIndex(cursor);
					if (insertIndex <= cIdx) {
						setCursorIndex(cursor, cIdx + 1);
					}
				}
			}
		}
	}

	/**
	 * Adjust cursors referring to the given binIndex in this BIN following a
	 * mutation of the entry from an LN to a DIN. The entry was moved from a BIN
	 * to a newly created DBIN so each cursor must be added to the new DBIN.
	 * 
	 * @param binIndex
	 *            - The index of the DIN (previously LN) entry in the BIN.
	 * @param dupBin
	 *            - The DBIN into which the LN entry was moved.
	 * @param dupBinIndex
	 *            - The index of the moved LN entry in the DBIN.
	 * @param excludeCursor
	 *            - The cursor being used for insertion and that should not be
	 *            updated.
	 */
	void adjustCursorsForMutation(int binIndex, DBIN dupBin, int dupBinIndex,
			CursorImpl excludeCursor) {
		// #if LATCHES
		assert this.isLatchOwner();
		// #endif
		if (cursorSet != null) {
			Iterator iter = cursorSet.iterator();
			while (iter.hasNext()) {
				CursorImpl cursor = (CursorImpl) iter.next();
				if (getCursorBINToBeRemoved(cursor) != this
						&& cursor != excludeCursor
						&& cursor.getIndex() == binIndex) {
					assert cursor.getDupBIN() == null;
					cursor.addCursor(dupBin);
					cursor.updateDBin(dupBin, dupBinIndex);
				}
			}
		}
	}

	/**
	 * Compress this BIN by removing any entries that are deleted. Deleted
	 * entries are those that have LN's marked deleted or if the knownDeleted
	 * flag is set. Caller is responsible for latching and unlatching this node.
	 * 
	 * @param binRef
	 *            is used to determine the set of keys to be checked for
	 *            deletedness, or is null to check all keys.
	 * @param canFetch
	 *            if false, don't fetch any non-resident children. We don't want
	 *            some callers of compress, such as the evictor, to fault in
	 *            other nodes.
	 * @return true if we had to requeue the entry because we were unable to get
	 *         locks, false if all entries were processed and therefore any
	 *         remaining deleted keys in the BINReference must now be in some
	 *         other BIN because of a split.
	 */
	public boolean compress(BINReference binRef, boolean canFetch)
			throws DatabaseException {
		boolean ret = false;
		boolean setNewIdKey = false;
		boolean anyLocksDenied = false;
		DatabaseImpl db = getDatabase();
		BasicLocker lockingTxn = new BasicLocker(db.getDbEnvironment());
		try {
			for (int i = 0; i < getNEntries(); i++) {
				boolean deleteEntry = false;
				if (binRef == null || isEntryPendingDeleted(i)
						|| isEntryKnownDeleted(i)
						|| binRef.hasDeletedKey(new Key(getKey(i)))) {
					Node n = null;
					if (canFetch) {
						n = fetchTarget(i);
					} else {
						n = getTarget(i);
						if (n == null) {
							continue;
						}
					}
					if (n == null) {
						deleteEntry = true;
					} else if (isEntryKnownDeleted(i)) {
						LockResult lockRet = lockingTxn.nonBlockingLock(
								n.getNodeId(), LockType.READ, db);
						if (lockRet.getLockGrant() == LockGrantType.DENIED) {
							anyLocksDenied = true;
							continue;
						}
						deleteEntry = true;
					} else {
						if (!n.containsDuplicates()) {
							LN ln = (LN) n;
							LockResult lockRet = lockingTxn.nonBlockingLock(
									ln.getNodeId(), LockType.READ, db);
							if (lockRet.getLockGrant() == LockGrantType.DENIED) {
								anyLocksDenied = true;
								continue;
							}
							if (ln.isDeleted()) {
								deleteEntry = true;
							}
						}
					}
					if (binRef != null) {
						binRef.removeDeletedKey(new Key(getKey(i)));
					}
				}
				if (deleteEntry) {
					boolean entryIsIdentifierKey = Key.compareKeys(getKey(i),
							getIdentifierKey(), getKeyComparator()) == 0;
					if (entryIsIdentifierKey) {
						setNewIdKey = true;
					}
					boolean deleteSuccess = deleteEntry(i, true);
					assert deleteSuccess;
					i--;
				}
			}
		} finally {
			if (lockingTxn != null) {
				lockingTxn.operationEnd();
			}
		}
		if (anyLocksDenied && binRef != null) {
			// #if INCOMPRESSOR
			db.getDbEnvironment().addToCompressorQueue(binRef, false);
			// #endif
			ret = true;
		}
		if (getNEntries() != 0 && setNewIdKey) {
			setIdentifierKey(getKey(0));
		}
		if (getNEntries() == 0) {
			setGeneration(0);
		}
		return ret;
	}

	public boolean isCompressible() {
		return true;
	}

	// #if EVICTOR
	/**
	 * Reduce memory consumption by evicting all LN targets. Note that the
	 * targets are not persistent, so this doesn't affect node dirtiness. The
	 * BIN should be latched by the caller.
	 * 
	 * @return number of evicted bytes
	 */
	public long evictLNs() throws DatabaseException {
		// #if LATCHES
		assert isLatchOwner() : "BIN must be latched before evicting LNs";
		// #endif
		// #if CLEANER
		Cleaner cleaner = getDatabase().getDbEnvironment().getCleaner();
		// #endif
		long removed = 0;
		if (nCursors() == 0) {
			for (int i = 0; i < getNEntries(); i++) {
				removed += evictInternal(i,cleaner);
			}
			// #if MEMORYBUDGET
			updateMemorySize(removed, 0);
			// #endif
		}
		return removed;
	}

	// #endif
	// #if EVICTOR
	/**
	 * Evict a single LN if allowed and adjust the memory budget.
	 */
	public void evictLN(int index) throws DatabaseException {
		// #if CLEANER
		Cleaner cleaner = getDatabase().getDbEnvironment().getCleaner();
		// #endif
		long removed = evictInternal(index,cleaner);
		// #if MEMORYBUDGET
		updateMemorySize(removed, 0);
		// #endif
	}

	// #endif
	// #if EVICTOR
	/**
	 * Evict a single LN if allowed. The amount of memory freed is returned and
	 * must be subtracted from the memory budget by the caller.
	 */
	private long evictInternal(int index,
	// #if CLEANER
			Cleaner cleaner
	// #endif
	) throws DatabaseException {
		Node n = getTarget(index);
		if (n instanceof LN &&
		// #if CLEANER
				cleaner.isEvictable(this, index)
		// #endif
		) {
			setTarget(index, null);
			return n.getMemorySizeIncludedByParent();
		} else {
			return 0;
		}
	}

	// #endif
	boolean validateSubtreeBeforeDelete(int index) throws DatabaseException {
		return true;
	}

	/**
	 * Check if this node fits the qualifications for being part of a deletable
	 * subtree. It can only have one IN child and no LN children.
	 */
	// #if LATCHES
	boolean isValidForDelete() throws DatabaseException {
		int validIndex = 0;
		int numValidEntries = 0;
		boolean needToLatch = !isLatchOwner();
		try {
			if (needToLatch) {
				latch();
			}
			for (int i = 0; i < getNEntries(); i++) {
				if (!isEntryKnownDeleted(i)) {
					numValidEntries++;
					validIndex = i;
				}
			}
			if (numValidEntries > 1) {
				return false;
			} else {
				if (nCursors() > 0) {
					return false;
				}
				if (numValidEntries == 1) {
					Node child = fetchTarget(validIndex);
					return child != null && child.isValidForDelete();
				} else {
					return true;
				}
			}
		} finally {
			if (needToLatch && isLatchOwner()) {
				releaseLatch();
			}
		}
	}

	// #endif

	void accumulateStats(TreeWalkerStatsAccumulator acc) {
		acc.processBIN(this, new Long(getNodeId()), getLevel());
	}

	/**
	 * Return the relevant user defined comparison function for this type of
	 * node. For IN's and BIN's, this is the BTree Comparison function.
	 * Overriden by DBIN.
	 */
	public Comparator getKeyComparator() {
		return getDatabase().getBtreeComparator();
	}

	public String beginTag() {
		return BEGIN_TAG;
	}

	public String endTag() {
		return END_TAG;
	}

	/**
	 * @see LoggableObject#getLogType
	 */
	public LogEntryType getLogType() {
		return LogEntryType.LOG_BIN;
	}

	public String shortClassName() {
		return "BIN";
	}

	/**
	 * Decide how to log this node. BINs may be logged provisionally. If logging
	 * a delta, return an null for the LSN.
	 */
	protected long logInternal(LogManager logManager, boolean allowDeltas,
			boolean isProvisional, boolean proactiveMigration, IN parent)
			throws DatabaseException {
		boolean doDeltaLog = false;
		long lastFullVersion = getLastFullVersion();
		// #if CLEANER
		Cleaner cleaner = getDatabase().getDbEnvironment().getCleaner();
		// #endif
		// #if CLEANER
		cleaner.lazyMigrateLNs(this, proactiveMigration);
		// #endif
		BINDelta deltaInfo = null;
		if ((allowDeltas) && (lastFullVersion != DbLsn.NULL_LSN)
				&& !prohibitNextDelta) {
			deltaInfo = new BINDelta(this);
			doDeltaLog = doDeltaLog(deltaInfo);
		}
		long returnLsn = DbLsn.NULL_LSN;
		if (doDeltaLog) {
			lastDeltaVersion = logManager.log(deltaInfo);
			returnLsn = DbLsn.NULL_LSN;
			numDeltasSinceLastFull++;
		} else {
			returnLsn = super.logInternal(logManager, allowDeltas,
					isProvisional, proactiveMigration, parent);
			lastDeltaVersion = DbLsn.NULL_LSN;
			numDeltasSinceLastFull = 0;
		}
		prohibitNextDelta = false;
		return returnLsn;
	}

	/**
	 * Decide whether to log a full or partial BIN, depending on the ratio of
	 * the delta size to full BIN size, and the number of deltas that have been
	 * logged since the last full.
	 * 
	 * @return true if we should log the deltas of this BIN
	 */
	private boolean doDeltaLog(BINDelta deltaInfo) throws DatabaseException {
		int maxDiffs = (getNEntries() * getDatabase().getBinDeltaPercent()) / 100;
		if ((deltaInfo.getNumDeltas() <= maxDiffs)
				&& (numDeltasSinceLastFull < getDatabase().getBinMaxDeltas())) {
			return true;
		} else {
			return false;
		}
	}
}
