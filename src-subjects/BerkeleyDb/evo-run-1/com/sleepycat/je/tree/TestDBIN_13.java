/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DBINReference;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.TreeLocation;

@RunWith(EvoSuiteRunner.class)
public class TestDBIN_13 {


  //Test case number: 13
  /*
   * 15 covered goals:
   * 1 Weak Mutation 34: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 35: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - InsertUnaryOp Negation
   * 3 Weak Mutation 38: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - DeleteStatement: getNEntries()I
   * 4 Weak Mutation 36: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 37: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 40: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - ReplaceComparisonOperator >= -> >
   * 7 Weak Mutation 65: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:155 - ReplaceConstant - 0 -> 1
   * 8 com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z: I8 Branch 1 IF_ICMPGE L143 - true
   * 9 Weak Mutation 34: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - ReplaceConstant - 0 -> 1
   * 10 Weak Mutation 35: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - InsertUnaryOp Negation
   * 11 Weak Mutation 38: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - DeleteStatement: getNEntries()I
   * 12 Weak Mutation 36: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 37: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 40: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:143 - ReplaceComparisonOperator >= -> >
   * 15 Weak Mutation 65: com.sleepycat.je.tree.DBIN.matchLNByNodeId(Lcom/sleepycat/je/tree/TreeLocation;J)Z:155 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test13()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      TreeLocation treeLocation0 = new TreeLocation();
      boolean boolean0 = dBIN0.matchLNByNodeId(treeLocation0, (long) 0);
      assertEquals(4294970934L, dBIN0.getLastId());
      assertEquals(false, boolean0);
  }
}
