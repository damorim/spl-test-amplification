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
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.spi.DataProvider;

@RunWith(EvoSuiteRunner.class)
public class TestStandardTokenizerProperties_13 {


  //Test case number: 13
  /*
   * 2 covered goals:
   * 1 Weak Mutation 258: de.susebox.jtopas.StandardTokenizerProperties.countLeadingWhitespaces(Lde/susebox/jtopas/spi/DataProvider;)I:551 - DeleteStatement: getLength()I
   * 2 Weak Mutation 258: de.susebox.jtopas.StandardTokenizerProperties.countLeadingWhitespaces(Lde/susebox/jtopas/spi/DataProvider;)I:551 - DeleteStatement: getLength()I
   */
  @Test
  public void test13()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      assertNotNull(standardTokenizerProperties0);
      
      try {
        standardTokenizerProperties0.countLeadingWhitespaces((DataProvider) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
