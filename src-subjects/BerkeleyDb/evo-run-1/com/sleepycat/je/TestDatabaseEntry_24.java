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
public class TestDatabaseEntry_24 {


  //Test case number: 24
  /*
   * 7 covered goals:
   * 1 com.sleepycat.je.DatabaseEntry.equals(Ljava/lang/Object;)Z: I62 Branch 12 IFNONNULL L184 - false
   * 2 Weak Mutation 39: com.sleepycat.je.DatabaseEntry.<init>()V:9 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 42: com.sleepycat.je.DatabaseEntry.<init>()V:12 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 43: com.sleepycat.je.DatabaseEntry.<init>()V:13 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 40: com.sleepycat.je.DatabaseEntry.<init>()V:10 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 41: com.sleepycat.je.DatabaseEntry.<init>()V:11 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 163: com.sleepycat.je.DatabaseEntry.equals(Ljava/lang/Object;)Z:185 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test24()  throws Throwable  {
      byte[] byteArray0 = new byte[21];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0);
      DatabaseEntry databaseEntry1 = new DatabaseEntry();
      boolean boolean0 = databaseEntry0.equals((Object) databaseEntry1);
      assertEquals(false, boolean0);
      assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=21>", databaseEntry0.toString());
      assertEquals(false, databaseEntry0.getPartial());
      assertEquals(false, databaseEntry1.getPartial());
      assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=0>", databaseEntry1.toString());
  }
}
