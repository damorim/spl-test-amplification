/*
 * This file was automatically generated by EvoSuite
 */

package sudoku.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import sudoku.main.Structure;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractEnum_0 {


  //Test case number: 0
  /*
   * 53 covered goals:
   * 1 Weak Mutation 0: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:88 - DeleteStatement: checkClassIsEnum(Ljava/lang/Class;)V
   * 2 Weak Mutation 1: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:89 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 2: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:90 - DeleteStatement: getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;
   * 4 Weak Mutation 3: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:90 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 5 Weak Mutation 4: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:91 - DeleteStatement: hasNext()Z
   * 6 Weak Mutation 5: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:91 - ReplaceComparisonOperator == -> !=
   * 7 Weak Mutation 6: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - InsertUnaryOp Negation
   * 8 Weak Mutation 7: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 8: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 9: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - DeleteStatement: next()Ljava/lang/Object;
   * 11 Weak Mutation 10: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:111 - DeleteStatement: checkClassIsEnum(Ljava/lang/Class;)V
   * 12 Weak Mutation 11: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteField: ALL_COUNTSLjava/util/Map;
   * 13 Weak Mutation 12: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteStatement: mapContainsKey(Ljava/util/Map;Ljava/lang/Object;)I
   * 14 Weak Mutation 15: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - ReplaceComparisonOperator <= -> -1
   * 15 Weak Mutation 17: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 16 Weak Mutation 16: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteField: ALL_COUNTSLjava/util/Map;
   * 17 Weak Mutation 18: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteStatement: intValue()I
   * 18 Weak Mutation 77: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:252 - ReplaceComparisonOperator <= -> -1
   * 19 Weak Mutation 73: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:252 - DeleteField: ALL_VALUES_BY_ORDINALLjava/util/Map;
   * 20 Weak Mutation 74: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:252 - DeleteStatement: mapContainsKey(Ljava/util/Map;Ljava/lang/Object;)I
   * 21 Weak Mutation 78: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:253 - DeleteField: ALL_VALUES_BY_ORDINALLjava/util/Map;
   * 22 Weak Mutation 79: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:253 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 23 Weak Mutation 96: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:267 - DeleteStatement: isAssignableFrom(Ljava/lang/Class;)Z
   * 24 Weak Mutation 97: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:267 - ReplaceComparisonOperator != -> ==
   * 25 sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;: I18 Branch 1 IFEQ L91 - true
   * 26 sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;: I18 Branch 1 IFEQ L91 - false
   * 27 sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I: I9 Branch 2 IFLE L112 - false
   * 28 sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;: I5 Branch 6 IFLE L252 - false
   * 29 sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V: I5 Branch 7 IFNE L267 - true
   * 30 Weak Mutation 0: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:88 - DeleteStatement: checkClassIsEnum(Ljava/lang/Class;)V
   * 31 Weak Mutation 1: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:89 - ReplaceConstant - 0 -> 1
   * 32 Weak Mutation 2: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:90 - DeleteStatement: getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;
   * 33 Weak Mutation 3: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:90 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 34 Weak Mutation 4: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:91 - DeleteStatement: hasNext()Z
   * 35 Weak Mutation 5: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:91 - ReplaceComparisonOperator == -> !=
   * 36 Weak Mutation 6: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - InsertUnaryOp Negation
   * 37 Weak Mutation 7: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - InsertUnaryOp IINC 1
   * 38 Weak Mutation 8: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - InsertUnaryOp IINC -1
   * 39 Weak Mutation 9: sudoku.main.AbstractEnum.values0(Ljava/lang/Class;[Lsudoku/main/AbstractEnum;)[Lsudoku/main/AbstractEnum;:93 - DeleteStatement: next()Ljava/lang/Object;
   * 40 Weak Mutation 10: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:111 - DeleteStatement: checkClassIsEnum(Ljava/lang/Class;)V
   * 41 Weak Mutation 11: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteField: ALL_COUNTSLjava/util/Map;
   * 42 Weak Mutation 12: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteStatement: mapContainsKey(Ljava/util/Map;Ljava/lang/Object;)I
   * 43 Weak Mutation 15: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - ReplaceComparisonOperator <= -> -1
   * 44 Weak Mutation 17: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 45 Weak Mutation 16: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteField: ALL_COUNTSLjava/util/Map;
   * 46 Weak Mutation 18: sudoku.main.AbstractEnum.count(Ljava/lang/Class;)I:112 - DeleteStatement: intValue()I
   * 47 Weak Mutation 77: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:252 - ReplaceComparisonOperator <= -> -1
   * 48 Weak Mutation 78: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:253 - DeleteField: ALL_VALUES_BY_ORDINALLjava/util/Map;
   * 49 Weak Mutation 79: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:253 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 50 Weak Mutation 73: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:252 - DeleteField: ALL_VALUES_BY_ORDINALLjava/util/Map;
   * 51 Weak Mutation 74: sudoku.main.AbstractEnum.getValuesByOrdinal(Ljava/lang/Class;)Ljava/util/SortedSet;:252 - DeleteStatement: mapContainsKey(Ljava/util/Map;Ljava/lang/Object;)I
   * 52 Weak Mutation 96: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:267 - DeleteStatement: isAssignableFrom(Ljava/lang/Class;)Z
   * 53 Weak Mutation 97: sudoku.main.AbstractEnum.checkClassIsEnum(Ljava/lang/Class;)V:267 - ReplaceComparisonOperator != -> ==
   */
  @Test
  public void test0()  throws Throwable  {
      Structure[] structureArray0 = Structure.values();
      assertNotNull(structureArray0);
  }
}