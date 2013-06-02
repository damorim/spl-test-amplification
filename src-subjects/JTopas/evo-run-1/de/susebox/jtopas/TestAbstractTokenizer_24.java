/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.java.lang.ExtIndexOutOfBoundsException;
import de.susebox.jtopas.AbstractTokenizer;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerSource;
import de.susebox.jtopas.spi.KeywordHandler;
import de.susebox.jtopas.spi.PatternHandler;
import de.susebox.jtopas.spi.SequenceHandler;
import java.io.PipedReader;
import java.io.Reader;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizer_24 {


  //Test case number: 24
  /*
   * 42 covered goals:
   * 1 Weak Mutation 521: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:984 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 524: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:986 - ReplaceComparisonOperator == -> !=
   * 3 Weak Mutation 522: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:986 - DeleteField: _baseTokenizerLde/susebox/jtopas/AbstractTokenizer;
   * 4 Weak Mutation 523: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:986 - DeleteField: _baseTokenizerLde/susebox/jtopas/AbstractTokenizer;
   * 5 Weak Mutation 526: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:989 - InsertUnaryOp Negation
   * 6 Weak Mutation 527: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:989 - DeleteField: _eofReachedZ
   * 7 Weak Mutation 529: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:990 - InsertUnaryOp +1
   * 8 Weak Mutation 528: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:990 - InsertUnaryOp Negation
   * 9 Weak Mutation 530: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:990 - InsertUnaryOp -1
   * 10 Weak Mutation 533: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:991 - InsertUnaryOp +1
   * 11 Weak Mutation 532: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:991 - InsertUnaryOp Negation
   * 12 Weak Mutation 534: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:991 - InsertUnaryOp -1
   * 13 Weak Mutation 537: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - InsertUnaryOp +1
   * 14 Weak Mutation 536: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - InsertUnaryOp Negation
   * 15 Weak Mutation 539: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - DeleteField: _columnNumberI
   * 16 Weak Mutation 538: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - InsertUnaryOp -1
   * 17 Weak Mutation 541: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - InsertUnaryOp +1
   * 18 Weak Mutation 540: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - InsertUnaryOp Negation
   * 19 Weak Mutation 543: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - DeleteField: _lineNumberI
   * 20 Weak Mutation 542: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - InsertUnaryOp -1
   * 21 de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V: I3 Branch 73 IFNULL L984 - false
   * 22 de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V: I16 Branch 74 IF_ACMPEQ L986 - true
   * 23 Weak Mutation 524: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:986 - ReplaceComparisonOperator == -> !=
   * 24 Weak Mutation 526: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:989 - InsertUnaryOp Negation
   * 25 Weak Mutation 527: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:989 - DeleteField: _eofReachedZ
   * 26 Weak Mutation 521: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:984 - ReplaceComparisonOperator = null -> != null
   * 27 Weak Mutation 522: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:986 - DeleteField: _baseTokenizerLde/susebox/jtopas/AbstractTokenizer;
   * 28 Weak Mutation 523: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:986 - DeleteField: _baseTokenizerLde/susebox/jtopas/AbstractTokenizer;
   * 29 Weak Mutation 533: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:991 - InsertUnaryOp +1
   * 30 Weak Mutation 532: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:991 - InsertUnaryOp Negation
   * 31 Weak Mutation 534: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:991 - InsertUnaryOp -1
   * 32 Weak Mutation 529: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:990 - InsertUnaryOp +1
   * 33 Weak Mutation 528: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:990 - InsertUnaryOp Negation
   * 34 Weak Mutation 530: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:990 - InsertUnaryOp -1
   * 35 Weak Mutation 541: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - InsertUnaryOp +1
   * 36 Weak Mutation 540: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - InsertUnaryOp Negation
   * 37 Weak Mutation 543: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - DeleteField: _lineNumberI
   * 38 Weak Mutation 542: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:993 - InsertUnaryOp -1
   * 39 Weak Mutation 537: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - InsertUnaryOp +1
   * 40 Weak Mutation 536: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - InsertUnaryOp Negation
   * 41 Weak Mutation 539: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - DeleteField: _columnNumberI
   * 42 Weak Mutation 538: de.susebox.jtopas.AbstractTokenizer.switchTo(Lde/susebox/jtopas/AbstractTokenizer;)V:992 - InsertUnaryOp -1
   */
  @Test
  public void test24()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      StandardTokenizer standardTokenizer0 = new StandardTokenizer((TokenizerProperties) standardTokenizerProperties0);
      assertNotNull(standardTokenizer0);
      
      standardTokenizer0.switchTo((AbstractTokenizer) standardTokenizer0);
      assertEquals(false, standardTokenizer0.hasMoreToken());
      assertEquals(-1, standardTokenizer0.getLineNumber());
  }
}
