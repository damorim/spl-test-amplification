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
public class TestCool_1 {


  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 2: org.prevayler.foundation.Cool.sleep(J)V:16 - InsertUnaryOp Negation
   * 2 Weak Mutation 3: org.prevayler.foundation.Cool.sleep(J)V:16 - DeleteStatement: sleep(J)V
   * 3 org.prevayler.foundation.Cool.sleep(J)V: root-Branch
   * 4 Weak Mutation 2: org.prevayler.foundation.Cool.sleep(J)V:16 - InsertUnaryOp Negation
   * 5 Weak Mutation 3: org.prevayler.foundation.Cool.sleep(J)V:16 - DeleteStatement: sleep(J)V
   */
  @Test
  public void test1()  throws Throwable  {
      Cool.sleep(0L);
  }
}
