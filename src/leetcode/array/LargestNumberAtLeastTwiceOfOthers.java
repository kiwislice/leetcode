package leetcode.array;

/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class LargestNumberAtLeastTwiceOfOthers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int dominantIndex(int[] nums) {
		int max = nums[0];
		int maxIndex = 0;
		Integer sec = null;
		
		for(int i=1;i<nums.length;i++) {
			if( nums[i]>max ) {
				sec = max;
				max = nums[i];
				maxIndex = i;
			}
			else if( sec==null || nums[i]>sec ) {
				sec = nums[i];
			}
		}
		return (sec==null || max>=sec*2)?maxIndex:-1;
	}

}
