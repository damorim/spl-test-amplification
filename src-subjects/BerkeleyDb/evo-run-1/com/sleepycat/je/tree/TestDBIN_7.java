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
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DBINReference;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;

@RunWith(EvoSuiteRunner.class)
public class TestDBIN_7 {


  //Test case number: 7
  /*
   * 11 covered goals:
   * 1 Weak Mutation 19: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getNodeId()J
   * 2 Weak Mutation 21: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getId()Lcom/sleepycat/je/dbi/DatabaseId;
   * 3 Weak Mutation 20: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 4 Weak Mutation 23: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteField: dupKey[B
   * 5 Weak Mutation 22: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getIdentifierKey()[B
   * 6 com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;: root-Branch
   * 7 Weak Mutation 19: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getNodeId()J
   * 8 Weak Mutation 21: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getId()Lcom/sleepycat/je/dbi/DatabaseId;
   * 9 Weak Mutation 20: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 10 Weak Mutation 23: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteField: dupKey[B
   * 11 Weak Mutation 22: com.sleepycat.je.tree.DBIN.createReference()Lcom/sleepycat/je/tree/BINReference;:90 - DeleteStatement: getIdentifierKey()[B
   */
  @Test
  public void test7()  throws Throwable  {
      MapLN mapLN0 = new MapLN();
      DatabaseImpl databaseImpl0 = mapLN0.getDatabase();
      byte[] byteArray0 = new byte[3];
      DBIN dBIN0 = new DBIN(databaseImpl0, byteArray0, (int) (byte)1, byteArray0, (-263));
      DBINReference dBINReference0 = (DBINReference)dBIN0.createReference();
      assertEquals(4294970835L, databaseImpl0.getEofNodeId());
      assertEquals("idKey=key=<key v=\"0 0 0 \"/> nodeId = 4294970838 db=0 deletedKeys=null dupKey=<key v=\"0 0 0 \"/>", dBINReference0.toString());
  }
}
