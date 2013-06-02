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
public class TestField_2 {


  //Test case number: 2
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
  public void test2()  throws Throwable  {
      Field field0 = new Field(1);
      int int0 = field0.getValue();
      assertEquals(true, field0.isSet());
      assertEquals(1, int0);
      assertEquals(false, field0.isInitialSet());
  }
}