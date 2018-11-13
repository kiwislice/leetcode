package leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 */
public class DegreeOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 27 ms
	public int findShortestSubArray(int[] nums) {
		if( nums==null || nums.length==0 )
			return 0;
		
		Map<Integer, int[]> m = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int[] ar = m.getOrDefault(nums[i], new int[] {0, i, i});
			if( ar[0]==0 )
				m.put(nums[i], ar);
			ar[0]++;
			ar[2] = i;
		}
		
		int maxCount = 0;
		for(int[] ar:m.values()) {
			maxCount = Math.max(maxCount, ar[0]);
		}
		
		int min = Integer.MAX_VALUE;
		for(int[] ar:m.values()) {
			if( ar[0]==maxCount ) {
				min = Math.min(min, ar[2]-ar[1]+1);
			}
		}
		return min;
	}

	// 79 ms
	public int findShortestSubArrayOld(int[] nums) {
		if( nums==null || nums.length==0 )
			return 0;
		
		Map<Integer, Integer> m = new HashMap<>();
		for(int n:nums) {
			m.put(n, m.getOrDefault(n, 0)+1);
		}
		
		int max = 0;
		Set<Integer> list = new HashSet<>();
		for(Map.Entry<Integer, Integer> ent:m.entrySet()) {
			if( max<ent.getValue() ) {
				list.clear();
				list.add(ent.getKey());
				max = ent.getValue();
			}
			else if( max==ent.getValue() ) {
				list.add(ent.getKey());
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int k:list) {
			min = Math.min(min, shortestLen(nums, k));
		}
		return min;
	}

	public static int shortestLen(int[] nums, int k) {
		int L = 0;
		int R = nums.length-1;
		while(nums[L]!=k) {
			L++;
		}
		while(nums[R]!=k) {
			R--;
		}
		return R-L+1;
	}
	
}
