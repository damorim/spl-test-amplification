/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.FileHeader;
import com.sleepycat.je.log.LogReadable;
import com.sleepycat.je.log.entry.SingleItemLogEntry;
import com.sleepycat.je.tree.BIN;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@RunWith(EvoSuiteRunner.class)
public class TestSingleItemLogEntry_4 {


  //Test case number: 4
  /*
   * 5 covered goals:
   * 1 Weak Mutation 15: com.sleepycat.je.log.entry.SingleItemLogEntry.getTransactionId()J:58 - DeleteField: itemLcom/sleepycat/je/log/LogReadable;
   * 2 Weak Mutation 16: com.sleepycat.je.log.entry.SingleItemLogEntry.getTransactionId()J:58 - DeleteStatement: getTransactionId()J
   * 3 com.sleepycat.je.log.entry.SingleItemLogEntry.getTransactionId()J: root-Branch
   * 4 Weak Mutation 15: com.sleepycat.je.log.entry.SingleItemLogEntry.getTransactionId()J:58 - DeleteField: itemLcom/sleepycat/je/log/LogReadable;
   * 5 Weak Mutation 16: com.sleepycat.je.log.entry.SingleItemLogEntry.getTransactionId()J:58 - DeleteStatement: getTransactionId()J
   */
  @Test
  public void test4()  throws Throwable  {
      Class<?> class0 = SingleItemLogEntry.class;
      SingleItemLogEntry singleItemLogEntry0 = new SingleItemLogEntry(class0);
      FileHeader fileHeader0 = new FileHeader();
      singleItemLogEntry0.item = (LogReadable) fileHeader0;
      long long0 = singleItemLogEntry0.getTransactionId();
      assertEquals(0L, long0);
  }
}