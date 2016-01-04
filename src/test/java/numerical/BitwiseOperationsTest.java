package numerical;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

import numerical.BitwiseOperations;

public class BitwiseOperationsTest {

	private static Logger logger = Logger.getLogger(BitwiseOperationsTest.class);

	@Test
	public void testGetBit() {

		int number = -1;
		int position = 32;
		int expected = 1;

		int result = BitwiseOperations.getBit(number, position);

		logger.info("binary number: " + Integer.toBinaryString(number) + ", getBit() at position " + position + " = "
				+ result);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void testSetBit() {

		int number = Integer.valueOf("10011101", 2);
		int position = 1;
		int expected = Integer.valueOf("10011111", 2);

		int result = BitwiseOperations.setBit(number, position);

		logger.info("binary number: " + Integer.toBinaryString(number) + ", setBit() at position " + position + " = "
				+ Integer.toBinaryString(result));

		Assert.assertEquals(expected, result);
	}

	@Test
	public void testToggleBit() {

		int number = Integer.valueOf("10011101", 2);
		int position = 3;
		int expected = Integer.valueOf("10010101", 2);

		int result = BitwiseOperations.toggleBit(number, position);

		logger.info("binary number: " + Integer.toBinaryString(number) + ", toggleBit() at position " + position + " = "
				+ Integer.toBinaryString(result));

		Assert.assertEquals(expected, result);
	}

	@Test
	public void testClearBit() {

		int number = Integer.valueOf("10011101", 2);
		int position = 3;
		int expected = Integer.valueOf("10010101", 2);

		int result = BitwiseOperations.clearBit(number, position);

		logger.info("binary number: " + Integer.toBinaryString(number) + ", clearBit() at position " + position + " = "
				+ Integer.toBinaryString(result));

		Assert.assertEquals(expected, result);
	}

	@Test
	public void testClearBitsMSBtoI() {

		int number = Integer.valueOf("10011101", 2);
		int position = 3;
		int expected = Integer.valueOf("00000101", 2);

		int result = BitwiseOperations.clearBitsMSBtoI(number, position);

		logger.info("binary number: " + Integer.toBinaryString(number) + ", clearBitsMSBtoI() from MSB to position "
				+ position + " = " + Integer.toBinaryString(result));

		Assert.assertEquals(expected, result);
	}

	@Test
	public void testClearBitsItoLSB() {

		int number = Integer.valueOf("10011101", 2);
		int position = 3;
		int expected = Integer.valueOf("10010000", 2);

		int result = BitwiseOperations.clearBitsItoLSB(number, position);

		logger.info("binary number: " + Integer.toBinaryString(number) + ", clearBitsItoLSB() from LSB to position "
				+ position + " = " + Integer.toBinaryString(result));

		Assert.assertEquals(expected, result);
	}

	@Test
	public void testUpdateBit() {

		int number = Integer.valueOf("10011101", 2);
		int position = 3;
		int value = 0;
		int expected = Integer.valueOf("10010101", 2);

		int result = BitwiseOperations.updateBit(number, position, value);

		logger.info("binary number: " + Integer.toBinaryString(number) + ", updateBit() at position " + position + " = "
				+ Integer.toBinaryString(result));

		Assert.assertEquals(expected, result);
	}
}
