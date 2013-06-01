/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.SecondaryConfig;

@RunWith(EvoSuiteRunner.class)
public class TestSecondaryConfig_1 {


  //Test case number: 1
  /*
   * 7 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.SecondaryConfig.setAllowPopulate(Z)V:55 - InsertUnaryOp Negation
   * 2 Weak Mutation 4: com.sleepycat.je.SecondaryConfig.setAllowPopulate(Z)V:55 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 5: com.sleepycat.je.SecondaryConfig.setAllowPopulate(Z)V:55 - InsertUnaryOp IINC -1
   * 4 com.sleepycat.je.SecondaryConfig.setAllowPopulate(Z)V: root-Branch
   * 5 Weak Mutation 3: com.sleepycat.je.SecondaryConfig.setAllowPopulate(Z)V:55 - InsertUnaryOp Negation
   * 6 Weak Mutation 4: com.sleepycat.je.SecondaryConfig.setAllowPopulate(Z)V:55 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 5: com.sleepycat.je.SecondaryConfig.setAllowPopulate(Z)V:55 - InsertUnaryOp IINC -1
   */
  @Test
  public void test1()  throws Throwable  {
      SecondaryConfig secondaryConfig0 = SecondaryConfig.DEFAULT;
      secondaryConfig0.setAllowPopulate(true);
      assertEquals(true, secondaryConfig0.getAllowPopulate());
  }
}
