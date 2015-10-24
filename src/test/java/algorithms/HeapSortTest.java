package algorithms;

import java.util.Arrays;
import java.util.Collections;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertArrayEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class HeapSortTest {

	private final static Logger logger = Logger.getLogger(HeapSortTest.class);

	private static String[] expectedArray;
	private static String[] shuffledArray;

	@BeforeClass
	public static void setUpBeforeClass() {

		expectedArray = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

		shuffledArray = Arrays.copyOf(expectedArray, expectedArray.length);

		Collections.shuffle(Arrays.asList(shuffledArray));

		logger.info("Expected array: " + Arrays.toString(expectedArray));
		logger.info("Shuffled array: " + Arrays.toString(shuffledArray));
	}

	@Test
	public final void testHeapSort() {

		String[] sortedArray = Arrays.copyOf(shuffledArray, shuffledArray.length);

		HeapSort.heapSort(sortedArray);

		logger.info("Sorted array: " + Arrays.toString(sortedArray));

		assertArrayEquals("heapSort works", expectedArray, sortedArray);
	}
}
