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
public class TestDupCountLN_10 {


  //Test case number: 10
  /*
   * 3 covered goals:
   * 1 Weak Mutation 126: com.sleepycat.je.tree.DupCountLN.getTransactionalLogType()Lcom/sleepycat/je/log/LogEntryType;:98 - DeleteField: LOG_DUPCOUNTLN_TRANSACTIONALLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.tree.DupCountLN.getTransactionalLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 126: com.sleepycat.je.tree.DupCountLN.getTransactionalLogType()Lcom/sleepycat/je/log/LogEntryType;:98 - DeleteField: LOG_DUPCOUNTLN_TRANSACTIONALLcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test10()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN(864);
      dupCountLN0.getTransactionalLogType();
      assertEquals("<com.sleepycat.je.tree.DupCountLN/10000985", dupCountLN0.shortDescription());
      assertEquals(10000987L, dupCountLN0.getNextNodeId());
  }
}