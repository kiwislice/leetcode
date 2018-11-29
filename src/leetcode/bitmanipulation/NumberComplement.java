package leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/number-complement/
 */
public class NumberComplement {

	public static void main(String[] args) {
		int n = 5;
		
		System.out.println(findComplement(n));
	}

	// 5 ms
	public static int findComplement(int num) {
		return ((Integer.highestOneBit(num)<<1)-1)^num;
	}
	
	// 7 ms
	public static int findComplementByOr(int num) {
		int f = num;
		for(int i=(num>>>1);i>0;i>>>=1)
			f |= i;
		return f^num;
	}

}
