/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeStats;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import com.sleepycat.je.tree.WithRootLatched;

@RunWith(EvoSuiteRunner.class)
public class TestTree_7 {


  //Test case number: 7
  /*
   * 3 covered goals:
   * 1 Weak Mutation 31: com.sleepycat.je.tree.Tree.withRootLatchedExclusive(Lcom/sleepycat/je/tree/WithRootLatched;)Lcom/sleepycat/je/tree/IN;:241 - ReplaceConstant - TYPE ERROR? -> 
   * 2 com.sleepycat.je.tree.Tree.withRootLatchedExclusive(Lcom/sleepycat/je/tree/WithRootLatched;)Lcom/sleepycat/je/tree/IN;: root-Branch
   * 3 Weak Mutation 31: com.sleepycat.je.tree.Tree.withRootLatchedExclusive(Lcom/sleepycat/je/tree/WithRootLatched;)Lcom/sleepycat/je/tree/IN;:241 - ReplaceConstant - TYPE ERROR? -> 
   */
  @Test
  public void test7()  throws Throwable  {
      Tree tree0 = new Tree();
      // Undeclared exception!
      try {
        tree0.withRootLatchedExclusive((WithRootLatched) null);
        fail("Expecting exception: RuntimeException");
      } catch(RuntimeException e) {
        /*
         * TYPE ERROR?
         */
      }
  }
}
