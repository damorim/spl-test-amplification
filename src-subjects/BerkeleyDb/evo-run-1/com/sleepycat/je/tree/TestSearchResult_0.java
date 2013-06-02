/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.tree.SearchResult;

@RunWith(EvoSuiteRunner.class)
public class TestSearchResult_0 {


  //Test case number: 0
  /*
   * 36 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteField: exactParentFoundZ
   * 2 Weak Mutation 0: com.sleepycat.je.tree.SearchResult.<init>()V:12 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 1: com.sleepycat.je.tree.SearchResult.<init>()V:13 - ReplaceConstant - 1 -> 0
   * 4 Weak Mutation 2: com.sleepycat.je.tree.SearchResult.<init>()V:15 - ReplaceConstant - -1 -> 0
   * 5 Weak Mutation 3: com.sleepycat.je.tree.SearchResult.<init>()V:15 - ReplaceConstant - -1 -> 1
   * 6 Weak Mutation 4: com.sleepycat.je.tree.SearchResult.<init>()V:15 - ReplaceConstant - -1 -> -2
   * 7 Weak Mutation 5: com.sleepycat.je.tree.SearchResult.<init>()V:16 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 6: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - ReplaceConstant - exactParentFound= -> 
   * 9 Weak Mutation 7: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 10 Weak Mutation 8: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - InsertUnaryOp Negation
   * 11 Weak Mutation 9: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteField: exactParentFoundZ
   * 12 Weak Mutation 10: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Z)Ljava/lang/StringBuilder;
   * 13 Weak Mutation 11: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - ReplaceConstant -  keepSearching= -> 
   * 14 Weak Mutation 12: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 15 Weak Mutation 13: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - InsertUnaryOp Negation
   * 16 Weak Mutation 14: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteField: keepSearchingZ
   * 17 Weak Mutation 15: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Z)Ljava/lang/StringBuilder;
   * 18 Weak Mutation 17: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 19 Weak Mutation 16: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - ReplaceConstant -  parent= -> 
   * 20 Weak Mutation 19: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - ReplaceComparisonOperator != null -> = null
   * 21 Weak Mutation 20: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - ReplaceConstant - null -> 
   * 22 Weak Mutation 25: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - ReplaceConstant -  index= -> 
   * 23 Weak Mutation 24: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 24 Weak Mutation 27: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - InsertUnaryOp Negation
   * 25 Weak Mutation 26: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 26 Weak Mutation 29: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - InsertUnaryOp -1
   * 27 Weak Mutation 28: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - InsertUnaryOp +1
   * 28 Weak Mutation 31: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 29 Weak Mutation 30: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteField: indexI
   * 30 Weak Mutation 34: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - InsertUnaryOp Negation
   * 31 Weak Mutation 32: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - ReplaceConstant -  childNotResident= -> 
   * 32 Weak Mutation 33: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 33 Weak Mutation 36: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: append(Z)Ljava/lang/StringBuilder;
   * 34 Weak Mutation 37: com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;:19 - DeleteStatement: toString()Ljava/lang/String;
   * 35 com.sleepycat.je.tree.SearchResult.<init>()V: root-Branch
   * 36 com.sleepycat.je.tree.SearchResult.toString()Ljava/lang/String;: I19 Branch 1 IFNONNULL L19 - false
   */
  @Test
  public void test0()  throws Throwable  {
      SearchResult searchResult0 = new SearchResult();
      assertEquals(false, searchResult0.exactParentFound);
      
      searchResult0.exactParentFound = true;
      String string0 = searchResult0.toString();
      assertEquals("exactParentFound=true keepSearching=true parent=null index=-1 childNotResident=false", string0);
  }
}