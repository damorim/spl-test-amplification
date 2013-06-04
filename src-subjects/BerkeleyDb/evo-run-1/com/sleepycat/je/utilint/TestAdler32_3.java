/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.zip.Adler32;

@RunWith(EvoSuiteRunner.class)
public class TestAdler32_3 {


  //Test case number: 3
  /*
   * 11 covered goals:
   * 1 Weak Mutation 109: com.sleepycat.je.utilint.Adler32.update([BII)V:65 - ReplaceComparisonOperator <= -> ==
   * 2 Weak Mutation 109: com.sleepycat.je.utilint.Adler32.update([BII)V:65 - ReplaceComparisonOperator <= -> ==
   * 3 Weak Mutation 190: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - ReplaceConstant - 16 -> 1
   * 4 Weak Mutation 191: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - ReplaceConstant - 16 -> -1
   * 5 Weak Mutation 188: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - InsertUnaryOp Negation
   * 6 Weak Mutation 189: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - ReplaceConstant - 16 -> 0
   * 7 Weak Mutation 197: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - ReplaceBitwiseOperator | -> &
   * 8 Weak Mutation 196: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - InsertUnaryOp Negation
   * 9 Weak Mutation 193: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - ReplaceConstant - 16 -> 17
   * 10 Weak Mutation 192: com.sleepycat.je.utilint.Adler32.update([BII)V:75 - ReplaceConstant - 16 -> 15
   * 11 com.sleepycat.je.utilint.Adler32.update([BII)V: I19 Branch 2 IFLE L65 - true
   */
  @Test
  public void test3()  throws Throwable  {
      com.sleepycat.je.utilint.Adler32 adler32_0 = new com.sleepycat.je.utilint.Adler32();
      byte[] byteArray0 = new byte[8];
      adler32_0.update(byteArray0, (int) (byte) (-26), (int) (byte) (-26));
      assertEquals(1L, adler32_0.getValue());
  }
}
