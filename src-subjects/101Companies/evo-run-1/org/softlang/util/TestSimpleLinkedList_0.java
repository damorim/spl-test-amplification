/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.softlang.util.SimpleLinkedList;

@RunWith(EvoSuiteRunner.class)
public class TestSimpleLinkedList_0 {


  //Test case number: 0
  /*
   * 6 covered goals:
   * 1 Weak Mutation 0: org.softlang.util.SimpleLinkedList.iterator()Ljava/util/Iterator;:15 - DeleteField: innerLjava/util/LinkedList;
   * 2 Weak Mutation 1: org.softlang.util.SimpleLinkedList.iterator()Ljava/util/Iterator;:15 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 3 org.softlang.util.SimpleLinkedList.<init>()V: root-Branch
   * 4 org.softlang.util.SimpleLinkedList.iterator()Ljava/util/Iterator;: root-Branch
   * 5 Weak Mutation 0: org.softlang.util.SimpleLinkedList.iterator()Ljava/util/Iterator;:15 - DeleteField: innerLjava/util/LinkedList;
   * 6 Weak Mutation 1: org.softlang.util.SimpleLinkedList.iterator()Ljava/util/Iterator;:15 - DeleteStatement: iterator()Ljava/util/Iterator;
   */
  @Test
  public void test0()  throws Throwable  {
      SimpleLinkedList<Object> simpleLinkedList0 = new SimpleLinkedList<Object>();
      Iterator<Object> iterator0 = simpleLinkedList0.iterator();
      assertEquals(false, iterator0.hasNext());
  }
}