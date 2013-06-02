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
public class TestStringSource_3 {


  //Test case number: 3
  /*
   * 11 covered goals:
   * 1 Weak Mutation 68: de.susebox.jtopas.StringSource.charAt(I)C:110 - DeleteStatement: charAt(I)C
   * 2 Weak Mutation 64: de.susebox.jtopas.StringSource.charAt(I)C:110 - DeleteField: _dataLjava/lang/String;
   * 3 Weak Mutation 65: de.susebox.jtopas.StringSource.charAt(I)C:110 - InsertUnaryOp Negation
   * 4 Weak Mutation 66: de.susebox.jtopas.StringSource.charAt(I)C:110 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 67: de.susebox.jtopas.StringSource.charAt(I)C:110 - InsertUnaryOp IINC -1
   * 6 de.susebox.jtopas.StringSource.charAt(I)C: root-Branch
   * 7 Weak Mutation 68: de.susebox.jtopas.StringSource.charAt(I)C:110 - DeleteStatement: charAt(I)C
   * 8 Weak Mutation 64: de.susebox.jtopas.StringSource.charAt(I)C:110 - DeleteField: _dataLjava/lang/String;
   * 9 Weak Mutation 65: de.susebox.jtopas.StringSource.charAt(I)C:110 - InsertUnaryOp Negation
   * 10 Weak Mutation 66: de.susebox.jtopas.StringSource.charAt(I)C:110 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 67: de.susebox.jtopas.StringSource.charAt(I)C:110 - InsertUnaryOp IINC -1
   */
  @Test
  public void test3()  throws Throwable  {
      StringSource stringSource0 = new StringSource("8'ds$M?j#:L");
      char char0 = stringSource0.charAt(0);
      assertEquals('8', char0);
  }
}
