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
public class TestEnvironmentConfig_17 {


  //Test case number: 17
  /*
   * 5 covered goals:
   * 1 Weak Mutation 89: com.sleepycat.je.EnvironmentConfig.getCreateUP()Z:194 - InsertUnaryOp Negation
   * 2 Weak Mutation 90: com.sleepycat.je.EnvironmentConfig.getCreateUP()Z:194 - DeleteField: createUPZ
   * 3 com.sleepycat.je.EnvironmentConfig.getCreateUP()Z: root-Branch
   * 4 Weak Mutation 89: com.sleepycat.je.EnvironmentConfig.getCreateUP()Z:194 - InsertUnaryOp Negation
   * 5 Weak Mutation 90: com.sleepycat.je.EnvironmentConfig.getCreateUP()Z:194 - DeleteField: createUPZ
   */
  @Test
  public void test17()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      boolean boolean0 = environmentConfig0.getCreateUP();
      assertEquals(false, environmentConfig0.getAllowCreate());
      assertEquals(true, environmentConfig0.getCheckpointUP());
      assertEquals(false, environmentConfig0.getTxnReadCommitted());
      assertEquals(true, boolean0);
  }
}
