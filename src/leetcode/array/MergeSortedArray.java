package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {4,5,0,0,0,0,0,0,0};
		int m = 2;
		int[] nums2 = {2,2,8};
		int n = 3;
		
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int index1 = m-1;
		int index2 = n-1;
		
		for(int i=m+n-1;i>=0;i--) {
			if( index2<0 )
				break;
			if( index1<0 ) {
				for(int j=index2;j>=0;j--) {
					nums1[j] = nums2[j];
				}
				break;
			}
			
			if( nums1[index1] <= nums2[index2] ) {
				nums1[i] = nums2[index2--];
			}
			else {
				nums1[i] = nums1[index1--];
			}
		}
	}

	public static void mergeByFromStart(int[] nums1, int m, int[] nums2, int n) {
		
		Queue<Integer> queue = new LinkedList<>();
		int index2 = 0;
		int min = Math.min(m, n);
		
		for(int i=0;i<min;i++) {
			if( queue.isEmpty() ) {
				if( nums1[i] <= nums2[index2] ) {
					continue;
				}
				else {
					queue.add(nums1[i]);
					nums1[i] = nums2[index2++];
				}
			}
			else {
				queue.add(nums1[i]);
				int n1 = queue.peek();
				if( n1 <= nums2[index2] ) {
					nums1[i] = n1;
					queue.remove();
					continue;
				}
				else {
					nums1[i] = nums2[index2++];
				}
			}
		}
		
		int i = min;
		while( i<m+n ) {
			if( i<m )
				queue.add(nums1[i]);
			Integer n1 = queue.isEmpty()?null:queue.peek();
			if( n1!=null && (index2==n || n1 <= nums2[index2]) ) {
				nums1[i++] = n1;
				queue.remove();
				continue;
			}
			else {
				nums1[i++] = nums2[index2++];
			}
		}
		
	}

}
