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
import org.softlang.features.SimpleCut;

@RunWith(EvoSuiteRunner.class)
public class TestSimpleCut_0 {


  //Test case number: 0
  /*
   * 22 covered goals:
   * 1 Weak Mutation 6: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> %
   * 2 Weak Mutation 8: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> *
   * 3 Weak Mutation 0: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - DeleteStatement: getSalary()D
   * 4 Weak Mutation 1: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> 0.0
   * 5 Weak Mutation 2: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> 1.0
   * 6 Weak Mutation 3: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> -1.0
   * 7 Weak Mutation 4: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> 3.0
   * 8 Weak Mutation 5: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> -
   * 9 Weak Mutation 7: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> +
   * 10 Weak Mutation 9: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - DeleteStatement: setSalary(D)V
   * 11 Weak Mutation 0: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - DeleteStatement: getSalary()D
   * 12 Weak Mutation 1: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> 0.0
   * 13 Weak Mutation 2: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> 1.0
   * 14 Weak Mutation 3: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> -1.0
   * 15 Weak Mutation 4: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceConstant - 2.0 -> 3.0
   * 16 Weak Mutation 5: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> -
   * 17 Weak Mutation 6: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> %
   * 18 Weak Mutation 7: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> +
   * 19 Weak Mutation 8: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - ReplaceArithmeticOperator / -> *
   * 20 Weak Mutation 9: org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V:8 - DeleteStatement: setSalary(D)V
   * 21 org.softlang.features.SimpleCut.visit(Lorg/softlang/company/Employee;)V: root-Branch
   * 22 org.softlang.features.SimpleCut.<init>()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      SimpleCut simpleCut0 = new SimpleCut();
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      employeeImpl0.setSalary((-1.0));
      simpleCut0.visit((Employee) employeeImpl0);
      assertEquals((-0.5), employeeImpl0.getSalary(), 0.01D);
  }
}