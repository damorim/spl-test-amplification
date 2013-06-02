/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.sef;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.sef.SEFTestDifficultSituations;
import java.io.File;
import junit.framework.AssertionFailedError;

@RunWith(EvoSuiteRunner.class)
public class TestSEFTestDifficultSituations_12 {


  //Test case number: 12
  /*
   * 71 covered goals:
   * 1 Weak Mutation 618: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:775 - ReplaceConstant - // line comment with DOS line ending
void main(int argc)
{
  // another line comment
  /* a block comment
     with more than one line
  */
}
 -> 
   * 2 Weak Mutation 619: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 0
   * 3 Weak Mutation 622: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 7
   * 4 Weak Mutation 623: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 9
   * 5 Weak Mutation 620: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 1
   * 6 Weak Mutation 621: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> -1
   * 7 Weak Mutation 627: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 3647
   * 8 Weak Mutation 626: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> -1
   * 9 Weak Mutation 625: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 1
   * 10 Weak Mutation 624: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 0
   * 11 Weak Mutation 629: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - DeleteStatement: setParseFlags(I)V
   * 12 Weak Mutation 628: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 3649
   * 13 Weak Mutation 631: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:792 - DeleteStatement: addLineComment(Ljava/lang/String;)V
   * 14 Weak Mutation 630: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:792 - ReplaceConstant - // -> 
   * 15 Weak Mutation 634: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:793 - DeleteStatement: addBlockComment(Ljava/lang/String;Ljava/lang/String;)V
   * 16 Weak Mutation 633: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:793 - ReplaceConstant - */ -> 
   * 17 Weak Mutation 632: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:793 - ReplaceConstant - /* -> 
   * 18 Weak Mutation 635: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - ReplaceConstant - " -> 
   * 19 Weak Mutation 638: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
   * 20 Weak Mutation 637: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - ReplaceConstant - \ -> 
   * 21 Weak Mutation 636: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - ReplaceConstant - " -> 
   * 22 Weak Mutation 639: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:795 - DeleteStatement: setSource(Lde/susebox/jtopas/TokenizerSource;)V
   * 23 Weak Mutation 641: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:798 - DeleteStatement: assertTrue(Z)V
   * 24 Weak Mutation 640: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:798 - DeleteStatement: hasMoreToken()Z
   * 25 Weak Mutation 642: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:799 - DeleteStatement: nextToken()Lde/susebox/jtopas/Token;
   * 26 Weak Mutation 655: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - DeleteStatement: assertTrue(Ljava/lang/String;Z)V
   * 27 Weak Mutation 654: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 0 -> 1
   * 28 Weak Mutation 649: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 8
   * 29 Weak Mutation 648: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 6
   * 30 Weak Mutation 650: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceComparisonOperator != -> >
   * 31 Weak Mutation 645: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 0
   * 32 Weak Mutation 644: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - DeleteStatement: getType()I
   * 33 Weak Mutation 647: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> -1
   * 34 Weak Mutation 646: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 1
   * 35 Weak Mutation 643: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - (1) line comment not recognized -> 
   * 36 de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V: I66 Branch 77 IF_ICMPNE L800 - true
   * 37 Weak Mutation 618: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:775 - ReplaceConstant - // line comment with DOS line ending
void main(int argc)
{
  // another line comment
  /* a block comment
     with more than one line
  */
}
 -> 
   * 38 Weak Mutation 619: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 0
   * 39 Weak Mutation 622: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 7
   * 40 Weak Mutation 623: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 9
   * 41 Weak Mutation 620: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> 1
   * 42 Weak Mutation 621: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:785 - ReplaceConstant - 8 -> -1
   * 43 Weak Mutation 627: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 3647
   * 44 Weak Mutation 626: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> -1
   * 45 Weak Mutation 625: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 1
   * 46 Weak Mutation 624: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 0
   * 47 Weak Mutation 631: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:792 - DeleteStatement: addLineComment(Ljava/lang/String;)V
   * 48 Weak Mutation 630: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:792 - ReplaceConstant - // -> 
   * 49 Weak Mutation 629: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - DeleteStatement: setParseFlags(I)V
   * 50 Weak Mutation 628: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:791 - ReplaceConstant - 3648 -> 3649
   * 51 Weak Mutation 635: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - ReplaceConstant - " -> 
   * 52 Weak Mutation 634: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:793 - DeleteStatement: addBlockComment(Ljava/lang/String;Ljava/lang/String;)V
   * 53 Weak Mutation 633: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:793 - ReplaceConstant - */ -> 
   * 54 Weak Mutation 632: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:793 - ReplaceConstant - /* -> 
   * 55 Weak Mutation 639: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:795 - DeleteStatement: setSource(Lde/susebox/jtopas/TokenizerSource;)V
   * 56 Weak Mutation 638: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
   * 57 Weak Mutation 637: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - ReplaceConstant - \ -> 
   * 58 Weak Mutation 636: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:794 - ReplaceConstant - " -> 
   * 59 Weak Mutation 655: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - DeleteStatement: assertTrue(Ljava/lang/String;Z)V
   * 60 Weak Mutation 654: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 0 -> 1
   * 61 Weak Mutation 649: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 8
   * 62 Weak Mutation 648: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 6
   * 63 Weak Mutation 650: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceComparisonOperator != -> >
   * 64 Weak Mutation 645: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 0
   * 65 Weak Mutation 644: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - DeleteStatement: getType()I
   * 66 Weak Mutation 647: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> -1
   * 67 Weak Mutation 646: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - 7 -> 1
   * 68 Weak Mutation 641: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:798 - DeleteStatement: assertTrue(Z)V
   * 69 Weak Mutation 640: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:798 - DeleteStatement: hasMoreToken()Z
   * 70 Weak Mutation 643: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:800 - ReplaceConstant - (1) line comment not recognized -> 
   * 71 Weak Mutation 642: de.susebox.jtopas.sef.SEFTestDifficultSituations.testDOSEOL()V:799 - DeleteStatement: nextToken()Lde/susebox/jtopas/Token;
   */
  @Test
  public void test12()  throws Throwable  {
      Class<?> class0 = SEFTestDifficultSituations.class;
      SEFTestDifficultSituations sEFTestDifficultSituations0 = new SEFTestDifficultSituations(": expected \"", (Class) class0);
      try {
        sEFTestDifficultSituations0.testDOSEOL();
        fail("Expecting exception: AssertionFailedError");
      } catch(AssertionFailedError e) {
        /*
         * (1) line comment not recognized
         */
      }
  }
}