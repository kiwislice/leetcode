package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 */
public class BinaryNumberWithAlternatingBits {

	public static void main(String[] args) {
		int n = 7;

		System.out.println(hasAlternatingBits(n));
	}

	public static boolean hasAlternatingBits(int n) {
		int xor = n^(n>>>1);
		return ((xor+1)&xor)==0;
	}

}
