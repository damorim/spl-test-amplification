package com.sleepycat.je.util;

import java.io.File;
import java.text.DecimalFormat;
import com.sleepycat.je.CheckpointConfig;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentMutableConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
//#if STATISTICS
import com.sleepycat.je.StatsConfig;
//#endif
//#if TRANSACTIONS
import com.sleepycat.je.Transaction;
//#endif
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.utilint.CmdUtil;

/**
 * DbRunAction is a debugging aid that runs one of the background activities
 * (cleaning, compressing, evicting, checkpointing).
 */
public class DbRunAction {
	// #if CLEANER
	private static final int CLEAN = 1;
	// #endif
	// #if INCOMPRESSOR
	private static final int COMPRESS = 2;
	// #endif
	// #if EVICTOR
	private static final int EVICT = 3;
	// #endif
	private static final int CHECKPOINT = 4;
	// #if DELETEOP
	private static final int REMOVEDB = 5;
	// #endif
	// #if STATISTICS
	private static final int DBSTATS = 6;

	// #endif
	public static void main(String[] argv) {
		long recoveryStart = 0;
		long actionStart = 0;
		long actionEnd = 0;
		try {
			int whichArg = 0;
			if (argv.length == 0) {
				usage();
				System.exit(1);
			}
			String dbName = null;
			int doAction = 0;
			String envHome = ".";
			boolean readOnly = false;
			while (whichArg < argv.length) {
				String nextArg = argv[whichArg];
				if (nextArg.equals("-h")) {
					whichArg++;
					envHome = CmdUtil.getArg(argv, whichArg);
				} else if (nextArg.equals("-a")) {
					whichArg++;
					String action = CmdUtil.getArg(argv, whichArg);
					// #if CLEANER
					if (action.equalsIgnoreCase("clean"))
					// #if CLEANER
					{
						doAction = CLEAN;
					}
					// #endif
					// #if INCOMPRESSOR
					else if (action.equalsIgnoreCase("compress"))
					// #if INCOMPRESSOR
					{
						doAction = COMPRESS;
					}
					// #endif
					else if (action.equalsIgnoreCase("checkpoint")) {
						doAction = CHECKPOINT;
					}
					// #if EVICTOR
					else if (action.equalsIgnoreCase("evict"))
					// #if EVICTOR
					{
						doAction = EVICT;
					}
					// #endif
					else
					// #if DELETEOP
					if (action.equalsIgnoreCase("removedb"))
					// #if DELETEOP
					{
						doAction = REMOVEDB;
					}
					// #endif
					// #if STATISTICS
					else if (action.equalsIgnoreCase("dbstats"))
					// #if STATISTICS
					{
						doAction = DBSTATS;
					}
					// #endif
					else {
						usage();
						System.exit(1);
					}
					// #endif
					// #endif
					// #endif
					// #endif
					// #endif
				} else if (nextArg.equals("-ro")) {
					readOnly = true;
				} else if (nextArg.equals("-s")) {
					dbName = argv[++whichArg];
				} else {
					throw new IllegalArgumentException(nextArg
							+ " is not a supported option.");
				}
				whichArg++;
			}
			EnvironmentConfig envConfig = new EnvironmentConfig();
			// #if LOGGINGCONSOLEHANDLER
			envConfig.setConfigParam(
					EnvironmentParams.JE_LOGGING_CONSOLE.getName(), "true");
			// #endif
			// #if LOGGINGDBLOGHANDLER
			if (readOnly)
			// #if LOGGINGDBLOGHANDLER
			{
				envConfig.setConfigParam(
						EnvironmentParams.JE_LOGGING_DBLOG.getName(), "false");
				envConfig.setReadOnly(true);
			}
			// #endif
			// #endif
			// #if EVICTOR
			if (doAction == EVICT)
			// #if EVICTOR
			{
				envConfig.setConfigParam(
						EnvironmentParams.ENV_RUN_EVICTOR.getName(), "false");
				envConfig
						.setConfigParam(
								EnvironmentParams.EVICTOR_CRITICAL_PERCENTAGE
										.getName(), "1000");
			}
			// #endif
			// #endif
			recoveryStart = System.currentTimeMillis();
			Environment env = new Environment(new File(envHome), envConfig);
			CheckpointConfig forceConfig = new CheckpointConfig();
			forceConfig.setForce(true);
			actionStart = System.currentTimeMillis();
			switch (doAction) {
			// #if CLEANER
			case CLEAN:
				// #endif
				// #if CLEANER
				while (true)
				// #if CLEANER
				{
					int nFiles = env.cleanLog();
					System.out.println("Files cleaned: " + nFiles);
					if (nFiles == 0) {
						break;
					}
				}
				// #endif
				// #endif
				// #if CLEANER
				env.checkpoint(forceConfig);
				// #endif
				// #if CLEANER
				break;
			// #endif
			// #if INCOMPRESSOR
			case COMPRESS:
				// #endif
				// #if INCOMPRESSOR
				env.compress();
				// #endif
				// #if INCOMPRESSOR
				break;
			// #endif
			// #if EVICTOR
			case EVICT:
				// #endif
				// #if EVICTOR
				preload(env, dbName);
				// #endif
				// #if EVICTOR
				break;
			// #endif
			case CHECKPOINT:
				env.checkpoint(forceConfig);
				break;
			// #if DELETEOP
			case REMOVEDB:
				// #endif
				// #if DELETEOP
				removeAndClean(env, dbName);
				// #endif
				// #if DELETEOP
				break;
			// #endif
			// #if STATISTICS
			case DBSTATS:
				// #endif
				// #if STATISTICS
				DatabaseConfig dbConfig = new DatabaseConfig();
				// #endif
				// #if STATISTICS
				dbConfig.setReadOnly(true);
				// #endif
				// #if STATISTICS
				DbInternal.setUseExistingConfig(dbConfig, true);
				// #endif
				// #if STATISTICS
				Database db = env.openDatabase(null, dbName, dbConfig);
				// #endif
				// #if STATISTICS
				try
				// #if STATISTICS
				{
					System.out.println(db.getStats(new StatsConfig()));
				}
				// #endif
				finally {
					db.close();
				}
				// #endif
				// #if STATISTICS
				break;
			// #endif
			}
			actionEnd = System.currentTimeMillis();
			env.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			usage();
			System.exit(1);
		} finally {
			DecimalFormat f = new DecimalFormat();
			f.setMaximumFractionDigits(2);
			long recoveryDuration = actionStart - recoveryStart;
			System.out.println("\nrecovery time = "
					+ f.format(recoveryDuration) + " millis "
					+ f.format((double) recoveryDuration / 60000) + " minutes");
			long actionDuration = actionEnd - actionStart;
			System.out.println("action time = " + f.format(actionDuration)
					+ " millis " + f.format(actionDuration / 60000)
					+ " minutes");
		}
	}

	// #if DELETEOP
	private static void removeAndClean(Environment env, String name)
			throws DatabaseException {
		long a, b, c, d, e, f;
		// #if TRANSACTIONS
		Transaction txn = env.beginTransaction(null, null);
		// #endif
		CheckpointConfig force = new CheckpointConfig();
		force.setForce(true);
		a = System.currentTimeMillis();
		env.removeDatabase(
		// #if TRANSACTIONS
				txn
				// #endif
				, name);
		b = System.currentTimeMillis();
		// #if TRANSACTIONS
		txn.commit();
		// #endif
		// #if CLEANER
		c = System.currentTimeMillis();
		// #endif
		// #if CLEANER
		int cleanedCount = 0;
		// #endif
		// #if CLEANER
		while (env.cleanLog() > 0)
		// #if CLEANER
		{
			cleanedCount++;
		}
		// #endif
		// #endif
		// #if CLEANER
		d = System.currentTimeMillis();
		// #endif
		// #if CLEANER
		System.out.println("cleanedCount=" + cleanedCount);
		// #endif
		// #if CLEANER
		e = 0;
		// #endif
		// #if CLEANER
		f = 0;
		// #endif
		// #if CLEANER
		if (cleanedCount > 0)
		// #if CLEANER
		{
			e = System.currentTimeMillis();
			env.checkpoint(force);
			f = System.currentTimeMillis();
		}
		// #endif
		// #endif
		System.out.println("Remove of " + name + " remove: " + getSecs(a, b)
				+ " commit: " + getSecs(b, c) + " clean: " + getSecs(c, d)
				+ " checkpoint: " + getSecs(e, f));
	}

	// #endif
	private static String getSecs(long start, long end) {
		return (end - start) / 1000 + " secs";
	}

	private static void preload(Environment env, String dbName)
			throws DatabaseException {
		System.out.println("Preload starting");
		Database db = env.openDatabase(
		// #if TRANSACTIONS
				null,
				// #endif
				dbName, null);
		Cursor cursor = db.openCursor(
		// #if TRANSACTIONS
				null,
				// #endif
				null);
		try {
			DatabaseEntry key = new DatabaseEntry();
			DatabaseEntry data = new DatabaseEntry();
			int count = 0;
			while (cursor.getNext(key, data, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				count++;
				if ((count % 50000) == 0) {
					System.out.println(count + "...");
				}
			}
			System.out.println("Preloaded " + count + " records");
		} finally {
			cursor.close();
			db.close();
		}
	}

	// #if EVICTOR
	private static void doEvict(Environment env) throws DatabaseException {
		EnvironmentImpl envImpl = DbInternal.envGetEnvironmentImpl(env);
		// #if MEMORYBUDGET
		long cacheUsage = envImpl.getMemoryBudget().getCacheMemoryUsage();
		// #endif
		EnvironmentMutableConfig c = new EnvironmentMutableConfig();
		// #if MEMORYBUDGET
		c.setCacheSize(cacheUsage / 2);
		// #endif
		env.setMutableConfig(c);
		long start = System.currentTimeMillis();
		env.evictMemory();
		long end = System.currentTimeMillis();
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		System.out.println("evict time=" + f.format(end - start));
	}

	// #endif
	private static void usage() {
		System.out.println("Usage: \n "
				+ CmdUtil.getJavaCommand(DbRunAction.class));
		System.out.println("  -h <environment home> ");
		System.out.println("  -a <clean|compress|evict|checkpoint|removedb>");
		System.out.println("  -ro (read-only - defaults to read-write)");
		System.out
				.println("  -s <dbName> (for preloading of evict or db remove)");
	}
}
