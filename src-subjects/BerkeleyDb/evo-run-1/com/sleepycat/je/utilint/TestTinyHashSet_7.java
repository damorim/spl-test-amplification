/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.utilint.TinyHashSet;
import java.util.Set;

@RunWith(EvoSuiteRunner.class)
public class TestTinyHashSet_7 {


  //Test case number: 7
  /*
   * 10 covered goals:
   * 1 Weak Mutation 77: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:64 - DeleteField: setLjava/util/Set;
   * 2 Weak Mutation 79: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:65 - DeleteField: setLjava/util/Set;
   * 3 com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;: I18 Branch 23 IFNULL L64 - false
   * 4 Weak Mutation 70: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:63 - InsertUnaryOp Negation
   * 5 Weak Mutation 78: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:64 - ReplaceComparisonOperator = null -> != null
   * 6 Weak Mutation 72: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:63 - ReplaceComparisonOperator != -> ==
   * 7 Weak Mutation 74: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:63 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 77: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:64 - DeleteField: setLjava/util/Set;
   * 9 Weak Mutation 79: com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;:65 - DeleteField: setLjava/util/Set;
   * 10 com.sleepycat.je.utilint.TinyHashSet.copy()Ljava/util/Set;: I6 Branch 21 IFNULL L63 - true
   */
  @Test
  public void test7()  throws Throwable  {
      TinyHashSet tinyHashSet0 = new TinyHashSet();
      tinyHashSet0.add((Object) tinyHashSet0);
      tinyHashSet0.add((Object) tinyHashSet0);
      Set<?> set0 = tinyHashSet0.copy();
      assertEquals(1, tinyHashSet0.size());
      assertEquals(1, set0.size());
  }
}