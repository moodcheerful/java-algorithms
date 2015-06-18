package algorithms;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Assert;
import org.apache.log4j.Logger;

public class MaintainingMedianTest {
	
	private final static Logger logger = Logger.getLogger(MaintainingMedianTest.class);
		
	@Test
	public void testMaintainingMedian() {
		
		int[] sequence = new int[]{1, 7, 4, 10, 0, -4, 6};
		double[] expectedRunningMedian = new double[]{1, 4, 4, 5.5, 4, 2.5, 4};	
		
		MaintainingMedian mm = new MaintainingMedian();
		double[] result = new double[sequence.length];
		
		for (int i = 0; i < sequence.length; i++) {		
			
			mm.addNumber(sequence[i]);
			result[i] = mm.getMedian();
		}
		logger.info("sequence: " + Arrays.toString(sequence));
		logger.info("expected: " + Arrays.toString(expectedRunningMedian));
		logger.info("result: " + Arrays.toString(result));
		
		Assert.assertArrayEquals(expectedRunningMedian, result, 0);
	}
}
