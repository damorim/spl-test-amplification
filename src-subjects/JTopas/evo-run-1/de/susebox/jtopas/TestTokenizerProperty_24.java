/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.TokenizerProperty;

@RunWith(EvoSuiteRunner.class)
public class TestTokenizerProperty_24 {


  //Test case number: 24
  /*
   * 46 covered goals:
   * 1 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I178 Branch 29 IF_ICMPGE L444 - true
   * 2 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I185 Branch 30 IFNULL L445 - false
   * 3 Weak Mutation 0: de.susebox.jtopas.TokenizerProperty.setType(I)V:88 - InsertUnaryOp Negation
   * 4 Weak Mutation 1: de.susebox.jtopas.TokenizerProperty.setType(I)V:88 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 2: de.susebox.jtopas.TokenizerProperty.setType(I)V:88 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 3: de.susebox.jtopas.TokenizerProperty.getType()I:102 - InsertUnaryOp Negation
   * 7 Weak Mutation 4: de.susebox.jtopas.TokenizerProperty.getType()I:102 - InsertUnaryOp +1
   * 8 Weak Mutation 5: de.susebox.jtopas.TokenizerProperty.getType()I:102 - InsertUnaryOp -1
   * 9 Weak Mutation 6: de.susebox.jtopas.TokenizerProperty.getType()I:102 - DeleteField: _typeI
   * 10 Weak Mutation 14: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:138 - InsertUnaryOp Negation
   * 11 Weak Mutation 15: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:138 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 17: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:138 - InsertUnaryOp Negation
   * 13 Weak Mutation 16: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:138 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 19: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:138 - InsertUnaryOp IINC -1
   * 15 Weak Mutation 18: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:138 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 23: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:139 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 22: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:139 - InsertUnaryOp Negation
   * 18 Weak Mutation 24: de.susebox.jtopas.TokenizerProperty.setFlags(II)V:139 - InsertUnaryOp IINC -1
   * 19 Weak Mutation 69: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:332 - InsertUnaryOp Negation
   * 20 Weak Mutation 70: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:332 - InsertUnaryOp IINC 1
   * 21 Weak Mutation 71: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:332 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 76: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:335 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 77: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:335 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 78: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:335 - InsertUnaryOp Negation
   * 25 Weak Mutation 79: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:335 - InsertUnaryOp IINC 1
   * 26 Weak Mutation 72: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:332 - DeleteStatement: setType(I)V
   * 27 Weak Mutation 73: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:333 - DeleteStatement: setImages([Ljava/lang/String;)V
   * 28 Weak Mutation 74: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:334 - DeleteStatement: setCompanion(Ljava/lang/Object;)V
   * 29 Weak Mutation 75: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:335 - InsertUnaryOp Negation
   * 30 Weak Mutation 81: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:335 - DeleteStatement: setFlags(II)V
   * 31 Weak Mutation 80: de.susebox.jtopas.TokenizerProperty.<init>(I[Ljava/lang/String;Ljava/lang/Object;II)V:335 - InsertUnaryOp IINC -1
   * 32 Weak Mutation 119: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:395 - ReplaceConstant - 58 -> 0
   * 33 Weak Mutation 118: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:394 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 34 Weak Mutation 117: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:394 - DeleteStatement: getName()Ljava/lang/String;
   * 35 Weak Mutation 116: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:394 - DeleteStatement: getClass()Ljava/lang/Class;
   * 36 Weak Mutation 125: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:397 - DeleteStatement: getType()I
   * 37 Weak Mutation 124: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:395 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 38 Weak Mutation 123: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:395 - ReplaceConstant - 58 -> 59
   * 39 Weak Mutation 122: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:395 - ReplaceConstant - 58 -> 57
   * 40 Weak Mutation 121: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:395 - ReplaceConstant - 58 -> -1
   * 41 Weak Mutation 120: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:395 - ReplaceConstant - 58 -> 1
   * 42 Weak Mutation 129: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:402 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 43 Weak Mutation 128: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:402 - ReplaceConstant -  BLOCK_COMMENT,  -> 
   * 44 Weak Mutation 129: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:402 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 45 Weak Mutation 128: de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;:402 - ReplaceConstant -  BLOCK_COMMENT,  -> 
   * 46 de.susebox.jtopas.TokenizerProperty.toString()Ljava/lang/String;: I24 Branch 25 LOOKUPSWITCH L397 Case 8 - true
   */
  @Test
  public void test24()  throws Throwable  {
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(8);
      String[] stringArray0 = new String[1];
      stringArray0[0] = "a";
      tokenizerProperty0.setImages(stringArray0);
      String string0 = tokenizerProperty0.toString();
      assertNotNull(string0);
      assertEquals("de.susebox.jtopas.TokenizerProperty: BLOCK_COMMENT, flags/mask 0x0/0x0: a", tokenizerProperty0.toString());
      assertEquals("de.susebox.jtopas.TokenizerProperty: BLOCK_COMMENT, flags/mask 0x0/0x0: a", string0);
  }
}
