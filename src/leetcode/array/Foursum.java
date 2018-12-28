package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/4sum/
 */
public class Foursum {

	public static void main(String[] args) {
//		int[] nums = {1, 0, -1, 0, -2, 2};
		// input 4 ans [[-5,0,4,5],[-3,-2,4,5]]
//		int[] nums = {-5,5,4,-3,0,0,4,-2};
		// input -4437 ans 
		int[] nums = {-493,-487,-480,-464,-456,-449,-445,-439,-437,-427,-415,-403,-400,-398,-372,-349,-347,-332,-330,-324,-287,-282,-273,-254,-249,-243,-220,-219,-217,-217,-214,-199,-198,-170,-153,-150,-143,-136,-113,-93,-91,-88,-87,-78,-58,-58,-55,-51,-49,-42,-38,-36,-26,0,13,28,54,61,85,90,90,111,118,136,138,167,170,172,195,198,205,209,241,263,290,302,324,328,347,359,373,390,406,417,435,439,443,446,464,465,468,484,486,492,493};


		System.out.println(fourSum(nums, -4437));
	}

	// 47 ms, faster than 55.93%
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> rtn = new LinkedList<>();
		// 排序
		Arrays.sort(nums);
		
		// for第1個數
		for(int h=0;h<nums.length-3;h++) {
			// 避免重複數字
			if( h>0 && nums[h]==nums[h-1] ) continue;
			
			// for第2個數
			for(int i=h+1;i<nums.length-2;i++) {
				// 避免重複數字
				if( i>h+1 && nums[i]==nums[i-1] ) continue;
				
				int hi = nums[h]+nums[i];
				// 第3,4個數從頭尾包夾
				int j = i+1, k = nums.length-1;
				while( j<k ) {
					// 避免重複數字
					if( j>i+1 && nums[j]==nums[j-1] ) {
						j++;
						continue;
					}
					if( k<nums.length-1 && nums[k]==nums[k+1] ) {
						k--;
						continue;
					}
					
					int sum = hi+nums[j]+nums[k];
					if( sum==target ) {
						rtn.add(Arrays.asList(nums[h], nums[i], nums[j++], nums[k--]));
						continue;
					}
					if( sum>target ) {
						k--;
						continue;
					}
					if( sum<target ) {
						j++;
						continue;
					}
				}
			}
		}
		return rtn;
	}

	// 410 ms, faster than 3.27%
	public static List<List<Integer>> fourSumBySortRecursive(int[] nums, int target) {
		Set<Ar> set = new HashSet<>();
		// 排序
		Arrays.sort(nums);
		// 遞迴跑完所有可能
		recu(nums, target, 0, 4, new int[4], set);
		
		List<List<Integer>> rtn = new ArrayList<>(set.size());
		for(Ar ar:set)
			rtn.add(ar.asList());
		return rtn;
	}

	public static void recu(int[] nums, int target, int startIndex, int count, int[] ns, Set<Ar> set) {
		for(int i=startIndex;i<nums.length-count+1;i++) {
			if( count==1 ) {
				if( target==nums[i] ) {
					int[] nns = Arrays.copyOf(ns, 4);
					nns[4-count] = nums[i];
					set.add(new Ar(nns));
				}	
				continue ;
			}
			
			int[] nns = Arrays.copyOf(ns, 4);
			nns[4-count] = nums[i];
			recu(nums, target-nums[i], i+1, count-1, nns, set);
		}
	}
	
	public static class Ar {

		int[] ns;

		public Ar(int[] ns) {
			this.ns = ns;
		}
		
		public List<Integer> asList() {
			return Arrays.asList(ns[0], ns[1], ns[2], ns[3]);
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(ns);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Ar other = (Ar) obj;
			return Arrays.equals(ns, other.ns);
		}
		
	}
	
}
