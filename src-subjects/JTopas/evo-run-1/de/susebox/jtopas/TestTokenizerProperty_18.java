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
public class TestTokenizerProperty_18 {


  //Test case number: 18
  /*
   * 5 covered goals:
   * 1 Weak Mutation 133: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:408 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 2 Weak Mutation 132: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:408 - ReplaceConstant -  STRING,  -> 
   * 3 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I24 Branch 19 LOOKUPSWITCH L397 Case 2 - true
   * 4 Weak Mutation 133: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:408 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 5 Weak Mutation 132: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:408 - ReplaceConstant -  STRING,  -> 
   */
  @Test
  public void test18()  throws Throwable  {
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(2);
      String string0 = tokenizerProperty0.toString();
      assertEquals("de.susebox.jtopas.TokenizerProperty: STRING, flags/mask 0x0/0x0", string0);
      assertNotNull(string0);
  }
}