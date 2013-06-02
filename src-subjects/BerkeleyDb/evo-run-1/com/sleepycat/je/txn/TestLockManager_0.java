/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.txn.DummyLockManager;

@RunWith(EvoSuiteRunner.class)
public class TestLockManager_0 {


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.txn.LockManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:45 - ReplaceConstant - 1 -> 0
   * 2 Weak Mutation 4: com.sleepycat.je.txn.LockManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:61 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   * 3 Weak Mutation 3: com.sleepycat.je.txn.LockManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:45 - ReplaceConstant - 1 -> 0
   * 4 Weak Mutation 4: com.sleepycat.je.txn.LockManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:61 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   */
  @Test
  public void test0()  throws Throwable  {
      DummyLockManager dummyLockManager0 = null;
      try {
        dummyLockManager0 = new DummyLockManager((EnvironmentImpl) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}