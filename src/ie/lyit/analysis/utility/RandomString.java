package ie.lyit.analysis.utility;

import java.util.Random;

/**
 * The Class RandomString.
 */
public class RandomString {

	/** The Constant symbols. */
	private static final char[] symbols = new char[36];

	static {
		for (int idx = 0; idx < 10; ++idx) {
			symbols[idx] = (char) ('0' + idx);
		}
		for (int idx = 10; idx < 36; ++idx) {
			symbols[idx] = (char) ('a' + idx - 10);
		}
	}

	/** The buf. */
	private static char[] buf;

	/** The Constant random. */
	private final static Random random = new Random();

	/**
	 * Given the length as a parameter, return a random string of that length.
	 * 
	 * @param length
	 *            the length
	 * @return the string
	 */
	public static String nextString(int length) {
		if (length < 1) {
			throw new IllegalArgumentException("length < 1: " + length);
		}
		buf = new char[length];
		for (int idx = 0; idx < buf.length; ++idx) {
			buf[idx] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}
}