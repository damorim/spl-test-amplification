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
import com.sleepycat.je.tree.Node;

@RunWith(EvoSuiteRunner.class)
public class TestChildReference_4 {


  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 33: com.sleepycat.je.tree.ChildReference.fetchTarget(Lcom/sleepycat/je/dbi/DatabaseImpl;Lcom/sleepycat/je/tree/IN;)Lcom/sleepycat/je/tree/Node;:80 - DeleteField: targetLcom/sleepycat/je/tree/Node;
   * 2 com.sleepycat.je.tree.ChildReference.fetchTarget(Lcom/sleepycat/je/dbi/DatabaseImpl;Lcom/sleepycat/je/tree/IN;)Lcom/sleepycat/je/tree/Node;: I4 Branch 1 IFNONNULL L80 - true
   * 3 Weak Mutation 33: com.sleepycat.je.tree.ChildReference.fetchTarget(Lcom/sleepycat/je/dbi/DatabaseImpl;Lcom/sleepycat/je/tree/IN;)Lcom/sleepycat/je/tree/Node;:80 - DeleteField: targetLcom/sleepycat/je/tree/Node;
   */
  @Test
  public void test4()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN((-663));
      byte[] byteArray0 = new byte[1];
      ChildReference childReference0 = new ChildReference((Node) dupCountLN0, byteArray0, (long) (-663));
      DIN dIN0 = new DIN();
      childReference0.fetchTarget((DatabaseImpl) null, (IN) dIN0);
      assertEquals("<DbLsn val=\"0xffffffff/0xfffffd69\"/>\n<key v=\"0 \"/>\n<dupCountLN>\n  <count v=\"-663\"/>\n  <node>4294969730</node>\n  <data></data>\n</dupCountLN>\n<knownDeleted val=\"false\"/><pendingDeleted val=\"false\"/><dirty val=\"true\"/>", childReference0.toString());
      assertEquals(4294969735L, dIN0.getNextNodeId());
  }
}
