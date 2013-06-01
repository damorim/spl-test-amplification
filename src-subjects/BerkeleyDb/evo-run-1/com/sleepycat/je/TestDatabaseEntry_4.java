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
public class TestDatabaseEntry_4 {


  //Test case number: 4
  /*
   * 7 covered goals:
   * 1 Weak Mutation 62: com.sleepycat.je.DatabaseEntry.setData([B)V:62 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 63: com.sleepycat.je.DatabaseEntry.setData([B)V:63 - ReplaceComparisonOperator != null -> = null
   * 3 Weak Mutation 64: com.sleepycat.je.DatabaseEntry.setData([B)V:63 - ReplaceConstant - 0 -> 1
   * 4 com.sleepycat.je.DatabaseEntry.setData([B)V: I14 Branch 2 IFNONNULL L63 - false
   * 5 Weak Mutation 63: com.sleepycat.je.DatabaseEntry.setData([B)V:63 - ReplaceComparisonOperator != null -> = null
   * 6 Weak Mutation 62: com.sleepycat.je.DatabaseEntry.setData([B)V:62 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 64: com.sleepycat.je.DatabaseEntry.setData([B)V:63 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test4()  throws Throwable  {
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      databaseEntry0.setData((byte[]) null);
      assertEquals(false, databaseEntry0.getPartial());
      assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=0>", databaseEntry0.toString());
      assertEquals(0, databaseEntry0.getOffset());
  }
}
