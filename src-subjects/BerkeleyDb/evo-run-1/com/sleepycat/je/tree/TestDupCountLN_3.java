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
public class TestDupCountLN_3 {


  //Test case number: 3
  /*
   * 18 covered goals:
   * 1 Weak Mutation 14: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - ReplaceArithmeticOperator + -> %
   * 2 Weak Mutation 23: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - DeleteField: dupCountI
   * 3 Weak Mutation 26: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - ReplaceComparisonOperator >= -> -1
   * 4 com.sleepycat.je.tree.DupCountLN.incDupCount()I: I14 Branch 2 IFGE L34 - false
   * 5 Weak Mutation 8: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - InsertUnaryOp Negation
   * 6 Weak Mutation 9: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - InsertUnaryOp +1
   * 7 Weak Mutation 10: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - InsertUnaryOp -1
   * 8 Weak Mutation 11: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - DeleteField: dupCountI
   * 9 Weak Mutation 12: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - ReplaceConstant - 1 -> 0
   * 10 Weak Mutation 13: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - ReplaceArithmeticOperator + -> -
   * 11 Weak Mutation 15: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - ReplaceArithmeticOperator + -> /
   * 12 Weak Mutation 17: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - InsertUnaryOp Negation
   * 13 Weak Mutation 16: com.sleepycat.je.tree.DupCountLN.incDupCount()I:33 - ReplaceArithmeticOperator + -> *
   * 14 Weak Mutation 19: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - ReplaceComparisonOperator != -> ==
   * 15 Weak Mutation 21: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - InsertUnaryOp +1
   * 16 Weak Mutation 20: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - InsertUnaryOp Negation
   * 17 Weak Mutation 22: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - InsertUnaryOp -1
   * 18 Weak Mutation 26: com.sleepycat.je.tree.DupCountLN.incDupCount()I:34 - ReplaceComparisonOperator >= -> -1
   */
  @Test
  public void test3()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN((-1151));
      // Undeclared exception!
      try {
        dupCountLN0.incDupCount();
        fail("Expecting exception: AssertionError");
      } catch(AssertionError e) {
      }
  }
}