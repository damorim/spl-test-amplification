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
public class TestTokenizerProperty_12 {


  //Test case number: 12
  /*
   * 6 covered goals:
   * 1 Weak Mutation 100: de.susebox.jtopas.TokenizerProperty.equals(Ljava/lang/Object;)Z:363 - ReplaceComparisonOperator != -> >
   * 2 de.susebox.jtopas.TokenizerProperty.equals(Ljava/lang/Object;)Z: I49 Branch 9 IF_ICMPNE L363 - true
   * 3 Weak Mutation 100: de.susebox.jtopas.TokenizerProperty.equals(Ljava/lang/Object;)Z:363 - ReplaceComparisonOperator != -> >
   * 4 Weak Mutation 98: de.susebox.jtopas.TokenizerProperty.equals(Ljava/lang/Object;)Z:363 - DeleteStatement: getFlags()I
   * 5 Weak Mutation 99: de.susebox.jtopas.TokenizerProperty.equals(Ljava/lang/Object;)Z:363 - DeleteStatement: getFlags()I
   * 6 de.susebox.jtopas.TokenizerProperty.equals(Ljava/lang/Object;)Z: I44 Branch 8 IF_ACMPNE L363 - false
   */
  @Test
  public void test12()  throws Throwable  {
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty();
      TokenizerProperty tokenizerProperty1 = new TokenizerProperty();
      tokenizerProperty1.setFlags(8, 8);
      boolean boolean0 = tokenizerProperty0.equals((Object) tokenizerProperty1);
      assertEquals("de.susebox.jtopas.TokenizerProperty: UNKNOWN, flags/mask 0x8/0x8", tokenizerProperty1.toString());
      assertEquals(false, boolean0);
  }
}
