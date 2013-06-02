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
public class TestLogEntryType_35 {


  //Test case number: 35
  /*
   * 3 covered goals:
   * 1 Weak Mutation 181: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:174 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z: I13 Branch 12 IFNE L173 - false
   * 3 Weak Mutation 181: com.sleepycat.je.log.LogEntryType.equals(Ljava/lang/Object;)Z:174 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test35()  throws Throwable  {
      LogEntryType logEntryType0 = LogEntryType.LOG_IN_DELETE_INFO;
      boolean boolean0 = logEntryType0.equals((Object) "INDelete/0");
      assertEquals(false, boolean0);
  }
}