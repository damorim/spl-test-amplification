/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseId_4 {


  //Test case number: 4
  /*
   * 20 covered goals:
   * 1 Weak Mutation 14: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp Negation
   * 2 Weak Mutation 15: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp +1
   * 3 Weak Mutation 16: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp -1
   * 4 Weak Mutation 19: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp +1
   * 5 Weak Mutation 18: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp Negation
   * 6 Weak Mutation 21: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - DeleteField: idI
   * 7 Weak Mutation 20: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp -1
   * 8 Weak Mutation 23: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - ReplaceComparisonOperator != -> <
   * 9 Weak Mutation 26: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - ReplaceConstant - 0 -> 1
   * 10 com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z: I13 Branch 2 IFNE L50 - true
   * 11 com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z: I25 Branch 3 IF_ICMPNE L53 - true
   * 12 Weak Mutation 14: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp Negation
   * 13 Weak Mutation 15: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp +1
   * 14 Weak Mutation 16: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp -1
   * 15 Weak Mutation 19: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp +1
   * 16 Weak Mutation 18: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp Negation
   * 17 Weak Mutation 21: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - DeleteField: idI
   * 18 Weak Mutation 20: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - InsertUnaryOp -1
   * 19 Weak Mutation 23: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - ReplaceComparisonOperator != -> <
   * 20 Weak Mutation 26: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:53 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test4()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId();
      DatabaseId databaseId1 = new DatabaseId((-1));
      boolean boolean0 = databaseId1.equals((Object) databaseId0);
      assertEquals(false, boolean0);
      assertFalse(databaseId0.equals(databaseId1));
      assertEquals("-1", databaseId1.toString());
  }
}
