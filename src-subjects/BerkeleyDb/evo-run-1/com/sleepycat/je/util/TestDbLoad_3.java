/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.util.DbLoad;
import java.io.IOException;

@RunWith(EvoSuiteRunner.class)
public class TestDbLoad_3 {


  //Test case number: 3
  /*
   * 17 covered goals:
   * 1 Weak Mutation 63: com.sleepycat.je.util.DbLoad.load()Z:188 - ReplaceComparisonOperator <= -> -1
   * 2 Weak Mutation 68: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: toString()Ljava/lang/String;
   * 3 Weak Mutation 69: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: println(Ljava/lang/String;)V
   * 4 Weak Mutation 64: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteField: outLjava/io/PrintStream;
   * 5 Weak Mutation 65: com.sleepycat.je.util.DbLoad.load()Z:189 - ReplaceConstant - Load start:  -> 
   * 6 Weak Mutation 66: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 7 Weak Mutation 67: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 8 com.sleepycat.je.util.DbLoad.load()Z: I6 Branch 19 IFLE L188 - false
   * 9 Weak Mutation 54: com.sleepycat.je.util.DbLoad.setProgressInterval(J)V:179 - InsertUnaryOp Negation
   * 10 Weak Mutation 57: com.sleepycat.je.util.DbLoad.load()Z:188 - DeleteField: progressIntervalJ
   * 11 Weak Mutation 63: com.sleepycat.je.util.DbLoad.load()Z:188 - ReplaceComparisonOperator <= -> -1
   * 12 Weak Mutation 68: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: toString()Ljava/lang/String;
   * 13 Weak Mutation 69: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: println(Ljava/lang/String;)V
   * 14 Weak Mutation 64: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteField: outLjava/io/PrintStream;
   * 15 Weak Mutation 65: com.sleepycat.je.util.DbLoad.load()Z:189 - ReplaceConstant - Load start:  -> 
   * 16 Weak Mutation 66: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 17 Weak Mutation 67: com.sleepycat.je.util.DbLoad.load()Z:189 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   */
  @Test
  public void test3()  throws Throwable  {
      DbLoad dbLoad0 = new DbLoad();
      dbLoad0.setProgressInterval(1L);
      // Undeclared exception!
      try {
        dbLoad0.load();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
