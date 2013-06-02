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
public class TestStandardTokenizerProperties_37 {


  //Test case number: 37
  /*
   * 4 covered goals:
   * 1 de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I15 Branch 45 TABLESWITCH L317 Default-Case - true
   * 2 Weak Mutation 158: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:315 - DeleteStatement: getImages()[Ljava/lang/String;
   * 3 Weak Mutation 159: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:315 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 160: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:317 - DeleteStatement: getType()I
   */
  @Test
  public void test37()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(45);
      assertNotNull(standardTokenizerProperties0);
      
      String[] stringArray0 = new String[8];
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty((-1), stringArray0, (Object) ":  ");
      // Undeclared exception!
      try {
        standardTokenizerProperties0.doRemoveProperty(tokenizerProperty0);
        fail("Expecting exception: ExtIllegalArgumentException");
      } catch(ExtIllegalArgumentException e) {
        /*
         * Unsupported property type -1. (Leading) image \"null\".
         */
      }
  }
}
