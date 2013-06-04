/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.txn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.txn.LockConflict;
import com.sleepycat.je.txn.LockType;

@RunWith(EvoSuiteRunner.class)
public class TestLockType {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.je.txn.LockType.isWriteLock()Z:65 - InsertUnaryOp Negation
   * 2 Weak Mutation 7: com.sleepycat.je.txn.LockType.isWriteLock()Z:65 - DeleteField: writeZ
   * 3 com.sleepycat.je.txn.LockType.isWriteLock()Z: root-Branch
   * 4 Weak Mutation 6: com.sleepycat.je.txn.LockType.isWriteLock()Z:65 - InsertUnaryOp Negation
   * 5 Weak Mutation 7: com.sleepycat.je.txn.LockType.isWriteLock()Z:65 - DeleteField: writeZ
   */
  @Test
  public void test0()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_WRITE;
      boolean boolean0 = lockType0.isWriteLock();
      assertEquals(true, boolean0);
  }

  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.txn.LockType.getCausesRestart()Z:79 - InsertUnaryOp Negation
   * 2 Weak Mutation 10: com.sleepycat.je.txn.LockType.getCausesRestart()Z:79 - DeleteField: causesRestartZ
   * 3 com.sleepycat.je.txn.LockType.getCausesRestart()Z: root-Branch
   * 4 Weak Mutation 9: com.sleepycat.je.txn.LockType.getCausesRestart()Z:79 - InsertUnaryOp Negation
   * 5 Weak Mutation 10: com.sleepycat.je.txn.LockType.getCausesRestart()Z:79 - DeleteField: causesRestartZ
   */
  @Test
  public void test1()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_READ;
      boolean boolean0 = lockType0.getCausesRestart();
      assertEquals(true, boolean0);
  }

  //Test case number: 2
  /*
   * 31 covered goals:
   * 1 Weak Mutation 11: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: conflictMatrix[[Lcom/sleepycat/je/txn/LockConflict;
   * 2 Weak Mutation 12: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp Negation
   * 3 Weak Mutation 13: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp +1
   * 4 Weak Mutation 14: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp -1
   * 5 Weak Mutation 15: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: indexI
   * 6 Weak Mutation 17: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RESTART
   * 7 Weak Mutation 16: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RANGE_READ
   * 8 Weak Mutation 19: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> READ
   * 9 Weak Mutation 18: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RANGE_INSERT
   * 10 Weak Mutation 21: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> WRITE
   * 11 Weak Mutation 22: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> NONE
   * 12 Weak Mutation 25: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp +1
   * 13 Weak Mutation 24: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp Negation
   * 14 Weak Mutation 27: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: indexI
   * 15 Weak Mutation 26: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp -1
   * 16 com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;: root-Branch
   * 17 Weak Mutation 11: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: conflictMatrix[[Lcom/sleepycat/je/txn/LockConflict;
   * 18 Weak Mutation 12: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp Negation
   * 19 Weak Mutation 13: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp +1
   * 20 Weak Mutation 14: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp -1
   * 21 Weak Mutation 15: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: indexI
   * 22 Weak Mutation 17: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RESTART
   * 23 Weak Mutation 16: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RANGE_READ
   * 24 Weak Mutation 19: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> READ
   * 25 Weak Mutation 18: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RANGE_INSERT
   * 26 Weak Mutation 21: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> WRITE
   * 27 Weak Mutation 22: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> NONE
   * 28 Weak Mutation 25: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp +1
   * 29 Weak Mutation 24: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp Negation
   * 30 Weak Mutation 27: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: indexI
   * 31 Weak Mutation 26: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp -1
   */
  @Test
  public void test2()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_WRITE;
      LockConflict lockConflict0 = lockType0.getConflict(lockType0);
      assertNotNull(lockConflict0);
      assertEquals(false, lockConflict0.getRestart());
  }

  //Test case number: 3
  /*
   * 18 covered goals:
   * 1 Weak Mutation 20: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RANGE_WRITE
   * 2 Weak Mutation 23: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> this
   * 3 Weak Mutation 11: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: conflictMatrix[[Lcom/sleepycat/je/txn/LockConflict;
   * 4 Weak Mutation 12: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp Negation
   * 5 Weak Mutation 13: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp +1
   * 6 Weak Mutation 14: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp -1
   * 7 Weak Mutation 15: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: indexI
   * 8 Weak Mutation 17: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RESTART
   * 9 Weak Mutation 16: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RANGE_READ
   * 10 Weak Mutation 19: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> READ
   * 11 Weak Mutation 21: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> WRITE
   * 12 Weak Mutation 22: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> NONE
   * 13 Weak Mutation 25: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp +1
   * 14 Weak Mutation 24: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp Negation
   * 15 Weak Mutation 27: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - DeleteField: indexI
   * 16 Weak Mutation 26: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - InsertUnaryOp -1
   * 17 Weak Mutation 20: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> RANGE_WRITE
   * 18 Weak Mutation 23: com.sleepycat.je.txn.LockType.getConflict(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockConflict;:86 - ReplaceVariable requestedType -> this
   */
  @Test
  public void test3()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_WRITE;
      LockType lockType1 = LockType.RANGE_INSERT;
      LockConflict lockConflict0 = lockType0.getConflict(lockType1);
      assertEquals(false, lockConflict0.getAllowed());
      assertNotNull(lockConflict0);
  }

  //Test case number: 4
  /*
   * 54 covered goals:
   * 1 Weak Mutation 33: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RANGE_READ
   * 2 Weak Mutation 40: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> this
   * 3 Weak Mutation 51: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 4 Weak Mutation 50: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: toString()Ljava/lang/String;
   * 5 Weak Mutation 55: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RESTART
   * 6 Weak Mutation 54: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RANGE_READ
   * 7 Weak Mutation 53: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 8 Weak Mutation 52: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceConstant -  to  -> 
   * 9 Weak Mutation 59: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> WRITE
   * 10 Weak Mutation 58: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RANGE_WRITE
   * 11 Weak Mutation 57: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> READ
   * 12 Weak Mutation 63: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: toString()Ljava/lang/String;
   * 13 Weak Mutation 62: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 14 Weak Mutation 61: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> this
   * 15 Weak Mutation 60: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> NONE
   * 16 Weak Mutation 64: com.sleepycat.je.txn.LockType.toString()Ljava/lang/String;:100 - DeleteField: nameLjava/lang/String;
   * 17 com.sleepycat.je.txn.LockType.toString()Ljava/lang/String;: root-Branch
   * 18 com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;: I16 Branch 3 IFEQ L96 - false
   * 19 Weak Mutation 37: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RANGE_WRITE
   * 20 Weak Mutation 29: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp Negation
   * 21 Weak Mutation 28: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - DeleteField: upgradeMatrix[[Lcom/sleepycat/je/txn/LockUpgrade;
   * 22 Weak Mutation 31: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp -1
   * 23 Weak Mutation 30: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp +1
   * 24 Weak Mutation 34: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RESTART
   * 25 Weak Mutation 32: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - DeleteField: indexI
   * 26 Weak Mutation 33: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RANGE_READ
   * 27 Weak Mutation 38: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> WRITE
   * 28 Weak Mutation 39: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> NONE
   * 29 Weak Mutation 36: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> READ
   * 30 Weak Mutation 37: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RANGE_WRITE
   * 31 Weak Mutation 42: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp +1
   * 32 Weak Mutation 43: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp -1
   * 33 Weak Mutation 40: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> this
   * 34 Weak Mutation 41: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp Negation
   * 35 Weak Mutation 47: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceComparisonOperator != -> ==
   * 36 Weak Mutation 44: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - DeleteField: indexI
   * 37 Weak Mutation 45: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - InsertUnaryOp Negation
   * 38 Weak Mutation 51: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 39 Weak Mutation 50: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: toString()Ljava/lang/String;
   * 40 Weak Mutation 49: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceComparisonOperator == -> !=
   * 41 Weak Mutation 48: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: getIllegal()Z
   * 42 Weak Mutation 55: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RESTART
   * 43 Weak Mutation 54: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RANGE_READ
   * 44 Weak Mutation 53: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 45 Weak Mutation 52: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceConstant -  to  -> 
   * 46 Weak Mutation 59: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> WRITE
   * 47 Weak Mutation 58: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RANGE_WRITE
   * 48 Weak Mutation 57: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> READ
   * 49 Weak Mutation 63: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: toString()Ljava/lang/String;
   * 50 Weak Mutation 62: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 51 Weak Mutation 61: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> this
   * 52 Weak Mutation 60: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> NONE
   * 53 Weak Mutation 64: com.sleepycat.je.txn.LockType.toString()Ljava/lang/String;:100 - DeleteField: nameLjava/lang/String;
   * 54 com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;: I13 Branch 2 IFNE L96 - false
   */
  @Test
  public void test4()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_READ;
      LockType lockType1 = LockType.RANGE_INSERT;
      // Undeclared exception!
      try {
        lockType0.getUpgrade(lockType1);
        fail("Expecting exception: AssertionError");
      } catch(AssertionError e) {
        /*
         * RANGE_READ to RANGE_INSERT
         */
      }
  }

  //Test case number: 5
  /*
   * 36 covered goals:
   * 1 Weak Mutation 56: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RANGE_INSERT
   * 2 Weak Mutation 29: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp Negation
   * 3 Weak Mutation 28: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - DeleteField: upgradeMatrix[[Lcom/sleepycat/je/txn/LockUpgrade;
   * 4 Weak Mutation 31: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp -1
   * 5 Weak Mutation 30: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp +1
   * 6 Weak Mutation 34: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RESTART
   * 7 Weak Mutation 35: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RANGE_INSERT
   * 8 Weak Mutation 32: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - DeleteField: indexI
   * 9 Weak Mutation 33: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RANGE_READ
   * 10 Weak Mutation 38: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> WRITE
   * 11 Weak Mutation 39: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> NONE
   * 12 Weak Mutation 36: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> READ
   * 13 Weak Mutation 42: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp +1
   * 14 Weak Mutation 43: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp -1
   * 15 Weak Mutation 40: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> this
   * 16 Weak Mutation 41: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - InsertUnaryOp Negation
   * 17 Weak Mutation 47: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceComparisonOperator != -> ==
   * 18 Weak Mutation 44: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - DeleteField: indexI
   * 19 Weak Mutation 45: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - InsertUnaryOp Negation
   * 20 Weak Mutation 51: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 21 Weak Mutation 50: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: toString()Ljava/lang/String;
   * 22 Weak Mutation 49: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceComparisonOperator == -> !=
   * 23 Weak Mutation 48: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: getIllegal()Z
   * 24 Weak Mutation 55: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RESTART
   * 25 Weak Mutation 54: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RANGE_READ
   * 26 Weak Mutation 53: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 27 Weak Mutation 52: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceConstant -  to  -> 
   * 28 Weak Mutation 59: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> WRITE
   * 29 Weak Mutation 57: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> READ
   * 30 Weak Mutation 63: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: toString()Ljava/lang/String;
   * 31 Weak Mutation 62: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 32 Weak Mutation 61: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> this
   * 33 Weak Mutation 60: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> NONE
   * 34 Weak Mutation 64: com.sleepycat.je.txn.LockType.toString()Ljava/lang/String;:100 - DeleteField: nameLjava/lang/String;
   * 35 Weak Mutation 35: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:95 - ReplaceVariable requestedType -> RANGE_INSERT
   * 36 Weak Mutation 56: com.sleepycat.je.txn.LockType.getUpgrade(Lcom/sleepycat/je/txn/LockType;)Lcom/sleepycat/je/txn/LockUpgrade;:96 - ReplaceVariable requestedType -> RANGE_INSERT
   */
  @Test
  public void test5()  throws Throwable  {
      LockType lockType0 = LockType.RANGE_WRITE;
      LockType lockType1 = LockType.RANGE_INSERT;
      // Undeclared exception!
      try {
        lockType1.getUpgrade(lockType0);
        fail("Expecting exception: AssertionError");
      } catch(AssertionError e) {
        /*
         * RANGE_INSERT to RANGE_WRITE
         */
      }
  }
}