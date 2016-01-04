package optimization;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median Maintenance Algorithm.
 * 
 * Given a sequence {x1, ..., xn} of numbers one-by-one from a data stream, find at each step i the
 * median of {x1, ..., xi}.
 * 
 * Time Complexity: O(log(i)) at each step i.
 * 
 * Solution: maintain 2 heaps, one that supports Extract-Min operation and one that supports
 * Extract-Max, and maintain invariant that maxHeap on the left half holds elements that are less
 * than the effective median, and minHeap on the right half holds elements that are greater than the
 * effective median.
 * 
 */
public class MaintainingMedian {

	private double median; // rolling median of the data stream
	private Queue<Integer> minHeap; // right half (elements >= median)
	private Queue<Integer> maxHeap; // left half (elements <= median)

	public MaintainingMedian() {

		minHeap = new PriorityQueue<Integer>();

		// Java's DEFAULT_INITIAL_CAPACITY for PriorityQueue = 11
		maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
			// reverse Integer comparator
			public int compare(Integer x, Integer y) {
				if (x < y)
					return 1;
				if (x > y)
					return -1;
				return 0;
			}
		});
	}

	public void addNumber(int x) {

		// initialize
		if (minHeap.isEmpty()) {

			// add first element:
			if (maxHeap.isEmpty()) {
				maxHeap.offer(x);
				median = x;

			// add second element:
			} else {
				minHeap.offer(x);
				median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
			}

		// process the rest of the elements:
		} else {

			// step 1: add next element to one of the heaps:
			if (x < maxHeap.peek()) { // O(1)
				maxHeap.offer(x); // O(log(i))
			} else {
				minHeap.offer(x); // O(log(i))
			}

			// step 2: rebalance the heaps:
			if (maxHeap.size() - minHeap.size() > 1) { // O(1)

				Integer extra = maxHeap.poll(); // O(log(i))
				minHeap.offer(extra); // O(log(i))

			} else if (minHeap.size() - maxHeap.size() > 1) {

				Integer extra = minHeap.poll(); // O(log(i))
				maxHeap.offer(extra); // O(log(i))
			}

			// step 3: recalculate median:
			if (minHeap.size() == maxHeap.size()) { // O(1)
				median = (double) (minHeap.peek() + maxHeap.peek()) / 2; // O(1)
			} else if (minHeap.size() > maxHeap.size()) {
				median = minHeap.peek(); // O(1)
			} else {
				median = maxHeap.peek(); // O(1)
			}
		}
	}

	public double getMedian() {
		return median;
	}
}
