/*
 * This file was automatically generated by EvoSuite
 */

package sudoku.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import sudoku.main.Structure;

@RunWith(EvoSuiteRunner.class)
public class TestStructure_0 {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 Weak Mutation 0: sudoku.main.Structure.values()[Lsudoku/main/Structure;:15 - DeleteStatement: count(Ljava/lang/Class;)I
   * 2 Weak Mutation 1: sudoku.main.Structure.values()[Lsudoku/main/Structure;:15 - DeleteStatement: values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;
   * 3 sudoku.main.Structure.values()[Lsudoku/main/Structure;: root-Branch
   * 4 Weak Mutation 0: sudoku.main.Structure.values()[Lsudoku/main/Structure;:15 - DeleteStatement: count(Ljava/lang/Class;)I
   * 5 Weak Mutation 1: sudoku.main.Structure.values()[Lsudoku/main/Structure;:15 - DeleteStatement: values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;
   */
  @Test
  public void test0()  throws Throwable  {
      Structure[] structureArray0 = Structure.values();
      assertNotNull(structureArray0);
  }
}