/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StringSource;

@RunWith(EvoSuiteRunner.class)
public class TestStringSource_2 {


  //Test case number: 2
  /*
   * 24 covered goals:
   * 1 Weak Mutation 24: de.susebox.jtopas.StringSource.read([CII)I:90 - ReplaceComparisonOperator <= -> ==
   * 2 Weak Mutation 1: de.susebox.jtopas.StringSource.read([CII)I:87 - DeleteField: _dataLjava/lang/String;
   * 3 Weak Mutation 2: de.susebox.jtopas.StringSource.read([CII)I:87 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 3: de.susebox.jtopas.StringSource.read([CII)I:87 - DeleteField: _dataLjava/lang/String;
   * 5 Weak Mutation 4: de.susebox.jtopas.StringSource.read([CII)I:87 - DeleteStatement: length()I
   * 6 Weak Mutation 6: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp Negation
   * 7 Weak Mutation 7: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 8: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp IINC -1
   * 9 Weak Mutation 9: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp Negation
   * 10 Weak Mutation 10: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp +1
   * 11 Weak Mutation 11: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp -1
   * 12 Weak Mutation 14: de.susebox.jtopas.StringSource.read([CII)I:88 - ReplaceArithmeticOperator - -> %
   * 13 Weak Mutation 15: de.susebox.jtopas.StringSource.read([CII)I:88 - ReplaceArithmeticOperator - -> /
   * 14 Weak Mutation 17: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp Negation
   * 15 Weak Mutation 19: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 18: de.susebox.jtopas.StringSource.read([CII)I:88 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 21: de.susebox.jtopas.StringSource.read([CII)I:90 - InsertUnaryOp Negation
   * 18 Weak Mutation 20: de.susebox.jtopas.StringSource.read([CII)I:88 - DeleteStatement: min(II)I
   * 19 Weak Mutation 23: de.susebox.jtopas.StringSource.read([CII)I:90 - InsertUnaryOp IINC -1
   * 20 Weak Mutation 22: de.susebox.jtopas.StringSource.read([CII)I:90 - InsertUnaryOp IINC 1
   * 21 Weak Mutation 63: de.susebox.jtopas.StringSource.read([CII)I:95 - ReplaceConstant - -1 -> -2
   * 22 Weak Mutation 62: de.susebox.jtopas.StringSource.read([CII)I:95 - ReplaceConstant - -1 -> 1
   * 23 Weak Mutation 61: de.susebox.jtopas.StringSource.read([CII)I:95 - ReplaceConstant - -1 -> 0
   * 24 Weak Mutation 24: de.susebox.jtopas.StringSource.read([CII)I:90 - ReplaceComparisonOperator <= -> ==
   */
  @Test
  public void test2()  throws Throwable  {
      StringSource stringSource0 = new StringSource("8'ds$M?j#:L");
      char[] charArray0 = new char[16];
      int int0 = stringSource0.read(charArray0, (-1780), (-1780));
      assertEquals((-1), int0);
  }
}