/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.utilint.CmdUtil;

@RunWith(EvoSuiteRunner.class)
public class TestCmdUtil_1 {


  //Test case number: 1
  /*
   * 3 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - ReplaceComparisonOperator >= -> ==
   * 2 com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;: I5 Branch 1 IF_ICMPGE L12 - true
   * 3 Weak Mutation 3: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - ReplaceComparisonOperator >= -> ==
   */
  @Test
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[4];
      try {
        CmdUtil.getArg(stringArray0, 1830);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
      }
  }
}
