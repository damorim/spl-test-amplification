/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DBINReference;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;

@RunWith(EvoSuiteRunner.class)
public class TestDBIN_10 {


  //Test case number: 10
  /*
   * 3 covered goals:
   * 1 Weak Mutation 26: com.sleepycat.je.tree.DBIN.getCursorBIN(Lcom/sleepycat/je/dbi/CursorImpl;)Lcom/sleepycat/je/tree/BIN;:128 - DeleteStatement: getDupBIN()Lcom/sleepycat/je/tree/DBIN;
   * 2 com.sleepycat.je.tree.DBIN.getCursorBIN(Lcom/sleepycat/je/dbi/CursorImpl;)Lcom/sleepycat/je/tree/BIN;: root-Branch
   * 3 Weak Mutation 26: com.sleepycat.je.tree.DBIN.getCursorBIN(Lcom/sleepycat/je/dbi/CursorImpl;)Lcom/sleepycat/je/tree/BIN;:128 - DeleteStatement: getDupBIN()Lcom/sleepycat/je/tree/DBIN;
   */
  @Test
  public void test10()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      // Undeclared exception!
      try {
        dBIN0.getCursorBIN((CursorImpl) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
