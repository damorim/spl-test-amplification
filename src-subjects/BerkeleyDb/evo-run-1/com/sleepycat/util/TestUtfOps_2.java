/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.util.UtfOps;

@RunWith(EvoSuiteRunner.class)
public class TestUtfOps_2 {


  //Test case number: 2
  /*
   * 28 covered goals:
   * 1 Weak Mutation 19: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - ReplaceArithmeticOperator + -> -
   * 2 Weak Mutation 22: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - ReplaceArithmeticOperator + -> *
   * 3 Weak Mutation 32: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - ReplaceComparisonOperator >= -> ==
   * 4 Weak Mutation 12: com.sleepycat.util.UtfOps.getByteLength([CII)I:43 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 13: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - InsertUnaryOp Negation
   * 6 Weak Mutation 14: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 15: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - InsertUnaryOp IINC -1
   * 8 Weak Mutation 17: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 16: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - InsertUnaryOp Negation
   * 10 Weak Mutation 19: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - ReplaceArithmeticOperator + -> -
   * 11 Weak Mutation 18: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 21: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - ReplaceArithmeticOperator + -> /
   * 13 Weak Mutation 20: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - ReplaceArithmeticOperator + -> %
   * 14 Weak Mutation 23: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp Negation
   * 15 Weak Mutation 22: com.sleepycat.util.UtfOps.getByteLength([CII)I:44 - ReplaceArithmeticOperator + -> *
   * 16 Weak Mutation 25: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 24: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 27: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 26: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp Negation
   * 20 Weak Mutation 29: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp Negation
   * 21 Weak Mutation 28: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 31: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp IINC -1
   * 23 Weak Mutation 30: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - InsertUnaryOp IINC 1
   * 24 Weak Mutation 32: com.sleepycat.util.UtfOps.getByteLength([CII)I:45 - ReplaceComparisonOperator >= -> ==
   * 25 Weak Mutation 65: com.sleepycat.util.UtfOps.getByteLength([CII)I:57 - InsertUnaryOp Negation
   * 26 Weak Mutation 66: com.sleepycat.util.UtfOps.getByteLength([CII)I:57 - InsertUnaryOp IINC 1
   * 27 Weak Mutation 67: com.sleepycat.util.UtfOps.getByteLength([CII)I:57 - InsertUnaryOp IINC -1
   * 28 com.sleepycat.util.UtfOps.getByteLength([CII)I: I17 Branch 2 IF_ICMPGE L45 - true
   */
  @Test
  public void test2()  throws Throwable  {
      char[] charArray0 = new char[19];
      int int0 = UtfOps.getByteLength(charArray0, 63, (-760));
      assertEquals(0, int0);
  }
}