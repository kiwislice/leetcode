package leetcode.array;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		// 6
		int[] ar = {-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(maxSubArray(ar));
	}

	// 10 ms
	public static int maxSubArray(int[] nums) {
		int add = nums[0];
        int total = nums[0];
        for(int i=1; i<nums.length; i++){
            add = Math.max(nums[i], nums[i] + add);
            total = Math.max(add, total);
        }
       
        return total;
	}

	// 166 ms
	public static int maxSubArrayByOn2(int[] nums) {
		int max = nums[0];
		for(int i=1;i<nums.length;i++) {
			max = Math.max(max, nums[i]);
			for(int j=0;j<i;j++) {
				nums[j] += nums[i];
				max = Math.max(max, nums[j]);
			}
		}
		return max;
	}

}
