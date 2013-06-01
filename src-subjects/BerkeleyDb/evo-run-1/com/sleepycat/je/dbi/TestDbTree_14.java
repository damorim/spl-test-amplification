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
public class TestDbTree_14 {


  //Test case number: 14
  /*
   * 19 covered goals:
   * 1 Weak Mutation 284: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - ReplaceComparisonOperator >= -> >
   * 2 Weak Mutation 291: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:821 - ReplaceComparisonOperator <= -> ==
   * 3 Weak Mutation 295: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:825 - ReplaceConstant - 0 -> 1
   * 4 com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z: I8 Branch 68 IF_ICMPGE L820 - true
   * 5 com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z: I16 Branch 69 IFLE L821 - true
   * 6 Weak Mutation 279: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - InsertUnaryOp Negation
   * 7 Weak Mutation 278: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 282: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - DeleteField: RESERVED_DB_NAMES[Ljava/lang/String;
   * 9 Weak Mutation 281: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 280: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 287: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:821 - InsertUnaryOp Negation
   * 12 Weak Mutation 286: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:821 - DeleteField: RESERVED_DB_NAMES[Ljava/lang/String;
   * 13 Weak Mutation 285: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - ReplaceComparisonOperator >= -> -1
   * 14 Weak Mutation 288: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:821 - InsertUnaryOp IINC 1
   * 15 Weak Mutation 289: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:821 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 290: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:821 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 17 Weak Mutation 284: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:820 - ReplaceComparisonOperator >= -> >
   * 18 Weak Mutation 291: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:821 - ReplaceComparisonOperator <= -> ==
   * 19 Weak Mutation 295: com.sleepycat.je.dbi.DbTree.isReservedDbName(Ljava/lang/String;)Z:825 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test14()  throws Throwable  {
      DbTree dbTree0 = new DbTree();
      assertNotNull(dbTree0);
      
      boolean boolean0 = dbTree0.isReservedDbName("_jeIdMep");
      assertEquals(false, boolean0);
  }
}
