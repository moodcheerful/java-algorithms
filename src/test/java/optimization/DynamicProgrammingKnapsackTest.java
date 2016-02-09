package optimization;

import java.util.Arrays;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import optimization.DynamicProgrammingKnapsack;

public class DynamicProgrammingKnapsackTest {

	private final static Logger logger = Logger.getLogger(DynamicProgrammingKnapsackTest.class);

	private static int W;
	private static int N;
	private static int[] weigth;
	private static int[] value;
	private static DynamicProgrammingKnapsack knapsack;
	private static int maxValue;
	private static boolean[] takeItem;
	private static int[][] maxValueTable;

	@BeforeClass
	public static void setupBeforeClass() {

		W = 6;
		N = 4;
		weigth = new int[] { 4, 3, 2, 3 };
		value = new int[] { 3, 2, 4, 4 };

		knapsack = new DynamicProgrammingKnapsack(W, N, weigth, value);

		maxValue = 8;
		takeItem = new boolean[] { false, false, true, true };

		maxValueTable = new int[W + 1][N + 1];
		maxValueTable[0] = new int[] { 0, 0, 0, 0, 0 };
		maxValueTable[1] = new int[] { 0, 0, 0, 0, 0 };
		maxValueTable[2] = new int[] { 0, 0, 0, 4, 4 };
		maxValueTable[3] = new int[] { 0, 0, 2, 4, 4 };
		maxValueTable[4] = new int[] { 0, 3, 3, 4, 4 };
		maxValueTable[5] = new int[] { 0, 3, 3, 6, 8 };
		maxValueTable[6] = new int[] { 0, 3, 3, 7, 8 };
	}

	@Test
	public final void testMaxValue() {

		int result = knapsack.maxValue();
		logger.info("maxValue: " + maxValue + ", result: " + result);
		Assert.assertTrue(maxValue == result);
	}

	@Test
	public final void testMemoize() {

		for (int i = 0; i < W + 1; i++) {
			logger.info("maxValueTable[" + i + "]: " + Arrays.toString(maxValueTable[i])
					+ ", result: " + Arrays.toString(knapsack.getMaxValueTable()[i]));
			Assert.assertArrayEquals(maxValueTable[i], knapsack.getMaxValueTable()[i]);
		}
	}

	@Test
	public final void testTakeItem() {

		boolean[] result = knapsack.takeItem();
		logger.info("takeItem: " + Arrays.toString(takeItem) + ", result: "
				+ Arrays.toString(result));
		Assert.assertTrue(Arrays.equals(takeItem, result));
	}
}
