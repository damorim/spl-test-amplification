/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.MapIterator;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import java.util.HashMap;
import java.util.Map;

@RunWith(EvoSuiteRunner.class)
public class TestMapIterator_0 {


  //Test case number: 0
  /*
   * 74 covered goals:
   * 1 Weak Mutation 58: de.susebox.jtopas.MapIterator.remove()V:1206 - DeleteStatement: remove()V
   * 2 Weak Mutation 57: de.susebox.jtopas.MapIterator.remove()V:1206 - ReplaceConstant - 1 -> 0
   * 3 Weak Mutation 56: de.susebox.jtopas.MapIterator.remove()V:1206 - DeleteField: _iterators[Ljava/util/Iterator;
   * 4 de.susebox.jtopas.MapIterator.remove()V: I23 Branch 10 IFNULL L1203 - true
   * 5 Weak Mutation 0: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1215 - ReplaceConstant - 2 -> 0
   * 6 Weak Mutation 1: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1215 - ReplaceConstant - 2 -> 1
   * 7 Weak Mutation 2: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1215 - ReplaceConstant - 2 -> -1
   * 8 Weak Mutation 3: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1215 - ReplaceConstant - 2 -> 3
   * 9 Weak Mutation 4: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1133 - ReplaceComparisonOperator = null -> != null
   * 10 Weak Mutation 5: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1134 - DeleteField: _iterators[Ljava/util/Iterator;
   * 11 Weak Mutation 6: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1134 - ReplaceConstant - 0 -> 1
   * 12 Weak Mutation 7: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1134 - DeleteStatement: values()Ljava/util/Collection;
   * 13 Weak Mutation 8: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1134 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 14 Weak Mutation 9: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1136 - ReplaceComparisonOperator = null -> != null
   * 15 Weak Mutation 10: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1137 - DeleteField: _iterators[Ljava/util/Iterator;
   * 16 Weak Mutation 11: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1137 - ReplaceConstant - 1 -> 0
   * 17 Weak Mutation 12: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1137 - DeleteStatement: values()Ljava/util/Collection;
   * 18 Weak Mutation 13: de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V:1137 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 19 Weak Mutation 14: de.susebox.jtopas.MapIterator.hasNext()Z:1150 - DeleteField: _iterators[Ljava/util/Iterator;
   * 20 Weak Mutation 15: de.susebox.jtopas.MapIterator.hasNext()Z:1151 - DeleteField: _iterators[Ljava/util/Iterator;
   * 21 Weak Mutation 17: de.susebox.jtopas.MapIterator.hasNext()Z:1151 - ReplaceComparisonOperator = null -> != null
   * 22 Weak Mutation 16: de.susebox.jtopas.MapIterator.hasNext()Z:1151 - ReplaceConstant - 0 -> 1
   * 23 Weak Mutation 19: de.susebox.jtopas.MapIterator.hasNext()Z:1152 - ReplaceConstant - 0 -> 1
   * 24 Weak Mutation 18: de.susebox.jtopas.MapIterator.hasNext()Z:1152 - DeleteField: _iterators[Ljava/util/Iterator;
   * 25 Weak Mutation 21: de.susebox.jtopas.MapIterator.hasNext()Z:1152 - ReplaceComparisonOperator == -> !=
   * 26 Weak Mutation 20: de.susebox.jtopas.MapIterator.hasNext()Z:1152 - DeleteStatement: hasNext()Z
   * 27 Weak Mutation 23: de.susebox.jtopas.MapIterator.hasNext()Z:1155 - DeleteField: _iterators[Ljava/util/Iterator;
   * 28 Weak Mutation 22: de.susebox.jtopas.MapIterator.hasNext()Z:1153 - ReplaceConstant - 1 -> 0
   * 29 Weak Mutation 25: de.susebox.jtopas.MapIterator.hasNext()Z:1158 - DeleteField: _iterators[Ljava/util/Iterator;
   * 30 Weak Mutation 24: de.susebox.jtopas.MapIterator.hasNext()Z:1155 - ReplaceConstant - 0 -> 1
   * 31 Weak Mutation 27: de.susebox.jtopas.MapIterator.hasNext()Z:1158 - ReplaceComparisonOperator = null -> != null
   * 32 Weak Mutation 26: de.susebox.jtopas.MapIterator.hasNext()Z:1158 - ReplaceConstant - 1 -> 0
   * 33 Weak Mutation 29: de.susebox.jtopas.MapIterator.hasNext()Z:1159 - ReplaceConstant - 1 -> 0
   * 34 Weak Mutation 28: de.susebox.jtopas.MapIterator.hasNext()Z:1159 - DeleteField: _iterators[Ljava/util/Iterator;
   * 35 Weak Mutation 31: de.susebox.jtopas.MapIterator.hasNext()Z:1159 - ReplaceComparisonOperator == -> !=
   * 36 Weak Mutation 30: de.susebox.jtopas.MapIterator.hasNext()Z:1159 - DeleteStatement: hasNext()Z
   * 37 Weak Mutation 32: de.susebox.jtopas.MapIterator.hasNext()Z:1160 - ReplaceConstant - 1 -> 0
   * 38 Weak Mutation 38: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1181 - DeleteField: _iterators[Ljava/util/Iterator;
   * 39 Weak Mutation 39: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1181 - ReplaceConstant - 0 -> 1
   * 40 Weak Mutation 36: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1176 - DeleteStatement: hasNext()Z
   * 41 Weak Mutation 37: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1176 - ReplaceComparisonOperator != -> ==
   * 42 Weak Mutation 42: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1182 - ReplaceConstant - 0 -> 1
   * 43 Weak Mutation 43: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1182 - DeleteStatement: next()Ljava/lang/Object;
   * 44 Weak Mutation 40: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1181 - ReplaceComparisonOperator = null -> != null
   * 45 Weak Mutation 41: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1182 - DeleteField: _iterators[Ljava/util/Iterator;
   * 46 Weak Mutation 46: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1184 - DeleteStatement: next()Ljava/lang/Object;
   * 47 Weak Mutation 47: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1186 - DeleteField: _currentDataLde/susebox/jtopas/TokenizerProperty;
   * 48 Weak Mutation 44: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1184 - DeleteField: _iterators[Ljava/util/Iterator;
   * 49 Weak Mutation 45: de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;:1184 - ReplaceConstant - 1 -> 0
   * 50 Weak Mutation 51: de.susebox.jtopas.MapIterator.remove()V:1203 - ReplaceConstant - 0 -> 1
   * 51 Weak Mutation 50: de.susebox.jtopas.MapIterator.remove()V:1203 - DeleteField: _iterators[Ljava/util/Iterator;
   * 52 Weak Mutation 49: de.susebox.jtopas.MapIterator.remove()V:1199 - ReplaceComparisonOperator != null -> = null
   * 53 Weak Mutation 48: de.susebox.jtopas.MapIterator.remove()V:1199 - DeleteField: _currentDataLde/susebox/jtopas/TokenizerProperty;
   * 54 Weak Mutation 52: de.susebox.jtopas.MapIterator.remove()V:1203 - ReplaceComparisonOperator = null -> != null
   * 55 Weak Mutation 58: de.susebox.jtopas.MapIterator.remove()V:1206 - DeleteStatement: remove()V
   * 56 Weak Mutation 57: de.susebox.jtopas.MapIterator.remove()V:1206 - ReplaceConstant - 1 -> 0
   * 57 Weak Mutation 56: de.susebox.jtopas.MapIterator.remove()V:1206 - DeleteField: _iterators[Ljava/util/Iterator;
   * 58 Weak Mutation 63: de.susebox.jtopas.MapIterator.remove()V:1208 - ReplaceConstant - 2 -> 3
   * 59 Weak Mutation 62: de.susebox.jtopas.MapIterator.remove()V:1208 - ReplaceConstant - 2 -> -1
   * 60 Weak Mutation 61: de.susebox.jtopas.MapIterator.remove()V:1208 - ReplaceConstant - 2 -> 1
   * 61 Weak Mutation 60: de.susebox.jtopas.MapIterator.remove()V:1208 - ReplaceConstant - 2 -> 0
   * 62 Weak Mutation 64: de.susebox.jtopas.MapIterator.remove()V:1208 - DeleteField: _currentDataLde/susebox/jtopas/TokenizerProperty;
   * 63 Weak Mutation 65: de.susebox.jtopas.MapIterator.remove()V:1208 - DeleteStatement: notifyListeners(Lde/susebox/jtopas/TokenizerPropertyEvent;)V
   * 64 de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V: I34 Branch 1 IFNULL L1133 - false
   * 65 de.susebox.jtopas.MapIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;Ljava/util/Map;Ljava/util/Map;)V: I47 Branch 2 IFNULL L1136 - false
   * 66 de.susebox.jtopas.MapIterator.remove()V: I10 Branch 9 IFNONNULL L1199 - true
   * 67 de.susebox.jtopas.MapIterator.hasNext()Z: I13 Branch 3 IFNULL L1151 - false
   * 68 de.susebox.jtopas.MapIterator.hasNext()Z: I21 Branch 4 IFEQ L1152 - true
   * 69 de.susebox.jtopas.MapIterator.hasNext()Z: I21 Branch 4 IFEQ L1152 - false
   * 70 de.susebox.jtopas.MapIterator.hasNext()Z: I42 Branch 5 IFNULL L1158 - false
   * 71 de.susebox.jtopas.MapIterator.hasNext()Z: I50 Branch 6 IFEQ L1159 - false
   * 72 de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;: I4 Branch 7 IFNE L1176 - true
   * 73 de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;: I23 Branch 8 IFNULL L1181 - true
   * 74 de.susebox.jtopas.MapIterator.next()Ljava/lang/Object;: I23 Branch 8 IFNULL L1181 - false
   */
  @Test
  public void test0()  throws Throwable  {
      HashMap<TokenizerProperty, TokenizerProperty> hashMap0 = new HashMap<TokenizerProperty, TokenizerProperty>();
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty();
      hashMap0.put(tokenizerProperty0, tokenizerProperty0);
      MapIterator mapIterator0 = new MapIterator((StandardTokenizerProperties) null, (Map) hashMap0, (Map) hashMap0);
      assertNotNull(mapIterator0);
      
      TokenizerProperty tokenizerProperty1 = (TokenizerProperty)mapIterator0.next();
      assertNotNull(tokenizerProperty1);
      
      mapIterator0.next();
      // Undeclared exception!
      try {
        mapIterator0.remove();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}