/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.spi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.spi.StandardWhitespaceHandler;

@RunWith(EvoSuiteRunner.class)
public class TestStandardWhitespaceHandler_5 {


  //Test case number: 5
  /*
   * 17 covered goals:
   * 1 Weak Mutation 26: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - ReplaceComparisonOperator < -> -2
   * 2 Weak Mutation 28: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - ReplaceConstant - 0 -> 1
   * 3 de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z: I37 Branch 5 IFLT L89 - true
   * 4 Weak Mutation 0: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:85 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 5 Weak Mutation 2: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:85 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 6 Weak Mutation 3: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:85 - DeleteStatement: getWhitespaces()Ljava/lang/String;
   * 7 Weak Mutation 4: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:85 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 5: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:86 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 9 Weak Mutation 6: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:86 - ReplaceConstant - 1 -> 0
   * 10 Weak Mutation 7: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:86 - DeleteStatement: isFlagSet(I)Z
   * 11 Weak Mutation 8: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:86 - ReplaceComparisonOperator == -> !=
   * 12 Weak Mutation 21: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 20: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - InsertUnaryOp Negation
   * 14 Weak Mutation 23: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - DeleteStatement: indexOf(I)I
   * 15 Weak Mutation 22: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 26: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - ReplaceComparisonOperator < -> -2
   * 17 Weak Mutation 28: de.susebox.jtopas.spi.StandardWhitespaceHandler.isWhitespace(C)Z:89 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test5()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-185), "Oc/O9", "Oc/O9");
      StandardWhitespaceHandler standardWhitespaceHandler0 = new StandardWhitespaceHandler((TokenizerProperties) standardTokenizerProperties0);
      boolean boolean0 = standardWhitespaceHandler0.isWhitespace('\\');
      assertEquals(false, boolean0);
  }
}
