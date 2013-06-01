/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log.entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.entry.INLogEntry;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import java.nio.ByteBuffer;
import java.util.Map;

@RunWith(EvoSuiteRunner.class)
public class TestINLogEntry_10 {


  //Test case number: 10
  /*
   * 35 covered goals:
   * 1 Weak Mutation 76: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteField: inLcom/sleepycat/je/tree/IN;
   * 2 Weak Mutation 77: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteStatement: getLogSize()I
   * 3 Weak Mutation 78: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 4 Weak Mutation 79: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteStatement: getLogSize()I
   * 5 Weak Mutation 85: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 1
   * 6 Weak Mutation 84: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 0
   * 7 Weak Mutation 87: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 7
   * 8 Weak Mutation 86: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> -1
   * 9 Weak Mutation 81: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> %
   * 10 Weak Mutation 80: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> -
   * 11 Weak Mutation 83: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> *
   * 12 Weak Mutation 82: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> /
   * 13 Weak Mutation 92: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> *
   * 14 Weak Mutation 89: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> -
   * 15 Weak Mutation 88: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 9
   * 16 Weak Mutation 91: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> /
   * 17 Weak Mutation 90: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> %
   * 18 com.sleepycat.je.log.entry.INLogEntry.getLogSize()I: root-Branch
   * 19 Weak Mutation 76: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteField: inLcom/sleepycat/je/tree/IN;
   * 20 Weak Mutation 77: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteStatement: getLogSize()I
   * 21 Weak Mutation 78: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteField: dbIdLcom/sleepycat/je/dbi/DatabaseId;
   * 22 Weak Mutation 79: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - DeleteStatement: getLogSize()I
   * 23 Weak Mutation 85: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 1
   * 24 Weak Mutation 84: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 0
   * 25 Weak Mutation 87: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 7
   * 26 Weak Mutation 86: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> -1
   * 27 Weak Mutation 81: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> %
   * 28 Weak Mutation 80: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> -
   * 29 Weak Mutation 83: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> *
   * 30 Weak Mutation 82: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> /
   * 31 Weak Mutation 92: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> *
   * 32 Weak Mutation 89: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> -
   * 33 Weak Mutation 88: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceConstant - 8 -> 9
   * 34 Weak Mutation 91: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> /
   * 35 Weak Mutation 90: com.sleepycat.je.log.entry.INLogEntry.getLogSize()I:150 - ReplaceArithmeticOperator + -> %
   */
  @Test
  public void test10()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      byte[] byteArray0 = new byte[4];
      DIN dIN0 = new DIN();
      ChildReference childReference0 = dIN0.getDupCountLNRef();
      DIN dIN1 = new DIN(databaseImpl0, byteArray0, (int) (byte)0, byteArray0, childReference0, (int) (byte)0);
      INLogEntry iNLogEntry0 = new INLogEntry((IN) dIN1);
      int int0 = iNLogEntry0.getLogSize();
      assertEquals(67111810L, dIN0.getLastId());
      assertEquals(68, int0);
  }
}
