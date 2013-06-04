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
public class TestBINReference_8 {


  //Test case number: 8
  /*
   * 8 covered goals:
   * 1 Weak Mutation 31: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - ReplaceComparisonOperator <= -> -1
   * 2 Weak Mutation 32: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - ReplaceConstant - 1 -> 0
   * 3 com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z: I9 Branch 7 IFLE L55 - false
   * 4 Weak Mutation 25: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - DeleteField: deletedKeysLjava/util/Set;
   * 5 Weak Mutation 27: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - DeleteField: deletedKeysLjava/util/Set;
   * 6 Weak Mutation 28: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - DeleteStatement: collectionContains(Ljava/util/Collection;Ljava/lang/Object;)I
   * 7 Weak Mutation 31: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - ReplaceComparisonOperator <= -> -1
   * 8 Weak Mutation 32: com.sleepycat.je.tree.BINReference.hasDeletedKey(Lcom/sleepycat/je/tree/Key;)Z:55 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test8()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId(236);
      byte[] byteArray0 = new byte[4];
      BINReference bINReference0 = new BINReference((long) 236, databaseId0, byteArray0);
      Key key0 = new Key(byteArray0);
      bINReference0.addDeletedKey(key0);
      boolean boolean0 = bINReference0.hasDeletedKey(key0);
      assertEquals(true, bINReference0.deletedKeysExist());
      assertEquals(true, boolean0);
  }
}
