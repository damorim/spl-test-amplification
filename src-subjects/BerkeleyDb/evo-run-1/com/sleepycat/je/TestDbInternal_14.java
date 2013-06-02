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
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.JoinCursor;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.txn.Locker;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbInternal_14 {


  //Test case number: 14
  /*
   * 9 covered goals:
   * 1 Weak Mutation 27: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - InsertUnaryOp IINC 1
   * 2 Weak Mutation 26: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - InsertUnaryOp Negation
   * 3 Weak Mutation 29: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - DeleteStatement: setTxnReadCommitted(Z)V
   * 4 Weak Mutation 28: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - InsertUnaryOp IINC -1
   * 5 com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V: root-Branch
   * 6 Weak Mutation 27: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 26: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - InsertUnaryOp Negation
   * 8 Weak Mutation 29: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - DeleteStatement: setTxnReadCommitted(Z)V
   * 9 Weak Mutation 28: com.sleepycat.je.DbInternal.setTxnReadCommitted(Lcom/sleepycat/je/EnvironmentConfig;Z)V:108 - InsertUnaryOp IINC -1
   */
  @Test
  public void test14()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      DbInternal.setTxnReadCommitted(environmentConfig0, false);
      assertEquals(false, environmentConfig0.getTxnReadCommitted());
  }
}