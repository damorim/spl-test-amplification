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
import com.sleepycat.je.tree.NameLN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestNameLN {


  //Test case number: 0
  /*
   * 29 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.tree.NameLN.isDeleted()Z:33 - InsertUnaryOp Negation
   * 2 Weak Mutation 63: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - DeleteStatement: getLogSize()I
   * 3 Weak Mutation 62: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 4 Weak Mutation 68: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - DeleteStatement: getBooleanLogSize()I
   * 5 Weak Mutation 69: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> -
   * 6 Weak Mutation 70: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> %
   * 7 Weak Mutation 71: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> /
   * 8 Weak Mutation 64: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> -
   * 9 Weak Mutation 65: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> %
   * 10 Weak Mutation 66: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> /
   * 11 Weak Mutation 67: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> *
   * 12 Weak Mutation 72: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> *
   * 13 com.sleepycat.je.tree.NameLN.getLogSize()I: root-Branch
   * 14 com.sleepycat.je.tree.NameLN.isDeleted()Z: root-Branch
   * 15 Weak Mutation 0: com.sleepycat.je.tree.NameLN.<init>(Lcom/sleepycat/je/dbi/DatabaseId;)V:23 - ReplaceConstant - 0 -> 1
   * 16 Weak Mutation 0: com.sleepycat.je.tree.NameLN.<init>(Lcom/sleepycat/je/dbi/DatabaseId;)V:23 - ReplaceConstant - 0 -> 1
   * 17 Weak Mutation 1: com.sleepycat.je.tree.NameLN.isDeleted()Z:33 - InsertUnaryOp Negation
   * 18 Weak Mutation 63: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - DeleteStatement: getLogSize()I
   * 19 Weak Mutation 62: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 20 Weak Mutation 68: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - DeleteStatement: getBooleanLogSize()I
   * 21 Weak Mutation 69: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> -
   * 22 Weak Mutation 70: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> %
   * 23 Weak Mutation 71: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> /
   * 24 Weak Mutation 64: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> -
   * 25 Weak Mutation 65: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> %
   * 26 Weak Mutation 66: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> /
   * 27 Weak Mutation 67: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> *
   * 28 Weak Mutation 72: com.sleepycat.je.tree.NameLN.getLogSize()I:83 - ReplaceArithmeticOperator + -> *
   * 29 com.sleepycat.je.tree.NameLN.<init>(Lcom/sleepycat/je/dbi/DatabaseId;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId((-2));
      NameLN nameLN0 = new NameLN(databaseId0);
      int int0 = nameLN0.getLogSize();
      assertEquals(4294967839L, nameLN0.getNodeId());
      assertEquals(18, int0);
  }

  //Test case number: 1
  /*
   * 7 covered goals:
   * 1 Weak Mutation 2: com.sleepycat.je.tree.NameLN.isDeleted()Z:33 - DeleteField: deletedZ
   * 2 Weak Mutation 3: com.sleepycat.je.tree.NameLN.makeDeleted()V:36 - ReplaceConstant - 1 -> 0
   * 3 com.sleepycat.je.tree.NameLN.<init>()V: root-Branch
   * 4 com.sleepycat.je.tree.NameLN.makeDeleted()V: root-Branch
   * 5 Weak Mutation 1: com.sleepycat.je.tree.NameLN.isDeleted()Z:33 - InsertUnaryOp Negation
   * 6 Weak Mutation 2: com.sleepycat.je.tree.NameLN.isDeleted()Z:33 - DeleteField: deletedZ
   * 7 Weak Mutation 3: com.sleepycat.je.tree.NameLN.makeDeleted()V:36 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test1()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      nameLN0.makeDeleted();
      boolean boolean0 = nameLN0.isDeleted();
      assertEquals(true, boolean0);
  }

  //Test case number: 2
  /*
   * 4 covered goals:
   * 1 com.sleepycat.je.tree.NameLN.setId(Lcom/sleepycat/je/dbi/DatabaseId;)V: root-Branch
   * 2 Weak Mutation 4: com.sleepycat.je.tree.NameLN.getId()Lcom/sleepycat/je/dbi/DatabaseId;:39 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 3 Weak Mutation 4: com.sleepycat.je.tree.NameLN.getId()Lcom/sleepycat/je/dbi/DatabaseId;:39 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 4 com.sleepycat.je.tree.NameLN.getId()Lcom/sleepycat/je/dbi/DatabaseId;: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      DatabaseId databaseId0 = nameLN0.getId();
      nameLN0.setId(databaseId0);
      assertEquals(4294967898L, nameLN0.getLastId());
      assertEquals(4294967898L, nameLN0.getNextNodeId());
  }

  //Test case number: 3
  /*
   * 115 covered goals:
   * 1 Weak Mutation 31: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteField: deletedZ
   * 2 Weak Mutation 3: com.sleepycat.je.tree.NameLN.makeDeleted()V:36 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 5: com.sleepycat.je.tree.NameLN.toString()Ljava/lang/String;:45 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 6: com.sleepycat.je.tree.NameLN.toString()Ljava/lang/String;:45 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 7: com.sleepycat.je.tree.NameLN.toString()Ljava/lang/String;:45 - DeleteStatement: dumpString(IZ)Ljava/lang/String;
   * 6 Weak Mutation 8: com.sleepycat.je.tree.NameLN.beginTag()Ljava/lang/String;:48 - ReplaceConstant - <nameLN> -> 
   * 7 Weak Mutation 9: com.sleepycat.je.tree.NameLN.endTag()Ljava/lang/String;:51 - ReplaceConstant - </nameLN> -> 
   * 8 Weak Mutation 10: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp Negation of nSpaces
   * 9 Weak Mutation 11: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC 1 nSpaces
   * 10 Weak Mutation 12: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC -1 nSpaces
   * 11 Weak Mutation 13: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp Negation of dumpTags
   * 12 Weak Mutation 14: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC 1 dumpTags
   * 13 Weak Mutation 15: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC -1 dumpTags
   * 14 Weak Mutation 17: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 0
   * 15 Weak Mutation 16: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 16 Weak Mutation 19: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> -1
   * 17 Weak Mutation 18: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 1
   * 18 Weak Mutation 21: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 11
   * 19 Weak Mutation 20: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 9
   * 20 Weak Mutation 23: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - InsertUnaryOp Negation of nSpaces
   * 21 Weak Mutation 22: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 22 Weak Mutation 25: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - InsertUnaryOp IINC -1 nSpaces
   * 23 Weak Mutation 24: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - InsertUnaryOp IINC 1 nSpaces
   * 24 Weak Mutation 27: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 25 Weak Mutation 26: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - DeleteStatement: indent(I)Ljava/lang/String;
   * 26 Weak Mutation 29: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 27 Weak Mutation 28: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - ReplaceConstant - <deleted val=" -> 
   * 28 Weak Mutation 30: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - InsertUnaryOp Negation
   * 29 Weak Mutation 34: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:59 - ReplaceConstant - "> -> 
   * 30 Weak Mutation 35: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:59 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 31 Weak Mutation 32: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteStatement: toString(Z)Ljava/lang/String;
   * 32 Weak Mutation 33: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 33 Weak Mutation 38: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> -1
   * 34 Weak Mutation 39: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 9
   * 35 Weak Mutation 36: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 0
   * 36 Weak Mutation 37: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 1
   * 37 Weak Mutation 42: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - InsertUnaryOp Negation of nSpaces
   * 38 Weak Mutation 43: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - InsertUnaryOp IINC 1 nSpaces
   * 39 Weak Mutation 40: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 11
   * 40 Weak Mutation 41: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 41 Weak Mutation 46: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 42 Weak Mutation 47: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - ReplaceConstant - <id val=" -> 
   * 43 Weak Mutation 44: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - InsertUnaryOp IINC -1 nSpaces
   * 44 Weak Mutation 45: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - DeleteStatement: indent(I)Ljava/lang/String;
   * 45 Weak Mutation 51: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:63 - ReplaceConstant - "> -> 
   * 46 Weak Mutation 50: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 47 Weak Mutation 49: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 48 Weak Mutation 48: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 49 Weak Mutation 55: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> -1
   * 50 Weak Mutation 54: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 1
   * 51 Weak Mutation 53: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 0
   * 52 Weak Mutation 52: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:63 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 53 Weak Mutation 59: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:65 - DeleteStatement: toString()Ljava/lang/String;
   * 54 Weak Mutation 58: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 55 Weak Mutation 57: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 11
   * 56 Weak Mutation 56: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 9
   * 57 Weak Mutation 5: com.sleepycat.je.tree.NameLN.toString()Ljava/lang/String;:45 - ReplaceConstant - 0 -> 1
   * 58 Weak Mutation 6: com.sleepycat.je.tree.NameLN.toString()Ljava/lang/String;:45 - ReplaceConstant - 1 -> 0
   * 59 Weak Mutation 7: com.sleepycat.je.tree.NameLN.toString()Ljava/lang/String;:45 - DeleteStatement: dumpString(IZ)Ljava/lang/String;
   * 60 Weak Mutation 8: com.sleepycat.je.tree.NameLN.beginTag()Ljava/lang/String;:48 - ReplaceConstant - <nameLN> -> 
   * 61 Weak Mutation 9: com.sleepycat.je.tree.NameLN.endTag()Ljava/lang/String;:51 - ReplaceConstant - </nameLN> -> 
   * 62 Weak Mutation 10: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp Negation of nSpaces
   * 63 Weak Mutation 11: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC 1 nSpaces
   * 64 Weak Mutation 12: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC -1 nSpaces
   * 65 Weak Mutation 13: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp Negation of dumpTags
   * 66 Weak Mutation 14: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC 1 dumpTags
   * 67 Weak Mutation 15: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - InsertUnaryOp IINC -1 dumpTags
   * 68 Weak Mutation 17: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 0
   * 69 Weak Mutation 16: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:55 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 70 Weak Mutation 19: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> -1
   * 71 Weak Mutation 18: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 1
   * 72 Weak Mutation 21: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 11
   * 73 Weak Mutation 20: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - ReplaceConstant - 10 -> 9
   * 74 Weak Mutation 23: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - InsertUnaryOp Negation of nSpaces
   * 75 Weak Mutation 22: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:56 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 76 Weak Mutation 25: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - InsertUnaryOp IINC -1 nSpaces
   * 77 Weak Mutation 24: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - InsertUnaryOp IINC 1 nSpaces
   * 78 Weak Mutation 27: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 79 Weak Mutation 26: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:57 - DeleteStatement: indent(I)Ljava/lang/String;
   * 80 Weak Mutation 29: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 81 Weak Mutation 28: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - ReplaceConstant - <deleted val=" -> 
   * 82 Weak Mutation 31: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteField: deletedZ
   * 83 Weak Mutation 30: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - InsertUnaryOp Negation
   * 84 Weak Mutation 34: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:59 - ReplaceConstant - "> -> 
   * 85 Weak Mutation 35: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:59 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 86 Weak Mutation 32: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteStatement: toString(Z)Ljava/lang/String;
   * 87 Weak Mutation 33: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:58 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 88 Weak Mutation 38: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> -1
   * 89 Weak Mutation 39: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 9
   * 90 Weak Mutation 36: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 0
   * 91 Weak Mutation 37: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 1
   * 92 Weak Mutation 42: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - InsertUnaryOp Negation of nSpaces
   * 93 Weak Mutation 43: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - InsertUnaryOp IINC 1 nSpaces
   * 94 Weak Mutation 40: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - ReplaceConstant - 10 -> 11
   * 95 Weak Mutation 41: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:60 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 96 Weak Mutation 46: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 97 Weak Mutation 47: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - ReplaceConstant - <id val=" -> 
   * 98 Weak Mutation 44: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - InsertUnaryOp IINC -1 nSpaces
   * 99 Weak Mutation 45: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:61 - DeleteStatement: indent(I)Ljava/lang/String;
   * 100 Weak Mutation 51: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:63 - ReplaceConstant - "> -> 
   * 101 Weak Mutation 50: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 102 Weak Mutation 49: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 103 Weak Mutation 48: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:62 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 104 Weak Mutation 55: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> -1
   * 105 Weak Mutation 54: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 1
   * 106 Weak Mutation 53: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 0
   * 107 Weak Mutation 52: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:63 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 108 Weak Mutation 59: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:65 - DeleteStatement: toString()Ljava/lang/String;
   * 109 Weak Mutation 58: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 110 Weak Mutation 57: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 11
   * 111 Weak Mutation 56: com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;:64 - ReplaceConstant - 10 -> 9
   * 112 com.sleepycat.je.tree.NameLN.beginTag()Ljava/lang/String;: root-Branch
   * 113 com.sleepycat.je.tree.NameLN.endTag()Ljava/lang/String;: root-Branch
   * 114 com.sleepycat.je.tree.NameLN.dumpString(IZ)Ljava/lang/String;: root-Branch
   * 115 com.sleepycat.je.tree.NameLN.toString()Ljava/lang/String;: root-Branch
   */
  @Test
  public void test3()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      nameLN0.makeDeleted();
      String string0 = nameLN0.toString();
      assertEquals(true, nameLN0.isDeleted());
      assertEquals("<nameLN>\n  <node>0</node>\n</nameLN>\n<deleted val=\"true\">\n<id val=\"0\">\n", string0);
  }

  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 60: com.sleepycat.je.tree.NameLN.getTransactionalLogType()Lcom/sleepycat/je/log/LogEntryType;:71 - DeleteField: LOG_NAMELN_TRANSACTIONALLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.tree.NameLN.getTransactionalLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 60: com.sleepycat.je.tree.NameLN.getTransactionalLogType()Lcom/sleepycat/je/log/LogEntryType;:71 - DeleteField: LOG_NAMELN_TRANSACTIONALLcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test4()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      LogEntryType logEntryType0 = nameLN0.getTransactionalLogType();
      assertNotNull(logEntryType0);
      assertEquals(4294968074L, nameLN0.getNextNodeId());
  }

  //Test case number: 5
  /*
   * 3 covered goals:
   * 1 Weak Mutation 61: com.sleepycat.je.tree.NameLN.getLogType()Lcom/sleepycat/je/log/LogEntryType;:77 - DeleteField: LOG_NAMELNLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.tree.NameLN.getLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 61: com.sleepycat.je.tree.NameLN.getLogType()Lcom/sleepycat/je/log/LogEntryType;:77 - DeleteField: LOG_NAMELNLcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test5()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      LogEntryType logEntryType0 = nameLN0.getLogType();
      assertNotNull(logEntryType0);
      assertEquals(4294968078L, nameLN0.getLastId());
  }

  //Test case number: 6
  /*
   * 7 covered goals:
   * 1 Weak Mutation 78: com.sleepycat.je.tree.NameLN.readFromLog(Ljava/nio/ByteBuffer;B)V:97 - InsertUnaryOp Negation of entryTypeVersion
   * 2 Weak Mutation 79: com.sleepycat.je.tree.NameLN.readFromLog(Ljava/nio/ByteBuffer;B)V:97 - InsertUnaryOp IINC 1 entryTypeVersion
   * 3 Weak Mutation 80: com.sleepycat.je.tree.NameLN.readFromLog(Ljava/nio/ByteBuffer;B)V:97 - InsertUnaryOp IINC -1 entryTypeVersion
   * 4 com.sleepycat.je.tree.NameLN.readFromLog(Ljava/nio/ByteBuffer;B)V: root-Branch
   * 5 Weak Mutation 78: com.sleepycat.je.tree.NameLN.readFromLog(Ljava/nio/ByteBuffer;B)V:97 - InsertUnaryOp Negation of entryTypeVersion
   * 6 Weak Mutation 79: com.sleepycat.je.tree.NameLN.readFromLog(Ljava/nio/ByteBuffer;B)V:97 - InsertUnaryOp IINC 1 entryTypeVersion
   * 7 Weak Mutation 80: com.sleepycat.je.tree.NameLN.readFromLog(Ljava/nio/ByteBuffer;B)V:97 - InsertUnaryOp IINC -1 entryTypeVersion
   */
  @Test
  public void test6()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      // Undeclared exception!
      try {
        nameLN0.readFromLog((ByteBuffer) null, (byte) (-12));
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 7
  /*
   * 7 covered goals:
   * 1 Weak Mutation 87: com.sleepycat.je.tree.NameLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:106 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 2 Weak Mutation 89: com.sleepycat.je.tree.NameLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:106 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 3 Weak Mutation 88: com.sleepycat.je.tree.NameLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:106 - ReplaceConstant - 1 -> 0
   * 4 com.sleepycat.je.tree.NameLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V: root-Branch
   * 5 Weak Mutation 87: com.sleepycat.je.tree.NameLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:106 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 6 Weak Mutation 89: com.sleepycat.je.tree.NameLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:106 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 7 Weak Mutation 88: com.sleepycat.je.tree.NameLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:106 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test7()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      // Undeclared exception!
      try {
        nameLN0.dumpLogAdditional((StringBuffer) null, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
