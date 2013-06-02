/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.JEVersion;

@RunWith(EvoSuiteRunner.class)
public class TestJEVersion_3 {


  //Test case number: 3
  /*
   * 9 covered goals:
   * 1 Weak Mutation 19: com.sleepycat.je.JEVersion.getPatch()I:48 - InsertUnaryOp +1
   * 2 Weak Mutation 18: com.sleepycat.je.JEVersion.getPatch()I:48 - InsertUnaryOp Negation
   * 3 Weak Mutation 21: com.sleepycat.je.JEVersion.getPatch()I:48 - DeleteField: patchNumI
   * 4 Weak Mutation 20: com.sleepycat.je.JEVersion.getPatch()I:48 - InsertUnaryOp -1
   * 5 com.sleepycat.je.JEVersion.getPatch()I: root-Branch
   * 6 Weak Mutation 19: com.sleepycat.je.JEVersion.getPatch()I:48 - InsertUnaryOp +1
   * 7 Weak Mutation 18: com.sleepycat.je.JEVersion.getPatch()I:48 - InsertUnaryOp Negation
   * 8 Weak Mutation 21: com.sleepycat.je.JEVersion.getPatch()I:48 - DeleteField: patchNumI
   * 9 Weak Mutation 20: com.sleepycat.je.JEVersion.getPatch()I:48 - InsertUnaryOp -1
   */
  @Test
  public void test3()  throws Throwable  {
      JEVersion jEVersion0 = JEVersion.CURRENT_VERSION;
      int int0 = jEVersion0.getPatch();
      assertEquals(30, int0);
  }
}