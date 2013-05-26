package com.sleepycat.je.tree;
import java.util.Iterator;
import java.util.NoSuchElementException;
import com.sleepycat.je.DatabaseException;
//#if LATCHES
import com.sleepycat.je.latch.LatchNotHeldException;
//#endif
/** 
 * TreeIterator implements an Iterator over Tree's.  Not protected
 * against insertions like cursors.
 */
public final class TreeIterator implements Iterator {
  private Tree tree;
  private BIN nextBin;
  private int index;
  public TreeIterator(  Tree tree) throws DatabaseException {
    nextBin=(BIN)tree.getFirstNode();
//#if LATCHES
    if (nextBin != null) 
//#if LATCHES
{
      nextBin.releaseLatch();
    }
//#endif
//#endif
    index=-1;
    this.tree=tree;
  }
  public boolean hasNext(){
    boolean ret=false;
    try {
//#if LATCHES
      if (nextBin != null) 
//#if LATCHES
{
        nextBin.latch();
      }
//#endif
//#endif
      advance();
      ret=(nextBin != null) && (index < nextBin.getNEntries());
    }
 catch (    DatabaseException e) {
    }
 finally {
//#if LATCHES
      try 
//#if LATCHES
{
        if (nextBin != null) {
          nextBin.releaseLatch();
        }
      }
//#endif
 catch (      LatchNotHeldException e) {
      }
//#endif
    }
    return ret;
  }
  public Object next(){
    Object ret=null;
    try {
      if (nextBin == null) {
        throw new NoSuchElementException();
      }
//#if LATCHES
      nextBin.latch();
//#endif
      ret=nextBin.getKey(index);
    }
 catch (    DatabaseException e) {
    }
 finally 
//#if LATCHES
{
      try {
        if (nextBin != null) {
          nextBin.releaseLatch();
        }
      }
 catch (      LatchNotHeldException e) {
      }
    }
//#endif
    return ret;
  }
  public void remove(){
    throw new UnsupportedOperationException();
  }
  private void advance() throws DatabaseException {
    while (nextBin != null) {
      if (++index < nextBin.getNEntries()) {
        return;
      }
      nextBin=tree.getNextBin(nextBin,false);
      index=-1;
    }
  }
}
