/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeLocation;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestNode_16 {


  //Test case number: 16
  /*
   * 15 covered goals:
   * 1 Weak Mutation 84: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:197 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 2 Weak Mutation 83: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:197 - ReplaceConstant - <node> -> 
   * 3 Weak Mutation 85: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:198 - InsertUnaryOp Negation
   * 4 Weak Mutation 87: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:198 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 5 Weak Mutation 86: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:198 - DeleteField: nodeIdJ
   * 6 Weak Mutation 89: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:199 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 88: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:199 - ReplaceConstant - </node> -> 
   * 8 com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V: root-Branch
   * 9 Weak Mutation 85: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:198 - InsertUnaryOp Negation
   * 10 Weak Mutation 84: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:197 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 11 Weak Mutation 87: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:198 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 12 Weak Mutation 86: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:198 - DeleteField: nodeIdJ
   * 13 Weak Mutation 83: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:197 - ReplaceConstant - <node> -> 
   * 14 Weak Mutation 89: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:199 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 15 Weak Mutation 88: com.sleepycat.je.tree.Node.dumpLog(Ljava/lang/StringBuffer;Z)V:199 - ReplaceConstant - </node> -> 
   */
  @Test
  public void test16()  throws Throwable  {
      StringBuffer stringBuffer0 = new StringBuffer(46);
      NameLN nameLN0 = new NameLN((DatabaseId) null);
      // Undeclared exception!
      try {
        nameLN0.dumpLog(stringBuffer0, false);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}