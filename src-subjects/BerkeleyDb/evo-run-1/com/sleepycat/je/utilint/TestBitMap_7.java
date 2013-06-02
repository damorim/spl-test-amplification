/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.utilint.BitMap;

@RunWith(EvoSuiteRunner.class)
public class TestBitMap_7 {


  //Test case number: 7
  /*
   * 10 covered goals:
   * 1 Weak Mutation 73: com.sleepycat.je.utilint.BitMap.cardinality()I:63 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 76: com.sleepycat.je.utilint.BitMap.cardinality()I:64 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 3 Weak Mutation 74: com.sleepycat.je.utilint.BitMap.cardinality()I:64 - DeleteField: bitSegmentsLjava/util/Map;
   * 4 Weak Mutation 75: com.sleepycat.je.utilint.BitMap.cardinality()I:64 - DeleteStatement: values()Ljava/util/Collection;
   * 5 Weak Mutation 77: com.sleepycat.je.utilint.BitMap.cardinality()I:65 - DeleteStatement: hasNext()Z
   * 6 Weak Mutation 78: com.sleepycat.je.utilint.BitMap.cardinality()I:65 - ReplaceComparisonOperator == -> !=
   * 7 Weak Mutation 89: com.sleepycat.je.utilint.BitMap.cardinality()I:69 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 88: com.sleepycat.je.utilint.BitMap.cardinality()I:69 - InsertUnaryOp Negation
   * 9 Weak Mutation 90: com.sleepycat.je.utilint.BitMap.cardinality()I:69 - InsertUnaryOp IINC -1
   * 10 com.sleepycat.je.utilint.BitMap.cardinality()I: I15 Branch 7 IFEQ L65 - true
   */
  @Test
  public void test7()  throws Throwable  {
      BitMap bitMap0 = new BitMap();
      int int0 = bitMap0.cardinality();
      assertEquals(0, int0);
  }
}