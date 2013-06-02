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
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;

@RunWith(EvoSuiteRunner.class)
public class TestDBIN_17 {


  //Test case number: 17
  /*
   * 25 covered goals:
   * 1 Weak Mutation 127: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - DeleteField: dupKey[B
   * 2 Weak Mutation 126: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - InsertUnaryOp IINC -1
   * 3 Weak Mutation 125: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 124: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - InsertUnaryOp Negation
   * 5 Weak Mutation 129: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> -
   * 6 Weak Mutation 128: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - DeleteStatement: getByteArrayLogSize([B)I
   * 7 Weak Mutation 131: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> /
   * 8 Weak Mutation 130: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> %
   * 9 Weak Mutation 132: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> *
   * 10 Weak Mutation 133: com.sleepycat.je.tree.DBIN.getLogSize()I:197 - InsertUnaryOp Negation
   * 11 Weak Mutation 135: com.sleepycat.je.tree.DBIN.getLogSize()I:197 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 134: com.sleepycat.je.tree.DBIN.getLogSize()I:197 - InsertUnaryOp IINC 1
   * 13 com.sleepycat.je.tree.DBIN.getLogSize()I: root-Branch
   * 14 Weak Mutation 127: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - DeleteField: dupKey[B
   * 15 Weak Mutation 126: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 125: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 124: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - InsertUnaryOp Negation
   * 18 Weak Mutation 129: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> -
   * 19 Weak Mutation 128: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - DeleteStatement: getByteArrayLogSize([B)I
   * 20 Weak Mutation 131: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> /
   * 21 Weak Mutation 130: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> %
   * 22 Weak Mutation 133: com.sleepycat.je.tree.DBIN.getLogSize()I:197 - InsertUnaryOp Negation
   * 23 Weak Mutation 132: com.sleepycat.je.tree.DBIN.getLogSize()I:196 - ReplaceArithmeticOperator + -> *
   * 24 Weak Mutation 135: com.sleepycat.je.tree.DBIN.getLogSize()I:197 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 134: com.sleepycat.je.tree.DBIN.getLogSize()I:197 - InsertUnaryOp IINC 1
   */
  @Test
  public void test17()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      byte[] byteArray0 = new byte[4];
      DBIN dBIN0 = new DBIN(databaseImpl0, byteArray0, (int) (byte)0, byteArray0, (-1245));
      int int0 = dBIN0.getLogSize();
      assertEquals(4294971429L, databaseImpl0.getEofNodeId());
      assertEquals(42, int0);
  }
}