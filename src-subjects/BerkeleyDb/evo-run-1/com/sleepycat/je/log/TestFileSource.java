/*
 * This file was automatically generated by EvoSuite
 */

package com.sleepycat.je.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.log.FileSource;
import java.io.IOException;
import java.io.RandomAccessFile;

@RunWith(EvoSuiteRunner.class)
public class TestFileSource {


  //Test case number: 0
  /*
   * 16 covered goals:
   * 1 Weak Mutation 19: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - InsertUnaryOp IINC 1 numBytes
   * 2 Weak Mutation 18: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - InsertUnaryOp Negation of numBytes
   * 3 Weak Mutation 21: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - DeleteStatement: allocate(I)Ljava/nio/ByteBuffer;
   * 4 Weak Mutation 20: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - InsertUnaryOp IINC -1 numBytes
   * 5 Weak Mutation 25: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:40 - DeleteStatement: readFromFile(Ljava/io/RandomAccessFile;Ljava/nio/ByteBuffer;J)V
   * 6 Weak Mutation 24: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:40 - InsertUnaryOp Negation of fileOffset
   * 7 Weak Mutation 0: com.sleepycat.je.log.FileSource.<init>(Ljava/io/RandomAccessFile;ILcom/sleepycat/je/log/FileManager;)V:17 - InsertUnaryOp Negation of readBufferSize
   * 8 Weak Mutation 1: com.sleepycat.je.log.FileSource.<init>(Ljava/io/RandomAccessFile;ILcom/sleepycat/je/log/FileManager;)V:17 - InsertUnaryOp IINC 1 readBufferSize
   * 9 Weak Mutation 2: com.sleepycat.je.log.FileSource.<init>(Ljava/io/RandomAccessFile;ILcom/sleepycat/je/log/FileManager;)V:17 - InsertUnaryOp IINC -1 readBufferSize
   * 10 Weak Mutation 19: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - InsertUnaryOp IINC 1 numBytes
   * 11 Weak Mutation 18: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - InsertUnaryOp Negation of numBytes
   * 12 Weak Mutation 21: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - DeleteStatement: allocate(I)Ljava/nio/ByteBuffer;
   * 13 Weak Mutation 20: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:39 - InsertUnaryOp IINC -1 numBytes
   * 14 Weak Mutation 25: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:40 - DeleteStatement: readFromFile(Ljava/io/RandomAccessFile;Ljava/nio/ByteBuffer;J)V
   * 15 Weak Mutation 24: com.sleepycat.je.log.FileSource.getBytes(JI)Ljava/nio/ByteBuffer;:40 - InsertUnaryOp Negation of fileOffset
   * 16 com.sleepycat.je.log.FileSource.<init>(Ljava/io/RandomAccessFile;ILcom/sleepycat/je/log/FileManager;)V: root-Branch
   */
  @Test
  public void test0()  throws Throwable  {
      FileSource fileSource0 = new FileSource((RandomAccessFile) null, 30, (FileManager) null);
      // Undeclared exception!
      try {
        fileSource0.getBytes((long) 30, 30);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 1
  /*
   * 14 covered goals:
   * 1 Weak Mutation 3: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - InsertUnaryOp Negation
   * 2 Weak Mutation 4: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - InsertUnaryOp +1
   * 3 Weak Mutation 5: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - InsertUnaryOp -1
   * 4 Weak Mutation 6: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - DeleteField: readBufferSizeI
   * 5 Weak Mutation 7: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - DeleteStatement: allocate(I)Ljava/nio/ByteBuffer;
   * 6 Weak Mutation 10: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:30 - InsertUnaryOp Negation of fileOffset
   * 7 Weak Mutation 11: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:30 - DeleteStatement: readFromFile(Ljava/io/RandomAccessFile;Ljava/nio/ByteBuffer;J)V
   * 8 Weak Mutation 3: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - InsertUnaryOp Negation
   * 9 Weak Mutation 4: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - InsertUnaryOp +1
   * 10 Weak Mutation 5: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - InsertUnaryOp -1
   * 11 Weak Mutation 6: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - DeleteField: readBufferSizeI
   * 12 Weak Mutation 7: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:29 - DeleteStatement: allocate(I)Ljava/nio/ByteBuffer;
   * 13 Weak Mutation 10: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:30 - InsertUnaryOp Negation of fileOffset
   * 14 Weak Mutation 11: com.sleepycat.je.log.FileSource.getBytes(J)Ljava/nio/ByteBuffer;:30 - DeleteStatement: readFromFile(Ljava/io/RandomAccessFile;Ljava/nio/ByteBuffer;J)V
   */
  @Test
  public void test1()  throws Throwable  {
      FileSource fileSource0 = new FileSource((RandomAccessFile) null, 448, (FileManager) null);
      // Undeclared exception!
      try {
        fileSource0.getBytes((long) 448);
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }

  //Test case number: 2
  /*
   * 4 covered goals:
   * 1 com.sleepycat.je.log.FileSource.release()V: root-Branch
   * 2 Weak Mutation 0: com.sleepycat.je.log.FileSource.<init>(Ljava/io/RandomAccessFile;ILcom/sleepycat/je/log/FileManager;)V:17 - InsertUnaryOp Negation of readBufferSize
   * 3 Weak Mutation 1: com.sleepycat.je.log.FileSource.<init>(Ljava/io/RandomAccessFile;ILcom/sleepycat/je/log/FileManager;)V:17 - InsertUnaryOp IINC 1 readBufferSize
   * 4 Weak Mutation 2: com.sleepycat.je.log.FileSource.<init>(Ljava/io/RandomAccessFile;ILcom/sleepycat/je/log/FileManager;)V:17 - InsertUnaryOp IINC -1 readBufferSize
   */
  @Test
  public void test2()  throws Throwable  {
      FileSource fileSource0 = new FileSource((RandomAccessFile) null, 448, (FileManager) null);
      fileSource0.release();
  }
}
