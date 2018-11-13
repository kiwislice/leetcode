package leetcode.array;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		// 5
		int[] nums = {2, 6, 4, 8, 10, 9, 15};

		System.out.println(findUnsortedSubarray(nums));
	}

	public static int findUnsortedSubarray(int[] nums) {
		int firstUnsortedL = -1;
		for(int i=1;i<nums.length;i++) {
			if( nums[i-1]>nums[i] ) {
				firstUnsortedL = i-1;
				break;
			}
		}
		if( firstUnsortedL==-1 )
			return 0;
		
		int firstUnsortedR = -1;
		for(int i=nums.length-1;i>=0;i--) {
			if( nums[i-1]>nums[i] ) {
				firstUnsortedR = i;
				break;
			}
		}
		
		int unsortedMin = Integer.MAX_VALUE;
		int unsortedMax = Integer.MIN_VALUE;
		for(int i=firstUnsortedL;i<=firstUnsortedR;i++) {
			unsortedMin = Math.min(unsortedMin, nums[i]);
			unsortedMax = Math.max(unsortedMax, nums[i]);
		}
		
		for(int i=0;i<=firstUnsortedL;i++) {
			if( nums[i]>unsortedMin ) {
				firstUnsortedL = i;
				break;
			}
		}

		for(int i=nums.length-1;i>=0;i--) {
			if( nums[i]<unsortedMax ) {
				firstUnsortedR = i;
				break;
			}
		}
		
		return firstUnsortedR-firstUnsortedL+1;
	}

}
