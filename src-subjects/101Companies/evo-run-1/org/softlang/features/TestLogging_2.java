/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.Observable;
import org.softlang.company.impl.bean.EmployeeImpl;
import org.softlang.features.Logging;

@RunWith(EvoSuiteRunner.class)
public class TestLogging_2 {


  //Test case number: 2
  /*
   * 7 covered goals:
   * 1 Weak Mutation 7: org.softlang.features.Logging.getSize()I:35 - InsertUnaryOp Negation
   * 2 Weak Mutation 8: org.softlang.features.Logging.getSize()I:35 - InsertUnaryOp +1
   * 3 Weak Mutation 9: org.softlang.features.Logging.getSize()I:35 - InsertUnaryOp -1
   * 4 org.softlang.features.Logging.getSize()I: root-Branch
   * 5 Weak Mutation 7: org.softlang.features.Logging.getSize()I:35 - InsertUnaryOp Negation
   * 6 Weak Mutation 8: org.softlang.features.Logging.getSize()I:35 - InsertUnaryOp +1
   * 7 Weak Mutation 9: org.softlang.features.Logging.getSize()I:35 - InsertUnaryOp -1
   */
  @Test
  public void test2()  throws Throwable  {
      Logging logging0 = new Logging();
      int int0 = logging0.getSize();
      assertEquals(0, int0);
  }
}
