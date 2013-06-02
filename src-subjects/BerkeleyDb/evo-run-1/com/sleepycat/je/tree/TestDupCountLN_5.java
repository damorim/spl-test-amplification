/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.tree.DupCountLN;

@RunWith(EvoSuiteRunner.class)
public class TestDupCountLN_5 {


  //Test case number: 5
  /*
   * 22 covered goals:
   * 1 Weak Mutation 47: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - ReplaceComparisonOperator >= -> ==
   * 2 Weak Mutation 53: com.sleepycat.je.tree.DupCountLN.decDupCount()I:40 - DeleteField: dupCountI
   * 3 Weak Mutation 31: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - InsertUnaryOp Negation
   * 4 Weak Mutation 34: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - DeleteField: dupCountI
   * 5 Weak Mutation 35: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 32: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - InsertUnaryOp +1
   * 7 Weak Mutation 33: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - InsertUnaryOp -1
   * 8 Weak Mutation 38: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> /
   * 9 Weak Mutation 39: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> *
   * 10 Weak Mutation 36: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> +
   * 11 Weak Mutation 37: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> %
   * 12 Weak Mutation 42: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - ReplaceComparisonOperator != -> ==
   * 13 Weak Mutation 43: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp Negation
   * 14 Weak Mutation 40: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp Negation
   * 15 Weak Mutation 46: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - DeleteField: dupCountI
   * 16 Weak Mutation 44: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp +1
   * 17 Weak Mutation 45: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp -1
   * 18 Weak Mutation 51: com.sleepycat.je.tree.DupCountLN.decDupCount()I:40 - InsertUnaryOp +1
   * 19 Weak Mutation 50: com.sleepycat.je.tree.DupCountLN.decDupCount()I:40 - InsertUnaryOp Negation
   * 20 Weak Mutation 52: com.sleepycat.je.tree.DupCountLN.decDupCount()I:40 - InsertUnaryOp -1
   * 21 Weak Mutation 47: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - ReplaceComparisonOperator >= -> ==
   * 22 Weak Mutation 53: com.sleepycat.je.tree.DupCountLN.decDupCount()I:40 - DeleteField: dupCountI
   */
  @Test
  public void test5()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN(5);
      int int0 = dupCountLN0.decDupCount();
      assertEquals(4, dupCountLN0.getDupCount());
      assertEquals(4, int0);
  }
}