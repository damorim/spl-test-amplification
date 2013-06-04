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
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;

@RunWith(EvoSuiteRunner.class)
public class TestDIN_11 {


  //Test case number: 11
  /*
   * 3 covered goals:
   * 1 Weak Mutation 39: com.sleepycat.je.tree.DIN.isDbRoot()Z:151 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.DIN.isDbRoot()Z: root-Branch
   * 3 Weak Mutation 39: com.sleepycat.je.tree.DIN.isDbRoot()Z:151 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test11()  throws Throwable  {
      DIN dIN0 = new DIN();
      boolean boolean0 = dIN0.isDbRoot();
      assertEquals(1006344L, dIN0.getNextNodeId());
      assertEquals(false, boolean0);
  }
}
