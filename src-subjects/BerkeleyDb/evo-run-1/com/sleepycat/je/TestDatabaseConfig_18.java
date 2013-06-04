/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseConfig_18 {


  //Test case number: 18
  /*
   * 8 covered goals:
   * 1 com.sleepycat.je.DatabaseConfig.cloneConfig()Lcom/sleepycat/je/DatabaseConfig;: root-Branch
   * 2 Weak Mutation 0: com.sleepycat.je.DatabaseConfig.<init>()V:10 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 1: com.sleepycat.je.DatabaseConfig.<init>()V:11 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 2: com.sleepycat.je.DatabaseConfig.<init>()V:15 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 3: com.sleepycat.je.DatabaseConfig.<init>()V:16 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 4: com.sleepycat.je.DatabaseConfig.<init>()V:21 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 5: com.sleepycat.je.DatabaseConfig.<init>()V:22 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 6: com.sleepycat.je.DatabaseConfig.<init>()V:23 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test18()  throws Throwable  {
      DatabaseConfig databaseConfig0 = new DatabaseConfig();
      DatabaseConfig databaseConfig1 = databaseConfig0.cloneConfig();
      assertEquals(false, databaseConfig0.getSortedDuplicates());
      assertEquals(false, databaseConfig0.getExclusiveCreate());
      assertEquals(false, databaseConfig0.getReadOnly());
      assertEquals(false, databaseConfig0.getAllowCreate());
      assertEquals(false, databaseConfig0.getOverrideBtreeComparator());
      assertEquals(false, databaseConfig0.getOverrideDuplicateComparator());
      assertEquals(false, databaseConfig0.getUseExistingConfig());
      assertEquals(false, databaseConfig1.getExclusiveCreate());
  }
}
