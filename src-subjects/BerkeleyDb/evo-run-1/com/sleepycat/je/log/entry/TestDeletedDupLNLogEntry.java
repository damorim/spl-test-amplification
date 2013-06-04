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
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.DeletedDupLNLogEntry;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.FileSummaryLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.txn.Txn;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDeletedDupLNLogEntry {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.<init>(Lcom/sleepycat/je/log/LogEntryType;Lcom/sleepycat/je/tree/LN;Lcom/sleepycat/je/dbi/DatabaseId;[B[BJZLcom/sleepycat/je/txn/Txn;)V:36 - ReplaceVariable dataAsKey -> key
   * 2 com.sleepycat.je.log.entry.DeletedDupLNLogEntry.<init>(Lcom/sleepycat/je/log/LogEntryType;Lcom/sleepycat/je/tree/LN;Lcom/sleepycat/je/dbi/DatabaseId;[B[BJZLcom/sleepycat/je/txn/Txn;)V: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.<init>(Lcom/sleepycat/je/log/LogEntryType;Lcom/sleepycat/je/tree/LN;Lcom/sleepycat/je/dbi/DatabaseId;[B[BJZLcom/sleepycat/je/txn/Txn;)V:36 - ReplaceVariable dataAsKey -> key
   */
  @Test
  public void test0()  throws Throwable  {
      MapLN mapLN0 = new MapLN();
      byte[] byteArray0 = new byte[1];
      byte[] byteArray1 = new byte[5];
      Txn txn0 = new Txn();
      DeletedDupLNLogEntry deletedDupLNLogEntry0 = new DeletedDupLNLogEntry((LogEntryType) null, (LN) mapLN0, (DatabaseId) null, byteArray0, byteArray1, 2L, true, txn0);
      assertEquals(2656L, mapLN0.getNextNodeId());
      assertEquals(2656L, mapLN0.getLastId());
  }

  //Test case number: 1
  /*
   * 19 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp Negation of entrySize
   * 2 Weak Mutation 2: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC 1 entrySize
   * 3 Weak Mutation 3: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC -1 entrySize
   * 4 Weak Mutation 4: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp Negation of entryTypeVersion
   * 5 Weak Mutation 5: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC 1 entryTypeVersion
   * 6 Weak Mutation 6: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC -1 entryTypeVersion
   * 7 Weak Mutation 7: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp Negation of readFullItem
   * 8 Weak Mutation 8: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC 1 readFullItem
   * 9 Weak Mutation 9: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC -1 readFullItem
   * 10 com.sleepycat.je.log.entry.DeletedDupLNLogEntry.<init>(Z)V: root-Branch
   * 11 Weak Mutation 1: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp Negation of entrySize
   * 12 Weak Mutation 2: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC 1 entrySize
   * 13 Weak Mutation 3: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC -1 entrySize
   * 14 Weak Mutation 4: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp Negation of entryTypeVersion
   * 15 Weak Mutation 5: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC 1 entryTypeVersion
   * 16 Weak Mutation 6: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC -1 entryTypeVersion
   * 17 Weak Mutation 7: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp Negation of readFullItem
   * 18 Weak Mutation 8: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC 1 readFullItem
   * 19 Weak Mutation 9: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.readEntry(Ljava/nio/ByteBuffer;IBZ)V:47 - InsertUnaryOp IINC -1 readFullItem
   */
  @Test
  public void test1()  throws Throwable  {
      DeletedDupLNLogEntry deletedDupLNLogEntry0 = new DeletedDupLNLogEntry(true);
      // Undeclared exception!
      try {
        deletedDupLNLogEntry0.readEntry((ByteBuffer) null, 32, (byte) (-18), true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 2
  /*
   * 7 covered goals:
   * 1 Weak Mutation 13: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:61 - InsertUnaryOp Negation of verbose
   * 2 Weak Mutation 14: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:61 - InsertUnaryOp IINC 1 verbose
   * 3 Weak Mutation 15: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:61 - InsertUnaryOp IINC -1 verbose
   * 4 com.sleepycat.je.log.entry.DeletedDupLNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;: root-Branch
   * 5 Weak Mutation 13: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:61 - InsertUnaryOp Negation of verbose
   * 6 Weak Mutation 14: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:61 - InsertUnaryOp IINC 1 verbose
   * 7 Weak Mutation 15: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.dumpEntry(Ljava/lang/StringBuffer;Z)Ljava/lang/StringBuffer;:61 - InsertUnaryOp IINC -1 verbose
   */
  @Test
  public void test2()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN((int) (byte) (-1));
      DatabaseId databaseId0 = new DatabaseId((int) (byte) (-1));
      byte[] byteArray0 = new byte[7];
      DeletedDupLNLogEntry deletedDupLNLogEntry0 = new DeletedDupLNLogEntry((LogEntryType) null, (LN) dupCountLN0, databaseId0, byteArray0, byteArray0, (-1L), false, (Txn) null);
      // Undeclared exception!
      try {
        deletedDupLNLogEntry0.dumpEntry((StringBuffer) null, false);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 3
  /*
   * 13 covered goals:
   * 1 Weak Mutation 21: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - DeleteStatement: getByteArrayLogSize([B)I
   * 2 Weak Mutation 20: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - DeleteField: dataAsKey[B
   * 3 Weak Mutation 23: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> %
   * 4 Weak Mutation 22: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> -
   * 5 Weak Mutation 25: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> *
   * 6 Weak Mutation 24: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> /
   * 7 com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I: root-Branch
   * 8 Weak Mutation 21: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - DeleteStatement: getByteArrayLogSize([B)I
   * 9 Weak Mutation 20: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - DeleteField: dataAsKey[B
   * 10 Weak Mutation 23: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> %
   * 11 Weak Mutation 22: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> -
   * 12 Weak Mutation 25: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> *
   * 13 Weak Mutation 24: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getLogSize()I:72 - ReplaceArithmeticOperator + -> /
   */
  @Test
  public void test3()  throws Throwable  {
      DupCountLN dupCountLN0 = new DupCountLN((int) (byte) (-1));
      DatabaseId databaseId0 = new DatabaseId((int) (byte) (-1));
      byte[] byteArray0 = new byte[7];
      DeletedDupLNLogEntry deletedDupLNLogEntry0 = new DeletedDupLNLogEntry((LogEntryType) null, (LN) dupCountLN0, databaseId0, byteArray0, byteArray0, (-1L), false, (Txn) null);
      int int0 = deletedDupLNLogEntry0.getLogSize();
      assertEquals(2683L, dupCountLN0.getNextNodeId());
      assertEquals(43, int0);
  }

  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 28: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getDupKey()[B:87 - DeleteField: dataAsKey[B
   * 2 com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getDupKey()[B: root-Branch
   * 3 Weak Mutation 28: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getDupKey()[B:87 - DeleteField: dataAsKey[B
   */
  @Test
  public void test4()  throws Throwable  {
      LogEntryType logEntryType0 = LogEntryType.LOG_NAMELN_TRANSACTIONAL;
      byte[] byteArray0 = new byte[1];
      FileSummaryLN fileSummaryLN0 = new FileSummaryLN();
      Txn txn0 = new Txn();
      DeletedDupLNLogEntry deletedDupLNLogEntry0 = new DeletedDupLNLogEntry(logEntryType0, (LN) fileSummaryLN0, (DatabaseId) null, byteArray0, byteArray0, (long) (byte)19, false, txn0);
      deletedDupLNLogEntry0.getDupKey();
      assertEquals(2714L, fileSummaryLN0.getLastId());
      assertEquals(2714L, fileSummaryLN0.getNextNodeId());
  }
}
