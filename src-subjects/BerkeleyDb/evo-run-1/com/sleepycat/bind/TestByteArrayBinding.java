/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.bind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.ByteArrayBinding;
import com.sleepycat.je.DatabaseEntry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.evosuite.Properties.SandboxMode;
import org.evosuite.sandbox.Sandbox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

@RunWith(EvoSuiteRunner.class)
public class TestByteArrayBinding {

  private static ExecutorService executor; 

  @BeforeClass 
  public static void initEvoSuiteFramework(){ 
    org.evosuite.Properties.REPLACE_CALLS = false; 
    org.evosuite.Properties.SANDBOX_MODE = SandboxMode.RECOMMENDED; 
    Sandbox.initializeSecurityManagerForSUT(); 
    executor = Executors.newCachedThreadPool(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    executor.shutdownNow(); 
    Sandbox.resetDefaultSecurityManager(); 
  } 

  @Before 
  public void initTestCase(){ 
    Sandbox.goingToExecuteSUTCode(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    Sandbox.doneWithExecutingSUTCode(); 
  } 


  //Test case number: 0
  /*
   * 14 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:36 - DeleteStatement: getSize()I
   * 2 Weak Mutation 1: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp Negation of len
   * 3 Weak Mutation 2: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC 1 len
   * 4 Weak Mutation 3: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC -1 len
   * 5 Weak Mutation 6: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> -1
   * 6 Weak Mutation 7: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:38 - DeleteField: ZERO_LENGTH_BYTE_ARRAY[B
   * 7 com.sleepycat.bind.ByteArrayBinding.<init>()V: root-Branch
   * 8 com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;: I8 Branch 1 IFNE L37 - false
   * 9 Weak Mutation 0: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:36 - DeleteStatement: getSize()I
   * 10 Weak Mutation 1: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp Negation of len
   * 11 Weak Mutation 2: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC 1 len
   * 12 Weak Mutation 3: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC -1 len
   * 13 Weak Mutation 6: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> -1
   * 14 Weak Mutation 7: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:38 - DeleteField: ZERO_LENGTH_BYTE_ARRAY[B
   */
  @Test
  public void test0()  throws Throwable  {
      ByteArrayBinding byteArrayBinding0 = new ByteArrayBinding();
      DatabaseEntry databaseEntry0 = new DatabaseEntry();
      Object object0 = byteArrayBinding0.entryToObject(databaseEntry0);
      assertNotNull(object0);
  }

  //Test case number: 1
  /*
   * 19 covered goals:
   * 1 Weak Mutation 15: com.sleepycat.bind.ByteArrayBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:51 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 16: com.sleepycat.bind.ByteArrayBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:51 - DeleteStatement: setData([BII)V
   * 3 com.sleepycat.bind.ByteArrayBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V: root-Branch
   * 4 Weak Mutation 4: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> <
   * 5 Weak Mutation 11: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:41 - DeleteStatement: getData()[B
   * 6 Weak Mutation 12: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:41 - DeleteStatement: getOffset()I
   * 7 Weak Mutation 13: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:42 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 14: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:41 - DeleteStatement: arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
   * 9 Weak Mutation 4: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> <
   * 10 Weak Mutation 8: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp Negation of len
   * 11 Weak Mutation 9: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC 1 len
   * 12 Weak Mutation 10: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC -1 len
   * 13 Weak Mutation 11: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:41 - DeleteStatement: getData()[B
   * 14 Weak Mutation 12: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:41 - DeleteStatement: getOffset()I
   * 15 Weak Mutation 13: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:42 - ReplaceConstant - 0 -> 1
   * 16 Weak Mutation 14: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:41 - DeleteStatement: arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
   * 17 Weak Mutation 15: com.sleepycat.bind.ByteArrayBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:51 - ReplaceConstant - 0 -> 1
   * 18 Weak Mutation 16: com.sleepycat.bind.ByteArrayBinding.objectToEntry(Ljava/lang/Object;Lcom/sleepycat/je/DatabaseEntry;)V:51 - DeleteStatement: setData([BII)V
   * 19 com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;: I8 Branch 1 IFNE L37 - true
   */
  @Test
  public void test1()  throws Throwable  {
    Future<?> future = executor.submit(new Runnable(){ 
            public void run() { 
          ByteArrayBinding byteArrayBinding0 = new ByteArrayBinding();
          byte[] byteArray0 = new byte[7];
          DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0);
          Object object0 = byteArrayBinding0.entryToObject(databaseEntry0);
          assertNotNull(object0);
          
          byteArrayBinding0.objectToEntry(object0, databaseEntry0);
          assertEquals("<DatabaseEntry dlen=0 doff=0 doff=0 offset=0 size=7>", databaseEntry0.toString());
          assertEquals(7, databaseEntry0.getSize());
      } 
    }); 
    future.get(6000, TimeUnit.MILLISECONDS); 
  }

  //Test case number: 2
  /*
   * 9 covered goals:
   * 1 Weak Mutation 5: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> >
   * 2 Weak Mutation 0: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:36 - DeleteStatement: getSize()I
   * 3 Weak Mutation 1: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp Negation of len
   * 4 Weak Mutation 2: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC 1 len
   * 5 Weak Mutation 3: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - InsertUnaryOp IINC -1 len
   * 6 Weak Mutation 8: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp Negation of len
   * 7 Weak Mutation 9: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC 1 len
   * 8 Weak Mutation 10: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:40 - InsertUnaryOp IINC -1 len
   * 9 Weak Mutation 5: com.sleepycat.bind.ByteArrayBinding.entryToObject(Lcom/sleepycat/je/DatabaseEntry;)Ljava/lang/Object;:37 - ReplaceComparisonOperator != -> >
   */
  @Test
  public void test2()  throws Throwable  {
      ByteArrayBinding byteArrayBinding0 = new ByteArrayBinding();
      byte[] byteArray0 = new byte[3];
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0, (-950), (int) (byte) (-74));
      // Undeclared exception!
      try {
        byteArrayBinding0.entryToObject(databaseEntry0);
        fail("Expecting exception: NegativeArraySizeException");
      } catch(NegativeArraySizeException e) {
      }
  }
}
