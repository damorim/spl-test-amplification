/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeIterator;

@RunWith(EvoSuiteRunner.class)
public class TestTreeIterator {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.tree.TreeIterator.<init>(Lcom/sleepycat/je/tree/Tree;)V:20 - DeleteStatement: getFirstNode()Lcom/sleepycat/je/tree/IN;
   * 2 com.sleepycat.je.tree.TreeIterator.<init>(Lcom/sleepycat/je/tree/Tree;)V: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.je.tree.TreeIterator.<init>(Lcom/sleepycat/je/tree/Tree;)V:20 - DeleteStatement: getFirstNode()Lcom/sleepycat/je/tree/IN;
   */
  @Test
  public void test0()  throws Throwable  {
      TreeIterator treeIterator0 = null;
      try {
        treeIterator0 = new TreeIterator((Tree) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
