package algorithms;

/*
 * Algorithm to check if a string is a palindrome.
 * Time complexity is O(n), where n is the length of the string.
 * 
 * A palindrome is a word, phrase, number, or other sequence of characters,
 * which reads the same backward or forward.
 * 
 * Allowances are made for adjustments to capital letters, punctuation, and word dividers. 
 * 
 * Examples of palindromes:
 * 
 * 		"A man, a plan, a canal - Panama!", 
 * 		"Amor, Roma", 
 * 		"race car", 
 * 		"stack cats", 
 * 		"Step on no pets.", 
 * 		"Put it up!", 
 * 		"Was it a car or a cat I saw?", 
 * 		"No 'x' in Nixon.",
 * 		"Cigar? Toss it in a can. It is so tragic.",
 * 		"Dammit, I'm mad!", 
 * 		"Desserts, I stressed!", 
 * 		"Live not on evil.", 
 * 		"Lonely Tylenol.",
 * 		"Never odd or even.",
 * 		"No lemon, no melon.",
 * 		"Do geese see God?",
 * 		"A Toyota's a Toyota.",
 * 		"A Santa lived as a devil at NASA." 
 */
public class Palindrome {

	public static boolean isPalindrome(String phrase) {

		int leftIndex = 0;
		int rightIndex = phrase.length() - 1;

		// scan towards the middle, adjusting the left and right indexes:
		while (leftIndex < rightIndex) {

			// skip punctuation and word dividers:
			while (!Character.isLetterOrDigit(phrase.charAt(leftIndex))) {
				leftIndex++;
			}
			while (!Character.isLetterOrDigit(phrase.charAt(rightIndex))) {
				rightIndex--;
			}

			// ignore capital letter case:
			char l = Character.toLowerCase(phrase.charAt(leftIndex));
			char r = Character.toLowerCase(phrase.charAt(rightIndex));

			// if letters are not equal, this is not a palindrome:
			if (l != r) {
				return false;
			}

			leftIndex++;
			rightIndex--;
		}
		return true;
	}
}
