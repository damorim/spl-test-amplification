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
public class TestProxyEmployee_3 {


  //Test case number: 3
  /*
   * 5 covered goals:
   * 1 Weak Mutation 6: org.softlang.proxy.ProxyEmployee.setAddress(Ljava/lang/String;)V:30 - DeleteField: subjectLorg/softlang/company/Employee;
   * 2 Weak Mutation 7: org.softlang.proxy.ProxyEmployee.setAddress(Ljava/lang/String;)V:30 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 3 org.softlang.proxy.ProxyEmployee.setAddress(Ljava/lang/String;)V: root-Branch
   * 4 Weak Mutation 6: org.softlang.proxy.ProxyEmployee.setAddress(Ljava/lang/String;)V:30 - DeleteField: subjectLorg/softlang/company/Employee;
   * 5 Weak Mutation 7: org.softlang.proxy.ProxyEmployee.setAddress(Ljava/lang/String;)V:30 - DeleteStatement: setAddress(Ljava/lang/String;)V
   */
  @Test
  public void test3()  throws Throwable  {
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      ProxyEmployee proxyEmployee0 = new ProxyEmployee((AccessControl) null, (Employee) employeeImpl0);
      proxyEmployee0.setAddress((String) null);
      assertNull(proxyEmployee0.getName());
  }
}
