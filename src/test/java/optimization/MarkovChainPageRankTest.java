package optimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import optimization.MarkovChainPageRank;

public class MarkovChainPageRankTest {

	public static final Logger logger = Logger.getLogger(MarkovChainPageRankTest.class);

	/**
	 * 	State space of N = 5 webpages, 9 links:
	 * 
	 * 	 |-------[4]-------|
	 *   |        ^        |
	 *   |        |        |
	 *   V        |        V
	 *  [0]----->[1]====>>[2]
	 *           |||       
	 *           |||
	 *           VVV
	 *           [3]
	 *           
	 */

	private static int N; // number of pages
	private static List<List<Integer>> pageLinks;

	@BeforeClass
	public static void setupBeforeClass() {

		N = 5;

		pageLinks = new ArrayList<List<Integer>>();

		pageLinks.add(Arrays.asList(0, 1));
		pageLinks.add(Arrays.asList(1, 2));
		pageLinks.add(Arrays.asList(1, 2));
		pageLinks.add(Arrays.asList(1, 3));
		pageLinks.add(Arrays.asList(1, 3));
		pageLinks.add(Arrays.asList(1, 3));
		pageLinks.add(Arrays.asList(1, 4));
		pageLinks.add(Arrays.asList(4, 0));
		pageLinks.add(Arrays.asList(4, 2));

		logger.info("\n pageLinks: " + pageLinks);
	}

	@Test
	public void testComputeTransitionMatrix() {

		MarkovChainPageRank mcpr = new MarkovChainPageRank(N, pageLinks);

		double[][] transitionMatrix = mcpr.getTransitionMatrix();

		String[] expectedFirstRow = new String[] { "0.03", "0.88", "0.03",
				"0.03", "0.03" };

		String[] firstRow = new String[N];

		DecimalFormat formatter = new DecimalFormat("0.00");
		for (int i = 0; i < N; i++) {
			firstRow[i] = formatter.format(transitionMatrix[0][i]);
		}

		logger.info("expectedFirstRow: " + Arrays.toString(expectedFirstRow));
		logger.info("firstRow: " + Arrays.toString(firstRow));
		logger.info("outDegree: " + Arrays.toString(mcpr.getOutDegree()));
		logger.info("\n linkCounts: " + mcpr.printMatrix(mcpr.getLinkCounts()));
		logger.info("\n transitionMatrix: " + mcpr.printMatrix(transitionMatrix));

		Assert.assertArrayEquals(expectedFirstRow, firstRow);
	}

	@Test
	public void testRandomSurfer() {

		MarkovChainPageRank mcpr = new MarkovChainPageRank(N, pageLinks);

		// the number of moves that the random surfer makes:
		int[] iterations = new int[] { 1, 2, 3, 4, 5, 10, 20, 30, 40, 50, 60,
				70, 80, 90, 100, 200, 300, 500, 1000 };

		double[] pageRank = new double[5];

		for (int i = 0; i < iterations.length; i++) {

			int M = iterations[i];

			pageRank = mcpr.randomSurfer(M);

			logger.info("M = " + String.format("%1$4d", M) + ", pageRank: "
					+ mcpr.printArray(pageRank));
		}
		Assert.assertTrue(pageRank[3] > pageRank[4]);
	}

	@Test
	public void testMarkovChain() {

		MarkovChainPageRank mcpr = new MarkovChainPageRank(N, pageLinks);

		// test how many iterations are needed until a Markov chain converges 
		// to within a tolerable limit:
		int[] iterations = new int[] { 1, 2, 3, 4, 5, 10, 20, 30, 40, 50, 60,
				70, 80, 90, 100, 200, 300, 500, 1000 };

		double[] pageRank = new double[5];

		for (int i = 0; i < iterations.length; i++) {

			int M = iterations[i];

			pageRank = mcpr.markovChain(M);

			logger.info("M = " + String.format("%1$4d", M) + ", pageRank: "
					+ mcpr.printArray(pageRank));
		}
		Assert.assertTrue(pageRank[3] > pageRank[4]);
	}
}