/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.txn.LockGrantType;

@RunWith(EvoSuiteRunner.class)
public class TestLockGrantType {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.txn.LockGrantType.toString()Ljava/lang/String;:19 - DeleteField: nameLjava/lang/String;
   * 2 com.sleepycat.je.txn.LockGrantType.toString()Ljava/lang/String;: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.je.txn.LockGrantType.toString()Ljava/lang/String;:19 - DeleteField: nameLjava/lang/String;
   */
  @Test
  public void test0()  throws Throwable  {
      LockGrantType lockGrantType0 = LockGrantType.WAIT_RESTART;
      String string0 = lockGrantType0.toString();
      assertEquals("WAIT_RESTART", string0);
  }
}
