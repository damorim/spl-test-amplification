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

@RunWith(EvoSuiteRunner.class)
public class TestINList_1 {


  //Test case number: 1
  /*
   * 28 covered goals:
   * 1 Weak Mutation 2: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteField: insLjava/util/SortedSet;
   * 2 Weak Mutation 3: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteStatement: size()I
   * 3 Weak Mutation 31: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteField: outLjava/io/PrintStream;
   * 4 Weak Mutation 34: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: getSize()I
   * 5 Weak Mutation 35: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 6 Weak Mutation 32: com.sleepycat.je.dbi.INList.dump()V:273 - ReplaceConstant - size= -> 
   * 7 Weak Mutation 33: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 8 Weak Mutation 36: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: toString()Ljava/lang/String;
   * 9 Weak Mutation 37: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: println(Ljava/lang/String;)V
   * 10 Weak Mutation 38: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteField: insLjava/util/SortedSet;
   * 11 Weak Mutation 39: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 12 Weak Mutation 40: com.sleepycat.je.dbi.INList.dump()V:275 - DeleteStatement: hasNext()Z
   * 13 Weak Mutation 41: com.sleepycat.je.dbi.INList.dump()V:275 - ReplaceComparisonOperator == -> !=
   * 14 com.sleepycat.je.dbi.INList.getSize()I: root-Branch
   * 15 com.sleepycat.je.dbi.INList.dump()V: I23 Branch 5 IFEQ L275 - true
   * 16 Weak Mutation 2: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteField: insLjava/util/SortedSet;
   * 17 Weak Mutation 3: com.sleepycat.je.dbi.INList.getSize()I:74 - DeleteStatement: size()I
   * 18 Weak Mutation 31: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteField: outLjava/io/PrintStream;
   * 19 Weak Mutation 34: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: getSize()I
   * 20 Weak Mutation 35: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: append(I)Ljava/lang/StringBuilder;
   * 21 Weak Mutation 32: com.sleepycat.je.dbi.INList.dump()V:273 - ReplaceConstant - size= -> 
   * 22 Weak Mutation 33: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 23 Weak Mutation 38: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteField: insLjava/util/SortedSet;
   * 24 Weak Mutation 39: com.sleepycat.je.dbi.INList.dump()V:274 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 25 Weak Mutation 36: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: toString()Ljava/lang/String;
   * 26 Weak Mutation 37: com.sleepycat.je.dbi.INList.dump()V:273 - DeleteStatement: println(Ljava/lang/String;)V
   * 27 Weak Mutation 40: com.sleepycat.je.dbi.INList.dump()V:275 - DeleteStatement: hasNext()Z
   * 28 Weak Mutation 41: com.sleepycat.je.dbi.INList.dump()V:275 - ReplaceComparisonOperator == -> !=
   */
  @Test
  public void test1()  throws Throwable  {
      INList iNList0 = new INList((EnvironmentImpl) null);
      iNList0.dump();
      assertEquals(0, iNList0.getSize());
  }
}
