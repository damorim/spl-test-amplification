/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.bind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.ByteArrayBinding;
import com.sleepycat.je.DatabaseEntry;

@RunWith(EvoSuiteRunner.class)
public class TestByteArrayBinding_0 {


  //Test case number: 0
  /*
   * 18 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:36 - DeleteStatement: getSize()I
   * 2 Weak Mutation 1: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp Negation of len
   * 3 Weak Mutation 2: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC 1 len
   * 4 Weak Mutation 3: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC -1 len
   * 5 Weak Mutation 5: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> >
   * 6 Weak Mutation 8: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp Negation of len
   * 7 Weak Mutation 9: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC 1 len
   * 8 Weak Mutation 10: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC -1 len
   * 9 com.sleepycat.bind.ByteArrayBinding.<init>()V: root-Branch
   * 10 com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;: I8 Branch 1 IFNE L37 - true
   * 11 Weak Mutation 0: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:36 - DeleteStatement: getSize()I
   * 12 Weak Mutation 1: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp Negation of len
   * 13 Weak Mutation 2: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC 1 len
   * 14 Weak Mutation 3: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC -1 len
   * 15 Weak Mutation 5: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> >
   * 16 Weak Mutation 8: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp Negation of len
   * 17 Weak Mutation 9: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC 1 len
   * 18 Weak Mutation 10: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC -1 len
   */
  @Test
  public void test0()  throws Throwable  {
      ByteArrayBinding byteArrayBinding0 = new ByteArrayBinding();
      byte[] byteArray0 = new byte[10];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0, 0, (int) (byte) (-12));
      // Undeclared exception!
      try {
        byteArrayBinding0.entryToObject(databaseEntry0);
        fail("Expecting exception: NegativeArraySizeException");
      } catch(NegativeArraySizeException e) {
      }
  }
}
