import org.junit.Test;


public class TestStack {
	
	@Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void testBoundHit() {
//#if STATISTICS && LOGGING
		int maxSize = 0;
		StatisticObject s = new StatisticObject();
		Stack stack = new Stack(maxSize, s, System.out);
		stack.push("");
//#endif
	}
	
	@Test ()
	public void testPushPop() {
//#if STATISTICS && LOGGING
		int maxSize = 1;
		StatisticObject s = new StatisticObject();
		Stack stack = new Stack(maxSize, s, System.out);
		stack.push("");
		stack.pop();
//#endif
	}
	
	@Test (expected=java.lang.ArrayIndexOutOfBoundsException.class)
	public void testPushPopPop() {
//#if STATISTICS && LOGGING
		int maxSize = 1;
		StatisticObject s = new StatisticObject();
		Stack stack = new Stack(maxSize, s, System.out);
		stack.push("");
		stack.pop();
		stack.pop();
//#endif
	}

}
