package net.test;

import java.io.IOException;



public class TestAll {
	
	/**
	 * Run each test according to the number.
	 */
	public static void runTest(int test) {
		switch(test){
			case 1:
				test1();
				break;
			case 2:
				test2();
				break;
			
			default:
				throw new RuntimeException("This test does not exist");
		}
	}
	
	public static void test1() {
		try {
			ZipMETest.main(new String[]{});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ZipMETest.cleanup();
		}
	}
	
	public static void test2() {
		try {
			GZIPTest.main(new String[]{});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			GZIPTest.cleanup();
		}
	}
	
	
}
			
			