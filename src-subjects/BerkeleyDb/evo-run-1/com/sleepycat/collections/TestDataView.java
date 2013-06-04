/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.bind.ByteArrayBinding;
import com.sleepycat.bind.EntityBinding;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.collections.DataView;
import com.sleepycat.collections.PrimaryKeyAssigner;
import com.sleepycat.je.Database;

@RunWith(EvoSuiteRunner.class)
public class TestDataView {


  //Test case number: 0
  /*
   * 5 covered goals:
   * 1 Weak Mutation 0: com.sleepycat.collections.DataView.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntityBinding;ZLcom/sleepycat/collections/PrimaryKeyAssigner;)V:72 - ReplaceComparisonOperator != null -> = null
   * 2 Weak Mutation 1: com.sleepycat.collections.DataView.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntityBinding;ZLcom/sleepycat/collections/PrimaryKeyAssigner;)V:73 - ReplaceConstant - database is null -> 
   * 3 com.sleepycat.collections.DataView.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntityBinding;ZLcom/sleepycat/collections/PrimaryKeyAssigner;)V: I7 Branch 1 IFNONNULL L72 - false
   * 4 Weak Mutation 0: com.sleepycat.collections.DataView.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntityBinding;ZLcom/sleepycat/collections/PrimaryKeyAssigner;)V:72 - ReplaceComparisonOperator != null -> = null
   * 5 Weak Mutation 1: com.sleepycat.collections.DataView.<init>(Lcom/sleepycat/je/Database;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntryBinding;Lcom/sleepycat/bind/EntityBinding;ZLcom/sleepycat/collections/PrimaryKeyAssigner;)V:73 - ReplaceConstant - database is null -> 
   */
  @Test
  public void test0()  throws Throwable  {
      ByteArrayBinding byteArrayBinding0 = new ByteArrayBinding();
      DataView dataView0 = null;
      try {
        dataView0 = new DataView((Database) null, (EntryBinding) byteArrayBinding0, (EntryBinding) byteArrayBinding0, (EntityBinding) null, false, (PrimaryKeyAssigner) null);
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * database is null
         */
      }
  }
}