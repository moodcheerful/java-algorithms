package strings;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import strings.ROT13Cipher;

public class ROT13CipherTest {

	private final static Logger logger = Logger.getLogger(ROT13CipherTest.class);

	@Test
	public final void testROT13() {

		String input = "The Quick Brown Fox Jumps Over The Lazy Dog.";

		String encrypted = ROT13Cipher.rot13(input);
		// ROT13 is its own inverse:
		String decrypted = ROT13Cipher.rot13(encrypted);

		logger.info("input: " + input);
		logger.info("encrypted: " + encrypted);
		logger.info("decrypted: " + decrypted);

		Assert.assertTrue(input.equals(decrypted));
	}
}
