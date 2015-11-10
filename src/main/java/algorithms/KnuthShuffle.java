package algorithms;

import java.util.Random;

public class KnuthShuffle {

	/*
	 * Knuth shuffle algorithm (the modern version of Fisher–Yates shuffle algorithm).
	 * 
	 * Rearranges an array of integers in random order.
	 * 
	 * Time complexity is O(n).
	 */
	public static void shuffleArray(int[] array) {

		Random random = new Random();

		int n = array.length;

		for (int i = 0; i < n; i++) {

			// choose index randomly in [i, n)
			int randomIndex = i + random.nextInt(n - i);

			// swap array[i] and array[randomIndex]
			int temp = array[i];
			array[i] = array[randomIndex];
			array[randomIndex] = temp;
		}
	}
}
