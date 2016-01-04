package statistics;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import statistics.ProbabilityDistributionsDiscrete;

import java.util.Arrays;

public class ProbabilityDistributionsDiscreteTest {

	private final static Logger logger = Logger
			.getLogger(ProbabilityDistributionsDiscreteTest.class);

	@Test
	public final void testDiscrete() {

		// the probability mass function of a discrete probability distribution:
		double[] probability = new double[] { 0.3, 0.2, 0.1, 0.1, 0.3 };

		int N = 1000;
		double delta = 0.1;

		int[] count = new int[probability.length];
		double[] percentOfValues = new double[probability.length];

		for (int i = 0; i < N; i++) {
			// generate a random integer from the discrete distribution:
			int d = ProbabilityDistributionsDiscrete.discrete(probability);
			count[d]++;
		}

		for (int i = 0; i < probability.length; i++) {
			percentOfValues[i] = (double) count[i] / N;
		}

		logger.info("probability: " + Arrays.toString(probability));
		logger.info("percent of values: " + Arrays.toString(percentOfValues));

		Assert.assertArrayEquals(probability, percentOfValues, delta);
	}

	@Test
	public final void testBernoulliMatrix() {

		int N = 1000; // matrix length
		double p = 0.2; // Bernoulli probability bias
		// generate a random boolean matrix from the Bernoulli distribution:
		boolean[][] matrix = ProbabilityDistributionsDiscrete.bernoulliMatrix(N, p);
		int counter = 0;
		double delta = 0.1;

		for (int i = 0; i < N; i++) {
			// logger.info(Arrays.toString(matrix[i]));
			for (int j = 0; j < N; j++) {
				if (matrix[i][j]) {
					counter++;
				}
			}
		}
		// percent of values that are true:
		double percentOfTrue = (double) counter / Math.pow(N, 2);
		logger.info("bias: " + p + "; percent of values that are true: " + percentOfTrue);

		Assert.assertTrue(Math.abs(p - percentOfTrue) <= delta);
	}
}