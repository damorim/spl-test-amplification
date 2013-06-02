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
public class TestCheckpointEnd_8 {


  //Test case number: 8
  /*
   * 5 covered goals:
   * 1 Weak Mutation 184: com.sleepycat.je.recovery.CheckpointEnd.getTransactionId()J:175 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 185: com.sleepycat.je.recovery.CheckpointEnd.getTransactionId()J:175 - ReplaceConstant - 0 -> -1
   * 3 com.sleepycat.je.recovery.CheckpointEnd.getTransactionId()J: root-Branch
   * 4 Weak Mutation 184: com.sleepycat.je.recovery.CheckpointEnd.getTransactionId()J:175 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 185: com.sleepycat.je.recovery.CheckpointEnd.getTransactionId()J:175 - ReplaceConstant - 0 -> -1
   */
  @Test
  public void test8()  throws Throwable  {
      CheckpointEnd checkpointEnd0 = new CheckpointEnd("}", (-1189L), (-1189L), (-1189L), (-1189L), 1294, (-1189L));
      assertNotNull(checkpointEnd0);
      
      long long0 = checkpointEnd0.getTransactionId();
      assertEquals("time=2013-06-01 11:38:58.158 lastNodeId=-1189 lastDbId=1294 id=-1189 rootExists=true ckptStartLsn=0xffffffff/0xfffffb5b root=0xffffffff/0xfffffb5b firstActive=0xffffffff/0xfffffb5b", checkpointEnd0.toString());
      assertEquals(0L, long0);
  }
}