package numerical;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Assumption: result can be represented as a long value.
 * 
 * The biggest long that can be stored in a double without losing precision 
 * is 2^53, since an IEEE 64-bit double has 52 bits of mantissa.
 * 
 */
public class ExponentiationBySquaringTest {

	private final static Logger logger = Logger
			.getLogger(ExponentiationBySquaringTest.class);

	private static int x;
	private static int n;

	@BeforeClass
	public static void setupBeforeClass() throws Exception {

		x = -2;
		n = 53;

		// validate input parameters:
		double d = Math.pow(x, n);
		if (Math.abs(d) > Math.pow(2, 53)) {
			throw new IllegalArgumentException("invalid JUnit test input");
		}
	}

	@Test
	public final void testPowerRecursive() {

		long expected = (long) Math.pow(x, n);
		long result = ExponentiationBySquaring.powerRecursive(x, n);
		logger.info("expected = " + expected + ", powerRecursive = " + result);
		Assert.assertTrue(expected == result);
	}

	@Test
	public final void testPowerIterative() {

		long expected = (long) Math.pow(x, n);
		long result = ExponentiationBySquaring.powerIterative(x, n);
		logger.info("expected = " + expected + ", powerIterative = " + result);
		Assert.assertTrue(expected == result);
	}
}
