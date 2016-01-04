package numerical;

import java.util.Arrays;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import numerical.PrimeSieve;

public class PrimeSieveTest {

	private final static Logger logger = Logger.getLogger(PrimeSieveTest.class);

	@Test
	public final void testPrimeSieve() {

		int n = 100;

		int[] primes100 = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
				47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

		int[] result = PrimeSieve.primeSieve(n);

		logger.info("expected: " + Arrays.toString(primes100));
		logger.info("result  : " + Arrays.toString(result));

		Assert.assertArrayEquals(primes100, result);
	}
}
