/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.sef;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.sef.SEFTestTokenizerProperties;
import junit.framework.AssertionFailedError;

@RunWith(EvoSuiteRunner.class)
public class TestSEFTestTokenizerProperties_2 {


  //Test case number: 2
  /*
   * 216 covered goals:
   * 1 Weak Mutation 232: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - ReplaceComparisonOperator >= -> >
   * 2 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I82 Branch 73 IF_ICMPGE L429 - true
   * 3 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I101 Branch 74 IFNULL L432 - false
   * 4 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I124 Branch 75 IF_ICMPNE L433 - false
   * 5 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I149 Branch 76 IF_ICMPNE L434 - false
   * 6 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I194 Branch 77 IF_ICMPGE L439 - true
   * 7 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I194 Branch 77 IF_ICMPGE L439 - false
   * 8 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I215 Branch 78 IFNULL L442 - false
   * 9 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I238 Branch 79 IF_ICMPNE L443 - false
   * 10 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I263 Branch 80 IF_ICMPNE L444 - false
   * 11 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I308 Branch 81 IF_ICMPGE L451 - true
   * 12 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I308 Branch 81 IF_ICMPGE L451 - false
   * 13 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I350 Branch 82 IFNE L454 - false
   * 14 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I369 Branch 83 IF_ICMPGE L456 - true
   * 15 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I369 Branch 83 IF_ICMPGE L456 - false
   * 16 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I449 Branch 84 IFEQ L467 - true
   * 17 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I449 Branch 84 IFEQ L467 - false
   * 18 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I475 Branch 85 IF_ICMPNE L471 - false
   * 19 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I490 Branch 86 IF_ICMPGE L474 - true
   * 20 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I490 Branch 86 IF_ICMPGE L474 - false
   * 21 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I509 Branch 87 IFNULL L477 - false
   * 22 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I532 Branch 88 IF_ICMPNE L478 - false
   * 23 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I557 Branch 89 IF_ICMPNE L479 - false
   * 24 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I602 Branch 90 IF_ICMPGE L484 - true
   * 25 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I602 Branch 90 IF_ICMPGE L484 - false
   * 26 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I621 Branch 91 IFNULL L487 - false
   * 27 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I644 Branch 92 IF_ICMPNE L488 - false
   * 28 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I669 Branch 93 IF_ICMPNE L489 - false
   * 29 Weak Mutation 139: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 0
   * 30 Weak Mutation 141: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> -1
   * 31 Weak Mutation 140: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 1
   * 32 Weak Mutation 143: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 12
   * 33 Weak Mutation 142: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 10
   * 34 Weak Mutation 152: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - elsif -> 
   * 35 Weak Mutation 153: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 0
   * 36 Weak Mutation 154: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 1
   * 37 Weak Mutation 155: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> -1
   * 38 Weak Mutation 156: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 2
   * 39 Weak Mutation 157: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 4
   * 40 Weak Mutation 158: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - end -> 
   * 41 Weak Mutation 159: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 0
   * 42 Weak Mutation 144: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 0 -> 1
   * 43 Weak Mutation 145: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - if -> 
   * 44 Weak Mutation 146: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 1 -> 0
   * 45 Weak Mutation 147: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - else -> 
   * 46 Weak Mutation 148: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> 0
   * 47 Weak Mutation 149: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> 1
   * 48 Weak Mutation 150: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> -1
   * 49 Weak Mutation 151: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> 3
   * 50 Weak Mutation 171: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 0
   * 51 Weak Mutation 170: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - while -> 
   * 52 Weak Mutation 169: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 6
   * 53 Weak Mutation 168: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 4
   * 54 Weak Mutation 175: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 7
   * 55 Weak Mutation 174: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 5
   * 56 Weak Mutation 173: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> -1
   * 57 Weak Mutation 172: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 1
   * 58 Weak Mutation 163: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 5
   * 59 Weak Mutation 162: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 3
   * 60 Weak Mutation 161: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> -1
   * 61 Weak Mutation 160: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 1
   * 62 Weak Mutation 167: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> -1
   * 63 Weak Mutation 166: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 1
   * 64 Weak Mutation 165: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 0
   * 65 Weak Mutation 164: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - integ -> 
   * 66 Weak Mutation 186: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 7
   * 67 Weak Mutation 187: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 9
   * 68 Weak Mutation 184: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 1
   * 69 Weak Mutation 185: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> -1
   * 70 Weak Mutation 190: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 1
   * 71 Weak Mutation 191: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> -1
   * 72 Weak Mutation 188: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - switch -> 
   * 73 Weak Mutation 189: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 0
   * 74 Weak Mutation 178: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 1
   * 75 Weak Mutation 179: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> -1
   * 76 Weak Mutation 176: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - loop -> 
   * 77 Weak Mutation 177: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 0
   * 78 Weak Mutation 182: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - case -> 
   * 79 Weak Mutation 183: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 0
   * 80 Weak Mutation 180: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 6
   * 81 Weak Mutation 181: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 8
   * 82 Weak Mutation 205: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 6
   * 83 Weak Mutation 204: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 4
   * 84 Weak Mutation 207: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - char -> 
   * 85 Weak Mutation 206: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 0 -> 1
   * 86 Weak Mutation 201: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 0
   * 87 Weak Mutation 200: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - break -> 
   * 88 Weak Mutation 203: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> -1
   * 89 Weak Mutation 202: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 1
   * 90 Weak Mutation 197: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> -1
   * 91 Weak Mutation 196: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 1
   * 92 Weak Mutation 199: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 11
   * 93 Weak Mutation 198: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 9
   * 94 Weak Mutation 193: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 10
   * 95 Weak Mutation 192: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 8
   * 96 Weak Mutation 195: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 0
   * 97 Weak Mutation 194: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - return -> 
   * 98 Weak Mutation 220: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - interface -> 
   * 99 Weak Mutation 221: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 0
   * 100 Weak Mutation 222: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 1
   * 101 Weak Mutation 223: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> -1
   * 102 Weak Mutation 216: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 1
   * 103 Weak Mutation 217: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> -1
   * 104 Weak Mutation 218: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 2
   * 105 Weak Mutation 219: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 4
   * 106 Weak Mutation 212: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> -1
   * 107 Weak Mutation 213: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> 3
   * 108 Weak Mutation 214: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - class -> 
   * 109 Weak Mutation 215: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 0
   * 110 Weak Mutation 208: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 1 -> 0
   * 111 Weak Mutation 209: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - int -> 
   * 112 Weak Mutation 210: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> 0
   * 113 Weak Mutation 211: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> 1
   * 114 Weak Mutation 233: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - ReplaceComparisonOperator >= -> -1
   * 115 Weak Mutation 230: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - InsertUnaryOp IINC -1
   * 116 Weak Mutation 229: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - InsertUnaryOp IINC 1
   * 117 Weak Mutation 228: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - InsertUnaryOp Negation
   * 118 Weak Mutation 227: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - ReplaceConstant - 0 -> 1
   * 119 Weak Mutation 226: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - integer -> 
   * 120 Weak Mutation 225: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 5
   * 121 Weak Mutation 224: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 3
   * 122 Weak Mutation 139: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 0
   * 123 Weak Mutation 141: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> -1
   * 124 Weak Mutation 140: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 1
   * 125 Weak Mutation 143: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 12
   * 126 Weak Mutation 142: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 11 -> 10
   * 127 Weak Mutation 152: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - elsif -> 
   * 128 Weak Mutation 153: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 0
   * 129 Weak Mutation 154: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 1
   * 130 Weak Mutation 155: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> -1
   * 131 Weak Mutation 156: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 2
   * 132 Weak Mutation 157: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 3 -> 4
   * 133 Weak Mutation 158: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - end -> 
   * 134 Weak Mutation 159: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 0
   * 135 Weak Mutation 144: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 0 -> 1
   * 136 Weak Mutation 145: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - if -> 
   * 137 Weak Mutation 146: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 1 -> 0
   * 138 Weak Mutation 147: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - else -> 
   * 139 Weak Mutation 148: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> 0
   * 140 Weak Mutation 149: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> 1
   * 141 Weak Mutation 150: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> -1
   * 142 Weak Mutation 151: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 2 -> 3
   * 143 Weak Mutation 171: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 0
   * 144 Weak Mutation 170: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - while -> 
   * 145 Weak Mutation 169: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 6
   * 146 Weak Mutation 168: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 4
   * 147 Weak Mutation 175: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 7
   * 148 Weak Mutation 174: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 5
   * 149 Weak Mutation 173: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> -1
   * 150 Weak Mutation 172: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 6 -> 1
   * 151 Weak Mutation 163: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 5
   * 152 Weak Mutation 162: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 3
   * 153 Weak Mutation 161: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> -1
   * 154 Weak Mutation 160: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 4 -> 1
   * 155 Weak Mutation 167: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> -1
   * 156 Weak Mutation 166: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 1
   * 157 Weak Mutation 165: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 5 -> 0
   * 158 Weak Mutation 164: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - integ -> 
   * 159 Weak Mutation 186: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 7
   * 160 Weak Mutation 187: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 9
   * 161 Weak Mutation 184: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 1
   * 162 Weak Mutation 185: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> -1
   * 163 Weak Mutation 190: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 1
   * 164 Weak Mutation 191: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> -1
   * 165 Weak Mutation 188: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - switch -> 
   * 166 Weak Mutation 189: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 0
   * 167 Weak Mutation 178: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 1
   * 168 Weak Mutation 179: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> -1
   * 169 Weak Mutation 176: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - loop -> 
   * 170 Weak Mutation 177: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 0
   * 171 Weak Mutation 182: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - case -> 
   * 172 Weak Mutation 183: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 8 -> 0
   * 173 Weak Mutation 180: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 6
   * 174 Weak Mutation 181: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 7 -> 8
   * 175 Weak Mutation 205: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 6
   * 176 Weak Mutation 204: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 4
   * 177 Weak Mutation 207: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - char -> 
   * 178 Weak Mutation 206: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 0 -> 1
   * 179 Weak Mutation 201: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 0
   * 180 Weak Mutation 200: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - break -> 
   * 181 Weak Mutation 203: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> -1
   * 182 Weak Mutation 202: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 5 -> 1
   * 183 Weak Mutation 197: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> -1
   * 184 Weak Mutation 196: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 1
   * 185 Weak Mutation 199: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 11
   * 186 Weak Mutation 198: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 9
   * 187 Weak Mutation 193: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 10
   * 188 Weak Mutation 192: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 9 -> 8
   * 189 Weak Mutation 195: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - 10 -> 0
   * 190 Weak Mutation 194: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:407 - ReplaceConstant - return -> 
   * 191 Weak Mutation 220: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - interface -> 
   * 192 Weak Mutation 221: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 0
   * 193 Weak Mutation 222: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 1
   * 194 Weak Mutation 223: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> -1
   * 195 Weak Mutation 216: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 1
   * 196 Weak Mutation 217: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> -1
   * 197 Weak Mutation 218: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 2
   * 198 Weak Mutation 219: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 4
   * 199 Weak Mutation 212: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> -1
   * 200 Weak Mutation 213: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> 3
   * 201 Weak Mutation 214: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - class -> 
   * 202 Weak Mutation 215: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 3 -> 0
   * 203 Weak Mutation 208: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 1 -> 0
   * 204 Weak Mutation 209: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - int -> 
   * 205 Weak Mutation 210: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> 0
   * 206 Weak Mutation 211: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 2 -> 1
   * 207 Weak Mutation 233: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - ReplaceComparisonOperator >= -> -1
   * 208 Weak Mutation 232: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - ReplaceComparisonOperator >= -> >
   * 209 Weak Mutation 230: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - InsertUnaryOp IINC -1
   * 210 Weak Mutation 229: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - InsertUnaryOp IINC 1
   * 211 Weak Mutation 228: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - InsertUnaryOp Negation
   * 212 Weak Mutation 227: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:429 - ReplaceConstant - 0 -> 1
   * 213 Weak Mutation 226: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - integer -> 
   * 214 Weak Mutation 225: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 5
   * 215 Weak Mutation 224: de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V:420 - ReplaceConstant - 4 -> 3
   * 216 de.susebox.jtopas.sef.SEFTestTokenizerProperties.testAddingKeywords()V: I82 Branch 73 IF_ICMPGE L429 - false
   */
  @Test
  public void test2()  throws Throwable  {
      SEFTestTokenizerProperties sEFTestTokenizerProperties0 = new SEFTestTokenizerProperties(" RM");
      sEFTestTokenizerProperties0.setUp();
      sEFTestTokenizerProperties0.testAddingKeywords();
      assertEquals(1, sEFTestTokenizerProperties0.countTestCases());
  }
}