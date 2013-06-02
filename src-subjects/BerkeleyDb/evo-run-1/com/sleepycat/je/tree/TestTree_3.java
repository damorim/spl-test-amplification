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
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.Tree;

@RunWith(EvoSuiteRunner.class)
public class TestTree_3 {


  //Test case number: 3
  /*
   * 8 covered goals:
   * 1 Weak Mutation 17: com.sleepycat.je.tree.Tree.getRootLsn()J:207 - ReplaceConstant - -1 -> 0
   * 2 Weak Mutation 19: com.sleepycat.je.tree.Tree.getRootLsn()J:207 - ReplaceConstant - -1 -> -2
   * 3 Weak Mutation 18: com.sleepycat.je.tree.Tree.getRootLsn()J:207 - ReplaceConstant - -1 -> 1
   * 4 com.sleepycat.je.tree.Tree.getRootLsn()J: I4 Branch 1 IFNONNULL L206 - false
   * 5 Weak Mutation 16: com.sleepycat.je.tree.Tree.getRootLsn()J:206 - ReplaceComparisonOperator != null -> = null
   * 6 Weak Mutation 17: com.sleepycat.je.tree.Tree.getRootLsn()J:207 - ReplaceConstant - -1 -> 0
   * 7 Weak Mutation 19: com.sleepycat.je.tree.Tree.getRootLsn()J:207 - ReplaceConstant - -1 -> -2
   * 8 Weak Mutation 18: com.sleepycat.je.tree.Tree.getRootLsn()J:207 - ReplaceConstant - -1 -> 1
   */
  @Test
  public void test3()  throws Throwable  {
      Tree tree0 = new Tree();
      long long0 = tree0.getRootLsn();
      assertEquals((-1L), long0);
  }
}