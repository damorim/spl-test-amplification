/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogException;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseImpl_17 {


  //Test case number: 17
  /*
   * 65 covered goals:
   * 1 Weak Mutation 287: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1055 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 2 Weak Mutation 286: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1055 - ReplaceConstant - <database> -> 
   * 3 Weak Mutation 288: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 4 Weak Mutation 289: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - InsertUnaryOp Negation
   * 5 Weak Mutation 290: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 291: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 292: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 8 Weak Mutation 293: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - DeleteField: treeLcom/sleepycat/je/tree/Tree;
   * 9 Weak Mutation 294: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - InsertUnaryOp Negation
   * 10 Weak Mutation 295: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 296: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 297: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 13 Weak Mutation 298: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - ReplaceConstant - <dupsort v=" -> 
   * 14 Weak Mutation 299: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 15 Weak Mutation 300: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - InsertUnaryOp Negation
   * 16 Weak Mutation 302: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - DeleteStatement: append(Z)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 304: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1059 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 18 Weak Mutation 303: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1059 - ReplaceConstant - "/> -> 
   * 19 Weak Mutation 305: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1060 - ReplaceConstant - <btcf name=" -> 
   * 20 Weak Mutation 306: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1060 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 307: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1061 - DeleteField: btreeComparatorNameLjava/lang/String;
   * 22 Weak Mutation 308: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1061 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 23 Weak Mutation 309: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1062 - ReplaceConstant - "/> -> 
   * 24 Weak Mutation 310: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1062 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 25 Weak Mutation 311: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1063 - ReplaceConstant - <dupcf name=" -> 
   * 26 Weak Mutation 312: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1063 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 27 Weak Mutation 313: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1064 - DeleteField: duplicateComparatorNameLjava/lang/String;
   * 28 Weak Mutation 314: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1064 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 29 Weak Mutation 315: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1065 - ReplaceConstant - "/> -> 
   * 30 Weak Mutation 316: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1065 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 31 Weak Mutation 317: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1066 - ReplaceConstant - </database> -> 
   * 32 Weak Mutation 318: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1066 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 33 com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V: root-Branch
   * 34 Weak Mutation 287: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1055 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 35 Weak Mutation 286: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1055 - ReplaceConstant - <database> -> 
   * 36 Weak Mutation 305: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1060 - ReplaceConstant - <btcf name=" -> 
   * 37 Weak Mutation 304: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1059 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 38 Weak Mutation 307: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1061 - DeleteField: btreeComparatorNameLjava/lang/String;
   * 39 Weak Mutation 306: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1060 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 40 Weak Mutation 309: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1062 - ReplaceConstant - "/> -> 
   * 41 Weak Mutation 308: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1061 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 42 Weak Mutation 311: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1063 - ReplaceConstant - <dupcf name=" -> 
   * 43 Weak Mutation 310: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1062 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 44 Weak Mutation 313: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1064 - DeleteField: duplicateComparatorNameLjava/lang/String;
   * 45 Weak Mutation 312: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1063 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 46 Weak Mutation 315: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1065 - ReplaceConstant - "/> -> 
   * 47 Weak Mutation 314: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1064 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 48 Weak Mutation 317: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1066 - ReplaceConstant - </database> -> 
   * 49 Weak Mutation 316: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1065 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 50 Weak Mutation 318: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1066 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 51 Weak Mutation 288: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 52 Weak Mutation 289: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - InsertUnaryOp Negation
   * 53 Weak Mutation 290: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - InsertUnaryOp IINC 1
   * 54 Weak Mutation 291: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - InsertUnaryOp IINC -1
   * 55 Weak Mutation 292: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1056 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 56 Weak Mutation 293: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - DeleteField: treeLcom/sleepycat/je/tree/Tree;
   * 57 Weak Mutation 294: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - InsertUnaryOp Negation
   * 58 Weak Mutation 295: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - InsertUnaryOp IINC 1
   * 59 Weak Mutation 296: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - InsertUnaryOp IINC -1
   * 60 Weak Mutation 297: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1057 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 61 Weak Mutation 298: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - ReplaceConstant - <dupsort v=" -> 
   * 62 Weak Mutation 299: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 63 Weak Mutation 300: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - InsertUnaryOp Negation
   * 64 Weak Mutation 302: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1058 - DeleteStatement: append(Z)Ljava/lang/StringBuffer;
   * 65 Weak Mutation 303: com.sleepycat.je.dbi.DatabaseImpl.dumpLog(Ljava/lang/StringBuffer;Z)V:1059 - ReplaceConstant - "/> -> 
   */
  @Test
  public void test17()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      StringBuffer stringBuffer0 = new StringBuffer(22);
      databaseImpl0.dumpLog(stringBuffer0, true);
      assertEquals(190, stringBuffer0.capacity());
      assertEquals("<database><dbId id=\"0\"/><root></root><dupsort v=\"false\"/><btcf name=\"\"/><dupcf name=\"\"/></database>", stringBuffer0.toString());
  }
}