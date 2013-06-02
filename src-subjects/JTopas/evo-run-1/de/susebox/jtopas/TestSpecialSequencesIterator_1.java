/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.SpecialSequencesIterator;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.impl.SequenceStore;
import java.util.NoSuchElementException;

@RunWith(EvoSuiteRunner.class)
public class TestSpecialSequencesIterator_1 {


  //Test case number: 1
  /*
   * 21 covered goals:
   * 1 Weak Mutation 15: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:51 - ReplaceConstant - 1 -> 0
   * 2 Weak Mutation 50: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:58 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 53: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:74 - ReplaceComparisonOperator != -> ==
   * 4 Weak Mutation 52: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:74 - DeleteStatement: hasNext()Z
   * 5 Weak Mutation 55: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:77 - DeleteStatement: next()Ljava/lang/Object;
   * 6 Weak Mutation 54: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:77 - DeleteField: _currentIteratorLjava/util/Iterator;
   * 7 Weak Mutation 56: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:78 - DeleteField: _currentElementLde/susebox/jtopas/TokenizerProperty;
   * 8 de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z: I14 Branch 2 IFEQ L50 - false
   * 9 de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z: I63 Branch 6 IFEQ L57 - false
   * 10 de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;: I10 Branch 7 IFNE L74 - true
   * 11 Weak Mutation 10: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:50 - DeleteField: _currentIteratorLjava/util/Iterator;
   * 12 Weak Mutation 12: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:50 - DeleteField: _currentIteratorLjava/util/Iterator;
   * 13 Weak Mutation 13: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:50 - DeleteStatement: hasNext()Z
   * 14 Weak Mutation 14: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:50 - ReplaceComparisonOperator == -> !=
   * 15 Weak Mutation 15: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:51 - ReplaceConstant - 1 -> 0
   * 16 Weak Mutation 50: de.susebox.jtopas.SpecialSequencesIterator.hasNext()Z:58 - ReplaceConstant - 1 -> 0
   * 17 Weak Mutation 55: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:77 - DeleteStatement: next()Ljava/lang/Object;
   * 18 Weak Mutation 54: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:77 - DeleteField: _currentIteratorLjava/util/Iterator;
   * 19 Weak Mutation 53: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:74 - ReplaceComparisonOperator != -> ==
   * 20 Weak Mutation 52: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:74 - DeleteStatement: hasNext()Z
   * 21 Weak Mutation 56: de.susebox.jtopas.SpecialSequencesIterator.next()Ljava/lang/Object;:78 - DeleteField: _currentElementLde/susebox/jtopas/TokenizerProperty;
   */
  @Test
  public void test1()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      SequenceStore[] sequenceStoreArray0 = new SequenceStore[5];
      SequenceStore sequenceStore0 = new SequenceStore(true);
      sequenceStoreArray0[3] = sequenceStore0;
      SpecialSequencesIterator specialSequencesIterator0 = new SpecialSequencesIterator(standardTokenizerProperties0, sequenceStoreArray0, 0);
      String[] stringArray0 = new String[15];
      stringArray0[0] = "x0/d$";
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty((int) 'y', stringArray0);
      sequenceStoreArray0[3].addKeyword(tokenizerProperty0);
      boolean boolean0 = specialSequencesIterator0.hasNext();
      assertEquals(false, boolean0);
      
      specialSequencesIterator0.next();
  }
}