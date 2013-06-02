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
public class TestLogUtils_10 {


  //Test case number: 10
  /*
   * 6 covered goals:
   * 1 Weak Mutation 701: com.sleepycat.je.log.LogUtils.readLong(Ljava/nio/ByteBuffer;)J:128 - DeleteStatement: get()B
   * 2 Weak Mutation 877: com.sleepycat.je.log.LogUtils.readTimestamp(Ljava/nio/ByteBuffer;)Ljava/sql/Timestamp;:200 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   * 3 com.sleepycat.je.log.LogUtils.readTimestamp(Ljava/nio/ByteBuffer;)Ljava/sql/Timestamp;: root-Branch
   * 4 com.sleepycat.je.log.LogUtils.readLong(Ljava/nio/ByteBuffer;)J: root-Branch
   * 5 Weak Mutation 701: com.sleepycat.je.log.LogUtils.readLong(Ljava/nio/ByteBuffer;)J:128 - DeleteStatement: get()B
   * 6 Weak Mutation 877: com.sleepycat.je.log.LogUtils.readTimestamp(Ljava/nio/ByteBuffer;)Ljava/sql/Timestamp;:200 - DeleteStatement: readLong(Ljava/nio/ByteBuffer;)J
   */
  @Test
  public void test10()  throws Throwable  {
      // Undeclared exception!
      try {
        LogUtils.readTimestamp((ByteBuffer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}