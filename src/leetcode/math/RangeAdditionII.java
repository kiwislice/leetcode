package leetcode.math;

/**
 * https://leetcode.com/problems/range-addition-ii/
 */
public class RangeAdditionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxCount(int m, int n, int[][] ops) {
		int minM = m;
		int minN = n;
		for(int[] op:ops) {
			if( op[0]>0 && op[1]>0 ) {
				minM = Math.min(minM, op[0]);
				minN = Math.min(minN, op[1]);
			}
		}
		return minM*minN;
	}

}
