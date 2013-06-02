/*
 * This file was automatically generated by EvoSuite
 */

package smashed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import smashed.TreeGenerator;

@RunWith(EvoSuiteRunner.class)
public class TestTreeGenerator {


  //Test case number: 0
  /*
   * 19 covered goals:
   * 1 Weak Mutation 0: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp Negation
   * 2 Weak Mutation 1: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 2: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 3: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 0
   * 5 Weak Mutation 4: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 1
   * 6 Weak Mutation 5: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> -1
   * 7 Weak Mutation 6: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 3
   * 8 Weak Mutation 7: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 5
   * 9 Weak Mutation 8: smashed.TreeGenerator.processNode(II)V:16 - ReplaceComparisonOperator >= -> ==
   * 10 smashed.TreeGenerator.processNode(II)V: I4 Branch 1 IF_ICMPGE L16 - true
   * 11 Weak Mutation 0: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp Negation
   * 12 Weak Mutation 1: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 2: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 3: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 0
   * 15 Weak Mutation 4: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 1
   * 16 Weak Mutation 5: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> -1
   * 17 Weak Mutation 6: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 3
   * 18 Weak Mutation 7: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 5
   * 19 Weak Mutation 8: smashed.TreeGenerator.processNode(II)V:16 - ReplaceComparisonOperator >= -> ==
   */
  @Test
  public void test0()  throws Throwable  {
      TreeGenerator.processNode((-111), 19265);
  }

  //Test case number: 1
  /*
   * 127 covered goals:
   * 1 Weak Mutation 9: smashed.TreeGenerator.processNode(II)V:16 - ReplaceComparisonOperator >= -> >
   * 2 Weak Mutation 10: smashed.TreeGenerator.processNode(II)V:16 - ReplaceComparisonOperator >= -> -1
   * 3 Weak Mutation 11: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 12: smashed.TreeGenerator.processNode(II)V:18 - InsertUnaryOp Negation
   * 5 Weak Mutation 13: smashed.TreeGenerator.processNode(II)V:18 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 14: smashed.TreeGenerator.processNode(II)V:18 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 15: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 0
   * 8 Weak Mutation 17: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> -1
   * 9 Weak Mutation 16: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 1
   * 10 Weak Mutation 19: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 5
   * 11 Weak Mutation 18: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 3
   * 12 Weak Mutation 21: smashed.TreeGenerator.processNode(II)V:18 - ReplaceComparisonOperator >= -> >
   * 13 Weak Mutation 22: smashed.TreeGenerator.processNode(II)V:18 - ReplaceComparisonOperator >= -> -1
   * 14 Weak Mutation 23: smashed.TreeGenerator.processNode(II)V:20 - InsertUnaryOp Negation
   * 15 Weak Mutation 25: smashed.TreeGenerator.processNode(II)V:20 - InsertUnaryOp -1
   * 16 Weak Mutation 24: smashed.TreeGenerator.processNode(II)V:20 - InsertUnaryOp +1
   * 17 Weak Mutation 27: smashed.TreeGenerator.processNode(II)V:20 - ReplaceConstant - 1 -> 0
   * 18 Weak Mutation 26: smashed.TreeGenerator.processNode(II)V:20 - DeleteField: nodeCountI
   * 19 Weak Mutation 29: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> %
   * 20 Weak Mutation 28: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> -
   * 21 Weak Mutation 31: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> *
   * 22 Weak Mutation 30: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> /
   * 23 Weak Mutation 34: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp Negation
   * 24 Weak Mutation 35: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC 1
   * 25 Weak Mutation 32: smashed.TreeGenerator.processNode(II)V:21 - DeleteField: strLjava/lang/String;
   * 26 Weak Mutation 33: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 27 Weak Mutation 38: smashed.TreeGenerator.processNode(II)V:21 - ReplaceConstant -   -> 
   * 28 Weak Mutation 39: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 29 Weak Mutation 36: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC -1
   * 30 Weak Mutation 37: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 31 Weak Mutation 42: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC -1
   * 32 Weak Mutation 43: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 33 Weak Mutation 40: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp Negation
   * 34 Weak Mutation 41: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC 1
   * 35 Weak Mutation 46: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: toString()Ljava/lang/String;
   * 36 Weak Mutation 44: smashed.TreeGenerator.processNode(II)V:21 - ReplaceConstant - 
 -> 
   * 37 Weak Mutation 45: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 38 Weak Mutation 47: smashed.TreeGenerator.processNode(II)V:22 - InsertUnaryOp Negation
   * 39 Weak Mutation 51: smashed.TreeGenerator.processNode(II)V:22 - ReplaceConstant - 1 -> 0
   * 40 Weak Mutation 50: smashed.TreeGenerator.processNode(II)V:22 - DeleteField: edgeCountI
   * 41 Weak Mutation 49: smashed.TreeGenerator.processNode(II)V:22 - InsertUnaryOp -1
   * 42 Weak Mutation 48: smashed.TreeGenerator.processNode(II)V:22 - InsertUnaryOp +1
   * 43 Weak Mutation 55: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> *
   * 44 Weak Mutation 54: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> /
   * 45 Weak Mutation 53: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> %
   * 46 Weak Mutation 52: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> -
   * 47 Weak Mutation 59: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp Negation
   * 48 Weak Mutation 58: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC -1
   * 49 Weak Mutation 57: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC 1
   * 50 Weak Mutation 56: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp Negation
   * 51 Weak Mutation 63: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> -
   * 52 Weak Mutation 62: smashed.TreeGenerator.processNode(II)V:23 - ReplaceConstant - 1 -> 0
   * 53 Weak Mutation 61: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC -1
   * 54 Weak Mutation 60: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC 1
   * 55 Weak Mutation 64: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> %
   * 56 Weak Mutation 65: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> /
   * 57 Weak Mutation 66: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> *
   * 58 Weak Mutation 67: smashed.TreeGenerator.processNode(II)V:23 - DeleteStatement: processNode(II)V
   * 59 smashed.TreeGenerator.processNode(II)V: I4 Branch 1 IF_ICMPGE L16 - false
   * 60 smashed.TreeGenerator.processNode(II)V: I12 Branch 2 IF_ICMPGE L18 - true
   * 61 smashed.TreeGenerator.processNode(II)V: I12 Branch 2 IF_ICMPGE L18 - false
   * 62 Weak Mutation 0: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp Negation
   * 63 Weak Mutation 1: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp IINC 1
   * 64 Weak Mutation 2: smashed.TreeGenerator.processNode(II)V:16 - InsertUnaryOp IINC -1
   * 65 Weak Mutation 3: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 0
   * 66 Weak Mutation 4: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 1
   * 67 Weak Mutation 5: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> -1
   * 68 Weak Mutation 6: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 3
   * 69 Weak Mutation 7: smashed.TreeGenerator.processNode(II)V:16 - ReplaceConstant - 4 -> 5
   * 70 Weak Mutation 9: smashed.TreeGenerator.processNode(II)V:16 - ReplaceComparisonOperator >= -> >
   * 71 Weak Mutation 10: smashed.TreeGenerator.processNode(II)V:16 - ReplaceComparisonOperator >= -> -1
   * 72 Weak Mutation 11: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 0 -> 1
   * 73 Weak Mutation 12: smashed.TreeGenerator.processNode(II)V:18 - InsertUnaryOp Negation
   * 74 Weak Mutation 13: smashed.TreeGenerator.processNode(II)V:18 - InsertUnaryOp IINC 1
   * 75 Weak Mutation 14: smashed.TreeGenerator.processNode(II)V:18 - InsertUnaryOp IINC -1
   * 76 Weak Mutation 15: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 0
   * 77 Weak Mutation 17: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> -1
   * 78 Weak Mutation 16: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 1
   * 79 Weak Mutation 19: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 5
   * 80 Weak Mutation 18: smashed.TreeGenerator.processNode(II)V:18 - ReplaceConstant - 4 -> 3
   * 81 Weak Mutation 21: smashed.TreeGenerator.processNode(II)V:18 - ReplaceComparisonOperator >= -> >
   * 82 Weak Mutation 23: smashed.TreeGenerator.processNode(II)V:20 - InsertUnaryOp Negation
   * 83 Weak Mutation 22: smashed.TreeGenerator.processNode(II)V:18 - ReplaceComparisonOperator >= -> -1
   * 84 Weak Mutation 25: smashed.TreeGenerator.processNode(II)V:20 - InsertUnaryOp -1
   * 85 Weak Mutation 24: smashed.TreeGenerator.processNode(II)V:20 - InsertUnaryOp +1
   * 86 Weak Mutation 27: smashed.TreeGenerator.processNode(II)V:20 - ReplaceConstant - 1 -> 0
   * 87 Weak Mutation 26: smashed.TreeGenerator.processNode(II)V:20 - DeleteField: nodeCountI
   * 88 Weak Mutation 29: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> %
   * 89 Weak Mutation 28: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> -
   * 90 Weak Mutation 31: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> *
   * 91 Weak Mutation 30: smashed.TreeGenerator.processNode(II)V:20 - ReplaceArithmeticOperator + -> /
   * 92 Weak Mutation 34: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp Negation
   * 93 Weak Mutation 35: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC 1
   * 94 Weak Mutation 32: smashed.TreeGenerator.processNode(II)V:21 - DeleteField: strLjava/lang/String;
   * 95 Weak Mutation 33: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 96 Weak Mutation 38: smashed.TreeGenerator.processNode(II)V:21 - ReplaceConstant -   -> 
   * 97 Weak Mutation 39: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 98 Weak Mutation 36: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC -1
   * 99 Weak Mutation 37: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 100 Weak Mutation 42: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC -1
   * 101 Weak Mutation 43: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 102 Weak Mutation 40: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp Negation
   * 103 Weak Mutation 41: smashed.TreeGenerator.processNode(II)V:21 - InsertUnaryOp IINC 1
   * 104 Weak Mutation 46: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: toString()Ljava/lang/String;
   * 105 Weak Mutation 47: smashed.TreeGenerator.processNode(II)V:22 - InsertUnaryOp Negation
   * 106 Weak Mutation 44: smashed.TreeGenerator.processNode(II)V:21 - ReplaceConstant - 
 -> 
   * 107 Weak Mutation 45: smashed.TreeGenerator.processNode(II)V:21 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 108 Weak Mutation 51: smashed.TreeGenerator.processNode(II)V:22 - ReplaceConstant - 1 -> 0
   * 109 Weak Mutation 50: smashed.TreeGenerator.processNode(II)V:22 - DeleteField: edgeCountI
   * 110 Weak Mutation 49: smashed.TreeGenerator.processNode(II)V:22 - InsertUnaryOp -1
   * 111 Weak Mutation 48: smashed.TreeGenerator.processNode(II)V:22 - InsertUnaryOp +1
   * 112 Weak Mutation 55: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> *
   * 113 Weak Mutation 54: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> /
   * 114 Weak Mutation 53: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> %
   * 115 Weak Mutation 52: smashed.TreeGenerator.processNode(II)V:22 - ReplaceArithmeticOperator + -> -
   * 116 Weak Mutation 59: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp Negation
   * 117 Weak Mutation 58: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC -1
   * 118 Weak Mutation 57: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC 1
   * 119 Weak Mutation 56: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp Negation
   * 120 Weak Mutation 63: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> -
   * 121 Weak Mutation 62: smashed.TreeGenerator.processNode(II)V:23 - ReplaceConstant - 1 -> 0
   * 122 Weak Mutation 61: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC -1
   * 123 Weak Mutation 60: smashed.TreeGenerator.processNode(II)V:23 - InsertUnaryOp IINC 1
   * 124 Weak Mutation 64: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> %
   * 125 Weak Mutation 65: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> /
   * 126 Weak Mutation 66: smashed.TreeGenerator.processNode(II)V:23 - ReplaceArithmeticOperator + -> *
   * 127 Weak Mutation 67: smashed.TreeGenerator.processNode(II)V:23 - DeleteStatement: processNode(II)V
   */
  @Test
  public void test1()  throws Throwable  {
      TreeGenerator.processNode(0, 1);
  }
}