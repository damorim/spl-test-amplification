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
public class TestNode_10 {


  //Test case number: 10
  /*
   * 25 covered goals:
   * 1 Weak Mutation 63: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: getType()Ljava/lang/String;
   * 2 Weak Mutation 62: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 3 Weak Mutation 61: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - ReplaceConstant - < -> 
   * 4 Weak Mutation 68: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(J)Ljava/lang/StringBuilder;
   * 5 Weak Mutation 69: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: toString()Ljava/lang/String;
   * 6 Weak Mutation 64: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 7 Weak Mutation 65: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - ReplaceConstant - / -> 
   * 8 Weak Mutation 66: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 9 Weak Mutation 67: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: getNodeId()J
   * 10 Weak Mutation 70: com.sleepycat.je.tree.Node.getType()Ljava/lang/String;:152 - DeleteStatement: getClass()Ljava/lang/Class;
   * 11 Weak Mutation 71: com.sleepycat.je.tree.Node.getType()Ljava/lang/String;:152 - DeleteStatement: getName()Ljava/lang/String;
   * 12 com.sleepycat.je.tree.Node.getType()Ljava/lang/String;: root-Branch
   * 13 com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;: root-Branch
   * 14 Weak Mutation 22: com.sleepycat.je.tree.Node.getNodeId()J:59 - InsertUnaryOp Negation
   * 15 Weak Mutation 63: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: getType()Ljava/lang/String;
   * 16 Weak Mutation 62: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 17 Weak Mutation 61: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - ReplaceConstant - < -> 
   * 18 Weak Mutation 68: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(J)Ljava/lang/StringBuilder;
   * 19 Weak Mutation 69: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: toString()Ljava/lang/String;
   * 20 Weak Mutation 70: com.sleepycat.je.tree.Node.getType()Ljava/lang/String;:152 - DeleteStatement: getClass()Ljava/lang/Class;
   * 21 Weak Mutation 71: com.sleepycat.je.tree.Node.getType()Ljava/lang/String;:152 - DeleteStatement: getName()Ljava/lang/String;
   * 22 Weak Mutation 64: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 23 Weak Mutation 65: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - ReplaceConstant - / -> 
   * 24 Weak Mutation 66: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 25 Weak Mutation 67: com.sleepycat.je.tree.Node.shortDescription()Ljava/lang/String;:149 - DeleteStatement: getNodeId()J
   */
  @Test
  public void test10()  throws Throwable  {
      BIN bIN0 = new BIN();
      String string0 = bIN0.shortDescription();
      assertEquals(88L, bIN0.getNextNodeId());
      assertEquals("<com.sleepycat.je.tree.BIN/0", string0);
  }
}
