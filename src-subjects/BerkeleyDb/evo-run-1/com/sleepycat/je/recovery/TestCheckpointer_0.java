/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.recovery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.recovery.Checkpointer;

@RunWith(EvoSuiteRunner.class)
public class TestCheckpointer_0 {


  //Test case number: 0
  /*
   * 3 covered goals:
   * 1 Weak Mutation 33: com.sleepycat.je.recovery.Checkpointer.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:110 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   * 2 com.sleepycat.je.recovery.Checkpointer.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V: root-Branch
   * 3 Weak Mutation 33: com.sleepycat.je.recovery.Checkpointer.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:110 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   */
  @Test
  public void test0()  throws Throwable  {
      Checkpointer checkpointer0 = null;
      try {
        checkpointer0 = new Checkpointer((EnvironmentImpl) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}