/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.SequenceConfig;

@RunWith(EvoSuiteRunner.class)
public class TestSequenceConfig_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 36: com.sleepycat.je.SequenceConfig.getInitialValue()J:93 - InsertUnaryOp Negation
   * 2 com.sleepycat.je.SequenceConfig.getInitialValue()J: root-Branch
   * 3 Weak Mutation 36: com.sleepycat.je.SequenceConfig.getInitialValue()J:93 - InsertUnaryOp Negation
   */
  @Test
  public void test6()  throws Throwable  {
      SequenceConfig sequenceConfig0 = SequenceConfig.DEFAULT;
      long long0 = sequenceConfig0.getInitialValue();
      assertEquals(0L, long0);
  }
}