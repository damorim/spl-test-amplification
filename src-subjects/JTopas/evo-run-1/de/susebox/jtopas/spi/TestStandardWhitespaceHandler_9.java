/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.spi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.spi.DataProvider;
import de.susebox.jtopas.spi.StandardWhitespaceHandler;

@RunWith(EvoSuiteRunner.class)
public class TestStandardWhitespaceHandler_9 {


  //Test case number: 9
  /*
   * 3 covered goals:
   * 1 Weak Mutation 55: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace()Z:131 - ReplaceConstant - 0 -> 1
   * 2 de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace()Z: I4 Branch 8 IFNULL L128 - true
   * 3 Weak Mutation 55: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace()Z:131 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test9()  throws Throwable  {
      StandardWhitespaceHandler standardWhitespaceHandler0 = new StandardWhitespaceHandler((TokenizerProperties) null);
      boolean boolean0 = standardWhitespaceHandler0.newlineIsWhitespace();
      assertEquals(false, boolean0);
  }
}
