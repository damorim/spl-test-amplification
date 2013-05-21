import org.junit.Test;


public class TestStack {
	
	@Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
	//#if STATISTICS || LOGGING
	public void testBoundHit() {		
		int maxSize = 0;
		StatisticObject s = new StatisticObject();
		Stack stack = new Stack(maxSize, s, System.out);
		stack.push("");
	}
	//#endif
	
	@Test ()
	//#if STATISTICS && LOGGING
	public void testPushPop() {		
		int maxSize = 1;
		StatisticObject s = new StatisticObject();
		Stack stack = new Stack(maxSize, s, System.out);
		stack.push("");
		stack.pop();
	}
	//#endif
	
	@Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
	//#if STATISTICS && LOGGING
	public void testPushPopPop() {		
		int maxSize = 1;
		StatisticObject s = new StatisticObject();
		Stack stack = new Stack(maxSize, s, System.out);
		stack.push("");
		stack.pop();
		stack.pop();
	}
	//#endif

}
