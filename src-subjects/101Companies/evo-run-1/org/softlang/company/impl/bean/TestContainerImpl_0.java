/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.company.impl.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Employee;
import org.softlang.company.impl.bean.DepartmentImpl;

@RunWith(EvoSuiteRunner.class)
public class TestContainerImpl_0 {


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 Weak Mutation 0: org.softlang.company.impl.bean.ContainerImpl.subunits()Ljava/lang/Iterable;:27 - DeleteField: subunitsLorg/softlang/util/ObservableSimpleList;
   * 2 org.softlang.company.impl.bean.ContainerImpl.subunits()Ljava/lang/Iterable;: root-Branch
   * 3 org.softlang.company.impl.bean.ContainerImpl.<init>()V: root-Branch
   * 4 Weak Mutation 0: org.softlang.company.impl.bean.ContainerImpl.subunits()Ljava/lang/Iterable;:27 - DeleteField: subunitsLorg/softlang/util/ObservableSimpleList;
   */
  @Test
  public void test0()  throws Throwable  {
      DepartmentImpl departmentImpl0 = new DepartmentImpl();
      Employee employee0 = departmentImpl0.getManager();
      assertNull(employee0);
  }
}