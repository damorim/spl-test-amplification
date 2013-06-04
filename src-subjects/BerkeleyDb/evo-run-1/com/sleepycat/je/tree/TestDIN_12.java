/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;

@RunWith(EvoSuiteRunner.class)
public class TestDIN_12 {


  //Test case number: 12
  /*
   * 5 covered goals:
   * 1 Weak Mutation 40: com.sleepycat.je.tree.DIN.getKeyComparator()Ljava/util/Comparator;:158 - DeleteStatement: getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 2 Weak Mutation 41: com.sleepycat.je.tree.DIN.getKeyComparator()Ljava/util/Comparator;:158 - DeleteStatement: getDuplicateComparator()Ljava/util/Comparator;
   * 3 com.sleepycat.je.tree.DIN.getKeyComparator()Ljava/util/Comparator;: root-Branch
   * 4 Weak Mutation 40: com.sleepycat.je.tree.DIN.getKeyComparator()Ljava/util/Comparator;:158 - DeleteStatement: getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 5 Weak Mutation 41: com.sleepycat.je.tree.DIN.getKeyComparator()Ljava/util/Comparator;:158 - DeleteStatement: getDuplicateComparator()Ljava/util/Comparator;
   */
  @Test
  public void test12()  throws Throwable  {
      DIN dIN0 = new DIN();
      // Undeclared exception!
      try {
        dIN0.getKeyComparator();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
