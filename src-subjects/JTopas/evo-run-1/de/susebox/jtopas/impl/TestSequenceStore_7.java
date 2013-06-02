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

@RunWith(EvoSuiteRunner.class)
public class TestSequenceStore_7 {


  //Test case number: 7
  /*
   * 23 covered goals:
   * 1 Weak Mutation 201: de.susebox.jtopas.impl.SequenceStore.getKeywords()Ljava/util/Iterator;:301 - ReplaceConstant - 1 -> 0
   * 2 Weak Mutation 202: de.susebox.jtopas.impl.SequenceStore.getKeywords()Ljava/util/Iterator;:301 - DeleteStatement: getSpecialSequences(I)Ljava/util/Iterator;
   * 3 de.susebox.jtopas.impl.SequenceStore.getKeywords()Ljava/util/Iterator;: root-Branch
   * 4 Weak Mutation 197: de.susebox.jtopas.impl.SequenceStore.getSpecialSequences(I)Ljava/util/Iterator;:259 - InsertUnaryOp IINC -1
   * 5 Weak Mutation 196: de.susebox.jtopas.impl.SequenceStore.getSpecialSequences(I)Ljava/util/Iterator;:259 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 195: de.susebox.jtopas.impl.SequenceStore.getSpecialSequences(I)Ljava/util/Iterator;:259 - InsertUnaryOp Negation
   * 7 Weak Mutation 0: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:666 - ReplaceConstant - -2 -> 0
   * 8 Weak Mutation 1: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:666 - ReplaceConstant - -2 -> 1
   * 9 Weak Mutation 2: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:666 - ReplaceConstant - -2 -> -1
   * 10 Weak Mutation 3: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:666 - ReplaceConstant - -2 -> -3
   * 11 Weak Mutation 4: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:668 - ReplaceConstant - -1 -> 0
   * 12 Weak Mutation 5: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:668 - ReplaceConstant - -1 -> 1
   * 13 Weak Mutation 6: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:668 - ReplaceConstant - -1 -> -2
   * 14 Weak Mutation 7: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:562 - InsertUnaryOp Negation
   * 15 Weak Mutation 8: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:562 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 9: de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V:562 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 201: de.susebox.jtopas.impl.SequenceStore.getKeywords()Ljava/util/Iterator;:301 - ReplaceConstant - 1 -> 0
   * 18 Weak Mutation 202: de.susebox.jtopas.impl.SequenceStore.getKeywords()Ljava/util/Iterator;:301 - DeleteStatement: getSpecialSequences(I)Ljava/util/Iterator;
   * 19 Weak Mutation 197: de.susebox.jtopas.impl.SequenceStore.getSpecialSequences(I)Ljava/util/Iterator;:259 - InsertUnaryOp IINC -1
   * 20 Weak Mutation 196: de.susebox.jtopas.impl.SequenceStore.getSpecialSequences(I)Ljava/util/Iterator;:259 - InsertUnaryOp IINC 1
   * 21 Weak Mutation 195: de.susebox.jtopas.impl.SequenceStore.getSpecialSequences(I)Ljava/util/Iterator;:259 - InsertUnaryOp Negation
   * 22 de.susebox.jtopas.impl.SequenceStore.getSpecialSequences(I)Ljava/util/Iterator;: root-Branch
   * 23 de.susebox.jtopas.impl.SequenceStore$SpecialSequencesIterator.<init>(Lde/susebox/jtopas/impl/SequenceStore;Lde/susebox/jtopas/impl/SequenceStore;I)V: root-Branch
   */
  @Test
  public void test7()  throws Throwable  {
      SequenceStore sequenceStore0 = new SequenceStore(true);
      Iterator<?> iterator0 = sequenceStore0.getKeywords();
      assertEquals(false, sequenceStore0.hasSequenceCommentOrString());
      assertNotNull(iterator0);
      assertEquals(0, sequenceStore0.getSequenceMaxLength());
  }
}
