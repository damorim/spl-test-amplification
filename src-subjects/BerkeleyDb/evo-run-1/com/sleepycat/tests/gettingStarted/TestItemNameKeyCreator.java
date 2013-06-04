/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.tests.gettingStarted;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.tuple.BooleanBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.tests.gettingStarted.ItemNameKeyCreator;

@RunWith(EvoSuiteRunner.class)
public class TestItemNameKeyCreator {


  //Test case number: 0
  /*
   * 16 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:26 - ReplaceVariable dataEntry -> keyEntry
   * 2 Weak Mutation 1: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:26 - ReplaceVariable dataEntry -> resultEntry
   * 3 Weak Mutation 2: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:26 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 3: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - DeleteField: theBindingLcom/sleepycat/bind/tuple/TupleBinding;
   * 5 Weak Mutation 4: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - ReplaceVariable dataEntry -> keyEntry
   * 6 Weak Mutation 5: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - ReplaceVariable dataEntry -> resultEntry
   * 7 Weak Mutation 6: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - DeleteStatement: entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;
   * 8 com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.<init>(Lcom/sleepycat/bind/tuple/TupleBinding;)V: root-Branch
   * 9 com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z: I3 Branch 1 IFNULL L26 - false
   * 10 Weak Mutation 0: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:26 - ReplaceVariable dataEntry -> keyEntry
   * 11 Weak Mutation 1: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:26 - ReplaceVariable dataEntry -> resultEntry
   * 12 Weak Mutation 2: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:26 - ReplaceComparisonOperator = null -> != null
   * 13 Weak Mutation 3: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - DeleteField: theBindingLcom/sleepycat/bind/tuple/TupleBinding;
   * 14 Weak Mutation 4: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - ReplaceVariable dataEntry -> keyEntry
   * 15 Weak Mutation 5: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - ReplaceVariable dataEntry -> resultEntry
   * 16 Weak Mutation 6: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:29 - DeleteStatement: entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;
   */
  @Test
  public void test0()  throws Throwable  {
      BooleanBinding booleanBinding0 = new BooleanBinding();
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      ItemNameKeyCreator itemNameKeyCreator0 = new ItemNameKeyCreator((TupleBinding) booleanBinding0);
      // Undeclared exception!
      try {
        itemNameKeyCreator0.createSecondaryKey((SecondaryDatabase) null, (DatabaseEntry) null, databaseEntry0, (DatabaseEntry) null);
        fail("Expecting exception: IndexOutOfBoundsException");
      } catch(IndexOutOfBoundsException e) {
      }
  }

  //Test case number: 1
  /*
   * 4 covered goals:
   * 1 Weak Mutation 12: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:34 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z: I3 Branch 1 IFNULL L26 - true
   * 3 Weak Mutation 2: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:26 - ReplaceComparisonOperator = null -> != null
   * 4 Weak Mutation 12: com.sleepycat.tests.gettingStarted.ItemNameKeyCreator.createSecondaryKey(Lcom/sleepycat/je/SecondaryDatabase;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Z:34 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test1()  throws Throwable  {
      BooleanBinding booleanBinding0 = new BooleanBinding();
      ItemNameKeyCreator itemNameKeyCreator0 = new ItemNameKeyCreator((TupleBinding) booleanBinding0);
      boolean boolean0 = itemNameKeyCreator0.createSecondaryKey((SecondaryDatabase) null, (DatabaseEntry) null, (DatabaseEntry) null, (DatabaseEntry) null);
      assertEquals(true, boolean0);
  }
}
