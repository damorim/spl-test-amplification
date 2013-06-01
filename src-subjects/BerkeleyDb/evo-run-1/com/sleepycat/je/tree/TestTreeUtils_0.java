/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.tree.TreeUtils;

@RunWith(EvoSuiteRunner.class)
public class TestTreeUtils_0 {


  //Test case number: 0
  /*
   * 9 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - ReplaceConstant -                                                                                                                                  -> 
   * 2 Weak Mutation 1: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 2: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - InsertUnaryOp Negation
   * 4 Weak Mutation 3: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - DeleteStatement: substring(II)Ljava/lang/String;
   * 5 com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;: root-Branch
   * 6 Weak Mutation 0: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - ReplaceConstant -                                                                                                                                  -> 
   * 7 Weak Mutation 1: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 2: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - InsertUnaryOp Negation
   * 9 Weak Mutation 3: com.sleepycat.je.tree.TreeUtils.indent(I)Ljava/lang/String;:11 - DeleteStatement: substring(II)Ljava/lang/String;
   */
  @Test
  public void test0()  throws Throwable  {
      String string0 = TreeUtils.indent((int) (byte)0);
      assertEquals("", string0);
  }
}
