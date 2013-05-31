package de.susebox.test;

import de.susebox.jtopas.CustomTestLargeSource;

public class TestAll {

	public static void main(String[] args){
		try {
			runTest(1);
			runTest(2);
			runTest(3);
			runTest(4);
			runTest(5);
			runTest(6);
			runTest(7);
			runTest(8);
			runTest(9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void runTest(int test) throws Exception {
		// running tests with the input
		// Tests 1-9 are the same tests used on the Shared Execution paper.
		switch (test) {
		case 1:
			test1();// Many comments
			break;
		case 2:
			test2();// Many comments
			break;
		case 3:
			test3();// Many comments
			break;
		case 4:
			test4();// Some comments
			break;
		case 5:
			test5();// Some comments
			break;
		case 6:
			test6();// Some comments
			break;
		case 7:
			test7();// No comments
			break;
		case 8:
			test8();// No comments
			break;
		case 9:
			test9();// No comments
			break;
//		case 10:
//			SEFTestPatternMatching.main(null);
//			break;
//		case 11:
//			SEFTestDifficultSituations.main(null);
//			break;
//		case 12:
//			SEFTestTextAccess.main(null);
//			break;
//		case 13:
//			SEFTestTokenizerSource.main(null);
//			break;
//		case 14:
//			SEFTestLargeSource.main(null);
//			break;
//		case 15:
//			SEFTestTokenizerProperties.main(null);
//			break;
//		case 16:
//			SEFTestEmbeddedTokenizer.main(null);
//			break;
		default:
			System.err.println("Test " + test + " does not exist");
			System.exit(0);
		}
		
	}

	private static void test1() throws Exception {
		CustomTestLargeSource.setTestId(1);
		CustomTestLargeSource.main(null);
	}

	private static void test2() throws Exception {
		CustomTestLargeSource.setTestId(2);
		CustomTestLargeSource.main(null);
	}

	private static void test3() {
		CustomTestLargeSource.setTestId(3);
		CustomTestLargeSource.main(null);
	}

	private static void test4() {
		CustomTestLargeSource.setTestId(4);
		CustomTestLargeSource.main(null);
	}

	private static void test5() {
		CustomTestLargeSource.setTestId(5);
		CustomTestLargeSource.main(null);
	}

	private static void test6() {
		CustomTestLargeSource.setTestId(6);
		CustomTestLargeSource.main(null);
	}

	private static void test7() {
		CustomTestLargeSource.setTestId(7);
		CustomTestLargeSource.main(null);
	}

	private static void test8() {
		CustomTestLargeSource.setTestId(8);
		CustomTestLargeSource.main(null);
	}

	private static void test9() {
		CustomTestLargeSource.setTestId(9);
		CustomTestLargeSource.main(null);
	}

}
