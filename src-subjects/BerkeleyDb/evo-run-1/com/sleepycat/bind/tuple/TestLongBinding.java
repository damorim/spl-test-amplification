/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.bind.tuple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.tuple.LongBinding;
import com.sleepycat.je.DatabaseEntry;

@RunWith(EvoSuiteRunner.class)
public class TestLongBinding {


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.bind.tuple.LongBinding.entryToObject(Lcom/sleepycat/bind/tuple/TupleInput;)Ljava/lang/Object;:36 - DeleteStatement: readLong()J
   * 2 com.sleepycat.bind.tuple.LongBinding.entryToObject(Lcom/sleepycat/bind/tuple/TupleInput;)Ljava/lang/Object;: root-Branch
   * 3 com.sleepycat.bind.tuple.LongBinding.<init>()V: root-Branch
   * 4 Weak Mutation 0: com.sleepycat.bind.tuple.LongBinding.entryToObject(Lcom/sleepycat/bind/tuple/TupleInput;)Ljava/lang/Object;:36 - DeleteStatement: readLong()J
   */
  @Test
  public void test0()  throws Throwable  {
      LongBinding longBinding0 = new LongBinding();
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      // Undeclared exception!
      try {
        longBinding0.entryToObject(databaseEntry0);
        fail("Expecting exception: IndexOutOfBoundsException");
      } catch(IndexOutOfBoundsException e) {
      }
  }

  //Test case number: 1
  /*
   * 19 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.bind.tuple.LongBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V:42 - DeleteStatement: longValue()J
   * 2 Weak Mutation 2: com.sleepycat.bind.tuple.LongBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V:42 - DeleteStatement: writeLong(J)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 3 Weak Mutation 3: com.sleepycat.bind.tuple.LongBinding.getTupleOutput(Ljava/lang/Object;)Lcom/sleepycat/bind/tuple/TupleOutput;:48 - DeleteStatement: sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;
   * 4 Weak Mutation 10: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 0
   * 5 Weak Mutation 11: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 1
   * 6 Weak Mutation 12: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> -1
   * 7 Weak Mutation 13: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 7
   * 8 Weak Mutation 14: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 9
   * 9 com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;: root-Branch
   * 10 com.sleepycat.bind.tuple.LongBinding.getTupleOutput(Ljava/lang/Object;)Lcom/sleepycat/bind/tuple/TupleOutput;: root-Branch
   * 11 com.sleepycat.bind.tuple.LongBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V: root-Branch
   * 12 Weak Mutation 1: com.sleepycat.bind.tuple.LongBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V:42 - DeleteStatement: longValue()J
   * 13 Weak Mutation 2: com.sleepycat.bind.tuple.LongBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V:42 - DeleteStatement: writeLong(J)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 14 Weak Mutation 3: com.sleepycat.bind.tuple.LongBinding.getTupleOutput(Ljava/lang/Object;)Lcom/sleepycat/bind/tuple/TupleOutput;:48 - DeleteStatement: sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;
   * 15 Weak Mutation 10: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 0
   * 16 Weak Mutation 11: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 1
   * 17 Weak Mutation 12: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> -1
   * 18 Weak Mutation 13: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 7
   * 19 Weak Mutation 14: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 9
   */
  @Test
  public void test1()  throws Throwable  {
      LongBinding longBinding0 = new LongBinding();
      Byte byte0 = Byte.valueOf((byte)0);
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      longBinding0.objectToEntry((Object) byte0, databaseEntry0);
      assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=8>", databaseEntry0.toString());
      assertEquals(8, databaseEntry0.getSize());
  }

  //Test case number: 2
  /*
   * 5 covered goals:
   * 1 Weak Mutation 4: com.sleepycat.bind.tuple.LongBinding.entryToLong(Lcom/sleepycat/je/DatabaseEntry;)J:60 - DeleteStatement: entryToInput(Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/bind/tuple/TupleInput;
   * 2 Weak Mutation 5: com.sleepycat.bind.tuple.LongBinding.entryToLong(Lcom/sleepycat/je/DatabaseEntry;)J:60 - DeleteStatement: readLong()J
   * 3 com.sleepycat.bind.tuple.LongBinding.entryToLong(Lcom/sleepycat/je/DatabaseEntry;)J: root-Branch
   * 4 Weak Mutation 4: com.sleepycat.bind.tuple.LongBinding.entryToLong(Lcom/sleepycat/je/DatabaseEntry;)J:60 - DeleteStatement: entryToInput(Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/bind/tuple/TupleInput;
   * 5 Weak Mutation 5: com.sleepycat.bind.tuple.LongBinding.entryToLong(Lcom/sleepycat/je/DatabaseEntry;)J:60 - DeleteStatement: readLong()J
   */
  @Test
  public void test2()  throws Throwable  {
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      // Undeclared exception!
      try {
        LongBinding.entryToLong(databaseEntry0);
        fail("Expecting exception: IndexOutOfBoundsException");
      } catch(IndexOutOfBoundsException e) {
      }
  }

  //Test case number: 3
  /*
   * 14 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - DeleteStatement: sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;
   * 2 Weak Mutation 7: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - InsertUnaryOp Negation of val
   * 3 Weak Mutation 8: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - DeleteStatement: writeLong(J)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 4 Weak Mutation 9: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - DeleteStatement: outputToEntry(Lcom/sleepycat/bind/tuple/TupleOutput;Lcom/sleepycat/je/DatabaseEntry;)V
   * 5 com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V: root-Branch
   * 6 Weak Mutation 10: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 0
   * 7 Weak Mutation 11: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 1
   * 8 Weak Mutation 12: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> -1
   * 9 Weak Mutation 13: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 7
   * 10 Weak Mutation 14: com.sleepycat.bind.tuple.LongBinding.sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;:81 - ReplaceConstant - 8 -> 9
   * 11 Weak Mutation 6: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - DeleteStatement: sizedOutput()Lcom/sleepycat/bind/tuple/TupleOutput;
   * 12 Weak Mutation 7: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - InsertUnaryOp Negation of val
   * 13 Weak Mutation 8: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - DeleteStatement: writeLong(J)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 14 Weak Mutation 9: com.sleepycat.bind.tuple.LongBinding.longToEntry(JLcom/sleepycat/je/DatabaseEntry;)V:72 - DeleteStatement: outputToEntry(Lcom/sleepycat/bind/tuple/TupleOutput;Lcom/sleepycat/je/DatabaseEntry;)V
   */
  @Test
  public void test3()  throws Throwable  {
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      LongBinding.longToEntry((-9223372036854775808L), databaseEntry0);
      assertEquals(8, databaseEntry0.getSize());
      assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=8>", databaseEntry0.toString());
  }
}