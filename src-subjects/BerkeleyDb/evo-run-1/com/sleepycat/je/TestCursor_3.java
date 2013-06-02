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
import com.sleepycat.je.Environment;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestCursor_3 {


  //Test case number: 3
  /*
   * 9 covered goals:
   * 1 Weak Mutation 11: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:90 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 12: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:90 - DeleteStatement: getReadCommitted()Z
   * 3 Weak Mutation 13: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:90 - DeleteStatement: getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;
   * 4 com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V: I7 Branch 2 IFNONNULL L87 - true
   * 5 Weak Mutation 8: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:87 - ReplaceComparisonOperator != null -> = null
   * 6 Weak Mutation 10: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:90 - DeleteStatement: getEnvironment()Lcom/sleepycat/je/Environment;
   * 7 Weak Mutation 11: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:90 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 12: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:90 - DeleteStatement: getReadCommitted()Z
   * 9 Weak Mutation 13: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/CursorConfig;)V:90 - DeleteStatement: getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;
   */
  @Test
  public void test3()  throws Throwable  {
      Database database0 = new Database((Environment) null);
      CursorConfig cursorConfig0 = new CursorConfig();
      Cursor cursor0 = null;
      try {
        cursor0 = new Cursor(database0, (Locker) null, cursorConfig0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}