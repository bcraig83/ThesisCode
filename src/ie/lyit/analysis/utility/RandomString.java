package ie.lyit.analysis.utility;

import java.util.Random;

public class RandomString {
	private static final char[] symbols = new char[36];

	static {
		for (int idx = 0; idx < 10; ++idx) {
			symbols[idx] = (char) ('0' + idx);
		}
		for (int idx = 10; idx < 36; ++idx) {
			symbols[idx] = (char) ('a' + idx - 10);
		}
	}

	public static void main(String[] args) {
		RandomString rs = new RandomString();
		System.out.println(rs.nextString(6));
	}

	private char[] buf;

	private final Random random = new Random();

	// TODO: may as well make this a static method?
	public String nextString(int length) {
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