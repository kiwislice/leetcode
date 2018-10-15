package leetcode.math;

/**
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(8));

	}

	public static int arrangeCoins(int n) {
		if( n<2 )
			return n;
		if( n<4 )
			return n-1;
		
		int min = 2;
		int max = 80000;
		
		while(max-min>1) {
			int k = (max+min)/2;
			long num = (1+k)*(long)k/2;
			if( num==n )
				return k;
			else if( num<n )
				min = k;
			else
				max = k;
		}
		return min;
	}

}
