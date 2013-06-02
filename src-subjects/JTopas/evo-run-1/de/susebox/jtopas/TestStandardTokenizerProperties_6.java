/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.java.lang.ExtIllegalArgumentException;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;

@RunWith(EvoSuiteRunner.class)
public class TestStandardTokenizerProperties_6 {


  //Test case number: 6
  /*
   * 72 covered goals:
   * 1 Weak Mutation 163: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:322 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 162: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:322 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 161: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:322 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 4 Weak Mutation 170: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - ReplaceComparisonOperator = null -> != null
   * 5 Weak Mutation 169: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 168: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 7 Weak Mutation 167: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - ReplaceComparisonOperator != null -> = null
   * 8 Weak Mutation 171: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:326 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 9 Weak Mutation 173: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:326 - DeleteStatement: removeSpecialSequence(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 10 Weak Mutation 172: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:326 - ReplaceConstant - 1 -> 0
   * 11 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I7 Branch 8 TABLESWITCH L164 Case 8 - true
   * 12 de.susebox.jtopas.StandardTokenizerProperties.doAddProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I4 Branch 34 TABLESWITCH L284 Case 7 - true
   * 13 de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I15 Branch 43 TABLESWITCH L317 Case 7 - true
   * 14 de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I22 Branch 46 IFNULL L322 - true
   * 15 de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I35 Branch 47 IFNONNULL L325 - false
   * 16 de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I40 Branch 48 IFNULL L325 - false
   * 17 Weak Mutation 51: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:182 - ReplaceConstant - 1 -> 0
   * 18 Weak Mutation 50: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:182 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 19 Weak Mutation 52: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:182 - DeleteStatement: getSpecialSequence(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 20 Weak Mutation 42: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:178 - ReplaceComparisonOperator = null -> != null
   * 21 Weak Mutation 40: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:178 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 22 Weak Mutation 41: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:178 - ReplaceConstant - 0 -> 1
   * 23 Weak Mutation 46: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:181 - ReplaceComparisonOperator != null -> = null
   * 24 Weak Mutation 47: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:181 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 25 Weak Mutation 51: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:182 - ReplaceConstant - 1 -> 0
   * 26 Weak Mutation 50: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:182 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 27 Weak Mutation 49: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:181 - ReplaceComparisonOperator = null -> != null
   * 28 Weak Mutation 48: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:181 - ReplaceConstant - 1 -> 0
   * 29 Weak Mutation 52: de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;:182 - DeleteStatement: getSpecialSequence(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 30 Weak Mutation 145: de.susebox.jtopas.StandardTokenizerProperties.doAddProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:289 - DeleteStatement: addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;
   * 31 Weak Mutation 171: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:326 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 32 Weak Mutation 170: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - ReplaceComparisonOperator = null -> != null
   * 33 Weak Mutation 169: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - ReplaceConstant - 1 -> 0
   * 34 Weak Mutation 168: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 35 Weak Mutation 173: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:326 - DeleteStatement: removeSpecialSequence(Ljava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;
   * 36 Weak Mutation 172: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:326 - ReplaceConstant - 1 -> 0
   * 37 Weak Mutation 163: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:322 - ReplaceComparisonOperator = null -> != null
   * 38 Weak Mutation 162: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:322 - ReplaceConstant - 0 -> 1
   * 39 Weak Mutation 161: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:322 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 40 Weak Mutation 167: de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:325 - ReplaceComparisonOperator != null -> = null
   * 41 Weak Mutation 516: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:850 - InsertUnaryOp IINC -1
   * 42 Weak Mutation 517: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:850 - ReplaceComparisonOperator == -> !=
   * 43 Weak Mutation 518: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:850 - ReplaceConstant - 1 -> 0
   * 44 Weak Mutation 512: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:849 - ReplaceConstant - 1 -> 0
   * 45 Weak Mutation 513: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:849 - DeleteStatement: isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z
   * 46 Weak Mutation 514: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:850 - InsertUnaryOp Negation
   * 47 Weak Mutation 515: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:850 - InsertUnaryOp IINC 1
   * 48 Weak Mutation 524: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:853 - ReplaceComparisonOperator != null -> = null
   * 49 Weak Mutation 525: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:854 - InsertUnaryOp Negation
   * 50 Weak Mutation 526: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:854 - ReplaceComparisonOperator == -> !=
   * 51 Weak Mutation 527: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:855 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 52 Weak Mutation 520: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:853 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 53 Weak Mutation 521: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:853 - InsertUnaryOp Negation
   * 54 Weak Mutation 522: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:853 - InsertUnaryOp IINC 1
   * 55 Weak Mutation 523: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:853 - InsertUnaryOp IINC -1
   * 56 Weak Mutation 529: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:855 - InsertUnaryOp IINC 1
   * 57 Weak Mutation 528: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:855 - InsertUnaryOp Negation
   * 58 Weak Mutation 531: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:855 - ReplaceConstant - 0 -> 1
   * 59 Weak Mutation 530: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:855 - InsertUnaryOp IINC -1
   * 60 Weak Mutation 541: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:862 - DeleteStatement: addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;
   * 61 Weak Mutation 540: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:862 - InsertUnaryOp IINC -1
   * 62 Weak Mutation 537: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:862 - DeleteField: _sequences[Lde/susebox/jtopas/impl/SequenceStore;
   * 63 Weak Mutation 539: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:862 - InsertUnaryOp IINC 1
   * 64 Weak Mutation 538: de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;:862 - InsertUnaryOp Negation
   * 65 de.susebox.jtopas.StandardTokenizerProperties.doRemoveProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I15 Branch 37 TABLESWITCH L317 Case 1 - false
   * 66 de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I10 Branch 89 IFEQ L850 - false
   * 67 de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I23 Branch 90 IFNONNULL L853 - false
   * 68 de.susebox.jtopas.StandardTokenizerProperties.addSpecialSequence(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;: I27 Branch 91 IFEQ L854 - false
   * 69 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I7 Branch 1 TABLESWITCH L164 Case 1 - false
   * 70 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I49 Branch 13 IFNULL L178 - true
   * 71 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I62 Branch 14 IFNONNULL L181 - false
   * 72 de.susebox.jtopas.StandardTokenizerProperties.doGetProperty(ILjava/lang/String;)Lde/susebox/jtopas/TokenizerProperty;: I67 Branch 15 IFNULL L181 - false
   */
  @Test
  public void test6()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-1745));
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.addLineComment("#tCrSVAnQGD", (Object) null, (-1745));
      standardTokenizerProperties0.removeBlockComment("#tCrSVAnQGD");
      assertEquals(11, standardTokenizerProperties0.getSequenceMaxLength());
      assertEquals(true, standardTokenizerProperties0.newlineIsWhitespace());
  }
}