/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.tree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.DatabaseId;
import com.sleepycat.je.dbi.DatabaseImpl;
import com.sleepycat.je.dbi.INList;
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.ChildReference;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.InconsistentNodeException;
import com.sleepycat.je.tree.MapLN;
import com.sleepycat.je.tree.Node;
import com.sleepycat.je.tree.SearchResult;
import com.sleepycat.je.tree.Tree;
import com.sleepycat.je.tree.TreeWalkerStatsAccumulator;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

@RunWith(EvoSuiteRunner.class)
public class TestIN_56 {


  //Test case number: 56
  /*
   * 81 covered goals:
   * 1 Weak Mutation 1938: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> *
   * 2 Weak Mutation 1936: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> %
   * 3 Weak Mutation 1937: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> /
   * 4 Weak Mutation 1935: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> -
   * 5 Weak Mutation 1934: com.sleepycat.je.tree.IN.getLogSize()I:1977 - DeleteStatement: getByteArrayLogSize([B)I
   * 6 Weak Mutation 1933: com.sleepycat.je.tree.IN.getLogSize()I:1977 - DeleteField: identifierKey[B
   * 7 Weak Mutation 1932: com.sleepycat.je.tree.IN.getLogSize()I:1977 - InsertUnaryOp IINC -1
   * 8 Weak Mutation 1931: com.sleepycat.je.tree.IN.getLogSize()I:1977 - InsertUnaryOp IINC 1
   * 9 Weak Mutation 1930: com.sleepycat.je.tree.IN.getLogSize()I:1977 - InsertUnaryOp Negation
   * 10 Weak Mutation 1942: com.sleepycat.je.tree.IN.getLogSize()I:1978 - DeleteStatement: getBooleanLogSize()I
   * 11 Weak Mutation 1943: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> -
   * 12 Weak Mutation 1940: com.sleepycat.je.tree.IN.getLogSize()I:1978 - InsertUnaryOp IINC 1
   * 13 Weak Mutation 1941: com.sleepycat.je.tree.IN.getLogSize()I:1978 - InsertUnaryOp IINC -1
   * 14 Weak Mutation 1939: com.sleepycat.je.tree.IN.getLogSize()I:1978 - InsertUnaryOp Negation
   * 15 Weak Mutation 1946: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> *
   * 16 Weak Mutation 1944: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> %
   * 17 Weak Mutation 1945: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> /
   * 18 Weak Mutation 1953: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> /
   * 19 Weak Mutation 1952: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> %
   * 20 Weak Mutation 1954: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> *
   * 21 Weak Mutation 1950: com.sleepycat.je.tree.IN.getLogSize()I:1982 - DeleteStatement: getBooleanLogSize()I
   * 22 Weak Mutation 1951: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> -
   * 23 Weak Mutation 1948: com.sleepycat.je.tree.IN.getLogSize()I:1982 - InsertUnaryOp IINC 1
   * 24 Weak Mutation 1949: com.sleepycat.je.tree.IN.getLogSize()I:1982 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 1947: com.sleepycat.je.tree.IN.getLogSize()I:1982 - InsertUnaryOp Negation
   * 26 Weak Mutation 1957: com.sleepycat.je.tree.IN.getLogSize()I:1983 - ReplaceConstant - 1 -> 0
   * 27 Weak Mutation 1956: com.sleepycat.je.tree.IN.getLogSize()I:1983 - ReplaceComparisonOperator != null -> = null
   * 28 Weak Mutation 1959: com.sleepycat.je.tree.IN.getLogSize()I:1984 - InsertUnaryOp Negation
   * 29 Weak Mutation 1961: com.sleepycat.je.tree.IN.getLogSize()I:1984 - InsertUnaryOp IINC -1
   * 30 Weak Mutation 1960: com.sleepycat.je.tree.IN.getLogSize()I:1984 - InsertUnaryOp IINC 1
   * 31 Weak Mutation 1962: com.sleepycat.je.tree.IN.getLogSize()I:1984 - ReplaceComparisonOperator == -> !=
   * 32 Weak Mutation 1972: com.sleepycat.je.tree.IN.getLogSize()I:1987 - ReplaceComparisonOperator >= -> >
   * 33 Weak Mutation 1968: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp +1
   * 34 Weak Mutation 1969: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp -1
   * 35 Weak Mutation 1965: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp IINC 1
   * 36 Weak Mutation 1964: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp Negation
   * 37 Weak Mutation 1967: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp Negation
   * 38 Weak Mutation 1966: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp IINC -1
   * 39 Weak Mutation 1963: com.sleepycat.je.tree.IN.getLogSize()I:1987 - ReplaceConstant - 0 -> 1
   * 40 com.sleepycat.je.tree.IN.getLogSize()I: I38 Branch 135 IFNONNULL L1983 - false
   * 41 com.sleepycat.je.tree.IN.getLogSize()I: I48 Branch 136 IFEQ L1984 - false
   * 42 com.sleepycat.je.tree.IN.getLogSize()I: I60 Branch 137 IF_ICMPGE L1987 - true
   * 43 Weak Mutation 1972: com.sleepycat.je.tree.IN.getLogSize()I:1987 - ReplaceComparisonOperator >= -> >
   * 44 Weak Mutation 1968: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp +1
   * 45 Weak Mutation 1969: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp -1
   * 46 Weak Mutation 1957: com.sleepycat.je.tree.IN.getLogSize()I:1983 - ReplaceConstant - 1 -> 0
   * 47 Weak Mutation 1956: com.sleepycat.je.tree.IN.getLogSize()I:1983 - ReplaceComparisonOperator != null -> = null
   * 48 Weak Mutation 1959: com.sleepycat.je.tree.IN.getLogSize()I:1984 - InsertUnaryOp Negation
   * 49 Weak Mutation 1953: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> /
   * 50 Weak Mutation 1952: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> %
   * 51 Weak Mutation 1954: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> *
   * 52 Weak Mutation 1965: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp IINC 1
   * 53 Weak Mutation 1964: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp Negation
   * 54 Weak Mutation 1967: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp Negation
   * 55 Weak Mutation 1966: com.sleepycat.je.tree.IN.getLogSize()I:1987 - InsertUnaryOp IINC -1
   * 56 Weak Mutation 1961: com.sleepycat.je.tree.IN.getLogSize()I:1984 - InsertUnaryOp IINC -1
   * 57 Weak Mutation 1960: com.sleepycat.je.tree.IN.getLogSize()I:1984 - InsertUnaryOp IINC 1
   * 58 Weak Mutation 1963: com.sleepycat.je.tree.IN.getLogSize()I:1987 - ReplaceConstant - 0 -> 1
   * 59 Weak Mutation 1962: com.sleepycat.je.tree.IN.getLogSize()I:1984 - ReplaceComparisonOperator == -> !=
   * 60 Weak Mutation 1942: com.sleepycat.je.tree.IN.getLogSize()I:1978 - DeleteStatement: getBooleanLogSize()I
   * 61 Weak Mutation 1943: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> -
   * 62 Weak Mutation 1940: com.sleepycat.je.tree.IN.getLogSize()I:1978 - InsertUnaryOp IINC 1
   * 63 Weak Mutation 1941: com.sleepycat.je.tree.IN.getLogSize()I:1978 - InsertUnaryOp IINC -1
   * 64 Weak Mutation 1938: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> *
   * 65 Weak Mutation 1939: com.sleepycat.je.tree.IN.getLogSize()I:1978 - InsertUnaryOp Negation
   * 66 Weak Mutation 1936: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> %
   * 67 Weak Mutation 1937: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> /
   * 68 Weak Mutation 1950: com.sleepycat.je.tree.IN.getLogSize()I:1982 - DeleteStatement: getBooleanLogSize()I
   * 69 Weak Mutation 1951: com.sleepycat.je.tree.IN.getLogSize()I:1982 - ReplaceArithmeticOperator + -> -
   * 70 Weak Mutation 1948: com.sleepycat.je.tree.IN.getLogSize()I:1982 - InsertUnaryOp IINC 1
   * 71 Weak Mutation 1949: com.sleepycat.je.tree.IN.getLogSize()I:1982 - InsertUnaryOp IINC -1
   * 72 Weak Mutation 1946: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> *
   * 73 Weak Mutation 1947: com.sleepycat.je.tree.IN.getLogSize()I:1982 - InsertUnaryOp Negation
   * 74 Weak Mutation 1944: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> %
   * 75 Weak Mutation 1945: com.sleepycat.je.tree.IN.getLogSize()I:1978 - ReplaceArithmeticOperator + -> /
   * 76 Weak Mutation 1935: com.sleepycat.je.tree.IN.getLogSize()I:1977 - ReplaceArithmeticOperator + -> -
   * 77 Weak Mutation 1934: com.sleepycat.je.tree.IN.getLogSize()I:1977 - DeleteStatement: getByteArrayLogSize([B)I
   * 78 Weak Mutation 1933: com.sleepycat.je.tree.IN.getLogSize()I:1977 - DeleteField: identifierKey[B
   * 79 Weak Mutation 1932: com.sleepycat.je.tree.IN.getLogSize()I:1977 - InsertUnaryOp IINC -1
   * 80 Weak Mutation 1931: com.sleepycat.je.tree.IN.getLogSize()I:1977 - InsertUnaryOp IINC 1
   * 81 Weak Mutation 1930: com.sleepycat.je.tree.IN.getLogSize()I:1977 - InsertUnaryOp Negation
   */
  @Test
  public void test56()  throws Throwable  {
      DBIN dBIN0 = new DBIN();
      assertNotNull(dBIN0);
      
      // Undeclared exception!
      try {
        dBIN0.getLogSize();
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
