/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.log.FileHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestLNLogEntry_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 61: com.sleepycat.je.log.entry.LNLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;:168 - DeleteField: entryTypeLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.log.entry.LNLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 61: com.sleepycat.je.log.entry.LNLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;:168 - DeleteField: entryTypeLcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test6()  throws Throwable  {
      FileHeader fileHeader0 = new FileHeader();
      LogEntryType logEntryType0 = fileHeader0.getLogType();
      LN lN0 = new LN();
      DatabaseId databaseId0 = new DatabaseId(0);
      byte[] byteArray0 = new byte[9];
      LNLogEntry lNLogEntry0 = new LNLogEntry(logEntryType0, lN0, databaseId0, byteArray0, (long) 0, true);
      lNLogEntry0.getLogType();
      assertEquals(4848L, lN0.getLastId());
      assertEquals(4848L, lN0.getNextNodeId());
  }
}