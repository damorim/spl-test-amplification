/*
 * This file was automatically generated by EvoSuite
 */

package de.susebox.jtopas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import de.susebox.java.lang.ExtIllegalArgumentException;
import de.susebox.java.lang.ExtUnsupportedOperationException;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.spi.DataProvider;

@RunWith(EvoSuiteRunner.class)
public class TestStandardTokenizerProperties_32 {


  //Test case number: 32
  /*
   * 20 covered goals:
   * 1 Weak Mutation 575: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:895 - ReplaceComparisonOperator <= -> <
   * 2 Weak Mutation 586: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:895 - ReplaceConstant - 0 -> 1
   * 3 Weak Mutation 610: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 0
   * 4 Weak Mutation 611: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 1
   * 5 Weak Mutation 614: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 65536
   * 6 Weak Mutation 612: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> -1
   * 7 Weak Mutation 613: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 65534
   * 8 Weak Mutation 599: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceComparisonOperator >= -> >
   * 9 de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V: I51 Branch 100 IFLE L895 - true
   * 10 de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V: I68 Branch 101 IF_ICMPGE L896 - true
   * 11 de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V: I129 Branch 104 IF_ICMPGE L914 - true
   * 12 de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V: I176 Branch 106 IFEQ L927 - false
   * 13 Weak Mutation 575: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:895 - ReplaceComparisonOperator <= -> <
   * 14 Weak Mutation 610: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 0
   * 15 Weak Mutation 611: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 1
   * 16 Weak Mutation 614: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 65536
   * 17 Weak Mutation 612: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> -1
   * 18 Weak Mutation 613: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceConstant - 65535 -> 65534
   * 19 Weak Mutation 586: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:895 - ReplaceConstant - 0 -> 1
   * 20 Weak Mutation 599: de.susebox.jtopas.StandardTokenizerProperties.putCharSet(Ljava/lang/String;IZ)V:896 - ReplaceComparisonOperator >= -> >
   */
  @Test
  public void test32()  throws Throwable  {
      StandardTokenizerProperties standardTokenizerProperties0 = null;
      try {
        standardTokenizerProperties0 = new StandardTokenizerProperties((-1), "-", "-");
        fail("Expecting exception: NullPointerException");
      } catch(NullPointerException e) {
      }
  }
}
