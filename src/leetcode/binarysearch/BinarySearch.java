package leetcode.binarysearch;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

	public static void main(String[] args) {
//		int[] nums = {-1,0,3,5,9,12};
//		int target = 9;
		int[] nums = {8};
		int target = 2;
		
		System.out.println(search(nums, target));
	}

	/** 2 ms, faster than 100.00% */
	public static int search(int[] nums, int target) {
		int L = 0, R = nums.length;
		
		while( L<R ) {
			int mid = (L+R)/2;
			
			if( nums[mid]==target ) {
				return mid;
			}
			if( nums[mid]<target ) {
				L = mid + 1;
			}
			else {
				R = mid;
			}
		}
		return -1;
	}

}
