/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseException;

@RunWith(EvoSuiteRunner.class)
public class TestCursor_0 {


  //Test case number: 0
  /*
   * 7 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/CursorConfig;)V:70 - ReplaceComparisonOperator != null -> = null
   * 2 Weak Mutation 1: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/CursorConfig;)V:71 - DeleteField: DEFAULTLcom/sleepycat/je/CursorConfig;
   * 3 Weak Mutation 2: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/CursorConfig;)V:73 - DeleteStatement: getEnvironment()Lcom/sleepycat/je/Environment;
   * 4 com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/CursorConfig;)V: I7 Branch 1 IFNONNULL L70 - false
   * 5 Weak Mutation 0: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/CursorConfig;)V:70 - ReplaceComparisonOperator != null -> = null
   * 6 Weak Mutation 1: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/CursorConfig;)V:71 - DeleteField: DEFAULTLcom/sleepycat/je/CursorConfig;
   * 7 Weak Mutation 2: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/CursorConfig;)V:73 - DeleteStatement: getEnvironment()Lcom/sleepycat/je/Environment;
   */
  @Test
  public void test0()  throws Throwable  {
      Cursor cursor0 = null;
      try {
        cursor0 = new Cursor((Database) null, (CursorConfig) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}