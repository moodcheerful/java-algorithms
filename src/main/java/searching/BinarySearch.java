package searching;

import java.util.List;

public class BinarySearch {

	/*
	 * BinarySearch algorithm of searching for an element in a SORTED list.
	 * 
	 * Time complexity is O(log n).
	 * 
	 * List<T> list must be sorted in ascending order.
	 */
	public static <T extends Comparable<T>> int binarySearch(List<T> list, T element) {

		int low = 0;

		int high = list.size() - 1;

		while (low <= high) {

			// the correct way to calculate average (low + high)/2 to avoid overflow 
			// to a negative value for large integers when the sum 
			// (low + high) > Integer.MAX_VALUE = 2^31 - 1. Another way:
			// int mid = (low + high) >>> 1;
			int mid = low + (high - low) / 2;

			int comp = element.compareTo(list.get(mid));

			if (comp < 0) {
				high = mid - 1;
			} else if (comp > 0) {
				low = mid + 1;
			} else {
				// element found:
				return mid;
			}
		}
		return -1;
	}
}
