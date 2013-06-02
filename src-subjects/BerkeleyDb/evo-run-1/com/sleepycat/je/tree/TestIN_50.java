/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.InconsistentNodeException;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import java.io.StringWriter;

@RunWith(EvoSuiteRunner.class)
public class TestIN_50 {


  //Test case number: 50
  /*
   * 13 covered goals:
   * 1 Weak Mutation 1729: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - ReplaceComparisonOperator <= -> >
   * 2 Weak Mutation 1728: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 1726: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - InsertUnaryOp -1
   * 4 Weak Mutation 1724: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - InsertUnaryOp Negation
   * 5 Weak Mutation 1725: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - InsertUnaryOp +1
   * 6 Weak Mutation 1742: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1563 - DeleteStatement: removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V
   * 7 com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V: I5 Branch 94 IF_ICMPLE L1560 - true
   * 8 Weak Mutation 1729: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - ReplaceComparisonOperator <= -> >
   * 9 Weak Mutation 1728: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - ReplaceConstant - 1 -> 0
   * 10 Weak Mutation 1742: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1563 - DeleteStatement: removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V
   * 11 Weak Mutation 1726: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - InsertUnaryOp -1
   * 12 Weak Mutation 1724: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - InsertUnaryOp Negation
   * 13 Weak Mutation 1725: com.sleepycat.je.tree.IN.accountForSubtreeRemoval(Lcom/sleepycat/je/dbi/INList;)V:1560 - InsertUnaryOp +1
   */
  @Test
  public void test50()  throws Throwable  {
      DIN dIN0 = new DIN();
      assertNotNull(dIN0);
      
      // Undeclared exception!
      try {
        dIN0.accountForSubtreeRemoval((INList) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}