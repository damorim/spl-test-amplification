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
public class TestAbstractTokenizer_26 {


  //Test case number: 26
  /*
   * 35 covered goals:
   * 1 Weak Mutation 554: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1040 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 553: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1040 - DeleteField: _whitespaceHandlerLde/susebox/jtopas/spi/WhitespaceHandler;
   * 3 Weak Mutation 558: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1041 - InsertUnaryOp Negation
   * 4 Weak Mutation 559: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1041 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 556: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1041 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 557: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1041 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 555: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1041 - InsertUnaryOp Negation
   * 8 Weak Mutation 561: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1041 - DeleteStatement: getBaseDataProvider(II)Lde/susebox/jtopas/spi/DataProvider;
   * 9 Weak Mutation 560: de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I:1041 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 944: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - ReplaceArithmeticOperator + -> /
   * 11 Weak Mutation 945: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - ReplaceArithmeticOperator + -> *
   * 12 Weak Mutation 941: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - ReplaceConstant - 1 -> 0
   * 13 Weak Mutation 943: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - ReplaceArithmeticOperator + -> %
   * 14 Weak Mutation 942: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - ReplaceArithmeticOperator + -> -
   * 15 Weak Mutation 937: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - InsertUnaryOp Negation
   * 16 Weak Mutation 939: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - InsertUnaryOp -1
   * 17 Weak Mutation 938: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1413 - InsertUnaryOp +1
   * 18 Weak Mutation 956: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - ReplaceArithmeticOperator - -> *
   * 19 Weak Mutation 952: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - InsertUnaryOp IINC -1
   * 20 Weak Mutation 953: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - ReplaceArithmeticOperator - -> +
   * 21 Weak Mutation 954: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - ReplaceArithmeticOperator - -> %
   * 22 Weak Mutation 955: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - ReplaceArithmeticOperator - -> /
   * 23 Weak Mutation 948: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - InsertUnaryOp -1
   * 24 Weak Mutation 950: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - InsertUnaryOp Negation
   * 25 Weak Mutation 951: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - InsertUnaryOp IINC 1
   * 26 Weak Mutation 946: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - InsertUnaryOp Negation
   * 27 Weak Mutation 947: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1414 - InsertUnaryOp +1
   * 28 Weak Mutation 957: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1415 - InsertUnaryOp Negation
   * 29 Weak Mutation 958: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1415 - InsertUnaryOp IINC 1
   * 30 Weak Mutation 959: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1415 - InsertUnaryOp IINC -1
   * 31 Weak Mutation 963: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1415 - DeleteStatement: readWhitespaces(II)I
   * 32 Weak Mutation 962: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1415 - InsertUnaryOp IINC -1
   * 33 Weak Mutation 961: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1415 - InsertUnaryOp IINC 1
   * 34 Weak Mutation 960: de.susebox.jtopas.AbstractTokenizer.completeWhitespace()I:1415 - InsertUnaryOp Negation
   * 35 de.susebox.jtopas.AbstractTokenizer.readWhitespaces(II)I: I4 Branch 76 IFNULL L1040 - false
   */
  @Test
  public void test26()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      // Undeclared exception!
      try {
        standardTokenizer0.completeWhitespace();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
