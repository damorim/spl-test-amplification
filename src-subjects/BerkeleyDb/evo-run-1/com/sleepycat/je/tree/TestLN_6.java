/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;

@RunWith(EvoSuiteRunner.class)
public class TestLN_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 61: com.sleepycat.je.tree.LN.isSoughtNode(JZ)Z:104 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.LN.isSoughtNode(JZ)Z: root-Branch
   * 3 Weak Mutation 61: com.sleepycat.je.tree.LN.isSoughtNode(JZ)Z:104 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test6()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      boolean boolean0 = nameLN0.isSoughtNode(4294968883L, true);
      assertEquals(false, boolean0);
  }
}