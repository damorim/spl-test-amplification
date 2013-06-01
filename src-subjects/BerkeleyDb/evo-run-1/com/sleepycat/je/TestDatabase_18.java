/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DatabaseTrigger;
import com.sleepycat.je.Environment;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.SecondaryTrigger;
import com.sleepycat.je.SequenceConfig;
import com.sleepycat.je.dbi.PutMode;
import java.io.File;

@RunWith(EvoSuiteRunner.class)
public class TestDatabase_18 {


  //Test case number: 18
  /*
   * 41 covered goals:
   * 1 Weak Mutation 335: com.sleepycat.je.Database.hasTriggers()Z:879 - ReplaceConstant - 1 -> 0
   * 2 Weak Mutation 333: com.sleepycat.je.Database.hasTriggers()Z:879 - DeleteField: triggerListLjava/util/List;
   * 3 Weak Mutation 338: com.sleepycat.je.Database.acquireTriggerListReadLock()V:891 - ReplaceComparisonOperator != null -> = null
   * 4 Weak Mutation 337: com.sleepycat.je.Database.acquireTriggerListReadLock()V:891 - DeleteField: triggerListLjava/util/List;
   * 5 Weak Mutation 340: com.sleepycat.je.Database.acquireTriggerListWriteLock()V:914 - ReplaceComparisonOperator != null -> = null
   * 6 Weak Mutation 343: com.sleepycat.je.Database.releaseTriggerListWriteLock()V:924 - ReplaceComparisonOperator != -> <
   * 7 Weak Mutation 342: com.sleepycat.je.Database.releaseTriggerListWriteLock()V:924 - DeleteStatement: size()I
   * 8 Weak Mutation 341: com.sleepycat.je.Database.releaseTriggerListWriteLock()V:924 - DeleteField: triggerListLjava/util/List;
   * 9 Weak Mutation 349: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - ReplaceComparisonOperator == -> !=
   * 10 Weak Mutation 348: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 347: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 346: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - InsertUnaryOp Negation
   * 13 Weak Mutation 351: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:941 - ReplaceConstant - 0 -> 1
   * 14 Weak Mutation 350: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:941 - DeleteField: triggerListLjava/util/List;
   * 15 Weak Mutation 352: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:941 - DeleteStatement: add(ILjava/lang/Object;)V
   * 16 Weak Mutation 355: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:946 - DeleteStatement: triggerAdded(Lcom/sleepycat/je/Database;)V
   * 17 com.sleepycat.je.Database.getSecondaryDatabases()Ljava/util/List;: I10 Branch 43 IFEQ L720 - false
   * 18 com.sleepycat.je.Database.hasTriggers()Z: I4 Branch 49 IFNULL L879 - false
   * 19 com.sleepycat.je.Database.acquireTriggerListReadLock()V: I4 Branch 50 IFNONNULL L891 - true
   * 20 com.sleepycat.je.Database.acquireTriggerListWriteLock()V: I4 Branch 51 IFNONNULL L914 - false
   * 21 com.sleepycat.je.Database.releaseTriggerListWriteLock()V: I5 Branch 52 IFNE L924 - true
   * 22 com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V: I7 Branch 53 IFEQ L940 - false
   * 23 Weak Mutation 288: com.sleepycat.je.Database.getSecondaryDatabases()Ljava/util/List;:720 - DeleteStatement: hasTriggers()Z
   * 24 Weak Mutation 289: com.sleepycat.je.Database.getSecondaryDatabases()Ljava/util/List;:720 - ReplaceComparisonOperator == -> !=
   * 25 Weak Mutation 334: com.sleepycat.je.Database.hasTriggers()Z:879 - ReplaceComparisonOperator = null -> != null
   * 26 Weak Mutation 343: com.sleepycat.je.Database.releaseTriggerListWriteLock()V:924 - ReplaceComparisonOperator != -> <
   * 27 Weak Mutation 342: com.sleepycat.je.Database.releaseTriggerListWriteLock()V:924 - DeleteStatement: size()I
   * 28 Weak Mutation 341: com.sleepycat.je.Database.releaseTriggerListWriteLock()V:924 - DeleteField: triggerListLjava/util/List;
   * 29 Weak Mutation 340: com.sleepycat.je.Database.acquireTriggerListWriteLock()V:914 - ReplaceComparisonOperator != null -> = null
   * 30 Weak Mutation 338: com.sleepycat.je.Database.acquireTriggerListReadLock()V:891 - ReplaceComparisonOperator != null -> = null
   * 31 Weak Mutation 337: com.sleepycat.je.Database.acquireTriggerListReadLock()V:891 - DeleteField: triggerListLjava/util/List;
   * 32 Weak Mutation 351: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:941 - ReplaceConstant - 0 -> 1
   * 33 Weak Mutation 350: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:941 - DeleteField: triggerListLjava/util/List;
   * 34 Weak Mutation 349: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - ReplaceComparisonOperator == -> !=
   * 35 Weak Mutation 348: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - InsertUnaryOp IINC -1
   * 36 Weak Mutation 347: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - InsertUnaryOp IINC 1
   * 37 Weak Mutation 346: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:940 - InsertUnaryOp Negation
   * 38 Weak Mutation 335: com.sleepycat.je.Database.hasTriggers()Z:879 - ReplaceConstant - 1 -> 0
   * 39 Weak Mutation 333: com.sleepycat.je.Database.hasTriggers()Z:879 - DeleteField: triggerListLjava/util/List;
   * 40 Weak Mutation 352: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:941 - DeleteStatement: add(ILjava/lang/Object;)V
   * 41 Weak Mutation 355: com.sleepycat.je.Database.addTrigger(Lcom/sleepycat/je/DatabaseTrigger;Z)V:946 - DeleteStatement: triggerAdded(Lcom/sleepycat/je/Database;)V
   */
  @Test
  public void test18()  throws Throwable  {
      Database database0 = new Database((Environment) null);
      SecondaryTrigger secondaryTrigger0 = new SecondaryTrigger((SecondaryDatabase) null);
      database0.addTrigger((DatabaseTrigger) secondaryTrigger0, true);
      database0.getSecondaryDatabases();
      assertEquals(true, database0.hasTriggers());
  }
}
