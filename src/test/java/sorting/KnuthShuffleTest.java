package sorting;

import java.util.Arrays;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import sorting.KnuthShuffle;

public class KnuthShuffleTest {
			
	private final static Logger logger = Logger.getLogger(KnuthShuffleTest.class);

	@Test
	public void testShuffleArray() {
	
		int[] initial = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int[] shuffled = Arrays.copyOf(initial, initial.length);
		
		KnuthShuffle.shuffleArray(shuffled);

		logger.info("Initial array: " + Arrays.toString(initial));		
		logger.info("Shuffled array: " + Arrays.toString(shuffled));	
		
		Assert.assertFalse(Arrays.equals(initial, shuffled));
	}
}
