/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.recovery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.recovery.CheckpointEnd;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestCheckpointEnd_2 {


  //Test case number: 2
  /*
   * 6 covered goals:
   * 1 Weak Mutation 39: com.sleepycat.je.recovery.CheckpointEnd.getLogType()Lcom/sleepycat/je/log/LogEntryType;:71 - DeleteField: LOG_CKPT_ENDLcom/sleepycat/je/log/LogEntryType;
   * 2 com.sleepycat.je.recovery.CheckpointEnd.getLogType()Lcom/sleepycat/je/log/LogEntryType;: root-Branch
   * 3 Weak Mutation 23: com.sleepycat.je.recovery.CheckpointEnd.<init>(Ljava/lang/String;JJJJIJ)V:49 - ReplaceComparisonOperator != -> -1
   * 4 Weak Mutation 24: com.sleepycat.je.recovery.CheckpointEnd.<init>(Ljava/lang/String;JJJJIJ)V:50 - InsertUnaryOp Negation
   * 5 Weak Mutation 39: com.sleepycat.je.recovery.CheckpointEnd.getLogType()Lcom/sleepycat/je/log/LogEntryType;:71 - DeleteField: LOG_CKPT_ENDLcom/sleepycat/je/log/LogEntryType;
   * 6 com.sleepycat.je.recovery.CheckpointEnd.<init>(Ljava/lang/String;JJJJIJ)V: I65 Branch 3 IFNE L49 - false
   */
  @Test
  public void test2()  throws Throwable  {
      CheckpointEnd checkpointEnd0 = new CheckpointEnd("La;#;Lm,", (-1L), 0L, (-1L), 0L, 938, (-1L));
      assertNotNull(checkpointEnd0);
      
      checkpointEnd0.getLogType();
      assertEquals("time=2013-06-01 11:38:56.368 lastNodeId=0 lastDbId=938 id=-1 rootExists=true ckptStartLsn=0xffffffff/0xffffffff root=0x0/0x0 firstActive=0xffffffff/0xffffffff", checkpointEnd0.toString());
      assertEquals(938, checkpointEnd0.getLastDbId());
  }
}