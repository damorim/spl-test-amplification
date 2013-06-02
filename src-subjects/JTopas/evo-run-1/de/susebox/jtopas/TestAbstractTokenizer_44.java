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
public class TestAbstractTokenizer_44 {


  //Test case number: 44
  /*
   * 44 covered goals:
   * 1 de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V: I36 Branch 20 IFEQ L401 - false
   * 2 de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V: I25 Branch 132 TABLESWITCH L1225 Case 7 - true
   * 3 Weak Mutation 58: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:206 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 4 Weak Mutation 61: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:207 - DeleteStatement: removeTokenizerPropertyListener(Lde/susebox/jtopas/TokenizerPropertyListener;)V
   * 5 Weak Mutation 60: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:207 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 6 Weak Mutation 751: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1218 - DeleteStatement: getProperty()Lde/susebox/jtopas/TokenizerProperty;
   * 7 Weak Mutation 762: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceBitwiseOperator & -> |
   * 8 Weak Mutation 763: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceBitwiseOperator & -> ^
   * 9 Weak Mutation 760: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 3
   * 10 Weak Mutation 761: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 5
   * 11 Weak Mutation 766: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - DeleteStatement: longSub(JJ)I
   * 12 Weak Mutation 764: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 0 -> 1
   * 13 Weak Mutation 765: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 0 -> -1
   * 14 Weak Mutation 754: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1225 - DeleteStatement: getType()I
   * 15 Weak Mutation 755: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - InsertUnaryOp Negation
   * 16 Weak Mutation 752: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1219 - DeleteStatement: getImages()[Ljava/lang/String;
   * 17 Weak Mutation 753: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1222 - DeleteStatement: getType()I
   * 18 Weak Mutation 758: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 1
   * 19 Weak Mutation 759: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> -1
   * 20 Weak Mutation 757: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 0
   * 21 Weak Mutation 772: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1232 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 22 Weak Mutation 773: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1232 - DeleteStatement: setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V
   * 23 Weak Mutation 770: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 24 Weak Mutation 771: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceComparisonOperator == -> !=
   * 25 Weak Mutation 769: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceComparisonOperator != -> -1
   * 26 Weak Mutation 762: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceBitwiseOperator & -> |
   * 27 Weak Mutation 763: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceBitwiseOperator & -> ^
   * 28 Weak Mutation 760: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 3
   * 29 Weak Mutation 761: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 5
   * 30 Weak Mutation 766: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - DeleteStatement: longSub(JJ)I
   * 31 Weak Mutation 764: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 0 -> 1
   * 32 Weak Mutation 765: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 0 -> -1
   * 33 Weak Mutation 755: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - InsertUnaryOp Negation
   * 34 Weak Mutation 758: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 1
   * 35 Weak Mutation 759: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> -1
   * 36 Weak Mutation 757: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceConstant - 4 -> 0
   * 37 Weak Mutation 772: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1232 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 38 Weak Mutation 773: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1232 - DeleteStatement: setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V
   * 39 Weak Mutation 770: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 40 Weak Mutation 771: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceComparisonOperator == -> !=
   * 41 Weak Mutation 769: de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V:1230 - ReplaceComparisonOperator != -> -1
   * 42 de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V: I25 Branch 126 TABLESWITCH L1225 Case 1 - false
   * 43 de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V: I34 Branch 135 IFNE L1230 - false
   * 44 de.susebox.jtopas.AbstractTokenizer.propertyChanged(Lde/susebox/jtopas/TokenizerPropertyEvent;)V: I38 Branch 136 IFEQ L1230 - false
   */
  @Test
  public void test44()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      StandardTokenizer standardTokenizer0 = new StandardTokenizer((TokenizerProperties) standardTokenizerProperties0);
      standardTokenizerProperties0.addLineComment("j");
      assertEquals(0, standardTokenizerProperties0.getParseFlags());
  }
}
