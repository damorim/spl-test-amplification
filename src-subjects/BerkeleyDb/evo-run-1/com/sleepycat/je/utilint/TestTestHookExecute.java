/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.utilint.TestHook;
import com.sleepycat.je.utilint.TestHookExecute;

@RunWith(EvoSuiteRunner.class)
public class TestTestHookExecute {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.utilint.TestHookExecute.doHookIfSet(Lcom/sleepycat/je/utilint/TestHook;)Z:6 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 2: com.sleepycat.je.utilint.TestHookExecute.doHookIfSet(Lcom/sleepycat/je/utilint/TestHook;)Z:9 - ReplaceConstant - 1 -> 0
   * 3 com.sleepycat.je.utilint.TestHookExecute.doHookIfSet(Lcom/sleepycat/je/utilint/TestHook;)Z: I3 Branch 1 IFNULL L6 - true
   * 4 Weak Mutation 0: com.sleepycat.je.utilint.TestHookExecute.doHookIfSet(Lcom/sleepycat/je/utilint/TestHook;)Z:6 - ReplaceComparisonOperator = null -> != null
   * 5 Weak Mutation 2: com.sleepycat.je.utilint.TestHookExecute.doHookIfSet(Lcom/sleepycat/je/utilint/TestHook;)Z:9 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test0()  throws Throwable  {
      boolean boolean0 = TestHookExecute.doHookIfSet((TestHook) null);
      assertEquals(true, boolean0);
  }
}