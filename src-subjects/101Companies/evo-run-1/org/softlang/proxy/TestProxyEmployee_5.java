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
public class TestProxyEmployee_5 {


  //Test case number: 5
  /*
   * 6 covered goals:
   * 1 Weak Mutation 13: org.softlang.proxy.ProxyEmployee.getSalary()D:36 - ReplaceConstant - Receiver without read access for salary. -> 
   * 2 org.softlang.proxy.ProxyEmployee.getSalary()D: I5 Branch 1 IFEQ L33 - true
   * 3 Weak Mutation 8: org.softlang.proxy.ProxyEmployee.getSalary()D:33 - DeleteField: contextLorg/softlang/proxy/AccessControl;
   * 4 Weak Mutation 9: org.softlang.proxy.ProxyEmployee.getSalary()D:33 - DeleteStatement: isReadable()Z
   * 5 Weak Mutation 10: org.softlang.proxy.ProxyEmployee.getSalary()D:33 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 13: org.softlang.proxy.ProxyEmployee.getSalary()D:36 - ReplaceConstant - Receiver without read access for salary. -> 
   */
  @Test
  public void test5()  throws Throwable  {
      AccessControl accessControl0 = new AccessControl();
      org.softlang.company.impl.bean.EmployeeImpl employeeImpl0 = new org.softlang.company.impl.bean.EmployeeImpl();
      ProxyEmployee proxyEmployee0 = new ProxyEmployee(accessControl0, (Employee) employeeImpl0);
      accessControl0.disableReadAcccess();
      // Undeclared exception!
      try {
        proxyEmployee0.getSalary();
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * Receiver without read access for salary.
         */
      }
  }
}
