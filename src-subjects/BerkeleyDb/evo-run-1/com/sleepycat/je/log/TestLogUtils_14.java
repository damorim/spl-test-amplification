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
public class TestLogUtils_14 {


  //Test case number: 14
  /*
   * 11 covered goals:
   * 1 Weak Mutation 881: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> -1
   * 2 Weak Mutation 880: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 1
   * 3 Weak Mutation 883: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 9
   * 4 Weak Mutation 882: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 7
   * 5 Weak Mutation 879: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 0
   * 6 com.sleepycat.je.log.LogUtils.getTimestampLogSize()I: root-Branch
   * 7 Weak Mutation 881: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> -1
   * 8 Weak Mutation 880: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 1
   * 9 Weak Mutation 883: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 9
   * 10 Weak Mutation 882: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 7
   * 11 Weak Mutation 879: com.sleepycat.je.log.LogUtils.getTimestampLogSize()I:207 - ReplaceConstant - 8 -> 0
   */
  @Test
  public void test14()  throws Throwable  {
      int int0 = LogUtils.getTimestampLogSize();
      assertEquals(8, int0);
  }
}
