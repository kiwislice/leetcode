package leetcode.hashtable;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/distribute-candies/
 */
public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int distributeCandies(int[] candies) {
		Arrays.sort(candies);
		int kindCount = 1;
		int lastKind = candies[0];
		
		for(int kind:candies) {
			if( lastKind!=kind ) {
				kindCount++;
				lastKind = kind;
			}
		}
		return Math.min(kindCount, candies.length/2);
	}

}
