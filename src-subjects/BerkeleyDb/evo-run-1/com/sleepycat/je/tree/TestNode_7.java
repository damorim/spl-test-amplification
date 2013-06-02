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
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeLocation;

@RunWith(EvoSuiteRunner.class)
public class TestNode_7 {


  //Test case number: 7
  /*
   * 3 covered goals:
   * 1 Weak Mutation 26: com.sleepycat.je.tree.Node.getLevel()I:78 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.Node.getLevel()I: root-Branch
   * 3 Weak Mutation 26: com.sleepycat.je.tree.Node.getLevel()I:78 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test7()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      int int0 = nameLN0.getLevel();
      assertEquals(5L, nameLN0.getNextNodeId());
      assertEquals(0, int0);
  }
}