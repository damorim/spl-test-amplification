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
public class TestBIN_8 {


  //Test case number: 8
  /*
   * 12 covered goals:
   * 1 Weak Mutation 69: com.sleepycat.je.tree.BIN.isEvictionProhibited()Z:137 - ReplaceComparisonOperator <= -> <
   * 2 Weak Mutation 67: com.sleepycat.je.tree.BIN.isEvictionProhibited()Z:137 - DeleteStatement: nCursors()I
   * 3 Weak Mutation 72: com.sleepycat.je.tree.BIN.isEvictionProhibited()Z:137 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 125: com.sleepycat.je.tree.BIN.nCursors()I:260 - DeleteStatement: size()I
   * 5 Weak Mutation 124: com.sleepycat.je.tree.BIN.nCursors()I:260 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   * 6 com.sleepycat.je.tree.BIN.nCursors()I: root-Branch
   * 7 com.sleepycat.je.tree.BIN.isEvictionProhibited()Z: I4 Branch 9 IFLE L137 - true
   * 8 Weak Mutation 69: com.sleepycat.je.tree.BIN.isEvictionProhibited()Z:137 - ReplaceComparisonOperator <= -> <
   * 9 Weak Mutation 67: com.sleepycat.je.tree.BIN.isEvictionProhibited()Z:137 - DeleteStatement: nCursors()I
   * 10 Weak Mutation 72: com.sleepycat.je.tree.BIN.isEvictionProhibited()Z:137 - ReplaceConstant - 0 -> 1
   * 11 Weak Mutation 125: com.sleepycat.je.tree.BIN.nCursors()I:260 - DeleteStatement: size()I
   * 12 Weak Mutation 124: com.sleepycat.je.tree.BIN.nCursors()I:260 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   */
  @Test
  public void test8()  throws Throwable  {
      BIN bIN0 = new BIN();
      boolean boolean0 = bIN0.isEvictionProhibited();
      assertEquals(11623L, bIN0.getNextNodeId());
      assertEquals(false, boolean0);
  }
}