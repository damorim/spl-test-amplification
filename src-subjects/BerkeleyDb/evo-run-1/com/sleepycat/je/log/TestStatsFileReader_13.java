/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.FileReader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.StatsFileReader;

@RunWith(EvoSuiteRunner.class)
public class TestStatsFileReader_13 {


  //Test case number: 13
  /*
   * 5 covered goals:
   * 1 com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I: I20 Branch 3 IFEQ L228 - true
   * 2 Weak Mutation 0: com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I:222 - ReplaceComparisonOperator != null -> = null
   * 3 Weak Mutation 4: com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I:225 - ReplaceComparisonOperator != null -> = null
   * 4 Weak Mutation 6: com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I:228 - ReplaceComparisonOperator == -> !=
   * 5 Weak Mutation 11: com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I:234 - ReplaceConstant - non LogEntryType passed to LogEntryType.compare -> 
   */
  @Test
  public void test13()  throws Throwable  {
      StatsFileReader.LogEntryTypeComparator statsFileReader_LogEntryTypeComparator0 = new StatsFileReader.LogEntryTypeComparator();
      Object object0 = new Object();
      // Undeclared exception!
      try {
        statsFileReader_LogEntryTypeComparator0.compare(object0, object0);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * non LogEntryType passed to LogEntryType.compare
         */
      }
  }
}