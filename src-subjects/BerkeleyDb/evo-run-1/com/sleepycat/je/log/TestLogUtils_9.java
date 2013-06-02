/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.LogUtils;
import java.nio.ByteBuffer;
import java.sql.Timestamp;

@RunWith(EvoSuiteRunner.class)
public class TestLogUtils_9 {


  //Test case number: 9
  /*
   * 18 covered goals:
   * 1 Weak Mutation 627: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:107 - InsertUnaryOp Negation
   * 2 Weak Mutation 628: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:107 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 631: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - InsertUnaryOp Negation
   * 4 Weak Mutation 634: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - DeleteStatement: put(B)Ljava/nio/ByteBuffer;
   * 5 Weak Mutation 633: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 632: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 875: com.sleepycat.je.log.LogUtils.writeTimestamp(Ljava/nio/ByteBuffer;Ljava/sql/Timestamp;)V:194 - DeleteStatement: getTime()J
   * 8 Weak Mutation 876: com.sleepycat.je.log.LogUtils.writeTimestamp(Ljava/nio/ByteBuffer;Ljava/sql/Timestamp;)V:194 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   * 9 com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V: root-Branch
   * 10 com.sleepycat.je.log.LogUtils.writeTimestamp(Ljava/nio/ByteBuffer;Ljava/sql/Timestamp;)V: root-Branch
   * 11 Weak Mutation 627: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:107 - InsertUnaryOp Negation
   * 12 Weak Mutation 631: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - InsertUnaryOp Negation
   * 13 Weak Mutation 628: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:107 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 634: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - DeleteStatement: put(B)Ljava/nio/ByteBuffer;
   * 15 Weak Mutation 633: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 632: com.sleepycat.je.log.LogUtils.writeLong(Ljava/nio/ByteBuffer;J)V:108 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 875: com.sleepycat.je.log.LogUtils.writeTimestamp(Ljava/nio/ByteBuffer;Ljava/sql/Timestamp;)V:194 - DeleteStatement: getTime()J
   * 18 Weak Mutation 876: com.sleepycat.je.log.LogUtils.writeTimestamp(Ljava/nio/ByteBuffer;Ljava/sql/Timestamp;)V:194 - DeleteStatement: writeLong(Ljava/nio/ByteBuffer;J)V
   */
  @Test
  public void test9()  throws Throwable  {
      Timestamp timestamp0 = new Timestamp(0L);
      // Undeclared exception!
      try {
        LogUtils.writeTimestamp((ByteBuffer) null, timestamp0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}