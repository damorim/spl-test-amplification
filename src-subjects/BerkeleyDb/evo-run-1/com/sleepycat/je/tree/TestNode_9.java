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
public class TestNode_9 {


  //Test case number: 9
  /*
   * 37 covered goals:
   * 1 Weak Mutation 35: com.sleepycat.je.tree.Node.dump(I)V:134 - DeleteField: outLjava/io/PrintStream;
   * 2 Weak Mutation 38: com.sleepycat.je.tree.Node.dump(I)V:134 - InsertUnaryOp IINC -1
   * 3 Weak Mutation 39: com.sleepycat.je.tree.Node.dump(I)V:134 - ReplaceConstant - 1 -> 0
   * 4 Weak Mutation 36: com.sleepycat.je.tree.Node.dump(I)V:134 - InsertUnaryOp Negation
   * 5 Weak Mutation 37: com.sleepycat.je.tree.Node.dump(I)V:134 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 40: com.sleepycat.je.tree.Node.dump(I)V:134 - DeleteStatement: dumpString(IZ)Ljava/lang/String;
   * 7 Weak Mutation 41: com.sleepycat.je.tree.Node.dump(I)V:134 - DeleteStatement: print(Ljava/lang/String;)V
   * 8 Weak Mutation 53: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - DeleteField: nodeIdJ
   * 9 com.sleepycat.je.tree.Node.dump(I)V: root-Branch
   * 10 Weak Mutation 34: com.sleepycat.je.tree.Node.endTag()Ljava/lang/String;:131 - ReplaceConstant - </node> -> 
   * 11 Weak Mutation 33: com.sleepycat.je.tree.Node.beginTag()Ljava/lang/String;:128 - ReplaceConstant - <node> -> 
   * 12 Weak Mutation 42: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp Negation
   * 13 Weak Mutation 43: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp IINC 1
   * 14 Weak Mutation 46: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 15 Weak Mutation 47: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp Negation
   * 16 Weak Mutation 44: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 45: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:138 - DeleteStatement: indent(I)Ljava/lang/String;
   * 18 Weak Mutation 51: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:140 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 19 Weak Mutation 50: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - ReplaceComparisonOperator == -> !=
   * 20 Weak Mutation 49: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 48: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:139 - InsertUnaryOp IINC 1
   * 22 Weak Mutation 55: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp Negation
   * 23 Weak Mutation 54: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 24 Weak Mutation 52: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - InsertUnaryOp Negation
   * 25 Weak Mutation 59: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:144 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 26 Weak Mutation 58: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - ReplaceComparisonOperator == -> !=
   * 27 Weak Mutation 57: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp IINC -1
   * 28 Weak Mutation 56: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:143 - InsertUnaryOp IINC 1
   * 29 Weak Mutation 60: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:146 - DeleteStatement: toString()Ljava/lang/String;
   * 30 Weak Mutation 35: com.sleepycat.je.tree.Node.dump(I)V:134 - DeleteField: outLjava/io/PrintStream;
   * 31 Weak Mutation 38: com.sleepycat.je.tree.Node.dump(I)V:134 - InsertUnaryOp IINC -1
   * 32 Weak Mutation 39: com.sleepycat.je.tree.Node.dump(I)V:134 - ReplaceConstant - 1 -> 0
   * 33 Weak Mutation 36: com.sleepycat.je.tree.Node.dump(I)V:134 - InsertUnaryOp Negation
   * 34 Weak Mutation 37: com.sleepycat.je.tree.Node.dump(I)V:134 - InsertUnaryOp IINC 1
   * 35 Weak Mutation 40: com.sleepycat.je.tree.Node.dump(I)V:134 - DeleteStatement: dumpString(IZ)Ljava/lang/String;
   * 36 Weak Mutation 41: com.sleepycat.je.tree.Node.dump(I)V:134 - DeleteStatement: print(Ljava/lang/String;)V
   * 37 Weak Mutation 53: com.sleepycat.je.tree.Node.dumpString(IZ)Ljava/lang/String;:142 - DeleteField: nodeIdJ
   */
  @Test
  public void test9()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      MapLN mapLN0 = new MapLN(databaseImpl0);
      mapLN0.dump(44);
      assertEquals(69L, mapLN0.getNodeId());
      assertEquals("<com.sleepycat.je.tree.MapLN/69", mapLN0.shortDescription());
  }
}
