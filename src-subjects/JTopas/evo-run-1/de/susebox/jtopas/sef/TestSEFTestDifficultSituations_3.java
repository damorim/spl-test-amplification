/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas.sef;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.sef.SEFTestDifficultSituations;
import java.io.File;
import junit.framework.AssertionFailedError;

@RunWith(EvoSuiteRunner.class)
public class TestSEFTestDifficultSituations_3 {


  //Test case number: 3
  /*
   * 84 covered goals:
   * 1 Weak Mutation 246: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - DeleteStatement: setParseFlags(I)V
   * 2 Weak Mutation 244: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 3583
   * 3 Weak Mutation 245: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 3585
   * 4 Weak Mutation 242: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 1
   * 5 Weak Mutation 243: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> -1
   * 6 Weak Mutation 241: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 0
   * 7 Weak Mutation 248: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:375 - DeleteStatement: addLineComment(Ljava/lang/String;)V
   * 8 Weak Mutation 247: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:375 - ReplaceConstant - // -> 
   * 9 Weak Mutation 250: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:376 - ReplaceConstant - + -> 
   * 10 Weak Mutation 251: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:376 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 11 Weak Mutation 249: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:376 - ReplaceConstant - + -> 
   * 12 Weak Mutation 254: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:377 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 13 Weak Mutation 252: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:377 - ReplaceConstant - ++ -> 
   * 14 Weak Mutation 253: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:377 - ReplaceConstant - ++ -> 
   * 15 Weak Mutation 255: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:378 - ReplaceConstant - - -> 
   * 16 Weak Mutation 256: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:378 - ReplaceConstant - - -> 
   * 17 Weak Mutation 257: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:378 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 18 Weak Mutation 258: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:379 - ReplaceConstant - -- -> 
   * 19 Weak Mutation 259: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:379 - ReplaceConstant - -- -> 
   * 20 Weak Mutation 260: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:379 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 21 Weak Mutation 262: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 1
   * 22 Weak Mutation 263: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> -1
   * 23 Weak Mutation 261: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 0
   * 24 Weak Mutation 264: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 8191
   * 25 Weak Mutation 265: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 8193
   * 26 Weak Mutation 266: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:385 - ReplaceConstant - A -> 
   * 27 Weak Mutation 267: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:385 - DeleteStatement: setSource(Lde/susebox/jtopas/TokenizerSource;)V
   * 28 Weak Mutation 268: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:387 - DeleteStatement: hasMoreToken()Z
   * 29 Weak Mutation 269: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:387 - DeleteStatement: assertTrue(Z)V
   * 30 Weak Mutation 270: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:388 - DeleteStatement: nextToken()Lde/susebox/jtopas/Token;
   * 31 Weak Mutation 275: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - ReplaceConstant - 1 -> 0
   * 32 Weak Mutation 274: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - ReplaceComparisonOperator != -> -1
   * 33 Weak Mutation 277: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - DeleteStatement: assertTrue(Z)V
   * 34 Weak Mutation 271: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - DeleteStatement: getType()I
   * 35 Weak Mutation 279: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - ReplaceConstant - A -> 
   * 36 Weak Mutation 278: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - DeleteStatement: getImage()Ljava/lang/String;
   * 37 Weak Mutation 281: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - DeleteStatement: assertTrue(Z)V
   * 38 Weak Mutation 280: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 39 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I72 Branch 13 IFNE L389 - false
   * 40 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I101 Branch 14 IF_ICMPNE L393 - false
   * 41 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I112 Branch 15 IFNE L394 - false
   * 42 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I141 Branch 16 IF_ICMPNE L401 - false
   * 43 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I153 Branch 17 IF_ACMPNE L402 - false
   * 44 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I175 Branch 18 IF_ICMPNE L405 - false
   * 45 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I186 Branch 19 IFNE L406 - false
   * 46 de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V: I215 Branch 20 IF_ICMPNE L413 - true
   * 47 Weak Mutation 254: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:377 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 48 Weak Mutation 255: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:378 - ReplaceConstant - - -> 
   * 49 Weak Mutation 252: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:377 - ReplaceConstant - ++ -> 
   * 50 Weak Mutation 253: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:377 - ReplaceConstant - ++ -> 
   * 51 Weak Mutation 250: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:376 - ReplaceConstant - + -> 
   * 52 Weak Mutation 251: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:376 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 53 Weak Mutation 248: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:375 - DeleteStatement: addLineComment(Ljava/lang/String;)V
   * 54 Weak Mutation 249: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:376 - ReplaceConstant - + -> 
   * 55 Weak Mutation 246: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - DeleteStatement: setParseFlags(I)V
   * 56 Weak Mutation 247: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:375 - ReplaceConstant - // -> 
   * 57 Weak Mutation 244: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 3583
   * 58 Weak Mutation 245: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 3585
   * 59 Weak Mutation 242: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 1
   * 60 Weak Mutation 243: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> -1
   * 61 Weak Mutation 241: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:374 - ReplaceConstant - 3584 -> 0
   * 62 Weak Mutation 275: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - ReplaceConstant - 1 -> 0
   * 63 Weak Mutation 274: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - ReplaceComparisonOperator != -> -1
   * 64 Weak Mutation 279: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - ReplaceConstant - A -> 
   * 65 Weak Mutation 278: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - DeleteStatement: getImage()Ljava/lang/String;
   * 66 Weak Mutation 277: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - DeleteStatement: assertTrue(Z)V
   * 67 Weak Mutation 281: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - DeleteStatement: assertTrue(Z)V
   * 68 Weak Mutation 280: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:390 - DeleteStatement: StringEquals(Ljava/lang/String;Ljava/lang/Object;)I
   * 69 Weak Mutation 258: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:379 - ReplaceConstant - -- -> 
   * 70 Weak Mutation 259: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:379 - ReplaceConstant - -- -> 
   * 71 Weak Mutation 256: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:378 - ReplaceConstant - - -> 
   * 72 Weak Mutation 257: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:378 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 73 Weak Mutation 262: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 1
   * 74 Weak Mutation 263: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> -1
   * 75 Weak Mutation 260: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:379 - DeleteStatement: addSpecialSequence(Ljava/lang/String;Ljava/lang/Object;)V
   * 76 Weak Mutation 261: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 0
   * 77 Weak Mutation 266: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:385 - ReplaceConstant - A -> 
   * 78 Weak Mutation 267: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:385 - DeleteStatement: setSource(Lde/susebox/jtopas/TokenizerSource;)V
   * 79 Weak Mutation 264: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 8191
   * 80 Weak Mutation 265: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:382 - ReplaceConstant - 8192 -> 8193
   * 81 Weak Mutation 270: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:388 - DeleteStatement: nextToken()Lde/susebox/jtopas/Token;
   * 82 Weak Mutation 271: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:389 - DeleteStatement: getType()I
   * 83 Weak Mutation 268: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:387 - DeleteStatement: hasMoreToken()Z
   * 84 Weak Mutation 269: de.susebox.jtopas.sef.SEFTestDifficultSituations.testSmallSource()V:387 - DeleteStatement: assertTrue(Z)V
   */
  @Test
  public void test3()  throws Throwable  {
      Class<?> class0 = SEFTestDifficultSituations.class;
      SEFTestDifficultSituations sEFTestDifficultSituations0 = new SEFTestDifficultSituations((String) null, (Class) class0);
      try {
        sEFTestDifficultSituations0.testSmallSource();
        fail("Expecting exception: AssertionFailedError");
      } catch(AssertionFailedError e) {
      }
  }
}