/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.FileHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogException;

@RunWith(EvoSuiteRunner.class)
public class TestFileHeader_6 {


  //Test case number: 6
  /*
   * 3 covered goals:
   * 1 Weak Mutation 45: com.sleepycat.je.log.FileHeader.getLogType()Lcom/sleepycat/je/log/LogEntryType;:48 - DeleteField: LOG_FILE_HEADERLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.log.FileHeader.getLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 45: com.sleepycat.je.log.FileHeader.getLogType()Lcom/sleepycat/je/log/LogEntryType;:48 - DeleteField: LOG_FILE_HEADERLcom/sleepycat/je/log/LogEntryType;
   */
  @Test
  public void test6()  throws Throwable  {
      FileHeader fileHeader0 = new FileHeader();
      LogEntryType logEntryType0 = fileHeader0.getLogType();
      assertEquals(25, logEntryType0.getTypeNum());
  }
}
