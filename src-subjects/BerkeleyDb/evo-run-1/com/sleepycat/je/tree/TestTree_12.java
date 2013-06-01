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
public class TestTree_12 {


  //Test case number: 12
  /*
   * 13 covered goals:
   * 1 Weak Mutation 137: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - -1 -> -2
   * 2 Weak Mutation 136: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - -1 -> 1
   * 3 Weak Mutation 139: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - DeleteStatement: search([BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;
   * 4 Weak Mutation 138: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 135: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - -1 -> 0
   * 6 Weak Mutation 134: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - DeleteField: RIGHTLcom/sleepycat/je/tree/Tree$SearchType;
   * 7 com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;: root-Branch
   * 8 Weak Mutation 137: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - -1 -> -2
   * 9 Weak Mutation 136: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - -1 -> 1
   * 10 Weak Mutation 139: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - DeleteStatement: search([BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;
   * 11 Weak Mutation 138: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - 1 -> 0
   * 12 Weak Mutation 135: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - ReplaceConstant - -1 -> 0
   * 13 Weak Mutation 134: com.sleepycat.je.tree.Tree.getLastNode()Lcom/sleepycat/je/tree/IN;:543 - DeleteField: RIGHTLcom/sleepycat/je/tree/Tree$SearchType;
   */
  @Test
  public void test12()  throws Throwable  {
      Tree tree0 = new Tree();
      // Undeclared exception!
      try {
        tree0.getLastNode();
        fail("Expecting exception: RuntimeException");
      } catch(RuntimeException e) {
        /*
         * TYPE ERROR?
         */
      }
  }
}
