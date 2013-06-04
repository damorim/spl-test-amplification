/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.config.ShortConfigParam;

@RunWith(EvoSuiteRunner.class)
public class TestShortConfigParam {


  //Test case number: 0
  /*
   * 66 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - ReplaceComparisonOperator >= -> ==
   * 2 Weak Mutation 30: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:21 - DeleteField: maxLjava/lang/Short;
   * 3 Weak Mutation 32: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - DeleteField: maxLjava/lang/Short;
   * 4 Weak Mutation 33: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - DeleteStatement: compareTo(Ljava/lang/Short;)I
   * 5 Weak Mutation 36: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - ReplaceComparisonOperator <= -> -1
   * 6 Weak Mutation 38: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 7 Weak Mutation 39: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 8 Weak Mutation 37: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 9 Weak Mutation 42: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant -  param  -> 
   * 10 Weak Mutation 43: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 40: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant - : -> 
   * 12 Weak Mutation 41: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 13 Weak Mutation 46: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 14 Weak Mutation 47: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant -  doesn't validate,  -> 
   * 15 Weak Mutation 44: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceVariable name -> CONFIG_DELIM
   * 16 Weak Mutation 45: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteField: nameLjava/lang/String;
   * 17 Weak Mutation 51: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 18 Weak Mutation 50: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant -  is greater than max of  -> 
   * 19 Weak Mutation 49: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 20 Weak Mutation 48: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 21 Weak Mutation 54: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: toString()Ljava/lang/String;
   * 22 Weak Mutation 53: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 23 Weak Mutation 52: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteField: maxLjava/lang/Short;
   * 24 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I48 Branch 4 IFNULL L21 - false
   * 25 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I55 Branch 5 IFLE L22 - false
   * 26 Weak Mutation 0: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> maxVal
   * 27 Weak Mutation 1: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> defaultValue
   * 28 Weak Mutation 2: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> minVal
   * 29 Weak Mutation 3: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> defaultValue
   * 30 Weak Mutation 4: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:15 - ReplaceComparisonOperator = null -> != null
   * 31 Weak Mutation 5: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:16 - DeleteField: minLjava/lang/Short;
   * 32 Weak Mutation 6: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:16 - ReplaceComparisonOperator = null -> != null
   * 33 Weak Mutation 7: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - DeleteField: minLjava/lang/Short;
   * 34 Weak Mutation 8: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - DeleteStatement: compareTo(Ljava/lang/Short;)I
   * 35 Weak Mutation 9: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - ReplaceComparisonOperator >= -> ==
   * 36 Weak Mutation 31: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:21 - ReplaceComparisonOperator = null -> != null
   * 37 Weak Mutation 30: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:21 - DeleteField: maxLjava/lang/Short;
   * 38 Weak Mutation 32: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - DeleteField: maxLjava/lang/Short;
   * 39 Weak Mutation 33: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - DeleteStatement: compareTo(Ljava/lang/Short;)I
   * 40 Weak Mutation 38: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 41 Weak Mutation 39: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 42 Weak Mutation 36: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - ReplaceComparisonOperator <= -> -1
   * 43 Weak Mutation 37: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 44 Weak Mutation 42: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant -  param  -> 
   * 45 Weak Mutation 43: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 46 Weak Mutation 40: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant - : -> 
   * 47 Weak Mutation 41: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 48 Weak Mutation 46: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 49 Weak Mutation 47: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant -  doesn't validate,  -> 
   * 50 Weak Mutation 44: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceVariable name -> CONFIG_DELIM
   * 51 Weak Mutation 45: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteField: nameLjava/lang/String;
   * 52 Weak Mutation 51: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 53 Weak Mutation 50: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - ReplaceConstant -  is greater than max of  -> 
   * 54 Weak Mutation 49: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 55 Weak Mutation 48: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 56 Weak Mutation 55: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:30 - ReplaceVariable value -> CONFIG_DELIM
   * 57 Weak Mutation 54: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: toString()Ljava/lang/String;
   * 58 Weak Mutation 53: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 59 Weak Mutation 52: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:23 - DeleteField: maxLjava/lang/Short;
   * 60 com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V: root-Branch
   * 61 com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V: root-Branch
   * 62 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I3 Branch 1 IFNULL L15 - false
   * 63 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I8 Branch 2 IFNULL L16 - true
   * 64 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I8 Branch 2 IFNULL L16 - false
   * 65 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I15 Branch 3 IFGE L17 - true
   * 66 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I48 Branch 4 IFNULL L21 - true
   */
  @Test
  public void test0()  throws Throwable  {
      Short short0 = new Short((short) (-953));
      ShortConfigParam shortConfigParam0 = new ShortConfigParam("sRd1)", (Short) (short) (-953), short0, (Short) (short) (-28), false, "sRd1)");
      assertNotNull(shortConfigParam0);
      
      try {
        shortConfigParam0.validate();
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * com.sleepycat.je.config.ShortConfigParam: param sRd1) doesn't validate, -28 is greater than max of -953
         */
      }
  }

  //Test case number: 1
  /*
   * 40 covered goals:
   * 1 Weak Mutation 11: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - ReplaceComparisonOperator >= -> -1
   * 2 Weak Mutation 12: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 3 Weak Mutation 13: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 4 Weak Mutation 14: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 5 Weak Mutation 15: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant - : -> 
   * 6 Weak Mutation 17: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant -  param  -> 
   * 7 Weak Mutation 16: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 8 Weak Mutation 19: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceVariable name -> CONFIG_DELIM
   * 9 Weak Mutation 18: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 10 Weak Mutation 21: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 20: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteField: nameLjava/lang/String;
   * 12 Weak Mutation 23: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 13 Weak Mutation 22: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant -  doesn't validate,  -> 
   * 14 Weak Mutation 25: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant -  is less than min of  -> 
   * 15 Weak Mutation 24: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 16 Weak Mutation 27: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteField: minLjava/lang/Short;
   * 17 Weak Mutation 26: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 18 Weak Mutation 29: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: toString()Ljava/lang/String;
   * 19 Weak Mutation 28: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 20 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I15 Branch 3 IFGE L17 - false
   * 21 Weak Mutation 1: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> defaultValue
   * 22 Weak Mutation 11: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - ReplaceComparisonOperator >= -> -1
   * 23 Weak Mutation 12: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 24 Weak Mutation 13: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 25 Weak Mutation 14: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 26 Weak Mutation 15: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant - : -> 
   * 27 Weak Mutation 17: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant -  param  -> 
   * 28 Weak Mutation 16: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 29 Weak Mutation 19: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceVariable name -> CONFIG_DELIM
   * 30 Weak Mutation 18: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 31 Weak Mutation 21: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 32 Weak Mutation 20: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteField: nameLjava/lang/String;
   * 33 Weak Mutation 23: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 34 Weak Mutation 22: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant -  doesn't validate,  -> 
   * 35 Weak Mutation 25: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - ReplaceConstant -  is less than min of  -> 
   * 36 Weak Mutation 24: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 37 Weak Mutation 27: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteField: minLjava/lang/Short;
   * 38 Weak Mutation 26: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 39 Weak Mutation 29: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: toString()Ljava/lang/String;
   * 40 Weak Mutation 28: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   */
  @Test
  public void test1()  throws Throwable  {
      ShortConfigParam shortConfigParam0 = new ShortConfigParam("!m6G", (Short) (short)922, (Short) (short) (-72), (Short) (short) (-72), false, "!m6G");
      assertNotNull(shortConfigParam0);
      
      try {
        shortConfigParam0.validate();
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * com.sleepycat.je.config.ShortConfigParam: param !m6G doesn't validate, -72 is less than min of 922
         */
      }
  }

  //Test case number: 2
  /*
   * 4 covered goals:
   * 1 Weak Mutation 34: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - ReplaceComparisonOperator <= -> ==
   * 2 com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V: I55 Branch 5 IFLE L22 - true
   * 3 Weak Mutation 10: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - ReplaceComparisonOperator >= -> >
   * 4 Weak Mutation 34: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - ReplaceComparisonOperator <= -> ==
   */
  @Test
  public void test2()  throws Throwable  {
      ShortConfigParam shortConfigParam0 = new ShortConfigParam("sRd1)", (Short) (short) (-953), (Short) (short) (-28), (Short) (short) (-953), false, "sRd1)");
      assertNotNull(shortConfigParam0);
      
      shortConfigParam0.validate();
      assertEquals("# minimum = -953\n# maximum = -28", shortConfigParam0.getExtraDescription());
  }

  //Test case number: 3
  /*
   * 9 covered goals:
   * 1 Weak Mutation 35: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - ReplaceComparisonOperator <= -> <
   * 2 Weak Mutation 5: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:16 - DeleteField: minLjava/lang/Short;
   * 3 Weak Mutation 7: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - DeleteField: minLjava/lang/Short;
   * 4 Weak Mutation 8: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - DeleteStatement: compareTo(Ljava/lang/Short;)I
   * 5 Weak Mutation 10: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:17 - ReplaceComparisonOperator >= -> >
   * 6 Weak Mutation 30: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:21 - DeleteField: maxLjava/lang/Short;
   * 7 Weak Mutation 32: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - DeleteField: maxLjava/lang/Short;
   * 8 Weak Mutation 33: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - DeleteStatement: compareTo(Ljava/lang/Short;)I
   * 9 Weak Mutation 35: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:22 - ReplaceComparisonOperator <= -> <
   */
  @Test
  public void test3()  throws Throwable  {
      ShortConfigParam shortConfigParam0 = new ShortConfigParam("g`d!1", (Short) (short) (-2000), (Short) (short) (-2000), (Short) (short) (-2000), false, "g`d!1");
      shortConfigParam0.validate();
      assertEquals("g`d!1", shortConfigParam0.getDescription());
  }

  //Test case number: 4
  /*
   * 26 covered goals:
   * 1 Weak Mutation 59: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant - :  -> 
   * 2 Weak Mutation 58: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 3 Weak Mutation 57: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 4 Weak Mutation 56: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 5 Weak Mutation 63: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant -  not valid value for  -> 
   * 6 Weak Mutation 62: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 7 Weak Mutation 61: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable value -> CONFIG_DELIM
   * 8 Weak Mutation 60: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 9 Weak Mutation 68: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: toString()Ljava/lang/String;
   * 10 Weak Mutation 64: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 65: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable name -> CONFIG_DELIM
   * 12 Weak Mutation 66: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: nameLjava/lang/String;
   * 13 Weak Mutation 67: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 14 Weak Mutation 59: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant - :  -> 
   * 15 Weak Mutation 58: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 16 Weak Mutation 57: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 17 Weak Mutation 56: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 18 Weak Mutation 63: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant -  not valid value for  -> 
   * 19 Weak Mutation 62: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 20 Weak Mutation 61: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable value -> CONFIG_DELIM
   * 21 Weak Mutation 60: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 22 Weak Mutation 68: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: toString()Ljava/lang/String;
   * 23 Weak Mutation 64: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 24 Weak Mutation 65: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable name -> CONFIG_DELIM
   * 25 Weak Mutation 66: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: nameLjava/lang/String;
   * 26 Weak Mutation 67: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   */
  @Test
  public void test4()  throws Throwable  {
      ShortConfigParam shortConfigParam0 = new ShortConfigParam("g`d!1", (Short) (short) (-2000), (Short) (short) (-2000), (Short) (short) (-2000), false, "g`d!1");
      try {
        shortConfigParam0.validateValue("g`d!1");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * com.sleepycat.je.config.ShortConfigParam: g`d!1 not valid value for g`d!1
         */
      }
  }

  //Test case number: 5
  /*
   * 21 covered goals:
   * 1 Weak Mutation 69: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:38 - DeleteField: minLjava/lang/Short;
   * 2 Weak Mutation 70: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:38 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 71: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - ReplaceConstant - # minimum =  -> 
   * 4 Weak Mutation 72: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 5 Weak Mutation 73: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteField: minLjava/lang/Short;
   * 6 Weak Mutation 74: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 7 Weak Mutation 76: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:41 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 85: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:47 - DeleteStatement: toString()Ljava/lang/String;
   * 9 com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;: I10 Branch 6 IFNULL L38 - false
   * 10 com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;: I24 Branch 7 IFNULL L41 - true
   * 11 Weak Mutation 0: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> maxVal
   * 12 Weak Mutation 2: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> minVal
   * 13 Weak Mutation 3: com.sleepycat.je.config.ShortConfigParam.<init>(Ljava/lang/String;Ljava/lang/Short;Ljava/lang/Short;Ljava/lang/Short;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> defaultValue
   * 14 Weak Mutation 69: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:38 - DeleteField: minLjava/lang/Short;
   * 15 Weak Mutation 70: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:38 - ReplaceComparisonOperator = null -> != null
   * 16 Weak Mutation 71: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - ReplaceConstant - # minimum =  -> 
   * 17 Weak Mutation 76: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:41 - ReplaceComparisonOperator = null -> != null
   * 18 Weak Mutation 72: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 19 Weak Mutation 73: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteField: minLjava/lang/Short;
   * 20 Weak Mutation 74: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 21 Weak Mutation 85: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:47 - DeleteStatement: toString()Ljava/lang/String;
   */
  @Test
  public void test5()  throws Throwable  {
      ShortConfigParam shortConfigParam0 = new ShortConfigParam("!m6G", (Short) (short)922, (Short) null, (Short) (short)922, false, "!m6G");
      assertNotNull(shortConfigParam0);
      
      String string0 = shortConfigParam0.getExtraDescription();
      assertNotNull(string0);
      assertEquals("# minimum = 922", string0);
  }

  //Test case number: 6
  /*
   * 32 covered goals:
   * 1 Weak Mutation 77: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:42 - DeleteField: minLjava/lang/Short;
   * 2 Weak Mutation 79: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:43 - ReplaceConstant - 
 -> 
   * 3 Weak Mutation 80: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:43 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 4 com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;: I29 Branch 8 IFNULL L42 - false
   * 5 Weak Mutation 4: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:15 - ReplaceComparisonOperator = null -> != null
   * 6 Weak Mutation 6: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:16 - ReplaceComparisonOperator = null -> != null
   * 7 Weak Mutation 31: com.sleepycat.je.config.ShortConfigParam.validate(Ljava/lang/Short;)V:21 - ReplaceComparisonOperator = null -> != null
   * 8 Weak Mutation 55: com.sleepycat.je.config.ShortConfigParam.validateValue(Ljava/lang/String;)V:30 - ReplaceVariable value -> CONFIG_DELIM
   * 9 Weak Mutation 69: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:38 - DeleteField: minLjava/lang/Short;
   * 10 Weak Mutation 70: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:38 - ReplaceComparisonOperator = null -> != null
   * 11 Weak Mutation 71: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - ReplaceConstant - # minimum =  -> 
   * 12 Weak Mutation 76: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:41 - ReplaceComparisonOperator = null -> != null
   * 13 Weak Mutation 78: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:42 - ReplaceComparisonOperator = null -> != null
   * 14 Weak Mutation 72: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 15 Weak Mutation 73: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteField: minLjava/lang/Short;
   * 16 Weak Mutation 74: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 75: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:41 - DeleteField: maxLjava/lang/Short;
   * 18 Weak Mutation 85: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:47 - DeleteStatement: toString()Ljava/lang/String;
   * 19 Weak Mutation 84: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 20 Weak Mutation 81: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - ReplaceConstant - # maximum =  -> 
   * 21 Weak Mutation 83: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteField: maxLjava/lang/Short;
   * 22 Weak Mutation 82: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 23 Weak Mutation 77: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:42 - DeleteField: minLjava/lang/Short;
   * 24 Weak Mutation 78: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:42 - ReplaceComparisonOperator = null -> != null
   * 25 Weak Mutation 79: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:43 - ReplaceConstant - 
 -> 
   * 26 Weak Mutation 75: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:41 - DeleteField: maxLjava/lang/Short;
   * 27 Weak Mutation 84: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 28 Weak Mutation 81: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - ReplaceConstant - # maximum =  -> 
   * 29 Weak Mutation 80: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:43 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 30 Weak Mutation 83: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteField: maxLjava/lang/Short;
   * 31 Weak Mutation 82: com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 32 com.sleepycat.je.config.ShortConfigParam.getExtraDescription()Ljava/lang/String;: I24 Branch 7 IFNULL L41 - false
   */
  @Test
  public void test6()  throws Throwable  {
      ShortConfigParam shortConfigParam0 = new ShortConfigParam("g`d!1", (Short) (short) (-2000), (Short) (short) (-2000), (Short) (short) (-2000), false, "g`d!1");
      assertNotNull(shortConfigParam0);
      
      String string0 = shortConfigParam0.getExtraDescription();
      assertEquals("# minimum = -2000\n# maximum = -2000", string0);
      assertNotNull(string0);
  }
}