package algorithms;

public class DecimalToBinary {

	/*
	 * The Divide by 2 algorithm for converting integers (both positive and negative) 
	 * from decimal to binary. Constant time complexity.
	 * 
	 * For decimal n represented as abcd in base 2:
	 * n = a*2^3 + b*2^2 + c*2^1 + d*2^0 = 2*(a*2^2 + b*2^1 + c*2^0) + d = 
	 * = 2 * floor(n / 2) + (n % 2)
	 * 
	 */
	public static String decimalToBinary(int decimal) {

		String binary = "";
		int lsb; // least significant bit

		for (int i = 0; i < 32; i++) {

			lsb = decimal & 1; // decimal % 2
			binary = lsb + binary;
			decimal = decimal >> 1; // floor(decimal / 2)

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

			if (binary.charAt(n - i - 1) == '1') {

				decimal = decimal | (1 << i);
			}
		}
		return decimal;
	}
}
