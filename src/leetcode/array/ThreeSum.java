package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};

		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rtn = new LinkedList<>();
		// 先排序
		Arrays.sort(nums);
		// for第1個數
		final int lastIndex = nums.length-2;
		for(int i=0;i<lastIndex;i++) {
			// 避免重複數字
			if( i>0 && nums[i]==nums[i-1] ) 
				continue;
			
			// 第2,3個數從頭尾包夾
			int j = i+1, k = lastIndex+1;
			while( j<k ) {
				// 避免重複數字
				if( j>i+1 && nums[j]==nums[j-1] ) {
					j++;
					continue;
				}
				if( k<=lastIndex && nums[k]==nums[k+1] ) {
					k--;
					continue;
				}
				
				int sum = nums[j]+nums[k];
				if( sum==-nums[i] ) {
					rtn.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
					continue;
				}
				if( sum>-nums[i] ) {
					k--;
					continue;
				}
				if( sum<-nums[i] ) {
					j++;
					continue;
				}
			}
		}
		return rtn;
	}

}
