/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.prevayler.foundation.Chunk;

@RunWith(EvoSuiteRunner.class)
public class TestChunk_2 {


  //Test case number: 2
  /*
   * 5 covered goals:
   * 1 Weak Mutation 3: org.prevayler.foundation.Chunk.getParameter(Ljava/lang/String;)Ljava/lang/String;:21 - DeleteField: _parametersLjava/util/Map;
   * 2 Weak Mutation 4: org.prevayler.foundation.Chunk.getParameter(Ljava/lang/String;)Ljava/lang/String;:21 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   * 3 org.prevayler.foundation.Chunk.getParameter(Ljava/lang/String;)Ljava/lang/String;: root-Branch
   * 4 Weak Mutation 3: org.prevayler.foundation.Chunk.getParameter(Ljava/lang/String;)Ljava/lang/String;:21 - DeleteField: _parametersLjava/util/Map;
   * 5 Weak Mutation 4: org.prevayler.foundation.Chunk.getParameter(Ljava/lang/String;)Ljava/lang/String;:21 - DeleteStatement: get(Ljava/lang/Object;)Ljava/lang/Object;
   */
  @Test
  public void test2()  throws Throwable  {
      byte[] byteArray0 = new byte[4];
      Chunk chunk0 = new Chunk(byteArray0);
      String string0 = chunk0.getParameter("p%[M+3i-*vqg61P$");
      assertNull(string0);
  }
}