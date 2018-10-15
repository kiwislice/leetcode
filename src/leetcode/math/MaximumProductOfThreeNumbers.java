package leetcode.math;

import java.util.Collections;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 */
public class MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[] {0,0,0}));
		System.out.println(maximumProduct(new int[] {-1,-2,-3}));
		System.out.println(maximumProduct(new int[] {1,2,3}));
	}


	public static int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		
		for(int n:nums) {
			if( n>max1 ) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			}
			else if( n>max2 ) {
				max3 = max2;
				max2 = n;
			}
			else if( n>max3 ) {
				max3 = n;
			}
			if( n<min1 ) {
				min2 = min1;
				min1 = n;
			}
			else if( n<min2 ) {
				min2 = n;
			}
		}
		
		int max = max1*max2*max3;
		max = Math.max(max, min1*min2*max1);
		return max;
	}
	
	public static int maximumProductByApi(int[] nums) {
		LinkedList<Integer> maxPositive = new LinkedList<>();
		LinkedList<Integer> minNegative = new LinkedList<>();
		
		LinkedList<Integer> cur;
		for(int n:nums) {
			cur = n>=0?maxPositive:minNegative;
			cur.add(n);
			if( cur.size()>3 ) {
				Collections.sort(cur);
				if( n>=0 )
					cur.pollFirst();
				else
					cur.pollLast();
			}
		}
		
		maxPositive.addAll(minNegative);
		Integer[] ar = maxPositive.toArray(new Integer[] {});
		int max = ar[0]*ar[1]*ar[2];
		for(int i=0;i<ar.length-2;i++) {
			for(int j=i+1;j<ar.length-1;j++) {
				for(int k=j+1;k<ar.length;k++) {
					max = Math.max(max, ar[i]*ar[j]*ar[k]);
				}
			}
		}
		return max;
	}

}
