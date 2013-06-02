/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.ForeignKeyDeleteAction;
import com.sleepycat.je.SecondaryConfig;

@RunWith(EvoSuiteRunner.class)
public class TestSecondaryConfig_5 {


  //Test case number: 5
  /*
   * 20 covered goals:
   * 1 Weak Mutation 18: com.sleepycat.je.SecondaryConfig.getImmutableSecondaryKey()Z:133 - DeleteField: immutableSecondaryKeyZ
   * 2 Weak Mutation 11: com.sleepycat.je.SecondaryConfig.getForeignKeyDeleteAction()Lcom/sleepycat/je/ForeignKeyDeleteAction;:91 - DeleteField: foreignKeyDeleteActionLcom/sleepycat/je/ForeignKeyDeleteAction;
   * 3 Weak Mutation 17: com.sleepycat.je.SecondaryConfig.getImmutableSecondaryKey()Z:133 - InsertUnaryOp Negation
   * 4 Weak Mutation 19: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:137 - ReplaceComparisonOperator = null -> != null
   * 5 Weak Mutation 20: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:137 - ReplaceComparisonOperator != -> ==
   * 6 Weak Mutation 22: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:141 - DeleteStatement: getKeyCreator()Lcom/sleepycat/je/SecondaryKeyCreator;
   * 7 Weak Mutation 24: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:142 - DeleteStatement: getMultiKeyCreator()Lcom/sleepycat/je/SecondaryMultiKeyCreator;
   * 8 Weak Mutation 26: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:143 - DeleteStatement: getForeignKeyDatabase()Lcom/sleepycat/je/Database;
   * 9 Weak Mutation 29: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:143 - ReplaceConstant - 1 -> 0
   * 10 Weak Mutation 28: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:143 - ReplaceComparisonOperator != -> ==
   * 11 Weak Mutation 31: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:144 - DeleteStatement: getForeignKeyDeleteAction()Lcom/sleepycat/je/ForeignKeyDeleteAction;
   * 12 Weak Mutation 34: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:144 - ReplaceConstant - 1 -> 0
   * 13 Weak Mutation 32: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:144 - DeleteField: foreignKeyDeleteActionLcom/sleepycat/je/ForeignKeyDeleteAction;
   * 14 Weak Mutation 33: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:144 - ReplaceComparisonOperator != -> ==
   * 15 Weak Mutation 38: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:146 - DeleteStatement: getForeignMultiKeyNullifier()Lcom/sleepycat/je/ForeignMultiKeyNullifier;
   * 16 Weak Mutation 36: com.sleepycat.je.SecondaryConfig.validate(Lcom/sleepycat/je/DatabaseConfig;)V:145 - DeleteStatement: getForeignKeyNullifier()Lcom/sleepycat/je/ForeignKeyNullifier;
   * 17 Weak Mutation 42: com.sleepycat.je.SecondaryConfig.equalOrBothNull(Ljava/lang/Object;Ljava/lang/Object;)Z:155 - ReplaceComparisonOperator != null -> = null
   * 18 Weak Mutation 43: com.sleepycat.je.SecondaryConfig.equalOrBothNull(Ljava/lang/Object;Ljava/lang/Object;)Z:155 - ReplaceConstant - 1 -> 0
   * 19 Weak Mutation 40: com.sleepycat.je.SecondaryConfig.equalOrBothNull(Ljava/lang/Object;Ljava/lang/Object;)Z:155 - ReplaceComparisonOperator = null -> != null
   * 20 Weak Mutation 18: com.sleepycat.je.SecondaryConfig.getImmutableSecondaryKey()Z:133 - DeleteField: immutableSecondaryKeyZ
   */
  @Test
  public void test5()  throws Throwable  {
      SecondaryConfig secondaryConfig0 = SecondaryConfig.DEFAULT;
      secondaryConfig0.validate((DatabaseConfig) secondaryConfig0);
      assertEquals(true, secondaryConfig0.getImmutableSecondaryKey());
  }
}