/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizerProperties_43 {


  //Test case number: 43
  /*
   * 18 covered goals:
   * 1 Weak Mutation 541: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - DeleteStatement: remove(Ljava/lang/Object;)Ljava/lang/Object;
   * 2 Weak Mutation 540: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - InsertUnaryOp IINC -1
   * 3 Weak Mutation 539: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 538: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - InsertUnaryOp Negation
   * 5 de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V: I66 Branch 48 IFEQ L1359 - false
   * 6 Weak Mutation 88: de.susebox.jtopas.AbstractTokenizerProperties.setWhitespaces(Ljava/lang/String;)V:265 - ReplaceComparisonOperator == -> >=
   * 7 Weak Mutation 91: de.susebox.jtopas.AbstractTokenizerProperties.setWhitespaces(Ljava/lang/String;)V:266 - DeleteStatement: toUpperCase()Ljava/lang/String;
   * 8 Weak Mutation 124: de.susebox.jtopas.AbstractTokenizerProperties.setSeparators(Ljava/lang/String;)V:329 - DeleteStatement: toUpperCase()Ljava/lang/String;
   * 9 Weak Mutation 121: de.susebox.jtopas.AbstractTokenizerProperties.setSeparators(Ljava/lang/String;)V:328 - ReplaceComparisonOperator == -> >=
   * 10 Weak Mutation 143: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:368 - DeleteStatement: getSeparators()Ljava/lang/String;
   * 11 Weak Mutation 142: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:367 - ReplaceComparisonOperator <= -> -1
   * 12 Weak Mutation 144: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:368 - ReplaceConstant - 1 -> 0
   * 13 Weak Mutation 145: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:368 - DeleteStatement: setSeparators(Ljava/lang/String;)V
   * 14 Weak Mutation 541: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - DeleteStatement: remove(Ljava/lang/Object;)Ljava/lang/Object;
   * 15 Weak Mutation 540: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - InsertUnaryOp IINC -1
   * 16 Weak Mutation 539: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - InsertUnaryOp IINC 1
   * 17 Weak Mutation 538: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1360 - InsertUnaryOp Negation
   * 18 de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V: I4 Branch 10 IFLE L367 - false
   */
  @Test
  public void test43()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-763));
      assertNotNull(standardTokenizerProperties0);
      
      standardTokenizerProperties0.removeSeparators("!#-%'-/:=-@[-^{-~");
      assertEquals("&;<`", standardTokenizerProperties0.getSeparators());
  }
}
