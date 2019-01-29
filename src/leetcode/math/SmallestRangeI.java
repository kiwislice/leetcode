package leetcode.math;

/**
 * https://leetcode.com/problems/smallest-range-i/
 */
public class SmallestRangeI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** 5 ms, faster than 89.72% */
	public int smallestRangeI(int[] A, int K) {
		int max = A[0];
		int min = A[0];
		for(int i=1;i<A.length;i++) {
			max = Math.max(max, A[i]);
			min = Math.min(min, A[i]);
		}
		int d = (max-K)-(min+K);
		return d<0?0:d;
	}

}
