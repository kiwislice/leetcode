package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[] nums, int k) {
		k = k%nums.length;
		if( k==0 ) return ;
		
		int[] temp = Arrays.copyOfRange(nums, nums.length-k, nums.length);
		for(int i=nums.length-1;i>=k;i--) {
			nums[i] = nums[i-k];
		}
		for(int i=0;i<k;i++) {
			nums[i] = temp[i];
		}
	}

}
