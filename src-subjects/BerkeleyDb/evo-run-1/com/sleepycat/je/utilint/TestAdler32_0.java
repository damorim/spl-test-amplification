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
public class TestAdler32_0 {


  //Test case number: 0
  /*
   * 7 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.utilint.Adler32.makeChecksum()Ljava/util/zip/Checksum;:39 - InsertUnaryOp Negation
   * 2 Weak Mutation 4: com.sleepycat.je.utilint.Adler32.makeChecksum()Ljava/util/zip/Checksum;:39 - DeleteField: JAVA5_AVAILABLEZ
   * 3 Weak Mutation 5: com.sleepycat.je.utilint.Adler32.makeChecksum()Ljava/util/zip/Checksum;:39 - ReplaceComparisonOperator == -> !=
   * 4 com.sleepycat.je.utilint.Adler32.makeChecksum()Ljava/util/zip/Checksum;: I3 Branch 1 IFEQ L39 - false
   * 5 Weak Mutation 3: com.sleepycat.je.utilint.Adler32.makeChecksum()Ljava/util/zip/Checksum;:39 - InsertUnaryOp Negation
   * 6 Weak Mutation 4: com.sleepycat.je.utilint.Adler32.makeChecksum()Ljava/util/zip/Checksum;:39 - DeleteField: JAVA5_AVAILABLEZ
   * 7 Weak Mutation 5: com.sleepycat.je.utilint.Adler32.makeChecksum()Ljava/util/zip/Checksum;:39 - ReplaceComparisonOperator == -> !=
   */
  @Test
  public void test0()  throws Throwable  {
      Adler32 adler32_0 = (Adler32)com.sleepycat.je.utilint.Adler32.makeChecksum();
      assertEquals(1L, adler32_0.getValue());
  }
}