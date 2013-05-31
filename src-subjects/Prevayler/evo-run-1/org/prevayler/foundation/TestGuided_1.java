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
public class TestGuided_1 {


  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 2: org.prevayler.foundation.Guided.endTurn()V:13 - DeleteField: _turnLorg/prevayler/foundation/Turn;
   * 2 Weak Mutation 3: org.prevayler.foundation.Guided.endTurn()V:13 - DeleteStatement: end()V
   * 3 org.prevayler.foundation.Guided.endTurn()V: root-Branch
   * 4 Weak Mutation 2: org.prevayler.foundation.Guided.endTurn()V:13 - DeleteField: _turnLorg/prevayler/foundation/Turn;
   * 5 Weak Mutation 3: org.prevayler.foundation.Guided.endTurn()V:13 - DeleteStatement: end()V
   */
  @Test
  public void test1()  throws Throwable  {
      Turn turn0 = Turn.first();
      TransactionGuide transactionGuide0 = new TransactionGuide((TransactionTimestamp) null, turn0);
      transactionGuide0.endTurn();
  }
}
