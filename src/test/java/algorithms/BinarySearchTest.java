package algorithms;

import org.apache.log4j.Logger;

import org.junit.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTest {

	private static Logger logger = Logger.getLogger(BinarySearchTest.class);

	private static List<Integer> list;
	private static Integer element;

	@BeforeClass
	public static void setUpBeforeClass() {

		// create a new sorted list with N elements:
		int N = 20;
		
		list = new ArrayList<Integer>(N);

		for (int i = 0; i < N; i++) {
			list.add(i);
		}
		
		// pick a random element from the list:
		Random rnd = new Random();
		
		element = list.get(rnd.nextInt(N));

		logger.info("Sorted list: " + list);
		logger.info("Element to search for: " + element);
	}

	@Test
	public void testBinarySearch() {
		
		int expected = list.indexOf(element);
		
		int result = BinarySearch.binarySearch(list, element);

		Assert.assertEquals(expected, result);
	}

}
