/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.swing.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.company.Component;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.company.impl.pojo.CompanyImpl;
import org.softlang.swing.model.Model;
import org.softlang.swing.view.CompanyView;

@RunWith(EvoSuiteRunner.class)
public class TestCompanyView_0 {


  //Test case number: 0
  /*
   * 82 covered goals:
   * 1 Weak Mutation 0: org.softlang.swing.view.CompanyView.<init>(Lorg/softlang/swing/model/Model;)V:32 - ReplaceConstant - 1 -> 0
   * 2 Weak Mutation 1: org.softlang.swing.view.CompanyView.<init>(Lorg/softlang/swing/model/Model;)V:32 - DeleteStatement: setVisible(Z)V
   * 3 Weak Mutation 2: org.softlang.swing.view.CompanyView.createView()V:39 - DeleteField: modelLorg/softlang/swing/model/Model;
   * 4 Weak Mutation 3: org.softlang.swing.view.CompanyView.createView()V:39 - DeleteStatement: getCurrentValue()Lorg/softlang/company/Component;
   * 5 Weak Mutation 4: org.softlang.swing.view.CompanyView.createView()V:40 - DeleteStatement: setLayout(Ljava/awt/LayoutManager;)V
   * 6 Weak Mutation 5: org.softlang.swing.view.CompanyView.createView()V:44 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 6: org.softlang.swing.view.CompanyView.createView()V:45 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 7: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 0
   * 9 Weak Mutation 8: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 1
   * 10 Weak Mutation 9: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> -1
   * 11 Weak Mutation 10: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 9
   * 12 Weak Mutation 11: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 11
   * 13 Weak Mutation 12: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 0
   * 14 Weak Mutation 13: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 1
   * 15 Weak Mutation 14: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> -1
   * 16 Weak Mutation 15: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 9
   * 17 Weak Mutation 17: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 16: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 11
   * 19 Weak Mutation 18: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 0 -> 1
   * 20 Weak Mutation 19: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 0
   * 21 Weak Mutation 21: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> -1
   * 22 Weak Mutation 20: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 1
   * 23 Weak Mutation 23: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 18
   * 24 Weak Mutation 22: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 16
   * 25 Weak Mutation 25: org.softlang.swing.view.CompanyView.createView()V:48 - DeleteStatement: add(Ljava/awt/Component;Ljava/lang/Object;)V
   * 26 Weak Mutation 24: org.softlang.swing.view.CompanyView.createView()V:48 - ReplaceConstant - Name:  -> 
   * 27 Weak Mutation 26: org.softlang.swing.view.CompanyView.createView()V:50 - ReplaceConstant - 1 -> 0
   * 28 Weak Mutation 27: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> 0
   * 29 Weak Mutation 29: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> -1
   * 30 Weak Mutation 28: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> 1
   * 31 Weak Mutation 30: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> 3
   * 32 Weak Mutation 31: org.softlang.swing.view.CompanyView.createView()V:52 - ReplaceConstant - 1.0 -> 0.0
   * 33 Weak Mutation 32: org.softlang.swing.view.CompanyView.createView()V:52 - ReplaceConstant - 1.0 -> -1.0
   * 34 Weak Mutation 33: org.softlang.swing.view.CompanyView.createView()V:52 - ReplaceConstant - 1.0 -> 2.0
   * 35 Weak Mutation 34: org.softlang.swing.view.CompanyView.createView()V:53 - DeleteField: nameLjavax/swing/JTextField;
   * 36 Weak Mutation 35: org.softlang.swing.view.CompanyView.createView()V:53 - DeleteStatement: getName()Ljava/lang/String;
   * 37 Weak Mutation 36: org.softlang.swing.view.CompanyView.createView()V:53 - DeleteStatement: setText(Ljava/lang/String;)V
   * 38 Weak Mutation 38: org.softlang.swing.view.CompanyView.createView()V:54 - DeleteStatement: add(Ljava/awt/Component;Ljava/lang/Object;)V
   * 39 Weak Mutation 37: org.softlang.swing.view.CompanyView.createView()V:54 - DeleteField: nameLjavax/swing/JTextField;
   * 40 Weak Mutation 39: org.softlang.swing.view.CompanyView.createView()V:65 - ReplaceConstant - 1 -> 0
   * 41 org.softlang.swing.view.CompanyView.<init>(Lorg/softlang/swing/model/Model;)V: root-Branch
   * 42 org.softlang.swing.view.CompanyView.createView()V: root-Branch
   * 43 Weak Mutation 0: org.softlang.swing.view.CompanyView.<init>(Lorg/softlang/swing/model/Model;)V:32 - ReplaceConstant - 1 -> 0
   * 44 Weak Mutation 1: org.softlang.swing.view.CompanyView.<init>(Lorg/softlang/swing/model/Model;)V:32 - DeleteStatement: setVisible(Z)V
   * 45 Weak Mutation 2: org.softlang.swing.view.CompanyView.createView()V:39 - DeleteField: modelLorg/softlang/swing/model/Model;
   * 46 Weak Mutation 3: org.softlang.swing.view.CompanyView.createView()V:39 - DeleteStatement: getCurrentValue()Lorg/softlang/company/Component;
   * 47 Weak Mutation 4: org.softlang.swing.view.CompanyView.createView()V:40 - DeleteStatement: setLayout(Ljava/awt/LayoutManager;)V
   * 48 Weak Mutation 5: org.softlang.swing.view.CompanyView.createView()V:44 - ReplaceConstant - 0 -> 1
   * 49 Weak Mutation 6: org.softlang.swing.view.CompanyView.createView()V:45 - ReplaceConstant - 0 -> 1
   * 50 Weak Mutation 7: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 0
   * 51 Weak Mutation 8: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 1
   * 52 Weak Mutation 9: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> -1
   * 53 Weak Mutation 10: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 9
   * 54 Weak Mutation 11: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 11
   * 55 Weak Mutation 12: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 0
   * 56 Weak Mutation 13: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 1
   * 57 Weak Mutation 14: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> -1
   * 58 Weak Mutation 15: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 9
   * 59 Weak Mutation 17: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 0 -> 1
   * 60 Weak Mutation 16: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 10 -> 11
   * 61 Weak Mutation 19: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 0
   * 62 Weak Mutation 18: org.softlang.swing.view.CompanyView.createView()V:46 - ReplaceConstant - 0 -> 1
   * 63 Weak Mutation 21: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> -1
   * 64 Weak Mutation 20: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 1
   * 65 Weak Mutation 23: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 18
   * 66 Weak Mutation 22: org.softlang.swing.view.CompanyView.createView()V:47 - ReplaceConstant - 17 -> 16
   * 67 Weak Mutation 25: org.softlang.swing.view.CompanyView.createView()V:48 - DeleteStatement: add(Ljava/awt/Component;Ljava/lang/Object;)V
   * 68 Weak Mutation 24: org.softlang.swing.view.CompanyView.createView()V:48 - ReplaceConstant - Name:  -> 
   * 69 Weak Mutation 27: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> 0
   * 70 Weak Mutation 26: org.softlang.swing.view.CompanyView.createView()V:50 - ReplaceConstant - 1 -> 0
   * 71 Weak Mutation 29: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> -1
   * 72 Weak Mutation 28: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> 1
   * 73 Weak Mutation 31: org.softlang.swing.view.CompanyView.createView()V:52 - ReplaceConstant - 1.0 -> 0.0
   * 74 Weak Mutation 30: org.softlang.swing.view.CompanyView.createView()V:51 - ReplaceConstant - 2 -> 3
   * 75 Weak Mutation 34: org.softlang.swing.view.CompanyView.createView()V:53 - DeleteField: nameLjavax/swing/JTextField;
   * 76 Weak Mutation 35: org.softlang.swing.view.CompanyView.createView()V:53 - DeleteStatement: getName()Ljava/lang/String;
   * 77 Weak Mutation 32: org.softlang.swing.view.CompanyView.createView()V:52 - ReplaceConstant - 1.0 -> -1.0
   * 78 Weak Mutation 33: org.softlang.swing.view.CompanyView.createView()V:52 - ReplaceConstant - 1.0 -> 2.0
   * 79 Weak Mutation 38: org.softlang.swing.view.CompanyView.createView()V:54 - DeleteStatement: add(Ljava/awt/Component;Ljava/lang/Object;)V
   * 80 Weak Mutation 39: org.softlang.swing.view.CompanyView.createView()V:65 - ReplaceConstant - 1 -> 0
   * 81 Weak Mutation 36: org.softlang.swing.view.CompanyView.createView()V:53 - DeleteStatement: setText(Ljava/lang/String;)V
   * 82 Weak Mutation 37: org.softlang.swing.view.CompanyView.createView()V:54 - DeleteField: nameLjavax/swing/JTextField;
   */
  @Test
  public void test0()  throws Throwable  {
      PojoFactory pojoFactory0 = new PojoFactory();
      Model model0 = new Model((Factory) pojoFactory0);
      CompanyImpl companyImpl0 = (CompanyImpl)pojoFactory0.mkCompany();
      model0.setCurrentValue((Component) companyImpl0);
      CompanyView companyView0 = new CompanyView(model0);
      assertNotNull(companyView0);
      assertEquals("org.softlang.swing.view.CompanyView[,0,0,0x0,invalid,layout=java.awt.GridBagLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]", companyView0.toString());
      assertEquals(3, companyView0.countComponents());
  }
}
