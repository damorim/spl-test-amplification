/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizerProperties;

@RunWith(EvoSuiteRunner.class)
public class TestStandardTokenizerProperties_4 {


  //Test case number: 4
  /*
   * 8 covered goals:
   * 1 Weak Mutation 143: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:269 - ReplaceComparisonOperator != -> -1
   * 2 de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;: I76 Branch 27 IFNE L269 - false
   * 3 Weak Mutation 119: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:255 - DeleteField: _whitespacesNoCaseLjava/lang/String;
   * 4 Weak Mutation 116: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:255 - ReplaceComparisonOperator <= -> <
   * 5 Weak Mutation 119: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:255 - DeleteField: _whitespacesNoCaseLjava/lang/String;
   * 6 Weak Mutation 116: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:255 - ReplaceComparisonOperator <= -> <
   * 7 Weak Mutation 143: de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;:269 - ReplaceComparisonOperator != -> -1
   * 8 de.susebox.jtopas.StandardTokenizerProperties.doSetWhitespaces(Ljava/lang/String;)Ljava/lang/String;: I12 Branch 24 IFLE L255 - true
   */
  @Test
  public void test4()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(2011, "", "");
      assertNotNull(standardTokenizerProperties0);
      
      String string0 = standardTokenizerProperties0.doSetWhitespaces("");
      assertNull(string0);
      assertEquals("", standardTokenizerProperties0.getSeparators());
      assertEquals(false, standardTokenizerProperties0.newlineIsWhitespace());
      assertEquals(2010, standardTokenizerProperties0.getParseFlags());
  }
}
