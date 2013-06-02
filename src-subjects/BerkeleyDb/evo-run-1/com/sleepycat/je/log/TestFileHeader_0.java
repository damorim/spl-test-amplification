/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.log.FileHeader;

@RunWith(EvoSuiteRunner.class)
public class TestFileHeader_0 {


  //Test case number: 0
  /*
   * 70 covered goals:
   * 1 Weak Mutation 117: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:110 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 2 Weak Mutation 116: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:110 - ReplaceConstant - <FileHeader num="0x -> 
   * 3 Weak Mutation 119: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - DeleteField: fileNumJ
   * 4 Weak Mutation 118: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - InsertUnaryOp Negation
   * 5 Weak Mutation 121: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 6 Weak Mutation 120: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - DeleteStatement: toHexString(J)Ljava/lang/String;
   * 7 Weak Mutation 123: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:112 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 8 Weak Mutation 122: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:112 - ReplaceConstant - " lastEntryInPrevFileOffset="0x -> 
   * 9 Weak Mutation 127: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 10 Weak Mutation 126: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - DeleteStatement: toHexString(J)Ljava/lang/String;
   * 11 Weak Mutation 125: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - DeleteField: lastEntryInPrevFileOffsetJ
   * 12 Weak Mutation 124: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - InsertUnaryOp Negation
   * 13 Weak Mutation 129: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:114 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 14 Weak Mutation 128: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:114 - ReplaceConstant - " logVersion="0x -> 
   * 15 Weak Mutation 131: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - InsertUnaryOp +1
   * 16 Weak Mutation 130: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - InsertUnaryOp Negation
   * 17 Weak Mutation 133: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - DeleteField: logVersionI
   * 18 Weak Mutation 132: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - InsertUnaryOp -1
   * 19 Weak Mutation 135: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 20 Weak Mutation 134: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - DeleteStatement: toHexString(I)Ljava/lang/String;
   * 21 Weak Mutation 137: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 22 Weak Mutation 136: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - ReplaceConstant - " time=" -> 
   * 23 Weak Mutation 139: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 24 Weak Mutation 138: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - DeleteField: timeLjava/sql/Timestamp;
   * 25 Weak Mutation 141: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:117 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 26 Weak Mutation 140: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:117 - ReplaceConstant - "/> -> 
   * 27 Weak Mutation 145: com.sleepycat.je.log.FileHeader.toString()Ljava/lang/String;:136 - ReplaceConstant - 1 -> 0
   * 28 Weak Mutation 146: com.sleepycat.je.log.FileHeader.toString()Ljava/lang/String;:136 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 29 Weak Mutation 147: com.sleepycat.je.log.FileHeader.toString()Ljava/lang/String;:137 - DeleteStatement: toString()Ljava/lang/String;
   * 30 com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V: root-Branch
   * 31 com.sleepycat.je.log.FileHeader.toString()Ljava/lang/String;: root-Branch
   * 32 Weak Mutation 0: com.sleepycat.je.log.FileHeader.<init>(JJ)V:17 - InsertUnaryOp Negation
   * 33 Weak Mutation 1: com.sleepycat.je.log.FileHeader.<init>(JJ)V:18 - InsertUnaryOp Negation
   * 34 Weak Mutation 2: com.sleepycat.je.log.FileHeader.<init>(JJ)V:19 - DeleteStatement: getInstance()Ljava/util/Calendar;
   * 35 Weak Mutation 3: com.sleepycat.je.log.FileHeader.<init>(JJ)V:20 - DeleteStatement: getTimeInMillis()J
   * 36 Weak Mutation 4: com.sleepycat.je.log.FileHeader.<init>(JJ)V:21 - ReplaceConstant - 3 -> 0
   * 37 Weak Mutation 5: com.sleepycat.je.log.FileHeader.<init>(JJ)V:21 - ReplaceConstant - 3 -> 1
   * 38 Weak Mutation 6: com.sleepycat.je.log.FileHeader.<init>(JJ)V:21 - ReplaceConstant - 3 -> -1
   * 39 Weak Mutation 7: com.sleepycat.je.log.FileHeader.<init>(JJ)V:21 - ReplaceConstant - 3 -> 2
   * 40 Weak Mutation 8: com.sleepycat.je.log.FileHeader.<init>(JJ)V:21 - ReplaceConstant - 3 -> 4
   * 41 Weak Mutation 119: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - DeleteField: fileNumJ
   * 42 Weak Mutation 118: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - InsertUnaryOp Negation
   * 43 Weak Mutation 117: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:110 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 44 Weak Mutation 116: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:110 - ReplaceConstant - <FileHeader num="0x -> 
   * 45 Weak Mutation 127: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 46 Weak Mutation 126: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - DeleteStatement: toHexString(J)Ljava/lang/String;
   * 47 Weak Mutation 125: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - DeleteField: lastEntryInPrevFileOffsetJ
   * 48 Weak Mutation 124: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:113 - InsertUnaryOp Negation
   * 49 Weak Mutation 123: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:112 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 50 Weak Mutation 122: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:112 - ReplaceConstant - " lastEntryInPrevFileOffset="0x -> 
   * 51 Weak Mutation 121: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 52 Weak Mutation 120: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:111 - DeleteStatement: toHexString(J)Ljava/lang/String;
   * 53 Weak Mutation 137: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 54 Weak Mutation 136: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - ReplaceConstant - " time=" -> 
   * 55 Weak Mutation 139: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - DeleteStatement: append(Ljava/lang/Object;)Ljava/lang/StringBuffer;
   * 56 Weak Mutation 138: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:116 - DeleteField: timeLjava/sql/Timestamp;
   * 57 Weak Mutation 141: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:117 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 58 Weak Mutation 140: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:117 - ReplaceConstant - "/> -> 
   * 59 Weak Mutation 129: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:114 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 60 Weak Mutation 128: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:114 - ReplaceConstant - " logVersion="0x -> 
   * 61 Weak Mutation 131: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - InsertUnaryOp +1
   * 62 Weak Mutation 130: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - InsertUnaryOp Negation
   * 63 Weak Mutation 133: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - DeleteField: logVersionI
   * 64 Weak Mutation 132: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - InsertUnaryOp -1
   * 65 Weak Mutation 135: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - DeleteStatement: append(Ljava/lang/String;)Ljava/lang/StringBuffer;
   * 66 Weak Mutation 134: com.sleepycat.je.log.FileHeader.dumpLog(Ljava/lang/StringBuffer;Z)V:115 - DeleteStatement: toHexString(I)Ljava/lang/String;
   * 67 Weak Mutation 145: com.sleepycat.je.log.FileHeader.toString()Ljava/lang/String;:136 - ReplaceConstant - 1 -> 0
   * 68 Weak Mutation 146: com.sleepycat.je.log.FileHeader.toString()Ljava/lang/String;:136 - DeleteStatement: dumpLog(Ljava/lang/StringBuffer;Z)V
   * 69 Weak Mutation 147: com.sleepycat.je.log.FileHeader.toString()Ljava/lang/String;:137 - DeleteStatement: toString()Ljava/lang/String;
   * 70 com.sleepycat.je.log.FileHeader.<init>(JJ)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      FileHeader fileHeader0 = new FileHeader((-527L), (-527L));
      assertNotNull(fileHeader0);
      
      String string0 = fileHeader0.toString();
      assertEquals("<FileHeader num=\"0xfffffffffffffdf1\" lastEntryInPrevFileOffset=\"0xfffffffffffffdf1\" logVersion=\"0x3\" time=\"2013-06-01 11:02:25.417\"/>", string0);
      assertNotNull(string0);
  }
}