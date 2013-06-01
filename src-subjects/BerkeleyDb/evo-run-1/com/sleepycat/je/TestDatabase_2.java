/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.SequenceConfig;
import java.io.File;

@RunWith(EvoSuiteRunner.class)
public class TestDatabase_2 {


  //Test case number: 2
  /*
   * 31 covered goals:
   * 1 Weak Mutation 79: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:162 - DeleteStatement: checkEnv()V
   * 2 Weak Mutation 81: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:163 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 80: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:163 - ReplaceConstant - key -> 
   * 4 Weak Mutation 82: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:163 - DeleteStatement: checkForNullDbt(Lcom/sleepycat/je/DatabaseEntry;Ljava/lang/String;Z)V
   * 5 Weak Mutation 85: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:164 - DeleteStatement: checkRequiredDbState(Lcom/sleepycat/je/Database$DbState;Ljava/lang/String;)V
   * 6 Weak Mutation 84: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:164 - ReplaceConstant - Can't call Database.openSequence: -> 
   * 7 Weak Mutation 86: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:165 - ReplaceConstant - openSequence -> 
   * 8 Weak Mutation 298: com.sleepycat.je.Database.checkRequiredDbState(Lcom/sleepycat/je/Database$DbState;Ljava/lang/String;)V:768 - ReplaceComparisonOperator == -> !=
   * 9 Weak Mutation 326: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:804 - InsertUnaryOp Negation
   * 10 Weak Mutation 328: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:804 - ReplaceComparisonOperator != -> ==
   * 11 Weak Mutation 332: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - DeleteStatement: toString()Ljava/lang/String;
   * 12 Weak Mutation 330: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 13 Weak Mutation 331: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 14 Weak Mutation 329: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - ReplaceConstant - Database is Read Only:  -> 
   * 15 com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;: root-Branch
   * 16 com.sleepycat.je.Database.checkRequiredDbState(Lcom/sleepycat/je/Database$DbState;Ljava/lang/String;)V: I5 Branch 44 IF_ACMPEQ L768 - true
   * 17 com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V: I4 Branch 48 IFNE L804 - false
   * 18 Weak Mutation 79: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:162 - DeleteStatement: checkEnv()V
   * 19 Weak Mutation 85: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:164 - DeleteStatement: checkRequiredDbState(Lcom/sleepycat/je/Database$DbState;Ljava/lang/String;)V
   * 20 Weak Mutation 84: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:164 - ReplaceConstant - Can't call Database.openSequence: -> 
   * 21 Weak Mutation 86: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:165 - ReplaceConstant - openSequence -> 
   * 22 Weak Mutation 81: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:163 - ReplaceConstant - 1 -> 0
   * 23 Weak Mutation 80: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:163 - ReplaceConstant - key -> 
   * 24 Weak Mutation 82: com.sleepycat.je.Database.openSequence(Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)Lcom/sleepycat/je/Sequence;:163 - DeleteStatement: checkForNullDbt(Lcom/sleepycat/je/DatabaseEntry;Ljava/lang/String;Z)V
   * 25 Weak Mutation 298: com.sleepycat.je.Database.checkRequiredDbState(Lcom/sleepycat/je/Database$DbState;Ljava/lang/String;)V:768 - ReplaceComparisonOperator == -> !=
   * 26 Weak Mutation 326: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:804 - InsertUnaryOp Negation
   * 27 Weak Mutation 332: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - DeleteStatement: toString()Ljava/lang/String;
   * 28 Weak Mutation 330: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 29 Weak Mutation 331: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 30 Weak Mutation 328: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:804 - ReplaceComparisonOperator != -> ==
   * 31 Weak Mutation 329: com.sleepycat.je.Database.checkWritable(Ljava/lang/String;)V:805 - ReplaceConstant - Database is Read Only:  -> 
   */
  @Test
  public void test2()  throws Throwable  {
      File file0 = new File("O'QvQa`Q4xl:q");
      Environment environment0 = new Environment(file0);
      Database database0 = new Database(environment0);
      byte[] byteArray0 = new byte[2];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0);
      SequenceConfig sequenceConfig0 = new SequenceConfig();
      try {
        database0.openSequence(databaseEntry0, sequenceConfig0);
        fail("Expecting exception: DatabaseException");
      } catch(DatabaseException e) {
        /*
         * Database is Read Only: openSequence
         */
      }
  }
}
