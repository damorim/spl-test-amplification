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
public class TestEmployeeImpl_2 {


  //Test case number: 2
  /*
   * 13 covered goals:
   * 1 Weak Mutation 6: org.softlang.company.impl.pojo.EmployeeImpl.getManager()Z:27 - DeleteField: managerZ
   * 2 Weak Mutation 7: org.softlang.company.impl.pojo.EmployeeImpl.setManager(Z)V:30 - InsertUnaryOp Negation
   * 3 Weak Mutation 8: org.softlang.company.impl.pojo.EmployeeImpl.setManager(Z)V:30 - InsertUnaryOp IINC 1
   * 4 Weak Mutation 9: org.softlang.company.impl.pojo.EmployeeImpl.setManager(Z)V:30 - InsertUnaryOp IINC -1
   * 5 org.softlang.company.impl.pojo.EmployeeImpl.setManager(Z)V: root-Branch
   * 6 Weak Mutation 0: org.softlang.company.impl.pojo.EmployeeImpl.<init>()V:12 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 5: org.softlang.company.impl.pojo.EmployeeImpl.getManager()Z:27 - InsertUnaryOp Negation
   * 8 Weak Mutation 5: org.softlang.company.impl.pojo.EmployeeImpl.getManager()Z:27 - InsertUnaryOp Negation
   * 9 Weak Mutation 6: org.softlang.company.impl.pojo.EmployeeImpl.getManager()Z:27 - DeleteField: managerZ
   * 10 Weak Mutation 7: org.softlang.company.impl.pojo.EmployeeImpl.setManager(Z)V:30 - InsertUnaryOp Negation
   * 11 Weak Mutation 8: org.softlang.company.impl.pojo.EmployeeImpl.setManager(Z)V:30 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 9: org.softlang.company.impl.pojo.EmployeeImpl.setManager(Z)V:30 - InsertUnaryOp IINC -1
   * 13 org.softlang.company.impl.pojo.EmployeeImpl.getManager()Z: root-Branch
   */
  @Test
  public void test2()  throws Throwable  {
      EmployeeImpl employeeImpl0 = new EmployeeImpl();
      assertEquals(false, employeeImpl0.getManager());
      
      employeeImpl0.setManager(true);
      boolean boolean0 = employeeImpl0.getManager();
      assertEquals(true, boolean0);
  }
}
