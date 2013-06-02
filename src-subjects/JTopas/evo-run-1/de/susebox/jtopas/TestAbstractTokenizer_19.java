/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
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
public class TestAbstractTokenizer_19 {


  //Test case number: 19
  /*
   * 51 covered goals:
   * 1 Weak Mutation 440: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - DeleteStatement: getRangeStart()I
   * 2 Weak Mutation 442: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - ReplaceComparisonOperator >= -> >
   * 3 Weak Mutation 437: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - InsertUnaryOp Negation
   * 4 Weak Mutation 438: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 439: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 463: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - ReplaceComparisonOperator <= -> <
   * 7 Weak Mutation 460: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp -1
   * 8 Weak Mutation 459: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp +1
   * 9 Weak Mutation 458: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp Negation
   * 10 Weak Mutation 457: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 456: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 455: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp Negation
   * 13 Weak Mutation 481: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:820 - InsertUnaryOp Negation
   * 14 Weak Mutation 483: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:820 - InsertUnaryOp IINC -1
   * 15 Weak Mutation 482: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:820 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 485: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:821 - DeleteStatement: fill([Ljava/lang/Object;Ljava/lang/Object;)V
   * 17 Weak Mutation 484: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:821 - DeleteField: _scannedToken[Lde/susebox/jtopas/Token;
   * 18 Weak Mutation 492: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - ReplaceArithmeticOperator + -> /
   * 19 Weak Mutation 494: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - DeleteStatement: setReadPositionAbsolute(I)V
   * 20 Weak Mutation 489: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 488: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - InsertUnaryOp IINC 1
   * 22 Weak Mutation 491: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - ReplaceArithmeticOperator + -> %
   * 23 Weak Mutation 487: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - InsertUnaryOp Negation
   * 24 Weak Mutation 486: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - DeleteStatement: getReadPosition()I
   * 25 de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V: root-Branch
   * 26 de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V: I5 Branch 67 IF_ICMPGE L809 - true
   * 27 de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V: I35 Branch 68 IF_ICMPLE L814 - true
   * 28 Weak Mutation 440: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - DeleteStatement: getRangeStart()I
   * 29 Weak Mutation 442: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - ReplaceComparisonOperator >= -> >
   * 30 Weak Mutation 437: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - InsertUnaryOp Negation
   * 31 Weak Mutation 438: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - InsertUnaryOp IINC 1
   * 32 Weak Mutation 439: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:809 - InsertUnaryOp IINC -1
   * 33 Weak Mutation 463: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - ReplaceComparisonOperator <= -> <
   * 34 Weak Mutation 460: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp -1
   * 35 Weak Mutation 459: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp +1
   * 36 Weak Mutation 458: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp Negation
   * 37 Weak Mutation 457: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp IINC -1
   * 38 Weak Mutation 456: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp IINC 1
   * 39 Weak Mutation 455: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:814 - InsertUnaryOp Negation
   * 40 Weak Mutation 492: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - ReplaceArithmeticOperator + -> /
   * 41 Weak Mutation 494: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - DeleteStatement: setReadPositionAbsolute(I)V
   * 42 Weak Mutation 489: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - InsertUnaryOp IINC -1
   * 43 Weak Mutation 488: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - InsertUnaryOp IINC 1
   * 44 Weak Mutation 491: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - ReplaceArithmeticOperator + -> %
   * 45 Weak Mutation 485: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:821 - DeleteStatement: fill([Ljava/lang/Object;Ljava/lang/Object;)V
   * 46 Weak Mutation 484: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:821 - DeleteField: _scannedToken[Lde/susebox/jtopas/Token;
   * 47 Weak Mutation 487: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - InsertUnaryOp Negation
   * 48 Weak Mutation 486: de.susebox.jtopas.AbstractTokenizer.setReadPositionRelative(I)V:857 - DeleteStatement: getReadPosition()I
   * 49 Weak Mutation 481: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:820 - InsertUnaryOp Negation
   * 50 Weak Mutation 483: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:820 - InsertUnaryOp IINC -1
   * 51 Weak Mutation 482: de.susebox.jtopas.AbstractTokenizer.setReadPositionAbsolute(I)V:820 - InsertUnaryOp IINC 1
   */
  @Test
  public void test19()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      standardTokenizer0.setReadPositionRelative(0);
      assertEquals(true, standardTokenizer0.hasMoreToken());
      assertEquals(-1, standardTokenizer0.getColumnNumber());
      assertEquals(0, standardTokenizer0.getReadPosition());
      assertEquals(-1, standardTokenizer0.getCurrentLine());
  }
}