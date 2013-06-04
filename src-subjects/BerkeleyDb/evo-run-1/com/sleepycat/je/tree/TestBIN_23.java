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
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;

@RunWith(EvoSuiteRunner.class)
public class TestBIN_23 {


  //Test case number: 23
  /*
   * 14 covered goals:
   * 1 Weak Mutation 279: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:408 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 278: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:408 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   * 3 Weak Mutation 281: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:409 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 4 Weak Mutation 280: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:409 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   * 5 Weak Mutation 283: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:410 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 282: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:410 - DeleteStatement: hasNext()Z
   * 7 com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V: I4 Branch 32 IFNULL L408 - false
   * 8 com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V: I15 Branch 33 IFEQ L410 - true
   * 9 Weak Mutation 279: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:408 - ReplaceComparisonOperator = null -> != null
   * 10 Weak Mutation 278: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:408 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   * 11 Weak Mutation 283: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:410 - ReplaceComparisonOperator == -> !=
   * 12 Weak Mutation 282: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:410 - DeleteStatement: hasNext()Z
   * 13 Weak Mutation 281: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:409 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 14 Weak Mutation 280: com.sleepycat.je.tree.BIN.adjustCursorsForMutation(ILcom/sleepycat/je/tree/DBIN;ILcom/sleepycat/je/dbi/CursorImpl;)V:409 - DeleteField: cursorSetLcom/sleepycat/je/utilint/TinyHashSet;
   */
  @Test
  public void test23()  throws Throwable  {
      BIN bIN0 = new BIN();
      bIN0.adjustCursorsForMutation(1, (DBIN) null, 1, (CursorImpl) null);
      assertEquals(12285L, bIN0.getLastId());
      assertEquals(12285L, bIN0.getNextNodeId());
  }
}
