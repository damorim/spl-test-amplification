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
import com.sleepycat.je.tree.MapLN;
import java.util.Set;

@RunWith(EvoSuiteRunner.class)
public class TestLogEntryType_27 {


  //Test case number: 27
  /*
   * 15 covered goals:
   * 1 Weak Mutation 158: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp Negation
   * 2 Weak Mutation 159: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - DeleteField: typeNumB
   * 3 Weak Mutation 162: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 161: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 160: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp Negation
   * 6 Weak Mutation 167: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 164: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - ReplaceComparisonOperator != -> <
   * 8 com.sleepycat.je.log.LogEntryType.equalsType(BB)Z: I5 Branch 9 IF_ICMPNE L164 - true
   * 9 Weak Mutation 158: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp Negation
   * 10 Weak Mutation 159: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - DeleteField: typeNumB
   * 11 Weak Mutation 162: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 161: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 160: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - InsertUnaryOp Negation
   * 14 Weak Mutation 167: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 164: com.sleepycat.je.log.LogEntryType.equalsType(BB)Z:164 - ReplaceComparisonOperator != -> <
   */
  @Test
  public void test27()  throws Throwable  {
      LogEntryType logEntryType0 = LogEntryType.LOG_IN_DELETE_INFO;
      boolean boolean0 = logEntryType0.equalsType((byte)0, (byte) (-1));
      assertEquals(false, boolean0);
  }
}
