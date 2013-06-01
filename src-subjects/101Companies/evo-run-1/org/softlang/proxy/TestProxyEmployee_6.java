/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Employee;
import org.softlang.company.impl.pojo.EmployeeImpl;
import org.softlang.proxy.AccessControl;
import org.softlang.proxy.ProxyEmployee;

@RunWith(EvoSuiteRunner.class)
public class TestProxyEmployee_6 {


  //Test case number: 6
  /*
   * 13 covered goals:
   * 1 Weak Mutation 14: org.softlang.proxy.ProxyEmployee.setSalary(D)V:39 - DeleteField: contextLorg/softlang/proxy/AccessControl;
   * 2 Weak Mutation 15: org.softlang.proxy.ProxyEmployee.setSalary(D)V:39 - DeleteStatement: isWritable()Z
   * 3 Weak Mutation 16: org.softlang.proxy.ProxyEmployee.setSalary(D)V:39 - ReplaceComparisonOperator == -> !=
   * 4 Weak Mutation 17: org.softlang.proxy.ProxyEmployee.setSalary(D)V:40 - DeleteField: subjectLorg/softlang/company/Employee;
   * 5 Weak Mutation 19: org.softlang.proxy.ProxyEmployee.setSalary(D)V:40 - DeleteStatement: setSalary(D)V
   * 6 Weak Mutation 18: org.softlang.proxy.ProxyEmployee.setSalary(D)V:40 - InsertUnaryOp Negation
   * 7 org.softlang.proxy.ProxyEmployee.setSalary(D)V: I5 Branch 2 IFEQ L39 - false
   * 8 Weak Mutation 14: org.softlang.proxy.ProxyEmployee.setSalary(D)V:39 - DeleteField: contextLorg/softlang/proxy/AccessControl;
   * 9 Weak Mutation 15: org.softlang.proxy.ProxyEmployee.setSalary(D)V:39 - DeleteStatement: isWritable()Z
   * 10 Weak Mutation 17: org.softlang.proxy.ProxyEmployee.setSalary(D)V:40 - DeleteField: subjectLorg/softlang/company/Employee;
   * 11 Weak Mutation 16: org.softlang.proxy.ProxyEmployee.setSalary(D)V:39 - ReplaceComparisonOperator == -> !=
   * 12 Weak Mutation 19: org.softlang.proxy.ProxyEmployee.setSalary(D)V:40 - DeleteStatement: setSalary(D)V
   * 13 Weak Mutation 18: org.softlang.proxy.ProxyEmployee.setSalary(D)V:40 - InsertUnaryOp Negation
   */
  @Test
  public void test6()  throws Throwable  {
      AccessControl accessControl0 = new AccessControl();
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      ProxyEmployee proxyEmployee0 = new ProxyEmployee(accessControl0, (Employee) employeeImpl0);
      proxyEmployee0.setSalary(375.12388078063657);
      assertEquals(375.12388078063657, proxyEmployee0.getSalary(), 0.01D);
      assertEquals(375.12388078063657, employeeImpl0.getSalary(), 0.01D);
  }
}
