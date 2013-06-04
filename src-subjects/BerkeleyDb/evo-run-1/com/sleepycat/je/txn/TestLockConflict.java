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
public class TestLockConflict {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.txn.LockConflict.getAllowed()Z:28 - DeleteField: allowedZ
   * 2 Weak Mutation 8: com.sleepycat.je.txn.LockConflict.getAllowed()Z:28 - InsertUnaryOp Negation
   * 3 Weak Mutation 8: com.sleepycat.je.txn.LockConflict.getAllowed()Z:28 - InsertUnaryOp Negation
   * 4 Weak Mutation 9: com.sleepycat.je.txn.LockConflict.getAllowed()Z:28 - DeleteField: allowedZ
   * 5 com.sleepycat.je.txn.LockConflict.getAllowed()Z: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      LockConflict lockConflict0 = LockConflict.ALLOW;
      boolean boolean0 = lockConflict0.getAllowed();
      assertEquals(true, boolean0);
  }

  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 10: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - InsertUnaryOp Negation
   * 2 Weak Mutation 11: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - DeleteField: restartZ
   * 3 com.sleepycat.je.txn.LockConflict.getRestart()Z: root-Branch
   * 4 Weak Mutation 10: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - InsertUnaryOp Negation
   * 5 Weak Mutation 11: com.sleepycat.je.txn.LockConflict.getRestart()Z:39 - DeleteField: restartZ
   */
  @Test
  public void test1()  throws Throwable  {
      LockConflict lockConflict0 = LockConflict.RESTART;
      boolean boolean0 = lockConflict0.getRestart();
      assertEquals(true, boolean0);
  }
}