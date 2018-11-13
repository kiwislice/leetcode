package leetcode.array;

import java.util.TreeSet;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		int[] ar = {1,2,2,5,3,5};

		System.out.println(thirdMax(ar));
	}

	// 4 ms
	public static int thirdMax(int[] nums) {
		Integer max = null, sec = null, thd = null;
		
		for(int i=0;i<nums.length;i++) {
			if( max==null || nums[i]>=max ) {
				if( max!=null && nums[i]==max )
					continue;
				thd = sec;
				sec = max;
				max = nums[i];
			}
			else if( sec==null || nums[i]>=sec ) {
				if( sec!=null && nums[i]==sec )
					continue;
				thd = sec;
				sec = nums[i];
			}
			else if( thd==null || nums[i]>thd ) {
				thd = nums[i];
			}
		}
		return thd==null?max:thd;
	}

	// 9 ms
	public static int thirdMaxByTreeSet(int[] nums) {
		if( nums.length==1 )
			return nums[0];
		
		TreeSet<Integer> ar = new TreeSet<>();
		ar.add(nums[0]);
		
		for(int i=1;i<nums.length;i++) {
			if( ar.contains(nums[i]) )
				continue;
			
			ar.add(nums[i]);
			if( ar.size()>3 )
				ar.pollFirst();
		}
		return ar.size()==3?ar.first():ar.last();
	}

}
