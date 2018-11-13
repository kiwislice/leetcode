package leetcode.array;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLengthOfLCIS(int[] nums) {
		if( nums==null || nums.length==0 )
			return 0;
		
		int max = 1;
		int len = 1;
		for(int i=0;i<nums.length-1;i++) {
			if( nums[i]<nums[i+1] ) {
				len++;
				max = Math.max(max, len);
			}
			else {
				len = 1;
			}
		}
		return max;
	}

}
