/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.implementation.clock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.Date;
import org.prevayler.Clock;
import org.prevayler.implementation.clock.BrokenClock;
import org.prevayler.implementation.clock.PausableClock;

@RunWith(EvoSuiteRunner.class)
public class TestPausableClock_0 {


  //Test case number: 0
  /*
   * 9 covered goals:
   * 1 Weak Mutation 1: org.prevayler.implementation.clock.PausableClock.time()Ljava/util/Date;:13 - DeleteField: _activeClockLorg/prevayler/Clock;
   * 2 Weak Mutation 2: org.prevayler.implementation.clock.PausableClock.time()Ljava/util/Date;:13 - DeleteStatement: time()Ljava/util/Date;
   * 3 org.prevayler.implementation.clock.PausableClock.time()Ljava/util/Date;: root-Branch
   * 4 Weak Mutation 0: org.prevayler.implementation.clock.PausableClock.<init>(Lorg/prevayler/Clock;)V:10 - DeleteStatement: resume()V
   * 5 Weak Mutation 1: org.prevayler.implementation.clock.PausableClock.time()Ljava/util/Date;:13 - DeleteField: _activeClockLorg/prevayler/Clock;
   * 6 Weak Mutation 2: org.prevayler.implementation.clock.PausableClock.time()Ljava/util/Date;:13 - DeleteStatement: time()Ljava/util/Date;
   * 7 Weak Mutation 9: org.prevayler.implementation.clock.PausableClock.resume()V:23 - DeleteField: _realClockLorg/prevayler/Clock;
   * 8 org.prevayler.implementation.clock.PausableClock.<init>(Lorg/prevayler/Clock;)V: root-Branch
   * 9 org.prevayler.implementation.clock.PausableClock.resume()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      BrokenClock brokenClock0 = new BrokenClock();
      PausableClock pausableClock0 = new PausableClock((Clock) brokenClock0);
      Date date0 = pausableClock0.time();
      assertEquals("31/12/1969 21:00:00", date0.toLocaleString());
  }
}