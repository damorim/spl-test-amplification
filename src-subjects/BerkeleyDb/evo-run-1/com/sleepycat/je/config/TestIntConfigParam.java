/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.config.IntConfigParam;

@RunWith(EvoSuiteRunner.class)
public class TestIntConfigParam {


  //Test case number: 0
  /*
   * 38 covered goals:
   * 1 Weak Mutation 59: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant - :  -> 
   * 2 Weak Mutation 58: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 3 Weak Mutation 57: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 4 Weak Mutation 56: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 5 Weak Mutation 63: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant -  not valid value for  -> 
   * 6 Weak Mutation 62: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 7 Weak Mutation 61: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable value -> CONFIG_DELIM
   * 8 Weak Mutation 60: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 9 Weak Mutation 68: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: toString()Ljava/lang/String;
   * 10 Weak Mutation 64: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 65: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable name -> CONFIG_DELIM
   * 12 Weak Mutation 66: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: nameLjava/lang/String;
   * 13 Weak Mutation 67: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 14 Weak Mutation 0: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> maxVal
   * 15 Weak Mutation 1: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> defaultValue
   * 16 Weak Mutation 2: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> minVal
   * 17 Weak Mutation 4: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:15 - ReplaceComparisonOperator = null -> != null
   * 18 Weak Mutation 6: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:16 - ReplaceComparisonOperator = null -> != null
   * 19 Weak Mutation 31: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:21 - ReplaceComparisonOperator = null -> != null
   * 20 Weak Mutation 55: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:30 - ReplaceVariable value -> CONFIG_DELIM
   * 21 Weak Mutation 59: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant - :  -> 
   * 22 Weak Mutation 58: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 23 Weak Mutation 57: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 24 Weak Mutation 56: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 25 Weak Mutation 63: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceConstant -  not valid value for  -> 
   * 26 Weak Mutation 62: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 27 Weak Mutation 61: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable value -> CONFIG_DELIM
   * 28 Weak Mutation 60: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 29 Weak Mutation 68: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: toString()Ljava/lang/String;
   * 30 Weak Mutation 64: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 31 Weak Mutation 65: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - ReplaceVariable name -> CONFIG_DELIM
   * 32 Weak Mutation 66: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteField: nameLjava/lang/String;
   * 33 Weak Mutation 67: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:33 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 34 com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V: root-Branch
   * 35 com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V: root-Branch
   * 36 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I3 Branch 1 IFNULL L15 - false
   * 37 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I8 Branch 2 IFNULL L16 - true
   * 38 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I48 Branch 4 IFNULL L21 - true
   */
  @Test
  public void test0()  throws Throwable  {
      IntConfigParam intConfigParam0 = new IntConfigParam("%~w", (Integer) null, (Integer) 4, (Integer) 4, true, "%~w");
      assertNotNull(intConfigParam0);
      
      try {
        intConfigParam0.validateValue("%~w");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * com.sleepycat.je.config.IntConfigParam: %~w not valid value for %~w
         */
      }
  }

  //Test case number: 1
  /*
   * 21 covered goals:
   * 1 Weak Mutation 5: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:16 - DeleteField: minLjava/lang/Integer;
   * 2 Weak Mutation 7: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - DeleteField: minLjava/lang/Integer;
   * 3 Weak Mutation 8: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - DeleteStatement: compareTo(Ljava/lang/Integer;)I
   * 4 Weak Mutation 10: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - ReplaceComparisonOperator >= -> >
   * 5 Weak Mutation 30: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:21 - DeleteField: maxLjava/lang/Integer;
   * 6 Weak Mutation 35: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - ReplaceComparisonOperator <= -> <
   * 7 Weak Mutation 32: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - DeleteField: maxLjava/lang/Integer;
   * 8 Weak Mutation 33: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - DeleteStatement: compareTo(Ljava/lang/Integer;)I
   * 9 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I8 Branch 2 IFNULL L16 - false
   * 10 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I15 Branch 3 IFGE L17 - true
   * 11 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I48 Branch 4 IFNULL L21 - false
   * 12 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I55 Branch 5 IFLE L22 - true
   * 13 Weak Mutation 3: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> defaultValue
   * 14 Weak Mutation 5: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:16 - DeleteField: minLjava/lang/Integer;
   * 15 Weak Mutation 7: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - DeleteField: minLjava/lang/Integer;
   * 16 Weak Mutation 8: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - DeleteStatement: compareTo(Ljava/lang/Integer;)I
   * 17 Weak Mutation 10: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - ReplaceComparisonOperator >= -> >
   * 18 Weak Mutation 30: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:21 - DeleteField: maxLjava/lang/Integer;
   * 19 Weak Mutation 35: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - ReplaceComparisonOperator <= -> <
   * 20 Weak Mutation 32: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - DeleteField: maxLjava/lang/Integer;
   * 21 Weak Mutation 33: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - DeleteStatement: compareTo(Ljava/lang/Integer;)I
   */
  @Test
  public void test1()  throws Throwable  {
      Integer integer0 = new Integer(5);
      IntConfigParam intConfigParam0 = new IntConfigParam("2", integer0, integer0, (Integer) 5, false, "2");
      intConfigParam0.validate();
      assertEquals("# minimum = 5\n# maximum = 5", intConfigParam0.getExtraDescription());
  }

  //Test case number: 2
  /*
   * 41 covered goals:
   * 1 Weak Mutation 9: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - ReplaceComparisonOperator >= -> ==
   * 2 Weak Mutation 36: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - ReplaceComparisonOperator <= -> -1
   * 3 Weak Mutation 38: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 4 Weak Mutation 39: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 5 Weak Mutation 37: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 6 Weak Mutation 42: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant -  param  -> 
   * 7 Weak Mutation 43: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 8 Weak Mutation 40: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant - : -> 
   * 9 Weak Mutation 41: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 10 Weak Mutation 46: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 47: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant -  doesn't validate,  -> 
   * 12 Weak Mutation 44: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceVariable name -> CONFIG_DELIM
   * 13 Weak Mutation 45: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteField: nameLjava/lang/String;
   * 14 Weak Mutation 51: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 15 Weak Mutation 50: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant -  is greater than max of  -> 
   * 16 Weak Mutation 49: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 17 Weak Mutation 48: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 18 Weak Mutation 54: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: toString()Ljava/lang/String;
   * 19 Weak Mutation 53: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 20 Weak Mutation 52: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteField: maxLjava/lang/Integer;
   * 21 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I55 Branch 5 IFLE L22 - false
   * 22 Weak Mutation 9: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - ReplaceComparisonOperator >= -> ==
   * 23 Weak Mutation 38: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 24 Weak Mutation 39: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 25 Weak Mutation 36: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - ReplaceComparisonOperator <= -> -1
   * 26 Weak Mutation 37: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 27 Weak Mutation 42: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant -  param  -> 
   * 28 Weak Mutation 43: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 29 Weak Mutation 40: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant - : -> 
   * 30 Weak Mutation 41: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 31 Weak Mutation 46: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 32 Weak Mutation 47: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant -  doesn't validate,  -> 
   * 33 Weak Mutation 44: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceVariable name -> CONFIG_DELIM
   * 34 Weak Mutation 45: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteField: nameLjava/lang/String;
   * 35 Weak Mutation 51: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 36 Weak Mutation 50: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - ReplaceConstant -  is greater than max of  -> 
   * 37 Weak Mutation 49: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 38 Weak Mutation 48: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 39 Weak Mutation 54: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: toString()Ljava/lang/String;
   * 40 Weak Mutation 53: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 41 Weak Mutation 52: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:23 - DeleteField: maxLjava/lang/Integer;
   */
  @Test
  public void test2()  throws Throwable  {
      Integer integer0 = new Integer((-1));
      IntConfigParam intConfigParam0 = new IntConfigParam("ec4$WritE@{@ G^Xd", integer0, integer0, integer0, false, "ec4$WritE@{@ G^Xd");
      try {
        intConfigParam0.validateValue("8209");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * com.sleepycat.je.config.IntConfigParam: param ec4$WritE@{@ G^Xd doesn't validate, 8209 is greater than max of -1
         */
      }
  }

  //Test case number: 3
  /*
   * 39 covered goals:
   * 1 Weak Mutation 11: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - ReplaceComparisonOperator >= -> -1
   * 2 Weak Mutation 12: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 3 Weak Mutation 13: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 4 Weak Mutation 14: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 5 Weak Mutation 15: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant - : -> 
   * 6 Weak Mutation 17: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant -  param  -> 
   * 7 Weak Mutation 16: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 8 Weak Mutation 19: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceVariable name -> CONFIG_DELIM
   * 9 Weak Mutation 18: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 10 Weak Mutation 21: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 11 Weak Mutation 20: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteField: nameLjava/lang/String;
   * 12 Weak Mutation 23: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 13 Weak Mutation 22: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant -  doesn't validate,  -> 
   * 14 Weak Mutation 25: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant -  is less than min of  -> 
   * 15 Weak Mutation 24: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 16 Weak Mutation 27: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteField: minLjava/lang/Integer;
   * 17 Weak Mutation 26: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 18 Weak Mutation 29: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: toString()Ljava/lang/String;
   * 19 Weak Mutation 28: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 20 com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V: I15 Branch 3 IFGE L17 - false
   * 21 Weak Mutation 11: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - ReplaceComparisonOperator >= -> -1
   * 22 Weak Mutation 12: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceVariable DEBUG_NAME -> CONFIG_DELIM
   * 23 Weak Mutation 13: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteField: DEBUG_NAMELjava/lang/String;
   * 24 Weak Mutation 14: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: valueOf(Ljava/lang/Object;)Ljava/lang/String;
   * 25 Weak Mutation 15: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant - : -> 
   * 26 Weak Mutation 17: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant -  param  -> 
   * 27 Weak Mutation 16: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 28 Weak Mutation 19: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceVariable name -> CONFIG_DELIM
   * 29 Weak Mutation 18: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 30 Weak Mutation 21: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 31 Weak Mutation 20: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteField: nameLjava/lang/String;
   * 32 Weak Mutation 23: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 33 Weak Mutation 22: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant -  doesn't validate,  -> 
   * 34 Weak Mutation 25: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - ReplaceConstant -  is less than min of  -> 
   * 35 Weak Mutation 24: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   * 36 Weak Mutation 27: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteField: minLjava/lang/Integer;
   * 37 Weak Mutation 26: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuilder;
   * 38 Weak Mutation 29: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: toString()Ljava/lang/String;
   * 39 Weak Mutation 28: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:18 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
   */
  @Test
  public void test3()  throws Throwable  {
      Integer integer0 = new Integer(5);
      IntConfigParam intConfigParam0 = new IntConfigParam("2", integer0, integer0, (Integer) 5, false, "2");
      try {
        intConfigParam0.validateValue("2");
        fail("Expecting exception: IllegalArgumentException");
      } catch(IllegalArgumentException e) {
        /*
         * com.sleepycat.je.config.IntConfigParam: param 2 doesn't validate, 2 is less than min of 5
         */
      }
  }

  //Test case number: 4
  /*
   * 9 covered goals:
   * 1 Weak Mutation 34: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - ReplaceComparisonOperator <= -> ==
   * 2 Weak Mutation 5: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:16 - DeleteField: minLjava/lang/Integer;
   * 3 Weak Mutation 7: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - DeleteField: minLjava/lang/Integer;
   * 4 Weak Mutation 8: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - DeleteStatement: compareTo(Ljava/lang/Integer;)I
   * 5 Weak Mutation 10: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:17 - ReplaceComparisonOperator >= -> >
   * 6 Weak Mutation 30: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:21 - DeleteField: maxLjava/lang/Integer;
   * 7 Weak Mutation 32: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - DeleteField: maxLjava/lang/Integer;
   * 8 Weak Mutation 33: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - DeleteStatement: compareTo(Ljava/lang/Integer;)I
   * 9 Weak Mutation 34: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:22 - ReplaceComparisonOperator <= -> ==
   */
  @Test
  public void test4()  throws Throwable  {
      Integer integer0 = new Integer(5);
      Integer integer1 = new Integer(1949);
      IntConfigParam intConfigParam0 = new IntConfigParam("2", integer0, integer1, (Integer) 5, false, "2");
      assertNotNull(intConfigParam0);
      
      intConfigParam0.validate();
      assertEquals("# minimum = 5\n# maximum = 1949", intConfigParam0.getExtraDescription());
  }

  //Test case number: 5
  /*
   * 19 covered goals:
   * 1 Weak Mutation 75: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:41 - DeleteField: maxLjava/lang/Integer;
   * 2 Weak Mutation 78: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:42 - ReplaceComparisonOperator = null -> != null
   * 3 Weak Mutation 84: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 4 Weak Mutation 81: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - ReplaceConstant - # maximum =  -> 
   * 5 Weak Mutation 83: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteField: maxLjava/lang/Integer;
   * 6 Weak Mutation 82: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 7 com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;: I10 Branch 6 IFNULL L38 - true
   * 8 com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;: I24 Branch 7 IFNULL L41 - false
   * 9 com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;: I29 Branch 8 IFNULL L42 - true
   * 10 Weak Mutation 1: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> defaultValue
   * 11 Weak Mutation 70: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:38 - ReplaceComparisonOperator = null -> != null
   * 12 Weak Mutation 76: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:41 - ReplaceComparisonOperator = null -> != null
   * 13 Weak Mutation 78: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:42 - ReplaceComparisonOperator = null -> != null
   * 14 Weak Mutation 75: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:41 - DeleteField: maxLjava/lang/Integer;
   * 15 Weak Mutation 85: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:47 - DeleteStatement: toString()Ljava/lang/String;
   * 16 Weak Mutation 84: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 17 Weak Mutation 81: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - ReplaceConstant - # maximum =  -> 
   * 18 Weak Mutation 83: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteField: maxLjava/lang/Integer;
   * 19 Weak Mutation 82: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   */
  @Test
  public void test5()  throws Throwable  {
      IntConfigParam intConfigParam0 = new IntConfigParam("%~w", (Integer) null, (Integer) 4, (Integer) 4, true, "%~w");
      assertNotNull(intConfigParam0);
      
      String string0 = intConfigParam0.getExtraDescription();
      assertNotNull(string0);
      assertEquals("# maximum = 4", string0);
  }

  //Test case number: 6
  /*
   * 34 covered goals:
   * 1 Weak Mutation 77: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:42 - DeleteField: minLjava/lang/Integer;
   * 2 Weak Mutation 79: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:43 - ReplaceConstant - 
 -> 
   * 3 Weak Mutation 80: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:43 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 4 com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;: I29 Branch 8 IFNULL L42 - false
   * 5 Weak Mutation 0: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:11 - ReplaceVariable minVal -> maxVal
   * 6 Weak Mutation 2: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> minVal
   * 7 Weak Mutation 3: com.sleepycat.je.config.IntConfigParam.<init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/String;)V:12 - ReplaceVariable maxVal -> defaultValue
   * 8 Weak Mutation 4: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:15 - ReplaceComparisonOperator = null -> != null
   * 9 Weak Mutation 6: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:16 - ReplaceComparisonOperator = null -> != null
   * 10 Weak Mutation 31: com.sleepycat.je.config.IntConfigParam.validate(Ljava/lang/Integer;)V:21 - ReplaceComparisonOperator = null -> != null
   * 11 Weak Mutation 55: com.sleepycat.je.config.IntConfigParam.validateValue(Ljava/lang/String;)V:30 - ReplaceVariable value -> CONFIG_DELIM
   * 12 Weak Mutation 69: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:38 - DeleteField: minLjava/lang/Integer;
   * 13 Weak Mutation 70: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:38 - ReplaceComparisonOperator = null -> != null
   * 14 Weak Mutation 71: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - ReplaceConstant - # minimum =  -> 
   * 15 Weak Mutation 76: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:41 - ReplaceComparisonOperator = null -> != null
   * 16 Weak Mutation 78: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:42 - ReplaceComparisonOperator = null -> != null
   * 17 Weak Mutation 72: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 18 Weak Mutation 73: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteField: minLjava/lang/Integer;
   * 19 Weak Mutation 74: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 20 Weak Mutation 75: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:41 - DeleteField: maxLjava/lang/Integer;
   * 21 Weak Mutation 85: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:47 - DeleteStatement: toString()Ljava/lang/String;
   * 22 Weak Mutation 84: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 23 Weak Mutation 81: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - ReplaceConstant - # maximum =  -> 
   * 24 Weak Mutation 83: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteField: maxLjava/lang/Integer;
   * 25 Weak Mutation 82: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:45 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 26 Weak Mutation 69: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:38 - DeleteField: minLjava/lang/Integer;
   * 27 Weak Mutation 71: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - ReplaceConstant - # minimum =  -> 
   * 28 Weak Mutation 77: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:42 - DeleteField: minLjava/lang/Integer;
   * 29 Weak Mutation 79: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:43 - ReplaceConstant - 
 -> 
   * 30 Weak Mutation 72: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 31 Weak Mutation 73: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteField: minLjava/lang/Integer;
   * 32 Weak Mutation 74: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:39 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 33 Weak Mutation 80: com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;:43 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 34 com.sleepycat.je.config.IntConfigParam.getExtraDescription()Ljava/lang/String;: I10 Branch 6 IFNULL L38 - false
   */
  @Test
  public void test6()  throws Throwable  {
      Integer integer0 = new Integer(8209);
      IntConfigParam intConfigParam0 = new IntConfigParam("ec4$WritE@{@ G^Xd", integer0, (Integer) 8209, integer0, false, "ec4$WritE@{@ G^Xd");
      assertNotNull(intConfigParam0);
      
      String string0 = intConfigParam0.getExtraDescription();
      assertEquals("# minimum = 8209\n# maximum = 8209", string0);
      assertNotNull(string0);
  }
}