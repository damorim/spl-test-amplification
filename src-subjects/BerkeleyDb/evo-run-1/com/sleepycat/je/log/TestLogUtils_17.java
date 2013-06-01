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
public class TestLogUtils_17 {


  //Test case number: 17
  /*
   * 14 covered goals:
   * 1 Weak Mutation 894: com.sleepycat.je.log.LogUtils.readBoolean(Ljava/nio/ByteBuffer;)Z:220 - DeleteStatement: get()B
   * 2 Weak Mutation 904: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:230 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 3 Weak Mutation 903: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:230 - ReplaceConstant - < -> 
   * 4 Weak Mutation 905: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:231 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 5 Weak Mutation 907: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:232 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 6 Weak Mutation 906: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:232 - ReplaceConstant -  exists = " -> 
   * 7 Weak Mutation 908: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:233 - DeleteStatement: readBoolean(Ljava/nio/ByteBuffer;)Z
   * 8 Weak Mutation 894: com.sleepycat.je.log.LogUtils.readBoolean(Ljava/nio/ByteBuffer;)Z:220 - DeleteStatement: get()B
   * 9 Weak Mutation 908: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:233 - DeleteStatement: readBoolean(Ljava/nio/ByteBuffer;)Z
   * 10 Weak Mutation 907: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:232 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 11 Weak Mutation 906: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:232 - ReplaceConstant -  exists = " -> 
   * 12 Weak Mutation 905: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:231 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 13 Weak Mutation 904: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:230 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 14 Weak Mutation 903: com.sleepycat.je.log.LogUtils.dumpBoolean(Ljava/nio/ByteBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)Z:230 - ReplaceConstant - < -> 
   */
  @Test
  public void test17()  throws Throwable  {
      StringBuffer stringBuffer0 = new StringBuffer("zXPdXx:");
      // Undeclared exception!
      try {
        LogUtils.dumpBoolean((ByteBuffer) null, stringBuffer0, "zXPdXx:");
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
