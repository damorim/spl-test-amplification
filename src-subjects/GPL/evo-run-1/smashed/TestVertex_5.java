/*
 * This file was automatically generated by EvoSuite
 */

package smashed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import smashed.FinishTimeWorkSpace;
import smashed.Vertex;
import smashed.WorkSpace;

@RunWith(EvoSuiteRunner.class)
public class TestVertex_5 {


  //Test case number: 5
  /*
   * 35 covered goals:
   * 1 Weak Mutation 52: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:137 - DeleteField: visitedZ
   * 2 Weak Mutation 66: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - ReplaceComparisonOperator >= -> -1
   * 3 Weak Mutation 68: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - InsertUnaryOp Negation
   * 4 Weak Mutation 69: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 70: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 71: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - DeleteStatement: get(I)Ljava/lang/Object;
   * 7 Weak Mutation 67: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 8 Weak Mutation 72: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:149 - DeleteStatement: checkNeighborAction(Lsmashed/Vertex;Lsmashed/Vertex;)V
   * 9 Weak Mutation 73: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:150 - DeleteStatement: dftNodeSearch(Lsmashed/WorkSpace;)V
   * 10 smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V: I9 Branch 5 IFEQ L137 - false
   * 11 smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V: I31 Branch 6 IF_ICMPGE L146 - false
   * 12 Weak Mutation 51: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:137 - InsertUnaryOp Negation
   * 13 Weak Mutation 50: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:135 - DeleteStatement: preVisitAction(Lsmashed/Vertex;)V
   * 14 Weak Mutation 55: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:145 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 15 Weak Mutation 54: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:143 - ReplaceConstant - 1 -> 0
   * 16 Weak Mutation 53: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:137 - ReplaceComparisonOperator == -> !=
   * 17 Weak Mutation 59: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 58: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - InsertUnaryOp Negation
   * 19 Weak Mutation 57: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - ReplaceConstant - 0 -> 1
   * 20 Weak Mutation 56: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:145 - DeleteStatement: size()I
   * 21 Weak Mutation 63: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 62: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 61: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - InsertUnaryOp Negation
   * 24 Weak Mutation 60: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 65: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - ReplaceComparisonOperator >= -> >
   * 26 Weak Mutation 74: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:155 - DeleteStatement: postVisitAction(Lsmashed/Vertex;)V
   * 27 Weak Mutation 52: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:137 - DeleteField: visitedZ
   * 28 Weak Mutation 68: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - InsertUnaryOp Negation
   * 29 Weak Mutation 69: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - InsertUnaryOp IINC 1
   * 30 Weak Mutation 70: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - InsertUnaryOp IINC -1
   * 31 Weak Mutation 71: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - DeleteStatement: get(I)Ljava/lang/Object;
   * 32 Weak Mutation 66: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:146 - ReplaceComparisonOperator >= -> -1
   * 33 Weak Mutation 67: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:148 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 34 Weak Mutation 72: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:149 - DeleteStatement: checkNeighborAction(Lsmashed/Vertex;Lsmashed/Vertex;)V
   * 35 Weak Mutation 73: smashed.Vertex.dftNodeSearch(Lsmashed/WorkSpace;)V:150 - DeleteStatement: dftNodeSearch(Lsmashed/WorkSpace;)V
   */
  @Test
  public void test5()  throws Throwable  {
      Vertex vertex0 = new Vertex();
      vertex0.addAdjacent(vertex0);
      FinishTimeWorkSpace finishTimeWorkSpace0 = new FinishTimeWorkSpace();
      vertex0.dftNodeSearch((WorkSpace) finishTimeWorkSpace0);
      assertEquals(2, vertex0.finishTime);
      assertEquals(true, vertex0.visited);
  }
}