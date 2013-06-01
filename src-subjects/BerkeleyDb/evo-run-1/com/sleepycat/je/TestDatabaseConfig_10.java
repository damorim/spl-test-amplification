/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseConfig;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseConfig_10 {


  //Test case number: 10
  /*
   * 5 covered goals:
   * 1 Weak Mutation 46: com.sleepycat.je.DatabaseConfig.getOverrideBtreeComparator()Z:159 - InsertUnaryOp Negation
   * 2 Weak Mutation 47: com.sleepycat.je.DatabaseConfig.getOverrideBtreeComparator()Z:159 - DeleteField: overrideBtreeComparatorZ
   * 3 com.sleepycat.je.DatabaseConfig.getOverrideBtreeComparator()Z: root-Branch
   * 4 Weak Mutation 46: com.sleepycat.je.DatabaseConfig.getOverrideBtreeComparator()Z:159 - InsertUnaryOp Negation
   * 5 Weak Mutation 47: com.sleepycat.je.DatabaseConfig.getOverrideBtreeComparator()Z:159 - DeleteField: overrideBtreeComparatorZ
   */
  @Test
  public void test10()  throws Throwable  {
      DatabaseConfig databaseConfig0 = DatabaseConfig.DEFAULT;
      boolean boolean0 = databaseConfig0.getOverrideBtreeComparator();
      assertEquals(true, boolean0);
  }
}
