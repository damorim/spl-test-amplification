import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;


public class MyTestRunner {
  
  public static void main(String[] args) throws InitializationError {
    
    runTestClass(SampleTest.class /* REPLACE THIS WITH A LIST OF FILES PASSED ON PARAMETER */);

  }

  private static void runTestClass(Class<?> theClass) throws InitializationError {
    final RunNotifier notifier = new RunNotifier();
    
    notifier.addListener(
        new RunListener() {
          @Override
          public void testFailure(Failure failure) throws Exception {
            System.out.printf("%s fails", failure.getTestHeader());
          }
        }
    );

    final Runner runner = new BlockJUnit4ClassRunner(theClass);

    runner.run(notifier);
  }

  

}
