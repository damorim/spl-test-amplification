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
public class TestRegionWorkSpace_3 {


  //Test case number: 3
  /*
   * 2 covered goals:
   * 1 smashed.RegionWorkSpace.checkNeighborAction(Lsmashed/Vertex;Lsmashed/Vertex;)V: root-Branch
   * 2 Weak Mutation 0: smashed.RegionWorkSpace.<init>()V:14 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test3()  throws Throwable  {
      RegionWorkSpace regionWorkSpace0 = new RegionWorkSpace();
      Vertex vertex0 = new Vertex();
      regionWorkSpace0.checkNeighborAction(vertex0, vertex0);
      assertEquals(0, regionWorkSpace0.counter);
  }
}
