/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.recovery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.recovery.CheckpointEnd;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestCheckpointEnd_15 {


  //Test case number: 15
  /*
   * 5 covered goals:
   * 1 Weak Mutation 246: com.sleepycat.je.recovery.CheckpointEnd.getId()J:215 - DeleteField: idJ
   * 2 Weak Mutation 245: com.sleepycat.je.recovery.CheckpointEnd.getId()J:215 - InsertUnaryOp Negation
   * 3 com.sleepycat.je.recovery.CheckpointEnd.getId()J: root-Branch
   * 4 Weak Mutation 246: com.sleepycat.je.recovery.CheckpointEnd.getId()J:215 - DeleteField: idJ
   * 5 Weak Mutation 245: com.sleepycat.je.recovery.CheckpointEnd.getId()J:215 - InsertUnaryOp Negation
   */
  @Test
  public void test15()  throws Throwable  {
      CheckpointEnd checkpointEnd0 = new CheckpointEnd("La;#;Lm,", (-1L), 0L, (-1L), 0L, 938, (-1L));
      assertNotNull(checkpointEnd0);
      
      long long0 = checkpointEnd0.getId();
      assertEquals("time=2013-06-01 11:38:59.839 lastNodeId=0 lastDbId=938 id=-1 rootExists=true ckptStartLsn=0xffffffff/0xffffffff root=0x0/0x0 firstActive=0xffffffff/0xffffffff", checkpointEnd0.toString());
      assertEquals((-1L), long0);
  }
}