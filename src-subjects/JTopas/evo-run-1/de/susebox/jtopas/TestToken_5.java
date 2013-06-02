/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.Token;

@RunWith(EvoSuiteRunner.class)
public class TestToken_5 {


  //Test case number: 5
  /*
   * 13 covered goals:
   * 1 Weak Mutation 46: de.susebox.jtopas.Token.getEndPosition()I:379 - DeleteStatement: getStartPosition()I
   * 2 Weak Mutation 47: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> +
   * 3 Weak Mutation 45: de.susebox.jtopas.Token.getEndPosition()I:379 - DeleteStatement: getLength()I
   * 4 Weak Mutation 50: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> *
   * 5 Weak Mutation 49: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> /
   * 6 Weak Mutation 48: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> %
   * 7 de.susebox.jtopas.Token.getEndPosition()I: root-Branch
   * 8 Weak Mutation 46: de.susebox.jtopas.Token.getEndPosition()I:379 - DeleteStatement: getStartPosition()I
   * 9 Weak Mutation 47: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> +
   * 10 Weak Mutation 45: de.susebox.jtopas.Token.getEndPosition()I:379 - DeleteStatement: getLength()I
   * 11 Weak Mutation 50: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> *
   * 12 Weak Mutation 49: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> /
   * 13 Weak Mutation 48: de.susebox.jtopas.Token.getEndPosition()I:379 - ReplaceArithmeticOperator - -> %
   */
  @Test
  public void test5()  throws Throwable  {
      Token token0 = new Token(21);
      assertNotNull(token0);
      
      int int0 = token0.getEndPosition();
      assertEquals(-1, token0.getStartColumn());
      assertEquals(-1, token0.getStartLine());
      assertEquals(1, int0);
      assertEquals(21, token0.getType());
      assertEquals(-1, token0.getEndColumn());
      assertEquals(-1, token0.getEndLine());
  }
}