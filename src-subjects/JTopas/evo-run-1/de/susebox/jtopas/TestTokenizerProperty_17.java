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
public class TestTokenizerProperty_17 {


  //Test case number: 17
  /*
   * 8 covered goals:
   * 1 Weak Mutation 131: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:405 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 2 Weak Mutation 130: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:405 - ReplaceConstant -  LINE_COMMENT,  -> 
   * 3 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I24 Branch 24 LOOKUPSWITCH L397 Case 7 - true
   * 4 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I162 Branch 28 IFNULL L442 - false
   * 5 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I178 Branch 29 IF_ICMPGE L444 - false
   * 6 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I185 Branch 30 IFNULL L445 - true
   * 7 Weak Mutation 131: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:405 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 8 Weak Mutation 130: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:405 - ReplaceConstant -  LINE_COMMENT,  -> 
   */
  @Test
  public void test17()  throws Throwable  {
      String[] stringArray0 = new String[3];
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(7, stringArray0);
      String string0 = tokenizerProperty0.toString();
      assertNotNull(string0);
      assertEquals("de.susebox.jtopas.TokenizerProperty: LINE_COMMENT, flags/mask 0x0/0x0:", string0);
  }
}