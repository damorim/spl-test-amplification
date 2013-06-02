/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseImpl_4 {


  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 66: com.sleepycat.je.dbi.DatabaseImpl.getSortedDuplicates()Z:252 - InsertUnaryOp Negation
   * 2 com.sleepycat.je.dbi.DatabaseImpl.getSortedDuplicates()Z: root-Branch
   * 3 Weak Mutation 66: com.sleepycat.je.dbi.DatabaseImpl.getSortedDuplicates()Z:252 - InsertUnaryOp Negation
   */
  @Test
  public void test4()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      databaseImpl0.getSortedDuplicates();
      assertEquals(115714L, databaseImpl0.getEofNodeId());
  }
}