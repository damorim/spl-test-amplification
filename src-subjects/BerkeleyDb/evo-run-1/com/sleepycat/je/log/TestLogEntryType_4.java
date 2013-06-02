/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.BIN;

@RunWith(EvoSuiteRunner.class)
public class TestLogEntryType_4 {


  //Test case number: 4
  /*
   * 19 covered goals:
   * 1 Weak Mutation 34: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - InsertUnaryOp Negation
   * 2 Weak Mutation 35: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - DeleteField: typeNumB
   * 3 Weak Mutation 38: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> -1
   * 4 Weak Mutation 39: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 14
   * 5 Weak Mutation 36: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 0
   * 6 Weak Mutation 37: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 1
   * 7 Weak Mutation 42: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceComparisonOperator > -> !=
   * 8 Weak Mutation 40: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 16
   * 9 Weak Mutation 44: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 1 -> 0
   * 10 com.sleepycat.je.log.LogEntryType.isNodeType()Z: I5 Branch 2 IF_ICMPGT L89 - false
   * 11 Weak Mutation 34: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - InsertUnaryOp Negation
   * 12 Weak Mutation 35: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - DeleteField: typeNumB
   * 13 Weak Mutation 38: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> -1
   * 14 Weak Mutation 39: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 14
   * 15 Weak Mutation 36: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 0
   * 16 Weak Mutation 37: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 1
   * 17 Weak Mutation 42: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceComparisonOperator > -> !=
   * 18 Weak Mutation 40: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 15 -> 16
   * 19 Weak Mutation 44: com.sleepycat.je.log.LogEntryType.isNodeType()Z:89 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test4()  throws Throwable  {
      BIN bIN0 = new BIN();
      LogEntryType logEntryType0 = bIN0.getLogType();
      boolean boolean0 = logEntryType0.isNodeType();
      assertEquals(4294969170L, bIN0.getLastId());
      assertEquals(true, boolean0);
  }
}