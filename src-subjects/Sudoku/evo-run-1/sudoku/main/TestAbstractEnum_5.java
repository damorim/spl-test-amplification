/*
 * This file was automatically generated by EvoSuite
 */

package sudoku.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import sudoku.main.AbstractEnum;
import sudoku.main.Structure;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractEnum_5 {


  //Test case number: 5
  /*
   * 9 covered goals:
   * 1 Weak Mutation 38: sudoku.main.AbstractEnum.ordinal()I:193 - InsertUnaryOp -1
   * 2 Weak Mutation 39: sudoku.main.AbstractEnum.ordinal()I:193 - DeleteField: ordinalI
   * 3 Weak Mutation 36: sudoku.main.AbstractEnum.ordinal()I:193 - InsertUnaryOp Negation
   * 4 Weak Mutation 37: sudoku.main.AbstractEnum.ordinal()I:193 - InsertUnaryOp +1
   * 5 sudoku.main.AbstractEnum.ordinal()I: root-Branch
   * 6 Weak Mutation 38: sudoku.main.AbstractEnum.ordinal()I:193 - InsertUnaryOp -1
   * 7 Weak Mutation 39: sudoku.main.AbstractEnum.ordinal()I:193 - DeleteField: ordinalI
   * 8 Weak Mutation 36: sudoku.main.AbstractEnum.ordinal()I:193 - InsertUnaryOp Negation
   * 9 Weak Mutation 37: sudoku.main.AbstractEnum.ordinal()I:193 - InsertUnaryOp +1
   */
  @Test
  public void test5()  throws Throwable  {
      Structure structure0 = Structure.BOX;
      int int0 = structure0.ordinal();
      assertEquals(2, int0);
  }
}