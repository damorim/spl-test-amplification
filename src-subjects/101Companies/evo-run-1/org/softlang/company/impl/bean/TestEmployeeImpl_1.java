/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.company.impl.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.impl.bean.EmployeeImpl;

@RunWith(EvoSuiteRunner.class)
public class TestEmployeeImpl_1 {


  //Test case number: 1
  /*
   * 4 covered goals:
   * 1 Weak Mutation 1: org.softlang.company.impl.bean.EmployeeImpl.getAddress()Ljava/lang/String;:38 - DeleteField: addressLjava/lang/String;
   * 2 org.softlang.company.impl.bean.EmployeeImpl.getAddress()Ljava/lang/String;: root-Branch
   * 3 org.softlang.company.impl.bean.EmployeeImpl.setAddress(Ljava/lang/String;)V: root-Branch
   * 4 Weak Mutation 1: org.softlang.company.impl.bean.EmployeeImpl.getAddress()Ljava/lang/String;:38 - DeleteField: addressLjava/lang/String;
   */
  @Test
  public void test1()  throws Throwable  {
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      employeeImpl0.setAddress("");
      String string0 = employeeImpl0.getAddress();
      assertEquals("", string0);
  }
}