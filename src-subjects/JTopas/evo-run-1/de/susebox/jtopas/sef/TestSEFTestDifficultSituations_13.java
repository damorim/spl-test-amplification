/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.sef;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.AbstractTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.sef.SEFTestDifficultSituations;
import java.io.File;
import junit.framework.AssertionFailedError;

@RunWith(EvoSuiteRunner.class)
public class TestSEFTestDifficultSituations_13 {


  //Test case number: 13
  /*
   * 71 covered goals:
   * 1 Weak Mutation 665: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:958 - ReplaceConstant - // line comment with DOS line endingvoid main(int argc){  // another line comment  /* a block comment     with more than one line  */} -> 
   * 2 Weak Mutation 668: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> -1
   * 3 Weak Mutation 669: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 7
   * 4 Weak Mutation 670: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 9
   * 5 Weak Mutation 666: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 0
   * 6 Weak Mutation 667: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 1
   * 7 Weak Mutation 676: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - DeleteStatement: setParseFlags(I)V
   * 8 Weak Mutation 675: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 3649
   * 9 Weak Mutation 674: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 3647
   * 10 Weak Mutation 673: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> -1
   * 11 Weak Mutation 672: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 1
   * 12 Weak Mutation 671: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 0
   * 13 Weak Mutation 678: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:975 - DeleteStatement: addLineComment(Ljava/lang/String;)V
   * 14 Weak Mutation 677: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:975 - ReplaceConstant - // -> 
   * 15 Weak Mutation 681: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:976 - DeleteStatement: addBlockComment(Ljava/lang/String;Ljava/lang/String;)V
   * 16 Weak Mutation 680: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:976 - ReplaceConstant - */ -> 
   * 17 Weak Mutation 679: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:976 - ReplaceConstant - /* -> 
   * 18 Weak Mutation 685: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
   * 19 Weak Mutation 684: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - ReplaceConstant - \ -> 
   * 20 Weak Mutation 683: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - ReplaceConstant - " -> 
   * 21 Weak Mutation 682: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - ReplaceConstant - " -> 
   * 22 Weak Mutation 686: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:978 - DeleteStatement: setSource(Lde/susebox/jtopas/TokenizerSource;)V
   * 23 Weak Mutation 687: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:981 - DeleteStatement: hasMoreToken()Z
   * 24 Weak Mutation 688: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:981 - DeleteStatement: assertTrue(Z)V
   * 25 Weak Mutation 689: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:982 - DeleteStatement: nextToken()Lde/susebox/jtopas/Token;
   * 26 Weak Mutation 702: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - DeleteStatement: assertTrue(Ljava/lang/String;Z)V
   * 27 Weak Mutation 701: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 0 -> 1
   * 28 Weak Mutation 696: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 8
   * 29 Weak Mutation 697: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceComparisonOperator != -> >
   * 30 Weak Mutation 694: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> -1
   * 31 Weak Mutation 695: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 6
   * 32 Weak Mutation 692: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 0
   * 33 Weak Mutation 693: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 1
   * 34 Weak Mutation 690: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - (1) line comment not recognized -> 
   * 35 Weak Mutation 691: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - DeleteStatement: getType()I
   * 36 de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V: I66 Branch 171 IF_ICMPNE L983 - true
   * 37 Weak Mutation 687: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:981 - DeleteStatement: hasMoreToken()Z
   * 38 Weak Mutation 686: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:978 - DeleteStatement: setSource(Lde/susebox/jtopas/TokenizerSource;)V
   * 39 Weak Mutation 685: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
   * 40 Weak Mutation 684: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - ReplaceConstant - \ -> 
   * 41 Weak Mutation 683: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - ReplaceConstant - " -> 
   * 42 Weak Mutation 682: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:977 - ReplaceConstant - " -> 
   * 43 Weak Mutation 681: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:976 - DeleteStatement: addBlockComment(Ljava/lang/String;Ljava/lang/String;)V
   * 44 Weak Mutation 680: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:976 - ReplaceConstant - */ -> 
   * 45 Weak Mutation 679: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:976 - ReplaceConstant - /* -> 
   * 46 Weak Mutation 678: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:975 - DeleteStatement: addLineComment(Ljava/lang/String;)V
   * 47 Weak Mutation 677: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:975 - ReplaceConstant - // -> 
   * 48 Weak Mutation 676: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - DeleteStatement: setParseFlags(I)V
   * 49 Weak Mutation 675: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 3649
   * 50 Weak Mutation 674: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 3647
   * 51 Weak Mutation 673: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> -1
   * 52 Weak Mutation 672: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 1
   * 53 Weak Mutation 702: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - DeleteStatement: assertTrue(Ljava/lang/String;Z)V
   * 54 Weak Mutation 701: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 0 -> 1
   * 55 Weak Mutation 696: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 8
   * 56 Weak Mutation 697: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceComparisonOperator != -> >
   * 57 Weak Mutation 694: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> -1
   * 58 Weak Mutation 695: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 6
   * 59 Weak Mutation 692: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 0
   * 60 Weak Mutation 693: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - 7 -> 1
   * 61 Weak Mutation 690: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - ReplaceConstant - (1) line comment not recognized -> 
   * 62 Weak Mutation 691: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:983 - DeleteStatement: getType()I
   * 63 Weak Mutation 688: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:981 - DeleteStatement: assertTrue(Z)V
   * 64 Weak Mutation 689: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:982 - DeleteStatement: nextToken()Lde/susebox/jtopas/Token;
   * 65 Weak Mutation 668: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> -1
   * 66 Weak Mutation 669: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 7
   * 67 Weak Mutation 670: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 9
   * 68 Weak Mutation 671: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:974 - ReplaceConstant - 3648 -> 0
   * 69 Weak Mutation 665: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:958 - ReplaceConstant - // line comment with DOS line endingvoid main(int argc){  // another line comment  /* a block comment     with more than one line  */} -> 
   * 70 Weak Mutation 666: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 0
   * 71 Weak Mutation 667: de.susebox.jtopas.sef.SEFTestDifficultSituations.testMACEOL()V:968 - ReplaceConstant - 8 -> 1
   */
  @Test
  public void test13()  throws Throwable  {
      Class<?> class0 = AbstractTokenizer.class;
      SEFTestDifficultSituations sEFTestDifficultSituations0 = new SEFTestDifficultSituations("(54) end column wrong", (Class) class0);
      try {
        sEFTestDifficultSituations0.testMACEOL();
        fail("Expecting exception: AssertionFailedError");
      } catch(AssertionFailedError e) {
        /*
         * (1) line comment not recognized
         */
      }
  }
}
