package leetcode.math;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class SumOfSquareNumbers {

	public static void main(String[] args) {
		System.out.println(judgeSquareSumBySqrt(2147482647));

	}

	public static boolean judgeSquareSumBySqrt(int c) {
		if( c<3 )
			return true;
		
		int sqrt = (int) Math.sqrt(c);
		for(int i=0;i<=sqrt;i++) {
			double d = Math.sqrt(c-i*i);
			if( d==(int)d )
				return true;
		}
		return false;
	}
	
	/**
	 * Time Limit Exceeded
	 */
	public static boolean judgeSquareSumByBruteForce(int c) {
		if( c<3 )
			return true;
		
		int sqrt = (int) Math.sqrt(c);
		for(int i=0;i<=sqrt;i++) {
			if( isPerfectSquareByFormula(c-i*i) )
				return true;
		}
		return false;
	}

	public static boolean isPerfectSquareByFormula(int num) {
		// A square number is 1+3+5+7+...
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}

}
