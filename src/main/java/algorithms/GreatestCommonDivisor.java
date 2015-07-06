package algorithms;

public class GreatestCommonDivisor {
	
	// Greatest Common Divisor (Euclid's algorithm)
	//
	// Time complexity: O((log b)^2), where b is the smaller number.
	//
	// The Euclidean algorithm is an example of a polynomial time P-problem whose time complexity is 
	// bounded by a quadratic function of the length of the input values (log b - number of digits). 
	
	public static int gcd(int a, int b) {
		
		   if (b == 0) return a;
		   
		   return gcd(b, a % b);
	}
}