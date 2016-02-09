package optimization;

/*
 * The 0/1 Knapsack Dynamic Programming Algorithm.
 * 
 * Given a set of N items, each with a weight and a value, along with a maximum 
 * weight capacity W, determine which items to take so that the total weight <= W 
 * and the total value is as large as possible. Assume all weights are positive.
 * 
 * Time Complexity: O(N * W)
 *
 */
public class DynamicProgrammingKnapsack {

	private int W; // knapsack weight capacity
	private int N; // number of items
	private int[] weigth; // weight of items
	private int[] value; // value of items

	// maxValueTable[w][i] = max value of packing item 0,...,i-1 with weight limit w
	// maxValueTable item indexes are off by 1 from value, weigth and takeItem() arrays:
	private int[][] maxValueTable;

	public DynamicProgrammingKnapsack(int W, int N, int[] weigth, int[] value) {
		this.W = W;
		this.N = N;
		this.weigth = weigth;
		this.value = value;
		this.maxValueTable = new int[W + 1][N + 1];

		memoize();
	}

	private void memoize() {

		// maxValueTable item indexes are off by 1 from value and weigth arrays:
		for (int i = 1; i < N + 1; i++) {
			for (int w = 0; w < W + 1; w++) {
				if (weigth[i - 1] <= w) {
					// option 1: do not take item i
					int option1 = maxValueTable[w][i - 1];
					// option 2: take item i
					int option2 = value[i - 1] + maxValueTable[w - weigth[i - 1]][i - 1];
					// select better of the two options:
					maxValueTable[w][i] = Math.max(option1, option2);
				} else {
					// do not take item i:
					maxValueTable[w][i] = maxValueTable[w][i - 1];
				}
			}
		}
	}

	// return max value of the knapsack:
	public int maxValue() {
		return maxValueTable[W][N];
	}

	// reconstruct from maxValueTable the subset of items to take to achieve max value:
	public boolean[] takeItem() {

		boolean[] takeItem = new boolean[N];
		int w = W;
		// maxValueTable item indexes are off by 1:
		for (int i = N; i > 0; i--) {
			if (maxValueTable[w][i] == maxValueTable[w][i - 1]) {
				// item i is not in max value subset:
				takeItem[i - 1] = false;
			} else {
				// item i is in max value subset:
				takeItem[i - 1] = true;
				w = w - weigth[i - 1];
			}
		}
		return takeItem;
	}

	public int[][] getMaxValueTable() {
		return maxValueTable;
	}
}
