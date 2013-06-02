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
public class TestField_3 {


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
      Field field0 = new Field(1);
      boolean boolean0 = field0.isSet();
      assertEquals(false, field0.isInitialSet());
      assertEquals(true, boolean0);
      assertEquals(1, field0.getValue());
  }
}