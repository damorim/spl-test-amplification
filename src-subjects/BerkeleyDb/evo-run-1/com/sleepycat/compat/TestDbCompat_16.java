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
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.SecondaryConfig;
import java.util.Comparator;

@RunWith(EvoSuiteRunner.class)
public class TestDbCompat_16 {


  //Test case number: 16
  /*
   * 2 covered goals:
   * 1 Weak Mutation 35: com.sleepycat.compat.DbCompat.setRecordLength(Lcom/sleepycat/je/DatabaseConfig;I)V:176 - ReplaceComparisonOperator == -> >=
   * 2 Weak Mutation 35: com.sleepycat.compat.DbCompat.setRecordLength(Lcom/sleepycat/je/DatabaseConfig;I)V:176 - ReplaceComparisonOperator == -> >=
   */
  @Test
  public void test16()  throws Throwable  {
      // Undeclared exception!
      try {
        DbCompat.setRecordLength((DatabaseConfig) null, 1);
        fail("Expecting exception: UnsupportedOperationException");
      } catch(UnsupportedOperationException e) {
      }
  }
}