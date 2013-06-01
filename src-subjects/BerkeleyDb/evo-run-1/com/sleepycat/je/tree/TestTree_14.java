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
import com.sleepycat.je.tree.CursorsExistException;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.NodeNotEmptyException;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeStats;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import com.sleepycat.je.tree.WithRootLatched;

@RunWith(EvoSuiteRunner.class)
public class TestTree_14 {


  //Test case number: 14
  /*
   * 5 covered goals:
   * 1 Weak Mutation 148: com.sleepycat.je.tree.Tree.getLastNode(Lcom/sleepycat/je/tree/DIN;)Lcom/sleepycat/je/tree/DBIN;:566 - ReplaceComparisonOperator != null -> = null
   * 2 Weak Mutation 149: com.sleepycat.je.tree.Tree.getLastNode(Lcom/sleepycat/je/tree/DIN;)Lcom/sleepycat/je/tree/DBIN;:567 - ReplaceConstant - getLastNode passed null root -> 
   * 3 com.sleepycat.je.tree.Tree.getLastNode(Lcom/sleepycat/je/tree/DIN;)Lcom/sleepycat/je/tree/DBIN;: I3 Branch 25 IFNONNULL L566 - false
   * 4 Weak Mutation 148: com.sleepycat.je.tree.Tree.getLastNode(Lcom/sleepycat/je/tree/DIN;)Lcom/sleepycat/je/tree/DBIN;:566 - ReplaceComparisonOperator != null -> = null
   * 5 Weak Mutation 149: com.sleepycat.je.tree.Tree.getLastNode(Lcom/sleepycat/je/tree/DIN;)Lcom/sleepycat/je/tree/DBIN;:567 - ReplaceConstant - getLastNode passed null root -> 
   */
  @Test
  public void test14()  throws Throwable  {
      Tree tree0 = new Tree();
      // Undeclared exception!
      try {
        tree0.getLastNode((DIN) null);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * getLastNode passed null root
         */
      }
  }
}
