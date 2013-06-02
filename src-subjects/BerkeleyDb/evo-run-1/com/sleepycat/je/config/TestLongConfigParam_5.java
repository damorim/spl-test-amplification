/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.config.LongConfigParam;

@RunWith(EvoSuiteRunner.class)
public class TestLongConfigParam_5 {


  //Test case number: 5
  /*
   * 37 covered goals:
   * 1 Weak Mutation 59: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:38 - DeleteField: minLjava/lang/Long;
   * 2 Weak Mutation 60: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:38 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 63: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteField: minLjava/lang/Long;
   * 4 Weak Mutation 62: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 5 Weak Mutation 61: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - ReplaceConstant - # minimum =  -> 
   * 6 Weak Mutation 64: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 65: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:41 - DeleteField: maxLjava/lang/Long;
   * 8 Weak Mutation 66: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:41 - ReplaceComparisonOperator = null -> != null
   * 9 Weak Mutation 68: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:42 - ReplaceComparisonOperator = null -> != null
   * 10 Weak Mutation 67: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:42 - DeleteField: minLjava/lang/Long;
   * 11 Weak Mutation 69: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:43 - ReplaceConstant - 
 -> 
   * 12 Weak Mutation 70: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:43 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 13 Weak Mutation 71: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - ReplaceConstant - # maximum =  -> 
   * 14 Weak Mutation 72: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 15 Weak Mutation 73: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteField: maxLjava/lang/Long;
   * 16 Weak Mutation 74: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 75: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:47 - DeleteStatement: toString()Ljava/lang/String;
   * 18 com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;: I10 Branch 6 IFNULL L38 - false
   * 19 com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;: I24 Branch 7 IFNULL L41 - false
   * 20 com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;: I29 Branch 8 IFNULL L42 - false
   * 21 Weak Mutation 59: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:38 - DeleteField: minLjava/lang/Long;
   * 22 Weak Mutation 63: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteField: minLjava/lang/Long;
   * 23 Weak Mutation 62: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 24 Weak Mutation 61: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - ReplaceConstant - # minimum =  -> 
   * 25 Weak Mutation 60: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:38 - ReplaceComparisonOperator = null -> != null
   * 26 Weak Mutation 68: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:42 - ReplaceComparisonOperator = null -> != null
   * 27 Weak Mutation 69: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:43 - ReplaceConstant - 
 -> 
   * 28 Weak Mutation 70: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:43 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 29 Weak Mutation 71: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - ReplaceConstant - # maximum =  -> 
   * 30 Weak Mutation 64: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 31 Weak Mutation 65: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:41 - DeleteField: maxLjava/lang/Long;
   * 32 Weak Mutation 66: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:41 - ReplaceComparisonOperator = null -> != null
   * 33 Weak Mutation 67: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:42 - DeleteField: minLjava/lang/Long;
   * 34 Weak Mutation 72: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 35 Weak Mutation 73: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteField: maxLjava/lang/Long;
   * 36 Weak Mutation 74: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 37 Weak Mutation 75: com.sleepycat.je.config.LongConfigParam.getExtraDescription()Ljava/lang/String;:47 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test5()  throws Throwable  {
      Long long0 = new Long((-1L));
      LongConfigParam longConfigParam0 = new LongConfigParam("w ", (Long) 0L, long0, long0, true, "w ");
      assertNotNull(longConfigParam0);
      
      String string0 = longConfigParam0.getExtraDescription();
      assertNotNull(string0);
      assertEquals("# minimum = 0\n# maximum = -1", string0);
  }
}