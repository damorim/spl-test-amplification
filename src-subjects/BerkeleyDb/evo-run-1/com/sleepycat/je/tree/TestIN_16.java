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
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;

@RunWith(EvoSuiteRunner.class)
public class TestIN_16 {


  //Test case number: 16
  /*
   * 3 covered goals:
   * 1 Weak Mutation 159: com.sleepycat.je.tree.IN.isDbRoot()Z:328 - InsertUnaryOp Negation
   * 2 com.sleepycat.je.tree.IN.isDbRoot()Z: root-Branch
   * 3 Weak Mutation 159: com.sleepycat.je.tree.IN.isDbRoot()Z:328 - InsertUnaryOp Negation
   */
  @Test
  public void test16()  throws Throwable  {
      IN iN0 = new IN();
      assertNotNull(iN0);
      
      boolean boolean0 = iN0.isDbRoot();
      assertEquals(104376L, iN0.getNextNodeId());
      assertEquals(false, boolean0);
  }
}