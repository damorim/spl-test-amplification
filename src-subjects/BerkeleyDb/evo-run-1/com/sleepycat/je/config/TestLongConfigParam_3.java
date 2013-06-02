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
public class TestLongConfigParam_3 {


  //Test case number: 3
  /*
   * 9 covered goals:
   * 1 Weak Mutation 28: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:22 - ReplaceComparisonOperator <= -> ==
   * 2 Weak Mutation 1: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:16 - DeleteField: minLjava/lang/Long;
   * 3 Weak Mutation 3: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:17 - DeleteField: minLjava/lang/Long;
   * 4 Weak Mutation 4: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:17 - DeleteStatement: compareTo(Ljava/lang/Long;)I
   * 5 Weak Mutation 6: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:17 - ReplaceComparisonOperator >= -> >
   * 6 Weak Mutation 24: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:21 - DeleteField: maxLjava/lang/Long;
   * 7 Weak Mutation 27: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:22 - DeleteStatement: compareTo(Ljava/lang/Long;)I
   * 8 Weak Mutation 26: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:22 - DeleteField: maxLjava/lang/Long;
   * 9 Weak Mutation 28: com.sleepycat.je.config.LongConfigParam.validate(Ljava/lang/Long;)V:22 - ReplaceComparisonOperator <= -> ==
   */
  @Test
  public void test3()  throws Throwable  {
      LongConfigParam longConfigParam0 = new LongConfigParam("o", (Long) 4L, (Long) 500000L, (Long) 4L, true, "o");
      longConfigParam0.validate();
      assertEquals("o", longConfigParam0.getName());
  }
}