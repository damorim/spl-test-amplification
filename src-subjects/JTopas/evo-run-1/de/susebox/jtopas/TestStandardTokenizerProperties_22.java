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
public class TestStandardTokenizerProperties_22 {


  //Test case number: 22
  /*
   * 34 covered goals:
   * 1 Weak Mutation 381: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 2 Weak Mutation 383: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - DeleteStatement: getSequenceMaxLength()I
   * 3 Weak Mutation 382: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceConstant - 1 -> 0
   * 4 Weak Mutation 386: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 385: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 384: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - InsertUnaryOp Negation
   * 7 Weak Mutation 389: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceComparisonOperator <= -> -1
   * 8 Weak Mutation 392: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:671 - DeleteStatement: getSequenceMaxLength()I
   * 9 Weak Mutation 391: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:671 - ReplaceConstant - 1 -> 0
   * 10 Weak Mutation 390: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:671 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 11 de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I: I32 Branch 72 IFNULL L670 - false
   * 12 de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I: I39 Branch 73 IF_ICMPLE L670 - false
   * 13 Weak Mutation 373: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:667 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 372: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:667 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 15 Weak Mutation 374: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:667 - ReplaceComparisonOperator = null -> != null
   * 16 Weak Mutation 371: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:666 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 17 Weak Mutation 370: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:664 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 380: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceComparisonOperator = null -> != null
   * 19 Weak Mutation 379: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceConstant - 1 -> 0
   * 20 Weak Mutation 378: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 21 Weak Mutation 395: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:674 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 394: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:674 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 393: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:674 - InsertUnaryOp Negation
   * 24 Weak Mutation 381: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 25 Weak Mutation 383: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - DeleteStatement: getSequenceMaxLength()I
   * 26 Weak Mutation 382: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceConstant - 1 -> 0
   * 27 Weak Mutation 392: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:671 - DeleteStatement: getSequenceMaxLength()I
   * 28 Weak Mutation 386: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - InsertUnaryOp IINC -1
   * 29 Weak Mutation 385: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - InsertUnaryOp IINC 1
   * 30 Weak Mutation 384: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - InsertUnaryOp Negation
   * 31 Weak Mutation 391: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:671 - ReplaceConstant - 1 -> 0
   * 32 Weak Mutation 390: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:671 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 33 Weak Mutation 389: de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I:670 - ReplaceComparisonOperator <= -> -1
   * 34 de.susebox.jtopas.StandardTokenizerProperties.getSequenceMaxLength()I: I17 Branch 71 IFNULL L667 - true
   */
  @Test
  public void test22()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-171), " NOR;MAL, ", " NOR;MAL, ");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addBlockComment("]|0[R6omW=ETLoF;{<N", "]|0[R6omW=ETLoF;{<N");
      int int0 = standardTokenizerProperties0.getSequenceMaxLength();
      assertEquals(true, standardTokenizerProperties0.hasSequenceCommentOrString());
      assertEquals(19, int0);
  }
}
