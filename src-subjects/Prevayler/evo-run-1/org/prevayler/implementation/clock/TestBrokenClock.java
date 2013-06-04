/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.implementation.clock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.Date;
import org.prevayler.implementation.clock.BrokenClock;

@RunWith(EvoSuiteRunner.class)
public class TestBrokenClock {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 Weak Mutation 1: org.prevayler.implementation.clock.BrokenClock.time()Ljava/util/Date;:18 - DeleteField: _timeLjava/util/Date;
   * 2 org.prevayler.implementation.clock.BrokenClock.time()Ljava/util/Date;: root-Branch
   * 3 Weak Mutation 0: org.prevayler.implementation.clock.BrokenClock.<init>(Ljava/util/Date;)V:15 - DeleteStatement: getTime()J
   * 4 Weak Mutation 1: org.prevayler.implementation.clock.BrokenClock.time()Ljava/util/Date;:18 - DeleteField: _timeLjava/util/Date;
   * 5 org.prevayler.implementation.clock.BrokenClock.<init>(Ljava/util/Date;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      Date date0 = new Date();
      BrokenClock brokenClock0 = new BrokenClock(date0);
      Date date1 = brokenClock0.time();
      assertEquals("Sun Jun 02 14:36:24 BRT 2013", date0.toString());
      assertEquals(24, date1.getSeconds());
  }

  //Test case number: 1
  /*
   * 13 covered goals:
   * 1 Weak Mutation 2: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:21 - DeleteStatement: getTime()J
   * 2 Weak Mutation 3: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - InsertUnaryOp Negation
   * 3 Weak Mutation 4: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - InsertUnaryOp Negation
   * 4 Weak Mutation 5: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - DeleteField: _millisJ
   * 5 Weak Mutation 6: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - DeleteStatement: longSub(JJ)I
   * 6 Weak Mutation 9: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - ReplaceComparisonOperator != -> -1
   * 7 org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V: I11 Branch 1 IFNE L22 - false
   * 8 Weak Mutation 2: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:21 - DeleteStatement: getTime()J
   * 9 Weak Mutation 3: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - InsertUnaryOp Negation
   * 10 Weak Mutation 4: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - InsertUnaryOp Negation
   * 11 Weak Mutation 5: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - DeleteField: _millisJ
   * 12 Weak Mutation 6: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - DeleteStatement: longSub(JJ)I
   * 13 Weak Mutation 9: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - ReplaceComparisonOperator != -> -1
   */
  @Test
  public void test1()  throws Throwable  {
      Date date0 = new Date();
      BrokenClock brokenClock0 = new BrokenClock(date0);
      brokenClock0.advanceTo(date0);
      assertEquals(1370194585047L, date0.getTime());
  }

  //Test case number: 2
  /*
   * 12 covered goals:
   * 1 Weak Mutation 7: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - ReplaceComparisonOperator != -> <
   * 2 Weak Mutation 8: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - ReplaceComparisonOperator != -> >
   * 3 Weak Mutation 10: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:23 - InsertUnaryOp Negation
   * 4 org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V: I11 Branch 1 IFNE L22 - true
   * 5 Weak Mutation 2: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:21 - DeleteStatement: getTime()J
   * 6 Weak Mutation 3: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - InsertUnaryOp Negation
   * 7 Weak Mutation 4: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - InsertUnaryOp Negation
   * 8 Weak Mutation 5: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - DeleteField: _millisJ
   * 9 Weak Mutation 6: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - DeleteStatement: longSub(JJ)I
   * 10 Weak Mutation 7: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - ReplaceComparisonOperator != -> <
   * 11 Weak Mutation 8: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:22 - ReplaceComparisonOperator != -> >
   * 12 Weak Mutation 10: org.prevayler.implementation.clock.BrokenClock.advanceTo(Ljava/util/Date;)V:23 - InsertUnaryOp Negation
   */
  @Test
  public void test2()  throws Throwable  {
      Date date0 = new Date();
      BrokenClock brokenClock0 = new BrokenClock(date0);
      Date date1 = new Date(0L);
      brokenClock0.advanceTo(date1);
      brokenClock0.advanceTo(date0);
      assertEquals(1370194585087L, date0.getTime());
  }

  //Test case number: 3
  /*
   * 2 covered goals:
   * 1 org.prevayler.implementation.clock.BrokenClock.<init>()V: root-Branch
   * 2 Weak Mutation 0: org.prevayler.implementation.clock.BrokenClock.<init>(Ljava/util/Date;)V:15 - DeleteStatement: getTime()J
   */
  @Test
  public void test3()  throws Throwable  {
      BrokenClock brokenClock0 = new BrokenClock();
      assertNotNull(brokenClock0);
  }
}