package leetcode.math;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class XOfAKindInADeckOfCards {

	public static void main(String[] args) {
		int[] deck = {1,1,2,2,3,3};
		System.out.println(hasGroupsSizeX(deck));

	}

	public static boolean hasGroupsSizeX(int[] deck) {
		Arrays.sort(deck);
		int lastX = 0;
		int curX = 1;
		
		for(int i=1;i<deck.length;i++) {
			if( deck[i]==deck[i-1] ) {
				curX++;
			}
			else {
				if( curX<2 || gcd(curX, lastX)<2 )
					return false;
				lastX = gcd(lastX, curX);
				curX = 1;
			}
		}
		return !(curX<2 || gcd(curX, lastX)<2);
	}
	
	public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
	
}
