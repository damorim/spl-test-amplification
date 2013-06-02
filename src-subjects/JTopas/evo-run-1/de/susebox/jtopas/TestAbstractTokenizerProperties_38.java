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
public class TestAbstractTokenizerProperties_38 {


  //Test case number: 38
  /*
   * 43 covered goals:
   * 1 Weak Mutation 425: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1229 - ReplaceComparisonOperator != -> ==
   * 2 Weak Mutation 424: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1229 - DeleteStatement: equals(Ljava/lang/Object;)Z
   * 3 Weak Mutation 427: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 1
   * 4 Weak Mutation 426: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 0
   * 5 Weak Mutation 429: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 2
   * 6 Weak Mutation 428: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> -1
   * 7 Weak Mutation 431: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - DeleteStatement: notifyListeners(Lde/susebox/jtopas/TokenizerPropertyEvent;)V
   * 8 Weak Mutation 430: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 4
   * 9 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I46 Branch 33 IFNONNULL L1227 - true
   * 10 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I62 Branch 34 IFNE L1229 - false
   * 11 Weak Mutation 343: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 342: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - InsertUnaryOp Negation
   * 13 Weak Mutation 341: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 340: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - ReplaceConstant - 1 -> 0
   * 15 Weak Mutation 339: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - ReplaceConstant - 1 -> 0
   * 16 Weak Mutation 338: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V:964 - DeleteStatement: addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V
   * 17 Weak Mutation 337: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V:964 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 336: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V:964 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 348: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - DeleteStatement: addProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 20 Weak Mutation 347: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 346: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - InsertUnaryOp IINC 1
   * 22 Weak Mutation 345: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - InsertUnaryOp Negation
   * 23 Weak Mutation 344: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;II)V:980 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 334: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V:964 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 335: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V:964 - InsertUnaryOp Negation
   * 26 Weak Mutation 332: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V:964 - InsertUnaryOp Negation
   * 27 Weak Mutation 333: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V:964 - InsertUnaryOp IINC 1
   * 28 Weak Mutation 330: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;)V:951 - DeleteStatement: getParseFlags()I
   * 29 Weak Mutation 331: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;)V:951 - DeleteStatement: addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V
   * 30 Weak Mutation 329: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;)V:938 - DeleteStatement: addKeyword(Ljava/lang/String;Ljava/lang/Object;)V
   * 31 Weak Mutation 330: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;)V:951 - DeleteStatement: getParseFlags()I
   * 32 Weak Mutation 331: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;)V:951 - DeleteStatement: addKeyword(Ljava/lang/String;Ljava/lang/Object;I)V
   * 33 Weak Mutation 329: de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;)V:938 - DeleteStatement: addKeyword(Ljava/lang/String;Ljava/lang/Object;)V
   * 34 Weak Mutation 425: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1229 - ReplaceComparisonOperator != -> ==
   * 35 Weak Mutation 424: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1229 - DeleteStatement: equals(Ljava/lang/Object;)Z
   * 36 Weak Mutation 427: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 1
   * 37 Weak Mutation 426: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 0
   * 38 Weak Mutation 429: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 2
   * 39 Weak Mutation 428: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> -1
   * 40 Weak Mutation 431: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - DeleteStatement: notifyListeners(Lde/susebox/jtopas/TokenizerPropertyEvent;)V
   * 41 Weak Mutation 430: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1230 - ReplaceConstant - 3 -> 4
   * 42 de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;Ljava/lang/Object;)V: root-Branch
   * 43 de.susebox.jtopas.AbstractTokenizerProperties.addKeyword(Ljava/lang/String;)V: root-Branch
   */
  @Test
  public void test38()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-6));
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addKeyword("!#-'*--/:-@H[-^`{-~");
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      standardTokenizerProperties0.addKeyword("!#-'*--/:-@H[-^`{-~", (Object) standardTokenizer0, (-2));
      assertEquals(true, standardTokenizerProperties0.hasKeywords());
  }
}
