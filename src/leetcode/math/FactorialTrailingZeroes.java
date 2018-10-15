package leetcode.math;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		System.out.println(trailingZeroes(1808548329));
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}

	public static int trailingZeroes(int n) {
		return n<5?0:n/5+trailingZeroes(n/5);
	}

	public static int trailingZeroesByCount5(int n) {
		int count5 = 0;
		while( n>0 ) {
			n /= 5;
			count5 += n;
		}
		return count5;
	}

}
