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
public class TestFastOutputStream_14 {


  //Test case number: 14
  /*
   * 3 covered goals:
   * 1 Weak Mutation 194: com.sleepycat.util.FastOutputStream.getBufferBytes()[B:147 - DeleteField: buf[B
   * 2 com.sleepycat.util.FastOutputStream.getBufferBytes()[B: root-Branch
   * 3 Weak Mutation 194: com.sleepycat.util.FastOutputStream.getBufferBytes()[B:147 - DeleteField: buf[B
   */
  @Test
  public void test14()  throws Throwable  {
      byte[] byteArray0 = new byte[1];
      FastOutputStream fastOutputStream0 = new FastOutputStream(byteArray0, 2025);
      byte[] byteArray1 = fastOutputStream0.getBufferBytes();
      assertSame(byteArray0, byteArray1);
  }
}