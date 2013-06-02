/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.StatsFileReader;

@RunWith(EvoSuiteRunner.class)
public class TestStatsFileReader_3 {


  //Test case number: 3
  /*
   * 3 covered goals:
   * 1 Weak Mutation 5: com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I:226 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I: I11 Branch 2 IFNONNULL L225 - false
   * 3 Weak Mutation 5: com.sleepycat.je.log.StatsFileReader$LogEntryTypeComparator.compare(Ljava/lang/Object;Ljava/lang/Object;)I:226 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test3()  throws Throwable  {
      StatsFileReader.LogEntryTypeComparator statsFileReader_LogEntryTypeComparator0 = new StatsFileReader.LogEntryTypeComparator();
      int int0 = statsFileReader_LogEntryTypeComparator0.compare((Object) "<dupCountLN>\n  <count v=\"0\"/>\n  <node>2213</node>\n  <data></data>\n</dupCountLN>", (Object) null);
      assertEquals(1, int0);
  }
}