/*
 * This file was automatically generated by EvoSuite
 */

package smashed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import smashed.Edge;
import smashed.Graph;
import smashed.Vertex;

@RunWith(EvoSuiteRunner.class)
public class TestGraph_4 {


  //Test case number: 4
  /*
   * 4 covered goals:
   * 1 Weak Mutation 206: smashed.Graph.ConnectedComponents()V:127 - DeleteStatement: GraphSearch(Lsmashed/WorkSpace;)V
   * 2 smashed.Graph.ConnectedComponents()V: root-Branch
   * 3 Weak Mutation 168: smashed.Graph.GraphSearch(Lsmashed/WorkSpace;)V:92 - ReplaceComparisonOperator != -> -1
   * 4 Weak Mutation 206: smashed.Graph.ConnectedComponents()V:127 - DeleteStatement: GraphSearch(Lsmashed/WorkSpace;)V
   */
  @Test
  public void test4()  throws Throwable  {
      Graph graph0 = new Graph();
      graph0.ConnectedComponents();
      assertEquals(false, graph0.CycleCheck());
  }
}
