/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;

@RunWith(EvoSuiteRunner.class)
public class TestIN_30 {


  //Test case number: 30
  /*
   * 8 covered goals:
   * 1 Weak Mutation 743: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - InsertUnaryOp IINC -1
   * 2 Weak Mutation 742: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 741: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - InsertUnaryOp Negation
   * 4 Weak Mutation 740: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - DeleteField: entryStates[B
   * 5 Weak Mutation 743: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 742: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 741: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - InsertUnaryOp Negation
   * 8 Weak Mutation 740: com.sleepycat.je.tree.IN.isEntryPendingDeleted(I)Z:640 - DeleteField: entryStates[B
   */
  @Test
  public void test30()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      assertNotNull(dBIN0);
      
      // Undeclared exception!
      try {
        dBIN0.isEntryPendingDeleted(11);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      } catch(ArrayIndexOutOfBoundsException e) {
        /*
         * 11
         */
      }
  }
}
