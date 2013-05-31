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
public class TestVertex_6 {


  //Test case number: 6
  /*
   * 57 covered goals:
   * 1 Weak Mutation 98: smashed.Vertex.display()V:257 - DeleteField: nameLjava/lang/String;
   * 2 Weak Mutation 1: smashed.Vertex.addAdjacent(Lsmashed/Vertex;)V:32 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 3 Weak Mutation 2: smashed.Vertex.addAdjacent(Lsmashed/Vertex;)V:32 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 4 Weak Mutation 76: smashed.Vertex.display()V:203 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 5 Weak Mutation 77: smashed.Vertex.display()V:204 - DeleteField: nameLjava/lang/String;
   * 6 Weak Mutation 78: smashed.Vertex.display()V:204 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 7 Weak Mutation 79: smashed.Vertex.display()V:253 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 8 Weak Mutation 75: smashed.Vertex.display()V:203 - ReplaceConstant - Printing vertex:  -> 
   * 9 Weak Mutation 85: smashed.Vertex.display()V:256 - InsertUnaryOp IINC 1
   * 10 Weak Mutation 84: smashed.Vertex.display()V:256 - InsertUnaryOp Negation
   * 11 Weak Mutation 87: smashed.Vertex.display()V:256 - InsertUnaryOp Negation
   * 12 Weak Mutation 86: smashed.Vertex.display()V:256 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 81: smashed.Vertex.display()V:255 - ReplaceConstant - Connected to:  -> 
   * 14 Weak Mutation 80: smashed.Vertex.display()V:253 - DeleteStatement: size()I
   * 15 Weak Mutation 83: smashed.Vertex.display()V:256 - ReplaceConstant - 0 -> 1
   * 16 Weak Mutation 82: smashed.Vertex.display()V:255 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 17 Weak Mutation 93: smashed.Vertex.display()V:257 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 18 Weak Mutation 92: smashed.Vertex.display()V:256 - ReplaceComparisonOperator >= -> -1
   * 19 Weak Mutation 95: smashed.Vertex.display()V:257 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 94: smashed.Vertex.display()V:257 - InsertUnaryOp Negation
   * 21 Weak Mutation 89: smashed.Vertex.display()V:256 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 88: smashed.Vertex.display()V:256 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 91: smashed.Vertex.display()V:256 - ReplaceComparisonOperator >= -> >
   * 24 Weak Mutation 100: smashed.Vertex.display()V:258 - ReplaceConstant - 
 -> 
   * 25 Weak Mutation 101: smashed.Vertex.display()V:258 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 26 Weak Mutation 99: smashed.Vertex.display()V:257 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 27 Weak Mutation 96: smashed.Vertex.display()V:257 - InsertUnaryOp IINC -1
   * 28 Weak Mutation 97: smashed.Vertex.display()V:257 - DeleteStatement: get(I)Ljava/lang/Object;
   * 29 Weak Mutation 76: smashed.Vertex.display()V:203 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 30 Weak Mutation 77: smashed.Vertex.display()V:204 - DeleteField: nameLjava/lang/String;
   * 31 Weak Mutation 78: smashed.Vertex.display()V:204 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 32 Weak Mutation 79: smashed.Vertex.display()V:253 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 33 Weak Mutation 75: smashed.Vertex.display()V:203 - ReplaceConstant - Printing vertex:  -> 
   * 34 Weak Mutation 85: smashed.Vertex.display()V:256 - InsertUnaryOp IINC 1
   * 35 Weak Mutation 84: smashed.Vertex.display()V:256 - InsertUnaryOp Negation
   * 36 Weak Mutation 87: smashed.Vertex.display()V:256 - InsertUnaryOp Negation
   * 37 Weak Mutation 86: smashed.Vertex.display()V:256 - InsertUnaryOp IINC -1
   * 38 Weak Mutation 81: smashed.Vertex.display()V:255 - ReplaceConstant - Connected to:  -> 
   * 39 Weak Mutation 80: smashed.Vertex.display()V:253 - DeleteStatement: size()I
   * 40 Weak Mutation 83: smashed.Vertex.display()V:256 - ReplaceConstant - 0 -> 1
   * 41 Weak Mutation 82: smashed.Vertex.display()V:255 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 42 Weak Mutation 93: smashed.Vertex.display()V:257 - DeleteField: adjacentVerticesLjava/util/LinkedList;
   * 43 Weak Mutation 92: smashed.Vertex.display()V:256 - ReplaceComparisonOperator >= -> -1
   * 44 Weak Mutation 95: smashed.Vertex.display()V:257 - InsertUnaryOp IINC 1
   * 45 Weak Mutation 94: smashed.Vertex.display()V:257 - InsertUnaryOp Negation
   * 46 Weak Mutation 89: smashed.Vertex.display()V:256 - InsertUnaryOp IINC -1
   * 47 Weak Mutation 88: smashed.Vertex.display()V:256 - InsertUnaryOp IINC 1
   * 48 Weak Mutation 91: smashed.Vertex.display()V:256 - ReplaceComparisonOperator >= -> >
   * 49 Weak Mutation 100: smashed.Vertex.display()V:258 - ReplaceConstant - 
 -> 
   * 50 Weak Mutation 101: smashed.Vertex.display()V:258 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 51 Weak Mutation 98: smashed.Vertex.display()V:257 - DeleteField: nameLjava/lang/String;
   * 52 Weak Mutation 99: smashed.Vertex.display()V:257 - DeleteStatement: splPrint___(Ljava/lang/String;)V
   * 53 Weak Mutation 96: smashed.Vertex.display()V:257 - InsertUnaryOp IINC -1
   * 54 Weak Mutation 97: smashed.Vertex.display()V:257 - DeleteStatement: get(I)Ljava/lang/Object;
   * 55 smashed.Vertex.assignName(Ljava/lang/String;)Lsmashed/Vertex;: root-Branch
   * 56 smashed.Vertex.display()V: I26 Branch 7 IF_ICMPGE L256 - true
   * 57 smashed.Vertex.display()V: I26 Branch 7 IF_ICMPGE L256 - false
   */
  @Test
  public void test6()  throws Throwable  {
      Vertex vertex0 = new Vertex();
      vertex0.addAdjacent(vertex0);
      Vertex vertex1 = vertex0.assignName("zHpDev");
      vertex1.display();
      assertEquals(0, vertex1.finishTime);
  }
}