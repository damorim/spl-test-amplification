package com.sleepycat.je.dbi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import com.sleepycat.je.DatabaseException;
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.tree.IN;
/** 
 * The INList is a list of in-memory INs for a given environment. 
 */
public class INList {
  private static final String DEBUG_NAME=INList.class.getName();
  private SortedSet ins=null;
//#if LATCHES
  private Set addedINs=null;
//#endif
  private EnvironmentImpl envImpl;
//#if LATCHES
  private Latch majorLatch;
//#endif
//#if LATCHES
  private Latch minorLatch;
//#endif
//#if MEMORYBUDGET
  private boolean updateMemoryUsage;
//#endif
  INList(  EnvironmentImpl envImpl){
    this.envImpl=envImpl;
    ins=new TreeSet();
//#if LATCHES
    addedINs=new HashSet();
//#endif
//#if LATCHES
    majorLatch=LatchSupport.makeLatch(DEBUG_NAME + " Major Latch",envImpl);
//#endif
//#if LATCHES
    minorLatch=LatchSupport.makeLatch(DEBUG_NAME + " Minor Latch",envImpl);
//#endif
//#if MEMORYBUDGET
    updateMemoryUsage=true;
//#endif
  }
  /** 
 * Used only by tree verifier when validating INList. Must be called with
 * orig.majorLatch acquired.
 */
  public INList(  INList orig,  EnvironmentImpl envImpl) throws DatabaseException {
    ins=new TreeSet(orig.getINs());
//#if LATCHES
    addedINs=new HashSet();
//#endif
    this.envImpl=envImpl;
//#if LATCHES
    majorLatch=LatchSupport.makeLatch(DEBUG_NAME + " Major Latch",envImpl);
//#endif
//#if LATCHES
    minorLatch=LatchSupport.makeLatch(DEBUG_NAME + " Minor Latch",envImpl);
//#endif
//#if MEMORYBUDGET
    updateMemoryUsage=false;
//#endif
  }
  public SortedSet getINs(){
    return ins;
  }
  public int getSize(){
    return ins.size();
  }
  /** 
 * An IN has just come into memory, add it to the list.
 */
  public void add(  IN in) throws DatabaseException {
//#if LATCHES
    boolean enteredWithLatchHeld=majorLatch.isOwner();
//#endif
    boolean addToMajor=true;
//#if LATCHES
    try {
//#if LATCHES
      if (enteredWithLatchHeld) 
//#if LATCHES
{
        addToMajor=false;
      }
//#endif
 else 
//#if LATCHES
{
        if (!(majorLatch.acquireNoWait())) {
          addToMajor=false;
        }
      }
//#endif
//#endif
//#if LATCHES
      if (addToMajor) {
        addAndSetMemory(ins,in);
      }
 else 
//#if LATCHES
{
        minorLatch.acquire();
        try {
          addAndSetMemory(addedINs,in);
        }
  finally {
          minorLatch.release();
        }
        if (!enteredWithLatchHeld) {
          if (majorLatch.acquireNoWait()) {
            try {
              latchMinorAndDumpAddedINs();
            }
  finally {
              releaseMajorLatch();
            }
          }
        }
      }
//#endif
//#endif
    }
  finally {
      if (addToMajor) {
        releaseMajorLatchIfHeld();
      }
    }
//#endif
  }
  private void addAndSetMemory(  Set set,  IN in){
    boolean addOk=set.add(in);
    assert addOk : "failed adding in " + in.getNodeId();
//#if MEMORYBUDGET
    if (updateMemoryUsage) 
//#if MEMORYBUDGET
{
//#if MEMORYBUDGET
      MemoryBudget mb=envImpl.getMemoryBudget();
//#endif
//#if MEMORYBUDGET
      mb.updateTreeMemoryUsage(in.getInMemorySize());
//#endif
      in.setInListResident(true);
    }
//#endif
//#endif
  }
  /** 
 * An IN is getting evicted or is displaced by recovery.  Caller is
 * responsible for acquiring the major latch before calling this and
 * releasing it when they're done.
 */
  public void removeLatchAlreadyHeld(  IN in) throws DatabaseException {
//#if LATCHES
    assert majorLatch.isOwner();
//#endif
    boolean removeDone=ins.remove(in);
//#if LATCHES
    if (!removeDone) 
//#if LATCHES
{
//#if LATCHES
      minorLatch.acquire();
//#endif
//#if LATCHES
      try {
        removeDone=addedINs.remove(in);
        dumpAddedINsIntoMajorSet();
      }
  finally {
        minorLatch.release();
      }
//#endif
    }
//#endif
//#endif
    assert removeDone;
//#if MEMORYBUDGET
    if (updateMemoryUsage) 
//#if MEMORYBUDGET
{
      envImpl.getMemoryBudget().updateTreeMemoryUsage(in.getAccumulatedDelta() - in.getInMemorySize());
      in.setInListResident(false);
    }
//#endif
//#endif
  }
  /** 
 * An IN is getting swept or is displaced by recovery.
 */
  public void remove(  IN in) throws DatabaseException {
//#if LATCHES
    assert LatchSupport.countLatchesHeld() == 0;
//#endif
//#if LATCHES
    majorLatch.acquire();
//#endif
//#if LATCHES
    try {
      removeLatchAlreadyHeld(in);
    }
  finally {
      releaseMajorLatch();
    }
//#endif
  }
  public SortedSet tailSet(  IN in) throws DatabaseException {
//#if LATCHES
    assert majorLatch.isOwner();
//#endif
    return ins.tailSet(in);
  }
  public IN first() throws DatabaseException {
//#if LATCHES
    assert majorLatch.isOwner();
//#endif
    return (IN)ins.first();
  }
  /** 
 * Return an iterator over the main 'ins' set.  Returned iterator will not
 * show the elements in addedINs.
 * The major latch should be held before entering.  The caller is
 * responsible for releasing the major latch when they're finished with the
 * iterator.
 * @return an iterator over the main 'ins' set.
 */
  public Iterator iterator(){
//#if LATCHES
    assert majorLatch.isOwner();
//#endif
    return ins.iterator();
  }
  /** 
 * Clear the entire list during recovery and at shutdown.
 */
  public void clear() throws DatabaseException {
//#if LATCHES
    assert LatchSupport.countLatchesHeld() == 0;
//#endif
//#if LATCHES
    majorLatch.acquire();
//#endif
//#if LATCHES
    minorLatch.acquire();
//#endif
    ins.clear();
//#if LATCHES
    addedINs.clear();
//#endif
//#if LATCHES
    minorLatch.release();
//#endif
//#if LATCHES
    releaseMajorLatch();
//#endif
//#if MEMORYBUDGET
    if (updateMemoryUsage) 
//#if MEMORYBUDGET
{
      envImpl.getMemoryBudget().refreshTreeMemoryUsage(0);
    }
//#endif
//#endif
  }
  public void dump(){
    System.out.println("size=" + getSize());
    Iterator iter=ins.iterator();
    while (iter.hasNext()) {
      IN theIN=(IN)iter.next();
      System.out.println("db=" + theIN.getDatabase().getId() + " nid=: "+ theIN.getNodeId()+ "/"+ theIN.getLevel());
    }
  }
//#if LATCHES
  /** 
 * The locking hierarchy is:
 * 1. INList major latch.
 * 2. IN latch.
 * In other words, the INList major latch must be taken before any IN
 * latches to avoid deadlock. 
 */
  
//#if LATCHES
public
//#endif
 
//#if LATCHES
void
//#endif
 
//#if LATCHES
latchMajor
//#endif
() throws 
//#if LATCHES
DatabaseException
//#endif
 
//#if LATCHES
{
    assert LatchSupport.countLatchesHeld() == 0;
    majorLatch.acquire();
  }
//#endif
//#endif
//#if LATCHES
  public void releaseMajorLatchIfHeld() throws DatabaseException {
    if (majorLatch.isOwner()) {
      releaseMajorLatch();
    }
  }
//#endif
//#if LATCHES
  public void releaseMajorLatch() throws DatabaseException {
    latchMinorAndDumpAddedINs();
    majorLatch.release();
  }
//#endif
//#if LATCHES
  private void dumpAddedINsIntoMajorSet(){
    if (addedINs.size() > 0) {
      ins.addAll(addedINs);
      addedINs.clear();
    }
  }
//#endif
//#if LATCHES
  void latchMinorAndDumpAddedINs() throws DatabaseException {
    latchMinor();
    try {
      dumpAddedINsIntoMajorSet();
    }
  finally {
      releaseMinorLatch();
    }
  }
//#endif
//#if LATCHES
  private void latchMinor() throws DatabaseException {
    minorLatch.acquire();
  }
//#endif
//#if LATCHES
  private void releaseMinorLatch() throws DatabaseException {
    minorLatch.release();
  }
//#endif
}
