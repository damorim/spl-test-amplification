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
public class TestSequenceConfig_7 {


  //Test case number: 7
  /*
   * 5 covered goals:
   * 1 Weak Mutation 48: com.sleepycat.je.SequenceConfig.getWrap()Z:149 - DeleteField: wrapZ
   * 2 Weak Mutation 47: com.sleepycat.je.SequenceConfig.getWrap()Z:149 - InsertUnaryOp Negation
   * 3 Weak Mutation 47: com.sleepycat.je.SequenceConfig.getWrap()Z:149 - InsertUnaryOp Negation
   * 4 Weak Mutation 48: com.sleepycat.je.SequenceConfig.getWrap()Z:149 - DeleteField: wrapZ
   * 5 com.sleepycat.je.SequenceConfig.getWrap()Z: root-Branch
   */
  @Test
  public void test7()  throws Throwable  {
      SequenceConfig sequenceConfig0 = SequenceConfig.DEFAULT;
      boolean boolean0 = sequenceConfig0.getWrap();
      assertEquals(true, boolean0);
  }
}