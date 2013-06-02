/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.SecondaryConfig;
import com.sleepycat.je.log.LogException;
import java.io.File;

@RunWith(EvoSuiteRunner.class)
public class TestEnvironment_9 {


  //Test case number: 9
  /*
   * 3 covered goals:
   * 1 Weak Mutation 155: com.sleepycat.je.Environment.getMutableConfig()Lcom/sleepycat/je/EnvironmentMutableConfig;:704 - DeleteStatement: checkHandleIsValid()V
   * 2 com.sleepycat.je.Environment.getMutableConfig()Lcom/sleepycat/je/EnvironmentMutableConfig;: root-Branch
   * 3 Weak Mutation 155: com.sleepycat.je.Environment.getMutableConfig()Lcom/sleepycat/je/EnvironmentMutableConfig;:704 - DeleteStatement: checkHandleIsValid()V
   */
  @Test
  public void test9()  throws Throwable  {
      File file0 = new File((File) null, "22");
      Environment environment0 = new Environment(file0);
      try {
        environment0.getMutableConfig();
        fail("Expecting exception: DatabaseException");
      } catch(DatabaseException e) {
        /*
         * Attempt to use non-open Environment object().
         */
      }
  }
}