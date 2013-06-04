/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.txn.Locker;
import com.sleepycat.je.txn.LockerFactory;
import com.sleepycat.je.txn.Txn;

@RunWith(EvoSuiteRunner.class)
public class TestLockerFactory {


  //Test case number: 0
  /*
   * 13 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - InsertUnaryOp Negation of dbIsTransactional
   * 2 Weak Mutation 1: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - InsertUnaryOp IINC 1 dbIsTransactional
   * 3 Weak Mutation 2: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - InsertUnaryOp IINC -1 dbIsTransactional
   * 4 Weak Mutation 3: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 4: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - DeleteStatement: getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZLcom/sleepycat/je/TransactionConfig;)Lcom/sleepycat/je/txn/Locker;
   * 6 Weak Mutation 5: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZLcom/sleepycat/je/TransactionConfig;)Lcom/sleepycat/je/txn/Locker;:37 - DeleteStatement: envGetEnvironmentImpl(Lcom/sleepycat/je/Environment;)Lcom/sleepycat/je/dbi/EnvironmentImpl;
   * 7 com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;: root-Branch
   * 8 Weak Mutation 0: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - InsertUnaryOp Negation of dbIsTransactional
   * 9 Weak Mutation 1: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - InsertUnaryOp IINC 1 dbIsTransactional
   * 10 Weak Mutation 2: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - InsertUnaryOp IINC -1 dbIsTransactional
   * 11 Weak Mutation 3: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 4: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;Z)Lcom/sleepycat/je/txn/Locker;:25 - DeleteStatement: getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZLcom/sleepycat/je/TransactionConfig;)Lcom/sleepycat/je/txn/Locker;
   * 13 Weak Mutation 5: com.sleepycat.je.txn.LockerFactory.getWritableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZLcom/sleepycat/je/TransactionConfig;)Lcom/sleepycat/je/txn/Locker;:37 - DeleteStatement: envGetEnvironmentImpl(Lcom/sleepycat/je/Environment;)Lcom/sleepycat/je/dbi/EnvironmentImpl;
   */
  @Test
  public void test0()  throws Throwable  {
      // Undeclared exception!
      try {
        LockerFactory.getWritableLocker((Environment) null, (Transaction) null, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 1
  /*
   * 22 covered goals:
   * 1 Weak Mutation 36: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:89 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 44: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:100 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 51: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp Negation of retainNonTxnLocks
   * 4 Weak Mutation 49: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - ReplaceVariable retainNonTxnLocks -> dbIsTransactional
   * 5 Weak Mutation 53: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp IINC -1 retainNonTxnLocks
   * 6 Weak Mutation 52: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp IINC 1 retainNonTxnLocks
   * 7 Weak Mutation 57: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - DeleteStatement: getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;
   * 8 Weak Mutation 54: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:111 - ReplaceVariable readCommittedIsolation -> dbIsTransactional
   * 9 Weak Mutation 56: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:111 - InsertUnaryOp Negation of readCommittedIsolation
   * 10 Weak Mutation 84: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;:151 - DeleteStatement: envGetEnvironmentImpl(Lcom/sleepycat/je/Environment;)Lcom/sleepycat/je/dbi/EnvironmentImpl;
   * 11 com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;: I3 Branch 12 IFNULL L89 - true
   * 12 com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;: I24 Branch 14 IFNULL L100 - true
   * 13 Weak Mutation 36: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:89 - ReplaceComparisonOperator = null -> != null
   * 14 Weak Mutation 44: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:100 - ReplaceComparisonOperator = null -> != null
   * 15 Weak Mutation 51: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp Negation of retainNonTxnLocks
   * 16 Weak Mutation 49: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - ReplaceVariable retainNonTxnLocks -> dbIsTransactional
   * 17 Weak Mutation 54: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:111 - ReplaceVariable readCommittedIsolation -> dbIsTransactional
   * 18 Weak Mutation 53: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp IINC -1 retainNonTxnLocks
   * 19 Weak Mutation 52: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp IINC 1 retainNonTxnLocks
   * 20 Weak Mutation 57: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - DeleteStatement: getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;
   * 21 Weak Mutation 56: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:111 - InsertUnaryOp Negation of readCommittedIsolation
   * 22 Weak Mutation 84: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;:151 - DeleteStatement: envGetEnvironmentImpl(Lcom/sleepycat/je/Environment;)Lcom/sleepycat/je/dbi/EnvironmentImpl;
   */
  @Test
  public void test1()  throws Throwable  {
      // Undeclared exception!
      try {
        LockerFactory.getReadableLocker((Environment) null, (Transaction) null, false, true, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 2
  /*
   * 13 covered goals:
   * 1 Weak Mutation 50: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - ReplaceVariable retainNonTxnLocks -> readCommittedIsolation
   * 2 Weak Mutation 55: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:111 - ReplaceVariable readCommittedIsolation -> retainNonTxnLocks
   * 3 Weak Mutation 36: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:89 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 44: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:100 - ReplaceComparisonOperator = null -> != null
   * 5 Weak Mutation 51: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp Negation of retainNonTxnLocks
   * 6 Weak Mutation 49: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - ReplaceVariable retainNonTxnLocks -> dbIsTransactional
   * 7 Weak Mutation 53: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp IINC -1 retainNonTxnLocks
   * 8 Weak Mutation 52: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - InsertUnaryOp IINC 1 retainNonTxnLocks
   * 9 Weak Mutation 57: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - DeleteStatement: getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;
   * 10 Weak Mutation 56: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:111 - InsertUnaryOp Negation of readCommittedIsolation
   * 11 Weak Mutation 84: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;:151 - DeleteStatement: envGetEnvironmentImpl(Lcom/sleepycat/je/Environment;)Lcom/sleepycat/je/dbi/EnvironmentImpl;
   * 12 Weak Mutation 50: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:110 - ReplaceVariable retainNonTxnLocks -> readCommittedIsolation
   * 13 Weak Mutation 55: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Transaction;ZZZ)Lcom/sleepycat/je/txn/Locker;:111 - ReplaceVariable readCommittedIsolation -> retainNonTxnLocks
   */
  @Test
  public void test2()  throws Throwable  {
      // Undeclared exception!
      try {
        LockerFactory.getReadableLocker((Environment) null, (Transaction) null, true, false, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 3
  /*
   * 2 covered goals:
   * 1 Weak Mutation 58: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;:121 - DeleteStatement: dbGetDatabaseImpl(Lcom/sleepycat/je/Database;)Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 2 Weak Mutation 58: com.sleepycat.je.txn.LockerFactory.getReadableLocker(Lcom/sleepycat/je/Environment;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/txn/Locker;ZZ)Lcom/sleepycat/je/txn/Locker;:121 - DeleteStatement: dbGetDatabaseImpl(Lcom/sleepycat/je/Database;)Lcom/sleepycat/je/dbi/DatabaseImpl;
   */
  @Test
  public void test3()  throws Throwable  {
      Txn txn0 = new Txn();
      // Undeclared exception!
      try {
        LockerFactory.getReadableLocker((Environment) null, (Database) null, (Locker) txn0, true, true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}