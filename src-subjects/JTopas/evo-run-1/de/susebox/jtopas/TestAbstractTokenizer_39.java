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
public class TestAbstractTokenizer_39 {


  //Test case number: 39
  /*
   * 46 covered goals:
   * 1 Weak Mutation 1270: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp -1
   * 2 Weak Mutation 1268: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp Negation
   * 3 Weak Mutation 1269: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp +1
   * 4 Weak Mutation 1278: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> *
   * 5 Weak Mutation 1279: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp Negation
   * 6 Weak Mutation 1276: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> %
   * 7 Weak Mutation 1277: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> /
   * 8 Weak Mutation 1274: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp IINC -1
   * 9 Weak Mutation 1275: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> -
   * 10 Weak Mutation 1272: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp Negation
   * 11 Weak Mutation 1273: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 1283: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceComparisonOperator < -> !=
   * 13 Weak Mutation 1280: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp +1
   * 14 Weak Mutation 1281: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp -1
   * 15 Weak Mutation 1286: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - DeleteStatement: readMoreDataFromBase()I
   * 16 Weak Mutation 1287: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceComparisonOperator <= -> ==
   * 17 Weak Mutation 1352: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1587 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 1350: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1587 - InsertUnaryOp Negation
   * 19 Weak Mutation 1351: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1587 - InsertUnaryOp IINC 1
   * 20 de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I: I20 Branch 183 IF_ICMPLT L1570 - false
   * 21 de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I: I23 Branch 184 IFLE L1570 - true
   * 22 Weak Mutation 1266: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1568 - ReplaceConstant - 0 -> 1
   * 23 Weak Mutation 1267: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1568 - DeleteStatement: length()I
   * 24 Weak Mutation 1265: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1567 - DeleteStatement: getImages()[Ljava/lang/String;
   * 25 Weak Mutation 1270: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp -1
   * 26 Weak Mutation 1268: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp Negation
   * 27 Weak Mutation 1269: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp +1
   * 28 Weak Mutation 1266: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1568 - ReplaceConstant - 0 -> 1
   * 29 Weak Mutation 1267: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1568 - DeleteStatement: length()I
   * 30 Weak Mutation 1265: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1567 - DeleteStatement: getImages()[Ljava/lang/String;
   * 31 Weak Mutation 1278: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> *
   * 32 Weak Mutation 1279: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp Negation
   * 33 Weak Mutation 1276: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> %
   * 34 Weak Mutation 1277: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> /
   * 35 Weak Mutation 1274: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp IINC -1
   * 36 Weak Mutation 1275: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceArithmeticOperator + -> -
   * 37 Weak Mutation 1272: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp Negation
   * 38 Weak Mutation 1273: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp IINC 1
   * 39 Weak Mutation 1352: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1587 - InsertUnaryOp IINC -1
   * 40 Weak Mutation 1350: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1587 - InsertUnaryOp Negation
   * 41 Weak Mutation 1351: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1587 - InsertUnaryOp IINC 1
   * 42 Weak Mutation 1283: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceComparisonOperator < -> !=
   * 43 Weak Mutation 1280: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp +1
   * 44 Weak Mutation 1281: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - InsertUnaryOp -1
   * 45 Weak Mutation 1286: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - DeleteStatement: readMoreDataFromBase()I
   * 46 Weak Mutation 1287: de.susebox.jtopas.AbstractTokenizer.completeLineComment(Lde/susebox/jtopas/TokenizerProperty;)I:1570 - ReplaceComparisonOperator <= -> ==
   */
  @Test
  public void test39()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      String[] stringArray0 = new String[9];
      stringArray0[0] = "EWkPq~#g";
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(0, stringArray0);
      int int0 = standardTokenizer0.completeLineComment(tokenizerProperty0);
      assertEquals(false, standardTokenizer0.hasMoreToken());
      assertEquals(8, int0);
  }
}