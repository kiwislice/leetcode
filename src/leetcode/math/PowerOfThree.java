package leetcode.math;

/**
 * https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfThree(int n) {
		if( n<1 )
			return false;
		
		while(n%3==0) {
			n /= 3;
		}
		return n==1;
	}

	public boolean isPowerOfThreeByMaxPower(int n) {
		// 1162261467 is 3^19,  3^20 is bigger than int  
	    return ( n>0 &&  1162261467%n==0);
	}

}
