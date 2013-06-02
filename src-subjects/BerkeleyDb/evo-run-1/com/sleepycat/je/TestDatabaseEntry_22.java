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
public class TestDatabaseEntry_22 {


  //Test case number: 22
  /*
   * 41 covered goals:
   * 1 Weak Mutation 216: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> -
   * 2 Weak Mutation 219: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> *
   * 3 Weak Mutation 187: com.sleepycat.je.DatabaseEntry.hashCode()I:201 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 190: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 191: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - InsertUnaryOp Negation
   * 6 Weak Mutation 188: com.sleepycat.je.DatabaseEntry.hashCode()I:202 - DeleteField: data[B
   * 7 Weak Mutation 189: com.sleepycat.je.DatabaseEntry.hashCode()I:202 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 205: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp Negation
   * 9 Weak Mutation 204: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - DeleteField: data[B
   * 10 Weak Mutation 207: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp -1
   * 11 Weak Mutation 206: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp +1
   * 12 Weak Mutation 201: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp Negation
   * 13 Weak Mutation 200: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - ReplaceComparisonOperator >= -> -1
   * 14 Weak Mutation 203: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp IINC -1
   * 15 Weak Mutation 202: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 197: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - DeleteField: sizeI
   * 17 Weak Mutation 196: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - InsertUnaryOp -1
   * 18 Weak Mutation 199: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - ReplaceComparisonOperator >= -> >
   * 19 Weak Mutation 193: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - InsertUnaryOp IINC -1
   * 20 Weak Mutation 192: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - InsertUnaryOp IINC 1
   * 21 Weak Mutation 195: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - InsertUnaryOp +1
   * 22 Weak Mutation 194: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - InsertUnaryOp Negation
   * 23 Weak Mutation 220: com.sleepycat.je.DatabaseEntry.hashCode()I:207 - InsertUnaryOp Negation
   * 24 Weak Mutation 221: com.sleepycat.je.DatabaseEntry.hashCode()I:207 - InsertUnaryOp IINC 1
   * 25 Weak Mutation 222: com.sleepycat.je.DatabaseEntry.hashCode()I:207 - InsertUnaryOp IINC -1
   * 26 Weak Mutation 217: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> %
   * 27 Weak Mutation 218: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> /
   * 28 Weak Mutation 212: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> -
   * 29 Weak Mutation 213: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> %
   * 30 Weak Mutation 214: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> /
   * 31 Weak Mutation 215: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> *
   * 32 Weak Mutation 209: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp Negation
   * 33 Weak Mutation 210: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp IINC 1
   * 34 Weak Mutation 211: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - InsertUnaryOp IINC -1
   * 35 Weak Mutation 199: com.sleepycat.je.DatabaseEntry.hashCode()I:203 - ReplaceComparisonOperator >= -> >
   * 36 Weak Mutation 216: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> -
   * 37 Weak Mutation 217: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> %
   * 38 Weak Mutation 218: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> /
   * 39 Weak Mutation 219: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> *
   * 40 Weak Mutation 212: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> -
   * 41 Weak Mutation 215: com.sleepycat.je.DatabaseEntry.hashCode()I:204 - ReplaceArithmeticOperator + -> *
   */
  @Test
  public void test22()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      byteArray0[0] = (byte)4;
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0);
      int int0 = databaseEntry0.hashCode();
      assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=4>", databaseEntry0.toString());
      assertEquals(false, databaseEntry0.getPartial());
      assertEquals(4, int0);
  }
}