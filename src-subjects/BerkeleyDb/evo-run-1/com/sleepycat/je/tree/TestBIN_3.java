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
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.IN;

@RunWith(EvoSuiteRunner.class)
public class TestBIN_3 {


  //Test case number: 3
  /*
   * 8 covered goals:
   * 1 Weak Mutation 22: com.sleepycat.je.tree.BIN.getBINDeltaType()Lcom/sleepycat/je/log/LogEntryType;:69 - DeleteField: LOG_BIN_DELTALcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.tree.BIN.getBINDeltaType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 5: com.sleepycat.je.tree.BIN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;[BII)V:29 - ReplaceConstant - -1 -> 0
   * 4 Weak Mutation 6: com.sleepycat.je.tree.BIN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;[BII)V:29 - ReplaceConstant - -1 -> 1
   * 5 Weak Mutation 7: com.sleepycat.je.tree.BIN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;[BII)V:29 - ReplaceConstant - -1 -> -2
   * 6 Weak Mutation 8: com.sleepycat.je.tree.BIN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;[BII)V:40 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 9: com.sleepycat.je.tree.BIN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;[BII)V:41 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 22: com.sleepycat.je.tree.BIN.getBINDeltaType()Lcom/sleepycat/je/log/LogEntryType;:69 - DeleteField: LOG_BIN_DELTALcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test3()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      byte[] byteArray0 = new byte[3];
      BIN bIN0 = new BIN(databaseImpl0, byteArray0, (int) (byte)0, (int) (byte)0);
      bIN0.getBINDeltaType();
      assertEquals("<bin>\n  <node>11467</node>\n  <idkey><key v=\"0 0 0 \"/></idkey>\n  <dirty val=\"false\"/>\n  <generation val=\"0\"/>\n  <level val=\"20000\"/>\n  <isRoot val=\"false\"/>\n  <entries nEntries=\"0\">\n  </entries>\n</bin>", bIN0.toString());
      assertEquals(11466L, databaseImpl0.getEofNodeId());
  }
}
