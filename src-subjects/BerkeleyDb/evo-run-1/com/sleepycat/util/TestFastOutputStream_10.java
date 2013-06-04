/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.util.FastOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

@RunWith(EvoSuiteRunner.class)
public class TestFastOutputStream_10 {


  //Test case number: 10
  /*
   * 31 covered goals:
   * 1 Weak Mutation 125: com.sleepycat.util.FastOutputStream.writeFast([B)V:127 - ReplaceComparisonOperator <= -> ==
   * 2 Weak Mutation 35: com.sleepycat.util.FastOutputStream.write([B)V:87 - DeleteStatement: writeFast([B)V
   * 3 Weak Mutation 110: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - InsertUnaryOp +1
   * 4 Weak Mutation 111: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - InsertUnaryOp -1
   * 5 Weak Mutation 109: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - InsertUnaryOp Negation
   * 6 Weak Mutation 119: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator - -> %
   * 7 Weak Mutation 118: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator - -> +
   * 8 Weak Mutation 117: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - DeleteField: buf[B
   * 9 Weak Mutation 116: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator + -> *
   * 10 Weak Mutation 115: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator + -> /
   * 11 Weak Mutation 114: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator + -> %
   * 12 Weak Mutation 113: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator + -> -
   * 13 Weak Mutation 124: com.sleepycat.util.FastOutputStream.writeFast([B)V:127 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 123: com.sleepycat.util.FastOutputStream.writeFast([B)V:127 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 122: com.sleepycat.util.FastOutputStream.writeFast([B)V:127 - InsertUnaryOp Negation
   * 16 Weak Mutation 121: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator - -> *
   * 17 Weak Mutation 120: com.sleepycat.util.FastOutputStream.writeFast([B)V:126 - ReplaceArithmeticOperator - -> /
   * 18 Weak Mutation 137: com.sleepycat.util.FastOutputStream.writeFast([B)V:128 - DeleteStatement: arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
   * 19 Weak Mutation 139: com.sleepycat.util.FastOutputStream.writeFast([B)V:129 - InsertUnaryOp +1
   * 20 Weak Mutation 138: com.sleepycat.util.FastOutputStream.writeFast([B)V:129 - InsertUnaryOp Negation
   * 21 Weak Mutation 140: com.sleepycat.util.FastOutputStream.writeFast([B)V:129 - InsertUnaryOp -1
   * 22 Weak Mutation 143: com.sleepycat.util.FastOutputStream.writeFast([B)V:129 - ReplaceArithmeticOperator + -> %
   * 23 Weak Mutation 142: com.sleepycat.util.FastOutputStream.writeFast([B)V:129 - ReplaceArithmeticOperator + -> -
   * 24 Weak Mutation 131: com.sleepycat.util.FastOutputStream.writeFast([B)V:128 - ReplaceConstant - 0 -> 1
   * 25 Weak Mutation 133: com.sleepycat.util.FastOutputStream.writeFast([B)V:128 - InsertUnaryOp Negation
   * 26 Weak Mutation 132: com.sleepycat.util.FastOutputStream.writeFast([B)V:128 - DeleteField: buf[B
   * 27 Weak Mutation 135: com.sleepycat.util.FastOutputStream.writeFast([B)V:128 - InsertUnaryOp -1
   * 28 Weak Mutation 134: com.sleepycat.util.FastOutputStream.writeFast([B)V:128 - InsertUnaryOp +1
   * 29 Weak Mutation 144: com.sleepycat.util.FastOutputStream.writeFast([B)V:129 - ReplaceArithmeticOperator + -> /
   * 30 Weak Mutation 145: com.sleepycat.util.FastOutputStream.writeFast([B)V:129 - ReplaceArithmeticOperator + -> *
   * 31 Weak Mutation 125: com.sleepycat.util.FastOutputStream.writeFast([B)V:127 - ReplaceComparisonOperator <= -> ==
   */
  @Test
  public void test10()  throws Throwable  {
      FastOutputStream fastOutputStream0 = new FastOutputStream(1819, (int) (byte)0);
      assertNotNull(fastOutputStream0);
      
      byte[] byteArray0 = new byte[1];
      fastOutputStream0.write(byteArray0);
      assertEquals("\u0000", fastOutputStream0.toString());
      assertEquals(1, fastOutputStream0.size());
  }
}
