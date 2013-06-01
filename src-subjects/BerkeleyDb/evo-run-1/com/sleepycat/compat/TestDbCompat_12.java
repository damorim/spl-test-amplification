/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.compat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.compat.DbCompat;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.SecondaryConfig;

@RunWith(EvoSuiteRunner.class)
public class TestDbCompat_12 {


  //Test case number: 12
  /*
   * 3 covered goals:
   * 1 Weak Mutation 15: com.sleepycat.compat.DbCompat.getWriteCursor(Lcom/sleepycat/je/CursorConfig;)Z:80 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.compat.DbCompat.getWriteCursor(Lcom/sleepycat/je/CursorConfig;)Z: root-Branch
   * 3 Weak Mutation 15: com.sleepycat.compat.DbCompat.getWriteCursor(Lcom/sleepycat/je/CursorConfig;)Z:80 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test12()  throws Throwable  {
      CursorConfig cursorConfig0 = CursorConfig.DEFAULT;
      boolean boolean0 = DbCompat.getWriteCursor(cursorConfig0);
      assertEquals(false, boolean0);
  }
}
