package com.sleepycat.je.dbi;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.cleaner.OffsetList;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.utilint.DbLsn;
/** 
 * Class to walk over the tree using sorted LSN fetching for parts of the tree
 * that are not in memory.  Returns LSNs for each node in the tree
 * <b>except</b> the root IN, but in an arbitrary order (i.e. not key
 * order). The caller is responsible for getting the root IN's LSN explicitly.
 * <p>
 * A calllback function specified in the constructor is executed for each LSN
 * found.
 * <p>
 * The walker works in two phases.  The first phase is to gather and return all
 * the INs from the INList that match the database being iterated over.  For
 * each IN, all of the LSNs of the children are passed to the callback method
 * (processLSN).  If the child was not in memory, it is added to a list of LSNs
 * to read.  When all of the in-memory INs have been processed, the list of
 * LSNs that were harvested are sorted.
 * <p>
 * Then for each of the sorted LSNs, the target is fetched, the type
 * determined, and the LSN and type passed to the callback method for
 * processing.  LSNs of the children of those nodes are retrieved and the
 * process repeated until there are no more nodes to be fetched for this
 * database's tree.
 */
public class SortedLSNTreeWalker {
public interface TreeNodeProcessor {
    void processLSN(    long childLSN,    LogEntryType childType);
  }
  protected DatabaseImpl dbImpl;
  private EnvironmentImpl envImpl;
  private long rootLsn;
  private boolean dups;
  private boolean removeINsFromINList;
  private boolean setDbState;
  private long[] currentLSNs;
  private int currentLSNIdx=0;
  private OffsetList accumulatedLSNFileNumbers;
  private OffsetList accumulatedLSNFileOffsets;
  private TreeNodeProcessor callback;
  protected boolean accumulateLNs=false;
  public SortedLSNTreeWalker(  DatabaseImpl dbImpl,  boolean removeINsFromINList,  boolean setDbState,  long rootLsn,  TreeNodeProcessor callback) throws DatabaseException {
    this.dbImpl=dbImpl;
    this.envImpl=dbImpl.getDbEnvironment();
    if (envImpl == null) {
      throw new DatabaseException("environmentImpl is null for target db " + dbImpl.getDebugName());
    }
    this.dups=dbImpl.getSortedDuplicates();
    this.removeINsFromINList=removeINsFromINList;
    this.setDbState=setDbState;
    this.rootLsn=rootLsn;
    this.callback=callback;
    currentLSNs=new long[0];
    currentLSNIdx=0;
  }
  private boolean extractINsForDb(  INList inList) throws DatabaseException {
    boolean foundSome=false;
    Set foundSet=new HashSet();
//#if MEMORYBUDGET
    long memoryChange=0;
    MemoryBudget mb=envImpl.getMemoryBudget();
//#endif
//#if LATCHES
    inList.latchMajor();
//#endif
    try {
//#if LATCHES
      inList.latchMinorAndDumpAddedINs();
//#endif
      Iterator iter=inList.iterator();
      while (iter.hasNext()) {
        IN thisIN=(IN)iter.next();
        if (thisIN.getDatabase() == dbImpl) {
          foundSome=true;
          if (removeINsFromINList) {
            iter.remove();
//#if MEMORYBUDGET
            memoryChange+=(thisIN.getAccumulatedDelta() - thisIN.getInMemorySize());
            thisIN.setInListResident(false);
//#endif
          }
          foundSet.add(thisIN);
        }
      }
    }
    //#if MEMORYBUDGET
    catch (DatabaseException e){
      mb.updateTreeMemoryUsage(memoryChange);
      throw e;
    }
    //#endif
    finally{ 
     //#if LATCHES
	 inList.releaseMajorLatch();
     //#endif
    }
    if (foundSome) {
      Iterator iter=foundSet.iterator();
      while (iter.hasNext()) {
        IN thisIN=(IN)iter.next();
        accumulateLSNs(thisIN);
      }
    }
    foundSet=null;
//#if MEMORYBUDGET
    mb.updateTreeMemoryUsage(memoryChange);
//#endif
    return foundSome;
  }
  /** 
 * Find all non-resident nodes, and execute the callback.  The root IN's
 * LSN is not returned to the callback.
 */
  public void walk() throws DatabaseException {
    walkInternal();
  }
  protected void walkInternal() throws DatabaseException {
    INList inList=envImpl.getInMemoryINs();
    IN root=null;
    if (!extractINsForDb(inList)) {
      if (rootLsn == DbLsn.NULL_LSN) {
        return;
      }
      root=getRootIN(rootLsn);
      accumulateLSNs(root);
      releaseRootIN(root);
    }
//#if DELETEOP
    if (setDbState) 
//#if DELETEOP
{
      dbImpl.finishedINListHarvest();
    }
//#endif
//#endif
    while (true) {
      maybeGetMoreINs();
      if (currentLSNs != null && currentLSNIdx < currentLSNs.length) {
        fetchAndProcessLSN(currentLSNs[currentLSNIdx++]);
      }
 else {
        break;
      }
    }
  }
  private void maybeGetMoreINs(){
    if ((currentLSNs != null && currentLSNIdx >= currentLSNs.length)) {
      if (accumulatedLSNFileNumbers == null || accumulatedLSNFileNumbers.size() == 0) {
        currentLSNs=null;
        currentLSNIdx=Integer.MAX_VALUE;
        return;
      }
      long[] tempFileNumbers=accumulatedLSNFileNumbers.toArray();
      long[] tempFileOffsets=accumulatedLSNFileOffsets.toArray();
      int nLSNs=tempFileNumbers.length;
      currentLSNIdx=0;
      currentLSNs=new long[nLSNs];
      for (int i=0; i < nLSNs; i++) {
        currentLSNs[i]=DbLsn.makeLsn(tempFileNumbers[i],tempFileOffsets[i]);
      }
      Arrays.sort(currentLSNs);
      accumulatedLSNFileNumbers=null;
      accumulatedLSNFileOffsets=null;
    }
  }
  private void accumulateLSNs(  IN in) throws DatabaseException {
    boolean accumulate=true;
    if (!accumulateLNs) {
      if ((!dups && (in instanceof BIN)) || (in instanceof DBIN)) {
        accumulate=false;
      }
    }
    for (int i=0; i < in.getNEntries(); i++) {
      if (in.isEntryPendingDeleted(i) || in.isEntryKnownDeleted(i)) {
        continue;
      }
      long lsn=in.getLsn(i);
      Node node=in.getTarget(i);
      if (accumulate && (node == null)) {
        if (accumulatedLSNFileNumbers == null) {
          accumulatedLSNFileNumbers=new OffsetList();
          accumulatedLSNFileOffsets=new OffsetList();
        }
        accumulatedLSNFileNumbers.add(DbLsn.getFileNumber(lsn),false);
        accumulatedLSNFileOffsets.add(DbLsn.getFileOffset(lsn),false);
        addToLsnINMap(new Long(lsn),in,i);
      }
 else {
        callback.processLSN(lsn,(node == null) ? LogEntryType.LOG_LN : node.getLogType());
      }
    }
    if (in instanceof DIN) {
      if (in.isRoot()) {
        DIN din=(DIN)in;
        callback.processLSN(din.getDupCountLNRef().getLsn(),LogEntryType.LOG_DUPCOUNTLN);
      }
    }
  }
  private void fetchAndProcessLSN(  long lsn) throws DatabaseException {
    Node node=fetchLSN(lsn);
    if (node != null) {
      callback.processLSN(lsn,node.getLogType());
      if (node instanceof IN) {
        accumulateLSNs((IN)node);
      }
    }
  }
  /** 
 * The default behavior fetches the rootIN from the log, but classes
 * extending this may fetch the root from the tree.
 */
  protected IN getRootIN(  long rootLsn) throws DatabaseException {
    return (IN)envImpl.getLogManager().get(rootLsn);
  }
  protected void releaseRootIN(  IN ignore) throws DatabaseException {
  }
  protected void addToLsnINMap(  Long lsn,  IN in,  int index){
  }
  protected Node fetchLSN(  long lsn) throws DatabaseException {
    return (Node)envImpl.getLogManager().get(lsn);
  }
}
