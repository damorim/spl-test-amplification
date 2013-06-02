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
public class TestStandardTokenizerProperties_20 {


  //Test case number: 20
  /*
   * 19 covered goals:
   * 1 Weak Mutation 346: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:634 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 2 Weak Mutation 349: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:635 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 348: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:635 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 347: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:635 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 5 Weak Mutation 353: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:638 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 6 Weak Mutation 354: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:638 - ReplaceConstant - 1 -> 0
   * 7 Weak Mutation 355: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:638 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 359: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:641 - ReplaceComparisonOperator != null -> = null
   * 9 de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;: I13 Branch 66 IFNULL L635 - true
   * 10 de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;: I31 Branch 67 IFNULL L638 - true
   * 11 de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;: I46 Branch 68 IFNONNULL L641 - false
   * 12 Weak Mutation 349: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:635 - ReplaceComparisonOperator = null -> != null
   * 13 Weak Mutation 348: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:635 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 347: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:635 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 15 Weak Mutation 346: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:634 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 16 Weak Mutation 359: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:641 - ReplaceComparisonOperator != null -> = null
   * 17 Weak Mutation 353: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:638 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 18 Weak Mutation 354: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:638 - ReplaceConstant - 1 -> 0
   * 19 Weak Mutation 355: de.susebox.jtopas.StandardTokenizerProperties.startsWithSequenceCommentOrString(Lde/susebox/jtopas/spi/DataProvider;)Lde/susebox/jtopas/TokenizerProperty;:638 - ReplaceComparisonOperator = null -> != null
   */
  @Test
  public void test20()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-171), " NORMAL, ", " NORMAL, ");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.startsWithSequenceCommentOrString((DataProvider) null);
      assertEquals(-171, standardTokenizerProperties0.getParseFlags());
  }
}