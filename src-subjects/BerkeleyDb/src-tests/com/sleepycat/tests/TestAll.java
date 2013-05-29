package com.sleepycat.tests;

import java.io.File;
import java.io.IOException;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentConfigTest;
import com.sleepycat.je.cleaner.CleanerTest;
import com.sleepycat.je.dbi.DbConfigManagerTest;
import com.sleepycat.je.log.LNFileReaderTest;
import com.sleepycat.tests.txn.TxnGuide;

public class TestAll {

	public static boolean logON = true;
	
	public static void main(String[] args){
		runTest(1);
	}

	public static void runTest(int test) {

		switch (test) {
		case 1:
			test1();
			break;
		case 2:
			test2();
			break;
		case 3:
			test3();
			break;
		case 4:
			test4();
			break;
		case 5:
			test5();
			break;
		default:
			throw new RuntimeException("This test does not exist");
		}
	}

	private static void test5() {
		LNFileReaderTest lnrt = new LNFileReaderTest();
		try {
			lnrt.setUp();
			lnrt.testNoFile();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally{
			try {
				lnrt.tearDown();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (DatabaseException e) {
				e.printStackTrace();
			}
		}
	}

	private static void test4() {
		DbConfigManagerTest dbct = new DbConfigManagerTest();
		try {
			dbct.testBasicParams();
		} catch (Throwable e) {
//			if (e.getClass() == InvalidConfigurationException.class) {
//				throw new InvalidConfigurationException();
//			}
			e.printStackTrace();
		}
	}

	private static void test3() {
		EnvironmentConfigTest ect = new EnvironmentConfigTest();
		try {
			ect.testValidation();
			ect.testSingleParam();
			ect.testInconsistentParams();
		} catch (Exception e) {
//			if (e.getClass() == InvalidConfigurationException.class) {
//				throw new InvalidConfigurationException();
//			}
		}
	}

	/**
	 * This test initializes the database environment.
	 */
	public static void test1() {
		CleanerTest ct = new CleanerTest();
		try {
			ct.setUp();
			try {
//				ct.testCleanerNoDupes();
				ct.testMutableConfig();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ct.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test runs a transactional example.
	 */
	public static void test2() {
		try {
			TxnGuide.run();
		} catch (Exception e) {
//			if (e.getClass() == InvalidConfigurationException.class) {
//				throw new InvalidConfigurationException();
//			}
		}
	}

	public static File setup() {
		File dir = new File("../BerkeleyDb/dbEnv");
		if (!dir.exists()) {
			dir.mkdir();
		}
		return dir;
	}

	public static void tearDown(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				if (logON) {
					// System.out.println("deleting dir: " + file);
				}
				for (File f : file.listFiles()) {
					if (!f.getName().contains("svn")) {
						tearDown(f);
					}
				}
			} else {
				if (logON) {
					// System.out.println("deleting file: " + file);
				}
				file.delete();
			}

		}
	}

}
