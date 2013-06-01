/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.INDeleteInfo;

@RunWith(EvoSuiteRunner.class)
public class TestINDeleteInfo_4 {


  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.je.tree.INDeleteInfo.marshallOutsideWriteLatch()Z:51 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.tree.INDeleteInfo.marshallOutsideWriteLatch()Z: root-Branch
   * 3 Weak Mutation 6: com.sleepycat.je.tree.INDeleteInfo.marshallOutsideWriteLatch()Z:51 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test4()  throws Throwable  {
      byte[] byteArray0 = new byte[11];
      DatabaseId databaseId0 = new DatabaseId((-984));
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo(216L, byteArray0, databaseId0);
      boolean boolean0 = iNDeleteInfo0.marshallOutsideWriteLatch();
      assertEquals(216L, iNDeleteInfo0.getDeletedNodeId());
      assertEquals(true, boolean0);
  }
}
