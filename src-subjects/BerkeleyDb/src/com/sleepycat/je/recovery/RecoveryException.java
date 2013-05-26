package com.sleepycat.je.recovery;
import com.sleepycat.je.RunRecoveryException;
import com.sleepycat.je.dbi.EnvironmentImpl;
/** 
 * Recovery related exceptions
 */
public class RecoveryException extends RunRecoveryException {
  public RecoveryException(  EnvironmentImpl env,  String message,  Throwable t){
    super(env,message,t);
  }
  public RecoveryException(  EnvironmentImpl env,  String message){
    super(env,message);
  }
}
