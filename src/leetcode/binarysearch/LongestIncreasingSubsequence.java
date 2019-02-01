package leetcode.binarysearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};

		System.out.println(lengthOfLIS(nums));
	}

	/** 
	 * 1 ms, faster than 94.23%
	 * By Solution Approach #4 Dynamic Programming
	 * 參考https://yanjia.me/zh/2018/11/05/70/
	 */
	public static int lengthOfLIS(int[] nums) {
		if( nums==null || nums.length==0 )
			return 0;
		
		int[] dp = new int[nums.length];
		int len = 0;
		
		for(int i=0;i<nums.length;i++) {
			int index = Arrays.binarySearch(dp, 0, len, nums[i]);
			if( index<0 )
				index = -(index+1);
			
			dp[index] = nums[i];
			if( index==len ) {
				len++;
			}
		}
		return len;
	}

	/** 
	 * 16 ms, faster than 39.25% 
	 * By Solution Approach #3 Dynamic Programming
	 */
	public static int lengthOfLIS_SolutionApproach3(int[] nums) {
		if( nums==null || nums.length==0 )
			return 0;
		
		int[] lis = new int[nums.length];
		int max = 1;
		
		for(int i=0;i<nums.length;i++) {
			int count = 1;
			for(int j=0;j<i;j++) {
				if( nums[i]>nums[j] ) {
					count = Math.max(count, 1+lis[j]);
				}
			}
			lis[i] = count;
			max = Math.max(max, count);
		}
		return max;
	}

}
