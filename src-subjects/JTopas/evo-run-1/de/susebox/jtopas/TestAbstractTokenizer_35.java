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
import de.susebox.jtopas.ReaderSource;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.TokenizerSource;
import de.susebox.jtopas.spi.KeywordHandler;
import de.susebox.jtopas.spi.PatternHandler;
import de.susebox.jtopas.spi.SequenceHandler;
import java.io.PipedReader;
import java.io.Reader;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizer_35 {


  //Test case number: 35
  /*
   * 18 covered goals:
   * 1 Weak Mutation 1039: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - ReplaceComparisonOperator < -> <=
   * 2 Weak Mutation 1020: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1437 - DeleteField: _whitespaceHandlerLde/susebox/jtopas/spi/WhitespaceHandler;
   * 3 Weak Mutation 1021: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1437 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 1022: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp Negation
   * 5 Weak Mutation 1023: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp +1
   * 6 Weak Mutation 1033: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp Negation
   * 7 Weak Mutation 1034: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp +1
   * 8 Weak Mutation 1035: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp -1
   * 9 Weak Mutation 1024: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp -1
   * 10 Weak Mutation 1026: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp Negation
   * 11 Weak Mutation 1027: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 1028: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 1030: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - ReplaceArithmeticOperator + -> %
   * 14 Weak Mutation 1031: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - ReplaceArithmeticOperator + -> /
   * 15 Weak Mutation 1040: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - DeleteStatement: readMoreDataFromBase()I
   * 16 Weak Mutation 1043: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - ReplaceComparisonOperator >= -> -1
   * 17 Weak Mutation 1044: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1439 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 1039: de.susebox.jtopas.AbstractTokenizer.isWhitespace(I)Z:1438 - ReplaceComparisonOperator < -> <=
   */
  @Test
  public void test35()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      StandardTokenizer standardTokenizer0 = new StandardTokenizer((TokenizerProperties) standardTokenizerProperties0);
      assertNotNull(standardTokenizer0);
      
      boolean boolean0 = standardTokenizer0.isWhitespace(0);
      assertEquals(false, standardTokenizer0.hasMoreToken());
      assertEquals(false, boolean0);
  }
}
