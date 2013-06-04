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
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeLocation;

@RunWith(EvoSuiteRunner.class)
public class TestNode_13 {


  //Test case number: 13
  /*
   * 11 covered goals:
   * 1 Weak Mutation 76: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> -1
   * 2 Weak Mutation 77: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 7
   * 3 Weak Mutation 78: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 9
   * 4 Weak Mutation 74: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 0
   * 5 Weak Mutation 75: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 1
   * 6 com.sleepycat.je.tree.Node.getLogSize()I: root-Branch
   * 7 Weak Mutation 76: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> -1
   * 8 Weak Mutation 77: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 7
   * 9 Weak Mutation 78: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 9
   * 10 Weak Mutation 74: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 0
   * 11 Weak Mutation 75: com.sleepycat.je.tree.Node.getLogSize()I:179 - ReplaceConstant - 8 -> 1
   */
  @Test
  public void test13()  throws Throwable  {
      MapLN mapLN0 = new MapLN();
      // Undeclared exception!
      try {
        mapLN0.getLogSize();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
