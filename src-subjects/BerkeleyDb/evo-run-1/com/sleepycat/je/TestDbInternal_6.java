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
import com.sleepycat.je.LockMode;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestDbInternal_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.DbInternal.getCursorImpl(Lcom/sleepycat/je/Cursor;)Lcom/sleepycat/je/dbi/CursorImpl;:60 - DeleteStatement: getCursorImpl()Lcom/sleepycat/je/dbi/CursorImpl;
   * 2 com.sleepycat.je.DbInternal.getCursorImpl(Lcom/sleepycat/je/Cursor;)Lcom/sleepycat/je/dbi/CursorImpl;: root-Branch
   * 3 Weak Mutation 9: com.sleepycat.je.DbInternal.getCursorImpl(Lcom/sleepycat/je/Cursor;)Lcom/sleepycat/je/dbi/CursorImpl;:60 - DeleteStatement: getCursorImpl()Lcom/sleepycat/je/dbi/CursorImpl;
   */
  @Test
  public void test6()  throws Throwable  {
      // Undeclared exception!
      try {
        DbInternal.getCursorImpl((Cursor) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
