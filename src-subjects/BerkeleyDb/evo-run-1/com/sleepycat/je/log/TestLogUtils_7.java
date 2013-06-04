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
public class TestLogUtils_7 {


  //Test case number: 7
  /*
   * 43 covered goals:
   * 1 Weak Mutation 478: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 1
   * 2 Weak Mutation 479: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> -1
   * 3 Weak Mutation 476: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator >> -> <<
   * 4 Weak Mutation 477: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 0
   * 5 Weak Mutation 474: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 25
   * 6 Weak Mutation 475: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator >> -> >>>
   * 7 Weak Mutation 472: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> -1
   * 8 Weak Mutation 473: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 23
   * 9 Weak Mutation 470: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 0
   * 10 Weak Mutation 471: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 1
   * 11 Weak Mutation 468: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 469: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 467: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - InsertUnaryOp Negation
   * 14 Weak Mutation 481: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 256
   * 15 Weak Mutation 480: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 254
   * 16 Weak Mutation 483: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator & -> ^
   * 17 Weak Mutation 482: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator & -> |
   * 18 Weak Mutation 485: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 484: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - InsertUnaryOp Negation
   * 20 Weak Mutation 487: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - DeleteStatement: put(B)Ljava/nio/ByteBuffer;
   * 21 Weak Mutation 486: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - InsertUnaryOp IINC -1
   * 22 com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V: root-Branch
   * 23 Weak Mutation 478: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 1
   * 24 Weak Mutation 479: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> -1
   * 25 Weak Mutation 476: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator >> -> <<
   * 26 Weak Mutation 477: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 0
   * 27 Weak Mutation 474: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 25
   * 28 Weak Mutation 475: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator >> -> >>>
   * 29 Weak Mutation 472: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> -1
   * 30 Weak Mutation 473: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 23
   * 31 Weak Mutation 470: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 0
   * 32 Weak Mutation 471: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 24 -> 1
   * 33 Weak Mutation 468: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - InsertUnaryOp IINC 1
   * 34 Weak Mutation 469: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - InsertUnaryOp IINC -1
   * 35 Weak Mutation 467: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - InsertUnaryOp Negation
   * 36 Weak Mutation 485: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - InsertUnaryOp IINC 1
   * 37 Weak Mutation 484: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - InsertUnaryOp Negation
   * 38 Weak Mutation 487: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - DeleteStatement: put(B)Ljava/nio/ByteBuffer;
   * 39 Weak Mutation 486: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:85 - InsertUnaryOp IINC -1
   * 40 Weak Mutation 481: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 256
   * 41 Weak Mutation 480: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceConstant - 255 -> 254
   * 42 Weak Mutation 483: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator & -> ^
   * 43 Weak Mutation 482: com.sleepycat.je.log.LogUtils.writeIntMSB(Ljava/nio/ByteBuffer;I)V:84 - ReplaceBitwiseOperator & -> |
   */
  @Test
  public void test7()  throws Throwable  {
      // Undeclared exception!
      try {
        LogUtils.writeIntMSB((ByteBuffer) null, (int) (byte) (-75));
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
