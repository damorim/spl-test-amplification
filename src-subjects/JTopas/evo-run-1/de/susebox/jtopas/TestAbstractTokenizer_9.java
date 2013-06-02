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
public class TestAbstractTokenizer_9 {


  //Test case number: 9
  /*
   * 11 covered goals:
   * 1 Weak Mutation 289: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - InsertUnaryOp Negation
   * 2 Weak Mutation 291: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 292: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceConstant - 1 -> -1
   * 4 Weak Mutation 293: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceConstant - 1 -> 2
   * 5 Weak Mutation 294: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceBitwiseOperator | -> &
   * 6 de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V: I11 Branch 22 IF_ACMPNE L444 - true
   * 7 Weak Mutation 289: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - InsertUnaryOp Negation
   * 8 Weak Mutation 291: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceConstant - 1 -> 0
   * 9 Weak Mutation 292: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceConstant - 1 -> -1
   * 10 Weak Mutation 293: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceConstant - 1 -> 2
   * 11 Weak Mutation 294: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:453 - ReplaceBitwiseOperator | -> &
   */
  @Test
  public void test9()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-548));
      standardTokenizer0.setPatternHandler((PatternHandler) standardTokenizerProperties0);
      assertEquals(false, standardTokenizer0.hasMoreToken());
      assertEquals(-1, standardTokenizer0.getLineNumber());
  }
}
