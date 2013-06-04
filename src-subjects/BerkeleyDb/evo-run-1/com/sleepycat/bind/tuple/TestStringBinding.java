/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.bind.tuple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.tuple.StringBinding;
import com.sleepycat.je.DatabaseEntry;

@RunWith(EvoSuiteRunner.class)
public class TestStringBinding {


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.bind.tuple.StringBinding.entryToObject(Lcom/sleepycat/bind/tuple/TupleInput;)Ljava/lang/Object;:34 - DeleteStatement: readString()Ljava/lang/String;
   * 2 com.sleepycat.bind.tuple.StringBinding.<init>()V: root-Branch
   * 3 com.sleepycat.bind.tuple.StringBinding.entryToObject(Lcom/sleepycat/bind/tuple/TupleInput;)Ljava/lang/Object;: root-Branch
   * 4 Weak Mutation 0: com.sleepycat.bind.tuple.StringBinding.entryToObject(Lcom/sleepycat/bind/tuple/TupleInput;)Ljava/lang/Object;:34 - DeleteStatement: readString()Ljava/lang/String;
   */
  @Test
  public void test0()  throws Throwable  {
      StringBinding stringBinding0 = new StringBinding();
      byte[] byteArray0 = new byte[9];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0, (int) (byte)0, 2);
      String string0 = (String)stringBinding0.entryToObject(databaseEntry0);
      assertEquals("", string0);
  }

  //Test case number: 1
  /*
   * 19 covered goals:
   * 1 Weak Mutation 1: com.sleepycat.bind.tuple.StringBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V:40 - DeleteStatement: writeString(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 2 Weak Mutation 2: com.sleepycat.bind.tuple.StringBinding.getTupleOutput(Ljava/lang/Object;)Lcom/sleepycat/bind/tuple/TupleOutput;:46 - DeleteStatement: sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 3 Weak Mutation 8: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - ReplaceComparisonOperator != null -> = null
   * 4 Weak Mutation 10: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - DeleteStatement: toCharArray()[C
   * 5 Weak Mutation 11: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - DeleteStatement: getByteLength([C)I
   * 6 Weak Mutation 12: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp Negation of stringLength
   * 7 Weak Mutation 13: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp IINC 1 stringLength
   * 8 Weak Mutation 14: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp IINC -1 stringLength
   * 9 com.sleepycat.bind.tuple.StringBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V: root-Branch
   * 10 com.sleepycat.bind.tuple.StringBinding.getTupleOutput(Ljava/lang/Object;)Lcom/sleepycat/bind/tuple/TupleOutput;: root-Branch
   * 11 com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;: I3 Branch 1 IFNONNULL L80 - true
   * 12 Weak Mutation 1: com.sleepycat.bind.tuple.StringBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/bind/tuple/TupleOutput;)V:40 - DeleteStatement: writeString(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 13 Weak Mutation 2: com.sleepycat.bind.tuple.StringBinding.getTupleOutput(Ljava/lang/Object;)Lcom/sleepycat/bind/tuple/TupleOutput;:46 - DeleteStatement: sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 14 Weak Mutation 8: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - ReplaceComparisonOperator != null -> = null
   * 15 Weak Mutation 10: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - DeleteStatement: toCharArray()[C
   * 16 Weak Mutation 11: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - DeleteStatement: getByteLength([C)I
   * 17 Weak Mutation 12: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp Negation of stringLength
   * 18 Weak Mutation 13: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp IINC 1 stringLength
   * 19 Weak Mutation 14: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp IINC -1 stringLength
   */
  @Test
  public void test1()  throws Throwable  {
      StringBinding stringBinding0 = new StringBinding();
      byte[] byteArray0 = new byte[9];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0, (int) (byte)0, 2);
      stringBinding0.objectToEntry((Object) "", databaseEntry0);
      assertEquals(1, databaseEntry0.getSize());
      assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=1>", databaseEntry0.toString());
  }

  //Test case number: 2
  /*
   * 5 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.bind.tuple.StringBinding.entryToString(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/String;:58 - DeleteStatement: entryToInput(Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/bind/tuple/TupleInput;
   * 2 Weak Mutation 4: com.sleepycat.bind.tuple.StringBinding.entryToString(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/String;:58 - DeleteStatement: readString()Ljava/lang/String;
   * 3 com.sleepycat.bind.tuple.StringBinding.entryToString(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/String;: root-Branch
   * 4 Weak Mutation 3: com.sleepycat.bind.tuple.StringBinding.entryToString(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/String;:58 - DeleteStatement: entryToInput(Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/bind/tuple/TupleInput;
   * 5 Weak Mutation 4: com.sleepycat.bind.tuple.StringBinding.entryToString(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/String;:58 - DeleteStatement: readString()Ljava/lang/String;
   */
  @Test
  public void test2()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0);
      String string0 = StringBinding.entryToString(databaseEntry0);
      assertEquals("", string0);
  }

  //Test case number: 3
  /*
   * 14 covered goals:
   * 1 Weak Mutation 5: com.sleepycat.bind.tuple.StringBinding.stringToEntry(Ljava/lang/String;Lcom/sleepycat/je/DatabaseEntry;)V:70 - DeleteStatement: sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 2 Weak Mutation 6: com.sleepycat.bind.tuple.StringBinding.stringToEntry(Ljava/lang/String;Lcom/sleepycat/je/DatabaseEntry;)V:70 - DeleteStatement: writeString(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 3 Weak Mutation 7: com.sleepycat.bind.tuple.StringBinding.stringToEntry(Ljava/lang/String;Lcom/sleepycat/je/DatabaseEntry;)V:70 - DeleteStatement: outputToEntry(Lcom/sleepycat/bind/tuple/TupleOutput;Lcom/sleepycat/je/DatabaseEntry;)V
   * 4 Weak Mutation 9: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - ReplaceConstant - 1 -> 0
   * 5 com.sleepycat.bind.tuple.StringBinding.stringToEntry(Ljava/lang/String;Lcom/sleepycat/je/DatabaseEntry;)V: root-Branch
   * 6 com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;: I3 Branch 1 IFNONNULL L80 - false
   * 7 Weak Mutation 8: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - ReplaceComparisonOperator != null -> = null
   * 8 Weak Mutation 12: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp Negation of stringLength
   * 9 Weak Mutation 13: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp IINC 1 stringLength
   * 10 Weak Mutation 14: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:82 - InsertUnaryOp IINC -1 stringLength
   * 11 Weak Mutation 5: com.sleepycat.bind.tuple.StringBinding.stringToEntry(Ljava/lang/String;Lcom/sleepycat/je/DatabaseEntry;)V:70 - DeleteStatement: sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 12 Weak Mutation 6: com.sleepycat.bind.tuple.StringBinding.stringToEntry(Ljava/lang/String;Lcom/sleepycat/je/DatabaseEntry;)V:70 - DeleteStatement: writeString(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;
   * 13 Weak Mutation 7: com.sleepycat.bind.tuple.StringBinding.stringToEntry(Ljava/lang/String;Lcom/sleepycat/je/DatabaseEntry;)V:70 - DeleteStatement: outputToEntry(Lcom/sleepycat/bind/tuple/TupleOutput;Lcom/sleepycat/je/DatabaseEntry;)V
   * 14 Weak Mutation 9: com.sleepycat.bind.tuple.StringBinding.sizedOutput(Ljava/lang/String;)Lcom/sleepycat/bind/tuple/TupleOutput;:80 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test3()  throws Throwable  {
      // Undeclared exception!
      try {
        StringBinding.stringToEntry((String) null, (DatabaseEntry) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}