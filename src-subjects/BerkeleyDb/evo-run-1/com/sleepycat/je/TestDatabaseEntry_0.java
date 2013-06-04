/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseEntry;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseEntry_0 {


  //Test case number: 0
  /*
   * 93 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - DeleteField: dlenI
   * 2 Weak Mutation 13: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - DeleteField: doffI
   * 3 Weak Mutation 20: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - DeleteField: doffI
   * 4 Weak Mutation 71: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - InsertUnaryOp Negation
   * 5 Weak Mutation 72: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 73: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 74: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - DeleteStatement: setPartialOffset(I)V
   * 8 Weak Mutation 76: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 77: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 78: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - DeleteStatement: setPartialLength(I)V
   * 11 Weak Mutation 75: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - InsertUnaryOp Negation
   * 12 Weak Mutation 79: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - InsertUnaryOp Negation
   * 13 Weak Mutation 81: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 80: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 82: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - DeleteStatement: setPartial(Z)V
   * 16 Weak Mutation 87: com.sleepycat.je.DatabaseEntry.setPartialLength(I)V:95 - InsertUnaryOp Negation
   * 17 Weak Mutation 89: com.sleepycat.je.DatabaseEntry.setPartialLength(I)V:95 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 88: com.sleepycat.je.DatabaseEntry.setPartialLength(I)V:95 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 95: com.sleepycat.je.DatabaseEntry.setPartialOffset(I)V:109 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 94: com.sleepycat.je.DatabaseEntry.setPartialOffset(I)V:109 - InsertUnaryOp Negation
   * 21 Weak Mutation 96: com.sleepycat.je.DatabaseEntry.setPartialOffset(I)V:109 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 100: com.sleepycat.je.DatabaseEntry.setPartial(Z)V:123 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 101: com.sleepycat.je.DatabaseEntry.setPartial(Z)V:123 - InsertUnaryOp IINC -1
   * 24 Weak Mutation 99: com.sleepycat.je.DatabaseEntry.setPartial(Z)V:123 - InsertUnaryOp Negation
   * 25 com.sleepycat.je.DatabaseEntry.setPartial(Z)V: root-Branch
   * 26 com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V: root-Branch
   * 27 com.sleepycat.je.DatabaseEntry.setPartialOffset(I)V: root-Branch
   * 28 com.sleepycat.je.DatabaseEntry.setPartialLength(I)V: root-Branch
   * 29 Weak Mutation 0: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:15 - ReplaceConstant - <DatabaseEntry -> 
   * 30 Weak Mutation 1: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - ReplaceConstant -  dlen= -> 
   * 31 Weak Mutation 2: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 32 Weak Mutation 3: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - InsertUnaryOp Negation
   * 33 Weak Mutation 4: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - InsertUnaryOp +1
   * 34 Weak Mutation 5: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - InsertUnaryOp -1
   * 35 Weak Mutation 6: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - DeleteField: dlenI
   * 36 Weak Mutation 7: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:16 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 37 Weak Mutation 8: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - ReplaceConstant -  doff= -> 
   * 38 Weak Mutation 9: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 39 Weak Mutation 10: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - InsertUnaryOp Negation
   * 40 Weak Mutation 11: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - InsertUnaryOp +1
   * 41 Weak Mutation 12: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - InsertUnaryOp -1
   * 42 Weak Mutation 13: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - DeleteField: doffI
   * 43 Weak Mutation 14: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:17 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 44 Weak Mutation 15: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - ReplaceConstant -  doff= -> 
   * 45 Weak Mutation 17: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - InsertUnaryOp Negation
   * 46 Weak Mutation 16: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 47 Weak Mutation 19: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - InsertUnaryOp -1
   * 48 Weak Mutation 18: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - InsertUnaryOp +1
   * 49 Weak Mutation 21: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 50 Weak Mutation 20: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:18 - DeleteField: doffI
   * 51 Weak Mutation 23: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:19 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 52 Weak Mutation 22: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:19 - ReplaceConstant -  offset= -> 
   * 53 Weak Mutation 25: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:19 - InsertUnaryOp +1
   * 54 Weak Mutation 24: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:19 - InsertUnaryOp Negation
   * 55 Weak Mutation 26: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:19 - InsertUnaryOp -1
   * 56 Weak Mutation 29: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:20 - ReplaceConstant -  size= -> 
   * 57 Weak Mutation 28: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:19 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 58 Weak Mutation 31: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:20 - InsertUnaryOp Negation
   * 59 Weak Mutation 30: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:20 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 60 Weak Mutation 35: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:20 - DeleteStatement: append(I)Ljava/lang/StringBuffer;
   * 61 Weak Mutation 32: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:20 - InsertUnaryOp +1
   * 62 Weak Mutation 33: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:20 - InsertUnaryOp -1
   * 63 Weak Mutation 38: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:22 - DeleteStatement: toString()Ljava/lang/String;
   * 64 Weak Mutation 39: com.sleepycat.je.DatabaseEntry.<init>()V:9 - ReplaceConstant - 0 -> 1
   * 65 Weak Mutation 36: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:21 - ReplaceConstant - > -> 
   * 66 Weak Mutation 37: com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;:21 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 67 Weak Mutation 42: com.sleepycat.je.DatabaseEntry.<init>()V:12 - ReplaceConstant - 0 -> 1
   * 68 Weak Mutation 43: com.sleepycat.je.DatabaseEntry.<init>()V:13 - ReplaceConstant - 0 -> 1
   * 69 Weak Mutation 40: com.sleepycat.je.DatabaseEntry.<init>()V:10 - ReplaceConstant - 0 -> 1
   * 70 Weak Mutation 41: com.sleepycat.je.DatabaseEntry.<init>()V:11 - ReplaceConstant - 0 -> 1
   * 71 Weak Mutation 71: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - InsertUnaryOp Negation
   * 72 Weak Mutation 76: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - InsertUnaryOp IINC 1
   * 73 Weak Mutation 77: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - InsertUnaryOp IINC -1
   * 74 Weak Mutation 78: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - DeleteStatement: setPartialLength(I)V
   * 75 Weak Mutation 79: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - InsertUnaryOp Negation
   * 76 Weak Mutation 72: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - InsertUnaryOp IINC 1
   * 77 Weak Mutation 73: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - InsertUnaryOp IINC -1
   * 78 Weak Mutation 74: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:79 - DeleteStatement: setPartialOffset(I)V
   * 79 Weak Mutation 75: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:80 - InsertUnaryOp Negation
   * 80 Weak Mutation 87: com.sleepycat.je.DatabaseEntry.setPartialLength(I)V:95 - InsertUnaryOp Negation
   * 81 Weak Mutation 81: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - InsertUnaryOp IINC -1
   * 82 Weak Mutation 80: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - InsertUnaryOp IINC 1
   * 83 Weak Mutation 82: com.sleepycat.je.DatabaseEntry.setPartial(IIZ)V:81 - DeleteStatement: setPartial(Z)V
   * 84 Weak Mutation 95: com.sleepycat.je.DatabaseEntry.setPartialOffset(I)V:109 - InsertUnaryOp IINC 1
   * 85 Weak Mutation 94: com.sleepycat.je.DatabaseEntry.setPartialOffset(I)V:109 - InsertUnaryOp Negation
   * 86 Weak Mutation 89: com.sleepycat.je.DatabaseEntry.setPartialLength(I)V:95 - InsertUnaryOp IINC -1
   * 87 Weak Mutation 88: com.sleepycat.je.DatabaseEntry.setPartialLength(I)V:95 - InsertUnaryOp IINC 1
   * 88 Weak Mutation 100: com.sleepycat.je.DatabaseEntry.setPartial(Z)V:123 - InsertUnaryOp IINC 1
   * 89 Weak Mutation 101: com.sleepycat.je.DatabaseEntry.setPartial(Z)V:123 - InsertUnaryOp IINC -1
   * 90 Weak Mutation 99: com.sleepycat.je.DatabaseEntry.setPartial(Z)V:123 - InsertUnaryOp Negation
   * 91 Weak Mutation 96: com.sleepycat.je.DatabaseEntry.setPartialOffset(I)V:109 - InsertUnaryOp IINC -1
   * 92 com.sleepycat.je.DatabaseEntry.<init>()V: root-Branch
   * 93 com.sleepycat.je.DatabaseEntry.toString()Ljava/lang/String;: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      databaseEntry0.setPartial(909, 909, true);
      String string0 = databaseEntry0.toString();
      assertEquals(909, databaseEntry0.getPartialLength());
      assertEquals("<DatabaseEntry dlen=909 doff=909 doff=909 offset=0 size=0>", string0);
  }
}
