package algorithms;

import java.util.Arrays;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertArrayEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSortTest {

	private final static Logger logger = Logger.getLogger(MergeSortTest.class);

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
	public final void testMergeSort() {

		int[] sortedArray = Arrays.copyOf(shuffledArray, shuffledArray.length);

		MergeSort.mergeSort(sortedArray);

		logger.info("Sorted array: " + Arrays.toString(sortedArray));

		assertArrayEquals("mergeSort works", expectedArray, sortedArray);
	}
}
