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
import com.sleepycat.je.tree.IN;

@RunWith(EvoSuiteRunner.class)
public class TestBIN_5 {


  //Test case number: 5
  /*
   * 3 covered goals:
   * 1 Weak Mutation 25: com.sleepycat.je.tree.BIN.setProhibitNextDelta()V:83 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.tree.BIN.setProhibitNextDelta()V: root-Branch
   * 3 Weak Mutation 25: com.sleepycat.je.tree.BIN.setProhibitNextDelta()V:83 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test5()  throws Throwable  {
      BIN bIN0 = new BIN();
      bIN0.setProhibitNextDelta();
      assertEquals(11511L, bIN0.getLastId());
      assertEquals(11511L, bIN0.getNextNodeId());
  }
}
