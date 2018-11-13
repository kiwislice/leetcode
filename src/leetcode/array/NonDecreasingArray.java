package leetcode.array;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {

	public static void main(String[] args) {
		int[] nums = {3,4,2,3};
//		int[] nums = {4,2,3};
//		int[] nums = {2,3,3,2,4};
//		int[] nums = {1,2,3,5,4};
//		int[] nums = {-1,4,2,3};
//		int[] nums = {3,2,3,2,4};
		
		System.out.println(checkPossibility(nums));
	}

	public static boolean checkPossibility(int[] nums) {
		if( nums==null || nums.length<=2 )
			return true;
		
		int countL = 0;
		int maxL = nums[0];
		int countR = 0;
		int minR = nums[nums.length-1];
		for(int i=1;i<nums.length;i++) {
			if( nums[i-1]>nums[i] ) {
				countL++;
				if( i<nums.length-1 && nums[i+1]<maxL )
					countL++;
			}
			else {
				maxL = nums[i];
			}
			if( nums[nums.length-i-1]>nums[nums.length-i] ) {
				countR++;
				if( i<nums.length-1 && nums[nums.length-i-2]>minR )
					countR++;
			}
			else {
				minR = nums[nums.length-i-1];
			}
		}
		return countR<2 || countL<2;
	}

}
