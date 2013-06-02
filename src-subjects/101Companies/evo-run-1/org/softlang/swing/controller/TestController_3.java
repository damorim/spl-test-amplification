/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.swing.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Component;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.swing.controller.Controller;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.MainView;

@RunWith(EvoSuiteRunner.class)
public class TestController_3 {


  //Test case number: 3
  /*
   * 5 covered goals:
   * 1 Weak Mutation 38: org.softlang.swing.controller.Controller.salaryChanged(Ljava/lang/String;)V:150 - DeleteStatement: setSalary(Ljava/lang/String;)V
   * 2 Weak Mutation 37: org.softlang.swing.controller.Controller.salaryChanged(Ljava/lang/String;)V:150 - DeleteField: modelLorg/softlang/swing/model/Model;
   * 3 org.softlang.swing.controller.Controller.salaryChanged(Ljava/lang/String;)V: root-Branch
   * 4 Weak Mutation 38: org.softlang.swing.controller.Controller.salaryChanged(Ljava/lang/String;)V:150 - DeleteStatement: setSalary(Ljava/lang/String;)V
   * 5 Weak Mutation 37: org.softlang.swing.controller.Controller.salaryChanged(Ljava/lang/String;)V:150 - DeleteField: modelLorg/softlang/swing/model/Model;
   */
  @Test
  public void test3()  throws Throwable  {
      PojoFactory pojoFactory0 = new PojoFactory();
      Model model0 = new Model((Factory) pojoFactory0);
      Controller controller0 = new Controller(model0, (MainView) null);
      // Undeclared exception!
      try {
        controller0.salaryChanged("");
        fail("Expecting exception: NumberFormatException");
      } catch(NumberFormatException e) {
        /*
         * empty String
         */
      }
  }
}