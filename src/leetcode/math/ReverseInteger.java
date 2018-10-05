package leetcode.math;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
	
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
	
	public static int reverse(int x) {
		long rtn = 0;
		
		while( x!=0 ) {
			int d = x%10;
			rtn = rtn*10+d;
			
			if( rtn>Integer.MAX_VALUE || rtn<Integer.MIN_VALUE )
				return 0;
			
			x /= 10;
		}
		
		return (int) rtn;
	}
	
}
