package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/power-of-four/
 */
public class PowerOfFour {

	public static void main(String[] args) {
		int n = 2147483647;

		System.out.println(Integer.toBinaryString(n));
		System.out.println(isPowerOfFour(n));
	}

	public static boolean isPowerOfFour(int num) {
		return num>0 && (num & 0b10101010_10101010_10101010_10101010)==0 && (num&(num-1))==0;
	}

}
