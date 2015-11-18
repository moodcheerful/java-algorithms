package algorithms;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class RomanToArabicTest {

	private final static Logger logger = Logger.getLogger(RomanToArabicTest.class);

	@Test
	public void testRomanToArabic() {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("IXX", 19);
		map.put("DXLIX", 549);
		map.put("MCMXCIV", 1994);
		map.put("MMXVI", 2016);
		map.put("MMMCMXCIX", 3999);
		// alternative form:
		map.put("viiii", 9);

		for (Map.Entry<String, Integer> el : map.entrySet()) {

			int expected = el.getValue();
			int result = RomanToArabic.romanToArabic(el.getKey());
			logger.info("Roman: " + el.getKey() + ", expected: " + expected + ", result: " + result);

			Assert.assertEquals(expected, result);
		}
	}
}
