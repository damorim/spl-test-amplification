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
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;

@RunWith(EvoSuiteRunner.class)
public class TestBIN_24 {


  //Test case number: 24
  /*
   * 10 covered goals:
   * 1 Weak Mutation 305: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:436 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 306: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:437 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 307: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:438 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 308: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:439 - DeleteStatement: getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 5 Weak Mutation 309: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:440 - DeleteStatement: getDbEnvironment()Lcom/sleepycat/je/dbi/EnvironmentImpl;
   * 6 Weak Mutation 305: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:436 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 307: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:438 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 306: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:437 - ReplaceConstant - 0 -> 1
   * 9 Weak Mutation 309: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:440 - DeleteStatement: getDbEnvironment()Lcom/sleepycat/je/dbi/EnvironmentImpl;
   * 10 Weak Mutation 308: com.sleepycat.je.tree.BIN.compress(Lcom/sleepycat/je/tree/BINReference;Z)Z:439 - DeleteStatement: getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;
   */
  @Test
  public void test24()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      byte[] byteArray0 = new byte[4];
      ChildReference childReference0 = new ChildReference((Node) dBIN0, byteArray0, (long) 0, (byte)15);
      // Undeclared exception!
      try {
        dBIN0.insertEntry(childReference0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
