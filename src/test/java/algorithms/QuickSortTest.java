package algorithms;

import java.util.Arrays;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertArrayEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortTest {

	private final static Logger logger = Logger.getLogger(QuickSortTest.class);

	private static int[] expectedArray;
	private static int[] shuffledArray;

	@BeforeClass
	public static void setUpBeforeClass() {

		expectedArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		shuffledArray = Arrays.copyOf(expectedArray, expectedArray.length);

		KnuthShuffle.shuffleArray(shuffledArray);
		
		logger.info("Expected array: " + Arrays.toString(expectedArray));
		logger.info("Shuffled array: " + Arrays.toString(shuffledArray));
	}

	@Test
	public final void testQuickSort() {

			int[] sortedArray = Arrays.copyOf(shuffledArray, shuffledArray.length);

			QuickSort.quickSort(sortedArray);
			
			logger.info("Sorted array: " + Arrays.toString(sortedArray));

			assertArrayEquals("quickSort works", expectedArray, sortedArray);
	}
}
