/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.txn.TxnPrepare;
import java.nio.ByteBuffer;
import javax.transaction.xa.Xid;

@RunWith(EvoSuiteRunner.class)
public class TestTxnPrepare_4 {


  //Test case number: 4
  /*
   * 7 covered goals:
   * 1 Weak Mutation 19: com.sleepycat.je.txn.TxnPrepare.writeToLog(Ljava/nio/ByteBuffer;)V:45 - InsertUnaryOp Negation
   * 2 Weak Mutation 21: com.sleepycat.je.txn.TxnPrepare.writeToLog(Ljava/nio/ByteBuffer;)V:45 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   * 3 Weak Mutation 20: com.sleepycat.je.txn.TxnPrepare.writeToLog(Ljava/nio/ByteBuffer;)V:45 - DeleteField: idJ
   * 4 com.sleepycat.je.txn.TxnPrepare.writeToLog(Ljava/nio/ByteBuffer;)V: root-Branch
   * 5 Weak Mutation 19: com.sleepycat.je.txn.TxnPrepare.writeToLog(Ljava/nio/ByteBuffer;)V:45 - InsertUnaryOp Negation
   * 6 Weak Mutation 21: com.sleepycat.je.txn.TxnPrepare.writeToLog(Ljava/nio/ByteBuffer;)V:45 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   * 7 Weak Mutation 20: com.sleepycat.je.txn.TxnPrepare.writeToLog(Ljava/nio/ByteBuffer;)V:45 - DeleteField: idJ
   */
  @Test
  public void test4()  throws Throwable  {
      byte[] byteArray0 = new byte[14];
      LogUtils.XidImpl logUtils_XidImpl0 = new LogUtils.XidImpl(1, byteArray0, byteArray0);
      TxnPrepare txnPrepare0 = new TxnPrepare((-1423L), (Xid) logUtils_XidImpl0);
      // Undeclared exception!
      try {
        txnPrepare0.writeToLog((ByteBuffer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
