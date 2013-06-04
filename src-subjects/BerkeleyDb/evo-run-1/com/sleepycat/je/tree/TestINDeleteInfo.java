/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.INDeleteInfo;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestINDeleteInfo {


  //Test case number: 0
  /*
   * 9 covered goals:
   * 1 Weak Mutation 25: com.sleepycat.je.tree.INDeleteInfo.writeToLog(Ljava/nio/ByteBuffer;)V:74 - InsertUnaryOp Negation
   * 2 Weak Mutation 27: com.sleepycat.je.tree.INDeleteInfo.writeToLog(Ljava/nio/ByteBuffer;)V:74 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   * 3 Weak Mutation 26: com.sleepycat.je.tree.INDeleteInfo.writeToLog(Ljava/nio/ByteBuffer;)V:74 - DeleteField: deletedNodeIdJ
   * 4 com.sleepycat.je.tree.INDeleteInfo.writeToLog(Ljava/nio/ByteBuffer;)V: root-Branch
   * 5 Weak Mutation 0: com.sleepycat.je.tree.INDeleteInfo.<init>(J[BLcom/sleepycat/je/dbi/DatabaseId;)V:22 - InsertUnaryOp Negation of deletedNodeId
   * 6 Weak Mutation 25: com.sleepycat.je.tree.INDeleteInfo.writeToLog(Ljava/nio/ByteBuffer;)V:74 - InsertUnaryOp Negation
   * 7 Weak Mutation 27: com.sleepycat.je.tree.INDeleteInfo.writeToLog(Ljava/nio/ByteBuffer;)V:74 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   * 8 Weak Mutation 26: com.sleepycat.je.tree.INDeleteInfo.writeToLog(Ljava/nio/ByteBuffer;)V:74 - DeleteField: deletedNodeIdJ
   * 9 com.sleepycat.je.tree.INDeleteInfo.<init>(J[BLcom/sleepycat/je/dbi/DatabaseId;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      byte[] byteArray0 = new byte[24];
      DatabaseId databaseId0 = new DatabaseId();
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo((-1L), byteArray0, databaseId0);
      // Undeclared exception!
      try {
        iNDeleteInfo0.writeToLog((ByteBuffer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - InsertUnaryOp Negation
   * 2 Weak Mutation 2: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - DeleteField: deletedNodeIdJ
   * 3 com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J: root-Branch
   * 4 Weak Mutation 1: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - InsertUnaryOp Negation
   * 5 Weak Mutation 2: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - DeleteField: deletedNodeIdJ
   */
  @Test
  public void test1()  throws Throwable  {
      byte[] byteArray0 = new byte[2];
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo(4294967280L, byteArray0, (DatabaseId) null);
      long long0 = iNDeleteInfo0.getDeletedNodeId();
      assertEquals(4294967280L, long0);
  }

  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.tree.INDeleteInfo.getDeletedIdKey()[B:36 - DeleteField: deletedIdKey[B
   * 2 com.sleepycat.je.tree.INDeleteInfo.getDeletedIdKey()[B: root-Branch
   * 3 Weak Mutation 3: com.sleepycat.je.tree.INDeleteInfo.getDeletedIdKey()[B:36 - DeleteField: deletedIdKey[B
   */
  @Test
  public void test2()  throws Throwable  {
      byte[] byteArray0 = new byte[2];
      DatabaseId databaseId0 = new DatabaseId();
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo((long) 0, byteArray0, databaseId0);
      byte[] byteArray1 = iNDeleteInfo0.getDeletedIdKey();
      assertSame(byteArray1, byteArray0);
  }

  //Test case number: 3
  /*
   * 4 covered goals:
   * 1 Weak Mutation 4: com.sleepycat.je.tree.INDeleteInfo.getDatabaseId()Lcom/sleepycat/je/dbi/DatabaseId;:39 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 2 com.sleepycat.je.tree.INDeleteInfo.<init>()V: root-Branch
   * 3 com.sleepycat.je.tree.INDeleteInfo.getDatabaseId()Lcom/sleepycat/je/dbi/DatabaseId;: root-Branch
   * 4 Weak Mutation 4: com.sleepycat.je.tree.INDeleteInfo.getDatabaseId()Lcom/sleepycat/je/dbi/DatabaseId;:39 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   */
  @Test
  public void test3()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      DatabaseId databaseId0 = iNDeleteInfo0.getDatabaseId();
      assertEquals("0", databaseId0.toString());
  }

  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 5: com.sleepycat.je.tree.INDeleteInfo.getLogType()Lcom/sleepycat/je/log/LogEntryType;:45 - DeleteField: LOG_IN_DELETE_INFOLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.tree.INDeleteInfo.getLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 5: com.sleepycat.je.tree.INDeleteInfo.getLogType()Lcom/sleepycat/je/log/LogEntryType;:45 - DeleteField: LOG_IN_DELETE_INFOLcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test4()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      LogEntryType logEntryType0 = iNDeleteInfo0.getLogType();
      assertEquals("INDelete/0", logEntryType0.toString());
  }

  //Test case number: 5
  /*
   * 3 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.je.tree.INDeleteInfo.marshallOutsideWriteLatch()Z:51 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.tree.INDeleteInfo.marshallOutsideWriteLatch()Z: root-Branch
   * 3 Weak Mutation 6: com.sleepycat.je.tree.INDeleteInfo.marshallOutsideWriteLatch()Z:51 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test5()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      boolean boolean0 = iNDeleteInfo0.marshallOutsideWriteLatch();
      assertEquals(true, boolean0);
  }

  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 7: com.sleepycat.je.tree.INDeleteInfo.countAsObsoleteWhenLogged()Z:57 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.INDeleteInfo.countAsObsoleteWhenLogged()Z: root-Branch
   * 3 Weak Mutation 7: com.sleepycat.je.tree.INDeleteInfo.countAsObsoleteWhenLogged()Z:57 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test6()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      boolean boolean0 = iNDeleteInfo0.countAsObsoleteWhenLogged();
      assertEquals(false, boolean0);
  }

  //Test case number: 7
  /*
   * 35 covered goals:
   * 1 Weak Mutation 13: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteField: deletedIdKey[B
   * 2 Weak Mutation 15: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> -
   * 3 Weak Mutation 17: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> /
   * 4 Weak Mutation 16: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> %
   * 5 Weak Mutation 19: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 6 Weak Mutation 18: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> *
   * 7 Weak Mutation 21: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> -
   * 8 Weak Mutation 20: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteStatement: getLogSize()I
   * 9 Weak Mutation 23: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> /
   * 10 Weak Mutation 22: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> %
   * 11 Weak Mutation 24: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> *
   * 12 Weak Mutation 8: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 0
   * 13 Weak Mutation 9: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 1
   * 14 Weak Mutation 10: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> -1
   * 15 Weak Mutation 11: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 7
   * 16 Weak Mutation 12: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 9
   * 17 Weak Mutation 14: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteStatement: getByteArrayLogSize([B)I
   * 18 Weak Mutation 8: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 0
   * 19 Weak Mutation 9: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 1
   * 20 Weak Mutation 10: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> -1
   * 21 Weak Mutation 11: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 7
   * 22 Weak Mutation 12: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceConstant - 8 -> 9
   * 23 Weak Mutation 13: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteField: deletedIdKey[B
   * 24 Weak Mutation 14: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteStatement: getByteArrayLogSize([B)I
   * 25 Weak Mutation 15: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> -
   * 26 Weak Mutation 17: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> /
   * 27 Weak Mutation 16: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> %
   * 28 Weak Mutation 19: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 29 Weak Mutation 18: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> *
   * 30 Weak Mutation 21: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> -
   * 31 Weak Mutation 20: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - DeleteStatement: getLogSize()I
   * 32 Weak Mutation 23: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> /
   * 33 Weak Mutation 22: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> %
   * 34 Weak Mutation 24: com.sleepycat.je.tree.INDeleteInfo.getLogSize()I:68 - ReplaceArithmeticOperator + -> *
   * 35 com.sleepycat.je.tree.INDeleteInfo.getLogSize()I: root-Branch
   */
  @Test
  public void test7()  throws Throwable  {
      byte[] byteArray0 = new byte[2];
      DatabaseId databaseId0 = new DatabaseId();
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo((long) 0, byteArray0, databaseId0);
      int int0 = iNDeleteInfo0.getLogSize();
      assertEquals(18, int0);
  }

  //Test case number: 8
  /*
   * 3 covered goals:
   * 1 Weak Mutation 32: com.sleepycat.je.tree.INDeleteInfo.readFromLog(Ljava/nio/ByteBuffer;B)V:82 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   * 2 com.sleepycat.je.tree.INDeleteInfo.readFromLog(Ljava/nio/ByteBuffer;B)V: root-Branch
   * 3 Weak Mutation 32: com.sleepycat.je.tree.INDeleteInfo.readFromLog(Ljava/nio/ByteBuffer;B)V:82 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   */
  @Test
  public void test8()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      // Undeclared exception!
      try {
        iNDeleteInfo0.readFromLog((ByteBuffer) null, (byte)19);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 9
  /*
   * 33 covered goals:
   * 1 Weak Mutation 39: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - ReplaceConstant - <INDeleteEntry node=" -> 
   * 2 Weak Mutation 43: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 3 Weak Mutation 40: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 4 Weak Mutation 41: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - InsertUnaryOp Negation
   * 5 Weak Mutation 44: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:91 - ReplaceConstant - "> -> 
   * 6 Weak Mutation 45: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:91 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 47: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 49: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 9 Weak Mutation 48: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 10 Weak Mutation 51: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp Negation of verbose
   * 11 Weak Mutation 50: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 12 Weak Mutation 54: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 13 Weak Mutation 53: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp IINC -1 verbose
   * 14 Weak Mutation 52: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp IINC 1 verbose
   * 15 Weak Mutation 55: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:94 - ReplaceConstant - </INDeleteEntry> -> 
   * 16 Weak Mutation 56: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:94 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 17 com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V: root-Branch
   * 18 Weak Mutation 39: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - ReplaceConstant - <INDeleteEntry node=" -> 
   * 19 Weak Mutation 43: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 20 Weak Mutation 40: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 41: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - InsertUnaryOp Negation
   * 22 Weak Mutation 47: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - ReplaceConstant - 0 -> 1
   * 23 Weak Mutation 44: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:91 - ReplaceConstant - "> -> 
   * 24 Weak Mutation 45: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:91 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 25 Weak Mutation 51: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp Negation of verbose
   * 26 Weak Mutation 50: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 27 Weak Mutation 49: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 28 Weak Mutation 48: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 29 Weak Mutation 55: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:94 - ReplaceConstant - </INDeleteEntry> -> 
   * 30 Weak Mutation 54: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 31 Weak Mutation 53: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp IINC -1 verbose
   * 32 Weak Mutation 52: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp IINC 1 verbose
   * 33 Weak Mutation 56: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:94 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   */
  @Test
  public void test9()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      StringBuffer stringBuffer0 = new StringBuffer(0);
      iNDeleteInfo0.dumpLog(stringBuffer0, true);
      assertEquals(90, stringBuffer0.capacity());
      assertEquals("<INDeleteEntry node=\"0\"><key v=\"<null>\"/><dbId id=\"0\"/></INDeleteEntry>", stringBuffer0.toString());
  }

  //Test case number: 10
  /*
   * 18 covered goals:
   * 1 Weak Mutation 42: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteField: deletedNodeIdJ
   * 2 Weak Mutation 46: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteField: deletedIdKey[B
   * 3 Weak Mutation 0: com.sleepycat.je.tree.INDeleteInfo.<init>(J[BLcom/sleepycat/je/dbi/DatabaseId;)V:22 - InsertUnaryOp Negation of deletedNodeId
   * 4 Weak Mutation 39: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - ReplaceConstant - <INDeleteEntry node=" -> 
   * 5 Weak Mutation 43: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 6 Weak Mutation 40: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 41: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - InsertUnaryOp Negation
   * 8 Weak Mutation 47: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - ReplaceConstant - 0 -> 1
   * 9 Weak Mutation 44: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:91 - ReplaceConstant - "> -> 
   * 10 Weak Mutation 45: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:91 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 11 Weak Mutation 51: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp Negation of verbose
   * 12 Weak Mutation 49: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 13 Weak Mutation 48: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 14 Weak Mutation 54: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 15 Weak Mutation 53: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp IINC -1 verbose
   * 16 Weak Mutation 52: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:93 - InsertUnaryOp IINC 1 verbose
   * 17 Weak Mutation 42: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:90 - DeleteField: deletedNodeIdJ
   * 18 Weak Mutation 46: com.sleepycat.je.tree.INDeleteInfo.dumpLog(Ljava/lang/StringBuffer;Z)V:92 - DeleteField: deletedIdKey[B
   */
  @Test
  public void test10()  throws Throwable  {
      byte[] byteArray0 = new byte[2];
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo(4294967280L, byteArray0, (DatabaseId) null);
      StringBuffer stringBuffer0 = new StringBuffer((int) (byte)0);
      // Undeclared exception!
      try {
        iNDeleteInfo0.dumpLog(stringBuffer0, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 11
  /*
   * 3 covered goals:
   * 1 Weak Mutation 57: com.sleepycat.je.tree.INDeleteInfo.logEntryIsTransactional()Z:100 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.INDeleteInfo.logEntryIsTransactional()Z: root-Branch
   * 3 Weak Mutation 57: com.sleepycat.je.tree.INDeleteInfo.logEntryIsTransactional()Z:100 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test11()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      boolean boolean0 = iNDeleteInfo0.logEntryIsTransactional();
      assertEquals(false, boolean0);
  }

  //Test case number: 12
  /*
   * 5 covered goals:
   * 1 Weak Mutation 59: com.sleepycat.je.tree.INDeleteInfo.getTransactionId()J:106 - ReplaceConstant - 0 -> -1
   * 2 Weak Mutation 58: com.sleepycat.je.tree.INDeleteInfo.getTransactionId()J:106 - ReplaceConstant - 0 -> 1
   * 3 com.sleepycat.je.tree.INDeleteInfo.getTransactionId()J: root-Branch
   * 4 Weak Mutation 59: com.sleepycat.je.tree.INDeleteInfo.getTransactionId()J:106 - ReplaceConstant - 0 -> -1
   * 5 Weak Mutation 58: com.sleepycat.je.tree.INDeleteInfo.getTransactionId()J:106 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test12()  throws Throwable  {
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo();
      long long0 = iNDeleteInfo0.getTransactionId();
      assertEquals(0L, long0);
  }
}
