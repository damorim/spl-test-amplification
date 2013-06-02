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
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogException;
import java.io.File;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestEnvironment_14 {


  //Test case number: 14
  /*
   * 13 covered goals:
   * 1 com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V: I30 Branch 1 IFNONNULL L53 - true
   * 2 Weak Mutation 0: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:47 - DeleteStatement: synchronizedSet(Ljava/util/Set;)Ljava/util/Set;
   * 3 Weak Mutation 1: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:51 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 2: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:52 - ReplaceConstant - envHome -> 
   * 5 Weak Mutation 3: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:52 - DeleteStatement: checkForNullParam(Ljava/lang/Object;Ljava/lang/String;)V
   * 6 Weak Mutation 4: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:53 - ReplaceComparisonOperator != null -> = null
   * 7 Weak Mutation 6: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:55 - DeleteStatement: cloneConfig()Lcom/sleepycat/je/EnvironmentConfig;
   * 8 Weak Mutation 7: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:58 - DeleteStatement: getInstance()Lcom/sleepycat/je/dbi/DbEnvPool;
   * 9 Weak Mutation 8: com.sleepycat.je.Environment.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:58 - DeleteStatement: getEnvironment(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)Lcom/sleepycat/je/dbi/DbEnvPool$EnvironmentImplInfo;
   * 10 Weak Mutation 31: com.sleepycat.je.Environment.applyFileConfig(Ljava/io/File;Lcom/sleepycat/je/EnvironmentMutableConfig;)V:104 - ReplaceComparisonOperator == -> !=
   * 11 Weak Mutation 30: com.sleepycat.je.Environment.applyFileConfig(Ljava/io/File;Lcom/sleepycat/je/EnvironmentMutableConfig;)V:104 - DeleteStatement: getLoadPropertyFile()Z
   * 12 Weak Mutation 32: com.sleepycat.je.Environment.applyFileConfig(Ljava/io/File;Lcom/sleepycat/je/EnvironmentMutableConfig;)V:107 - ReplaceConstant - je.properties -> 
   * 13 Weak Mutation 126: com.sleepycat.je.Environment.copyToHandleConfig(Lcom/sleepycat/je/EnvironmentMutableConfig;Lcom/sleepycat/je/EnvironmentConfig;)V:524 - DeleteStatement: copyHandlePropsTo(Lcom/sleepycat/je/EnvironmentMutableConfig;)V
   */
  @Test
  public void test14()  throws Throwable  {
      File file0 = new File((String) null, "");
      Properties properties0 = new Properties();
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig(properties0);
      Environment environment0 = null;
      try {
        environment0 = new Environment(file0, environmentConfig0);
        fail("Expecting exception: LogException");
      } catch(LogException e) {
        /*
         * Environment home  doesn't exist
         */
      }
  }
}