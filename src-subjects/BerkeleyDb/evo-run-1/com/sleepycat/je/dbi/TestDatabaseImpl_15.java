/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.dbi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import java.nio.ByteBuffer;

@RunWith(EvoSuiteRunner.class)
public class TestDatabaseImpl_15 {


  //Test case number: 15
  /*
   * 5 covered goals:
   * 1 Weak Mutation 230: com.sleepycat.je.dbi.DatabaseImpl.writeToLog(Ljava/nio/ByteBuffer;)V:1014 - DeleteStatement: writeToLog(Ljava/nio/ByteBuffer;)V
   * 2 Weak Mutation 229: com.sleepycat.je.dbi.DatabaseImpl.writeToLog(Ljava/nio/ByteBuffer;)V:1014 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   * 3 com.sleepycat.je.dbi.DatabaseImpl.writeToLog(Ljava/nio/ByteBuffer;)V: root-Branch
   * 4 Weak Mutation 230: com.sleepycat.je.dbi.DatabaseImpl.writeToLog(Ljava/nio/ByteBuffer;)V:1014 - DeleteStatement: writeToLog(Ljava/nio/ByteBuffer;)V
   * 5 Weak Mutation 229: com.sleepycat.je.dbi.DatabaseImpl.writeToLog(Ljava/nio/ByteBuffer;)V:1014 - DeleteField: idLcom/sleepycat/je/dbi/DatabaseId;
   */
  @Test
  public void test15()  throws Throwable  {
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      // Undeclared exception!
      try {
        databaseImpl0.writeToLog((ByteBuffer) null);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}