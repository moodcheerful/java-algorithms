package algorithms;

public class GreatestCommonDivisor {

	/*
	 * Greatest Common Divisor (Euclid's algorithm)
	 * 
	 * Time complexity: O((log b)^2), where b is the smaller number.
	 * 
	 * The Euclidean algorithm is an example of a polynomial time P-problem whose time complexity is
	 * bounded by a quadratic function of the length of the input values (log b - number of digits).
	 */
	public static int gcd(int a, int b) {

		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	/*
	 * Least Common Multiple of 2 integers
	 * 
	 * Algorithm: lcm(a, b) * gcd(a, b) = a * b
	 * 
	 * Proof:
	 * Let prime factorization for x = 2^j0 * 3^j1 * 5^j2 * 7^j3 * 11^j4 * ... 
	 * Let prime factorization for y = 2^k0 * 3^k1 * 5^k2 * 7^k3 * 11^k4 * ... 
	 * gcd(x, y) = 2^min(j0, k0) * 3^min(j1, k1) * 5^min(j2, k2) * 7^min(j3, k4) * 11^min(j4, k4) * ... 
	 * lcm(x, y) = 2^max(j0, k0) * 3^max(j1, k1) * 5^max(j2, k2) * 7^max(j3, k4) * 11^max(j4, k4) * ... 
	 * Therefore, gcd(x, y) * lcm(x, y) = x * y
	 */
	public static int lcm(int a, int b) {

		if (a == 0 && b == 0) {
			return 0;
		}
		return a * b / gcd(a, b);
	}
}