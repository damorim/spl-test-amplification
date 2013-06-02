/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.sef;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.sef.SEFTestTextAccess;

@RunWith(EvoSuiteRunner.class)
public class TestSEFTestTextAccess_1 {


  //Test case number: 1
  /*
   * 2 covered goals:
   * 1 Weak Mutation 36: de.susebox.jtopas.sef.SEFTestTextAccess.testGetText()V:175 - ReplaceConstant - A text to parse. -> 
   * 2 Weak Mutation 38: de.susebox.jtopas.sef.SEFTestTextAccess.testGetText()V:179 - DeleteStatement: setSource(Ljava/io/Reader;)V
   */
  @Test
  public void test1()  throws Throwable  {
      SEFTestTextAccess sEFTestTextAccess0 = new SEFTestTextAccess(".");
      try {
        sEFTestTextAccess0.testGetText();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}