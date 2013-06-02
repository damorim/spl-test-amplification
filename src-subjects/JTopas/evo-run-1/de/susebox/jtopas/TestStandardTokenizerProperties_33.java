/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.java.lang.ExtIllegalArgumentException;
import de.susebox.java.lang.ExtUnsupportedOperationException;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.spi.DataProvider;

@RunWith(EvoSuiteRunner.class)
public class TestStandardTokenizerProperties_33 {


  //Test case number: 33
  /*
   * 5 covered goals:
   * 1 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I7 Branch 2 TABLESWITCH L164 Case 2 - true
   * 2 Weak Mutation 47: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:181 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 3 Weak Mutation 49: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:181 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 48: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:181 - ReplaceConstant - 1 -> 0
   * 5 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I67 Branch 15 IFNULL L181 - true
   */
  @Test
  public void test33()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.getString("@u?(LbW=iR:1 F9(");
      assertEquals(0, standardTokenizerProperties0.getParseFlags());
      assertEquals(true, standardTokenizerProperties0.newlineIsWhitespace());
  }
}