/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizerProperties;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizerProperties_11 {


  //Test case number: 11
  /*
   * 60 covered goals:
   * 1 Weak Mutation 183: de.susebox.jtopas.AbstractTokenizerProperties.getStringCompanion(Ljava/lang/String;)Ljava/lang/Object;:481 - DeleteStatement: getCompanion()Ljava/lang/Object;
   * 2 Weak Mutation 196: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;)V:535 - DeleteStatement: addLineComment(Ljava/lang/String;Ljava/lang/Object;)V
   * 3 Weak Mutation 197: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;)V:547 - DeleteStatement: getParseFlags()I
   * 4 Weak Mutation 198: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;)V:547 - DeleteStatement: addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V
   * 5 Weak Mutation 205: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - DeleteStatement: addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V
   * 6 Weak Mutation 204: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 201: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC -1
   * 8 Weak Mutation 200: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 203: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC 1
   * 10 Weak Mutation 202: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp Negation
   * 11 Weak Mutation 199: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp Negation
   * 12 Weak Mutation 207: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 1
   * 13 Weak Mutation 206: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 0
   * 14 Weak Mutation 216: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp Negation
   * 15 Weak Mutation 217: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 218: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 219: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - DeleteStatement: addProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 18 Weak Mutation 212: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 0 -> 1
   * 19 Weak Mutation 213: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp Negation
   * 20 Weak Mutation 214: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC 1
   * 21 Weak Mutation 215: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 208: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> -1
   * 23 Weak Mutation 209: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 6
   * 24 Weak Mutation 210: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 8
   * 25 Weak Mutation 211: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 1 -> 0
   * 26 de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V: root-Branch
   * 27 de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;)V: root-Branch
   * 28 de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V: root-Branch
   * 29 de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;)V: root-Branch
   * 30 de.susebox.jtopas.AbstractTokenizerProperties.getStringCompanion(Ljava/lang/String;)Ljava/lang/Object;: I9 Branch 12 IFNULL L480 - false
   * 31 Weak Mutation 182: de.susebox.jtopas.AbstractTokenizerProperties.getStringCompanion(Ljava/lang/String;)Ljava/lang/Object;:480 - ReplaceComparisonOperator = null -> != null
   * 32 Weak Mutation 181: de.susebox.jtopas.AbstractTokenizerProperties.getStringCompanion(Ljava/lang/String;)Ljava/lang/Object;:478 - DeleteStatement: getString(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 33 Weak Mutation 182: de.susebox.jtopas.AbstractTokenizerProperties.getStringCompanion(Ljava/lang/String;)Ljava/lang/Object;:480 - ReplaceComparisonOperator = null -> != null
   * 34 Weak Mutation 183: de.susebox.jtopas.AbstractTokenizerProperties.getStringCompanion(Ljava/lang/String;)Ljava/lang/Object;:481 - DeleteStatement: getCompanion()Ljava/lang/Object;
   * 35 Weak Mutation 181: de.susebox.jtopas.AbstractTokenizerProperties.getStringCompanion(Ljava/lang/String;)Ljava/lang/Object;:478 - DeleteStatement: getString(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 36 Weak Mutation 205: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - DeleteStatement: addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V
   * 37 Weak Mutation 204: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC -1
   * 38 Weak Mutation 207: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 1
   * 39 Weak Mutation 206: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 0
   * 40 Weak Mutation 201: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC -1
   * 41 Weak Mutation 200: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC 1
   * 42 Weak Mutation 203: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp IINC 1
   * 43 Weak Mutation 202: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp Negation
   * 44 Weak Mutation 197: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;)V:547 - DeleteStatement: getParseFlags()I
   * 45 Weak Mutation 196: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;)V:535 - DeleteStatement: addLineComment(Ljava/lang/String;Ljava/lang/Object;)V
   * 46 Weak Mutation 199: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V:562 - InsertUnaryOp Negation
   * 47 Weak Mutation 198: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;)V:547 - DeleteStatement: addLineComment(Ljava/lang/String;Ljava/lang/Object;I)V
   * 48 Weak Mutation 216: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp Negation
   * 49 Weak Mutation 217: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC 1
   * 50 Weak Mutation 218: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC -1
   * 51 Weak Mutation 219: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - DeleteStatement: addProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 52 Weak Mutation 212: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 0 -> 1
   * 53 Weak Mutation 213: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp Negation
   * 54 Weak Mutation 214: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC 1
   * 55 Weak Mutation 215: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - InsertUnaryOp IINC -1
   * 56 Weak Mutation 208: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> -1
   * 57 Weak Mutation 209: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 6
   * 58 Weak Mutation 210: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 7 -> 8
   * 59 Weak Mutation 211: de.susebox.jtopas.AbstractTokenizerProperties.addLineComment(Ljava/lang/String;Ljava/lang/Object;II)V:578 - ReplaceConstant - 1 -> 0
   * 60 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I14 Branch 31 LOOKUPSWITCH L1216 Default-Case - true
   */
  @Test
  public void test11()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(58, ":*NDW),^F:$*`|poS", ":*NDW),^F:$*`|poS");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addLineComment("/*");
      standardTokenizerProperties0.getStringCompanion("/*");
      assertEquals(true, standardTokenizerProperties0.hasSequenceCommentOrString());
      assertEquals(58, standardTokenizerProperties0.getParseFlags());
  }
}