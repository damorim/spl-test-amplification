/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.bind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.RecordNumberBinding;
import com.sleepycat.je.DatabaseEntry;

@RunWith(EvoSuiteRunner.class)
public class TestRecordNumberBinding_1 {


  //Test case number: 1
  /*
   * 34 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.bind.RecordNumberBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:41 - DeleteStatement: longValue()J
   * 2 Weak Mutation 2: com.sleepycat.bind.RecordNumberBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:41 - DeleteStatement: recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V
   * 3 Weak Mutation 11: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 0
   * 4 Weak Mutation 12: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 1
   * 5 Weak Mutation 13: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> -1
   * 6 Weak Mutation 14: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 3
   * 7 Weak Mutation 15: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 5
   * 8 Weak Mutation 17: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 0
   * 9 Weak Mutation 16: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 0 -> 1
   * 10 Weak Mutation 19: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> -1
   * 11 Weak Mutation 18: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 1
   * 12 Weak Mutation 21: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 5
   * 13 Weak Mutation 20: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 3
   * 14 Weak Mutation 22: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - DeleteStatement: setData([BII)V
   * 15 Weak Mutation 23: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:68 - InsertUnaryOp Negation of recordNumber
   * 16 Weak Mutation 24: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:68 - DeleteStatement: setRecordNumber(Lcom/sleepycat/je/DatabaseEntry;I)V
   * 17 com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V: root-Branch
   * 18 com.sleepycat.bind.RecordNumberBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V: root-Branch
   * 19 Weak Mutation 1: com.sleepycat.bind.RecordNumberBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:41 - DeleteStatement: longValue()J
   * 20 Weak Mutation 2: com.sleepycat.bind.RecordNumberBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:41 - DeleteStatement: recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V
   * 21 Weak Mutation 11: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 0
   * 22 Weak Mutation 12: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 1
   * 23 Weak Mutation 13: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> -1
   * 24 Weak Mutation 14: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 3
   * 25 Weak Mutation 15: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 5
   * 26 Weak Mutation 17: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 0
   * 27 Weak Mutation 16: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 0 -> 1
   * 28 Weak Mutation 19: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> -1
   * 29 Weak Mutation 18: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 1
   * 30 Weak Mutation 21: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 5
   * 31 Weak Mutation 20: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - ReplaceConstant - 4 -> 3
   * 32 Weak Mutation 23: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:68 - InsertUnaryOp Negation of recordNumber
   * 33 Weak Mutation 22: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:67 - DeleteStatement: setData([BII)V
   * 34 Weak Mutation 24: com.sleepycat.bind.RecordNumberBinding.recordNumberToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:68 - DeleteStatement: setRecordNumber(Lcom/sleepycat/je/DatabaseEntry;I)V
   */
  @Test
  public void test1()  throws Throwable  {
      RecordNumberBinding recordNumberBinding0 = new RecordNumberBinding();
      Short short0 = new Short((short)0);
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      // Undeclared exception!
      try {
        recordNumberBinding0.objectToEntry((Object) short0, databaseEntry0);
        fail("Expecting exception: UnsupportedOperationException");
      } catch(UnsupportedOperationException e) {
      }
  }
}