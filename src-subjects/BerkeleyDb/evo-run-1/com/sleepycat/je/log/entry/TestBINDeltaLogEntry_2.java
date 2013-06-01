/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.entry.BINDeltaLogEntry;

@RunWith(EvoSuiteRunner.class)
public class TestBINDeltaLogEntry_2 {


  //Test case number: 2
  /*
   * 5 covered goals:
   * 1 Weak Mutation 4: com.sleepycat.je.log.entry.BINDeltaLogEntry.getLsnOfIN(J)J:30 - DeleteStatement: getMainItem()Ljava/lang/Object;
   * 2 Weak Mutation 5: com.sleepycat.je.log.entry.BINDeltaLogEntry.getLsnOfIN(J)J:31 - DeleteStatement: getLastFullLsn()J
   * 3 com.sleepycat.je.log.entry.BINDeltaLogEntry.getLsnOfIN(J)J: root-Branch
   * 4 Weak Mutation 4: com.sleepycat.je.log.entry.BINDeltaLogEntry.getLsnOfIN(J)J:30 - DeleteStatement: getMainItem()Ljava/lang/Object;
   * 5 Weak Mutation 5: com.sleepycat.je.log.entry.BINDeltaLogEntry.getLsnOfIN(J)J:31 - DeleteStatement: getLastFullLsn()J
   */
  @Test
  public void test2()  throws Throwable  {
      Class<?> class0 = BINDeltaLogEntry.class;
      BINDeltaLogEntry bINDeltaLogEntry0 = new BINDeltaLogEntry(class0);
      // Undeclared exception!
      try {
        bINDeltaLogEntry0.getLsnOfIN((-1394L));
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
