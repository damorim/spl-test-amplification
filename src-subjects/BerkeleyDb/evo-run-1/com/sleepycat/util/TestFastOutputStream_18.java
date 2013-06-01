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
public class TestFastOutputStream_18 {


  //Test case number: 18
  /*
   * 6 covered goals:
   * 1 Weak Mutation 220: com.sleepycat.util.FastOutputStream.makeSpace(I)V:171 - ReplaceComparisonOperator <= -> <
   * 2 Weak Mutation 6: com.sleepycat.util.FastOutputStream.<init>(I)V:42 - InsertUnaryOp Negation
   * 3 Weak Mutation 7: com.sleepycat.util.FastOutputStream.<init>(I)V:42 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 8: com.sleepycat.util.FastOutputStream.<init>(I)V:42 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 9: com.sleepycat.util.FastOutputStream.<init>(I)V:42 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 220: com.sleepycat.util.FastOutputStream.makeSpace(I)V:171 - ReplaceComparisonOperator <= -> <
   */
  @Test
  public void test18()  throws Throwable  {
      FastOutputStream fastOutputStream0 = new FastOutputStream((int) (byte)0);
      fastOutputStream0.makeSpace((int) (byte)0);
      assertEquals("", fastOutputStream0.toString());
  }
}
