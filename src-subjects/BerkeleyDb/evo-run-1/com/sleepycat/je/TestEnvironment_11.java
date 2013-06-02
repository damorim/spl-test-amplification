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
public class TestEnvironment_11 {


  //Test case number: 11
  /*
   * 3 covered goals:
   * 1 Weak Mutation 165: com.sleepycat.je.Environment.addReferringHandle(Lcom/sleepycat/je/Database;)V:811 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 2 com.sleepycat.je.Environment.addReferringHandle(Lcom/sleepycat/je/Database;)V: root-Branch
   * 3 Weak Mutation 165: com.sleepycat.je.Environment.addReferringHandle(Lcom/sleepycat/je/Database;)V:811 - DeleteStatement: add(Ljava/lang/Object;)Z
   */
  @Test
  public void test11()  throws Throwable  {
      File file0 = new File("p!q");
      Environment environment0 = new Environment(file0);
      // Undeclared exception!
      try {
        environment0.addReferringHandle((Database) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}