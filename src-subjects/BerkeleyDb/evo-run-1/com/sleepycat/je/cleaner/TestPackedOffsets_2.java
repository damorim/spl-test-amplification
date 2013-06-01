/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.cleaner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.cleaner.PackedOffsets;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestPackedOffsets_2 {


  //Test case number: 2
  /*
   * 71 covered goals:
   * 1 Weak Mutation 110: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:50 - DeleteField: sizeI
   * 2 Weak Mutation 108: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:50 - InsertUnaryOp +1
   * 3 Weak Mutation 109: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:50 - InsertUnaryOp -1
   * 4 Weak Mutation 107: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:50 - InsertUnaryOp Negation
   * 5 Weak Mutation 111: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:51 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 112: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:52 - DeleteStatement: iterator()Lcom/sleepycat/je/cleaner/PackedOffsets$Iterator;
   * 7 Weak Mutation 114: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:53 - ReplaceComparisonOperator == -> !=
   * 8 Weak Mutation 113: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:53 - DeleteStatement: hasNext()Z
   * 9 Weak Mutation 118: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:54 - DeleteStatement: next()J
   * 10 Weak Mutation 117: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:54 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 116: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:54 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 115: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:54 - InsertUnaryOp Negation
   * 13 Weak Mutation 119: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - InsertUnaryOp Negation
   * 14 Weak Mutation 127: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - InsertUnaryOp -1
   * 15 Weak Mutation 126: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - InsertUnaryOp +1
   * 16 Weak Mutation 125: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - InsertUnaryOp Negation
   * 17 Weak Mutation 124: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 123: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 122: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - InsertUnaryOp Negation
   * 20 Weak Mutation 121: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - ReplaceComparisonOperator != -> ==
   * 21 Weak Mutation 128: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - DeleteField: sizeI
   * 22 Weak Mutation 130: com.sleepycat.je.cleaner.PackedOffsets.toArray()[J:56 - ReplaceComparisonOperator == -> -2
   * 23 Weak Mutation 0: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - DeleteField: this$0Lcom/sleepycat/je/cleaner/PackedOffsets;
   * 24 Weak Mutation 1: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - DeleteStatement: access$100(Lcom/sleepycat/je/cleaner/PackedOffsets;)[S
   * 25 Weak Mutation 2: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - ReplaceComparisonOperator = null -> != null
   * 26 Weak Mutation 3: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - InsertUnaryOp Negation
   * 27 Weak Mutation 4: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - InsertUnaryOp +1
   * 28 Weak Mutation 5: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - InsertUnaryOp -1
   * 29 Weak Mutation 6: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - DeleteField: indexI
   * 30 Weak Mutation 7: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - DeleteField: this$0Lcom/sleepycat/je/cleaner/PackedOffsets;
   * 31 Weak Mutation 8: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - DeleteStatement: access$100(Lcom/sleepycat/je/cleaner/PackedOffsets;)[S
   * 32 Weak Mutation 10: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - ReplaceComparisonOperator >= -> >
   * 33 Weak Mutation 11: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - ReplaceComparisonOperator >= -> -1
   * 34 Weak Mutation 12: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - ReplaceConstant - 1 -> 0
   * 35 Weak Mutation 13: com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z:87 - ReplaceConstant - 0 -> 1
   * 36 Weak Mutation 14: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:90 - InsertUnaryOp Negation
   * 37 Weak Mutation 16: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:91 - ReplaceConstant - 0 -> 1
   * 38 Weak Mutation 17: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - DeleteField: this$0Lcom/sleepycat/je/cleaner/PackedOffsets;
   * 39 Weak Mutation 19: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - InsertUnaryOp Negation
   * 40 Weak Mutation 18: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - DeleteStatement: access$100(Lcom/sleepycat/je/cleaner/PackedOffsets;)[S
   * 41 Weak Mutation 21: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - InsertUnaryOp -1
   * 42 Weak Mutation 20: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - InsertUnaryOp +1
   * 43 Weak Mutation 23: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - ReplaceConstant - 1 -> 0
   * 44 Weak Mutation 22: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - DeleteField: indexI
   * 45 Weak Mutation 25: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - ReplaceArithmeticOperator + -> %
   * 46 Weak Mutation 24: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - ReplaceArithmeticOperator + -> -
   * 47 Weak Mutation 27: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - ReplaceArithmeticOperator + -> *
   * 48 Weak Mutation 26: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:92 - ReplaceArithmeticOperator + -> /
   * 49 Weak Mutation 29: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:93 - ReplaceConstant - 0 -> 1
   * 50 Weak Mutation 28: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:93 - InsertUnaryOp Negation
   * 51 Weak Mutation 31: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:93 - DeleteStatement: longSub(JJ)I
   * 52 Weak Mutation 30: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:93 - ReplaceConstant - 0 -> -1
   * 53 Weak Mutation 33: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:93 - ReplaceComparisonOperator >= -> >
   * 54 Weak Mutation 55: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:97 - InsertUnaryOp Negation
   * 55 Weak Mutation 54: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:97 - InsertUnaryOp Negation
   * 56 Weak Mutation 53: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:97 - InsertUnaryOp Negation
   * 57 Weak Mutation 57: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:97 - InsertUnaryOp IINC -1
   * 58 Weak Mutation 56: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:97 - InsertUnaryOp IINC 1
   * 59 Weak Mutation 62: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:97 - ReplaceArithmeticOperator + -> /
   * 60 Weak Mutation 61: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:97 - ReplaceArithmeticOperator + -> %
   * 61 Weak Mutation 64: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:101 - InsertUnaryOp Negation
   * 62 Weak Mutation 65: com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J:102 - InsertUnaryOp Negation
   * 63 com.sleepycat.je.cleaner.PackedOffsets.iterator()Lcom/sleepycat/je/cleaner/PackedOffsets$Iterator;: root-Branch
   * 64 com.sleepycat.je.cleaner.PackedOffsets.toArray()[J: I19 Branch 5 IFEQ L53 - true
   * 65 com.sleepycat.je.cleaner.PackedOffsets.toArray()[J: I19 Branch 5 IFEQ L53 - false
   * 66 com.sleepycat.je.cleaner.PackedOffsets.toArray()[J: I32 Branch 6 IFNE L56 - false
   * 67 com.sleepycat.je.cleaner.PackedOffsets.toArray()[J: I36 Branch 7 IF_ICMPEQ L56 - true
   * 68 com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z: I5 Branch 1 IFNULL L87 - false
   * 69 com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z: I12 Branch 2 IF_ICMPGE L87 - true
   * 70 com.sleepycat.je.cleaner.PackedOffsets$Iterator.hasNext()Z: I12 Branch 2 IF_ICMPGE L87 - false
   * 71 com.sleepycat.je.cleaner.PackedOffsets$Iterator.next()J: I29 Branch 3 IFGE L93 - true
   */
  @Test
  public void test2()  throws Throwable  {
      PackedOffsets packedOffsets0 = new PackedOffsets();
      long[] longArray0 = new long[10];
      packedOffsets0.pack(longArray0);
      packedOffsets0.toArray();
      assertEquals(28, packedOffsets0.getLogSize());
      assertEquals("<offsets size=\"10\">0x0 0x0 0x0 0x0 0x0 0x0 0x0 0x0 0x0 0x0 </offsets>", packedOffsets0.toString());
  }
}
