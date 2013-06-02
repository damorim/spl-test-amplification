/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.prevayler.foundation.Cool;

@RunWith(EvoSuiteRunner.class)
public class TestCool_0 {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 0: org.prevayler.foundation.Cool.wait(Ljava/lang/Object;)V:8 - DeleteStatement: wait()V
   * 2 org.prevayler.foundation.Cool.wait(Ljava/lang/Object;)V: root-Branch
   * 3 Weak Mutation 0: org.prevayler.foundation.Cool.wait(Ljava/lang/Object;)V:8 - DeleteStatement: wait()V
   */
  @Test
  public void test0()  throws Throwable  {
      // Undeclared exception!
      try {
        Cool.wait((Object) "RE3W=bf");
        fail("Expecting exception: IllegalMonitorStateException");
      } catch(IllegalMonitorStateException e) {
      }
  }
}