/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.util.AddDoubles;

@RunWith(EvoSuiteRunner.class)
public class TestAddDoubles_1 {


  //Test case number: 1
  /*
   * 12 covered goals:
   * 1 Weak Mutation 8: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - ReplaceArithmeticOperator + -> -
   * 2 Weak Mutation 11: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - ReplaceArithmeticOperator + -> *
   * 3 Weak Mutation 0: org.softlang.util.AddDoubles.getInstance()Lorg/softlang/util/AddDoubles;:10 - DeleteField: instanceLorg/softlang/util/AddDoubles;
   * 4 Weak Mutation 1: org.softlang.util.AddDoubles.getInstance()Lorg/softlang/util/AddDoubles;:10 - ReplaceComparisonOperator != null -> = null
   * 5 Weak Mutation 2: org.softlang.util.AddDoubles.getInstance()Lorg/softlang/util/AddDoubles;:12 - DeleteField: instanceLorg/softlang/util/AddDoubles;
   * 6 Weak Mutation 6: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - DeleteStatement: doubleValue()D
   * 7 Weak Mutation 7: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - DeleteStatement: doubleValue()D
   * 8 Weak Mutation 9: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - ReplaceArithmeticOperator + -> %
   * 9 Weak Mutation 10: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - ReplaceArithmeticOperator + -> /
   * 10 Weak Mutation 12: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - DeleteStatement: valueOf(D)Ljava/lang/Double;
   * 11 Weak Mutation 8: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - ReplaceArithmeticOperator + -> -
   * 12 Weak Mutation 11: org.softlang.util.AddDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:15 - ReplaceArithmeticOperator + -> *
   */
  @Test
  public void test1()  throws Throwable  {
      AddDoubles addDoubles0 = AddDoubles.getInstance();
      assertNotNull(addDoubles0);
      
      Double double0 = new Double((-709.3402794711615));
      Double double1 = addDoubles0.append(double0, (Double) (-709.3402794711615));
      assertEquals((-1418.680558942323), (double)double1, 0.01D);
  }
}