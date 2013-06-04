/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.IN;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@RunWith(EvoSuiteRunner.class)
public class TestINList {


  //Test case number: 0
  /*
   * 9 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.dbi.INList.<init>(Lcom/sleepycat/je/dbi/INList;Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:55 - ReplaceVariable orig -> this
   * 2 Weak Mutation 1: com.sleepycat.je.dbi.INList.<init>(Lcom/sleepycat/je/dbi/INList;Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:55 - DeleteStatement: getINs()Ljava/util/SortedSet;
   * 3 Weak Mutation 2: com.sleepycat.je.dbi.INList.getINs()Ljava/util/SortedSet;:71 - DeleteField: insLjava/util/SortedSet;
   * 4 com.sleepycat.je.dbi.INList.<init>(Lcom/sleepycat/je/dbi/INList;Lcom/sleepycat/je/dbi/EnvironmentImpl;)V: root-Branch
   * 5 com.sleepycat.je.dbi.INList.getINs()Ljava/util/SortedSet;: root-Branch
   * 6 com.sleepycat.je.dbi.INList.<init>(Lcom/sleepycat/je/dbi/EnvironmentImpl;)V: root-Branch
   * 7 Weak Mutation 0: com.sleepycat.je.dbi.INList.<init>(Lcom/sleepycat/je/dbi/INList;Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:55 - ReplaceVariable orig -> this
   * 8 Weak Mutation 1: com.sleepycat.je.dbi.INList.<init>(Lcom/sleepycat/je/dbi/INList;Lcom/sleepycat/je/dbi/EnvironmentImpl;)V:55 - DeleteStatement: getINs()Ljava/util/SortedSet;
   * 9 Weak Mutation 2: com.sleepycat.je.dbi.INList.getINs()Ljava/util/SortedSet;:71 - DeleteField: insLjava/util/SortedSet;
   */
  @Test
  public void test0()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      INList iNList1 = new INList(iNList0, (EnvironmentImpl) null);
      assertNotSame(iNList1, iNList0);
  }

  //Test case number: 1
  /*
   * 26 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteField: insLjava/util/SortedSet;
   * 2 Weak Mutation 4: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteStatement: size()I
   * 3 Weak Mutation 31: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteField: outLjava/io/PrintStream;
   * 4 Weak Mutation 34: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 5 Weak Mutation 35: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: toString()Ljava/lang/String;
   * 6 Weak Mutation 32: com.sleepycat.je.dbi.INList.dump()V:273 - ReplaceConstant - size= -> 
   * 7 Weak Mutation 33: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: getSize()I
   * 8 Weak Mutation 36: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: println(Ljava/lang/String;)V
   * 9 Weak Mutation 38: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 10 Weak Mutation 37: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteField: insLjava/util/SortedSet;
   * 11 Weak Mutation 55: com.sleepycat.je.dbi.INList.dump()V:275 - DeleteStatement: hasNext()Z
   * 12 Weak Mutation 56: com.sleepycat.je.dbi.INList.dump()V:275 - ReplaceComparisonOperator != -> ==
   * 13 com.sleepycat.je.dbi.INList.getSize()I: root-Branch
   * 14 com.sleepycat.je.dbi.INList.dump()V: I54 Branch 6 IFNE L275 - false
   * 15 Weak Mutation 3: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteField: insLjava/util/SortedSet;
   * 16 Weak Mutation 4: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteStatement: size()I
   * 17 Weak Mutation 31: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteField: outLjava/io/PrintStream;
   * 18 Weak Mutation 34: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 19 Weak Mutation 35: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: toString()Ljava/lang/String;
   * 20 Weak Mutation 32: com.sleepycat.je.dbi.INList.dump()V:273 - ReplaceConstant - size= -> 
   * 21 Weak Mutation 33: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: getSize()I
   * 22 Weak Mutation 38: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 23 Weak Mutation 36: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: println(Ljava/lang/String;)V
   * 24 Weak Mutation 37: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteField: insLjava/util/SortedSet;
   * 25 Weak Mutation 55: com.sleepycat.je.dbi.INList.dump()V:275 - DeleteStatement: hasNext()Z
   * 26 Weak Mutation 56: com.sleepycat.je.dbi.INList.dump()V:275 - ReplaceComparisonOperator != -> ==
   */
  @Test
  public void test1()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      iNList0.dump();
      assertEquals(0, iNList0.getSize());
  }

  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 Weak Mutation 5: com.sleepycat.je.dbi.INList.add(Lcom/sleepycat/je/tree/IN;)V:83 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.je.dbi.INList.add(Lcom/sleepycat/je/tree/IN;)V: root-Branch
   * 3 Weak Mutation 5: com.sleepycat.je.dbi.INList.add(Lcom/sleepycat/je/tree/IN;)V:83 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test2()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      DBIN dBIN0 = new DBIN();
      iNList0.add((IN) dBIN0);
      assertEquals(3567L, dBIN0.getNextNodeId());
      assertEquals(3567L, dBIN0.getLastId());
  }

  //Test case number: 3
  /*
   * 14 covered goals:
   * 1 Weak Mutation 17: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:164 - DeleteStatement: remove(Ljava/lang/Object;)Z
   * 2 Weak Mutation 16: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:164 - DeleteField: insLjava/util/SortedSet;
   * 3 Weak Mutation 18: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - InsertUnaryOp Negation
   * 4 Weak Mutation 21: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - InsertUnaryOp Negation of removeDone
   * 5 Weak Mutation 20: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - ReplaceComparisonOperator != -> ==
   * 6 Weak Mutation 22: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - ReplaceComparisonOperator != -> ==
   * 7 com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V: I10 Branch 4 IFNE L184 - false
   * 8 com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V: I12 Branch 5 IFNE L184 - false
   * 9 Weak Mutation 17: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:164 - DeleteStatement: remove(Ljava/lang/Object;)Z
   * 10 Weak Mutation 16: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:164 - DeleteField: insLjava/util/SortedSet;
   * 11 Weak Mutation 18: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - InsertUnaryOp Negation
   * 12 Weak Mutation 21: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - InsertUnaryOp Negation of removeDone
   * 13 Weak Mutation 20: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - ReplaceComparisonOperator != -> ==
   * 14 Weak Mutation 22: com.sleepycat.je.dbi.INList.removeLatchAlreadyHeld(Lcom/sleepycat/je/tree/IN;)V:184 - ReplaceComparisonOperator != -> ==
   */
  @Test
  public void test3()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      DBIN dBIN0 = new DBIN();
      // Undeclared exception!
      try {
        iNList0.removeLatchAlreadyHeld((IN) dBIN0);
        fail("Expecting exception: AssertionError");
      } catch(AssertionError e) {
      }
  }

  //Test case number: 4
  /*
   * 5 covered goals:
   * 1 Weak Mutation 23: com.sleepycat.je.dbi.INList.tailSet(Lcom/sleepycat/je/tree/IN;)Ljava/util/SortedSet;:218 - DeleteField: insLjava/util/SortedSet;
   * 2 Weak Mutation 24: com.sleepycat.je.dbi.INList.tailSet(Lcom/sleepycat/je/tree/IN;)Ljava/util/SortedSet;:218 - DeleteStatement: tailSet(Ljava/lang/Object;)Ljava/util/SortedSet;
   * 3 com.sleepycat.je.dbi.INList.tailSet(Lcom/sleepycat/je/tree/IN;)Ljava/util/SortedSet;: root-Branch
   * 4 Weak Mutation 23: com.sleepycat.je.dbi.INList.tailSet(Lcom/sleepycat/je/tree/IN;)Ljava/util/SortedSet;:218 - DeleteField: insLjava/util/SortedSet;
   * 5 Weak Mutation 24: com.sleepycat.je.dbi.INList.tailSet(Lcom/sleepycat/je/tree/IN;)Ljava/util/SortedSet;:218 - DeleteStatement: tailSet(Ljava/lang/Object;)Ljava/util/SortedSet;
   */
  @Test
  public void test4()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      DBIN dBIN0 = new DBIN();
      SortedSet<?> sortedSet0 = iNList0.tailSet((IN) dBIN0);
      assertNotNull(sortedSet0);
      assertEquals(3587L, dBIN0.getLastId());
  }

  //Test case number: 5
  /*
   * 5 covered goals:
   * 1 Weak Mutation 25: com.sleepycat.je.dbi.INList.first()Lcom/sleepycat/je/tree/IN;:224 - DeleteField: insLjava/util/SortedSet;
   * 2 Weak Mutation 26: com.sleepycat.je.dbi.INList.first()Lcom/sleepycat/je/tree/IN;:224 - DeleteStatement: first()Ljava/lang/Object;
   * 3 com.sleepycat.je.dbi.INList.first()Lcom/sleepycat/je/tree/IN;: root-Branch
   * 4 Weak Mutation 25: com.sleepycat.je.dbi.INList.first()Lcom/sleepycat/je/tree/IN;:224 - DeleteField: insLjava/util/SortedSet;
   * 5 Weak Mutation 26: com.sleepycat.je.dbi.INList.first()Lcom/sleepycat/je/tree/IN;:224 - DeleteStatement: first()Ljava/lang/Object;
   */
  @Test
  public void test5()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      // Undeclared exception!
      try {
        iNList0.first();
        fail("Expecting exception: NoSuchElementException");
      } catch(NoSuchElementException e) {
      }
  }

  //Test case number: 6
  /*
   * 5 covered goals:
   * 1 Weak Mutation 27: com.sleepycat.je.dbi.INList.iterator()Ljava/util/Iterator;:238 - DeleteField: insLjava/util/SortedSet;
   * 2 Weak Mutation 28: com.sleepycat.je.dbi.INList.iterator()Ljava/util/Iterator;:238 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 3 com.sleepycat.je.dbi.INList.iterator()Ljava/util/Iterator;: root-Branch
   * 4 Weak Mutation 27: com.sleepycat.je.dbi.INList.iterator()Ljava/util/Iterator;:238 - DeleteField: insLjava/util/SortedSet;
   * 5 Weak Mutation 28: com.sleepycat.je.dbi.INList.iterator()Ljava/util/Iterator;:238 - DeleteStatement: iterator()Ljava/util/Iterator;
   */
  @Test
  public void test6()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      Iterator<?> iterator0 = iNList0.iterator();
      assertEquals(false, iterator0.hasNext());
  }

  //Test case number: 7
  /*
   * 5 covered goals:
   * 1 Weak Mutation 29: com.sleepycat.je.dbi.INList.clear()V:253 - DeleteField: insLjava/util/SortedSet;
   * 2 Weak Mutation 30: com.sleepycat.je.dbi.INList.clear()V:253 - DeleteStatement: clear()V
   * 3 com.sleepycat.je.dbi.INList.clear()V: root-Branch
   * 4 Weak Mutation 29: com.sleepycat.je.dbi.INList.clear()V:253 - DeleteField: insLjava/util/SortedSet;
   * 5 Weak Mutation 30: com.sleepycat.je.dbi.INList.clear()V:253 - DeleteStatement: clear()V
   */
  @Test
  public void test7()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      iNList0.clear();
      assertEquals(0, iNList0.getSize());
  }
}