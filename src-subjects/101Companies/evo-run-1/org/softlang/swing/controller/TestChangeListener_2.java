/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.swing.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.plaf.metal.MetalComboBoxEditor;
import org.softlang.swing.controller.ChangeListener;
import org.softlang.swing.controller.Controller;

@RunWith(EvoSuiteRunner.class)
public class TestChangeListener_2 {


  //Test case number: 2
  /*
   * 19 covered goals:
   * 1 Weak Mutation 24: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:44 - ReplaceComparisonOperator <= -> -1
   * 2 Weak Mutation 27: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:45 - DeleteStatement: salaryChanged(Ljava/lang/String;)V
   * 3 Weak Mutation 26: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:45 - DeleteStatement: getText()Ljava/lang/String;
   * 4 org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V: I42 Branch 3 IFLE L44 - false
   * 5 Weak Mutation 0: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:39 - DeleteStatement: getComponent()Ljava/awt/Component;
   * 6 Weak Mutation 1: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:40 - DeleteField: subjectLjava/lang/String;
   * 7 Weak Mutation 2: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:40 - ReplaceConstant - address -> 
   * 8 Weak Mutation 3: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:40 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 9 Weak Mutation 4: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:40 - ReplaceComparisonOperator <= -> ==
   * 10 Weak Mutation 10: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:42 - DeleteField: subjectLjava/lang/String;
   * 11 Weak Mutation 11: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:42 - ReplaceConstant - name -> 
   * 12 Weak Mutation 12: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:42 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 13 Weak Mutation 13: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:42 - ReplaceComparisonOperator <= -> ==
   * 14 Weak Mutation 19: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:44 - DeleteField: subjectLjava/lang/String;
   * 15 Weak Mutation 21: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:44 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 16 Weak Mutation 20: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:44 - ReplaceConstant - salary -> 
   * 17 Weak Mutation 24: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:44 - ReplaceComparisonOperator <= -> -1
   * 18 Weak Mutation 27: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:45 - DeleteStatement: salaryChanged(Ljava/lang/String;)V
   * 19 Weak Mutation 26: org.softlang.swing.controller.ChangeListener.valueChanged(Ljava/awt/event/KeyEvent;)V:45 - DeleteStatement: getText()Ljava/lang/String;
   */
  @Test
  public void test2()  throws Throwable  {
      ChangeListener changeListener0 = new ChangeListener((Controller) null, "salary");
      MetalComboBoxEditor metalComboBoxEditor0 = new MetalComboBoxEditor();
      Component component0 = metalComboBoxEditor0.getEditorComponent();
      KeyEvent keyEvent0 = new KeyEvent(component0, 1125, (long) 1125, 1125, 1125, 'm');
      // Undeclared exception!
      try {
        changeListener0.keyReleased(keyEvent0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
