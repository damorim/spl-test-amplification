/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.LNLogEntry;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestLNLogEntry_3 {


  //Test case number: 3
  /*
   * 29 covered goals:
   * 1 Weak Mutation 46: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - InsertUnaryOp IINC 1
   * 2 Weak Mutation 47: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - InsertUnaryOp IINC -1
   * 3 Weak Mutation 44: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - DeleteField: lnLcom/sleepycat/je/tree/LN;
   * 4 Weak Mutation 45: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - InsertUnaryOp Negation
   * 5 Weak Mutation 48: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 6 Weak Mutation 51: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 50: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - InsertUnaryOp Negation
   * 8 Weak Mutation 49: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 9 Weak Mutation 53: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 10 Weak Mutation 52: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 55: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 54: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - DeleteField: key[B
   * 13 Weak Mutation 57: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 14 Weak Mutation 56: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   * 15 com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;: root-Branch
   * 16 Weak Mutation 46: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 47: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 44: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - DeleteField: lnLcom/sleepycat/je/tree/LN;
   * 19 Weak Mutation 45: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - InsertUnaryOp Negation
   * 20 Weak Mutation 51: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - InsertUnaryOp IINC 1
   * 21 Weak Mutation 50: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - InsertUnaryOp Negation
   * 22 Weak Mutation 49: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 23 Weak Mutation 48: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:107 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 24 Weak Mutation 55: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - ReplaceConstant - 0 -> 1
   * 25 Weak Mutation 54: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - DeleteField: key[B
   * 26 Weak Mutation 53: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 27 Weak Mutation 52: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:108 - InsertUnaryOp IINC -1
   * 28 Weak Mutation 57: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 29 Weak Mutation 56: com.sleepycat.je.log.entry.LNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:109 - DeleteStatement: dumpString([BI)Ljava/lang/String;
   */
  @Test
  public void test3()  throws Throwable  {
      LogEntryType logEntryType0 = LogEntryType.LOG_BIN;
      DatabaseId databaseId0 = new DatabaseId();
      NameLN nameLN0 = new NameLN(databaseId0);
      byte[] byteArray0 = new byte[5];
      LNLogEntry lNLogEntry0 = new LNLogEntry(logEntryType0, (LN) nameLN0, databaseId0, byteArray0, (long) (byte)49, true);
      StringBuffer stringBuffer0 = new StringBuffer();
      StringBuffer stringBuffer1 = lNLogEntry0.dumpEntry(stringBuffer0, true);
      assertEquals(96, stringBuffer0.length());
      assertEquals("<nameLN><node>4659</node><data></data><dbId id=\"0\"/></nameLN><dbId id=\"0\"/><key v=\"0 0 0 0 0 \"/>", stringBuffer1.toString());
  }
}