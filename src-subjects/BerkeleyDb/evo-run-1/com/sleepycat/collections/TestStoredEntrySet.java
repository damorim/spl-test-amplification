/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.collections.DataView;
import com.sleepycat.collections.StoredEntrySet;
import com.sleepycat.collections.StoredSortedEntrySet;

@RunWith(EvoSuiteRunner.class)
public class TestStoredEntrySet {


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.collections.StoredEntrySet.add(Ljava/lang/Object;)Z:68 - DeleteStatement: getKey()Ljava/lang/Object;
   * 2 com.sleepycat.collections.StoredEntrySet.<init>(Lcom/sleepycat/collections/DataView;)V: root-Branch
   * 3 com.sleepycat.collections.StoredEntrySet.add(Ljava/lang/Object;)Z: root-Branch
   * 4 Weak Mutation 0: com.sleepycat.collections.StoredEntrySet.add(Ljava/lang/Object;)Z:68 - DeleteStatement: getKey()Ljava/lang/Object;
   */
  @Test
  public void test0()  throws Throwable  {
      StoredSortedEntrySet storedSortedEntrySet0 = new StoredSortedEntrySet((DataView) null);
      // Undeclared exception!
      try {
        storedSortedEntrySet0.add((Object) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 25: com.sleepycat.collections.StoredEntrySet.contains(Ljava/lang/Object;)Z:124 - ReplaceComparisonOperator != -> ==
   * 2 Weak Mutation 26: com.sleepycat.collections.StoredEntrySet.contains(Ljava/lang/Object;)Z:125 - ReplaceConstant - 0 -> 1
   * 3 com.sleepycat.collections.StoredEntrySet.contains(Ljava/lang/Object;)Z: I4 Branch 4 IFNE L124 - false
   * 4 Weak Mutation 25: com.sleepycat.collections.StoredEntrySet.contains(Ljava/lang/Object;)Z:124 - ReplaceComparisonOperator != -> ==
   * 5 Weak Mutation 26: com.sleepycat.collections.StoredEntrySet.contains(Ljava/lang/Object;)Z:125 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test1()  throws Throwable  {
      StoredEntrySet storedEntrySet0 = new StoredEntrySet((DataView) null);
      boolean boolean0 = storedEntrySet0.contains((Object) "<dupCountLN/>");
      assertEquals(false, boolean0);
  }

  //Test case number: 2
  /*
   * 6 covered goals:
   * 1 Weak Mutation 40: com.sleepycat.collections.StoredEntrySet.toString()Ljava/lang/String;:144 - ReplaceConstant - [ -> 
   * 2 Weak Mutation 41: com.sleepycat.collections.StoredEntrySet.toString()Ljava/lang/String;:144 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 3 Weak Mutation 42: com.sleepycat.collections.StoredEntrySet.toString()Ljava/lang/String;:145 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 4 Weak Mutation 42: com.sleepycat.collections.StoredEntrySet.toString()Ljava/lang/String;:145 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 5 Weak Mutation 40: com.sleepycat.collections.StoredEntrySet.toString()Ljava/lang/String;:144 - ReplaceConstant - [ -> 
   * 6 Weak Mutation 41: com.sleepycat.collections.StoredEntrySet.toString()Ljava/lang/String;:144 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   */
  @Test
  public void test2()  throws Throwable  {
      StoredEntrySet storedEntrySet0 = new StoredEntrySet((DataView) null);
      // Undeclared exception!
      try {
        storedEntrySet0.toString();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 3
  /*
   * 3 covered goals:
   * 1 Weak Mutation 82: com.sleepycat.collections.StoredEntrySet.hasValues()Z:174 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.collections.StoredEntrySet.hasValues()Z: root-Branch
   * 3 Weak Mutation 82: com.sleepycat.collections.StoredEntrySet.hasValues()Z:174 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test3()  throws Throwable  {
      StoredEntrySet storedEntrySet0 = new StoredEntrySet((DataView) null);
      boolean boolean0 = storedEntrySet0.hasValues();
      assertEquals(true, boolean0);
  }
}
