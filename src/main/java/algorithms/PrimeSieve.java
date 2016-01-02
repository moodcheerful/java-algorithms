package algorithms;

/*
 * The Sieve of Eratosthenes algorithm for generating prime numbers <= n.
 *  
 * A prime number is a natural number greater than 1 that has exactly two divisors: 
 * 1 and itself.
 * 
 * Time complexity is O(n log(log n)), 
 * since number of iterations is
 * = n + n/2 + n/3 + n/5 + n/7 + n/11 + ... + n/p = 
 * = n * (1 + 1/2 + 1/3 + 1/5 + 1/7 + 1/11 + ... + 1/p), 
 * = n * sum of reciprocals of primes up to p = Math.sqrt(n), 
 * and the prime harmonic series asymptotically approaches log(log n).
 * 
 */
public class PrimeSieve {

	// return an array of prime numbers <= n:
	public static int[] primeSieve(int n) {

		// isNonPrime[i] = true when i is a composite number:
		boolean[] isNonPrime = new boolean[n + 1];
		// for consistency with the definition of a prime:
		isNonPrime[0] = true;
		isNonPrime[1] = true;

		// mark non-primes <= n using Sieve of Eratosthenes:
		for (int i = 2; i * i <= n; i++) {
			// If i is prime (hasn't been crossed off in prior iterations),
			// cross off all multiples of i.
			// We can start with (i * i), because the numbers (i * k), where k < i,
			// have already been crossed off in prior iterations.
			if (!isNonPrime[i]) {
				for (int k = i; i * k <= n; k++) {
					isNonPrime[i * k] = true;
				}
			}
		}

		// collect all primes from the boolean[] isNonPrime array:
		int[] primes = outputPrimes(isNonPrime);

		return primes;
	}

	// return int[] array of primes given a boolean[] array of crossed-off non-primes:
	public static int[] outputPrimes(boolean[] isNonPrime) {

		// count primes:
		int count = 0;
		for (int i = 2; i < isNonPrime.length; i++) {
			if (!isNonPrime[i]) {
				count++;
			}
		}
		int[] primes = new int[count];
		// add primes to the output array:
		int counter = 0;
		for (int i = 2; i < isNonPrime.length; i++) {
			if (!isNonPrime[i]) {
				primes[counter] = i;
				counter++;
			}
		}
		return primes;
	}
}
