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
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.JoinCursor;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestDbInternal_8 {


  //Test case number: 8
  /*
   * 3 covered goals:
   * 1 Weak Mutation 11: com.sleepycat.je.DbInternal.getSortedCursors(Lcom/sleepycat/je/JoinCursor;)[Lcom/sleepycat/je/Cursor;:72 - DeleteStatement: getSortedCursors()[Lcom/sleepycat/je/Cursor;
   * 2 com.sleepycat.je.DbInternal.getSortedCursors(Lcom/sleepycat/je/JoinCursor;)[Lcom/sleepycat/je/Cursor;: root-Branch
   * 3 Weak Mutation 11: com.sleepycat.je.DbInternal.getSortedCursors(Lcom/sleepycat/je/JoinCursor;)[Lcom/sleepycat/je/Cursor;:72 - DeleteStatement: getSortedCursors()[Lcom/sleepycat/je/Cursor;
   */
  @Test
  public void test8()  throws Throwable  {
      // Undeclared exception!
      try {
        DbInternal.getSortedCursors((JoinCursor) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}