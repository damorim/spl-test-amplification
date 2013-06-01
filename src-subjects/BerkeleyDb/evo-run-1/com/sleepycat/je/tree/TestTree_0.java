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
import com.sleepycat.je.tree.Tree;

@RunWith(EvoSuiteRunner.class)
public class TestTree_0 {


  //Test case number: 0
  /*
   * 18 covered goals:
   * 1 Weak Mutation 4: com.sleepycat.je.tree.Tree.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:103 - DeleteStatement: setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V
   * 2 Weak Mutation 5: com.sleepycat.je.tree.Tree.<init>()V:110 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 6: com.sleepycat.je.tree.Tree.<init>()V:111 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 7: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:130 - DeleteStatement: getNodeMaxEntries()I
   * 5 Weak Mutation 8: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:131 - DeleteStatement: getNodeMaxDupTreeEntries()I
   * 6 Weak Mutation 9: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:132 - DeleteStatement: getDbEnvironment()Lcom/sleepycat/je/dbi/EnvironmentImpl;
   * 7 Weak Mutation 10: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:132 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   * 8 com.sleepycat.je.tree.Tree.<init>()V: root-Branch
   * 9 com.sleepycat.je.tree.Tree.init(Lcom/sleepycat/je/dbi/DatabaseImpl;)V: root-Branch
   * 10 com.sleepycat.je.tree.Tree.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;)V: root-Branch
   * 11 com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V: root-Branch
   * 12 Weak Mutation 4: com.sleepycat.je.tree.Tree.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:103 - DeleteStatement: setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V
   * 13 Weak Mutation 5: com.sleepycat.je.tree.Tree.<init>()V:110 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 6: com.sleepycat.je.tree.Tree.<init>()V:111 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 7: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:130 - DeleteStatement: getNodeMaxEntries()I
   * 16 Weak Mutation 8: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:131 - DeleteStatement: getNodeMaxDupTreeEntries()I
   * 17 Weak Mutation 9: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:132 - DeleteStatement: getDbEnvironment()Lcom/sleepycat/je/dbi/EnvironmentImpl;
   * 18 Weak Mutation 10: com.sleepycat.je.tree.Tree.setDatabase(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:132 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   */
  @Test
  public void test0()  throws Throwable  {
      MapLN mapLN0 = new MapLN();
      DatabaseImpl databaseImpl0 = mapLN0.getDatabase();
      Tree tree0 = null;
      try {
        tree0 = new Tree(databaseImpl0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
