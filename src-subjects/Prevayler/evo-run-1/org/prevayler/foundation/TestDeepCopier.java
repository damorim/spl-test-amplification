/*
 * This file was automatically generated by EvoSuite
 */

package org.prevayler.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.io.IOException;
import org.prevayler.foundation.DeepCopier;
import org.prevayler.foundation.serialization.JavaSerializer;
import org.prevayler.foundation.serialization.Serializer;
import org.prevayler.foundation.serialization.XStreamSerializer;

@RunWith(EvoSuiteRunner.class)
public class TestDeepCopier {


  //Test case number: 0
  /*
   * 10 covered goals:
   * 1 Weak Mutation 31: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;)Ljava/lang/Object;:17 - DeleteStatement: deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;
   * 2 Weak Mutation 32: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:26 - DeleteStatement: writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V
   * 3 Weak Mutation 33: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:27 - DeleteStatement: toByteArray()[B
   * 4 Weak Mutation 34: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:28 - DeleteStatement: readObject(Ljava/io/InputStream;)Ljava/lang/Object;
   * 5 org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;)Ljava/lang/Object;: root-Branch
   * 6 org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;: root-Branch
   * 7 Weak Mutation 31: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;)Ljava/lang/Object;:17 - DeleteStatement: deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;
   * 8 Weak Mutation 34: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:28 - DeleteStatement: readObject(Ljava/io/InputStream;)Ljava/lang/Object;
   * 9 Weak Mutation 32: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:26 - DeleteStatement: writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V
   * 10 Weak Mutation 33: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:27 - DeleteStatement: toByteArray()[B
   */
  @Test
  public void test0()  throws Throwable  {
      String string0 = (String)DeepCopier.deepCopy((Object) "en");
      assertEquals("en", string0);
  }

  //Test case number: 1
  /*
   * 3 covered goals:
   * 1 Weak Mutation 35: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:31 - DeleteStatement: unexpected(Ljava/lang/Exception;)V
   * 2 Weak Mutation 32: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:26 - DeleteStatement: writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V
   * 3 Weak Mutation 35: org.prevayler.foundation.DeepCopier.deepCopy(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:31 - DeleteStatement: unexpected(Ljava/lang/Exception;)V
   */
  @Test
  public void test1()  throws Throwable  {
      XStreamSerializer xStreamSerializer0 = new XStreamSerializer("");
      // Undeclared exception!
      try {
        DeepCopier.deepCopy((Object) null, (Serializer) xStreamSerializer0);
        fail("Expecting exception: RuntimeException");
      } catch(RuntimeException e) {
        /*
         * Unexpected Exception was thrown.
         */
      }
  }

  //Test case number: 2
  /*
   * 8 covered goals:
   * 1 Weak Mutation 36: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:46 - DeleteStatement: writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V
   * 2 Weak Mutation 38: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:49 - DeleteStatement: close()V
   * 3 Weak Mutation 0: org.prevayler.foundation.DeepCopier$Receiver.<init>(Ljava/io/InputStream;Lorg/prevayler/foundation/serialization/Serializer;)V:64 - DeleteStatement: start()V
   * 4 org.prevayler.foundation.DeepCopier$Receiver.<init>(Ljava/io/InputStream;Lorg/prevayler/foundation/serialization/Serializer;)V: root-Branch
   * 5 org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;: root-Branch
   * 6 Weak Mutation 0: org.prevayler.foundation.DeepCopier$Receiver.<init>(Ljava/io/InputStream;Lorg/prevayler/foundation/serialization/Serializer;)V:64 - DeleteStatement: start()V
   * 7 Weak Mutation 38: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:49 - DeleteStatement: close()V
   * 8 Weak Mutation 36: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:46 - DeleteStatement: writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V
   */
  @Test
  public void test2()  throws Throwable  {
      // Undeclared exception!
      try {
        DeepCopier.deepCopyParallel((Object) null, (Serializer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 3
  /*
   * 25 covered goals:
   * 1 Weak Mutation 37: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:49 - DeleteStatement: close()V
   * 2 Weak Mutation 39: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:51 - DeleteStatement: getResult()Ljava/lang/Object;
   * 3 Weak Mutation 12: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:92 - DeleteStatement: join()V
   * 4 Weak Mutation 15: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:97 - ReplaceComparisonOperator = null -> != null
   * 5 Weak Mutation 19: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:98 - ReplaceComparisonOperator = null -> != null
   * 6 Weak Mutation 22: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:99 - ReplaceComparisonOperator = null -> != null
   * 7 Weak Mutation 25: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:100 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 27: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:101 - DeleteField: _resultLjava/lang/Object;
   * 9 Weak Mutation 28: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:101 - ReplaceComparisonOperator != null -> = null
   * 10 Weak Mutation 30: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:102 - DeleteField: _resultLjava/lang/Object;
   * 11 org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;: I22 Branch 2 IFNULL L97 - true
   * 12 org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;: I34 Branch 3 IFNULL L98 - true
   * 13 org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;: I42 Branch 4 IFNULL L99 - true
   * 14 org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;: I50 Branch 5 IFNULL L100 - true
   * 15 org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;: I58 Branch 6 IFNONNULL L101 - true
   * 16 Weak Mutation 12: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:92 - DeleteStatement: join()V
   * 17 Weak Mutation 15: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:97 - ReplaceComparisonOperator = null -> != null
   * 18 Weak Mutation 19: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:98 - ReplaceComparisonOperator = null -> != null
   * 19 Weak Mutation 22: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:99 - ReplaceComparisonOperator = null -> != null
   * 20 Weak Mutation 25: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:100 - ReplaceComparisonOperator = null -> != null
   * 21 Weak Mutation 27: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:101 - DeleteField: _resultLjava/lang/Object;
   * 22 Weak Mutation 28: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:101 - ReplaceComparisonOperator != null -> = null
   * 23 Weak Mutation 30: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:102 - DeleteField: _resultLjava/lang/Object;
   * 24 Weak Mutation 39: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:51 - DeleteStatement: getResult()Ljava/lang/Object;
   * 25 Weak Mutation 37: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:49 - DeleteStatement: close()V
   */
  @Test
  public void test3()  throws Throwable  {
      JavaSerializer javaSerializer0 = new JavaSerializer();
      String string0 = (String)DeepCopier.deepCopyParallel((Object) "en", (Serializer) javaSerializer0);
      assertEquals("en", string0);
  }

  //Test case number: 4
  /*
   * 13 covered goals:
   * 1 Weak Mutation 29: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:101 - ReplaceConstant - Deep copy failed in an unknown way -> 
   * 2 org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;: I58 Branch 6 IFNONNULL L101 - false
   * 3 Weak Mutation 0: org.prevayler.foundation.DeepCopier$Receiver.<init>(Ljava/io/InputStream;Lorg/prevayler/foundation/serialization/Serializer;)V:64 - DeleteStatement: start()V
   * 4 Weak Mutation 12: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:92 - DeleteStatement: join()V
   * 5 Weak Mutation 15: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:97 - ReplaceComparisonOperator = null -> != null
   * 6 Weak Mutation 19: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:98 - ReplaceComparisonOperator = null -> != null
   * 7 Weak Mutation 22: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:99 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 25: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:100 - ReplaceComparisonOperator = null -> != null
   * 9 Weak Mutation 28: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:101 - ReplaceComparisonOperator != null -> = null
   * 10 Weak Mutation 39: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:51 - DeleteStatement: getResult()Ljava/lang/Object;
   * 11 Weak Mutation 36: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:46 - DeleteStatement: writeObject(Ljava/io/OutputStream;Ljava/lang/Object;)V
   * 12 Weak Mutation 37: org.prevayler.foundation.DeepCopier.deepCopyParallel(Ljava/lang/Object;Lorg/prevayler/foundation/serialization/Serializer;)Ljava/lang/Object;:49 - DeleteStatement: close()V
   * 13 Weak Mutation 29: org.prevayler.foundation.DeepCopier$Receiver.getResult()Ljava/lang/Object;:101 - ReplaceConstant - Deep copy failed in an unknown way -> 
   */
  @Test
  public void test4()  throws Throwable  {
      XStreamSerializer xStreamSerializer0 = new XStreamSerializer();
      // Undeclared exception!
      try {
        DeepCopier.deepCopyParallel((Object) null, (Serializer) xStreamSerializer0);
        fail("Expecting exception: RuntimeException");
      } catch(RuntimeException e) {
        /*
         * Deep copy failed in an unknown way
         */
      }
  }
}
