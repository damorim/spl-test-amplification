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
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;

@RunWith(EvoSuiteRunner.class)
public class TestIN_3 {


  //Test case number: 3
  /*
   * 13 covered goals:
   * 1 Weak Mutation 102: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC -1
   * 2 Weak Mutation 103: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp Negation
   * 3 Weak Mutation 100: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp Negation
   * 4 Weak Mutation 101: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC 1
   * 5 Weak Mutation 104: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 105: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC -1
   * 7 com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;: root-Branch
   * 8 Weak Mutation 102: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC -1
   * 9 Weak Mutation 103: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp Negation
   * 10 Weak Mutation 100: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp Negation
   * 11 Weak Mutation 101: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC 1
   * 12 Weak Mutation 104: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 105: com.sleepycat.je.tree.IN.createNewInstance([BII)Lcom/sleepycat/je/tree/IN;:192 - InsertUnaryOp IINC -1
   */
  @Test
  public void test3()  throws Throwable  {
      IN iN0 = new IN();
      assertNotNull(iN0);
      
      // Undeclared exception!
      try {
        iN0.createNewInstance((byte[]) null, 1356, 22);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
