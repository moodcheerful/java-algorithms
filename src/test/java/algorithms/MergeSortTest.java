package algorithms;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

import static org.junit.Assert.assertArrayEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSortTest {

	private final static Logger logger = Logger.getLogger(MergeSortTest.class);

	private static List<Integer> expectedList;
	private static List<Integer> shuffledList;

	@BeforeClass
	public static void setUpBeforeClass() {

		expectedList = new ArrayList<Integer>(Arrays.asList(-5, -1, 0, 2, 2, 5, 7, 100));
		
		shuffledList = new ArrayList<Integer>(expectedList);
		Collections.shuffle(shuffledList);
		
		logger.info("Expected list: " + expectedList);
		logger.info("Shuffled list: " + shuffledList);
	}

	@Test
	public final void testMergeSort() {

			MergeSort sorter = new MergeSort();
			
			List<Integer> sortedList = sorter.mergeSort(shuffledList);			
			logger.info("Sorted list: " + sortedList);
			
			assertArrayEquals("mergeSort works", expectedList.toArray(), sortedList.toArray());
	}
}
