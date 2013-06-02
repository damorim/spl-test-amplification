/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation.serialization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.prevayler.foundation.serialization.XStreamSerializer;

@RunWith(EvoSuiteRunner.class)
public class TestXStreamSerializer_2 {


  //Test case number: 2
  /*
   * 7 covered goals:
   * 1 Weak Mutation 7: org.prevayler.foundation.serialization.XStreamSerializer.writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V:48 - DeleteStatement: toXML(Ljava/lang/Object;Ljava/io/Writer;)V
   * 2 Weak Mutation 8: org.prevayler.foundation.serialization.XStreamSerializer.writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V:49 - DeleteStatement: flush()V
   * 3 org.prevayler.foundation.serialization.XStreamSerializer.<init>()V: root-Branch
   * 4 org.prevayler.foundation.serialization.XStreamSerializer.writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V: I4 Branch 1 IFNONNULL L47 - false
   * 5 Weak Mutation 5: org.prevayler.foundation.serialization.XStreamSerializer.writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V:47 - ReplaceComparisonOperator != null -> = null
   * 6 Weak Mutation 7: org.prevayler.foundation.serialization.XStreamSerializer.writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V:48 - DeleteStatement: toXML(Ljava/lang/Object;Ljava/io/Writer;)V
   * 7 Weak Mutation 8: org.prevayler.foundation.serialization.XStreamSerializer.writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V:49 - DeleteStatement: flush()V
   */
  @Test
  public void test2()  throws Throwable  {
      XStreamSerializer xStreamSerializer0 = new XStreamSerializer();
      PrintStream printStream0 = new PrintStream("list");
      xStreamSerializer0.writeObject((OutputStream) printStream0, (Object) "/private/var/folders/nq/zr797mk520g827f_9zncfn9r0000gn/T/list5597261390545956507list");
      assertEquals(false, printStream0.checkError());
  }
}