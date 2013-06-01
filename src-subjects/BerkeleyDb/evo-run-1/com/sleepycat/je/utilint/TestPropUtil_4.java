/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.utilint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.utilint.PropUtil;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@RunWith(EvoSuiteRunner.class)
public class TestPropUtil_4 {


  //Test case number: 4
  /*
   * 13 covered goals:
   * 1 com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;: I24 Branch 5 IFEQ L35 - true
   * 2 Weak Mutation 9: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:29 - ReplaceComparisonOperator != null -> = null
   * 3 Weak Mutation 10: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:33 - DeleteStatement: size()I
   * 4 Weak Mutation 13: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:33 - ReplaceComparisonOperator <= -> -1
   * 5 Weak Mutation 14: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:34 - DeleteStatement: propertyNames()Ljava/util/Enumeration;
   * 6 Weak Mutation 15: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:35 - DeleteStatement: hasMoreElements()Z
   * 7 Weak Mutation 17: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:36 - DeleteStatement: nextElement()Ljava/lang/Object;
   * 8 Weak Mutation 16: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:35 - ReplaceComparisonOperator == -> !=
   * 9 Weak Mutation 19: com.sleepycat.je.utilint.PropUtil.validateProp(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V:47 - DeleteStatement: collectionContains(Ljava/util/Collection;Ljava/lang/Object;)I
   * 10 Weak Mutation 18: com.sleepycat.je.utilint.PropUtil.validateProps(Ljava/util/Properties;Ljava/util/Set;Ljava/lang/String;)Ljava/util/Properties;:37 - DeleteStatement: validateProp(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V
   * 11 Weak Mutation 22: com.sleepycat.je.utilint.PropUtil.validateProp(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V:47 - ReplaceComparisonOperator > -> -2
   * 12 Weak Mutation 22: com.sleepycat.je.utilint.PropUtil.validateProp(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V:47 - ReplaceComparisonOperator > -> -2
   * 13 com.sleepycat.je.utilint.PropUtil.validateProp(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V: I5 Branch 6 IFGT L47 - true
   */
  @Test
  public void test4()  throws Throwable  {
      HashSet<String> hashSet0 = new HashSet<String>();
      Properties properties0 = new Properties();
      hashSet0.add(" is not a valid properqy for ");
      properties0.put((Object) " is not a valid properqy for ", (Object) "");
      Properties properties1 = PropUtil.validateProps(properties0, (Set) hashSet0, " is not a valid properqy for ");
      assertNotNull(properties1);
      assertEquals(1, properties1.size());
  }
}
