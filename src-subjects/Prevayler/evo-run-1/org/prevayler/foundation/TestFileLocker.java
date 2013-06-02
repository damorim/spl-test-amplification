/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.evosuite.Properties.SandboxMode;
import org.evosuite.sandbox.Sandbox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.prevayler.foundation.FileLocker;

@RunWith(EvoSuiteRunner.class)
public class TestFileLocker {

  private static ExecutorService executor; 

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = false; 
    org.evosuite.Properties.SANDBOX_MODE = SandboxMode.RECOMMENDED; 
    Sandbox.initializeSecurityManagerForSUT(); 
    executor = Executors.newCachedThreadPool(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    executor.shutdownNow(); 
    Sandbox.resetDefaultSecurityManager(); 
  } 

  @Before 
  public void initTestCase(){ 
    Sandbox.goingToExecuteSUTCode(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    Sandbox.doneWithExecutingSUTCode(); 
  } 


  //Test case number: 0
  /*
   * 40 covered goals:
   * 1 Weak Mutation 0: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:25 - DeleteStatement: getCanonicalFile()Ljava/io/File;
   * 2 Weak Mutation 1: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - ReplaceConstant - locked -> 
   * 3 Weak Mutation 2: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - ReplaceConstant - locked -> 
   * 4 Weak Mutation 3: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - DeleteStatement: setProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   * 5 Weak Mutation 4: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 6 Weak Mutation 5: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - ReplaceComparisonOperator <= -> ==
   * 7 Weak Mutation 9: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:29 - DeleteField: _fileLjava/io/File;
   * 8 Weak Mutation 10: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:29 - DeleteStatement: getParentFile()Ljava/io/File;
   * 9 Weak Mutation 11: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:29 - DeleteStatement: mkdirs()Z
   * 10 Weak Mutation 12: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:30 - DeleteField: _fileLjava/io/File;
   * 11 Weak Mutation 13: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:30 - DeleteStatement: createNewFile()Z
   * 12 Weak Mutation 27: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 13 Weak Mutation 26: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: getName()Ljava/lang/String;
   * 14 Weak Mutation 29: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 15 Weak Mutation 28: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - ReplaceConstant - - -> 
   * 16 Weak Mutation 31: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: getCanonicalPath()Ljava/lang/String;
   * 17 Weak Mutation 30: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteField: _fileLjava/io/File;
   * 18 Weak Mutation 32: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 19 Weak Mutation 33: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: toString()Ljava/lang/String;
   * 20 org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;: root-Branch
   * 21 org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V: I18 Branch 1 IFLE L26 - true
   * 22 Weak Mutation 0: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:25 - DeleteStatement: getCanonicalFile()Ljava/io/File;
   * 23 Weak Mutation 1: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - ReplaceConstant - locked -> 
   * 24 Weak Mutation 2: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - ReplaceConstant - locked -> 
   * 25 Weak Mutation 3: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - DeleteStatement: setProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   * 26 Weak Mutation 4: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 27 Weak Mutation 5: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:26 - ReplaceComparisonOperator <= -> ==
   * 28 Weak Mutation 9: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:29 - DeleteField: _fileLjava/io/File;
   * 29 Weak Mutation 10: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:29 - DeleteStatement: getParentFile()Ljava/io/File;
   * 30 Weak Mutation 11: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:29 - DeleteStatement: mkdirs()Z
   * 31 Weak Mutation 12: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:30 - DeleteField: _fileLjava/io/File;
   * 32 Weak Mutation 13: org.prevayler.foundation.FileLocker.<init>(Ljava/io/File;)V:30 - DeleteStatement: createNewFile()Z
   * 33 Weak Mutation 27: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 34 Weak Mutation 26: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: getName()Ljava/lang/String;
   * 35 Weak Mutation 29: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 36 Weak Mutation 28: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - ReplaceConstant - - -> 
   * 37 Weak Mutation 31: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: getCanonicalPath()Ljava/lang/String;
   * 38 Weak Mutation 30: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteField: _fileLjava/io/File;
   * 39 Weak Mutation 32: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 40 Weak Mutation 33: org.prevayler.foundation.FileLocker.propertyName()Ljava/lang/String;:46 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test0()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
        try {
          File file0 = new File(";g_d,zzO65R_WZ>Kw");
          FileLocker fileLocker0 = null;
          try {
            fileLocker0 = new FileLocker(file0);
            fail("Expecting exception: SecurityException");
          } catch(SecurityException e) {
            /*
             * Security manager blocks (java.io.FilePermission /Users/sabrinasouto/git/spl-test-amplification/;g_d,zzO65R_WZ>Kw write)
             * java.lang.Thread.getStackTrace(Thread.java:1503)
             * org.evosuite.sandbox.MSecurityManager.checkPermission(MSecurityManager.java:303)
             * java.lang.SecurityManager.checkWrite(SecurityManager.java:962)
             * java.io.File.createNewFile(File.java:882)
             * org.prevayler.foundation.FileLocker.<init>(FileLocker.java:30)
             * sun.reflect.GeneratedConstructorAccessor5.newInstance(Unknown Source)
             * sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:27)
             * java.lang.reflect.Constructor.newInstance(Constructor.java:513)
             * org.evosuite.testcase.ConstructorStatement$1.execute(ConstructorStatement.java:225)
             * org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
             * org.evosuite.testcase.ConstructorStatement.execute(ConstructorStatement.java:187)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
             * java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
             * java.util.concurrent.FutureTask.run(FutureTask.java:138)
             * java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
             * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
             * java.lang.Thread.run(Thread.java:680)
             */
          }
        } catch(Throwable t) {
            // Need to catch declared exceptions
        }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }
}
