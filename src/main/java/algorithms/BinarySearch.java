package algorithms;

import java.util.List;

public class BinarySearch {

	// BinarySearch algorithm of searching for an element in a SORTED list
	// Time complexity is O(log n)

	// List<T> list must be sorted in ascending order
	public static <T extends Comparable<T>> int binarySearch(List<T> list, T element) {

		int low = 0;
		
		int high = list.size() - 1;

		while (low <= high) {
			
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
