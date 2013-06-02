/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.txn.WriteLockInfo;
import com.sleepycat.je.utilint.TestHook;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseImpl_26 {


  //Test case number: 26
  /*
   * 3 covered goals:
   * 1 com.sleepycat.je.dbi.DatabaseImpl.setPendingDeletedHook(Lcom/sleepycat/je/utilint/TestHook;)V: root-Branch
   * 2 Weak Mutation 35: com.sleepycat.je.dbi.DatabaseImpl.<init>()V:142 - DeleteStatement: synchronizedSet(Ljava/util/Set;)Ljava/util/Set;
   * 3 Weak Mutation 36: com.sleepycat.je.dbi.DatabaseImpl.<init>()V:143 - DeleteStatement: getNextNodeId()J
   */
  @Test
  public void test26()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      databaseImpl0.setPendingDeletedHook((TestHook) null);
      assertEquals(115904L, databaseImpl0.getEofNodeId());
  }
}