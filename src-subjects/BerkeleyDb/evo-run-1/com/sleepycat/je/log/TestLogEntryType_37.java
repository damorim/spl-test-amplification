/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.SingleItemLogEntry;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.INDupDeleteInfo;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.txn.TxnAbort;
import java.util.Set;

@RunWith(EvoSuiteRunner.class)
public class TestLogEntryType_37 {


  //Test case number: 37
  /*
   * 17 covered goals:
   * 1 Weak Mutation 188: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - ReplaceComparisonOperator != -> -1
   * 2 Weak Mutation 189: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - ReplaceConstant - 1 -> 0
   * 3 com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z: I25 Branch 13 IF_ICMPNE L176 - false
   * 4 Weak Mutation 13: com.sleepycat.je.log.LogEntryType.<init>(BB)V:75 - InsertUnaryOp Negation
   * 5 Weak Mutation 14: com.sleepycat.je.log.LogEntryType.<init>(BB)V:75 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 15: com.sleepycat.je.log.LogEntryType.<init>(BB)V:75 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 17: com.sleepycat.je.log.LogEntryType.<init>(BB)V:76 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 16: com.sleepycat.je.log.LogEntryType.<init>(BB)V:76 - InsertUnaryOp Negation
   * 9 Weak Mutation 18: com.sleepycat.je.log.LogEntryType.<init>(BB)V:76 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 184: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - InsertUnaryOp Negation
   * 11 Weak Mutation 185: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - DeleteField: typeNumB
   * 12 Weak Mutation 178: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:170 - ReplaceComparisonOperator != -> ==
   * 13 Weak Mutation 182: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - InsertUnaryOp Negation
   * 14 Weak Mutation 183: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - DeleteField: typeNumB
   * 15 Weak Mutation 180: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:173 - ReplaceComparisonOperator != -> ==
   * 16 Weak Mutation 188: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - ReplaceComparisonOperator != -> -1
   * 17 Weak Mutation 189: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:176 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test37()  throws Throwable  {
      LogEntryType logEntryType0 = new LogEntryType((byte)108, (byte)108);
      LogEntryType logEntryType1 = new LogEntryType((byte)108, (byte)108);
      boolean boolean0 = logEntryType1.equals((Object) logEntryType0);
      assertEquals("null/108", logEntryType0.toString());
      assertEquals(true, boolean0);
      assertEquals(108, logEntryType0.getTypeNum());
  }
}
