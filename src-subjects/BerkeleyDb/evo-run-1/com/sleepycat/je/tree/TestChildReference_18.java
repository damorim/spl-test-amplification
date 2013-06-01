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
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.tree.Node;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestChildReference_18 {


  //Test case number: 18
  /*
   * 4 covered goals:
   * 1 Weak Mutation 167: com.sleepycat.je.tree.ChildReference.writeToLog(Ljava/nio/ByteBuffer;)V:198 - DeleteStatement: writeByteArray(Ljava/nio/ByteBuffer;[B)V
   * 2 Weak Mutation 166: com.sleepycat.je.tree.ChildReference.writeToLog(Ljava/nio/ByteBuffer;)V:198 - DeleteField: key[B
   * 3 Weak Mutation 167: com.sleepycat.je.tree.ChildReference.writeToLog(Ljava/nio/ByteBuffer;)V:198 - DeleteStatement: writeByteArray(Ljava/nio/ByteBuffer;[B)V
   * 4 Weak Mutation 166: com.sleepycat.je.tree.ChildReference.writeToLog(Ljava/nio/ByteBuffer;)V:198 - DeleteField: key[B
   */
  @Test
  public void test18()  throws Throwable  {
      ChildReference childReference0 = new ChildReference();
      // Undeclared exception!
      try {
        childReference0.writeToLog((ByteBuffer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
