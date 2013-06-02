/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.FileHeader;
import com.sleepycat.je.log.LogException;

@RunWith(EvoSuiteRunner.class)
public class TestFileHeader_4 {


  //Test case number: 4
  /*
   * 17 covered goals:
   * 1 Weak Mutation 40: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceComparisonOperator >= -> -1
   * 2 Weak Mutation 41: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceConstant - 1 -> 0
   * 3 com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z: I35 Branch 2 IF_ICMPGE L36 - false
   * 4 Weak Mutation 9: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:33 - InsertUnaryOp Negation
   * 5 Weak Mutation 11: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:33 - InsertUnaryOp Negation
   * 6 Weak Mutation 12: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:33 - DeleteStatement: longSub(JJ)I
   * 7 Weak Mutation 15: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:33 - ReplaceComparisonOperator == -> -2
   * 8 Weak Mutation 29: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - InsertUnaryOp Negation
   * 9 Weak Mutation 31: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - InsertUnaryOp -1
   * 10 Weak Mutation 30: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - InsertUnaryOp +1
   * 11 Weak Mutation 34: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceConstant - 3 -> 1
   * 12 Weak Mutation 35: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceConstant - 3 -> -1
   * 13 Weak Mutation 33: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceConstant - 3 -> 0
   * 14 Weak Mutation 36: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceConstant - 3 -> 2
   * 15 Weak Mutation 37: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceConstant - 3 -> 4
   * 16 Weak Mutation 40: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceComparisonOperator >= -> -1
   * 17 Weak Mutation 41: com.sleepycat.je.log.FileHeader.validate(Ljava/lang/String;J)Z:36 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test4()  throws Throwable  {
      FileHeader fileHeader0 = new FileHeader();
      boolean boolean0 = fileHeader0.validate("_.", 0L);
      assertEquals(true, boolean0);
  }
}