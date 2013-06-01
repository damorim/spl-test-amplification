/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.utilint.LevelOrderedINMap;

@RunWith(EvoSuiteRunner.class)
public class TestLevelOrderedINMap_0 {


  //Test case number: 0
  /*
   * 13 covered goals:
   * 1 com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V: I18 Branch 1 IFNONNULL L14 - true
   * 2 Weak Mutation 0: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:12 - DeleteStatement: getLevel()I
   * 3 Weak Mutation 1: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:13 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 4 Weak Mutation 2: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:14 - ReplaceComparisonOperator != null -> = null
   * 5 Weak Mutation 3: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:16 - DeleteStatement: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   * 6 Weak Mutation 4: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:18 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 7 Weak Mutation 0: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:12 - DeleteStatement: getLevel()I
   * 8 Weak Mutation 1: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:13 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 9 Weak Mutation 2: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:14 - ReplaceComparisonOperator != null -> = null
   * 10 Weak Mutation 3: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:16 - DeleteStatement: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   * 11 Weak Mutation 4: com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V:18 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 12 com.sleepycat.je.utilint.LevelOrderedINMap.<init>()V: root-Branch
   * 13 com.sleepycat.je.utilint.LevelOrderedINMap.putIN(Lcom/sleepycat/je/tree/IN;)V: I18 Branch 1 IFNONNULL L14 - false
   */
  @Test
  public void test0()  throws Throwable  {
      LevelOrderedINMap levelOrderedINMap0 = new LevelOrderedINMap();
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      byte[] byteArray0 = new byte[2];
      BIN bIN0 = new BIN(databaseImpl0, byteArray0, 1, 310);
      levelOrderedINMap0.putIN((IN) bIN0);
      levelOrderedINMap0.putIN((IN) bIN0);
      assertEquals(1, levelOrderedINMap0.size());
      assertEquals(222L, bIN0.getNodeId());
  }
}
