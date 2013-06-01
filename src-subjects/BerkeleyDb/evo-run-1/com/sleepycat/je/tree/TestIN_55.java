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
public class TestIN_55 {


  //Test case number: 55
  /*
   * 59 covered goals:
   * 1 Weak Mutation 1878: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1902 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 1880: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1903 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 1888: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceConstant - -1 -> 0
   * 4 Weak Mutation 1889: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceConstant - -1 -> 1
   * 5 Weak Mutation 1890: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceConstant - -1 -> -2
   * 6 Weak Mutation 1891: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - DeleteStatement: longSub(JJ)I
   * 7 Weak Mutation 1892: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceComparisonOperator != -> <
   * 8 Weak Mutation 1887: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - InsertUnaryOp Negation
   * 9 Weak Mutation 1904: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1922 - ReplaceComparisonOperator != null -> = null
   * 10 Weak Mutation 1905: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - InsertUnaryOp Negation
   * 11 Weak Mutation 1907: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceConstant - -1 -> 1
   * 12 Weak Mutation 1906: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceConstant - -1 -> 0
   * 13 Weak Mutation 1909: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - DeleteStatement: longSub(JJ)I
   * 14 Weak Mutation 1908: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceConstant - -1 -> -2
   * 15 Weak Mutation 1910: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceComparisonOperator == -> >=
   * 16 Weak Mutation 1913: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1926 - DeleteField: provisionalObsoleteLjava/util/List;
   * 17 Weak Mutation 1915: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1926 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 18 Weak Mutation 1914: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1926 - InsertUnaryOp Negation
   * 19 Weak Mutation 1917: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceConstant - -1 -> 0
   * 20 Weak Mutation 1916: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - InsertUnaryOp Negation
   * 21 Weak Mutation 1919: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceConstant - -1 -> -2
   * 22 Weak Mutation 1918: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceConstant - -1 -> 1
   * 23 Weak Mutation 1921: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceComparisonOperator == -> >=
   * 24 Weak Mutation 1920: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - DeleteStatement: longSub(JJ)I
   * 25 Weak Mutation 1926: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1932 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 26 Weak Mutation 1925: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1932 - InsertUnaryOp Negation
   * 27 Weak Mutation 1924: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1932 - DeleteField: provisionalObsoleteLjava/util/List;
   * 28 com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V: I8 Branch 127 IFNULL L1903 - true
   * 29 com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V: I39 Branch 129 IFNE L1921 - true
   * 30 com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V: I48 Branch 131 IFNONNULL L1922 - false
   * 31 com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V: I61 Branch 132 IFEQ L1925 - false
   * 32 com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V: I77 Branch 133 IFEQ L1931 - false
   * 33 Weak Mutation 1913: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1926 - DeleteField: provisionalObsoleteLjava/util/List;
   * 34 Weak Mutation 1915: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1926 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 35 Weak Mutation 1914: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1926 - InsertUnaryOp Negation
   * 36 Weak Mutation 1917: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceConstant - -1 -> 0
   * 37 Weak Mutation 1916: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - InsertUnaryOp Negation
   * 38 Weak Mutation 1919: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceConstant - -1 -> -2
   * 39 Weak Mutation 1918: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceConstant - -1 -> 1
   * 40 Weak Mutation 1905: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - InsertUnaryOp Negation
   * 41 Weak Mutation 1904: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1922 - ReplaceComparisonOperator != null -> = null
   * 42 Weak Mutation 1907: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceConstant - -1 -> 1
   * 43 Weak Mutation 1906: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceConstant - -1 -> 0
   * 44 Weak Mutation 1909: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - DeleteStatement: longSub(JJ)I
   * 45 Weak Mutation 1908: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceConstant - -1 -> -2
   * 46 Weak Mutation 1910: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1925 - ReplaceComparisonOperator == -> >=
   * 47 Weak Mutation 1888: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceConstant - -1 -> 0
   * 48 Weak Mutation 1889: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceConstant - -1 -> 1
   * 49 Weak Mutation 1890: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceConstant - -1 -> -2
   * 50 Weak Mutation 1891: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - DeleteStatement: longSub(JJ)I
   * 51 Weak Mutation 1892: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - ReplaceComparisonOperator != -> <
   * 52 Weak Mutation 1880: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1903 - ReplaceComparisonOperator = null -> != null
   * 53 Weak Mutation 1887: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1921 - InsertUnaryOp Negation
   * 54 Weak Mutation 1878: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1902 - ReplaceConstant - 0 -> 1
   * 55 Weak Mutation 1926: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1932 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 56 Weak Mutation 1925: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1932 - InsertUnaryOp Negation
   * 57 Weak Mutation 1924: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1932 - DeleteField: provisionalObsoleteLjava/util/List;
   * 58 Weak Mutation 1921: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - ReplaceComparisonOperator == -> >=
   * 59 Weak Mutation 1920: com.sleepycat.je.tree.IN.trackProvisionalObsolete(Lcom/sleepycat/je/tree/IN;JJ)V:1931 - DeleteStatement: longSub(JJ)I
   */
  @Test
  public void test55()  throws Throwable  {
      IN iN0 = new IN();
      assertNotNull(iN0);
      
      iN0.trackProvisionalObsolete(iN0, 0L, 0L);
      assertEquals(114232L, iN0.getNextNodeId());
      assertEquals(114232L, iN0.getLastId());
  }
}
