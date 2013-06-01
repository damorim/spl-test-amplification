/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.utilint.CmdUtil;

@RunWith(EvoSuiteRunner.class)
public class TestCmdUtil_5 {


  //Test case number: 5
  /*
   * 144 covered goals:
   * 1 Weak Mutation 55: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - InsertUnaryOp IINC -1
   * 2 Weak Mutation 54: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 53: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - InsertUnaryOp Negation
   * 4 Weak Mutation 59: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 91
   * 5 Weak Mutation 58: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> -1
   * 6 Weak Mutation 57: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 1
   * 7 Weak Mutation 56: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 0
   * 8 Weak Mutation 63: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceComparisonOperator != -> -1
   * 9 Weak Mutation 60: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 93
   * 10 Weak Mutation 68: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 93
   * 11 Weak Mutation 69: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 12 Weak Mutation 64: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 0
   * 13 Weak Mutation 65: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 1
   * 14 Weak Mutation 66: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> -1
   * 15 Weak Mutation 67: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 91
   * 16 Weak Mutation 70: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~ -> 
   * 17 Weak Mutation 71: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - InsertUnaryOp Negation
   * 18 Weak Mutation 76: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> -1
   * 19 Weak Mutation 77: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 32
   * 20 Weak Mutation 78: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 34
   * 21 Weak Mutation 79: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> +
   * 22 Weak Mutation 72: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 73: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 74: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 0
   * 25 Weak Mutation 75: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 1
   * 26 Weak Mutation 84: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 27 Weak Mutation 81: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> /
   * 28 Weak Mutation 80: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> %
   * 29 Weak Mutation 83: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - DeleteStatement: charAt(I)C
   * 30 Weak Mutation 82: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> *
   * 31 Weak Mutation 146: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceComparisonOperator >= -> -1
   * 32 Weak Mutation 147: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 1 -> 0
   * 33 com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V: I25 Branch 5 IFEQ L36 - false
   * 34 com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V: I30 Branch 6 IF_ICMPNE L37 - false
   * 35 com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z: I7 Branch 10 IF_ICMPGE L61 - false
   * 36 Weak Mutation 27: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:33 - ReplaceConstant - 0 -> 1
   * 37 Weak Mutation 29: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:33 - InsertUnaryOp IINC 1
   * 38 Weak Mutation 28: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:33 - InsertUnaryOp Negation
   * 39 Weak Mutation 30: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:33 - InsertUnaryOp IINC -1
   * 40 Weak Mutation 34: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - InsertUnaryOp Negation
   * 41 Weak Mutation 35: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - InsertUnaryOp IINC 1
   * 42 Weak Mutation 32: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:33 - ReplaceComparisonOperator >= -> >
   * 43 Weak Mutation 33: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:33 - ReplaceComparisonOperator >= -> -1
   * 44 Weak Mutation 38: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - ReplaceConstant - 255 -> 1
   * 45 Weak Mutation 39: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - ReplaceConstant - 255 -> -1
   * 46 Weak Mutation 36: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - InsertUnaryOp IINC -1
   * 47 Weak Mutation 37: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - ReplaceConstant - 255 -> 0
   * 48 Weak Mutation 42: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - ReplaceBitwiseOperator & -> |
   * 49 Weak Mutation 43: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - ReplaceBitwiseOperator & -> ^
   * 50 Weak Mutation 40: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - ReplaceConstant - 255 -> 254
   * 51 Weak Mutation 41: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:34 - ReplaceConstant - 255 -> 256
   * 52 Weak Mutation 46: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:35 - InsertUnaryOp IINC -1
   * 53 Weak Mutation 47: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:35 - ReplaceComparisonOperator == -> !=
   * 54 Weak Mutation 44: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:35 - InsertUnaryOp Negation
   * 55 Weak Mutation 45: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:35 - InsertUnaryOp IINC 1
   * 56 Weak Mutation 51: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:36 - DeleteStatement: isPrint(I)Z
   * 57 Weak Mutation 50: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:36 - InsertUnaryOp IINC -1
   * 58 Weak Mutation 49: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:36 - InsertUnaryOp IINC 1
   * 59 Weak Mutation 48: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:36 - InsertUnaryOp Negation
   * 60 Weak Mutation 55: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - InsertUnaryOp IINC -1
   * 61 Weak Mutation 54: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - InsertUnaryOp IINC 1
   * 62 Weak Mutation 53: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - InsertUnaryOp Negation
   * 63 Weak Mutation 52: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:36 - ReplaceComparisonOperator == -> !=
   * 64 Weak Mutation 59: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 91
   * 65 Weak Mutation 58: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> -1
   * 66 Weak Mutation 57: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 1
   * 67 Weak Mutation 56: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 0
   * 68 Weak Mutation 63: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceComparisonOperator != -> -1
   * 69 Weak Mutation 60: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:37 - ReplaceConstant - 92 -> 93
   * 70 Weak Mutation 68: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 93
   * 71 Weak Mutation 69: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 72 Weak Mutation 70: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~ -> 
   * 73 Weak Mutation 71: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - InsertUnaryOp Negation
   * 74 Weak Mutation 64: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 0
   * 75 Weak Mutation 65: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 1
   * 76 Weak Mutation 66: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> -1
   * 77 Weak Mutation 67: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:38 - ReplaceConstant - 92 -> 91
   * 78 Weak Mutation 76: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> -1
   * 79 Weak Mutation 77: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 32
   * 80 Weak Mutation 78: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 34
   * 81 Weak Mutation 79: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> +
   * 82 Weak Mutation 72: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - InsertUnaryOp IINC 1
   * 83 Weak Mutation 73: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - InsertUnaryOp IINC -1
   * 84 Weak Mutation 74: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 0
   * 85 Weak Mutation 75: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceConstant - 33 -> 1
   * 86 Weak Mutation 85: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:43 - ReplaceConstant - 92 -> 0
   * 87 Weak Mutation 84: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 88 Weak Mutation 87: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:43 - ReplaceConstant - 92 -> -1
   * 89 Weak Mutation 86: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:43 - ReplaceConstant - 92 -> 1
   * 90 Weak Mutation 81: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> /
   * 91 Weak Mutation 80: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> %
   * 92 Weak Mutation 83: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - DeleteStatement: charAt(I)C
   * 93 Weak Mutation 82: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:40 - ReplaceArithmeticOperator - -> *
   * 94 Weak Mutation 93: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:44 - InsertUnaryOp IINC -1
   * 95 Weak Mutation 92: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:44 - InsertUnaryOp IINC 1
   * 96 Weak Mutation 95: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - InsertUnaryOp Negation
   * 97 Weak Mutation 94: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:44 - DeleteStatement: toHexString(I)Ljava/lang/String;
   * 98 Weak Mutation 89: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:43 - ReplaceConstant - 92 -> 93
   * 99 Weak Mutation 88: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:43 - ReplaceConstant - 92 -> 91
   * 100 Weak Mutation 91: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:44 - InsertUnaryOp Negation
   * 101 Weak Mutation 90: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:43 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 102 Weak Mutation 102: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - ReplaceConstant - 16 -> 17
   * 103 Weak Mutation 100: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - ReplaceConstant - 16 -> -1
   * 104 Weak Mutation 101: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - ReplaceConstant - 16 -> 15
   * 105 Weak Mutation 98: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - ReplaceConstant - 16 -> 0
   * 106 Weak Mutation 99: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - ReplaceConstant - 16 -> 1
   * 107 Weak Mutation 96: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - InsertUnaryOp IINC 1
   * 108 Weak Mutation 97: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - InsertUnaryOp IINC -1
   * 109 Weak Mutation 110: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:46 - ReplaceConstant - 48 -> 49
   * 110 Weak Mutation 111: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:46 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 111 Weak Mutation 108: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:46 - ReplaceConstant - 48 -> -1
   * 112 Weak Mutation 109: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:46 - ReplaceConstant - 48 -> 47
   * 113 Weak Mutation 106: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:46 - ReplaceConstant - 48 -> 0
   * 114 Weak Mutation 107: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:46 - ReplaceConstant - 48 -> 1
   * 115 Weak Mutation 105: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:45 - ReplaceComparisonOperator >= -> -1
   * 116 Weak Mutation 112: com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V:48 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 117 Weak Mutation 127: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - InsertUnaryOp IINC -1
   * 118 Weak Mutation 126: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - InsertUnaryOp IINC 1
   * 119 Weak Mutation 125: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - InsertUnaryOp Negation
   * 120 Weak Mutation 137: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 32 -> 1
   * 121 Weak Mutation 136: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 32 -> 0
   * 122 Weak Mutation 139: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 32 -> 31
   * 123 Weak Mutation 138: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 32 -> -1
   * 124 Weak Mutation 141: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - InsertUnaryOp Negation
   * 125 Weak Mutation 140: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 32 -> 33
   * 126 Weak Mutation 143: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - InsertUnaryOp IINC -1
   * 127 Weak Mutation 142: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - InsertUnaryOp IINC 1
   * 128 Weak Mutation 129: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 127 -> 1
   * 129 Weak Mutation 128: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 127 -> 0
   * 130 Weak Mutation 131: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 127 -> 126
   * 131 Weak Mutation 130: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 127 -> -1
   * 132 Weak Mutation 132: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 127 -> 128
   * 133 Weak Mutation 135: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceComparisonOperator >= -> -1
   * 134 Weak Mutation 144: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceComparisonOperator >= -> ==
   * 135 Weak Mutation 146: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceComparisonOperator >= -> -1
   * 136 Weak Mutation 147: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 1 -> 0
   * 137 Weak Mutation 148: com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z:61 - ReplaceConstant - 0 -> 1
   * 138 com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z: I4 Branch 9 IF_ICMPGE L61 - false
   * 139 com.sleepycat.je.utilint.CmdUtil.isPrint(I)Z: I7 Branch 10 IF_ICMPGE L61 - true
   * 140 com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V: I8 Branch 3 IF_ICMPGE L33 - true
   * 141 com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V: I8 Branch 3 IF_ICMPGE L33 - false
   * 142 com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V: I20 Branch 4 IFEQ L35 - false
   * 143 com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V: I25 Branch 5 IFEQ L36 - true
   * 144 com.sleepycat.je.utilint.CmdUtil.formatEntry(Ljava/lang/StringBuffer;[BZ)V: I63 Branch 7 IF_ICMPGE L45 - false
   */
  @Test
  public void test5()  throws Throwable  {
      StringBuffer stringBuffer0 = new StringBuffer();
      byte[] byteArray0 = new byte[10];
      byteArray0[1] = (byte)92;
      CmdUtil.formatEntry(stringBuffer0, byteArray0, true);
      assertEquals(34, stringBuffer0.capacity());
      assertEquals(29, stringBuffer0.length());
  }
}
