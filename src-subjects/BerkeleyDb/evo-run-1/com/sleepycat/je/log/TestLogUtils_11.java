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
public class TestLogUtils_11 {


  //Test case number: 11
  /*
   * 11 covered goals:
   * 1 Weak Mutation 834: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 0
   * 2 Weak Mutation 835: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 1
   * 3 Weak Mutation 838: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 9
   * 4 Weak Mutation 836: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> -1
   * 5 Weak Mutation 837: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 7
   * 6 com.sleepycat.je.log.LogUtils.getLongLogSize()I: root-Branch
   * 7 Weak Mutation 834: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 0
   * 8 Weak Mutation 835: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 1
   * 9 Weak Mutation 838: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 9
   * 10 Weak Mutation 836: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> -1
   * 11 Weak Mutation 837: com.sleepycat.je.log.LogUtils.getLongLogSize()I:142 - ReplaceConstant - 8 -> 7
   */
  @Test
  public void test11()  throws Throwable  {
      int int0 = LogUtils.getLongLogSize();
      assertEquals(8, int0);
  }
}
