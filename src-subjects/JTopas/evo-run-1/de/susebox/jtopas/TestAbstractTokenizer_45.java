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
public class TestAbstractTokenizer_45 {


  //Test case number: 45
  /*
   * 65 covered goals:
   * 1 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I117 Branch 95 IF_ICMPGE L1144 - true
   * 2 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I126 Branch 97 IFGT L1145 - true
   * 3 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I143 Branch 100 IFNONNULL L1147 - true
   * 4 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I143 Branch 100 IFNONNULL L1147 - false
   * 5 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I173 Branch 101 IF_ICMPGE L1152 - false
   * 6 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I177 Branch 102 IFNE L1153 - false
   * 7 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I182 Branch 103 IFGT L1153 - true
   * 8 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I292 Branch 114 IFNULL L1172 - false
   * 9 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I295 Branch 115 IF_ICMPGE L1172 - false
   * 10 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I309 Branch 116 IFNULL L1176 - false
   * 11 Weak Mutation 584: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1085 - ReplaceComparisonOperator >= -> -1
   * 12 Weak Mutation 585: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - InsertUnaryOp Negation
   * 13 Weak Mutation 586: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - InsertUnaryOp IINC 1
   * 14 Weak Mutation 587: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - InsertUnaryOp IINC -1
   * 15 Weak Mutation 588: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - DeleteStatement: charAt(I)C
   * 16 Weak Mutation 687: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: length()I
   * 17 Weak Mutation 686: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceComparisonOperator != -> ==
   * 18 Weak Mutation 685: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - InsertUnaryOp IINC -1
   * 19 Weak Mutation 684: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 683: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - InsertUnaryOp Negation
   * 21 Weak Mutation 680: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceComparisonOperator < -> !=
   * 22 Weak Mutation 676: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> %
   * 23 Weak Mutation 694: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 24 Weak Mutation 695: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceComparisonOperator > -> !=
   * 25 Weak Mutation 692: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> *
   * 26 Weak Mutation 693: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: substring(I)Ljava/lang/String;
   * 27 Weak Mutation 690: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> %
   * 28 Weak Mutation 691: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> /
   * 29 Weak Mutation 688: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: length()I
   * 30 Weak Mutation 689: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> +
   * 31 Weak Mutation 655: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1128 - ReplaceComparisonOperator == -> <=
   * 32 Weak Mutation 666: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1128 - ReplaceConstant - 0 -> 1
   * 33 Weak Mutation 660: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1128 - ReplaceComparisonOperator == -> !=
   * 34 Weak Mutation 657: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1128 - InsertUnaryOp Negation
   * 35 Weak Mutation 658: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1128 - InsertUnaryOp IINC 1
   * 36 Weak Mutation 659: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1128 - InsertUnaryOp IINC -1
   * 37 Weak Mutation 584: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1085 - ReplaceComparisonOperator >= -> -1
   * 38 Weak Mutation 585: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - InsertUnaryOp Negation
   * 39 Weak Mutation 586: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - InsertUnaryOp IINC 1
   * 40 Weak Mutation 587: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - InsertUnaryOp IINC -1
   * 41 Weak Mutation 588: de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;:1086 - DeleteStatement: charAt(I)C
   * 42 Weak Mutation 687: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: length()I
   * 43 Weak Mutation 686: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceComparisonOperator != -> ==
   * 44 Weak Mutation 685: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - InsertUnaryOp IINC -1
   * 45 Weak Mutation 684: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - InsertUnaryOp IINC 1
   * 46 Weak Mutation 683: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - InsertUnaryOp Negation
   * 47 Weak Mutation 680: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceComparisonOperator < -> !=
   * 48 Weak Mutation 694: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 49 Weak Mutation 695: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceComparisonOperator > -> !=
   * 50 Weak Mutation 692: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> *
   * 51 Weak Mutation 693: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: substring(I)Ljava/lang/String;
   * 52 Weak Mutation 690: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> %
   * 53 Weak Mutation 691: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> /
   * 54 Weak Mutation 688: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - DeleteStatement: length()I
   * 55 Weak Mutation 689: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1136 - ReplaceArithmeticOperator - -> +
   * 56 Weak Mutation 655: de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;:1128 - ReplaceComparisonOperator == -> <=
   * 57 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I73 Branch 90 IF_ICMPLT L1136 - false
   * 58 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I75 Branch 91 IFNE L1136 - false
   * 59 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I85 Branch 92 IFGT L1136 - false
   * 60 de.susebox.jtopas.AbstractTokenizer.splitString(Lde/susebox/jtopas/TokenizerProperty;Ljava/lang/String;)[Ljava/lang/String;: I88 Branch 93 IFEQ L1136 - true
   * 61 de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;: I19 Branch 78 IF_ICMPGE L1085 - false
   * 62 de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;: I25 Branch 79 LOOKUPSWITCH L1086 Case 10 - false
   * 63 de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;: I25 Branch 80 LOOKUPSWITCH L1086 Case 13 - false
   * 64 de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;: I25 Branch 81 LOOKUPSWITCH L1086 Default-Case - true
   * 65 de.susebox.jtopas.AbstractTokenizer.splitIntoLines(Ljava/lang/String;)[Ljava/lang/String;: I89 Branch 84 IF_ICMPLT L1105 - true
   */
  @Test
  public void test45()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      String[] stringArray0 = new String[5];
      stringArray0[0] = "Bc?lsB*N:`ba.I[6o";
      stringArray0[1] = "NHAo3z";
      stringArray0[2] = "";
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(0, stringArray0, (Object) null);
      standardTokenizer0.splitString(tokenizerProperty0, "Unsupported property type {0}. (Leading) image \"{1}\".");
      assertEquals(false, standardTokenizer0.hasMoreToken());
      assertEquals(-1, standardTokenizer0.getLineNumber());
  }
}
