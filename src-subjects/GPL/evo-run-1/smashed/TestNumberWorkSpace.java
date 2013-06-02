/*
 * This file was automatically generated by EvoSuite
 */

package smashed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import smashed.NumberWorkSpace;
import smashed.Vertex;
import smashed.WorkSpace;

@RunWith(EvoSuiteRunner.class)
public class TestNumberWorkSpace {


  //Test case number: 0
  /*
   * 16 covered goals:
   * 1 Weak Mutation 8: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - DeleteField: vertexCounterI
   * 2 Weak Mutation 0: smashed.NumberWorkSpace.<init>()V:14 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 1: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - InsertUnaryOp Negation
   * 4 Weak Mutation 3: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 4: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 5: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - InsertUnaryOp Negation
   * 7 Weak Mutation 6: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - InsertUnaryOp +1
   * 8 Weak Mutation 7: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - InsertUnaryOp -1
   * 9 Weak Mutation 8: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - DeleteField: vertexCounterI
   * 10 Weak Mutation 9: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceConstant - 1 -> 0
   * 11 Weak Mutation 10: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> -
   * 12 Weak Mutation 11: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> %
   * 13 Weak Mutation 12: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> /
   * 14 Weak Mutation 13: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> *
   * 15 smashed.NumberWorkSpace.<init>()V: root-Branch
   * 16 smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V: I5 Branch 1 IF_ICMPEQ L22 - false
   */
  @Test
  public void test0()  throws Throwable  {
      NumberWorkSpace numberWorkSpace0 = new NumberWorkSpace();
      Vertex vertex0 = new Vertex();
      numberWorkSpace0.preVisitAction(vertex0);
      numberWorkSpace0.preVisitAction(vertex0);
      assertEquals(2, numberWorkSpace0.vertexCounter);
      assertEquals(1, vertex0.VertexNumber);
  }

  //Test case number: 1
  /*
   * 15 covered goals:
   * 1 Weak Mutation 2: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - DeleteField: visitedZ
   * 2 smashed.NumberWorkSpace.postVisitAction(Lsmashed/Vertex;)V: root-Branch
   * 3 smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V: I5 Branch 1 IF_ICMPEQ L22 - true
   * 4 Weak Mutation 1: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - InsertUnaryOp Negation
   * 5 Weak Mutation 3: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 4: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - ReplaceComparisonOperator == -> !=
   * 7 Weak Mutation 5: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - InsertUnaryOp Negation
   * 8 Weak Mutation 6: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - InsertUnaryOp +1
   * 9 Weak Mutation 7: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - InsertUnaryOp -1
   * 10 Weak Mutation 9: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceConstant - 1 -> 0
   * 11 Weak Mutation 10: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> -
   * 12 Weak Mutation 11: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> %
   * 13 Weak Mutation 12: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> /
   * 14 Weak Mutation 13: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:23 - ReplaceArithmeticOperator + -> *
   * 15 Weak Mutation 2: smashed.NumberWorkSpace.preVisitAction(Lsmashed/Vertex;)V:22 - DeleteField: visitedZ
   */
  @Test
  public void test1()  throws Throwable  {
      NumberWorkSpace numberWorkSpace0 = new NumberWorkSpace();
      Vertex vertex0 = new Vertex();
      vertex0.dftNodeSearch((WorkSpace) numberWorkSpace0);
      numberWorkSpace0.preVisitAction(vertex0);
      assertEquals(1, numberWorkSpace0.vertexCounter);
  }

  //Test case number: 2
  /*
   * 2 covered goals:
   * 1 smashed.NumberWorkSpace.checkNeighborAction(Lsmashed/Vertex;Lsmashed/Vertex;)V: root-Branch
   * 2 Weak Mutation 0: smashed.NumberWorkSpace.<init>()V:14 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test2()  throws Throwable  {
      NumberWorkSpace numberWorkSpace0 = new NumberWorkSpace();
      Vertex vertex0 = new Vertex();
      numberWorkSpace0.checkNeighborAction(vertex0, vertex0);
      assertEquals(0, numberWorkSpace0.vertexCounter);
  }
}