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
public class TestSEFTestLargeSource_5 {


  //Test case number: 5
  /*
   * 7 covered goals:
   * 1 Weak Mutation 480: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:430 - ReplaceComparisonOperator <= -> <
   * 2 de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;: I31 Branch 32 IFLE L430 - true
   * 3 Weak Mutation 478: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:430 - DeleteStatement: length()I
   * 4 Weak Mutation 477: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:429 - ReplaceComparisonOperator != -> -1
   * 5 Weak Mutation 485: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:433 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 6 Weak Mutation 484: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:433 - ReplaceConstant - F_RETURN_WHITESPACES -> 
   * 7 Weak Mutation 480: de.susebox.jtopas.sef.SEFTestLargeSource.flags2String()Ljava/lang/String;:430 - ReplaceComparisonOperator <= -> <
   */
  @Test
  public void test5()  throws Throwable  {
      SEFTestLargeSource sEFTestLargeSource0 = new SEFTestLargeSource((String) null, (-55), (long) (-55));
      try {
        sEFTestLargeSource0.parseCharSequence();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}