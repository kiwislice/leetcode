package leetcode.array;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class MaximumAverageSubarrayI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 16 ms
	public double findMaxAverage(int[] nums, int k) {
		int max = 0, add = 0;
		for(int i=0;i<k;i++) {
			add += nums[i];
		}
		max = add;
		
		for(int i=k;i<nums.length;i++) {
			add -= nums[i-k];
			add += nums[i];
			max = Math.max(max, add);
		}
		return max*1.0/k;
	}

	// 14 ms
	public double findMaxAverageByDouble(int[] nums, int k) {
		double max = 0, add = 0;
		for(int i=0;i<k;i++) {
			add += nums[i];
		}
		max = add;
		
		for(int i=k;i<nums.length;i++) {
			add -= nums[i-k];
			add += nums[i];
			max = Math.max(max, add);
		}
		return max/k;
	}

}
