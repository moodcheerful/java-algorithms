package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

//import org.junit.runners.MethodSorters;
//import org.junit.FixMethodOrder;

// Unit tests should be order independent:
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SelectKthSmallestTest {

	private final static Logger logger = Logger.getLogger(SelectKthSmallestTest.class);

	private static String[] originalArray;
	private static String[] shuffledArray;

	private static int randomIndex;
	private static String expectedElement;

	@BeforeClass
	public static void setUpBeforeClass() {
		
		originalArray = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };
		logger.info("Original array: " + Arrays.toString(originalArray));
		
		Random random = new Random();		
		randomIndex = random.nextInt(originalArray.length);
		expectedElement = originalArray[randomIndex];
		logger.info(randomIndex + "-th smallest element to select: " + expectedElement);
		
		shuffledArray = Arrays.copyOf(originalArray, originalArray.length);
		Collections.shuffle(Arrays.asList(shuffledArray));		
		logger.info("Shuffled array: " + Arrays.toString(shuffledArray));
	}

	@Test
	public final void testSelectKthSmallest() {
			
			String result = SelectKthSmallest.quickSelect(shuffledArray, randomIndex);
			logger.info("Selected element: " + result);
			
			Assert.assertEquals("SelectKthSmallest works", expectedElement, result);			
	}
	
	@Test
	// Slow sort (O(n^2)) using quickSelect algorithm n times:
	public final void testSort() {
		
		String[] sortedArray = new String[shuffledArray.length];
		
		for (int i = 0; i < shuffledArray.length; i++) {
			
			sortedArray[i] = SelectKthSmallest.quickSelect(shuffledArray, i);
		}
		logger.info("Sorted array: " + Arrays.toString(sortedArray));
	
		Assert.assertArrayEquals(originalArray, sortedArray);
	}
}
