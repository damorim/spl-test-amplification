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
public class TestLogEntryType_9 {


  //Test case number: 9
  /*
   * 2 covered goals:
   * 1 Weak Mutation 49: com.sleepycat.je.log.LogEntryType.findType(BB)Lcom/sleepycat/je/log/LogEntryType;:95 - ReplaceComparisonOperator <= -> ==
   * 2 Weak Mutation 49: com.sleepycat.je.log.LogEntryType.findType(BB)Lcom/sleepycat/je/log/LogEntryType;:95 - ReplaceComparisonOperator <= -> ==
   */
  @Test
  public void test9()  throws Throwable  {
      LogEntryType logEntryType0 = LogEntryType.findType((byte) (-113), (byte)27);
      assertNull(logEntryType0);
  }
}
