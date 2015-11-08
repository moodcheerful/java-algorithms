package algorithms;

public class DecimalToBinary {

	/*
	 * The Divide by 2 algorithm for converting integers (both positive and negative) 
	 * from decimal to binary. 
	 * 
	 * Constant time complexity since n is bounded by Integer.MAX_VALUE = 2^31 - 1.
	 * If n was a arbitrary precision unbounded integer, complexity would be O(M(n) * log(n)),
	 * where M(n) is complexity of multiplication.
	 * 
	 * For a decimal number n, represented in base 2 as abcd:
	 * n = a * 2^3 + b * 2^2 + c * 2^1 + d * 2^0 = 
	 * = 2 * (a * 2^2 + b * 2^1 + c * 2^0) + d = 
	 * = 2 * (n >> 1) + (n & 1) =
	 * = 2 * (n / 2) + (n % 2), if n >= 0
	 * 
	 * Example for n < 0: n = -3 = 2 * (-2) + 1 = 2 * (-3 >> 1) + (-3 & 1),
	 * since -3 % 2 = -1, -3 & 1 = 1, -3 / 2 = -1, -3 >> 1 = -2
	 * 
	 */
	public static String decimalToBinary(int decimal) {

		String binary = "";
		int lsb; // least significant bit

		for (int i = 0; i < 32; i++) {

			lsb = decimal & 1; // decimal % 2, if n >= 0
			binary = lsb + binary;
			decimal = decimal >> 1; // decimal / 2, if n >= 0

			// positive decimals will break out of the for loop
			// before 32 iterations
			if (decimal == 0) {
				break;
			}
		}
		return binary;
	}

	/*
	 * Algorithm for converting binary to decimal integers (both positive and negative).
	 * Constant time complexity.
	 * 
	 * 11011001 = (1 * 2^7) + (1 * 2^6) + (1 * 2^4) + (1 * 2^3) + (1 * 2^0) = 
	 * 			=	1 << 7 | 1 << 6 | 1 << 4 | 1 << 3 | 1 << 0
	 */
	public static int binaryToDecimal(String binary) {

		int decimal = 0;
		int n = binary.length(); // n <= 32

		for (int i = 0; i < n; i++) {

			// read binary string from right to left:
			if (binary.charAt(n - i - 1) == '1') {

				decimal = decimal | (1 << i);
			}
		}
		return decimal;
	}

	/*
	 * Algorithm for converting binary to decimal integers (both positive and negative).
	 * The "reverse" of the divide by 2 algorithm. Constant time complexity.
	 */ 
	public static int binaryToDecimal_v2(String binary) {

		int decimal = 0;
		int n = binary.length(); // n <= 32

		for (int i = 0; i < n; i++) {

			// read binary string from left to right:
			decimal = (decimal << 1) + (binary.charAt(i) == '1' ? 1 : 0);
		}
		return decimal;
	}
}
