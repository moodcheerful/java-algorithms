package algorithms;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

	// QuickSort algorithm
	// Time complexity is O(n*log(n))

	public static void quickSort(String[] a) {

		Collections.shuffle(Arrays.asList(a));

		sort(a, 0, a.length - 1);
	}

	// quicksort the subarray from a[lo] to a[hi]:
	private static void sort(String[] a, int lo, int hi) {

		if (lo < hi) {

			int i = partition(a, lo, hi);
			sort(a, lo, i - 1);
			sort(a, i + 1, hi);
		}
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j
	private static int partition(String[] a, int lo, int hi) {
		
		int i = lo;
		int j = hi + 1;
		
		while (i < j) {

			// find item on the left to swap:
			while (a[lo].compareTo(a[++i]) > 0) {
				if (i == hi) 
					break;
			}
			
			// find item on the right to swap:
			while (a[lo].compareTo(a[--j]) < 0) {
				if (j == lo)
					break; 
			}
			
			// check if pointers cross:
			if (i >= j)
				break;

			swap(a, i, j);
		}

		// put partitioning item a[lo] at a[j]:
		swap(a, lo, j);

		return j;
	}
	
	private static void swap(String[] a, int i, int j) {

		String tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
