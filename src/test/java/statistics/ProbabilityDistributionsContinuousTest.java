package statistics;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import statistics.ProbabilityDistributionsContinuous;

public class ProbabilityDistributionsContinuousTest {

	private final static Logger logger = Logger
			.getLogger(ProbabilityDistributionsContinuousTest.class);

	@Test
	public final void testGaussian() {

		double[] expected = new double[] { 68.27, 95.45, 99.73 };
		double delta = 1;

		double mu = -2; // mean
		double sigma = 1; // standard deviation
		int n = 100000; // sample size

		double[] toleranceInterval = ProbabilityDistributionsContinuous
				.the_68_95_99p7_rule(mu, sigma, n);

		logger.info("\n Percent of values within 1 standard deviation of the mean: "
				+ toleranceInterval[0]);
		logger.info("\n Percent of values within 2 standard deviations of the mean: "
				+ toleranceInterval[1]);
		logger.info("\n Percent of values within 3 standard deviations of the mean: "
				+ toleranceInterval[2]);

		Assert.assertArrayEquals(expected, toleranceInterval, delta);
	}

}