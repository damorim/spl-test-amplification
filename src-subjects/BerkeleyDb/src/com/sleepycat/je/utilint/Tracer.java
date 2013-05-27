package com.sleepycat.je.utilint;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.config.ConfigParam;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.LogReadable;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.LoggableObject;
/** 
 * The Tracer generates debug messages that are sent to the java.util.Logging
 * facility. There are three log handlers set up for logging -- the database
 * log itself, an output file, and stdout (the "console").  By default, only
 * the database file is enabled.
 */
public class Tracer
//#if LOGGINGDBLOGHANDLER
implements LoggableObject, LogReadable
//#endif
 {
  public static final String INFO_FILES="je.info";
//#if LOGGINGBASE
  private Timestamp time;
//#endif
//#if LOGGINGBASE
  private String msg;
//#endif
//#if LOGGINGBASE
  /** 
 * Create a new debug record.
 */
  public Tracer(  String msg){
    this.time=getCurrentTimestamp();
    this.msg=msg;
  }
//#endif
//#if LOGGINGBASE
  /** 
 * Create trace record that will be filled in from the log.
 */
  public Tracer(){
  }
//#endif
  /** 
 * Logger method for recording a general message.
 */
  public static void trace(  Level logLevel,  EnvironmentImpl envImpl,  String msg){
//#if LOGGINGBASE
    envImpl.getLogger().log(logLevel,msg);
//#endif
  }
//#if LOGGINGSEVERE
  /** 
 * Logger method for recording an exception and stacktrace.
 */
  public static void trace(  EnvironmentImpl envImpl,  String sourceClass,  String sourceMethod,  String msg,  Throwable t){
//#if LOGGINGBASE
    envImpl.getLogger().logp(Level.SEVERE,sourceClass,sourceMethod,msg + "\n" + Tracer.getStackTrace(t));
//#endif
  }
//#endif
  /** 
 * Parse a logging level config parameter, and return a more explanatory
 * error message if it doesn't parse.
 */
  public static Level parseLevel(  EnvironmentImpl envImpl,  ConfigParam configParam) throws DatabaseException {
    Level level=null;
    try {
      String levelVal=envImpl.getConfigManager().get(configParam);
      level=Level.parse(levelVal);
    }
 catch (    IllegalArgumentException e) {
      throw new DatabaseException("Problem parsing parameter " + configParam.getName() + ": "+ e.getMessage(),e);
    }
    return level;
  }
//#if LOGGINGBASE
  public String getMessage(){
    return msg;
  }
//#endif
//#if LOGGINGBASE
  /** 
 * @return a timestamp for "now"
 */
  private Timestamp getCurrentTimestamp(){
    Calendar cal=Calendar.getInstance();
    return new Timestamp(cal.getTime().getTime());
  }
//#endif
  /** 
 * @return the stacktrace for an exception
 */
  public static String getStackTrace(  Throwable t){
    StringWriter s=new StringWriter();
    t.printStackTrace(new PrintWriter(s));
    String stackTrace=s.toString();
    stackTrace=stackTrace.replaceAll("<","&lt;");
    stackTrace=stackTrace.replaceAll(">","&gt;");
    return stackTrace;
  }
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LoggableObject#getLogType
 */
  public LogEntryType getLogType(){
    return LogEntryType.LOG_TRACE;
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LoggableObject#marshallOutsideWriteLatchCan be marshalled outside the log write latch.
 */
  public boolean marshallOutsideWriteLatch(){
    return true;
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LoggableObject#countAsObsoleteWhenLogged
 */
  public boolean countAsObsoleteWhenLogged(){
    return false;
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LoggableObject#postLogWork
 */
  public void postLogWork(  long justLoggedLsn){
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LoggableObject#getLogSize()
 */
  public int getLogSize(){
    return (LogUtils.getTimestampLogSize() + LogUtils.getStringLogSize(msg));
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LoggableObject#writeToLog
 */
  public void writeToLog(  ByteBuffer logBuffer){
    LogUtils.writeTimestamp(logBuffer,time);
    LogUtils.writeString(logBuffer,msg);
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LogReadable#readFromLog
 */
  public void readFromLog(  ByteBuffer itemBuffer,  byte entryTypeVersion){
    time=LogUtils.readTimestamp(itemBuffer);
    msg=LogUtils.readString(itemBuffer);
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LogReadable#dumpLog
 */
  public void dumpLog(  StringBuffer sb,  boolean verbose){
    sb.append("<Dbg time=\"");
    sb.append(time);
    sb.append("\">");
    sb.append("<msg val=\"");
    sb.append(msg);
    sb.append("\"/>");
    sb.append("</Dbg>");
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LogReadable#logEntryIsTransactional
 */
  public boolean logEntryIsTransactional(){
    return false;
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * @see LogReadable#getTransactionId
 */
  public long getTransactionId(){
    return 0;
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  public String toString(){
    return (time + "/" + msg);
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * Just in case it's ever used as a hash key.
 */
  public int hashCode(){
    return toString().hashCode();
  }
//#endif
//#if LOGGINGDBLOGHANDLER
  /** 
 * Override Object.equals
 */
  public boolean equals(  Object obj){
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Tracer)) {
      return false;
    }
    return (toString().equals(obj.toString()));
  }
//#endif
}
