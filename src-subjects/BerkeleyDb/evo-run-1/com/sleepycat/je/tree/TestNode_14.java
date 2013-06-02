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
public class TestNode_14 {


  //Test case number: 14
  /*
   * 7 covered goals:
   * 1 Weak Mutation 79: com.sleepycat.je.tree.Node.writeToLog(Ljava/nio/ByteBuffer;)V:185 - InsertUnaryOp Negation
   * 2 Weak Mutation 81: com.sleepycat.je.tree.Node.writeToLog(Ljava/nio/ByteBuffer;)V:185 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   * 3 Weak Mutation 80: com.sleepycat.je.tree.Node.writeToLog(Ljava/nio/ByteBuffer;)V:185 - DeleteField: nodeIdJ
   * 4 com.sleepycat.je.tree.Node.writeToLog(Ljava/nio/ByteBuffer;)V: root-Branch
   * 5 Weak Mutation 79: com.sleepycat.je.tree.Node.writeToLog(Ljava/nio/ByteBuffer;)V:185 - InsertUnaryOp Negation
   * 6 Weak Mutation 81: com.sleepycat.je.tree.Node.writeToLog(Ljava/nio/ByteBuffer;)V:185 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   * 7 Weak Mutation 80: com.sleepycat.je.tree.Node.writeToLog(Ljava/nio/ByteBuffer;)V:185 - DeleteField: nodeIdJ
   */
  @Test
  public void test14()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      byte[] byteArray0 = new byte[8];
      DBIN dBIN0 = new DBIN(databaseImpl0, byteArray0, (int) (byte)0, byteArray0, 0);
      // Undeclared exception!
      try {
        dBIN0.writeToLog((ByteBuffer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}