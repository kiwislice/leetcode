package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1])
				return true;
		}
		return false;
	}

}
