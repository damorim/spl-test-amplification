/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.utilint.DbLsn;

@RunWith(EvoSuiteRunner.class)
public class TestDbLsn_7 {


  //Test case number: 7
  /*
   * 14 covered goals:
   * 1 Weak Mutation 85: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceComparisonOperator != -> -1
   * 2 com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I: I9 Branch 5 IFNE L55 - false
   * 3 Weak Mutation 70: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - InsertUnaryOp Negation
   * 4 Weak Mutation 71: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 0
   * 5 Weak Mutation 76: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceComparisonOperator == -> <=
   * 6 Weak Mutation 78: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - InsertUnaryOp Negation
   * 7 Weak Mutation 79: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 0
   * 8 Weak Mutation 72: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 1
   * 9 Weak Mutation 73: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> -2
   * 10 Weak Mutation 74: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - DeleteStatement: longSub(JJ)I
   * 11 Weak Mutation 81: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> -2
   * 12 Weak Mutation 80: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 1
   * 13 Weak Mutation 82: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - DeleteStatement: longSub(JJ)I
   * 14 Weak Mutation 85: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceComparisonOperator != -> -1
   */
  @Test
  public void test7()  throws Throwable  {
      // Undeclared exception!
      try {
        DbLsn.compareTo((-258L), (-1L));
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}