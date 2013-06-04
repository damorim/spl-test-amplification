/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.tuple.TupleBase;
import com.sleepycat.bind.tuple.TupleOutput;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.util.DbVerify;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.evosuite.Properties.SandboxMode;
import org.evosuite.sandbox.Sandbox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

@RunWith(EvoSuiteRunner.class)
public class TestDbVerify {

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
   * 44 covered goals:
   * 1 Weak Mutation 69: com.sleepycat.je.util.DbVerify.openEnv()V:123 - ReplaceComparisonOperator != null -> = null
   * 2 Weak Mutation 70: com.sleepycat.je.util.DbVerify.openEnv()V:125 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 71: com.sleepycat.je.util.DbVerify.openEnv()V:125 - DeleteStatement: setReadOnly(Z)V
   * 4 Weak Mutation 77: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:141 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 78: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - InsertUnaryOp Negation
   * 6 Weak Mutation 79: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - DeleteField: quietZ
   * 7 Weak Mutation 81: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 80: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - ReplaceComparisonOperator == -> !=
   * 9 Weak Mutation 83: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - DeleteStatement: setPrintInfo(Z)V
   * 10 Weak Mutation 85: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp +1
   * 11 Weak Mutation 84: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp Negation
   * 12 Weak Mutation 86: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp -1
   * 13 Weak Mutation 89: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - ReplaceComparisonOperator <= -> <
   * 14 Weak Mutation 97: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:149 - DeleteStatement: openEnv()V
   * 15 com.sleepycat.je.util.DbVerify.openEnv()V: I4 Branch 14 IFNONNULL L123 - false
   * 16 com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z: I15 Branch 16 IFEQ L144 - false
   * 17 com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z: I26 Branch 17 IFLE L145 - true
   * 18 Weak Mutation 3: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:41 - ReplaceConstant - 0 -> 1
   * 19 Weak Mutation 4: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:42 - ReplaceConstant - 0 -> 1
   * 20 Weak Mutation 5: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:43 - ReplaceConstant - 0 -> 1
   * 21 Weak Mutation 6: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:70 - InsertUnaryOp Negation of quiet
   * 22 Weak Mutation 7: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:70 - InsertUnaryOp IINC 1 quiet
   * 23 Weak Mutation 8: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:70 - InsertUnaryOp IINC -1 quiet
   * 24 Weak Mutation 3: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:41 - ReplaceConstant - 0 -> 1
   * 25 Weak Mutation 4: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:42 - ReplaceConstant - 0 -> 1
   * 26 Weak Mutation 5: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:43 - ReplaceConstant - 0 -> 1
   * 27 Weak Mutation 6: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:70 - InsertUnaryOp Negation of quiet
   * 28 Weak Mutation 7: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:70 - InsertUnaryOp IINC 1 quiet
   * 29 Weak Mutation 8: com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V:70 - InsertUnaryOp IINC -1 quiet
   * 30 Weak Mutation 69: com.sleepycat.je.util.DbVerify.openEnv()V:123 - ReplaceComparisonOperator != null -> = null
   * 31 Weak Mutation 70: com.sleepycat.je.util.DbVerify.openEnv()V:125 - ReplaceConstant - 1 -> 0
   * 32 Weak Mutation 71: com.sleepycat.je.util.DbVerify.openEnv()V:125 - DeleteStatement: setReadOnly(Z)V
   * 33 Weak Mutation 77: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:141 - ReplaceConstant - 1 -> 0
   * 34 Weak Mutation 78: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - InsertUnaryOp Negation
   * 35 Weak Mutation 79: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - DeleteField: quietZ
   * 36 Weak Mutation 85: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp +1
   * 37 Weak Mutation 84: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp Negation
   * 38 Weak Mutation 86: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp -1
   * 39 Weak Mutation 81: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - ReplaceConstant - 0 -> 1
   * 40 Weak Mutation 80: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - ReplaceComparisonOperator == -> !=
   * 41 Weak Mutation 83: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - DeleteStatement: setPrintInfo(Z)V
   * 42 Weak Mutation 89: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - ReplaceComparisonOperator <= -> <
   * 43 Weak Mutation 97: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:149 - DeleteStatement: openEnv()V
   * 44 com.sleepycat.je.util.DbVerify.<init>(Lcom/sleepycat/je/Environment;Ljava/lang/String;Z)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      DbVerify dbVerify0 = new DbVerify((Environment) null, "0h>N(m*|zDA|:", true);
      byte[] byteArray0 = new byte[10];
      TupleOutput tupleOutput0 = new TupleOutput(byteArray0);
      PrintStream printStream0 = new PrintStream((OutputStream) tupleOutput0, true);
      // Undeclared exception!
      try {
        dbVerify0.verify(printStream0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
        /*
         * envHome cannot be null
         */
      }
  }

  //Test case number: 1
  /*
   * 18 covered goals:
   * 1 Weak Mutation 28: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - ReplaceComparisonOperator <= -> -1
   * 2 Weak Mutation 29: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:85 - ReplaceConstant - 1 -> 0
   * 3 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I24 Branch 1 IFLE L84 - false
   * 4 Weak Mutation 0: com.sleepycat.je.util.DbVerify.<init>()V:41 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 1: com.sleepycat.je.util.DbVerify.<init>()V:42 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 2: com.sleepycat.je.util.DbVerify.<init>()V:43 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 19: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - ReplaceVariable argc -> nArgs
   * 8 Weak Mutation 18: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:80 - ReplaceConstant - 0 -> 1
   * 9 Weak Mutation 21: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - InsertUnaryOp IINC 1 argc
   * 10 Weak Mutation 20: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - InsertUnaryOp Negation of argc
   * 11 Weak Mutation 23: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - ReplaceVariable argc -> nArgs
   * 12 Weak Mutation 22: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - InsertUnaryOp IINC -1 argc
   * 13 Weak Mutation 25: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 14 Weak Mutation 24: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - ReplaceConstant - -q -> 
   * 15 Weak Mutation 29: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:85 - ReplaceConstant - 1 -> 0
   * 16 Weak Mutation 28: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - ReplaceComparisonOperator <= -> -1
   * 17 com.sleepycat.je.util.DbVerify.<init>()V: root-Branch
   * 18 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I165 Branch 11 IF_ICMPLT L82 - true
   */
  @Test
  public void test1()  throws Throwable  {
      DbVerify dbVerify0 = new DbVerify();
      String[] stringArray0 = new String[7];
      stringArray0[0] = "";
      stringArray0[0] = "-q";
      // Undeclared exception!
      try {
        dbVerify0.parseArgs(stringArray0);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * StringEquals is not supposed to work on a null caller
         */
      }
  }

  //Test case number: 2
  /*
   * 29 covered goals:
   * 1 Weak Mutation 34: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - ReplaceComparisonOperator <= -> -1
   * 2 Weak Mutation 35: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:87 - DeleteField: outLjava/io/PrintStream;
   * 3 Weak Mutation 36: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:87 - DeleteField: CURRENT_VERSIONLcom/sleepycat/je/JEVersion;
   * 4 Weak Mutation 37: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:87 - DeleteStatement: println(Ljava/lang/Object;)V
   * 5 Weak Mutation 38: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:88 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 39: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:88 - DeleteStatement: exit(I)V
   * 7 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I37 Branch 2 IFLE L86 - false
   * 8 Weak Mutation 26: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - ReplaceComparisonOperator <= -> ==
   * 9 Weak Mutation 31: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 10 Weak Mutation 30: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - ReplaceConstant - -V -> 
   * 11 Weak Mutation 34: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - ReplaceComparisonOperator <= -> -1
   * 12 Weak Mutation 35: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:87 - DeleteField: outLjava/io/PrintStream;
   * 13 Weak Mutation 32: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - ReplaceComparisonOperator <= -> ==
   * 14 Weak Mutation 38: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:88 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 39: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:88 - DeleteStatement: exit(I)V
   * 16 Weak Mutation 36: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:87 - DeleteField: CURRENT_VERSIONLcom/sleepycat/je/JEVersion;
   * 17 Weak Mutation 37: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:87 - DeleteStatement: println(Ljava/lang/Object;)V
   * 18 Weak Mutation 42: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - ReplaceComparisonOperator <= -> ==
   * 19 Weak Mutation 40: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - ReplaceConstant - -h -> 
   * 20 Weak Mutation 41: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 21 Weak Mutation 63: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - ReplaceConstant - -s -> 
   * 22 Weak Mutation 64: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 23 Weak Mutation 65: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - ReplaceComparisonOperator <= -> ==
   * 24 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I24 Branch 1 IFLE L84 - true
   * 25 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I37 Branch 2 IFLE L86 - true
   * 26 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I54 Branch 3 IFLE L89 - true
   * 27 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I86 Branch 5 IFLE L95 - true
   * 28 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I115 Branch 7 IFLE L101 - true
   * 29 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I155 Branch 10 IFLE L110 - true
   */
  @Test
  public void test2()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          DbVerify dbVerify0 = new DbVerify();
          String[] stringArray0 = new String[10];
          stringArray0[0] = ";fd|R_>N_0";
          stringArray0[1] = ";fd|R_>N_0";
          stringArray0[2] = ";fd|R_>N_0";
          stringArray0[3] = ";fd|R_>N_0";
          stringArray0[4] = ";fd|R_>N_0";
          stringArray0[5] = ";fd|R_>N_0";
          stringArray0[6] = "-V";
          // Undeclared exception!
          try {
            dbVerify0.parseArgs(stringArray0);
            fail("Expecting exception: SecurityException");
          } catch(SecurityException e) {
            /*
             * Security manager blocks (java.lang.RuntimePermission exitVM.0)
             * java.lang.Thread.getStackTrace(Thread.java:1503)
             * org.evosuite.sandbox.MSecurityManager.checkPermission(MSecurityManager.java:303)
             * java.lang.SecurityManager.checkExit(SecurityManager.java:744)
             * java.lang.Runtime.exit(Runtime.java:88)
             * java.lang.System.exit(System.java:921)
             * com.sleepycat.je.util.DbVerify.parseArgs(DbVerify.java:88)
             * sun.reflect.GeneratedMethodAccessor4.invoke(Unknown Source)
             * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
             * java.lang.reflect.Method.invoke(Method.java:597)
             * org.evosuite.testcase.MethodStatement$1.execute(MethodStatement.java:260)
             * org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
             * org.evosuite.testcase.MethodStatement.execute(MethodStatement.java:215)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
             * java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
             * java.util.concurrent.FutureTask.run(FutureTask.java:138)
             * java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
             * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
             * java.lang.Thread.run(Thread.java:680)
             */
          }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 3
  /*
   * 49 covered goals:
   * 1 Weak Mutation 54: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceComparisonOperator >= -> >
   * 2 Weak Mutation 62: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:93 - DeleteStatement: printUsage(Ljava/lang/String;)V
   * 3 Weak Mutation 61: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:93 - ReplaceConstant - -h requires an argument -> 
   * 4 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I59 Branch 4 IF_ICMPGE L90 - true
   * 5 Weak Mutation 46: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp Negation of argc
   * 6 Weak Mutation 47: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC 1 argc
   * 7 Weak Mutation 44: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - ReplaceComparisonOperator <= -> -1
   * 8 Weak Mutation 45: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceVariable argc -> nArgs
   * 9 Weak Mutation 51: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC 1 nArgs
   * 10 Weak Mutation 50: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp Negation of nArgs
   * 11 Weak Mutation 49: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceVariable nArgs -> argc
   * 12 Weak Mutation 48: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC -1 argc
   * 13 Weak Mutation 55: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceComparisonOperator >= -> -1
   * 14 Weak Mutation 52: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC -1 nArgs
   * 15 Weak Mutation 59: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - InsertUnaryOp IINC -1 argc
   * 16 Weak Mutation 58: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - InsertUnaryOp IINC 1 argc
   * 17 Weak Mutation 57: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - InsertUnaryOp Negation of argc
   * 18 Weak Mutation 56: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - ReplaceVariable argc -> nArgs
   * 19 Weak Mutation 60: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - ReplaceVariable argc -> nArgs
   * 20 Weak Mutation 9: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:74 - DeleteField: errLjava/io/PrintStream;
   * 21 Weak Mutation 10: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:74 - DeleteStatement: println(Ljava/lang/String;)V
   * 22 Weak Mutation 11: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:75 - DeleteField: errLjava/io/PrintStream;
   * 23 Weak Mutation 12: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:75 - DeleteField: usageStringLjava/lang/String;
   * 24 Weak Mutation 13: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:75 - DeleteStatement: println(Ljava/lang/String;)V
   * 25 Weak Mutation 14: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - ReplaceConstant - -1 -> 0
   * 26 Weak Mutation 15: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - ReplaceConstant - -1 -> 1
   * 27 Weak Mutation 17: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - DeleteStatement: exit(I)V
   * 28 Weak Mutation 16: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - ReplaceConstant - -1 -> -2
   * 29 Weak Mutation 46: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp Negation of argc
   * 30 Weak Mutation 47: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC 1 argc
   * 31 Weak Mutation 44: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - ReplaceComparisonOperator <= -> -1
   * 32 Weak Mutation 45: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceVariable argc -> nArgs
   * 33 Weak Mutation 51: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC 1 nArgs
   * 34 Weak Mutation 50: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp Negation of nArgs
   * 35 Weak Mutation 49: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceVariable nArgs -> argc
   * 36 Weak Mutation 48: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC -1 argc
   * 37 Weak Mutation 55: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceComparisonOperator >= -> -1
   * 38 Weak Mutation 54: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - ReplaceComparisonOperator >= -> >
   * 39 Weak Mutation 52: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:90 - InsertUnaryOp IINC -1 nArgs
   * 40 Weak Mutation 59: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - InsertUnaryOp IINC -1 argc
   * 41 Weak Mutation 58: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - InsertUnaryOp IINC 1 argc
   * 42 Weak Mutation 57: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - InsertUnaryOp Negation of argc
   * 43 Weak Mutation 56: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - ReplaceVariable argc -> nArgs
   * 44 Weak Mutation 62: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:93 - DeleteStatement: printUsage(Ljava/lang/String;)V
   * 45 Weak Mutation 61: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:93 - ReplaceConstant - -h requires an argument -> 
   * 46 Weak Mutation 60: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:91 - ReplaceVariable argc -> nArgs
   * 47 com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V: root-Branch
   * 48 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I54 Branch 3 IFLE L89 - false
   * 49 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I59 Branch 4 IF_ICMPGE L90 - false
   */
  @Test
  public void test3()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          DbVerify dbVerify0 = new DbVerify();
          String[] stringArray0 = new String[9];
          stringArray0[0] = "-h";
          stringArray0[1] = "-h";
          stringArray0[2] = "-h";
          stringArray0[3] = "-h";
          stringArray0[4] = "-h";
          stringArray0[5] = "-h";
          stringArray0[6] = "-h";
          stringArray0[7] = "-h";
          stringArray0[8] = "-h";
          // Undeclared exception!
          try {
            dbVerify0.parseArgs(stringArray0);
            fail("Expecting exception: SecurityException");
          } catch(SecurityException e) {
            /*
             * Security manager blocks (java.lang.RuntimePermission exitVM.-1)
             * java.lang.Thread.getStackTrace(Thread.java:1503)
             * org.evosuite.sandbox.MSecurityManager.checkPermission(MSecurityManager.java:303)
             * java.lang.SecurityManager.checkExit(SecurityManager.java:744)
             * java.lang.Runtime.exit(Runtime.java:88)
             * java.lang.System.exit(System.java:921)
             * com.sleepycat.je.util.DbVerify.printUsage(DbVerify.java:76)
             * com.sleepycat.je.util.DbVerify.parseArgs(DbVerify.java:93)
             * sun.reflect.GeneratedMethodAccessor4.invoke(Unknown Source)
             * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
             * java.lang.reflect.Method.invoke(Method.java:597)
             * org.evosuite.testcase.MethodStatement$1.execute(MethodStatement.java:260)
             * org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
             * org.evosuite.testcase.MethodStatement.execute(MethodStatement.java:215)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
             * java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
             * java.util.concurrent.FutureTask.run(FutureTask.java:138)
             * java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
             * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
             * java.lang.Thread.run(Thread.java:680)
             */
          }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 74: com.sleepycat.je.util.DbVerify.closeEnv()V:132 - ReplaceComparisonOperator = null -> != null
   * 2 com.sleepycat.je.util.DbVerify.closeEnv()V: I4 Branch 15 IFNULL L132 - true
   * 3 Weak Mutation 74: com.sleepycat.je.util.DbVerify.closeEnv()V:132 - ReplaceComparisonOperator = null -> != null
   */
  @Test
  public void test4()  throws Throwable  {
      DbVerify dbVerify0 = new DbVerify();
      dbVerify0.closeEnv();
  }

  //Test case number: 5
  /*
   * 15 covered goals:
   * 1 Weak Mutation 82: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z: I15 Branch 16 IFEQ L144 - true
   * 3 Weak Mutation 69: com.sleepycat.je.util.DbVerify.openEnv()V:123 - ReplaceComparisonOperator != null -> = null
   * 4 Weak Mutation 70: com.sleepycat.je.util.DbVerify.openEnv()V:125 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 71: com.sleepycat.je.util.DbVerify.openEnv()V:125 - DeleteStatement: setReadOnly(Z)V
   * 6 Weak Mutation 77: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:141 - ReplaceConstant - 1 -> 0
   * 7 Weak Mutation 78: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - InsertUnaryOp Negation
   * 8 Weak Mutation 85: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp +1
   * 9 Weak Mutation 84: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp Negation
   * 10 Weak Mutation 86: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - InsertUnaryOp -1
   * 11 Weak Mutation 80: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - ReplaceComparisonOperator == -> !=
   * 12 Weak Mutation 83: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - DeleteStatement: setPrintInfo(Z)V
   * 13 Weak Mutation 89: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:145 - ReplaceComparisonOperator <= -> <
   * 14 Weak Mutation 97: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:149 - DeleteStatement: openEnv()V
   * 15 Weak Mutation 82: com.sleepycat.je.util.DbVerify.verify(Ljava/io/PrintStream;)Z:144 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test5()  throws Throwable  {
      DbVerify dbVerify0 = new DbVerify();
      byte[] byteArray0 = new byte[20];
      TupleOutput tupleOutput0 = TupleBase.newOutput(byteArray0);
      PrintStream printStream0 = new PrintStream((OutputStream) tupleOutput0);
      // Undeclared exception!
      try {
        dbVerify0.verify(printStream0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
        /*
         * envHome cannot be null
         */
      }
  }

  //Test case number: 6
  /*
   * 5 covered goals:
   * 1 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I91 Branch 6 IF_ICMPGE L96 - true
   * 2 Weak Mutation 67: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - ReplaceComparisonOperator <= -> -1
   * 3 Weak Mutation 67: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - ReplaceComparisonOperator <= -> -1
   * 4 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I86 Branch 5 IFLE L95 - false
   * 5 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I91 Branch 6 IF_ICMPGE L96 - false
   */
  @Test
  public void test6()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          DbVerify dbVerify0 = new DbVerify();
          String[] stringArray0 = new String[9];
          stringArray0[0] = "@FzL0";
          stringArray0[1] = "-s";
          stringArray0[3] = "-s";
          stringArray0[5] = "@FzL0";
          stringArray0[6] = "@FzL0";
          stringArray0[7] = "@FzL0";
          stringArray0[8] = "-s";
          // Undeclared exception!
          try {
            dbVerify0.parseArgs(stringArray0);
            fail("Expecting exception: SecurityException");
          } catch(SecurityException e) {
            /*
             * Security manager blocks (java.lang.RuntimePermission exitVM.-1)
             * java.lang.Thread.getStackTrace(Thread.java:1503)
             * org.evosuite.sandbox.MSecurityManager.checkPermission(MSecurityManager.java:303)
             * java.lang.SecurityManager.checkExit(SecurityManager.java:744)
             * java.lang.Runtime.exit(Runtime.java:88)
             * java.lang.System.exit(System.java:921)
             * com.sleepycat.je.util.DbVerify.printUsage(DbVerify.java:76)
             * com.sleepycat.je.util.DbVerify.parseArgs(DbVerify.java:99)
             * sun.reflect.GeneratedMethodAccessor4.invoke(Unknown Source)
             * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
             * java.lang.reflect.Method.invoke(Method.java:597)
             * org.evosuite.testcase.MethodStatement$1.execute(MethodStatement.java:260)
             * org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
             * org.evosuite.testcase.MethodStatement.execute(MethodStatement.java:215)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
             * java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
             * java.util.concurrent.FutureTask.run(FutureTask.java:138)
             * java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
             * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
             * java.lang.Thread.run(Thread.java:680)
             */
          }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 7
  /*
   * 33 covered goals:
   * 1 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I170 Branch 12 IFNONNULL L114 - false
   * 2 Weak Mutation 0: com.sleepycat.je.util.DbVerify.<init>()V:41 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 1: com.sleepycat.je.util.DbVerify.<init>()V:42 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 2: com.sleepycat.je.util.DbVerify.<init>()V:43 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 9: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:74 - DeleteField: errLjava/io/PrintStream;
   * 6 Weak Mutation 10: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:74 - DeleteStatement: println(Ljava/lang/String;)V
   * 7 Weak Mutation 11: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:75 - DeleteField: errLjava/io/PrintStream;
   * 8 Weak Mutation 12: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:75 - DeleteField: usageStringLjava/lang/String;
   * 9 Weak Mutation 13: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:75 - DeleteStatement: println(Ljava/lang/String;)V
   * 10 Weak Mutation 14: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - ReplaceConstant - -1 -> 0
   * 11 Weak Mutation 15: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - ReplaceConstant - -1 -> 1
   * 12 Weak Mutation 17: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - DeleteStatement: exit(I)V
   * 13 Weak Mutation 16: com.sleepycat.je.util.DbVerify.printUsage(Ljava/lang/String;)V:76 - ReplaceConstant - -1 -> -2
   * 14 Weak Mutation 19: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - ReplaceVariable argc -> nArgs
   * 15 Weak Mutation 18: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:80 - ReplaceConstant - 0 -> 1
   * 16 Weak Mutation 21: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - InsertUnaryOp IINC 1 argc
   * 17 Weak Mutation 20: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - InsertUnaryOp Negation of argc
   * 18 Weak Mutation 23: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - ReplaceVariable argc -> nArgs
   * 19 Weak Mutation 22: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:83 - InsertUnaryOp IINC -1 argc
   * 20 Weak Mutation 25: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 21 Weak Mutation 24: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - ReplaceConstant - -q -> 
   * 22 Weak Mutation 26: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:84 - ReplaceComparisonOperator <= -> ==
   * 23 Weak Mutation 31: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 24 Weak Mutation 30: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - ReplaceConstant - -V -> 
   * 25 Weak Mutation 32: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:86 - ReplaceComparisonOperator <= -> ==
   * 26 Weak Mutation 42: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - ReplaceComparisonOperator <= -> ==
   * 27 Weak Mutation 40: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - ReplaceConstant - -h -> 
   * 28 Weak Mutation 41: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:89 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 29 Weak Mutation 63: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - ReplaceConstant - -s -> 
   * 30 Weak Mutation 64: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 31 Weak Mutation 65: com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V:95 - ReplaceComparisonOperator <= -> ==
   * 32 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I155 Branch 10 IFLE L110 - false
   * 33 com.sleepycat.je.util.DbVerify.parseArgs([Ljava/lang/String;)V: I165 Branch 11 IF_ICMPLT L82 - false
   */
  @Test
  public void test7()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          DbVerify dbVerify0 = new DbVerify();
          String[] stringArray0 = new String[4];
          stringArray0[0] = "LI1|DW\"g&Hn)26X- +";
          stringArray0[1] = "LI1|DW\"g&Hn)26X- +";
          stringArray0[2] = "-c";
          stringArray0[3] = "-c";
          // Undeclared exception!
          try {
            dbVerify0.parseArgs(stringArray0);
            fail("Expecting exception: SecurityException");
          } catch(SecurityException e) {
            /*
             * Security manager blocks (java.lang.RuntimePermission exitVM.-1)
             * java.lang.Thread.getStackTrace(Thread.java:1503)
             * org.evosuite.sandbox.MSecurityManager.checkPermission(MSecurityManager.java:303)
             * java.lang.SecurityManager.checkExit(SecurityManager.java:744)
             * java.lang.Runtime.exit(Runtime.java:88)
             * java.lang.System.exit(System.java:921)
             * com.sleepycat.je.util.DbVerify.printUsage(DbVerify.java:76)
             * com.sleepycat.je.util.DbVerify.parseArgs(DbVerify.java:115)
             * sun.reflect.GeneratedMethodAccessor4.invoke(Unknown Source)
             * sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
             * java.lang.reflect.Method.invoke(Method.java:597)
             * org.evosuite.testcase.MethodStatement$1.execute(MethodStatement.java:260)
             * org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
             * org.evosuite.testcase.MethodStatement.execute(MethodStatement.java:215)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
             * org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
             * java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
             * java.util.concurrent.FutureTask.run(FutureTask.java:138)
             * java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
             * java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
             * java.lang.Thread.run(Thread.java:680)
             */
          }
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }
}
