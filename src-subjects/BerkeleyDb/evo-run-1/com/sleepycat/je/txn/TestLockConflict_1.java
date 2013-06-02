/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.txn.LockConflict;

@RunWith(EvoSuiteRunner.class)
public class TestLockConflict_1 {


  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 8: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - InsertUnaryOp Negation
   * 2 Weak Mutation 9: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - DeleteField: restartZ
   * 3 com.sleepycat.je.txn.LockConflict.getRestart()Z: root-Branch
   * 4 Weak Mutation 8: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - InsertUnaryOp Negation
   * 5 Weak Mutation 9: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - DeleteField: restartZ
   */
  @Test
  public void test1()  throws Throwable  {
      LockConflict lockConflict0 = LockConflict.RESTART;
      boolean boolean0 = lockConflict0.getRestart();
      assertEquals(true, boolean0);
  }
}