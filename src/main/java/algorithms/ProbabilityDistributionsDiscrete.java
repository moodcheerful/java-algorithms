package algorithms;

import java.util.Random;

/*
 * 1. Discrete distribution.
 * 
 * Algorithm for generating a random integer from a Discrete distribution 
 * with the given probability mass function over a set of n possible values.
 * 
 * Time complexity: O(n)
 * 
 * 2. Bernoulli distribution.
 * 
 * Algorithm for generating a random boolean matrix from a Bernoulli distribution 
 * with a given bias p.
 * 
 * Time complexity: O(n^2)
 * 
 * The Bernoulli distribution is the probability distribution of a random 
 * variable which takes the value 1 with success probability of p and 
 * the value 0 with failure probability of q = 1 - p. 
 * 
 * Bernoulli distribution is the outcome of a single Bernoulli trial 
 * (e.g. success/failure, yes/no, head/tail event). 
 * In particular, unfair coins would have p != 0.5.
 * 
 */
public class ProbabilityDistributionsDiscrete {

	// return a random integer from a discrete distribution with
	// the probability mass function given by an array probability[]
	public static int discrete(double[] probability) {

		// validate input array:
		double sum = 0;
		for (int i = 0; i < probability.length; i++) {
			if (probability[i] < 0) {
				throw new IllegalArgumentException(
						"probability[" + i + "] must be nonnegative: " + probability[i]);
			}
			sum = sum + probability[i];
		}

		double DELTA = 1E-14;
		if ((sum < 1.0 - DELTA) || (sum > 1.0 + DELTA)) {
			throw new IllegalArgumentException(
					"sum of probability values does not approximately equal 1.0: " + sum);
		}

		Random random = new Random();

		while (true) {

			sum = 0;
			// generate a random double in [0, 1):
			double r = random.nextDouble();

			for (int i = 0; i < probability.length; i++) {

				sum = sum + probability[i];
				if (sum > r) {
					// found integer i where cumulative distribution function
					// CDF(i - 1) <= r < CDF(i):
					return i;
				}
			}
		}
	}

	// return a random boolean matrix from a Bernoulli distribution
	// with a given bias p:
	public static boolean[][] bernoulliMatrix(int N, double p) {

		if ((p < 0) || (p >= 1)) {
			throw new IllegalArgumentException("Probability must be in [0,1) range.");
		}

		boolean[][] bernoulliMatrix = new boolean[N][N];
		Random random = new Random();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bernoulliMatrix[i][j] = (random.nextDouble() < p);
			}
		}
		return bernoulliMatrix;
	}
}
