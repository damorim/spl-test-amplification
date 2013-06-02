/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.util.MaxDoubles;

@RunWith(EvoSuiteRunner.class)
public class TestMaxDoubles_1 {


  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 org.softlang.util.MaxDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;: I3 Branch 2 IFNONNULL L16 - false
   * 2 Weak Mutation 0: org.softlang.util.MaxDoubles.getInstance()Lorg/softlang/util/MaxDoubles;:10 - DeleteField: instanceLorg/softlang/util/MaxDoubles;
   * 3 Weak Mutation 1: org.softlang.util.MaxDoubles.getInstance()Lorg/softlang/util/MaxDoubles;:10 - ReplaceComparisonOperator != null -> = null
   * 4 Weak Mutation 2: org.softlang.util.MaxDoubles.getInstance()Lorg/softlang/util/MaxDoubles;:12 - DeleteField: instanceLorg/softlang/util/MaxDoubles;
   * 5 Weak Mutation 3: org.softlang.util.MaxDoubles.append(Ljava/lang/Double;Ljava/lang/Double;)Ljava/lang/Double;:16 - ReplaceComparisonOperator != null -> = null
   */
  @Test
  public void test1()  throws Throwable  {
      MaxDoubles maxDoubles0 = MaxDoubles.getInstance();
      Double double0 = maxDoubles0.append((Double) null, (Double) (-24.402199958175043));
      assertEquals((-24.4022F), double0.floatValue(), 0.01F);
  }
}