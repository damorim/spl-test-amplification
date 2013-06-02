/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.SequenceConfig;
import java.io.File;

@RunWith(EvoSuiteRunner.class)
public class TestDatabase_6 {


  //Test case number: 6
  /*
   * 23 covered goals:
   * 1 Weak Mutation 179: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:387 - DeleteStatement: checkEnv()V
   * 2 Weak Mutation 182: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:388 - DeleteStatement: checkForNullDbt(Lcom/sleepycat/je/DatabaseEntry;Ljava/lang/String;Z)V
   * 3 Weak Mutation 180: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:388 - ReplaceConstant - key -> 
   * 4 Weak Mutation 181: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:388 - ReplaceConstant - 1 -> 0
   * 5 Weak Mutation 184: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:389 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 185: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:389 - DeleteStatement: checkForNullDbt(Lcom/sleepycat/je/DatabaseEntry;Ljava/lang/String;Z)V
   * 7 Weak Mutation 183: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:389 - ReplaceConstant - data -> 
   * 8 Weak Mutation 186: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:390 - DeleteStatement: checkForPartialKey(Lcom/sleepycat/je/DatabaseEntry;)V
   * 9 Weak Mutation 188: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:391 - ReplaceConstant - Can't call Database.put -> 
   * 10 Weak Mutation 189: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:391 - DeleteStatement: checkRequiredDbState(Lcom/sleepycat/je/Database$DbState;Ljava/lang/String;)V
   * 11 Weak Mutation 190: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:392 - ReplaceConstant - put -> 
   * 12 com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;: root-Branch
   * 13 Weak Mutation 186: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:390 - DeleteStatement: checkForPartialKey(Lcom/sleepycat/je/DatabaseEntry;)V
   * 14 Weak Mutation 184: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:389 - ReplaceConstant - 1 -> 0
   * 15 Weak Mutation 185: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:389 - DeleteStatement: checkForNullDbt(Lcom/sleepycat/je/DatabaseEntry;Ljava/lang/String;Z)V
   * 16 Weak Mutation 190: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:392 - ReplaceConstant - put -> 
   * 17 Weak Mutation 188: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:391 - ReplaceConstant - Can't call Database.put -> 
   * 18 Weak Mutation 189: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:391 - DeleteStatement: checkRequiredDbState(Lcom/sleepycat/je/Database$DbState;Ljava/lang/String;)V
   * 19 Weak Mutation 179: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:387 - DeleteStatement: checkEnv()V
   * 20 Weak Mutation 182: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:388 - DeleteStatement: checkForNullDbt(Lcom/sleepycat/je/DatabaseEntry;Ljava/lang/String;Z)V
   * 21 Weak Mutation 183: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:389 - ReplaceConstant - data -> 
   * 22 Weak Mutation 180: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:388 - ReplaceConstant - key -> 
   * 23 Weak Mutation 181: com.sleepycat.je.Database.put(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/DatabaseEntry;)Lcom/sleepycat/je/OperationStatus;:388 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test6()  throws Throwable  {
      File file0 = new File((File) null, "");
      Environment environment0 = new Environment(file0);
      Database database0 = new Database(environment0);
      byte[] byteArray0 = new byte[14];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0, (int) (byte) (-100), (int) (byte)0);
      try {
        database0.put(databaseEntry0, databaseEntry0);
        fail("Expecting exception: DatabaseException");
      } catch(DatabaseException e) {
        /*
         * Database is Read Only: put
         */
      }
  }
}