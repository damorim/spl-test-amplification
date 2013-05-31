/*
 * This file was automatically generated by EvoSuite
 */

package smashed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import smashed.Edge;
import smashed.FinishTimeWorkSpace;
import smashed.Graph;
import smashed.Vertex;
import smashed.WorkSpace;

@RunWith(EvoSuiteRunner.class)
public class TestGraph_15 {


  //Test case number: 15
  /*
   * 84 covered goals:
   * 1 Weak Mutation 418: smashed.Graph.readNumber()I:861 - ReplaceComparisonOperator != -> <
   * 2 Weak Mutation 439: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> >=
   * 3 Weak Mutation 450: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> >=
   * 4 Weak Mutation 429: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> -2
   * 5 Weak Mutation 419: smashed.Graph.readNumber()I:861 - ReplaceComparisonOperator != -> -1
   * 6 Weak Mutation 421: smashed.Graph.readNumber()I:862 - DeleteStatement: read()I
   * 7 Weak Mutation 420: smashed.Graph.readNumber()I:862 - DeleteField: inFileLjava/io/Reader;
   * 8 Weak Mutation 410: smashed.Graph.readNumber()I:861 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 411: smashed.Graph.readNumber()I:861 - InsertUnaryOp IINC -1
   * 10 Weak Mutation 408: smashed.Graph.readNumber()I:860 - DeleteStatement: read()I
   * 11 Weak Mutation 409: smashed.Graph.readNumber()I:861 - InsertUnaryOp Negation
   * 12 Weak Mutation 414: smashed.Graph.readNumber()I:861 - ReplaceConstant - 32 -> -1
   * 13 Weak Mutation 415: smashed.Graph.readNumber()I:861 - ReplaceConstant - 32 -> 31
   * 14 Weak Mutation 412: smashed.Graph.readNumber()I:861 - ReplaceConstant - 32 -> 0
   * 15 Weak Mutation 413: smashed.Graph.readNumber()I:861 - ReplaceConstant - 32 -> 1
   * 16 Weak Mutation 402: smashed.Graph.readNumber()I:857 - ReplaceConstant - 80 -> 1
   * 17 Weak Mutation 403: smashed.Graph.readNumber()I:857 - ReplaceConstant - 80 -> -1
   * 18 Weak Mutation 400: smashed.Graph.readNumber()I:856 - ReplaceConstant - 0 -> 1
   * 19 Weak Mutation 401: smashed.Graph.readNumber()I:857 - ReplaceConstant - 80 -> 0
   * 20 Weak Mutation 406: smashed.Graph.readNumber()I:858 - ReplaceConstant - 0 -> 1
   * 21 Weak Mutation 407: smashed.Graph.readNumber()I:860 - DeleteField: inFileLjava/io/Reader;
   * 22 Weak Mutation 404: smashed.Graph.readNumber()I:857 - ReplaceConstant - 80 -> 79
   * 23 Weak Mutation 405: smashed.Graph.readNumber()I:857 - ReplaceConstant - 80 -> 81
   * 24 Weak Mutation 441: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> <=
   * 25 Weak Mutation 442: smashed.Graph.readNumber()I:865 - InsertUnaryOp Negation
   * 26 Weak Mutation 443: smashed.Graph.readNumber()I:865 - InsertUnaryOp IINC 1
   * 27 Weak Mutation 444: smashed.Graph.readNumber()I:865 - InsertUnaryOp IINC -1
   * 28 Weak Mutation 445: smashed.Graph.readNumber()I:865 - ReplaceConstant - 10 -> 0
   * 29 Weak Mutation 446: smashed.Graph.readNumber()I:865 - ReplaceConstant - 10 -> 1
   * 30 Weak Mutation 447: smashed.Graph.readNumber()I:865 - ReplaceConstant - 10 -> -1
   * 31 Weak Mutation 432: smashed.Graph.readNumber()I:865 - InsertUnaryOp IINC 1
   * 32 Weak Mutation 433: smashed.Graph.readNumber()I:865 - InsertUnaryOp IINC -1
   * 33 Weak Mutation 434: smashed.Graph.readNumber()I:865 - ReplaceConstant - 32 -> 0
   * 34 Weak Mutation 435: smashed.Graph.readNumber()I:865 - ReplaceConstant - 32 -> 1
   * 35 Weak Mutation 436: smashed.Graph.readNumber()I:865 - ReplaceConstant - 32 -> -1
   * 36 Weak Mutation 437: smashed.Graph.readNumber()I:865 - ReplaceConstant - 32 -> 31
   * 37 Weak Mutation 438: smashed.Graph.readNumber()I:865 - ReplaceConstant - 32 -> 33
   * 38 Weak Mutation 439: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> >=
   * 39 Weak Mutation 425: smashed.Graph.readNumber()I:865 - ReplaceConstant - -1 -> 0
   * 40 Weak Mutation 424: smashed.Graph.readNumber()I:865 - InsertUnaryOp IINC -1
   * 41 Weak Mutation 427: smashed.Graph.readNumber()I:865 - ReplaceConstant - -1 -> -2
   * 42 Weak Mutation 426: smashed.Graph.readNumber()I:865 - ReplaceConstant - -1 -> 1
   * 43 Weak Mutation 429: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> -2
   * 44 Weak Mutation 428: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> >=
   * 45 Weak Mutation 431: smashed.Graph.readNumber()I:865 - InsertUnaryOp Negation
   * 46 Weak Mutation 416: smashed.Graph.readNumber()I:861 - ReplaceConstant - 32 -> 33
   * 47 Weak Mutation 419: smashed.Graph.readNumber()I:861 - ReplaceComparisonOperator != -> -1
   * 48 Weak Mutation 418: smashed.Graph.readNumber()I:861 - ReplaceComparisonOperator != -> <
   * 49 Weak Mutation 421: smashed.Graph.readNumber()I:862 - DeleteStatement: read()I
   * 50 Weak Mutation 420: smashed.Graph.readNumber()I:862 - DeleteField: inFileLjava/io/Reader;
   * 51 Weak Mutation 423: smashed.Graph.readNumber()I:865 - InsertUnaryOp IINC 1
   * 52 Weak Mutation 422: smashed.Graph.readNumber()I:865 - InsertUnaryOp Negation
   * 53 Weak Mutation 474: smashed.Graph.readNumber()I:875 - DeleteStatement: parseInt(Ljava/lang/String;I)I
   * 54 Weak Mutation 472: smashed.Graph.readNumber()I:875 - ReplaceConstant - 10 -> 9
   * 55 Weak Mutation 473: smashed.Graph.readNumber()I:875 - ReplaceConstant - 10 -> 11
   * 56 Weak Mutation 470: smashed.Graph.readNumber()I:875 - ReplaceConstant - 10 -> 1
   * 57 Weak Mutation 471: smashed.Graph.readNumber()I:875 - ReplaceConstant - 10 -> -1
   * 58 Weak Mutation 468: smashed.Graph.readNumber()I:874 - DeleteStatement: trim()Ljava/lang/String;
   * 59 Weak Mutation 469: smashed.Graph.readNumber()I:875 - ReplaceConstant - 10 -> 0
   * 60 Weak Mutation 466: smashed.Graph.readNumber()I:874 - InsertUnaryOp Negation
   * 61 Weak Mutation 467: smashed.Graph.readNumber()I:874 - DeleteStatement: substring(II)Ljava/lang/String;
   * 62 Weak Mutation 464: smashed.Graph.readNumber()I:870 - ReplaceConstant - 0 -> 1
   * 63 Weak Mutation 465: smashed.Graph.readNumber()I:874 - ReplaceConstant - 0 -> 1
   * 64 Weak Mutation 463: smashed.Graph.readNumber()I:870 - InsertUnaryOp IINC -1
   * 65 Weak Mutation 462: smashed.Graph.readNumber()I:870 - InsertUnaryOp IINC 1
   * 66 Weak Mutation 461: smashed.Graph.readNumber()I:870 - InsertUnaryOp Negation
   * 67 Weak Mutation 460: smashed.Graph.readNumber()I:868 - DeleteStatement: read()I
   * 68 Weak Mutation 459: smashed.Graph.readNumber()I:868 - DeleteField: inFileLjava/io/Reader;
   * 69 Weak Mutation 458: smashed.Graph.readNumber()I:867 - InsertUnaryOp IINC -1
   * 70 Weak Mutation 457: smashed.Graph.readNumber()I:867 - InsertUnaryOp IINC 1
   * 71 Weak Mutation 456: smashed.Graph.readNumber()I:867 - InsertUnaryOp Negation
   * 72 Weak Mutation 455: smashed.Graph.readNumber()I:867 - InsertUnaryOp IINC -1
   * 73 Weak Mutation 454: smashed.Graph.readNumber()I:867 - InsertUnaryOp IINC 1
   * 74 Weak Mutation 453: smashed.Graph.readNumber()I:867 - InsertUnaryOp Negation
   * 75 Weak Mutation 452: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> <=
   * 76 Weak Mutation 450: smashed.Graph.readNumber()I:865 - ReplaceComparisonOperator == -> >=
   * 77 Weak Mutation 449: smashed.Graph.readNumber()I:865 - ReplaceConstant - 10 -> 11
   * 78 Weak Mutation 448: smashed.Graph.readNumber()I:865 - ReplaceConstant - 10 -> 9
   * 79 smashed.Graph.readNumber()I: I23 Branch 64 IF_ICMPNE L861 - true
   * 80 smashed.Graph.readNumber()I: I23 Branch 64 IF_ICMPNE L861 - false
   * 81 smashed.Graph.readNumber()I: I35 Branch 65 IF_ICMPEQ L865 - true
   * 82 smashed.Graph.readNumber()I: I35 Branch 65 IF_ICMPEQ L865 - false
   * 83 smashed.Graph.readNumber()I: I38 Branch 66 IF_ICMPEQ L865 - false
   * 84 smashed.Graph.readNumber()I: I41 Branch 67 IF_ICMPEQ L865 - false
   */
  @Test
  public void test15()  throws Throwable  {
      Graph graph0 = new Graph();
      char[] charArray0 = new char[8];
      charArray0[0] = ' ';
      charArray0[1] = ' ';
      charArray0[2] = '\'';
      CharArrayReader charArrayReader0 = new CharArrayReader(charArray0);
      graph0.inFile = (Reader) charArrayReader0;
      // Undeclared exception!
      try {
        graph0.readNumber();
        fail("Expecting exception: NumberFormatException");
      } catch(NumberFormatException e) {
        /*
         * For input string: \"'\"
         */
      }
  }
}
