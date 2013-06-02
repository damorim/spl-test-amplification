/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseConfig;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseConfig_0 {


  //Test case number: 0
  /*
   * 15 covered goals:
   * 1 Weak Mutation 7: com.sleepycat.je.DatabaseConfig.setAllowCreate(Z)V:35 - InsertUnaryOp Negation
   * 2 Weak Mutation 8: com.sleepycat.je.DatabaseConfig.setAllowCreate(Z)V:35 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 9: com.sleepycat.je.DatabaseConfig.setAllowCreate(Z)V:35 - InsertUnaryOp IINC -1
   * 4 com.sleepycat.je.DatabaseConfig.setAllowCreate(Z)V: root-Branch
   * 5 Weak Mutation 0: com.sleepycat.je.DatabaseConfig.<init>()V:10 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 1: com.sleepycat.je.DatabaseConfig.<init>()V:11 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 2: com.sleepycat.je.DatabaseConfig.<init>()V:15 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 3: com.sleepycat.je.DatabaseConfig.<init>()V:16 - ReplaceConstant - 0 -> 1
   * 9 Weak Mutation 4: com.sleepycat.je.DatabaseConfig.<init>()V:21 - ReplaceConstant - 0 -> 1
   * 10 Weak Mutation 5: com.sleepycat.je.DatabaseConfig.<init>()V:22 - ReplaceConstant - 0 -> 1
   * 11 Weak Mutation 6: com.sleepycat.je.DatabaseConfig.<init>()V:23 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 7: com.sleepycat.je.DatabaseConfig.setAllowCreate(Z)V:35 - InsertUnaryOp Negation
   * 13 Weak Mutation 8: com.sleepycat.je.DatabaseConfig.setAllowCreate(Z)V:35 - InsertUnaryOp IINC 1
   * 14 Weak Mutation 9: com.sleepycat.je.DatabaseConfig.setAllowCreate(Z)V:35 - InsertUnaryOp IINC -1
   * 15 com.sleepycat.je.DatabaseConfig.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      DatabaseConfig databaseConfig0 = new DatabaseConfig();
      assertEquals(false, databaseConfig0.getAllowCreate());
      
      databaseConfig0.setAllowCreate(true);
      assertEquals(true, databaseConfig0.getAllowCreate());
  }
}