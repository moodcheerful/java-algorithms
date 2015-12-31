package algorithms;

/*
 * ROT13 ("rotate by 13 places") is a simple letter substitution cipher 
 * that replaces a letter with the letter 13 letters after it in the alphabet. 
 * ROT13 is a special case of the Caesar cipher.
 * 
 * Because there are 26 letters (2×13) in the English alphabet, ROT13 is its own inverse:
 * the same algorithm is used for encoding and decoding.
 * 
 * The algorithm provides virtually no cryptographic security, 
 * and is a canonical example of weak encryption, mostly used for obscuring text data:
 * "Usenet equivalent of a magazine printing the answer to a quiz upside down."
 * 
 * Linear time complexity.
 * 
 * One-liner in bash:
 * echo "The Quick Brown Fox Jumps Over The Lazy Dog" | tr 'A-Za-z' 'N-ZA-Mn-za-m'
 * 
 */
public class ROT13 {

	public static String rot13(String input) {

		StringBuilder sb = new StringBuilder(input.length());

		for (int i = 0; i < input.length(); i++) {

			char c = input.charAt(i);

			// rotate lower case letters:
			if (c >= 'a' && c <= 'm') {
				c = (char) (c + 13); 	// c += 13;
			} else if (c > 'm' && c <= 'z') {
				c = (char) (c - 13); 	// c -= 13;
			// rotate upper case letters:
			} else if (c >= 'A' && c <= 'M') {
				c = (char) (c + 13); 	// c += 13;
			} else if (c > 'M' && c <= 'Z') {
				c = (char) (c - 13); 	// c -= 13;
			}
			sb.append(c);
		}
		return sb.toString();
	}
}