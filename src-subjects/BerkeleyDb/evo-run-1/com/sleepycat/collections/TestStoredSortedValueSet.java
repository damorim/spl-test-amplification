/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.collections.DataView;
import com.sleepycat.collections.StoredSortedValueSet;

@RunWith(EvoSuiteRunner.class)
public class TestStoredSortedValueSet {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.collections.StoredSortedValueSet.checkKeyDerivation()V:87 - DeleteStatement: canDeriveKeyFromValue()Z
   * 2 com.sleepycat.collections.StoredSortedValueSet.<init>(Lcom/sleepycat/collections/DataView;)V: root-Branch
   * 3 Weak Mutation 1: com.sleepycat.collections.StoredSortedValueSet.checkKeyDerivation()V:87 - DeleteStatement: canDeriveKeyFromValue()Z
   */
  @Test
  public void test0()  throws Throwable  {
      StoredSortedValueSet storedSortedValueSet0 = null;
      try {
        storedSortedValueSet0 = new StoredSortedValueSet((DataView) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}