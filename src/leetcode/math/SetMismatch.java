package leetcode.math;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {

	public static void main(String[] args) {
		int[] ar = {4,2,3,4};
//		int[] ar = {1,3,3};
		System.out.println(Arrays.toString(findErrorNums(ar)));

	}

	public static int[] findErrorNums(int[] nums) {
		boolean[] bs = new boolean[nums.length];
		int repeat = 0;
		for(int i=0;i<nums.length;i++) {
			if( bs[nums[i]-1] ) {
				repeat = nums[i];
			}
			bs[nums[i]-1] = true;
		}
		
		int notfound = 0;
		for(int i=0;i<nums.length;i++) {
			if( !bs[i] ) {
				notfound = i+1;
				break;
			}	
		}
		
		return new int[] {repeat, notfound};
	}
	
}
