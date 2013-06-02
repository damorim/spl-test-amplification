/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.DupCountLN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDupCountLN_13 {


  //Test case number: 13
  /*
   * 25 covered goals:
   * 1 Weak Mutation 146: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:130 - InsertUnaryOp Negation
   * 2 Weak Mutation 147: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:130 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 148: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:130 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 152: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - InsertUnaryOp +1
   * 5 Weak Mutation 153: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - InsertUnaryOp -1
   * 6 Weak Mutation 154: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteField: dupCountI
   * 7 Weak Mutation 155: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 8 Weak Mutation 156: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - ReplaceConstant - "/> -> 
   * 9 Weak Mutation 157: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 10 Weak Mutation 149: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - ReplaceConstant - <count v=" -> 
   * 11 Weak Mutation 150: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 12 Weak Mutation 151: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - InsertUnaryOp Negation
   * 13 com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V: root-Branch
   * 14 Weak Mutation 152: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - InsertUnaryOp +1
   * 15 Weak Mutation 153: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - InsertUnaryOp -1
   * 16 Weak Mutation 154: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteField: dupCountI
   * 17 Weak Mutation 155: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 18 Weak Mutation 156: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - ReplaceConstant - "/> -> 
   * 19 Weak Mutation 157: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 20 Weak Mutation 146: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:130 - InsertUnaryOp Negation
   * 21 Weak Mutation 147: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:130 - InsertUnaryOp IINC 1
   * 22 Weak Mutation 148: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:130 - InsertUnaryOp IINC -1
   * 23 Weak Mutation 149: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - ReplaceConstant - <count v=" -> 
   * 24 Weak Mutation 150: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 25 Weak Mutation 151: com.sleepycat.je.tree.DupCountLN.dumpLogAdditional(Ljava/lang/StringBuffer;Z)V:131 - InsertUnaryOp Negation
   */
  @Test
  public void test13()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN(864);
      StringBuffer stringBuffer0 = new StringBuffer("r");
      dupCountLN0.dumpLogAdditional(stringBuffer0, false);
      assertEquals(17, stringBuffer0.length());
      assertEquals(864, dupCountLN0.getDupCount());
  }
}