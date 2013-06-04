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
public class TestCmdUtil_0 {


  //Test case number: 0
  /*
   * 15 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - InsertUnaryOp Negation
   * 2 Weak Mutation 1: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 2: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 5: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - ReplaceComparisonOperator >= -> -1
   * 5 Weak Mutation 6: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:13 - InsertUnaryOp Negation
   * 6 Weak Mutation 7: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:13 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 8: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:13 - InsertUnaryOp IINC -1
   * 8 com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;: I5 Branch 1 IF_ICMPGE L12 - false
   * 9 Weak Mutation 0: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - InsertUnaryOp Negation
   * 10 Weak Mutation 1: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 2: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 5: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:12 - ReplaceComparisonOperator >= -> -1
   * 13 Weak Mutation 6: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:13 - InsertUnaryOp Negation
   * 14 Weak Mutation 7: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:13 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 8: com.sleepycat.je.utilint.CmdUtil.getArg([Ljava/lang/String;I)Ljava/lang/String;:13 - InsertUnaryOp IINC -1
   */
  @Test
  public void test0()  throws Throwable  {
      String[] stringArray0 = new String[13];
      String string0 = CmdUtil.getArg(stringArray0, 0);
      assertNull(string0);
  }
}
