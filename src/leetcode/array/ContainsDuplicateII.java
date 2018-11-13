package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {
		// input 3 ans true
		int[] ar = {1,2,3,4,5,6,7,8,9,9};
		
		System.out.println(containsNearbyDuplicate(ar, 3));
	}

	// 20 ms
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if( k<1 || nums==null || nums.length==0 )
			return false;
		
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			if( i>k )
				set.remove(nums[i-k-1]);
			if(!set.add(nums[i]))
				return true;
		}
		return false;
	}

	// 1000 ms
	public static boolean containsNearbyDuplicateByFor(int[] nums, int k) {
		if( k<1 )
			return false;
		if( k>=nums.length )
			return containsDuplicate(nums);
		
		for(int i=0;i<nums.length;i++) {
			int jmax = Math.min(i+k, nums.length-1);
			for(int j=i+1;j<=jmax;j++) {
				if( nums[i]==nums[j] )
					return true;
			}
		}
		return false;
	}

	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1])
				return true;
		}
		return false;
	}

}
