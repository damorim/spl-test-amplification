/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.bind.tuple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.tuple.TupleInput;
import com.sleepycat.bind.tuple.TupleInputBinding;
import com.sleepycat.je.DatabaseEntry;

@RunWith(EvoSuiteRunner.class)
public class TestTupleInputBinding {


  //Test case number: 0
  /*
   * 7 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.bind.tuple.TupleInputBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:44 - DeleteStatement: inputToEntry(Lcom/sleepycat/bind/tuple/TupleInput;Lcom/sleepycat/je/DatabaseEntry;)V
   * 2 com.sleepycat.bind.tuple.TupleInputBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.bind.tuple.TupleInputBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:38 - DeleteStatement: entryToInput(Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/bind/tuple/TupleInput;
   * 4 Weak Mutation 0: com.sleepycat.bind.tuple.TupleInputBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:38 - DeleteStatement: entryToInput(Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/bind/tuple/TupleInput;
   * 5 Weak Mutation 1: com.sleepycat.bind.tuple.TupleInputBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:44 - DeleteStatement: inputToEntry(Lcom/sleepycat/bind/tuple/TupleInput;Lcom/sleepycat/je/DatabaseEntry;)V
   * 6 com.sleepycat.bind.tuple.TupleInputBinding.<init>()V: root-Branch
   * 7 com.sleepycat.bind.tuple.TupleInputBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      TupleInputBinding tupleInputBinding0 = new TupleInputBinding();
      byte[] byteArray0 = new byte[9];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0, (int) (byte)0, (int) (byte)0);
      TupleInput tupleInput0 = (TupleInput)tupleInputBinding0.entryToObject(databaseEntry0);
      tupleInputBinding0.objectToEntry((Object) tupleInput0, databaseEntry0);
      assertEquals(0, databaseEntry0.getSize());
  }
}