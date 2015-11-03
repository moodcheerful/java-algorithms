package algorithms;

public class DecimalToBinary {

	/*
	 * Algorithm for converting both positive and negative integers from decimal
	 * reprisentation to binary. Constant time complexity.
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
}
