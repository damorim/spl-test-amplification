/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.swing.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Company;
import org.softlang.company.Component;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.swing.model.Model;

@RunWith(EvoSuiteRunner.class)
public class TestModel {


  //Test case number: 0
  /*
   * 53 covered goals:
   * 1 Weak Mutation 4: org.softlang.swing.model.Model.setName(Ljava/lang/String;)V:116 - DeleteField: currentValueLorg/softlang/company/Component;
   * 2 Weak Mutation 5: org.softlang.swing.model.Model.setName(Ljava/lang/String;)V:116 - DeleteStatement: setName(Ljava/lang/String;)V
   * 3 org.softlang.swing.model.Model.setCurrentValue(Lorg/softlang/company/Component;)V: root-Branch
   * 4 org.softlang.swing.model.Model.setName(Ljava/lang/String;)V: root-Branch
   * 5 Weak Mutation 0: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:52 - ReplaceComparisonOperator == -> !=
   * 6 Weak Mutation 2: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:54 - ReplaceComparisonOperator == -> !=
   * 7 Weak Mutation 3: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:55 - DeleteStatement: createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;
   * 8 Weak Mutation 4: org.softlang.swing.model.Model.setName(Ljava/lang/String;)V:116 - DeleteField: currentValueLorg/softlang/company/Component;
   * 9 Weak Mutation 5: org.softlang.swing.model.Model.setName(Ljava/lang/String;)V:116 - DeleteStatement: setName(Ljava/lang/String;)V
   * 10 Weak Mutation 13: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:146 - DeleteStatement: mkCompany()Lorg/softlang/company/Company;
   * 11 Weak Mutation 14: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:147 - ReplaceConstant - meganalysis -> 
   * 12 Weak Mutation 15: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:147 - DeleteStatement: setName(Ljava/lang/String;)V
   * 13 Weak Mutation 17: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:151 - ReplaceConstant - Craig -> 
   * 14 Weak Mutation 16: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:150 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 15 Weak Mutation 19: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:152 - ReplaceConstant - Redmond -> 
   * 16 Weak Mutation 18: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:151 - DeleteStatement: setName(Ljava/lang/String;)V
   * 17 Weak Mutation 21: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 0.0
   * 18 Weak Mutation 20: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:152 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 19 Weak Mutation 23: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> -1.0
   * 20 Weak Mutation 22: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 1.0
   * 21 Weak Mutation 25: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 123457.0
   * 22 Weak Mutation 24: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 123455.0
   * 23 Weak Mutation 27: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:154 - ReplaceConstant - 1 -> 0
   * 24 Weak Mutation 26: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - DeleteStatement: setSalary(D)V
   * 25 Weak Mutation 29: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:156 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 26 Weak Mutation 28: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:154 - DeleteStatement: setManager(Z)V
   * 27 Weak Mutation 31: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:157 - DeleteStatement: setName(Ljava/lang/String;)V
   * 28 Weak Mutation 30: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:157 - ReplaceConstant - Erik -> 
   * 29 Weak Mutation 34: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 0.0
   * 30 Weak Mutation 35: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 1.0
   * 31 Weak Mutation 32: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:158 - ReplaceConstant - Utrecht -> 
   * 32 Weak Mutation 33: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:158 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 33 Weak Mutation 38: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 12346.0
   * 34 Weak Mutation 39: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - DeleteStatement: setSalary(D)V
   * 35 Weak Mutation 36: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> -1.0
   * 36 Weak Mutation 37: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 12344.0
   * 37 Weak Mutation 42: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:162 - DeleteStatement: setName(Ljava/lang/String;)V
   * 38 Weak Mutation 43: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:163 - ReplaceConstant - Koblenz -> 
   * 39 Weak Mutation 40: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:161 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 40 Weak Mutation 41: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:162 - ReplaceConstant - Ralf -> 
   * 41 Weak Mutation 46: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1.0
   * 42 Weak Mutation 47: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> -1.0
   * 43 Weak Mutation 44: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:163 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 44 Weak Mutation 45: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 0.0
   * 45 Weak Mutation 51: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:166 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 46 Weak Mutation 50: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - DeleteStatement: setSalary(D)V
   * 47 Weak Mutation 49: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1235.0
   * 48 Weak Mutation 48: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1233.0
   * 49 Weak Mutation 53: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:167 - DeleteStatement: setName(Ljava/lang/String;)V
   * 50 Weak Mutation 52: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:167 - ReplaceConstant - Ray -> 
   * 51 org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;: root-Branch
   * 52 org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V: I8 Branch 1 IFEQ L52 - true
   * 53 org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V: I23 Branch 2 IFEQ L54 - false
   */
  @Test
  public void test0()  throws Throwable  {
      BeanFactory beanFactory0 = new BeanFactory();
      Model model0 = new Model((Factory) beanFactory0);
      CompanyImpl companyImpl0 = (CompanyImpl)beanFactory0.mkCompany();
      model0.setCurrentValue((Component) companyImpl0);
      model0.setName("");
  }

  //Test case number: 1
  /*
   * 5 covered goals:
   * 1 Weak Mutation 7: org.softlang.swing.model.Model.setAddress(Ljava/lang/String;)V:120 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 2 Weak Mutation 1: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:53 - DeleteStatement: createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;
   * 3 Weak Mutation 7: org.softlang.swing.model.Model.setAddress(Ljava/lang/String;)V:120 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 4 org.softlang.swing.model.Model.setAddress(Ljava/lang/String;)V: root-Branch
   * 5 org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V: I8 Branch 1 IFEQ L52 - false
   */
  @Test
  public void test1()  throws Throwable  {
      PojoFactory pojoFactory0 = new PojoFactory();
      Model model0 = new Model((Factory) pojoFactory0);
      // Undeclared exception!
      try {
        model0.setAddress("?j'eum>%ea)nP.$3/K@");
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 2
  /*
   * 3 covered goals:
   * 1 Weak Mutation 6: org.softlang.swing.model.Model.setAddress(Ljava/lang/String;)V:120 - DeleteField: currentValueLorg/softlang/company/Component;
   * 2 org.softlang.swing.model.Model.setAddress(Ljava/lang/String;)V: root-Branch
   * 3 Weak Mutation 6: org.softlang.swing.model.Model.setAddress(Ljava/lang/String;)V:120 - DeleteField: currentValueLorg/softlang/company/Component;
   */
  @Test
  public void test2()  throws Throwable  {
      BeanFactory beanFactory0 = new BeanFactory();
      Model model0 = new Model((Factory) beanFactory0);
      CompanyImpl companyImpl0 = (CompanyImpl)beanFactory0.mkCompany();
      model0.setCurrentValue((Component) companyImpl0);
      // Undeclared exception!
      try {
        model0.setAddress("");
        fail("Expecting exception: ClassCastException");
      } catch(ClassCastException e) {
        /*
         * org.softlang.company.impl.bean.CompanyImpl cannot be cast to org.softlang.company.Employee
         */
      }
  }

  //Test case number: 3
  /*
   * 7 covered goals:
   * 1 Weak Mutation 8: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteField: currentValueLorg/softlang/company/Component;
   * 2 Weak Mutation 11: org.softlang.swing.model.Model.getCompany()Lorg/softlang/company/Company;:128 - DeleteField: companyLorg/softlang/company/Company;
   * 3 org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V: root-Branch
   * 4 org.softlang.swing.model.Model.getCompany()Lorg/softlang/company/Company;: root-Branch
   * 5 Weak Mutation 1: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:53 - DeleteStatement: createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;
   * 6 Weak Mutation 8: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteField: currentValueLorg/softlang/company/Component;
   * 7 Weak Mutation 11: org.softlang.swing.model.Model.getCompany()Lorg/softlang/company/Company;:128 - DeleteField: companyLorg/softlang/company/Company;
   */
  @Test
  public void test3()  throws Throwable  {
      PojoFactory pojoFactory0 = new PojoFactory();
      Model model0 = new Model((Factory) pojoFactory0);
      org.softlang.company.impl.pojo.CompanyImpl companyImpl0 = (org.softlang.company.impl.pojo.CompanyImpl)model0.getCompany();
      model0.setCurrentValue((Component) companyImpl0);
      // Undeclared exception!
      try {
        model0.setSalary("");
        fail("Expecting exception: ClassCastException");
      } catch(ClassCastException e) {
        /*
         * org.softlang.company.impl.pojo.CompanyImpl cannot be cast to org.softlang.company.Employee
         */
      }
  }

  //Test case number: 4
  /*
   * 4 covered goals:
   * 1 Weak Mutation 9: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: parseDouble(Ljava/lang/String;)D
   * 2 Weak Mutation 10: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: setSalary(D)V
   * 3 Weak Mutation 9: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: parseDouble(Ljava/lang/String;)D
   * 4 Weak Mutation 10: org.softlang.swing.model.Model.setSalary(Ljava/lang/String;)V:124 - DeleteStatement: setSalary(D)V
   */
  @Test
  public void test4()  throws Throwable  {
      BeanFactory beanFactory0 = new BeanFactory();
      Model model0 = new Model((Factory) beanFactory0);
      // Undeclared exception!
      try {
        model0.setSalary("3");
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 5
  /*
   * 3 covered goals:
   * 1 Weak Mutation 12: org.softlang.swing.model.Model.getCurrentValue()Lorg/softlang/company/Component;:136 - DeleteField: currentValueLorg/softlang/company/Component;
   * 2 org.softlang.swing.model.Model.getCurrentValue()Lorg/softlang/company/Component;: root-Branch
   * 3 Weak Mutation 12: org.softlang.swing.model.Model.getCurrentValue()Lorg/softlang/company/Component;:136 - DeleteField: currentValueLorg/softlang/company/Component;
   */
  @Test
  public void test5()  throws Throwable  {
      BeanFactory beanFactory0 = new BeanFactory();
      Model model0 = new Model((Factory) beanFactory0);
      CompanyImpl companyImpl0 = (CompanyImpl)beanFactory0.mkCompany();
      model0.setCurrentValue((Component) companyImpl0);
      CompanyImpl companyImpl1 = (CompanyImpl)model0.getCurrentValue();
      assertNull(companyImpl1.getName());
  }

  //Test case number: 6
  /*
   * 43 covered goals:
   * 1 org.softlang.swing.model.Model.setCompany(Lorg/softlang/company/Company;)V: root-Branch
   * 2 Weak Mutation 3: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:55 - DeleteStatement: createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;
   * 3 Weak Mutation 13: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:146 - DeleteStatement: mkCompany()Lorg/softlang/company/Company;
   * 4 Weak Mutation 14: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:147 - ReplaceConstant - meganalysis -> 
   * 5 Weak Mutation 15: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:147 - DeleteStatement: setName(Ljava/lang/String;)V
   * 6 Weak Mutation 17: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:151 - ReplaceConstant - Craig -> 
   * 7 Weak Mutation 16: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:150 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 8 Weak Mutation 19: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:152 - ReplaceConstant - Redmond -> 
   * 9 Weak Mutation 18: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:151 - DeleteStatement: setName(Ljava/lang/String;)V
   * 10 Weak Mutation 21: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 0.0
   * 11 Weak Mutation 20: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:152 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 12 Weak Mutation 23: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> -1.0
   * 13 Weak Mutation 22: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 1.0
   * 14 Weak Mutation 25: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 123457.0
   * 15 Weak Mutation 24: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 123455.0
   * 16 Weak Mutation 27: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:154 - ReplaceConstant - 1 -> 0
   * 17 Weak Mutation 26: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - DeleteStatement: setSalary(D)V
   * 18 Weak Mutation 29: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:156 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 19 Weak Mutation 28: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:154 - DeleteStatement: setManager(Z)V
   * 20 Weak Mutation 31: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:157 - DeleteStatement: setName(Ljava/lang/String;)V
   * 21 Weak Mutation 30: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:157 - ReplaceConstant - Erik -> 
   * 22 Weak Mutation 34: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 0.0
   * 23 Weak Mutation 35: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 1.0
   * 24 Weak Mutation 32: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:158 - ReplaceConstant - Utrecht -> 
   * 25 Weak Mutation 33: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:158 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 26 Weak Mutation 38: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 12346.0
   * 27 Weak Mutation 39: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - DeleteStatement: setSalary(D)V
   * 28 Weak Mutation 36: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> -1.0
   * 29 Weak Mutation 37: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 12344.0
   * 30 Weak Mutation 42: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:162 - DeleteStatement: setName(Ljava/lang/String;)V
   * 31 Weak Mutation 43: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:163 - ReplaceConstant - Koblenz -> 
   * 32 Weak Mutation 40: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:161 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 33 Weak Mutation 41: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:162 - ReplaceConstant - Ralf -> 
   * 34 Weak Mutation 46: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1.0
   * 35 Weak Mutation 47: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> -1.0
   * 36 Weak Mutation 44: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:163 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 37 Weak Mutation 45: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 0.0
   * 38 Weak Mutation 51: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:166 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 39 Weak Mutation 50: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - DeleteStatement: setSalary(D)V
   * 40 Weak Mutation 49: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1235.0
   * 41 Weak Mutation 48: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1233.0
   * 42 Weak Mutation 53: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:167 - DeleteStatement: setName(Ljava/lang/String;)V
   * 43 Weak Mutation 52: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:167 - ReplaceConstant - Ray -> 
   */
  @Test
  public void test6()  throws Throwable  {
      BeanFactory beanFactory0 = new BeanFactory();
      Model model0 = new Model((Factory) beanFactory0);
      CompanyImpl companyImpl0 = (CompanyImpl)beanFactory0.mkCompany();
      model0.setCompany((Company) companyImpl0);
      assertEquals(false, companyImpl0.hasChanged());
  }

  //Test case number: 7
  /*
   * 3 covered goals:
   * 1 org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V: I23 Branch 2 IFEQ L54 - true
   * 2 Weak Mutation 0: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:52 - ReplaceComparisonOperator == -> !=
   * 3 Weak Mutation 2: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:54 - ReplaceComparisonOperator == -> !=
   */
  @Test
  public void test7()  throws Throwable  {
      Model model0 = new Model((Factory) null);
      assertNotNull(model0);
  }
}
