/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.util.FastInputStream;

@RunWith(EvoSuiteRunner.class)
public class TestFastInputStream_2 {


  //Test case number: 2
  /*
   * 52 covered goals:
   * 1 Weak Mutation 13: com.sleepycat.util.FastInputStream.available()I:39 - DeleteField: offI
   * 2 Weak Mutation 14: com.sleepycat.util.FastInputStream.available()I:39 - ReplaceArithmeticOperator - -> +
   * 3 Weak Mutation 17: com.sleepycat.util.FastInputStream.available()I:39 - ReplaceArithmeticOperator - -> *
   * 4 Weak Mutation 26: com.sleepycat.util.FastInputStream.skip(J)J:51 - InsertUnaryOp Negation
   * 5 Weak Mutation 27: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp Negation
   * 6 Weak Mutation 29: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 28: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 31: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp +1
   * 9 Weak Mutation 30: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp Negation
   * 10 Weak Mutation 35: com.sleepycat.util.FastInputStream.skip(J)J:52 - ReplaceArithmeticOperator + -> %
   * 11 Weak Mutation 32: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp -1
   * 12 Weak Mutation 38: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp Negation
   * 13 Weak Mutation 39: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp +1
   * 14 Weak Mutation 36: com.sleepycat.util.FastInputStream.skip(J)J:52 - ReplaceArithmeticOperator + -> /
   * 15 Weak Mutation 40: com.sleepycat.util.FastInputStream.skip(J)J:52 - InsertUnaryOp -1
   * 16 Weak Mutation 41: com.sleepycat.util.FastInputStream.skip(J)J:52 - DeleteField: lenI
   * 17 Weak Mutation 44: com.sleepycat.util.FastInputStream.skip(J)J:52 - ReplaceComparisonOperator <= -> -1
   * 18 Weak Mutation 46: com.sleepycat.util.FastInputStream.skip(J)J:53 - InsertUnaryOp +1
   * 19 Weak Mutation 47: com.sleepycat.util.FastInputStream.skip(J)J:53 - InsertUnaryOp -1
   * 20 Weak Mutation 45: com.sleepycat.util.FastInputStream.skip(J)J:53 - InsertUnaryOp Negation
   * 21 Weak Mutation 51: com.sleepycat.util.FastInputStream.skip(J)J:53 - InsertUnaryOp -1
   * 22 Weak Mutation 50: com.sleepycat.util.FastInputStream.skip(J)J:53 - InsertUnaryOp +1
   * 23 Weak Mutation 49: com.sleepycat.util.FastInputStream.skip(J)J:53 - InsertUnaryOp Negation
   * 24 Weak Mutation 48: com.sleepycat.util.FastInputStream.skip(J)J:53 - DeleteField: lenI
   * 25 Weak Mutation 55: com.sleepycat.util.FastInputStream.skip(J)J:53 - ReplaceArithmeticOperator - -> /
   * 26 Weak Mutation 54: com.sleepycat.util.FastInputStream.skip(J)J:53 - ReplaceArithmeticOperator - -> %
   * 27 Weak Mutation 59: com.sleepycat.util.FastInputStream.skip(J)J:55 - InsertUnaryOp -1
   * 28 Weak Mutation 58: com.sleepycat.util.FastInputStream.skip(J)J:55 - InsertUnaryOp +1
   * 29 Weak Mutation 57: com.sleepycat.util.FastInputStream.skip(J)J:55 - InsertUnaryOp Negation
   * 30 Weak Mutation 63: com.sleepycat.util.FastInputStream.skip(J)J:55 - InsertUnaryOp IINC -1
   * 31 Weak Mutation 62: com.sleepycat.util.FastInputStream.skip(J)J:55 - InsertUnaryOp IINC 1
   * 32 Weak Mutation 61: com.sleepycat.util.FastInputStream.skip(J)J:55 - InsertUnaryOp Negation
   * 33 Weak Mutation 64: com.sleepycat.util.FastInputStream.skip(J)J:55 - ReplaceArithmeticOperator + -> -
   * 34 Weak Mutation 65: com.sleepycat.util.FastInputStream.skip(J)J:55 - ReplaceArithmeticOperator + -> %
   * 35 Weak Mutation 66: com.sleepycat.util.FastInputStream.skip(J)J:55 - ReplaceArithmeticOperator + -> /
   * 36 Weak Mutation 67: com.sleepycat.util.FastInputStream.skip(J)J:55 - ReplaceArithmeticOperator + -> *
   * 37 Weak Mutation 68: com.sleepycat.util.FastInputStream.skip(J)J:56 - InsertUnaryOp Negation
   * 38 Weak Mutation 69: com.sleepycat.util.FastInputStream.skip(J)J:56 - InsertUnaryOp IINC 1
   * 39 Weak Mutation 70: com.sleepycat.util.FastInputStream.skip(J)J:56 - InsertUnaryOp IINC -1
   * 40 com.sleepycat.util.FastInputStream.skip(J)J: I13 Branch 1 IF_ICMPLE L52 - false
   * 41 Weak Mutation 6: com.sleepycat.util.FastInputStream.available()I:39 - InsertUnaryOp Negation
   * 42 Weak Mutation 7: com.sleepycat.util.FastInputStream.available()I:39 - InsertUnaryOp +1
   * 43 Weak Mutation 8: com.sleepycat.util.FastInputStream.available()I:39 - InsertUnaryOp -1
   * 44 Weak Mutation 9: com.sleepycat.util.FastInputStream.available()I:39 - DeleteField: lenI
   * 45 Weak Mutation 10: com.sleepycat.util.FastInputStream.available()I:39 - InsertUnaryOp Negation
   * 46 Weak Mutation 11: com.sleepycat.util.FastInputStream.available()I:39 - InsertUnaryOp +1
   * 47 Weak Mutation 12: com.sleepycat.util.FastInputStream.available()I:39 - InsertUnaryOp -1
   * 48 Weak Mutation 16: com.sleepycat.util.FastInputStream.available()I:39 - ReplaceArithmeticOperator - -> /
   * 49 Weak Mutation 13: com.sleepycat.util.FastInputStream.available()I:39 - DeleteField: offI
   * 50 Weak Mutation 14: com.sleepycat.util.FastInputStream.available()I:39 - ReplaceArithmeticOperator - -> +
   * 51 Weak Mutation 17: com.sleepycat.util.FastInputStream.available()I:39 - ReplaceArithmeticOperator - -> *
   * 52 Weak Mutation 54: com.sleepycat.util.FastInputStream.skip(J)J:53 - ReplaceArithmeticOperator - -> %
   */
  @Test
  public void test2()  throws Throwable  {
      byte[] byteArray0 = new byte[5];
      FastInputStream fastInputStream0 = new FastInputStream(byteArray0, (int) (byte)0, (-1978));
      fastInputStream0.skip((-1588L));
      int int0 = fastInputStream0.available();
      assertEquals(-1978, fastInputStream0.getBufferOffset());
      assertEquals(0, int0);
  }
}
