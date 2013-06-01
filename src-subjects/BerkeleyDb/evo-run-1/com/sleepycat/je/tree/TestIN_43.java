/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import java.io.StringWriter;

@RunWith(EvoSuiteRunner.class)
public class TestIN_43 {


  //Test case number: 43
  /*
   * 19 covered goals:
   * 1 Weak Mutation 1096: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> 3
   * 2 Weak Mutation 1099: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceComparisonOperator >= -> -1
   * 3 Weak Mutation 1093: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> 0
   * 4 Weak Mutation 1094: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> 1
   * 5 Weak Mutation 1095: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> -1
   * 6 Weak Mutation 1089: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - InsertUnaryOp Negation
   * 7 Weak Mutation 1090: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - InsertUnaryOp +1
   * 8 Weak Mutation 1091: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - InsertUnaryOp -1
   * 9 Weak Mutation 1100: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1045 - ReplaceConstant - 0 -> 1
   * 10 com.sleepycat.je.tree.IN.isKeyInBounds([B)Z: I5 Branch 42 IF_ICMPGE L1044 - false
   * 11 Weak Mutation 1100: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1045 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 1096: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> 3
   * 13 Weak Mutation 1099: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceComparisonOperator >= -> -1
   * 14 Weak Mutation 1093: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> 0
   * 15 Weak Mutation 1094: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> 1
   * 16 Weak Mutation 1095: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - ReplaceConstant - 2 -> -1
   * 17 Weak Mutation 1089: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - InsertUnaryOp Negation
   * 18 Weak Mutation 1090: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - InsertUnaryOp +1
   * 19 Weak Mutation 1091: com.sleepycat.je.tree.IN.isKeyInBounds([B)Z:1044 - InsertUnaryOp -1
   */
  @Test
  public void test43()  throws Throwable  {
      DIN dIN0 = new DIN();
      assertNotNull(dIN0);
      
      byte[] byteArray0 = new byte[6];
      boolean boolean0 = dIN0.isKeyInBounds(byteArray0);
      assertEquals(112689L, dIN0.getLastId());
      assertEquals(false, boolean0);
  }
}
