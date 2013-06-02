/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.prevayler.foundation.Turn;
import org.prevayler.implementation.TransactionGuide;
import org.prevayler.implementation.TransactionTimestamp;

@RunWith(EvoSuiteRunner.class)
public class TestGuided_0 {


  //Test case number: 0
  /*
   * 6 covered goals:
   * 1 Weak Mutation 0: org.prevayler.foundation.Guided.startTurn()V:10 - DeleteField: _turnLorg/prevayler/foundation/Turn;
   * 2 Weak Mutation 1: org.prevayler.foundation.Guided.startTurn()V:10 - DeleteStatement: start()V
   * 3 org.prevayler.foundation.Guided.startTurn()V: root-Branch
   * 4 org.prevayler.foundation.Guided.<init>(Lorg/prevayler/foundation/Turn;)V: root-Branch
   * 5 Weak Mutation 0: org.prevayler.foundation.Guided.startTurn()V:10 - DeleteField: _turnLorg/prevayler/foundation/Turn;
   * 6 Weak Mutation 1: org.prevayler.foundation.Guided.startTurn()V:10 - DeleteStatement: start()V
   */
  @Test
  public void test0()  throws Throwable  {
      Turn turn0 = Turn.first();
      TransactionGuide transactionGuide0 = new TransactionGuide((TransactionTimestamp) null, turn0);
      transactionGuide0.startTurn();
  }
}