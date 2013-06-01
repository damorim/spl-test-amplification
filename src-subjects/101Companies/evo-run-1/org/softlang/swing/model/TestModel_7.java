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
public class TestModel_7 {


  //Test case number: 7
  /*
   * 46 covered goals:
   * 1 org.softlang.swing.model.Model.setCompany(Lorg/softlang/company/Company;)V: root-Branch
   * 2 Weak Mutation 0: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:52 - ReplaceComparisonOperator == -> !=
   * 3 Weak Mutation 2: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:54 - ReplaceComparisonOperator == -> !=
   * 4 Weak Mutation 3: org.softlang.swing.model.Model.<init>(Lorg/softlang/company/factory/Factory;)V:55 - DeleteStatement: createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;
   * 5 Weak Mutation 11: org.softlang.swing.model.Model.getCompany()Lorg/softlang/company/Company;:128 - DeleteField: companyLorg/softlang/company/Company;
   * 6 Weak Mutation 13: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:146 - DeleteStatement: mkCompany()Lorg/softlang/company/Company;
   * 7 Weak Mutation 14: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:147 - ReplaceConstant - meganalysis -> 
   * 8 Weak Mutation 15: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:147 - DeleteStatement: setName(Ljava/lang/String;)V
   * 9 Weak Mutation 17: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:151 - ReplaceConstant - Craig -> 
   * 10 Weak Mutation 16: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:150 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 11 Weak Mutation 19: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:152 - ReplaceConstant - Redmond -> 
   * 12 Weak Mutation 18: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:151 - DeleteStatement: setName(Ljava/lang/String;)V
   * 13 Weak Mutation 21: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 0.0
   * 14 Weak Mutation 20: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:152 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 15 Weak Mutation 23: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> -1.0
   * 16 Weak Mutation 22: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 1.0
   * 17 Weak Mutation 25: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 123457.0
   * 18 Weak Mutation 24: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - ReplaceConstant - 123456.0 -> 123455.0
   * 19 Weak Mutation 27: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:154 - ReplaceConstant - 1 -> 0
   * 20 Weak Mutation 26: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:153 - DeleteStatement: setSalary(D)V
   * 21 Weak Mutation 29: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:156 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 22 Weak Mutation 28: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:154 - DeleteStatement: setManager(Z)V
   * 23 Weak Mutation 31: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:157 - DeleteStatement: setName(Ljava/lang/String;)V
   * 24 Weak Mutation 30: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:157 - ReplaceConstant - Erik -> 
   * 25 Weak Mutation 34: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 0.0
   * 26 Weak Mutation 35: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 1.0
   * 27 Weak Mutation 32: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:158 - ReplaceConstant - Utrecht -> 
   * 28 Weak Mutation 33: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:158 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 29 Weak Mutation 38: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 12346.0
   * 30 Weak Mutation 39: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - DeleteStatement: setSalary(D)V
   * 31 Weak Mutation 36: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> -1.0
   * 32 Weak Mutation 37: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:159 - ReplaceConstant - 12345.0 -> 12344.0
   * 33 Weak Mutation 42: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:162 - DeleteStatement: setName(Ljava/lang/String;)V
   * 34 Weak Mutation 43: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:163 - ReplaceConstant - Koblenz -> 
   * 35 Weak Mutation 40: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:161 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 36 Weak Mutation 41: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:162 - ReplaceConstant - Ralf -> 
   * 37 Weak Mutation 46: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1.0
   * 38 Weak Mutation 47: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> -1.0
   * 39 Weak Mutation 44: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:163 - DeleteStatement: setAddress(Ljava/lang/String;)V
   * 40 Weak Mutation 45: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 0.0
   * 41 Weak Mutation 51: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:166 - DeleteStatement: mkEmployee()Lorg/softlang/company/Employee;
   * 42 Weak Mutation 50: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - DeleteStatement: setSalary(D)V
   * 43 Weak Mutation 49: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1235.0
   * 44 Weak Mutation 48: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:164 - ReplaceConstant - 1234.0 -> 1233.0
   * 45 Weak Mutation 53: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:167 - DeleteStatement: setName(Ljava/lang/String;)V
   * 46 Weak Mutation 52: org.softlang.swing.model.Model.createSampleCompany(Lorg/softlang/company/factory/Factory;)Lorg/softlang/company/Company;:167 - ReplaceConstant - Ray -> 
   */
  @Test
  public void test7()  throws Throwable  {
      BeanFactory beanFactory0 = new BeanFactory();
      Model model0 = new Model((Factory) beanFactory0);
      assertNotNull(model0);
      
      CompanyImpl companyImpl0 = (CompanyImpl)model0.getCompany();
      assertNotNull(companyImpl0);
      
      model0.setCompany((Company) companyImpl0);
      assertEquals("meganalysis", companyImpl0.getName());
  }
}
