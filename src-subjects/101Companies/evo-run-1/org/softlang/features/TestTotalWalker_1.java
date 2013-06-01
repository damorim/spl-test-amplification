/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Employee;
import org.softlang.company.impl.pojo.EmployeeImpl;
import org.softlang.features.TotalWalker;

@RunWith(EvoSuiteRunner.class)
public class TestTotalWalker_1 {


  //Test case number: 1
  /*
   * 10 covered goals:
   * 1 Weak Mutation 5: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - DeleteField: totalD
   * 2 Weak Mutation 0: org.softlang.features.TotalWalker.<init>()V:13 - ReplaceConstant - 0.0 -> 1.0
   * 3 Weak Mutation 1: org.softlang.features.TotalWalker.<init>()V:13 - ReplaceConstant - 0.0 -> -1.0
   * 4 Weak Mutation 4: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - InsertUnaryOp Negation
   * 5 Weak Mutation 6: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - DeleteStatement: getSalary()D
   * 6 Weak Mutation 7: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - ReplaceArithmeticOperator + -> -
   * 7 Weak Mutation 8: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - ReplaceArithmeticOperator + -> %
   * 8 Weak Mutation 9: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - ReplaceArithmeticOperator + -> /
   * 9 Weak Mutation 10: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - ReplaceArithmeticOperator + -> *
   * 10 Weak Mutation 5: org.softlang.features.TotalWalker.visit(Lorg/softlang/company/Employee;)V:20 - DeleteField: totalD
   */
  @Test
  public void test1()  throws Throwable  {
      TotalWalker totalWalker0 = new TotalWalker();
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      employeeImpl0.setSalary(1.0);
      totalWalker0.visit((Employee) employeeImpl0);
      totalWalker0.visit((Employee) employeeImpl0);
      assertEquals(2.0, totalWalker0.getTotal(), 0.01D);
  }
}
