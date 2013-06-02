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
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestLNLogEntry_10 {


  //Test case number: 10
  /*
   * 3 covered goals:
   * 1 Weak Mutation 89: com.sleepycat.je.log.entry.LNLogEntry.getLN()Lcom/sleepycat/je/tree/LN;:231 - DeleteField: lnLcom/sleepycat/je/tree/LN;
   * 2 com.sleepycat.je.log.entry.LNLogEntry.getLN()Lcom/sleepycat/je/tree/LN;: root-Branch
   * 3 Weak Mutation 89: com.sleepycat.je.log.entry.LNLogEntry.getLN()Lcom/sleepycat/je/tree/LN;:231 - DeleteField: lnLcom/sleepycat/je/tree/LN;
   */
  @Test
  public void test10()  throws Throwable  {
      LogEntryType logEntryType0 = LogEntryType.LOG_DEL_DUPLN;
      LN lN0 = new LN();
      byte[] byteArray0 = new byte[2];
      LNLogEntry lNLogEntry0 = new LNLogEntry(logEntryType0, lN0, (DatabaseId) null, byteArray0, (long) (byte) (-108), true);
      lNLogEntry0.getLN();
      assertEquals(5074L, lN0.getLastId());
      assertEquals(5074L, lN0.getNextNodeId());
  }
}