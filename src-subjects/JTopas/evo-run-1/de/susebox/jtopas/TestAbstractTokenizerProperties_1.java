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
public class TestAbstractTokenizerProperties_1 {


  //Test case number: 1
  /*
   * 53 covered goals:
   * 1 Weak Mutation 68: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - ReplaceComparisonOperator != -> <
   * 2 Weak Mutation 71: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 754: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1550 - ReplaceComparisonOperator > -> !=
   * 4 Weak Mutation 762: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp Negation
   * 5 Weak Mutation 763: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 760: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 2
   * 7 Weak Mutation 761: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 4
   * 8 Weak Mutation 766: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 0 -> 1
   * 9 Weak Mutation 767: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp Negation
   * 10 Weak Mutation 764: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 765: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 1 -> 0
   * 12 Weak Mutation 758: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 1
   * 13 Weak Mutation 759: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> -1
   * 14 Weak Mutation 757: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 0
   * 15 Weak Mutation 772: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - DeleteStatement: notifyListeners(Lde/susebox/jtopas/TokenizerPropertyEvent;)V
   * 16 Weak Mutation 770: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 1 -> 0
   * 17 Weak Mutation 771: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 768: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 769: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC -1
   * 20 de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z: I7 Branch 2 IF_ICMPNE L225 - true
   * 21 de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V: I35 Branch 73 IFGT L1550 - false
   * 22 Weak Mutation 22: de.susebox.jtopas.AbstractTokenizerProperties.setParseFlags(I)V:194 - ReplaceComparisonOperator == -> -2
   * 23 Weak Mutation 55: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp Negation
   * 24 Weak Mutation 59: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp Negation
   * 25 Weak Mutation 57: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp -1
   * 26 Weak Mutation 56: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp +1
   * 27 Weak Mutation 63: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - ReplaceBitwiseOperator & -> ^
   * 28 Weak Mutation 62: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - ReplaceBitwiseOperator & -> |
   * 29 Weak Mutation 61: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp IINC -1
   * 30 Weak Mutation 60: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp IINC 1
   * 31 Weak Mutation 68: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - ReplaceComparisonOperator != -> <
   * 32 Weak Mutation 71: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - ReplaceConstant - 0 -> 1
   * 33 Weak Mutation 64: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp Negation
   * 34 Weak Mutation 65: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp IINC 1
   * 35 Weak Mutation 66: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - InsertUnaryOp IINC -1
   * 36 Weak Mutation 762: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp Negation
   * 37 Weak Mutation 763: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC 1
   * 38 Weak Mutation 760: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 2
   * 39 Weak Mutation 761: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 4
   * 40 Weak Mutation 766: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 0 -> 1
   * 41 Weak Mutation 767: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp Negation
   * 42 Weak Mutation 764: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC -1
   * 43 Weak Mutation 765: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 1 -> 0
   * 44 Weak Mutation 754: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1550 - ReplaceComparisonOperator > -> !=
   * 45 Weak Mutation 758: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 1
   * 46 Weak Mutation 759: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> -1
   * 47 Weak Mutation 757: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 3 -> 0
   * 48 Weak Mutation 772: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - DeleteStatement: notifyListeners(Lde/susebox/jtopas/TokenizerPropertyEvent;)V
   * 49 Weak Mutation 770: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 1 -> 0
   * 50 Weak Mutation 771: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - ReplaceConstant - 0 -> 1
   * 51 Weak Mutation 768: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC 1
   * 52 Weak Mutation 769: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1551 - InsertUnaryOp IINC -1
   * 53 de.susebox.jtopas.AbstractTokenizerProperties.setParseFlags(I)V: I28 Branch 1 IF_ICMPEQ L194 - true
   */
  @Test
  public void test1()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(0, "!#-%'-/:=-@[-^{-~", "!#-%'-/:=-@[-^{-~");
      assertNotNull(standardTokenizerProperties0);
      
      boolean boolean0 = standardTokenizerProperties0.isFlagSet((-2));
      assertEquals("!#-%'-/:=-@[-^{-~", standardTokenizerProperties0.getSeparators());
      assertEquals(0, standardTokenizerProperties0.getParseFlags());
      assertEquals(false, boolean0);
      assertEquals("!#-%'-/:=-@[-^{-~", standardTokenizerProperties0.getWhitespaces());
  }
}