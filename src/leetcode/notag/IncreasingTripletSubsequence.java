package leetcode.notag;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int[] nums = {2,5,3,4,5};

		System.out.println(increasingTriplet(nums));
	}

	/** 3 ms, faster than 88.97% */
	public static boolean increasingTriplet(int[] nums) {
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		
		for(int i:nums) {
			if( i<=a ) {
				a = i;
			}
			else if( i<=b ) {
				b = i;
			}
			else {
				return true;
			}
		}
		return false;
	}

	/** 3 ms, faster than 88.97% */
	public static boolean increasingTriplet_LIS(int[] nums) {
		int[] dp = new int[3];
		int len = 0;
		
		// 最長遞增子序列(非連續)的變形
		for(int i=0;i<nums.length;i++) {
			int index = len;
			for(int j=0;j<len;j++) {
				if( nums[i]<=dp[j] ) {
					index = j;
					break;
				}
			}
			
			dp[index] = nums[i];
			if( index==len ) {
				len++;
				if( len==3 )
					return true;
			}
		}
		return false;
	}

}
