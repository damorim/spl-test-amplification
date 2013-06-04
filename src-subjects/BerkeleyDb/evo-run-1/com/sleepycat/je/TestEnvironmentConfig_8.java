/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.EnvironmentConfig;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestEnvironmentConfig_8 {


  //Test case number: 8
  /*
   * 9 covered goals:
   * 1 Weak Mutation 44: com.sleepycat.je.EnvironmentConfig.getLocking()Z:121 - DeleteField: ENV_INIT_LOCKINGLcom/sleepycat/je/config/BooleanConfigParam;
   * 2 Weak Mutation 45: com.sleepycat.je.EnvironmentConfig.getLocking()Z:121 - DeleteStatement: getVal(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 3 Weak Mutation 46: com.sleepycat.je.EnvironmentConfig.getLocking()Z:122 - DeleteStatement: valueOf(Ljava/lang/String;)Ljava/lang/Boolean;
   * 4 Weak Mutation 47: com.sleepycat.je.EnvironmentConfig.getLocking()Z:122 - DeleteStatement: booleanValue()Z
   * 5 com.sleepycat.je.EnvironmentConfig.getLocking()Z: root-Branch
   * 6 Weak Mutation 46: com.sleepycat.je.EnvironmentConfig.getLocking()Z:122 - DeleteStatement: valueOf(Ljava/lang/String;)Ljava/lang/Boolean;
   * 7 Weak Mutation 47: com.sleepycat.je.EnvironmentConfig.getLocking()Z:122 - DeleteStatement: booleanValue()Z
   * 8 Weak Mutation 44: com.sleepycat.je.EnvironmentConfig.getLocking()Z:121 - DeleteField: ENV_INIT_LOCKINGLcom/sleepycat/je/config/BooleanConfigParam;
   * 9 Weak Mutation 45: com.sleepycat.je.EnvironmentConfig.getLocking()Z:121 - DeleteStatement: getVal(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   */
  @Test
  public void test8()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = EnvironmentConfig.DEFAULT;
      boolean boolean0 = environmentConfig0.getLocking();
      assertEquals(false, boolean0);
  }
}
