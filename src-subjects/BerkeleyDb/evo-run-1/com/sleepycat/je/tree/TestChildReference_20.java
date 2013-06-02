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
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.tree.Node;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestChildReference_20 {


  //Test case number: 20
  /*
   * 39 covered goals:
   * 1 Weak Mutation 221: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - DeleteField: lsnJ
   * 2 Weak Mutation 207: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - ReplaceConstant - <ref knownDeleted=" -> 
   * 3 Weak Mutation 220: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - InsertUnaryOp Negation
   * 4 Weak Mutation 222: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - DeleteStatement: toString(J)Ljava/lang/String;
   * 5 Weak Mutation 223: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 6 Weak Mutation 216: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - DeleteField: key[B
   * 7 Weak Mutation 217: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 218: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 9 Weak Mutation 219: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 10 Weak Mutation 212: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:218 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 11 Weak Mutation 213: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:218 - DeleteStatement: append(Z)Ljava/lang/StringBuffer;
   * 12 Weak Mutation 214: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:219 - ReplaceConstant - "> -> 
   * 13 Weak Mutation 215: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:219 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 14 Weak Mutation 208: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 15 Weak Mutation 209: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - DeleteStatement: isKnownDeleted()Z
   * 16 Weak Mutation 210: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - DeleteStatement: append(Z)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 211: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:218 - ReplaceConstant - " pendingDeleted=" -> 
   * 18 Weak Mutation 225: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:222 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 19 Weak Mutation 224: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:222 - ReplaceConstant - </ref> -> 
   * 20 Weak Mutation 207: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - ReplaceConstant - <ref knownDeleted=" -> 
   * 21 Weak Mutation 220: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - InsertUnaryOp Negation
   * 22 Weak Mutation 221: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - DeleteField: lsnJ
   * 23 Weak Mutation 222: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - DeleteStatement: toString(J)Ljava/lang/String;
   * 24 Weak Mutation 223: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:221 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 25 Weak Mutation 216: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - DeleteField: key[B
   * 26 Weak Mutation 217: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - ReplaceConstant - 0 -> 1
   * 27 Weak Mutation 218: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 28 Weak Mutation 219: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:220 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 29 Weak Mutation 212: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:218 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 30 Weak Mutation 213: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:218 - DeleteStatement: append(Z)Ljava/lang/StringBuffer;
   * 31 Weak Mutation 214: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:219 - ReplaceConstant - "> -> 
   * 32 Weak Mutation 215: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:219 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 33 Weak Mutation 208: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 34 Weak Mutation 209: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - DeleteStatement: isKnownDeleted()Z
   * 35 Weak Mutation 210: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:217 - DeleteStatement: append(Z)Ljava/lang/StringBuffer;
   * 36 Weak Mutation 211: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:218 - ReplaceConstant - " pendingDeleted=" -> 
   * 37 Weak Mutation 225: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:222 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 38 Weak Mutation 224: com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V:222 - ReplaceConstant - </ref> -> 
   * 39 com.sleepycat.je.tree.ChildReference.dumpLog(Ljava/lang/StringBuffer;Z)V: root-Branch
   */
  @Test
  public void test20()  throws Throwable  {
      NameLN nameLN0 = new NameLN();
      byte[] byteArray0 = new byte[1];
      ChildReference childReference0 = new ChildReference((Node) nameLN0, byteArray0, 1L, (byte)0);
      StringBuffer stringBuffer0 = new StringBuffer((CharSequence) "");
      childReference0.dumpLog(stringBuffer0, false);
      assertEquals(142, stringBuffer0.capacity());
      assertEquals(4294971021L, nameLN0.getNextNodeId());
  }
}