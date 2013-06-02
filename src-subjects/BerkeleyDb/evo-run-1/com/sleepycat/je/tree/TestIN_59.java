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
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.InconsistentNodeException;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

@RunWith(EvoSuiteRunner.class)
public class TestIN_59 {


  //Test case number: 59
  /*
   * 5 covered goals:
   * 1 Weak Mutation 2140: com.sleepycat.je.tree.IN.getTransactionId()J:2128 - ReplaceConstant - 0 -> -1
   * 2 Weak Mutation 2139: com.sleepycat.je.tree.IN.getTransactionId()J:2128 - ReplaceConstant - 0 -> 1
   * 3 com.sleepycat.je.tree.IN.getTransactionId()J: root-Branch
   * 4 Weak Mutation 2140: com.sleepycat.je.tree.IN.getTransactionId()J:2128 - ReplaceConstant - 0 -> -1
   * 5 Weak Mutation 2139: com.sleepycat.je.tree.IN.getTransactionId()J:2128 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test59()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      assertNotNull(dBIN0);
      
      long long0 = dBIN0.getTransactionId();
      assertEquals(114674L, dBIN0.getLastId());
      assertEquals(0L, long0);
  }
}