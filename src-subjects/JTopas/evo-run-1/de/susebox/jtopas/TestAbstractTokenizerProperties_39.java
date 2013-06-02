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
import de.susebox.jtopas.TokenizerProperty;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizerProperties_39 {


  //Test case number: 39
  /*
   * 7 covered goals:
   * 1 Weak Mutation 440: de.susebox.jtopas.AbstractTokenizerProperties.propertyExists(Lde/susebox/jtopas/TokenizerProperty;)Z:1268 - DeleteStatement: checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V
   * 2 Weak Mutation 448: de.susebox.jtopas.AbstractTokenizerProperties.propertyExists(Lde/susebox/jtopas/TokenizerProperty;)Z:1273 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 732: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1522 - ReplaceConstant - Property is null. -> 
   * 4 de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V: I3 Branch 67 IFNONNULL L1521 - false
   * 5 Weak Mutation 440: de.susebox.jtopas.AbstractTokenizerProperties.propertyExists(Lde/susebox/jtopas/TokenizerProperty;)Z:1268 - DeleteStatement: checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V
   * 6 Weak Mutation 448: de.susebox.jtopas.AbstractTokenizerProperties.propertyExists(Lde/susebox/jtopas/TokenizerProperty;)Z:1273 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 732: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1522 - ReplaceConstant - Property is null. -> 
   */
  @Test
  public void test39()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(58, ":*NDW),^F:$*`|poS", ":*NDW),^F:$*`|poS");
      assertNotNull(standardTokenizerProperties0);
      
      TokenizerProperty tokenizerProperty0 = standardTokenizerProperties0.getString(":*NDW),^F:$*`|poS");
      boolean boolean0 = standardTokenizerProperties0.propertyExists(tokenizerProperty0);
      assertEquals(":*NDW),^F:$*`|poS", standardTokenizerProperties0.getWhitespaces());
      assertEquals(false, boolean0);
      assertEquals(":*NDW),^F:$*`|poS", standardTokenizerProperties0.getSeparators());
      assertEquals(58, standardTokenizerProperties0.getParseFlags());
  }
}