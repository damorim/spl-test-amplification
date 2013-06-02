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
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogException;
import java.io.File;

@RunWith(EvoSuiteRunner.class)
public class TestEnvironmentImpl_0 {


  //Test case number: 0
  /*
   * 26 covered goals:
   * 1 Weak Mutation 13: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:191 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V: I63 Branch 1 IFNE L191 - false
   * 3 Weak Mutation 0: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:116 - ReplaceConstant - -1 -> 0
   * 4 Weak Mutation 1: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:116 - ReplaceConstant - -1 -> 1
   * 5 Weak Mutation 2: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:116 - ReplaceConstant - -1 -> -2
   * 6 Weak Mutation 3: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:176 - DeleteField: INITLcom/sleepycat/je/dbi/DbEnvState;
   * 7 Weak Mutation 4: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:182 - DeleteStatement: addConfigObserver(Lcom/sleepycat/je/dbi/EnvConfigObserver;)V
   * 8 Weak Mutation 5: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:183 - DeleteField: configManagerLcom/sleepycat/je/dbi/DbConfigManager;
   * 9 Weak Mutation 6: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:187 - DeleteField: configManagerLcom/sleepycat/je/dbi/DbConfigManager;
   * 10 Weak Mutation 7: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:187 - DeleteField: ENV_FORCED_YIELDLcom/sleepycat/je/config/BooleanConfigParam;
   * 11 Weak Mutation 8: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:187 - DeleteStatement: getBoolean(Lcom/sleepycat/je/config/BooleanConfigParam;)Z
   * 12 Weak Mutation 9: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:191 - DeleteField: configManagerLcom/sleepycat/je/dbi/DbConfigManager;
   * 13 Weak Mutation 10: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:191 - DeleteField: ENV_INIT_LOCKINGLcom/sleepycat/je/config/BooleanConfigParam;
   * 14 Weak Mutation 11: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:191 - DeleteStatement: getBoolean(Lcom/sleepycat/je/config/BooleanConfigParam;)Z
   * 15 Weak Mutation 12: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:191 - ReplaceComparisonOperator != -> ==
   * 16 Weak Mutation 13: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:191 - ReplaceConstant - 1 -> 0
   * 17 Weak Mutation 15: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:208 - DeleteField: configManagerLcom/sleepycat/je/dbi/DbConfigManager;
   * 18 Weak Mutation 17: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:208 - DeleteStatement: getBoolean(Lcom/sleepycat/je/config/BooleanConfigParam;)Z
   * 19 Weak Mutation 16: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:208 - DeleteField: ENV_RDONLYLcom/sleepycat/je/config/BooleanConfigParam;
   * 20 Weak Mutation 18: com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V:209 - InsertUnaryOp Negation
   * 21 Weak Mutation 192: com.sleepycat.je.dbi.EnvironmentImpl.getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;:1060 - DeleteField: configManagerLcom/sleepycat/je/dbi/DbConfigManager;
   * 22 Weak Mutation 227: com.sleepycat.je.dbi.EnvironmentImpl.addConfigObserver(Lcom/sleepycat/je/dbi/EnvConfigObserver;)V:1097 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 23 Weak Mutation 226: com.sleepycat.je.dbi.EnvironmentImpl.addConfigObserver(Lcom/sleepycat/je/dbi/EnvConfigObserver;)V:1097 - DeleteField: configObserversLjava/util/List;
   * 24 com.sleepycat.je.dbi.EnvironmentImpl.addConfigObserver(Lcom/sleepycat/je/dbi/EnvConfigObserver;)V: root-Branch
   * 25 com.sleepycat.je.dbi.EnvironmentImpl.getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;: root-Branch
   * 26 com.sleepycat.je.dbi.EnvironmentImpl.<init>(Ljava/io/File;Lcom/sleepycat/je/EnvironmentConfig;)V: I270 Branch 5 IFNULL L260 - true
   */
  @Test
  public void test0()  throws Throwable  {
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig();
      environmentConfig0.setLocking(false);
      File file0 = new File("Dfzzok=*PrqH(*wN");
      EnvironmentImpl environmentImpl0 = null;
      try {
        environmentImpl0 = new EnvironmentImpl(file0, environmentConfig0);
        fail("Expecting exception: LogException");
      } catch(LogException e) {
        /*
         * Environment home Dfzzok=*PrqH(*wN doesn't exist
         */
      }
  }
}