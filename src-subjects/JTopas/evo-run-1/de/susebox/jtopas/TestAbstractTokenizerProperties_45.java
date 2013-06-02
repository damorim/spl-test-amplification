/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizerProperties_45 {


  //Test case number: 45
  /*
   * 176 covered goals:
   * 1 Weak Mutation 558: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 91
   * 2 Weak Mutation 559: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 93
   * 3 Weak Mutation 556: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 1
   * 4 Weak Mutation 557: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> -1
   * 5 Weak Mutation 555: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 0
   * 6 Weak Mutation 560: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 7 de.susebox.jtopas.AbstractTokenizerProperties.escapeChar(C)Z: I3 Branch 53 LOOKUPSWITCH L1394 Case 92 - true
   * 8 de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V: I5 Branch 55 IFEQ L1412 - false
   * 9 Weak Mutation 139: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:367 - DeleteStatement: length()I
   * 10 Weak Mutation 143: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:368 - DeleteStatement: getSeparators()Ljava/lang/String;
   * 11 Weak Mutation 142: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:367 - ReplaceComparisonOperator <= -> -1
   * 12 Weak Mutation 144: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:368 - ReplaceConstant - 1 -> 0
   * 13 Weak Mutation 145: de.susebox.jtopas.AbstractTokenizerProperties.removeSeparators(Ljava/lang/String;)V:368 - DeleteStatement: setSeparators(Ljava/lang/String;)V
   * 14 Weak Mutation 478: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1347 - InsertUnaryOp Negation
   * 15 Weak Mutation 479: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1347 - InsertUnaryOp IINC 1
   * 16 Weak Mutation 476: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1345 - InsertUnaryOp IINC -1
   * 17 Weak Mutation 477: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1345 - DeleteStatement: charAt(I)C
   * 18 Weak Mutation 474: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1345 - InsertUnaryOp Negation
   * 19 Weak Mutation 475: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1345 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 472: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1344 - ReplaceComparisonOperator >= -> >
   * 21 Weak Mutation 473: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1344 - ReplaceComparisonOperator >= -> -1
   * 22 Weak Mutation 470: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1344 - DeleteStatement: length()I
   * 23 Weak Mutation 468: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1344 - InsertUnaryOp IINC 1
   * 24 Weak Mutation 469: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1344 - InsertUnaryOp IINC -1
   * 25 Weak Mutation 466: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1344 - ReplaceConstant - 0 -> 1
   * 26 Weak Mutation 467: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1344 - InsertUnaryOp Negation
   * 27 Weak Mutation 508: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - ReplaceComparisonOperator != -> <
   * 28 Weak Mutation 504: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - ReplaceConstant - 92 -> -1
   * 29 Weak Mutation 505: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - ReplaceConstant - 92 -> 91
   * 30 Weak Mutation 506: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - ReplaceConstant - 92 -> 93
   * 31 Weak Mutation 507: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - ReplaceComparisonOperator != -> >
   * 32 Weak Mutation 500: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - InsertUnaryOp IINC 1
   * 33 Weak Mutation 501: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - InsertUnaryOp IINC -1
   * 34 Weak Mutation 502: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - ReplaceConstant - 92 -> 0
   * 35 Weak Mutation 503: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - ReplaceConstant - 92 -> 1
   * 36 Weak Mutation 496: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - ReplaceArithmeticOperator + -> /
   * 37 Weak Mutation 497: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - ReplaceArithmeticOperator + -> *
   * 38 Weak Mutation 498: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - DeleteStatement: charAt(I)C
   * 39 Weak Mutation 499: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1352 - InsertUnaryOp Negation
   * 40 Weak Mutation 493: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - ReplaceConstant - 1 -> 0
   * 41 Weak Mutation 492: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - InsertUnaryOp IINC -1
   * 42 Weak Mutation 495: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - ReplaceArithmeticOperator + -> %
   * 43 Weak Mutation 494: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - ReplaceArithmeticOperator + -> -
   * 44 Weak Mutation 489: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - DeleteStatement: charAt(I)C
   * 45 Weak Mutation 488: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - ReplaceArithmeticOperator - -> *
   * 46 Weak Mutation 491: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - InsertUnaryOp IINC 1
   * 47 Weak Mutation 490: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1351 - InsertUnaryOp Negation
   * 48 Weak Mutation 485: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - ReplaceArithmeticOperator - -> +
   * 49 Weak Mutation 484: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - ReplaceConstant - 1 -> 0
   * 50 Weak Mutation 487: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - ReplaceArithmeticOperator - -> /
   * 51 Weak Mutation 486: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - ReplaceArithmeticOperator - -> %
   * 52 Weak Mutation 481: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - InsertUnaryOp Negation
   * 53 Weak Mutation 480: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1347 - InsertUnaryOp IINC -1
   * 54 Weak Mutation 483: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - InsertUnaryOp IINC -1
   * 55 Weak Mutation 482: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1350 - InsertUnaryOp IINC 1
   * 56 Weak Mutation 550: de.susebox.jtopas.AbstractTokenizerProperties.escapeChar(C)Z:1399 - ReplaceConstant - 0 -> 1
   * 57 Weak Mutation 551: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1412 - InsertUnaryOp Negation
   * 58 Weak Mutation 548: de.susebox.jtopas.AbstractTokenizerProperties.escapeChar(C)Z:1394 - InsertUnaryOp IINC -1
   * 59 Weak Mutation 549: de.susebox.jtopas.AbstractTokenizerProperties.escapeChar(C)Z:1397 - ReplaceConstant - 1 -> 0
   * 60 Weak Mutation 546: de.susebox.jtopas.AbstractTokenizerProperties.escapeChar(C)Z:1394 - InsertUnaryOp Negation
   * 61 Weak Mutation 547: de.susebox.jtopas.AbstractTokenizerProperties.escapeChar(C)Z:1394 - InsertUnaryOp IINC 1
   * 62 Weak Mutation 544: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1362 - InsertUnaryOp IINC -1
   * 63 Weak Mutation 545: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1362 - DeleteStatement: put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
   * 64 Weak Mutation 554: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1412 - ReplaceComparisonOperator == -> !=
   * 65 Weak Mutation 552: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1412 - InsertUnaryOp IINC 1
   * 66 Weak Mutation 553: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1412 - InsertUnaryOp IINC -1
   * 67 Weak Mutation 567: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - InsertUnaryOp IINC -1
   * 68 Weak Mutation 566: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - InsertUnaryOp IINC 1
   * 69 Weak Mutation 565: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - InsertUnaryOp Negation
   * 70 Weak Mutation 564: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1415 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 71 Weak Mutation 563: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1415 - InsertUnaryOp IINC -1
   * 72 Weak Mutation 562: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1415 - InsertUnaryOp IINC 1
   * 73 Weak Mutation 561: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1415 - InsertUnaryOp Negation
   * 74 Weak Mutation 575: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceArithmeticOperator - -> *
   * 75 Weak Mutation 574: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceArithmeticOperator - -> /
   * 76 Weak Mutation 573: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceArithmeticOperator - -> %
   * 77 Weak Mutation 572: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceArithmeticOperator - -> +
   * 78 Weak Mutation 571: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceConstant - 1 -> 0
   * 79 Weak Mutation 570: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - InsertUnaryOp IINC -1
   * 80 Weak Mutation 569: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - InsertUnaryOp IINC 1
   * 81 Weak Mutation 568: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - InsertUnaryOp Negation
   * 82 Weak Mutation 524: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp IINC -1
   * 83 Weak Mutation 525: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp Negation
   * 84 Weak Mutation 526: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp IINC 1
   * 85 Weak Mutation 527: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp IINC -1
   * 86 Weak Mutation 522: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp Negation
   * 87 Weak Mutation 523: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp IINC 1
   * 88 Weak Mutation 533: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - ReplaceComparisonOperator > -> -2
   * 89 Weak Mutation 532: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - ReplaceComparisonOperator > -> !=
   * 90 Weak Mutation 535: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1359 - InsertUnaryOp IINC 1
   * 91 Weak Mutation 534: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1359 - InsertUnaryOp Negation
   * 92 Weak Mutation 529: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp IINC 1
   * 93 Weak Mutation 528: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp Negation
   * 94 Weak Mutation 531: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - ReplaceComparisonOperator > -> >=
   * 95 Weak Mutation 530: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1358 - InsertUnaryOp IINC -1
   * 96 Weak Mutation 543: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1362 - InsertUnaryOp IINC 1
   * 97 Weak Mutation 542: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1362 - InsertUnaryOp Negation
   * 98 Weak Mutation 537: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1359 - ReplaceComparisonOperator == -> !=
   * 99 Weak Mutation 536: de.susebox.jtopas.AbstractTokenizerProperties.mapCharacterSet(Ljava/util/Map;Ljava/lang/String;Z)V:1359 - InsertUnaryOp IINC -1
   * 100 Weak Mutation 610: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1444 - InsertUnaryOp IINC 1
   * 101 Weak Mutation 611: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1444 - InsertUnaryOp IINC -1
   * 102 Weak Mutation 608: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1443 - ReplaceConstant - 0 -> 1
   * 103 Weak Mutation 609: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1444 - InsertUnaryOp Negation
   * 104 Weak Mutation 614: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1447 - ReplaceArithmeticOperator + -> -
   * 105 Weak Mutation 615: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1447 - ReplaceArithmeticOperator + -> %
   * 106 Weak Mutation 612: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1447 - DeleteStatement: length()I
   * 107 Weak Mutation 613: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1447 - DeleteStatement: length()I
   * 108 Weak Mutation 618: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1449 - DeleteStatement: size()I
   * 109 Weak Mutation 616: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1447 - ReplaceArithmeticOperator + -> /
   * 110 Weak Mutation 617: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1447 - ReplaceArithmeticOperator + -> *
   * 111 Weak Mutation 622: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1450 - DeleteStatement: keySet()Ljava/util/Set;
   * 112 Weak Mutation 623: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1450 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 113 Weak Mutation 621: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1449 - ReplaceComparisonOperator <= -> -1
   * 114 Weak Mutation 627: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1452 - InsertUnaryOp IINC 1
   * 115 Weak Mutation 626: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1452 - InsertUnaryOp Negation
   * 116 Weak Mutation 625: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1451 - DeleteStatement: charValue()C
   * 117 Weak Mutation 624: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1451 - DeleteStatement: firstKey()Ljava/lang/Object;
   * 118 Weak Mutation 631: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1455 - DeleteStatement: next()Ljava/lang/Object;
   * 119 Weak Mutation 630: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1454 - ReplaceComparisonOperator == -> !=
   * 120 Weak Mutation 629: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1454 - DeleteStatement: hasNext()Z
   * 121 Weak Mutation 628: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1452 - InsertUnaryOp IINC -1
   * 122 Weak Mutation 635: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - InsertUnaryOp IINC -1
   * 123 Weak Mutation 634: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - InsertUnaryOp IINC 1
   * 124 Weak Mutation 633: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - InsertUnaryOp Negation
   * 125 Weak Mutation 632: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1455 - DeleteStatement: charValue()C
   * 126 Weak Mutation 639: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceConstant - 1 -> 0
   * 127 Weak Mutation 638: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - InsertUnaryOp IINC -1
   * 128 Weak Mutation 637: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - InsertUnaryOp IINC 1
   * 129 Weak Mutation 636: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - InsertUnaryOp Negation
   * 130 Weak Mutation 576: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceComparisonOperator >= -> ==
   * 131 Weak Mutation 577: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceComparisonOperator >= -> >
   * 132 Weak Mutation 578: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1416 - ReplaceComparisonOperator >= -> -1
   * 133 Weak Mutation 579: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1417 - ReplaceConstant - 45 -> 0
   * 134 Weak Mutation 580: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1417 - ReplaceConstant - 45 -> 1
   * 135 Weak Mutation 581: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1417 - ReplaceConstant - 45 -> -1
   * 136 Weak Mutation 582: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1417 - ReplaceConstant - 45 -> 44
   * 137 Weak Mutation 583: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1417 - ReplaceConstant - 45 -> 46
   * 138 Weak Mutation 584: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1417 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 139 Weak Mutation 585: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - InsertUnaryOp Negation
   * 140 Weak Mutation 586: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - InsertUnaryOp IINC 1
   * 141 Weak Mutation 587: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - InsertUnaryOp IINC -1
   * 142 Weak Mutation 588: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - InsertUnaryOp Negation
   * 143 Weak Mutation 589: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - InsertUnaryOp IINC 1
   * 144 Weak Mutation 590: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - InsertUnaryOp IINC -1
   * 145 Weak Mutation 593: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - ReplaceComparisonOperator == -> <=
   * 146 Weak Mutation 592: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1419 - ReplaceComparisonOperator == -> -2
   * 147 Weak Mutation 595: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1420 - InsertUnaryOp IINC 1
   * 148 Weak Mutation 594: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1420 - InsertUnaryOp Negation
   * 149 Weak Mutation 597: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1420 - ReplaceComparisonOperator == -> !=
   * 150 Weak Mutation 596: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1420 - InsertUnaryOp IINC -1
   * 151 Weak Mutation 605: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1423 - InsertUnaryOp IINC 1
   * 152 Weak Mutation 604: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1423 - InsertUnaryOp Negation
   * 153 Weak Mutation 607: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1423 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   * 154 Weak Mutation 606: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1423 - InsertUnaryOp IINC -1
   * 155 Weak Mutation 653: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1459 - InsertUnaryOp Negation
   * 156 Weak Mutation 652: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1458 - InsertUnaryOp IINC -1
   * 157 Weak Mutation 655: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1459 - InsertUnaryOp IINC -1
   * 158 Weak Mutation 654: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1459 - InsertUnaryOp IINC 1
   * 159 Weak Mutation 649: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1458 - InsertUnaryOp IINC -1
   * 160 Weak Mutation 648: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1458 - InsertUnaryOp IINC 1
   * 161 Weak Mutation 651: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1458 - InsertUnaryOp IINC 1
   * 162 Weak Mutation 650: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1458 - InsertUnaryOp Negation
   * 163 Weak Mutation 645: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceComparisonOperator <= -> <
   * 164 Weak Mutation 644: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceComparisonOperator <= -> ==
   * 165 Weak Mutation 647: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1458 - InsertUnaryOp Negation
   * 166 Weak Mutation 646: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceComparisonOperator <= -> -1
   * 167 Weak Mutation 641: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceArithmeticOperator + -> %
   * 168 Weak Mutation 640: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceArithmeticOperator + -> -
   * 169 Weak Mutation 643: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceArithmeticOperator + -> *
   * 170 Weak Mutation 642: de.susebox.jtopas.AbstractTokenizerProperties.mergeSet(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;:1457 - ReplaceArithmeticOperator + -> /
   * 171 Weak Mutation 558: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 91
   * 172 Weak Mutation 559: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 93
   * 173 Weak Mutation 556: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 1
   * 174 Weak Mutation 557: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> -1
   * 175 Weak Mutation 555: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - ReplaceConstant - 92 -> 0
   * 176 Weak Mutation 560: de.susebox.jtopas.AbstractTokenizerProperties.addRange(Ljava/lang/StringBuffer;CC)V:1413 - DeleteStatement: append(C)Ljava/lang/StringBuffer;
   */
  @Test
  public void test45()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties(0);
      standardTokenizerProperties0.removeSeparators("ezxdt[AS=b:KDVWLd=");
      assertEquals("!#-/;<>-@\\\\-^`{-~", standardTokenizerProperties0.getSeparators());
  }
}
