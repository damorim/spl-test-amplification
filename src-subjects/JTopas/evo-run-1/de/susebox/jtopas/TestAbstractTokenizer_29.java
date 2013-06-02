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
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.TokenizerSource;
import de.susebox.jtopas.spi.KeywordHandler;
import de.susebox.jtopas.spi.PatternHandler;
import de.susebox.jtopas.spi.SequenceHandler;
import java.io.PipedReader;
import java.io.Reader;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizer_29 {


  //Test case number: 29
  /*
   * 22 covered goals:
   * 1 Weak Mutation 711: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - ReplaceComparisonOperator < -> -2
   * 2 Weak Mutation 750: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1200 - DeleteStatement: splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;
   * 3 Weak Mutation 749: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1200 - DeleteStatement: substring(I)Ljava/lang/String;
   * 4 Weak Mutation 748: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1200 - DeleteStatement: length()I
   * 5 de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I33 Branch 117 IF_ICMPLT L1195 - true
   * 6 Weak Mutation 702: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1193 - DeleteStatement: isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z
   * 7 Weak Mutation 703: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - DeleteStatement: length()I
   * 8 Weak Mutation 700: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1192 - ReplaceConstant - 1 -> 0
   * 9 Weak Mutation 701: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1193 - ReplaceConstant - 1 -> 0
   * 10 Weak Mutation 698: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1190 - DeleteStatement: getImages()[Ljava/lang/String;
   * 11 Weak Mutation 699: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1191 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 705: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - ReplaceArithmeticOperator - -> +
   * 13 Weak Mutation 704: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - DeleteStatement: length()I
   * 14 Weak Mutation 707: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - ReplaceArithmeticOperator - -> /
   * 15 Weak Mutation 709: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - DeleteStatement: length()I
   * 16 Weak Mutation 708: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - ReplaceArithmeticOperator - -> *
   * 17 Weak Mutation 750: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1200 - DeleteStatement: splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;
   * 18 Weak Mutation 749: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1200 - DeleteStatement: substring(I)Ljava/lang/String;
   * 19 Weak Mutation 748: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1200 - DeleteStatement: length()I
   * 20 Weak Mutation 705: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - ReplaceArithmeticOperator - -> +
   * 21 Weak Mutation 708: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - ReplaceArithmeticOperator - -> *
   * 22 Weak Mutation 711: de.susebox.jtopas.AbstractTokenizer.splitBlockComment(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1195 - ReplaceComparisonOperator < -> -2
   */
  @Test
  public void test29()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      String[] stringArray0 = new String[8];
      stringArray0[0] = "yH:udt8";
      stringArray0[1] = "yH:udt8";
      StandardTokenizerProperties standardTokenizerProperties0 = (StandardTokenizerProperties)standardTokenizer0.getPatternHandler();
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(65536, stringArray0, (Object) standardTokenizerProperties0);
      standardTokenizer0.splitBlockComment(tokenizerProperty0, "yH:udt8");
      assertEquals(false, standardTokenizer0.hasMoreToken());
      assertEquals(0, standardTokenizer0.getParseFlags());
  }
}
