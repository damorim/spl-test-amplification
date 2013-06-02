/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.StandardTokenizerProperties;

@RunWith(EvoSuiteRunner.class)
public class TestAbstractTokenizerProperties_9 {


  //Test case number: 9
  /*
   * 127 covered goals:
   * 1 Weak Mutation 146: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V:395 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
   * 2 Weak Mutation 147: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V:412 - DeleteStatement: getParseFlags()I
   * 3 Weak Mutation 148: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V:412 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V
   * 4 Weak Mutation 152: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp Negation
   * 5 Weak Mutation 153: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC 1
   * 6 Weak Mutation 154: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC -1
   * 7 Weak Mutation 155: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V
   * 8 Weak Mutation 149: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp Negation
   * 9 Weak Mutation 150: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC 1
   * 10 Weak Mutation 151: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC -1
   * 11 Weak Mutation 156: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 0
   * 12 Weak Mutation 157: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 1
   * 13 Weak Mutation 158: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> -1
   * 14 Weak Mutation 159: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 3
   * 15 Weak Mutation 171: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp Negation
   * 16 Weak Mutation 170: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 3
   * 17 Weak Mutation 169: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> -1
   * 18 Weak Mutation 168: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 1
   * 19 Weak Mutation 175: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC 1
   * 20 Weak Mutation 174: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp Negation
   * 21 Weak Mutation 173: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC -1
   * 22 Weak Mutation 172: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC 1
   * 23 Weak Mutation 163: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 2
   * 24 Weak Mutation 162: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> -1
   * 25 Weak Mutation 161: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 1
   * 26 Weak Mutation 160: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 0
   * 27 Weak Mutation 167: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 0
   * 28 Weak Mutation 166: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 1 -> 0
   * 29 Weak Mutation 165: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 0 -> 1
   * 30 Weak Mutation 164: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 4
   * 31 Weak Mutation 176: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC -1
   * 32 Weak Mutation 177: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - DeleteStatement: addProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 33 Weak Mutation 410: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> 0
   * 34 Weak Mutation 411: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> 1
   * 35 Weak Mutation 414: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceComparisonOperator >= -> ==
   * 36 Weak Mutation 412: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> -1
   * 37 Weak Mutation 413: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> 3
   * 38 Weak Mutation 417: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 1 -> 0
   * 39 Weak Mutation 419: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - DeleteStatement: checkArgument(Ljava/lang/String;Ljava/lang/String;)V
   * 40 Weak Mutation 418: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - End sequence -> 
   * 41 Weak Mutation 720: de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V:1504 - ReplaceComparisonOperator != null -> = null
   * 42 Weak Mutation 724: de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V:1506 - DeleteStatement: length()I
   * 43 Weak Mutation 727: de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V:1506 - ReplaceComparisonOperator > -> -2
   * 44 de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V: root-Branch
   * 45 de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V: root-Branch
   * 46 de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V: root-Branch
   * 47 de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V: root-Branch
   * 48 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I14 Branch 29 LOOKUPSWITCH L1216 Case 2 - true
   * 49 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I14 Branch 31 LOOKUPSWITCH L1216 Default-Case - false
   * 50 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I21 Branch 32 IF_ICMPGE L1219 - true
   * 51 de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V: I3 Branch 65 IFNONNULL L1504 - true
   * 52 de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V: I21 Branch 66 IFGT L1506 - true
   * 53 Weak Mutation 51: de.susebox.jtopas.AbstractTokenizerProperties.getParseFlags()I:212 - InsertUnaryOp Negation
   * 54 Weak Mutation 53: de.susebox.jtopas.AbstractTokenizerProperties.getParseFlags()I:212 - InsertUnaryOp -1
   * 55 Weak Mutation 52: de.susebox.jtopas.AbstractTokenizerProperties.getParseFlags()I:212 - InsertUnaryOp +1
   * 56 Weak Mutation 67: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(I)Z:225 - ReplaceComparisonOperator != -> >
   * 57 Weak Mutation 76: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - InsertUnaryOp IINC 1
   * 58 Weak Mutation 77: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - InsertUnaryOp IINC -1
   * 59 Weak Mutation 78: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - DeleteStatement: isFlagSet(I)Z
   * 60 Weak Mutation 79: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - DeleteStatement: isFlagSet(IZ)Z
   * 61 Weak Mutation 72: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - InsertUnaryOp Negation
   * 62 Weak Mutation 73: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - InsertUnaryOp IINC 1
   * 63 Weak Mutation 74: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - InsertUnaryOp IINC -1
   * 64 Weak Mutation 75: de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z:241 - InsertUnaryOp Negation
   * 65 Weak Mutation 152: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp Negation
   * 66 Weak Mutation 153: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC 1
   * 67 Weak Mutation 154: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC -1
   * 68 Weak Mutation 155: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V
   * 69 Weak Mutation 156: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 0
   * 70 Weak Mutation 157: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 1
   * 71 Weak Mutation 158: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> -1
   * 72 Weak Mutation 159: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 3
   * 73 Weak Mutation 146: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V:395 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
   * 74 Weak Mutation 147: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V:412 - DeleteStatement: getParseFlags()I
   * 75 Weak Mutation 148: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V:412 - DeleteStatement: addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V
   * 76 Weak Mutation 149: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp Negation
   * 77 Weak Mutation 150: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC 1
   * 78 Weak Mutation 151: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;I)V:429 - InsertUnaryOp IINC -1
   * 79 Weak Mutation 171: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp Negation
   * 80 Weak Mutation 170: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 3
   * 81 Weak Mutation 169: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> -1
   * 82 Weak Mutation 168: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 1
   * 83 Weak Mutation 175: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC 1
   * 84 Weak Mutation 174: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp Negation
   * 85 Weak Mutation 173: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC -1
   * 86 Weak Mutation 172: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC 1
   * 87 Weak Mutation 163: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 2
   * 88 Weak Mutation 162: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> -1
   * 89 Weak Mutation 161: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 1
   * 90 Weak Mutation 160: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 0
   * 91 Weak Mutation 167: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 2 -> 0
   * 92 Weak Mutation 166: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 1 -> 0
   * 93 Weak Mutation 165: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 0 -> 1
   * 94 Weak Mutation 164: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - ReplaceConstant - 3 -> 4
   * 95 Weak Mutation 176: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - InsertUnaryOp IINC -1
   * 96 Weak Mutation 177: de.susebox.jtopas.AbstractTokenizerProperties.addString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;II)V:447 - DeleteStatement: addProperty(Lde/susebox/jtopas/TokenizerProperty;)V
   * 97 Weak Mutation 410: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> 0
   * 98 Weak Mutation 411: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> 1
   * 99 Weak Mutation 408: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1214 - DeleteStatement: getImages()[Ljava/lang/String;
   * 100 Weak Mutation 409: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1216 - DeleteStatement: getType()I
   * 101 Weak Mutation 414: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceComparisonOperator >= -> ==
   * 102 Weak Mutation 412: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> -1
   * 103 Weak Mutation 413: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 2 -> 3
   * 104 Weak Mutation 407: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1211 - DeleteStatement: checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V
   * 105 Weak Mutation 417: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - 1 -> 0
   * 106 Weak Mutation 419: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - DeleteStatement: checkArgument(Ljava/lang/String;Ljava/lang/String;)V
   * 107 Weak Mutation 418: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1219 - ReplaceConstant - End sequence -> 
   * 108 Weak Mutation 421: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1227 - ReplaceComparisonOperator != null -> = null
   * 109 Weak Mutation 420: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1225 - DeleteStatement: doAddProperty(Lde/susebox/jtopas/TokenizerProperty;)Lde/susebox/jtopas/TokenizerProperty;
   * 110 Weak Mutation 423: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1228 - DeleteStatement: notifyListeners(Lde/susebox/jtopas/TokenizerPropertyEvent;)V
   * 111 Weak Mutation 422: de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V:1228 - ReplaceConstant - 1 -> 0
   * 112 Weak Mutation 738: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1525 - ReplaceComparisonOperator != null -> = null
   * 113 Weak Mutation 737: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1525 - ReplaceConstant - 0 -> 1
   * 114 Weak Mutation 736: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1525 - DeleteStatement: getImages()[Ljava/lang/String;
   * 115 Weak Mutation 731: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1521 - ReplaceComparisonOperator != null -> = null
   * 116 Weak Mutation 733: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1523 - DeleteStatement: getImages()[Ljava/lang/String;
   * 117 Weak Mutation 734: de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V:1523 - ReplaceComparisonOperator != null -> = null
   * 118 Weak Mutation 720: de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V:1504 - ReplaceComparisonOperator != null -> = null
   * 119 Weak Mutation 724: de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V:1506 - DeleteStatement: length()I
   * 120 Weak Mutation 727: de.susebox.jtopas.AbstractTokenizerProperties.checkArgument(Ljava/lang/String;Ljava/lang/String;)V:1506 - ReplaceComparisonOperator > -> -2
   * 121 de.susebox.jtopas.AbstractTokenizerProperties.isFlagSet(Lde/susebox/jtopas/TokenizerProperty;I)Z: root-Branch
   * 122 de.susebox.jtopas.AbstractTokenizerProperties.getParseFlags()I: root-Branch
   * 123 de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V: I3 Branch 67 IFNONNULL L1521 - true
   * 124 de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V: I16 Branch 68 IFNONNULL L1523 - true
   * 125 de.susebox.jtopas.AbstractTokenizerProperties.checkPropertyArgument(Lde/susebox/jtopas/TokenizerProperty;)V: I31 Branch 69 IFNONNULL L1525 - true
   * 126 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I14 Branch 30 LOOKUPSWITCH L1216 Case 8 - false
   * 127 de.susebox.jtopas.AbstractTokenizerProperties.addProperty(Lde/susebox/jtopas/TokenizerProperty;)V: I46 Branch 33 IFNONNULL L1227 - false
   */
  @Test
  public void test9()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = new StandardTokenizerProperties();
      standardTokenizerProperties0.addString(">4_l2R3-", ">4_l2R3-", ">4_l2R3-");
      assertEquals(8, standardTokenizerProperties0.getSequenceMaxLength());
      assertEquals(0, standardTokenizerProperties0.getParseFlags());
  }
}