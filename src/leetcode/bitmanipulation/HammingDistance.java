package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/hamming-distance/
 */
public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x^y);
	}

}
