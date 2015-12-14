package algorithms;

import java.util.Random;

/*
 * Algorithm for computing a random double number from a Gaussian distribution 
 * using the polar form of the Box-Muller transform.
 * Time complexity: O(1)
 * 
 * The standard normal distribution: 
 * a Gaussian distribution with the mean 0 and the standard deviation 1.
 * 
 * The 68–95–99.7 rule (or the 3-sigma rule): 
 * the percentage of values that lie within 1, 2 and 3 standard deviations of the mean 
 * in a Gaussian distribution (68.27, 95.45, 99.73).
 * 
 */
public class ProbabilityDistributionsContinuous {

	// return a random double number from the standard normal distribution
	// (a Gaussian distribution with the mean 0 and the standard deviation 1):
	public static double normal() {

		// compute Gaussian using the polar form of the Box-Muller transform:
		double x = 0;
		double y = 0;
		double r = 0;
		Random random = new Random();

		while ((r >= 1) || (r == 0)) {

			// random double numbers x and y uniformly in (-1, 1):
			x = -1 + 2 * random.nextDouble();
			y = -1 + 2 * random.nextDouble();

			r = x * x + y * y;
		}

		// independent random Gaussian:
		double gaussian = x * Math.sqrt(-2 * Math.log(r) / r);

		return gaussian;
	}

	// return a random double number from a Gaussian distribution with given
	// mean mu and standard deviation sigma:
	public static double gaussian(double mu, double sigma) {

		return mu + sigma * normal();
	}

	// Given the mean μ, the standard deviation σ and sample size n of a
	// Gaussian distribution, return percent of values within 1, 2 and 3
	// standard deviations of the mean:
	public static double[] the_68_95_99p7_rule(double mu, double sigma, int n) {

		// percent of values within 1, 2 and 3 standard deviations of the mean:
		double[] toleranceInterval = new double[3];

		int counter1 = 0; // μ ± σ
		int counter2 = 0; // μ ± 2σ
		int counter3 = 0; // μ ± 3σ

		for (int i = 0; i < n; i++) {

			double value = gaussian(mu, sigma);

			if ((value > mu - sigma) && (value < mu + sigma)) {
				counter1++;
			} else if ((value > mu - 2 * sigma) && (value < mu + 2 * sigma)) {
				counter2++;
			} else if ((value > mu - 3 * sigma) && (value < mu + 3 * sigma)) {
				counter3++;
			}
		}

		toleranceInterval[0] = (double) counter1 * 100 / n;
		toleranceInterval[1] = (double) (counter1 + counter2) * 100 / n;
		toleranceInterval[2] = (double) (counter1 + counter2 + counter3) * 100 / n;

		return toleranceInterval;
	}

}
