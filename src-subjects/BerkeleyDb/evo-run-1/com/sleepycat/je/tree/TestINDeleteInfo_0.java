/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.tree.INDeleteInfo;

@RunWith(EvoSuiteRunner.class)
public class TestINDeleteInfo_0 {


  //Test case number: 0
  /*
   * 7 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - InsertUnaryOp Negation
   * 2 Weak Mutation 2: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - DeleteField: deletedNodeIdJ
   * 3 com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J: root-Branch
   * 4 Weak Mutation 0: com.sleepycat.je.tree.INDeleteInfo.<init>(J[BLcom/sleepycat/je/dbi/DatabaseId;)V:22 - InsertUnaryOp Negation
   * 5 Weak Mutation 1: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - InsertUnaryOp Negation
   * 6 Weak Mutation 2: com.sleepycat.je.tree.INDeleteInfo.getDeletedNodeId()J:33 - DeleteField: deletedNodeIdJ
   * 7 com.sleepycat.je.tree.INDeleteInfo.<init>(J[BLcom/sleepycat/je/dbi/DatabaseId;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      byte[] byteArray0 = new byte[11];
      DatabaseId databaseId0 = new DatabaseId((-984));
      INDeleteInfo iNDeleteInfo0 = new INDeleteInfo(216L, byteArray0, databaseId0);
      long long0 = iNDeleteInfo0.getDeletedNodeId();
      assertEquals(216L, long0);
  }
}
