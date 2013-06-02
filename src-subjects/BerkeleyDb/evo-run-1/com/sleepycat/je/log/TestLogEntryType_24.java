/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.SingleItemLogEntry;
import com.sleepycat.je.tree.BIN;
import java.util.Set;

@RunWith(EvoSuiteRunner.class)
public class TestLogEntryType_24 {


  //Test case number: 24
  /*
   * 3 covered goals:
   * 1 Weak Mutation 146: com.sleepycat.je.log.LogEntryType.isValidType(B)Z:155 - ReplaceComparisonOperator > -> !=
   * 2 Weak Mutation 148: com.sleepycat.je.log.LogEntryType.isValidType(B)Z:155 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 146: com.sleepycat.je.log.LogEntryType.isValidType(B)Z:155 - ReplaceComparisonOperator > -> !=
   */
  @Test
  public void test24()  throws Throwable  {
      boolean boolean0 = LogEntryType.isValidType((byte)24);
      assertEquals(true, boolean0);
  }
}