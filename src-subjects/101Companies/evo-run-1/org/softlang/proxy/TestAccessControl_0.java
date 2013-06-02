/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.proxy.AccessControl;

@RunWith(EvoSuiteRunner.class)
public class TestAccessControl_0 {


  //Test case number: 0
  /*
   * 8 covered goals:
   * 1 Weak Mutation 2: org.softlang.proxy.AccessControl.isReadable()Z:19 - InsertUnaryOp Negation
   * 2 Weak Mutation 3: org.softlang.proxy.AccessControl.isReadable()Z:19 - DeleteField: readZ
   * 3 org.softlang.proxy.AccessControl.isReadable()Z: root-Branch
   * 4 Weak Mutation 0: org.softlang.proxy.AccessControl.<init>()V:15 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 1: org.softlang.proxy.AccessControl.<init>()V:16 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 2: org.softlang.proxy.AccessControl.isReadable()Z:19 - InsertUnaryOp Negation
   * 7 Weak Mutation 3: org.softlang.proxy.AccessControl.isReadable()Z:19 - DeleteField: readZ
   * 8 org.softlang.proxy.AccessControl.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      AccessControl accessControl0 = new AccessControl();
      boolean boolean0 = accessControl0.isReadable();
      assertEquals(true, accessControl0.isWritable());
      assertEquals(true, boolean0);
  }
}