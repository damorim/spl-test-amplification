/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Locker;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestLN_19 {


  //Test case number: 19
  /*
   * 42 covered goals:
   * 1 Weak Mutation 244: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:345 - DeleteField: data[B
   * 2 Weak Mutation 246: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:346 - ReplaceConstant - <data> -> 
   * 3 Weak Mutation 247: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:346 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 4 Weak Mutation 250: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:347 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 5 Weak Mutation 248: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:347 - DeleteField: data[B
   * 6 Weak Mutation 249: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:347 - DeleteStatement: dumpByteArray([B)Ljava/lang/String;
   * 7 Weak Mutation 252: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:348 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 8 Weak Mutation 251: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:348 - ReplaceConstant - </data> -> 
   * 9 com.sleepycat.je.tree.LN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V: root-Branch
   * 10 com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V: I17 Branch 16 IFNULL L345 - false
   * 11 Weak Mutation 239: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:343 - DeleteStatement: beginTag()Ljava/lang/String;
   * 12 Weak Mutation 254: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 255: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 253: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - InsertUnaryOp Negation
   * 15 Weak Mutation 245: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:345 - ReplaceComparisonOperator = null -> != null
   * 16 Weak Mutation 242: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:344 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 243: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:344 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 240: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:343 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 19 Weak Mutation 241: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:344 - InsertUnaryOp Negation
   * 20 Weak Mutation 258: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:351 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 256: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - DeleteStatement: dumpLogAdditional(Ljava/lang/StringBuffer;Z)V
   * 22 Weak Mutation 257: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:351 - DeleteStatement: endTag()Ljava/lang/String;
   * 23 Weak Mutation 239: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:343 - DeleteStatement: beginTag()Ljava/lang/String;
   * 24 Weak Mutation 254: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - InsertUnaryOp IINC 1
   * 25 Weak Mutation 255: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - InsertUnaryOp IINC -1
   * 26 Weak Mutation 252: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:348 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 27 Weak Mutation 253: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - InsertUnaryOp Negation
   * 28 Weak Mutation 250: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:347 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 29 Weak Mutation 251: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:348 - ReplaceConstant - </data> -> 
   * 30 Weak Mutation 248: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:347 - DeleteField: data[B
   * 31 Weak Mutation 249: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:347 - DeleteStatement: dumpByteArray([B)Ljava/lang/String;
   * 32 Weak Mutation 246: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:346 - ReplaceConstant - <data> -> 
   * 33 Weak Mutation 247: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:346 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 34 Weak Mutation 244: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:345 - DeleteField: data[B
   * 35 Weak Mutation 245: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:345 - ReplaceComparisonOperator = null -> != null
   * 36 Weak Mutation 242: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:344 - InsertUnaryOp IINC 1
   * 37 Weak Mutation 243: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:344 - InsertUnaryOp IINC -1
   * 38 Weak Mutation 240: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:343 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 39 Weak Mutation 241: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:344 - InsertUnaryOp Negation
   * 40 Weak Mutation 258: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:351 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 41 Weak Mutation 256: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:350 - DeleteStatement: dumpLogAdditional(Ljava/lang/StringBuffer;Z)V
   * 42 Weak Mutation 257: com.sleepycat.je.tree.LN.dumpLog(Ljava/lang/StringBuffer;Z)V:351 - DeleteStatement: endTag()Ljava/lang/String;
   */
  @Test
  public void test19()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN(0);
      assertNotNull(dupCountLN0);
      
      StringBuffer stringBuffer0 = new StringBuffer((int) (byte)82);
      dupCountLN0.dumpLog(stringBuffer0, true);
      assertEquals(75, stringBuffer0.length());
      assertEquals("<dupCountLN>\n  <count v=\"0\"/>\n  <node>4294970915</node>\n  <data></data>\n</dupCountLN>", dupCountLN0.toString());
  }
}