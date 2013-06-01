/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogBuffer;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestLogBuffer_3 {


  //Test case number: 3
  /*
   * 8 covered goals:
   * 1 Weak Mutation 13: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp Negation
   * 2 Weak Mutation 14: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC 1
   * 3 Weak Mutation 15: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC -1
   * 4 Weak Mutation 17: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteStatement: capacity()I
   * 5 Weak Mutation 13: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp Negation
   * 6 Weak Mutation 14: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC 1
   * 7 Weak Mutation 15: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC -1
   * 8 Weak Mutation 17: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteStatement: capacity()I
   */
  @Test
  public void test3()  throws Throwable  {
      LogBuffer logBuffer0 = new LogBuffer((ByteBuffer) null, 9L);
      // Undeclared exception!
      try {
        logBuffer0.hasRoom((-1989));
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
