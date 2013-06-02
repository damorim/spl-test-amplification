/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseId_14 {


  //Test case number: 14
  /*
   * 22 covered goals:
   * 1 Weak Mutation 76: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - DeleteField: idI
   * 2 Weak Mutation 0: com.sleepycat.je.dbi.DatabaseId.<init>(I)V:19 - InsertUnaryOp Negation
   * 3 Weak Mutation 1: com.sleepycat.je.dbi.DatabaseId.<init>(I)V:19 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 2: com.sleepycat.je.dbi.DatabaseId.<init>(I)V:19 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 71: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:101 - ReplaceConstant - <dbId id=" -> 
   * 6 Weak Mutation 77: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 78: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:103 - ReplaceConstant - "/> -> 
   * 8 Weak Mutation 79: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:103 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 9 Weak Mutation 72: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:101 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 10 Weak Mutation 73: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - InsertUnaryOp Negation
   * 11 Weak Mutation 74: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - InsertUnaryOp +1
   * 12 Weak Mutation 75: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - InsertUnaryOp -1
   * 13 Weak Mutation 71: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:101 - ReplaceConstant - <dbId id=" -> 
   * 14 Weak Mutation 76: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - DeleteField: idI
   * 15 Weak Mutation 77: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 16 Weak Mutation 78: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:103 - ReplaceConstant - "/> -> 
   * 17 Weak Mutation 79: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:103 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 18 Weak Mutation 72: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:101 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 19 Weak Mutation 73: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - InsertUnaryOp Negation
   * 20 Weak Mutation 74: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - InsertUnaryOp +1
   * 21 Weak Mutation 75: com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V:102 - InsertUnaryOp -1
   * 22 com.sleepycat.je.dbi.DatabaseId.dumpLog(Ljava/lang/StringBuffer;Z)V: root-Branch
   */
  @Test
  public void test14()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId((-1));
      StringBuffer stringBuffer0 = new StringBuffer(1);
      databaseId0.dumpLog(stringBuffer0, false);
      assertEquals(22, stringBuffer0.capacity());
      assertEquals("<dbId id=\"-1\"/>", stringBuffer0.toString());
  }
}