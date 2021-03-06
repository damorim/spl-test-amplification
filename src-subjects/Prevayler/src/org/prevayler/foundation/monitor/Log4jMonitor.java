//#if MONITOR
package org.prevayler.foundation.monitor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
/** 
 * A Monitor that logs output using Log4j. Loggers are named by fully qualified
 * class name for easy configuration and control over logging output.
 */
public class Log4jMonitor extends LoggingMonitor {
  private static final String callerFQCN=LoggingMonitor.class.getName();
  protected void info(  Class clazz,  String message){
    log(clazz,Level.INFO,message,null);
  }
  protected void error(  Class clazz,  String message,  Exception ex){
    log(clazz,Level.ERROR,message,ex);
  }
  protected boolean isInfoEnabled(  Class clazz){
    return logger(clazz).isInfoEnabled();
  }
  private Logger logger(  Class clazz){
    return Logger.getLogger(clazz);
  }
  private void log(  Class clazz,  Level level,  String message,  Exception ex){
    logger(clazz).log(callerFQCN,level,message,ex);
  }
}
//#endif
