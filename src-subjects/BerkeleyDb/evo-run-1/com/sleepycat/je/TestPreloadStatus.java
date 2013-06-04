/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.PreloadStatus;

@RunWith(EvoSuiteRunner.class)
public class TestPreloadStatus {


  //Test case number: 0
  /*
   * 9 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - ReplaceConstant - PreloadStatus. -> 
   * 2 Weak Mutation 1: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - DeleteField: statusNameLjava/lang/String;
   * 3 Weak Mutation 2: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 4 Weak Mutation 3: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - DeleteStatement: toString()Ljava/lang/String;
   * 5 com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;: root-Branch
   * 6 Weak Mutation 0: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - ReplaceConstant - PreloadStatus. -> 
   * 7 Weak Mutation 1: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - DeleteField: statusNameLjava/lang/String;
   * 8 Weak Mutation 2: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 9 Weak Mutation 3: com.sleepycat.je.PreloadStatus.toString()Ljava/lang/String;:13 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test0()  throws Throwable  {
      PreloadStatus preloadStatus0 = PreloadStatus.EXCEEDED_TIME;
      String string0 = preloadStatus0.toString();
      assertEquals("PreloadStatus.EXCEEDED_TIME", string0);
      assertNotNull(string0);
  }
}
