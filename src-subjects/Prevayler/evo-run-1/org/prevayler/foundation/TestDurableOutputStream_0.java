/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.prevayler.foundation.DurableOutputStream;

@RunWith(EvoSuiteRunner.class)
public class TestDurableOutputStream_0 {


  //Test case number: 0
  /*
   * 20 covered goals:
   * 1 Weak Mutation 65: org.prevayler.foundation.DurableOutputStream.close()V:117 - DeleteField: _closedZ
   * 2 org.prevayler.foundation.DurableOutputStream.close()V: I18 Branch 4 IFEQ L117 - false
   * 3 Weak Mutation 0: org.prevayler.foundation.DurableOutputStream.<init>(Ljava/io/File;)V:41 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 1: org.prevayler.foundation.DurableOutputStream.<init>(Ljava/io/File;)V:45 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 2: org.prevayler.foundation.DurableOutputStream.<init>(Ljava/io/File;)V:49 - ReplaceConstant - 0 -> 1
   * 6 Weak Mutation 3: org.prevayler.foundation.DurableOutputStream.<init>(Ljava/io/File;)V:53 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 4: org.prevayler.foundation.DurableOutputStream.<init>(Ljava/io/File;)V:57 - DeleteField: _fileOutputStreamLjava/io/FileOutputStream;
   * 8 Weak Mutation 5: org.prevayler.foundation.DurableOutputStream.<init>(Ljava/io/File;)V:57 - DeleteStatement: getFD()Ljava/io/FileDescriptor;
   * 9 Weak Mutation 63: org.prevayler.foundation.DurableOutputStream.close()V:116 - DeleteField: _writeLockLjava/lang/Object;
   * 10 Weak Mutation 62: org.prevayler.foundation.DurableOutputStream.close()V:115 - DeleteField: _syncLockLjava/lang/Object;
   * 11 Weak Mutation 68: org.prevayler.foundation.DurableOutputStream.close()V:121 - DeleteStatement: close()V
   * 12 Weak Mutation 69: org.prevayler.foundation.DurableOutputStream.internalClose()V:126 - DeleteField: _writeLockLjava/lang/Object;
   * 13 Weak Mutation 70: org.prevayler.foundation.DurableOutputStream.internalClose()V:127 - ReplaceConstant - 1 -> 0
   * 14 Weak Mutation 64: org.prevayler.foundation.DurableOutputStream.close()V:117 - InsertUnaryOp Negation
   * 15 Weak Mutation 65: org.prevayler.foundation.DurableOutputStream.close()V:117 - DeleteField: _closedZ
   * 16 Weak Mutation 66: org.prevayler.foundation.DurableOutputStream.close()V:117 - ReplaceComparisonOperator == -> !=
   * 17 Weak Mutation 67: org.prevayler.foundation.DurableOutputStream.close()V:121 - DeleteField: _fileOutputStreamLjava/io/FileOutputStream;
   * 18 org.prevayler.foundation.DurableOutputStream.internalClose()V: root-Branch
   * 19 org.prevayler.foundation.DurableOutputStream.<init>(Ljava/io/File;)V: root-Branch
   * 20 org.prevayler.foundation.DurableOutputStream.close()V: I18 Branch 4 IFEQ L117 - true
   */
  @Test
  public void test0()  throws Throwable  {
      File file0 = new File("&)W");
      DurableOutputStream durableOutputStream0 = new DurableOutputStream(file0);
      assertEquals(false, durableOutputStream0.reallyClosed());
      assertNotNull(durableOutputStream0);
      
      durableOutputStream0.close();
      durableOutputStream0.close();
      assertEquals(true, durableOutputStream0.reallyClosed());
  }
}