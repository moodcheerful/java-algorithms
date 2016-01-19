package numerical;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrimalityTest {

	private final static Logger logger = Logger.getLogger(PrimalityTest.class);

	private static long[] primes;
	private static long[] notPrimes;

	@BeforeClass
	public static void setupBeforeClass() {

		primes = new long[] { 2, 3, 5, 7, 11, 97, 
				997, // biggest 3 digit prime
				999983, // biggest 6 digit prime
				999999937, // biggest 9 digit prime
				Integer.MAX_VALUE, // biggest Java int prime = 2147483647 (10 digits)
				999999999989L, // biggest 12 digit prime
				9999999999971L, // biggest 13 digit prime
				99999999999973L, // biggest 14 digit prime
				999999999999989L, // biggest 15 digit prime
				9999999999999937L, // biggest 16 digit prime
				99999999999999997L, // biggest 17 digit prime
				999999999999999989L, // biggest 18 digit prime
				9223372036854775783L // biggest Java long prime < Long.MAX_VALUE (19 digits)
		};

		notPrimes = new long[] { -3, 0, 1, 4, 6, 9, 100, Long.MAX_VALUE };
	}

	@Test
	public final void testIsPrime() {

		for (long n : primes) {

			long startTime = System.currentTimeMillis();
			boolean isPrime = Primality.isPrime(n);
			long stopTime = System.currentTimeMillis();

			int numberOfDigits = String.valueOf(n).length();
			logger.info(numberOfDigits + "-digit prime: " + n + ", time: "
					+ (stopTime - startTime));

			Assert.assertTrue(isPrime);
		}

		for (long n : notPrimes) {

			boolean isPrime = Primality.isPrime(n);
			logger.info("not prime: " + n);

			Assert.assertFalse(isPrime);
		}
	}
}
