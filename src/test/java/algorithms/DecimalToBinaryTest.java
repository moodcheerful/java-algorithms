package algorithms;

import org.apache.log4j.Logger;

import org.junit.*;

public class DecimalToBinaryTest {

	private static Logger logger = Logger.getLogger(DecimalToBinaryTest.class);

	@Test
	public void testDecimalToBinary() {

		int[] numbers = { Integer.MIN_VALUE, Integer.MIN_VALUE + 1, -2, -1, 0,
				1, 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE };

		for (int i = 0; i < numbers.length; i++) {

			String expected = Integer.toBinaryString(numbers[i]);

			String result = DecimalToBinary.decimalToBinary(numbers[i]);

			logger.info("number: " + numbers[i] + ", binary representation: "
					+ result);

			Assert.assertTrue(expected.equals(result));
		}
	}
}
