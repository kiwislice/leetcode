package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
public class MaximumLengthOfPairChain {

	public static void main(String[] args) {
		// 3
		int[][] pairs = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};

		System.out.println(findLongestChain(pairs));
	}

	/** 19 ms, faster than 97.06% */
	public static int findLongestChain(int[][] pairs) {
		if( pairs==null || pairs.length==0 )
			return 0;
		
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		int count = 1;
		int lastB = pairs[0][1];
		for(int i=1;i<pairs.length;i++) {
			if( pairs[i][0]>lastB ) {
				count++;
				lastB = pairs[i][1];
			}
		}
		return count;
	}

}
