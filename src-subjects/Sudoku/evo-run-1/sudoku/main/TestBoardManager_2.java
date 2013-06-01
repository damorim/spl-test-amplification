/*
 * This file was automatically generated by EvoSuite
 */

package sudoku.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import sudoku.main.BoardManager;

@RunWith(EvoSuiteRunner.class)
public class TestBoardManager_2 {


  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 Weak Mutation 120: sudoku.main.BoardManager.getBoard()Lsudoku/main/Board;:131 - ReplaceComparisonOperator != null -> = null
   * 2 sudoku.main.BoardManager.getBoard()Lsudoku/main/Board;: I4 Branch 9 IFNONNULL L131 - false
   * 3 Weak Mutation 120: sudoku.main.BoardManager.getBoard()Lsudoku/main/Board;:131 - ReplaceComparisonOperator != null -> = null
   */
  @Test
  public void test2()  throws Throwable  {
      BoardManager boardManager0 = new BoardManager();
      // Undeclared exception!
      try {
        boardManager0.getBoard();
        fail("Expecting exception: NegativeArraySizeException");
      } catch(NegativeArraySizeException e) {
      }
  }
}
