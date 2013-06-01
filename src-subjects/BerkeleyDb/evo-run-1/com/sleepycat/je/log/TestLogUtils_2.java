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

@RunWith(EvoSuiteRunner.class)
public class TestLogUtils_2 {


  //Test case number: 2
  /*
   * 31 covered goals:
   * 1 Weak Mutation 237: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 236: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - InsertUnaryOp IINC -1
   * 3 Weak Mutation 235: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 234: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - InsertUnaryOp Negation
   * 5 Weak Mutation 246: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceBitwiseOperator & -> ^
   * 6 Weak Mutation 244: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 256
   * 7 Weak Mutation 245: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceBitwiseOperator & -> |
   * 8 Weak Mutation 242: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> -1
   * 9 Weak Mutation 243: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 254
   * 10 Weak Mutation 240: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 0
   * 11 Weak Mutation 241: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 1
   * 12 Weak Mutation 250: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - DeleteStatement: put(B)Ljava/nio/ByteBuffer;
   * 13 Weak Mutation 248: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - InsertUnaryOp IINC 1
   * 14 Weak Mutation 249: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - InsertUnaryOp IINC -1
   * 15 Weak Mutation 247: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - InsertUnaryOp Negation
   * 16 com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V: root-Branch
   * 17 Weak Mutation 237: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 236: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - InsertUnaryOp IINC -1
   * 19 Weak Mutation 235: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 234: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - InsertUnaryOp Negation
   * 21 Weak Mutation 250: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - DeleteStatement: put(B)Ljava/nio/ByteBuffer;
   * 22 Weak Mutation 248: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 249: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 246: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceBitwiseOperator & -> ^
   * 25 Weak Mutation 247: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:41 - InsertUnaryOp Negation
   * 26 Weak Mutation 244: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 256
   * 27 Weak Mutation 245: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceBitwiseOperator & -> |
   * 28 Weak Mutation 242: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> -1
   * 29 Weak Mutation 243: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 254
   * 30 Weak Mutation 240: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 0
   * 31 Weak Mutation 241: com.sleepycat.je.log.LogUtils.writeShort(Ljava/nio/ByteBuffer;S)V:40 - ReplaceConstant - 255 -> 1
   */
  @Test
  public void test2()  throws Throwable  {
      // Undeclared exception!
      try {
        LogUtils.writeShort((ByteBuffer) null, (short)1716);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
