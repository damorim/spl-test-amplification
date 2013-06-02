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
public class TestStandardTokenizerProperties_21 {


  //Test case number: 21
  /*
   * 27 covered goals:
   * 1 Weak Mutation 375: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:668 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 2 Weak Mutation 377: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:668 - DeleteStatement: getSequenceMaxLength()I
   * 3 Weak Mutation 376: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:668 - ReplaceConstant - 0 -> 1
   * 4 de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I: I17 Branch 71 IFNULL L667 - false
   * 5 Weak Mutation 373: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:667 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 372: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:667 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 7 Weak Mutation 375: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:668 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 8 Weak Mutation 374: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:667 - ReplaceComparisonOperator = null -> != null
   * 9 Weak Mutation 371: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:666 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 10 Weak Mutation 370: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:664 - ReplaceConstant - 0 -> 1
   * 11 Weak Mutation 380: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceComparisonOperator = null -> != null
   * 12 Weak Mutation 377: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:668 - DeleteStatement: getSequenceMaxLength()I
   * 13 Weak Mutation 376: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:668 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 379: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceConstant - 1 -> 0
   * 15 Weak Mutation 378: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 16 Weak Mutation 395: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:674 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 394: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:674 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 393: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:674 - InsertUnaryOp Negation
   * 19 Weak Mutation 519: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:850 - ReplaceConstant - 0 -> 1
   * 20 Weak Mutation 533: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:857 - InsertUnaryOp Negation
   * 21 Weak Mutation 532: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:857 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 22 Weak Mutation 535: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:857 - InsertUnaryOp IINC -1
   * 23 Weak Mutation 534: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:857 - InsertUnaryOp IINC 1
   * 24 Weak Mutation 536: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:857 - ReplaceConstant - 0 -> 1
   * 25 de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I10 Branch 89 IFEQ L850 - true
   * 26 de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I27 Branch 91 IFEQ L854 - true
   * 27 de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I: I32 Branch 72 IFNULL L670 - true
   */
  @Test
  public void test21()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-1));
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addBlockComment("]|0[R6omW=ETLoF;{<N", "]|0[R6omW=ETLoF;{<N");
      int int0 = standardTokenizerProperties0.getSequenceMaxLength();
      assertEquals(true, standardTokenizerProperties0.hasSequenceCommentOrString());
      assertEquals(19, int0);
  }
}