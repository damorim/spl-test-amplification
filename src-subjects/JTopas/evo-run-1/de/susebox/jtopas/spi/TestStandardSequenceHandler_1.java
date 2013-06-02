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
import de.susebox.jtopas.spi.StandardSequenceHandler;

@RunWith(EvoSuiteRunner.class)
public class TestStandardSequenceHandler_1 {


  //Test case number: 1
  /*
   * 4 covered goals:
   * 1 Weak Mutation 5: de.susebox.jtopas.spi.StandardSequenceHandler.hasSequenceCommentOrString()Z:89 - ReplaceConstant - 0 -> 1
   * 2 de.susebox.jtopas.spi.StandardSequenceHandler.hasSequenceCommentOrString()Z: I4 Branch 1 IFNULL L86 - true
   * 3 Weak Mutation 1: de.susebox.jtopas.spi.StandardSequenceHandler.hasSequenceCommentOrString()Z:86 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 5: de.susebox.jtopas.spi.StandardSequenceHandler.hasSequenceCommentOrString()Z:89 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test1()  throws Throwable  {
      StandardSequenceHandler standardSequenceHandler0 = new StandardSequenceHandler((TokenizerProperties) null);
      boolean boolean0 = standardSequenceHandler0.hasSequenceCommentOrString();
      assertEquals(false, boolean0);
  }
}
