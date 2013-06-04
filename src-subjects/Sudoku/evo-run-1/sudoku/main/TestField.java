/*
 * This file was automatically generated by EvoSuite
 */

package sudoku.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import sudoku.main.Field;

@RunWith(EvoSuiteRunner.class)
public class TestField {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 Weak Mutation 0: sudoku.main.Field.<init>()V:41 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 1: sudoku.main.Field.<init>()V:42 - ReplaceConstant - 0 -> 1
   * 3 sudoku.main.Field.<init>()V: root-Branch
   * 4 Weak Mutation 0: sudoku.main.Field.<init>()V:41 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 1: sudoku.main.Field.<init>()V:42 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test0()  throws Throwable  {
      Field field0 = new Field();
      assertEquals(false, field0.isSet());
      assertEquals(false, field0.isInitialSet());
  }

  //Test case number: 1
  /*
   * 15 covered goals:
   * 1 Weak Mutation 14: sudoku.main.Field.getValue()I:100 - InsertUnaryOp Negation
   * 2 Weak Mutation 15: sudoku.main.Field.getValue()I:100 - InsertUnaryOp +1
   * 3 Weak Mutation 17: sudoku.main.Field.getValue()I:100 - DeleteField: valueI
   * 4 Weak Mutation 16: sudoku.main.Field.getValue()I:100 - InsertUnaryOp -1
   * 5 sudoku.main.Field.getValue()I: root-Branch
   * 6 Weak Mutation 9: sudoku.main.Field.<init>(I)V:79 - InsertUnaryOp Negation
   * 7 Weak Mutation 10: sudoku.main.Field.<init>(I)V:79 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 11: sudoku.main.Field.<init>(I)V:79 - InsertUnaryOp IINC -1
   * 9 Weak Mutation 12: sudoku.main.Field.<init>(I)V:80 - ReplaceConstant - 1 -> 0
   * 10 Weak Mutation 13: sudoku.main.Field.<init>(I)V:81 - ReplaceConstant - 0 -> 1
   * 11 Weak Mutation 14: sudoku.main.Field.getValue()I:100 - InsertUnaryOp Negation
   * 12 Weak Mutation 15: sudoku.main.Field.getValue()I:100 - InsertUnaryOp +1
   * 13 Weak Mutation 17: sudoku.main.Field.getValue()I:100 - DeleteField: valueI
   * 14 Weak Mutation 16: sudoku.main.Field.getValue()I:100 - InsertUnaryOp -1
   * 15 sudoku.main.Field.<init>(I)V: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      Field field0 = new Field((-1734));
      int int0 = field0.getValue();
      assertEquals(false, field0.isInitialSet());
      assertEquals(true, field0.isSet());
      assertEquals((-1734), int0);
  }

  //Test case number: 2
  /*
   * 20 covered goals:
   * 1 Weak Mutation 19: sudoku.main.Field.isInitialSet()Z:109 - DeleteField: initialSetZ
   * 2 Weak Mutation 18: sudoku.main.Field.isInitialSet()Z:109 - InsertUnaryOp Negation
   * 3 sudoku.main.Field.isInitialSet()Z: root-Branch
   * 4 Weak Mutation 2: sudoku.main.Field.<init>(IZ)V:63 - InsertUnaryOp Negation
   * 5 Weak Mutation 3: sudoku.main.Field.<init>(IZ)V:63 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 4: sudoku.main.Field.<init>(IZ)V:63 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 5: sudoku.main.Field.<init>(IZ)V:64 - ReplaceConstant - 1 -> 0
   * 8 Weak Mutation 6: sudoku.main.Field.<init>(IZ)V:65 - InsertUnaryOp Negation
   * 9 Weak Mutation 7: sudoku.main.Field.<init>(IZ)V:65 - InsertUnaryOp IINC 1
   * 10 Weak Mutation 8: sudoku.main.Field.<init>(IZ)V:65 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 2: sudoku.main.Field.<init>(IZ)V:63 - InsertUnaryOp Negation
   * 12 Weak Mutation 3: sudoku.main.Field.<init>(IZ)V:63 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 4: sudoku.main.Field.<init>(IZ)V:63 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 5: sudoku.main.Field.<init>(IZ)V:64 - ReplaceConstant - 1 -> 0
   * 15 Weak Mutation 6: sudoku.main.Field.<init>(IZ)V:65 - InsertUnaryOp Negation
   * 16 Weak Mutation 7: sudoku.main.Field.<init>(IZ)V:65 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 8: sudoku.main.Field.<init>(IZ)V:65 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 19: sudoku.main.Field.isInitialSet()Z:109 - DeleteField: initialSetZ
   * 19 Weak Mutation 18: sudoku.main.Field.isInitialSet()Z:109 - InsertUnaryOp Negation
   * 20 sudoku.main.Field.<init>(IZ)V: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      Field field0 = new Field(2008, true);
      boolean boolean0 = field0.isInitialSet();
      assertEquals(2008, field0.getValue());
      assertEquals(true, field0.isSet());
      assertEquals(true, boolean0);
  }

  //Test case number: 3
  /*
   * 5 covered goals:
   * 1 Weak Mutation 21: sudoku.main.Field.isSet()Z:118 - DeleteField: setZ
   * 2 Weak Mutation 20: sudoku.main.Field.isSet()Z:118 - InsertUnaryOp Negation
   * 3 sudoku.main.Field.isSet()Z: root-Branch
   * 4 Weak Mutation 21: sudoku.main.Field.isSet()Z:118 - DeleteField: setZ
   * 5 Weak Mutation 20: sudoku.main.Field.isSet()Z:118 - InsertUnaryOp Negation
   */
  @Test
  public void test3()  throws Throwable  {
      Field field0 = new Field((-1734));
      boolean boolean0 = field0.isSet();
      assertEquals(true, boolean0);
      assertEquals(-1734, field0.getValue());
      assertEquals(false, field0.isInitialSet());
  }

  //Test case number: 4
  /*
   * 6 covered goals:
   * 1 sudoku.main.Field.setInitial(Z)V: root-Branch
   * 2 Weak Mutation 9: sudoku.main.Field.<init>(I)V:79 - InsertUnaryOp Negation
   * 3 Weak Mutation 10: sudoku.main.Field.<init>(I)V:79 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 11: sudoku.main.Field.<init>(I)V:79 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 12: sudoku.main.Field.<init>(I)V:80 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 13: sudoku.main.Field.<init>(I)V:81 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test4()  throws Throwable  {
      Field field0 = new Field((-1734));
      field0.setInitial(false);
      assertEquals(false, field0.isInitialSet());
      assertEquals(true, field0.isSet());
      assertEquals(-1734, field0.getValue());
  }
}