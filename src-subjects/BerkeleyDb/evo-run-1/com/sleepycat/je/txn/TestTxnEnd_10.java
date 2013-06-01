/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.txn.TxnAbort;
import com.sleepycat.je.txn.TxnCommit;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestTxnEnd_10 {


  //Test case number: 10
  /*
   * 4 covered goals:
   * 1 com.sleepycat.je.txn.TxnEnd.postLogWork(J)V: root-Branch
   * 2 Weak Mutation 0: com.sleepycat.je.txn.TxnEnd.<init>(JJ)V:17 - InsertUnaryOp Negation
   * 3 Weak Mutation 1: com.sleepycat.je.txn.TxnEnd.<init>(JJ)V:18 - DeleteStatement: currentTimeMillis()J
   * 4 Weak Mutation 2: com.sleepycat.je.txn.TxnEnd.<init>(JJ)V:19 - InsertUnaryOp Negation
   */
  @Test
  public void test10()  throws Throwable  {
      TxnCommit txnCommit0 = new TxnCommit(1855L, 1855L);
      txnCommit0.postLogWork(1855L);
      assertEquals(1855L, txnCommit0.getLastLsn());
      assertEquals(1855L, txnCommit0.getTransactionId());
      assertEquals(1855L, txnCommit0.getId());
  }
}
