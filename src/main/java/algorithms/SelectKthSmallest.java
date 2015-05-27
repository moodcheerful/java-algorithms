package algorithms;

import java.util.Arrays;
import java.util.Collections;

public class SelectKthSmallest {

	/* Select k-th smallest element of an array using QuickSelect algorithm.
	 * 
	 * While QuickSort time complexity is O(n*log(n)), 
	 * SelectKthSmallest QuickSelect algorithm time complexity is only O(n) 
	 * because we don't have to sort the other partitions of the array,
	 * partitioning has time complexity of O(n) and
	 * Knuth Shuffle algorithm's time complexity is also O(n).
	 * 
	 * The ineffective solution is to sort an array first in O(n*log(n)), 
	 * then select k-th smallest element in one scan, 
	 * which results in O(n*log(n) + n) = O(n*log(n)) runtime.
	 */
		
	public static <T extends Comparable<T>> T quickSelect(T[] a, int k) {

        if (k < 0 || k >= a.length) {
        	throw new IndexOutOfBoundsException("Index of the element to be selected is out of bounds");
        }
        
		Collections.shuffle(Arrays.asList(a));

		return select(a, k);
	}
	
	// Rearrange the array so that a[k] contains the k-th smallest element;
	// a[0] through a[k-1] are <= a[k]; a[k+1] through a[N-1] are >= a[k].
    public static <T extends Comparable<T>> T select(T[] a, int k) {

        int low = 0;
        int high = a.length - 1;
        
        while (high > low) {
        	
            int i = partition(a, low, high);
            
            if (i > k) {
            	high = i - 1;
            } else if (i < k) {
            	low = i + 1;
            } else {
            	return a[i];
            }
        }
        return a[low];
    }

	// partition the subarray a[low..high] so that a[low..j-1] <= a[j] <= a[j+1..high]
	// and return the index j
	private static <T extends Comparable<T>> int partition(T[] a, int low, int high) {
		
		int i = low;
		int j = high + 1;
		
		while (i < j) {

			// find item on the left to swap:
			while (a[low].compareTo(a[++i]) > 0) {
				if (i == high) 
					break;
			}
			
			// find item on the right to swap:
			while (a[low].compareTo(a[--j]) < 0) {
				if (j == low)
					break; 
			}
			
			// check if pointers cross:
			if (i >= j)
				break;

			swap(a, i, j);
		}

		// put partitioning item a[low] at a[j]:
		swap(a, low, j);

		return j;
	}
	
	private static <T extends Comparable<T>> void swap(T[] a, int i, int j) {

		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
