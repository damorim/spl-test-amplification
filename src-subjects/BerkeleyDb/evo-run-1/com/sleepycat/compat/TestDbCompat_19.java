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
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.SecondaryConfig;
import java.io.FileNotFoundException;
import java.util.Comparator;

@RunWith(EvoSuiteRunner.class)
public class TestDbCompat_19 {


  //Test case number: 19
  /*
   * 15 covered goals:
   * 1 Weak Mutation 40: com.sleepycat.compat.DbCompat.openSecondaryDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/SecondaryConfig;)Lcom/sleepycat/je/SecondaryDatabase;:199 - DeleteStatement: makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   * 2 Weak Mutation 41: com.sleepycat.compat.DbCompat.openSecondaryDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/SecondaryConfig;)Lcom/sleepycat/je/SecondaryDatabase;:199 - DeleteStatement: openSecondaryDatabase(Ljava/lang/String;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/SecondaryConfig;)Lcom/sleepycat/je/SecondaryDatabase;
   * 3 com.sleepycat.compat.DbCompat.openSecondaryDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/SecondaryConfig;)Lcom/sleepycat/je/SecondaryDatabase;: root-Branch
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
   * 14 Weak Mutation 40: com.sleepycat.compat.DbCompat.openSecondaryDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/SecondaryConfig;)Lcom/sleepycat/je/SecondaryDatabase;:199 - DeleteStatement: makeDbName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
   * 15 Weak Mutation 41: com.sleepycat.compat.DbCompat.openSecondaryDatabase(Lcom/sleepycat/je/Environment;Ljava/lang/String;Ljava/lang/String;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/SecondaryConfig;)Lcom/sleepycat/je/SecondaryDatabase;:199 - DeleteStatement: openSecondaryDatabase(Ljava/lang/String;Lcom/sleepycat/je/Database;Lcom/sleepycat/je/SecondaryConfig;)Lcom/sleepycat/je/SecondaryDatabase;
   */
  @Test
  public void test19()  throws Throwable  {
      SecondaryConfig secondaryConfig0 = new SecondaryConfig();
      // Undeclared exception!
      try {
        DbCompat.openSecondaryDatabase((Environment) null, "", "", (Database) null, secondaryConfig0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}