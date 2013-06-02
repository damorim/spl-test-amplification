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
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestCursor_5 {


  //Test case number: 5
  /*
   * 2 covered goals:
   * 1 Weak Mutation 45: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Cursor;Z)V:130 - InsertUnaryOp Negation
   * 2 Weak Mutation 45: com.sleepycat.je.Cursor.<init>(Lcom/sleepycat/je/Cursor;Z)V:130 - InsertUnaryOp Negation
   */
  @Test
  public void test5()  throws Throwable  {
      Cursor cursor0 = null;
      try {
        cursor0 = new Cursor((Cursor) null, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}