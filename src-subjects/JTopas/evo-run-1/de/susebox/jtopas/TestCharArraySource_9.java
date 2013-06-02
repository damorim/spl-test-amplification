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
public class TestCharArraySource_9 {


  //Test case number: 9
  /*
   * 26 covered goals:
   * 1 Weak Mutation 100: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - DeleteField: _offsetI
   * 2 de.susebox.jtopas.CharArraySource.<init>([CII)V: I32 Branch 2 IFNULL L82 - true
   * 3 Weak Mutation 14: de.susebox.jtopas.CharArraySource.<init>([CII)V:82 - ReplaceComparisonOperator >= -> -1
   * 4 Weak Mutation 15: de.susebox.jtopas.CharArraySource.<init>([CII)V:84 - ReplaceConstant - -1 -> 0
   * 5 Weak Mutation 17: de.susebox.jtopas.CharArraySource.<init>([CII)V:84 - ReplaceConstant - -1 -> -2
   * 6 Weak Mutation 16: de.susebox.jtopas.CharArraySource.<init>([CII)V:84 - ReplaceConstant - -1 -> 1
   * 7 Weak Mutation 102: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 103: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp IINC -1
   * 9 Weak Mutation 101: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp Negation
   * 10 Weak Mutation 98: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp +1
   * 11 Weak Mutation 99: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp -1
   * 12 Weak Mutation 97: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp Negation
   * 13 Weak Mutation 110: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 111: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp Negation
   * 15 Weak Mutation 108: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp Negation
   * 16 Weak Mutation 109: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 106: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - ReplaceArithmeticOperator + -> /
   * 18 Weak Mutation 107: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - ReplaceArithmeticOperator + -> *
   * 19 Weak Mutation 104: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - ReplaceArithmeticOperator + -> -
   * 20 Weak Mutation 105: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - ReplaceArithmeticOperator + -> %
   * 21 Weak Mutation 117: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - ReplaceArithmeticOperator - -> *
   * 22 Weak Mutation 116: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - ReplaceArithmeticOperator - -> /
   * 23 Weak Mutation 114: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - ReplaceArithmeticOperator - -> +
   * 24 Weak Mutation 113: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 112: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - InsertUnaryOp IINC 1
   * 26 Weak Mutation 100: de.susebox.jtopas.CharArraySource.subSequence(II)Ljava/lang/CharSequence;:153 - DeleteField: _offsetI
   */
  @Test
  public void test9()  throws Throwable  {
      char[] charArray0 = new char[8];
      CharArraySource charArraySource0 = new CharArraySource(charArray0, (int) '3', (-234));
      CharArraySource charArraySource1 = (CharArraySource)charArraySource0.subSequence((int) '3', (int) '3');
      assertEquals(-1, charArraySource1.length());
  }
}
