/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.log.LogException;
import java.io.File;

@RunWith(EvoSuiteRunner.class)
public class TestEnvironment_1 {


  //Test case number: 1
  /*
   * 12 covered goals:
   * 1 Weak Mutation 123: com.sleepycat.je.Environment.getHome()Ljava/io/File;:504 - DeleteStatement: checkHandleIsValid()V
   * 2 com.sleepycat.je.Environment.getHome()Ljava/io/File;: root-Branch
   * 3 Weak Mutation 19: com.sleepycat.je.Environment.<init>(Ljava/io/File;)V:82 - DeleteStatement: getInstance()Lcom/sleepycat/je/dbi/DbEnvPool;
   * 4 Weak Mutation 18: com.sleepycat.je.Environment.<init>(Ljava/io/File;)V:81 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 20: com.sleepycat.je.Environment.<init>(Ljava/io/File;)V:82 - DeleteStatement: getExistingEnvironment(Ljava/io/File;)Lcom/sleepycat/je/dbi/DbEnvPool$EnvironmentImplInfo;
   * 6 Weak Mutation 22: com.sleepycat.je.Environment.<init>(Ljava/io/File;)V:85 - ReplaceComparisonOperator = null -> != null
   * 7 Weak Mutation 123: com.sleepycat.je.Environment.getHome()Ljava/io/File;:504 - DeleteStatement: checkHandleIsValid()V
   * 8 Weak Mutation 171: com.sleepycat.je.Environment.checkHandleIsValid()V:847 - ReplaceComparisonOperator != -> ==
   * 9 Weak Mutation 169: com.sleepycat.je.Environment.checkHandleIsValid()V:847 - InsertUnaryOp Negation
   * 10 Weak Mutation 172: com.sleepycat.je.Environment.checkHandleIsValid()V:848 - ReplaceConstant - Attempt to use non-open Environment object(). -> 
   * 11 com.sleepycat.je.Environment.<init>(Ljava/io/File;)V: I28 Branch 5 IFNULL L85 - true
   * 12 com.sleepycat.je.Environment.checkHandleIsValid()V: I4 Branch 29 IFNE L847 - false
   */
  @Test
  public void test1()  throws Throwable  {
      File file0 = new File("");
      Environment environment0 = new Environment(file0);
      try {
        environment0.getHome();
        fail("Expecting exception: DatabaseException");
      } catch(DatabaseException e) {
        /*
         * Attempt to use non-open Environment object().
         */
      }
  }
}
