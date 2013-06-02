/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.java.lang.ExtIllegalArgumentException;
import de.susebox.java.lang.ExtUnsupportedOperationException;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.spi.DataProvider;

@RunWith(EvoSuiteRunner.class)
public class TestStandardTokenizerProperties_17 {


  //Test case number: 17
  /*
   * 15 covered goals:
   * 1 Weak Mutation 316: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceComparisonOperator == -> -2
   * 2 Weak Mutation 318: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceConstant - 0 -> 1
   * 3 de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z: I8 Branch 61 IFEQ L585 - true
   * 4 Weak Mutation 305: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - InsertUnaryOp Negation
   * 5 Weak Mutation 304: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - DeleteField: _charFlags[I
   * 6 Weak Mutation 307: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 306: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 309: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceConstant - 2 -> 1
   * 9 Weak Mutation 308: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceConstant - 2 -> 0
   * 10 Weak Mutation 311: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceConstant - 2 -> 3
   * 11 Weak Mutation 310: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceConstant - 2 -> -1
   * 12 Weak Mutation 313: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceBitwiseOperator & -> ^
   * 13 Weak Mutation 312: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceBitwiseOperator & -> |
   * 14 Weak Mutation 316: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceComparisonOperator == -> -2
   * 15 Weak Mutation 318: de.susebox.jtopas.StandardTokenizerProperties.isSeparator(C)Z:585 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test17()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      assertNotNull(standardTokenizerProperties0);
      
      boolean boolean0 = standardTokenizerProperties0.isSeparator('S');
      assertEquals(false, boolean0);
      assertEquals(0, standardTokenizerProperties0.getParseFlags());
      assertEquals(true, standardTokenizerProperties0.newlineIsWhitespace());
  }
}