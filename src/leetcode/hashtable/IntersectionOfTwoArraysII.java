package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> list = new ArrayList<>();
		int i1 = 0, i2 = 0;
		while( i1<nums1.length && i2<nums2.length ) {
			if( nums1[i1]==nums2[i2] ) {
				list.add(nums1[i1]);
				
				i1++;
				i2++;
			}
			else if( nums1[i1]<nums2[i2] ) {
				i1++;
			}
			else if( nums1[i1]>nums2[i2] ) {
				i2++;
			}
		}
		
		int[] rtn = new int[list.size()];
		for(int i=0;i<rtn.length;i++)
			rtn[i] = list.get(i);
		return rtn;
	}

}
