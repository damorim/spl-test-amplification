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
import com.sleepycat.je.tree.MapLN;

@RunWith(EvoSuiteRunner.class)
public class TestMapLN_1 {


  //Test case number: 1
  /*
   * 37 covered goals:
   * 1 Weak Mutation 2: com.sleepycat.je.tree.MapLN.isDeleted()Z:35 - DeleteField: deletedZ
   * 2 Weak Mutation 3: com.sleepycat.je.tree.MapLN.makeDeleted()V:38 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 4: com.sleepycat.je.tree.MapLN.makeDeleted()V:39 - DeleteField: databaseImplLcom/sleepycat/je/dbi/DatabaseImpl;
   * 4 Weak Mutation 5: com.sleepycat.je.tree.MapLN.makeDeleted()V:39 - DeleteStatement: getTree()Lcom/sleepycat/je/tree/Tree;
   * 5 Weak Mutation 6: com.sleepycat.je.tree.MapLN.makeDeleted()V:39 - DeleteStatement: setRoot(Lcom/sleepycat/je/tree/ChildReference;)V
   * 6 Weak Mutation 59: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> -
   * 7 Weak Mutation 58: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - DeleteStatement: getLogSize()I
   * 8 Weak Mutation 57: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - DeleteField: databaseImplLcom/sleepycat/je/dbi/DatabaseImpl;
   * 9 Weak Mutation 63: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - DeleteStatement: getBooleanLogSize()I
   * 10 Weak Mutation 62: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> *
   * 11 Weak Mutation 61: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> /
   * 12 Weak Mutation 60: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> %
   * 13 Weak Mutation 64: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> -
   * 14 Weak Mutation 65: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> %
   * 15 Weak Mutation 66: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> /
   * 16 Weak Mutation 67: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> *
   * 17 com.sleepycat.je.tree.MapLN.makeDeleted()V: root-Branch
   * 18 Weak Mutation 1: com.sleepycat.je.tree.MapLN.isDeleted()Z:35 - InsertUnaryOp Negation
   * 19 Weak Mutation 1: com.sleepycat.je.tree.MapLN.isDeleted()Z:35 - InsertUnaryOp Negation
   * 20 Weak Mutation 2: com.sleepycat.je.tree.MapLN.isDeleted()Z:35 - DeleteField: deletedZ
   * 21 Weak Mutation 3: com.sleepycat.je.tree.MapLN.makeDeleted()V:38 - ReplaceConstant - 1 -> 0
   * 22 Weak Mutation 4: com.sleepycat.je.tree.MapLN.makeDeleted()V:39 - DeleteField: databaseImplLcom/sleepycat/je/dbi/DatabaseImpl;
   * 23 Weak Mutation 5: com.sleepycat.je.tree.MapLN.makeDeleted()V:39 - DeleteStatement: getTree()Lcom/sleepycat/je/tree/Tree;
   * 24 Weak Mutation 6: com.sleepycat.je.tree.MapLN.makeDeleted()V:39 - DeleteStatement: setRoot(Lcom/sleepycat/je/tree/ChildReference;)V
   * 25 Weak Mutation 59: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> -
   * 26 Weak Mutation 58: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - DeleteStatement: getLogSize()I
   * 27 Weak Mutation 57: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - DeleteField: databaseImplLcom/sleepycat/je/dbi/DatabaseImpl;
   * 28 Weak Mutation 63: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - DeleteStatement: getBooleanLogSize()I
   * 29 Weak Mutation 62: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> *
   * 30 Weak Mutation 61: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> /
   * 31 Weak Mutation 60: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> %
   * 32 Weak Mutation 64: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> -
   * 33 Weak Mutation 65: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> %
   * 34 Weak Mutation 66: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> /
   * 35 Weak Mutation 67: com.sleepycat.je.tree.MapLN.getLogSize()I:90 - ReplaceArithmeticOperator + -> *
   * 36 com.sleepycat.je.tree.MapLN.getLogSize()I: root-Branch
   * 37 com.sleepycat.je.tree.MapLN.isDeleted()Z: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      MapLN mapLN0 = new MapLN();
      mapLN0.makeDeleted();
      int int0 = mapLN0.getLogSize();
      assertEquals("<mapLN>\n  <node>0</node>\n</mapLN>\n<deleted val=\"true\">\n<database id=\"0\"/>", mapLN0.toString());
      assertEquals(32, int0);
  }
}
