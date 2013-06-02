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
public class TestStandardTokenizerProperties_34 {


  //Test case number: 34
  /*
   * 32 covered goals:
   * 1 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I109 Branch 17 IFLE L191 - true
   * 2 Weak Mutation 55: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 54: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - InsertUnaryOp Negation
   * 4 Weak Mutation 53: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 58: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - DeleteStatement: size()I
   * 6 Weak Mutation 57: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - DeleteField: _patternsLjava/util/ArrayList;
   * 7 Weak Mutation 56: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - InsertUnaryOp IINC -1
   * 8 Weak Mutation 61: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - ReplaceComparisonOperator >= -> -1
   * 9 Weak Mutation 60: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - ReplaceComparisonOperator >= -> >
   * 10 Weak Mutation 147: de.susebox.jtopas.StandardTokenizerProperties.doAddProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:295 - DeleteStatement: addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;
   * 11 Weak Mutation 462: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:796 - ReplaceComparisonOperator >= -> >
   * 12 Weak Mutation 460: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:796 - DeleteStatement: size()I
   * 13 Weak Mutation 459: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:796 - DeleteField: _patternsLjava/util/ArrayList;
   * 14 Weak Mutation 458: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:796 - InsertUnaryOp IINC -1
   * 15 Weak Mutation 457: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:796 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 456: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:796 - InsertUnaryOp Negation
   * 17 Weak Mutation 455: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:796 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 453: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:790 - DeleteStatement: getParseFlags()I
   * 19 Weak Mutation 452: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:787 - ReplaceConstant - 0 -> 1
   * 20 Weak Mutation 451: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:787 - DeleteStatement: getImages()[Ljava/lang/String;
   * 21 Weak Mutation 481: de.susebox.jtopas.StandardTokenizerProperties.addPattern(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:807 - DeleteField: _patternsLjava/util/ArrayList;
   * 22 Weak Mutation 55: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 54: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - InsertUnaryOp Negation
   * 24 Weak Mutation 53: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - ReplaceConstant - 0 -> 1
   * 25 Weak Mutation 58: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - DeleteStatement: size()I
   * 26 Weak Mutation 57: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - DeleteField: _patternsLjava/util/ArrayList;
   * 27 Weak Mutation 56: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - InsertUnaryOp IINC -1
   * 28 Weak Mutation 61: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - ReplaceComparisonOperator >= -> -1
   * 29 Weak Mutation 60: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:187 - ReplaceComparisonOperator >= -> >
   * 30 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I7 Branch 3 TABLESWITCH L164 Case 3 - true
   * 31 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I87 Branch 16 IF_ICMPGE L187 - true
   * 32 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I87 Branch 16 IF_ICMPGE L187 - false
   */
  @Test
  public void test34()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(1226, "KxHV", "KxHV");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addPattern("KxHV", "8");
      standardTokenizerProperties0.removePattern("pc");
      assertEquals(true, standardTokenizerProperties0.hasPattern());
      assertEquals(1226, standardTokenizerProperties0.getParseFlags());
  }
}
