/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.LogException;
import java.io.File;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestFileManager_2 {


  //Test case number: 2
  /*
   * 27 covered goals:
   * 1 Weak Mutation 51: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - ReplaceConstant - Environment home  -> 
   * 2 Weak Mutation 55: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 3 Weak Mutation 54: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - ReplaceConstant -  doesn't exist -> 
   * 4 Weak Mutation 53: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 5 Weak Mutation 52: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 6 Weak Mutation 56: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: toString()Ljava/lang/String;
   * 7 com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V: I65 Branch 9 IFNE L147 - false
   * 8 Weak Mutation 38: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:79 - ReplaceConstant - 0 -> 1
   * 9 Weak Mutation 39: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:116 - ReplaceConstant - 0 -> 1
   * 10 Weak Mutation 37: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:75 - ReplaceConstant - 1 -> 0
   * 11 Weak Mutation 42: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:1393 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 43: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:130 - InsertUnaryOp Negation
   * 13 Weak Mutation 40: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:116 - ReplaceConstant - 0 -> -1
   * 14 Weak Mutation 41: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:1392 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 46: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:131 - DeleteStatement: getConfigManager()Lcom/sleepycat/je/dbi/DbConfigManager;
   * 16 Weak Mutation 47: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:132 - DeleteField: LOG_FILE_MAXLcom/sleepycat/je/config/LongConfigParam;
   * 17 Weak Mutation 44: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:130 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 45: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:130 - InsertUnaryOp IINC -1
   * 19 Weak Mutation 50: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:147 - ReplaceComparisonOperator != -> ==
   * 20 Weak Mutation 49: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:147 - DeleteStatement: exists()Z
   * 21 Weak Mutation 48: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:132 - DeleteStatement: getLong(Lcom/sleepycat/je/config/LongConfigParam;)J
   * 22 Weak Mutation 51: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - ReplaceConstant - Environment home  -> 
   * 23 Weak Mutation 55: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 24 Weak Mutation 54: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - ReplaceConstant -  doesn't exist -> 
   * 25 Weak Mutation 53: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 26 Weak Mutation 52: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 27 Weak Mutation 56: com.sleepycat.je.log.FileManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Ljava/io/File;Z)V:148 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test2()  throws Throwable  {
      File file0 = new File("x@P=p#$%Ws", "x@P=p#$%Ws");
      Properties properties0 = new Properties();
      EnvironmentConfig environmentConfig0 = new EnvironmentConfig(properties0);
      EnvironmentImpl environmentImpl0 = null;
      try {
        environmentImpl0 = new EnvironmentImpl(file0, environmentConfig0);
        fail("Expecting exception: LogException");
      } catch(LogException e) {
        /*
         * Environment home x@P=p#$%Ws/x@P=p#$%Ws doesn't exist
         */
      }
  }
}
