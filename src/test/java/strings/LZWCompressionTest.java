package strings;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import strings.LZWCompression;

/*
 * LZW compression results:
 * 
 * String s1: compression ratio: 1.50, space savings: 33.33%
 * String s2: compression ratio: 1.92, space savings: 47.92%
 * String s3: compression ratio: 2.40, space savings: 58.33%
 * String s4: compression ratio: 1.53, space savings: 34.83%
 * 
 */
public class LZWCompressionTest {

	private final static Logger logger = Logger.getLogger(LZWCompressionTest.class);

	@Test
	public final void testLZWCompression() {

		String s0 = "";
		String s1 = "TOBEORNOTTOBEORTOBEORNOT";
		String s2 = "TOBEORNOTTOBEORTOBEORNOTTOBEORNOTTOBEORTOBEORNOT";
		String s3 = "TOBEORNOTTOBEORTOBEORNOTTOBEORNOTTOBEORTOBEORNOTTOBEORNOTTOBEORTOBEORNOT";
		String s4 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
				+ "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
				+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
				+ "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in "
				+ "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
				+ "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in "
				+ "culpa qui officia deserunt mollit anim id est laborum.";

		List<String> uncompressedStrings = new ArrayList<String>();
		uncompressedStrings.add(s0);
		uncompressedStrings.add(s1);
		uncompressedStrings.add(s2);
		uncompressedStrings.add(s3);
		uncompressedStrings.add(s4);

		for (String uncompressed : uncompressedStrings) {

			List<Short> compressed = LZWCompression.compress(uncompressed);

			String decompressed = LZWCompression.decompress(compressed);

			logger.info("compressed: " + compressed);
			logger.info("decompressed: " + decompressed);
			logger.info("compression ratio: "
					+ String.format("%.2f", LZWCompression.compressionRatio(uncompressed)));
			logger.info("space savings: "
					+ String.format("%.2f", LZWCompression.spaceSavings(uncompressed)) + "%");

			Assert.assertTrue(uncompressed.equals(decompressed));
		}
	}
}
