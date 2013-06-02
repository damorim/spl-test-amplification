/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.txn.Lock;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import java.util.List;
import java.util.Set;

@RunWith(EvoSuiteRunner.class)
public class TestLock_9 {


  //Test case number: 9
  /*
   * 7 covered goals:
   * 1 Weak Mutation 102: com.sleepycat.je.txn.Lock.isOwner(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)Z:247 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.txn.Lock.isOwner(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)Z: I9 Branch 29 IFNULL L237 - true
   * 3 Weak Mutation 94: com.sleepycat.je.txn.Lock.isOwner(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)Z:237 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 86: com.sleepycat.je.txn.Lock.getOwnerLockInfo(Lcom/sleepycat/je/txn/Locker;)Lcom/sleepycat/je/txn/LockInfo;:219 - ReplaceComparisonOperator = null -> != null
   * 5 Weak Mutation 102: com.sleepycat.je.txn.Lock.isOwner(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)Z:247 - ReplaceConstant - 0 -> 1
   * 6 com.sleepycat.je.txn.Lock.getOwnerLockInfo(Lcom/sleepycat/je/txn/Locker;)Lcom/sleepycat/je/txn/LockInfo;: I4 Branch 24 IFNULL L216 - true
   * 7 com.sleepycat.je.txn.Lock.getOwnerLockInfo(Lcom/sleepycat/je/txn/Locker;)Lcom/sleepycat/je/txn/LockInfo;: I19 Branch 26 IFNULL L219 - true
   */
  @Test
  public void test9()  throws Throwable  {
      Lock lock0 = new Lock();
      LockType lockType0 = LockType.RANGE_INSERT;
      boolean boolean0 = lock0.isOwner((Locker) null, lockType0);
      assertEquals(false, boolean0);
  }
}