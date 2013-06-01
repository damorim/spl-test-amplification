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
public class TestRecoveryInfo_1 {


  //Test case number: 1
  /*
   * 2 covered goals:
   * 1 Weak Mutation 50: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:39 - DeleteField: useMaxNodeIdJ
   * 2 Weak Mutation 50: com.sleepycat.je.recovery.RecoveryInfo.toString()Ljava/lang/String;:39 - DeleteField: useMaxNodeIdJ
   */
  @Test
  public void test1()  throws Throwable  {
      RecoveryInfo recoveryInfo0 = new RecoveryInfo();
      recoveryInfo0.useMaxNodeId = 1L;
      String string0 = recoveryInfo0.toString();
      assertNotNull(string0);
      assertEquals("Recovery Info ckptEnd=<null> useMaxNodeId=1 useMaxDbId=0 numMapINs=0 numOtherINs=0 numBinDeltas=0 numDuplicateINs=0 lnFound=0 lnNotFound=0 lnInserted=0 lnReplaced=0 nRepeatIteratorReads=0", recoveryInfo0.toString());
      assertEquals("Recovery Info ckptEnd=<null> useMaxNodeId=1 useMaxDbId=0 numMapINs=0 numOtherINs=0 numBinDeltas=0 numDuplicateINs=0 lnFound=0 lnNotFound=0 lnInserted=0 lnReplaced=0 nRepeatIteratorReads=0", string0);
  }
}
