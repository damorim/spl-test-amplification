/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.utilint.DbLsn;

@RunWith(EvoSuiteRunner.class)
public class TestDbLsn_3 {


  //Test case number: 3
  /*
   * 119 covered goals:
   * 1 Weak Mutation 31: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 0
   * 2 Weak Mutation 30: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - InsertUnaryOp Negation
   * 3 Weak Mutation 34: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 31
   * 4 Weak Mutation 35: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 33
   * 5 Weak Mutation 32: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 1
   * 6 Weak Mutation 33: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> -1
   * 7 Weak Mutation 38: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 0
   * 8 Weak Mutation 39: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 1
   * 9 Weak Mutation 37: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceBitwiseOperator >> -> <<
   * 10 Weak Mutation 42: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 4294967296
   * 11 Weak Mutation 43: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceBitwiseOperator & -> |
   * 12 Weak Mutation 40: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> -1
   * 13 Weak Mutation 41: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 4294967294
   * 14 Weak Mutation 44: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceBitwiseOperator & -> ^
   * 15 Weak Mutation 46: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 0
   * 16 Weak Mutation 47: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 1
   * 17 Weak Mutation 45: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - InsertUnaryOp Negation
   * 18 Weak Mutation 51: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceBitwiseOperator & -> |
   * 19 Weak Mutation 50: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 4294967296
   * 20 Weak Mutation 49: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 4294967294
   * 21 Weak Mutation 48: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> -1
   * 22 Weak Mutation 52: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceBitwiseOperator & -> ^
   * 23 Weak Mutation 55: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - DeleteStatement: longSub(JJ)I
   * 24 Weak Mutation 54: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - InsertUnaryOp Negation
   * 25 Weak Mutation 53: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - InsertUnaryOp Negation
   * 26 Weak Mutation 57: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - ReplaceComparisonOperator >= -> >
   * 27 Weak Mutation 63: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - InsertUnaryOp Negation
   * 28 Weak Mutation 62: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - InsertUnaryOp Negation
   * 29 Weak Mutation 64: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - DeleteStatement: longSub(JJ)I
   * 30 Weak Mutation 66: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - ReplaceComparisonOperator <= -> <
   * 31 Weak Mutation 69: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:51 - ReplaceConstant - 0 -> 1
   * 32 Weak Mutation 70: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - InsertUnaryOp Negation
   * 33 Weak Mutation 71: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 0
   * 34 Weak Mutation 78: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - InsertUnaryOp Negation
   * 35 Weak Mutation 79: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 0
   * 36 Weak Mutation 72: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 1
   * 37 Weak Mutation 73: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> -2
   * 38 Weak Mutation 74: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - DeleteStatement: longSub(JJ)I
   * 39 Weak Mutation 75: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceComparisonOperator == -> >=
   * 40 Weak Mutation 81: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> -2
   * 41 Weak Mutation 80: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 1
   * 42 Weak Mutation 83: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceComparisonOperator != -> <
   * 43 Weak Mutation 82: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - DeleteStatement: longSub(JJ)I
   * 44 Weak Mutation 87: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:58 - DeleteStatement: getFileNumber(J)J
   * 45 Weak Mutation 86: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:58 - InsertUnaryOp Negation
   * 46 Weak Mutation 89: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:59 - DeleteStatement: getFileNumber(J)J
   * 47 Weak Mutation 88: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:59 - InsertUnaryOp Negation
   * 48 Weak Mutation 92: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - DeleteStatement: longSub(JJ)I
   * 49 Weak Mutation 95: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - ReplaceComparisonOperator != -> -1
   * 50 Weak Mutation 91: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - InsertUnaryOp Negation
   * 51 Weak Mutation 90: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - InsertUnaryOp Negation
   * 52 Weak Mutation 100: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - DeleteStatement: compareLong(JJ)I
   * 53 Weak Mutation 98: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - InsertUnaryOp Negation
   * 54 Weak Mutation 99: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - DeleteStatement: getFileOffset(J)J
   * 55 Weak Mutation 96: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - InsertUnaryOp Negation
   * 56 Weak Mutation 97: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - DeleteStatement: getFileOffset(J)J
   * 57 com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J: root-Branch
   * 58 com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J: root-Branch
   * 59 com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I: I5 Branch 2 IFGE L44 - true
   * 60 com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I: I15 Branch 3 IFLE L47 - true
   * 61 com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I: I5 Branch 4 IFEQ L55 - false
   * 62 com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I: I9 Branch 5 IFNE L55 - true
   * 63 com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I: I31 Branch 6 IFNE L60 - false
   * 64 Weak Mutation 31: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 0
   * 65 Weak Mutation 30: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - InsertUnaryOp Negation
   * 66 Weak Mutation 34: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 31
   * 67 Weak Mutation 35: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 33
   * 68 Weak Mutation 32: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> 1
   * 69 Weak Mutation 33: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 32 -> -1
   * 70 Weak Mutation 38: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 0
   * 71 Weak Mutation 39: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 1
   * 72 Weak Mutation 37: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceBitwiseOperator >> -> <<
   * 73 Weak Mutation 42: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 4294967296
   * 74 Weak Mutation 43: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceBitwiseOperator & -> |
   * 75 Weak Mutation 40: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> -1
   * 76 Weak Mutation 41: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceConstant - 4294967295 -> 4294967294
   * 77 Weak Mutation 46: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 0
   * 78 Weak Mutation 47: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 1
   * 79 Weak Mutation 44: com.sleepycat.je.utilint.DbLsn.getFileNumber(J)J:34 - ReplaceBitwiseOperator & -> ^
   * 80 Weak Mutation 45: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - InsertUnaryOp Negation
   * 81 Weak Mutation 51: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceBitwiseOperator & -> |
   * 82 Weak Mutation 50: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 4294967296
   * 83 Weak Mutation 49: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> 4294967294
   * 84 Weak Mutation 48: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceConstant - 4294967295 -> -1
   * 85 Weak Mutation 55: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - DeleteStatement: longSub(JJ)I
   * 86 Weak Mutation 54: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - InsertUnaryOp Negation
   * 87 Weak Mutation 53: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - InsertUnaryOp Negation
   * 88 Weak Mutation 52: com.sleepycat.je.utilint.DbLsn.getFileOffset(J)J:41 - ReplaceBitwiseOperator & -> ^
   * 89 Weak Mutation 57: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:44 - ReplaceComparisonOperator >= -> >
   * 90 Weak Mutation 63: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - InsertUnaryOp Negation
   * 91 Weak Mutation 62: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - InsertUnaryOp Negation
   * 92 Weak Mutation 69: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:51 - ReplaceConstant - 0 -> 1
   * 93 Weak Mutation 70: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - InsertUnaryOp Negation
   * 94 Weak Mutation 71: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 0
   * 95 Weak Mutation 64: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - DeleteStatement: longSub(JJ)I
   * 96 Weak Mutation 66: com.sleepycat.je.utilint.DbLsn.compareLong(JJ)I:47 - ReplaceComparisonOperator <= -> <
   * 97 Weak Mutation 78: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - InsertUnaryOp Negation
   * 98 Weak Mutation 79: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 0
   * 99 Weak Mutation 72: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 1
   * 100 Weak Mutation 73: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> -2
   * 101 Weak Mutation 74: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - DeleteStatement: longSub(JJ)I
   * 102 Weak Mutation 75: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceComparisonOperator == -> >=
   * 103 Weak Mutation 87: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:58 - DeleteStatement: getFileNumber(J)J
   * 104 Weak Mutation 86: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:58 - InsertUnaryOp Negation
   * 105 Weak Mutation 81: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> -2
   * 106 Weak Mutation 80: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceConstant - -1 -> 1
   * 107 Weak Mutation 83: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - ReplaceComparisonOperator != -> <
   * 108 Weak Mutation 82: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:55 - DeleteStatement: longSub(JJ)I
   * 109 Weak Mutation 92: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - DeleteStatement: longSub(JJ)I
   * 110 Weak Mutation 95: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - ReplaceComparisonOperator != -> -1
   * 111 Weak Mutation 89: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:59 - DeleteStatement: getFileNumber(J)J
   * 112 Weak Mutation 88: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:59 - InsertUnaryOp Negation
   * 113 Weak Mutation 91: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - InsertUnaryOp Negation
   * 114 Weak Mutation 90: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:60 - InsertUnaryOp Negation
   * 115 Weak Mutation 100: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - DeleteStatement: compareLong(JJ)I
   * 116 Weak Mutation 98: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - InsertUnaryOp Negation
   * 117 Weak Mutation 99: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - DeleteStatement: getFileOffset(J)J
   * 118 Weak Mutation 96: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - InsertUnaryOp Negation
   * 119 Weak Mutation 97: com.sleepycat.je.utilint.DbLsn.compareTo(JJ)I:61 - DeleteStatement: getFileOffset(J)J
   */
  @Test
  public void test3()  throws Throwable  {
      int int0 = DbLsn.compareTo(1L, 1L);
      assertEquals(0, int0);
  }
}