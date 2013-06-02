/*
 * This file was automatically generated by EvoSuite
 */

package sudoku.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.SortedSet;
import sudoku.main.AbstractEnum;
import sudoku.main.Structure;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractEnum_9 {


  //Test case number: 9
  /*
   * 6 covered goals:
   * 1 Weak Mutation 98: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:268 - DeleteStatement: toString()Ljava/lang/String;
   * 2 sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V: I5 Branch 7 IFNE L267 - false
   * 3 Weak Mutation 10: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:111 - DeleteStatement: checkClassIsEnum(Ljava/lang/Class;)V
   * 4 Weak Mutation 96: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:267 - DeleteStatement: isAssignableFrom(Ljava/lang/Class;)Z
   * 5 Weak Mutation 97: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:267 - ReplaceComparisonOperator != -> ==
   * 6 Weak Mutation 98: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:268 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test9()  throws Throwable  {
      Class<?> class0 = SortedSet.class;
      // Undeclared exception!
      try {
        AbstractEnum.count(class0);
        fail("Expecting exception: ClassCastException");
      } catch(ClassCastException e) {
        /*
         * interface java.util.SortedSet
         */
      }
  }
}