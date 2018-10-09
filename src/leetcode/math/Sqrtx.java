package leetcode.math;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrtx {

	public static void main(String[] args) {
		System.out.println(mySqrt(536848900));
	}

	public static int mySqrt(int x) {
		if( x==0 )
			return 0;
		if( x<4 )
			return 1;
		
		int MIN = 2;
		int MAX = x<536848900?23170:46341; //46341;
		
		while(MIN+1!=MAX) {
			int M = (MIN+MAX)/2;
			int square = M*M;
			if( square < x ) {
				MIN = M;
			}
			else if( square > x ) {
				MAX = M;
			}
			else if( square == x ) {
				return M;
			}	
		}
		return MIN;
	}

}
