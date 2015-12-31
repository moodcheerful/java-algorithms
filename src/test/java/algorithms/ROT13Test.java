package algorithms;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.Test;

public class ROT13Test {

	private final static Logger logger = Logger.getLogger(ROT13Test.class);

	@Test
	public final void testROT13() {

		String input = "The Quick Brown Fox Jumps Over The Lazy Dog.";

		String encrypted = ROT13.rot13(input);
		// ROT13 is its own inverse:
		String decrypted = ROT13.rot13(encrypted);

		logger.info("input: " + input);
		logger.info("encrypted: " + encrypted);
		logger.info("decrypted: " + decrypted);

		Assert.assertTrue(input.equals(decrypted));
	}
}
