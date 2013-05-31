/*
 * This file was automatically generated by EvoSuite
 */

package smashed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import smashed.RegionWorkSpace;
import smashed.Vertex;

@RunWith(EvoSuiteRunner.class)
public class TestRegionWorkSpace_0 {


  //Test case number: 0
  /*
   * 9 covered goals:
   * 1 Weak Mutation 1: smashed.RegionWorkSpace.init_vertex(Lsmashed/Vertex;)V:20 - ReplaceConstant - -1 -> 0
   * 2 Weak Mutation 2: smashed.RegionWorkSpace.init_vertex(Lsmashed/Vertex;)V:20 - ReplaceConstant - -1 -> 1
   * 3 Weak Mutation 3: smashed.RegionWorkSpace.init_vertex(Lsmashed/Vertex;)V:20 - ReplaceConstant - -1 -> -2
   * 4 smashed.RegionWorkSpace.init_vertex(Lsmashed/Vertex;)V: root-Branch
   * 5 Weak Mutation 0: smashed.RegionWorkSpace.<init>()V:14 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 1: smashed.RegionWorkSpace.init_vertex(Lsmashed/Vertex;)V:20 - ReplaceConstant - -1 -> 0
   * 7 Weak Mutation 2: smashed.RegionWorkSpace.init_vertex(Lsmashed/Vertex;)V:20 - ReplaceConstant - -1 -> 1
   * 8 Weak Mutation 3: smashed.RegionWorkSpace.init_vertex(Lsmashed/Vertex;)V:20 - ReplaceConstant - -1 -> -2
   * 9 smashed.RegionWorkSpace.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      RegionWorkSpace regionWorkSpace0 = new RegionWorkSpace();
      Vertex vertex0 = new Vertex();
      regionWorkSpace0.init_vertex(vertex0);
      assertEquals((-1), vertex0.componentNumber);
      assertEquals(0, regionWorkSpace0.counter);
  }
}