/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.entry.INLogEntry;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestINLogEntry_3 {


  //Test case number: 3
  /*
   * 21 covered goals:
   * 1 Weak Mutation 59: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - InsertUnaryOp IINC 1
   * 2 Weak Mutation 58: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - InsertUnaryOp Negation
   * 3 Weak Mutation 57: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - DeleteField: inLcom/sleepycat/je/tree/IN;
   * 4 Weak Mutation 61: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 5 Weak Mutation 60: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 63: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - InsertUnaryOp Negation
   * 7 Weak Mutation 62: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 8 Weak Mutation 64: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 65: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 66: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 11 com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;: root-Branch
   * 12 Weak Mutation 59: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 58: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - InsertUnaryOp Negation
   * 14 Weak Mutation 57: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - DeleteField: inLcom/sleepycat/je/tree/IN;
   * 15 Weak Mutation 63: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - InsertUnaryOp Negation
   * 16 Weak Mutation 62: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 17 Weak Mutation 61: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 18 Weak Mutation 60: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:98 - InsertUnaryOp IINC -1
   * 19 Weak Mutation 64: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 65: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 66: com.sleepycat.je.log.entry.INLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:99 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   */
  @Test
  public void test3()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      byte[] byteArray0 = new byte[4];
      DIN dIN0 = new DIN();
      ChildReference childReference0 = dIN0.getDupCountLNRef();
      DIN dIN1 = new DIN(databaseImpl0, byteArray0, (int) (byte)0, byteArray0, childReference0, (int) (byte)0);
      INLogEntry iNLogEntry0 = new INLogEntry((IN) dIN1);
      StringBuffer stringBuffer0 = new StringBuffer(";wsv6");
      iNLogEntry0.dumpEntry(stringBuffer0, true);
      assertEquals(67111461L, dIN1.getNextNodeId());
      assertEquals(67111456L, iNLogEntry0.getNodeId());
  }
}