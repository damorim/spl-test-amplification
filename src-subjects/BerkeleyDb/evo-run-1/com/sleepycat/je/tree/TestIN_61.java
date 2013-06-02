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
public class TestIN_61 {


  //Test case number: 61
  /*
   * 3 covered goals:
   * 1 Weak Mutation 2247: com.sleepycat.je.tree.IN.shortClassName()Ljava/lang/String;:2241 - ReplaceConstant - IN -> 
   * 2 com.sleepycat.je.tree.IN.shortClassName()Ljava/lang/String;: root-Branch
   * 3 Weak Mutation 2247: com.sleepycat.je.tree.IN.shortClassName()Ljava/lang/String;:2241 - ReplaceConstant - IN -> 
   */
  @Test
  public void test61()  throws Throwable  {
      IN iN0 = new IN();
      assertNotNull(iN0);
      
      String string0 = iN0.shortClassName();
      assertEquals(114940L, iN0.getLastId());
      assertEquals("IN", string0);
  }
}