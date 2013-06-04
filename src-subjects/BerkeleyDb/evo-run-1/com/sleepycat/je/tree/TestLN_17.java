/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.tree.DupCountLN;
import com.sleepycat.je.tree.LN;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.NameLN;
import com.sleepycat.je.txn.Locker;

@RunWith(EvoSuiteRunner.class)
public class TestLN_17 {


  //Test case number: 17
  /*
   * 3 covered goals:
   * 1 Weak Mutation 196: com.sleepycat.je.tree.LN.countAsObsoleteWhenLogged()Z:299 - ReplaceConstant - 0 -> 1
   * 2 com.sleepycat.je.tree.LN.countAsObsoleteWhenLogged()Z: root-Branch
   * 3 Weak Mutation 196: com.sleepycat.je.tree.LN.countAsObsoleteWhenLogged()Z:299 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test17()  throws Throwable  {
      NameLN nameLN0 = new NameLN((DatabaseId) null);
      assertNotNull(nameLN0);
      
      boolean boolean0 = nameLN0.countAsObsoleteWhenLogged();
      assertEquals("<com.sleepycat.je.tree.NameLN/4294970807", nameLN0.shortDescription());
      assertEquals(false, boolean0);
  }
}
