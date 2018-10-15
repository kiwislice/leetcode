package leetcode.math;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(32));

	}

	public static boolean isPowerOfTwo(int n) {
		if(n<1)
			return false;
		
		while((n&1)==0) {
			n >>= 1;
		}
		return n==1;
	}

}
