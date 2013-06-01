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
public class TestDbLsn_13 {


  //Test case number: 13
  /*
   * 24 covered goals:
   * 1 Weak Mutation 163: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:88 - ReplaceComparisonOperator != -> -1
   * 2 Weak Mutation 165: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:89 - ReplaceConstant - 0 -> -1
   * 3 Weak Mutation 164: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:89 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 173: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:92 - ReplaceComparisonOperator != -> -1
   * 5 Weak Mutation 175: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - DeleteStatement: getFileOffset(J)J
   * 6 Weak Mutation 174: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - InsertUnaryOp Negation
   * 7 Weak Mutation 178: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - ReplaceArithmeticOperator - -> %
   * 8 Weak Mutation 176: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - InsertUnaryOp Negation
   * 9 Weak Mutation 177: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - DeleteStatement: getFileOffset(J)J
   * 10 Weak Mutation 182: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - DeleteStatement: abs(J)J
   * 11 Weak Mutation 180: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - ReplaceArithmeticOperator - -> /
   * 12 com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J: I26 Branch 9 IFNE L88 - false
   * 13 com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J: I41 Branch 10 IFNE L92 - false
   * 14 Weak Mutation 175: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - DeleteStatement: getFileOffset(J)J
   * 15 Weak Mutation 174: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - InsertUnaryOp Negation
   * 16 Weak Mutation 173: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:92 - ReplaceComparisonOperator != -> -1
   * 17 Weak Mutation 163: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:88 - ReplaceComparisonOperator != -> -1
   * 18 Weak Mutation 165: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:89 - ReplaceConstant - 0 -> -1
   * 19 Weak Mutation 164: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:89 - ReplaceConstant - 0 -> 1
   * 20 Weak Mutation 178: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - ReplaceArithmeticOperator - -> %
   * 21 Weak Mutation 176: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - InsertUnaryOp Negation
   * 22 Weak Mutation 177: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - DeleteStatement: getFileOffset(J)J
   * 23 Weak Mutation 182: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - DeleteStatement: abs(J)J
   * 24 Weak Mutation 180: com.sleepycat.je.utilint.DbLsn.getNoCleaningDistance(JJJ)J:93 - ReplaceArithmeticOperator - -> /
   */
  @Test
  public void test13()  throws Throwable  {
      long long0 = DbLsn.getNoCleaningDistance(361L, (-1L), 0L);
      assertEquals(361L, long0);
  }
}
