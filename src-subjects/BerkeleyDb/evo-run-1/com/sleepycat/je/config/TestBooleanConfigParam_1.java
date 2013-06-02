/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.config.BooleanConfigParam;

@RunWith(EvoSuiteRunner.class)
public class TestBooleanConfigParam_1 {


  //Test case number: 1
  /*
   * 12 covered goals:
   * 1 Weak Mutation 13: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - ReplaceComparisonOperator > -> -2
   * 2 com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V: I13 Branch 2 IFGT L19 - true
   * 3 Weak Mutation 0: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteStatement: trim()Ljava/lang/String;
   * 4 Weak Mutation 1: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteField: FALSELjava/lang/Boolean;
   * 5 Weak Mutation 2: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteStatement: toString()Ljava/lang/String;
   * 6 Weak Mutation 3: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteStatement: StringEqualsIgnoreCase(Ljava/lang/String;Ljava/lang/String;)I
   * 7 Weak Mutation 4: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - ReplaceComparisonOperator > -> !=
   * 8 Weak Mutation 7: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteStatement: trim()Ljava/lang/String;
   * 9 Weak Mutation 8: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteField: TRUELjava/lang/Boolean;
   * 10 Weak Mutation 9: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteStatement: toString()Ljava/lang/String;
   * 11 Weak Mutation 10: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - DeleteStatement: StringEqualsIgnoreCase(Ljava/lang/String;Ljava/lang/String;)I
   * 12 Weak Mutation 13: com.sleepycat.je.config.BooleanConfigParam.validateValue(Ljava/lang/String;)V:19 - ReplaceComparisonOperator > -> -2
   */
  @Test
  public void test1()  throws Throwable  {
      BooleanConfigParam booleanConfigParam0 = new BooleanConfigParam("fal", true, true, "fal");
      assertEquals("fal", booleanConfigParam0.toString());
  }
}