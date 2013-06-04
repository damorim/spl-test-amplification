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

@RunWith(EvoSuiteRunner.class)
public class TestFastOutputStream_3 {


  //Test case number: 3
  /*
   * 67 covered goals:
   * 1 Weak Mutation 29: com.sleepycat.util.FastOutputStream.size()I:78 - DeleteField: lenI
   * 2 Weak Mutation 31: com.sleepycat.util.FastOutputStream.write(I)V:84 - InsertUnaryOp Negation
   * 3 Weak Mutation 34: com.sleepycat.util.FastOutputStream.write(I)V:84 - DeleteStatement: writeFast(I)V
   * 4 Weak Mutation 32: com.sleepycat.util.FastOutputStream.write(I)V:84 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 33: com.sleepycat.util.FastOutputStream.write(I)V:84 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 84: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - InsertUnaryOp -1
   * 7 Weak Mutation 87: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> -
   * 8 Weak Mutation 86: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceConstant - 1 -> 0
   * 9 Weak Mutation 83: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - InsertUnaryOp +1
   * 10 Weak Mutation 82: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - InsertUnaryOp Negation
   * 11 Weak Mutation 93: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceComparisonOperator <= -> <
   * 12 Weak Mutation 89: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> /
   * 13 Weak Mutation 88: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> %
   * 14 Weak Mutation 91: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - DeleteField: buf[B
   * 15 Weak Mutation 90: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> *
   * 16 Weak Mutation 102: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> -
   * 17 Weak Mutation 103: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> %
   * 18 Weak Mutation 101: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceConstant - 1 -> 0
   * 19 Weak Mutation 98: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp +1
   * 20 Weak Mutation 99: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp -1
   * 21 Weak Mutation 96: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - DeleteField: buf[B
   * 22 Weak Mutation 97: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp Negation
   * 23 Weak Mutation 108: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 106: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp Negation
   * 25 Weak Mutation 107: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp IINC 1
   * 26 Weak Mutation 104: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> /
   * 27 Weak Mutation 105: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> *
   * 28 com.sleepycat.util.FastOutputStream.write(I)V: root-Branch
   * 29 com.sleepycat.util.FastOutputStream.writeFast(I)V: I9 Branch 2 IF_ICMPLE L117 - true
   * 30 Weak Mutation 27: com.sleepycat.util.FastOutputStream.size()I:78 - InsertUnaryOp +1
   * 31 Weak Mutation 26: com.sleepycat.util.FastOutputStream.size()I:78 - InsertUnaryOp Negation
   * 32 Weak Mutation 28: com.sleepycat.util.FastOutputStream.size()I:78 - InsertUnaryOp -1
   * 33 Weak Mutation 17: com.sleepycat.util.FastOutputStream.<init>([BI)V:71 - InsertUnaryOp Negation
   * 34 Weak Mutation 19: com.sleepycat.util.FastOutputStream.<init>([BI)V:71 - InsertUnaryOp IINC -1
   * 35 Weak Mutation 18: com.sleepycat.util.FastOutputStream.<init>([BI)V:71 - InsertUnaryOp IINC 1
   * 36 Weak Mutation 27: com.sleepycat.util.FastOutputStream.size()I:78 - InsertUnaryOp +1
   * 37 Weak Mutation 26: com.sleepycat.util.FastOutputStream.size()I:78 - InsertUnaryOp Negation
   * 38 Weak Mutation 29: com.sleepycat.util.FastOutputStream.size()I:78 - DeleteField: lenI
   * 39 Weak Mutation 28: com.sleepycat.util.FastOutputStream.size()I:78 - InsertUnaryOp -1
   * 40 Weak Mutation 31: com.sleepycat.util.FastOutputStream.write(I)V:84 - InsertUnaryOp Negation
   * 41 Weak Mutation 34: com.sleepycat.util.FastOutputStream.write(I)V:84 - DeleteStatement: writeFast(I)V
   * 42 Weak Mutation 32: com.sleepycat.util.FastOutputStream.write(I)V:84 - InsertUnaryOp IINC 1
   * 43 Weak Mutation 33: com.sleepycat.util.FastOutputStream.write(I)V:84 - InsertUnaryOp IINC -1
   * 44 Weak Mutation 84: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - InsertUnaryOp -1
   * 45 Weak Mutation 87: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> -
   * 46 Weak Mutation 86: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceConstant - 1 -> 0
   * 47 Weak Mutation 83: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - InsertUnaryOp +1
   * 48 Weak Mutation 82: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - InsertUnaryOp Negation
   * 49 Weak Mutation 93: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceComparisonOperator <= -> <
   * 50 Weak Mutation 89: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> /
   * 51 Weak Mutation 88: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> %
   * 52 Weak Mutation 91: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - DeleteField: buf[B
   * 53 Weak Mutation 90: com.sleepycat.util.FastOutputStream.writeFast(I)V:117 - ReplaceArithmeticOperator + -> *
   * 54 Weak Mutation 102: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> -
   * 55 Weak Mutation 103: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> %
   * 56 Weak Mutation 101: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceConstant - 1 -> 0
   * 57 Weak Mutation 98: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp +1
   * 58 Weak Mutation 99: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp -1
   * 59 Weak Mutation 96: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - DeleteField: buf[B
   * 60 Weak Mutation 97: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp Negation
   * 61 Weak Mutation 108: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp IINC -1
   * 62 Weak Mutation 106: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp Negation
   * 63 Weak Mutation 107: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - InsertUnaryOp IINC 1
   * 64 Weak Mutation 104: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> /
   * 65 Weak Mutation 105: com.sleepycat.util.FastOutputStream.writeFast(I)V:118 - ReplaceArithmeticOperator + -> *
   * 66 com.sleepycat.util.FastOutputStream.size()I: root-Branch
   * 67 com.sleepycat.util.FastOutputStream.<init>([BI)V: root-Branch
   */
  @Test
  public void test3()  throws Throwable  {
      byte[] byteArray0 = new byte[1];
      FastOutputStream fastOutputStream0 = new FastOutputStream(byteArray0, 2025);
      fastOutputStream0.write(2025);
      int int0 = fastOutputStream0.size();
      assertEquals(1, fastOutputStream0.size());
      assertEquals(1, int0);
  }
}
