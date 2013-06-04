/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.recovery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.recovery.CheckpointEnd;
import com.sleepycat.je.recovery.RecoveryInfo;

@RunWith(EvoSuiteRunner.class)
public class TestRecoveryInfo_0 {


  //Test case number: 0
  /*
   * 66 covered goals:
   * 1 Weak Mutation 43: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:38 - DeleteField: checkpointEndLcom/sleepycat/je/recovery/CheckpointEnd;
   * 2 Weak Mutation 0: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:7 - ReplaceConstant - -1 -> 0
   * 3 Weak Mutation 1: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:7 - ReplaceConstant - -1 -> 1
   * 4 Weak Mutation 2: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:7 - ReplaceConstant - -1 -> -2
   * 5 Weak Mutation 3: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:8 - ReplaceConstant - -1 -> 0
   * 6 Weak Mutation 4: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:8 - ReplaceConstant - -1 -> 1
   * 7 Weak Mutation 5: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:8 - ReplaceConstant - -1 -> -2
   * 8 Weak Mutation 6: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:9 - ReplaceConstant - -1 -> 0
   * 9 Weak Mutation 7: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:9 - ReplaceConstant - -1 -> 1
   * 10 Weak Mutation 8: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:9 - ReplaceConstant - -1 -> -2
   * 11 Weak Mutation 9: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:10 - ReplaceConstant - -1 -> 0
   * 12 Weak Mutation 10: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:10 - ReplaceConstant - -1 -> 1
   * 13 Weak Mutation 11: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:10 - ReplaceConstant - -1 -> -2
   * 14 Weak Mutation 12: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:11 - ReplaceConstant - -1 -> 0
   * 15 Weak Mutation 13: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:11 - ReplaceConstant - -1 -> 1
   * 16 Weak Mutation 14: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:11 - ReplaceConstant - -1 -> -2
   * 17 Weak Mutation 15: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:12 - ReplaceConstant - -1 -> 0
   * 18 Weak Mutation 17: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:12 - ReplaceConstant - -1 -> -2
   * 19 Weak Mutation 16: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:12 - ReplaceConstant - -1 -> 1
   * 20 Weak Mutation 19: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:13 - ReplaceConstant - -1 -> 1
   * 21 Weak Mutation 18: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:13 - ReplaceConstant - -1 -> 0
   * 22 Weak Mutation 21: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:31 - ReplaceConstant - Recovery Info -> 
   * 23 Weak Mutation 20: com.sleepycat.je.recovery.RecoveryInfo.<init>()V:13 - ReplaceConstant - -1 -> -2
   * 24 Weak Mutation 23: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:32 - ReplaceConstant -  lastUsed= -> 
   * 25 Weak Mutation 22: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:31 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 26 Weak Mutation 25: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:32 - DeleteField: lastUsedLsnJ
   * 27 Weak Mutation 24: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:32 - InsertUnaryOp Negation
   * 28 Weak Mutation 27: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:33 - InsertUnaryOp Negation
   * 29 Weak Mutation 26: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:33 - ReplaceConstant -  nextAvail= -> 
   * 30 Weak Mutation 29: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:34 - ReplaceConstant -  ckptStart= -> 
   * 31 Weak Mutation 28: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:33 - DeleteField: nextAvailableLsnJ
   * 32 Weak Mutation 31: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:34 - DeleteField: checkpointStartLsnJ
   * 33 Weak Mutation 30: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:34 - InsertUnaryOp Negation
   * 34 Weak Mutation 34: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:35 - DeleteField: firstActiveLsnJ
   * 35 Weak Mutation 35: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:36 - ReplaceConstant -  ckptEnd= -> 
   * 36 Weak Mutation 32: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:35 - ReplaceConstant -  firstActive= -> 
   * 37 Weak Mutation 33: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:35 - InsertUnaryOp Negation
   * 38 Weak Mutation 38: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:37 - ReplaceConstant -  useRoot= -> 
   * 39 Weak Mutation 39: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:37 - InsertUnaryOp Negation
   * 40 Weak Mutation 36: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:36 - InsertUnaryOp Negation
   * 41 Weak Mutation 37: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:36 - DeleteField: checkpointEndLsnJ
   * 42 Weak Mutation 42: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:38 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 43 Weak Mutation 43: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:38 - DeleteField: checkpointEndLcom/sleepycat/je/recovery/CheckpointEnd;
   * 44 Weak Mutation 40: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:37 - DeleteField: useRootLsnJ
   * 45 Weak Mutation 41: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:38 - ReplaceConstant -  ckptEnd=< -> 
   * 46 Weak Mutation 46: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:38 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 47 Weak Mutation 47: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:39 - ReplaceConstant -  useMaxNodeId= -> 
   * 48 Weak Mutation 44: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:38 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 49 Weak Mutation 45: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:38 - ReplaceConstant - > -> 
   * 50 Weak Mutation 51: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:39 - DeleteStatement: append(J)Ljava/lang/StringBuffer;
   * 51 Weak Mutation 49: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:39 - InsertUnaryOp Negation
   * 52 Weak Mutation 48: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 53 Weak Mutation 55: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:40 - InsertUnaryOp +1
   * 54 Weak Mutation 54: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:40 - InsertUnaryOp Negation
   * 55 Weak Mutation 53: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:40 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 56 Weak Mutation 52: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:40 - ReplaceConstant -  useMaxDbId= -> 
   * 57 Weak Mutation 59: com.sleepycat.je.recovery.RecoveryInfo.appendLsn(Ljava/lang/StringBuffer;Ljava/lang/String;J)V:56 - ReplaceConstant - -1 -> 0
   * 58 Weak Mutation 58: com.sleepycat.je.recovery.RecoveryInfo.appendLsn(Ljava/lang/StringBuffer;Ljava/lang/String;J)V:56 - InsertUnaryOp Negation
   * 59 Weak Mutation 56: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:40 - InsertUnaryOp -1
   * 60 Weak Mutation 62: com.sleepycat.je.recovery.RecoveryInfo.appendLsn(Ljava/lang/StringBuffer;Ljava/lang/String;J)V:56 - DeleteStatement: longSub(JJ)I
   * 61 Weak Mutation 61: com.sleepycat.je.recovery.RecoveryInfo.appendLsn(Ljava/lang/StringBuffer;Ljava/lang/String;J)V:56 - ReplaceConstant - -1 -> -2
   * 62 Weak Mutation 60: com.sleepycat.je.recovery.RecoveryInfo.appendLsn(Ljava/lang/StringBuffer;Ljava/lang/String;J)V:56 - ReplaceConstant - -1 -> 1
   * 63 Weak Mutation 65: com.sleepycat.je.recovery.RecoveryInfo.appendLsn(Ljava/lang/StringBuffer;Ljava/lang/String;J)V:56 - ReplaceComparisonOperator == -> -2
   * 64 com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;: root-Branch
   * 65 com.sleepycat.je.recovery.RecoveryInfo.<init>()V: root-Branch
   * 66 com.sleepycat.je.recovery.RecoveryInfo.appendLsn(Ljava/lang/StringBuffer;Ljava/lang/String;J)V: I5 Branch 1 IFEQ L56 - true
   */
  @Test
  public void test0()  throws Throwable  {
      RecoveryInfo recoveryInfo0 = new RecoveryInfo();
      recoveryInfo0.checkpointEnd = null;
      CheckpointEnd checkpointEnd0 = new CheckpointEnd();
      recoveryInfo0.checkpointEnd = checkpointEnd0;
      String string0 = recoveryInfo0.toString();
      assertEquals("Recovery Info ckptEnd=<time=null lastNodeId=0 lastDbId=0 id=0 rootExists=false ckptStartLsn=0xffffffff/0xffffffff firstActive=0xffffffff/0xffffffff> useMaxNodeId=0 useMaxDbId=0 numMapINs=0 numOtherINs=0 numBinDeltas=0 numDuplicateINs=0 lnFound=0 lnNotFound=0 lnInserted=0 lnReplaced=0 nRepeatIteratorReads=0", recoveryInfo0.toString());
      assertNotNull(string0);
      assertEquals("Recovery Info ckptEnd=<time=null lastNodeId=0 lastDbId=0 id=0 rootExists=false ckptStartLsn=0xffffffff/0xffffffff firstActive=0xffffffff/0xffffffff> useMaxNodeId=0 useMaxDbId=0 numMapINs=0 numOtherINs=0 numBinDeltas=0 numDuplicateINs=0 lnFound=0 lnNotFound=0 lnInserted=0 lnReplaced=0 nRepeatIteratorReads=0", string0);
  }
}
