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
public class TestDupCountLN_4 {


  //Test case number: 4
  /*
   * 20 covered goals:
   * 1 Weak Mutation 31: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - InsertUnaryOp Negation
   * 2 Weak Mutation 35: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 32: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - InsertUnaryOp +1
   * 4 Weak Mutation 33: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - InsertUnaryOp -1
   * 5 Weak Mutation 38: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> /
   * 6 Weak Mutation 39: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> *
   * 7 Weak Mutation 36: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> +
   * 8 Weak Mutation 37: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> %
   * 9 Weak Mutation 42: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - ReplaceComparisonOperator != -> ==
   * 10 Weak Mutation 43: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp Negation
   * 11 Weak Mutation 40: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp Negation
   * 12 Weak Mutation 46: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - DeleteField: dupCountI
   * 13 Weak Mutation 44: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp +1
   * 14 Weak Mutation 45: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - InsertUnaryOp -1
   * 15 Weak Mutation 49: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - ReplaceComparisonOperator >= -> -1
   * 16 com.sleepycat.je.tree.DupCountLN.decDupCount()I: I11 Branch 3 IFNE L39 - false
   * 17 com.sleepycat.je.tree.DupCountLN.decDupCount()I: I14 Branch 4 IFGE L39 - false
   * 18 Weak Mutation 37: com.sleepycat.je.tree.DupCountLN.decDupCount()I:38 - ReplaceArithmeticOperator - -> %
   * 19 Weak Mutation 46: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - DeleteField: dupCountI
   * 20 Weak Mutation 49: com.sleepycat.je.tree.DupCountLN.decDupCount()I:39 - ReplaceComparisonOperator >= -> -1
   */
  @Test
  public void test4()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN();
      // Undeclared exception!
      try {
        dupCountLN0.decDupCount();
        fail("Expecting exception: AssertionError");
      } catch(AssertionError e) {
      }
  }
}
