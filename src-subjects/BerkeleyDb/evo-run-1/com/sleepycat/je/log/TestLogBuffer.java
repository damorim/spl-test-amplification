/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogBuffer;
import java.nio.ByteBuffer;
import org.evosuite.testcase.TestCaseExecutor;

@RunWith(EvoSuiteRunner.class)
public class TestLogBuffer {


  //Test case number: 0
  /*
   * 18 covered goals:
   * 1 Weak Mutation 33: com.sleepycat.je.log.LogBuffer.getDataBuffer()Ljava/nio/ByteBuffer;:100 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 2 com.sleepycat.je.log.LogBuffer.getDataBuffer()Ljava/nio/ByteBuffer;: root-Branch
   * 3 Weak Mutation 0: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - InsertUnaryOp Negation of capacity
   * 4 Weak Mutation 1: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - InsertUnaryOp IINC 1 capacity
   * 5 Weak Mutation 2: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - InsertUnaryOp IINC -1 capacity
   * 6 Weak Mutation 3: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - DeleteStatement: allocateDirect(I)Ljava/nio/ByteBuffer;
   * 7 Weak Mutation 4: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:36 - DeleteStatement: reinit()V
   * 8 Weak Mutation 7: com.sleepycat.je.log.LogBuffer.reinit()V:50 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 9 Weak Mutation 8: com.sleepycat.je.log.LogBuffer.reinit()V:50 - DeleteStatement: clear()Ljava/nio/Buffer;
   * 10 Weak Mutation 9: com.sleepycat.je.log.LogBuffer.reinit()V:51 - ReplaceConstant - -1 -> 0
   * 11 Weak Mutation 10: com.sleepycat.je.log.LogBuffer.reinit()V:51 - ReplaceConstant - -1 -> 1
   * 12 Weak Mutation 11: com.sleepycat.je.log.LogBuffer.reinit()V:51 - ReplaceConstant - -1 -> -2
   * 13 Weak Mutation 12: com.sleepycat.je.log.LogBuffer.reinit()V:52 - ReplaceConstant - -1 -> 0
   * 14 Weak Mutation 13: com.sleepycat.je.log.LogBuffer.reinit()V:52 - ReplaceConstant - -1 -> 1
   * 15 Weak Mutation 14: com.sleepycat.je.log.LogBuffer.reinit()V:52 - ReplaceConstant - -1 -> -2
   * 16 Weak Mutation 33: com.sleepycat.je.log.LogBuffer.getDataBuffer()Ljava/nio/ByteBuffer;:100 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 17 com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V: root-Branch
   * 18 com.sleepycat.je.log.LogBuffer.reinit()V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      LogBuffer logBuffer0 = new LogBuffer(0, (EnvironmentImpl) null);
      assertNotNull(logBuffer0);
      
      ByteBuffer byteBuffer0 = logBuffer0.getDataBuffer();
      assertEquals((-1L), logBuffer0.getFirstLsn());
      assertNotNull(byteBuffer0);
      assertEquals(0, logBuffer0.getCapacity());
      assertEquals(0, byteBuffer0.position());
  }

  //Test case number: 1
  /*
   * 8 covered goals:
   * 1 Weak Mutation 15: com.sleepycat.je.log.LogBuffer.getFirstLsn()J:65 - InsertUnaryOp Negation
   * 2 Weak Mutation 16: com.sleepycat.je.log.LogBuffer.getFirstLsn()J:65 - DeleteField: firstLsnJ
   * 3 com.sleepycat.je.log.LogBuffer.getFirstLsn()J: root-Branch
   * 4 Weak Mutation 5: com.sleepycat.je.log.LogBuffer.<init>(Ljava/nio/ByteBuffer;J)V:40 - InsertUnaryOp Negation of firstLsn
   * 5 Weak Mutation 6: com.sleepycat.je.log.LogBuffer.<init>(Ljava/nio/ByteBuffer;J)V:41 - InsertUnaryOp Negation of firstLsn
   * 6 Weak Mutation 15: com.sleepycat.je.log.LogBuffer.getFirstLsn()J:65 - InsertUnaryOp Negation
   * 7 Weak Mutation 16: com.sleepycat.je.log.LogBuffer.getFirstLsn()J:65 - DeleteField: firstLsnJ
   * 8 com.sleepycat.je.log.LogBuffer.<init>(Ljava/nio/ByteBuffer;J)V: root-Branch
   */
  @Test
  public void test1()  throws Throwable  {
      LogBuffer logBuffer0 = new LogBuffer((ByteBuffer) null, 2042L);
      long long0 = logBuffer0.getFirstLsn();
      assertEquals(2042L, long0);
  }

  //Test case number: 2
  /*
   * 23 covered goals:
   * 1 Weak Mutation 17: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp Negation of numBytes
   * 2 Weak Mutation 19: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC -1 numBytes
   * 3 Weak Mutation 18: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC 1 numBytes
   * 4 Weak Mutation 21: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteStatement: capacity()I
   * 5 Weak Mutation 20: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 6 Weak Mutation 23: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteStatement: position()I
   * 7 Weak Mutation 22: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 8 Weak Mutation 25: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceArithmeticOperator - -> %
   * 9 Weak Mutation 26: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceArithmeticOperator - -> /
   * 10 Weak Mutation 28: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceComparisonOperator > -> >=
   * 11 Weak Mutation 31: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceConstant - 1 -> 0
   * 12 com.sleepycat.je.log.LogBuffer.hasRoom(I)Z: I10 Branch 2 IF_ICMPGT L94 - false
   * 13 Weak Mutation 17: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp Negation of numBytes
   * 14 Weak Mutation 19: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC -1 numBytes
   * 15 Weak Mutation 18: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - InsertUnaryOp IINC 1 numBytes
   * 16 Weak Mutation 21: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteStatement: capacity()I
   * 17 Weak Mutation 20: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 18 Weak Mutation 23: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteStatement: position()I
   * 19 Weak Mutation 22: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 20 Weak Mutation 25: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceArithmeticOperator - -> %
   * 21 Weak Mutation 26: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceArithmeticOperator - -> /
   * 22 Weak Mutation 28: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceComparisonOperator > -> >=
   * 23 Weak Mutation 31: com.sleepycat.je.log.LogBuffer.hasRoom(I)Z:94 - ReplaceConstant - 1 -> 0
   */
  @Test
  public void test2()  throws Throwable  {
      LogBuffer logBuffer0 = new LogBuffer(335, (EnvironmentImpl) null);
      assertNotNull(logBuffer0);
      
      boolean boolean0 = logBuffer0.hasRoom(335);
      assertEquals(335, logBuffer0.getCapacity());
      assertEquals(true, boolean0);
      assertEquals((-1L), logBuffer0.getFirstLsn());
  }

  //Test case number: 3
  /*
   * 35 covered goals:
   * 1 Weak Mutation 36: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:118 - ReplaceConstant - 0 -> 1
   * 2 Weak Mutation 38: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: firstLsnJ
   * 3 Weak Mutation 39: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> 0
   * 4 Weak Mutation 37: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 5 Weak Mutation 42: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: longSub(JJ)I
   * 6 Weak Mutation 43: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator == -> >=
   * 7 Weak Mutation 40: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> 1
   * 8 Weak Mutation 41: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> -2
   * 9 Weak Mutation 46: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 10 Weak Mutation 47: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: firstLsnJ
   * 11 Weak Mutation 49: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: compareTo(JJ)I
   * 12 Weak Mutation 48: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation of lsn
   * 13 Weak Mutation 52: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator > -> -2
   * 14 Weak Mutation 62: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:122 - ReplaceComparisonOperator == -> !=
   * 15 Weak Mutation 61: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:122 - InsertUnaryOp Negation of found
   * 16 Weak Mutation 64: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:129 - ReplaceConstant - 0 -> 1
   * 17 com.sleepycat.je.log.LogBuffer.containsLsn(J)Z: I10 Branch 3 IFEQ L119 - false
   * 18 com.sleepycat.je.log.LogBuffer.containsLsn(J)Z: I15 Branch 4 IFGT L119 - true
   * 19 com.sleepycat.je.log.LogBuffer.containsLsn(J)Z: I28 Branch 6 IFEQ L122 - true
   * 20 Weak Mutation 38: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: firstLsnJ
   * 21 Weak Mutation 39: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> 0
   * 22 Weak Mutation 36: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:118 - ReplaceConstant - 0 -> 1
   * 23 Weak Mutation 37: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 24 Weak Mutation 42: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: longSub(JJ)I
   * 25 Weak Mutation 43: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator == -> >=
   * 26 Weak Mutation 40: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> 1
   * 27 Weak Mutation 41: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> -2
   * 28 Weak Mutation 46: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 29 Weak Mutation 47: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: firstLsnJ
   * 30 Weak Mutation 49: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: compareTo(JJ)I
   * 31 Weak Mutation 48: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation of lsn
   * 32 Weak Mutation 52: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator > -> -2
   * 33 Weak Mutation 62: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:122 - ReplaceComparisonOperator == -> !=
   * 34 Weak Mutation 61: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:122 - InsertUnaryOp Negation of found
   * 35 Weak Mutation 64: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:129 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test3()  throws Throwable  {
      LogBuffer logBuffer0 = new LogBuffer((ByteBuffer) null, 2042L);
      boolean boolean0 = logBuffer0.containsLsn(0L);
      assertEquals(false, boolean0);
      assertEquals(2042L, logBuffer0.getFirstLsn());
  }

  //Test case number: 4
  /*
   * 19 covered goals:
   * 1 Weak Mutation 44: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator == -> <=
   * 2 Weak Mutation 5: com.sleepycat.je.log.LogBuffer.<init>(Ljava/nio/ByteBuffer;J)V:40 - InsertUnaryOp Negation of firstLsn
   * 3 Weak Mutation 6: com.sleepycat.je.log.LogBuffer.<init>(Ljava/nio/ByteBuffer;J)V:41 - InsertUnaryOp Negation of firstLsn
   * 4 Weak Mutation 38: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: firstLsnJ
   * 5 Weak Mutation 39: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> 0
   * 6 Weak Mutation 36: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:118 - ReplaceConstant - 0 -> 1
   * 7 Weak Mutation 37: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 8 Weak Mutation 42: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: longSub(JJ)I
   * 9 Weak Mutation 40: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> 1
   * 10 Weak Mutation 41: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceConstant - -1 -> -2
   * 11 Weak Mutation 46: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation
   * 12 Weak Mutation 47: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteField: firstLsnJ
   * 13 Weak Mutation 49: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - DeleteStatement: compareTo(JJ)I
   * 14 Weak Mutation 48: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - InsertUnaryOp Negation of lsn
   * 15 Weak Mutation 52: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator > -> -2
   * 16 Weak Mutation 62: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:122 - ReplaceComparisonOperator == -> !=
   * 17 Weak Mutation 61: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:122 - InsertUnaryOp Negation of found
   * 18 Weak Mutation 64: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:129 - ReplaceConstant - 0 -> 1
   * 19 Weak Mutation 44: com.sleepycat.je.log.LogBuffer.containsLsn(J)Z:119 - ReplaceComparisonOperator == -> <=
   */
  @Test
  public void test4()  throws Throwable  {
      LogBuffer logBuffer0 = new LogBuffer((ByteBuffer) null, (-194L));
      boolean boolean0 = logBuffer0.containsLsn(0L);
      assertEquals((-194L), logBuffer0.getFirstLsn());
      assertEquals(false, boolean0);
  }

  //Test case number: 5
  /*
   * 39 covered goals:
   * 1 Weak Mutation 65: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:172 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 2 Weak Mutation 66: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:172 - DeleteStatement: duplicate()Ljava/nio/ByteBuffer;
   * 3 Weak Mutation 68: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - InsertUnaryOp Negation
   * 4 Weak Mutation 69: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - DeleteField: firstLsnJ
   * 5 Weak Mutation 70: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - DeleteStatement: getFileOffset(J)J
   * 6 Weak Mutation 71: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> %
   * 7 Weak Mutation 67: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - InsertUnaryOp Negation of fileOffset
   * 8 Weak Mutation 72: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> +
   * 9 Weak Mutation 73: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> /
   * 10 Weak Mutation 74: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> *
   * 11 Weak Mutation 75: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - DeleteStatement: position(I)Ljava/nio/Buffer;
   * 12 Weak Mutation 76: com.sleepycat.je.log.LogBuffer.getBytes(JI)Ljava/nio/ByteBuffer;:186 - InsertUnaryOp Negation of fileOffset
   * 13 Weak Mutation 77: com.sleepycat.je.log.LogBuffer.getBytes(JI)Ljava/nio/ByteBuffer;:186 - DeleteStatement: getBytes(J)Ljava/nio/ByteBuffer;
   * 14 Weak Mutation 0: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - InsertUnaryOp Negation of capacity
   * 15 Weak Mutation 1: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - InsertUnaryOp IINC 1 capacity
   * 16 Weak Mutation 2: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - InsertUnaryOp IINC -1 capacity
   * 17 Weak Mutation 3: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:28 - DeleteStatement: allocateDirect(I)Ljava/nio/ByteBuffer;
   * 18 Weak Mutation 4: com.sleepycat.je.log.LogBuffer.<init>(ILcom/sleepycat/je/dbi/EnvironmentImpl;)V:36 - DeleteStatement: reinit()V
   * 19 Weak Mutation 7: com.sleepycat.je.log.LogBuffer.reinit()V:50 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 20 Weak Mutation 8: com.sleepycat.je.log.LogBuffer.reinit()V:50 - DeleteStatement: clear()Ljava/nio/Buffer;
   * 21 Weak Mutation 9: com.sleepycat.je.log.LogBuffer.reinit()V:51 - ReplaceConstant - -1 -> 0
   * 22 Weak Mutation 10: com.sleepycat.je.log.LogBuffer.reinit()V:51 - ReplaceConstant - -1 -> 1
   * 23 Weak Mutation 11: com.sleepycat.je.log.LogBuffer.reinit()V:51 - ReplaceConstant - -1 -> -2
   * 24 Weak Mutation 12: com.sleepycat.je.log.LogBuffer.reinit()V:52 - ReplaceConstant - -1 -> 0
   * 25 Weak Mutation 13: com.sleepycat.je.log.LogBuffer.reinit()V:52 - ReplaceConstant - -1 -> 1
   * 26 Weak Mutation 14: com.sleepycat.je.log.LogBuffer.reinit()V:52 - ReplaceConstant - -1 -> -2
   * 27 Weak Mutation 68: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - InsertUnaryOp Negation
   * 28 Weak Mutation 69: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - DeleteField: firstLsnJ
   * 29 Weak Mutation 70: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - DeleteStatement: getFileOffset(J)J
   * 30 Weak Mutation 71: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> %
   * 31 Weak Mutation 65: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:172 - DeleteField: bufferLjava/nio/ByteBuffer;
   * 32 Weak Mutation 66: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:172 - DeleteStatement: duplicate()Ljava/nio/ByteBuffer;
   * 33 Weak Mutation 67: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - InsertUnaryOp Negation of fileOffset
   * 34 Weak Mutation 76: com.sleepycat.je.log.LogBuffer.getBytes(JI)Ljava/nio/ByteBuffer;:186 - InsertUnaryOp Negation of fileOffset
   * 35 Weak Mutation 77: com.sleepycat.je.log.LogBuffer.getBytes(JI)Ljava/nio/ByteBuffer;:186 - DeleteStatement: getBytes(J)Ljava/nio/ByteBuffer;
   * 36 Weak Mutation 72: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> +
   * 37 Weak Mutation 73: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> /
   * 38 Weak Mutation 74: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - ReplaceArithmeticOperator - -> *
   * 39 Weak Mutation 75: com.sleepycat.je.log.LogBuffer.getBytes(J)Ljava/nio/ByteBuffer;:173 - DeleteStatement: position(I)Ljava/nio/Buffer;
   */
  @Test
  public void test5()  throws Throwable  {
      int int0 = 335;
      LogBuffer logBuffer0 = new LogBuffer(335, (EnvironmentImpl) null);
      logBuffer0.getBytes((long) int0, int0);
  }
}