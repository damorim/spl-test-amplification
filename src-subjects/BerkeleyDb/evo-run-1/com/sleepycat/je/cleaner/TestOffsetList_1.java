/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.cleaner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.cleaner.OffsetList;

@RunWith(EvoSuiteRunner.class)
public class TestOffsetList_1 {


  //Test case number: 1
  /*
   * 40 covered goals:
   * 1 Weak Mutation 59: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - InsertUnaryOp Negation
   * 2 Weak Mutation 58: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 3 Weak Mutation 57: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - ReplaceConstant - Dup Offset  -> 
   * 4 Weak Mutation 63: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: getStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
   * 5 Weak Mutation 62: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: toString()Ljava/lang/String;
   * 6 Weak Mutation 61: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 7 Weak Mutation 60: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: toHexString(J)Ljava/lang/String;
   * 8 Weak Mutation 155: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:93 - ReplaceComparisonOperator >= -> -1
   * 9 Weak Mutation 156: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - InsertUnaryOp Negation
   * 10 Weak Mutation 157: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 158: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 159: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - DeleteStatement: get(I)J
   * 13 Weak Mutation 161: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - DeleteStatement: longSub(JJ)I
   * 14 Weak Mutation 160: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - InsertUnaryOp Negation
   * 15 Weak Mutation 164: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - ReplaceComparisonOperator != -> -1
   * 16 Weak Mutation 165: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:95 - ReplaceConstant - 1 -> 0
   * 17 Weak Mutation 34: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 35: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - InsertUnaryOp IINC -1
   * 19 Weak Mutation 32: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - DeleteField: values[I
   * 20 Weak Mutation 33: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - InsertUnaryOp Negation
   * 21 Weak Mutation 38: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - ReplaceConstant - -1 -> -2
   * 22 Weak Mutation 39: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - ReplaceBitwiseOperator & -> |
   * 23 Weak Mutation 36: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - ReplaceConstant - -1 -> 0
   * 24 Weak Mutation 37: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - ReplaceConstant - -1 -> 1
   * 25 Weak Mutation 40: com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J:134 - ReplaceBitwiseOperator & -> ^
   * 26 Weak Mutation 45: com.sleepycat.je.cleaner.OffsetList$Segment.size()I:152 - DeleteField: indexI
   * 27 com.sleepycat.je.cleaner.OffsetList$Segment.get(I)J: root-Branch
   * 28 com.sleepycat.je.cleaner.OffsetList.add(JZ)Z: I3 Branch 2 IFEQ L33 - true
   * 29 com.sleepycat.je.cleaner.OffsetList.add(JZ)Z: I11 Branch 4 IFEQ L34 - false
   * 30 com.sleepycat.je.cleaner.OffsetList.contains(J)Z: I16 Branch 15 IF_ICMPGE L93 - false
   * 31 com.sleepycat.je.cleaner.OffsetList.contains(J)Z: I24 Branch 16 IFNE L94 - false
   * 32 Weak Mutation 59: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - InsertUnaryOp Negation
   * 33 Weak Mutation 58: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 34 Weak Mutation 57: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - ReplaceConstant - Dup Offset  -> 
   * 35 Weak Mutation 63: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: getStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
   * 36 Weak Mutation 62: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: toString()Ljava/lang/String;
   * 37 Weak Mutation 61: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 38 Weak Mutation 60: com.sleepycat.je.cleaner.OffsetList.add(JZ)Z:34 - DeleteStatement: toHexString(J)Ljava/lang/String;
   * 39 Weak Mutation 165: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:95 - ReplaceConstant - 1 -> 0
   * 40 Weak Mutation 164: com.sleepycat.je.cleaner.OffsetList.contains(J)Z:94 - ReplaceComparisonOperator != -> -1
   */
  @Test
  public void test1()  throws Throwable  {
      OffsetList offsetList0 = new OffsetList();
      assertNotNull(offsetList0);
      
      offsetList0.add((-347L), false);
      // Undeclared exception!
      try {
        offsetList0.add((-347L), true);
        fail("Expecting exception: AssertionError");
      } catch(AssertionError e) {
        /*
         * java.lang.Exception: Dup Offset fffffffffffffea5
         * \tat com.sleepycat.je.cleaner.OffsetList.add(OffsetList.java:34)
         * \tat sun.reflect.GeneratedMethodAccessor7.invoke(Unknown Source)
         * \tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
         * \tat java.lang.reflect.Method.invoke(Method.java:597)
         * \tat org.evosuite.testcase.MethodStatement$1.execute(MethodStatement.java:260)
         * \tat org.evosuite.testcase.AbstractStatement.exceptionHandler(AbstractStatement.java:142)
         * \tat org.evosuite.testcase.MethodStatement.execute(MethodStatement.java:215)
         * \tat org.evosuite.testcase.TestRunnable.call(TestRunnable.java:291)
         * \tat org.evosuite.testcase.TestRunnable.call(TestRunnable.java:44)
         * \tat java.util.concurrent.FutureTask$Sync.innerRun(FutureTask.java:303)
         * \tat java.util.concurrent.FutureTask.run(FutureTask.java:138)
         * \tat java.util.concurrent.ThreadPoolExecutor$Worker.runTask(ThreadPoolExecutor.java:886)
         * \tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:908)
         * \tat java.lang.Thread.run(Thread.java:680)
         */
      }
  }
}
