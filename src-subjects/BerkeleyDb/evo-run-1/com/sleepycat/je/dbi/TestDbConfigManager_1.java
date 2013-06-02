/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.config.LongConfigParam;
import com.sleepycat.je.dbi.DbConfigException;
import com.sleepycat.je.dbi.DbConfigManager;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbConfigManager_1 {


  //Test case number: 1
  /*
   * 7 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 2 Weak Mutation 2: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteStatement: getName()Ljava/lang/String;
   * 3 Weak Mutation 30: com.sleepycat.je.dbi.DbConfigManager.getLong(Lcom/sleepycat/je/config/LongConfigParam;)J:88 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 4 com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;: root-Branch
   * 5 Weak Mutation 1: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 6 Weak Mutation 2: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteStatement: getName()Ljava/lang/String;
   * 7 Weak Mutation 30: com.sleepycat.je.dbi.DbConfigManager.getLong(Lcom/sleepycat/je/config/LongConfigParam;)J:88 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   */
  @Test
  public void test1()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      DbConfigManager dbConfigManager0 = new DbConfigManager(environmentConfig0);
      // Undeclared exception!
      try {
        dbConfigManager0.getLong((LongConfigParam) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}