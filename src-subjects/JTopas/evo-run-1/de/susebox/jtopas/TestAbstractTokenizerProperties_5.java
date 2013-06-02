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
public class TestAbstractTokenizerProperties_5 {


  //Test case number: 5
  /*
   * 43 covered goals:
   * 1 Weak Mutation 109: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:304 - ReplaceComparisonOperator <= -> -1
   * 2 Weak Mutation 110: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:305 - DeleteStatement: getWhitespaces()Ljava/lang/String;
   * 3 Weak Mutation 111: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:305 - ReplaceConstant - 1 -> 0
   * 4 Weak Mutation 112: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:305 - DeleteStatement: setWhitespaces(Ljava/lang/String;)V
   * 5 Weak Mutation 620: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1449 - ReplaceComparisonOperator <= -> <
   * 6 Weak Mutation 743: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1544 - ReplaceComparisonOperator <= -> <
   * 7 Weak Mutation 774: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1557 - DeleteStatement: length()I
   * 8 Weak Mutation 773: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1557 - ReplaceComparisonOperator = null -> != null
   * 9 Weak Mutation 777: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1557 - ReplaceComparisonOperator <= -> -1
   * 10 Weak Mutation 786: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 0 -> 1
   * 11 Weak Mutation 785: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 1 -> 0
   * 12 Weak Mutation 784: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 782: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - InsertUnaryOp Negation
   * 14 Weak Mutation 783: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 780: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> -1
   * 16 Weak Mutation 781: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> 3
   * 17 Weak Mutation 778: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> 0
   * 18 Weak Mutation 779: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> 1
   * 19 de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V: I4 Branch 6 IFLE L304 - false
   * 20 de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V: I135 Branch 51 IFEQ L1376 - false
   * 21 de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;: I35 Branch 59 IFLE L1449 - true
   * 22 de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V: I6 Branch 71 IFLE L1544 - true
   * 23 de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V: I68 Branch 74 IFNULL L1557 - false
   * 24 de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V: I71 Branch 75 IFLE L1557 - false
   * 25 Weak Mutation 106: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:304 - DeleteStatement: length()I
   * 26 Weak Mutation 110: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:305 - DeleteStatement: getWhitespaces()Ljava/lang/String;
   * 27 Weak Mutation 111: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:305 - ReplaceConstant - 1 -> 0
   * 28 Weak Mutation 109: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:304 - ReplaceComparisonOperator <= -> -1
   * 29 Weak Mutation 112: de.susebox.jtopas.AbstractTokenizerProperties.removeWhitespaces(Ljava/lang/String;)V:305 - DeleteStatement: setWhitespaces(Ljava/lang/String;)V
   * 30 Weak Mutation 620: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1449 - ReplaceComparisonOperator <= -> <
   * 31 Weak Mutation 743: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1544 - ReplaceComparisonOperator <= -> <
   * 32 Weak Mutation 786: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 0 -> 1
   * 33 Weak Mutation 785: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 1 -> 0
   * 34 Weak Mutation 784: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - InsertUnaryOp IINC -1
   * 35 Weak Mutation 774: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1557 - DeleteStatement: length()I
   * 36 Weak Mutation 773: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1557 - ReplaceComparisonOperator = null -> != null
   * 37 Weak Mutation 782: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - InsertUnaryOp Negation
   * 38 Weak Mutation 783: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - InsertUnaryOp IINC 1
   * 39 Weak Mutation 780: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> -1
   * 40 Weak Mutation 781: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> 3
   * 41 Weak Mutation 778: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> 0
   * 42 Weak Mutation 779: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1558 - ReplaceConstant - 2 -> 1
   * 43 Weak Mutation 777: de.susebox.jtopas.AbstractTokenizerProperties.handleEvent(ILjava/lang/String;Ljava/lang/String;)V:1557 - ReplaceComparisonOperator <= -> -1
   */
  @Test
  public void test5()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-2), "*+xl9W1w.Lp<pw9GX1", "*+xl9W1w.Lp<pw9GX1");
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.removeWhitespaces("*+xl9W1w.Lp<pw9GX1");
      assertEquals("", standardTokenizerProperties0.getWhitespaces());
      assertEquals("*+xl9W1w.Lp<pw9GX1", standardTokenizerProperties0.getSeparators());
  }
}
