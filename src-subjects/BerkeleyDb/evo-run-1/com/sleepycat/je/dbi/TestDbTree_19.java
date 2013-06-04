/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Locker;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbTree_19 {


  //Test case number: 19
  /*
   * 27 covered goals:
   * 1 Weak Mutation 336: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> *
   * 2 Weak Mutation 326: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteStatement: getLogSize()I
   * 3 Weak Mutation 327: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> -
   * 4 Weak Mutation 324: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteStatement: getIntLogSize()I
   * 5 Weak Mutation 325: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteField: idDatabaseLcom/sleepycat/je/dbi/DatabaseImpl;
   * 6 Weak Mutation 334: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> %
   * 7 Weak Mutation 335: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> /
   * 8 Weak Mutation 332: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteStatement: getLogSize()I
   * 9 Weak Mutation 333: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> -
   * 10 Weak Mutation 330: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> *
   * 11 Weak Mutation 331: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteField: nameDatabaseLcom/sleepycat/je/dbi/DatabaseImpl;
   * 12 Weak Mutation 328: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> %
   * 13 Weak Mutation 329: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> /
   * 14 com.sleepycat.je.dbi.DbTree.getLogSize()I: root-Branch
   * 15 Weak Mutation 336: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> *
   * 16 Weak Mutation 326: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteStatement: getLogSize()I
   * 17 Weak Mutation 327: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> -
   * 18 Weak Mutation 324: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteStatement: getIntLogSize()I
   * 19 Weak Mutation 325: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteField: idDatabaseLcom/sleepycat/je/dbi/DatabaseImpl;
   * 20 Weak Mutation 334: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> %
   * 21 Weak Mutation 335: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> /
   * 22 Weak Mutation 332: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteStatement: getLogSize()I
   * 23 Weak Mutation 333: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> -
   * 24 Weak Mutation 330: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> *
   * 25 Weak Mutation 331: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - DeleteField: nameDatabaseLcom/sleepycat/je/dbi/DatabaseImpl;
   * 26 Weak Mutation 328: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> %
   * 27 Weak Mutation 329: com.sleepycat.je.dbi.DbTree.getLogSize()I:878 - ReplaceArithmeticOperator + -> /
   */
  @Test
  public void test19()  throws Throwable  {
      DbTree dbTree0 = new DbTree();
      assertNotNull(dbTree0);
      
      int int0 = dbTree0.getLogSize();
      assertEquals(48, int0);
  }
}
