/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;

@RunWith(EvoSuiteRunner.class)
public class TestDBIN_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 18: com.sleepycat.je.tree.DBIN.getBINDeltaType()Lcom/sleepycat/je/log/LogEntryType;:87 - DeleteField: LOG_DUP_BIN_DELTALcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.tree.DBIN.getBINDeltaType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 18: com.sleepycat.je.tree.DBIN.getBINDeltaType()Lcom/sleepycat/je/log/LogEntryType;:87 - DeleteField: LOG_DUP_BIN_DELTALcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test6()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      LogEntryType logEntryType0 = dBIN0.getBINDeltaType();
      assertNotNull(logEntryType0);
      assertEquals(4294970832L, dBIN0.getNextNodeId());
  }
}
