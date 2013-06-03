package com.sleepycat.je.dbi;
import java.util.Iterator;
import com.sleepycat.je.DatabaseException;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.DBIN;
import com.sleepycat.je.tree.DIN;
import com.sleepycat.je.tree.IN;
/** 
 * MemoryBudget calculates the available memory for JE and how to apportion
 * it between cache and log buffers. It is meant to centralize all memory 
 * calculations. Objects that ask for memory budgets should get settings from
 * this class, rather than using the configuration parameter values directly.
 */
public class MemoryBudget implements EnvConfigObserver {
//#if MEMORYBUDGET
  private final static int LONG_OVERHEAD_32=16;
//#endif
//#if MEMORYBUDGET
  private final static int LONG_OVERHEAD_64=24;
//#endif
//#if MEMORYBUDGET
  private final static int BYTE_ARRAY_OVERHEAD_32=16;
//#endif
//#if MEMORYBUDGET
  private final static int BYTE_ARRAY_OVERHEAD_64=24;
//#endif
//#if MEMORYBUDGET
  private final static int OBJECT_OVERHEAD_32=8;
//#endif
//#if MEMORYBUDGET
  private final static int OBJECT_OVERHEAD_64=16;
//#endif
//#if MEMORYBUDGET
  private final static int ARRAY_ITEM_OVERHEAD_32=4;
//#endif
//#if MEMORYBUDGET
  private final static int ARRAY_ITEM_OVERHEAD_64=8;
//#endif
//#if MEMORYBUDGET
  private final static int HASHMAP_OVERHEAD_32=120;
//#endif
//#if MEMORYBUDGET
  private final static int HASHMAP_OVERHEAD_64=216;
//#endif
//#if MEMORYBUDGET
  private final static int HASHMAP_ENTRY_OVERHEAD_32=24;
//#endif
//#if MEMORYBUDGET
  private final static int HASHMAP_ENTRY_OVERHEAD_64=48;
//#endif
//#if MEMORYBUDGET
  private final static int HASHSET_OVERHEAD_32=136;
//#endif
//#if MEMORYBUDGET
  private final static int HASHSET_OVERHEAD_64=240;
//#endif
//#if MEMORYBUDGET
  private final static int HASHSET_ENTRY_OVERHEAD_32=24;
//#endif
//#if MEMORYBUDGET
  private final static int HASHSET_ENTRY_OVERHEAD_64=48;
//#endif
//#if MEMORYBUDGET
  private final static int TWOHASHMAPS_OVERHEAD_32=240;
//#endif
//#if MEMORYBUDGET
  private final static int TWOHASHMAPS_OVERHEAD_64=432;
//#endif
//#if MEMORYBUDGET
  private final static int TREEMAP_OVERHEAD_32=40;
//#endif
//#if MEMORYBUDGET
  private final static int TREEMAP_OVERHEAD_64=64;
//#endif
//#if MEMORYBUDGET
  private final static int TREEMAP_ENTRY_OVERHEAD_32=32;
//#endif
//#if MEMORYBUDGET
  private final static int TREEMAP_ENTRY_OVERHEAD_64=53;
//#endif
//#if MEMORYBUDGET
  private final static int LN_OVERHEAD_32=24;
//#endif
//#if MEMORYBUDGET
  private final static int LN_OVERHEAD_64=32;
//#endif
//#if MEMORYBUDGET
  private final static int DUPCOUNTLN_OVERHEAD_32=24;
//#endif
//#if MEMORYBUDGET
  private final static int DUPCOUNTLN_OVERHEAD_64=40;
//#endif
//#if MEMORYBUDGET
  private final static int BIN_FIXED_OVERHEAD_32_14=344;
//#endif
//#if MEMORYBUDGET
  private final static int BIN_FIXED_OVERHEAD_32_15=360;
//#endif
//#if MEMORYBUDGET
  private final static int BIN_FIXED_OVERHEAD_64_15=528;
//#endif
//#if MEMORYBUDGET
  private final static int DIN_FIXED_OVERHEAD_32_14=352;
//#endif
//#if MEMORYBUDGET
  private final static int DIN_FIXED_OVERHEAD_32_15=360;
//#endif
//#if MEMORYBUDGET
  private final static int DIN_FIXED_OVERHEAD_64_15=536;
//#endif
//#if MEMORYBUDGET
  private final static int DBIN_FIXED_OVERHEAD_32_14=352;
//#endif
//#if MEMORYBUDGET
  private final static int DBIN_FIXED_OVERHEAD_32_15=368;
//#endif
//#if MEMORYBUDGET
  private final static int DBIN_FIXED_OVERHEAD_64_15=544;
//#endif
//#if MEMORYBUDGET
  private final static int IN_FIXED_OVERHEAD_32_14=312;
//#endif
//#if MEMORYBUDGET
  private final static int IN_FIXED_OVERHEAD_32_15=320;
//#endif
//#if MEMORYBUDGET
  private final static int IN_FIXED_OVERHEAD_64_15=472;
//#endif
//#if MEMORYBUDGET
  private final static int KEY_OVERHEAD_32=16;
//#endif
//#if MEMORYBUDGET
  private final static int KEY_OVERHEAD_64=24;
//#endif
//#if MEMORYBUDGET
  private final static int LOCK_OVERHEAD_32=32;
//#endif
//#if MEMORYBUDGET
  private final static int LOCK_OVERHEAD_64=56;
//#endif
//#if MEMORYBUDGET
  private final static int LOCKINFO_OVERHEAD_32=16;
//#endif
//#if MEMORYBUDGET
  private final static int LOCKINFO_OVERHEAD_64=32;
//#endif
//#if MEMORYBUDGET
  private final static int TXN_OVERHEAD_32_14=167;
//#endif
//#if MEMORYBUDGET
  private final static int TXN_OVERHEAD_32_15=175;
//#endif
//#if MEMORYBUDGET
  private final static int TXN_OVERHEAD_64_15=293;
//#endif
//#if MEMORYBUDGET
  private final static int CHECKPOINT_REFERENCE_SIZE_32_14=32 + HASHSET_ENTRY_OVERHEAD_32;
//#endif
//#if MEMORYBUDGET
  private final static int CHECKPOINT_REFERENCE_SIZE_32_15=40 + HASHSET_ENTRY_OVERHEAD_32;
//#endif
//#if MEMORYBUDGET
  private final static int CHECKPOINT_REFERENCE_SIZE_64_15=56 + HASHSET_ENTRY_OVERHEAD_64;
//#endif
//#if MEMORYBUDGET
  private final static int UTILIZATION_PROFILE_ENTRY_32=88;
//#endif
//#if MEMORYBUDGET
  private final static int UTILIZATION_PROFILE_ENTRY_64=136;
//#endif
//#if MEMORYBUDGET
  private final static int TFS_LIST_INITIAL_OVERHEAD_32=464;
//#endif
//#if MEMORYBUDGET
  private final static int TFS_LIST_INITIAL_OVERHEAD_64=504;
//#endif
//#if MEMORYBUDGET
  private final static int TFS_LIST_SEGMENT_OVERHEAD_32=440;
//#endif
//#if MEMORYBUDGET
  private final static int TFS_LIST_SEGMENT_OVERHEAD_64=464;
//#endif
//#if MEMORYBUDGET
  private final static int LN_INFO_OVERHEAD_32=24;
//#endif
//#if MEMORYBUDGET
  private final static int LN_INFO_OVERHEAD_64=48;
//#endif
//#if MEMORYBUDGET
  private final static int LONG_LIST_PER_ITEM_OVERHEAD_32=20;
//#endif
//#if MEMORYBUDGET
  private final static int LONG_LIST_PER_ITEM_OVERHEAD_64=32;
//#endif
//#if MEMORYBUDGET
  public final static int LONG_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int BYTE_ARRAY_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int OBJECT_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int ARRAY_ITEM_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int HASHMAP_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int HASHMAP_ENTRY_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int HASHSET_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int HASHSET_ENTRY_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int TWOHASHMAPS_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int TREEMAP_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int TREEMAP_ENTRY_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int LN_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int DUPCOUNTLN_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int BIN_FIXED_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int DIN_FIXED_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int DBIN_FIXED_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int IN_FIXED_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int KEY_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int LOCK_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int LOCKINFO_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int TXN_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int CHECKPOINT_REFERENCE_SIZE;
//#endif
//#if MEMORYBUDGET
  public final static int UTILIZATION_PROFILE_ENTRY;
//#endif
//#if MEMORYBUDGET
  public final static int TFS_LIST_INITIAL_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int TFS_LIST_SEGMENT_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int LN_INFO_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  public final static int LONG_LIST_PER_ITEM_OVERHEAD;
//#endif
//#if MEMORYBUDGET
  private final static String JVM_ARCH_PROPERTY="sun.arch.data.model";
//#endif
//#if MEMORYBUDGET
  private final static String FORCE_JVM_ARCH="je.forceJVMArch";
//#endif
//#if MEMORYBUDGET
static {
    boolean is64=false;
    boolean isJVM14
//#if LATCHES
=(LatchSupport.getJava5LatchClass() == null)
//#endif
;
    String overrideArch=System.getProperty(FORCE_JVM_ARCH);
    try {
      if (overrideArch == null) {
        String arch=System.getProperty(JVM_ARCH_PROPERTY);
        if (arch != null) {
          is64=Integer.parseInt(arch) == 64;
        }
      }
 else {
        is64=Integer.parseInt(overrideArch) == 64;
      }
    }
 catch (    NumberFormatException NFE) {
      NFE.printStackTrace(System.err);
    }
    if (is64) {
      if (isJVM14) {
        RuntimeException RE=new RuntimeException("1.4 based 64 bit JVM not supported");
        RE.printStackTrace(System.err);
        throw RE;
      }
      LONG_OVERHEAD=LONG_OVERHEAD_64;
      BYTE_ARRAY_OVERHEAD=BYTE_ARRAY_OVERHEAD_64;
      OBJECT_OVERHEAD=OBJECT_OVERHEAD_64;
      ARRAY_ITEM_OVERHEAD=ARRAY_ITEM_OVERHEAD_64;
      HASHMAP_OVERHEAD=HASHMAP_OVERHEAD_64;
      HASHMAP_ENTRY_OVERHEAD=HASHMAP_ENTRY_OVERHEAD_64;
      HASHSET_OVERHEAD=HASHSET_OVERHEAD_64;
      HASHSET_ENTRY_OVERHEAD=HASHSET_ENTRY_OVERHEAD_64;
      TWOHASHMAPS_OVERHEAD=TWOHASHMAPS_OVERHEAD_64;
      TREEMAP_OVERHEAD=TREEMAP_OVERHEAD_64;
      TREEMAP_ENTRY_OVERHEAD=TREEMAP_ENTRY_OVERHEAD_64;
      LN_OVERHEAD=LN_OVERHEAD_64;
      DUPCOUNTLN_OVERHEAD=DUPCOUNTLN_OVERHEAD_64;
      BIN_FIXED_OVERHEAD=BIN_FIXED_OVERHEAD_64_15;
      DIN_FIXED_OVERHEAD=DIN_FIXED_OVERHEAD_64_15;
      DBIN_FIXED_OVERHEAD=DBIN_FIXED_OVERHEAD_64_15;
      IN_FIXED_OVERHEAD=IN_FIXED_OVERHEAD_64_15;
      TXN_OVERHEAD=TXN_OVERHEAD_64_15;
      CHECKPOINT_REFERENCE_SIZE=CHECKPOINT_REFERENCE_SIZE_64_15;
      KEY_OVERHEAD=KEY_OVERHEAD_64;
      LOCK_OVERHEAD=LOCK_OVERHEAD_64;
      LOCKINFO_OVERHEAD=LOCKINFO_OVERHEAD_64;
      UTILIZATION_PROFILE_ENTRY=UTILIZATION_PROFILE_ENTRY_64;
      TFS_LIST_INITIAL_OVERHEAD=TFS_LIST_INITIAL_OVERHEAD_64;
      TFS_LIST_SEGMENT_OVERHEAD=TFS_LIST_SEGMENT_OVERHEAD_64;
      LN_INFO_OVERHEAD=LN_INFO_OVERHEAD_64;
      LONG_LIST_PER_ITEM_OVERHEAD=LONG_LIST_PER_ITEM_OVERHEAD_64;
    }
 else {
      LONG_OVERHEAD=LONG_OVERHEAD_32;
      BYTE_ARRAY_OVERHEAD=BYTE_ARRAY_OVERHEAD_32;
      OBJECT_OVERHEAD=OBJECT_OVERHEAD_32;
      ARRAY_ITEM_OVERHEAD=ARRAY_ITEM_OVERHEAD_32;
      HASHMAP_OVERHEAD=HASHMAP_OVERHEAD_32;
      HASHMAP_ENTRY_OVERHEAD=HASHMAP_ENTRY_OVERHEAD_32;
      HASHSET_OVERHEAD=HASHSET_OVERHEAD_32;
      HASHSET_ENTRY_OVERHEAD=HASHSET_ENTRY_OVERHEAD_32;
      TWOHASHMAPS_OVERHEAD=TWOHASHMAPS_OVERHEAD_32;
      TREEMAP_OVERHEAD=TREEMAP_OVERHEAD_32;
      TREEMAP_ENTRY_OVERHEAD=TREEMAP_ENTRY_OVERHEAD_32;
      LN_OVERHEAD=LN_OVERHEAD_32;
      DUPCOUNTLN_OVERHEAD=DUPCOUNTLN_OVERHEAD_32;
      if (isJVM14) {
        BIN_FIXED_OVERHEAD=BIN_FIXED_OVERHEAD_32_14;
        DIN_FIXED_OVERHEAD=DIN_FIXED_OVERHEAD_32_14;
        DBIN_FIXED_OVERHEAD=DBIN_FIXED_OVERHEAD_32_14;
        IN_FIXED_OVERHEAD=IN_FIXED_OVERHEAD_32_14;
        TXN_OVERHEAD=TXN_OVERHEAD_32_14;
        CHECKPOINT_REFERENCE_SIZE=CHECKPOINT_REFERENCE_SIZE_32_14;
      }
 else {
        BIN_FIXED_OVERHEAD=BIN_FIXED_OVERHEAD_32_15;
        DIN_FIXED_OVERHEAD=DIN_FIXED_OVERHEAD_32_15;
        DBIN_FIXED_OVERHEAD=DBIN_FIXED_OVERHEAD_32_15;
        IN_FIXED_OVERHEAD=IN_FIXED_OVERHEAD_32_15;
        TXN_OVERHEAD=TXN_OVERHEAD_32_15;
        CHECKPOINT_REFERENCE_SIZE=CHECKPOINT_REFERENCE_SIZE_32_15;
      }
      KEY_OVERHEAD=KEY_OVERHEAD_32;
      LOCK_OVERHEAD=LOCK_OVERHEAD_32;
      LOCKINFO_OVERHEAD=LOCKINFO_OVERHEAD_32;
      UTILIZATION_PROFILE_ENTRY=UTILIZATION_PROFILE_ENTRY_32;
      TFS_LIST_INITIAL_OVERHEAD=TFS_LIST_INITIAL_OVERHEAD_32;
      TFS_LIST_SEGMENT_OVERHEAD=TFS_LIST_SEGMENT_OVERHEAD_32;
      LN_INFO_OVERHEAD=LN_INFO_OVERHEAD_32;
      LONG_LIST_PER_ITEM_OVERHEAD=LONG_LIST_PER_ITEM_OVERHEAD_32;
    }
  }
//#endif
  public final static long MIN_MAX_MEMORY_SIZE=96 * 1024;
  public final static String MIN_MAX_MEMORY_SIZE_STRING=Long.toString(MIN_MAX_MEMORY_SIZE);
  private final static long N_64MB=(1 << 26);
//#if MEMORYBUDGET
  private long treeMemoryUsage;
//#endif
//#if MEMORYBUDGET
  private long miscMemoryUsage;
//#endif
//#if MEMORYBUDGET
  private Object memoryUsageSynchronizer=new Object();
//#endif
//#if MEMORYBUDGET
  private int nLockTables;
//#endif
//#if MEMORYBUDGET
  private long[] lockMemoryUsage;
//#endif
  private long maxMemory;
//#if EVICTOR
//#if MEMORYBUDGET
  private long criticalThreshold;
//#endif
//#endif
  private long logBufferBudget;
//#if MEMORYBUDGET
  private long trackerBudget;
//#endif
//#if MEMORYBUDGET
  private long cacheBudget;
//#endif
//#if MEMORYBUDGET
  private long inOverhead;
//#endif
//#if MEMORYBUDGET
  private long binOverhead;
//#endif
//#if MEMORYBUDGET
  private long dinOverhead;
//#endif
//#if MEMORYBUDGET
  private long dbinOverhead;
//#endif
  private EnvironmentImpl envImpl;
  MemoryBudget(  EnvironmentImpl envImpl,  DbConfigManager configManager) throws DatabaseException {
    this.envImpl=envImpl;
    envImpl.addConfigObserver(this);
    reset(configManager);
//#if MEMORYBUDGET
    inOverhead=IN.computeOverhead(configManager);
//#endif
//#if MEMORYBUDGET
    binOverhead=BIN.computeOverhead(configManager);
//#endif
//#if MEMORYBUDGET
    dinOverhead=DIN.computeOverhead(configManager);
//#endif
//#if MEMORYBUDGET
    dbinOverhead=DBIN.computeOverhead(configManager);
//#endif
  }
  /** 
 * Respond to config updates.
 */
  public void envConfigUpdate(  DbConfigManager configManager) throws DatabaseException {
    long oldLogBufferBudget=logBufferBudget;
    reset(configManager);
    if (oldLogBufferBudget != logBufferBudget) {
      envImpl.getLogManager().resetPool(configManager);
    }
  }
  /** 
 * Initialize at construction time and when the cache is resized.
 */
  private void reset(  DbConfigManager configManager) throws DatabaseException {
    long newMaxMemory=configManager.getLong(EnvironmentParams.MAX_MEMORY);
    long jvmMemory=getRuntimeMaxMemory();
    if (newMaxMemory != 0) {
      if (jvmMemory < newMaxMemory) {
        throw new IllegalArgumentException(EnvironmentParams.MAX_MEMORY.getName() + " has a value of " + newMaxMemory+ " but the JVM is only configured for "+ jvmMemory+ ". Consider using je.maxMemoryPercent.");
      }
      if (newMaxMemory < MIN_MAX_MEMORY_SIZE) {
        throw new IllegalArgumentException(EnvironmentParams.MAX_MEMORY.getName() + " is " + newMaxMemory+ " which is less than the minimum: "+ MIN_MAX_MEMORY_SIZE);
      }
    }
 else {
      if (jvmMemory == Long.MAX_VALUE) {
        jvmMemory=N_64MB;
      }
      int maxMemoryPercent=configManager.getInt(EnvironmentParams.MAX_MEMORY_PERCENT);
      newMaxMemory=(maxMemoryPercent * jvmMemory) / 100;
    }
    long newLogBufferBudget=configManager.getLong(EnvironmentParams.LOG_MEM_SIZE);
    if (newLogBufferBudget == 0) {
      newLogBufferBudget=newMaxMemory >> 4;
    }
 else     if (newLogBufferBudget > newMaxMemory / 2) {
      newLogBufferBudget=newMaxMemory / 2;
    }
    int numBuffers=configManager.getInt(EnvironmentParams.NUM_LOG_BUFFERS);
    long startingBufferSize=newLogBufferBudget / numBuffers;
    int logBufferSize=configManager.getInt(EnvironmentParams.LOG_BUFFER_MAX_SIZE);
    if (startingBufferSize > logBufferSize) {
      startingBufferSize=logBufferSize;
      newLogBufferBudget=numBuffers * startingBufferSize;
    }
 else     if (startingBufferSize < EnvironmentParams.MIN_LOG_BUFFER_SIZE) {
      startingBufferSize=EnvironmentParams.MIN_LOG_BUFFER_SIZE;
      newLogBufferBudget=numBuffers * startingBufferSize;
    }
//#if EVICTOR
    long newCriticalThreshold=(newMaxMemory * envImpl.getConfigManager().getInt(EnvironmentParams.EVICTOR_CRITICAL_PERCENTAGE)) / 100;
//#endif
//#if CLEANER
    long newTrackerBudget=(newMaxMemory * envImpl.getConfigManager().getInt(EnvironmentParams.CLEANER_DETAIL_MAX_MEMORY_PERCENTAGE)) / 100;
//#endif
    maxMemory=newMaxMemory;
//#if EVICTOR
//#if MEMORYBUDGET
    criticalThreshold=newCriticalThreshold;
//#endif
//#endif
    logBufferBudget=newLogBufferBudget;
//#if MEMORYBUDGET
    trackerBudget
//#if CLEANER
= true ? newTrackerBudget : newMaxMemory
//#endif
;
//#endif
//#if MEMORYBUDGET
    cacheBudget=newMaxMemory - newLogBufferBudget;
//#endif
//#if MEMORYBUDGET
    nLockTables=configManager.getInt(EnvironmentParams.N_LOCK_TABLES);
//#endif
//#if MEMORYBUDGET
    lockMemoryUsage=new long[nLockTables];
//#endif
  }
  /** 
 * Returns Runtime.maxMemory(), accounting for a MacOS bug.
 * May return Long.MAX_VALUE if there is no inherent limit.
 * Used by unit tests as well as by this class.
 */
  public static long getRuntimeMaxMemory(){
    if ("Mac OS X".equals(System.getProperty("os.name"))) {
      String jvmVersion=System.getProperty("java.version");
      if (jvmVersion != null && jvmVersion.startsWith("1.4.2")) {
        return Long.MAX_VALUE;
      }
    }
    return Runtime.getRuntime().maxMemory();
  }
//#if MEMORYBUDGET
  /** 
 * Initialize the starting environment memory state 
 */
  void initCacheMemoryUsage() throws DatabaseException {
synchronized (memoryUsageSynchronizer) {
      treeMemoryUsage=calcTreeCacheUsage();
    }
//#if LATCHES
    assert LatchSupport.countLatchesHeld() == 0;
//#endif
  }
//#endif
//#if MEMORYBUDGET
  /** 
 * Public for testing.
 */
  public long calcTreeCacheUsage() throws DatabaseException {
    long totalSize=0;
    INList inList=envImpl.getInMemoryINs();
//#if LATCHES
    inList.latchMajor();
//#endif
//#if LATCHES
    try {
      Iterator iter=inList.iterator();
      while (iter.hasNext()) {
        IN in=(IN)iter.next();
        long size=in.getInMemorySize();
        totalSize+=size;
      }
    }
  finally {
      inList.releaseMajorLatch();
    }
//#endif
    return totalSize;
  }
//#endif
//#if MEMORYBUDGET
  /** 
 * Update the environment wide tree memory count, wake up the evictor if
 * necessary.
 * @param increment note that increment may be negative.
 */
  public void updateTreeMemoryUsage(  long increment){
synchronized (memoryUsageSynchronizer) {
      treeMemoryUsage+=increment;
    }
//#if EVICTOR
    if (getCacheMemoryUsage() > cacheBudget) 
//#if EVICTOR
{
      envImpl.alertEvictor();
    }
//#endif
//#endif
  }
//#endif
//#if MEMORYBUDGET
  /** 
 * Update the environment wide misc memory count, wake up the evictor if
 * necessary.
 * @param increment note that increment may be negative.
 */
  public void updateMiscMemoryUsage(  long increment){
synchronized (memoryUsageSynchronizer) {
      miscMemoryUsage+=increment;
    }
//#if EVICTOR
    if (getCacheMemoryUsage() > cacheBudget) 
//#if EVICTOR
{
      envImpl.alertEvictor();
    }
//#endif
//#endif
  }
//#endif
//#if MEMORYBUDGET
  public void updateLockMemoryUsage(  long increment,  int lockTableIndex){
    lockMemoryUsage[lockTableIndex]+=increment;
//#if EVICTOR
    if (getCacheMemoryUsage() > cacheBudget) 
//#if EVICTOR
{
      envImpl.alertEvictor();
    }
//#endif
//#endif
  }
//#endif
//#if MEMORYBUDGET
  public long accumulateNewUsage(  IN in,  long newSize){
    return in.getInMemorySize() + newSize;
  }
//#endif
//#if MEMORYBUDGET
  public void refreshTreeMemoryUsage(  long newSize){
synchronized (memoryUsageSynchronizer) {
      treeMemoryUsage=newSize;
    }
  }
//#endif
//#if MEMORYBUDGET
  public long getCacheMemoryUsage(){
    long accLockMemoryUsage=0;
    if (nLockTables == 1) {
      accLockMemoryUsage=lockMemoryUsage[0];
    }
 else {
      for (int i=0; i < nLockTables; i++) {
        accLockMemoryUsage+=lockMemoryUsage[i];
      }
    }
    return treeMemoryUsage + miscMemoryUsage + accLockMemoryUsage;
  }
//#endif
//#if MEMORYBUDGET
  /** 
 * Used for unit testing.
 */
  public long getTreeMemoryUsage(){
    return treeMemoryUsage;
  }
//#endif
  public long getLogBufferBudget(){
    return logBufferBudget;
  }
//#if MEMORYBUDGET
  public long getTrackerBudget(){
    return trackerBudget;
  }
//#endif
  public long getMaxMemory(){
    return maxMemory;
  }
//#if EVICTOR
//#if MEMORYBUDGET
  public long getCriticalThreshold(){
    return criticalThreshold;
  }
//#endif
//#endif
//#if MEMORYBUDGET
  public long getCacheBudget(){
    return cacheBudget;
  }
//#endif
//#if MEMORYBUDGET
  public long getINOverhead(){
    return inOverhead;
  }
//#endif
//#if MEMORYBUDGET
  public long getBINOverhead(){
    return binOverhead;
  }
//#endif
//#if MEMORYBUDGET
  public long getDINOverhead(){
    return dinOverhead;
  }
//#endif
//#if MEMORYBUDGET
  public long getDBINOverhead(){
    return dbinOverhead;
  }
//#endif
//#if MEMORYBUDGET
  /** 
 * Returns the memory size occupied by a byte array of a given length.
 */
  public static int byteArraySize(  int arrayLen){
    int size=BYTE_ARRAY_OVERHEAD;
    if (arrayLen > 4) {
      size+=((arrayLen - 4 + 7) / 8) * 8;
    }
    return size;
  }
//#endif
//#if MEMORYBUDGET
//#if STATISTICS
  void loadStats(  StatsConfig config,  EnvironmentStats stats){
    stats.setCacheDataBytes(getCacheMemoryUsage());
  }
//#endif
//#endif
}
