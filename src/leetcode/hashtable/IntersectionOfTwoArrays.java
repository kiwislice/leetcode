package leetcode.hashtable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for(int i:nums1)
			set.add(i);
		
		List<Integer> rtn = new LinkedList<>();
		for(int i:nums2) {
			if( set.remove(i) )
				rtn.add(i);
		}
		
		int[] rtnar = new int[rtn.size()];
		for(int i=0;i<rtnar.length;i++)
			rtnar[i] = rtn.get(i);
		return rtnar;
	}

}
