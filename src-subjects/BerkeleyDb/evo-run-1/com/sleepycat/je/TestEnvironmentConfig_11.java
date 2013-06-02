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
public class TestEnvironmentConfig_11 {


  //Test case number: 11
  /*
   * 9 covered goals:
   * 1 Weak Mutation 69: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:158 - DeleteField: TXN_SERIALIZABLE_ISOLATIONLcom/sleepycat/je/config/BooleanConfigParam;
   * 2 Weak Mutation 70: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:158 - DeleteStatement: getVal(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 3 Weak Mutation 71: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:159 - DeleteStatement: valueOf(Ljava/lang/String;)Ljava/lang/Boolean;
   * 4 Weak Mutation 72: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:159 - DeleteStatement: booleanValue()Z
   * 5 com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z: root-Branch
   * 6 Weak Mutation 69: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:158 - DeleteField: TXN_SERIALIZABLE_ISOLATIONLcom/sleepycat/je/config/BooleanConfigParam;
   * 7 Weak Mutation 70: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:158 - DeleteStatement: getVal(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 8 Weak Mutation 71: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:159 - DeleteStatement: valueOf(Ljava/lang/String;)Ljava/lang/Boolean;
   * 9 Weak Mutation 72: com.sleepycat.je.EnvironmentConfig.getTxnSerializableIsolation()Z:159 - DeleteStatement: booleanValue()Z
   */
  @Test
  public void test11()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      environmentConfig0.getTxnSerializableIsolation();
      assertEquals(false, environmentConfig0.getTxnReadCommitted());
      assertEquals("allowCreate=false\n{}", environmentConfig0.toString());
      assertEquals(true, environmentConfig0.getCreateUP());
      assertEquals(true, environmentConfig0.getCheckpointUP());
  }
}