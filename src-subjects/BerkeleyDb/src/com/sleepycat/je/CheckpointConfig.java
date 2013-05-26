package com.sleepycat.je;
/** 
 * Javadoc for this public class is generated
 * via the doc templates in the doc_src directory.
 */
public class CheckpointConfig {
  public final static CheckpointConfig DEFAULT=new CheckpointConfig();
  private boolean force=false;
//#if CPBYTES
  private int kbytes=0;
//#endif
//#if CPTIME
  private int minutes=0;
//#endif
  private boolean minimizeRecoveryTime=false;
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public CheckpointConfig(){
  }
//#if CPBYTES
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public void setKBytes(  int kbytes){
    this.kbytes=kbytes;
  }
//#endif
//#if CPBYTES
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int getKBytes(){
    return kbytes;
  }
//#endif
//#if CPTIME
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public void setMinutes(  int minutes){
    this.minutes=minutes;
  }
//#endif
//#if CPTIME
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public int getMinutes(){
    return minutes;
  }
//#endif
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public void setForce(  boolean force){
    this.force=force;
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public boolean getForce(){
    return force;
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public void setMinimizeRecoveryTime(  boolean minimizeRecoveryTime){
    this.minimizeRecoveryTime=minimizeRecoveryTime;
  }
  /** 
 * Javadoc for this public method is generated via
 * the doc templates in the doc_src directory.
 */
  public boolean getMinimizeRecoveryTime(){
    return minimizeRecoveryTime;
  }
}
