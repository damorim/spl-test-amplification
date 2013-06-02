/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.util.Observable;
import org.softlang.company.Subunit;
import org.softlang.company.impl.bean.DepartmentImpl;
import org.softlang.company.impl.bean.EmployeeImpl;
import org.softlang.features.Precedence;

@RunWith(EvoSuiteRunner.class)
public class TestPrecedence_4 {


  //Test case number: 4
  /*
   * 33 covered goals:
   * 1 Weak Mutation 19: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:32 - DeleteStatement: getParent()Lorg/softlang/company/impl/bean/ComponentImpl;
   * 2 Weak Mutation 18: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:32 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 20: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:32 - ReplaceComparisonOperator == -> !=
   * 4 Weak Mutation 21: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getSalary()D
   * 5 Weak Mutation 23: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getManager()Lorg/softlang/company/Employee;
   * 6 Weak Mutation 22: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getParent()Lorg/softlang/company/impl/bean/ComponentImpl;
   * 7 Weak Mutation 25: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: doubleSub(DD)I
   * 8 Weak Mutation 24: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getSalary()D
   * 9 Weak Mutation 27: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - ReplaceComparisonOperator < -> <=
   * 10 Weak Mutation 29: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:45 - DeleteStatement: subunits()Ljava/lang/Iterable;
   * 11 Weak Mutation 30: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:45 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 12 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I56 Branch 6 IFNULL L32 - false
   * 13 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I60 Branch 7 IFEQ L32 - false
   * 14 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I72 Branch 8 IFLT L33 - false
   * 15 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I91 Branch 9 IFEQ L45 - true
   * 16 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I91 Branch 9 IFEQ L45 - false
   * 17 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I100 Branch 10 IFEQ L46 - true
   * 18 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I100 Branch 10 IFEQ L46 - false
   * 19 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I110 Branch 11 IFLT L47 - false
   * 20 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I127 Branch 12 IF_ACMPEQ L58 - true
   * 21 Weak Mutation 17: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:32 - DeleteStatement: getParent()Lorg/softlang/company/impl/bean/ComponentImpl;
   * 22 Weak Mutation 19: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:32 - DeleteStatement: getParent()Lorg/softlang/company/impl/bean/ComponentImpl;
   * 23 Weak Mutation 18: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:32 - ReplaceComparisonOperator = null -> != null
   * 24 Weak Mutation 21: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getSalary()D
   * 25 Weak Mutation 20: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:32 - ReplaceComparisonOperator == -> !=
   * 26 Weak Mutation 23: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getManager()Lorg/softlang/company/Employee;
   * 27 Weak Mutation 22: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getParent()Lorg/softlang/company/impl/bean/ComponentImpl;
   * 28 Weak Mutation 25: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: doubleSub(DD)I
   * 29 Weak Mutation 24: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - DeleteStatement: getSalary()D
   * 30 Weak Mutation 27: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:33 - ReplaceComparisonOperator < -> <=
   * 31 Weak Mutation 29: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:45 - DeleteStatement: subunits()Ljava/lang/Iterable;
   * 32 Weak Mutation 30: org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V:45 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 33 org.softlang.features.Precedence.update(Ljava/util/Observable;Ljava/lang/Object;)V: I30 Branch 4 IFNE L18 - true
   */
  @Test
  public void test4()  throws Throwable  {
      DepartmentImpl departmentImpl0 = new DepartmentImpl();
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      Precedence precedence0 = new Precedence();
      departmentImpl0.add((Subunit) employeeImpl0);
      departmentImpl0.add((Subunit) departmentImpl0);
      employeeImpl0.setManager(true);
      precedence0.update((Observable) employeeImpl0, (Object) "salary");
      assertNull(employeeImpl0.getName());
  }
}