package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
 * LZW compression algorithm.
 * 
 * Lempel–Ziv–Welch (LZW) compression is a lossless data compression algorithm, 
 * used in GIF, TIFF, and Unix compress.
 * 
 * Original LZW encoded sequences of 8-bit data as fixed-length 12-bit codes, 
 * using dictionary with 4K (2^12) entries, first 256 (0-255) were ASCII codes.
 * 
 * In this implementation, I encode 16-bit characters as 16-bit shorts,
 * using initial dictionary of 256 ASCII characters.
 * 
 * Time complexity: O(n), where n is the input length.
 * 
 * Possible improvements:
 * Since input/output Stream classes in java.io package are bytes rather than bits based,
 * we need to use an external library or custom implemented Binary Stream classes,
 * to reduce the codeword length from 16-bit shorts to 12 bits, which will result in 
 * additional 25% compression ratio improvement.
 * 
 * Compressions:
 * LZW: fixed length code for variable length strings.
 * Huffman: variable length code for fixed length symbols. 
 * 
 */
public class LZWCompression {

	// number of input chars:
	public static final short INITIAL_DICTIONARY_SIZE = 256;

	public static List<Short> compress(String uncompressed) {

		// build initial dictionary:
		Map<String, Short> dictionary = new HashMap<String, Short>();
		for (short i = 0; i < INITIAL_DICTIONARY_SIZE; i++) {
			dictionary.put("" + (char) i, i);
		}

		List<Short> compressed = new ArrayList<Short>();
		String w = "";
		short dictionarySize = INITIAL_DICTIONARY_SIZE;

		// read each character in the input string:
		for (char c : uncompressed.toCharArray()) {

			String wc = w + c;
			// find the longest string w in the dictionary that matches the
			// current input:
			if (dictionary.containsKey(wc)) {
				w = wc;
			} else {
				// add w followed by the next character c in the input to the
				// dictionary:
				dictionary.put(wc, dictionarySize++);
				// emit the dictionary index for w to output:
				compressed.add(dictionary.get(w));
				// remove w from the input:
				w = "" + c;
			}
		}
		// output the code for the last w:
		if (!w.isEmpty()) {
			compressed.add(dictionary.get(w));
		}
		return compressed;
	}

	public static String decompress(List<Short> compressed) {

		if (compressed.isEmpty()) {
			return "";
		}

		// rebuild the initial dictionary:
		Map<Short, String> dictionary = new HashMap<Short, String>();
		for (short i = 0; i < INITIAL_DICTIONARY_SIZE; i++) {
			dictionary.put(i, "" + (char) i);
		}

		// first character in the input:
		String w = "" + (char) (short) compressed.remove(0);
		String decompressed = w;
		String entry;
		short dictionarySize = INITIAL_DICTIONARY_SIZE;

		// read the rest of the input:
		for (short c : compressed) {
			if (dictionary.containsKey(c)) {
				// if c is in the dictionary, entry = dictionary entry for c:
				entry = dictionary.get(c);
			} else if (c == dictionarySize) {
				// c is the next code not yet in the dictionary:
				entry = w + w.charAt(0);
			} else {
				throw new IllegalArgumentException("bad compressed code: " + c);
			}
			// add w followed by the next character in the input to the
			// dictionary:
			dictionary.put(dictionarySize++, w + entry.charAt(0));
			// output entry:
			decompressed = decompressed + entry;
			// remove w from the input:
			w = entry;
		}
		return decompressed;
	}

	// return data compression ratio (the ratio between the uncompressed size
	// and compressed size):
	public static double compressionRatio(String uncompressed) {

		double compressionRatio;

		if (uncompressed.isEmpty()) {
			compressionRatio = 0;
		} else {
			// each char in the input String is 16 bits:
			int uncompressedSizeInBits = 16 * uncompressed.length();
			// each short in the output List<Short> is 16 bits:
			int compressedSizeInBits = 16 * compress(uncompressed).size();

			compressionRatio = (double) uncompressedSizeInBits / compressedSizeInBits;
		}
		return compressionRatio;
	}

	// return space savings (the reduction in size relative to the uncompressed
	// size, as a percentage):
	public static double spaceSavings(String uncompressed) {

		double spaceSavings;

		if (uncompressed.isEmpty()) {
			spaceSavings = 0;
		} else {
			// each char in the input String is 16 bits:
			int uncompressedSizeInBits = 16 * uncompressed.length();
			// each short in the output List<Short> is 16 bits:
			int compressedSizeInBits = 16 * compress(uncompressed).size();

			spaceSavings = (1 - (double) compressedSizeInBits / uncompressedSizeInBits) * 100;
		}
		return spaceSavings;
	}
}
