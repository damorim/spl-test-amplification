/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.entry.INLogEntry;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestINLogEntry_7 {


  //Test case number: 7
  /*
   * 5 covered goals:
   * 1 Weak Mutation 71: com.sleepycat.je.log.entry.INLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;:127 - DeleteField: inLcom/sleepycat/je/tree/IN;
   * 2 Weak Mutation 72: com.sleepycat.je.log.entry.INLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;:127 - DeleteStatement: getLogType()Lcom/sleepycat/je/log/LogEntryType;
   * 3 com.sleepycat.je.log.entry.INLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 4 Weak Mutation 71: com.sleepycat.je.log.entry.INLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;:127 - DeleteField: inLcom/sleepycat/je/tree/IN;
   * 5 Weak Mutation 72: com.sleepycat.je.log.entry.INLogEntry.getLogType()Lcom/sleepycat/je/log/LogEntryType;:127 - DeleteStatement: getLogType()Lcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test7()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      byte[] byteArray0 = new byte[9];
      BIN bIN0 = new BIN(databaseImpl0, byteArray0, (int) (byte)82, (int) (byte)82);
      INLogEntry iNLogEntry0 = new INLogEntry((IN) bIN0);
      iNLogEntry0.getLogType();
      assertEquals(67111684L, databaseImpl0.getEofNodeId());
      assertEquals(67111688L, bIN0.getLastId());
  }
}