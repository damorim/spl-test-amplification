/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.PatternIterator;
import de.susebox.jtopas.StandardTokenizerProperties;
import java.util.NoSuchElementException;

@RunWith(EvoSuiteRunner.class)
public class TestPatternIterator_2 {


  //Test case number: 2
  /*
   * 6 covered goals:
   * 1 Weak Mutation 9: de.susebox.jtopas.PatternIterator.remove()V:52 - DeleteField: _iteratorLjava/util/Iterator;
   * 2 Weak Mutation 10: de.susebox.jtopas.PatternIterator.remove()V:52 - DeleteStatement: remove()V
   * 3 de.susebox.jtopas.PatternIterator.remove()V: root-Branch
   * 4 Weak Mutation 0: de.susebox.jtopas.PatternIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:19 - DeleteField: _patternsLjava/util/ArrayList;
   * 5 Weak Mutation 1: de.susebox.jtopas.PatternIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:20 - DeleteField: _patternsLjava/util/ArrayList;
   * 6 Weak Mutation 2: de.susebox.jtopas.PatternIterator.<init>(Lde/susebox/jtopas/StandardTokenizerProperties;)V:20 - DeleteStatement: iterator()Ljava/util/Iterator;
   */
  @Test
  public void test2()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties((-1967), (String) null, (String) null);
      PatternIterator patternIterator0 = new PatternIterator(standardTokenizerProperties0);
      // Undeclared exception!
      try {
        patternIterator0.remove();
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
      }
  }
}
