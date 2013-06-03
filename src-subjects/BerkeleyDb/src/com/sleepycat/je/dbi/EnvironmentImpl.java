package com.sleepycat.je.dbi;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentMutableConfig;
//#if STATISTICS
import com.sleepycat.je.EnvironmentStats;
//#endif
//#if STATISTICS
import com.sleepycat.je.LockStats;
//#endif
import com.sleepycat.je.RunRecoveryException;
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
//#if TRANSACTIONS
import com.sleepycat.je.Transaction;
//#endif
//#if TRANSACTIONS
import com.sleepycat.je.TransactionConfig;
//#endif
//#if TRANSACTIONS
//#if STATISTICS
import com.sleepycat.je.TransactionStats;
//#endif
//#endif
//#if VERIFIER
import com.sleepycat.je.VerifyConfig;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.Cleaner;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.UtilizationProfile;
//#endif
//#if CLEANER
import com.sleepycat.je.cleaner.UtilizationTracker;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
//#if EVICTOR
import com.sleepycat.je.evictor.Evictor;
//#endif
//#if INCOMPRESSOR
import com.sleepycat.je.incomp.INCompressor;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.Latch;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.LatchSupport;
//#endif
//#if LATCHES
import com.sleepycat.je.latch.SharedLatch;
//#endif
import com.sleepycat.je.log.FileManager;
//#if LATCHES
import com.sleepycat.je.log.LatchedLogManager;
//#endif
import com.sleepycat.je.log.LogManager;
import com.sleepycat.je.log.SyncedLogManager;
//#if LOGGINGDBLOGHANDLER
import com.sleepycat.je.log.TraceLogHandler;
//#endif
import com.sleepycat.je.recovery.Checkpointer;
import com.sleepycat.je.recovery.RecoveryInfo;
import com.sleepycat.je.recovery.RecoveryManager;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.BINReference;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.tree.Key;
import com.sleepycat.je.txn.Locker;
//#if TRANSACTIONS
import com.sleepycat.je.txn.Txn;
//#endif
import com.sleepycat.je.txn.TxnManager;
import com.sleepycat.je.utilint.DbLsn;
import com.sleepycat.je.utilint.PropUtil;
import com.sleepycat.je.utilint.Tracer;
/** 
 * Underlying Environment implementation. There is a single instance for any
 * database environment opened by the application.
 */
public class EnvironmentImpl implements EnvConfigObserver {
  private static final boolean TEST_NO_LOCKING_MODE=false;
  private DbEnvState envState;
  private boolean closing;
  private File envHome;
  private int referenceCount;
//#if TRANSACTIONS
  private boolean isTransactional;
//#endif
  private boolean isNoLocking;
  private boolean isReadOnly;
//#if LATCHES
  private static boolean fairLatches;
//#endif
  private MemoryBudget memoryBudget;
  private long lockTimeout;
  private long txnTimeout;
  private DbTree dbMapTree;
  private long mapTreeRootLsn=DbLsn.NULL_LSN;
//#if LATCHES
  private Latch mapTreeRootLatch;
//#endif
  private INList inMemoryINs;
  private DbConfigManager configManager;
  private List configObservers;
//#if LOGGINGBASE
  private Logger envLogger;
//#endif
  protected LogManager logManager;
  private FileManager fileManager;
  private TxnManager txnManager;
//#if EVICTOR
  private Evictor evictor;
//#endif
//#if INCOMPRESSOR
  private INCompressor inCompressor;
//#endif
  private Checkpointer checkpointer;
//#if CLEANER
  private Cleaner cleaner;
//#endif
  private RecoveryInfo lastRecoveryInfo;
  private RunRecoveryException savedInvalidatingException;
  private static boolean forcedYield=false;
//#if LATCHES
  private SharedLatch triggerLatch;
//#endif
  private static int threadLocalReferenceCount=0;
  /** 
 * DbPrintLog doesn't need btree and dup comparators to function properly
 * don't require any instantiations. This flag, if true, indicates that
 * we've been called from DbPrintLog.
 */
  private static boolean noComparators=false;
  public static final boolean JAVA5_AVAILABLE;
  private static final String DISABLE_JAVA_ADLER32="je.disable.java.adler32";
static {
    boolean ret=false;
    if (System.getProperty(DISABLE_JAVA_ADLER32) == null) {
      String javaVersion=System.getProperty("java.version");
      if (javaVersion != null && !javaVersion.startsWith("1.4.")) {
        ret=true;
      }
    }
    JAVA5_AVAILABLE=ret;
  }
  /** 
 * Create a database environment to represent the data in envHome. dbHome.
 * Properties from the je.properties file in that directory are used to
 * initialize the system wide property bag. Properties passed to this method
 * are used to influence the open itself.
 * @param envHomeabsolute path of the database environment home directory
 * @param envConfig
 * @throws DatabaseExceptionon all other failures
 */
  public EnvironmentImpl(  File envHome,  EnvironmentConfig envConfig) throws DatabaseException {
    try {
      this.envHome=envHome;
      envState=DbEnvState.INIT;
//#if LATCHES
      mapTreeRootLatch=LatchSupport.makeLatch("MapTreeRoot",this);
//#endif
      configManager=new DbConfigManager(envConfig);
      configObservers=new ArrayList();
      addConfigObserver(this);
      memoryBudget=new MemoryBudget(this,configManager);
//#if LOGGINGBASE
      envLogger=initLogger(envHome);
//#endif
      forcedYield=configManager.getBoolean(EnvironmentParams.ENV_FORCED_YIELD);
//#if TRANSACTIONS
      isTransactional=configManager.getBoolean(EnvironmentParams.ENV_INIT_TXN);
//#endif
      isNoLocking=!(configManager.getBoolean(EnvironmentParams.ENV_INIT_LOCKING));
//#if TRANSACTIONS
      if (isTransactional && isNoLocking) 
//#if TRANSACTIONS
{
        if (TEST_NO_LOCKING_MODE) {
          isNoLocking=!isTransactional;
        }
 else {
          throw new IllegalArgumentException("Can't set 'je.env.isNoLocking' and " + "'je.env.isTransactional';");
        }
      }
//#endif
//#endif
//#if LATCHES
      fairLatches=configManager.getBoolean(EnvironmentParams.ENV_FAIR_LATCHES);
//#endif
      isReadOnly=configManager.getBoolean(EnvironmentParams.ENV_RDONLY);
      fileManager=new FileManager(this,envHome,isReadOnly);
      if (!envConfig.getAllowCreate() && !fileManager.filesExist()) {
        throw new DatabaseException("Enviroment creation isn't allowed, " + " but there is no pre-existing " + " environment in "+ envHome);
      }
//#if LATCHES
      if (fairLatches) 
//#if LATCHES
{
        logManager=new LatchedLogManager(this,isReadOnly);
      }
//#endif
 else {
        logManager=new SyncedLogManager(this,isReadOnly);
      }
//#endif
      inMemoryINs=new INList(this);
      txnManager=new TxnManager(this);
      createDaemons();
      dbMapTree=new DbTree(this);
      referenceCount=0;
//#if LATCHES
      triggerLatch=LatchSupport.makeSharedLatch("TriggerLatch",this);
//#endif
      if (configManager.getBoolean(EnvironmentParams.ENV_RECOVERY)) {
        try {
          RecoveryManager recoveryManager=new RecoveryManager(this);
          lastRecoveryInfo=recoveryManager.recover(isReadOnly);
        }
  finally {
          try {
            logManager.flush();
            fileManager.clear();
          }
 catch (          IOException e) {
            throw new DatabaseException(e.getMessage());
          }
        }
      }
 else {
        isReadOnly=true;
        noComparators=true;
      }
      runOrPauseDaemons(configManager);
      lockTimeout=PropUtil.microsToMillis(configManager.getLong(EnvironmentParams.LOCK_TIMEOUT));
      txnTimeout=PropUtil.microsToMillis(configManager.getLong(EnvironmentParams.TXN_TIMEOUT));
//#if MEMORYBUDGET
      memoryBudget.initCacheMemoryUsage();
//#endif
      open();
    }
 catch (    DatabaseException e) {
      if (fileManager != null) {
        try {
          fileManager.close();
        }
 catch (        IOException IOE) {
        }
      }
      throw e;
    }
  }
  /** 
 * Respond to config updates.
 */
  public void envConfigUpdate(  DbConfigManager mgr) throws DatabaseException {
    runOrPauseDaemons(mgr);
  }
  /** 
 * Read configurations for daemons, instantiate.
 */
	private void createDaemons() throws DatabaseException {
		long checkpointerWakeupTime = 0;
		// #if EVICTOR
		evictor = new Evictor(this, "Evictor");
		// #endif
		// #if CPTIME
		checkpointerWakeupTime = Checkpointer
				.getWakeupPeriod(configManager);
		// #endif
		checkpointer = new Checkpointer(this, checkpointerWakeupTime, "Checkpointer");
		// #if INCOMPRESSOR
		long compressorWakeupInterval = PropUtil.microsToMillis(configManager
				.getLong(EnvironmentParams.COMPRESSOR_WAKEUP_INTERVAL));
		// #endif
		// #if INCOMPRESSOR
		inCompressor = new INCompressor(this, compressorWakeupInterval,
				"INCompressor");
		// #endif
		// #if CLEANER
		cleaner = new Cleaner(this, "Cleaner");
		// #endif
	}

  /** 
 * Run or pause daemons, depending on config properties.
 */
  private void runOrPauseDaemons(  DbConfigManager mgr) throws DatabaseException {
    if (!isReadOnly) {
//#if INCOMPRESSOR
      inCompressor.runOrPause(mgr.getBoolean(EnvironmentParams.ENV_RUN_INCOMPRESSOR));
//#endif
//#if CLEANER
//#if CLEANERDAEMON
      cleaner.runOrPause(mgr.getBoolean(EnvironmentParams.ENV_RUN_CLEANER) && !mgr.getBoolean(EnvironmentParams.LOG_MEMORY_ONLY));
//#endif
//#endif
//#if CHECKPOINTERDAEMON
      checkpointer.runOrPause(mgr.getBoolean(EnvironmentParams.ENV_RUN_CHECKPOINTER));
//#endif
    }
//#if EVICTORDAEMON
//#if EVICTOR
    evictor.runOrPause(mgr.getBoolean(EnvironmentParams.ENV_RUN_EVICTOR));
//#endif
//#endif
  }
//#if INCOMPRESSOR
  /** 
 * Return the incompressor. In general, don't use this directly because it's
 * easy to forget that the incompressor can be null at times (i.e during the
 * shutdown procedure. Instead, wrap the functionality within this class,
 * like lazyCompress.
 */
  public INCompressor getINCompressor(){
    return inCompressor;
  }
//#endif
//#if CLEANER
  /** 
 * Returns the UtilizationTracker.
 */
  public UtilizationTracker getUtilizationTracker(){
    return cleaner.getUtilizationTracker();
  }
//#endif
//#if CLEANER
  /** 
 * Returns the UtilizationProfile.
 */
  public UtilizationProfile getUtilizationProfile(){
    return cleaner.getUtilizationProfile();
  }
//#endif
  /** 
 * Log the map tree root and save the LSN.
 */
  public void logMapTreeRoot() throws DatabaseException {
//#if LATCHES
    mapTreeRootLatch.acquire();
//#endif
//#if LATCHES
    try {
      mapTreeRootLsn=logManager.log(dbMapTree);
    }
  finally {
      mapTreeRootLatch.release();
    }
//#endif
  }
  /** 
 * Force a rewrite of the map tree root if required.
 */
  public void rewriteMapTreeRoot(  long cleanerTargetLsn) throws DatabaseException {
//#if LATCHES
    mapTreeRootLatch.acquire();
//#endif
//#if LATCHES
    try {
      if (DbLsn.compareTo(cleanerTargetLsn,mapTreeRootLsn) == 0) {
        mapTreeRootLsn=logManager.log(dbMapTree);
      }
    }
  finally {
      mapTreeRootLatch.release();
    }
//#endif
  }
  /** 
 * @return the mapping tree root LSN.
 */
  public long getRootLsn(){
    return mapTreeRootLsn;
  }
  /** 
 * Set the mapping tree from the log. Called during recovery.
 */
  public void readMapTreeFromLog(  long rootLsn) throws DatabaseException {
    dbMapTree=(DbTree)logManager.get(rootLsn);
    dbMapTree.setEnvironmentImpl(this);
//#if LATCHES
    mapTreeRootLatch.acquire();
//#endif
//#if LATCHES
    try {
      mapTreeRootLsn=rootLsn;
    }
  finally {
      mapTreeRootLatch.release();
    }
//#endif
  }
//#if INCOMPRESSOR
  /** 
 * Tells the asynchronous IN compressor thread about a BIN with a deleted
 * entry.
 */
  public void addToCompressorQueue(  BIN bin,  Key deletedKey,  boolean doWakeup) throws DatabaseException {
    if (inCompressor != null) {
      inCompressor.addBinKeyToQueue(bin,deletedKey,doWakeup);
    }
  }
//#endif
//#if INCOMPRESSOR
  /** 
 * Tells the asynchronous IN compressor thread about a BINReference with a
 * deleted entry.
 */
  public void addToCompressorQueue(  BINReference binRef,  boolean doWakeup) throws DatabaseException {
    if (inCompressor != null) {
      inCompressor.addBinRefToQueue(binRef,doWakeup);
    }
  }
//#endif
//#if INCOMPRESSOR
  /** 
 * Tells the asynchronous IN compressor thread about a collections of
 * BINReferences with deleted entries.
 */
  public void addToCompressorQueue(  Collection binRefs,  boolean doWakeup) throws DatabaseException {
    if (inCompressor != null) {
      inCompressor.addMultipleBinRefsToQueue(binRefs,doWakeup);
    }
  }
//#endif
//#if INCOMPRESSOR
  /** 
 * Do lazy compression at opportune moments.
 */
  public void lazyCompress(  IN in) throws DatabaseException {
    if (inCompressor != null) {
      inCompressor.lazyCompress(in);
    }
  }
//#endif
//#if LOGGINGBASE
  /** 
 * Initialize the debugging logging system. Note that publishing to the
 * database log is not permitted until we've initialized the file manager in
 * recovery. We can't log safely before that.
 */
  private Logger initLogger(  File envHome) throws DatabaseException {
//#if LOGGINGBASE
    Logger logger=Logger.getAnonymousLogger();
//#endif
//#if LOGGINGBASE
    logger.setUseParentHandlers(false);
//#endif
    Level level=Tracer.parseLevel(this,EnvironmentParams.JE_LOGGING_LEVEL);
    logger.setLevel(level);
//#if LOGGINGCONSOLEHANDLER
    if (configManager.getBoolean(EnvironmentParams.JE_LOGGING_CONSOLE)) 
//#if LOGGINGCONSOLEHANDLER
{
      Handler consoleHandler=new ConsoleHandler();
      consoleHandler.setLevel(level);
      logger.addHandler(consoleHandler);
    }
//#endif
//#endif
//#if LOGGINGFILEHANDLER
    Handler fileHandler=null;
//#endif
//#if LOGGINGFILEHANDLER
    try 
//#if LOGGINGFILEHANDLER
{
      if (configManager.getBoolean(EnvironmentParams.JE_LOGGING_FILE)) {
        int limit=configManager.getInt(EnvironmentParams.JE_LOGGING_FILE_LIMIT);
        int count=configManager.getInt(EnvironmentParams.JE_LOGGING_FILE_COUNT);
        String logFilePattern=envHome + "/" + Tracer.INFO_FILES;
        fileHandler=new FileHandler(logFilePattern,limit,count,true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(level);
        logger.addHandler(fileHandler);
      }
    }
//#endif
 catch (    IOException e) {
      throw new DatabaseException(e.getMessage());
    }
//#endif
    return logger;
  }
//#endif
//#if LOGGINGBASE
//#if LOGGINGDBLOGHANDLER
  /** 
 * Add the database log as one of the debug logging destinations when the
 * logging system is sufficiently initialized.
 */
  public void enableDebugLoggingToDbLog() throws DatabaseException {
    if (configManager.getBoolean(EnvironmentParams.JE_LOGGING_DBLOG)) {
      Handler dbLogHandler=new TraceLogHandler(this);
      Level level=Level.parse(configManager.get(EnvironmentParams.JE_LOGGING_LEVEL));
      dbLogHandler.setLevel(level);
      envLogger.addHandler(dbLogHandler);
    }
  }
//#endif
//#endif
//#if LOGGINGBASE
  /** 
 * Close down the logger.
 */
  public void closeLogger(){
    Handler[] handlers=envLogger.getHandlers();
    for (int i=0; i < handlers.length; i++) {
      handlers[i].close();
    }
  }
//#endif
  /** 
 * Not much to do, mark state.
 */
  public void open(){
    envState=DbEnvState.OPEN;
  }
  /** 
 * Invalidate the environment. Done when a fatal exception
 * (RunRecoveryException) is thrown.
 */
  public void invalidate(  RunRecoveryException e){
    savedInvalidatingException=e;
    envState=DbEnvState.INVALID;
    requestShutdownDaemons();
  }
  /** 
 * @return true if environment is open.
 */
  public boolean isOpen(){
    return (envState == DbEnvState.OPEN);
  }
  /** 
 * @return true if close has begun, although the state may still be open.
 */
  public boolean isClosing(){
    return closing;
  }
  public boolean isClosed(){
    return (envState == DbEnvState.CLOSED);
  }
  /** 
 * When a RunRecoveryException occurs or the environment is closed, further
 * writing can cause log corruption.
 */
  public boolean mayNotWrite(){
    return (envState == DbEnvState.INVALID) || (envState == DbEnvState.CLOSED);
  }
  public void checkIfInvalid() throws RunRecoveryException {
    if (envState == DbEnvState.INVALID) {
      savedInvalidatingException.setAlreadyThrown();
      throw savedInvalidatingException;
    }
  }
  public void checkNotClosed() throws DatabaseException {
    if (envState == DbEnvState.CLOSED) {
      throw new DatabaseException("Attempt to use a Environment that has been closed.");
    }
  }
  public synchronized void close() throws DatabaseException {
    if (--referenceCount <= 0) {
      doClose(true);
    }
  }
  public synchronized void close(  boolean doCheckpoint) throws DatabaseException {
    if (--referenceCount <= 0) {
      doClose(doCheckpoint);
    }
  }
  private void doClose(  boolean doCheckpoint) throws DatabaseException {
    StringBuffer errors=new StringBuffer();
    try {
//#if LOGGINGFINE
      Tracer.trace(Level.FINE,this,"Close of environment " + envHome + " started");
//#endif
      try {
        envState.checkState(DbEnvState.VALID_FOR_CLOSE,DbEnvState.CLOSED);
      }
 catch (      DatabaseException DBE) {
        throw DBE;
      }
      requestShutdownDaemons();
      if (doCheckpoint && !isReadOnly && (envState != DbEnvState.INVALID)&& logManager.getLastLsnAtRecovery() != fileManager.getLastUsedLsn()) {
        CheckpointConfig ckptConfig=new CheckpointConfig();
        ckptConfig.setForce(true);
        ckptConfig.setMinimizeRecoveryTime(true);
        try {
          invokeCheckpoint(ckptConfig,false,"close");
        }
 catch (        DatabaseException IE) {
          errors.append("\nException performing checkpoint: ");
          errors.append(IE.toString()).append("\n");
        }
      }
      try {
        shutdownDaemons();
      }
 catch (      InterruptedException IE) {
        errors.append("\nException shutting down daemon threads: ");
        errors.append(IE.toString()).append("\n");
      }
//#if LOGGINGFINE
      Tracer.trace(Level.FINE,this,"Env " + envHome + " daemons shutdown");
//#endif
      try {
        logManager.flush();
      }
 catch (      DatabaseException DBE) {
        errors.append("\nException flushing log manager: ");
        errors.append(DBE.toString()).append("\n");
      }
      try {
        fileManager.clear();
      }
 catch (      IOException IOE) {
        errors.append("\nException clearing file manager: ");
        errors.append(IOE.toString()).append("\n");
      }
catch (      DatabaseException DBE) {
        errors.append("\nException clearing file manager: ");
        errors.append(DBE.toString()).append("\n");
      }
      try {
        fileManager.close();
      }
 catch (      IOException IOE) {
        errors.append("\nException clearing file manager: ");
        errors.append(IOE.toString()).append("\n");
      }
catch (      DatabaseException DBE) {
        errors.append("\nException clearing file manager: ");
        errors.append(DBE.toString()).append("\n");
      }
      try {
        inMemoryINs.clear();
      }
 catch (      DatabaseException DBE) {
        errors.append("\nException closing file manager: ");
        errors.append(DBE.toString()).append("\n");
      }
//#if LOGGINGBASE
      closeLogger();
//#endif
      DbEnvPool.getInstance().remove(envHome);
//#if CHECKLEAKS
      try 
//#if CHECKLEAKS
{
//#if CHECKLEAKS
        checkLeaks();
//#endif
//#if LATCHES
        LatchSupport.clearNotes();
//#endif
      }
//#endif
 catch (      DatabaseException DBE) {
        errors.append("\nException performing validity checks: ");
        errors.append(DBE.toString()).append("\n");
      }
//#endif
    }
  finally {
      envState=DbEnvState.CLOSED;
    }
    if (errors.length() > 0 && savedInvalidatingException == null) {
      throw new RunRecoveryException(this,errors.toString());
    }
  }
  public synchronized void closeAfterRunRecovery() throws DatabaseException {
    try {
      shutdownDaemons();
    }
 catch (    InterruptedException IE) {
    }
    try {
      fileManager.clear();
    }
 catch (    Exception e) {
    }
    try {
      fileManager.close();
    }
 catch (    Exception e) {
    }
    DbEnvPool.getInstance().remove(envHome);
  }
  public synchronized void forceClose() throws DatabaseException {
    referenceCount=1;
    close();
  }
  public synchronized void incReferenceCount(){
    referenceCount++;
  }
  public static int getThreadLocalReferenceCount(){
    return threadLocalReferenceCount;
  }
  public static synchronized void incThreadLocalReferenceCount(){
    threadLocalReferenceCount++;
  }
  public static synchronized void decThreadLocalReferenceCount(){
    threadLocalReferenceCount--;
  }
  public static boolean getNoComparators(){
    return noComparators;
  }
//#if CHECKLEAKS
  /** 
 * Debugging support. Check for leaked locks and transactions.
 */
  private void checkLeaks() throws DatabaseException {
    if (!configManager.getBoolean(EnvironmentParams.ENV_CHECK_LEAKS)) {
      return;
    }
    boolean clean=true;
//#if STATISTICS
    StatsConfig statsConfig=new StatsConfig();
//#endif
//#if STATISTICS
    statsConfig.setFast(false);
//#endif
//#if STATISTICS
    LockStats lockStat=lockStat(statsConfig);
//#endif
//#if STATISTICS
    if (lockStat.getNTotalLocks() != 0) 
//#if STATISTICS
{
      clean=false;
      System.out.println("Problem: " + lockStat.getNTotalLocks() + " locks left");
      txnManager.getLockManager().dump();
    }
//#endif
//#endif
//#if TRANSACTIONS
//#if STATISTICS
    TransactionStats txnStat=txnStat(statsConfig);
//#endif
//#endif
//#if TRANSACTIONS
//#if STATISTICS
    if (txnStat.getNActive() != 0) 
//#if TRANSACTIONS
//#if STATISTICS
{
      clean=false;
      System.out.println("Problem: " + txnStat.getNActive() + " txns left");
      TransactionStats.Active[] active=txnStat.getActiveTxns();
      if (active != null) {
        for (int i=0; i < active.length; i+=1) {
          System.out.println(active[i]);
        }
      }
    }
//#endif
//#endif
//#endif
//#endif
//#if LATCHES
    if (LatchSupport.countLatchesHeld() > 0) 
//#if LATCHES
{
      clean=false;
      System.out.println("Some latches held at env close.");
      LatchSupport.dumpLatchesHeld();
    }
//#endif
//#endif
    assert clean : "Lock, transaction, or latch left behind at environment close";
  }
//#endif
  /** 
 * Invoke a checkpoint programatically. Note that only one checkpoint may
 * run at a time.
 */
  public boolean invokeCheckpoint(  CheckpointConfig config,  boolean flushAll,  String invokingSource) throws DatabaseException {
    if (checkpointer != null) {
      checkpointer.doCheckpoint(config,flushAll,invokingSource);
      return true;
    }
 else {
      return false;
    }
  }
//#if LOGGINGBASE
//#if LOGGINGFILEHANDLER
  /** 
 * Flip the log to a new file, forcing an fsync. Return the LSN of the trace
 * record in the new file.
 */
  public long forceLogFileFlip() throws DatabaseException {
    Tracer newRec=new Tracer("File Flip");
    return logManager.logForceFlip(newRec);
  }
//#endif
//#endif
//#if INCOMPRESSOR
  /** 
 * Invoke a compress programatically. Note that only one compress may run at
 * a time.
 */
  public boolean invokeCompressor() throws DatabaseException {
    if (inCompressor != null) {
      inCompressor.doCompress();
      return true;
    }
 else {
      return false;
    }
  }
//#endif
//#if EVICTOR
  public void invokeEvictor() throws DatabaseException {
    if (evictor != null) {
      evictor.doEvict(Evictor.SOURCE_MANUAL);
    }
  }
//#endif
//#if CLEANER
  public int invokeCleaner() throws DatabaseException {
    if (cleaner != null) {
      return cleaner.doClean(true,false);
    }
 else {
      return 0;
    }
  }
//#endif
  private void requestShutdownDaemons(){
    closing=true;
//#if INCOMPRESSOR
    if (inCompressor != null) 
//#if INCOMPRESSOR
{
      inCompressor.requestShutdown();
    }
//#endif
//#endif
//#if EVICTOR
    if (evictor != null) 
//#if EVICTOR
{
    //#if EVICTORDAEMON
      evictor.requestShutdown();
    //#endif
    }
//#endif
//#endif
//#if CHECKPOINTERDAEMON
    if (checkpointer != null) 
//#if CHECKPOINTERDAEMON
{
      checkpointer.requestShutdown();
    }
//#endif
//#endif
//#if CLEANER
//#if CLEANERDAEMON
    if (cleaner != null) 
//#if CLEANER
//#if CLEANERDAEMON
{
      cleaner.requestShutdown();
    }
//#endif
//#endif
//#endif
//#endif
  }
  /** 
 * Ask all daemon threads to shut down.
 */
  private void shutdownDaemons() throws InterruptedException {
//#if INCOMPRESSOR
    shutdownINCompressor();
//#endif
//#if CLEANER
//#if CLEANERDAEMON
    shutdownCleaner();
//#endif
//#endif
    shutdownCheckpointer();
//#if EVICTOR
    shutdownEvictor();
//#endif
  }
//#if INCOMPRESSOR
  /** 
 * Available for the unit tests.
 */
  public void shutdownINCompressor() throws InterruptedException {
    if (inCompressor != null) {
      inCompressor.shutdown();
      inCompressor.clearEnv();
      inCompressor=null;
    }
    return;
  }
//#endif
//#if EVICTOR
  public void shutdownEvictor() throws InterruptedException {
    if (evictor != null) {
   //#if EVICTORDAEMON	
      evictor.shutdown();
   //#endif
      evictor.clearEnv();
      evictor=null;
    }
    return;
  }
//#endif
  void shutdownCheckpointer() throws InterruptedException {
    if (checkpointer != null) {
//#if CHECKPOINTERDAEMON
      checkpointer.shutdown();
//#endif
//#if CHECKPOINTERDAEMON
      checkpointer.clearEnv();
//#endif
      checkpointer=null;
    }
    return;
  }
//#if CLEANER
//#if CLEANERDAEMON
  /** 
 * public for unit tests.
 */
  public void shutdownCleaner() throws InterruptedException {
    if (cleaner != null) {
      cleaner.shutdown();
    }
    return;
  }
//#endif
//#endif
  public boolean isNoLocking(){
    return isNoLocking;
  }
//#if TRANSACTIONS
  public boolean isTransactional(){
    return isTransactional;
  }
//#endif
  public boolean isReadOnly(){
    return isReadOnly;
  }
//#if LATCHES
  public static boolean getFairLatches(){
    return fairLatches;
  }
//#endif
  public DatabaseImpl createDb(  Locker locker,  String databaseName,  DatabaseConfig dbConfig,  Database databaseHandle) throws DatabaseException {
    return dbMapTree.createDb(locker,databaseName,dbConfig,databaseHandle);
  }
  /** 
 * Get a database object given a database name.
 * @param databaseNametarget database.
 * @return null if database doesn't exist.
 */
  public DatabaseImpl getDb(  Locker locker,  String databaseName,  Database databaseHandle) throws DatabaseException {
    return dbMapTree.getDb(locker,databaseName,databaseHandle);
  }
  public List getDbNames() throws DatabaseException {
    return dbMapTree.getDbNames();
  }
  /** 
 * For debugging.
 */
  public void dumpMapTree() throws DatabaseException {
    dbMapTree.dump();
  }
//#if RENAMEOP
  /** 
 * Rename a database.
 */
  public void dbRename(  Locker locker,  String databaseName,  String newName) throws DatabaseException {
    dbMapTree.dbRename(locker,databaseName,newName);
  }
//#endif
//#if DELETEOP
  /** 
 * Remove a database.
 */
  public void dbRemove(  Locker locker,  String databaseName) throws DatabaseException {
    dbMapTree.dbRemove(locker,databaseName);
  }
//#endif
//#if TRUNCATEOP
  /** 
 * Truncate a database. Return a new DatabaseImpl object which represents
 * the new truncated database. The old database is marked as deleted.
 * @deprecated This supports Database.truncate(), which is deprecated.
 */
  public TruncateResult truncate(  Locker locker,  DatabaseImpl database) throws DatabaseException {
    return dbMapTree.truncate(locker,database,true);
  }
//#endif
//#if TRUNCATEOP
  /** 
 * Truncate a database.
 */
  public long truncate(  Locker locker,  String databaseName,  boolean returnCount) throws DatabaseException {
    return dbMapTree.truncate(locker,databaseName,returnCount);
  }
//#endif
  /** 
 * Transactional services.
 */
  
//#if TRANSACTIONS
  public Txn txnBegin (Transaction parent, TransactionConfig txnConfig) throws DatabaseException {
    if (!isTransactional) {
      throw new DatabaseException("beginTransaction called, " + " but Environment was not opened " + "with transactional cpabilities");
    }
    return txnManager.txnBegin(parent,txnConfig);
  }
//#endif

  public LogManager getLogManager(){
    return logManager;
  }
  public FileManager getFileManager(){
    return fileManager;
  }
  public DbTree getDbMapTree(){
    return dbMapTree;
  }
  /** 
 * Returns the config manager for the current base configuration.
 * <p>
 * The configuration can change, but changes are made by replacing the
 * config manager object with a enw one. To use a consistent set of
 * properties, call this method once and query the returned manager
 * repeatedly for each property, rather than getting the config manager via
 * this method for each property individually.
 * </p>
 */
  public DbConfigManager getConfigManager(){
    return configManager;
  }
  /** 
 * Clones the current configuration.
 */
  public EnvironmentConfig cloneConfig(){
    return DbInternal.cloneConfig(configManager.getEnvironmentConfig());
  }
  /** 
 * Clones the current mutable configuration.
 */
  public EnvironmentMutableConfig cloneMutableConfig(){
    return DbInternal.cloneMutableConfig(configManager.getEnvironmentConfig());
  }
  /** 
 * Throws an exception if an immutable property is changed.
 */
  public void checkImmutablePropsForEquality(  EnvironmentConfig config) throws IllegalArgumentException {
    DbInternal.checkImmutablePropsForEquality(configManager.getEnvironmentConfig(),config);
  }
  /** 
 * Changes the mutable config properties that are present in the given
 * config, and notifies all config observer.
 */
  public synchronized void setMutableConfig(  EnvironmentMutableConfig config) throws DatabaseException {
    EnvironmentConfig newConfig=DbInternal.cloneConfig(configManager.getEnvironmentConfig());
    DbInternal.copyMutablePropsTo(config,newConfig);
    configManager=new DbConfigManager(newConfig);
    for (int i=configObservers.size() - 1; i >= 0; i-=1) {
      EnvConfigObserver o=(EnvConfigObserver)configObservers.get(i);
      o.envConfigUpdate(configManager);
    }
  }
  /** 
 * Adds an observer of mutable config changes.
 */
  public synchronized void addConfigObserver(  EnvConfigObserver o){
    configObservers.add(o);
  }
  /** 
 * Removes an observer of mutable config changes.
 */
  public synchronized void removeConfigObserver(  EnvConfigObserver o){
    configObservers.remove(o);
  }
  public INList getInMemoryINs(){
    return inMemoryINs;
  }
  public TxnManager getTxnManager(){
    return txnManager;
  }
  public Checkpointer getCheckpointer(){
    return checkpointer;
  }
//#if CLEANER
  public Cleaner getCleaner(){
    return cleaner;
  }
//#endif
  public MemoryBudget getMemoryBudget(){
    return memoryBudget;
  }
//#if LOGGINGBASE
  /** 
 * @return environment Logger, for use in debugging output.
 */
  public Logger getLogger(){
    return envLogger;
  }
//#endif
//#if STATISTICS
//#if VERIFIER
  public boolean verify(  VerifyConfig config,  PrintStream out) throws DatabaseException {
    return dbMapTree.verify(config,out);
  }
//#endif
//#endif
//#if VERIFIER
//#if INCOMPRESSOR
  public void verifyCursors() throws DatabaseException {
    inCompressor.verifyCursors();
  }
//#endif
//#endif
//#if STATISTICS
  /** 
 * Retrieve and return stat information.
 */
  synchronized public EnvironmentStats loadStats(  StatsConfig config) throws DatabaseException {
    EnvironmentStats stats=new EnvironmentStats();
//#if INCOMPRESSOR
    inCompressor.loadStats(config,stats);
//#endif
//#if EVICTOR
    evictor.loadStats(config,stats);
//#endif
    checkpointer.loadStats(config,stats);
//#if CLEANER
    cleaner.loadStats(config,stats);
//#endif
    logManager.loadStats(config,stats);
//#if MEMORYBUDGET
    memoryBudget.loadStats(config,stats);
//#endif
    return stats;
  }
//#endif
//#if STATISTICS
  /** 
 * Retrieve lock statistics
 */
  synchronized public LockStats lockStat(  StatsConfig config) throws DatabaseException {
    return txnManager.lockStat(config);
  }
//#endif
//#if TRANSACTIONS
//#if STATISTICS
  /** 
 * Retrieve txn statistics
 */
  
//#if TRANSACTIONS
synchronized
//#endif
 
//#if TRANSACTIONS
public
//#endif
 
//#if TRANSACTIONS
TransactionStats
//#endif
 
//#if TRANSACTIONS
txnStat
//#endif
(
//#if TRANSACTIONS
  StatsConfig config
//#endif
) throws 
//#if TRANSACTIONS
DatabaseException
//#endif
 
//#if TRANSACTIONS
{
    return txnManager.txnStat(config);
  }
//#endif
//#endif
//#endif

//#if INCOMPRESSOR
  public int getINCompressorQueueSize() throws DatabaseException {
    return inCompressor.getBinRefQueueSize();
  }
//#endif
  /** 
 * Info about the last recovery
 */
  public RecoveryInfo getLastRecoveryInfo(){
    return lastRecoveryInfo;
  }
  /** 
 * Get the environment home directory.
 */
  public File getEnvironmentHome(){
    return envHome;
  }
  public long getTxnTimeout(){
    return txnTimeout;
  }
  public long getLockTimeout(){
    return lockTimeout;
  }
//#if LATCHES
  /** 
 * Returns the shared trigger latch.
 */
  public SharedLatch getTriggerLatch(){
    return triggerLatch;
  }
//#endif
//#if EVICTOR
  public Evictor getEvictor(){
    return evictor;
  }
//#endif
//#if EVICTOR
  void alertEvictor(){
    if (evictor != null) {
      evictor.alert();
    }
  }
//#endif
  /** 
 * For stress testing. Should only ever be called from an assert.
 */
  public static boolean maybeForceYield(){
    if (forcedYield) {
      Thread.yield();
    }
    return true;
  }
}
