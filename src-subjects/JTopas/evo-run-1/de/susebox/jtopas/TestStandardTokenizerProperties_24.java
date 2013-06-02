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
public class TestStandardTokenizerProperties_24 {


  //Test case number: 24
  /*
   * 19 covered goals:
   * 1 Weak Mutation 405: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:705 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 2 Weak Mutation 408: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:708 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 406: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:708 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 4 Weak Mutation 407: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:708 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 414: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 415: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - ReplaceComparisonOperator = null -> != null
   * 7 Weak Mutation 412: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - ReplaceComparisonOperator != null -> = null
   * 8 Weak Mutation 413: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 9 de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;: I13 Branch 76 IFNULL L708 - true
   * 10 de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;: I31 Branch 77 IFNONNULL L713 - false
   * 11 de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;: I36 Branch 78 IFNULL L713 - true
   * 12 Weak Mutation 408: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:708 - ReplaceComparisonOperator = null -> != null
   * 13 Weak Mutation 414: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - ReplaceConstant - 1 -> 0
   * 14 Weak Mutation 415: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - ReplaceComparisonOperator = null -> != null
   * 15 Weak Mutation 412: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - ReplaceComparisonOperator != null -> = null
   * 16 Weak Mutation 413: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:713 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 17 Weak Mutation 406: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:708 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 18 Weak Mutation 407: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:708 - ReplaceConstant - 0 -> 1
   * 19 Weak Mutation 405: de.susebox.jtopas.StandardTokenizerProperties.isKeyword(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:705 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   */
  @Test
  public void test24()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(1383);
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.isKeyword((DataProvider) null);
      assertEquals(true, standardTokenizerProperties0.newlineIsWhitespace());
      assertEquals(1382, standardTokenizerProperties0.getParseFlags());
  }
}
