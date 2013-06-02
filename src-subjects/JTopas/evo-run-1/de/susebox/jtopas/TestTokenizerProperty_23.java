/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.TokenizerProperty;

@RunWith(EvoSuiteRunner.class)
public class TestTokenizerProperty_23 {


  //Test case number: 23
  /*
   * 2 covered goals:
   * 1 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I24 Branch 26 LOOKUPSWITCH L397 Case 127 - true
   * 2 Weak Mutation 21: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:138 - ReplaceBitwiseOperator & -> ^
   */
  @Test
  public void test23()  throws Throwable  {
      String[] stringArray0 = new String[2];
      Object object0 = new Object();
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(127, stringArray0, object0, 127);
      String string0 = tokenizerProperty0.toString();
      assertNotNull(string0);
      assertEquals("de.susebox.jtopas.TokenizerProperty: PARSE FLAG MASK, flags/mask 0x7f/0x7f:", string0);
  }
}