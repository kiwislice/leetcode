package leetcode.array;

/**
 * https://leetcode.com/problems/find-pivot-index/
 */
public class FindPivotIndex {

	public static void main(String[] args) {
		// 3
//		int[] nums = {1,7,3,6,5,6};
		// 5
		int[] nums = {-1,-1,0,1,1,0};

		System.out.println(pivotIndex(nums));
	}

	// 20 ms
	public static int pivotIndex(int[] nums) {
		if( nums==null || nums.length==0 )
			return -1;
		
		int sumR = 0;
		for(int i=0;i<nums.length;i++) {
			sumR += nums[i];
		}
		
		int sumL = 0;
		for(int i=0;i<nums.length;i++) {
			sumR -= nums[i];
			if( sumL==sumR )
				return i;
			sumL += nums[i];
		}
		return -1;
	}

	// 21 ms
	public static int pivotIndexOld(int[] nums) {
		if( nums==null || nums.length==0 )
			return -1;
		if( nums.length<=1 )
			return 0;
		
		int sumR = 0;
		for(int i=1;i<nums.length;i++) {
			sumR += nums[i];
		}
		
		int sumL = 0;
		for(int i=0;i<nums.length;i++) {
			if( sumL==sumR )
				return i;
			if( i==nums.length-1 )
				break;
			sumR -= nums[i+1];
			sumL += nums[i];
		}
		return -1;
	}

}
