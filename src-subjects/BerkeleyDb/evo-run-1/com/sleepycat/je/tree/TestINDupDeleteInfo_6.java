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
import com.sleepycat.je.tree.INDupDeleteInfo;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestINDupDeleteInfo_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 8: com.sleepycat.je.tree.INDupDeleteInfo.countAsObsoleteWhenLogged()Z:62 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.INDupDeleteInfo.countAsObsoleteWhenLogged()Z: root-Branch
   * 3 Weak Mutation 8: com.sleepycat.je.tree.INDupDeleteInfo.countAsObsoleteWhenLogged()Z:62 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test6()  throws Throwable  {
      INDupDeleteInfo iNDupDeleteInfo0 = new INDupDeleteInfo();
      boolean boolean0 = iNDupDeleteInfo0.countAsObsoleteWhenLogged();
      assertEquals(false, boolean0);
  }
}
