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
public class TestDbCompat_24 {


  //Test case number: 24
  /*
   * 5 covered goals:
   * 1 com.sleepycat.compat.DbCompat.setUnsortedDuplicates(Lcom/sleepycat/je/DatabaseConfig;Z)V: I3 Branch 5 IFEQ L171 - false
   * 2 Weak Mutation 31: com.sleepycat.compat.DbCompat.setUnsortedDuplicates(Lcom/sleepycat/je/DatabaseConfig;Z)V:171 - ReplaceComparisonOperator == -> !=
   * 3 Weak Mutation 30: com.sleepycat.compat.DbCompat.setUnsortedDuplicates(Lcom/sleepycat/je/DatabaseConfig;Z)V:171 - InsertUnaryOp Negation
   * 4 Weak Mutation 31: com.sleepycat.compat.DbCompat.setUnsortedDuplicates(Lcom/sleepycat/je/DatabaseConfig;Z)V:171 - ReplaceComparisonOperator == -> !=
   * 5 Weak Mutation 30: com.sleepycat.compat.DbCompat.setUnsortedDuplicates(Lcom/sleepycat/je/DatabaseConfig;Z)V:171 - InsertUnaryOp Negation
   */
  @Test
  public void test24()  throws Throwable  {
      DatabaseConfig databaseConfig0 = DatabaseConfig.DEFAULT;
      // Undeclared exception!
      try {
        DbCompat.setUnsortedDuplicates(databaseConfig0, true);
        fail("Expecting exception: UnsupportedOperationException");
      } catch(UnsupportedOperationException e) {
      }
  }
}