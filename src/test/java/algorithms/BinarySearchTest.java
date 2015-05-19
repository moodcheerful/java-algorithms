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
	
	private static List<Character> list2;
	private static Character element2;

	@BeforeClass
	public static void setUpBeforeClass() {

		// create a new sorted list with n integers:
		int n = 20;		
		list = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		
		// pick a random element from the list:
		Random rnd = new Random();		
		element = list.get(rnd.nextInt(n));

		logger.info("Sorted list: " + list);
		logger.info("Element to search for: " + element);
		
		// create a new sorted list2:	
		int n2 = 26;
		list2 = new ArrayList<Character>(n2);	
		for (char ch = 'a'; ch <= 'z'; ch++) {			
			list2.add(ch);
		}
		
		// pick a random character from the list:		
		element2 = list2.get(rnd.nextInt(n2));

		logger.info("Sorted list2: " + list2);
		logger.info("Element to search for: " + element2);
	}

	@Test
	public void testBinarySearch() {
		
		int expected = list.indexOf(element);
		
		int result = BinarySearch.binarySearch(list, element);

		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void testBinarySearch2() {
		
		int expected = list2.indexOf(element2);
		
		int result = BinarySearch.binarySearch(list2, element2);

		Assert.assertEquals(expected, result);
	}

}
