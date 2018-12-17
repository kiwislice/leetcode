package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {
//		int[] nums = {1,3,2,2,5,2,3,7};
		// 2
//		int[] nums = {1,2,3,4};
		// 0
		int[] nums = {1,3,5,7,9,11,13,15,17};

		System.out.println(findLHS(nums));
	}

	public static int findLHS(int[] nums) {
		if( nums==null || nums.length==0 )
			return 0;
		
		Arrays.sort(nums);
		int max = 0;
		int lastCount = 0;
		int curCount = 1;
		int curN = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			if( nums[i]==curN ) {
				curCount++;
			}
			else {
				lastCount = curN+1==nums[i]?curCount:0;
				curCount = 1;
				curN = nums[i];
			}
			if( lastCount>0 && curCount>0 )
				max = Math.max(max, lastCount+curCount);
		}
		return max;
	}

	public static int findLHSOld(int[] nums) {
		int[] m = new int[nums.length];
		Set<Integer> set = new HashSet<>();
		int max = 0;
		
		for(int i=0;i<nums.length;i++) {
			set.iterator();
			for(int j:set) {
				int diff = nums[i]-nums[j];
				if( m[j]==0 ) {
					m[j] = diff;
				}
				else if( m[j]==1 && diff!=0 && diff!=1 ) {
					m[j]++;
				}
				else if( m[j]==-1 && diff!=0 && diff!=-1 ) {
					m[j]--;
				}
				
				if( m[j]>1 || m[j]<-1 ) {
					max = Math.max(max, i-j);
					set.remove(j);
				}
			}
			set.add(i);
		}
		return max;
	}

}
