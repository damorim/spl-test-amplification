//#if LATCHES
package com.sleepycat.je.latch;
import com.sleepycat.je.DatabaseException;
/** 
 * The root of latch related exceptions.
 */
public class LatchException extends DatabaseException {
  public LatchException(){
    super();
  }
  public LatchException(  String message){
    super(message);
  }
}
//#endif
