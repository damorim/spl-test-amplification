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
public class TestSEFTestLargeSource_6 {


  //Test case number: 6
  /*
   * 21 covered goals:
   * 1 Weak Mutation 502: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:436 - ReplaceComparisonOperator <= -> <
   * 2 Weak Mutation 519: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:441 - ReplaceComparisonOperator == -> >=
   * 3 Weak Mutation 525: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:442 - ReplaceComparisonOperator <= -> -1
   * 4 Weak Mutation 522: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:442 - DeleteStatement: length()I
   * 5 Weak Mutation 526: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:443 - ReplaceConstant -  +  -> 
   * 6 Weak Mutation 527: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:443 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 7 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I56 Branch 34 IFLE L436 - true
   * 8 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I75 Branch 35 IFEQ L441 - false
   * 9 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I80 Branch 36 IFLE L442 - false
   * 10 Weak Mutation 506: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:439 - ReplaceConstant - F_RETURN_BLOCK_COMMENTS -> 
   * 11 Weak Mutation 507: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:439 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 12 Weak Mutation 500: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:436 - DeleteStatement: length()I
   * 13 Weak Mutation 497: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:435 - ReplaceComparisonOperator == -> >=
   * 14 Weak Mutation 558: de.susebox.jtopas.sef.SEFTestLargeSource.types2String()Ljava/lang/String;:480 - ReplaceComparisonOperator == -> -2
   * 15 Weak Mutation 542: de.susebox.jtopas.sef.SEFTestLargeSource.types2String()Ljava/lang/String;:477 - ReplaceComparisonOperator == -> -2
   * 16 Weak Mutation 502: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:436 - ReplaceComparisonOperator <= -> <
   * 17 Weak Mutation 519: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:441 - ReplaceComparisonOperator == -> >=
   * 18 Weak Mutation 525: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:442 - ReplaceComparisonOperator <= -> -1
   * 19 Weak Mutation 526: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:443 - ReplaceConstant -  +  -> 
   * 20 Weak Mutation 527: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:443 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 522: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:442 - DeleteStatement: length()I
   */
  @Test
  public void test6()  throws Throwable  {
      SEFTestLargeSource sEFTestLargeSource0 = new SEFTestLargeSource("$f^nHE?}y+", (-762), (-1680L));
      try {
        sEFTestLargeSource0.parseCharSequence();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}