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
public class TestDupCountLN_7 {


  //Test case number: 7
  /*
   * 4 covered goals:
   * 1 Weak Mutation 57: com.sleepycat.je.tree.DupCountLN.containsDuplicates()Z:50 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.tree.DupCountLN.containsDuplicates()Z: root-Branch
   * 3 Weak Mutation 3: com.sleepycat.je.tree.DupCountLN.<init>()V:27 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 57: com.sleepycat.je.tree.DupCountLN.containsDuplicates()Z:50 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test7()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN();
      boolean boolean0 = dupCountLN0.containsDuplicates();
      assertEquals(10000725L, dupCountLN0.getNextNodeId());
      assertEquals(true, boolean0);
  }
}
