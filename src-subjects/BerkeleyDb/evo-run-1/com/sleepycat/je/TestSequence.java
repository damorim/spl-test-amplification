/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.Sequence;
import com.sleepycat.je.SequenceConfig;
import com.sleepycat.je.Transaction;

@RunWith(EvoSuiteRunner.class)
public class TestSequence {


  //Test case number: 0
  /*
   * 4 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.je.Sequence.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/Transaction;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)V:46 - DeleteStatement: getDatabaseImpl()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 2 Weak Mutation 1: com.sleepycat.je.Sequence.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/Transaction;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)V:46 - DeleteStatement: getSortedDuplicates()Z
   * 3 Weak Mutation 0: com.sleepycat.je.Sequence.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/Transaction;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)V:46 - DeleteStatement: getDatabaseImpl()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 4 Weak Mutation 1: com.sleepycat.je.Sequence.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/je/Transaction;Lcom/sleepycat/je/DatabaseEntry;Lcom/sleepycat/je/SequenceConfig;)V:46 - DeleteStatement: getSortedDuplicates()Z
   */
  @Test
  public void test0()  throws Throwable  {
      byte[] byteArray0 = new byte[2];
      Database database0 = new Database((Environment) null);
      DatabaseEntry databaseEntry0 = new DatabaseEntry(byteArray0);
      SequenceConfig sequenceConfig0 = new SequenceConfig();
      Sequence sequence0 = null;
      try {
        sequence0 = new Sequence(database0, (Transaction) null, databaseEntry0, sequenceConfig0);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
