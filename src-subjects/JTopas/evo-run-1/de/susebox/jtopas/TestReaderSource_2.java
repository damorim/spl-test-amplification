/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.jtopas.ReaderSource;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedReader;
import java.io.Reader;

@RunWith(EvoSuiteRunner.class)
public class TestReaderSource_2 {


  //Test case number: 2
  /*
   * 7 covered goals:
   * 1 Weak Mutation 3: de.susebox.jtopas.ReaderSource.<init>(Ljava/io/File;)V:120 - ReplaceComparisonOperator = null -> != null
   * 2 Weak Mutation 4: de.susebox.jtopas.ReaderSource.<init>(Ljava/io/File;)V:122 - DeleteField: _inputStreamLjava/io/InputStream;
   * 3 Weak Mutation 5: de.susebox.jtopas.ReaderSource.<init>(Ljava/io/File;)V:122 - DeleteStatement: setReader(Ljava/io/Reader;)V
   * 4 de.susebox.jtopas.ReaderSource.<init>(Ljava/io/File;)V: I17 Branch 2 IFNULL L120 - false
   * 5 Weak Mutation 3: de.susebox.jtopas.ReaderSource.<init>(Ljava/io/File;)V:120 - ReplaceComparisonOperator = null -> != null
   * 6 Weak Mutation 4: de.susebox.jtopas.ReaderSource.<init>(Ljava/io/File;)V:122 - DeleteField: _inputStreamLjava/io/InputStream;
   * 7 Weak Mutation 5: de.susebox.jtopas.ReaderSource.<init>(Ljava/io/File;)V:122 - DeleteStatement: setReader(Ljava/io/Reader;)V
   */
  @Test
  public void test2()  throws Throwable  {
      File file0 = File.createTempFile("I@y;i|I.Vmc", "I@y;i|I.Vmc");
      ReaderSource readerSource0 = new ReaderSource(file0);
      assertEquals("/private/var/folders/nq/zr797mk520g827f_9zncfn9r0000gn/T/I@y;i|I.Vmc1614289510890964410I@y;i|I.Vmc", file0.getCanonicalPath());
      assertEquals("/var/folders/nq/zr797mk520g827f_9zncfn9r0000gn/T/I@y;i|I.Vmc1614289510890964410I@y;i|I.Vmc", file0.getPath());
  }
}