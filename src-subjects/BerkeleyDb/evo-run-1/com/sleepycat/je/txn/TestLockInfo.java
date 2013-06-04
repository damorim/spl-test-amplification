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
import com.sleepycat.je.txn.Txn;

@RunWith(EvoSuiteRunner.class)
public class TestLockInfo {


  //Test case number: 0
  /*
   * 60 covered goals:
   * 1 Weak Mutation 2: com.sleepycat.je.txn.LockInfo.getDeadlockStackTrace()Z:27 - DeleteField: deadlockStackTraceZ
   * 2 Weak Mutation 3: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - InsertUnaryOp Negation
   * 3 Weak Mutation 4: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - DeleteField: deadlockStackTraceZ
   * 4 Weak Mutation 5: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - ReplaceComparisonOperator == -> !=
   * 5 Weak Mutation 6: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteField: traceExceptionMapLjava/util/Map;
   * 6 Weak Mutation 7: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteStatement: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   * 7 Weak Mutation 10: com.sleepycat.je.txn.LockInfo.dump()V:70 - DeleteField: outLjava/io/PrintStream;
   * 8 Weak Mutation 11: com.sleepycat.je.txn.LockInfo.dump()V:70 - DeleteStatement: println(Ljava/lang/Object;)V
   * 9 Weak Mutation 12: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 0
   * 10 Weak Mutation 13: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 1
   * 11 Weak Mutation 14: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> -1
   * 12 Weak Mutation 15: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 499
   * 13 Weak Mutation 16: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 501
   * 14 Weak Mutation 17: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - ReplaceConstant - <LockInfo locker=" -> 
   * 15 Weak Mutation 18: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 16 Weak Mutation 20: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:75 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 21: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - ReplaceConstant - " type=" -> 
   * 18 Weak Mutation 22: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 19 Weak Mutation 24: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 20 Weak Mutation 25: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - ReplaceConstant - "/> -> 
   * 21 Weak Mutation 26: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 22 Weak Mutation 27: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - InsertUnaryOp Negation
   * 23 Weak Mutation 29: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - ReplaceComparisonOperator == -> !=
   * 24 Weak Mutation 37: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:86 - DeleteStatement: toString()Ljava/lang/String;
   * 25 com.sleepycat.je.txn.LockInfo.dump()V: root-Branch
   * 26 com.sleepycat.je.txn.LockInfo.getLocker()Lcom/sleepycat/je/txn/Locker;: root-Branch
   * 27 com.sleepycat.je.txn.LockInfo.clone()Ljava/lang/Object;: root-Branch
   * 28 com.sleepycat.je.txn.LockInfo.setLockType(Lcom/sleepycat/je/txn/LockType;)V: root-Branch
   * 29 com.sleepycat.je.txn.LockInfo.setLocker(Lcom/sleepycat/je/txn/Locker;)V: root-Branch
   * 30 com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V: I17 Branch 1 IFEQ L35 - false
   * 31 com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;: I42 Branch 2 IFEQ L79 - true
   * 32 Weak Mutation 1: com.sleepycat.je.txn.LockInfo.getDeadlockStackTrace()Z:27 - InsertUnaryOp Negation
   * 33 Weak Mutation 0: com.sleepycat.je.txn.LockInfo.setDeadlockStackTrace(Z)V:21 - InsertUnaryOp Negation of enable
   * 34 Weak Mutation 1: com.sleepycat.je.txn.LockInfo.getDeadlockStackTrace()Z:27 - InsertUnaryOp Negation
   * 35 Weak Mutation 2: com.sleepycat.je.txn.LockInfo.getDeadlockStackTrace()Z:27 - DeleteField: deadlockStackTraceZ
   * 36 Weak Mutation 3: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - InsertUnaryOp Negation
   * 37 Weak Mutation 4: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - DeleteField: deadlockStackTraceZ
   * 38 Weak Mutation 5: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - ReplaceComparisonOperator == -> !=
   * 39 Weak Mutation 6: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteField: traceExceptionMapLjava/util/Map;
   * 40 Weak Mutation 7: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteStatement: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   * 41 Weak Mutation 10: com.sleepycat.je.txn.LockInfo.dump()V:70 - DeleteField: outLjava/io/PrintStream;
   * 42 Weak Mutation 11: com.sleepycat.je.txn.LockInfo.dump()V:70 - DeleteStatement: println(Ljava/lang/Object;)V
   * 43 Weak Mutation 12: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 0
   * 44 Weak Mutation 13: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 1
   * 45 Weak Mutation 14: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> -1
   * 46 Weak Mutation 15: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 499
   * 47 Weak Mutation 17: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - ReplaceConstant - <LockInfo locker=" -> 
   * 48 Weak Mutation 16: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 501
   * 49 Weak Mutation 18: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 50 Weak Mutation 21: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - ReplaceConstant - " type=" -> 
   * 51 Weak Mutation 20: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:75 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 52 Weak Mutation 22: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 53 Weak Mutation 25: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - ReplaceConstant - "/> -> 
   * 54 Weak Mutation 24: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 55 Weak Mutation 27: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - InsertUnaryOp Negation
   * 56 Weak Mutation 26: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 57 Weak Mutation 29: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - ReplaceComparisonOperator == -> !=
   * 58 Weak Mutation 37: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:86 - DeleteStatement: toString()Ljava/lang/String;
   * 59 com.sleepycat.je.txn.LockInfo.setDeadlockStackTrace(Z)V: root-Branch
   * 60 com.sleepycat.je.txn.LockInfo.getDeadlockStackTrace()Z: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      LockInfo.getDeadlockStackTrace();
      LockInfo lockInfo0 = new LockInfo((Locker) null, (LockType) null);
      lockInfo0.getLocker();
      LockInfo lockInfo1 = new LockInfo((Locker) null, (LockType) null);
      lockInfo1.setLockType((LockType) null);
      lockInfo1.clone();
      LockInfo.getDeadlockStackTrace();
      LockInfo.setDeadlockStackTrace(false);
      lockInfo1.setLockType((LockType) null);
      lockInfo1.setLocker((Locker) null);
      lockInfo1.dump();
      lockInfo0.dump();
      lockInfo1.getLocker();
      lockInfo1.getLocker();
      String string0 = lockInfo0.toString();
      assertEquals("<LockInfo locker=\"null\" type=\"null\"/>", string0);
      assertNotNull(string0);
  }

  //Test case number: 1
  /*
   * 3 covered goals:
   * 1 Weak Mutation 8: com.sleepycat.je.txn.LockInfo.getLocker()Lcom/sleepycat/je/txn/Locker;:49 - DeleteField: lockerLcom/sleepycat/je/txn/Locker;
   * 2 com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V: I17 Branch 1 IFEQ L35 - true
   * 3 Weak Mutation 8: com.sleepycat.je.txn.LockInfo.getLocker()Lcom/sleepycat/je/txn/Locker;:49 - DeleteField: lockerLcom/sleepycat/je/txn/Locker;
   */
  @Test
  public void test1()  throws Throwable  {
      Txn txn0 = new Txn();
      LockInfo lockInfo0 = new LockInfo((Locker) txn0, (LockType) null);
      Txn txn1 = (Txn)lockInfo0.getLocker();
      assertEquals(false, txn1.isSuspended());
  }

  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.txn.LockInfo.getLockType()Lcom/sleepycat/je/txn/LockType;:61 - DeleteField: lockTypeLcom/sleepycat/je/txn/LockType;
   * 2 com.sleepycat.je.txn.LockInfo.getLockType()Lcom/sleepycat/je/txn/LockType;: root-Branch
   * 3 Weak Mutation 9: com.sleepycat.je.txn.LockInfo.getLockType()Lcom/sleepycat/je/txn/LockType;:61 - DeleteField: lockTypeLcom/sleepycat/je/txn/LockType;
   */
  @Test
  public void test2()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_WRITE;
      LockInfo lockInfo0 = new LockInfo((Locker) null, lockType0);
      LockType lockType1 = lockInfo0.getLockType();
      assertEquals("RANGE_WRITE", lockType1.toString());
  }

  //Test case number: 3
  /*
   * 12 covered goals:
   * 1 Weak Mutation 19: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:75 - DeleteField: lockerLcom/sleepycat/je/txn/Locker;
   * 2 Weak Mutation 19: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:75 - DeleteField: lockerLcom/sleepycat/je/txn/Locker;
   * 3 Weak Mutation 28: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - DeleteField: deadlockStackTraceZ
   * 4 Weak Mutation 31: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:80 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 5 Weak Mutation 30: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:80 - DeleteField: traceExceptionMapLjava/util/Map;
   * 6 Weak Mutation 34: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:82 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 35: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:83 - DeleteStatement: getStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
   * 8 Weak Mutation 32: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:81 - ReplaceComparisonOperator = null -> != null
   * 9 Weak Mutation 33: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:82 - ReplaceConstant -  lock taken at:  -> 
   * 10 Weak Mutation 36: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:83 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 11 com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;: I42 Branch 2 IFEQ L79 - false
   * 12 com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;: I53 Branch 3 IFNULL L81 - false
   */
  @Test
  public void test3()  throws Throwable  {
      Txn txn0 = new Txn();
      LockInfo lockInfo0 = new LockInfo((Locker) txn0, (LockType) null);
      lockInfo0.dump();
      assertEquals("<LockInfo locker=\"0__Txn\" type=\"null\"/>", lockInfo0.toString());
  }

  //Test case number: 4
  /*
   * 35 covered goals:
   * 1 com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;: I53 Branch 3 IFNULL L81 - true
   * 2 Weak Mutation 0: com.sleepycat.je.txn.LockInfo.setDeadlockStackTrace(Z)V:21 - InsertUnaryOp Negation of enable
   * 3 Weak Mutation 3: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - InsertUnaryOp Negation
   * 4 Weak Mutation 4: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - DeleteField: deadlockStackTraceZ
   * 5 Weak Mutation 5: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:35 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 6: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteField: traceExceptionMapLjava/util/Map;
   * 7 Weak Mutation 7: com.sleepycat.je.txn.LockInfo.<init>(Lcom/sleepycat/je/txn/Locker;Lcom/sleepycat/je/txn/LockType;)V:36 - DeleteStatement: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   * 8 Weak Mutation 10: com.sleepycat.je.txn.LockInfo.dump()V:70 - DeleteField: outLjava/io/PrintStream;
   * 9 Weak Mutation 11: com.sleepycat.je.txn.LockInfo.dump()V:70 - DeleteStatement: println(Ljava/lang/Object;)V
   * 10 Weak Mutation 12: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 0
   * 11 Weak Mutation 13: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 1
   * 12 Weak Mutation 14: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> -1
   * 13 Weak Mutation 15: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 499
   * 14 Weak Mutation 17: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - ReplaceConstant - <LockInfo locker=" -> 
   * 15 Weak Mutation 16: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:73 - ReplaceConstant - 500 -> 501
   * 16 Weak Mutation 18: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:74 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 21: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - ReplaceConstant - " type=" -> 
   * 18 Weak Mutation 20: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:75 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 19 Weak Mutation 23: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteField: lockTypeLcom/sleepycat/je/txn/LockType;
   * 20 Weak Mutation 22: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:76 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 25: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - ReplaceConstant - "/> -> 
   * 22 Weak Mutation 24: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 23 Weak Mutation 27: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - InsertUnaryOp Negation
   * 24 Weak Mutation 26: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:78 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 25 Weak Mutation 29: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - ReplaceComparisonOperator == -> !=
   * 26 Weak Mutation 28: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:79 - DeleteField: deadlockStackTraceZ
   * 27 Weak Mutation 31: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:80 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 28 Weak Mutation 30: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:80 - DeleteField: traceExceptionMapLjava/util/Map;
   * 29 Weak Mutation 34: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:82 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 30 Weak Mutation 35: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:83 - DeleteStatement: getStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
   * 31 Weak Mutation 32: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:81 - ReplaceComparisonOperator = null -> != null
   * 32 Weak Mutation 33: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:82 - ReplaceConstant -  lock taken at:  -> 
   * 33 Weak Mutation 36: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:83 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 34 Weak Mutation 37: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:86 - DeleteStatement: toString()Ljava/lang/String;
   * 35 Weak Mutation 23: com.sleepycat.je.txn.LockInfo.toString()Ljava/lang/String;:77 - DeleteField: lockTypeLcom/sleepycat/je/txn/LockType;
   */
  @Test
  public void test4()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_WRITE;
      LockInfo lockInfo0 = new LockInfo((Locker) null, lockType0);
      assertEquals(false, lockInfo0.getDeadlockStackTrace());
      
      LockInfo.setDeadlockStackTrace(true);
      lockInfo0.dump();
      assertEquals("<LockInfo locker=\"null\" type=\"RANGE_WRITE\"/>", lockInfo0.toString());
  }
}