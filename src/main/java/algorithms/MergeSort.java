package algorithms;

public class MergeSort {

	// Mergesort algorithm (top-down)
	// Time complexity is O(n*log(n))

	public static void mergeSort(int[] a) {
		
		int[] b = new int[a.length];
		sort(a, b, 0, a.length - 1);
	}

	private static void sort(int[] a, int[] b, int lo, int hi) {

		if (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			sort(a, b, lo, mid);
			sort(a, b, mid + 1, hi);
			merge(a, b, lo, mid, hi);
		}
	}

	// stably merge a[lo .. mid] with a[mid+1 ..hi] using b[lo .. hi]
	// precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
	private static void merge(int[] a, int[] b, int lo, int mid, int hi) {

		// copy to b[]
		for (int k = lo; k <= hi; k++) {
			b[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = b[j++]; // this copying is unnecessary
			else if (j > hi)
				a[k] = b[i++];
			else if (b[j] < b[i])
				a[k] = b[j++];
			else
				a[k] = b[i++];
		}
	}
}
