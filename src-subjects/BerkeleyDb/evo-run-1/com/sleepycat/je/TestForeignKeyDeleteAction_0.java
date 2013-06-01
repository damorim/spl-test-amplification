/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.ForeignKeyDeleteAction;

@RunWith(EvoSuiteRunner.class)
public class TestForeignKeyDeleteAction_0 {


  //Test case number: 0
  /*
   * 11 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - ReplaceConstant - ForeignKeyDeleteAction. -> 
   * 2 Weak Mutation 1: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 3 Weak Mutation 2: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteField: nameLjava/lang/String;
   * 4 Weak Mutation 3: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 5 Weak Mutation 4: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteStatement: toString()Ljava/lang/String;
   * 6 com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;: root-Branch
   * 7 Weak Mutation 0: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - ReplaceConstant - ForeignKeyDeleteAction. -> 
   * 8 Weak Mutation 1: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 9 Weak Mutation 2: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteField: nameLjava/lang/String;
   * 10 Weak Mutation 3: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 4: com.sleepycat.je.ForeignKeyDeleteAction.toString()Ljava/lang/String;:27 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test0()  throws Throwable  {
      ForeignKeyDeleteAction foreignKeyDeleteAction0 = ForeignKeyDeleteAction.NULLIFY;
      String string0 = foreignKeyDeleteAction0.toString();
      assertNotNull(string0);
      assertEquals("ForeignKeyDeleteAction.NULLIFY", string0);
  }
}
