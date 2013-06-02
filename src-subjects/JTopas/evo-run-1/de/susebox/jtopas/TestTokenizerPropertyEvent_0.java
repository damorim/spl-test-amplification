/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.TokenizerPropertyEvent;

@RunWith(EvoSuiteRunner.class)
public class TestTokenizerPropertyEvent_0 {


  //Test case number: 0
  /*
   * 38 covered goals:
   * 1 Weak Mutation 68: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:237 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 2 Weak Mutation 67: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:237 - ReplaceConstant - <unknown type>  -> 
   * 3 de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;: I24 Branch 14 TABLESWITCH L226 Default-Case - true
   * 4 Weak Mutation 0: de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V:251 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 1: de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V:95 - InsertUnaryOp Negation
   * 6 Weak Mutation 2: de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V:95 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 3: de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V:95 - InsertUnaryOp IINC -1
   * 8 Weak Mutation 4: de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V:95 - DeleteStatement: setType(I)V
   * 9 Weak Mutation 5: de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V:96 - DeleteStatement: setProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 10 Weak Mutation 6: de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V:97 - DeleteStatement: setOldProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 11 Weak Mutation 14: de.susebox.jtopas.TokenizerPropertyEvent.setType(I)V:129 - InsertUnaryOp Negation
   * 12 Weak Mutation 15: de.susebox.jtopas.TokenizerPropertyEvent.setType(I)V:129 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 16: de.susebox.jtopas.TokenizerPropertyEvent.setType(I)V:129 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 55: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:224 - ReplaceConstant - :  -> 
   * 15 Weak Mutation 54: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:223 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 16 Weak Mutation 53: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:223 - DeleteStatement: getName()Ljava/lang/String;
   * 17 Weak Mutation 52: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:223 - DeleteStatement: getClass()Ljava/lang/Class;
   * 18 Weak Mutation 59: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:226 - InsertUnaryOp -1
   * 19 Weak Mutation 58: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:226 - InsertUnaryOp +1
   * 20 Weak Mutation 57: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:226 - InsertUnaryOp Negation
   * 21 Weak Mutation 56: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:224 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 22 Weak Mutation 60: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:226 - DeleteField: _typeI
   * 23 Weak Mutation 68: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:237 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 24 Weak Mutation 69: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:240 - DeleteStatement: getProperty()Lde/susebox/jtopas/TokenizerProperty;
   * 25 Weak Mutation 70: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:240 - ReplaceComparisonOperator = null -> != null
   * 26 Weak Mutation 67: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:237 - ReplaceConstant - <unknown type>  -> 
   * 27 Weak Mutation 76: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:245 - DeleteStatement: toString()Ljava/lang/String;
   * 28 Weak Mutation 74: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:243 - ReplaceConstant - <no property> -> 
   * 29 Weak Mutation 75: de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;:243 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 30 de.susebox.jtopas.TokenizerPropertyEvent.setOldProperty(Lde/susebox/jtopas/TokenizerProperty;)V: root-Branch
   * 31 de.susebox.jtopas.TokenizerPropertyEvent.getProperty()Lde/susebox/jtopas/TokenizerProperty;: root-Branch
   * 32 de.susebox.jtopas.TokenizerPropertyEvent.setProperty(Lde/susebox/jtopas/TokenizerProperty;)V: root-Branch
   * 33 de.susebox.jtopas.TokenizerPropertyEvent.<init>(ILde/susebox/jtopas/TokenizerProperty;)V: root-Branch
   * 34 de.susebox.jtopas.TokenizerPropertyEvent.setType(I)V: root-Branch
   * 35 de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;: I24 Branch 11 TABLESWITCH L226 Case 1 - false
   * 36 de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;: I24 Branch 12 TABLESWITCH L226 Case 2 - false
   * 37 de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;: I24 Branch 13 TABLESWITCH L226 Case 3 - false
   * 38 de.susebox.jtopas.TokenizerPropertyEvent.toString()Ljava/lang/String;: I62 Branch 15 IFNULL L240 - true
   */
  @Test
  public void test0()  throws Throwable  {
      TokenizerPropertyEvent tokenizerPropertyEvent0 = new TokenizerPropertyEvent(7, (TokenizerProperty) null);
      String string0 = tokenizerPropertyEvent0.toString();
      assertEquals("de.susebox.jtopas.TokenizerPropertyEvent: <unknown type> <no property>", string0);
      assertNotNull(string0);
      assertEquals(7, tokenizerPropertyEvent0.getType());
  }
}
