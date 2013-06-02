/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.swing.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Component;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.swing.model.Model;

@RunWith(EvoSuiteRunner.class)
public class TestModel_5 {


  //Test case number: 5
  /*
   * 4 covered goals:
   * 1 Weak Mutation 9: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: parseDouble(Ljava/lang/String;)D
   * 2 Weak Mutation 10: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: setSalary(D)V
   * 3 Weak Mutation 9: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: parseDouble(Ljava/lang/String;)D
   * 4 Weak Mutation 10: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: setSalary(D)V
   */
  @Test
  public void test5()  throws Throwable  {
      BeanFactory beanFactory0 = new BeanFactory();
      Model model0 = new Model((Factory) beanFactory0);
      // Undeclared exception!
      try {
        model0.setSalary("4");
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}