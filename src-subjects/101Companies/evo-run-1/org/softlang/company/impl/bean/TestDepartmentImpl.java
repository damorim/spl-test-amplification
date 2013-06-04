/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.company.impl.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Subunit;
import org.softlang.company.impl.bean.DepartmentImpl;
import org.softlang.company.impl.bean.EmployeeImpl;

@RunWith(EvoSuiteRunner.class)
public class TestDepartmentImpl {


  //Test case number: 0
  /*
   * 20 covered goals:
   * 1 org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;: I28 Branch 3 IFEQ L76 - false
   * 2 Weak Mutation 0: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: subunits()Ljava/lang/Iterable;
   * 3 Weak Mutation 1: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 4 Weak Mutation 2: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: hasNext()Z
   * 5 Weak Mutation 3: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 4: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: next()Ljava/lang/Object;
   * 7 Weak Mutation 5: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:74 - ReplaceComparisonOperator == -> !=
   * 8 Weak Mutation 6: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:76 - DeleteStatement: getManager()Z
   * 9 Weak Mutation 7: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:76 - ReplaceComparisonOperator == -> !=
   * 10 Weak Mutation 0: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: subunits()Ljava/lang/Iterable;
   * 11 Weak Mutation 1: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 12 Weak Mutation 2: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: hasNext()Z
   * 13 Weak Mutation 3: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - ReplaceComparisonOperator == -> !=
   * 14 Weak Mutation 4: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:73 - DeleteStatement: next()Ljava/lang/Object;
   * 15 Weak Mutation 5: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:74 - ReplaceComparisonOperator == -> !=
   * 16 Weak Mutation 6: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:76 - DeleteStatement: getManager()Z
   * 17 Weak Mutation 7: org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;:76 - ReplaceComparisonOperator == -> !=
   * 18 org.softlang.company.impl.bean.DepartmentImpl.<init>()V: root-Branch
   * 19 org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;: I9 Branch 1 IFEQ L73 - false
   * 20 org.softlang.company.impl.bean.DepartmentImpl.getManager()Lorg/softlang/company/Employee;: I18 Branch 2 IFEQ L74 - false
   */
  @Test
  public void test0()  throws Throwable  {
      DepartmentImpl departmentImpl0 = new DepartmentImpl();
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      departmentImpl0.add((Subunit) employeeImpl0);
      employeeImpl0.setManager(true);
      EmployeeImpl employeeImpl1 = (EmployeeImpl)departmentImpl0.getManager();
      assertEquals(0.0, employeeImpl1.getSalary(), 0.01D);
  }
}