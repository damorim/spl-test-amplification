/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseUtil;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseUtil_0 {


  //Test case number: 0
  /*
   * 11 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 2 Weak Mutation 2: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - ReplaceConstant -  cannot be null -> 
   * 3 Weak Mutation 3: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 4 Weak Mutation 4: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - DeleteStatement: toString()Ljava/lang/String;
   * 5 com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V: I3 Branch 1 IFNONNULL L10 - false
   * 6 Weak Mutation 0: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:10 - ReplaceComparisonOperator != null -> = null
   * 7 Weak Mutation 0: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:10 - ReplaceComparisonOperator != null -> = null
   * 8 Weak Mutation 1: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 9 Weak Mutation 2: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - ReplaceConstant -  cannot be null -> 
   * 10 Weak Mutation 3: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 4: com.sleepycat.je.DatabaseUtil.checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V:11 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test0()  throws Throwable  {
      // Undeclared exception!
      try {
        DatabaseUtil.checkForNullParam((Object) null, "2l#Q2z!^O?u&o~Db");
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
        /*
         * 2l#Q2z!^O?u&o~Db cannot be null
         */
      }
  }
}