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
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.BINBoundary;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.CursorsExistException;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.NodeNotEmptyException;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeLocation;
import com.sleepycat.je.tree.TreeStats;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import com.sleepycat.je.tree.WithRootLatched;
import java.util.List;

@RunWith(EvoSuiteRunner.class)
public class TestTree_23 {


  //Test case number: 23
  /*
   * 10 covered goals:
   * 1 Weak Mutation 362: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1184 - ReplaceComparisonOperator != -> -1
   * 2 com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;: I32 Branch 57 IFNE L1184 - false
   * 3 Weak Mutation 351: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1178 - DeleteField: LEFTLcom/sleepycat/je/tree/Tree$SearchType;
   * 4 Weak Mutation 357: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1184 - DeleteStatement: getNodeId()J
   * 5 Weak Mutation 358: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1184 - InsertUnaryOp Negation
   * 6 Weak Mutation 359: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1184 - DeleteStatement: longSub(JJ)I
   * 7 Weak Mutation 352: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1178 - ReplaceComparisonOperator == -> !=
   * 8 Weak Mutation 353: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1178 - DeleteField: RIGHTLcom/sleepycat/je/tree/Tree$SearchType;
   * 9 Weak Mutation 354: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1178 - ReplaceComparisonOperator != -> ==
   * 10 Weak Mutation 362: com.sleepycat.je.tree.Tree.searchSubTree(Lcom/sleepycat/je/tree/IN;[BLcom/sleepycat/je/tree/Tree$SearchType;JLcom/sleepycat/je/tree/BINBoundary;Z)Lcom/sleepycat/je/tree/IN;:1184 - ReplaceComparisonOperator != -> -1
   */
  @Test
  public void test23()  throws Throwable  {
      Tree tree0 = new Tree();
      DBIN dBIN0 = new DBIN();
      byte[] byteArray0 = new byte[8];
      Tree.SearchType tree_SearchType0 = Tree.SearchType.NORMAL;
      BINBoundary bINBoundary0 = new BINBoundary();
      tree0.searchSubTree((IN) dBIN0, byteArray0, tree_SearchType0, (long) 0, bINBoundary0, false);
      assertEquals(101909L, dBIN0.getLastId());
      assertEquals(101909L, dBIN0.getNextNodeId());
  }
}
