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
public class TestSequenceStore_10 {


  //Test case number: 10
  /*
   * 24 covered goals:
   * 1 Weak Mutation 246: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - ReplaceComparisonOperator >= -> ==
   * 2 Weak Mutation 253: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:352 - ReplaceComparisonOperator = null -> != null
   * 3 de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;: I72 Branch 30 IF_ICMPGE L350 - true
   * 4 de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;: I84 Branch 31 IFNULL L352 - true
   * 5 Weak Mutation 239: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - ReplaceComparisonOperator < -> !=
   * 6 Weak Mutation 238: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 237: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - InsertUnaryOp IINC 1
   * 8 Weak Mutation 236: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - InsertUnaryOp Negation
   * 9 Weak Mutation 233: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:346 - ReplaceComparisonOperator = null -> != null
   * 10 Weak Mutation 232: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:345 - ReplaceComparisonOperator == -> !=
   * 11 Weak Mutation 231: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:345 - InsertUnaryOp IINC -1
   * 12 Weak Mutation 230: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:345 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 229: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:345 - InsertUnaryOp Negation
   * 14 Weak Mutation 228: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:344 - ReplaceComparisonOperator != -> -1
   * 15 Weak Mutation 253: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:352 - ReplaceComparisonOperator = null -> != null
   * 16 Weak Mutation 246: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - ReplaceComparisonOperator >= -> ==
   * 17 Weak Mutation 244: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - InsertUnaryOp IINC -1
   * 18 Weak Mutation 245: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - DeleteField: DIRECT_INDEX_COUNTC
   * 19 Weak Mutation 242: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - InsertUnaryOp Negation
   * 20 Weak Mutation 243: de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;:350 - InsertUnaryOp IINC 1
   * 21 de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;: I45 Branch 26 IFNE L344 - false
   * 22 de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;: I49 Branch 27 IFEQ L345 - false
   * 23 de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;: I53 Branch 28 IFNULL L346 - true
   * 24 de.susebox.jtopas.impl.SequenceStore.searchString(Ljava/lang/String;Z)Lde/susebox/jtopas/TokenizerProperty;: I69 Branch 29 IFLT L350 - false
   */
  @Test
  public void test10()  throws Throwable  {
      SequenceStore sequenceStore0 = new SequenceStore(true);
      String[] stringArray0 = new String[1];
      stringArray0[0] = "k0x)!";
      SequenceStore.PropertyList sequenceStore_PropertyList0 = sequenceStore0.new PropertyList((TokenizerProperty) null);
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(1119, stringArray0, (Object) sequenceStore_PropertyList0, 1119, 1119);
      sequenceStore0.addKeyword(tokenizerProperty0);
      sequenceStore0.removeKeyword("k0x)!");
      assertEquals(true, sequenceStore0.hasKeywords());
      assertEquals(5, sequenceStore0.getSequenceMaxLength());
  }
}