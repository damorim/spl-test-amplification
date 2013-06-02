/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.util.UtfOps;

@RunWith(EvoSuiteRunner.class)
public class TestUtfOps_11 {


  //Test case number: 11
  /*
   * 46 covered goals:
   * 1 Weak Mutation 275: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - InsertUnaryOp IINC 1
   * 2 Weak Mutation 274: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - InsertUnaryOp Negation
   * 3 Weak Mutation 279: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> -1
   * 4 Weak Mutation 278: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 1
   * 5 Weak Mutation 277: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 0
   * 6 Weak Mutation 276: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 282: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceComparisonOperator <= -> ==
   * 8 Weak Mutation 281: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 2048
   * 9 Weak Mutation 280: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 2046
   * 10 com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V: I24 Branch 46 IF_ICMPLT L174 - true
   * 11 com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V: I41 Branch 48 IF_ICMPLE L177 - true
   * 12 Weak Mutation 239: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 238: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp IINC 1
   * 14 Weak Mutation 237: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp Negation
   * 15 Weak Mutation 235: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - ReplaceArithmeticOperator + -> /
   * 16 Weak Mutation 234: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - ReplaceArithmeticOperator + -> %
   * 17 Weak Mutation 232: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 231: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 230: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - InsertUnaryOp Negation
   * 20 Weak Mutation 229: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 228: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - InsertUnaryOp IINC 1
   * 22 Weak Mutation 227: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:171 - InsertUnaryOp Negation
   * 23 Weak Mutation 254: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:174 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 255: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:174 - ReplaceConstant - 1 -> 0
   * 25 Weak Mutation 252: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:174 - InsertUnaryOp Negation
   * 26 Weak Mutation 253: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:174 - InsertUnaryOp IINC 1
   * 27 Weak Mutation 250: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:173 - InsertUnaryOp IINC 1
   * 28 Weak Mutation 251: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:173 - InsertUnaryOp IINC -1
   * 29 Weak Mutation 248: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - ReplaceComparisonOperator >= -> -1
   * 30 Weak Mutation 249: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:173 - InsertUnaryOp Negation
   * 31 Weak Mutation 244: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp IINC 1
   * 32 Weak Mutation 245: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp IINC -1
   * 33 Weak Mutation 242: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp IINC -1
   * 34 Weak Mutation 243: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp Negation
   * 35 Weak Mutation 240: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp Negation
   * 36 Weak Mutation 241: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:172 - InsertUnaryOp IINC 1
   * 37 Weak Mutation 256: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:174 - ReplaceComparisonOperator < -> >=
   * 38 Weak Mutation 275: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - InsertUnaryOp IINC 1
   * 39 Weak Mutation 274: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - InsertUnaryOp Negation
   * 40 Weak Mutation 279: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> -1
   * 41 Weak Mutation 278: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 1
   * 42 Weak Mutation 277: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 0
   * 43 Weak Mutation 276: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - InsertUnaryOp IINC -1
   * 44 Weak Mutation 282: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceComparisonOperator <= -> ==
   * 45 Weak Mutation 281: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 2048
   * 46 Weak Mutation 280: com.sleepycat.util.UtfOps.charsToBytes([CI[BII)V:177 - ReplaceConstant - 2047 -> 2046
   */
  @Test
  public void test11()  throws Throwable  {
      char[] charArray0 = new char[2];
      byte[] byteArray0 = new byte[8];
      // Undeclared exception!
      try {
        UtfOps.charsToBytes(charArray0, 0, byteArray0, 0, 642);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      } catch(ArrayIndexOutOfBoundsException e) {
        /*
         * 2
         */
      }
  }
}