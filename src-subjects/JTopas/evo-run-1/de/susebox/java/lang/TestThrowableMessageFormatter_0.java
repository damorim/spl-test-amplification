/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.java.lang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.java.lang.ThrowableList;
import de.susebox.java.lang.ThrowableMessageFormatter;

@RunWith(EvoSuiteRunner.class)
public class TestThrowableMessageFormatter_0 {


  //Test case number: 0
  /*
   * 2 covered goals:
   * 1 Weak Mutation 0: de.susebox.java.lang.ThrowableMessageFormatter.getMessage(Lde/susebox/java/lang/ThrowableList;)Ljava/lang/String;:98 - DeleteStatement: isWrapper()Z
   * 2 Weak Mutation 0: de.susebox.java.lang.ThrowableMessageFormatter.getMessage(Lde/susebox/java/lang/ThrowableList;)Ljava/lang/String;:98 - DeleteStatement: isWrapper()Z
   */
  @Test
  public void test0()  throws Throwable  {
      // Undeclared exception!
      try {
        ThrowableMessageFormatter.getMessage((ThrowableList) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}