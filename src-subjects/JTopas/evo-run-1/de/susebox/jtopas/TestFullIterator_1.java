/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.FullIterator;
import de.susebox.jtopas.StandardTokenizerProperties;

@RunWith(EvoSuiteRunner.class)
public class TestFullIterator_1 {


  //Test case number: 1
  /*
   * 49 covered goals:
   * 1 Weak Mutation 68: de.susebox.jtopas.FullIterator.remove()V:1103 - DeleteField: _currIndexI
   * 2 Weak Mutation 23: de.susebox.jtopas.FullIterator.hasNext()Z:1066 - InsertUnaryOp +1
   * 3 Weak Mutation 22: de.susebox.jtopas.FullIterator.hasNext()Z:1066 - InsertUnaryOp Negation
   * 4 Weak Mutation 25: de.susebox.jtopas.FullIterator.hasNext()Z:1066 - DeleteField: _currIndexI
   * 5 Weak Mutation 24: de.susebox.jtopas.FullIterator.hasNext()Z:1066 - InsertUnaryOp -1
   * 6 Weak Mutation 26: de.susebox.jtopas.FullIterator.hasNext()Z:1066 - DeleteField: _iterators[Ljava/lang/Object;
   * 7 Weak Mutation 29: de.susebox.jtopas.FullIterator.hasNext()Z:1066 - ReplaceComparisonOperator >= -> -1
   * 8 Weak Mutation 31: de.susebox.jtopas.FullIterator.hasNext()Z:1067 - InsertUnaryOp Negation
   * 9 Weak Mutation 30: de.susebox.jtopas.FullIterator.hasNext()Z:1067 - DeleteField: _iterators[Ljava/lang/Object;
   * 10 Weak Mutation 34: de.susebox.jtopas.FullIterator.hasNext()Z:1067 - DeleteField: _currIndexI
   * 11 Weak Mutation 35: de.susebox.jtopas.FullIterator.hasNext()Z:1069 - DeleteStatement: hasNext()Z
   * 12 Weak Mutation 32: de.susebox.jtopas.FullIterator.hasNext()Z:1067 - InsertUnaryOp +1
   * 13 Weak Mutation 33: de.susebox.jtopas.FullIterator.hasNext()Z:1067 - InsertUnaryOp -1
   * 14 Weak Mutation 38: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - InsertUnaryOp Negation
   * 15 Weak Mutation 39: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - InsertUnaryOp +1
   * 16 Weak Mutation 36: de.susebox.jtopas.FullIterator.hasNext()Z:1069 - ReplaceComparisonOperator == -> !=
   * 17 Weak Mutation 37: de.susebox.jtopas.FullIterator.hasNext()Z:1070 - ReplaceConstant - 1 -> 0
   * 18 Weak Mutation 42: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - ReplaceConstant - 1 -> 0
   * 19 Weak Mutation 43: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - ReplaceArithmeticOperator + -> -
   * 20 Weak Mutation 40: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - InsertUnaryOp -1
   * 21 Weak Mutation 46: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - ReplaceArithmeticOperator + -> *
   * 22 Weak Mutation 44: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - ReplaceArithmeticOperator + -> %
   * 23 Weak Mutation 45: de.susebox.jtopas.FullIterator.hasNext()Z:1072 - ReplaceArithmeticOperator + -> /
   * 24 Weak Mutation 51: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - InsertUnaryOp Negation
   * 25 Weak Mutation 50: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - DeleteField: _iterators[Ljava/lang/Object;
   * 26 Weak Mutation 49: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1085 - ReplaceComparisonOperator == -> !=
   * 27 Weak Mutation 48: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1085 - DeleteStatement: hasNext()Z
   * 28 Weak Mutation 55: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1088 - DeleteStatement: next()Ljava/lang/Object;
   * 29 Weak Mutation 54: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - DeleteField: _currIndexI
   * 30 Weak Mutation 53: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - InsertUnaryOp -1
   * 31 Weak Mutation 52: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - InsertUnaryOp +1
   * 32 Weak Mutation 59: de.susebox.jtopas.FullIterator.remove()V:1102 - DeleteField: _currIndexI
   * 33 Weak Mutation 37: de.susebox.jtopas.FullIterator.hasNext()Z:1070 - ReplaceConstant - 1 -> 0
   * 34 Weak Mutation 51: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - InsertUnaryOp Negation
   * 35 Weak Mutation 50: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - DeleteField: _iterators[Ljava/lang/Object;
   * 36 Weak Mutation 55: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1088 - DeleteStatement: next()Ljava/lang/Object;
   * 37 Weak Mutation 54: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - DeleteField: _currIndexI
   * 38 Weak Mutation 53: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - InsertUnaryOp -1
   * 39 Weak Mutation 52: de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;:1087 - InsertUnaryOp +1
   * 40 Weak Mutation 63: de.susebox.jtopas.FullIterator.remove()V:1102 - ReplaceComparisonOperator >= -> -1
   * 41 Weak Mutation 68: de.susebox.jtopas.FullIterator.remove()V:1103 - DeleteField: _currIndexI
   * 42 Weak Mutation 69: de.susebox.jtopas.FullIterator.remove()V:1104 - DeleteStatement: remove()V
   * 43 Weak Mutation 64: de.susebox.jtopas.FullIterator.remove()V:1103 - DeleteField: _iterators[Ljava/lang/Object;
   * 44 Weak Mutation 65: de.susebox.jtopas.FullIterator.remove()V:1103 - InsertUnaryOp Negation
   * 45 Weak Mutation 66: de.susebox.jtopas.FullIterator.remove()V:1103 - InsertUnaryOp +1
   * 46 Weak Mutation 67: de.susebox.jtopas.FullIterator.remove()V:1103 - InsertUnaryOp -1
   * 47 de.susebox.jtopas.FullIterator.remove()V: I7 Branch 4 IF_ICMPGE L1102 - false
   * 48 de.susebox.jtopas.FullIterator.hasNext()Z: I27 Branch 2 IFEQ L1069 - false
   * 49 de.susebox.jtopas.FullIterator.next()Ljava/lang/Object;: I4 Branch 3 IFEQ L1085 - false
   */
  @Test
  public void test1()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      FullIterator fullIterator0 = new FullIterator(standardTokenizerProperties0);
      standardTokenizerProperties0.addString("kWu", "kWu", "kWu");
      fullIterator0.next();
      fullIterator0.remove();
      assertEquals(false, fullIterator0.hasNext());
  }
}