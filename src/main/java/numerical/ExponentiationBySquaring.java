package numerical;

/*
 * Exponentiation by Squaring algorithm (also known as Binary Exponentiation).
 * 
 * Assumption: result (x to the power n) can be represented as a long value.
 * 
 * Time complexity: O(log n),
 * since the number of operations is floor(log<sub>2</sub>n) squarings plus 
 * at most floor(log<sub>2</sub>n) multiplications.
 * 
 * More precisely:
 * number of squarings: 1 less than the number of binary digits in n,
 * number of multiplications: 1 less than the number of 1s in the same binary expansion of n.
 * 
 */
public class ExponentiationBySquaring {

	// return x to the power n:
	public static long powerRecursive(long x, int n) {

		if (n < 0) {
			return powerRecursive(1 / x, -n);
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n % 2 == 0) {
			return powerRecursive(x * x, n / 2);
		} else { // n is odd
			return x * powerRecursive(x * x, (n - 1) / 2);
		}
	}

	// return x to the power n:
	public static long powerIterative(long x, int n) {

		if (n < 0) {
			return powerIterative(1 / x, -n);
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		long y = 1;
		while (n > 1) {
			if (n % 2 != 0) {
				y = y * x;
				// n = n - 1; // redundant
			}
			x = x * x;
			n = n / 2;
		}
		y = y * x;
		return y;
	}
}
