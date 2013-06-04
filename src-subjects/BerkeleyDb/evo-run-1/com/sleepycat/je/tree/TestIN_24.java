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
public class TestIN_24 {


  //Test case number: 24
  /*
   * 11 covered goals:
   * 1 Weak Mutation 305: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - InsertUnaryOp Negation
   * 2 Weak Mutation 304: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - DeleteField: entryStates[B
   * 3 Weak Mutation 307: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 306: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - InsertUnaryOp IINC 1
   * 5 com.sleepycat.je.tree.IN.setMigrate(IZ)V: I3 Branch 11 IFEQ L436 - false
   * 6 Weak Mutation 302: com.sleepycat.je.tree.IN.setMigrate(IZ)V:436 - InsertUnaryOp Negation
   * 7 Weak Mutation 303: com.sleepycat.je.tree.IN.setMigrate(IZ)V:436 - ReplaceComparisonOperator == -> !=
   * 8 Weak Mutation 305: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - InsertUnaryOp Negation
   * 9 Weak Mutation 304: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - DeleteField: entryStates[B
   * 10 Weak Mutation 307: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 306: com.sleepycat.je.tree.IN.setMigrate(IZ)V:437 - InsertUnaryOp IINC 1
   */
  @Test
  public void test24()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      assertNotNull(dBIN0);
      
      // Undeclared exception!
      try {
        dBIN0.setMigrate(0, true);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      } catch(ArrayIndexOutOfBoundsException e) {
        /*
         * 0
         */
      }
  }
}
