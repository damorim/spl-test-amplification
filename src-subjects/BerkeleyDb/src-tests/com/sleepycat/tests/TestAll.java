package com.sleepycat.tests;

import java.io.File;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.tests.gettingStarted.ExampleDatabasePut;
import com.sleepycat.tests.gettingStarted.ExampleInventoryRead;
import com.sleepycat.tests.gettingStarted.MyDbEnv;
import com.sleepycat.tests.txn.TxnGuide;

public class TestAll {

	public static String logdisable = "logdisable";
	public static boolean logON = true;
	public static boolean doCoverage = false;// NÂO COMITAR COM TRUE

	public static void main(String[] args) throws InterruptedException {
		int test = 1;

		switch (test) {
		case 1:
			// TRANSACTIONS && IO && CLEANER
			test1();// Works on both reduced and extended suite (for every valid
					// feature set), including JPF for both.
			break;
		case 2:
			// LATCHES && FILEHANDLECACHE && CLEANER && EVICTOR && DELETEOP && MEMORY_BUDGET
			test2();// Works on reduced suite and extended suite(for a certain
					// feature set).
			break;
		case 3:
			// LATCHES && FILEHANDLECACHE && CLEANER && EVICTOR && DELETEOP && MEMORY_BUDGET
			test3();// Works on reduced suite and extended suite(for a certain
					// feature set).
			break;
		case 4:
			//#if LATCHES && FILEHANDLECACHE && CLEANER && EVICTOR && DELETEOP && MEMORY_BUDGET
			test4();// Works on reduced suite and extended suite(for a certain
					// feature set).
			//#endif
			break;
		default:
			throw new RuntimeException("This test does not exist");
		}

		if (true) {
			if (logON) {
				System.out.println("DONE");
			}
			System.exit(0);
		}
	}

	/**
	 * This test initializes the database environment. Minimum feature set: 1
	 * TRANSACTIONS IO CLEANER
	 */
	public static void test1() {
		Environment myDatabaseEnvironment = null;
		File dbEnv = setup();
		try {
			EnvironmentConfig envConfig = new EnvironmentConfig();
			envConfig.setAllowCreate(true);
			//#if TRANSACTIONS
			envConfig.setTransactional(true);
			//#endif
			myDatabaseEnvironment = new Environment(dbEnv, envConfig);
		} catch (DatabaseException dbe) {
			dbe.printStackTrace();
			System.err.println(dbe.toString());
			// System.exit(1);
		}
		tearDown(dbEnv);

		/**
		 * MARCELO ADDED THIS TO DEAL WITH DAEMON THREADS
		 */
		if (true) {
			if (logON) {
				System.out.println("DONE");
			}
			System.exit(0);
		}
	}

	/**
	 * This test inserts into and retrieves from a database by specifying an
	 * environment directory for the data generated: Minimum feature set: 3
	 * LATCHES FILEHANDLECACHE CLEANER EVICTOR DELETEOP MEMORY_BUDGET NIO 3
	 * LATCHES FILEHANDLECACHE CLEANER EVICTOR DELETEOP MEMORY_BUDGET
	 * CHUNCKEDNIO 3 LATCHES FILEHANDLECACHE CLEANER EVICTOR DELETEOP
	 * MEMORY_BUDGET IO
	 */
	public static void test3() {
		File dbEnv = setup();
		SimpleExample appInsert = new SimpleExample(10, true, dbEnv, 10); // insert
		SimpleExample appRetrieve = new SimpleExample(0, false, dbEnv, 0); // retrieve
		try {
			appInsert.run();
			appRetrieve.run();
		} catch (DatabaseException dbe) {
			System.err.println("ExampleDatabasePut: " + dbe.toString());
			dbe.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
			e.printStackTrace();
		}
		tearDown(dbEnv);
	}

	/**
	 * This test puts and reads information in your database. Minimum feature
	 * set: 2 LATCHES FILEHANDLECACHE CLEANER EVICTOR DELETEOP MEMORY_BUDGET NIO
	 * 2 LATCHES FILEHANDLECACHE CLEANER EVICTOR DELETEOP MEMORY_BUDGET
	 * CHUNCKEDNIO 2 LATCHES FILEHANDLECACHE CLEANER EVICTOR DELETEOP
	 * MEMORY_BUDGET IO
	 */
	public static void test2() {
		MyDbEnv myDbEnv = new MyDbEnv();
		try {
			ExampleDatabasePut.run(myDbEnv);
			ExampleInventoryRead.run(myDbEnv);
		} catch (DatabaseException dbe) {
			System.err.println("ExampleDatabasePut: " + dbe.toString());
			dbe.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
			e.printStackTrace();
		} finally {
			myDbEnv.close();
		}
		File dir = new File(System.getProperty("user.dir") + "/gsgEnv");
		tearDown(dir);// organizar isso depois

	}

	/**
	 * This test runs a transactional example. Minimum feature set: 4 LATCHES
	 * FILEHANDLECACHE CLEANER EVICTOR DELETEOP MEMORY_BUDGET NIO 4 LATCHES
	 * FILEHANDLECACHE CLEANER EVICTOR DELETEOP MEMORY_BUDGET CHUNCKEDNIO 4
	 * LATCHES FILEHANDLECACHE CLEANER EVICTOR DELETEOP MEMORY_BUDGET IO
	 */
	public static void test4() {
		TxnGuide.run();
	}

	public static File setup() {
		File dir = new File(System.getProperty("user.dir") + "/dbEnv");
		if (!dir.exists()) {
			dir.mkdir();
		}
		return dir;
	}

	public static void tearDown(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				if (logON) {
					System.out.println("deleting dir: " + file);
				}
				for (File f : file.listFiles()) {
					if (!f.getName().contains("svn")) {
						tearDown(f);
					}
				}
			} else {
				if (logON) {
					System.out.println("deleting file: " + file);
				}
				file.delete();
			}

		}
	}
}
