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
import de.susebox.jtopas.spi.DataProvider;
import de.susebox.jtopas.spi.StandardWhitespaceHandler;

@RunWith(EvoSuiteRunner.class)
public class TestStandardWhitespaceHandler_10 {


  //Test case number: 10
  /*
   * 112 covered goals:
   * 1 Weak Mutation 68: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:150 - ReplaceComparisonOperator >= -> ==
   * 2 Weak Mutation 76: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 77: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 75: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp Negation
   * 5 Weak Mutation 85: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> +
   * 6 Weak Mutation 84: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceConstant - 1 -> 0
   * 7 Weak Mutation 87: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> /
   * 8 Weak Mutation 86: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> %
   * 9 Weak Mutation 81: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp Negation
   * 10 Weak Mutation 80: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceComparisonOperator <= -> -1
   * 11 Weak Mutation 83: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 82: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 89: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - DeleteStatement: charAt(I)C
   * 14 Weak Mutation 88: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> *
   * 15 Weak Mutation 93: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 92: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 95: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 94: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp Negation
   * 19 Weak Mutation 91: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp Negation
   * 20 Weak Mutation 100: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> /
   * 21 Weak Mutation 101: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> *
   * 22 Weak Mutation 98: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> +
   * 23 Weak Mutation 99: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> %
   * 24 Weak Mutation 96: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 97: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceConstant - 1 -> 0
   * 26 Weak Mutation 110: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> %
   * 27 Weak Mutation 111: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> /
   * 28 Weak Mutation 108: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceConstant - 1 -> 0
   * 29 Weak Mutation 109: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> -
   * 30 Weak Mutation 106: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC 1
   * 31 Weak Mutation 107: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC -1
   * 32 Weak Mutation 104: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceComparisonOperator >= -> -1
   * 33 Weak Mutation 105: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp Negation
   * 34 Weak Mutation 113: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - DeleteStatement: charAt(I)C
   * 35 Weak Mutation 112: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> *
   * 36 Weak Mutation 119: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 0
   * 37 Weak Mutation 126: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - InsertUnaryOp IINC -1
   * 38 Weak Mutation 125: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - InsertUnaryOp IINC 1
   * 39 Weak Mutation 124: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - InsertUnaryOp Negation
   * 40 Weak Mutation 123: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 11
   * 41 Weak Mutation 122: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 9
   * 42 Weak Mutation 121: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> -1
   * 43 Weak Mutation 120: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 1
   * 44 Weak Mutation 128: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceComparisonOperator < -> -2
   * 45 Weak Mutation 143: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 1
   * 46 Weak Mutation 142: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 0
   * 47 Weak Mutation 144: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> -1
   * 48 Weak Mutation 145: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 12
   * 49 Weak Mutation 146: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 14
   * 50 Weak Mutation 147: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - InsertUnaryOp Negation
   * 51 Weak Mutation 148: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - InsertUnaryOp IINC 1
   * 52 Weak Mutation 149: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - InsertUnaryOp IINC -1
   * 53 Weak Mutation 151: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceComparisonOperator < -> -2
   * 54 de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z: I34 Branch 14 LOOKUPSWITCH L151 Case 45 - true
   * 55 de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z: I34 Branch 16 LOOKUPSWITCH L151 Default-Case - false
   * 56 de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z: I38 Branch 17 IFLE L153 - false
   * 57 de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z: I55 Branch 18 IF_ICMPGE L154 - false
   * 58 de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z: I70 Branch 19 IF_ICMPLT L155 - true
   * 59 de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z: I82 Branch 21 IF_ICMPLT L158 - true
   * 60 Weak Mutation 68: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:150 - ReplaceComparisonOperator >= -> ==
   * 61 Weak Mutation 76: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC 1
   * 62 Weak Mutation 77: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC -1
   * 63 Weak Mutation 75: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp Negation
   * 64 Weak Mutation 85: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> +
   * 65 Weak Mutation 84: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceConstant - 1 -> 0
   * 66 Weak Mutation 87: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> /
   * 67 Weak Mutation 86: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> %
   * 68 Weak Mutation 81: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp Negation
   * 69 Weak Mutation 80: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceComparisonOperator <= -> -1
   * 70 Weak Mutation 83: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC -1
   * 71 Weak Mutation 82: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - InsertUnaryOp IINC 1
   * 72 Weak Mutation 93: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC -1
   * 73 Weak Mutation 92: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC 1
   * 74 Weak Mutation 95: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC 1
   * 75 Weak Mutation 94: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp Negation
   * 76 Weak Mutation 89: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - DeleteStatement: charAt(I)C
   * 77 Weak Mutation 88: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:153 - ReplaceArithmeticOperator - -> *
   * 78 Weak Mutation 91: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp Negation
   * 79 Weak Mutation 100: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> /
   * 80 Weak Mutation 101: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> *
   * 81 Weak Mutation 98: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> +
   * 82 Weak Mutation 99: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator - -> %
   * 83 Weak Mutation 96: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC -1
   * 84 Weak Mutation 97: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceConstant - 1 -> 0
   * 85 Weak Mutation 110: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> %
   * 86 Weak Mutation 111: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> /
   * 87 Weak Mutation 108: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceConstant - 1 -> 0
   * 88 Weak Mutation 109: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> -
   * 89 Weak Mutation 106: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC 1
   * 90 Weak Mutation 107: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp IINC -1
   * 91 Weak Mutation 104: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceComparisonOperator >= -> -1
   * 92 Weak Mutation 105: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - InsertUnaryOp Negation
   * 93 Weak Mutation 119: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 0
   * 94 Weak Mutation 113: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - DeleteStatement: charAt(I)C
   * 95 Weak Mutation 112: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:154 - ReplaceArithmeticOperator + -> *
   * 96 Weak Mutation 126: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - InsertUnaryOp IINC -1
   * 97 Weak Mutation 125: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - InsertUnaryOp IINC 1
   * 98 Weak Mutation 124: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - InsertUnaryOp Negation
   * 99 Weak Mutation 123: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 11
   * 100 Weak Mutation 122: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 9
   * 101 Weak Mutation 121: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> -1
   * 102 Weak Mutation 120: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceConstant - 10 -> 1
   * 103 Weak Mutation 143: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 1
   * 104 Weak Mutation 142: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 0
   * 105 Weak Mutation 128: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:155 - ReplaceComparisonOperator < -> -2
   * 106 Weak Mutation 144: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> -1
   * 107 Weak Mutation 145: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 12
   * 108 Weak Mutation 146: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceConstant - 13 -> 14
   * 109 Weak Mutation 147: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - InsertUnaryOp Negation
   * 110 Weak Mutation 148: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - InsertUnaryOp IINC 1
   * 111 Weak Mutation 149: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - InsertUnaryOp IINC -1
   * 112 Weak Mutation 151: de.susebox.jtopas.spi.StandardWhitespaceHandler.newlineIsWhitespace(Ljava/lang/String;)Z:158 - ReplaceComparisonOperator < -> -2
   */
  @Test
  public void test10()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(127, "!#-/:-@[-^`{-~", "!#-/:-@[-^`{-~");
      StandardWhitespaceHandler standardWhitespaceHandler0 = new StandardWhitespaceHandler((TokenizerProperties) standardTokenizerProperties0);
      boolean boolean0 = standardWhitespaceHandler0.newlineIsWhitespace();
      assertEquals(false, boolean0);
  }
}
