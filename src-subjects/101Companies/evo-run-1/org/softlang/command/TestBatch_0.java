/*
 * This file was automatically generated by EvoSuite
 */

package org.softlang.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.evosuite.junit.EvoSuiteRunner;
import static org.junit.Assert.*;
import org.softlang.command.Batch;
import org.softlang.command.Command;

@RunWith(EvoSuiteRunner.class)
public class TestBatch_0 {


  //Test case number: 0
  /*
   * 42 covered goals:
   * 1 Weak Mutation 14: org.softlang.command.Batch.undo()V:27 - DeleteStatement: next()Ljava/lang/Object;
   * 2 Weak Mutation 15: org.softlang.command.Batch.undo()V:28 - DeleteStatement: undo()V
   * 3 org.softlang.command.Batch.undo()V: I18 Branch 2 IFEQ L27 - false
   * 4 Weak Mutation 0: org.softlang.command.Batch.add(Lorg/softlang/command/Command;)V:15 - DeleteField: commandsLjava/util/List;
   * 5 Weak Mutation 1: org.softlang.command.Batch.add(Lorg/softlang/command/Command;)V:15 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 6 Weak Mutation 2: org.softlang.command.Batch.execute()V:20 - DeleteField: commandsLjava/util/List;
   * 7 Weak Mutation 3: org.softlang.command.Batch.execute()V:20 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 8 Weak Mutation 4: org.softlang.command.Batch.execute()V:20 - DeleteStatement: hasNext()Z
   * 9 Weak Mutation 5: org.softlang.command.Batch.execute()V:20 - ReplaceComparisonOperator == -> !=
   * 10 Weak Mutation 6: org.softlang.command.Batch.execute()V:20 - DeleteStatement: next()Ljava/lang/Object;
   * 11 Weak Mutation 7: org.softlang.command.Batch.execute()V:21 - DeleteStatement: execute()V
   * 12 Weak Mutation 8: org.softlang.command.Batch.undo()V:26 - DeleteField: commandsLjava/util/List;
   * 13 Weak Mutation 9: org.softlang.command.Batch.undo()V:26 - DeleteStatement: reverse(Ljava/util/List;)V
   * 14 Weak Mutation 10: org.softlang.command.Batch.undo()V:27 - DeleteField: commandsLjava/util/List;
   * 15 Weak Mutation 11: org.softlang.command.Batch.undo()V:27 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 16 Weak Mutation 12: org.softlang.command.Batch.undo()V:27 - DeleteStatement: hasNext()Z
   * 17 Weak Mutation 13: org.softlang.command.Batch.undo()V:27 - ReplaceComparisonOperator == -> !=
   * 18 Weak Mutation 17: org.softlang.command.Batch.undo()V:29 - DeleteStatement: reverse(Ljava/util/List;)V
   * 19 Weak Mutation 16: org.softlang.command.Batch.undo()V:29 - DeleteField: commandsLjava/util/List;
   * 20 Weak Mutation 0: org.softlang.command.Batch.add(Lorg/softlang/command/Command;)V:15 - DeleteField: commandsLjava/util/List;
   * 21 Weak Mutation 1: org.softlang.command.Batch.add(Lorg/softlang/command/Command;)V:15 - DeleteStatement: add(Ljava/lang/Object;)Z
   * 22 Weak Mutation 2: org.softlang.command.Batch.execute()V:20 - DeleteField: commandsLjava/util/List;
   * 23 Weak Mutation 3: org.softlang.command.Batch.execute()V:20 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 24 Weak Mutation 4: org.softlang.command.Batch.execute()V:20 - DeleteStatement: hasNext()Z
   * 25 Weak Mutation 5: org.softlang.command.Batch.execute()V:20 - ReplaceComparisonOperator == -> !=
   * 26 Weak Mutation 6: org.softlang.command.Batch.execute()V:20 - DeleteStatement: next()Ljava/lang/Object;
   * 27 Weak Mutation 7: org.softlang.command.Batch.execute()V:21 - DeleteStatement: execute()V
   * 28 Weak Mutation 8: org.softlang.command.Batch.undo()V:26 - DeleteField: commandsLjava/util/List;
   * 29 Weak Mutation 9: org.softlang.command.Batch.undo()V:26 - DeleteStatement: reverse(Ljava/util/List;)V
   * 30 Weak Mutation 10: org.softlang.command.Batch.undo()V:27 - DeleteField: commandsLjava/util/List;
   * 31 Weak Mutation 11: org.softlang.command.Batch.undo()V:27 - DeleteStatement: iterator()Ljava/util/Iterator;
   * 32 Weak Mutation 12: org.softlang.command.Batch.undo()V:27 - DeleteStatement: hasNext()Z
   * 33 Weak Mutation 13: org.softlang.command.Batch.undo()V:27 - ReplaceComparisonOperator == -> !=
   * 34 Weak Mutation 14: org.softlang.command.Batch.undo()V:27 - DeleteStatement: next()Ljava/lang/Object;
   * 35 Weak Mutation 15: org.softlang.command.Batch.undo()V:28 - DeleteStatement: undo()V
   * 36 Weak Mutation 17: org.softlang.command.Batch.undo()V:29 - DeleteStatement: reverse(Ljava/util/List;)V
   * 37 Weak Mutation 16: org.softlang.command.Batch.undo()V:29 - DeleteField: commandsLjava/util/List;
   * 38 org.softlang.command.Batch.add(Lorg/softlang/command/Command;)V: root-Branch
   * 39 org.softlang.command.Batch.<init>()V: root-Branch
   * 40 org.softlang.command.Batch.execute()V: I13 Branch 1 IFEQ L20 - true
   * 41 org.softlang.command.Batch.execute()V: I13 Branch 1 IFEQ L20 - false
   * 42 org.softlang.command.Batch.undo()V: I18 Branch 2 IFEQ L27 - true
   */
  @Test
  public void test0()  throws Throwable  {
      Batch batch0 = new Batch();
      Command command0 = new Command();
      batch0.add(command0);
      batch0.execute();
      batch0.undo();
  }
}