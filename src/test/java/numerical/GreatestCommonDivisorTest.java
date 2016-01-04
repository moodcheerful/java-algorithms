package numerical;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import numerical.GreatestCommonDivisor;

public class GreatestCommonDivisorTest {

	private final static Logger logger = Logger.getLogger(GreatestCommonDivisorTest.class);

	@Test
	public final void testGCD() {

		int a = 10;
		int b = 4;
		int expected = 2;

		int result = GreatestCommonDivisor.gcd(a, b);
		logger.info("a = " + a + ", b = " + b + ", greatest common divisor = " + result);

		Assert.assertEquals(expected, result);
	}

	@Test
	public final void testLCM() {

		int a = 10;
		int b = 4;
		int expected = 20;

		int result = GreatestCommonDivisor.lcm(a, b);
		logger.info("a = " + a + ", b = " + b + ", least common multiple = " + result);

		Assert.assertEquals(expected, result);
	}
}
