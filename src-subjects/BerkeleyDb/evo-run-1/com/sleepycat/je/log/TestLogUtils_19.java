/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.LogUtils;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import javax.transaction.xa.Xid;

@RunWith(EvoSuiteRunner.class)
public class TestLogUtils_19 {


  //Test case number: 19
  /*
   * 49 covered goals:
   * 1 Weak Mutation 920: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:249 - DeleteStatement: getGlobalTransactionId()[B
   * 2 Weak Mutation 921: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:250 - DeleteStatement: getBranchQualifier()[B
   * 3 Weak Mutation 937: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> /
   * 4 Weak Mutation 936: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> %
   * 5 Weak Mutation 938: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> *
   * 6 Weak Mutation 933: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceComparisonOperator != null -> = null
   * 7 Weak Mutation 932: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> *
   * 8 Weak Mutation 935: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> -
   * 9 Weak Mutation 929: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> -
   * 10 Weak Mutation 931: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> /
   * 11 Weak Mutation 930: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> %
   * 12 Weak Mutation 926: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 7
   * 13 Weak Mutation 927: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceComparisonOperator != null -> = null
   * 14 Weak Mutation 924: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> -1
   * 15 Weak Mutation 925: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 5
   * 16 Weak Mutation 922: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 0
   * 17 Weak Mutation 923: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 1
   * 18 Weak Mutation 0: com.sleepycat.je.log.LogUtils$XidImpl.<init>(I[B[B)V:293 - InsertUnaryOp Negation
   * 19 Weak Mutation 1: com.sleepycat.je.log.LogUtils$XidImpl.<init>(I[B[B)V:293 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 2: com.sleepycat.je.log.LogUtils$XidImpl.<init>(I[B[B)V:293 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 7: com.sleepycat.je.log.LogUtils$XidImpl.getGlobalTransactionId()[B:301 - DeleteField: gid[B
   * 22 Weak Mutation 8: com.sleepycat.je.log.LogUtils$XidImpl.getBranchQualifier()[B:304 - DeleteField: bqual[B
   * 23 com.sleepycat.je.log.LogUtils$XidImpl.getBranchQualifier()[B: root-Branch
   * 24 com.sleepycat.je.log.LogUtils$XidImpl.getGlobalTransactionId()[B: root-Branch
   * 25 com.sleepycat.je.log.LogUtils$XidImpl.<init>(I[B[B)V: root-Branch
   * 26 com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I: I14 Branch 21 IFNONNULL L251 - true
   * 27 com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I: I23 Branch 22 IFNONNULL L251 - true
   * 28 Weak Mutation 0: com.sleepycat.je.log.LogUtils$XidImpl.<init>(I[B[B)V:293 - InsertUnaryOp Negation
   * 29 Weak Mutation 1: com.sleepycat.je.log.LogUtils$XidImpl.<init>(I[B[B)V:293 - InsertUnaryOp IINC 1
   * 30 Weak Mutation 2: com.sleepycat.je.log.LogUtils$XidImpl.<init>(I[B[B)V:293 - InsertUnaryOp IINC -1
   * 31 Weak Mutation 7: com.sleepycat.je.log.LogUtils$XidImpl.getGlobalTransactionId()[B:301 - DeleteField: gid[B
   * 32 Weak Mutation 8: com.sleepycat.je.log.LogUtils$XidImpl.getBranchQualifier()[B:304 - DeleteField: bqual[B
   * 33 Weak Mutation 937: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> /
   * 34 Weak Mutation 936: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> %
   * 35 Weak Mutation 938: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> *
   * 36 Weak Mutation 933: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceComparisonOperator != null -> = null
   * 37 Weak Mutation 932: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> *
   * 38 Weak Mutation 935: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> -
   * 39 Weak Mutation 929: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> -
   * 40 Weak Mutation 931: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> /
   * 41 Weak Mutation 930: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceArithmeticOperator + -> %
   * 42 Weak Mutation 926: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 7
   * 43 Weak Mutation 927: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceComparisonOperator != null -> = null
   * 44 Weak Mutation 924: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> -1
   * 45 Weak Mutation 925: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 5
   * 46 Weak Mutation 922: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 0
   * 47 Weak Mutation 923: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:251 - ReplaceConstant - 6 -> 1
   * 48 Weak Mutation 920: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:249 - DeleteStatement: getGlobalTransactionId()[B
   * 49 Weak Mutation 921: com.sleepycat.je.log.LogUtils.getXidSize(Ljavax/transaction/xa/Xid;)I:250 - DeleteStatement: getBranchQualifier()[B
   */
  @Test
  public void test19()  throws Throwable  {
      byte[] byteArray0 = new byte[7];
      LogUtils.XidImpl logUtils_XidImpl0 = new LogUtils.XidImpl(8, byteArray0, byteArray0);
      int int0 = LogUtils.getXidSize((Xid) logUtils_XidImpl0);
      assertEquals(20, int0);
      assertEquals("<Xid formatId=\"8\" gTxnId=\"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\" bqual=\"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\"/>", logUtils_XidImpl0.toString());
  }
}
