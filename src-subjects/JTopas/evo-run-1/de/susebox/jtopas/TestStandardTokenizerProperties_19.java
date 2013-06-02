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
public class TestStandardTokenizerProperties_19 {


  //Test case number: 19
  /*
   * 7 covered goals:
   * 1 Weak Mutation 344: de.susebox.jtopas.StandardTokenizerProperties.hasSequenceCommentOrString()Z:604 - ReplaceConstant - 1 -> 0
   * 2 de.susebox.jtopas.StandardTokenizerProperties.hasSequenceCommentOrString()Z: I18 Branch 65 IFNULL L604 - false
   * 3 Weak Mutation 343: de.susebox.jtopas.StandardTokenizerProperties.hasSequenceCommentOrString()Z:604 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 342: de.susebox.jtopas.StandardTokenizerProperties.hasSequenceCommentOrString()Z:604 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 341: de.susebox.jtopas.StandardTokenizerProperties.hasSequenceCommentOrString()Z:604 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 6 Weak Mutation 344: de.susebox.jtopas.StandardTokenizerProperties.hasSequenceCommentOrString()Z:604 - ReplaceConstant - 1 -> 0
   * 7 de.susebox.jtopas.StandardTokenizerProperties.doAddProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I4 Branch 35 TABLESWITCH L284 Case 8 - true
   */
  @Test
  public void test19()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-171), " NOR;MAL, ", " NOR;MAL, ");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addBlockComment("]|0[R6omW=ETLoF;{<N", "]|0[R6omW=ETLoF;{<N");
      boolean boolean0 = standardTokenizerProperties0.hasSequenceCommentOrString();
      assertEquals(19, standardTokenizerProperties0.getSequenceMaxLength());
      assertEquals(true, boolean0);
  }
}
