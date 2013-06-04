/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.config.ConfigParam;

@RunWith(EvoSuiteRunner.class)
public class TestConfigParam_0 {


  //Test case number: 0
  /*
   * 18 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.je.config.ConfigParam.getDescription()Ljava/lang/String;:27 - DeleteField: descriptionLjava/lang/String;
   * 2 com.sleepycat.je.config.ConfigParam.getDescription()Ljava/lang/String;: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.je.config.ConfigParam.<init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V:17 - InsertUnaryOp Negation
   * 4 Weak Mutation 1: com.sleepycat.je.config.ConfigParam.<init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V:17 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 2: com.sleepycat.je.config.ConfigParam.<init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V:17 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 3: com.sleepycat.je.config.ConfigParam.<init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V:20 - DeleteStatement: validateValue(Ljava/lang/String;)V
   * 7 Weak Mutation 4: com.sleepycat.je.config.ConfigParam.<init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V:21 - DeleteStatement: addSupportedParam(Lcom/sleepycat/je/config/ConfigParam;)V
   * 8 Weak Mutation 5: com.sleepycat.je.config.ConfigParam.getName()Ljava/lang/String;:24 - DeleteField: nameLjava/lang/String;
   * 9 Weak Mutation 6: com.sleepycat.je.config.ConfigParam.getDescription()Ljava/lang/String;:27 - DeleteField: descriptionLjava/lang/String;
   * 10 Weak Mutation 13: com.sleepycat.je.config.ConfigParam.validateName(Ljava/lang/String;)V:46 - ReplaceComparisonOperator = null -> != null
   * 11 Weak Mutation 14: com.sleepycat.je.config.ConfigParam.validateName(Ljava/lang/String;)V:46 - DeleteStatement: length()I
   * 12 Weak Mutation 15: com.sleepycat.je.config.ConfigParam.validateName(Ljava/lang/String;)V:46 - ReplaceConstant - 1 -> 0
   * 13 Weak Mutation 16: com.sleepycat.je.config.ConfigParam.validateName(Ljava/lang/String;)V:46 - ReplaceComparisonOperator >= -> <
   * 14 com.sleepycat.je.config.ConfigParam.validateValue(Ljava/lang/String;)V: root-Branch
   * 15 com.sleepycat.je.config.ConfigParam.getName()Ljava/lang/String;: root-Branch
   * 16 com.sleepycat.je.config.ConfigParam.<init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V: root-Branch
   * 17 com.sleepycat.je.config.ConfigParam.validateName(Ljava/lang/String;)V: I3 Branch 1 IFNULL L46 - false
   * 18 com.sleepycat.je.config.ConfigParam.validateName(Ljava/lang/String;)V: I7 Branch 2 IF_ICMPGE L46 - true
   */
  @Test
  public void test0()  throws Throwable  {
      ConfigParam configParam0 = new ConfigParam(";", ";", true, ";");
      assertNotNull(configParam0);
      
      String string0 = configParam0.getDescription();
      assertNotNull(string0);
      assertEquals(true, configParam0.isMutable());
  }
}
