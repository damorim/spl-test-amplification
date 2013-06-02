/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.tree.DupCountLN;

@RunWith(EvoSuiteRunner.class)
public class TestDupCountLN_11 {


  //Test case number: 11
  /*
   * 3 covered goals:
   * 1 Weak Mutation 127: com.sleepycat.je.tree.DupCountLN.getLogType()Lcom/sleepycat/je/log/LogEntryType;:104 - DeleteField: LOG_DUPCOUNTLNLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.tree.DupCountLN.getLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 127: com.sleepycat.je.tree.DupCountLN.getLogType()Lcom/sleepycat/je/log/LogEntryType;:104 - DeleteField: LOG_DUPCOUNTLNLcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test11()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN(1673);
      dupCountLN0.getLogType();
      assertEquals(10001002L, dupCountLN0.getNextNodeId());
      assertEquals(10001002L, dupCountLN0.getLastId());
  }
}