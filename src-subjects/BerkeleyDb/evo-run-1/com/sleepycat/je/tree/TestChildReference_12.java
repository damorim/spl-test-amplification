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

@RunWith(EvoSuiteRunner.class)
public class TestChildReference_12 {


  //Test case number: 12
  /*
   * 29 covered goals:
   * 1 Weak Mutation 84: com.sleepycat.je.tree.ChildReference.isPendingDeleted()Z:157 - DeleteField: stateB
   * 2 Weak Mutation 108: com.sleepycat.je.tree.ChildReference.isDirty()Z:169 - DeleteField: stateB
   * 3 Weak Mutation 118: com.sleepycat.je.tree.ChildReference.isDirty()Z:169 - ReplaceConstant - 1 -> 0
   * 4 Weak Mutation 115: com.sleepycat.je.tree.ChildReference.isDirty()Z:169 - ReplaceComparisonOperator == -> >=
   * 5 Weak Mutation 236: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:238 - ReplaceComparisonOperator != -> >
   * 6 Weak Mutation 250: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - DeleteStatement: dumpString(JI)Ljava/lang/String;
   * 7 Weak Mutation 251: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 8 Weak Mutation 248: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 249: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 246: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - DeleteField: lsnJ
   * 11 Weak Mutation 247: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp Negation
   * 12 Weak Mutation 245: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp Negation
   * 13 Weak Mutation 279: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:254 - DeleteField: targetLcom/sleepycat/je/tree/Node;
   * 14 com.sleepycat.je.tree.ChildReference.isDirty()Z: I6 Branch 8 IFEQ L169 - false
   * 15 com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;: I12 Branch 13 IFNE L238 - true
   * 16 com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;: I80 Branch 15 IFNONNULL L254 - true
   * 17 Weak Mutation 84: com.sleepycat.je.tree.ChildReference.isPendingDeleted()Z:157 - DeleteField: stateB
   * 18 Weak Mutation 108: com.sleepycat.je.tree.ChildReference.isDirty()Z:169 - DeleteField: stateB
   * 19 Weak Mutation 118: com.sleepycat.je.tree.ChildReference.isDirty()Z:169 - ReplaceConstant - 1 -> 0
   * 20 Weak Mutation 115: com.sleepycat.je.tree.ChildReference.isDirty()Z:169 - ReplaceComparisonOperator == -> >=
   * 21 Weak Mutation 236: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:238 - ReplaceComparisonOperator != -> >
   * 22 Weak Mutation 250: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - DeleteStatement: dumpString(JI)Ljava/lang/String;
   * 23 Weak Mutation 251: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 24 Weak Mutation 248: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp IINC 1
   * 25 Weak Mutation 249: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp IINC -1
   * 26 Weak Mutation 246: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - DeleteField: lsnJ
   * 27 Weak Mutation 247: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp Negation
   * 28 Weak Mutation 245: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:243 - InsertUnaryOp Negation
   * 29 Weak Mutation 279: com.sleepycat.je.tree.ChildReference.dumpString(IZ)Ljava/lang/String;:254 - DeleteField: targetLcom/sleepycat/je/tree/Node;
   */
  @Test
  public void test12()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN((-663));
      byte[] byteArray0 = new byte[1];
      ChildReference childReference0 = new ChildReference((Node) dupCountLN0, byteArray0, (long) (-663));
      String string0 = childReference0.toString();
      assertEquals("<com.sleepycat.je.tree.DupCountLN/4294970253", dupCountLN0.shortDescription());
      assertEquals("<DbLsn val=\"0xffffffff/0xfffffd69\"/>\n<key v=\"0 \"/>\n<dupCountLN>\n  <count v=\"-663\"/>\n  <node>4294970253</node>\n  <data></data>\n</dupCountLN>\n<knownDeleted val=\"false\"/><pendingDeleted val=\"false\"/><dirty val=\"true\"/>", string0);
  }
}