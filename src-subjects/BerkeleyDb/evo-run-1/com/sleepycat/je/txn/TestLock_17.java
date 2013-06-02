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
public class TestLock_17 {


  //Test case number: 17
  /*
   * 9 covered goals:
   * 1 Weak Mutation 352: com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;:709 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 356: com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;:712 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 358: com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;:715 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 362: com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;:718 - ReplaceComparisonOperator = null -> != null
   * 5 com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;: I12 Branch 160 IFNULL L709 - true
   * 6 com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;: I23 Branch 161 IFNULL L712 - true
   * 7 com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;: I33 Branch 162 IFNULL L715 - true
   * 8 com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;: I46 Branch 164 IFNULL L718 - true
   * 9 Weak Mutation 358: com.sleepycat.je.txn.Lock.getWriteOwnerLocker()Lcom/sleepycat/je/txn/Locker;:715 - ReplaceComparisonOperator = null -> != null
   */
  @Test
  public void test17()  throws Throwable  {
      Lock lock0 = new Lock((Long) (-308L));
      Locker locker0 = lock0.getWriteOwnerLocker();
      assertNull(locker0);
  }
}