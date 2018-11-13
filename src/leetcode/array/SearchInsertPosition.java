package leetcode.array;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int searchInsert(int[] nums, int target) {
		if( nums==null || nums.length==0 || target<=nums[0] )
			return 0;
		if( nums[nums.length-1]==target )
			return nums.length-1;
		if( nums[nums.length-1]<target )
			return nums.length;
		
		int indexL = 0;
		int indexR = nums.length-1;
		
		while(indexR-indexL>1) {
			int mid = (indexL+indexR)/2;
			if( nums[mid]==target ) {
				return mid;
			}
			if( nums[mid]<target ) {
				indexL = mid;
			}
			else if( target<nums[mid] ) {
				indexR = mid;
			}
		}
		return indexR;
	}

}
