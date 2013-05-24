import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;


public class MyTestRunner {

	final static Map<String, String> testStatus = new HashMap<String, String>(); 

	public static void main(String[] args) throws InitializationError, IOException, ClassNotFoundException {

		/***
		 * configuration we are running this test against 
		 ***/
		String configuration = System.getProperty("configuration");
		if (configuration == null) {
			System.err.println("inform list of features");
			System.exit(1);
		}
		
		/***
		 * the number of the testsuite necessary to distinguish 
		 * between test cases with the same name from different
		 * runs.
		 ***/
		String evosuiteNumber = System.getProperty("evosuite.number");
		if (evosuiteNumber == null) {
			System.err.println("missing evosuite number");
			System.exit(1);
		}
		
		/***
		 * test.files stores the name of the file containing
		 * the fully-qualified name of all test classes.  
		 ***/
		String inputFileName = System.getProperty("tests.file");
		if (inputFileName == null) {
		  System.err.println("parameter -Dtests.file not defined");
		  System.exit(1);
		}
		
		/**
		 * reading input file
		 */
		File f = new File(inputFileName);
		if (!f.exists()) {
			System.err.printf("Could not find file %d\n", inputFileName);
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(new FileReader(f));
		String s;
		while ((s = br.readLine())!=null) {
			// remove trailing .class
			s = s.substring(0, s.indexOf(".class"));
			// remove leading ./
			s = s.substring(s.indexOf("./")+2);
			// replace / with .
			s = s.replace('/', '.');
			Class<?> clazz = Class.forName(s);
			// running test case
			runTestClass(clazz);
		}
		// closing file with list of test cases
		br.close();
		
		for (Map.Entry<String, String> entry : testStatus.entrySet()) {
			String testName = entry.getKey();
			String status = entry.getValue();
			System.out.printf("%s:%s %s %s\n", evosuiteNumber, testName, status, configuration);
		}
		
	}

	private static void runTestClass(final Class<?> theClass) throws InitializationError {

		final RunNotifier notifier = new RunNotifier();

		notifier.addListener(
				new RunListener() {
					boolean pass = true;
					@Override
					public void testFailure(Failure failure) throws Exception {
						pass = false;
					}
					@Override
					public void testFinished(Description desc) {
						String key = theClass.getName();
						if (testStatus.containsKey(key)) {
							throw new RuntimeException("KEY ALREADY USED. CHECK!");
						}
						testStatus.put(key, pass?"PASS":"FAIL");
					}
				}
				);

		final Runner runner = new BlockJUnit4ClassRunner(theClass);

		runner.run(notifier);

	}

}
