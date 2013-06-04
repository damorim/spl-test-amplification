/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.tree.DBINReference;

@RunWith(EvoSuiteRunner.class)
public class TestDBINReference {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.tree.DBINReference.<init>(JLcom/sleepycat/je/dbi/DatabaseId;[B[B)V:11 - ReplaceVariable dupKey -> idKey
   * 2 com.sleepycat.je.tree.DBINReference.<init>(JLcom/sleepycat/je/dbi/DatabaseId;[B[B)V: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.je.tree.DBINReference.<init>(JLcom/sleepycat/je/dbi/DatabaseId;[B[B)V:11 - ReplaceVariable dupKey -> idKey
   */
  @Test
  public void test0()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId((-549));
      byte[] byteArray0 = new byte[7];
      byte[] byteArray1 = new byte[10];
      DBINReference dBINReference0 = new DBINReference((-1L), databaseId0, byteArray1, byteArray0);
      assertEquals("idKey=key=<key v=\"0 0 0 0 0 0 0 0 0 0 \"/> nodeId = -1 db=-549 deletedKeys=null dupKey=<key v=\"0 0 0 0 0 0 0 \"/>", dBINReference0.toString());
  }

  //Test case number: 1
  /*
   * 3 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.tree.DBINReference.getKey()[B:14 - DeleteField: dupKey[B
   * 2 com.sleepycat.je.tree.DBINReference.getKey()[B: root-Branch
   * 3 Weak Mutation 1: com.sleepycat.je.tree.DBINReference.getKey()[B:14 - DeleteField: dupKey[B
   */
  @Test
  public void test1()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId();
      byte[] byteArray0 = new byte[5];
      DBINReference dBINReference0 = new DBINReference((-614L), databaseId0, byteArray0, byteArray0);
      byte[] byteArray1 = dBINReference0.getKey();
      assertSame(byteArray0, byteArray1);
  }

  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 Weak Mutation 2: com.sleepycat.je.tree.DBINReference.getData()[B:17 - DeleteField: idKey[B
   * 2 com.sleepycat.je.tree.DBINReference.getData()[B: root-Branch
   * 3 Weak Mutation 2: com.sleepycat.je.tree.DBINReference.getData()[B:17 - DeleteField: idKey[B
   */
  @Test
  public void test2()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId(35);
      byte[] byteArray0 = new byte[4];
      DBINReference dBINReference0 = new DBINReference(0L, databaseId0, byteArray0, byteArray0);
      byte[] byteArray1 = dBINReference0.getData();
      assertSame(byteArray1, byteArray0);
  }

  //Test case number: 3
  /*
   * 17 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 2 Weak Mutation 4: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - ReplaceConstant -  dupKey= -> 
   * 3 Weak Mutation 5: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 4 Weak Mutation 6: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteField: dupKey[B
   * 5 Weak Mutation 7: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 8: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 7 Weak Mutation 9: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 8 Weak Mutation 10: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: toString()Ljava/lang/String;
   * 9 com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;: root-Branch
   * 10 Weak Mutation 3: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 11 Weak Mutation 4: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - ReplaceConstant -  dupKey= -> 
   * 12 Weak Mutation 5: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 13 Weak Mutation 6: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteField: dupKey[B
   * 14 Weak Mutation 7: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 8: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 16 Weak Mutation 9: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 17 Weak Mutation 10: com.sleepycat.je.tree.DBINReference.toString()Ljava/lang/String;:20 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test3()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId();
      byte[] byteArray0 = new byte[5];
      DBINReference dBINReference0 = new DBINReference((-614L), databaseId0, byteArray0, byteArray0);
      String string0 = dBINReference0.toString();
      assertNotNull(string0);
      assertEquals("idKey=key=<key v=\"0 0 0 0 0 \"/> nodeId = -614 db=0 deletedKeys=null dupKey=<key v=\"0 0 0 0 0 \"/>", string0);
  }
}
