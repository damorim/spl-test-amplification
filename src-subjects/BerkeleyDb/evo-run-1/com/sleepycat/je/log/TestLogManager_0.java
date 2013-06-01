/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.SyncedLogManager;

@RunWith(EvoSuiteRunner.class)
public class TestLogManager_0 {


  //Test case number: 0
  /*
   * 9 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:73 - ReplaceConstant - -1 -> 0
   * 2 Weak Mutation 2: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:73 - ReplaceConstant - -1 -> 1
   * 3 Weak Mutation 3: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:73 - ReplaceConstant - -1 -> -2
   * 4 Weak Mutation 4: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:86 - DeleteStatement: getFileManager()Lcom/sleepycat/je/log/FileManager;
   * 5 com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V: root-Branch
   * 6 Weak Mutation 1: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:73 - ReplaceConstant - -1 -> 0
   * 7 Weak Mutation 2: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:73 - ReplaceConstant - -1 -> 1
   * 8 Weak Mutation 3: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:73 - ReplaceConstant - -1 -> -2
   * 9 Weak Mutation 4: com.sleepycat.je.log.LogManager.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;Z)V:86 - DeleteStatement: getFileManager()Lcom/sleepycat/je/log/FileManager;
   */
  @Test
  public void test0()  throws Throwable  {
      SyncedLogManager syncedLogManager0 = null;
      try {
        syncedLogManager0 = new SyncedLogManager((EnvironmentImpl) null, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
