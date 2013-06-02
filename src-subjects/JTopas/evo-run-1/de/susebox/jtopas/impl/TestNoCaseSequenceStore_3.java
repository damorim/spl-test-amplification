/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.impl.NoCaseSequenceStore;

@RunWith(EvoSuiteRunner.class)
public class TestNoCaseSequenceStore_3 {


  //Test case number: 3
  /*
   * 18 covered goals:
   * 1 Weak Mutation 19: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:90 - ReplaceComparisonOperator == -> -2
   * 2 de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I: I9 Branch 1 IFEQ L90 - true
   * 3 Weak Mutation 4: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - InsertUnaryOp Negation
   * 4 Weak Mutation 5: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 6: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - InsertUnaryOp IINC -1
   * 6 Weak Mutation 7: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - InsertUnaryOp Negation
   * 7 Weak Mutation 8: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 9: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - InsertUnaryOp IINC -1
   * 9 Weak Mutation 10: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - ReplaceArithmeticOperator - -> +
   * 10 Weak Mutation 12: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - ReplaceArithmeticOperator - -> /
   * 11 Weak Mutation 13: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:88 - ReplaceArithmeticOperator - -> *
   * 12 Weak Mutation 14: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:90 - InsertUnaryOp Negation
   * 13 Weak Mutation 15: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:90 - InsertUnaryOp IINC 1
   * 14 Weak Mutation 16: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:90 - InsertUnaryOp IINC -1
   * 15 Weak Mutation 34: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:93 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 32: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:93 - InsertUnaryOp Negation
   * 17 Weak Mutation 33: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:93 - InsertUnaryOp IINC 1
   * 18 Weak Mutation 19: de.susebox.jtopas.impl.NoCaseSequenceStore.compare(CC)I:90 - ReplaceComparisonOperator == -> -2
   */
  @Test
  public void test3()  throws Throwable  {
      NoCaseSequenceStore noCaseSequenceStore0 = new NoCaseSequenceStore(false);
      int int0 = noCaseSequenceStore0.compare(':', ':');
      assertEquals(0, int0);
  }
}