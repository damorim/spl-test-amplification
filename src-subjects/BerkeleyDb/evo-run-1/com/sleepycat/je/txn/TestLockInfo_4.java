/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.txn.LockInfo;
import com.sleepycat.je.txn.LockType;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestLockInfo_4 {


  //Test case number: 4
  /*
   * 26 covered goals:
   * 1 Weak Mutation 23: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteField: lockTypeLcom/sleepycat/je/txn/LockType;
   * 2 Weak Mutation 12: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 0
   * 3 Weak Mutation 13: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 1
   * 4 Weak Mutation 14: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> -1
   * 5 Weak Mutation 15: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 499
   * 6 Weak Mutation 17: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - ReplaceConstant - <LockInfo locker=" -> 
   * 7 Weak Mutation 16: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 501
   * 8 Weak Mutation 18: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 9 Weak Mutation 21: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - ReplaceConstant - " type=" -> 
   * 10 Weak Mutation 20: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:75 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 11 Weak Mutation 22: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 12 Weak Mutation 25: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - ReplaceConstant - "/> -> 
   * 13 Weak Mutation 24: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 14 Weak Mutation 27: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - InsertUnaryOp Negation
   * 15 Weak Mutation 26: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 16 Weak Mutation 29: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - ReplaceComparisonOperator == -> !=
   * 17 Weak Mutation 28: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - DeleteField: deadlockStackTraceZ
   * 18 Weak Mutation 31: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:80 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 19 Weak Mutation 30: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:80 - DeleteField: traceExceptionMapLjava/util/Map;
   * 20 Weak Mutation 34: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:82 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 35: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:83 - DeleteStatement: getStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
   * 22 Weak Mutation 32: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:81 - ReplaceComparisonOperator = null -> != null
   * 23 Weak Mutation 33: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:82 - ReplaceConstant -  lock taken at:  -> 
   * 24 Weak Mutation 36: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:83 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 25 Weak Mutation 37: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:86 - DeleteStatement: toString()Ljava/lang/String;
   * 26 Weak Mutation 23: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteField: lockTypeLcom/sleepycat/je/txn/LockType;
   */
  @Test
  public void test4()  throws Throwable  {
      LockType lockType0 = LockType.NONE;
      LockInfo lockInfo0 = new LockInfo((Locker) null, lockType0);
      assertNotNull(lockInfo0);
      
      String string0 = lockInfo0.toString();
      assertNotNull(string0);
      assertEquals("<LockInfo locker=\"null\" type=\"NONE\"/> lock taken at: com.sleepycat.je.txn.LockInfo$StackTraceAtLockTime\n\tat com.sleepycat.je.txn.LockInfo.&lt;init&gt;(LockInfo.java:36)\n\tat sun.reflect.GeneratedConstructorAccessor5.newInstance(Unknown Source)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:27)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:513)\n\tat org.evosuite.testcase.ConstructorStatement$1.execute(ConstructorStatement.java:225)\n\tat org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)\n\tat org.evosuite.testcase.ConstructorStatement.execute(ConstructorStatement.java:187)\n\tat org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)\n\tat org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)\n\tat java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)\n\tat java.util.concurrent.FutureTask.run(FutureTask.java:138)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)\n\tat java.lang.Thread.run(Thread.java:680)\n", string0);
  }
}