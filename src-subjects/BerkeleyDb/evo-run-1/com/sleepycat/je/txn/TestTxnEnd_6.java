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
public class TestTxnEnd_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 35: com.sleepycat.je.txn.TxnEnd.readFromLog(Ljava/nio/ByteBuffer;B)V:73 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   * 2 com.sleepycat.je.txn.TxnEnd.readFromLog(Ljava/nio/ByteBuffer;B)V: root-Branch
   * 3 Weak Mutation 35: com.sleepycat.je.txn.TxnEnd.readFromLog(Ljava/nio/ByteBuffer;B)V:73 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   */
  @Test
  public void test6()  throws Throwable  {
      TxnCommit txnCommit0 = new TxnCommit(1855L, 1855L);
      // Undeclared exception!
      try {
        txnCommit0.readFromLog((ByteBuffer) null, (byte) (-25));
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}