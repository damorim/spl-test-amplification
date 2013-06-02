/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogBuffer;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestLogBuffer_5 {


  //Test case number: 5
  /*
   * 21 covered goals:
   * 1 Weak Mutation 39: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator == -> >=
   * 2 Weak Mutation 47: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator > -> >=
   * 3 Weak Mutation 51: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 4 Weak Mutation 50: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: lastLsnJ
   * 5 Weak Mutation 49: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 6 Weak Mutation 54: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator < -> <=
   * 7 Weak Mutation 52: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: compareTo(JJ)I
   * 8 Weak Mutation 56: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:120 - ReplaceConstant - 1 -> 0
   * 9 Weak Mutation 59: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:123 - ReplaceConstant - 1 -> 0
   * 10 com.sleepycat.je.log.LogBuffer.containsLsn(J)Z: I15 Branch 3 IFGT L119 - false
   * 11 com.sleepycat.je.log.LogBuffer.containsLsn(J)Z: I20 Branch 4 IFLT L119 - false
   * 12 com.sleepycat.je.log.LogBuffer.containsLsn(J)Z: I28 Branch 5 IFEQ L122 - false
   * 13 Weak Mutation 39: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator == -> >=
   * 14 Weak Mutation 47: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator > -> >=
   * 15 Weak Mutation 51: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 16 Weak Mutation 50: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: lastLsnJ
   * 17 Weak Mutation 49: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 18 Weak Mutation 54: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator < -> <=
   * 19 Weak Mutation 52: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: compareTo(JJ)I
   * 20 Weak Mutation 59: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:123 - ReplaceConstant - 1 -> 0
   * 21 Weak Mutation 56: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:120 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test5()  throws Throwable  {
      LogBuffer logBuffer0 = new LogBuffer((ByteBuffer) null, 70L);
      boolean boolean0 = logBuffer0.containsLsn(70L);
      assertEquals(true, boolean0);
  }
}