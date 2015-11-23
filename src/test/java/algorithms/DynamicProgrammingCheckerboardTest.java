package algorithms;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/*
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
 * 	Shortest Path: (2,0) -> (1,1) -> (0,2) -> (0,3) -> (0, 4)
 * 
 */
public class DynamicProgrammingCheckerboardTest {

	private static final Logger logger = Logger.getLogger(DynamicProgrammingCheckerboardTest.class);

	private static int[][] cost;
	private static DynamicProgrammingCheckerboard dpc;

	@BeforeClass
	public static void setupBeforeClass() {

		cost = new int[5][5];

		cost[0] = new int[] { 2, 3, 0, 4, 1 };
		cost[1] = new int[] { 2, 1, 1, 0, 2 };
		cost[2] = new int[] { 0, 2, 7, 3, 2 };
		cost[3] = new int[] { 1, 3, 1, 1, 4 };
		cost[4] = new int[] { 0, 3, 4, 3, 0 };

		dpc = new DynamicProgrammingCheckerboard(cost);

		logger.info("cost: " + dpc.printBoard(cost));
	}

	@Test
	public void testMinCost() {

		int r = 4;
		int c = 0;
		int expected = 2;
		int result = 0;

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {

			result = dpc.minCost(r, c);
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;

		logger.info("recursive execution time = " + executionTime);
		logger.info("expected = " + expected + ", minCost = " + result);

		Assert.assertTrue(expected == result);
	}

	@Test
	public void testComputeShortestPath() {

		int[] expected = new int[] { 2, 1, 0, 0, 0 };
		int[] result = new int[5];

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {

			result = dpc.computeShortestPath();
		}
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;

		logger.info("dynamic programming execution time = " + executionTime);
		logger.info("expected = " + Arrays.toString(expected) + ", shortestPath = "
				+ Arrays.toString(result));

		Assert.assertArrayEquals(expected, result);
	}

	@Test
	public void testPathCost() {

		dpc.computeShortestPath();

		logger.info("pathCost: " + dpc.printBoard(dpc.getPathCost()));
		logger.info("predecessor: " + dpc.printBoard(dpc.getPredecessor()));

		int expected = 2;
		int result = dpc.getPathCost()[4][0];

		Assert.assertTrue(expected == result);
	}
}
