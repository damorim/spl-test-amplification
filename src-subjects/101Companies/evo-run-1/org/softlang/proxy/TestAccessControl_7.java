/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Department;
import org.softlang.company.Subunit;
import org.softlang.company.impl.pojo.DepartmentImpl;
import org.softlang.proxy.AccessControl;
import org.softlang.proxy.ProxyDepartment;

@RunWith(EvoSuiteRunner.class)
public class TestAccessControl_7 {


  //Test case number: 7
  /*
   * 14 covered goals:
   * 1 Weak Mutation 16: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Subunit;)Lorg/softlang/company/Subunit;:70 - DeleteStatement: deploy(Lorg/softlang/company/Department;)Lorg/softlang/company/Department;
   * 2 org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Subunit;)Lorg/softlang/company/Subunit;: I4 Branch 4 IFEQ L70 - false
   * 3 Weak Mutation 15: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Subunit;)Lorg/softlang/company/Subunit;:70 - ReplaceComparisonOperator == -> !=
   * 4 Weak Mutation 19: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:77 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 5 Weak Mutation 18: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:77 - DeleteStatement: subunits()Ljava/lang/Iterable;
   * 6 Weak Mutation 21: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:77 - ReplaceComparisonOperator == -> !=
   * 7 Weak Mutation 20: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:77 - DeleteStatement: hasNext()Z
   * 8 Weak Mutation 27: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:84 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 9 Weak Mutation 29: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:84 - ReplaceComparisonOperator == -> !=
   * 10 Weak Mutation 28: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:84 - DeleteStatement: hasNext()Z
   * 11 Weak Mutation 34: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:86 - ReplaceComparisonOperator == -> !=
   * 12 Weak Mutation 32: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:86 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 13 Weak Mutation 33: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Container;)V:86 - DeleteStatement: hasNext()Z
   * 14 Weak Mutation 16: org.softlang.proxy.AccessControl.deploy(Lorg/softlang/company/Subunit;)Lorg/softlang/company/Subunit;:70 - DeleteStatement: deploy(Lorg/softlang/company/Department;)Lorg/softlang/company/Department;
   */
  @Test
  public void test7()  throws Throwable  {
      AccessControl accessControl0 = new AccessControl();
      DepartmentImpl departmentImpl0 = new DepartmentImpl();
      ProxyDepartment proxyDepartment0 = (ProxyDepartment)accessControl0.deploy((Subunit) departmentImpl0);
      assertNotNull(proxyDepartment0);
      assertEquals(true, accessControl0.isReadable());
      assertEquals(true, accessControl0.isWritable());
  }
}
