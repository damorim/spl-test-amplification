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
public class TestStringSource_6 {


  //Test case number: 6
  /*
   * 18 covered goals:
   * 1 Weak Mutation 76: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC 1
   * 2 Weak Mutation 77: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC -1
   * 3 Weak Mutation 78: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp Negation
   * 4 Weak Mutation 79: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 74: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - DeleteField: _dataLjava/lang/String;
   * 6 Weak Mutation 75: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp Negation
   * 7 Weak Mutation 81: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - DeleteStatement: subSequence(II)Ljava/lang/CharSequence;
   * 8 Weak Mutation 80: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC -1
   * 9 de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;: root-Branch
   * 10 Weak Mutation 0: de.susebox.jtopas.StringSource.<init>(Ljava/lang/String;)V:140 - ReplaceConstant - 0 -> 1
   * 11 Weak Mutation 76: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 77: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 78: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp Negation
   * 14 Weak Mutation 79: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 74: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - DeleteField: _dataLjava/lang/String;
   * 16 Weak Mutation 75: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp Negation
   * 17 Weak Mutation 81: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - DeleteStatement: subSequence(II)Ljava/lang/CharSequence;
   * 18 Weak Mutation 80: de.susebox.jtopas.StringSource.subSequence(II)Ljava/lang/CharSequence;:132 - InsertUnaryOp IINC -1
   */
  @Test
  public void test6()  throws Throwable  {
      StringSource stringSource0 = new StringSource("8'ds$M?j#:L");
      String string0 = (String)stringSource0.subSequence(0, 1);
      assertEquals("8", string0);
      assertNotNull(string0);
  }
}
