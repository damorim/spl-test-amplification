/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeLocation;

@RunWith(EvoSuiteRunner.class)
public class TestNode_8 {


  //Test case number: 8
  /*
   * 51 covered goals:
   * 1 Weak Mutation 31: com.sleepycat.je.tree.Node.toString()Ljava/lang/String;:125 - ReplaceConstant - 1 -> 0
   * 2 Weak Mutation 30: com.sleepycat.je.tree.Node.toString()Ljava/lang/String;:125 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 32: com.sleepycat.je.tree.Node.toString()Ljava/lang/String;:125 - DeleteStatement: dumpString(IZ)Ljava/lang/String;
   * 4 Weak Mutation 33: com.sleepycat.je.tree.Node.beginTag()Ljava/lang/String;:128 - ReplaceConstant - <node> -> 
   * 5 Weak Mutation 34: com.sleepycat.je.tree.Node.endTag()Ljava/lang/String;:131 - ReplaceConstant - </node> -> 
   * 6 Weak Mutation 42: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp Negation
   * 7 Weak Mutation 43: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 46: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 9 Weak Mutation 44: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 45: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - DeleteStatement: indent(I)Ljava/lang/String;
   * 11 Weak Mutation 47: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp Negation
   * 12 Weak Mutation 50: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - ReplaceComparisonOperator == -> !=
   * 13 Weak Mutation 49: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 48: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 51: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:140 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 16 Weak Mutation 54: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 52: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - InsertUnaryOp Negation
   * 18 Weak Mutation 55: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp Negation
   * 19 Weak Mutation 58: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - ReplaceComparisonOperator == -> !=
   * 20 Weak Mutation 57: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 56: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp IINC 1
   * 22 Weak Mutation 59: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:144 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 23 Weak Mutation 60: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:146 - DeleteStatement: toString()Ljava/lang/String;
   * 24 com.sleepycat.je.tree.Node.endTag()Ljava/lang/String;: root-Branch
   * 25 com.sleepycat.je.tree.Node.toString()Ljava/lang/String;: root-Branch
   * 26 com.sleepycat.je.tree.Node.beginTag()Ljava/lang/String;: root-Branch
   * 27 com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;: I16 Branch 3 IFEQ L139 - false
   * 28 com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;: I34 Branch 4 IFEQ L143 - false
   * 29 Weak Mutation 31: com.sleepycat.je.tree.Node.toString()Ljava/lang/String;:125 - ReplaceConstant - 1 -> 0
   * 30 Weak Mutation 30: com.sleepycat.je.tree.Node.toString()Ljava/lang/String;:125 - ReplaceConstant - 0 -> 1
   * 31 Weak Mutation 34: com.sleepycat.je.tree.Node.endTag()Ljava/lang/String;:131 - ReplaceConstant - </node> -> 
   * 32 Weak Mutation 32: com.sleepycat.je.tree.Node.toString()Ljava/lang/String;:125 - DeleteStatement: dumpString(IZ)Ljava/lang/String;
   * 33 Weak Mutation 33: com.sleepycat.je.tree.Node.beginTag()Ljava/lang/String;:128 - ReplaceConstant - <node> -> 
   * 34 Weak Mutation 42: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp Negation
   * 35 Weak Mutation 43: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp IINC 1
   * 36 Weak Mutation 46: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 37 Weak Mutation 47: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp Negation
   * 38 Weak Mutation 44: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp IINC -1
   * 39 Weak Mutation 45: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - DeleteStatement: indent(I)Ljava/lang/String;
   * 40 Weak Mutation 51: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:140 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 41 Weak Mutation 50: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - ReplaceComparisonOperator == -> !=
   * 42 Weak Mutation 49: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp IINC -1
   * 43 Weak Mutation 48: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp IINC 1
   * 44 Weak Mutation 55: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp Negation
   * 45 Weak Mutation 54: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 46 Weak Mutation 52: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - InsertUnaryOp Negation
   * 47 Weak Mutation 59: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:144 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 48 Weak Mutation 58: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - ReplaceComparisonOperator == -> !=
   * 49 Weak Mutation 57: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp IINC -1
   * 50 Weak Mutation 56: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp IINC 1
   * 51 Weak Mutation 60: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:146 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test8()  throws Throwable  {
      LN lN0 = new LN();
      String string0 = lN0.toString();
      assertEquals(14L, lN0.getLastId());
      assertEquals("<ln>\n  <node>0</node>\n</ln>", string0);
  }
}
