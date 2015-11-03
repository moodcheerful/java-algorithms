package algorithms;

public class BitwiseOperations {

	// get bit at position i of a binary number:
	public static int getBit(int number, int i) {

		// mask 0...010...0 at position i:
		int mask = (1 << i);
		return (((number & mask) != 0) ? 1 : 0);
	}

	// set bit at position i of a binary number to 1:
	public static int setBit(int number, int i) {

		// mask 0...010...0 at position i:
		int mask = (1 << i);
		return number | mask;
	}

	// toggle bit at position i of a binary number:
	public static int toggleBit(int number, int i) {

		// mask 0...010...0 at position i:
		int mask = (1 << i);
		return number ^ mask;
	}

	// clear bit at position i of a binary number (set it to 0):
	public static int clearBit(int number, int i) {

		// mask 1...101...1 at position i:
		int mask = ~(1 << i);
		return number & mask;
	}

	// clear bits of a binary number from leftmost (most significant bit) to
	// position i inclusive:
	public static int clearBitsMSBtoI(int number, int i) {

		// mask 0...01...1 with 0s from MSB to position i inclusive:
		int mask = (1 << i) - 1;
		return number & mask;
	}

	// clear bits of a binary number from position i inclusive to position 0
	// (least significant bit):
	public static int clearBitsItoLSB(int number, int i) {

		// mask 1...10...0 with 0s from position i inclusive to 0:
		int mask = ~(-1 >>> (31 - i));
		return number & mask;
	}

	// update bit at position i of a binary number to value 0 or 1:
	public static int updateBit(int number, int i, int value) {

		// mask 1...101...1 at position i:
		int mask = ~(1 << i);
		return (number & mask) | (value << i);
	}
}
