package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 */
public class SumOfTwoIntegers {

	public static void main(String[] args) {
		System.out.println(getSum(30,-5));

	}

	public static int getSum(int a, int b) {
		int and = a & b;
		while(and!=0) {
			a = a ^ b;
			b = and<<1;
			and = a & b;
		}
		return a | b;
	}

}
