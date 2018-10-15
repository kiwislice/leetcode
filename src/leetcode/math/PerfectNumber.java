package leetcode.math;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-number/
 */
public class PerfectNumber {

	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(7));

	}

	public static boolean checkPerfectNumber(int num) {
		final int[] perfectNumbers = {6,28,496,8128,33550336};
		int index = Arrays.binarySearch(perfectNumbers, num);
		return index>=0;
	}

	/**
	 * Time Limit Exceeded
	 */
	public static boolean checkPerfectNumberByBruteForce(int num) {
		if( num<6 )
			return false;
		
		int max = num;
		int sum = 1;
		for(int i=2;i<max;i++) {
			if( num%i==0 ) {
				sum += i;
				sum += num/i;
				max = num/i;
			}
		}
		return sum == num;
	}

}
