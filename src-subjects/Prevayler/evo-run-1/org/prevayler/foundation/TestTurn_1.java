/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.prevayler.foundation.Turn;

@RunWith(EvoSuiteRunner.class)
public class TestTurn_1 {


  //Test case number: 1
  /*
   * 23 covered goals:
   * 1 org.prevayler.foundation.Turn.end()V: root-Branch
   * 2 org.prevayler.foundation.Turn.first()Lorg/prevayler/foundation/Turn;: root-Branch
   * 3 org.prevayler.foundation.Turn.next()Lorg/prevayler/foundation/Turn;: I4 Branch 1 IFNONNULL L16 - true
   * 4 org.prevayler.foundation.Turn.start()V: I4 Branch 2 IFNE L20 - true
   * 5 org.prevayler.foundation.Turn.haveSomeTickets(I)V: I4 Branch 3 IFEQ L27 - true
   * 6 org.prevayler.foundation.Turn.next()Lorg/prevayler/foundation/Turn;: I4 Branch 1 IFNONNULL L16 - false
   * 7 Weak Mutation 5: org.prevayler.foundation.Turn.<init>(I)V:7 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 9: org.prevayler.foundation.Turn.next()Lorg/prevayler/foundation/Turn;:16 - DeleteField: _nextLorg/prevayler/foundation/Turn;
   * 9 Weak Mutation 13: org.prevayler.foundation.Turn.start()V:20 - InsertUnaryOp Negation
   * 10 Weak Mutation 13: org.prevayler.foundation.Turn.start()V:20 - InsertUnaryOp Negation
   * 11 Weak Mutation 14: org.prevayler.foundation.Turn.start()V:20 - InsertUnaryOp +1
   * 12 Weak Mutation 15: org.prevayler.foundation.Turn.start()V:20 - InsertUnaryOp -1
   * 13 Weak Mutation 17: org.prevayler.foundation.Turn.start()V:20 - ReplaceComparisonOperator != -> <
   * 14 Weak Mutation 16: org.prevayler.foundation.Turn.start()V:20 - DeleteField: _ticketsI
   * 15 Weak Mutation 21: org.prevayler.foundation.Turn.start()V:21 - InsertUnaryOp Negation
   * 16 Weak Mutation 23: org.prevayler.foundation.Turn.start()V:21 - InsertUnaryOp -1
   * 17 Weak Mutation 22: org.prevayler.foundation.Turn.start()V:21 - InsertUnaryOp +1
   * 18 Weak Mutation 25: org.prevayler.foundation.Turn.start()V:21 - ReplaceConstant - 1 -> 0
   * 19 Weak Mutation 24: org.prevayler.foundation.Turn.start()V:21 - DeleteField: _ticketsI
   * 20 Weak Mutation 27: org.prevayler.foundation.Turn.start()V:21 - ReplaceArithmeticOperator - -> %
   * 21 Weak Mutation 26: org.prevayler.foundation.Turn.start()V:21 - ReplaceArithmeticOperator - -> +
   * 22 Weak Mutation 29: org.prevayler.foundation.Turn.start()V:21 - ReplaceArithmeticOperator - -> *
   * 23 Weak Mutation 28: org.prevayler.foundation.Turn.start()V:21 - ReplaceArithmeticOperator - -> /
   */
  @Test
  public void test1()  throws Throwable  {
      Turn turn0 = Turn.first();
      Turn turn1 = turn0.next();
      turn1.end();
      Turn turn2 = turn1.next();
      Turn turn3 = Turn.first();
      turn2.next();
      turn3.start();
      assertFalse(turn3.equals(turn2));
  }
}