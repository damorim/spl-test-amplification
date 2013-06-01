/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;

@RunWith(EvoSuiteRunner.class)
public class TestBIN_14 {


  //Test case number: 14
  /*
   * 5 covered goals:
   * 1 Weak Mutation 119: com.sleepycat.je.tree.BIN.getCursorSet()Ljava/util/Set;:233 - DeleteStatement: copy()Ljava/util/Set;
   * 2 Weak Mutation 118: com.sleepycat.je.tree.BIN.getCursorSet()Ljava/util/Set;:233 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   * 3 com.sleepycat.je.tree.BIN.getCursorSet()Ljava/util/Set;: root-Branch
   * 4 Weak Mutation 119: com.sleepycat.je.tree.BIN.getCursorSet()Ljava/util/Set;:233 - DeleteStatement: copy()Ljava/util/Set;
   * 5 Weak Mutation 118: com.sleepycat.je.tree.BIN.getCursorSet()Ljava/util/Set;:233 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   */
  @Test
  public void test14()  throws Throwable  {
      BIN bIN0 = new BIN();
      bIN0.getCursorSet();
      assertEquals(11933L, bIN0.getNextNodeId());
      assertEquals(11933L, bIN0.getLastId());
  }
}
