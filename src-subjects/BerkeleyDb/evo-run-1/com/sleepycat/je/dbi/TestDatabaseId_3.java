/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.dbi.DatabaseId;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseId_3 {


  //Test case number: 3
  /*
   * 3 covered goals:
   * 1 Weak Mutation 11: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:48 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z: I4 Branch 1 IF_ACMPNE L47 - false
   * 3 Weak Mutation 11: com.sleepycat.je.dbi.DatabaseId.equals(Ljava/lang/Object;)Z:48 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test3()  throws Throwable  {
      DatabaseId databaseId0 = new DatabaseId();
      boolean boolean0 = databaseId0.equals((Object) databaseId0);
      assertEquals(true, boolean0);
  }
}