/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.txn.LockGrantType;
import com.sleepycat.je.txn.LockResult;
import com.sleepycat.je.txn.WriteLockInfo;

@RunWith(EvoSuiteRunner.class)
public class TestLockResult_3 {


  //Test case number: 3
  /*
   * 26 covered goals:
   * 1 Weak Mutation 23: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:33 - ReplaceComparisonOperator == -> >=
   * 2 Weak Mutation 27: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:34 - InsertUnaryOp Negation
   * 3 Weak Mutation 26: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:34 - DeleteField: infoLcom/sleepycat/je/txn/WriteLockInfo;
   * 4 Weak Mutation 29: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - InsertUnaryOp Negation
   * 5 Weak Mutation 28: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - DeleteField: infoLcom/sleepycat/je/txn/WriteLockInfo;
   * 6 Weak Mutation 31: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 30: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - InsertUnaryOp IINC 1
   * 8 com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V: I14 Branch 3 IFEQ L33 - false
   * 9 Weak Mutation 7: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp Negation
   * 10 Weak Mutation 8: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp Negation
   * 11 Weak Mutation 9: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 10: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 11: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp Negation
   * 14 Weak Mutation 7: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp Negation
   * 15 Weak Mutation 8: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp Negation
   * 16 Weak Mutation 9: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 10: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 11: com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V:29 - InsertUnaryOp Negation
   * 19 Weak Mutation 23: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:33 - ReplaceComparisonOperator == -> >=
   * 20 Weak Mutation 27: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:34 - InsertUnaryOp Negation
   * 21 Weak Mutation 26: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:34 - DeleteField: infoLcom/sleepycat/je/txn/WriteLockInfo;
   * 22 Weak Mutation 29: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - InsertUnaryOp Negation
   * 23 Weak Mutation 28: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - DeleteField: infoLcom/sleepycat/je/txn/WriteLockInfo;
   * 24 Weak Mutation 31: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 30: com.sleepycat.je.txn.LockResult.setAbortLsnInternal(JZZ)V:35 - InsertUnaryOp IINC 1
   * 26 com.sleepycat.je.txn.LockResult.setAbortLsn(JZZ)V: root-Branch
   */
  @Test
  public void test3()  throws Throwable  {
      LockGrantType lockGrantType0 = LockGrantType.WAIT_PROMOTION;
      WriteLockInfo writeLockInfo0 = new WriteLockInfo();
      LockResult lockResult0 = new LockResult(lockGrantType0, writeLockInfo0);
      lockResult0.setAbortLsn(0L, true, false);
      assertEquals(false, writeLockInfo0.neverLocked);
      assertEquals(0L, writeLockInfo0.getAbortLsn());
  }
}
