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
public class TestLock_11 {


  //Test case number: 11
  /*
   * 8 covered goals:
   * 1 Weak Mutation 110: com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z:262 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 116: com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z:267 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 125: com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z:276 - ReplaceConstant - 0 -> 1
   * 4 com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z: I4 Branch 34 IFNULL L262 - true
   * 5 com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z: I20 Branch 36 IFNULL L267 - true
   * 6 Weak Mutation 110: com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z:262 - ReplaceComparisonOperator = null -> != null
   * 7 Weak Mutation 116: com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z:267 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 125: com.sleepycat.je.txn.Lock.isWaiter(Lcom/sleepycat/je/txn/Locker;)Z:276 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test11()  throws Throwable  {
      Lock lock0 = new Lock((Long) (-308L));
      boolean boolean0 = lock0.isWaiter((Locker) null);
      assertEquals(false, boolean0);
  }
}