/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.CursorImpl;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;

@RunWith(EvoSuiteRunner.class)
public class TestBIN_20 {


  //Test case number: 20
  /*
   * 54 covered goals:
   * 1 Weak Mutation 175: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - InsertUnaryOp Negation
   * 2 Weak Mutation 178: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - ReplaceComparisonOperator != -> ==
   * 3 Weak Mutation 176: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - ReplaceComparisonOperator != -> ==
   * 4 Weak Mutation 177: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - InsertUnaryOp Negation
   * 5 Weak Mutation 207: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 206: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp Negation
   * 7 Weak Mutation 212: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - DeleteStatement: split(Lcom/sleepycat/je/tree/IN;II)V
   * 8 Weak Mutation 208: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC -1
   * 9 Weak Mutation 209: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp Negation
   * 10 Weak Mutation 210: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC 1
   * 11 Weak Mutation 211: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC -1
   * 12 com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V: I34 Branch 14 IFEQ L296 - true
   * 13 com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V: I49 Branch 16 IFNE L299 - false
   * 14 com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V: I51 Branch 17 IFNE L299 - true
   * 15 Weak Mutation 89: com.sleepycat.je.tree.BIN.entryZeroKeyComparesLow()Z:185 - ReplaceConstant - 0 -> 1
   * 16 Weak Mutation 137: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:293 - DeleteStatement: getNEntries()I
   * 17 Weak Mutation 136: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:292 - DeleteStatement: findEntry([BZZ)I
   * 18 Weak Mutation 139: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - InsertUnaryOp IINC 1
   * 19 Weak Mutation 138: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - InsertUnaryOp Negation
   * 20 Weak Mutation 141: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceConstant - 65536 -> 0
   * 21 Weak Mutation 140: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 143: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceConstant - 65536 -> -1
   * 23 Weak Mutation 142: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceConstant - 65536 -> 1
   * 24 Weak Mutation 135: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:292 - ReplaceConstant - 0 -> 1
   * 25 Weak Mutation 134: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:292 - ReplaceConstant - 1 -> 0
   * 26 Weak Mutation 153: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - InsertUnaryOp Negation
   * 27 Weak Mutation 154: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - ReplaceConstant - -65537 -> 0
   * 28 Weak Mutation 155: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - ReplaceConstant - -65537 -> 1
   * 29 Weak Mutation 156: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - ReplaceConstant - -65537 -> -1
   * 30 Weak Mutation 157: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - ReplaceConstant - -65537 -> -65538
   * 31 Weak Mutation 158: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - ReplaceConstant - -65537 -> -65536
   * 32 Weak Mutation 159: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - ReplaceBitwiseOperator & -> |
   * 33 Weak Mutation 144: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceConstant - 65536 -> 65535
   * 34 Weak Mutation 145: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceConstant - 65536 -> 65537
   * 35 Weak Mutation 146: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceBitwiseOperator & -> |
   * 36 Weak Mutation 147: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceBitwiseOperator & -> ^
   * 37 Weak Mutation 148: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceComparisonOperator == -> >=
   * 38 Weak Mutation 151: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:294 - ReplaceConstant - 1 -> 0
   * 39 Weak Mutation 162: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:296 - ReplaceComparisonOperator == -> !=
   * 40 Weak Mutation 161: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:296 - InsertUnaryOp Negation
   * 41 Weak Mutation 160: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:295 - ReplaceBitwiseOperator & -> ^
   * 42 Weak Mutation 354: com.sleepycat.je.tree.BIN.getKeyComparator()Ljava/util/Comparator;:643 - DeleteStatement: getDatabase()Lcom/sleepycat/je/dbi/DatabaseImpl;
   * 43 Weak Mutation 355: com.sleepycat.je.tree.BIN.getKeyComparator()Ljava/util/Comparator;:643 - DeleteStatement: getBtreeComparator()Ljava/util/Comparator;
   * 44 Weak Mutation 175: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - InsertUnaryOp Negation
   * 45 Weak Mutation 178: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - ReplaceComparisonOperator != -> ==
   * 46 Weak Mutation 176: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - ReplaceComparisonOperator != -> ==
   * 47 Weak Mutation 177: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:299 - InsertUnaryOp Negation
   * 48 Weak Mutation 207: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC 1
   * 49 Weak Mutation 206: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp Negation
   * 50 Weak Mutation 212: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - DeleteStatement: split(Lcom/sleepycat/je/tree/IN;II)V
   * 51 Weak Mutation 208: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC -1
   * 52 Weak Mutation 209: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp Negation
   * 53 Weak Mutation 210: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC 1
   * 54 Weak Mutation 211: com.sleepycat.je.tree.BIN.splitSpecial(Lcom/sleepycat/je/tree/IN;II[BZ)V:303 - InsertUnaryOp IINC -1
   */
  @Test
  public void test20()  throws Throwable  {
      BIN bIN0 = new BIN();
      byte[] byteArray0 = new byte[8];
      DatabaseImpl databaseImpl0 = new DatabaseImpl();
      bIN0.postRecoveryInit(databaseImpl0, (long) (-74));
      // Undeclared exception!
      try {
        bIN0.splitSpecial((IN) bIN0, (-74), (-74), byteArray0, false);
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      } catch(ArrayIndexOutOfBoundsException e) {
        /*
         * 0
         */
      }
  }
}