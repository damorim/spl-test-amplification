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
public class TestAbstractTokenizer_25 {


  //Test case number: 25
  /*
   * 15 covered goals:
   * 1 Weak Mutation 546: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1016 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 545: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1016 - DeleteField: _whitespaceHandlerLde/susebox/jtopas/spi/WhitespaceHandler;
   * 3 Weak Mutation 550: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 551: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - DeleteStatement: isWhitespace(C)Z
   * 5 Weak Mutation 548: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - InsertUnaryOp Negation
   * 6 Weak Mutation 549: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 547: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - DeleteField: _whitespaceHandlerLde/susebox/jtopas/spi/WhitespaceHandler;
   * 8 de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z: I4 Branch 75 IFNULL L1016 - false
   * 9 Weak Mutation 550: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 551: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - DeleteStatement: isWhitespace(C)Z
   * 11 Weak Mutation 548: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - InsertUnaryOp Negation
   * 12 Weak Mutation 549: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 546: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1016 - ReplaceComparisonOperator = null -> != null
   * 14 Weak Mutation 547: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1017 - DeleteField: _whitespaceHandlerLde/susebox/jtopas/spi/WhitespaceHandler;
   * 15 Weak Mutation 545: de.susebox.jtopas.AbstractTokenizer.isWhitespace(C)Z:1016 - DeleteField: _whitespaceHandlerLde/susebox/jtopas/spi/WhitespaceHandler;
   */
  @Test
  public void test25()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      standardTokenizer0.isWhitespace('#');
      assertEquals(false, standardTokenizer0.hasMoreToken());
      assertEquals(-1, standardTokenizer0.getColumnNumber());
  }
}
