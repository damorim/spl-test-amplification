/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.Observable;
import java.util.Observer;
import org.softlang.features.Logging;
import org.softlang.features.Precedence;
import org.softlang.util.ObservableSimpleList;
import org.softlang.util.SimpleLinkedList;
import org.softlang.util.SimpleList;

@RunWith(EvoSuiteRunner.class)
public class TestObservableSimpleList_2 {


  //Test case number: 2
  /*
   * 12 covered goals:
   * 1 Weak Mutation 15: org.softlang.util.ObservableSimpleList.deleteObservers()V:41 - DeleteStatement: next()Ljava/lang/Object;
   * 2 Weak Mutation 16: org.softlang.util.ObservableSimpleList.deleteObservers()V:42 - ReplaceComparisonOperator == -> !=
   * 3 Weak Mutation 17: org.softlang.util.ObservableSimpleList.deleteObservers()V:43 - DeleteStatement: deleteObservers()V
   * 4 org.softlang.util.ObservableSimpleList.deleteObservers()V: I12 Branch 5 IFEQ L41 - false
   * 5 org.softlang.util.ObservableSimpleList.deleteObservers()V: I20 Branch 6 IFEQ L42 - false
   * 6 Weak Mutation 12: org.softlang.util.ObservableSimpleList.deleteObservers()V:41 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 7 Weak Mutation 13: org.softlang.util.ObservableSimpleList.deleteObservers()V:41 - DeleteStatement: hasNext()Z
   * 8 Weak Mutation 14: org.softlang.util.ObservableSimpleList.deleteObservers()V:41 - ReplaceComparisonOperator == -> !=
   * 9 Weak Mutation 15: org.softlang.util.ObservableSimpleList.deleteObservers()V:41 - DeleteStatement: next()Ljava/lang/Object;
   * 10 Weak Mutation 17: org.softlang.util.ObservableSimpleList.deleteObservers()V:43 - DeleteStatement: deleteObservers()V
   * 11 Weak Mutation 16: org.softlang.util.ObservableSimpleList.deleteObservers()V:42 - ReplaceComparisonOperator == -> !=
   * 12 org.softlang.util.ObservableSimpleList.deleteObservers()V: I12 Branch 5 IFEQ L41 - true
   */
  @Test
  public void test2()  throws Throwable  {
      SimpleLinkedList<Object> simpleLinkedList0 = new SimpleLinkedList<Object>();
      ObservableSimpleList<Object> observableSimpleList0 = new ObservableSimpleList<Object>((SimpleList<Object>) simpleLinkedList0);
      SimpleLinkedList<Observable> simpleLinkedList1 = new SimpleLinkedList<Observable>();
      ObservableSimpleList<Observable> observableSimpleList1 = new ObservableSimpleList<Observable>((SimpleList<Observable>) simpleLinkedList1);
      boolean boolean0 = observableSimpleList0.add((Object) observableSimpleList1);
      assertEquals(true, boolean0);
      
      observableSimpleList0.deleteObservers();
      assertEquals(false, observableSimpleList0.hasChanged());
  }
}