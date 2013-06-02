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
public class TestLockInfo_5 {


  //Test case number: 5
  /*
   * 6 covered goals:
   * 1 com.sleepycat.je.txn.LockInfo.setLocker(Lcom/sleepycat/je/txn/Locker;)V: root-Branch
   * 2 Weak Mutation 3: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - InsertUnaryOp Negation
   * 3 Weak Mutation 4: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - DeleteField: deadlockStackTraceZ
   * 4 Weak Mutation 5: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - ReplaceComparisonOperator == -> !=
   * 5 Weak Mutation 6: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteField: traceExceptionMapLjava/util/Map;
   * 6 Weak Mutation 7: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteStatement: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   */
  @Test
  public void test5()  throws Throwable  {
      LockInfo lockInfo0 = new LockInfo((Locker) null, (LockType) null);
      assertNotNull(lockInfo0);
      
      lockInfo0.setLocker((Locker) null);
      assertEquals("<LockInfo locker=\"null\" type=\"null\"/> lock taken at: com.sleepycat.je.txn.LockInfo$StackTraceAtLockTime\n\tat com.sleepycat.je.txn.LockInfo.&lt;init&gt;(LockInfo.java:36)\n\tat sun.reflect.GeneratedConstructorAccessor5.newInstance(Unknown Source)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:27)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:513)\n\tat org.evosuite.testcase.ConstructorStatement$1.execute(ConstructorStatement.java:225)\n\tat org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)\n\tat org.evosuite.testcase.ConstructorStatement.execute(ConstructorStatement.java:187)\n\tat org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)\n\tat org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)\n\tat java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)\n\tat java.util.concurrent.FutureTask.run(FutureTask.java:138)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)\n\tat java.lang.Thread.run(Thread.java:680)\n", lockInfo0.toString());
  }
}