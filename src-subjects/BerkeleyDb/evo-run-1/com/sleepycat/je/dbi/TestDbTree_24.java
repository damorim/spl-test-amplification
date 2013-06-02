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
import com.sleepycat.je.dbi.DbTree;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogException;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Locker;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RunWith(EvoSuiteRunner.class)
public class TestDbTree_24 {


  //Test case number: 24
  /*
   * 5 covered goals:
   * 1 Weak Mutation 386: com.sleepycat.je.dbi.DbTree.getTransactionId()J:925 - ReplaceConstant - 0 -> -1
   * 2 Weak Mutation 385: com.sleepycat.je.dbi.DbTree.getTransactionId()J:925 - ReplaceConstant - 0 -> 1
   * 3 com.sleepycat.je.dbi.DbTree.getTransactionId()J: root-Branch
   * 4 Weak Mutation 386: com.sleepycat.je.dbi.DbTree.getTransactionId()J:925 - ReplaceConstant - 0 -> -1
   * 5 Weak Mutation 385: com.sleepycat.je.dbi.DbTree.getTransactionId()J:925 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test24()  throws Throwable  {
      DbTree dbTree0 = new DbTree();
      assertNotNull(dbTree0);
      
      long long0 = dbTree0.getTransactionId();
      assertEquals(0L, long0);
  }
}