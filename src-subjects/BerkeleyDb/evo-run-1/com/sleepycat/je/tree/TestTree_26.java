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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@RunWith(EvoSuiteRunner.class)
public class TestTree_26 {


  //Test case number: 26
  /*
   * 7 covered goals:
   * 1 Weak Mutation 608: com.sleepycat.je.tree.Tree.writeToLog(Ljava/nio/ByteBuffer;)V:2132 - DeleteStatement: writeBoolean(Ljava/nio/ByteBuffer;Z)V
   * 2 Weak Mutation 605: com.sleepycat.je.tree.Tree.writeToLog(Ljava/nio/ByteBuffer;)V:2132 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 607: com.sleepycat.je.tree.Tree.writeToLog(Ljava/nio/ByteBuffer;)V:2132 - ReplaceConstant - 0 -> 1
   * 4 com.sleepycat.je.tree.Tree.writeToLog(Ljava/nio/ByteBuffer;)V: I5 Branch 134 IFNULL L2132 - true
   * 5 Weak Mutation 608: com.sleepycat.je.tree.Tree.writeToLog(Ljava/nio/ByteBuffer;)V:2132 - DeleteStatement: writeBoolean(Ljava/nio/ByteBuffer;Z)V
   * 6 Weak Mutation 605: com.sleepycat.je.tree.Tree.writeToLog(Ljava/nio/ByteBuffer;)V:2132 - ReplaceComparisonOperator = null -> != null
   * 7 Weak Mutation 607: com.sleepycat.je.tree.Tree.writeToLog(Ljava/nio/ByteBuffer;)V:2132 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test26()  throws Throwable  {
      Tree tree0 = new Tree();
      // Undeclared exception!
      try {
        tree0.writeToLog((ByteBuffer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
