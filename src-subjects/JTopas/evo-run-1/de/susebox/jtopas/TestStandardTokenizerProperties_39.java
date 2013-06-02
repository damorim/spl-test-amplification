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
public class TestStandardTokenizerProperties_39 {


  //Test case number: 39
  /*
   * 38 covered goals:
   * 1 de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I23 Branch 87 IFNONNULL L825 - true
   * 2 Weak Mutation 69: de.susebox.jtopas.StandardTokenizerProperties.doSetSeparators(Ljava/lang/String;)Ljava/lang/String;:221 - ReplaceComparisonOperator != -> <
   * 3 Weak Mutation 65: de.susebox.jtopas.StandardTokenizerProperties.doSetSeparators(Ljava/lang/String;)Ljava/lang/String;:221 - DeleteField: _flagsI
   * 4 Weak Mutation 79: de.susebox.jtopas.StandardTokenizerProperties.doSetSeparators(Ljava/lang/String;)Ljava/lang/String;:226 - DeleteField: _separatorsNoCaseLjava/lang/String;
   * 5 Weak Mutation 85: de.susebox.jtopas.StandardTokenizerProperties.doSetSeparators(Ljava/lang/String;)Ljava/lang/String;:226 - DeleteField: _separatorsCaseLjava/lang/String;
   * 6 Weak Mutation 80: de.susebox.jtopas.StandardTokenizerProperties.doSetSeparators(Ljava/lang/String;)Ljava/lang/String;:226 - DeleteStatement: length()I
   * 7 Weak Mutation 82: de.susebox.jtopas.StandardTokenizerProperties.doSetSeparators(Ljava/lang/String;)Ljava/lang/String;:226 - ReplaceComparisonOperator <= -> <
   * 8 Weak Mutation 110: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:254 - ReplaceComparisonOperator != -> <
   * 9 Weak Mutation 106: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:254 - DeleteField: _flagsI
   * 10 Weak Mutation 126: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:259 - DeleteField: _whitespacesCaseLjava/lang/String;
   * 11 Weak Mutation 123: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:259 - ReplaceComparisonOperator <= -> <
   * 12 Weak Mutation 121: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:259 - DeleteStatement: length()I
   * 13 Weak Mutation 120: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:259 - DeleteField: _whitespacesNoCaseLjava/lang/String;
   * 14 Weak Mutation 146: de.susebox.jtopas.StandardTokenizerProperties.doAddProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:292 - DeleteStatement: addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;
   * 15 Weak Mutation 508: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:834 - InsertUnaryOp Negation
   * 16 Weak Mutation 509: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:834 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 510: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:834 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 511: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:834 - DeleteStatement: addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;
   * 19 Weak Mutation 507: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:834 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 20 Weak Mutation 500: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:827 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 501: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:827 - ReplaceConstant - 1 -> 0
   * 22 Weak Mutation 496: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:826 - ReplaceComparisonOperator == -> !=
   * 23 Weak Mutation 497: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:827 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 24 Weak Mutation 498: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:827 - InsertUnaryOp Negation
   * 25 Weak Mutation 499: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:827 - InsertUnaryOp IINC 1
   * 26 Weak Mutation 493: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:825 - InsertUnaryOp IINC -1
   * 27 Weak Mutation 492: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:825 - InsertUnaryOp IINC 1
   * 28 Weak Mutation 495: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:826 - InsertUnaryOp Negation
   * 29 Weak Mutation 494: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:825 - ReplaceComparisonOperator != null -> = null
   * 30 Weak Mutation 488: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:822 - ReplaceConstant - 1 -> 0
   * 31 Weak Mutation 491: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:825 - InsertUnaryOp Negation
   * 32 Weak Mutation 490: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:825 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 33 Weak Mutation 485: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:822 - InsertUnaryOp IINC 1
   * 34 Weak Mutation 484: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:822 - InsertUnaryOp Negation
   * 35 Weak Mutation 487: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:822 - ReplaceComparisonOperator == -> !=
   * 36 Weak Mutation 486: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:822 - InsertUnaryOp IINC -1
   * 37 Weak Mutation 483: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:821 - DeleteStatement: isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z
   * 38 Weak Mutation 482: de.susebox.jtopas.StandardTokenizerProperties.addKeyword(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:821 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test39()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-171), " NOR;MAL, ", " NOR;MAL, ");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addKeyword("]|0[R6omW=ETLoF;{<N");
      assertEquals(true, standardTokenizerProperties0.hasKeywords());
      
      String[] stringArray0 = new String[10];
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(1316, stringArray0);
      // Undeclared exception!
      try {
        standardTokenizerProperties0.addKeyword(tokenizerProperty0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
