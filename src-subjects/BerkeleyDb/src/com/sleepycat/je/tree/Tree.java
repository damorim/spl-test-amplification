package com.sleepycat.je.tree;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sleepycat.je.DatabaseException;
//#if CLEANER
import com.sleepycat.je.cleaner.UtilizationTracker;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbConfigManager;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.SharedLatch;
//#endif
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.LogReadable;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.LogWritable;
import com.sleepycat.je.recovery.RecoveryManager;
import com.sleepycat.je.txn.BasicLocker;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.WriteLockInfo;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;
import com.sleepycat.je.utilint.Tracer;

/**
 * Tree implements the JE B+Tree. A note on tree search patterns: There's a set
 * of Tree.search* methods. Some clients of the tree use those search methods
 * directly, whereas other clients of the tree tend to use methods built on top
 * of search. The semantics of search* are they leave you pointing at a BIN or
 * IN they don't tell you where the reference of interest is. they traverse a
 * single tree, to jump into the duplicate tree, the caller has to take explicit
 * action. The semantics of the get* methods are: they leave you pointing at a
 * BIN or IN they return the index of the slot of interest they traverse down to
 * whatever level is needed -- they'll take care of jumping into the duplicate
 * tree. they are built on top of search* methods. For the future: Over time, we
 * need to clarify which methods are to be used by clients of the tree.
 * Preferably clients that call the tree use get*, although their are cases
 * where they need visibility into the tree structure. For example, tee cursors
 * use search* because they want to add themselves to BIN before jumping into
 * the duplicate tree. Also, search* should return the location of the slot to
 * save us a second binary search.
 */
public final class Tree implements LogWritable, LogReadable {
	private static final String TRACE_ROOT_SPLIT = "RootSplit:";
	private static final String TRACE_DUP_ROOT_SPLIT = "DupRootSplit:";
	private static final String TRACE_MUTATE = "Mut:";
	private static final String TRACE_INSERT = "Ins:";
	private static final String TRACE_INSERT_DUPLICATE = "InsD:";
	private DatabaseImpl database;
	private ChildReference root;
	private int maxMainTreeEntriesPerNode;
	private int maxDupTreeEntriesPerNode;
	private boolean purgeRoot;
	// #if LATCHES
	private SharedLatch rootLatch;
	// #endif
	private TreeStats treeStats;
	private ThreadLocal treeStatsAccumulatorTL = new ThreadLocal();
	private static SplitRequiredException splitRequiredException = new SplitRequiredException();

	/**
	 * Embodies an enum for the type of search being performed. NORMAL means do
	 * a regular search down the tree. LEFT/RIGHT means search down the
	 * left/right side to find the first/last node in the tree.
	 */
	public static class SearchType {
		public static final SearchType NORMAL = new SearchType();
		public static final SearchType LEFT = new SearchType();
		public static final SearchType RIGHT = new SearchType();

		private SearchType() {
		}
	}

	private TestHook waitHook;
	private TestHook searchHook;
	private TestHook ckptHook;

	/**
	 * Create a new tree.
	 */
	public Tree(DatabaseImpl database) throws DatabaseException {
		init(database);
		setDatabase(database);
	}

	/**
	 * Create a tree that's being read in from the log.
	 */
	public Tree() throws DatabaseException {
		init(null);
		maxMainTreeEntriesPerNode = 0;
		maxDupTreeEntriesPerNode = 0;
	}

	/**
	 * constructor helper
	 */
	private void init(DatabaseImpl database) {
		// #if LATCHES
		rootLatch = LatchSupport.makeSharedLatch("RootLatch",
				(database != null) ? database.getDbEnvironment() : null);
		// #endif
		treeStats = new TreeStats();
		this.root = null;
		this.database = database;
	}

	/**
	 * Set the database for this tree. Used by recovery when recreating an
	 * existing tree.
	 */
	public void setDatabase(DatabaseImpl database) throws DatabaseException {
		this.database = database;
		maxMainTreeEntriesPerNode = database.getNodeMaxEntries();
		maxDupTreeEntriesPerNode = database.getNodeMaxDupTreeEntries();
		DbConfigManager configManager = database.getDbEnvironment()
				.getConfigManager();
		purgeRoot = configManager
				.getBoolean(EnvironmentParams.COMPRESSOR_PURGE_ROOT);
	}

	/**
	 * @return the database for this Tree.
	 */
	public DatabaseImpl getDatabase() {
		return database;
	}

	/**
	 * Set the root for the tree. Should only be called within the root latch.
	 */
	public void setRoot(ChildReference newRoot, boolean notLatched) {
		// #if LATCHES
		assert (notLatched || rootLatch.isWriteLockedByCurrentThread());
		// #endif
		root = newRoot;
	}

	public ChildReference makeRootChildReference(Node target, byte[] key,
			long lsn) {
		return new RootChildReference(target, key, lsn);
	}

	private ChildReference makeRootChildReference() {
		return new RootChildReference();
	}

	private class RootChildReference extends ChildReference {
		private RootChildReference() {
			super();
		}

		private RootChildReference(Node target, byte[] key, long lsn) {
			super(target, key, lsn);
		}

		private RootChildReference(Node target, byte[] key, long lsn,
				byte existingState) {
			super(target, key, lsn, existingState);
		}

		public Node fetchTarget(DatabaseImpl database, IN in)
				throws DatabaseException {
			// #if LATCHES
			if (getTarget() == null
					&& !rootLatch.isWriteLockedByCurrentThread())
			// #if LATCHES
			{
				rootLatch.release();
				rootLatch.acquireExclusive();
			}
			// #endif
			// #endif
			return super.fetchTarget(database, in);
		}

		public void setTarget(Node target) {
			// #if LATCHES
			assert rootLatch.isWriteLockedByCurrentThread();
			// #endif
			super.setTarget(target);
		}

		public void clearTarget() {
			// #if LATCHES
			assert rootLatch.isWriteLockedByCurrentThread();
			// #endif
			super.clearTarget();
		}

		public void setLsn(long lsn) {
			// #if LATCHES
			assert rootLatch.isWriteLockedByCurrentThread();
			// #endif
			super.setLsn(lsn);
		}
	}

	/**
	 * Get LSN of the rootIN. Obtained without latching, should only be accessed
	 * while quiescent.
	 */
	public long getRootLsn() {
		if (root == null) {
			return DbLsn.NULL_LSN;
		} else {
			return root.getLsn();
		}
	}

	/**
	 * @return the TreeStats for this tree.
	 */
	TreeStats getTreeStats() {
		return treeStats;
	}

	private TreeWalkerStatsAccumulator getTreeStatsAccumulator() {
		if (EnvironmentImpl.getThreadLocalReferenceCount() > 0) {
			return (TreeWalkerStatsAccumulator) treeStatsAccumulatorTL.get();
		} else {
			return null;
		}
	}

	public void setTreeStatsAccumulator(TreeWalkerStatsAccumulator tSA) {
		treeStatsAccumulatorTL.set(tSA);
	}

	public IN withRootLatchedExclusive(WithRootLatched wrl)
			throws DatabaseException {
		// #if LATCHES
		try {
			rootLatch.acquireExclusive();
			return wrl.doWork(root);
		} finally {
			rootLatch.release();
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	public IN withRootLatchedShared(WithRootLatched wrl)
			throws DatabaseException {
		// #if LATCHES
		try {
			rootLatch.acquireShared();
			return wrl.doWork(root);
		} finally {
			rootLatch.release();
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * Deletes a BIN specified by key from the tree. If the BIN resides in a
	 * subtree that can be pruned away, prune as much as possible, so we don't
	 * leave a branch that has no BINs. It's possible that the targeted BIN will
	 * now have entries, or will have resident cursors. Either will prevent
	 * deletion.
	 * 
	 * @param idKey
	 *            - the identifier key of the node to delete.
	 * @param tracker
	 *            is used for tracking obsolete node info.
	 */
	public void delete(byte[] idKey, UtilizationTracker tracker
	) throws DatabaseException, NodeNotEmptyException, CursorsExistException {
		IN subtreeRootIN = null;
		ArrayList nodeLadder = new ArrayList();
		IN rootIN = null;
		boolean rootNeedsUpdating = false;
		// #if LATCHES
		rootLatch.acquireExclusive();
		// #endif
		// #if LATCHES
		try {
			if (root == null) {
				return;
			}
			rootIN = (IN) root.fetchTarget(database, null);
			rootIN.latch(false);
			searchDeletableSubTree(rootIN, idKey, nodeLadder);
			if (nodeLadder.size() == 0) {
				if (purgeRoot) {
					subtreeRootIN = logTreeRemoval(rootIN,
					// #if CLEANER
							tracker
					// #endif
					);
					if (subtreeRootIN != null) {
						rootNeedsUpdating = true;
					}
				}
			} else {
				SplitInfo detachPoint = (SplitInfo) nodeLadder.get(nodeLadder
						.size() - 1);
				boolean deleteOk = detachPoint.parent.deleteEntry(
						detachPoint.index, true);
				assert deleteOk;
				rootNeedsUpdating = cascadeUpdates(nodeLadder, null, -1);
				subtreeRootIN = detachPoint.child;
			}
		} finally {
			releaseNodeLadderLatches(nodeLadder);
			if (rootIN != null) {
				rootIN.releaseLatch();
			}
			rootLatch.release();
		}
		// #endif
		if (subtreeRootIN != null) {
			EnvironmentImpl envImpl = database.getDbEnvironment();
			if (rootNeedsUpdating) {
				DbTree dbTree = envImpl.getDbMapTree();
				dbTree.modifyDbRoot(database);
				// #if LOGGINGFINE
				RecoveryManager.traceRootDeletion(Level.FINE, database);
				// #endif
			}
			INList inList = envImpl.getInMemoryINs();
			accountForSubtreeRemoval(inList, subtreeRootIN, tracker);
		}
	}

	// #if LATCHES
	private void releaseNodeLadderLatches(ArrayList nodeLadder)
			throws DatabaseException {
		ListIterator iter = nodeLadder.listIterator(nodeLadder.size());
		while (iter.hasPrevious()) {
			SplitInfo info = (SplitInfo) iter.previous();
			info.child.releaseLatch();
		}
	}

	// #endif
	/**
	 * This entire tree is empty, clear the root and log a new MapLN
	 * 
	 * @return the rootIN that has been detached, or null if there hasn't been
	 *         any removal.
	 */
	private IN logTreeRemoval(IN rootIN, UtilizationTracker tracker) throws DatabaseException {
		// #if LATCHES
		assert rootLatch.isWriteLockedByCurrentThread();
		// #endif
		IN detachedRootIN = null;
		if ((rootIN.getNEntries() <= 1)
				&& (rootIN.validateSubtreeBeforeDelete(0))) {
			root = null;
			EnvironmentImpl envImpl = database.getDbEnvironment();
			LogManager logManager = envImpl.getLogManager();
			logManager.log(new INDeleteInfo(rootIN.getNodeId(), rootIN
					.getIdentifierKey(), database.getId()));
			detachedRootIN = rootIN;
		}
		return detachedRootIN;
	}

	/**
	 * Update nodes for a delete, going upwards. For example, suppose a node
	 * ladder holds: INa, INb, index for INb in INa INb, INc, index for INc in
	 * INb INc, BINd, index for BINd in INc When we enter this method, BINd has
	 * already been removed from INc. We need to - log INc - update INb, log INb
	 * - update INa, log INa
	 * 
	 * @param nodeLadder
	 *            List of SplitInfos describing each node pair on the downward
	 *            path
	 * @param binRoot
	 *            parent of the dup tree, or null if this is not for dups.
	 * @param index
	 *            slot occupied by this din tree.
	 * @return whether the DB root needs updating.
	 */
	private boolean cascadeUpdates(ArrayList nodeLadder, BIN binRoot, int index)
			throws DatabaseException {
		ListIterator iter = nodeLadder.listIterator(nodeLadder.size());
		EnvironmentImpl envImpl = database.getDbEnvironment();
		LogManager logManager = envImpl.getLogManager();
		long newLsn = DbLsn.NULL_LSN;
		SplitInfo info = null;
		while (iter.hasPrevious()) {
			info = (SplitInfo) iter.previous();
			if (newLsn != DbLsn.NULL_LSN) {
				info.parent.updateEntry(info.index, newLsn);
			}
			newLsn = info.parent.log(logManager);
		}
		boolean rootNeedsUpdating = false;
		if (info != null) {
			if (info.parent.isDbRoot()) {
				// #if LATCHES
				assert rootLatch.isWriteLockedByCurrentThread();
				// #endif
				root.setLsn(newLsn);
				rootNeedsUpdating = true;
			} else if ((binRoot != null) && info.parent.isRoot()) {
				binRoot.updateEntry(index, newLsn);
			} else {
				assert false;
			}
		}
		return rootNeedsUpdating;
	}

	/**
	 * Delete a subtree of a duplicate tree. Find the duplicate tree using
	 * mainKey in the top part of the tree and idKey in the duplicate tree.
	 * 
	 * @param idKey
	 *            the identifier key to be used in the duplicate subtree to find
	 *            the duplicate path.
	 * @param mainKey
	 *            the key to be used in the main tree to find the duplicate
	 *            subtree.
	 * @param tracker
	 *            is used for tracking obsolete node info.
	 * @return true if the delete succeeded, false if there were still cursors
	 *         present on the leaf DBIN of the subtree that was located.
	 */
	public void deleteDup(byte[] idKey, byte[] mainKey, UtilizationTracker tracker
	) throws DatabaseException, NodeNotEmptyException, CursorsExistException {
		IN in = search(mainKey, SearchType.NORMAL, -1, null, false);
		IN deletedSubtreeRoot = null;
		// #if LATCHES
		try {
			// #if LATCHES
			assert in.isLatchOwner();
			// #endif
			assert in instanceof BIN;
			assert in.getNEntries() > 0;
			int index = in.findEntry(mainKey, false, true);
			if (index >= 0) {
				deletedSubtreeRoot = deleteDupSubtree(idKey, (BIN) in, index);
			}
		} finally {
			in.releaseLatch();
		}
		// #endif
		if (deletedSubtreeRoot != null) {
			EnvironmentImpl envImpl = database.getDbEnvironment();
			accountForSubtreeRemoval(envImpl.getInMemoryINs(),
					deletedSubtreeRoot, tracker);
		}
	}

	/**
	 * We enter and leave this method with 'bin' latched.
	 * 
	 * @return the root of the subtree we have deleted, so it can be properly
	 *         accounted for. May be null if nothing was deleted.
	 */
	private IN deleteDupSubtree(byte[] idKey, BIN bin, int index)
			throws DatabaseException, NodeNotEmptyException,
			CursorsExistException {
		EnvironmentImpl envImpl = database.getDbEnvironment();
		boolean dupCountLNLocked = false;
		DupCountLN dcl = null;
		BasicLocker locker = new BasicLocker(envImpl);
		DIN duplicateRoot = (DIN) bin.fetchTarget(index);
		duplicateRoot.latch(false);
		ArrayList nodeLadder = new ArrayList();
		IN subtreeRootIN = null;
		try {
			ChildReference dclRef = duplicateRoot.getDupCountLNRef();
			dcl = (DupCountLN) dclRef.fetchTarget(database, duplicateRoot);
			LockResult lockResult = locker.nonBlockingLock(dcl.getNodeId(),
					LockType.READ, database);
			if (lockResult.getLockGrant() == LockGrantType.DENIED) {
				throw CursorsExistException.CURSORS_EXIST;
			} else {
				dupCountLNLocked = true;
			}
			searchDeletableSubTree(duplicateRoot, idKey, nodeLadder);
			LogManager logManager = envImpl.getLogManager();
			if (nodeLadder.size() == 0) {
				if (bin.nCursors() == 0) {
					boolean deleteOk = bin.deleteEntry(index, true);
					assert deleteOk;
					logManager.log(new INDupDeleteInfo(duplicateRoot
							.getNodeId(), duplicateRoot.getMainTreeKey(),
							duplicateRoot.getDupTreeKey(), database.getId()));
					subtreeRootIN = duplicateRoot;
					// #if INCOMPRESSOR
					if (bin.getNEntries() == 0)
					// #if INCOMPRESSOR
					{
						database.getDbEnvironment().addToCompressorQueue(bin,
								null, false);
					}
					// #endif
					// #endif
				} else {
					throw CursorsExistException.CURSORS_EXIST;
				}
			} else {
				SplitInfo detachPoint = (SplitInfo) nodeLadder.get(nodeLadder
						.size() - 1);
				boolean deleteOk = detachPoint.parent.deleteEntry(
						detachPoint.index, true);
				assert deleteOk;
				cascadeUpdates(nodeLadder, bin, index);
				subtreeRootIN = detachPoint.child;
			}
		} finally {
			// #if LATCHES
			releaseNodeLadderLatches(nodeLadder);
			// #endif
			if (dupCountLNLocked) {
				locker.releaseLock(dcl.getNodeId());
			}
			// #if LATCHES
			if (duplicateRoot != null)
			// #if LATCHES
			{
				duplicateRoot.releaseLatch();
			}
			// #endif
			// #endif
		}
		return subtreeRootIN;
	}

	/**
	 * Find the leftmost node (IN or BIN) in the tree. Do not descend into a
	 * duplicate tree if the leftmost entry of the first BIN refers to one.
	 * 
	 * @return the leftmost node in the tree, null if the tree is empty. The
	 *         returned node is latched and the caller must release it.
	 */
	public IN getFirstNode() throws DatabaseException {
		return search(null, SearchType.LEFT, -1, null, true);
	}

	/**
	 * Find the rightmost node (IN or BIN) in the tree. Do not descend into a
	 * duplicate tree if the rightmost entry of the last BIN refers to one.
	 * 
	 * @return the rightmost node in the tree, null if the tree is empty. The
	 *         returned node is latched and the caller must release it.
	 */
	public IN getLastNode() throws DatabaseException {
		return search(null, SearchType.RIGHT, -1, null, true);
	}

	/**
	 * Find the leftmost node (DBIN) in a duplicate tree.
	 * 
	 * @return the leftmost node in the tree, null if the tree is empty. The
	 *         returned node is latched and the caller must release it.
	 */
	public DBIN getFirstNode(DIN dupRoot) throws DatabaseException {
		if (dupRoot == null) {
			throw new IllegalArgumentException("getFirstNode passed null root");
		}
		// #if LATCHES
		assert dupRoot.isLatchOwner();
		// #endif
		IN ret = searchSubTree(dupRoot, null, SearchType.LEFT, -1, null, true);
		return (DBIN) ret;
	}

	/**
	 * Find the rightmost node (DBIN) in a duplicate tree.
	 * 
	 * @return the rightmost node in the tree, null if the tree is empty. The
	 *         returned node is latched and the caller must release it.
	 */
	public DBIN getLastNode(DIN dupRoot) throws DatabaseException {
		if (dupRoot == null) {
			throw new IllegalArgumentException("getLastNode passed null root");
		}
		// #if LATCHES
		assert dupRoot.isLatchOwner();
		// #endif
		IN ret = searchSubTree(dupRoot, null, SearchType.RIGHT, -1, null, true);
		return (DBIN) ret;
	}

	/**
	 * GetParentNode without optional tracking.
	 */
	public SearchResult getParentINForChildIN(IN child,
			boolean requireExactMatch, boolean updateGeneration)
			throws DatabaseException {
		return getParentINForChildIN(child, requireExactMatch,
				updateGeneration, -1, null);
	}

	/**
	 * Return a reference to the parent or possible parent of the child. Used by
	 * objects that need to take a standalone node and find it in the tree, like
	 * the evictor, checkpointer, and recovery.
	 * 
	 * @param child
	 *            The child node for which to find the parent. This node is
	 *            latched by the caller and is released by this function before
	 *            returning to the caller.
	 * @param requireExactMatch
	 *            if true, we must find the exact parent, not a potential
	 *            parent.
	 * @param updateGeneration
	 *            if true, set the generation count during latching. Pass false
	 *            when the LRU should not be impacted, such as during eviction
	 *            and checkpointing.
	 * @param trackingList
	 *            if not null, add the LSNs of the parents visited along the
	 *            way, as a debug tracing mechanism. This is meant to stay in
	 *            production, to add information to the log.
	 * @return a SearchResult object. If the parent has been found,
	 *         result.foundExactMatch is true. If any parent, exact or potential
	 *         has been found, result.parent refers to that node.
	 */
	public SearchResult getParentINForChildIN(IN child,
			boolean requireExactMatch, boolean updateGeneration,
			int targetLevel, List trackingList) throws DatabaseException {
		if (child == null) {
			throw new IllegalArgumentException("getParentNode passed null");
		}
		// #if LATCHES
		assert child.isLatchOwner();
		// #endif
		byte[] mainTreeKey = child.getMainTreeKey();
		byte[] dupTreeKey = child.getDupTreeKey();
		boolean isRoot = child.isRoot();
		// #if LATCHES
		child.releaseLatch();
		// #endif
		return getParentINForChildIN(child.getNodeId(),
				child.containsDuplicates(), isRoot, mainTreeKey, dupTreeKey,
				requireExactMatch, updateGeneration, targetLevel, trackingList,
				true);
	}

	/**
	 * Return a reference to the parent or possible parent of the child. Used by
	 * objects that need to take a node id and find it in the tree, like the
	 * evictor, checkpointer, and recovery.
	 * 
	 * @param requireExactMatch
	 *            if true, we must find the exact parent, not a potential
	 *            parent.
	 * @param updateGeneration
	 *            if true, set the generation count during latching. Pass false
	 *            when the LRU should not be impacted, such as during eviction
	 *            and checkpointing.
	 * @param trackingList
	 *            if not null, add the LSNs of the parents visited along the
	 *            way, as a debug tracing mechanism. This is meant to stay in
	 *            production, to add information to the log.
	 * @param doFetch
	 *            if false, stop the search if we run into a non-resident child.
	 *            Used by the checkpointer to avoid conflicting with work done
	 *            by the evictor.
	 * @param child
	 *            The child node for which to find the parent. This node is
	 *            latched by the caller and is released by this function before
	 *            returning to the caller.
	 * @return a SearchResult object. If the parent has been found,
	 *         result.foundExactMatch is true. If any parent, exact or potential
	 *         has been found, result.parent refers to that node.
	 */
	public SearchResult getParentINForChildIN(long targetNodeId,
			boolean targetContainsDuplicates, boolean targetIsRoot,
			byte[] targetMainTreeKey, byte[] targetDupTreeKey,
			boolean requireExactMatch, boolean updateGeneration,
			int targetLevel, List trackingList, boolean doFetch)
			throws DatabaseException {
		IN rootIN = getRootIN(updateGeneration);
		SearchResult result = new SearchResult();
		if (rootIN != null) {
			if (trackingList != null) {
				trackingList.add(new TrackingInfo(root.getLsn(), rootIN
						.getNodeId()));
			}
			IN potentialParent = rootIN;
			try {
				while (result.keepSearching) {
					assert TestHookExecute.doHookIfSet(searchHook);
					potentialParent.findParent(SearchType.NORMAL, targetNodeId,
							targetContainsDuplicates, targetIsRoot,
							targetMainTreeKey, targetDupTreeKey, result,
							requireExactMatch, updateGeneration, targetLevel,
							trackingList, doFetch);
					potentialParent = result.parent;
				}
			} catch (Exception e) {
				// #if LATCHES
				potentialParent.releaseLatchIfOwner();
				// #endif
				throw new DatabaseException(e);
			}
		}
		return result;
	}

	/**
	 * Return a reference to the parent of this LN. This searches through the
	 * main and duplicate tree and allows splits. Set the tree location to the
	 * proper BIN parent whether or not the LN child is found. That's because if
	 * the LN is not found, recovery or abort will need to place it within the
	 * tree, and so we must point at the appropriate position.
	 * <p>
	 * When this method returns with location.bin non-null, the BIN is latched
	 * and must be unlatched by the caller. Note that location.bin may be
	 * non-null even if this method returns false.
	 * </p>
	 * 
	 * @param location
	 *            a holder class to hold state about the location of our search.
	 *            Sort of an internal cursor.
	 * @param mainKey
	 *            key to navigate through main key
	 * @param dupKey
	 *            key to navigate through duplicate tree. May be null, since
	 *            deleted lns have no data.
	 * @param ln
	 *            the node instantiated from the log
	 * @param splitsAllowed
	 *            true if this method is allowed to cause tree splits as a side
	 *            effect. In practice, recovery can cause splits, but abort
	 *            can't.
	 * @param searchDupTree
	 *            true if a search through the dup tree looking for a match on
	 *            the ln's node id should be made (only in the case where dupKey
	 *            == null). See SR 8984.
	 * @param updateGeneration
	 *            if true, set the generation count during latching. Pass false
	 *            when the LRU should not be impacted, such as during eviction
	 *            and checkpointing.
	 * @return true if node found in tree. If false is returned and there is the
	 *         possibility that we can insert the record into a plausible parent
	 *         we must also set - location.bin (may be null if no possible
	 *         parent found) - location.lnKey (don't need to set if no possible
	 *         parent).
	 */
	public boolean getParentBINForChildLN(TreeLocation location,
			byte[] mainKey, byte[] dupKey, LN ln, boolean splitsAllowed,
			boolean findDeletedEntries, boolean searchDupTree,
			boolean updateGeneration) throws DatabaseException {
		IN searchResult = null;
		try {
			if (splitsAllowed) {
				searchResult = searchSplitsAllowed(mainKey, -1,
						updateGeneration);
			} else {
				searchResult = search(mainKey, SearchType.NORMAL, -1, null,
						updateGeneration);
			}
			location.bin = (BIN) searchResult;
		} catch (Exception e) {
			StringBuffer msg = new StringBuffer();
			if (searchResult != null) {
				// #if LATCHES
				searchResult.releaseLatchIfOwner();
				// #endif
				msg.append("searchResult=" + searchResult.getClass()
						+ " nodeId=" + searchResult.getNodeId() + " nEntries="
						+ searchResult.getNEntries());
			}
			throw new DatabaseException(msg.toString(), e);
		}
		if (location.bin == null) {
			return false;
		}
		boolean exactSearch = false;
		boolean indicateIfExact = true;
		if (!findDeletedEntries) {
			exactSearch = true;
			indicateIfExact = false;
		}
		location.index = location.bin.findEntry(mainKey, indicateIfExact,
				exactSearch);
		boolean match = false;
		if (findDeletedEntries) {
			match = (location.index >= 0 && (location.index & IN.EXACT_MATCH) != 0);
			location.index &= ~IN.EXACT_MATCH;
		} else {
			match = (location.index >= 0);
		}
		if (match) {
			if (!location.bin.isEntryKnownDeleted(location.index)) {
				if (database.getSortedDuplicates()) {
					Node childNode = location.bin.fetchTarget(location.index);
					// #if LATCHES
					try {
						if (childNode == null) {
						} else if (ln.containsDuplicates()) {
							return searchDupTreeForDupCountLNParent(location,
									mainKey, childNode);
						} else {
							if (childNode.containsDuplicates()) {
								if (dupKey == null) {
									return searchDupTreeByNodeId(location,
											childNode, ln, searchDupTree,
											updateGeneration);
								} else {
									return searchDupTreeForDBIN(location,
											dupKey, (DIN) childNode, ln,
											findDeletedEntries,
											indicateIfExact, exactSearch,
											splitsAllowed, updateGeneration);
								}
							}
						}
					} catch (DatabaseException e) {
						location.bin.releaseLatchIfOwner();
						throw e;
					}
					// #endif
				}
			}
			location.childLsn = location.bin.getLsn(location.index);
			return true;
		} else {
			location.lnKey = mainKey;
			return false;
		}
	}

	/**
	 * For SR [#8984]: our prospective child is a deleted LN, and we're facing a
	 * dup tree. Alas, the deleted LN has no data, and therefore nothing to
	 * guide the search in the dup tree. Instead, we search by node id. This is
	 * very expensive, but this situation is a very rare case.
	 */
	private boolean searchDupTreeByNodeId(TreeLocation location,
			Node childNode, LN ln, boolean searchDupTree,
			boolean updateGeneration) throws DatabaseException {
		if (searchDupTree) {
			BIN oldBIN = location.bin;
			if (childNode.matchLNByNodeId(location, ln.getNodeId())) {
				location.index &= ~IN.EXACT_MATCH;
				// #if LATCHES
				if (oldBIN != null)
				// #if LATCHES
				{
					oldBIN.releaseLatch();
				}
				// #endif
				// #endif
				location.bin.latch(updateGeneration);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * @return true if childNode is the DIN parent of this DupCountLN
	 */
	private boolean searchDupTreeForDupCountLNParent(TreeLocation location,
			byte[] mainKey, Node childNode) throws DatabaseException {
		location.lnKey = mainKey;
		if (childNode instanceof DIN) {
			DIN dupRoot = (DIN) childNode;
			location.childLsn = dupRoot.getDupCountLNRef().getLsn();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Search the dup tree for the DBIN parent of this ln.
	 */
	private boolean searchDupTreeForDBIN(TreeLocation location, byte[] dupKey,
			DIN dupRoot, LN ln, boolean findDeletedEntries,
			boolean indicateIfExact, boolean exactSearch,
			boolean splitsAllowed, boolean updateGeneration)
			throws DatabaseException {
		assert dupKey != null;
		// #if LATCHES
		dupRoot.latch();
		try {
			if (maybeSplitDuplicateRoot(location.bin, location.index)) {
				dupRoot = (DIN) location.bin.fetchTarget(location.index);
			}
			location.bin.releaseLatch();
			location.lnKey = dupKey;
			if (splitsAllowed) {
				try {
					location.bin = (BIN) searchSubTreeSplitsAllowed(dupRoot,
							location.lnKey, ln.getNodeId(), updateGeneration);
				} catch (SplitRequiredException e) {
					throw new DatabaseException(e);
				}
			} else {
				location.bin = (BIN) searchSubTree(dupRoot, location.lnKey,
						SearchType.NORMAL, ln.getNodeId(), null,
						updateGeneration);
			}
			location.index = location.bin.findEntry(location.lnKey,
					indicateIfExact, exactSearch);
			boolean match;
			if (findDeletedEntries) {
				match = (location.index >= 0 && (location.index & IN.EXACT_MATCH) != 0);
				location.index &= ~IN.EXACT_MATCH;
			} else {
				match = (location.index >= 0);
			}
			if (match) {
				location.childLsn = location.bin.getLsn(location.index);
				return true;
			} else {
				return false;
			}
		} catch (DatabaseException e) {
			dupRoot.releaseLatchIfOwner();
			throw e;
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * Return a reference to the adjacent BIN.
	 * 
	 * @param bin
	 *            The BIN to find the next BIN for. This BIN is latched.
	 * @param traverseWithinDupTree
	 *            if true, only search within the dup tree and return null when
	 *            the traversal runs out of duplicates.
	 * @return The next BIN, or null if there are no more. The returned node is
	 *         latched and the caller must release it. If null is returned, the
	 *         argument BIN remains latched.
	 */
	public BIN getNextBin(BIN bin, boolean traverseWithinDupTree)
			throws DatabaseException {
		return getNextBinInternal(traverseWithinDupTree, bin, true);
	}

	/**
	 * Return a reference to the previous BIN.
	 * 
	 * @param bin
	 *            The BIN to find the next BIN for. This BIN is latched.
	 * @param traverseWithinDupTree
	 *            if true, only search within the dup tree and return null when
	 *            the traversal runs out of duplicates.
	 * @return The previous BIN, or null if there are no more. The returned node
	 *         is latched and the caller must release it. If null is returned,
	 *         the argument bin remains latched.
	 */
	public BIN getPrevBin(BIN bin, boolean traverseWithinDupTree)
			throws DatabaseException {
		return getNextBinInternal(traverseWithinDupTree, bin, false);
	}

	/**
	 * Helper routine for above two routines to iterate through BIN's.
	 */
	private BIN getNextBinInternal(boolean traverseWithinDupTree, BIN bin,
			boolean forward) throws DatabaseException {
		byte[] idKey = null;
		if (bin.getNEntries() == 0) {
			idKey = bin.getIdentifierKey();
		} else if (forward) {
			idKey = bin.getKey(bin.getNEntries() - 1);
		} else {
			idKey = bin.getKey(0);
		}
		IN next = bin;
		// #if LATCHES
		assert LatchSupport.countLatchesHeld() == 1 : LatchSupport
				.latchesHeldToString();
		// #endif
		IN parent = null;
		IN nextIN = null;
		// #if LATCHES
		try {
			while (true) {
				SearchResult result = null;
				if (!traverseWithinDupTree) {
					result = getParentINForChildIN(next, true, true);
					if (result.exactParentFound) {
						parent = result.parent;
					} else {
						assert (LatchSupport.countLatchesHeld() == 0) : LatchSupport
								.latchesHeldToString();
						return null;
					}
				} else {
					if (next.isRoot()) {
						next.releaseLatch();
						return null;
					} else {
						result = getParentINForChildIN(next, true, true);
						if (result.exactParentFound) {
							parent = result.parent;
						} else {
							return null;
						}
					}
				}
				assert (LatchSupport.countLatchesHeld() == 1) : LatchSupport
						.latchesHeldToString();
				int index = parent.findEntry(idKey, false, false);
				boolean moreEntriesThisBin = false;
				if (forward) {
					index++;
					if (index < parent.getNEntries()) {
						moreEntriesThisBin = true;
					}
				} else {
					if (index > 0) {
						moreEntriesThisBin = true;
					}
					index--;
				}
				if (moreEntriesThisBin) {
					nextIN = (IN) parent.fetchTarget(index);
					nextIN.latch();
					assert (LatchSupport.countLatchesHeld() == 2) : LatchSupport
							.latchesHeldToString();
					if (nextIN instanceof BIN) {
						parent.releaseLatch();
						TreeWalkerStatsAccumulator treeStatsAccumulator = getTreeStatsAccumulator();
						if (treeStatsAccumulator != null) {
							nextIN.accumulateStats(treeStatsAccumulator);
						}
						return (BIN) nextIN;
					} else {
						IN ret = searchSubTree(nextIN, null,
								(forward ? SearchType.LEFT : SearchType.RIGHT),
								-1, null, true);
						parent.releaseLatch();
						assert LatchSupport.countLatchesHeld() == 1 : LatchSupport
								.latchesHeldToString();
						if (ret instanceof BIN) {
							return (BIN) ret;
						} else {
							throw new InconsistentNodeException(
									"subtree did not have a BIN for leaf");
						}
					}
				}
				next = parent;
			}
		} catch (DatabaseException e) {
			next.releaseLatchIfOwner();
			if (parent != null) {
				parent.releaseLatchIfOwner();
			}
			if (nextIN != null) {
				nextIN.releaseLatchIfOwner();
			}
			throw e;
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * Split the root of the tree.
	 */
	private void splitRoot() throws DatabaseException {
		EnvironmentImpl env = database.getDbEnvironment();
		LogManager logManager = env.getLogManager();
		INList inMemoryINs = env.getInMemoryINs();
		IN curRoot = null;
		curRoot = (IN) root.fetchTarget(database, null);
		// #if LATCHES
		curRoot.latch();
		// #endif
		long curRootLsn = 0;
		long logLsn = 0;
		IN newRoot = null;
		// #if LATCHES
		try {
			byte[] rootIdKey = curRoot.getKey(0);
			newRoot = new IN(database, rootIdKey, maxMainTreeEntriesPerNode,
					curRoot.getLevel() + 1);
			newRoot.setIsRoot(true);
			curRoot.setIsRoot(false);
			try {
				curRootLsn = curRoot.logProvisional(logManager, newRoot);
				boolean insertOk = newRoot.insertEntry(new ChildReference(
						curRoot, rootIdKey, curRootLsn));
				assert insertOk;
				logLsn = newRoot.log(logManager);
			} catch (DatabaseException e) {
				curRoot.setIsRoot(true);
				throw e;
			}
			inMemoryINs.add(newRoot);
			root.setTarget(newRoot);
			root.setLsn(logLsn);
			curRoot.split(newRoot, 0, maxMainTreeEntriesPerNode);
			root.setLsn(newRoot.getLastFullVersion());
		} finally {
			curRoot.releaseLatch();
		}
		// #endif
		treeStats.nRootSplits++;
		// #if LOGGINGFINE
		traceSplitRoot(Level.FINE, TRACE_ROOT_SPLIT, newRoot, logLsn, curRoot,
				curRootLsn);
		// #endif
	}

	/**
	 * Search the tree, starting at the root. Depending on search type either
	 * search using key, or search all the way down the right or left sides.
	 * Stop the search either when the bottom of the tree is reached, or a node
	 * matching nid is found (see below) in which case that node's parent is
	 * returned. Preemptive splitting is not done during the search.
	 * 
	 * @param key
	 *            - the key to search for, or null if searchType is LEFT or
	 *            RIGHT.
	 * @param searchType
	 *            - The type of tree search to perform. NORMAL means we're
	 *            searching for key in the tree. LEFT/RIGHT means we're
	 *            descending down the left or right side, resp. DELETE means
	 *            we're descending the tree and will return the lowest node in
	 *            the path that has > 1 entries.
	 * @param nid
	 *            - The nodeid to search for in the tree. If found, returns its
	 *            parent. If the nodeid of the root is passed, null is returned.
	 * @param binBoundary
	 *            - If non-null, information is returned about whether the BIN
	 *            found is the first or last BIN in the database.
	 * @return - the Node that matches the criteria, if any. This is the node
	 *         that is farthest down the tree with a match. Returns null if the
	 *         root is null. Node is latched (unless it's null) and must be
	 *         unlatched by the caller. Only IN's and BIN's are returned, not
	 *         LN's. In a NORMAL search, It is the caller's responsibility to do
	 *         the findEntry() call on the key and BIN to locate the entry that
	 *         matches key. The return value node is latched upon return and it
	 *         is the caller's responsibility to unlatch it.
	 */
	public IN search(byte[] key, SearchType searchType, long nid,
			BINBoundary binBoundary, boolean updateGeneration)
			throws DatabaseException {
		IN rootIN = getRootIN(true);
		if (rootIN != null) {
			return searchSubTree(rootIN, key, searchType, nid, binBoundary,
					updateGeneration);
		} else {
			return null;
		}
	}

	/**
	 * Do a key based search, permitting pre-emptive splits. Returns the target
	 * node's parent.
	 */
	public IN searchSplitsAllowed(byte[] key, long nid, boolean updateGeneration)
			throws DatabaseException {
		IN insertTarget = null;
		while (insertTarget == null) {
			// #if LATCHES
			rootLatch.acquireShared();
			// #endif
			// #if LATCHES
			boolean rootLatched = true;
			// #endif
			// #if LATCHES
			boolean rootLatchedExclusive = false;
			// #endif
			IN rootIN = null;
			// #if LATCHES
			try {
				while (true) {
					if (root != null) {
						rootIN = (IN) root.fetchTarget(database, null);
						if (rootIN.needsSplitting()) {
							// #if LATCHES
							if (!rootLatchedExclusive)
							// #if LATCHES
							{
								rootIN = null;
								rootLatch.release();
								rootLatch.acquireExclusive();
								rootLatchedExclusive = true;
								continue;
							}
							// #endif
							// #endif
							splitRoot();
							// #if LATCHES
							rootLatch.release();
							// #endif
							// #if LATCHES
							rootLatched = false;
							// #endif
							EnvironmentImpl env = database.getDbEnvironment();
							env.getDbMapTree().modifyDbRoot(database);
							// #if LATCHES
							rootLatched = true;
							// #endif
							// #if LATCHES
							rootLatch.acquireExclusive();
							// #endif
							rootIN = (IN) root.fetchTarget(database, null);
						}
						// #if LATCHES
						rootIN.latch();
						// #endif
					}
					break;
				}
			} finally {
				if (rootLatched) {
					rootLatch.release();
				}
			}
			// #endif
			if (rootIN == null) {
				break;
			}
			try {
				insertTarget = searchSubTreeSplitsAllowed(rootIN, key, nid,
						updateGeneration);
			} catch (SplitRequiredException e) {
				continue;
			}
		}
		return insertTarget;
	}

	/**
	 * Searches a portion of the tree starting at parent using key. If during
	 * the search a node matching a non-null nid argument is found, its parent
	 * is returned. If searchType is NORMAL, then key must be supplied to guide
	 * the search. If searchType is LEFT (or RIGHT), then the tree is searched
	 * down the left (or right) side to find the first (or last) leaf,
	 * respectively.
	 * <p>
	 * Enters with parent latched, assuming it's not null. Exits with the return
	 * value latched, assuming it's not null.
	 * <p>
	 * 
	 * @param parent
	 *            - the root of the subtree to start the search at. This node
	 *            should be latched by the caller and will be unlatched prior to
	 *            return.
	 * @param key
	 *            - the key to search for, unless searchType is LEFT or RIGHT
	 * @param searchType
	 *            - NORMAL means search using key and, optionally, nid. LEFT
	 *            means find the first (leftmost) leaf RIGHT means find the last
	 *            (rightmost) leaf
	 * @param nid
	 *            - The nodeid to search for in the tree. If found, returns its
	 *            parent. If the nodeid of the root is passed, null is returned.
	 *            Pass -1 if no nodeid based search is desired.
	 * @return - the node matching the argument criteria, or null. The node is
	 *         latched and must be unlatched by the caller. The parent argument
	 *         and any other nodes that are latched during the search are
	 *         unlatched prior to return.
	 */
	public IN searchSubTree(IN parent, byte[] key, SearchType searchType,
			long nid, BINBoundary binBoundary, boolean updateGeneration)
			throws DatabaseException {
		if (parent == null) {
			return null;
		}
		if ((searchType == SearchType.LEFT || searchType == SearchType.RIGHT)
				&& key != null) {
			throw new IllegalArgumentException(
					"searchSubTree passed key and left/right search");
		}
		// #if LATCHES
		assert parent.isLatchOwner();
		// #endif
		if (parent.getNodeId() == nid) {
			// #if LATCHES
			parent.releaseLatch();
			// #endif
			return null;
		}
		if (binBoundary != null) {
			binBoundary.isLastBin = true;
			binBoundary.isFirstBin = true;
		}
		int index;
		IN child = null;
		TreeWalkerStatsAccumulator treeStatsAccumulator = getTreeStatsAccumulator();
		try {
			do {
				if (treeStatsAccumulator != null) {
					parent.accumulateStats(treeStatsAccumulator);
				}
				if (parent.getNEntries() == 0) {
					return parent;
				} else if (searchType == SearchType.NORMAL) {
					index = parent.findEntry(key, false, false);
				} else if (searchType == SearchType.LEFT) {
					index = 0;
				} else if (searchType == SearchType.RIGHT) {
					index = parent.getNEntries() - 1;
				} else {
					throw new IllegalArgumentException(
							"Invalid value of searchType: " + searchType);
				}
				assert index >= 0;
				if (binBoundary != null) {
					if (index != parent.getNEntries() - 1) {
						binBoundary.isLastBin = false;
					}
					if (index != 0) {
						binBoundary.isFirstBin = false;
					}
				}
				child = (IN) parent.fetchTarget(index);
				child.latch(updateGeneration);
				if (treeStatsAccumulator != null) {
					child.accumulateStats(treeStatsAccumulator);
				}
				if (child.getNodeId() == nid) {
					// #if LATCHES
					child.releaseLatch();
					// #endif
					return parent;
				}
				// #if LATCHES
				parent.releaseLatch();
				// #endif
				parent = child;
			} while (!(parent instanceof BIN));
			return child;
		} catch (Throwable t) {
			// #if LATCHES
			if (child != null)
			// #if LATCHES
			{
				child.releaseLatchIfOwner();
			}
			// #endif
			// #endif
			// #if LATCHES
			parent.releaseLatchIfOwner();
			// #endif
			if (t instanceof DatabaseException) {
				throw (DatabaseException) t;
			} else {
				throw new DatabaseException(t);
			}
		}
	}

	/**
	 * Search down the tree using a key, but instead of returning the BIN that
	 * houses that key, find the point where we can detach a deletable subtree.
	 * A deletable subtree is a branch where each IN has one child, and the
	 * bottom BIN has no entries and no resident cursors. That point can be
	 * found by saving a pointer to the lowest node in the path with more than
	 * one entry. INa / \ INb INc | | INd .. / \ INe .. | BINx (suspected of
	 * being empty) In this case, we'd like to prune off the subtree headed by
	 * INe. INd is the parent of this deletable subtree. As we descend, we must
	 * keep latches for all the nodes that will be logged. In this case, we will
	 * need to keep INa, INb and INd latched when we return from this method.
	 * The method returns a list of parent/child/index structures. In this
	 * example, the list will hold: INa/INb/index INb/INd/index INd/INe/index
	 * Every node is latched, and every node except for the bottom most child
	 * (INe) must be logged.
	 */
	public void searchDeletableSubTree(IN parent, byte[] key,
			ArrayList nodeLadder) throws DatabaseException,
			NodeNotEmptyException, CursorsExistException {
		assert (parent != null);
		assert (key != null);
		// #if LATCHES
		assert parent.isLatchOwner();
		// #endif
		int index;
		IN child = null;
		IN lowestMultipleEntryIN = null;
		do {
			if (parent.getNEntries() == 0) {
				break;
			}
			if (parent.getNEntries() > 1) {
				lowestMultipleEntryIN = parent;
			}
			index = parent.findEntry(key, false, false);
			assert index >= 0;
			child = (IN) parent.fetchTarget(index);
			child.latch(false);
			nodeLadder.add(new SplitInfo(parent, child, index));
			parent = child;
		} while (!(parent instanceof BIN));
		if ((child != null) && (child instanceof BIN)) {
			if (child.getNEntries() != 0) {
				throw NodeNotEmptyException.NODE_NOT_EMPTY;
			}
			if (((BIN) child).nCursors() > 0) {
				throw CursorsExistException.CURSORS_EXIST;
			}
		}
		if (lowestMultipleEntryIN != null) {
			ListIterator iter = nodeLadder.listIterator(nodeLadder.size());
			while (iter.hasPrevious()) {
				SplitInfo info = (SplitInfo) iter.previous();
				if (info.parent == lowestMultipleEntryIN) {
					break;
				} else {
					// #if LATCHES
					info.child.releaseLatch();
					// #endif
					iter.remove();
				}
			}
		} else {
			// #if LATCHES
			releaseNodeLadderLatches(nodeLadder);
			// #endif
			nodeLadder.clear();
		}
	}

	/**
	 * Search the portion of the tree starting at the parent, permitting
	 * preemptive splits.
	 */
	private IN searchSubTreeSplitsAllowed(IN parent, byte[] key, long nid,
			boolean updateGeneration) throws DatabaseException,
			SplitRequiredException {
		if (parent != null) {
			while (true) {
				try {
					return searchSubTreeUntilSplit(parent, key, nid,
							updateGeneration);
				} catch (SplitRequiredException e) {
					if (waitHook != null) {
						waitHook.doHook();
					}
					forceSplit(parent, key);
				}
			}
		} else {
			return null;
		}
	}

	/**
	 * Search the subtree, but throw an exception when we see a node that has to
	 * be split.
	 */
	private IN searchSubTreeUntilSplit(IN parent, byte[] key, long nid,
			boolean updateGeneration) throws DatabaseException,
			SplitRequiredException {
		if (parent == null) {
			return null;
		}
		// #if LATCHES
		assert parent.isLatchOwner();
		// #endif
		if (parent.getNodeId() == nid) {
			// #if LATCHES
			parent.releaseLatch();
			// #endif
			return null;
		}
		int index;
		IN child = null;
		// #if LATCHES
		try {
			do {
				if (parent.getNEntries() == 0) {
					return parent;
				} else {
					index = parent.findEntry(key, false, false);
				}
				assert index >= 0;
				child = (IN) parent.fetchTarget(index);
				child.latch(updateGeneration);
				if (child.needsSplitting()) {
					child.releaseLatch();
					parent.releaseLatch();
					throw splitRequiredException;
				}
				if (child.getNodeId() == nid) {
					child.releaseLatch();
					return parent;
				}
				parent.releaseLatch();
				parent = child;
			} while (!(parent instanceof BIN));
			return parent;
		} catch (DatabaseException e) {
			if (child != null) {
				child.releaseLatchIfOwner();
			}
			parent.releaseLatchIfOwner();
			throw e;
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * Do pre-emptive splitting in the subtree topped by the "parent" node.
	 * Search down the tree until we get to the BIN level, and split any nodes
	 * that fit the splittable requirement. Note that more than one node in the
	 * path may be splittable. For example, a tree might have a level2 IN and a
	 * BIN that are both splittable, and would be encountered by the same insert
	 * operation.
	 */
	private void forceSplit(IN parent, byte[] key) throws DatabaseException,
			SplitRequiredException {
		ArrayList nodeLadder = new ArrayList();
		boolean allLeftSideDescent = true;
		boolean allRightSideDescent = true;
		int index;
		IN child = null;
		IN originalParent = parent;
		ListIterator iter = null;
		// #if LATCHES
		boolean isRootLatched = false;
		// #endif
		boolean success = false;
		try {
			// #if LATCHES
			if (originalParent.isDbRoot())
			// #if LATCHES
			{
				rootLatch.acquireExclusive();
				isRootLatched = true;
			}
			// #endif
			// #endif
			// #if LATCHES
			originalParent.latch();
			// #endif
			if (originalParent.needsSplitting() || !originalParent.isRoot()) {
				throw splitRequiredException;
			}
			do {
				if (parent.getNEntries() == 0) {
					break;
				} else {
					index = parent.findEntry(key, false, false);
					if (index != 0) {
						allLeftSideDescent = false;
					}
					if (index != (parent.getNEntries() - 1)) {
						allRightSideDescent = false;
					}
				}
				assert index >= 0;
				child = (IN) parent.getTarget(index);
				if (child == null) {
					break;
				} else {
					// #if LATCHES
					child.latch();
					// #endif
					nodeLadder.add(new SplitInfo(parent, child, index));
				}
				parent = child;
			} while (!(parent instanceof BIN));
			boolean startedSplits = false;
			LogManager logManager = database.getDbEnvironment().getLogManager();
			iter = nodeLadder.listIterator(nodeLadder.size());
			long lastParentForSplit = -1;
			while (iter.hasPrevious()) {
				SplitInfo info = (SplitInfo) iter.previous();
				child = info.child;
				parent = info.parent;
				index = info.index;
				if (child.needsSplitting()) {
					int maxEntriesPerNode = (child.containsDuplicates() ? maxDupTreeEntriesPerNode
							: maxMainTreeEntriesPerNode);
					if (allLeftSideDescent || allRightSideDescent) {
						child.splitSpecial(parent, index, maxEntriesPerNode,
								key, allLeftSideDescent);
					} else {
						child.split(parent, index, maxEntriesPerNode);
					}
					lastParentForSplit = parent.getNodeId();
					startedSplits = true;
					if (parent.isDbRoot()) {
						// #if LATCHES
						assert isRootLatched;
						// #endif
						root.setLsn(parent.getLastFullVersion());
						parent.setDirty(true);
					}
				} else {
					if (startedSplits) {
						long newLsn = 0;
						if (lastParentForSplit == child.getNodeId()) {
							newLsn = child.getLastFullVersion();
						} else {
							newLsn = child.log(logManager);
						}
						parent.updateEntry(index, newLsn);
					}
				}
				// #if LATCHES
				child.releaseLatch();
				// #endif
				child = null;
				iter.remove();
			}
			success = true;
		} finally {
			// #if LATCHES
			if (!success)
			// #if LATCHES
			{
				// #if LATCHES
				if (child != null)
				// #if LATCHES
				{
					child.releaseLatchIfOwner();
				}
				// #endif
				// #endif
				// #if LATCHES
				originalParent.releaseLatchIfOwner();
				// #endif
			}
			// #endif
			// #endif
			// #if LATCHES
			if (nodeLadder.size() > 0)
			// #if LATCHES
			{
				iter = nodeLadder.listIterator(nodeLadder.size());
				while (iter.hasPrevious()) {
					SplitInfo info = (SplitInfo) iter.previous();
					// #if LATCHES
					info.child.releaseLatchIfOwner();
					// #endif
				}
			}
			// #endif
			// #endif
			// #if LATCHES
			if (isRootLatched)
			// #if LATCHES
			{
				rootLatch.release();
			}
			// #endif
			// #endif
		}
	}

	/**
	 * Helper to obtain the root IN with proper root latching. Optionally
	 * updates the generation of the root when latching it.
	 */
	public IN getRootIN(boolean updateGeneration) throws DatabaseException {
		// #if LATCHES
		rootLatch.acquireShared();
		IN rootIN = null;
		try {
			if (root != null) {
				rootIN = (IN) root.fetchTarget(database, null);
				rootIN.latch(updateGeneration);
			}
			return rootIN;
		} finally {
			rootLatch.release();
		}
		// #else
		throw new RuntimeException("TYPE ERROR?");
		// #endif
	}

	/**
	 * Inserts a new LN into the tree.
	 * 
	 * @param ln
	 *            The LN to insert into the tree.
	 * @param key
	 *            Key value for the node
	 * @param allowDuplicates
	 *            whether to allow duplicates to be inserted
	 * @param cursor
	 *            the cursor to update to point to the newly inserted key/data
	 *            pair, or null if no cursor should be updated.
	 * @return true if LN was inserted, false if it was a duplicate duplicate or
	 *         if an attempt was made to insert a duplicate when allowDuplicates
	 *         was false.
	 */
	public boolean insert(LN ln, byte[] key, boolean allowDuplicates,
			CursorImpl cursor, LockResult lnLock) throws DatabaseException {
		validateInsertArgs(allowDuplicates);
		EnvironmentImpl env = database.getDbEnvironment();
		LogManager logManager = env.getLogManager();
		INList inMemoryINs = env.getInMemoryINs();
		BIN bin = null;
		// #if LATCHES
		try {
			bin = findBinForInsert(key, logManager, inMemoryINs, cursor);
			assert bin.isLatchOwner();
			ChildReference newLNRef = new ChildReference(ln, key,
					DbLsn.NULL_LSN);
			cursor.setBIN(bin);
			int index = bin.insertEntry1(newLNRef);
			if ((index & IN.INSERT_SUCCESS) != 0) {
				index &= ~IN.INSERT_SUCCESS;
				cursor.updateBin(bin, index);
				long newLsn = DbLsn.NULL_LSN;
				try {
					newLsn = ln.log(env, database.getId(), key, DbLsn.NULL_LSN,
							cursor.getLocker());
				} finally {
					if (newLsn == DbLsn.NULL_LSN) {
						bin.setKnownDeleted(index);
					}
				}
				lnLock.setAbortLsn(DbLsn.NULL_LSN, true, true);
				bin.updateEntry(index, newLsn);
				// #if LOGGINGFINER
				traceInsert(Level.FINER, env, bin, ln, newLsn, index);
				// #endif
				return true;
			} else {
				index &= ~IN.EXACT_MATCH;
				cursor.updateBin(bin, index);
				LN currentLN = null;
				boolean isDup = false;
				Node n = bin.fetchTarget(index);
				if (n == null || n instanceof LN) {
					currentLN = (LN) n;
				} else {
					isDup = true;
				}
				boolean isDeleted = false;
				LockResult currentLock = null;
				if (!isDup) {
					if (currentLN == null) {
						isDeleted = true;
					} else {
						currentLock = cursor.lockLNDeletedAllowed(currentLN,
								LockType.WRITE);
						currentLN = currentLock.getLN();
						bin = cursor.getBIN();
						index = cursor.getIndex();
						if (cursor.getDupBIN() != null) {
							cursor.clearDupBIN(true);
							isDup = true;
						} else if (bin.isEntryKnownDeleted(index)
								|| currentLN == null || currentLN.isDeleted()) {
							isDeleted = true;
						}
					}
				}
				if (isDeleted) {
					long abortLsn = bin.getLsn(index);
					boolean abortKnownDeleted = true;
					if (currentLN != null
							&& currentLock.getLockGrant() == LockGrantType.EXISTING) {
						long nodeId = currentLN.getNodeId();
						Locker locker = cursor.getLocker();
						WriteLockInfo info = locker.getWriteLockInfo(nodeId);
						abortLsn = info.getAbortLsn();
						abortKnownDeleted = info.getAbortKnownDeleted();
					}
					lnLock.setAbortLsn(abortLsn, abortKnownDeleted);
					long newLsn = ln.log(env, database.getId(), key,
							DbLsn.NULL_LSN, cursor.getLocker());
					bin.updateEntry(index, ln, newLsn, key);
					bin.clearKnownDeleted(index);
					bin.clearPendingDeleted(index);
					// #if LOGGINGFINER
					traceInsert(Level.FINER, env, bin, ln, newLsn, index);
					// #endif
					return true;
				} else {
					return insertDuplicate(key, bin, ln, logManager,
							inMemoryINs, cursor, lnLock, allowDuplicates);
				}
			}
		} finally {
			cursor.releaseBIN();
		}
		// #else
		return false; // Marcelo & Sabrina (comperr owise)
		// #endif
	}

	/**
	 * Attempts to insert a duplicate at the current cursor BIN position. If an
	 * existing dup tree exists, insert into it; otherwise, create a new dup
	 * tree and place the new LN and the existing LN into it. If the current BIN
	 * entry contains an LN, the caller guarantees that it is not deleted.
	 * 
	 * @return true if duplicate inserted successfully, false if it was a
	 *         duplicate duplicate, false if a there is an existing LN and
	 *         allowDuplicates is false.
	 */
	private boolean insertDuplicate(byte[] key, BIN bin, LN newLN,
			LogManager logManager, INList inMemoryINs, CursorImpl cursor,
			LockResult lnLock, boolean allowDuplicates)
			throws DatabaseException {
		EnvironmentImpl env = database.getDbEnvironment();
		int index = cursor.getIndex();
		boolean successfulInsert = false;
		DIN dupRoot = null;
		Node n = bin.fetchTarget(index);
		long binNid = bin.getNodeId();
		if (n instanceof DIN) {
			DBIN dupBin = null;
			// #if LATCHES
			try {
				dupRoot = (DIN) n;
				// #if LATCHES
				dupRoot.latch();
				// #endif
				LockResult dclLockResult = cursor.lockDupCountLN(dupRoot,
						LockType.WRITE);
				bin = cursor.getBIN();
				index = cursor.getIndex();
				if (!allowDuplicates) {
					DupCountLN dcl = (DupCountLN) dclLockResult.getLN();
					if (dcl.getDupCount() > 0) {
						return false;
					}
				}
				maybeSplitDuplicateRoot(bin, index);
				dupRoot = (DIN) bin.fetchTarget(index);
				byte[] newLNKey = newLN.getData();
				long previousLsn = dupRoot.getLastFullVersion();
				try {
					dupBin = (DBIN) searchSubTreeSplitsAllowed(dupRoot,
							newLNKey, -1, true);
				} catch (SplitRequiredException e) {
					throw new DatabaseException(e);
				}
				long currentLsn = dupRoot.getLastFullVersion();
				if (currentLsn != previousLsn) {
					bin.updateEntry(index, currentLsn);
				}
				// #if LATCHES
				cursor.releaseBIN();
				// #endif
				bin = null;
				dupRoot = null;
				ChildReference newLNRef = new ChildReference(newLN, newLNKey,
						DbLsn.NULL_LSN);
				int dupIndex = dupBin.insertEntry1(newLNRef);
				if ((dupIndex & IN.INSERT_SUCCESS) != 0) {
					dupIndex &= ~IN.INSERT_SUCCESS;
					cursor.updateDBin(dupBin, dupIndex);
					long newLsn = DbLsn.NULL_LSN;
					try {
						newLsn = newLN.log(env, database.getId(), key,
								DbLsn.NULL_LSN, cursor.getLocker());
					} finally {
						if (newLsn == DbLsn.NULL_LSN) {
							dupBin.setKnownDeleted(dupIndex);
						}
					}
					lnLock.setAbortLsn(DbLsn.NULL_LSN, true, true);
					dupBin.setLsn(dupIndex, newLsn);
					// #if LOGGINGFINER
					traceInsertDuplicate(Level.FINER,
							database.getDbEnvironment(), dupBin, newLN, newLsn,
							binNid);
					// #endif
					successfulInsert = true;
				} else {
					dupIndex &= ~IN.EXACT_MATCH;
					cursor.updateDBin(dupBin, dupIndex);
					LN currentLN = (LN) dupBin.fetchTarget(dupIndex);
					boolean isDeleted = false;
					LockResult currentLock = null;
					if (currentLN == null) {
						isDeleted = true;
					} else {
						currentLock = cursor.lockLNDeletedAllowed(currentLN,
								LockType.WRITE);
						currentLN = currentLock.getLN();
						dupBin = cursor.getDupBIN();
						dupIndex = cursor.getDupIndex();
						if (dupBin.isEntryKnownDeleted(dupIndex)
								|| currentLN == null || currentLN.isDeleted()) {
							isDeleted = true;
						}
					}
					if (isDeleted) {
						long abortLsn = dupBin.getLsn(dupIndex);
						boolean abortKnownDeleted = true;
						if (currentLN != null
								&& currentLock.getLockGrant() == LockGrantType.EXISTING) {
							long nodeId = currentLN.getNodeId();
							Locker locker = cursor.getLocker();
							WriteLockInfo info = locker
									.getWriteLockInfo(nodeId);
							abortLsn = info.getAbortLsn();
							abortKnownDeleted = info.getAbortKnownDeleted();
						}
						lnLock.setAbortLsn(abortLsn, abortKnownDeleted);
						long newLsn = newLN.log(env, database.getId(), key,
								DbLsn.NULL_LSN, cursor.getLocker());
						dupBin.updateEntry(dupIndex, newLN, newLsn, newLNKey);
						dupBin.clearKnownDeleted(dupIndex);
						dupBin.clearPendingDeleted(dupIndex);
						// #if LOGGINGFINER
						traceInsertDuplicate(Level.FINER,
								database.getDbEnvironment(), dupBin, newLN,
								newLsn, binNid);
						// #endif
						successfulInsert = true;
					} else {
						successfulInsert = false;
					}
				}
				// #if LATCHES
				dupBin.releaseLatch();
				// #endif
				dupBin = null;
				if (successfulInsert) {
					// #if LATCHES
					cursor.latchBIN();
					// #endif
					dupRoot = cursor.getLatchedDupRoot(false);
					// #if LATCHES
					cursor.releaseBIN();
					// #endif
					dupRoot.incrementDuplicateCount(dclLockResult, key,
							cursor.getLocker(), true);
				}
			} finally {
				if (dupBin != null) {
					dupBin.releaseLatchIfOwner();
				}
				if (dupRoot != null) {
					dupRoot.releaseLatchIfOwner();
				}
			}
			// #endif
		} else if (n instanceof LN) {
			if (!allowDuplicates) {
				return false;
			}
			try {
				lnLock.setAbortLsn(DbLsn.NULL_LSN, true, true);
				dupRoot = createDuplicateTree(key, logManager, inMemoryINs,
						newLN, cursor);
			} finally {
				if (dupRoot != null) {
					// #if LATCHES
					dupRoot.releaseLatch();
					// #endif
					successfulInsert = true;
				} else {
					successfulInsert = false;
				}
			}
		} else {
			throw new InconsistentNodeException(
					"neither LN or DIN found in BIN");
		}
		return successfulInsert;
	}

	/**
	 * Check if the duplicate root needs to be split. The current duplicate root
	 * is latched. Exit with the new root (even if it's unchanged) latched and
	 * the old root (unless the root is unchanged) unlatched.
	 * 
	 * @param bin
	 *            the BIN containing the duplicate root.
	 * @param index
	 *            the index of the duplicate root in bin.
	 * @return true if the duplicate root was split.
	 */
	private boolean maybeSplitDuplicateRoot(BIN bin, int index)
			throws DatabaseException {
		DIN curRoot = (DIN) bin.fetchTarget(index);
		if (curRoot.needsSplitting()) {
			EnvironmentImpl env = database.getDbEnvironment();
			LogManager logManager = env.getLogManager();
			INList inMemoryINs = env.getInMemoryINs();
			byte[] rootIdKey = curRoot.getKey(0);
			DIN newRoot = new DIN(database, rootIdKey,
					maxDupTreeEntriesPerNode, curRoot.getDupKey(),
					curRoot.getDupCountLNRef(), curRoot.getLevel() + 1);
			// #if LATCHES
			newRoot.latch();
			// #endif
			long curRootLsn = 0;
			long logLsn = 0;
			// #if LATCHES
			try {
				newRoot.setIsRoot(true);
				curRoot.setDupCountLN(null);
				curRoot.setIsRoot(false);
				try {
					curRootLsn = curRoot.logProvisional(logManager, newRoot);
					boolean insertOk = newRoot.insertEntry(new ChildReference(
							curRoot, rootIdKey, bin.getLsn(index)));
					assert insertOk;
					logLsn = newRoot.log(logManager);
				} catch (DatabaseException e) {
					curRoot.setIsRoot(true);
					throw e;
				}
				inMemoryINs.add(newRoot);
				bin.updateEntry(index, newRoot, logLsn);
				curRoot.split(newRoot, 0, maxDupTreeEntriesPerNode);
			} finally {
				curRoot.releaseLatch();
			}
			// #endif
			// #if LOGGINGFINE
			traceSplitRoot(Level.FINE, TRACE_DUP_ROOT_SPLIT, newRoot, logLsn,
					curRoot, curRootLsn);
			// #endif
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Convert an existing BIN entry from a single (non-duplicate) LN to a new
	 * DIN/DupCountLN->DBIN->LN subtree.
	 * 
	 * @param key
	 *            the key of the entry which will become the duplicate key for
	 *            the duplicate subtree.
	 * @param logManager
	 *            the logManager
	 * @param inMemoryINs
	 *            the in memory IN list
	 * @param newLN
	 *            the new record to be inserted
	 * @param cursor
	 *            points to the target position for this new dup tree.
	 * @return the new duplicate subtree root (a DIN). It is latched when it is
	 *         returned and the caller should unlatch it. If new entry to be
	 *         inserted is a duplicate of the existing LN, null is returned.
	 */
	private DIN createDuplicateTree(byte[] key, LogManager logManager,
			INList inMemoryINs, LN newLN, CursorImpl cursor)
			throws DatabaseException {
		EnvironmentImpl env = database.getDbEnvironment();
		DIN dupRoot = null;
		DBIN dupBin = null;
		BIN bin = cursor.getBIN();
		int index = cursor.getIndex();
		LN existingLN = (LN) bin.fetchTarget(index);
		boolean existingLNIsDeleted = bin.isEntryKnownDeleted(index)
				|| existingLN.isDeleted();
		assert existingLN != null;
		byte[] existingKey = existingLN.getData();
		byte[] newLNKey = newLN.getData();
		boolean keysEqual = Key.compareKeys(newLNKey, existingKey,
				database.getDuplicateComparator()) == 0;
		if (keysEqual) {
			return null;
		}
		Locker locker = cursor.getLocker();
		long nodeId = existingLN.getNodeId();
		int startingCount = (locker.createdNode(nodeId) || existingLNIsDeleted || locker
				.getWriteLockInfo(nodeId).getAbortKnownDeleted()) ? 0 : 1;
		DupCountLN dupCountLN = new DupCountLN(startingCount);
		long firstDupCountLNLsn = dupCountLN.logProvisional(env,
				database.getId(), key, DbLsn.NULL_LSN);
		dupRoot = new DIN(database, existingKey, maxDupTreeEntriesPerNode, key,
				new ChildReference(dupCountLN, key, firstDupCountLNLsn), 2);
		// #if LATCHES
		dupRoot.latch();
		// #endif
		dupRoot.setIsRoot(true);
		dupBin = new DBIN(database, existingKey, maxDupTreeEntriesPerNode, key,
				1);
		// #if LATCHES
		dupBin.latch();
		// #endif
		ChildReference newExistingLNRef = new ChildReference(existingLN,
				existingKey, bin.getLsn(index), bin.getState(index));
		boolean insertOk = dupBin.insertEntry(newExistingLNRef);
		assert insertOk;
		// #if LATCHES
		try {
			long dbinLsn = dupBin.logProvisional(logManager, dupRoot);
			inMemoryINs.add(dupBin);
			dupRoot.setEntry(0, dupBin, dupBin.getKey(0), dbinLsn,
					dupBin.getState(0));
			long dinLsn = dupRoot.log(logManager);
			inMemoryINs.add(dupRoot);
			LockResult lockResult = locker.lock(dupCountLN.getNodeId(),
					LockType.WRITE, false, database);
			lockResult.setAbortLsn(firstDupCountLNLsn, false);
			dupCountLN.setDupCount(2);
			long dupCountLsn = dupCountLN.log(env, database.getId(), key,
					firstDupCountLNLsn, locker);
			dupRoot.updateDupCountLNRef(dupCountLsn);
			long newLsn = newLN.log(env, database.getId(), key, DbLsn.NULL_LSN,
					locker);
			int dupIndex = dupBin.insertEntry1(new ChildReference(newLN,
					newLNKey, newLsn));
			dupIndex &= ~IN.INSERT_SUCCESS;
			cursor.updateDBin(dupBin, dupIndex);
			bin.adjustCursorsForMutation(index, dupBin, dupIndex ^ 1, cursor);
			// #if LATCHES
			dupBin.releaseLatch();
			// #endif
			bin.updateEntry(index, dupRoot, dinLsn);
			bin.setMigrate(index, false);
			// #if LOGGINGFINE
			traceMutate(Level.FINE, bin, existingLN, newLN, newLsn, dupCountLN,
					dupCountLsn, dupRoot, dinLsn, dupBin, dbinLsn);
			// #endif
		} catch (DatabaseException e) {
			dupBin.releaseLatchIfOwner();
			dupRoot.releaseLatchIfOwner();
			throw e;
		}
		// #endif
		return dupRoot;
	}

	/**
	 * Validate args passed to insert. Presently this just means making sure
	 * that if they say duplicates are allowed that the database supports
	 * duplicates.
	 */
	private void validateInsertArgs(boolean allowDuplicates)
			throws DatabaseException {
		if (allowDuplicates && !database.getSortedDuplicates()) {
			throw new DatabaseException(
					"allowDuplicates passed to insert but database doesn't "
							+ "have allow duplicates set.");
		}
	}

	/**
	 * Find the BIN that is relevant to the insert. If the tree doesn't exist
	 * yet, then create the first IN and BIN.
	 * 
	 * @return the BIN that was found or created and return it latched.
	 */
	private BIN findBinForInsert(byte[] key, LogManager logManager,
			INList inMemoryINs, CursorImpl cursor) throws DatabaseException {
		BIN bin;
		bin = cursor.latchBIN();
		if (bin != null) {
			if (!bin.needsSplitting() && bin.isKeyInBounds(key)) {
				return bin;
			} else {
				// #if LATCHES
				bin.releaseLatch();
				// #endif

			}
		}
		boolean rootLatchIsHeld = false;
		// #if LATCHES
		try {
			long logLsn;
			while (true) {
				rootLatchIsHeld = true;
				rootLatch.acquireShared();
				if (root == null) {
					rootLatch.release();
					rootLatch.acquireExclusive();
					if (root != null) {
						rootLatch.release();
						rootLatchIsHeld = false;
						continue;
					}
					bin = new BIN(database, key, maxMainTreeEntriesPerNode, 1);
					bin.latch();
					logLsn = bin.logProvisional(logManager, null);
					IN rootIN = new IN(database, key,
							maxMainTreeEntriesPerNode, 2);
					rootIN.setIsRoot(true);
					boolean insertOk = rootIN.insertEntry(new ChildReference(
							bin, key, logLsn));
					assert insertOk;
					logLsn = rootIN.log(logManager);
					rootIN.setDirty(true);
					root = new ChildReference(rootIN, new byte[0], logLsn);
					inMemoryINs.add(bin);
					inMemoryINs.add(rootIN);
					rootLatch.release();
					rootLatchIsHeld = false;
					break;
				} else {
					rootLatch.release();
					rootLatchIsHeld = false;
					IN in = searchSplitsAllowed(key, -1, true);
					if (in == null) {
						continue;
					} else {
						bin = (BIN) in;
						break;
					}
				}
			}
		} finally {
			if (rootLatchIsHeld) {
				rootLatch.release();
			}
		}
		// #endif
		if (ckptHook != null) {
			ckptHook.doHook();
		}
		return bin;
	}

	private void accountForSubtreeRemoval(INList inList, IN subtreeRoot, UtilizationTracker tracker) throws DatabaseException {
		// #if LATCHES
		inList.latchMajor();
		// #endif
		// #if LATCHES
		try {
			subtreeRoot.accountForSubtreeRemoval(inList,tracker);
		} finally {
			inList.releaseMajorLatch();
		}
		// #endif
		// #if LOGGINGFINE
		Tracer.trace(Level.FINE, database.getDbEnvironment(),
				"SubtreeRemoval: subtreeRoot = " + subtreeRoot.getNodeId());
		// #endif
	}

	/**
	 * @see LogWritable#getLogSize
	 */
	public int getLogSize() {
		int size = LogUtils.getBooleanLogSize();
		if (root != null) {
			size += root.getLogSize();
		}
		return size;
	}

	/**
	 * @see LogWritable#writeToLog
	 */
	public void writeToLog(ByteBuffer logBuffer) {
		LogUtils.writeBoolean(logBuffer, (root != null));
		if (root != null) {
			root.writeToLog(logBuffer);
		}
	}

	/**
	 * @see LogReadable#readFromLog
	 */
	public void readFromLog(ByteBuffer itemBuffer, byte entryTypeVersion) {
		boolean rootExists = LogUtils.readBoolean(itemBuffer);
		if (rootExists) {
			root = makeRootChildReference();
			root.readFromLog(itemBuffer, entryTypeVersion);
		}
	}

	/**
	 * @see LogReadable#dumpLog
	 */
	public void dumpLog(StringBuffer sb, boolean verbose) {
		sb.append("<root>");
		if (root != null) {
			root.dumpLog(sb, verbose);
		}
		sb.append("</root>");
	}

	/**
	 * @see LogReadable#isTransactional
	 */
	public boolean logEntryIsTransactional() {
		return false;
	}

	/**
	 * @see LogReadable#getTransactionId
	 */
	public long getTransactionId() {
		return 0;
	}

	/**
	 * rebuildINList is used by recovery to add all the resident nodes to the IN
	 * list.
	 */
	public void rebuildINList() throws DatabaseException {
		INList inMemoryList = database.getDbEnvironment().getInMemoryINs();
		if (root != null) {
			// #if LATCHES
			rootLatch.acquireShared();
			// #endif
			// #if LATCHES
			try {
				Node rootIN = root.getTarget();
				if (rootIN != null) {
					rootIN.rebuildINList(inMemoryList);
				}
			} finally {
				rootLatch.release();
			}
			// #endif
		}
	}

	public void dump() throws DatabaseException {
		System.out.println(dumpString(0));
	}

	public String dumpString(int nSpaces) throws DatabaseException {
		StringBuffer sb = new StringBuffer();
		sb.append(TreeUtils.indent(nSpaces));
		sb.append("<tree>");
		sb.append('\n');
		if (root != null) {
			sb.append(DbLsn.dumpString(root.getLsn(), nSpaces));
			sb.append('\n');
			IN rootIN = (IN) root.getTarget();
			if (rootIN == null) {
				sb.append("<in/>");
			} else {
				sb.append(rootIN.toString());
			}
			sb.append('\n');
		}
		sb.append(TreeUtils.indent(nSpaces));
		sb.append("</tree>");
		return sb.toString();
	}

	/**
	 * Unit test support to validate subtree pruning. Didn't want to make root
	 * access public.
	 */
	// #if LATCHES
	boolean validateDelete(int index) throws DatabaseException {
		rootLatch.acquireShared();
		try {
			IN rootIN = (IN) root.fetchTarget(database, null);
			return rootIN.validateSubtreeBeforeDelete(index);
		} finally {
			rootLatch.release();
		}
	}

	// #endif

	/**
	 * Debugging check that all resident nodes are on the INList and no stray
	 * nodes are present in the unused portion of the IN arrays.
	 */
	public void validateINList(IN parent) throws DatabaseException {
		if (parent == null) {
			parent = (IN) root.getTarget();
		}
		if (parent != null) {
			INList inList = database.getDbEnvironment().getInMemoryINs();
			if (!inList.getINs().contains(parent)) {
				throw new DatabaseException("IN " + parent.getNodeId()
						+ " missing from INList");
			}
			for (int i = 0;; i += 1) {
				try {
					Node node = parent.getTarget(i);
					if (i >= parent.getNEntries()) {
						if (node != null) {
							throw new DatabaseException("IN "
									+ parent.getNodeId() + " has stray node "
									+ node.getNodeId() + " at index " + i);
						}
						byte[] key = parent.getKey(i);
						if (key != null) {
							throw new DatabaseException("IN "
									+ parent.getNodeId() + " has stray key "
									+ key + " at index " + i);
						}
					}
					if (node instanceof IN) {
						validateINList((IN) node);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					break;
				}
			}
		}
	}

	public void setWaitHook(TestHook hook) {
		waitHook = hook;
	}

	public void setSearchHook(TestHook hook) {
		searchHook = hook;
	}

	public void setCkptHook(TestHook hook) {
		ckptHook = hook;
	}

	// #if LOGGINGFINE
	/**
	 * Send trace messages to the java.util.logger. Don't rely on the logger
	 * alone to conditionalize whether we send this message, we don't even want
	 * to construct the message if the level is not enabled.
	 */
	private void traceSplitRoot(Level level, String splitType, IN newRoot,
			long newRootLsn, IN oldRoot, long oldRootLsn) {
		// #if LOGGINGBASE
		Logger logger = database.getDbEnvironment().getLogger();
		// #endif
		// #if LOGGINGBASE
		if (logger.isLoggable(level))
		// #if LOGGINGBASE
		{
			StringBuffer sb = new StringBuffer();
			sb.append(splitType);
			sb.append(" newRoot=").append(newRoot.getNodeId());
			sb.append(" newRootLsn=").append(
					DbLsn.getNoFormatString(newRootLsn));
			sb.append(" oldRoot=").append(oldRoot.getNodeId());
			sb.append(" oldRootLsn=").append(
					DbLsn.getNoFormatString(oldRootLsn));
			logger.log(level, sb.toString());
		}
		// #endif
		// #endif
	}

	// #endif
	// #if LOGGINGFINE
	/**
	 * Send trace messages to the java.util.logger. Don't rely on the logger
	 * alone to conditionalize whether we send this message, we don't even want
	 * to construct the message if the level is not enabled.
	 */
	private void traceMutate(Level level, BIN theBin, LN existingLn, LN newLn,
			long newLsn, DupCountLN dupCountLN, long dupRootLsn, DIN dupRoot,
			long ddinLsn, DBIN dupBin, long dbinLsn) {
		// #if LOGGINGBASE
		Logger logger = database.getDbEnvironment().getLogger();
		// #endif
		// #if LOGGINGBASE
		if (logger.isLoggable(level))
		// #if LOGGINGBASE
		{
			StringBuffer sb = new StringBuffer();
			sb.append(TRACE_MUTATE);
			sb.append(" existingLn=");
			sb.append(existingLn.getNodeId());
			sb.append(" newLn=");
			sb.append(newLn.getNodeId());
			sb.append(" newLnLsn=");
			sb.append(DbLsn.getNoFormatString(newLsn));
			sb.append(" dupCountLN=");
			sb.append(dupCountLN.getNodeId());
			sb.append(" dupRootLsn=");
			sb.append(DbLsn.getNoFormatString(dupRootLsn));
			sb.append(" rootdin=");
			sb.append(dupRoot.getNodeId());
			sb.append(" ddinLsn=");
			sb.append(DbLsn.getNoFormatString(ddinLsn));
			sb.append(" dbin=");
			sb.append(dupBin.getNodeId());
			sb.append(" dbinLsn=");
			sb.append(DbLsn.getNoFormatString(dbinLsn));
			sb.append(" bin=");
			sb.append(theBin.getNodeId());
			logger.log(level, sb.toString());
		}
		// #endif
		// #endif
	}

	// #endif
	// #if LOGGINGFINER
	/**
	 * Send trace messages to the java.util.logger. Don't rely on the logger
	 * alone to conditionalize whether we send this message, we don't even want
	 * to construct the message if the level is not enabled.
	 */
	private void traceInsert(Level level, EnvironmentImpl env,
			BIN insertingBin, LN ln, long lnLsn, int index) {
		// #if LOGGINGBASE
		Logger logger = env.getLogger();
		// #endif
		// #if LOGGINGBASE
		if (logger.isLoggable(level))
		// #if LOGGINGBASE
		{
			StringBuffer sb = new StringBuffer();
			sb.append(TRACE_INSERT);
			sb.append(" bin=");
			sb.append(insertingBin.getNodeId());
			sb.append(" ln=");
			sb.append(ln.getNodeId());
			sb.append(" lnLsn=");
			sb.append(DbLsn.getNoFormatString(lnLsn));
			sb.append(" index=");
			sb.append(index);
			logger.log(level, sb.toString());
		}
		// #endif
		// #endif
	}

	// #endif
	// #if LOGGINGFINER
	/**
	 * Send trace messages to the java.util.logger. Don't rely on the logger
	 * alone to conditionalize whether we send this message, we don't even want
	 * to construct the message if the level is not enabled.
	 */
	private void traceInsertDuplicate(Level level, EnvironmentImpl env,
			BIN insertingDBin, LN ln, long lnLsn, long binNid) {
		// #if LOGGINGBASE
		Logger logger = env.getLogger();
		// #endif
		// #if LOGGINGBASE
		if (logger.isLoggable(level))
		// #if LOGGINGBASE
		{
			StringBuffer sb = new StringBuffer();
			sb.append(TRACE_INSERT_DUPLICATE);
			sb.append(" dbin=");
			sb.append(insertingDBin.getNodeId());
			sb.append(" bin=");
			sb.append(binNid);
			sb.append(" ln=");
			sb.append(ln.getNodeId());
			sb.append(" lnLsn=");
			sb.append(DbLsn.getNoFormatString(lnLsn));
			logger.log(level, sb.toString());
		}
		// #endif
		// #endif
	}

	// #endif
	static private class SplitInfo {
		IN parent;
		IN child;
		int index;

		SplitInfo(IN parent, IN child, int index) {
			this.parent = parent;
			this.child = child;
			this.index = index;
		}
	}
}
