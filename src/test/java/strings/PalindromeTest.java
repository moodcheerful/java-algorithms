package strings;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import strings.Palindrome;

public class PalindromeTest {

	private final static Logger logger = Logger.getLogger(PalindromeTest.class);

	@Test
	public final void testIsPalindrome() {

		String[] palindromes = { "", "A", "radar", 
				"A man, a plan, a canal - Panama!", 
				"Amor, Roma", 
				"race car", 
				"stack cats", 
				"Step on no pets.", 
				"Put it up!", 
				"Was it a car or a cat I saw?", 
				"No 'x' in Nixon.",
				"Cigar? Toss it in a can. It is so tragic.",
				"Dammit, I'm mad!", 
				"Desserts, I stressed!", 
				"Live not on evil.", 
				"Lonely Tylenol.",
				"Never odd or even.",
				"No lemon, no melon.",
				"Do geese see God?",
				"A Toyota's a Toyota.",
				"A Santa lived as a devil at NASA.",
				"123321"};

		String[] notPalindromes = { "To be, or not to be, that is the question." };

		for (String phrase : palindromes) {
			logger.info("palindrome: " + phrase);
			Assert.assertTrue(Palindrome.isPalindrome(phrase));
		}
		for (String phrase : notPalindromes) {
			logger.info("not palindrome: " + phrase);
			Assert.assertFalse(Palindrome.isPalindrome(phrase));
		}
	}
}
