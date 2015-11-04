package algorithms;

import org.apache.log4j.Logger;

import org.junit.*;

public class DecimalToBinaryTest {

	private static Logger logger = Logger.getLogger(DecimalToBinaryTest.class);

	private static int[] decimals;

	@BeforeClass
	public static void setupBeforeClass() {

		decimals = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE + 1, -3, -2,
				-1, 0, 1, 2, 3, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
	}

	@Test
	public void testDecimalToBinary() {

		for (int i = 0; i < decimals.length; i++) {

			String expected = Integer.toBinaryString(decimals[i]);

			String result = DecimalToBinary.decimalToBinary(decimals[i]);

			logger.info("decimal: " + decimals[i] + ", binary: " + result);

			Assert.assertTrue(expected.equals(result));
		}
	}

	@Test
	public void testBinaryToDecimal() {

		for (int i = 0; i < decimals.length; i++) {

			int expected = decimals[i];

			int result = DecimalToBinary.binaryToDecimal(Integer.toBinaryString(expected));

			logger.info("binary: " + Integer.toBinaryString(expected)
					+ ", decimal: " + result);

			Assert.assertEquals(expected, result);
		}
	}
}
