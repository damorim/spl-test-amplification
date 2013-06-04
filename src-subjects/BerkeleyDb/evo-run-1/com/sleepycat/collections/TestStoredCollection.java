/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.collections.DataView;
import com.sleepycat.collections.StoredContainer;
import com.sleepycat.collections.StoredEntrySet;
import com.sleepycat.collections.StoredSortedEntrySet;
import com.sleepycat.collections.StoredSortedKeySet;
import com.sleepycat.collections.StoredValueSet;
import com.sleepycat.je.JoinConfig;

@RunWith(EvoSuiteRunner.class)
public class TestStoredCollection {


  //Test case number: 0
  /*
   * 16 covered goals:
   * 1 Weak Mutation 21: com.sleepycat.collections.StoredCollection.iterator()Ljava/util/Iterator;:90 - DeleteStatement: isWriteAllowed()Z
   * 2 Weak Mutation 138: com.sleepycat.collections.StoredCollection.equals(Ljava/lang/Object;)Z:293 - ReplaceComparisonOperator == -> !=
   * 3 Weak Mutation 139: com.sleepycat.collections.StoredCollection.equals(Ljava/lang/Object;)Z:294 - DeleteStatement: copyCollection(Ljava/lang/Object;)Ljava/util/Collection;
   * 4 Weak Mutation 152: com.sleepycat.collections.StoredCollection.toList()Ljava/util/List;:332 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 5 Weak Mutation 224: com.sleepycat.collections.StoredCollection.copyCollection(Ljava/lang/Object;)Ljava/util/Collection;:453 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 225: com.sleepycat.collections.StoredCollection.copyCollection(Ljava/lang/Object;)Ljava/util/Collection;:454 - DeleteStatement: toList()Ljava/util/List;
   * 7 com.sleepycat.collections.StoredCollection.iterator()Ljava/util/Iterator;: root-Branch
   * 8 com.sleepycat.collections.StoredCollection.<init>(Lcom/sleepycat/collections/DataView;)V: root-Branch
   * 9 com.sleepycat.collections.StoredCollection.equals(Ljava/lang/Object;)Z: I4 Branch 16 IFEQ L293 - false
   * 10 com.sleepycat.collections.StoredCollection.copyCollection(Ljava/lang/Object;)Ljava/util/Collection;: I4 Branch 26 IFEQ L453 - false
   * 11 Weak Mutation 21: com.sleepycat.collections.StoredCollection.iterator()Ljava/util/Iterator;:90 - DeleteStatement: isWriteAllowed()Z
   * 12 Weak Mutation 139: com.sleepycat.collections.StoredCollection.equals(Ljava/lang/Object;)Z:294 - DeleteStatement: copyCollection(Ljava/lang/Object;)Ljava/util/Collection;
   * 13 Weak Mutation 138: com.sleepycat.collections.StoredCollection.equals(Ljava/lang/Object;)Z:293 - ReplaceComparisonOperator == -> !=
   * 14 Weak Mutation 152: com.sleepycat.collections.StoredCollection.toList()Ljava/util/List;:332 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 15 Weak Mutation 225: com.sleepycat.collections.StoredCollection.copyCollection(Ljava/lang/Object;)Ljava/util/Collection;:454 - DeleteStatement: toList()Ljava/util/List;
   * 16 Weak Mutation 224: com.sleepycat.collections.StoredCollection.copyCollection(Ljava/lang/Object;)Ljava/util/Collection;:453 - ReplaceComparisonOperator == -> !=
   */
  @Test
  public void test0()  throws Throwable  {
      StoredSortedEntrySet storedSortedEntrySet0 = new StoredSortedEntrySet((DataView) null);
      StoredValueSet storedValueSet0 = new StoredValueSet((DataView) null);
      // Undeclared exception!
      try {
        storedSortedEntrySet0.equals((Object) storedValueSet0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 1
  /*
   * 13 covered goals:
   * 1 Weak Mutation 23: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - InsertUnaryOp Negation of writeAllowed
   * 2 Weak Mutation 25: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - InsertUnaryOp IINC -1 writeAllowed
   * 3 Weak Mutation 24: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - InsertUnaryOp IINC 1 writeAllowed
   * 4 Weak Mutation 27: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - DeleteStatement: isWriteAllowed()Z
   * 5 Weak Mutation 26: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 31: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:118 - DeleteStatement: convertException(Ljava/lang/Exception;)Ljava/lang/RuntimeException;
   * 7 com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;: I6 Branch 2 IFEQ L115 - false
   * 8 Weak Mutation 23: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - InsertUnaryOp Negation of writeAllowed
   * 9 Weak Mutation 25: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - InsertUnaryOp IINC -1 writeAllowed
   * 10 Weak Mutation 24: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - InsertUnaryOp IINC 1 writeAllowed
   * 11 Weak Mutation 27: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - DeleteStatement: isWriteAllowed()Z
   * 12 Weak Mutation 26: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:115 - ReplaceComparisonOperator == -> !=
   * 13 Weak Mutation 31: com.sleepycat.collections.StoredCollection.iterator(Z)Lcom/sleepycat/collections/StoredIterator;:118 - DeleteStatement: convertException(Ljava/lang/Exception;)Ljava/lang/RuntimeException;
   */
  @Test
  public void test1()  throws Throwable  {
      StoredSortedKeySet storedSortedKeySet0 = new StoredSortedKeySet((DataView) null);
      // Undeclared exception!
      try {
        storedSortedKeySet0.iterator(true);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 2
  /*
   * 30 covered goals:
   * 1 Weak Mutation 198: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - ReplaceComparisonOperator < -> <=
   * 2 Weak Mutation 200: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:400 - DeleteStatement: join([Lcom/sleepycat/collections/DataView;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/DataCursor;
   * 3 com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;: I28 Branch 22 IF_ICMPLT L397 - false
   * 4 Weak Mutation 186: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp Negation of i
   * 5 Weak Mutation 187: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC 1 i
   * 6 Weak Mutation 185: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 190: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC 1 i
   * 8 Weak Mutation 191: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC -1 i
   * 9 Weak Mutation 188: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC -1 i
   * 10 Weak Mutation 189: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp Negation of i
   * 11 Weak Mutation 202: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:403 - DeleteStatement: convertException(Ljava/lang/Exception;)Ljava/lang/RuntimeException;
   * 12 Weak Mutation 197: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - ReplaceComparisonOperator < -> -2
   * 13 Weak Mutation 193: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - InsertUnaryOp Negation of i
   * 14 Weak Mutation 195: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - InsertUnaryOp IINC -1 i
   * 15 Weak Mutation 194: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - InsertUnaryOp IINC 1 i
   * 16 Weak Mutation 186: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp Negation of i
   * 17 Weak Mutation 187: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC 1 i
   * 18 Weak Mutation 185: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - ReplaceConstant - 0 -> 1
   * 19 Weak Mutation 190: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC 1 i
   * 20 Weak Mutation 191: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC -1 i
   * 21 Weak Mutation 188: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp IINC -1 i
   * 22 Weak Mutation 189: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:398 - InsertUnaryOp Negation of i
   * 23 Weak Mutation 200: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:400 - DeleteStatement: join([Lcom/sleepycat/collections/DataView;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/DataCursor;
   * 24 Weak Mutation 202: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:403 - DeleteStatement: convertException(Ljava/lang/Exception;)Ljava/lang/RuntimeException;
   * 25 Weak Mutation 197: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - ReplaceComparisonOperator < -> -2
   * 26 Weak Mutation 198: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - ReplaceComparisonOperator < -> <=
   * 27 Weak Mutation 193: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - InsertUnaryOp Negation of i
   * 28 Weak Mutation 195: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - InsertUnaryOp IINC -1 i
   * 29 Weak Mutation 194: com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;:397 - InsertUnaryOp IINC 1 i
   * 30 com.sleepycat.collections.StoredCollection.join([Lcom/sleepycat/collections/StoredContainer;[Ljava/lang/Object;Lcom/sleepycat/je/JoinConfig;)Lcom/sleepycat/collections/StoredIterator;: I28 Branch 22 IF_ICMPLT L397 - true
   */
  @Test
  public void test2()  throws Throwable  {
      StoredEntrySet storedEntrySet0 = new StoredEntrySet((DataView) null);
      StoredContainer[] storedContainerArray0 = new StoredContainer[1];
      storedContainerArray0[0] = (StoredContainer) storedEntrySet0;
      JoinConfig joinConfig0 = new JoinConfig();
      // Undeclared exception!
      try {
        storedEntrySet0.join(storedContainerArray0, (Object[]) storedContainerArray0, joinConfig0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 3
  /*
   * 6 covered goals:
   * 1 Weak Mutation 204: com.sleepycat.collections.StoredCollection.getFirstOrLast(Z)Ljava/lang/Object;:411 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 217: com.sleepycat.collections.StoredCollection.getFirstOrLast(Z)Ljava/lang/Object;:421 - DeleteStatement: convertException(Ljava/lang/Exception;)Ljava/lang/RuntimeException;
   * 3 Weak Mutation 218: com.sleepycat.collections.StoredCollection.getFirstOrLast(Z)Ljava/lang/Object;:423 - DeleteStatement: closeCursor(Lcom/sleepycat/collections/DataCursor;)V
   * 4 Weak Mutation 204: com.sleepycat.collections.StoredCollection.getFirstOrLast(Z)Ljava/lang/Object;:411 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 217: com.sleepycat.collections.StoredCollection.getFirstOrLast(Z)Ljava/lang/Object;:421 - DeleteStatement: convertException(Ljava/lang/Exception;)Ljava/lang/RuntimeException;
   * 6 Weak Mutation 218: com.sleepycat.collections.StoredCollection.getFirstOrLast(Z)Ljava/lang/Object;:423 - DeleteStatement: closeCursor(Lcom/sleepycat/collections/DataCursor;)V
   */
  @Test
  public void test3()  throws Throwable  {
      StoredSortedEntrySet storedSortedEntrySet0 = new StoredSortedEntrySet((DataView) null);
      // Undeclared exception!
      try {
        storedSortedEntrySet0.getFirstOrLast(false);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 4
  /*
   * 3 covered goals:
   * 1 Weak Mutation 219: com.sleepycat.collections.StoredCollection.iterateDuplicates()Z:435 - ReplaceConstant - 1 -> 0
   * 2 com.sleepycat.collections.StoredCollection.iterateDuplicates()Z: root-Branch
   * 3 Weak Mutation 219: com.sleepycat.collections.StoredCollection.iterateDuplicates()Z:435 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test4()  throws Throwable  {
      StoredEntrySet storedEntrySet0 = new StoredEntrySet((DataView) null);
      boolean boolean0 = storedEntrySet0.iterateDuplicates();
      assertEquals(true, boolean0);
  }

  //Test case number: 5
  /*
   * 3 covered goals:
   * 1 Weak Mutation 223: com.sleepycat.collections.StoredCollection.getIndexOffset()I:448 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.collections.StoredCollection.getIndexOffset()I: root-Branch
   * 3 Weak Mutation 223: com.sleepycat.collections.StoredCollection.getIndexOffset()I:448 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test5()  throws Throwable  {
      StoredSortedKeySet storedSortedKeySet0 = new StoredSortedKeySet((DataView) null);
      int int0 = storedSortedKeySet0.getIndexOffset();
      assertEquals(0, int0);
  }
}
