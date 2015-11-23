package algorithms;

import java.util.Arrays;

/*
 * Dynamic Programming - Checkerboard
 * 
 * Consider a checkerboard with N × N squares and a cost-function cost(i, j), 
 * which returns a cost associated with square (i, j) (i being the row, j being the column). 
 * 
 *    +---+---+---+---+---+
 *  4 | 0 | 3 | 4 | 3 | 0 |
 *    +---|---|---|---|---+
 *  3 | 1 | 3 | 1 | 1 | 4 |
 *    +---|---|---|---|---+
 *  2 | 0 | 2 | 7 | 3 | 2 |
 *    +---|---|---|---|---+
 *  1 | 2 | 1 | 1 | 0 | 2 |
 *    +---|---|---|---|---+
 *  0 | 2 | 3 | 0 | 4 | 1 |
 *    +---+---+---+---+---+
 *      0   1   2   3   4
 * 
 * The checker starts at any square on the bottom row and moves up to one of the 3 squares:
 * immediately forward or diagonally left or right forward.
 * That is, a checker on (1, 3) can only move to (2, 2), (2, 3) or (2, 4).
 * 
 * Problem: Find the shortest path (path with the minimum sum of the costs 
 * of the visited squares) to get to the top row. 
 * 
 * Shortest path for the checkerboard above: (2,0) -> (1,1) -> (0,2) -> (0,3) -> (0, 4)
 *  
 * Solution 1 - Recursive
 * 
 * Recursively compute from top to bottom a function minCost(i, j) where:
 * minCost(i, j) = the minimum cost to reach square (i, j).
 * Inefficient solution of exponential time complexity, 
 * since we are recomputing the same shortest paths over and over. 
 * 
 * Solution 2 - Dynamic Programming
 * 
 * The problem exhibits optimal substructure (the solution to the entire problem relies 
 * on solutions to subproblems). To avoid recomputation, compute it in a bottom-up fashion 
 * by caching (memoizing) path-costs in a two-dimensional array pathCost[i, j] 
 * rather than using recursion. 
 * 
 * Time complexity is O(n^2).
 * 
 */
public class DynamicProgrammingCheckerboard {

	private int[][] cost;
	private int N;

	// path cost array for memoization:
	private int[][] pathCost;
	// predecessor array to store where paths came from:
	private int[][] predecessor;
	// path with lowest cost (array elements being the columns, their indexes being the rows):
	private int[] shortestPath;

	public DynamicProgrammingCheckerboard(int[][] cost) {
		this.cost = cost;
		this.N = cost[0].length;
		this.pathCost = new int[N][N];
		this.predecessor = new int[N][N];
		this.shortestPath = new int[N];
	}

	// inefficient recursive solution of exponential time complexity:
	public int minCost(int r, int c) {

		int min = 0;

		// out of bounds:
		if (c < 0 || c > N - 1) {
			min = Integer.MAX_VALUE;
		// first row:
		} else if (r == 0) {
			min = cost[r][c];
		} else {
			min = Math.min(Math.min(minCost(r - 1, c - 1), minCost(r - 1, c)),
					minCost(r - 1, c + 1)) + cost[r][c];
		}
		return min;
	}

	// memoization of pathCost array:
	private void memoizePathCost() {

		int left, center, right, min;

		// first row:
		for (int c = 0; c < N; c++) {
			pathCost[0][c] = cost[0][c];
		}
		for (int r = 1; r < N; r++) {
			for (int c = 0; c < N; c++) {

				// left border:
				if (c == 0) {
					left = Integer.MAX_VALUE;
					right = pathCost[r - 1][c + 1];
				// right border:
				} else if (c == N - 1) {
					left = pathCost[r - 1][c - 1];
					right = Integer.MAX_VALUE;
				} else {
					left = pathCost[r - 1][c - 1];
					right = pathCost[r - 1][c + 1];
				}
				center = pathCost[r - 1][c];

				// compute pathCost:
				min = Math.min(Math.min(left, center), right);
				pathCost[r][c] = min + cost[r][c];

				// compute predecessor:
				if (min == left) {
					predecessor[r][c] = -1;
				} else if (min == center) {
					predecessor[r][c] = 0;
				} else {
					predecessor[r][c] = 1;
				}
			}
		}
	}

	// Dynamic Programming solution:
	public int[] computeShortestPath() {

		memoizePathCost();

		int minIndex = 0;
		int min = pathCost[N - 1][minIndex];

		// find element with lowest pathCost in top row:
		for (int i = 1; i < N; i++) {

			if (pathCost[N - 1][i] < min) {
				minIndex = i;
				min = pathCost[N - 1][i];
			}
		}

		// compute shortest path to that element:
		computePathTo(N - 1, minIndex);

		return shortestPath;
	}

	// compute path with lowest cost to a given square:
	private void computePathTo(int r, int c) {

		shortestPath[r] = c;
		if (r == 1) {
			shortestPath[r - 1] = c + predecessor[r][c];
		} else {
			// recursive call:
			computePathTo(r - 1, c + predecessor[r][c]);
		}
	}

	// return a string representation of a 2-dimensional board:
	public String printBoard(int[][] board) {

		StringBuilder sb = new StringBuilder();
		String NEWLINE = System.lineSeparator();
		sb.append(NEWLINE);

		for (int i = N - 1; i >= 0; i--) {
			sb.append(Arrays.toString(board[i])).append(NEWLINE);
		}
		return sb.toString();
	}

	public int[][] getPathCost() {
		return pathCost;
	}

	public int[][] getPredecessor() {
		return predecessor;
	}

	public int[] getShortestPath() {
		return shortestPath;
	}
}
