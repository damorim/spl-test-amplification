/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.CursorConfig;

@RunWith(EvoSuiteRunner.class)
public class TestCursorConfig_1 {


  //Test case number: 1
  /*
   * 24 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.je.CursorConfig.getReadUncommitted()Z:52 - DeleteField: readUncommittedZ
   * 2 Weak Mutation 7: com.sleepycat.je.CursorConfig.setReadCommitted(Z)V:75 - InsertUnaryOp Negation
   * 3 Weak Mutation 8: com.sleepycat.je.CursorConfig.setReadCommitted(Z)V:75 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 9: com.sleepycat.je.CursorConfig.setReadCommitted(Z)V:75 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 10: com.sleepycat.je.CursorConfig.getReadCommitted()Z:82 - InsertUnaryOp Negation
   * 6 Weak Mutation 11: com.sleepycat.je.CursorConfig.getReadCommitted()Z:82 - DeleteField: readCommittedZ
   * 7 com.sleepycat.je.CursorConfig.getReadCommitted()Z: root-Branch
   * 8 com.sleepycat.je.CursorConfig.cloneConfig()Lcom/sleepycat/je/CursorConfig;: root-Branch
   * 9 com.sleepycat.je.CursorConfig.setReadCommitted(Z)V: root-Branch
   * 10 Weak Mutation 2: com.sleepycat.je.CursorConfig.setReadUncommitted(Z)V:45 - InsertUnaryOp Negation
   * 11 Weak Mutation 3: com.sleepycat.je.CursorConfig.setReadUncommitted(Z)V:45 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 4: com.sleepycat.je.CursorConfig.setReadUncommitted(Z)V:45 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 5: com.sleepycat.je.CursorConfig.getReadUncommitted()Z:52 - InsertUnaryOp Negation
   * 14 Weak Mutation 2: com.sleepycat.je.CursorConfig.setReadUncommitted(Z)V:45 - InsertUnaryOp Negation
   * 15 Weak Mutation 3: com.sleepycat.je.CursorConfig.setReadUncommitted(Z)V:45 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 4: com.sleepycat.je.CursorConfig.setReadUncommitted(Z)V:45 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 5: com.sleepycat.je.CursorConfig.getReadUncommitted()Z:52 - InsertUnaryOp Negation
   * 18 Weak Mutation 7: com.sleepycat.je.CursorConfig.setReadCommitted(Z)V:75 - InsertUnaryOp Negation
   * 19 Weak Mutation 8: com.sleepycat.je.CursorConfig.setReadCommitted(Z)V:75 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 9: com.sleepycat.je.CursorConfig.setReadCommitted(Z)V:75 - InsertUnaryOp IINC -1
   * 21 Weak Mutation 10: com.sleepycat.je.CursorConfig.getReadCommitted()Z:82 - InsertUnaryOp Negation
   * 22 Weak Mutation 11: com.sleepycat.je.CursorConfig.getReadCommitted()Z:82 - DeleteField: readCommittedZ
   * 23 com.sleepycat.je.CursorConfig.getReadUncommitted()Z: root-Branch
   * 24 com.sleepycat.je.CursorConfig.setReadUncommitted(Z)V: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      CursorConfig cursorConfig0 = CursorConfig.READ_UNCOMMITTED;
      cursorConfig0.getReadUncommitted();
      CursorConfig cursorConfig1 = CursorConfig.READ_UNCOMMITTED;
      cursorConfig1.getReadCommitted();
      cursorConfig1.setDirtyRead(false);
      cursorConfig1.getDirtyRead();
      cursorConfig1.getDirtyRead();
      cursorConfig1.setDirtyRead(false);
      cursorConfig1.getReadUncommitted();
      CursorConfig cursorConfig2 = cursorConfig1.cloneConfig();
      cursorConfig1.getReadCommitted();
      cursorConfig1.setReadCommitted(true);
      cursorConfig1.getDirtyRead();
      cursorConfig1.setDirtyRead(false);
      cursorConfig1.getReadCommitted();
      cursorConfig1.setReadUncommitted(false);
      cursorConfig1.getDirtyRead();
      CursorConfig cursorConfig3 = CursorConfig.READ_UNCOMMITTED;
      boolean boolean0 = cursorConfig2.getReadUncommitted();
      assertEquals(false, boolean0);
      assertEquals(true, cursorConfig1.getReadCommitted());
  }
}
