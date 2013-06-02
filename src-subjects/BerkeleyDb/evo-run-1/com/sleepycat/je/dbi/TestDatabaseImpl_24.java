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
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseImpl_24 {


  //Test case number: 24
  /*
   * 2 covered goals:
   * 1 com.sleepycat.je.dbi.DatabaseImpl.setEnvironmentImpl(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V: root-Branch
   * 2 Weak Mutation 39: com.sleepycat.je.dbi.DatabaseImpl.initDefaultSettings()V:160 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   */
  @Test
  public void test24()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      // Undeclared exception!
      try {
        databaseImpl0.setEnvironmentImpl((EnvironmentImpl) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}