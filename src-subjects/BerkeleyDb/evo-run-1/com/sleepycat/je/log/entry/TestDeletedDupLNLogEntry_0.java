/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.entry.DeletedDupLNLogEntry;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDeletedDupLNLogEntry_0 {


  //Test case number: 0
  /*
   * 19 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp Negation
   * 2 Weak Mutation 1: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 2: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 3: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp Negation
   * 5 Weak Mutation 4: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 5: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 6: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp Negation
   * 8 Weak Mutation 7: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 8: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC -1
   * 10 com.sleepycat.je.log.entry.DeletedDupLNLogEntry.<init>(Z)V: root-Branch
   * 11 Weak Mutation 0: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp Negation
   * 12 Weak Mutation 1: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 2: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 3: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp Negation
   * 15 Weak Mutation 4: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 5: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 6: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp Negation
   * 18 Weak Mutation 7: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 8: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:46 - InsertUnaryOp IINC -1
   */
  @Test
  public void test0()  throws Throwable  {
      DeletedDupLNLogEntry deletedDupLNLogEntry0 = new DeletedDupLNLogEntry(true);
      // Undeclared exception!
      try {
        deletedDupLNLogEntry0.readEntry((ByteBuffer) null, (int) (byte)0, (byte)22, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
