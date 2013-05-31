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
public class TestPausableClock_2 {


  //Test case number: 2
  /*
   * 7 covered goals:
   * 1 Weak Mutation 10: org.prevayler.implementation.clock.PausableClock.realTime()Ljava/util/Date;:26 - DeleteField: _realClockLorg/prevayler/Clock;
   * 2 Weak Mutation 11: org.prevayler.implementation.clock.PausableClock.realTime()Ljava/util/Date;:26 - DeleteStatement: time()Ljava/util/Date;
   * 3 org.prevayler.implementation.clock.PausableClock.realTime()Ljava/util/Date;: root-Branch
   * 4 Weak Mutation 0: org.prevayler.implementation.clock.PausableClock.<init>(Lorg/prevayler/Clock;)V:10 - DeleteStatement: resume()V
   * 5 Weak Mutation 9: org.prevayler.implementation.clock.PausableClock.resume()V:23 - DeleteField: _realClockLorg/prevayler/Clock;
   * 6 Weak Mutation 10: org.prevayler.implementation.clock.PausableClock.realTime()Ljava/util/Date;:26 - DeleteField: _realClockLorg/prevayler/Clock;
   * 7 Weak Mutation 11: org.prevayler.implementation.clock.PausableClock.realTime()Ljava/util/Date;:26 - DeleteStatement: time()Ljava/util/Date;
   */
  @Test
  public void test2()  throws Throwable  {
      BrokenClock brokenClock0 = new BrokenClock();
      PausableClock pausableClock0 = new PausableClock((Clock) brokenClock0);
      Date date0 = pausableClock0.realTime();
      assertEquals(3, date0.getDay());
  }
}
