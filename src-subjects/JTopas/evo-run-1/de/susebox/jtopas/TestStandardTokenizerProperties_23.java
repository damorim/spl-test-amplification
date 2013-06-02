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
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.spi.DataProvider;

@RunWith(EvoSuiteRunner.class)
public class TestStandardTokenizerProperties_23 {


  //Test case number: 23
  /*
   * 18 covered goals:
   * 1 Weak Mutation 396: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:687 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 2 Weak Mutation 402: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 400: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 4 Weak Mutation 401: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 404: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 399: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceComparisonOperator != null -> = null
   * 7 Weak Mutation 398: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 397: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 9 de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z: I13 Branch 74 IFNONNULL L688 - false
   * 10 de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z: I18 Branch 75 IFNULL L688 - true
   * 11 Weak Mutation 402: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceComparisonOperator = null -> != null
   * 12 Weak Mutation 400: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 13 Weak Mutation 401: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceConstant - 1 -> 0
   * 14 Weak Mutation 404: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 399: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceComparisonOperator != null -> = null
   * 16 Weak Mutation 398: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - ReplaceConstant - 0 -> 1
   * 17 Weak Mutation 397: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:688 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 18 Weak Mutation 396: de.susebox.jtopas.StandardTokenizerProperties.hasKeywords()Z:687 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   */
  @Test
  public void test23()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-1775));
      assertNotNull(standardTokenizerProperties0);
      
      boolean boolean0 = standardTokenizerProperties0.hasKeywords();
      assertEquals(false, boolean0);
      assertEquals(true, standardTokenizerProperties0.newlineIsWhitespace());
      assertEquals(-1775, standardTokenizerProperties0.getParseFlags());
  }
}
