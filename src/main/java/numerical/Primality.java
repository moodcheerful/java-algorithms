package numerical;

/*
 * Primality Testing - Trial Division Algorithm.
 * 
 * Optimizations:
 * 1. All primes are of the form 6k ± 1, except 2 and 3.
 * 2. Test for divisors up to sqrt(n) instead of n.
 *
 * Time complexity: O(n^1/2)
 * 
 * Note 1: 
 * If the primality testing algorithm has to be run multiple times, further 
 * optimization is possible by first computing and caching a prime sieve for k = srqt(n), 
 * and then only checking for prime divisors of n from the sieve.
 * Using sieve will result in longer run time for a single run, since
 * Sieve of Eratosthenes time complexity is O(k log(log k)), which for k = srqt(n) 
 * is bigger than O(srqt(n)) time complexity of the simple trial division algorithm.
 * 
 * Note 2:
 * Trial division is a deterministic algorithm (determines for sure whether a number is prime or not).
 * Non-deterministic (probabilistic) algorithms much more efficient than trial division 
 * have been devised to test the (probable) primality of large numbers. 
 * Probabilistic algorithms never report a prime number as composite, 
 * but it is possible for a composite number to be reported as prime 
 * within a certain probability of error.
 * 1. Fermat primality test (a compositeness test)
 * 2. Miller–Rabin primality test (fast, but has a small probability of error)
 * 3. AKS primality test (fast deterministic test)
 * 
 * Timing tests:
 * 997, // biggest 3 digit prime
 * 999983, // biggest 6 digit prime
 * 999999937, // biggest 9 digit prime
 * Integer.MAX_VALUE, // biggest Java int prime = 2147483647 (10 digits)
 * 999999999989L, // biggest 12 digit prime
 * 9999999999971L, // biggest 13 digit prime
 * 99999999999973L, // biggest 14 digit prime
 * 999999999999989L, // biggest 15 digit prime
 * 9999999999999937L, // biggest 16 digit prime
 * 99999999999999997L, // biggest 17 digit prime
 * 999999999999999989L, // biggest 18 digit prime
 * 9223372036854775783L // biggest Java long prime < Long.MAX_VALUE (19 digits)
 *
 */
public class Primality {
	
	// return true if n is prime, false if n is composite:
	public static boolean isPrime(long n) {

		// a prime number should be greater than 1:
		if (n <= 1) {
			return false;
		}
		// 2 and 3 are prime:
		if (n == 2 || n == 3) {
			return true;
		}
		// eliminate multiples of 2 and 3:
		if ((n % 2 == 0) || (n % 3 == 0)) {
			return false;
		}
		// numbers remaining to test are of the form 6*k ± 1:
		long upperBound = (long) Math.sqrt(n);
		for (long i = 6; i <= upperBound; i = i + 6) {
			if ((n % (i - 1) == 0) || (n % (i + 1) == 0)) {
				return false;
			}
		}
		return true;
	}
}
