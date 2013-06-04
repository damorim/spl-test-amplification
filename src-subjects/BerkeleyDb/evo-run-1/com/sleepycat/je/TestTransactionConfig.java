/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.TransactionConfig;

@RunWith(EvoSuiteRunner.class)
public class TestTransactionConfig {


  //Test case number: 0
  /*
   * 15 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.TransactionConfig.<init>()V:13 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 1: com.sleepycat.je.TransactionConfig.<init>()V:14 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 2: com.sleepycat.je.TransactionConfig.<init>()V:15 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 3: com.sleepycat.je.TransactionConfig.<init>()V:16 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 4: com.sleepycat.je.TransactionConfig.<init>()V:17 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 5: com.sleepycat.je.TransactionConfig.<init>()V:18 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 6: com.sleepycat.je.TransactionConfig.<init>()V:19 - ReplaceConstant - 0 -> 1
   * 8 com.sleepycat.je.TransactionConfig.<init>()V: root-Branch
   * 9 Weak Mutation 0: com.sleepycat.je.TransactionConfig.<init>()V:13 - ReplaceConstant - 0 -> 1
   * 10 Weak Mutation 1: com.sleepycat.je.TransactionConfig.<init>()V:14 - ReplaceConstant - 0 -> 1
   * 11 Weak Mutation 2: com.sleepycat.je.TransactionConfig.<init>()V:15 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 3: com.sleepycat.je.TransactionConfig.<init>()V:16 - ReplaceConstant - 0 -> 1
   * 13 Weak Mutation 4: com.sleepycat.je.TransactionConfig.<init>()V:17 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 5: com.sleepycat.je.TransactionConfig.<init>()V:18 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 6: com.sleepycat.je.TransactionConfig.<init>()V:19 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test0()  throws Throwable  {
      TransactionConfig transactionConfig0 = new TransactionConfig();
      assertEquals(false, transactionConfig0.getNoWait());
      assertEquals(false, transactionConfig0.getReadCommitted());
      assertEquals(false, transactionConfig0.getWriteNoSync());
      assertEquals(false, transactionConfig0.getSerializableIsolation());
      assertEquals(false, transactionConfig0.getNoSync());
      assertEquals(false, transactionConfig0.getSync());
      assertEquals(false, transactionConfig0.getReadUncommitted());
  }

  //Test case number: 1
  /*
   * 7 covered goals:
   * 1 Weak Mutation 12: com.sleepycat.je.TransactionConfig.setNoSync(Z)V:45 - InsertUnaryOp Negation of noSync
   * 2 Weak Mutation 13: com.sleepycat.je.TransactionConfig.setNoSync(Z)V:45 - InsertUnaryOp IINC 1 noSync
   * 3 Weak Mutation 14: com.sleepycat.je.TransactionConfig.setNoSync(Z)V:45 - InsertUnaryOp IINC -1 noSync
   * 4 com.sleepycat.je.TransactionConfig.setNoSync(Z)V: root-Branch
   * 5 Weak Mutation 12: com.sleepycat.je.TransactionConfig.setNoSync(Z)V:45 - InsertUnaryOp Negation of noSync
   * 6 Weak Mutation 13: com.sleepycat.je.TransactionConfig.setNoSync(Z)V:45 - InsertUnaryOp IINC 1 noSync
   * 7 Weak Mutation 14: com.sleepycat.je.TransactionConfig.setNoSync(Z)V:45 - InsertUnaryOp IINC -1 noSync
   */
  @Test
  public void test1()  throws Throwable  {
      TransactionConfig transactionConfig0 = TransactionConfig.DEFAULT;
      transactionConfig0.setNoSync(false);
      assertEquals(false, transactionConfig0.getNoSync());
  }

  //Test case number: 2
  /*
   * 52 covered goals:
   * 1 Weak Mutation 16: com.sleepycat.je.TransactionConfig.getNoSync()Z:52 - DeleteField: noSyncZ
   * 2 Weak Mutation 17: com.sleepycat.je.TransactionConfig.setWriteNoSync(Z)V:59 - InsertUnaryOp Negation of writeNoSync
   * 3 Weak Mutation 19: com.sleepycat.je.TransactionConfig.setWriteNoSync(Z)V:59 - InsertUnaryOp IINC -1 writeNoSync
   * 4 Weak Mutation 18: com.sleepycat.je.TransactionConfig.setWriteNoSync(Z)V:59 - InsertUnaryOp IINC 1 writeNoSync
   * 5 Weak Mutation 20: com.sleepycat.je.TransactionConfig.getWriteNoSync()Z:66 - InsertUnaryOp Negation
   * 6 Weak Mutation 25: com.sleepycat.je.TransactionConfig.getNoWait()Z:80 - InsertUnaryOp Negation
   * 7 Weak Mutation 27: com.sleepycat.je.TransactionConfig.setReadUncommitted(Z)V:87 - InsertUnaryOp Negation of readUncommitted
   * 8 Weak Mutation 29: com.sleepycat.je.TransactionConfig.setReadUncommitted(Z)V:87 - InsertUnaryOp IINC -1 readUncommitted
   * 9 Weak Mutation 28: com.sleepycat.je.TransactionConfig.setReadUncommitted(Z)V:87 - InsertUnaryOp IINC 1 readUncommitted
   * 10 Weak Mutation 31: com.sleepycat.je.TransactionConfig.getReadUncommitted()Z:94 - DeleteField: readUncommittedZ
   * 11 Weak Mutation 30: com.sleepycat.je.TransactionConfig.getReadUncommitted()Z:94 - InsertUnaryOp Negation
   * 12 Weak Mutation 34: com.sleepycat.je.TransactionConfig.setReadCommitted(Z)V:117 - InsertUnaryOp IINC -1 readCommitted
   * 13 Weak Mutation 32: com.sleepycat.je.TransactionConfig.setReadCommitted(Z)V:117 - InsertUnaryOp Negation of readCommitted
   * 14 Weak Mutation 33: com.sleepycat.je.TransactionConfig.setReadCommitted(Z)V:117 - InsertUnaryOp IINC 1 readCommitted
   * 15 Weak Mutation 35: com.sleepycat.je.TransactionConfig.getReadCommitted()Z:124 - InsertUnaryOp Negation
   * 16 com.sleepycat.je.TransactionConfig.setWriteNoSync(Z)V: root-Branch
   * 17 com.sleepycat.je.TransactionConfig.getReadCommitted()Z: root-Branch
   * 18 com.sleepycat.je.TransactionConfig.cloneConfig()Lcom/sleepycat/je/TransactionConfig;: root-Branch
   * 19 com.sleepycat.je.TransactionConfig.getWriteNoSync()Z: root-Branch
   * 20 com.sleepycat.je.TransactionConfig.setReadCommitted(Z)V: root-Branch
   * 21 com.sleepycat.je.TransactionConfig.getReadUncommitted()Z: root-Branch
   * 22 com.sleepycat.je.TransactionConfig.getNoWait()Z: root-Branch
   * 23 com.sleepycat.je.TransactionConfig.setReadUncommitted(Z)V: root-Branch
   * 24 Weak Mutation 7: com.sleepycat.je.TransactionConfig.setSync(Z)V:31 - InsertUnaryOp Negation of sync
   * 25 Weak Mutation 8: com.sleepycat.je.TransactionConfig.setSync(Z)V:31 - InsertUnaryOp IINC 1 sync
   * 26 Weak Mutation 9: com.sleepycat.je.TransactionConfig.setSync(Z)V:31 - InsertUnaryOp IINC -1 sync
   * 27 Weak Mutation 10: com.sleepycat.je.TransactionConfig.getSync()Z:38 - InsertUnaryOp Negation
   * 28 Weak Mutation 11: com.sleepycat.je.TransactionConfig.getSync()Z:38 - DeleteField: syncZ
   * 29 Weak Mutation 15: com.sleepycat.je.TransactionConfig.getNoSync()Z:52 - InsertUnaryOp Negation
   * 30 Weak Mutation 7: com.sleepycat.je.TransactionConfig.setSync(Z)V:31 - InsertUnaryOp Negation of sync
   * 31 Weak Mutation 8: com.sleepycat.je.TransactionConfig.setSync(Z)V:31 - InsertUnaryOp IINC 1 sync
   * 32 Weak Mutation 9: com.sleepycat.je.TransactionConfig.setSync(Z)V:31 - InsertUnaryOp IINC -1 sync
   * 33 Weak Mutation 10: com.sleepycat.je.TransactionConfig.getSync()Z:38 - InsertUnaryOp Negation
   * 34 Weak Mutation 11: com.sleepycat.je.TransactionConfig.getSync()Z:38 - DeleteField: syncZ
   * 35 Weak Mutation 15: com.sleepycat.je.TransactionConfig.getNoSync()Z:52 - InsertUnaryOp Negation
   * 36 Weak Mutation 17: com.sleepycat.je.TransactionConfig.setWriteNoSync(Z)V:59 - InsertUnaryOp Negation of writeNoSync
   * 37 Weak Mutation 19: com.sleepycat.je.TransactionConfig.setWriteNoSync(Z)V:59 - InsertUnaryOp IINC -1 writeNoSync
   * 38 Weak Mutation 18: com.sleepycat.je.TransactionConfig.setWriteNoSync(Z)V:59 - InsertUnaryOp IINC 1 writeNoSync
   * 39 Weak Mutation 20: com.sleepycat.je.TransactionConfig.getWriteNoSync()Z:66 - InsertUnaryOp Negation
   * 40 Weak Mutation 25: com.sleepycat.je.TransactionConfig.getNoWait()Z:80 - InsertUnaryOp Negation
   * 41 Weak Mutation 27: com.sleepycat.je.TransactionConfig.setReadUncommitted(Z)V:87 - InsertUnaryOp Negation of readUncommitted
   * 42 Weak Mutation 29: com.sleepycat.je.TransactionConfig.setReadUncommitted(Z)V:87 - InsertUnaryOp IINC -1 readUncommitted
   * 43 Weak Mutation 28: com.sleepycat.je.TransactionConfig.setReadUncommitted(Z)V:87 - InsertUnaryOp IINC 1 readUncommitted
   * 44 Weak Mutation 31: com.sleepycat.je.TransactionConfig.getReadUncommitted()Z:94 - DeleteField: readUncommittedZ
   * 45 Weak Mutation 30: com.sleepycat.je.TransactionConfig.getReadUncommitted()Z:94 - InsertUnaryOp Negation
   * 46 Weak Mutation 34: com.sleepycat.je.TransactionConfig.setReadCommitted(Z)V:117 - InsertUnaryOp IINC -1 readCommitted
   * 47 Weak Mutation 35: com.sleepycat.je.TransactionConfig.getReadCommitted()Z:124 - InsertUnaryOp Negation
   * 48 Weak Mutation 32: com.sleepycat.je.TransactionConfig.setReadCommitted(Z)V:117 - InsertUnaryOp Negation of readCommitted
   * 49 Weak Mutation 33: com.sleepycat.je.TransactionConfig.setReadCommitted(Z)V:117 - InsertUnaryOp IINC 1 readCommitted
   * 50 com.sleepycat.je.TransactionConfig.setSync(Z)V: root-Branch
   * 51 com.sleepycat.je.TransactionConfig.getSync()Z: root-Branch
   * 52 com.sleepycat.je.TransactionConfig.getNoSync()Z: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      TransactionConfig transactionConfig0 = TransactionConfig.DEFAULT;
      TransactionConfig transactionConfig1 = transactionConfig0.cloneConfig();
      transactionConfig0.setDirtyRead(true);
      transactionConfig0.setSync(true);
      TransactionConfig transactionConfig2 = transactionConfig1.cloneConfig();
      transactionConfig1.setReadCommitted(false);
      transactionConfig0.setDirtyRead(true);
      transactionConfig0.getNoWait();
      transactionConfig2.getDirtyRead();
      transactionConfig0.getSync();
      transactionConfig1.setReadCommitted(false);
      transactionConfig2.setWriteNoSync(false);
      TransactionConfig transactionConfig3 = TransactionConfig.DEFAULT;
      transactionConfig3.setReadCommitted(false);
      transactionConfig3.setSync(false);
      transactionConfig3.getDirtyRead();
      transactionConfig0.getNoSync();
      transactionConfig0.setSync(true);
      transactionConfig0.setReadCommitted(false);
      transactionConfig1.getDirtyRead();
      transactionConfig1.getSync();
      transactionConfig2.getWriteNoSync();
      transactionConfig3.getNoSync();
      transactionConfig1.getReadCommitted();
      transactionConfig0.setReadCommitted(true);
      transactionConfig3.setDirtyRead(true);
      transactionConfig3.getNoSync();
      boolean boolean0 = transactionConfig2.getWriteNoSync();
      assertEquals(true, transactionConfig0.getReadCommitted());
      assertEquals(false, boolean0);
  }

  //Test case number: 3
  /*
   * 3 covered goals:
   * 1 Weak Mutation 21: com.sleepycat.je.TransactionConfig.getWriteNoSync()Z:66 - DeleteField: writeNoSyncZ
   * 2 Weak Mutation 20: com.sleepycat.je.TransactionConfig.getWriteNoSync()Z:66 - InsertUnaryOp Negation
   * 3 Weak Mutation 21: com.sleepycat.je.TransactionConfig.getWriteNoSync()Z:66 - DeleteField: writeNoSyncZ
   */
  @Test
  public void test3()  throws Throwable  {
      TransactionConfig transactionConfig0 = TransactionConfig.DEFAULT;
      boolean boolean0 = transactionConfig0.getWriteNoSync();
      assertEquals(true, boolean0);
  }

  //Test case number: 4
  /*
   * 7 covered goals:
   * 1 Weak Mutation 23: com.sleepycat.je.TransactionConfig.setNoWait(Z)V:73 - InsertUnaryOp IINC 1 noWait
   * 2 Weak Mutation 22: com.sleepycat.je.TransactionConfig.setNoWait(Z)V:73 - InsertUnaryOp Negation of noWait
   * 3 Weak Mutation 24: com.sleepycat.je.TransactionConfig.setNoWait(Z)V:73 - InsertUnaryOp IINC -1 noWait
   * 4 com.sleepycat.je.TransactionConfig.setNoWait(Z)V: root-Branch
   * 5 Weak Mutation 23: com.sleepycat.je.TransactionConfig.setNoWait(Z)V:73 - InsertUnaryOp IINC 1 noWait
   * 6 Weak Mutation 22: com.sleepycat.je.TransactionConfig.setNoWait(Z)V:73 - InsertUnaryOp Negation of noWait
   * 7 Weak Mutation 24: com.sleepycat.je.TransactionConfig.setNoWait(Z)V:73 - InsertUnaryOp IINC -1 noWait
   */
  @Test
  public void test4()  throws Throwable  {
      TransactionConfig transactionConfig0 = TransactionConfig.DEFAULT;
      transactionConfig0.setNoWait(false);
      assertEquals(false, transactionConfig0.getNoWait());
  }

  //Test case number: 5
  /*
   * 3 covered goals:
   * 1 Weak Mutation 36: com.sleepycat.je.TransactionConfig.getReadCommitted()Z:124 - DeleteField: readCommittedZ
   * 2 Weak Mutation 35: com.sleepycat.je.TransactionConfig.getReadCommitted()Z:124 - InsertUnaryOp Negation
   * 3 Weak Mutation 36: com.sleepycat.je.TransactionConfig.getReadCommitted()Z:124 - DeleteField: readCommittedZ
   */
  @Test
  public void test5()  throws Throwable  {
      TransactionConfig transactionConfig0 = TransactionConfig.DEFAULT;
      boolean boolean0 = transactionConfig0.getReadCommitted();
      assertEquals(false, boolean0);
  }

  //Test case number: 6
  /*
   * 7 covered goals:
   * 1 Weak Mutation 38: com.sleepycat.je.TransactionConfig.setSerializableIsolation(Z)V:131 - InsertUnaryOp IINC 1 serializableIsolation
   * 2 Weak Mutation 39: com.sleepycat.je.TransactionConfig.setSerializableIsolation(Z)V:131 - InsertUnaryOp IINC -1 serializableIsolation
   * 3 Weak Mutation 37: com.sleepycat.je.TransactionConfig.setSerializableIsolation(Z)V:131 - InsertUnaryOp Negation of serializableIsolation
   * 4 com.sleepycat.je.TransactionConfig.setSerializableIsolation(Z)V: root-Branch
   * 5 Weak Mutation 38: com.sleepycat.je.TransactionConfig.setSerializableIsolation(Z)V:131 - InsertUnaryOp IINC 1 serializableIsolation
   * 6 Weak Mutation 39: com.sleepycat.je.TransactionConfig.setSerializableIsolation(Z)V:131 - InsertUnaryOp IINC -1 serializableIsolation
   * 7 Weak Mutation 37: com.sleepycat.je.TransactionConfig.setSerializableIsolation(Z)V:131 - InsertUnaryOp Negation of serializableIsolation
   */
  @Test
  public void test6()  throws Throwable  {
      TransactionConfig transactionConfig0 = TransactionConfig.DEFAULT;
      transactionConfig0.setSerializableIsolation(true);
      assertEquals(true, transactionConfig0.getSerializableIsolation());
  }

  //Test case number: 7
  /*
   * 5 covered goals:
   * 1 Weak Mutation 41: com.sleepycat.je.TransactionConfig.getSerializableIsolation()Z:138 - DeleteField: serializableIsolationZ
   * 2 Weak Mutation 40: com.sleepycat.je.TransactionConfig.getSerializableIsolation()Z:138 - InsertUnaryOp Negation
   * 3 Weak Mutation 40: com.sleepycat.je.TransactionConfig.getSerializableIsolation()Z:138 - InsertUnaryOp Negation
   * 4 Weak Mutation 41: com.sleepycat.je.TransactionConfig.getSerializableIsolation()Z:138 - DeleteField: serializableIsolationZ
   * 5 com.sleepycat.je.TransactionConfig.getSerializableIsolation()Z: root-Branch
   */
  @Test
  public void test7()  throws Throwable  {
      TransactionConfig transactionConfig0 = TransactionConfig.DEFAULT;
      boolean boolean0 = transactionConfig0.getSerializableIsolation();
      assertEquals(false, boolean0);
  }
}
