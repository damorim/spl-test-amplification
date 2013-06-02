/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.sef;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.sef.SEFTestLargeSource;
import junit.framework.AssertionFailedError;

@RunWith(EvoSuiteRunner.class)
public class TestSEFTestLargeSource_3 {


  //Test case number: 3
  /*
   * 27 covered goals:
   * 1 Weak Mutation 454: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:425 - ReplaceComparisonOperator == -> >=
   * 2 Weak Mutation 458: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:426 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 3 Weak Mutation 457: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:426 - ReplaceConstant - F_KEEP_DATA -> 
   * 4 Weak Mutation 497: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:435 - ReplaceComparisonOperator == -> >=
   * 5 Weak Mutation 500: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:436 - DeleteStatement: length()I
   * 6 Weak Mutation 503: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:436 - ReplaceComparisonOperator <= -> -1
   * 7 Weak Mutation 504: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:437 - ReplaceConstant -  +  -> 
   * 8 Weak Mutation 505: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:437 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 9 Weak Mutation 506: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:439 - ReplaceConstant - F_RETURN_BLOCK_COMMENTS -> 
   * 10 Weak Mutation 507: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:439 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 11 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I12 Branch 30 IFEQ L425 - false
   * 12 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I51 Branch 33 IFEQ L435 - false
   * 13 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I56 Branch 34 IFLE L436 - false
   * 14 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I104 Branch 38 IFLE L448 - false
   * 15 Weak Mutation 521: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:441 - ReplaceComparisonOperator == -> -2
   * 16 Weak Mutation 458: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:426 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 457: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:426 - ReplaceConstant - F_KEEP_DATA -> 
   * 18 Weak Mutation 454: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:425 - ReplaceComparisonOperator == -> >=
   * 19 Weak Mutation 504: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:437 - ReplaceConstant -  +  -> 
   * 20 Weak Mutation 505: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:437 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 506: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:439 - ReplaceConstant - F_RETURN_BLOCK_COMMENTS -> 
   * 22 Weak Mutation 507: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:439 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 23 Weak Mutation 500: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:436 - DeleteStatement: length()I
   * 24 Weak Mutation 503: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:436 - ReplaceComparisonOperator <= -> -1
   * 25 Weak Mutation 497: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:435 - ReplaceComparisonOperator == -> >=
   * 26 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I99 Branch 37 IFEQ L447 - false
   * 27 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I123 Branch 39 IFEQ L455 - true
   */
  @Test
  public void test3()  throws Throwable  {
      SEFTestLargeSource sEFTestLargeSource0 = new SEFTestLargeSource("", 1725, (long) 1725);
      try {
        sEFTestLargeSource0.parseCharSequence();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}