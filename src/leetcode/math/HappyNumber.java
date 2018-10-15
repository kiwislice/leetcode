package leetcode.math;

/**
 * https://zh.wikipedia.org/wiki/%E5%BF%AB%E6%A8%82%E6%95%B8
 */
public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(1));
		// 68,13,28,23,		
	}

	static final int[] m = {0,1,4,9,16,25,36,49,64,81};
	
	public static boolean isHappy(int n) {
		int count = 20;
		while(n>0 && count-->0) {
			int sum = 0;
			while(n>0) {
				sum += m[n%10];
				n /= 10;
			}
			n = sum;
			if( n==1 )
				return true;
		}
		return false;
	}

}
