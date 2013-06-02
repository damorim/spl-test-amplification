/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Locker;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestLN_22 {


  //Test case number: 22
  /*
   * 15 covered goals:
   * 1 com.sleepycat.je.tree.LN.addToDirtyMap(Ljava/util/Map;)V: root-Branch
   * 2 Weak Mutation 1: com.sleepycat.je.tree.LN.<init>([B)V:51 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 17: com.sleepycat.je.tree.LN.init([BIIII)V:71 - InsertUnaryOp Negation
   * 4 Weak Mutation 19: com.sleepycat.je.tree.LN.init([BIIII)V:71 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 18: com.sleepycat.je.tree.LN.init([BIIII)V:71 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 23: com.sleepycat.je.tree.LN.init([BIIII)V:72 - DeleteField: ZERO_LENGTH_BYTE_ARRAY[B
   * 7 Weak Mutation 22: com.sleepycat.je.tree.LN.init([BIIII)V:71 - ReplaceComparisonOperator != -> -1
   * 8 Weak Mutation 38: com.sleepycat.je.tree.LN.init([BII)V:80 - InsertUnaryOp Negation
   * 9 Weak Mutation 39: com.sleepycat.je.tree.LN.init([BII)V:80 - InsertUnaryOp IINC 1
   * 10 Weak Mutation 42: com.sleepycat.je.tree.LN.init([BII)V:80 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 43: com.sleepycat.je.tree.LN.init([BII)V:80 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 40: com.sleepycat.je.tree.LN.init([BII)V:80 - InsertUnaryOp IINC -1
   * 13 Weak Mutation 41: com.sleepycat.je.tree.LN.init([BII)V:80 - InsertUnaryOp Negation
   * 14 Weak Mutation 44: com.sleepycat.je.tree.LN.init([BII)V:80 - ReplaceConstant - 0 -> 1
   * 15 Weak Mutation 45: com.sleepycat.je.tree.LN.init([BII)V:80 - InsertUnaryOp Negation
   */
  @Test
  public void test22()  throws Throwable  {
      NameLN nameLN0 = new NameLN((DatabaseId) null);
      assertNotNull(nameLN0);
      
      Properties properties0 = new Properties();
      nameLN0.addToDirtyMap((Map) properties0);
      assertEquals(4294971035L, nameLN0.getNextNodeId());
      assertEquals("<com.sleepycat.je.tree.NameLN/4294971033", nameLN0.shortDescription());
  }
}