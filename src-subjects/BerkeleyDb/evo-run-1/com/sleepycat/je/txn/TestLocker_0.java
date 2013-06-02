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
import com.sleepycat.je.txn.ThreadLocker;

@RunWith(EvoSuiteRunner.class)
public class TestLocker_0 {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.txn.Locker.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;ZZ)V:62 - DeleteStatement: getTxnManager()Lcom/sleepycat/je/txn/TxnManager;
   * 2 Weak Mutation 0: com.sleepycat.je.txn.Locker.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;ZZ)V:62 - DeleteStatement: getTxnManager()Lcom/sleepycat/je/txn/TxnManager;
   */
  @Test
  public void test0()  throws Throwable  {
      ThreadLocker threadLocker0 = null;
      try {
        threadLocker0 = new ThreadLocker((EnvironmentImpl) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}