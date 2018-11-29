package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class ConvertANumberToHexadecimal {

	public static void main(String[] args) {
		// "1a"
		int n = 26;
		
		System.out.println(toHex(n));
	}

	public static String toHex(int num) {
		final char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		StringBuilder sb = new StringBuilder(8);
		do {
			int b = num & 0b1111;
			num >>>= 4;
			sb.insert(0, hex[b]);
		} while(num!=0);
		return sb.toString();
	}

}
