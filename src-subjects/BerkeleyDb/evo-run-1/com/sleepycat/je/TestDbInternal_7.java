/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestDbInternal_7 {


  //Test case number: 7
  /*
   * 3 covered goals:
   * 1 Weak Mutation 10: com.sleepycat.je.DbInternal.dbGetDatabaseImpl(Lcom/sleepycat/je/Database;)Lcom/sleepycat/je/dbi/DatabaseImpl;:66 - DeleteStatement: getDatabaseImpl()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 2 com.sleepycat.je.DbInternal.dbGetDatabaseImpl(Lcom/sleepycat/je/Database;)Lcom/sleepycat/je/dbi/DatabaseImpl;: root-Branch
   * 3 Weak Mutation 10: com.sleepycat.je.DbInternal.dbGetDatabaseImpl(Lcom/sleepycat/je/Database;)Lcom/sleepycat/je/dbi/DatabaseImpl;:66 - DeleteStatement: getDatabaseImpl()Lcom/sleepycat/je/dbi/DatabaseImpl;
   */
  @Test
  public void test7()  throws Throwable  {
      // Undeclared exception!
      try {
        DbInternal.dbGetDatabaseImpl((Database) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
