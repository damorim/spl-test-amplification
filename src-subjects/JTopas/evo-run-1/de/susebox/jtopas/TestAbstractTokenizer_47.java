/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.java.lang.ExtIndexOutOfBoundsException;
import de.susebox.jtopas.AbstractTokenizer;
import de.susebox.jtopas.ReaderSource;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.TokenizerSource;
import de.susebox.jtopas.spi.KeywordHandler;
import de.susebox.jtopas.spi.PatternHandler;
import de.susebox.jtopas.spi.SequenceHandler;
import java.io.PipedReader;
import java.io.Reader;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizer_47 {


  //Test case number: 47
  /*
   * 224 covered goals:
   * 1 de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I: I80 Branch 195 LOOKUPSWITCH L1625 Case -1 - true
   * 2 de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I: I80 Branch 196 LOOKUPSWITCH L1625 Case 0 - false
   * 3 Weak Mutation 0: de.susebox.jtopas.AbstractTokenizer.<init>()V:1900 - ReplaceConstant - 0 -> 1
   * 4 Weak Mutation 1: de.susebox.jtopas.AbstractTokenizer.<init>()V:1909 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 2: de.susebox.jtopas.AbstractTokenizer.<init>()V:1914 - ReplaceConstant - 1 -> 0
   * 6 Weak Mutation 3: de.susebox.jtopas.AbstractTokenizer.<init>()V:1919 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 4: de.susebox.jtopas.AbstractTokenizer.<init>()V:1924 - ReplaceConstant - 0 -> 1
   * 8 Weak Mutation 5: de.susebox.jtopas.AbstractTokenizer.<init>()V:1930 - ReplaceConstant - -1 -> 0
   * 9 Weak Mutation 6: de.susebox.jtopas.AbstractTokenizer.<init>()V:1930 - ReplaceConstant - -1 -> 1
   * 10 Weak Mutation 7: de.susebox.jtopas.AbstractTokenizer.<init>()V:1930 - ReplaceConstant - -1 -> -2
   * 11 Weak Mutation 8: de.susebox.jtopas.AbstractTokenizer.<init>()V:1936 - ReplaceConstant - -1 -> 0
   * 12 Weak Mutation 9: de.susebox.jtopas.AbstractTokenizer.<init>()V:1936 - ReplaceConstant - -1 -> 1
   * 13 Weak Mutation 10: de.susebox.jtopas.AbstractTokenizer.<init>()V:1936 - ReplaceConstant - -1 -> -2
   * 14 Weak Mutation 11: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 3 -> 0
   * 15 Weak Mutation 12: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 3 -> 1
   * 16 Weak Mutation 13: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 3 -> -1
   * 17 Weak Mutation 14: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 3 -> 2
   * 18 Weak Mutation 15: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 3 -> 4
   * 19 Weak Mutation 17: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 1 -> 0
   * 20 Weak Mutation 16: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 0 -> 1
   * 21 Weak Mutation 19: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 2 -> 1
   * 22 Weak Mutation 18: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 2 -> 0
   * 23 Weak Mutation 21: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 2 -> 3
   * 24 Weak Mutation 20: de.susebox.jtopas.AbstractTokenizer.<init>()V:1943 - ReplaceConstant - 2 -> -1
   * 25 Weak Mutation 59: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:206 - ReplaceComparisonOperator = null -> != null
   * 26 Weak Mutation 57: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:201 - ReplaceComparisonOperator != null -> = null
   * 27 Weak Mutation 63: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:210 - DeleteStatement: addTokenizerPropertyListener(Lde/susebox/jtopas/TokenizerPropertyListener;)V
   * 28 Weak Mutation 62: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:210 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 29 Weak Mutation 70: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:218 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 30 Weak Mutation 71: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:218 - ReplaceComparisonOperator == -> !=
   * 31 Weak Mutation 64: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:213 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 32 Weak Mutation 65: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:213 - ReplaceComparisonOperator == -> !=
   * 33 Weak Mutation 66: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:214 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 34 Weak Mutation 67: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:214 - DeleteStatement: setWhitespaceHandler(Lde/susebox/jtopas/spi/WhitespaceHandler;)V
   * 35 Weak Mutation 76: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:223 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 36 Weak Mutation 77: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:223 - ReplaceComparisonOperator == -> !=
   * 37 Weak Mutation 78: de.susebox.jtopas.AbstractTokenizer.getTokenizerProperties()Lde/susebox/jtopas/TokenizerProperties;:260 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 38 Weak Mutation 72: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:219 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 39 Weak Mutation 73: de.susebox.jtopas.AbstractTokenizer.setTokenizerProperties(Lde/susebox/jtopas/TokenizerProperties;)V:219 - DeleteStatement: setSeparatorHandler(Lde/susebox/jtopas/spi/SeparatorHandler;)V
   * 40 Weak Mutation 152: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp -1
   * 41 Weak Mutation 154: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceConstant - -1 -> 0
   * 42 Weak Mutation 155: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceConstant - -1 -> 1
   * 43 Weak Mutation 156: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceConstant - -1 -> -2
   * 44 Weak Mutation 157: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceBitwiseOperator ^ -> &
   * 45 Weak Mutation 159: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceBitwiseOperator & -> |
   * 46 Weak Mutation 148: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - DeleteStatement: getTokenizerProperties()Lde/susebox/jtopas/TokenizerProperties;
   * 47 Weak Mutation 149: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - DeleteStatement: getParseFlags()I
   * 48 Weak Mutation 150: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp Negation
   * 49 Weak Mutation 151: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp +1
   * 50 Weak Mutation 175: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:313 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 51 Weak Mutation 173: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceArithmeticOperator + -> /
   * 52 Weak Mutation 172: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceArithmeticOperator + -> %
   * 53 Weak Mutation 163: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp -1
   * 54 Weak Mutation 162: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp +1
   * 55 Weak Mutation 161: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp Negation
   * 56 Weak Mutation 160: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - ReplaceBitwiseOperator & -> ^
   * 57 Weak Mutation 167: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp -1
   * 58 Weak Mutation 166: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp +1
   * 59 Weak Mutation 165: de.susebox.jtopas.AbstractTokenizer.getParseFlags()I:301 - InsertUnaryOp Negation
   * 60 Weak Mutation 186: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - ReplaceConstant - -3 -> 1
   * 61 Weak Mutation 187: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - ReplaceConstant - -3 -> -1
   * 62 Weak Mutation 185: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - ReplaceConstant - -3 -> 0
   * 63 Weak Mutation 190: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - ReplaceBitwiseOperator & -> |
   * 64 Weak Mutation 191: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - ReplaceBitwiseOperator & -> ^
   * 65 Weak Mutation 188: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - ReplaceConstant - -3 -> -4
   * 66 Weak Mutation 189: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - ReplaceConstant - -3 -> -2
   * 67 Weak Mutation 178: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:314 - ReplaceComparisonOperator = null -> != null
   * 68 Weak Mutation 179: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:314 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 69 Weak Mutation 176: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:313 - ReplaceComparisonOperator != -> ==
   * 70 Weak Mutation 177: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:314 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 71 Weak Mutation 182: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:314 - ReplaceComparisonOperator == -> !=
   * 72 Weak Mutation 183: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:319 - InsertUnaryOp Negation
   * 73 Weak Mutation 180: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:314 - DeleteStatement: getKeywords()Ljava/util/Iterator;
   * 74 Weak Mutation 181: de.susebox.jtopas.AbstractTokenizer.setKeywordHandler(Lde/susebox/jtopas/spi/KeywordHandler;)V:314 - DeleteStatement: hasNext()Z
   * 75 Weak Mutation 220: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 76 Weak Mutation 221: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - ReplaceComparisonOperator = null -> != null
   * 77 Weak Mutation 222: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 78 Weak Mutation 223: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: getSpecialSequences()Ljava/util/Iterator;
   * 79 Weak Mutation 218: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:400 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 80 Weak Mutation 219: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:400 - ReplaceComparisonOperator != -> ==
   * 81 Weak Mutation 238: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - InsertUnaryOp Negation
   * 82 Weak Mutation 237: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - ReplaceComparisonOperator == -> !=
   * 83 Weak Mutation 236: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: hasNext()Z
   * 84 Weak Mutation 235: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: getLineComments()Ljava/util/Iterator;
   * 85 Weak Mutation 234: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 86 Weak Mutation 233: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - ReplaceComparisonOperator != -> ==
   * 87 Weak Mutation 232: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: hasNext()Z
   * 88 Weak Mutation 231: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: getBlockComments()Ljava/util/Iterator;
   * 89 Weak Mutation 230: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 90 Weak Mutation 229: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - ReplaceComparisonOperator != -> ==
   * 91 Weak Mutation 228: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: hasNext()Z
   * 92 Weak Mutation 227: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: getStrings()Ljava/util/Iterator;
   * 93 Weak Mutation 226: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 94 Weak Mutation 225: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - ReplaceComparisonOperator != -> ==
   * 95 Weak Mutation 224: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:401 - DeleteStatement: hasNext()Z
   * 96 Weak Mutation 246: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - ReplaceBitwiseOperator & -> ^
   * 97 Weak Mutation 244: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - ReplaceConstant - -5 -> -4
   * 98 Weak Mutation 245: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - ReplaceBitwiseOperator & -> |
   * 99 Weak Mutation 242: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - ReplaceConstant - -5 -> -1
   * 100 Weak Mutation 243: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - ReplaceConstant - -5 -> -6
   * 101 Weak Mutation 240: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - ReplaceConstant - -5 -> 0
   * 102 Weak Mutation 241: de.susebox.jtopas.AbstractTokenizer.setSequenceHandler(Lde/susebox/jtopas/spi/SequenceHandler;)V:409 - ReplaceConstant - -5 -> 1
   * 103 Weak Mutation 275: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:445 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 104 Weak Mutation 274: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:444 - ReplaceComparisonOperator != -> ==
   * 105 Weak Mutation 273: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:444 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 106 Weak Mutation 279: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:445 - DeleteStatement: hasNext()Z
   * 107 Weak Mutation 278: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:445 - DeleteStatement: getPatterns()Ljava/util/Iterator;
   * 108 Weak Mutation 277: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:445 - DeleteField: _propertiesLde/susebox/jtopas/TokenizerProperties;
   * 109 Weak Mutation 276: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:445 - ReplaceComparisonOperator = null -> != null
   * 110 Weak Mutation 283: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:450 - ReplaceConstant - -2 -> 0
   * 111 Weak Mutation 281: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:450 - InsertUnaryOp Negation
   * 112 Weak Mutation 280: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:445 - ReplaceComparisonOperator == -> !=
   * 113 Weak Mutation 287: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:450 - ReplaceBitwiseOperator & -> |
   * 114 Weak Mutation 286: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:450 - ReplaceConstant - -2 -> -3
   * 115 Weak Mutation 285: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:450 - ReplaceConstant - -2 -> -1
   * 116 Weak Mutation 284: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:450 - ReplaceConstant - -2 -> 1
   * 117 Weak Mutation 305: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - DeleteStatement: longSub(JJ)I
   * 118 Weak Mutation 304: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceConstant - 0 -> -1
   * 119 Weak Mutation 309: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:469 - DeleteStatement: getTokenizerProperties()Lde/susebox/jtopas/TokenizerProperties;
   * 120 Weak Mutation 308: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceComparisonOperator != -> -1
   * 121 Weak Mutation 288: de.susebox.jtopas.AbstractTokenizer.setPatternHandler(Lde/susebox/jtopas/spi/PatternHandler;)V:450 - ReplaceBitwiseOperator & -> ^
   * 122 Weak Mutation 296: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - InsertUnaryOp Negation
   * 123 Weak Mutation 298: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceConstant - 1 -> 0
   * 124 Weak Mutation 299: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceConstant - 1 -> -1
   * 125 Weak Mutation 300: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceConstant - 1 -> 2
   * 126 Weak Mutation 301: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceBitwiseOperator & -> |
   * 127 Weak Mutation 302: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceBitwiseOperator & -> ^
   * 128 Weak Mutation 303: de.susebox.jtopas.AbstractTokenizer.getPatternHandler()Lde/susebox/jtopas/spi/PatternHandler;:468 - ReplaceConstant - 0 -> 1
   * 129 Weak Mutation 821: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1318 - DeleteField: _eofReachedZ
   * 130 Weak Mutation 820: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1318 - InsertUnaryOp Negation
   * 131 Weak Mutation 822: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1318 - ReplaceComparisonOperator != -> ==
   * 132 Weak Mutation 817: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1316 - ReplaceConstant - -1 -> 0
   * 133 Weak Mutation 819: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1316 - ReplaceConstant - -1 -> -2
   * 134 Weak Mutation 818: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1316 - ReplaceConstant - -1 -> 1
   * 135 Weak Mutation 855: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1336 - InsertUnaryOp Negation
   * 136 Weak Mutation 857: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1336 - InsertUnaryOp IINC -1
   * 137 Weak Mutation 856: de.susebox.jtopas.AbstractTokenizer.readMoreDataFromBase()I:1336 - InsertUnaryOp IINC 1
   * 138 Weak Mutation 1369: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1613 - ReplaceComparisonOperator == -> !=
   * 139 Weak Mutation 1368: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1613 - InsertUnaryOp IINC -1
   * 140 Weak Mutation 1367: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1613 - InsertUnaryOp IINC 1
   * 141 Weak Mutation 1366: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1613 - InsertUnaryOp Negation
   * 142 Weak Mutation 1365: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1607 - ReplaceConstant - 0 -> 1
   * 143 Weak Mutation 1364: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1606 - DeleteStatement: length()I
   * 144 Weak Mutation 1363: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1605 - DeleteStatement: isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z
   * 145 Weak Mutation 1362: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1605 - ReplaceConstant - 128 -> 129
   * 146 Weak Mutation 1361: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1605 - ReplaceConstant - 128 -> 127
   * 147 Weak Mutation 1360: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1605 - ReplaceConstant - 128 -> -1
   * 148 Weak Mutation 1358: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1605 - ReplaceConstant - 128 -> 0
   * 149 Weak Mutation 1359: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1605 - ReplaceConstant - 128 -> 1
   * 150 Weak Mutation 1356: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1604 - ReplaceConstant - 1 -> 0
   * 151 Weak Mutation 1357: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1604 - DeleteStatement: isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z
   * 152 Weak Mutation 1354: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1602 - ReplaceConstant - 0 -> 1
   * 153 Weak Mutation 1355: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1603 - ReplaceConstant - 1 -> 0
   * 154 Weak Mutation 1353: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1601 - DeleteStatement: getImages()[Ljava/lang/String;
   * 155 Weak Mutation 1401: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1625 - InsertUnaryOp IINC 1
   * 156 Weak Mutation 1400: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1625 - InsertUnaryOp Negation
   * 157 Weak Mutation 1403: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1625 - DeleteStatement: comparePrefix(ILjava/lang/String;Z)I
   * 158 Weak Mutation 1402: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1625 - InsertUnaryOp IINC -1
   * 159 Weak Mutation 1397: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1625 - InsertUnaryOp Negation
   * 160 Weak Mutation 1399: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1625 - InsertUnaryOp IINC -1
   * 161 Weak Mutation 1398: de.susebox.jtopas.AbstractTokenizer.completeBlockComment(Lde/susebox/jtopas/TokenizerProperty;)I:1625 - InsertUnaryOp IINC 1
   * 162 Weak Mutation 1493: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - ReplaceComparisonOperator < -> !=
   * 163 Weak Mutation 1490: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp +1
   * 164 Weak Mutation 1491: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp -1
   * 165 Weak Mutation 1488: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - ReplaceArithmeticOperator + -> *
   * 166 Weak Mutation 1489: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp Negation
   * 167 Weak Mutation 1502: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1720 - ReplaceConstant - -1 -> -2
   * 168 Weak Mutation 1500: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1720 - ReplaceConstant - -1 -> 0
   * 169 Weak Mutation 1501: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1720 - ReplaceConstant - -1 -> 1
   * 170 Weak Mutation 1499: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - ReplaceComparisonOperator >= -> -1
   * 171 Weak Mutation 1496: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - DeleteStatement: readMoreDataFromBase()I
   * 172 Weak Mutation 1479: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp +1
   * 173 Weak Mutation 1478: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp Negation
   * 174 Weak Mutation 1477: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - ReplaceComparisonOperator >= -> -1
   * 175 Weak Mutation 1474: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - ReplaceArithmeticOperator + -> *
   * 176 Weak Mutation 1473: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - ReplaceArithmeticOperator + -> /
   * 177 Weak Mutation 1472: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - ReplaceArithmeticOperator + -> %
   * 178 Weak Mutation 1487: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - ReplaceArithmeticOperator + -> /
   * 179 Weak Mutation 1486: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - ReplaceArithmeticOperator + -> %
   * 180 Weak Mutation 1485: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - ReplaceArithmeticOperator + -> -
   * 181 Weak Mutation 1484: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp IINC -1
   * 182 Weak Mutation 1483: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp IINC 1
   * 183 Weak Mutation 1482: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp Negation
   * 184 Weak Mutation 1480: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1719 - InsertUnaryOp -1
   * 185 Weak Mutation 1458: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1715 - DeleteStatement: length()I
   * 186 Weak Mutation 1459: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp Negation
   * 187 Weak Mutation 1460: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC 1
   * 188 Weak Mutation 1461: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC -1
   * 189 Weak Mutation 1462: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp Negation
   * 190 Weak Mutation 1463: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC 1
   * 191 Weak Mutation 1464: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC -1
   * 192 Weak Mutation 1465: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp Negation
   * 193 Weak Mutation 1466: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC 1
   * 194 Weak Mutation 1467: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC -1
   * 195 Weak Mutation 1468: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp Negation
   * 196 Weak Mutation 1469: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC 1
   * 197 Weak Mutation 1470: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - InsertUnaryOp IINC -1
   * 198 Weak Mutation 1471: de.susebox.jtopas.AbstractTokenizer.comparePrefix(ILjava/lang/String;Z)I:1717 - ReplaceArithmeticOperator + -> -
   * 199 Weak Mutation 1582: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - ReplaceBitwiseOperator & -> ^
   * 200 Weak Mutation 1580: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp IINC -1
   * 201 Weak Mutation 1581: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - ReplaceBitwiseOperator & -> |
   * 202 Weak Mutation 1578: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp Negation
   * 203 Weak Mutation 1579: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp IINC 1
   * 204 Weak Mutation 1576: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - DeleteStatement: getTokenizerProperties()Lde/susebox/jtopas/TokenizerProperties;
   * 205 Weak Mutation 1577: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - DeleteStatement: getParseFlags()I
   * 206 Weak Mutation 1574: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp IINC 1
   * 207 Weak Mutation 1575: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp IINC -1
   * 208 Weak Mutation 1572: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - ReplaceConstant - 0 -> 1
   * 209 Weak Mutation 1573: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp Negation
   * 210 Weak Mutation 1570: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - ReplaceComparisonOperator == -> -2
   * 211 Weak Mutation 1593: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - DeleteStatement: isFlagSet(IZ)Z
   * 212 Weak Mutation 1592: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - ReplaceConstant - 0 -> 1
   * 213 Weak Mutation 1590: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - ReplaceComparisonOperator == -> !=
   * 214 Weak Mutation 1589: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - DeleteStatement: isFlagSet(I)Z
   * 215 Weak Mutation 1588: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp IINC -1
   * 216 Weak Mutation 1587: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp IINC 1
   * 217 Weak Mutation 1586: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - InsertUnaryOp Negation
   * 218 Weak Mutation 1585: de.susebox.jtopas.AbstractTokenizer.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:1857 - ReplaceComparisonOperator != -> -1
   * 219 Weak Mutation 1565: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - InsertUnaryOp IINC -1
   * 220 Weak Mutation 1564: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - InsertUnaryOp IINC 1
   * 221 Weak Mutation 1567: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - ReplaceBitwiseOperator & -> ^
   * 222 Weak Mutation 1566: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - ReplaceBitwiseOperator & -> |
   * 223 Weak Mutation 1563: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - InsertUnaryOp Negation
   * 224 Weak Mutation 1562: de.susebox.jtopas.AbstractTokenizer.isFlagSet(I)Z:1828 - DeleteStatement: getParseFlags()I
   */
  @Test
  public void test47()  throws Throwable  {
      StandardTokenizer standardTokenizer0 = new StandardTokenizer();
      assertNotNull(standardTokenizer0);
      
      String[] stringArray0 = new String[8];
      stringArray0[0] = "yH:udt8";
      stringArray0[1] = "yH:udt8";
      StandardTokenizerProperties standardTokenizerProperties0 = (StandardTokenizerProperties)standardTokenizer0.getPatternHandler();
      assertNotNull(standardTokenizerProperties0);
      
      TokenizerProperty tokenizerProperty0 = new TokenizerProperty(65536, stringArray0, (Object) standardTokenizerProperties0);
      int int0 = standardTokenizer0.completeBlockComment(tokenizerProperty0);
      assertEquals(0, int0);
      assertEquals(0, standardTokenizer0.getParseFlags());
      assertEquals(-1, standardTokenizer0.readMoreDataFromBase());
      assertEquals(-1, standardTokenizer0.getCurrentLine());
  }
}