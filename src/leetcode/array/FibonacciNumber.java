package leetcode.array;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

	public static void main(String[] args) {
		int N = 30;

		System.out.println(fib(N));
	}

	/** 2 ms, faster than 100.00% */
	public static int fib(int N) {
		if( N<=1 ) return N;
		
		int n1 = 0;
		int n2 = 1;
		for(int i=1;i<N;i++) {
			int next = n1 + n2;
			n1 = n2;
			n2 = next;
		}
		return n2;
	}

}
