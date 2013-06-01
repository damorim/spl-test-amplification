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
import java.util.ArrayList;
import java.util.List;

@RunWith(EvoSuiteRunner.class)
public class TestTree_25 {


  //Test case number: 25
  /*
   * 31 covered goals:
   * 1 Weak Mutation 590: com.sleepycat.je.tree.Tree.getLogSize()I:2123 - DeleteField: rootLcom/sleepycat/je/tree/ChildReference;
   * 2 Weak Mutation 593: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 592: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - InsertUnaryOp Negation
   * 4 Weak Mutation 595: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - DeleteField: rootLcom/sleepycat/je/tree/ChildReference;
   * 5 Weak Mutation 594: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 597: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> -
   * 7 Weak Mutation 596: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - DeleteStatement: getLogSize()I
   * 8 Weak Mutation 599: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> /
   * 9 Weak Mutation 598: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> %
   * 10 Weak Mutation 600: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> *
   * 11 com.sleepycat.je.tree.Tree.getLogSize()I: I8 Branch 133 IFNULL L2123 - false
   * 12 Weak Mutation 589: com.sleepycat.je.tree.Tree.getLogSize()I:2122 - DeleteStatement: getBooleanLogSize()I
   * 13 Weak Mutation 591: com.sleepycat.je.tree.Tree.getLogSize()I:2123 - ReplaceComparisonOperator = null -> != null
   * 14 Weak Mutation 601: com.sleepycat.je.tree.Tree.getLogSize()I:2126 - InsertUnaryOp Negation
   * 15 Weak Mutation 603: com.sleepycat.je.tree.Tree.getLogSize()I:2126 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 602: com.sleepycat.je.tree.Tree.getLogSize()I:2126 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 589: com.sleepycat.je.tree.Tree.getLogSize()I:2122 - DeleteStatement: getBooleanLogSize()I
   * 18 Weak Mutation 590: com.sleepycat.je.tree.Tree.getLogSize()I:2123 - DeleteField: rootLcom/sleepycat/je/tree/ChildReference;
   * 19 Weak Mutation 591: com.sleepycat.je.tree.Tree.getLogSize()I:2123 - ReplaceComparisonOperator = null -> != null
   * 20 Weak Mutation 593: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - InsertUnaryOp IINC 1
   * 21 Weak Mutation 592: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - InsertUnaryOp Negation
   * 22 Weak Mutation 595: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - DeleteField: rootLcom/sleepycat/je/tree/ChildReference;
   * 23 Weak Mutation 594: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 597: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> -
   * 25 Weak Mutation 596: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - DeleteStatement: getLogSize()I
   * 26 Weak Mutation 599: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> /
   * 27 Weak Mutation 598: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> %
   * 28 Weak Mutation 601: com.sleepycat.je.tree.Tree.getLogSize()I:2126 - InsertUnaryOp Negation
   * 29 Weak Mutation 600: com.sleepycat.je.tree.Tree.getLogSize()I:2124 - ReplaceArithmeticOperator + -> *
   * 30 Weak Mutation 603: com.sleepycat.je.tree.Tree.getLogSize()I:2126 - InsertUnaryOp IINC -1
   * 31 Weak Mutation 602: com.sleepycat.je.tree.Tree.getLogSize()I:2126 - InsertUnaryOp IINC 1
   */
  @Test
  public void test25()  throws Throwable  {
      Tree tree0 = new Tree();
      MapLN mapLN0 = new MapLN();
      byte[] byteArray0 = new byte[1];
      ChildReference childReference0 = tree0.makeRootChildReference((Node) mapLN0, byteArray0, 1115L);
      tree0.setRoot(childReference0);
      int int0 = tree0.getLogSize();
      assertEquals(1115L, tree0.getRootLsn());
      assertEquals(15, int0);
  }
}
