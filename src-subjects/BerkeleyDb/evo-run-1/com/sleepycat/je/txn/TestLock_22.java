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
public class TestLock_22 {


  //Test case number: 22
  /*
   * 34 covered goals:
   * 1 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I221 Branch 107 IFEQ L496 - false
   * 2 Weak Mutation 144: com.sleepycat.je.txn.Lock.nOwners()I:290 - DeleteField: firstOwnerLcom/sleepycat/je/txn/LockInfo;
   * 3 Weak Mutation 221: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:440 - DeleteStatement: getLocker()Lcom/sleepycat/je/txn/Locker;
   * 4 Weak Mutation 222: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:441 - DeleteStatement: getLockType()Lcom/sleepycat/je/txn/LockType;
   * 5 Weak Mutation 223: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:444 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 214: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:436 - ReplaceComparisonOperator != -> <
   * 7 Weak Mutation 231: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:452 - DeleteField: firstOwnerLcom/sleepycat/je/txn/LockInfo;
   * 8 Weak Mutation 230: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:451 - ReplaceComparisonOperator = null -> != null
   * 9 Weak Mutation 229: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:451 - DeleteField: firstOwnerLcom/sleepycat/je/txn/LockInfo;
   * 10 Weak Mutation 226: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:448 - ReplaceComparisonOperator = null -> != null
   * 11 Weak Mutation 224: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:445 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 221: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:440 - DeleteStatement: getLocker()Lcom/sleepycat/je/txn/Locker;
   * 13 Weak Mutation 222: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:441 - DeleteStatement: getLockType()Lcom/sleepycat/je/txn/LockType;
   * 14 Weak Mutation 223: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:444 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 214: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:436 - ReplaceComparisonOperator != -> <
   * 16 Weak Mutation 231: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:452 - DeleteField: firstOwnerLcom/sleepycat/je/txn/LockInfo;
   * 17 Weak Mutation 230: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:451 - ReplaceComparisonOperator = null -> != null
   * 18 Weak Mutation 229: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:451 - DeleteField: firstOwnerLcom/sleepycat/je/txn/LockInfo;
   * 19 Weak Mutation 226: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:448 - ReplaceComparisonOperator = null -> != null
   * 20 Weak Mutation 224: com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;:445 - ReplaceConstant - 0 -> 1
   * 21 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I4 Branch 88 IFNE L436 - true
   * 22 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I54 Branch 89 IFNULL L448 - true
   * 23 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I65 Branch 90 IFNULL L451 - false
   * 24 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I88 Branch 93 IFNULL L457 - true
   * 25 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I88 Branch 93 IFNULL L457 - false
   * 26 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I103 Branch 94 IF_ACMPNE L460 - false
   * 27 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I107 Branch 95 IFNE L461 - false
   * 28 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I109 Branch 96 IFNULL L461 - true
   * 29 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I124 Branch 97 IFNONNULL L463 - true
   * 30 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I171 Branch 101 IFNULL L484 - true
   * 31 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I192 Branch 103 IFNULL L491 - false
   * 32 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I201 Branch 104 IFNE L493 - false
   * 33 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I203 Branch 105 IFNONNULL L493 - true
   * 34 com.sleepycat.je.txn.Lock.tryLock(Lcom/sleepycat/je/txn/LockInfo;ZLcom/sleepycat/je/dbi/MemoryBudget;I)Lcom/sleepycat/je/txn/LockGrantType;: I211 Branch 106 IFNE L494 - false
   */
  @Test
  public void test22()  throws Throwable  {
      Lock lock0 = new Lock((Long) (-308L));
      LockType lockType0 = LockType.RANGE_READ;
      LockGrantType lockGrantType0 = lock0.lock(lockType0, (Locker) null, false, (MemoryBudget) null, 1101);
      assertNotNull(lockGrantType0);
      
      LockType lockType1 = LockType.RANGE_WRITE;
      LockGrantType lockGrantType1 = lock0.lock(lockType1, (Locker) null, false, (MemoryBudget) null, 0);
      assertEquals(1, lock0.nOwners());
      assertNotSame(lockGrantType1, lockGrantType0);
  }
}
