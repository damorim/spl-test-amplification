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
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.tree.Node;

@RunWith(EvoSuiteRunner.class)
public class TestChildReference_8 {


  //Test case number: 8
  /*
   * 3 covered goals:
   * 1 Weak Mutation 71: com.sleepycat.je.tree.ChildReference.getTarget()Lcom/sleepycat/je/tree/Node;:120 - DeleteField: targetLcom/sleepycat/je/tree/Node;
   * 2 com.sleepycat.je.tree.ChildReference.getTarget()Lcom/sleepycat/je/tree/Node;: root-Branch
   * 3 Weak Mutation 71: com.sleepycat.je.tree.ChildReference.getTarget()Lcom/sleepycat/je/tree/Node;:120 - DeleteField: targetLcom/sleepycat/je/tree/Node;
   */
  @Test
  public void test8()  throws Throwable  {
      LN lN0 = new LN();
      byte[] byteArray0 = new byte[1];
      ChildReference childReference0 = new ChildReference((Node) lN0, byteArray0, 0L, (byte) (-1));
      LN lN1 = (LN)childReference0.getTarget();
      assertEquals(4294970157L, lN0.getNextNodeId());
      assertEquals(4294970156L, lN1.getNextNodeId());
  }
}
