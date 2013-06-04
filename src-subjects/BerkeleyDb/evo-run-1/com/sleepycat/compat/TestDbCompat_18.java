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
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.SecondaryConfig;
import java.io.FileNotFoundException;
import java.util.Comparator;

@RunWith(EvoSuiteRunner.class)
public class TestDbCompat_18 {


  //Test case number: 18
  /*
   * 29 covered goals:
   * 1 Weak Mutation 38: com.sleepycat.compat.DbCompat.openDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/DatabaseConfig;)Lcom/sleepycat/je/Database;:188 - DeleteStatement: makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   * 2 Weak Mutation 39: com.sleepycat.compat.DbCompat.openDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/DatabaseConfig;)Lcom/sleepycat/je/Database;:188 - DeleteStatement: openDatabase(Ljava/lang/String;Lcom/sleepycat/je/DatabaseConfig;)Lcom/sleepycat/je/Database;
   * 3 Weak Mutation 42: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:206 - ReplaceComparisonOperator != null -> = null
   * 4 Weak Mutation 43: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:210 - ReplaceComparisonOperator = null -> != null
   * 5 Weak Mutation 46: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 1
   * 6 Weak Mutation 47: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> -1
   * 7 Weak Mutation 44: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 8 Weak Mutation 45: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 0
   * 9 Weak Mutation 51: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 10 Weak Mutation 50: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: append(C)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 49: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 47
   * 12 Weak Mutation 48: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 45
   * 13 Weak Mutation 52: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: toString()Ljava/lang/String;
   * 14 com.sleepycat.compat.DbCompat.openDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/DatabaseConfig;)Lcom/sleepycat/je/Database;: root-Branch
   * 15 com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;: I3 Branch 7 IFNONNULL L206 - true
   * 16 com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;: I11 Branch 8 IFNULL L210 - false
   * 17 Weak Mutation 38: com.sleepycat.compat.DbCompat.openDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/DatabaseConfig;)Lcom/sleepycat/je/Database;:188 - DeleteStatement: makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   * 18 Weak Mutation 39: com.sleepycat.compat.DbCompat.openDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/DatabaseConfig;)Lcom/sleepycat/je/Database;:188 - DeleteStatement: openDatabase(Ljava/lang/String;Lcom/sleepycat/je/DatabaseConfig;)Lcom/sleepycat/je/Database;
   * 19 Weak Mutation 42: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:206 - ReplaceComparisonOperator != null -> = null
   * 20 Weak Mutation 43: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:210 - ReplaceComparisonOperator = null -> != null
   * 21 Weak Mutation 46: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 1
   * 22 Weak Mutation 47: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> -1
   * 23 Weak Mutation 44: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 24 Weak Mutation 45: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 0
   * 25 Weak Mutation 51: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 26 Weak Mutation 50: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: append(C)Ljava/lang/StringBuilder;
   * 27 Weak Mutation 49: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 47
   * 28 Weak Mutation 48: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - ReplaceConstant - 46 -> 45
   * 29 Weak Mutation 52: com.sleepycat.compat.DbCompat.makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;:211 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test18()  throws Throwable  {
      DatabaseConfig databaseConfig0 = DatabaseConfig.DEFAULT;
      // Undeclared exception!
      try {
        DbCompat.openDatabase((Environment) null, "Can't call Database.preload", "Can't call Database.preload", databaseConfig0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
