/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizerProperties_33 {


  //Test case number: 33
  /*
   * 39 covered goals:
   * 1 Weak Mutation 390: de.susebox.jtopas.AbstractTokenizerProperties.removePattern(Ljava/lang/String;)V:1135 - DeleteStatement: removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 2 de.susebox.jtopas.AbstractTokenizerProperties.removePattern(Ljava/lang/String;)V: I9 Branch 26 IFNULL L1134 - false
   * 3 Weak Mutation 389: de.susebox.jtopas.AbstractTokenizerProperties.removePattern(Ljava/lang/String;)V:1134 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 388: de.susebox.jtopas.AbstractTokenizerProperties.removePattern(Ljava/lang/String;)V:1132 - DeleteStatement: getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 5 Weak Mutation 432: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1245 - DeleteStatement: checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V
   * 6 Weak Mutation 433: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1249 - DeleteStatement: doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;
   * 7 Weak Mutation 434: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1251 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 435: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1252 - ReplaceConstant - 2 -> 0
   * 9 Weak Mutation 436: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1252 - ReplaceConstant - 2 -> 1
   * 10 Weak Mutation 437: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1252 - ReplaceConstant - 2 -> -1
   * 11 Weak Mutation 438: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1252 - ReplaceConstant - 2 -> 3
   * 12 Weak Mutation 439: de.susebox.jtopas.AbstractTokenizerProperties.removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1252 - DeleteStatement: notifyListeners(Lde/susebox/jtopas/TokenizerPropertyEvent;)V
   * 13 Weak Mutation 375: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - ReplaceConstant - 3 -> 1
   * 14 Weak Mutation 374: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - ReplaceConstant - 3 -> 0
   * 15 Weak Mutation 381: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - InsertUnaryOp Negation
   * 16 Weak Mutation 380: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - ReplaceConstant - 0 -> 1
   * 17 Weak Mutation 383: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 382: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 377: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - ReplaceConstant - 3 -> 2
   * 20 Weak Mutation 376: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - ReplaceConstant - 3 -> -1
   * 21 Weak Mutation 379: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - ReplaceConstant - 1 -> 0
   * 22 Weak Mutation 378: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - ReplaceConstant - 3 -> 4
   * 23 Weak Mutation 402: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1192 - ReplaceConstant - 3 -> 1
   * 24 Weak Mutation 403: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1192 - ReplaceConstant - 3 -> -1
   * 25 Weak Mutation 400: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1188 - DeleteStatement: checkArgument(Ljava/lang/String;Ljava/lang/String;)V
   * 26 Weak Mutation 401: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1192 - ReplaceConstant - 3 -> 0
   * 27 Weak Mutation 406: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1192 - DeleteStatement: doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 28 Weak Mutation 404: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1192 - ReplaceConstant - 3 -> 2
   * 29 Weak Mutation 405: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1192 - ReplaceConstant - 3 -> 4
   * 30 Weak Mutation 399: de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:1188 - ReplaceConstant - Pattern -> 
   * 31 Weak Mutation 387: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - DeleteStatement: addProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 32 Weak Mutation 386: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - InsertUnaryOp IINC -1
   * 33 Weak Mutation 385: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - InsertUnaryOp IINC 1
   * 34 Weak Mutation 384: de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V:1119 - InsertUnaryOp Negation
   * 35 Weak Mutation 390: de.susebox.jtopas.AbstractTokenizerProperties.removePattern(Ljava/lang/String;)V:1135 - DeleteStatement: removeProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 36 Weak Mutation 389: de.susebox.jtopas.AbstractTokenizerProperties.removePattern(Ljava/lang/String;)V:1134 - ReplaceComparisonOperator = null -> != null
   * 37 Weak Mutation 388: de.susebox.jtopas.AbstractTokenizerProperties.removePattern(Ljava/lang/String;)V:1132 - DeleteStatement: getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 38 de.susebox.jtopas.AbstractTokenizerProperties.getPattern(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: root-Branch
   * 39 de.susebox.jtopas.AbstractTokenizerProperties.addPattern(Ljava/lang/String;Ljava/lang/Object;II)V: root-Branch
   */
  @Test
  public void test33()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(503, "B:~NJ5O5lDi", "B:~NJ5O5lDi");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addPattern("B:~NJ5O5lDi", (Object) "Type UNKNOWN:  no image, length 0", 0, 0);
      assertEquals(true, standardTokenizerProperties0.hasPattern());
      
      standardTokenizerProperties0.removePattern("B:~NJ5O5lDi");
      assertEquals(502, standardTokenizerProperties0.getParseFlags());
  }
}
