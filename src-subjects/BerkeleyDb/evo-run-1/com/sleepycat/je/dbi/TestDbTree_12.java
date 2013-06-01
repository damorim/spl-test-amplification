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
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Locker;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbTree_12 {


  //Test case number: 12
  /*
   * 13 covered goals:
   * 1 Weak Mutation 250: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:736 - ReplaceConstant - _jeNameMap -> 
   * 2 com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;: I15 Branch 50 IFEQ L735 - false
   * 3 Weak Mutation 248: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:735 - DeleteStatement: equals(Ljava/lang/Object;)Z
   * 4 Weak Mutation 249: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:735 - ReplaceComparisonOperator == -> !=
   * 5 Weak Mutation 247: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:735 - DeleteField: NAME_DB_IDLcom/sleepycat/je/dbi/DatabaseId;
   * 6 Weak Mutation 244: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:732 - DeleteStatement: equals(Ljava/lang/Object;)Z
   * 7 Weak Mutation 245: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:732 - ReplaceComparisonOperator == -> !=
   * 8 Weak Mutation 243: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:732 - DeleteField: ID_DB_IDLcom/sleepycat/je/dbi/DatabaseId;
   * 9 Weak Mutation 250: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:736 - ReplaceConstant - _jeNameMap -> 
   * 10 Weak Mutation 248: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:735 - DeleteStatement: equals(Ljava/lang/Object;)Z
   * 11 Weak Mutation 249: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:735 - ReplaceComparisonOperator == -> !=
   * 12 Weak Mutation 247: com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;:735 - DeleteField: NAME_DB_IDLcom/sleepycat/je/dbi/DatabaseId;
   * 13 com.sleepycat.je.dbi.DbTree.getDbName(Lcom/sleepycat/je/dbi/DatabaseId;)Ljava/lang/String;: I5 Branch 49 IFEQ L732 - true
   */
  @Test
  public void test12()  throws Throwable  {
      DbTree dbTree0 = new DbTree();
      assertNotNull(dbTree0);
      
      DatabaseId databaseId0 = DbTree.NAME_DB_ID;
      String string0 = dbTree0.getDbName(databaseId0);
      assertNotNull(string0);
      assertEquals("_jeNameMap", string0);
  }
}
