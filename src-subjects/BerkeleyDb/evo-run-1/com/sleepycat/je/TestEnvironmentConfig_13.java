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
public class TestEnvironmentConfig_13 {


  //Test case number: 13
  /*
   * 5 covered goals:
   * 1 Weak Mutation 76: com.sleepycat.je.EnvironmentConfig.getTxnReadCommitted()Z:171 - InsertUnaryOp Negation
   * 2 Weak Mutation 77: com.sleepycat.je.EnvironmentConfig.getTxnReadCommitted()Z:171 - DeleteField: txnReadCommittedZ
   * 3 com.sleepycat.je.EnvironmentConfig.getTxnReadCommitted()Z: root-Branch
   * 4 Weak Mutation 76: com.sleepycat.je.EnvironmentConfig.getTxnReadCommitted()Z:171 - InsertUnaryOp Negation
   * 5 Weak Mutation 77: com.sleepycat.je.EnvironmentConfig.getTxnReadCommitted()Z:171 - DeleteField: txnReadCommittedZ
   */
  @Test
  public void test13()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = EnvironmentConfig.DEFAULT;
      boolean boolean0 = environmentConfig0.getTxnReadCommitted();
      assertEquals(true, boolean0);
  }
}