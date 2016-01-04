package numerical;

import java.util.HashMap;
import java.util.Map;

/*
 * Algorithm to convert Roman numerals to Arabic:
 * 
 * The values of the letters are added up except when a letter of smaller value is followed 
 * by a letter of larger value, then the smaller value is subtracted from the larger value.
 * 
 * MCMXCIV = M + CM + XC + IV = 1000 + (1000 - 100) + (100 - 10) + (5 - 1) = 1994
 * 
 */
public class RomanToArabic {

	// Assume input string is a valid Roman numeral
	public static int romanToArabic(String roman) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int arabic = 0;
		int i = 0;
		roman = roman.toUpperCase();

		while (i < roman.length()) {

			int current = map.get(roman.charAt(i));
			i++;

			// at the end of the string:
			if (i == roman.length()) {
				arabic = arabic + current;
			} else {

				int next = map.get(roman.charAt(i));

				// the group of 2 characters:
				if (current < next) {
					arabic = arabic + (next - current);
					i++;
				// 1 character:
				} else {
					arabic = arabic + current;
				}
			}
		}
		return arabic;
	}
}
