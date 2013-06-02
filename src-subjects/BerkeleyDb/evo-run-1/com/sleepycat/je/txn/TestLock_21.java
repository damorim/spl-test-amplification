/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.txn.Lock;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;
import java.util.List;
import java.util.Set;

@RunWith(EvoSuiteRunner.class)
public class TestLock_21 {


  //Test case number: 21
  /*
   * 7 covered goals:
   * 1 com.sleepycat.je.txn.Lock.isOwnedWriteLock(Lcom/sleepycat/je/txn/Locker;)Z: I13 Branch 33 IFEQ L255 - true
   * 2 Weak Mutation 103: com.sleepycat.je.txn.Lock.isOwnedWriteLock(Lcom/sleepycat/je/txn/Locker;)Z:255 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 108: com.sleepycat.je.txn.Lock.isOwnedWriteLock(Lcom/sleepycat/je/txn/Locker;)Z:255 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 106: com.sleepycat.je.txn.Lock.isOwnedWriteLock(Lcom/sleepycat/je/txn/Locker;)Z:255 - ReplaceComparisonOperator == -> !=
   * 5 Weak Mutation 104: com.sleepycat.je.txn.Lock.isOwnedWriteLock(Lcom/sleepycat/je/txn/Locker;)Z:255 - DeleteStatement: getLockType()Lcom/sleepycat/je/txn/LockType;
   * 6 Weak Mutation 105: com.sleepycat.je.txn.Lock.isOwnedWriteLock(Lcom/sleepycat/je/txn/Locker;)Z:255 - DeleteStatement: isWriteLock()Z
   * 7 Weak Mutation 108: com.sleepycat.je.txn.Lock.isOwnedWriteLock(Lcom/sleepycat/je/txn/Locker;)Z:255 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test21()  throws Throwable  {
      Lock lock0 = new Lock((Long) (-308L));
      LockType lockType0 = LockType.RANGE_READ;
      LockGrantType lockGrantType0 = lock0.lock(lockType0, (Locker) null, false, (MemoryBudget) null, 0);
      assertNotNull(lockGrantType0);
      
      boolean boolean0 = lock0.isOwnedWriteLock((Locker) null);
      assertEquals(1, lock0.nOwners());
      assertEquals(false, boolean0);
  }
}