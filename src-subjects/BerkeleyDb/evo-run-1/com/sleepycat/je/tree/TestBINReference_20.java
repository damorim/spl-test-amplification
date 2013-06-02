/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.tree.BINReference;
import com.sleepycat.je.tree.Key;

@RunWith(EvoSuiteRunner.class)
public class TestBINReference_20 {


  //Test case number: 20
  /*
   * 3 covered goals:
   * 1 com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z: I4 Branch 6 IFNULL L55 - true
   * 2 Weak Mutation 26: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 33: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test20()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId();
      byte[] byteArray0 = new byte[10];
      BINReference bINReference0 = new BINReference(374L, databaseId0, byteArray0);
      Key key0 = new Key(byteArray0);
      boolean boolean0 = bINReference0.hasDeletedKey(key0);
      assertEquals(374L, bINReference0.getNodeId());
      assertEquals(false, boolean0);
  }
}