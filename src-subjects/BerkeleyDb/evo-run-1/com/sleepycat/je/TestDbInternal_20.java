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
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.JoinCursor;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.dbi.GetMode;
import com.sleepycat.je.txn.Locker;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbInternal_20 {


  //Test case number: 20
  /*
   * 5 covered goals:
   * 1 Weak Mutation 35: com.sleepycat.je.DbInternal.disableParameterValidation(Lcom/sleepycat/je/EnvironmentMutableConfig;)V:144 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 36: com.sleepycat.je.DbInternal.disableParameterValidation(Lcom/sleepycat/je/EnvironmentMutableConfig;)V:144 - DeleteStatement: setValidateParams(Z)V
   * 3 com.sleepycat.je.DbInternal.disableParameterValidation(Lcom/sleepycat/je/EnvironmentMutableConfig;)V: root-Branch
   * 4 Weak Mutation 35: com.sleepycat.je.DbInternal.disableParameterValidation(Lcom/sleepycat/je/EnvironmentMutableConfig;)V:144 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 36: com.sleepycat.je.DbInternal.disableParameterValidation(Lcom/sleepycat/je/EnvironmentMutableConfig;)V:144 - DeleteStatement: setValidateParams(Z)V
   */
  @Test
  public void test20()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      DbInternal.disableParameterValidation((EnvironmentMutableConfig) environmentConfig0);
      assertEquals(true, environmentConfig0.getCreateUP());
  }
}
