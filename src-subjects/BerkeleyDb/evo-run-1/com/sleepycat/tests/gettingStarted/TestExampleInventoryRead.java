/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.tests.gettingStarted;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.LogException;
import com.sleepycat.tests.gettingStarted.ExampleInventoryRead;
import com.sleepycat.tests.gettingStarted.MyDbEnv;

@RunWith(EvoSuiteRunner.class)
public class TestExampleInventoryRead {


  //Test case number: 0
  /*
   * 8 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:33 - DeleteField: myDbEnvLcom/sleepycat/tests/gettingStarted/MyDbEnv;
   * 2 Weak Mutation 1: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:33 - DeleteField: myDbEnvPathLjava/io/File;
   * 3 Weak Mutation 3: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:33 - DeleteStatement: setup(Ljava/io/File;Z)V
   * 4 Weak Mutation 2: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:34 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 0: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:33 - DeleteField: myDbEnvLcom/sleepycat/tests/gettingStarted/MyDbEnv;
   * 6 Weak Mutation 1: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:33 - DeleteField: myDbEnvPathLjava/io/File;
   * 7 Weak Mutation 2: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:34 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 3: com.sleepycat.tests.gettingStarted.ExampleInventoryRead.run(Lcom/sleepycat/tests/gettingStarted/MyDbEnv;)V:33 - DeleteStatement: setup(Ljava/io/File;Z)V
   */
  @Test
  public void test0()  throws Throwable  {
      MyDbEnv myDbEnv0 = new MyDbEnv();
      try {
        ExampleInventoryRead.run(myDbEnv0);
        fail("Expecting exception: LogException");
      } catch(LogException e) {
        /*
         * Environment home /Users/sabrinasouto/git/spl-test-amplification/libs/gsgEnv doesn't exist
         */
      }
  }
}
