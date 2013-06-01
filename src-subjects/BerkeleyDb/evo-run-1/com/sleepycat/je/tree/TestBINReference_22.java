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
import java.util.Iterator;

@RunWith(EvoSuiteRunner.class)
public class TestBINReference_22 {


  //Test case number: 22
  /*
   * 3 covered goals:
   * 1 com.sleepycat.je.tree.BINReference.getDeletedKeyIterator()Ljava/util/Iterator;: I4 Branch 10 IFNULL L61 - true
   * 2 Weak Mutation 0: com.sleepycat.je.tree.BINReference.<init>(JLcom/sleepycat/je/dbi/DatabaseId;[B)V:16 - InsertUnaryOp Negation
   * 3 Weak Mutation 44: com.sleepycat.je.tree.BINReference.getDeletedKeyIterator()Ljava/util/Iterator;:61 - ReplaceComparisonOperator = null -> != null
   */
  @Test
  public void test22()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      BINReference bINReference0 = new BINReference((long) (byte)0, (DatabaseId) null, byteArray0);
      Iterator<?> iterator0 = bINReference0.getDeletedKeyIterator();
      assertNull(iterator0);
  }
}
