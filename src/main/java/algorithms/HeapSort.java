package algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {

	// HeapSort algorithm
	// Time complexity is O(n*log(n))
	//
	// Step 1. Heap construction (linear time). 
	// The largest element of the heap is stored at index 1.
	// Proceed from right to left, using sink() to make subheaps as we go. 
	//
	// Step 2. Sortdown.
	// A sorted array is built from right to left by repeatedly removing the largest remaining element
	// (the root of the heap, stored at index 1), and inserting it into position vacated as the heap shrinks.
	// Then the remaining heap is updated after each removal to maintain the heap property.
	
	
	public static <T extends Comparable<T>> void heapSort(T[] heap) {
		
		int N = heap.length;
		
		// Step 1. Heap construction:
		for (int k = N/2; k >= 1; k--) {
			
			sink(heap, k, N);
		}

		// Step 2. Sortdown:
		while (N > 1) {
			
			swap(heap, 1, N);
			N--;
			sink(heap, 1, N);
		}
	}

	// Sink-based heap construction is linear time
	private static <T extends Comparable<T>> void sink(T[] heap, int k, int N) {
		
		while (2*k <= N) {
			
			int i = 2*k;
			
			if (i < N && less(heap, i, i + 1)) {
				i++;
			}
			if (!less(heap, k, i)) {
				break;
			}
			swap(heap, k, i);
			k = i;
		}
	}

	// Indexes are "off-by-one" to support 1-based heap indexing
	private static <T extends Comparable<T>> boolean less(T[] heap, int i, int j) {
		
		return heap[i - 1].compareTo(heap[j - 1]) < 0;
	}

	// Indexes are "off-by-one" to support 1-based heap indexing
	private static void swap(Object[] heap, int i, int j) {
		
		Object tmp = heap[i - 1];
		heap[i - 1] = heap[j - 1];
		heap[j - 1] = tmp;
	}
	
	// The artificial solution: double the memory use by creating a new PriorityQueue and 
	// let Java Collections API do its sorting
	public static <T extends Comparable<T>> void heapSortPriorityQueue(T[] c) {
		
	    Queue<T> queue = new PriorityQueue<T>(Arrays.asList(c));
	    
	    for (int i = 0; i < c.length; i++) {
	    	c[i] = queue.remove();
	    }
	}
}
