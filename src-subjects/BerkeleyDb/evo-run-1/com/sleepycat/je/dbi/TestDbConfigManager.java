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
import com.sleepycat.je.config.BooleanConfigParam;
import com.sleepycat.je.config.IntConfigParam;
import com.sleepycat.je.config.LongConfigParam;
import com.sleepycat.je.config.ShortConfigParam;
import com.sleepycat.je.dbi.DbConfigException;
import com.sleepycat.je.dbi.DbConfigManager;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbConfigManager {


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.dbi.DbConfigManager.getEnvironmentConfig()Lcom/sleepycat/je/EnvironmentConfig;:21 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 2 com.sleepycat.je.dbi.DbConfigManager.getEnvironmentConfig()Lcom/sleepycat/je/EnvironmentConfig;: root-Branch
   * 3 com.sleepycat.je.dbi.DbConfigManager.<init>(Lcom/sleepycat/je/EnvironmentConfig;)V: root-Branch
   * 4 Weak Mutation 0: com.sleepycat.je.dbi.DbConfigManager.getEnvironmentConfig()Lcom/sleepycat/je/EnvironmentConfig;:21 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   */
  @Test
  public void test0()  throws Throwable  {
      Properties properties0 = new Properties();
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig(properties0);
      DbConfigManager dbConfigManager0 = new DbConfigManager(environmentConfig0);
      EnvironmentConfig environmentConfig1 = dbConfigManager0.getEnvironmentConfig();
      assertEquals(false, environmentConfig1.getTxnSerializableIsolation());
  }

  //Test case number: 1
  /*
   * 8 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 2 Weak Mutation 2: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteStatement: getName()Ljava/lang/String;
   * 3 Weak Mutation 6: com.sleepycat.je.dbi.DbConfigManager.getBoolean(Lcom/sleepycat/je/config/BooleanConfigParam;)Z:45 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 4 com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;: root-Branch
   * 5 com.sleepycat.je.dbi.DbConfigManager.getBoolean(Lcom/sleepycat/je/config/BooleanConfigParam;)Z: root-Branch
   * 6 Weak Mutation 1: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 7 Weak Mutation 2: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteStatement: getName()Ljava/lang/String;
   * 8 Weak Mutation 6: com.sleepycat.je.dbi.DbConfigManager.getBoolean(Lcom/sleepycat/je/config/BooleanConfigParam;)Z:45 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   */
  @Test
  public void test1()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      DbConfigManager dbConfigManager0 = new DbConfigManager(environmentConfig0);
      // Undeclared exception!
      try {
        dbConfigManager0.getBoolean((BooleanConfigParam) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 2
  /*
   * 5 covered goals:
   * 1 Weak Mutation 4: com.sleepycat.je.dbi.DbConfigManager.get(Ljava/lang/String;)Ljava/lang/String;:37 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 2 Weak Mutation 5: com.sleepycat.je.dbi.DbConfigManager.get(Ljava/lang/String;)Ljava/lang/String;:37 - DeleteStatement: getConfigParam(Ljava/lang/String;)Ljava/lang/String;
   * 3 com.sleepycat.je.dbi.DbConfigManager.get(Ljava/lang/String;)Ljava/lang/String;: root-Branch
   * 4 Weak Mutation 4: com.sleepycat.je.dbi.DbConfigManager.get(Ljava/lang/String;)Ljava/lang/String;:37 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 5 Weak Mutation 5: com.sleepycat.je.dbi.DbConfigManager.get(Ljava/lang/String;)Ljava/lang/String;:37 - DeleteStatement: getConfigParam(Ljava/lang/String;)Ljava/lang/String;
   */
  @Test
  public void test2()  throws Throwable  {
      Properties properties0 = new Properties();
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig(properties0);
      DbConfigManager dbConfigManager0 = new DbConfigManager(environmentConfig0);
      try {
        dbConfigManager0.get("'J}7");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * 'J}7 is not a valid BDBJE environment configuration
         */
      }
  }

  //Test case number: 3
  /*
   * 2 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.dbi.DbConfigManager.getShort(Lcom/sleepycat/je/config/ShortConfigParam;)S:54 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 2 Weak Mutation 9: com.sleepycat.je.dbi.DbConfigManager.getShort(Lcom/sleepycat/je/config/ShortConfigParam;)S:54 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   */
  @Test
  public void test3()  throws Throwable  {
      DbConfigManager dbConfigManager0 = new DbConfigManager((EnvironmentConfig) null);
      // Undeclared exception!
      try {
        dbConfigManager0.getShort((ShortConfigParam) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 4
  /*
   * 2 covered goals:
   * 1 Weak Mutation 19: com.sleepycat.je.dbi.DbConfigManager.getInt(Lcom/sleepycat/je/config/IntConfigParam;)I:70 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 2 Weak Mutation 19: com.sleepycat.je.dbi.DbConfigManager.getInt(Lcom/sleepycat/je/config/IntConfigParam;)I:70 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   */
  @Test
  public void test4()  throws Throwable  {
      Properties properties0 = new Properties();
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig(properties0);
      DbConfigManager dbConfigManager0 = new DbConfigManager(environmentConfig0);
      // Undeclared exception!
      try {
        dbConfigManager0.getInt((IntConfigParam) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 5
  /*
   * 4 covered goals:
   * 1 Weak Mutation 30: com.sleepycat.je.dbi.DbConfigManager.getLong(Lcom/sleepycat/je/config/LongConfigParam;)J:88 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   * 2 Weak Mutation 1: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteField: environmentConfigLcom/sleepycat/je/EnvironmentConfig;
   * 3 Weak Mutation 2: com.sleepycat.je.dbi.DbConfigManager.get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;:29 - DeleteStatement: getName()Ljava/lang/String;
   * 4 Weak Mutation 30: com.sleepycat.je.dbi.DbConfigManager.getLong(Lcom/sleepycat/je/config/LongConfigParam;)J:88 - DeleteStatement: get(Lcom/sleepycat/je/config/ConfigParam;)Ljava/lang/String;
   */
  @Test
  public void test5()  throws Throwable  {
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