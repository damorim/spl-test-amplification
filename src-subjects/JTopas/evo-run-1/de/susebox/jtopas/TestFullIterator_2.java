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
public class TestFullIterator_2 {


  //Test case number: 2
  /*
   * 33 covered goals:
   * 1 Weak Mutation 63: de.susebox.jtopas.FullIterator.remove()V:1102 - ReplaceComparisonOperator >= -> -1
   * 2 Weak Mutation 64: de.susebox.jtopas.FullIterator.remove()V:1103 - DeleteField: _iterators[Ljava/lang/Object;
   * 3 Weak Mutation 65: de.susebox.jtopas.FullIterator.remove()V:1103 - InsertUnaryOp Negation
   * 4 Weak Mutation 66: de.susebox.jtopas.FullIterator.remove()V:1103 - InsertUnaryOp +1
   * 5 Weak Mutation 67: de.susebox.jtopas.FullIterator.remove()V:1103 - InsertUnaryOp -1
   * 6 Weak Mutation 69: de.susebox.jtopas.FullIterator.remove()V:1104 - DeleteStatement: remove()V
   * 7 de.susebox.jtopas.FullIterator.remove()V: I7 Branch 4 IF_ICMPGE L1102 - false
   * 8 Weak Mutation 0: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1112 - ReplaceConstant - -1 -> 0
   * 9 Weak Mutation 1: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1112 - ReplaceConstant - -1 -> 1
   * 10 Weak Mutation 2: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1112 - ReplaceConstant - -1 -> -2
   * 11 Weak Mutation 3: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1050 - ReplaceConstant - 3 -> 0
   * 12 Weak Mutation 4: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1050 - ReplaceConstant - 3 -> 1
   * 13 Weak Mutation 5: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1050 - ReplaceConstant - 3 -> -1
   * 14 Weak Mutation 6: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1050 - ReplaceConstant - 3 -> 2
   * 15 Weak Mutation 7: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1050 - ReplaceConstant - 3 -> 4
   * 16 Weak Mutation 8: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1051 - DeleteField: _iterators[Ljava/lang/Object;
   * 17 Weak Mutation 9: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1051 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 10: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1051 - DeleteField: _keywords[Lde/susebox/jtopas/impl/SequenceStore;
   * 19 Weak Mutation 11: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1051 - ReplaceConstant - 1 -> 0
   * 20 Weak Mutation 12: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1052 - DeleteField: _iterators[Ljava/lang/Object;
   * 21 Weak Mutation 13: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1052 - ReplaceConstant - 1 -> 0
   * 22 Weak Mutation 14: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1052 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 23 Weak Mutation 15: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1052 - ReplaceConstant - 0 -> 1
   * 24 Weak Mutation 17: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1053 - ReplaceConstant - 2 -> 0
   * 25 Weak Mutation 16: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1053 - DeleteField: _iterators[Ljava/lang/Object;
   * 26 Weak Mutation 19: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1053 - ReplaceConstant - 2 -> -1
   * 27 Weak Mutation 18: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1053 - ReplaceConstant - 2 -> 1
   * 28 Weak Mutation 21: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1054 - ReplaceConstant - 0 -> 1
   * 29 Weak Mutation 20: de.susebox.jtopas.FullIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:1053 - ReplaceConstant - 2 -> 3
   * 30 Weak Mutation 58: de.susebox.jtopas.FullIterator.remove()V:1102 - InsertUnaryOp -1
   * 31 Weak Mutation 57: de.susebox.jtopas.FullIterator.remove()V:1102 - InsertUnaryOp +1
   * 32 Weak Mutation 56: de.susebox.jtopas.FullIterator.remove()V:1102 - InsertUnaryOp Negation
   * 33 Weak Mutation 60: de.susebox.jtopas.FullIterator.remove()V:1102 - DeleteField: _iterators[Ljava/lang/Object;
   */
  @Test
  public void test2()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      FullIterator fullIterator0 = new FullIterator(standardTokenizerProperties0);
      // Undeclared exception!
      try {
        fullIterator0.remove();
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
      }
      assertEquals(false, fullIterator0.hasNext());
  }
}
