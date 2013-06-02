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
public class TestMapLN_0 {


  //Test case number: 0
  /*
   * 7 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.tree.MapLN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:25 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 7: com.sleepycat.je.tree.MapLN.getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;:46 - DeleteField: databaseImplLcom/sleepycat/je/dbi/DatabaseImpl;
   * 3 com.sleepycat.je.tree.MapLN.getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;: root-Branch
   * 4 com.sleepycat.je.tree.MapLN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;)V: root-Branch
   * 5 com.sleepycat.je.tree.MapLN.<init>()V: root-Branch
   * 6 Weak Mutation 0: com.sleepycat.je.tree.MapLN.<init>(Lcom/sleepycat/je/dbi/DatabaseImpl;)V:25 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 7: com.sleepycat.je.tree.MapLN.getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;:46 - DeleteField: databaseImplLcom/sleepycat/je/dbi/DatabaseImpl;
   */
  @Test
  public void test0()  throws Throwable  {
      MapLN mapLN0 = new MapLN();
      DatabaseImpl databaseImpl0 = mapLN0.getDatabase();
      MapLN mapLN1 = new MapLN(databaseImpl0);
      assertEquals(1001529L, mapLN0.getNextNodeId());
      assertEquals("<mapLN>\n  <node>1001527</node>\n  <data></data>\n</mapLN>\n<deleted val=\"false\">\n<database id=\"0\"/>", mapLN1.toString());
  }
}