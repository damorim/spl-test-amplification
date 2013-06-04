/*
 * This file was automatically generated by EvoSuite
 */

package sudoku.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import sudoku.main.Board;

@RunWith(EvoSuiteRunner.class)
public class TestBoard {


  //Test case number: 0
  /*
   * 8 covered goals:
   * 1 Weak Mutation 0: sudoku.main.Board.<init>()V:34 - InsertUnaryOp Negation
   * 2 Weak Mutation 1: sudoku.main.Board.<init>()V:34 - InsertUnaryOp +1
   * 3 Weak Mutation 2: sudoku.main.Board.<init>()V:34 - InsertUnaryOp -1
   * 4 Weak Mutation 3: sudoku.main.Board.<init>()V:34 - DeleteField: ELEMENTSI
   * 5 Weak Mutation 0: sudoku.main.Board.<init>()V:34 - InsertUnaryOp Negation
   * 6 Weak Mutation 1: sudoku.main.Board.<init>()V:34 - InsertUnaryOp +1
   * 7 Weak Mutation 2: sudoku.main.Board.<init>()V:34 - InsertUnaryOp -1
   * 8 Weak Mutation 3: sudoku.main.Board.<init>()V:34 - DeleteField: ELEMENTSI
   */
  @Test
  public void test0()  throws Throwable  {
      Board board0 = null;
      try {
        board0 = new Board();
        fail("Expecting exception: NegativeArraySizeException");
      } catch(NegativeArraySizeException e) {
      }
  }
}