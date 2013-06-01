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
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.JoinCursor;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.txn.Locker;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbInternal_21 {


  //Test case number: 21
  /*
   * 9 covered goals:
   * 1 Weak Mutation 38: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - InsertUnaryOp IINC 1
   * 2 Weak Mutation 39: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - InsertUnaryOp IINC -1
   * 3 Weak Mutation 37: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - InsertUnaryOp Negation
   * 4 Weak Mutation 40: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - DeleteStatement: setUseExistingConfig(Z)V
   * 5 com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V: root-Branch
   * 6 Weak Mutation 38: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 39: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - InsertUnaryOp IINC -1
   * 8 Weak Mutation 37: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - InsertUnaryOp Negation
   * 9 Weak Mutation 40: com.sleepycat.je.DbInternal.setUseExistingConfig(Lcom/sleepycat/je/DatabaseConfig;Z)V:150 - DeleteStatement: setUseExistingConfig(Z)V
   */
  @Test
  public void test21()  throws Throwable  {
      SecondaryConfig secondaryConfig0 = new SecondaryConfig();
      DbInternal.setUseExistingConfig((DatabaseConfig) secondaryConfig0, false);
      assertEquals(false, secondaryConfig0.getUseExistingConfig());
  }
}
