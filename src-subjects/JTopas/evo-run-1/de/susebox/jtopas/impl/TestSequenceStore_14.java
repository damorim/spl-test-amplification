/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.impl.SequenceStore;
import de.susebox.jtopas.spi.DataProvider;
import java.util.Iterator;
import java.util.NoSuchElementException;

@RunWith(EvoSuiteRunner.class)
public class TestSequenceStore_14 {


  //Test case number: 14
  /*
   * 17 covered goals:
   * 1 Weak Mutation 18: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.listHasNext()Z:576 - ReplaceComparisonOperator == -> -2
   * 2 Weak Mutation 29: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.listHasNext()Z:577 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 68: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.hasNext()Z:611 - ReplaceConstant - 1 -> 0
   * 4 Weak Mutation 76: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:638 - DeleteField: _currentListLde/susebox/jtopas/impl/SequenceStore$PropertyList;
   * 5 Weak Mutation 77: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:639 - DeleteField: _currentListLde/susebox/jtopas/impl/SequenceStore$PropertyList;
   * 6 Weak Mutation 79: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:640 - DeleteField: _currentElemLde/susebox/jtopas/impl/SequenceStore$PropertyList;
   * 7 Weak Mutation 80: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:640 - DeleteField: _propertyLde/susebox/jtopas/TokenizerProperty;
   * 8 de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.listHasNext()Z: I9 Branch 2 IFEQ L576 - true
   * 9 de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.hasNext()Z: I70 Branch 11 IFEQ L610 - false
   * 10 de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;: I4 Branch 13 IFNE L634 - true
   * 11 Weak Mutation 18: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.listHasNext()Z:576 - ReplaceComparisonOperator == -> -2
   * 12 Weak Mutation 29: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.listHasNext()Z:577 - ReplaceConstant - 1 -> 0
   * 13 Weak Mutation 68: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.hasNext()Z:611 - ReplaceConstant - 1 -> 0
   * 14 Weak Mutation 76: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:638 - DeleteField: _currentListLde/susebox/jtopas/impl/SequenceStore$PropertyList;
   * 15 Weak Mutation 77: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:639 - DeleteField: _currentListLde/susebox/jtopas/impl/SequenceStore$PropertyList;
   * 16 Weak Mutation 79: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:640 - DeleteField: _currentElemLde/susebox/jtopas/impl/SequenceStore$PropertyList;
   * 17 Weak Mutation 80: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.next()Ljava/lang/Object;:640 - DeleteField: _propertyLde/susebox/jtopas/TokenizerProperty;
   */
  @Test
  public void test14()  throws Throwable  {
      SequenceStore sequenceStore0 = new SequenceStore(true);
      String[] stringArray0 = new String[7];
      stringArray0[0] = "O/tkJ\"cZ";
      Object object0 = new Object();
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(0, stringArray0, object0, (-1061), (-644));
      sequenceStore0.addSpecialSequence(tokenizerProperty0);
      SequenceStore.SpecialSequencesIterator sequenceStore_SpecialSequencesIterator0 = sequenceStore0.new SpecialSequencesIterator(sequenceStore0, 0);
      sequenceStore_SpecialSequencesIterator0.next();
      assertEquals(8, sequenceStore0.getSequenceMaxLength());
  }
}
