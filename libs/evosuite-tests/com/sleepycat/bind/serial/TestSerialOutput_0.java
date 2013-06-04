/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.bind.serial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.serial.ClassCatalog;
import com.sleepycat.bind.serial.SerialOutput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

@RunWith(EvoSuiteRunner.class)
public class TestSerialOutput_0 {


  //Test case number: 0
  /*
   * 14 covered goals:
   * 1 Weak Mutation 6: com.sleepycat.bind.serial.SerialOutput.writeClassDescriptor(Ljava/io/ObjectStreamClass;)V:86 - DeleteStatement: getClassID(Ljava/io/ObjectStreamClass;)[B
   * 2 com.sleepycat.bind.serial.SerialOutput.writeClassDescriptor(Ljava/io/ObjectStreamClass;)V: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> 0
   * 4 Weak Mutation 1: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> 1
   * 5 Weak Mutation 2: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> -1
   * 6 Weak Mutation 3: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> 3
   * 7 Weak Mutation 4: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - DeleteStatement: useProtocolVersion(I)V
   * 8 Weak Mutation 0: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> 0
   * 9 Weak Mutation 1: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> 1
   * 10 Weak Mutation 2: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> -1
   * 11 Weak Mutation 3: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - ReplaceConstant - 2 -> 3
   * 12 Weak Mutation 4: com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V:78 - DeleteStatement: useProtocolVersion(I)V
   * 13 Weak Mutation 6: com.sleepycat.bind.serial.SerialOutput.writeClassDescriptor(Ljava/io/ObjectStreamClass;)V:86 - DeleteStatement: getClassID(Ljava/io/ObjectStreamClass;)[B
   * 14 com.sleepycat.bind.serial.SerialOutput.<init>(Ljava/io/OutputStream;Lcom/sleepycat/bind/serial/ClassCatalog;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
      SerialOutput serialOutput0 = new SerialOutput((OutputStream) byteArrayOutputStream0, (ClassCatalog) null);
      // Undeclared exception!
      try {
        serialOutput0.writeClassDescriptor((ObjectStreamClass) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
