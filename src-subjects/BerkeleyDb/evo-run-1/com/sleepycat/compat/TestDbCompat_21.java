/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.compat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.compat.DbCompat;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.SecondaryConfig;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbCompat_21 {


  //Test case number: 21
  /*
   * 5 covered goals:
   * 1 com.sleepycat.compat.DbCompat.setInitializeCache(Lcom/sleepycat/je/EnvironmentConfig;Z)V: I3 Branch 2 IFNE L124 - true
   * 2 Weak Mutation 19: com.sleepycat.compat.DbCompat.setInitializeCache(Lcom/sleepycat/je/EnvironmentConfig;Z)V:124 - ReplaceComparisonOperator != -> ==
   * 3 Weak Mutation 18: com.sleepycat.compat.DbCompat.setInitializeCache(Lcom/sleepycat/je/EnvironmentConfig;Z)V:124 - InsertUnaryOp Negation
   * 4 Weak Mutation 19: com.sleepycat.compat.DbCompat.setInitializeCache(Lcom/sleepycat/je/EnvironmentConfig;Z)V:124 - ReplaceComparisonOperator != -> ==
   * 5 Weak Mutation 18: com.sleepycat.compat.DbCompat.setInitializeCache(Lcom/sleepycat/je/EnvironmentConfig;Z)V:124 - InsertUnaryOp Negation
   */
  @Test
  public void test21()  throws Throwable  {
      Properties properties0 = new Properties();
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig(properties0);
      DbCompat.setInitializeCache(environmentConfig0, true);
      assertEquals(false, environmentConfig0.getReadOnly());
  }
}
