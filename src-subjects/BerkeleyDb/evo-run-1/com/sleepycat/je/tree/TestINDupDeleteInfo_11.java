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
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.INDupDeleteInfo;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestINDupDeleteInfo_11 {


  //Test case number: 11
  /*
   * 3 covered goals:
   * 1 Weak Mutation 71: com.sleepycat.je.tree.INDupDeleteInfo.logEntryIsTransactional()Z:108 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.INDupDeleteInfo.logEntryIsTransactional()Z: root-Branch
   * 3 Weak Mutation 71: com.sleepycat.je.tree.INDupDeleteInfo.logEntryIsTransactional()Z:108 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test11()  throws Throwable  {
      INDupDeleteInfo iNDupDeleteInfo0 = new INDupDeleteInfo();
      boolean boolean0 = iNDupDeleteInfo0.logEntryIsTransactional();
      assertEquals(false, boolean0);
  }
}