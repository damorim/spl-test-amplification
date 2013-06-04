/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.INDupDeleteInfo;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestINDupDeleteInfo_9 {


  //Test case number: 9
  /*
   * 3 covered goals:
   * 1 Weak Mutation 41: com.sleepycat.je.tree.INDupDeleteInfo.readFromLog(Ljava/nio/ByteBuffer;B)V:88 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   * 2 com.sleepycat.je.tree.INDupDeleteInfo.readFromLog(Ljava/nio/ByteBuffer;B)V: root-Branch
   * 3 Weak Mutation 41: com.sleepycat.je.tree.INDupDeleteInfo.readFromLog(Ljava/nio/ByteBuffer;B)V:88 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   */
  @Test
  public void test9()  throws Throwable  {
      INDupDeleteInfo iNDupDeleteInfo0 = new INDupDeleteInfo();
      // Undeclared exception!
      try {
        iNDupDeleteInfo0.readFromLog((ByteBuffer) null, (byte) (-62));
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
