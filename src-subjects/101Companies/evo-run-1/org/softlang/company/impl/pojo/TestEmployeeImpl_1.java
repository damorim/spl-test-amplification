/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.company.impl.pojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.impl.pojo.EmployeeImpl;

@RunWith(EvoSuiteRunner.class)
public class TestEmployeeImpl_1 {


  //Test case number: 1
  /*
   * 8 covered goals:
   * 1 Weak Mutation 3: org.softlang.company.impl.pojo.EmployeeImpl.getSalary()D:21 - DeleteField: salaryD
   * 2 Weak Mutation 4: org.softlang.company.impl.pojo.EmployeeImpl.setSalary(D)V:24 - InsertUnaryOp Negation
   * 3 org.softlang.company.impl.pojo.EmployeeImpl.setSalary(D)V: root-Branch
   * 4 Weak Mutation 2: org.softlang.company.impl.pojo.EmployeeImpl.getSalary()D:21 - InsertUnaryOp Negation
   * 5 Weak Mutation 2: org.softlang.company.impl.pojo.EmployeeImpl.getSalary()D:21 - InsertUnaryOp Negation
   * 6 Weak Mutation 3: org.softlang.company.impl.pojo.EmployeeImpl.getSalary()D:21 - DeleteField: salaryD
   * 7 Weak Mutation 4: org.softlang.company.impl.pojo.EmployeeImpl.setSalary(D)V:24 - InsertUnaryOp Negation
   * 8 org.softlang.company.impl.pojo.EmployeeImpl.getSalary()D: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      employeeImpl0.setSalary(1453.5421559825243);
      double double0 = employeeImpl0.getSalary();
      assertEquals(1453.5421559825243, employeeImpl0.getSalary(), 0.01D);
      assertEquals(1453.5421559825243, double0, 0.01D);
  }
}