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
public class TestEnvironmentConfig_12 {


  //Test case number: 12
  /*
   * 7 covered goals:
   * 1 Weak Mutation 73: com.sleepycat.je.EnvironmentConfig.setTxnReadCommitted(Z)V:165 - InsertUnaryOp Negation
   * 2 Weak Mutation 74: com.sleepycat.je.EnvironmentConfig.setTxnReadCommitted(Z)V:165 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 75: com.sleepycat.je.EnvironmentConfig.setTxnReadCommitted(Z)V:165 - InsertUnaryOp IINC -1
   * 4 com.sleepycat.je.EnvironmentConfig.setTxnReadCommitted(Z)V: root-Branch
   * 5 Weak Mutation 73: com.sleepycat.je.EnvironmentConfig.setTxnReadCommitted(Z)V:165 - InsertUnaryOp Negation
   * 6 Weak Mutation 74: com.sleepycat.je.EnvironmentConfig.setTxnReadCommitted(Z)V:165 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 75: com.sleepycat.je.EnvironmentConfig.setTxnReadCommitted(Z)V:165 - InsertUnaryOp IINC -1
   */
  @Test
  public void test12()  throws Throwable  {
      Properties properties0 = new Properties();
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig(properties0);
      assertEquals(false, environmentConfig0.getTxnReadCommitted());
      
      environmentConfig0.setTxnReadCommitted(true);
      assertEquals(true, environmentConfig0.getTxnReadCommitted());
      assertEquals(true, environmentConfig0.getCreateUP());
  }
}
