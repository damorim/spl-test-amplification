/*
 * This file was automatically generated by EvoSuite
 */

package smashed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import smashed.NetworkGenerator;

@RunWith(EvoSuiteRunner.class)
public class TestNetworkGenerator_0 {


  //Test case number: 0
  /*
   * 190 covered goals:
   * 1 Weak Mutation 0: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp Negation
   * 2 Weak Mutation 1: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 2: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 3: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp Negation
   * 5 Weak Mutation 4: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 5: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 6: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> -
   * 8 Weak Mutation 7: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> %
   * 9 Weak Mutation 8: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> /
   * 10 Weak Mutation 9: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> *
   * 11 Weak Mutation 10: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceConstant - 1 -> 0
   * 12 Weak Mutation 11: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> -
   * 13 Weak Mutation 12: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> %
   * 14 Weak Mutation 13: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> /
   * 15 Weak Mutation 14: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> *
   * 16 Weak Mutation 15: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - ReplaceConstant - 0 -> 1
   * 17 Weak Mutation 17: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 16: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp Negation
   * 19 Weak Mutation 19: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp Negation
   * 20 Weak Mutation 18: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 21: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 20: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 23: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - ReplaceComparisonOperator >= -> >
   * 24 Weak Mutation 24: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - ReplaceComparisonOperator >= -> -1
   * 25 Weak Mutation 25: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp Negation
   * 26 Weak Mutation 27: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC -1
   * 27 Weak Mutation 26: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC 1
   * 28 Weak Mutation 29: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC 1
   * 29 Weak Mutation 28: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp Negation
   * 30 Weak Mutation 31: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> -
   * 31 Weak Mutation 30: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC -1
   * 32 Weak Mutation 34: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> *
   * 33 Weak Mutation 35: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceConstant - 1 -> 0
   * 34 Weak Mutation 32: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> %
   * 35 Weak Mutation 33: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> /
   * 36 Weak Mutation 38: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> /
   * 37 Weak Mutation 39: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> *
   * 38 Weak Mutation 36: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> -
   * 39 Weak Mutation 37: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> %
   * 40 Weak Mutation 42: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC 1
   * 41 Weak Mutation 43: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC -1
   * 42 Weak Mutation 40: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 43 Weak Mutation 41: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp Negation
   * 44 Weak Mutation 46: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 45 Weak Mutation 47: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp Negation
   * 46 Weak Mutation 44: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 47 Weak Mutation 45: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - ReplaceConstant -   -> 
   * 48 Weak Mutation 51: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - ReplaceConstant - 
 -> 
   * 49 Weak Mutation 50: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 50 Weak Mutation 49: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC -1
   * 51 Weak Mutation 48: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC 1
   * 52 Weak Mutation 53: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: toString()Ljava/lang/String;
   * 53 Weak Mutation 52: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 54 Weak Mutation 55: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp Negation
   * 55 Weak Mutation 54: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 56 Weak Mutation 59: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - ReplaceConstant -   -> 
   * 57 Weak Mutation 58: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 58 Weak Mutation 57: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC -1
   * 59 Weak Mutation 56: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC 1
   * 60 Weak Mutation 63: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC -1
   * 61 Weak Mutation 62: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC 1
   * 62 Weak Mutation 61: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp Negation
   * 63 Weak Mutation 60: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 64 Weak Mutation 64: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 65 Weak Mutation 65: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - ReplaceConstant - 
 -> 
   * 66 Weak Mutation 66: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 67 Weak Mutation 67: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: toString()Ljava/lang/String;
   * 68 Weak Mutation 68: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 0
   * 69 Weak Mutation 69: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 1
   * 70 Weak Mutation 70: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> -1
   * 71 Weak Mutation 71: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 3
   * 72 Weak Mutation 76: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - DeleteStatement: valueOf(I)Ljava/lang/Integer;
   * 73 Weak Mutation 77: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> 0
   * 74 Weak Mutation 78: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> 1
   * 75 Weak Mutation 79: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> -1
   * 76 Weak Mutation 72: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 5
   * 77 Weak Mutation 73: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 0 -> 1
   * 78 Weak Mutation 74: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 1 -> 0
   * 79 Weak Mutation 75: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp Negation
   * 80 Weak Mutation 85: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> -
   * 81 Weak Mutation 84: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 1 -> 0
   * 82 Weak Mutation 87: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> /
   * 83 Weak Mutation 86: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> %
   * 84 Weak Mutation 81: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp Negation
   * 85 Weak Mutation 80: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> 3
   * 86 Weak Mutation 83: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp IINC -1
   * 87 Weak Mutation 82: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp IINC 1
   * 88 Weak Mutation 93: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> *
   * 89 Weak Mutation 92: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> /
   * 90 Weak Mutation 94: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - DeleteStatement: valueOf(I)Ljava/lang/Integer;
   * 91 Weak Mutation 89: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 1 -> 0
   * 92 Weak Mutation 88: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> *
   * 93 Weak Mutation 91: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> %
   * 94 Weak Mutation 90: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> -
   * 95 smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;: I19 Branch 1 IF_ICMPGE L28 - true
   * 96 smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;: I19 Branch 1 IF_ICMPGE L28 - false
   * 97 Weak Mutation 0: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp Negation
   * 98 Weak Mutation 1: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC 1
   * 99 Weak Mutation 2: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC -1
   * 100 Weak Mutation 3: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp Negation
   * 101 Weak Mutation 4: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC 1
   * 102 Weak Mutation 5: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - InsertUnaryOp IINC -1
   * 103 Weak Mutation 6: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> -
   * 104 Weak Mutation 7: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> %
   * 105 Weak Mutation 8: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> /
   * 106 Weak Mutation 9: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> *
   * 107 Weak Mutation 10: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceConstant - 1 -> 0
   * 108 Weak Mutation 11: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> -
   * 109 Weak Mutation 12: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> %
   * 110 Weak Mutation 13: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> /
   * 111 Weak Mutation 14: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:27 - ReplaceArithmeticOperator + -> *
   * 112 Weak Mutation 15: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - ReplaceConstant - 0 -> 1
   * 113 Weak Mutation 17: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC 1
   * 114 Weak Mutation 16: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp Negation
   * 115 Weak Mutation 19: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp Negation
   * 116 Weak Mutation 18: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC -1
   * 117 Weak Mutation 21: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC -1
   * 118 Weak Mutation 20: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - InsertUnaryOp IINC 1
   * 119 Weak Mutation 23: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - ReplaceComparisonOperator >= -> >
   * 120 Weak Mutation 25: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp Negation
   * 121 Weak Mutation 24: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:28 - ReplaceComparisonOperator >= -> -1
   * 122 Weak Mutation 27: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC -1
   * 123 Weak Mutation 26: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC 1
   * 124 Weak Mutation 29: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC 1
   * 125 Weak Mutation 28: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp Negation
   * 126 Weak Mutation 31: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> -
   * 127 Weak Mutation 30: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - InsertUnaryOp IINC -1
   * 128 Weak Mutation 34: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> *
   * 129 Weak Mutation 35: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceConstant - 1 -> 0
   * 130 Weak Mutation 32: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> %
   * 131 Weak Mutation 33: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> /
   * 132 Weak Mutation 38: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> /
   * 133 Weak Mutation 39: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> *
   * 134 Weak Mutation 36: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> -
   * 135 Weak Mutation 37: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:30 - ReplaceArithmeticOperator + -> %
   * 136 Weak Mutation 42: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC 1
   * 137 Weak Mutation 43: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC -1
   * 138 Weak Mutation 40: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 139 Weak Mutation 41: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp Negation
   * 140 Weak Mutation 46: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 141 Weak Mutation 47: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp Negation
   * 142 Weak Mutation 44: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 143 Weak Mutation 45: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - ReplaceConstant -   -> 
   * 144 Weak Mutation 51: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - ReplaceConstant - 
 -> 
   * 145 Weak Mutation 50: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 146 Weak Mutation 49: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC -1
   * 147 Weak Mutation 48: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - InsertUnaryOp IINC 1
   * 148 Weak Mutation 55: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp Negation
   * 149 Weak Mutation 54: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 150 Weak Mutation 53: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: toString()Ljava/lang/String;
   * 151 Weak Mutation 52: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:32 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 152 Weak Mutation 59: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - ReplaceConstant -   -> 
   * 153 Weak Mutation 58: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 154 Weak Mutation 57: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC -1
   * 155 Weak Mutation 56: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC 1
   * 156 Weak Mutation 63: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC -1
   * 157 Weak Mutation 62: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp IINC 1
   * 158 Weak Mutation 61: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - InsertUnaryOp Negation
   * 159 Weak Mutation 60: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 160 Weak Mutation 68: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 0
   * 161 Weak Mutation 69: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 1
   * 162 Weak Mutation 70: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> -1
   * 163 Weak Mutation 71: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 3
   * 164 Weak Mutation 64: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 165 Weak Mutation 65: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - ReplaceConstant - 
 -> 
   * 166 Weak Mutation 66: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 167 Weak Mutation 67: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:34 - DeleteStatement: toString()Ljava/lang/String;
   * 168 Weak Mutation 76: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - DeleteStatement: valueOf(I)Ljava/lang/Integer;
   * 169 Weak Mutation 77: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> 0
   * 170 Weak Mutation 78: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> 1
   * 171 Weak Mutation 79: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> -1
   * 172 Weak Mutation 72: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 4 -> 5
   * 173 Weak Mutation 73: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 0 -> 1
   * 174 Weak Mutation 74: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 1 -> 0
   * 175 Weak Mutation 75: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp Negation
   * 176 Weak Mutation 85: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> -
   * 177 Weak Mutation 84: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 1 -> 0
   * 178 Weak Mutation 87: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> /
   * 179 Weak Mutation 86: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> %
   * 180 Weak Mutation 81: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp Negation
   * 181 Weak Mutation 80: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 2 -> 3
   * 182 Weak Mutation 83: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp IINC -1
   * 183 Weak Mutation 82: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - InsertUnaryOp IINC 1
   * 184 Weak Mutation 93: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> *
   * 185 Weak Mutation 92: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> /
   * 186 Weak Mutation 94: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - DeleteStatement: valueOf(I)Ljava/lang/Integer;
   * 187 Weak Mutation 89: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceConstant - 1 -> 0
   * 188 Weak Mutation 88: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> *
   * 189 Weak Mutation 91: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> %
   * 190 Weak Mutation 90: smashed.NetworkGenerator.getNetwork(II)[Ljava/lang/Object;:36 - ReplaceArithmeticOperator + -> -
   */
  @Test
  public void test0()  throws Throwable  {
      Object[] objectArray0 = NetworkGenerator.getNetwork(0, 10);
      assertNotNull(objectArray0);
  }
}
