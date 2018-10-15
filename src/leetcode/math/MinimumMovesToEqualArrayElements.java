package leetcode.math;

public class MinimumMovesToEqualArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
	 */
	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
//		sum - minNum * n = m
		
		for(int i:nums) {
			min = i<min?i:min;
			sum += i;
		}
		return sum - min*nums.length;
	}

}
