/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.CharArraySource;

@RunWith(EvoSuiteRunner.class)
public class TestCharArraySource_0 {


  //Test case number: 0
  /*
   * 59 covered goals:
   * 1 Weak Mutation 21: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp Negation
   * 2 Weak Mutation 23: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp -1
   * 3 Weak Mutation 22: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp +1
   * 4 Weak Mutation 25: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp Negation
   * 5 Weak Mutation 24: de.susebox.jtopas.CharArraySource.read([CII)I:107 - DeleteField: _lengthI
   * 6 Weak Mutation 27: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp -1
   * 7 Weak Mutation 26: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp +1
   * 8 Weak Mutation 31: de.susebox.jtopas.CharArraySource.read([CII)I:107 - ReplaceArithmeticOperator - -> /
   * 9 Weak Mutation 30: de.susebox.jtopas.CharArraySource.read([CII)I:107 - ReplaceArithmeticOperator - -> %
   * 10 Weak Mutation 34: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 35: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 33: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp Negation
   * 13 Weak Mutation 36: de.susebox.jtopas.CharArraySource.read([CII)I:107 - DeleteStatement: min(II)I
   * 14 Weak Mutation 38: de.susebox.jtopas.CharArraySource.read([CII)I:109 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 39: de.susebox.jtopas.CharArraySource.read([CII)I:109 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 37: de.susebox.jtopas.CharArraySource.read([CII)I:109 - InsertUnaryOp Negation
   * 17 Weak Mutation 41: de.susebox.jtopas.CharArraySource.read([CII)I:109 - ReplaceComparisonOperator <= -> <
   * 18 Weak Mutation 77: de.susebox.jtopas.CharArraySource.read([CII)I:114 - ReplaceConstant - -1 -> 0
   * 19 Weak Mutation 78: de.susebox.jtopas.CharArraySource.read([CII)I:114 - ReplaceConstant - -1 -> 1
   * 20 Weak Mutation 79: de.susebox.jtopas.CharArraySource.read([CII)I:114 - ReplaceConstant - -1 -> -2
   * 21 de.susebox.jtopas.CharArraySource.read([CII)I: I13 Branch 4 IFLE L109 - true
   * 22 Weak Mutation 0: de.susebox.jtopas.CharArraySource.<init>([CII)V:171 - ReplaceConstant - 0 -> 1
   * 23 Weak Mutation 1: de.susebox.jtopas.CharArraySource.<init>([CII)V:172 - ReplaceConstant - -1 -> 0
   * 24 Weak Mutation 2: de.susebox.jtopas.CharArraySource.<init>([CII)V:172 - ReplaceConstant - -1 -> 1
   * 25 Weak Mutation 3: de.susebox.jtopas.CharArraySource.<init>([CII)V:172 - ReplaceConstant - -1 -> -2
   * 26 Weak Mutation 4: de.susebox.jtopas.CharArraySource.<init>([CII)V:173 - ReplaceConstant - 0 -> 1
   * 27 Weak Mutation 5: de.susebox.jtopas.CharArraySource.<init>([CII)V:81 - InsertUnaryOp Negation
   * 28 Weak Mutation 6: de.susebox.jtopas.CharArraySource.<init>([CII)V:81 - InsertUnaryOp IINC 1
   * 29 Weak Mutation 7: de.susebox.jtopas.CharArraySource.<init>([CII)V:81 - InsertUnaryOp IINC -1
   * 30 Weak Mutation 8: de.susebox.jtopas.CharArraySource.<init>([CII)V:82 - ReplaceComparisonOperator = null -> != null
   * 31 Weak Mutation 9: de.susebox.jtopas.CharArraySource.<init>([CII)V:82 - InsertUnaryOp Negation
   * 32 Weak Mutation 10: de.susebox.jtopas.CharArraySource.<init>([CII)V:82 - InsertUnaryOp IINC 1
   * 33 Weak Mutation 11: de.susebox.jtopas.CharArraySource.<init>([CII)V:82 - InsertUnaryOp IINC -1
   * 34 Weak Mutation 12: de.susebox.jtopas.CharArraySource.<init>([CII)V:82 - ReplaceComparisonOperator >= -> ==
   * 35 Weak Mutation 19: de.susebox.jtopas.CharArraySource.<init>([CII)V:87 - InsertUnaryOp IINC 1
   * 36 Weak Mutation 18: de.susebox.jtopas.CharArraySource.<init>([CII)V:87 - InsertUnaryOp Negation
   * 37 Weak Mutation 21: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp Negation
   * 38 Weak Mutation 20: de.susebox.jtopas.CharArraySource.<init>([CII)V:87 - InsertUnaryOp IINC -1
   * 39 Weak Mutation 23: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp -1
   * 40 Weak Mutation 22: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp +1
   * 41 Weak Mutation 25: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp Negation
   * 42 Weak Mutation 24: de.susebox.jtopas.CharArraySource.read([CII)I:107 - DeleteField: _lengthI
   * 43 Weak Mutation 27: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp -1
   * 44 Weak Mutation 26: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp +1
   * 45 Weak Mutation 31: de.susebox.jtopas.CharArraySource.read([CII)I:107 - ReplaceArithmeticOperator - -> /
   * 46 Weak Mutation 30: de.susebox.jtopas.CharArraySource.read([CII)I:107 - ReplaceArithmeticOperator - -> %
   * 47 Weak Mutation 34: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp IINC 1
   * 48 Weak Mutation 35: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp IINC -1
   * 49 Weak Mutation 33: de.susebox.jtopas.CharArraySource.read([CII)I:107 - InsertUnaryOp Negation
   * 50 Weak Mutation 38: de.susebox.jtopas.CharArraySource.read([CII)I:109 - InsertUnaryOp IINC 1
   * 51 Weak Mutation 39: de.susebox.jtopas.CharArraySource.read([CII)I:109 - InsertUnaryOp IINC -1
   * 52 Weak Mutation 36: de.susebox.jtopas.CharArraySource.read([CII)I:107 - DeleteStatement: min(II)I
   * 53 Weak Mutation 37: de.susebox.jtopas.CharArraySource.read([CII)I:109 - InsertUnaryOp Negation
   * 54 Weak Mutation 41: de.susebox.jtopas.CharArraySource.read([CII)I:109 - ReplaceComparisonOperator <= -> <
   * 55 Weak Mutation 77: de.susebox.jtopas.CharArraySource.read([CII)I:114 - ReplaceConstant - -1 -> 0
   * 56 Weak Mutation 78: de.susebox.jtopas.CharArraySource.read([CII)I:114 - ReplaceConstant - -1 -> 1
   * 57 Weak Mutation 79: de.susebox.jtopas.CharArraySource.read([CII)I:114 - ReplaceConstant - -1 -> -2
   * 58 de.susebox.jtopas.CharArraySource.<init>([CII)V: I32 Branch 2 IFNULL L82 - false
   * 59 de.susebox.jtopas.CharArraySource.<init>([CII)V: I34 Branch 3 IFGE L82 - true
   */
  @Test
  public void test0()  throws Throwable  {
      char[] charArray0 = new char[14];
      CharArraySource charArraySource0 = new CharArraySource(charArray0);
      int int0 = charArraySource0.read(charArray0, 1, (int) '\u0000');
      assertEquals((-1), int0);
      assertEquals(14, charArraySource0.length());
  }
}
