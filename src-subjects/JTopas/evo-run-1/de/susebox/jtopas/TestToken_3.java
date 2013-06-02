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
public class TestToken_3 {


  //Test case number: 3
  /*
   * 64 covered goals:
   * 1 Weak Mutation 128: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:570 - ReplaceComparisonOperator == -> >=
   * 2 Weak Mutation 19: de.susebox.jtopas.Token.setLength(I)V:286 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 18: de.susebox.jtopas.Token.setLength(I)V:286 - InsertUnaryOp Negation
   * 4 Weak Mutation 20: de.susebox.jtopas.Token.setLength(I)V:286 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 34: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 35: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 33: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp Negation
   * 8 Weak Mutation 38: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp -1
   * 9 Weak Mutation 39: de.susebox.jtopas.Token.setEndPosition(I)V:365 - DeleteField: _startPositionI
   * 10 Weak Mutation 36: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp Negation
   * 11 Weak Mutation 37: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp +1
   * 12 Weak Mutation 42: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> /
   * 13 Weak Mutation 43: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> *
   * 14 Weak Mutation 40: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> +
   * 15 Weak Mutation 41: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> %
   * 16 Weak Mutation 44: de.susebox.jtopas.Token.setEndPosition(I)V:365 - DeleteStatement: setLength(I)V
   * 17 Weak Mutation 19: de.susebox.jtopas.Token.setLength(I)V:286 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 18: de.susebox.jtopas.Token.setLength(I)V:286 - InsertUnaryOp Negation
   * 19 Weak Mutation 21: de.susebox.jtopas.Token.getLength()I:298 - InsertUnaryOp Negation
   * 20 Weak Mutation 20: de.susebox.jtopas.Token.setLength(I)V:286 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 23: de.susebox.jtopas.Token.getLength()I:298 - InsertUnaryOp -1
   * 22 Weak Mutation 22: de.susebox.jtopas.Token.getLength()I:298 - InsertUnaryOp +1
   * 23 Weak Mutation 24: de.susebox.jtopas.Token.getLength()I:298 - DeleteField: _lengthI
   * 24 Weak Mutation 29: de.susebox.jtopas.Token.getStartPosition()I:344 - InsertUnaryOp Negation
   * 25 Weak Mutation 31: de.susebox.jtopas.Token.getStartPosition()I:344 - InsertUnaryOp -1
   * 26 Weak Mutation 30: de.susebox.jtopas.Token.getStartPosition()I:344 - InsertUnaryOp +1
   * 27 Weak Mutation 34: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp IINC 1
   * 28 Weak Mutation 35: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp IINC -1
   * 29 Weak Mutation 32: de.susebox.jtopas.Token.getStartPosition()I:344 - DeleteField: _startPositionI
   * 30 Weak Mutation 33: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp Negation
   * 31 Weak Mutation 38: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp -1
   * 32 Weak Mutation 39: de.susebox.jtopas.Token.setEndPosition(I)V:365 - DeleteField: _startPositionI
   * 33 Weak Mutation 36: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp Negation
   * 34 Weak Mutation 37: de.susebox.jtopas.Token.setEndPosition(I)V:365 - InsertUnaryOp +1
   * 35 Weak Mutation 42: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> /
   * 36 Weak Mutation 43: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> *
   * 37 Weak Mutation 40: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> +
   * 38 Weak Mutation 41: de.susebox.jtopas.Token.setEndPosition(I)V:365 - ReplaceArithmeticOperator - -> %
   * 39 Weak Mutation 44: de.susebox.jtopas.Token.setEndPosition(I)V:365 - DeleteStatement: setLength(I)V
   * 40 Weak Mutation 110: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:559 - DeleteStatement: getClass()Ljava/lang/Class;
   * 41 Weak Mutation 111: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:559 - DeleteStatement: getClass()Ljava/lang/Class;
   * 42 Weak Mutation 108: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:557 - ReplaceComparisonOperator != -> ==
   * 43 Weak Mutation 106: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:555 - ReplaceComparisonOperator != null -> = null
   * 44 Weak Mutation 117: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:566 - ReplaceComparisonOperator == -> -2
   * 45 Weak Mutation 115: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:566 - DeleteStatement: getType()I
   * 46 Weak Mutation 114: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:566 - DeleteStatement: getType()I
   * 47 Weak Mutation 112: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:559 - ReplaceComparisonOperator == -> !=
   * 48 Weak Mutation 127: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:570 - DeleteStatement: getLength()I
   * 49 Weak Mutation 126: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:570 - DeleteStatement: getLength()I
   * 50 Weak Mutation 123: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:568 - ReplaceComparisonOperator == -> -2
   * 51 Weak Mutation 121: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:568 - DeleteStatement: getStartPosition()I
   * 52 Weak Mutation 120: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:568 - DeleteStatement: getStartPosition()I
   * 53 Weak Mutation 128: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:570 - ReplaceComparisonOperator == -> >=
   * 54 Weak Mutation 131: de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z:571 - ReplaceConstant - 0 -> 1
   * 55 de.susebox.jtopas.Token.getLength()I: root-Branch
   * 56 de.susebox.jtopas.Token.setEndPosition(I)V: root-Branch
   * 57 de.susebox.jtopas.Token.getStartPosition()I: root-Branch
   * 58 de.susebox.jtopas.Token.setLength(I)V: root-Branch
   * 59 de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z: I3 Branch 3 IFNONNULL L555 - true
   * 60 de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z: I12 Branch 4 IF_ACMPNE L557 - true
   * 61 de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z: I23 Branch 5 IF_ACMPEQ L559 - true
   * 62 de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z: I39 Branch 6 IF_ICMPEQ L566 - true
   * 63 de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z: I50 Branch 7 IF_ICMPEQ L568 - true
   * 64 de.susebox.jtopas.Token.equals(Ljava/lang/Object;)Z: I61 Branch 8 IF_ICMPEQ L570 - false
   */
  @Test
  public void test3()  throws Throwable  {
      Token token0 = new Token(0);
      assertNotNull(token0);
      
      token0.setEndPosition(0);
      Token token1 = new Token(0);
      boolean boolean0 = token0.equals((Object) token1);
      assertEquals(false, boolean0);
      assertEquals(2, token0.getEndPosition());
  }
}