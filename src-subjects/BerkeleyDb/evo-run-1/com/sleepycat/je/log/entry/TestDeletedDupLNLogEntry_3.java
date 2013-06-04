/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.entry.DeletedDupLNLogEntry;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDeletedDupLNLogEntry_3 {


  //Test case number: 3
  /*
   * 3 covered goals:
   * 1 Weak Mutation 27: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getDupKey()[B:81 - DeleteField: dataAsKey[B
   * 2 com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getDupKey()[B: root-Branch
   * 3 Weak Mutation 27: com.sleepycat.je.log.entry.DeletedDupLNLogEntry.getDupKey()[B:81 - DeleteField: dataAsKey[B
   */
  @Test
  public void test3()  throws Throwable  {
      LogEntryType logEntryType0 = LogEntryType.LOG_DEL_DUPLN_TRANSACTIONAL;
      NameLN nameLN0 = new NameLN();
      DatabaseId databaseId0 = nameLN0.getId();
      byte[] byteArray0 = new byte[2];
      DeletedDupLNLogEntry deletedDupLNLogEntry0 = new DeletedDupLNLogEntry(logEntryType0, (LN) nameLN0, databaseId0, byteArray0, byteArray0, (long) (byte)80, true);
      byte[] byteArray1 = deletedDupLNLogEntry0.getDupKey();
      assertNotNull(byteArray1);
      assertEquals(3422L, nameLN0.getNextNodeId());
  }
}
