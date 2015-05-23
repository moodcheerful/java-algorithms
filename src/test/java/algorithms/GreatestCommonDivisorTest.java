package algorithms;

import org.junit.Assert;
import org.junit.Test;

public class GreatestCommonDivisorTest {

	@Test
	public final void testGCD() {

		int a = 10;
		int b = 4;
		int expected = 2;

		Assert.assertEquals(expected, GreatestCommonDivisor.gcd(a, b));
	}
}
