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
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestLN_13 {


  //Test case number: 13
  /*
   * 81 covered goals:
   * 1 Weak Mutation 139: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:212 - DeleteField: data[B
   * 2 Weak Mutation 141: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - InsertUnaryOp Negation
   * 3 Weak Mutation 143: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 142: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 152: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - DeleteStatement: indent(I)Ljava/lang/String;
   * 6 Weak Mutation 153: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 144: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> 0
   * 8 Weak Mutation 145: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> 1
   * 9 Weak Mutation 146: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> -1
   * 10 Weak Mutation 147: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> 3
   * 11 Weak Mutation 148: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> -
   * 12 Weak Mutation 149: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> %
   * 13 Weak Mutation 150: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> /
   * 14 Weak Mutation 151: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> *
   * 15 Weak Mutation 154: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:214 - ReplaceConstant - <data> -> 
   * 16 Weak Mutation 155: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:214 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 156: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:215 - DeleteField: data[B
   * 18 Weak Mutation 157: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:215 - DeleteStatement: dumpByteArray([B)Ljava/lang/String;
   * 19 Weak Mutation 158: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:215 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 20 Weak Mutation 159: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:216 - ReplaceConstant - </data> -> 
   * 21 Weak Mutation 160: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:216 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 22 Weak Mutation 163: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> -1
   * 23 Weak Mutation 162: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 1
   * 24 Weak Mutation 161: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 0
   * 25 Weak Mutation 166: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 26 Weak Mutation 165: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 11
   * 27 Weak Mutation 164: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 9
   * 28 com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;: I9 Branch 8 IFEQ L205 - true
   * 29 com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;: I51 Branch 9 IFNULL L212 - false
   * 30 com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;: I90 Branch 10 IFEQ L219 - true
   * 31 Weak Mutation 103: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:205 - InsertUnaryOp Negation
   * 32 Weak Mutation 106: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:205 - ReplaceComparisonOperator == -> !=
   * 33 Weak Mutation 104: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:205 - InsertUnaryOp IINC 1
   * 34 Weak Mutation 105: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:205 - InsertUnaryOp IINC -1
   * 35 Weak Mutation 127: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceArithmeticOperator + -> -
   * 36 Weak Mutation 126: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceConstant - 2 -> 3
   * 37 Weak Mutation 125: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceConstant - 2 -> -1
   * 38 Weak Mutation 124: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceConstant - 2 -> 1
   * 39 Weak Mutation 123: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceConstant - 2 -> 0
   * 40 Weak Mutation 122: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - InsertUnaryOp IINC -1
   * 41 Weak Mutation 121: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - InsertUnaryOp IINC 1
   * 42 Weak Mutation 120: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - InsertUnaryOp Negation
   * 43 Weak Mutation 137: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:211 - ReplaceConstant - 10 -> 11
   * 44 Weak Mutation 136: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:211 - ReplaceConstant - 10 -> 9
   * 45 Weak Mutation 138: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:211 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 46 Weak Mutation 140: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:212 - ReplaceComparisonOperator = null -> != null
   * 47 Weak Mutation 129: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceArithmeticOperator + -> /
   * 48 Weak Mutation 128: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceArithmeticOperator + -> %
   * 49 Weak Mutation 131: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceConstant - 1 -> 0
   * 50 Weak Mutation 130: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - ReplaceArithmeticOperator + -> *
   * 51 Weak Mutation 133: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:211 - ReplaceConstant - 10 -> 0
   * 52 Weak Mutation 132: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:210 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 53 Weak Mutation 135: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:211 - ReplaceConstant - 10 -> -1
   * 54 Weak Mutation 134: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:211 - ReplaceConstant - 10 -> 1
   * 55 Weak Mutation 139: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:212 - DeleteField: data[B
   * 56 Weak Mutation 141: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - InsertUnaryOp Negation
   * 57 Weak Mutation 143: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - InsertUnaryOp IINC -1
   * 58 Weak Mutation 142: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - InsertUnaryOp IINC 1
   * 59 Weak Mutation 152: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - DeleteStatement: indent(I)Ljava/lang/String;
   * 60 Weak Mutation 153: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 61 Weak Mutation 154: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:214 - ReplaceConstant - <data> -> 
   * 62 Weak Mutation 155: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:214 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 63 Weak Mutation 156: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:215 - DeleteField: data[B
   * 64 Weak Mutation 157: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:215 - DeleteStatement: dumpByteArray([B)Ljava/lang/String;
   * 65 Weak Mutation 158: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:215 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 66 Weak Mutation 159: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:216 - ReplaceConstant - </data> -> 
   * 67 Weak Mutation 144: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> 0
   * 68 Weak Mutation 145: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> 1
   * 69 Weak Mutation 146: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> -1
   * 70 Weak Mutation 147: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceConstant - 2 -> 3
   * 71 Weak Mutation 148: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> -
   * 72 Weak Mutation 149: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> %
   * 73 Weak Mutation 150: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> /
   * 74 Weak Mutation 151: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:213 - ReplaceArithmeticOperator + -> *
   * 75 Weak Mutation 163: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> -1
   * 76 Weak Mutation 162: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 1
   * 77 Weak Mutation 161: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 0
   * 78 Weak Mutation 160: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:216 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 79 Weak Mutation 166: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 80 Weak Mutation 165: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 11
   * 81 Weak Mutation 164: com.sleepycat.je.tree.LN.dumpString(IZ)Ljava/lang/String;:217 - ReplaceConstant - 10 -> 9
   */
  @Test
  public void test13()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN((-1948));
      assertNotNull(dupCountLN0);
      
      String string0 = dupCountLN0.dumpString(0, true);
      assertEquals("<com.sleepycat.je.tree.DupCountLN/4294970466", dupCountLN0.shortDescription());
      assertEquals("<dupCountLN>\n  <count v=\"-1948\"/>\n  <node>4294970466</node>\n  <data></data>\n</dupCountLN>", string0);
  }
}
