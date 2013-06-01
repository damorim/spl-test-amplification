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
public class TestBINReference_16 {


  //Test case number: 16
  /*
   * 9 covered goals:
   * 1 Weak Mutation 57: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:78 - ReplaceComparisonOperator != -> >
   * 2 Weak Mutation 47: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:72 - ReplaceComparisonOperator != -> ==
   * 3 Weak Mutation 51: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:78 - InsertUnaryOp Negation
   * 4 Weak Mutation 49: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:75 - ReplaceComparisonOperator != -> ==
   * 5 Weak Mutation 55: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:78 - DeleteStatement: longSub(JJ)I
   * 6 Weak Mutation 53: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:78 - InsertUnaryOp Negation
   * 7 Weak Mutation 52: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:78 - DeleteField: nodeIdJ
   * 8 Weak Mutation 60: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:78 - ReplaceConstant - 0 -> 1
   * 9 Weak Mutation 57: com.sleepycat.je.tree.BINReference.equals(Ljava/lang/Object;)Z:78 - ReplaceComparisonOperator != -> >
   */
  @Test
  public void test16()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      BINReference bINReference0 = new BINReference((long) (byte)0, (DatabaseId) null, byteArray0);
      BINReference bINReference1 = new BINReference((-1762L), (DatabaseId) null, byteArray0);
      boolean boolean0 = bINReference0.equals((Object) bINReference1);
      assertEquals(false, boolean0);
      assertEquals((-1762L), bINReference1.getNodeId());
      assertFalse(bINReference1.equals(bINReference0));
  }
}
