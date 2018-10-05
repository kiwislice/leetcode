package leetcode.array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		if( nums==null || nums.length==0 )
			return 0;
		
		int lastN = nums[0];
		int count = 1;
		for(int i=1;i<nums.length;i++) {
			if( lastN!=nums[i] ) {
				count++;
				lastN = nums[i];
				
				nums[count-1] = nums[i];
			}
		}
		return count;
	}

}
