/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.compat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.compat.DbCompat;
import com.sleepycat.je.EnvironmentConfig;

@RunWith(EvoSuiteRunner.class)
public class TestDbCompat_0 {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.compat.DbCompat.getInitializeLocking(Lcom/sleepycat/je/EnvironmentConfig;)Z:41 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.compat.DbCompat.getInitializeLocking(Lcom/sleepycat/je/EnvironmentConfig;)Z: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.compat.DbCompat.getInitializeLocking(Lcom/sleepycat/je/EnvironmentConfig;)Z:41 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test0()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      boolean boolean0 = DbCompat.getInitializeLocking(environmentConfig0);
      assertEquals(true, boolean0);
  }
}