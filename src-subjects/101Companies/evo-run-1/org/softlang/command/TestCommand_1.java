/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.command.Command;

@RunWith(EvoSuiteRunner.class)
public class TestCommand_1 {


  //Test case number: 1
  /*
   * 13 covered goals:
   * 1 Weak Mutation 6: org.softlang.command.Command.undo()V:13 - DeleteField: doneZ
   * 2 Weak Mutation 8: org.softlang.command.Command.undo()V:15 - ReplaceConstant - 0 -> 1
   * 3 org.softlang.command.Command.undo()V: I4 Branch 2 IFNE L13 - true
   * 4 Weak Mutation 0: org.softlang.command.Command.<init>()V:5 - ReplaceConstant - 0 -> 1
   * 5 Weak Mutation 1: org.softlang.command.Command.execute()V:8 - InsertUnaryOp Negation
   * 6 Weak Mutation 3: org.softlang.command.Command.execute()V:8 - ReplaceComparisonOperator == -> !=
   * 7 Weak Mutation 4: org.softlang.command.Command.execute()V:10 - ReplaceConstant - 1 -> 0
   * 8 Weak Mutation 5: org.softlang.command.Command.undo()V:13 - InsertUnaryOp Negation
   * 9 Weak Mutation 7: org.softlang.command.Command.undo()V:13 - ReplaceComparisonOperator != -> ==
   * 10 Weak Mutation 5: org.softlang.command.Command.undo()V:13 - InsertUnaryOp Negation
   * 11 Weak Mutation 6: org.softlang.command.Command.undo()V:13 - DeleteField: doneZ
   * 12 Weak Mutation 7: org.softlang.command.Command.undo()V:13 - ReplaceComparisonOperator != -> ==
   * 13 Weak Mutation 8: org.softlang.command.Command.undo()V:15 - ReplaceConstant - 0 -> 1
   */
  @Test
  public void test1()  throws Throwable  {
      Command command0 = new Command();
      command0.execute();
      command0.undo();
  }
}
