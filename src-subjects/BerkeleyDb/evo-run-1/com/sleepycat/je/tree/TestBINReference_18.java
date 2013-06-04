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
public class TestBINReference_18 {


  //Test case number: 18
  /*
   * 43 covered goals:
   * 1 Weak Mutation 79: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: deletedKeysLjava/util/Set;
   * 2 Weak Mutation 11: com.sleepycat.je.tree.BINReference.addDeletedKeys(Lcom/sleepycat/je/tree/BINReference;)V:42 - DeleteField: deletedKeysLjava/util/Set;
   * 3 Weak Mutation 13: com.sleepycat.je.tree.BINReference.addDeletedKeys(Lcom/sleepycat/je/tree/BINReference;)V:43 - DeleteField: deletedKeysLjava/util/Set;
   * 4 Weak Mutation 14: com.sleepycat.je.tree.BINReference.addDeletedKeys(Lcom/sleepycat/je/tree/BINReference;)V:43 - DeleteField: deletedKeysLjava/util/Set;
   * 5 Weak Mutation 15: com.sleepycat.je.tree.BINReference.addDeletedKeys(Lcom/sleepycat/je/tree/BINReference;)V:43 - DeleteStatement: addAll(Ljava/util/Collection;)Z
   * 6 Weak Mutation 63: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant - idKey= -> 
   * 7 Weak Mutation 68: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant -  nodeId =  -> 
   * 8 Weak Mutation 69: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 9 Weak Mutation 70: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - InsertUnaryOp Negation
   * 10 Weak Mutation 71: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: nodeIdJ
   * 11 Weak Mutation 64: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 12 Weak Mutation 65: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: idKey[B
   * 13 Weak Mutation 66: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: getNoFormatString([B)Ljava/lang/String;
   * 14 Weak Mutation 67: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 15 Weak Mutation 76: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 16 Weak Mutation 77: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant -  deletedKeys= -> 
   * 17 Weak Mutation 78: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 18 Weak Mutation 72: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(J)Ljava/lang/StringBuilder;
   * 19 Weak Mutation 73: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant -  db= -> 
   * 20 Weak Mutation 74: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 21 Weak Mutation 75: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: databaseIdLcom/sleepycat/je/dbi/DatabaseId;
   * 22 Weak Mutation 81: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: toString()Ljava/lang/String;
   * 23 Weak Mutation 80: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 24 Weak Mutation 63: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant - idKey= -> 
   * 25 Weak Mutation 68: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant -  nodeId =  -> 
   * 26 Weak Mutation 69: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 27 Weak Mutation 70: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - InsertUnaryOp Negation
   * 28 Weak Mutation 71: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: nodeIdJ
   * 29 Weak Mutation 64: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 30 Weak Mutation 65: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: idKey[B
   * 31 Weak Mutation 66: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: getNoFormatString([B)Ljava/lang/String;
   * 32 Weak Mutation 67: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 33 Weak Mutation 76: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 34 Weak Mutation 77: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant -  deletedKeys= -> 
   * 35 Weak Mutation 78: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 36 Weak Mutation 79: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: deletedKeysLjava/util/Set;
   * 37 Weak Mutation 72: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(J)Ljava/lang/StringBuilder;
   * 38 Weak Mutation 73: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - ReplaceConstant -  db= -> 
   * 39 Weak Mutation 74: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 40 Weak Mutation 75: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteField: databaseIdLcom/sleepycat/je/dbi/DatabaseId;
   * 41 Weak Mutation 81: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: toString()Ljava/lang/String;
   * 42 Weak Mutation 80: com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;:84 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 43 com.sleepycat.je.tree.BINReference.toString()Ljava/lang/String;: root-Branch
   */
  @Test
  public void test18()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId();
      byte[] byteArray0 = new byte[10];
      BINReference bINReference0 = new BINReference(374L, databaseId0, byteArray0);
      bINReference0.addDeletedKeys(bINReference0);
      String string0 = bINReference0.toString();
      assertNotNull(string0);
      assertEquals("idKey=key=<key v=\"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\"/> nodeId = 374 db=0 deletedKeys=[]", bINReference0.toString());
      assertEquals("idKey=key=<key v=\"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\"/> nodeId = 374 db=0 deletedKeys=[]", string0);
  }
}
